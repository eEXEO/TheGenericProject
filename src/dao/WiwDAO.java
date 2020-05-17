package dao;

import static dao.VehiclesDAO.session;
import entity.Wiw;
import entity.Owners;
import java.text.ParseException;
import org.hibernate.Transaction;
import static top.SessionHolder.*;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

public class WiwDAO 
{
    
    static public boolean checkOV(int vid, int oid)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Wiw wiw = null;
        
        try {
            session.beginTransaction();
			
            Criteria criteria = session.createCriteria(Wiw.class);
            criteria.add(Restrictions.eq("vid", vid));
            criteria.add(Restrictions.eq("oid", oid));
			
            wiw = (Wiw) criteria.uniqueResult();			
            session.getTransaction().commit();
            
            if(wiw!=null)
            {
                return false;
            }else
            {
                return true;
            }
	}
        catch (Exception e) 
        {
            System.out.println(e);
            session.getTransaction().rollback();
            return false;
	}
    }
    
    
    static public boolean checkV(int vid)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Wiw wiw = null;
        
        try {
            session.beginTransaction();
			
            Criteria criteria = session.createCriteria(Wiw.class);
            criteria.add(Restrictions.eq("vid", vid));
			
            wiw = (Wiw) criteria.uniqueResult();			
            session.getTransaction().commit();
            
            if(wiw != null)
            {
                return false;
            }else
            {
                return true;
            }
	}
        catch (Exception e) 
        {
            System.out.println(e);
            session.getTransaction().rollback();
            return false;
	}
    }
    
    static public boolean checkO(int oid)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Wiw wiw = null;
        
        try {
            session.beginTransaction();
			
            Criteria criteria = session.createCriteria(Wiw.class);
            criteria.add(Restrictions.eq("oid", oid));
			
            wiw = (Wiw) criteria.uniqueResult();			
            session.getTransaction().commit();
            
            if(wiw != null)
            {
                return false;
            }else
            {
                return true;
            }
	}
        catch (Exception e) 
        {
            System.out.println(e);
            session.getTransaction().rollback();
            return false;
	}
    }
    
    
    static public List<Wiw> checkOwn(int oid)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Wiw wiw = null;
        
        try {
            session.beginTransaction();
			
            Criteria criteria = session.createCriteria(Wiw.class);
            List<Wiw> list = criteria.add(Restrictions.eq("oid", oid)).list();
			
            session.getTransaction().commit();
            
            return list;
	}
        catch (Exception e) 
        {
            System.out.println(e);
            session.getTransaction().rollback();
            return null;
	}
    }
    
    static public boolean insertOV(int idve, int idow) throws ParseException
    {
        

        int gid = getServant().getIdof();

            Wiw data = new Wiw(idve, idow, gid);
            
            if(checkOV(idve, idow))
            {
                session = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = session.beginTransaction();
                //session.save(data);
                session.saveOrUpdate(data);
                tx.commit();
                session.close();

                return true;
            }
            else
            {
                return false;
            }
        
    }
    
    static public Wiw rcheckOV(int vid)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Wiw db = null;
        
        try {
            session.beginTransaction();
			
            Criteria criteria = session.createCriteria(Wiw.class);
            criteria.add(Restrictions.eq("vid", vid));
            
            db = (Wiw) criteria.uniqueResult();			
            session.getTransaction().commit();
	}
        catch (HibernateException e) 
        {
            System.out.println(e);
            session.getTransaction().rollback();
	}
        
        return db;
    }
   
    static public boolean removeOV(int idve) throws ParseException
    {

            Wiw rchk = rcheckOV(idve);
                        
            if(rchk!=null)
            {
                int wiwid = rchk.getIdwiw();
                
                session = HibernateUtil.getSessionFactory().openSession();
        
                Transaction tx = session.beginTransaction();  
                Object ob = session.load(Wiw.class, wiwid);
                Wiw ovc = (Wiw) ob;

                session.delete(ovc);
                tx.commit(); 

                return true;
            }
            else
            {
                return false;
            }
        
    }
}
