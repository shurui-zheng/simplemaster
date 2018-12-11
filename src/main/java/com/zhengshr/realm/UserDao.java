package com.zhengshr.realm;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhengshr.entity.User;

@Service
public class UserDao {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	Map<String, User> userStore = new HashMap<String, User>();
	public UserDao() {
		populateUserStore();
	}
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();

	void populateUserStore() {
		User user = new User();
		user.setId("123");
		user.setLoginName("zhengshurui");
		user.setName("郑树锐");
		String credential = "123456";
		RandomNumberGenerator rng = new SecureRandomNumberGenerator();
		String salt = rng.nextBytes().toBase64();
		
		String hashedPasswordBase64 = new Sha256Hash(credential, salt, 1).toBase64();
		user.setPassword(hashedPasswordBase64);
		user.setSalt(salt);
		userStore.put(user.getLoginName(), user);
	}
	
	public User get(User user) {
		// for test.
		logger.debug("return from userDao: {}", gson.toJson(userStore));
		if(userStore.containsKey(user.getLoginName())) {
			User ret = userStore.get(user.getLoginName());
			return ret;
		}
		
		return null;
	}
}
