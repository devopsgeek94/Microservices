/**
 * 
 */
package com.lifetolearn.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lifetolearn.application.domain.Credentials;
import com.lifetolearn.application.domain.User;

/**
 * @author Prateek Maurya
 * 		   since 26-Aug-2019
 */
@Service
public interface UserService {
	public User register(User user);

	public User getByUsername(String username);

	public List<User> getAll();

	public long deleteByUsername(String username);

	public String updatePassword(Credentials credentials);
}
