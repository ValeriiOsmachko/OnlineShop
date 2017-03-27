package com.epam.osmachko.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.osmachko.entity.User;

public class Strorage {
	
	public static final List<User> STORAGE = new ArrayList<User>();

	static {
		STORAGE.add(new User(1,"val1","password1","Valerii","Osmachko","v.o.osa@gmail.com"));
		STORAGE.add(new User(2,"val2","password2","Zahorodnii","Vladislav","vlad@gmail.com"));
		STORAGE.add(new User(3,"val3","password3","Yevheniya","Komahina","komiahina@gmail.com"));
	}
}
