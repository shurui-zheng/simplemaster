package com.zhengshr.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhengshr.entity.User;
import com.zhengshr.realm.UserDao;

@Controller
@RequestMapping("user.do")
public class UserController {
	
	@Autowired
	UserDao userDao;
	EnterpriseCacheSessionDAO cachdao;
	
	@RequestMapping(value="fetchSession", method=RequestMethod.GET)
	public @ResponseBody Session fetchSession() {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		if(session.getAttribute("user") != null) {
			final String username = (String) subject.getPrincipal();
			User user = userDao.get(new User() {
				{
					setLoginName(username);
				}
			});			
			session.setAttribute("user", user);
		}

		return session;
	}
	
	
}
