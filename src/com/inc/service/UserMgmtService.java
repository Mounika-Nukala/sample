package com.inc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inc.dao.User;
import com.inc.dao.UserMgmtDAO;
@Service
public class UserMgmtService 
{
	@Autowired
	private UserMgmtDAO userDAO;
	
	public UserMgmtDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserMgmtDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public void addUser(UserDetails usrDetails)
	{
		System.out.println("User Service called...!");
		User usr=new User();
		usr.setEmail(usrDetails.getEmail());
		usr.setFname(usrDetails.getFname());
		usr.setLname(usrDetails.getLname());
		userDAO.addUser(usr);
	}
	public UserDetails getUser(int uid)
	{
		User usr=userDAO.getUser(uid);
		UserDetails usrDetails=new UserDetails();
		System.out.println("service----"+usr.getEmail());
		usrDetails.setUid(usr.getUid());
		usrDetails.setFname(usr.getFname());
		usrDetails.setLname(usr.getLname());
		usrDetails.setEmail(usr.getEmail());
		return usrDetails;
	}
	public int UpdateUser(UserDetails usrDetails)
	{
		User usr=new User();
		usr.setEmail(usrDetails.getEmail());
		usr.setFname(usrDetails.getFname());
		usr.setLname(usrDetails.getLname());
		usr.setUid(usrDetails.getUid());
		int val=userDAO.UpdateUser(usr);
		return val;
	}
	public int deleteUser(int uid)
	{
		int val=userDAO.deleteUser(uid);
		return val;
	}
	public List<UserDetails> getAllUsers()
	{
		List<User> userlist=userDAO.getAllUsers();
		
		List<UserDetails> userdetList=new ArrayList<UserDetails>();
		for(User user:userlist)
		{
			UserDetails usrDetails=new UserDetails();
			usrDetails.setUid(user.getUid());
			usrDetails.setFname(user.getFname());
			usrDetails.setLname(user.getLname());
			usrDetails.setEmail(user.getEmail());
			userdetList.add(usrDetails);
		}
		return userdetList;
	}
}
