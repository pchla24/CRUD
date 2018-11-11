/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import entity.Rower;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author User
 */
public class ReadDAO {
    
    public ReadDAO() {
    
    }
    
    public Rower read(int id) {
        
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Rower.class)
                                .buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        
        try {
            session.beginTransaction();
            
            System.out.println("Retriving bike with id: " + id);
            Rower retrivedBike = (Rower) session.get(Rower.class, id);
            session.getTransaction().commit();
            System.out.println("Retrived bike: " + retrivedBike);
            return retrivedBike;
        }
        finally {
            factory.close();
        } 
        
    }
    
}
