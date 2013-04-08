package org.activiti.custom.security;

import java.util.List;

import org.activiti.custom.security.domain.UserProfile;
import org.activiti.custom.spring.CustomUserEntityManager;
/**
 * Simplified representation of custom User management DAO service.
 * It is called by {@link CustomUserEntityManager}. 
 * @author mondhs
 *
 */
public interface UserDao {

	List<UserProfile> findAll();

	UserProfile findUserByLoginName(String id);

}
