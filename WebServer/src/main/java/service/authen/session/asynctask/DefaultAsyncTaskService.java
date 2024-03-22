package service.authen.session.asynctask;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.ApplicationScoped;
import javax.servlet.http.HttpSession;

@ApplicationScoped
public class DefaultAsyncTaskService implements AsyncTaskService {

	@Resource
	private ManagedExecutorService executorService;

	@Override
	public void execute(Runnable task) {
		HttpSession session = SessionHelper.getSession();
		executorService.execute(() ->{
			Long tId = Thread.currentThread().getId();
			SessionHelper.setSession(tId, session);
			task.run();
			SessionHelper.removeSession(tId);
		});
	}

}
