package dao;

import entity.Owners;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
