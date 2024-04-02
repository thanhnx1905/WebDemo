package dom.refreshtoken;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import service.authen.JwTokenHelper;

@AllArgsConstructor
@Getter
public class RefreshToken {

	@Setter
	private String tokenId;
	
	private String sid;

	private Date changeDate;
	
	public boolean validRenewSession(Date dateExp) {
		Date now = new Date();
		return !now.after(dateExp) && (now.getTime() - changeDate.getTime()) >= TimeUnit.MINUTES
				.toMillis(JwTokenHelper.EXPIRATION_LIMIT_IN_MINUTES);

	}
	
	public RefreshToken reNew(String tokenId, Date dateExp) {
		return new RefreshToken(tokenId, this.sid, dateExp);
	}
}
