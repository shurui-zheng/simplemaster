package com.zhengshr.realm;

import org.springframework.stereotype.Service;

import com.zhengshr.entity.User;

@Service
public class UserDao {
	
	public User get(User user) {
		// for test.
		if(user.getLoginName().equals("zhengshr")) {
			user.setId("123");
			user.setName("郑树锐");
			user.setPassword("123456");
			
			return user;
		}
		
		return null;
	}
}
