package service.authen;

import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import service.authen.test.TokenForAuthRefresh;

public class JwTokenHelper {

	// The privateKey is only valid for the given minutes
	private static final long EXPIRATION_LIMIT_IN_MINUTES = 30;
	
	// The privateKey (refresh token) is only valid for the given minutes
	private static final long EXPIRATION_REF_LIMIT_IN_MINUTES = 10080;//one week

	// The JWT signature algorithm we will be using to sign the token
	private static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;

	// Keys used with HS256 MUST have a size >= 256 bits
	private static final String SECRET_KEY = "thanhnx-code-demo-token-base-authentication-with-jwt-example";

	private static final String ISSUER = "thanhnx";

	public static TokenForAuthRefresh createJWT(User user) {
		return new TokenForAuthRefresh(createJWT(user, false), createJWT(user, true));
	}

	public static TokenForAuthRefresh createJWT(User user, Date dateExp) {
		return new TokenForAuthRefresh(createJWT(user, false), createJWT(user, true, Optional.of(dateExp)));
	}
	
	private static String createJWT(User user, boolean isRefreshToken) {
		return createJWT(user, isRefreshToken, Optional.empty());
	}
	
	private static String createJWT(User user, boolean isRefreshToken, Optional<Date> dateExp) {
		long currentTimeInMillis = System.currentTimeMillis();
		Date now = new Date(currentTimeInMillis);

		// The privateKey is only valid for the next EXPIRATION_LIMIT_IN_MINUTES
		long expirationTimeInMilliSeconds = TimeUnit.MINUTES
				.toMillis(isRefreshToken ? EXPIRATION_REF_LIMIT_IN_MINUTES : EXPIRATION_LIMIT_IN_MINUTES);
		Date expirationDate = dateExp.isPresent() ? dateExp.get() : new Date(currentTimeInMillis + expirationTimeInMilliSeconds);

		// Will sign our JWT with our ApiKey secret
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, SIGNATURE_ALGORITHM.getJcaName());
		
		// Sets the JWT Claims sub (subject) value
        Claims claims = Jwts.claims().setSubject(user.getSid());
        claims.put("name", user.getUsername());
        claims.put("roles", user.getRoles());
		
        // Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder() // Configured and then used to create JWT compact serialized strings
                .setClaims(claims).setId(UUID.randomUUID().toString()) // Sets the JWT Claims jti (JWT ID) value
                .setIssuedAt(now) // Sets the JWT Claims iat (issued at) value
                .setIssuer(ISSUER) // Sets the JWT Claims iss (issuer) value
                .setExpiration(expirationDate) // Sets the JWT Claims exp (expiration) value
                .signWith(signingKey, SIGNATURE_ALGORITHM);
 
        // Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();

	}
	
	 /**
     * Get User from the given token
     */
    @SuppressWarnings("unchecked")
	public static User getUserFromToken(String token) {
        final Claims claims = decodeJWT(token);
        User user = new User();
        user.setUsername((String) claims.get("name"));
        user.setRoles((List<String>) claims.get("roles"));
        user.setSid(claims.getSubject());
        return user;
    }
    
    /**
     * Check if the token was issued by the server and if it's not expired
     */
    public static Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
 
    public static boolean needToRefresh(String token, String tokenRefresh) {
    	Date dateExp = getExpirationDateFromToken(token);
    	Date dateExpFinished = getExpirationDateFromToken(tokenRefresh);
    	return !dateExp.after(dateExpFinished);
    }
    
    public static Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }
 
    private static <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = decodeJWT(token);
        return claimsResolver.apply(claims);
    }
 
    private static Claims decodeJWT(String jwt) {
        // This line will throw an exception if it is not a signed JWS (as expected)
        return Jwts.parser() // Configured and then used to parse JWT strings
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY)) // Sets the signing key used to verify
                                                                                // any discovered JWS digital signature
                .parseClaimsJws(jwt) // Parses the specified compact serialized JWS string based
                .getBody();
    }
}
