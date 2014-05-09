/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    
    

    public RegistraceDialog() {
        super(new JFrame(),"Registrace zákazníka",true);
        initComponents();
        //initActions();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        this.setLayout(new BorderLayout(10,10));
        this.setPreferredSize(new Dimension(200,210));
        this.setResizable(false);
        
        reg = new JPanel(new GridLayout(5,1));
        jmeno = new JTextField("jmeno");
        mesto = new JTextField("mesto");
        ulice = new JTextField("ulice");
        CP = new JTextField("CP");
        PSC = new JTextField("PSC");
        reg.add(jmeno);
        reg.add(mesto);
        reg.add(ulice);
        reg.add(CP);
        reg.add(PSC);
        this.add(reg,BorderLayout.NORTH);
        
        tlacitka= new JPanel(new FlowLayout());
        ok=new JButton("OK");
        ok.setEnabled(false);
        cancel=new JButton("CANCEL");
        cancel.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        
        tlacitka.add(ok);
        tlacitka.add(cancel);
        this.add(tlacitka,BorderLayout.SOUTH);
    }

    private void initActions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
