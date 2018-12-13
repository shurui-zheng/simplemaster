package com.zhengshr.util;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroSessionListener implements SessionListener {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void onStart(Session session) {
		// TODO Auto-generated method stub
		logger.info("~~~~~~~~~~~~~~~~~ starting shirosession {}", session.getId());
	}

	public void onStop(Session session) {
		// TODO Auto-generated method stub
		logger.info("~~~~~~~~~~~~~~~~~ stopping shirosession {}", session.getId());
	}

	public void onExpiration(Session session) {
		// TODO Auto-generated method stub
		logger.info("~~~~~~~~~~~~~~~~~~ expiring shirosession {}", session.getId());
		
	}

}
