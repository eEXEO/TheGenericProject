package dao;

import static dao.VehiclesDAO.session;
import entity.Wiw;
import entity.Owners;
import entity.Vehicles;
import java.text.ParseException;
import org.hibernate.Transaction;
import static top.SessionHolder.*;
import static dao.VehiclesDAO.*;
import static dao.OwnersDAO.*;
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
                System.out.println("found");
                return false;
            }else
            {
                System.out.println("not found");
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
    
    static public boolean insertOV(String plates, String pesel) throws ParseException
    {
        
        int vid, oid;
        int gid = getServant().getIdof();
        Owners tempo = checkPesel(pesel);
        Vehicles tempv = checkPlates(plates);
        
        if(tempo==null || tempv==null)
        {
            return false;
        }else
        {
            vid = tempv.getIdve();
            oid = tempo.getIdow();
            Wiw data = new Wiw(vid, oid, gid);
            
            if(checkOV(vid, oid))
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
    }
    
    static public Wiw rcheckOV(int vid, int oid)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Wiw db = null;
        
        try {
            session.beginTransaction();
			
            Criteria criteria = session.createCriteria(Wiw.class);
            criteria.add(Restrictions.eq("vid", vid));
            criteria.add(Restrictions.eq("oid", oid));
            
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
    
    static public boolean removeOV(String plates, String pesel) throws ParseException
    {
        
        int vid, oid;
        Owners tempo = checkPesel(pesel);
        Vehicles tempv = checkPlates(plates);
        
        if(tempo==null || tempv==null)
        {
            return false;
        }else
        {
            vid = tempv.getIdve();
            oid = tempo.getIdow();
            
            Wiw rchk = rcheckOV(vid, oid);
                        
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
}
