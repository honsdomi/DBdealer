/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import dealer.Adresa;
import dealer.Main;
import dealer.Prodejce;
import dealer.Zakaznik;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.*;

/**
 *
 * @author Dominik
 */
public class RegistraceDialog extends JDialog{
    
    private JTextField jmeno;
    private JTextField mesto;
    private JTextField ulice;
    private JTextField CP;
    private JTextField PSC;
    private JButton ok;
    private JButton cancel;
    private JPanel tlacitka;
    private JPanel reg;
    private JLabel ljmeno;
    private JLabel lmesto;
    private JLabel lulice;
    private JLabel lCP;
    private JLabel lPSC;
    
    

    public RegistraceDialog() {
        super(new JFrame(),"Registrace zákazníka",true);
        initComponents();
        initActions();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        this.setLayout(new BorderLayout(10,10));
        this.setPreferredSize(new Dimension(300,200));
        this.setResizable(false);
        
        reg = new JPanel(new GridLayout(5,2));
        ljmeno = new JLabel("Jméno: ");
        lmesto = new JLabel("Město: ");
        lulice = new JLabel("Ulice: ");
        lCP = new JLabel("Číslo popisné: ");
        lPSC = new JLabel("PSČ: ");
        jmeno = new JTextField();
        mesto = new JTextField();
        ulice = new JTextField();
        CP = new JTextField();
        PSC = new JTextField();
        reg.add(ljmeno);
        reg.add(jmeno);
        reg.add(lmesto);
        reg.add(mesto);
        reg.add(lulice);
        reg.add(ulice);
        reg.add(lCP);
        reg.add(CP);
        reg.add(lPSC);
        reg.add(PSC);
        this.add(reg,BorderLayout.NORTH);
        
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

            public void actionPerformed(ActionEvent e) {
                try{
                String j = jmeno.getText();
                String m = mesto.getText();
                String u = ulice.getText();
                int c = Integer.parseInt(CP.getText());
                int p = Integer.parseInt(PSC.getText());
                Adresa a = new Adresa(m,u,c,p);
                EntityManager em = Main.emf.createEntityManager();
                em.getTransaction().begin();
                em.persist(a);
                Zakaznik z = new Zakaznik(j,a);
                em.persist(z);
                em.getTransaction().commit();
                dispose();
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(reg,"Neplatné zadání","Pozor",JOptionPane.WARNING_MESSAGE);
                }
            }
            
        });
        
    }
    
    
    
}
