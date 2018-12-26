package dao;

import entity.Officials;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class OfficialsDAO 
{
    static Session session = null;
    
    static public Officials officialLogin (String passwd, String login)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Officials employee = null;
        
        try {
            session.beginTransaction();
			
            Criteria criteria = session.createCriteria(Officials.class);
            criteria.add(Restrictions.eq("passwd", passwd));
            criteria.add(Restrictions.eq("login", login));
			
            employee = (Officials) criteria.uniqueResult();			
            session.getTransaction().commit();
	}
        catch (Exception e) 
        {
            System.out.println(e);
            session.getTransaction().rollback();
	}
        
        return employee;
    }
    
    
}
