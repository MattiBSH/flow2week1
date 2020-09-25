/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author matti
 */
public class Tester {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        Person p1 = new Person("Matti Hansen",1998);
        Person p2 = new Person("Paul mejer",1997);
        Address a1= new Address("store torv 1",2323,"nr snede");
        Address a2= new Address("store torv 2",2323,"nr pube");
        Fee f1= new Fee(200);
        Fee f2= new Fee(250);
        Fee f3= new Fee(350);
        p1.setAddress(a1);
        p2.setAddress(a2);
        p1.addFee(f2);
        p2.addFee(f1);
        p1.addFee(f3);
        SwimStyle s1 = new SwimStyle("Crawl");
        SwimStyle s2 = new SwimStyle("Butterfly");
        SwimStyle s3 = new SwimStyle("breast");
        
        p1.addSwimStyle(s3);
        p1.addSwimStyle(s1);
        p2.addSwimStyle(s2);
        
        //DB SECTION***
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        
        em.getTransaction().commit();
        //DB SECTION***
        //DB SECTION***
        em.getTransaction().begin();
        p1.removeSwimStyle(s3);
        
        em.getTransaction().commit();
        //DB SECTION***
        
        System.out.println("p1 "+ p1.getP_id()+p1.getName());
        System.out.println("p2 "+p2.getP_id()+p2.getName());
        System.out.println("lad os se om det virker "+a1.getPerson().getName());
        
        System.out.println("hvad har matti betalt");
        
        TypedQuery<Fee>q1=em.createQuery("SELECT f from Fee f", Fee.class);
        List<Fee>fees=q1.getResultList();
        
        System.out.println("Name, Amount and Date");
        for(Fee f:fees){
            
            System.out.println(f.getPerson().getName()+": "+f.getAmount()+": "+f.getPayDate().toString());
        }
        
    }
}
