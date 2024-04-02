package authen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import javax.ejb.Stateless;

@Stateless
public class UserService {
	
	public User getUser(String username) {
		User user = new User();
		user.setUsername(username);
		user.setPassword("gpcoder");
		if ("admin".equals(username)) {
			user.setRoles(Arrays.asList(Role.ROLE_ADMIN));
		} else if ("customer".equals(username)) {
			user.setRoles(Arrays.asList(Role.ROLE_CUSTOMER));
		} else if ("gpcoder".equals(username)) {
			user.setRoles(Arrays.asList(Role.ROLE_ADMIN, Role.ROLE_CUSTOMER));
		} else {
			user.setRoles(new ArrayList<>());
		}
		user.setSid(UUID.randomUUID().toString());
		return user;
	}
}
