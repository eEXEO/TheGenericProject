package dao;

import entity.Owners;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import top.SessionHolder;

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
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Object ob = session.get(Owners.class, SessionHolder.getOwner().getIdow());
        Owners o = (Owners)ob;
        o.setAddress(address);
        o.setName(name);
        o.setSurname(surname);
        
        session.update(ob);
        
        tx.commit();
        session.close();
        
        return o;
    }
    
    static public Owners deleteOwner(String pesel)
    {
        Owners owner = checkPesel(pesel);
        int id = owner.getIdow();
        session = HibernateUtil.getSessionFactory().openSession();
        System.out.println(id);
        
        Transaction tx = session.beginTransaction();  
        Object ob = session.load(Owners.class, id);
        Owners veh = (Owners) ob;

        session.delete(veh);
        tx.commit();  
        
        return veh;
    }
    
}
