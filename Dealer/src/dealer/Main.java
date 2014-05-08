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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
            System.out.println(store.getSpolecnostNazev());
        }

        Query queryC = em.createNamedQuery(Prodejce.findByJmeno);
        queryC.setParameter("jmeno", "Karel Bendikovic");
        List<Prodejce> list = queryC.getResultList();
        System.out.println(list.size());

        // Criteria API
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Prodejce> cq = cb.createQuery(Prodejce.class);
        Root<Prodejce> pet = cq.from(Prodejce.class);
        cq.select(pet);
        TypedQuery<Prodejce> q = em.createQuery(cq);
        List<Prodejce> allPets = q.getResultList();
        System.out.println(allPets.size());

    }
}
