package pvasilev.cit.oossp.library.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextBridgeImpl 
	implements SpringContextBridge, ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Autowired
	private LibraryServiceImp service;
	
	@SuppressWarnings("static-access")
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) 
			throws BeansException {
		this.applicationContext = applicationContext;		
	}
	public static SpringContextBridge services() {
		return applicationContext.getBean(SpringContextBridge.class);
	}
	
	@Override
	public LibraryService getService() {
		return service;
	}
}
