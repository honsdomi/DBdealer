/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dealer;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author lenka
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DealerPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery queryS = em.createQuery("Select s from Pobocka s", Pobocka.class);
        List<Pobocka> listS = queryS.getResultList();

        for (Iterator<Pobocka> itS = listS.iterator(); itS.hasNext();) {
            Pobocka store = itS.next();
            System.out.println(store);
        }
        
        Query queryC = em.createNamedQuery(Prodejce.findByJmeno);
        queryC.setParameter("jmeno", "Karel Karlov");
        List<Prodejce> list = queryC.getResultList();
        System.out.println(list.size());

    }
}
