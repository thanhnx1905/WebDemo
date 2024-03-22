package service.authen.session.asynctask;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

public class SessionHelper {

	private static final ConcurrentHashMap<Long, HttpSession> sessionMap = new ConcurrentHashMap<>();

	public static void setSession(Long sessionId, HttpSession session) {
		sessionMap.put(sessionId, session);
	}

	public static HttpSession getSession() {
		return sessionMap.get(Thread.currentThread().getId());
	}

	public static HttpSession removeSession(Long sessionId) {
		return sessionMap.remove(sessionId);
	}
}
