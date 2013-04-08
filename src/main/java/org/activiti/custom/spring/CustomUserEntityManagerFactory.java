package org.activiti.custom.spring;

import org.activiti.custom.security.UserDao;
import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.UserEntityManager;
/**
 * Factory is used for defining for activiti that {@link CustomUserEntityManager} should be used instead of {@link UserEntityManager}.
 * This class is used from <code>./src/main/resources/META-INF/spring/custom-activiti-beans.xml</code>
 * 
 * @author mondhs
 *
 */
public class CustomUserEntityManagerFactory implements SessionFactory {

	private UserDao userDao;
	
	@Override
	public Class<?> getSessionType() {
		 return UserEntityManager.class;
	}

	@Override
	public Session openSession() {
		CustomUserEntityManager aUserEntityManager = new CustomUserEntityManager();
		aUserEntityManager.setUserDao(userDao);
		return (Session) aUserEntityManager;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
