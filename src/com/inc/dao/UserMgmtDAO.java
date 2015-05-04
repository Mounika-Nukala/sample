package com.inc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UserMgmtDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	public void setSession(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	public void addUser(User usr)
	{
		Session ses=sessionFactory.getCurrentSession();
		ses.save(usr);
		
	}
	
	public List<User> getAllUsers()
	{
		Session ses=sessionFactory.getCurrentSession();
		String qry="from User";
		Query qryObj=ses.createQuery(qry);
		List<User> usrList=qryObj.list();
		return usrList;
	}
	
	
	@SuppressWarnings("unchecked")
	public User getUser(int uid)
	{
		Session ses=sessionFactory.getCurrentSession();
		String qry="from User where uid="+uid;
		Query qryObj=ses.createQuery(qry);
		List<User> usrList=qryObj.list();
		User usr=usrList.get(0);
		return usr;
	}
	public int UpdateUser(User usr)
	{
		Session ses=sessionFactory.getCurrentSession();
		String qry="update User set fname='"+usr.getFname()+"',lname='"+usr.getLname()+"',email='"+usr.getEmail()+"' where uid="+usr.getUid();
		Query qryObj=ses.createQuery(qry);
		int val=qryObj.executeUpdate();
		return val;
	}
	public int deleteUser(int uid)
	{
		Session ses=sessionFactory.getCurrentSession();
		String qry="delete from User where uid="+uid;
		Query qryObj=ses.createQuery(qry);
		int val=qryObj.executeUpdate();
		return val;
	}
}
