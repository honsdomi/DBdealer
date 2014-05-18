/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dealer;

import GUI.Menu;
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
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author lenka
 */
public class Main {
    public static EntityManagerFactory emf;
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception{
        emf = Persistence.createEntityManagerFactory("DealerPU");
        EntityManager em = emf.createEntityManager();
        
        
        
        /**
         * Aplikaci se zadá název společnosti a adresa pobočky.
         */
        String spolecnost = "AutoDealers";
        String mesto = "Plzen";
        String ulice = "Prazska";
        int CP = 105;
        
        Spolecnost spol = em.find(Spolecnost.class,spolecnost);
        
        Query qu = em.createQuery ("SELECT x FROM Adresa x WHERE x.mesto = ?1 and x.ulice = ?2 and x.cp = ?3");
        qu.setParameter (1, mesto);
        qu.setParameter (2, ulice);
        qu.setParameter(3, CP);
        List<Adresa> results = qu.getResultList ();
        
        Adresa adr = results.get(0);      
        
       
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Pobocka> cq2 = cb.createQuery(Pobocka.class);
        Root<Pobocka> pobo = cq2.from(Pobocka.class);
        cq2.where(cb.equal(pobo.get("adresaId"), adr));
        Query qadr = em.createQuery(cq2);
        List<Pobocka> resadr = qadr.getResultList();
        Pobocka pobocka = resadr.get(0);
        
        
        if(pobocka.getSpolecnostNazev()==spol){
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            JFrame f = new JFrame("Dealer aut");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Menu m = new Menu(spol, pobocka);
            f.add(m);
            f.pack();
            f.setResizable(false);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        }

        Statistiky.getSeznamPobocek("AutoDealers");
        Statistiky.getPobockaProdejce("Karel Bendikovic");
        Statistiky.getSeznamProdejcu();
        Statistiky.getMzdaVyssiNez(40000);
        Statistiky.getMaxMzda();
        
    }
}
