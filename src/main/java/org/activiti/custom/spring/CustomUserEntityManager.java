package org.activiti.custom.spring;

import org.activiti.custom.engine.identity.CustomUserQuery;
import org.activiti.custom.security.UserDao;
import org.activiti.custom.security.domain.UserProfile;
import org.activiti.engine.identity.User;
import org.activiti.engine.identity.UserQuery;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.activiti.engine.impl.persistence.entity.UserEntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Custom adapter of {@link UserEntityManager}. It takes user information from {@link UserDao}.
 * This instance is created by {@link CustomUserEntityManagerFactory}.
 * 
 * @author mondhs
 *
 */
public class CustomUserEntityManager extends UserEntityManager {
	public static Logger LOG = LoggerFactory
			.getLogger(CustomUserEntityManager.class);

	private UserDao userDao;

	public CustomUserEntityManager() {
		super();
		LOG.error("Init");
	}

	@Override
	public UserEntity findUserById(String userId) {
		// return super.findUserById(userId);
		UserProfile aUser = userDao.findUserByLoginName(userId);
		UserEntity userEntity = new UserEntity(aUser.getLoginName());
		userEntity.setEmail(aUser.getEmailAddress());
		userEntity.setFirstName(aUser.getFirstName());
		userEntity.setLastName(aUser.getLastName());
		return userEntity;
	}
	@Override
	public UserQuery createNewUserQuery() {
		CustomUserQuery aUserQuery = new CustomUserQuery();
		aUserQuery.setUserDao(userDao);
		return aUserQuery;
	}
	
	@Override
	public Boolean checkPassword(String userId, String password) {
		return Boolean.TRUE;
	}

	@Override
	public void insertUser(User user) {
		throw new IllegalArgumentException("Not impl");
	}

	@Override
	public void deleteUser(String userId) {
		throw new IllegalArgumentException("Not impl");
	}

	@Override
	public void flush() {
		super.flush();
		LOG.error("flush");
	}

	@Override
	public void close() {
		super.close();
		LOG.error("close");
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
