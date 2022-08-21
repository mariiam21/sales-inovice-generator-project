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
public class HeaderFormDialog extends JDialog {
    
    //variables of the invoice header data
    //text fields
    private JTextField CustNameField;
    private JTextField InvoiceDateField;
    //labels
    private JLabel CustNameLbl;
    private JLabel InvoiceDateLbl;
    //buttons
    private JButton saveButton;
    private JButton cancelButton;

    //constructor (default)
    public HeaderFormDialog() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //getters
     public JTextField getCustNameField() {
        return CustNameField;
    }

    public JTextField getInvDateField() {
        return InvoiceDateField;
    }
    
    
    
    //constructor
    public HeaderFormDialog(InvoiceFrame generator) {

        //initilization
        CustNameLbl = new JLabel("Customer Name:");
        CustNameField = new JTextField(10);
        
        InvoiceDateLbl = new JLabel("Invoice Date:");
        InvoiceDateField = new JTextField(10);
        
       saveButton = new JButton("Save");
        
        cancelButton = new JButton("Cancel");
 
        saveButton.setActionCommand("Creating Invoice is done");
        cancelButton.setActionCommand("Creating Invoice is Cancelled");
        saveButton.addActionListener(generator.getListener());
        cancelButton.addActionListener(generator.getListener());
        setLayout(new GridLayout(3, 2));
        
        Component label1 = add(InvoiceDateLbl);
        Component DataField = add(InvoiceDateField);
        Component label2 = add(CustNameLbl);
        add(CustNameField);
        Component button1 = add(saveButton);
        Component button2 = add(cancelButton);
        
        pack();
        
    }

   
}
    

