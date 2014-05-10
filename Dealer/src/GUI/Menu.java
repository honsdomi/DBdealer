/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Dominik
 */
public class Menu extends JPanel{
    
    private JButton reg;
    private JButton sm;

    public Menu() {
        initComponents();
        initActions();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout(10,10));        
        this.setPreferredSize(new Dimension(250,150));
        this.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        reg = new JButton("Registrovat nového zákazníka");
        reg.setPreferredSize(new Dimension(50,50));
        JPanel p1 = new JPanel(new BorderLayout(10,10));
        p1.add(reg);
        sm = new JButton("Vytvořit smlouvu");
        sm.setPreferredSize(new Dimension(50,50));
        JPanel p2 = new JPanel(new BorderLayout(10,10));
        p2.add(sm);
        this.add(p1,BorderLayout.NORTH);
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
