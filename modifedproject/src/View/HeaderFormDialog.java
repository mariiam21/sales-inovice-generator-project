/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

//import Model.InvoiceHeader;
//import java.util.ArrayList;
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
    private final JTextField customerNameField;
    private final JTextField invoiceDateField;
    //lables
    private final JLabel customerNameLabel;
    private final JLabel invoiceDateLabel;
    //button
    private final JButton okButton;
    private final JButton cancelButton;    
    
    //constructor
     public HeaderFormDialog(InvoiceFrame frame) {
        customerNameLabel = new JLabel("Customer Name:");
        customerNameField = new JTextField(20);
        invoiceDateLabel = new JLabel("Invoice Date:");
        invoiceDateField = new JTextField(20);
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        okButton.setActionCommand("createInvoiceOK");
        cancelButton.setActionCommand("createInvoiceCancel");
        
        okButton.addActionListener(frame.getController());
        cancelButton.addActionListener(frame.getController());
        setLayout(new GridLayout(3, 2));
        
        Component add = add(invoiceDateLabel);
        Component add1 = add(invoiceDateField);
        Component add2 = add(customerNameLabel);
        add(customerNameField);
        add(okButton);
        add(cancelButton);
        
        pack();
        
    }
     
      //constructor (default)
//    public HeaderFormDialog() {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
public JTextField getcustomerNameField() {
        return customerNameField;
    }

    public JTextField getinvoiceDateField() {
        return invoiceDateField;
    }
}
