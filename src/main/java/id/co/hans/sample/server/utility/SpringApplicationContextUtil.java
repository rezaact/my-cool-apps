package id.co.iconpln.ap2t.fungsi4.server.utility;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationContextUtil implements ApplicationContextAware{

	private static ApplicationContext CONTEXT; 
	
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		CONTEXT = arg0;
	}
	
	public static Object getBean(String beanName) {  
		CONTEXT = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
        return (CONTEXT != null) ? CONTEXT.getBean(beanName) : null;     
   } 

}
