package com.epam.osmachko.domain;

import com.epam.osmachko.bean.RegistrationFormBean;
import com.epam.osmachko.entity.User;
import com.epam.osmachko.password_hash_algorithm.PasswordHash;

public class UserDomain {

	public static User transfirtToDomain(RegistrationFormBean bean) {
		User user = new User();
		user.setEmail(bean.getEmail());
		user.setFirstName(bean.getFirstName());
		user.setLastName(bean.getLastName());
		user.setLogin(bean.getLogin());
		PasswordHash passwordHash = new PasswordHash();
		String hashPass = passwordHash.md5Apache(bean.getPassword());
		user.setPassword(hashPass);
		return user;
	}
}
