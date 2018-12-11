package com.zhengshr.realm;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhengshr.entity.User;

@Component
public class UserRealm extends AuthorizingRealm {
	Logger logger = LoggerFactory.getLogger(UserRealm.class);
	
	@Autowired
	private UserDao userDao;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		System.out.println("=============获取授权信息");
		info.addStringPermission("sys:manager");
		info.addStringPermission("user");

		return info;
	}

	@Override

	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		String password = new String(upToken.getPassword());
		User user = new User();
		user.setLoginName(username);
		user = userDao.get(user);

		logger.info("=========== 获取验证信息");
		if (user != null) {
			return new SimpleAuthenticationInfo(username, 
					user.getPassword(), 
					ByteSource.Util.bytes(user.getSalt()), 
					getName());
		}

		return null;
	}

	public static class Principal implements Serializable {
		private static final long serialVersionUID = 1L;
		private String id; // 编号
		private String loginName; // 登录名
		private String name; // 姓名
		public Principal(User user) {
			this.id = user.getId();
			this.loginName = user.getLoginName();
			this.name = user.getName();
		}
		public String getId() {
			return id;
		}
		public String getLoginName() {
			return loginName;
		}
		public String getName() {
			return name;
		}

		/**
		 * 获取SESSIONID
		 * 
		 */
		/*
		public String getSessionid() {
			try {
				return (String) UserUtils.getSession().getId();
			} catch (Exception e) {
				return "";
			}
		}*/
		
		@Override
		public String toString() {
			return id;
		}
	}
}