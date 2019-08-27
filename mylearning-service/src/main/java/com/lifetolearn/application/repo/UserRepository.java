/**
 * 
 */
package com.lifetolearn.application.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lifetolearn.application.domain.User;

/**
 * @author Prateek Maurya
 * 		   since 26-Aug-2019
 */
public interface UserRepository extends MongoRepository<User, String> {

	/**
	 * @param username
	 * @return
	 */
	User findByUsername(String username);

	/**
	 * @param username
	 * @return
	 */
	long deleteByUsername(String username);

}
