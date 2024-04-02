package service.authen;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserForLogin {
	private String username;
	private String password;
	private String tokenId;
}
