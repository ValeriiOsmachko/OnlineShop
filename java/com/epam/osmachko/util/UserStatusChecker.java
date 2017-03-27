package com.epam.osmachko.util;

import java.util.Date;
import com.epam.osmachko.constant.Constant;
import com.epam.osmachko.entity.User;
import com.epam.osmachko.service.MySQLUserService;

public class UserStatusChecker {
	
	private MySQLUserService service;
	

	public UserStatusChecker(MySQLUserService service) {
		this.service = service;
	}

	public boolean checkUserStatus(User user) {
		checkForBan(user);
		User user1 = getUpdatedUser(user);
		return checkForBan(user) & user1.getQuantityWrongLoginAttemps() <= Constant.AMOUNT_OF_WRONG_INPUT;
	}

	private boolean checkForBan(User user) {
		Date banDate = user.getBanTime();
		if (user.getBanTime() == null) {
			return true;
		}
		Date currentDate = new Date();
		long diffInMillies = currentDate.getTime() - banDate.getTime();
		long time = diffInMillies/ (60 * 1000) % 60;
		if (time > Constant.TIME_OF_BAN) {
			service.unBanUser(user);
			service.setAmountOfWrongLoginAttemps(user);
		}
		return time > Constant.TIME_OF_BAN;
	}
	
	private User getUpdatedUser(User user) {
		return service.getUserByLogin(user.getLogin());
		
	}
	
	

}
