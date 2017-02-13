package com.Accer.DAOImplemaintation;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Accer.DAOInterFace.DashboardDAOInterFace;
import com.Accer.Entity.UserProfile;
@Repository
public class DashboardDAOImplemaintaion implements DashboardDAOInterFace{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public UserProfile findUserProfileByUserEmail(String name) {
		try {
			Criteria cr = sessionFactory.getCurrentSession().createCriteria(UserProfile.class);
			cr.add(Restrictions.eq("userEmailId", name));
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			
			if (cr.list() == null || cr.list().isEmpty()) {
				return null;
			}
			return (UserProfile) cr.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public String updateUserProfile(UserProfile userProfileLocal) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(UserProfile.class.getName(), userProfileLocal);
			return "Success";
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			return "Try Again!";

		}
	}
	
}
