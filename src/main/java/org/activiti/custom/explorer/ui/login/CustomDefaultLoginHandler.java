package org.activiti.custom.explorer.ui.login;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.custom.identity.CustomGroup;
import org.activiti.custom.identity.CustomUser;
import org.activiti.custom.security.CurrentUserService;
import org.activiti.custom.security.domain.UserProfile;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.explorer.Constants;
import org.activiti.explorer.identity.LoggedInUser;
import org.activiti.explorer.identity.LoggedInUserImpl;
import org.activiti.explorer.ui.login.DefaultLoginHandler;

/**
 * UI integration with activiti explorer. Main idea how integrate custom {@link CurrentUserService} to UI login.
 * Login form uses {@link #authenticate(String, String)}.
 * login check filter uses {@link #authenticate(HttpServletRequest, HttpServletResponse)}. if override this most probably you do not need change {@link #authenticate(String, String)}
 * This used custom {@link CurrentUserService}
 * 
 * @author mondhs
 * 
 */
public class CustomDefaultLoginHandler extends DefaultLoginHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7393324602979871899L;
	private CurrentUserService currentUserService;

	/**
	 * Current user login
	 * This is called from login from in localhost:8080/claims/ui. 
	 * 
	 * user should be automatically logged in @see {@link #authenticate(HttpServletRequest, HttpServletResponse)}
	 * 
	 * @param userName is not important as app current user will be used expected empty or other value
	 * @param password is not important as app current user will be used expected empty or other value
	 */
	public LoggedInUserImpl authenticate(String userName, String password) {
		LoggedInUserImpl loggedInUser = null;
		User user = findCurrentUser();
		if(user == null){
			return null;
		}
		loggedInUser = new LoggedInUserImpl(user, user.getPassword());
		List<Group> groups = findUserGroups(user);
		for (Group group : groups) {
			if (Constants.SECURITY_ROLE.equals(group.getType())) {
				loggedInUser.addSecurityRoleGroup(group);
				if (Constants.SECURITY_ROLE_USER.equals(group.getId())) {
					loggedInUser.setUser(true);
				}
				if (Constants.SECURITY_ROLE_ADMIN.equals(group.getId())) {
					loggedInUser.setAdmin(true);
				}
			} else {
				loggedInUser.addGroup(group);
			}
		}
		return loggedInUser;
	}
	/**
	 * This is called from login from in localhost:8080/claims/login.xhtml. 
	 * Current user login
	 */
	public LoggedInUser authenticate(HttpServletRequest request, HttpServletResponse response) {
		// current user login to Activiti 
		return authenticate("","");
	}

	private List<Group> findUserGroups(User user) {
		List<Group> userGroup = new ArrayList<Group>();
		userGroup.add(new CustomGroup(Constants.SECURITY_ROLE_USER,
				Constants.SECURITY_ROLE));
		userGroup.add(new CustomGroup(Constants.SECURITY_ROLE_ADMIN,
				Constants.SECURITY_ROLE));
		return userGroup;
	}

	private User findCurrentUser() {
		UserProfile userProfile = currentUserService.getCurrentUser();
		CustomUser aUser = null;
		if(userProfile != null){
			aUser = new CustomUser(userProfile);
		}
		return aUser;
	}

	public void setCurrentUserService(CurrentUserService currentUserService) {
		this.currentUserService = currentUserService;
	}

}
