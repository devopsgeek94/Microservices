/**
 * 
 */
package com.lifetolearn.application.domain;

import lombok.Data;

/**
 * @author Prateek Maurya
 * 		   since 26-Aug-2019
 */
@Data
public class User {
	private String name;
	private String username;
	private String password;
	private String emailId;
}
