package com.Accer.DAOImplemaintation;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Accer.DAOInterFace.LoginDAOInterFace;
import com.Accer.Entity.Roles;
import com.Accer.Entity.UserProfile;
import com.Accer.Entity.UserVerfication;
import com.Accer.Entity.Users;

@Repository
public class LoginDAOImplemaintation implements LoginDAOInterFace {

	@Autowired
	private SessionFactory sessionFactory;

	public UserProfile findUserProfile(String userEmail) {
		try {
			Criteria cr = sessionFactory.getCurrentSession().createCriteria(UserProfile.class);
			cr.add(Restrictions.eq("userEmailId", userEmail));
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			
			if (cr.list() == null || cr.list().isEmpty()) {
				System.out.println("userEmail 2"+ userEmail);
				return null;
			}
			
			System.out.println("userEmail 3"+ userEmail);
			return (UserProfile) cr.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Roles findUserRole(String roleName) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Roles.class);
		cr.add(Restrictions.eq("role", roleName));
		cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		if (cr.list() == null || cr.list().isEmpty()) {
			return null;
		}
		return (Roles) cr.list().get(0);

	}

	public boolean registerNewAccount(Users user) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(Users.class.getName(), user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			return false;

		}
	}

	public UserProfile findAccessKeyandEmailIdByAdmin(String accesskey, String userEmail) {

		Criteria cr = sessionFactory.getCurrentSession().createCriteria(UserProfile.class);
		Criterion rest = Restrictions.or(Restrictions.eq("userEmailId", userEmail));
		cr.createAlias("userVerfication", "verification"); 
		Criterion rest1 = Restrictions.or(Restrictions.eq("verification.adminEmailVerification", accesskey));
		cr.add(Restrictions.and(rest, rest1));
		cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		if (cr.list() == null || cr.list().isEmpty()) {
			return null;
		}
		return (UserProfile) cr.list().get(0);
	}

	public UserProfile findAccessKeyandEmailIdByUser(String accessKey, String emailId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(UserProfile.class);
		Criterion rest = Restrictions.or(Restrictions.eq("userEmailId", emailId));
		cr.createAlias("userVerfication", "verification"); 
		Criterion rest1 = Restrictions.or(Restrictions.eq("verification.userEmailVerification", accessKey));
		cr.add(Restrictions.and(rest, rest1));
		cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		if (cr.list() == null || cr.list().isEmpty()) {
			return null;
		}
		return (UserProfile) cr.list().get(0);
	}

	

	public boolean updateUserProfile(UserProfile userProfile) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(UserProfile.class.getName(), userProfile);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			return false;
		}

	}

	public String findUserByEmailIdUserTable(String userEmail) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Users.class);
		cr.add(Restrictions.eq("username", userEmail));
		cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		if (cr.list() == null || cr.list().isEmpty()) {
			return "Not Avail";
		}
		return "Success";
	}

	public boolean rejectAccountByAdmin(String userEmail) {
		UserProfile userProfile = null;
		try {
			userProfile = (UserProfile) sessionFactory.getCurrentSession().load(UserProfile.class, userEmail);
			sessionFactory.getCurrentSession().delete(userProfile);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public boolean findPasswordAccessKeyandEmailIdByUser(String accessKey, String emailId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(UserProfile.class);
		Criterion rest = Restrictions.or(Restrictions.eq("userEmailId", emailId));
		Criterion rest1 = Restrictions.or(Restrictions.eq("userVerfications.forgotPassword", accessKey));
		cr.add(Restrictions.and(rest, rest1));
		cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		if (cr.list() == null || cr.list().isEmpty()) {
			return false;
		}
		return true;
	}

	public Users findUserByIdInUserTable(String userEmail) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Users.class);
		cr.add(Restrictions.eq("username", userEmail));
		cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		if (cr.list() == null || cr.list().isEmpty()) {
			return null;
		}
		return (Users) cr.list().get(0);
	}

	@Override
	public boolean updateUserVerification(UserVerfication userVerification) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(UserVerfication.class.getName(), userVerification);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			return false;

		}
	}

}
