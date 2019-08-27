/**
 * 
 */
package com.lifetolearn.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifetolearn.application.domain.Credentials;
import com.lifetolearn.application.domain.User;
import com.lifetolearn.application.repo.UserRepository;

/**
 * @author Prateek Maurya 
 * 		   since 26-Aug-2019
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User register(User user) {
		if (userRepository.findByUsername(user.getUsername()) != null) {
			return user;
		} else {
			return userRepository.save(user);
		}
	}

	@Override
	public User getByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public long deleteByUsername(String username) {

		return userRepository.deleteByUsername(username);
	}

	@Override
	public String updatePassword(Credentials credentials) {
		User user = userRepository.findByUsername(credentials.getUsername());
		if (user!= null) {
			if (credentials.getOldPassword().equals(user.getPassword())) {
				userRepository.deleteByUsername(credentials.getUsername());
				user.setPassword(credentials.getNewPassword());
				userRepository.save(user);
				return "Credentials updated successfully for user : " + credentials.getUsername();
			} else {
				return "Invalid Password! for user :- " + credentials.getUsername();
			}
		} else {
			return "Invalid User! :-" + credentials.getUsername();
		}

	}
}
