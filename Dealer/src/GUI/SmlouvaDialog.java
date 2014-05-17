/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import dealer.Adresa;
import dealer.DoplnkovaVybava;
import dealer.DoplnkovaVybavaHasRezervace;
import dealer.Main;
import dealer.Pobocka;
import dealer.Prodejce;
import dealer.Rezervace;
import dealer.Smlouva;
import dealer.Zakaznik;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Dominik
 */
public class SmlouvaDialog extends JDialog{
    private JLabel za;
    private JLabel pr;
    private JLabel da;
    private JComboBox cza;
    private JComboBox cpr;
    private JTextField t;
    private JButton ok;
    private JButton cancel;
    private JPanel tlacitka;
    private JLabel zn;
    private JTextField tzn;
    private JLabel mo;
    private JTextField tmo;
    private JLabel ba;
    private JTextField tba;
    private JLabel ro;
    private JTextField tro;
    private JLabel dv;
    private JComboBox cdv;
    private JLabel pdv;
    private JTextField tpdv;
    private JLabel ce;
    private JTextField tce;
    
    
    public SmlouvaDialog() {
        super(new JFrame(),"Smlouva",true);
        initComponents();
        initActions();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        this.setLayout(new BorderLayout(10,10));
        this.setPreferredSize(new Dimension(350,350));
        this.setResizable(false);
        
        JPanel p = new JPanel(new GridLayout(10,2));
        za = new JLabel("Zákazník: ");
        p.add(za);
        cza = new JComboBox(getZakazniky());
        cza.setSelectedItem(null);
        p.add(cza);
        pr = new JLabel("Prodejce: ");
        p.add(pr);
        cpr = new JComboBox(getProdejce());
        cpr.setSelectedItem(null);
        p.add(cpr);
        da = new JLabel("Datum splatnosti: ");
        p.add(da);
        t = new JTextField("YYYY-MM-DD");
        p.add(t);
        zn = new JLabel("Značka: ");
        p.add(zn);
        tzn = new JTextField();
        p.add(tzn);
        mo = new JLabel("Model: ");
        p.add(mo);
        tmo = new JTextField();
        p.add(tmo);
        ba = new JLabel("Barva: ");
        p.add(ba);
        tba = new JTextField();
        p.add(tba);
        ro = new JLabel("Rok výroby: ");
        p.add(ro);
        tro = new JTextField();
        p.add(tro);
        ce = new JLabel("Cena: ");
        p.add(ce);
        tce = new JTextField();
        p.add(tce);
        dv = new JLabel("Doplňková výbava: ");
        p.add(dv);
        cdv = new JComboBox(getDoplnky());
        cdv.setSelectedItem(null);
        p.add(cdv);
        pdv = new JLabel("Počet kusů : ");
        p.add(pdv);
        tpdv = new JTextField();
        p.add(tpdv);
        this.add(p,BorderLayout.NORTH);
        
        
        tlacitka= new JPanel(new FlowLayout());
        ok=new JButton("OK");
        cancel=new JButton("CANCEL");
        tlacitka.add(ok);
        tlacitka.add(cancel);
        this.add(tlacitka,BorderLayout.SOUTH);
    }

    private void initActions() {
        cancel.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        ok.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{
                
                    String zna = (tzn.getText().equals("") ? null : tzn.getText());
                    String mod = (tmo.getText().equals("") ? null : tmo.getText());
                    String bar = (tba.getText().equals("") ? null : tba.getText());
                    short rok = (short)Integer.parseInt(tro.getText());
                    Rezervace reze = new Rezervace(zna, mod, bar, rok);
                    EntityManager em = Main.emf.createEntityManager();
                    em.getTransaction().begin();
                    em.persist(reze);

                    String dop = (String)cdv.getSelectedItem();
                    if(dop != null){
                        Query queryC = em.createNamedQuery(DoplnkovaVybava.findByNazev);
                        queryC.setParameter("nazev", dop);
                        List<DoplnkovaVybava> list = queryC.getResultList();
                        DoplnkovaVybava dopl = list.get(0);
                        int pocet = Integer.parseInt(tpdv.getText());
                        DoplnkovaVybavaHasRezervace dvhr = new DoplnkovaVybavaHasRezervace(pocet,reze,dopl);
                        em.persist(dvhr);
                    }
                    



                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        Date date = df.parse(t.getText());
                        String z = (String)cza.getSelectedItem();
                        String p = (String)cpr.getSelectedItem();
                        if(z==null || p==null){
                            throw new IOException();
                        }

                        Query queryZ = em.createNamedQuery(Zakaznik.findByJmeno);
                        queryZ.setParameter("jmeno", z);
                        List<Zakaznik> list2 = queryZ.getResultList();
                        Zakaznik zaka = list2.get(0);

                        Query queryP = em.createNamedQuery(Prodejce.findByJmeno);
                        queryP.setParameter("jmeno", p);
                        List<Prodejce> list3 = queryP.getResultList();
                        Prodejce prod = list3.get(0);

                        int cen = Integer.parseInt(tce.getText());

                        Smlouva s = new Smlouva(date,false,zaka,reze,prod,cen);
                        em.persist(s);
                        em.getTransaction().commit();
                        dispose();

                    }catch(PersistenceException ex){ 
                        JOptionPane.showMessageDialog(null,"Neplatné zadání","Pozor",JOptionPane.WARNING_MESSAGE);
                    }catch (ParseException ex) {
                        JOptionPane.showMessageDialog(null,"Neplatné zadání","Pozor",JOptionPane.WARNING_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null,"Neplatné zadání","Pozor",JOptionPane.WARNING_MESSAGE);
                    }
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Neplatné zadání","Pozor",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
    
    private String[] getZakazniky(){
        EntityManager em = Main.emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Zakaznik> cq = cb.createQuery(Zakaznik.class);
        Root<Zakaznik> z = cq.from(Zakaznik.class);
        cq.select(z);
        TypedQuery<Zakaznik> q = em.createQuery(cq);
        List<Zakaznik> all = q.getResultList();
        String[]ret = new String[all.size()];
        int i=0;
        for (Zakaznik p : all) {
            ret[i] = p.getJmeno();
            i++;
        }
        return ret;
    }
    private String[] getProdejce(){
        EntityManager em = Main.emf.createEntityManager();
        
        Query qu = em.createQuery ("select pr.jmeno from Prodejce pr \n" +
                                    "join pr.pobockaCollection po "+
                                    "where po.id = ?1");
        qu.setParameter (1, Menu.getPo().getId());
        List<String> results = qu.getResultList ();
        String[]ret = results.toArray(new String[results.size()]);
        
        return ret;
    }

    private String[] getDoplnky() {
        EntityManager em = Main.emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DoplnkovaVybava> cq = cb.createQuery(DoplnkovaVybava.class);
        Root<DoplnkovaVybava> z = cq.from(DoplnkovaVybava.class);
        cq.select(z);
        TypedQuery<DoplnkovaVybava> q = em.createQuery(cq);
        List<DoplnkovaVybava> all = q.getResultList();
        String[]ret = new String[all.size()];
        int i=0;
        for (DoplnkovaVybava p : all) {
            ret[i] = p.getNazev();
            i++;
        }
        return ret;
    }
    
}
