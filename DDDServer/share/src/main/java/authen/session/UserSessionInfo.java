package authen.session;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserSessionInfo {

	private String sid;
	
	private String username;
}
