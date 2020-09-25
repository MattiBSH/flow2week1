/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import utils.EMF_Creator;
/**
 *
 * @author matti
 */
public class CustomerFacade {
    private static CustomerFacade instance;
    private static EntityManagerFactory emf;
    private static EntityManager em;
 
    public static CustomerFacade getFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }
    
public Customer addCustomer(Customer c){
        
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            return c;
        }finally {
            em.close();
        }}

        public List<Customer>list(){
            EntityManager em = emf.createEntityManager();
                try{
                    TypedQuery<Customer>query=em.createQuery("SELECT c from Customer c",Customer.class);
                    return query.getResultList();
                }finally{
                    em.close();
                }

        }
    public Customer findCustomer(String id){
         EntityManager em = emf.createEntityManager();
        try{
            Customer cus = em.find(Customer.class,id);
            return cus;
        }finally {
            em.close();
        }}

    
    
     
    
}
