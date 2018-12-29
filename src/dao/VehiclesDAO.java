package dao;

import static dao.VehiclesDAO.session;
import entity.Vehicles;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import top.SessionHolder;

public class VehiclesDAO 
{
    static Session session = null;
    
    static public void insertVehicle(String make, String model, String year, String color, String plates) throws ParseException
    {
        Date yeart = new SimpleDateFormat("dd-MM-yyyy").parse(year);
        Vehicles data = new Vehicles(make, model, yeart, color, plates);
        
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(data);
        tx.commit();
        session.close();
    }
    
    static public Vehicles checkPlates(String plates)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Vehicles vehicle = null;
        
        try {
            session.beginTransaction();
			
            Criteria criteria = session.createCriteria(Vehicles.class);
            criteria.add(Restrictions.eq("plates", plates));
			
            vehicle = (Vehicles) criteria.uniqueResult();			
            session.getTransaction().commit();
	}
        catch (Exception e) 
        {
            System.out.println(e);
            session.getTransaction().rollback();
	}
        
        return vehicle;
    }
    
    static public Vehicles editVehicle(String make, String model, String year, String color, String plates) throws ParseException
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Object ob = session.get(Vehicles.class, SessionHolder.getVehicle().getIdve());
        Vehicles o = (Vehicles)ob;
        
        Date yeart = new SimpleDateFormat("dd-MM-yyyy").parse(year);
        
        o.setColor(color);
        o.setMake(make);
        o.setModel(model);
        o.setPlates(plates);
        o.setYear(yeart);
        
        session.update(ob);
        
        tx.commit();
        session.close();
        
        return o;
    }
    
    static public Vehicles deleteVehicle(String plates)
    {
        Vehicles vehicle = checkPlates(plates);
        int id = vehicle.getIdve();
        session = HibernateUtil.getSessionFactory().openSession();
        
        Transaction tx = session.beginTransaction();  
        Object ob = session.load(Vehicles.class,id);
        Vehicles veh = (Vehicles) ob;

        session.delete(veh);
        tx.commit();  
        
        return veh;
    }
}
