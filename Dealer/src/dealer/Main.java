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
import javax.persistence.criteria.Subquery;
import org.eclipse.persistence.jpa.JpaEntityManager;
import org.eclipse.persistence.sessions.Session;

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
        System.out.println("pocet zamestnancu: " + allPets.size());
        for (Prodejce p : allPets) {
            System.out.println(p.getJmeno());
        }

        cq = cb.createQuery(Prodejce.class);
        Root e = cq.from(Prodejce.class);
        cq.where(cb.greaterThan(e.get("mzda"), 40000));
        Query query = em.createQuery(cq);
        List<Prodejce> result = query.getResultList();
        System.out.println("");
        System.out.println("Mzda vyssi nez 40 tisic");
        for (Prodejce p : result) {
            System.out.println(p.getJmeno() + " mzda: " + p.getMzda());
        }

        cq = cb.createQuery(Prodejce.class);
        Root employee = cq.from(Prodejce.class);
        cq.select(cb.max(employee.get("mzda")));
        Query query2 = em.createQuery(cq);
        List<Integer> result2 = query2.getResultList();

        cq = cb.createQuery(Prodejce.class);
        e = cq.from(Prodejce.class);
        cq.where(cb.equal(e.get("mzda"), result2.get(0)));
        Query query3 = em.createQuery(cq);
        List<Prodejce> maxMzda = query3.getResultList();
        System.out.println("\nNejvyssi mzda v podniku");
        for (Prodejce p : maxMzda) {
            System.out.println(p.getJmeno() + " mzda: " + p.getMzda());
        }
        
    }
}
