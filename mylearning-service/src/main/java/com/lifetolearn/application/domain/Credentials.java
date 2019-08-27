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
public class Credentials {
	private String username;
	private String oldPassword;
	private String newPassword;
}
