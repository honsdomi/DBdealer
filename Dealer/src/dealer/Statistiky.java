/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealer;

import static dealer.Main.emf;
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
 * @author Tom
 */
public class Statistiky {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("DealerPU");
    public static EntityManager em = emf.createEntityManager();
    public static CriteriaBuilder cb = em.getCriteriaBuilder();

    public static void getSeznamPobocek(String spolecnost) {
        Query queryS = em.createNativeQuery("Select * from Pobocka  WHERE spolecnost_nazev = (SELECT nazev from spolecnost WHERE nazev = ?)", Pobocka.class);
        queryS.setParameter(1, spolecnost);
        List<Pobocka> listS = queryS.getResultList();

        for (Iterator<Pobocka> itS = listS.iterator();
                itS.hasNext();) {
            Pobocka store = itS.next();
            System.out.println("ID:" + store.getId() + " tel: " + store.getTelefon());
        }
    }

    public static void getPobockaProdejce(String prodejce) {
        Query queryC = em.createNamedQuery(Prodejce.findByJmeno);

        queryC.setParameter("jmeno", prodejce);
        List<Prodejce> list = queryC.getResultList();
        if (list.size() != 0) {
            for (Prodejce p : list) {
                System.out.println(p.getJmeno() + " pracuje na pobockach: ");
                for (Iterator<Pobocka> it = p.getPobockaCollection().iterator(); it.hasNext();) {
                    System.out.println(it.next().getId());
                }
            }
        }
    }

    public static void getSeznamProdejcu() {

        CriteriaQuery<Prodejce> cq = cb.createQuery(Prodejce.class);
        Root<Prodejce> pet = cq.from(Prodejce.class);

        cq.select(pet);
        TypedQuery<Prodejce> q = em.createQuery(cq);
        List<Prodejce> allPets = q.getResultList();

        System.out.println(
                "pocet zamestnancu: " + allPets.size());
        for (Prodejce p : allPets) {
            System.out.println(p.getJmeno());
        }
    }

    public static void getMzdaVyssiNez(int plat) {
        CriteriaQuery<Prodejce> cq = cb.createQuery(Prodejce.class);
        Root e = cq.from(Prodejce.class);

        cq.where(cb.greaterThan(e.get("mzda"), plat));
        Query query = em.createQuery(cq);
        List<Prodejce> result = query.getResultList();

        System.out.println(
                "");
        System.out.println(
                "Mzda vyssi nez 40 tisic");
        for (Prodejce p : result) {
            System.out.println(p.getJmeno() + " mzda: " + p.getMzda());
        }
    }

    public static void getMaxMzda() {
        CriteriaQuery<Prodejce> cq = cb.createQuery(Prodejce.class);
        Root employee = cq.from(Prodejce.class);

        cq.select(cb.max(employee.get("mzda")));
        Query query2 = em.createQuery(cq);
        List<Integer> result2 = query2.getResultList();

        cq = cb.createQuery(Prodejce.class);
        Root e = cq.from(Prodejce.class);

        cq.where(cb.equal(e.get("mzda"), result2.get(0)));
        Query query3 = em.createQuery(cq);
        List<Prodejce> maxMzda = query3.getResultList();

        System.out.println(
                "\nNejvyssi mzda v podniku");
        for (Prodejce p : maxMzda) {
            System.out.println(p.getJmeno() + " mzda: " + p.getMzda());
        }
    }

}
