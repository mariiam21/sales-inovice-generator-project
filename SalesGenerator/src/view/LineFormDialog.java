/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;



import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author mariiam
 */

public class LineFormDialog extends JDialog{
    
    
    //variables of the invoice line data
    //text fields
    private final JTextField ItemNameField;
    private final JTextField ItemCountField;
    private final JTextField ItemTPriceField;
    //labels
    private final JLabel ItemNameLbl;
    private final JLabel ItemCountLbl;
    private final JLabel ItemTPriceLbl;
    //buttons
    private final JButton saveButton;
    private final JButton cancelButton;

    //constructor(default)
    public LineFormDialog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //getters
    public JTextField getItemNameField() {
        return ItemNameField;
    }

    public JTextField getItemCountField() {
        return ItemCountField;
    }

    public JTextField getItemTPriceField() {
        return ItemTPriceField;
    }

    public LineFormDialog(InvoiceFrame generator) {
        
        ItemNameField = new JTextField(10);
        ItemNameLbl = new JLabel("Item Name");
        
        ItemCountField = new JTextField(10);
        ItemCountLbl = new JLabel("Item Count");
        
        ItemTPriceField = new JTextField(10);
        ItemTPriceLbl = new JLabel("Item Price");
        
        saveButton = new JButton("Done");
        
        cancelButton = new JButton("Cancel");
        
        saveButton.setActionCommand("creating Line is done");
        cancelButton.setActionCommand("creating Line is Cancelld");
        
        saveButton.addActionListener(generator.getListener());
        cancelButton.addActionListener(generator.getListener());
        setLayout(new GridLayout(4, 2));
        
      
        Component LB1 = add(ItemNameField);
        add(ItemCountLbl);
        add(ItemCountField);
        add(ItemTPriceLbl);
        add(ItemTPriceField);
        Component button1= add(saveButton);
        Component button2 = add(cancelButton);
        
        pack();
    }
    }
    
    
    

