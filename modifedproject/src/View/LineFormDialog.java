/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
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
    private final JTextField itemNameField;
    private final JTextField itemQtyField;
    private final JTextField itemPriceField;
     //labels
    private final JLabel itemNameLabel;
    private final JLabel itemCountLabel;
    private final JLabel itemPriceLabel;
      //buttons
    private final JButton okButton;
    private final JButton cancelButton;
    
    
    //constructor(default)
//    public LineFormDialog() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

      public LineFormDialog(InvoiceFrame frame) {
        itemNameField = new JTextField(20);
        itemNameLabel = new JLabel("Item Name");
        
        itemQtyField = new JTextField(20);
        itemCountLabel = new JLabel("Item Count");
        
        itemPriceField = new JTextField(20);
        itemPriceLabel = new JLabel("Item Price");
        
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        
        okButton.setActionCommand("createOK");
        cancelButton.setActionCommand("createLineCancel");
        
        okButton.addActionListener(frame.getController());
        cancelButton.addActionListener(frame.getController());
        setLayout(new GridLayout(4, 2));
        
        add(itemNameLabel);
        add(itemNameField);
        add(itemCountLabel);
        Component add = add(itemQtyField);
        Component add1 = add(itemPriceLabel);
        add(itemPriceField);
        add(okButton);
        add(cancelButton);
        
        pack();
    }

    public JTextField getItemNameField() {
        return itemNameField;
    }

    public JTextField getItemQtyField() {
        return itemQtyField;
    }

    public JTextField getItemPriceField() {
        return itemPriceField;
    }
    
}
