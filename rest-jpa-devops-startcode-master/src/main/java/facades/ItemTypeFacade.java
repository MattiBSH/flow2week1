/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Customer;
import entities.ItemType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author matti
 */
public class ItemTypeFacade {
    
     private static ItemTypeFacade instance;
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    public static ItemTypeFacade getFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new ItemTypeFacade();
        }
        return instance;
    }
    public ItemType addItemType(ItemType i){

     EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(i);
            em.getTransaction().commit();
            return i;
        }finally {
            em.close();
        }}

        

        
    public ItemType findItemType(String name){
         EntityManager em = emf.createEntityManager();
        TypedQuery<ItemType> query = em.createQuery(
        "SELECT i FROM ItemType i WHERE i.name = '" + name + "'",
        ItemType.class);
    return query.getSingleResult();
    }
}
