package dao;

import entity.Vehicles;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
