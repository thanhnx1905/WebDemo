package authen.session;

import javax.servlet.http.HttpSession;

import authen.session.asynctask.SessionHelper;

public class SessionLoginInfo {

	public static UserSessionInfo context() {
		HttpSession session = SessionHelper.getSession();
		if (session != null) {
			return (UserSessionInfo) session.getAttribute("user");
		} else {
			return null; // Xử lý trường hợp phiên không khả dụng
		}
	}

}
