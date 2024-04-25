package authen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;

@Stateless
public class UserService {

	public User getUser(String username) {
		User user = new User();
		user.setUsername(username);
		user.setPassword("12345678");
		if ("admin@gmail.com".equals(username)) {
			user.setRoles(Arrays.asList(Role.ROLE_ADMIN));
		} else if ("customer@gmail.com".equals(username)) {
			user.setRoles(Arrays.asList(Role.ROLE_CUSTOMER));
		} else if ("thanhnx@gmail.com".equals(username)) {
			user.setRoles(Arrays.asList(Role.ROLE_ADMIN, Role.ROLE_CUSTOMER));
		} else {
			user.setRoles(new ArrayList<>());
		}
		user.setSid(UUID.randomUUID().toString());
		return user;
	}

	public List<User> getLstUser() {
		List<User> rst = new ArrayList<User>();
		rst.add(new User("", "admin@gmail.com", "12345678", Arrays.asList(Role.ROLE_ADMIN)));
		rst.add(new User("", "customer@gmail.com", "12345678", Arrays.asList(Role.ROLE_CUSTOMER)));
		rst.add(new User("", "thanhnx@gmail.com", "12345678", Arrays.asList(Role.ROLE_ADMIN, Role.ROLE_CUSTOMER)));
		return rst;
	}
}
