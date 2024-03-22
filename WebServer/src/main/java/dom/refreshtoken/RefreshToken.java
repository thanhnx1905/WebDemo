package dom.refreshtoken;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class RefreshToken {

	private String sid;

	@Setter
	private String tokenId;

	private Date dateExp;
}
