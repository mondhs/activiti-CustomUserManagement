package org.activiti.custom.engine.identity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.activiti.custom.identity.CustomUser;
import org.activiti.custom.security.UserDao;
import org.activiti.custom.security.domain.UserProfile;
import org.activiti.engine.identity.User;
import org.activiti.engine.identity.UserQuery;

/**
 * Simplified implementation of {@link UserQuery}. It is adapts results from {@link UserDao}.
 * Implementation is just as sample and it is not performance efficient. 
 * 
 * @author mondhs
 *
 */
public class CustomUserQuery implements UserQuery {

	private UserDao userDao;

	@Override
	public UserQuery asc() {
		throw new IllegalArgumentException("Not Impl");
	}

	@Override
	public UserQuery desc() {
		throw new IllegalArgumentException("Not Impl");
	}

	@Override
	public long count() {
		return userDao.findAll().size();
	}

	@Override
	public User singleResult() {
		throw new IllegalArgumentException("Not Impl");
	}

	@Override
	public List<User> list() {
		throw new IllegalArgumentException("Not Impl");
	}

	@Override
	public List<User> listPage(int firstResult, int maxResults) {
		List<User> users = new ArrayList<User>();
		Iterator<UserProfile> userProfiles = userDao.findAll().iterator();
		for (int i = 0; i < firstResult; i++) {
			userProfiles.next();
		}
		for (int i = 0; i < maxResults; i++) {
			if (!userProfiles.hasNext()) {
				break;
			}
			UserProfile userProfile = userProfiles.next();
			CustomUser user = new CustomUser(userProfile);
			users.add(user);
		}

		return users;
	}

	@Override
	public UserQuery userId(String id) {
		final UserProfile userProfile = userDao.findUserByLoginName(id);

		UserQuery aSubUserQuery = new UserQuery() {

			@Override
			public User singleResult() {
				CustomUser user = new CustomUser(userProfile);
				return user;
			}

			@Override
			public List<User> listPage(int firstResult, int maxResults) {
				throw new IllegalArgumentException("Not Impl");
			}

			@Override
			public List<User> list() {
				throw new IllegalArgumentException("Not Impl");
			}

			@Override
			public UserQuery desc() {
				throw new IllegalArgumentException("Not Impl");
			}

			@Override
			public long count() {
				throw new IllegalArgumentException("Not Impl");
			}

			@Override
			public UserQuery asc() {
				throw new IllegalArgumentException("Not Impl");
			}

			@Override
			public UserQuery userLastNameLike(String lastNameLike) {
				throw new IllegalArgumentException("Not Impl");
			}

			@Override
			public UserQuery userLastName(String lastName) {
				throw new IllegalArgumentException("Not Impl");
			}

			@Override
			public UserQuery userId(String id) {
				throw new IllegalArgumentException("Not Impl");
			}

			@Override
			public UserQuery userFirstNameLike(String firstNameLike) {
				throw new IllegalArgumentException("Not Impl");
			}

			@Override
			public UserQuery userFirstName(String firstName) {
				throw new IllegalArgumentException("Not Impl");
			}

			@Override
			public UserQuery userEmailLike(String emailLike) {
				throw new IllegalArgumentException("Not Impl");
			}

			@Override
			public UserQuery userEmail(String email) {
				throw new IllegalArgumentException("Not Impl");
			}

			@Override
			public UserQuery potentialStarter(String procDefId) {
				throw new IllegalArgumentException("Not Impl");
			}

			@Override
			public UserQuery orderByUserLastName() {
				throw new IllegalArgumentException("Not Impl");
			}

			@Override
			public UserQuery orderByUserId() {
				throw new IllegalArgumentException("Not Impl");
			}

			@Override
			public UserQuery orderByUserFirstName() {
				throw new IllegalArgumentException("Not Impl");
			}

			@Override
			public UserQuery orderByUserEmail() {
				throw new IllegalArgumentException("Not Impl");
			}

			@Override
			public UserQuery memberOfGroup(String groupId) {
				throw new IllegalArgumentException("Not Impl");
			}

			@Override
			public UserQuery userFullNameLike(String arg0) {
				throw new IllegalArgumentException("Not Impl");
			}

		};

		return aSubUserQuery;
	}

	@Override
	public UserQuery userFirstName(String firstName) {
		throw new IllegalArgumentException("Not Impl");
	}

	@Override
	public UserQuery userFirstNameLike(String firstNameLike) {
		throw new IllegalArgumentException("Not Impl");
	}

	@Override
	public UserQuery userLastName(String lastName) {
		throw new IllegalArgumentException("Not Impl");
	}

	@Override
	public UserQuery userLastNameLike(String lastNameLike) {
		throw new IllegalArgumentException("Not Impl");
	}

	@Override
	public UserQuery userEmail(String email) {
		throw new IllegalArgumentException("Not Impl");
	}

	@Override
	public UserQuery userEmailLike(String emailLike) {
		throw new IllegalArgumentException("Not Impl");
	}

	@Override
	public UserQuery memberOfGroup(String groupId) {
		throw new IllegalArgumentException("Not Impl");
	}

	@Override
	public UserQuery potentialStarter(String procDefId) {
		throw new IllegalArgumentException("Not Impl");
	}

	@Override
	public UserQuery orderByUserId() {
		throw new IllegalArgumentException("Not Impl");
	}

	@Override
	public UserQuery orderByUserFirstName() {
		throw new IllegalArgumentException("Not Impl");
	}

	@Override
	public UserQuery orderByUserLastName() {
		throw new IllegalArgumentException("Not Impl");
	}

	@Override
	public UserQuery orderByUserEmail() {
		throw new IllegalArgumentException("Not Impl");
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserQuery userFullNameLike(String arg0) {
		throw new IllegalArgumentException("Not Impl");
	}

}
