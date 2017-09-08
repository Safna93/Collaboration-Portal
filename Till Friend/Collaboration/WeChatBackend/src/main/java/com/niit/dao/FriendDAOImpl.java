package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Friend;
import com.niit.model.User;
@Repository
@Transactional
public class FriendDAOImpl  implements FriendDAO{

	@Autowired
	private SessionFactory sessionFactory;
	public List<User> getListOfSuggestedUsers(String username) {
		Session session=sessionFactory.getCurrentSession();
		String queryString="select * from user where username in (select username from user where username!=? minus (select fromId from friend where toId=? and status!='D' union select toId from friend where fromId=? and status!='D'))";
SQLQuery query=session.createSQLQuery(queryString);
		query.setString(0,username);
		query.setString(1,username);
		query.setString(2,username);
		query.addEntity(User.class);
		List<User> suggestedUsers=query.list();
		return suggestedUsers;
	}
	
	public void addFriendRequest(String username, String toId) {
		Session session=sessionFactory.getCurrentSession();
		Friend friend=new Friend();
		friend.setFromId(username);
		friend.setToId(toId);
		friend.setStatus('P');
		session.save(friend);		
	}

	
	public List<Friend> getPendingRequests(String username) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Friend where toId=? and status='P'");
		query.setString(0,username)	;
		return query.list();
		}

	
	public void updatePendingRequest(Friend pendingRequest) {
		Session session=sessionFactory.getCurrentSession();
		session.update(pendingRequest);
		
	}

}
