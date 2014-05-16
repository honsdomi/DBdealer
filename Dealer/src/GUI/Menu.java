/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import dealer.Pobocka;
import dealer.Spolecnost;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Dominik
 */
public class Menu extends JPanel{
    private static Spolecnost sp;
    private static Pobocka po;
    private JLabel spol;
    private JLabel pob;
    private JButton reg;
    private JButton sm;

    public Menu(Spolecnost s, Pobocka p) {
        sp = s;
        po = p;
        initComponents();
        initActions();
    }

    public static Spolecnost getSp() {
        return sp;
    }

    public static Pobocka getPo() {
        return po;
    }
    
    private void initComponents() {
        this.setLayout(new BorderLayout(10,10));        
        this.setPreferredSize(new Dimension(250,180));
        this.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        
        spol = new JLabel("Společnost: "+sp.getNazev());
        pob = new JLabel("Pobočka: "+po.getAdresaId().getMesto()+" "+po.getAdresaId().getUlice()+" "+po.getAdresaId().getCp());
        JPanel p3 = new JPanel(new BorderLayout(10,10));
        p3.add(spol,BorderLayout.NORTH);
        p3.add(pob,BorderLayout.SOUTH);
        reg = new JButton("Registrovat nového zákazníka");
        reg.setPreferredSize(new Dimension(50,50));
        JPanel p1 = new JPanel(new BorderLayout(10,10));
        p1.add(reg);
        sm = new JButton("Vytvořit smlouvu");
        sm.setPreferredSize(new Dimension(50,50));
        JPanel p2 = new JPanel(new BorderLayout(10,10));
        p2.add(sm);
        this.add(p3,BorderLayout.NORTH);
        this.add(p1,BorderLayout.CENTER);
        this.add(p2,BorderLayout.SOUTH);
    }

    private void initActions() {
        reg.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                RegistraceDialog r = new RegistraceDialog();
            }
            
        });
        sm.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                SmlouvaDialog s = new SmlouvaDialog();
            }
            
        });
        
    }
    
    
    
}
