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

	@Column(name = "SID")
	public String employeeID;

	@Column(name = "CHANGE_TIME")
	public Date changeTime;

	
	public RefreshToken toDomain() {
		return new RefreshToken(pk.tokenId, employeeID, changeTime);
	}
	
	public static ERefreshToken toEntity(RefreshToken token) {
		return new ERefreshToken(new ERefreshTokenPK(token.getTokenId()), token.getSid(), token.getChangeDate());
	}
}
