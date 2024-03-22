package service.authen;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

public class BasicSecurityConext implements SecurityContext {

	private User user;

	private boolean secure;

	public BasicSecurityConext(User user, boolean secure) {
		this.user = user;
		this.secure = secure;
	}

	@Override
	public Principal getUserPrincipal() {
		return () -> user.getUsername();
	}

	@Override
	public boolean isUserInRole(String role) {
		return user.getRoles().contains(role);
	}

	@Override
	public boolean isSecure() {
		return secure;
	}

	@Override
	public String getAuthenticationScheme() {
		return SecurityContext.BASIC_AUTH;
	}

}
