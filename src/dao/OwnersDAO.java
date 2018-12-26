package dao;

import entity.Owners;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class OwnersDAO 
{
    static Session session = null;
    
    static public void insertOwner(long pesel, String name, String surname, String address)
    {
        Owners data = new Owners(pesel, name, surname, address);
        
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(data);
        tx.commit();
        session.close();
    }
    
    static public Owners checkPesel(String pesel)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Owners owner = null;
        
        long pesell = Long.parseLong(pesel);
        
        try {
            session.beginTransaction();
			
            Criteria criteria = session.createCriteria(Owners.class);
            criteria.add(Restrictions.eq("pesel", pesell));
			
            owner = (Owners) criteria.uniqueResult();			
            session.getTransaction().commit();
	}
        catch (Exception e) 
        {
            System.out.println(e);
            session.getTransaction().rollback();
	}
        
        return owner;
    }
    
    static public Owners editOwner(long pesel, String name, String surname, String address)
    {
        return new Owners();
    }
    
}
