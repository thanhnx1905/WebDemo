package refreshtoken;

import java.util.Optional;

public interface RefreshTokenRepository {

	public Optional<RefreshToken> findByKey(String tokenId);

	public void updateTokenExp(RefreshToken token);

	public void removeByKey(String tokenId);
	
	public void insertTokenExp(RefreshToken token);

}
