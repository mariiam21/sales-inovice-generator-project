/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JMenuItem;
//import javax.swing.JTable;
//import javax.swing.JTextField;

import controller.EventListener;
import Model.InvoiceHeader;
import Model.HeaderModel;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author mariiam
 */
public class InvoiceFrame extends javax.swing.JFrame {

    
    public InvoiceFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        InvoiceTable = new javax.swing.JTable();
        InvoiceTable.getSelectionModel().addListSelectionListener(controller);
        createInvoiceButton = new javax.swing.JButton();
        createInvoiceButton.addActionListener(controller);
        deleteInvoiceButton = new javax.swing.JButton();
        deleteInvoiceButton.addActionListener(controller);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        soLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        linesTable = new javax.swing.JTable();
        createItemButton = new javax.swing.JButton();
        createItemButton.addActionListener(controller);
        deleteItemButton = new javax.swing.JButton();
        deleteItemButton.addActionListener(controller);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        LoadFileMenuItem = new javax.swing.JMenuItem();
        LoadFileMenuItem.addActionListener(controller);
        SaveFileMenuItem = new javax.swing.JMenuItem();
        SaveFileMenuItem.addActionListener(controller);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        InvoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(InvoiceTable);

        createInvoiceButton.setText("New Invoice");
        createInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createInvoiceButtonActionPerformed(evt);
            }
        });

        deleteInvoiceButton.setText("Delete Invoice");

        jLabel1.setText("Invoice Number");

        jLabel2.setText("Date");

        jLabel3.setText("Customer Name");

        jLabel4.setText("Total");

        linesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(linesTable);

        createItemButton.setText("create New Item");
        createItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createItemButtonActionPerformed(evt);
            }
        });

        deleteItemButton.setText("Delete Item");

        jMenu1.setText("File");

        LoadFileMenuItem.setText("load file");
        jMenu1.add(LoadFileMenuItem);

        SaveFileMenuItem.setText("save file");
        jMenu1.add(SaveFileMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(createInvoiceButton)
                        .addGap(46, 46, 46)
                        .addComponent(deleteInvoiceButton)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(totalLabel))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nameLabel))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateLabel))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(49, 49, 49)
                                    .addComponent(soLabel)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(createItemButton)
                        .addGap(60, 60, 60)
                        .addComponent(deleteItemButton)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(soLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(dateLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(totalLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(createItemButton)
                        .addComponent(deleteItemButton))
                    .addComponent(deleteInvoiceButton)
                    .addComponent(createInvoiceButton))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createInvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createInvoiceButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createInvoiceButtonActionPerformed

    private void createItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createItemButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createItemButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new InvoiceFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable InvoiceTable;
    private javax.swing.JMenuItem LoadFileMenuItem;
    private javax.swing.JMenuItem SaveFileMenuItem;
    private javax.swing.JButton createInvoiceButton;
    private javax.swing.JButton createItemButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton deleteInvoiceButton;
    private javax.swing.JButton deleteItemButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable linesTable;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel soLabel;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
  
    
    
   private ArrayList<InvoiceHeader> invoices;
  private final EventListener controller= new EventListener(this);
  private HeaderModel invoicesTableModel;
  
    public ArrayList<InvoiceHeader> getInvoices() {
        return invoices;
    }

    public void setInvoices(ArrayList<InvoiceHeader> invoices) {
        this.invoices = invoices;
    }

    public HeaderModel getInvoicesTableModel() {
        return invoicesTableModel;
    }

    public void setInvoicesTableModel(HeaderModel invoicesTableModel) {
        this.invoicesTableModel = invoicesTableModel;
    }

    public JTable getInvoiceTable() {
        return InvoiceTable;
    }

    public JLabel getDateLabel() {
        return dateLabel;
    }

    public JTable getLinesTable() {
        return linesTable;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public JLabel getSoLabel() {
        return soLabel;
    }

    public JLabel getTotalLabel() {
        return totalLabel;
    }
   
    public EventListener getController() {
        return controller;
    }
    
    public int getNextInvoicenumber(){
     int number=0 ; 
     
     for (InvoiceHeader invoice : invoices){
             if(invoice.getSonumber()>number) 
             {
                  number=invoice.getSonumber();
             
             }
     }
     return number+1;
    }

    

  
}

//private final List<InvoiceHeader> invArray = new ArrayList<>();
////private HeaderModel HeaderModel;
//private LineModel LineModel;
//private HeaderFormDialog HDialog;
//private LineFormDialog LDialog;
//
//private final EventListener listener =new EventListener(this);
//private final DateFormat df= new SimpleDateFormat("dd/MM/yyyy");
//
////setters and getters for private variables (so it can be used in another classes)
//    public EventListener getListener() {
//        return listener;
//    }
//    public void setInvLineTable(JTable invLineTable) {
//        this.invLineTable = invLineTable;
//    }
//
//    public void setInvHeaderTableModel(HeaderModel HeaderModel) {
//        this.HeaderModel = HeaderModel;
//    }
//
//    public JLabel getInvNumLbl() {
//        return invNumLbl;
//    }
//
//    public JButton getCreateInvBtn() {
//        return createInvBtn;
//    }
//
//    public JButton getCreateLineBtn() {
//        return createLineBtn;
//    }
//
//    public JTextField getCustNameTF() {
//        return custNameTF;
//    }
//
//    public JButton getDeleteInvBtn() {
//        return deleteInvBtn;
//    }
//
//    public JButton getDeleteLineBtn() {
//        return deleteLineBtn;
//    }
//
//    public JTextField getInvDateTF() {
//        return invDateTF;
//    }
//
//    public JTable getInvLineTable() {
//        return invLineTable;
//    }
//
//    public JLabel getInvTotalLbl() {
//        return invTotalLbl;
//    }
//
//    public JTable getInvoicesTable() {
//        return invoicesTable;
//    }
//
//    public JMenuItem getLoadMenuItem() {
//        return loadMenuItem;
//    }
//
//    public JMenuItem getSaveMenuItem() {
//        return saveMenuItem;
//    }
//
// 
//
//    public List<InvoiceHeader> getInvoicesArray() {
//        return invArray;
//    }
//
//    public HeaderModel getHeaderModel() {
//        return HeaderModel;
//    }
//
//    public LineModel getLineModel() {
//        return LineModel;
//    }
//
//    public HeaderFormDialog getHeaderDialog() {
//        return HDialog;
//    }
//
//    public LineFormDialog getLineDialog() {
//        return LDialog;
//    }
//
//    public void setInvLineTableModel(LineModel LineModel) {
//        this.LineModel = LineModel;
//    }
//
//    public void setHeaderDialog(HeaderFormDialog headerDialog) {
//        this.HDialog = HDialog;
//    }
//
//    public void setLineDialog(LineFormDialog LDialog) {
//        this.LDialog = LDialog;
//    }
//
//
//
//}