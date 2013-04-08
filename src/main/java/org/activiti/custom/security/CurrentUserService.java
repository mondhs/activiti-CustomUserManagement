package org.activiti.custom.security;

import org.activiti.custom.explorer.ui.login.CustomDefaultLoginHandler;
import org.activiti.custom.security.domain.UserProfile;
/**
 * interface returns user information which is already currently connected to the system.
 * It is used from {@link CustomDefaultLoginHandler}
 * @author mondhs
 *
 */
public interface CurrentUserService {

	UserProfile getCurrentUser();

}
