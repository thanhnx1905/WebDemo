package infra.entity.refreshtoken;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import dom.refreshtoken.RefreshToken;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "REFRESH_TOKEN")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ERefreshToken implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	public ERefreshTokenPK pk;

	@Column(name = "TOKEN_ID")
	private String tokenId;


	@Column(name = "EXP")
	private Date dateExp;

	
	public RefreshToken toDomain() {
		return new RefreshToken(pk.employeeID, tokenId, dateExp);
	}
	
	public static ERefreshToken toEntity(RefreshToken token) {
		return new ERefreshToken(new ERefreshTokenPK(token.getSid()), token.getTokenId(), token.getDateExp());
	}
}
