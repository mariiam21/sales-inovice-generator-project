
package invoicegenerator;

import java.awt.HeadlessException;
import model.InvoiceHeader;
import model.InvoiceLine;
import model.HeaderModel;
import model.LineModel;
import view.HeaderFormDialog;
import view.LineFormDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author mariiam
 */
public class TheForm extends javax.swing.JFrame implements ActionListener, ListSelectionListener  {

    /**
     * Creates new form InvoiceFrame
     */
    public TheForm() {
        this.invArray = new ArrayList<>();
        initComponents();
    }

    private TheForm(int invNum, String custName, Date invDate) {
        this.invArray = new ArrayList<>();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        invoicesTable = new javax.swing.JTable();
        invoicesTable.getSelectionModel().addListSelectionListener(this);
        createInvBtn = new javax.swing.JButton();
        createInvBtn.addActionListener(this);
        deleteInvBtn = new javax.swing.JButton();
        deleteInvBtn.addActionListener(this);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        custNameTF = new javax.swing.JTextField();
        invDateTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        invTotalLbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        invLineTable = new javax.swing.JTable();
        createLineBtn = new javax.swing.JButton();
        createLineBtn.addActionListener(this);
        deleteLineBtn = new javax.swing.JButton();
        deleteLineBtn.addActionListener(this);
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();
        loadMenuItem.addActionListener(this);
        saveMenuItem = new javax.swing.JMenuItem();
        saveMenuItem.addActionListener(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invoicesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(invoicesTable);
        invoicesTable.getAccessibleContext().setAccessibleName("");

        createInvBtn.setText("Create New Invoice");
        createInvBtn.setActionCommand("CreateNewInvoice");
        createInvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createInvBtnActionPerformed(evt);
            }
        });

        deleteInvBtn.setText("Delete Invoice");
        deleteInvBtn.setActionCommand("DeleteInvoice");
        deleteInvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteInvBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Invoice Number");

        jLabel2.setText("Invoice Date");

        jLabel3.setText("Customer Name");

        jLabel4.setText("Invoice Total");

        custNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custNameTFActionPerformed(evt);
            }
        });

        invDateTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invDateTFActionPerformed(evt);
            }
        });

        invLineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(invLineTable);

        createLineBtn.setText("Create New Line");
        createLineBtn.setActionCommand("CreateNewLine");
        createLineBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createLineBtnActionPerformed(evt);
            }
        });

        deleteLineBtn.setActionCommand("DeleteLine");
        deleteLineBtn.setLabel("Delete Line");
        deleteLineBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteLineBtnActionPerformed(evt);
            }
        });

        jLabel6.setText("Invoices Table");

        jMenu1.setText("File");

        loadMenuItem.setText("Load File");
        loadMenuItem.setActionCommand("LoadFile");
        jMenu1.add(loadMenuItem);

        saveMenuItem.setText("Save File");
        saveMenuItem.setActionCommand("SaveFile");
        jMenu1.add(saveMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(createInvBtn)
                        .addGap(68, 68, 68)
                        .addComponent(deleteInvBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(invTotalLbl)
                                    .addComponent(invDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(custNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(createLineBtn)
                        .addGap(98, 98, 98)
                        .addComponent(deleteLineBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(invDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(custNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(invTotalLbl))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createLineBtn)
                            .addComponent(deleteLineBtn)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createInvBtn)
                    .addComponent(deleteInvBtn))
                .addGap(104, 104, 104))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void custNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custNameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_custNameTFActionPerformed

    private void createLineBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createLineBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createLineBtnActionPerformed

    private void deleteLineBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteLineBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteLineBtnActionPerformed

    private void invDateTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invDateTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_invDateTFActionPerformed

    private void createInvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createInvBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createInvBtnActionPerformed

    private void deleteInvBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteInvBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteInvBtnActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TheForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TheForm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createInvBtn;
    private javax.swing.JButton createLineBtn;
    private javax.swing.JTextField custNameTF;
    private javax.swing.JButton deleteInvBtn;
    private javax.swing.JButton deleteLineBtn;
    private javax.swing.JTextField invDateTF;
    private javax.swing.JTable invLineTable;
    private javax.swing.JLabel invTotalLbl;
    private javax.swing.JTable invoicesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

    
private final DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
private final List<InvoiceHeader> invArray;
private HeaderModel invHeaderTableModel;
private LineModel invLineTableModel;
private HeaderFormDialog HDialog;
private LineFormDialog LDialog;



    @Override
    public void actionPerformed(ActionEvent e) {
switch (e.getActionCommand()){
    
                    case "Create New Invoice": Createinvoice();
                    break;
                    case "Delete Invoice":deleteInvoice();
                    break;
                    case "Create New Line": CreateLine();
                    break;
                    case "Delete Line": deleteLine();
                    break;
                    case "Load File": LoadFile();
                    break;
                    case "Save File": SaveFile();
                    break;
                    case "create Invoice Cancel": createInvoiceCancel();
                    break;
                    case "create Invoice done": createInvoicedone();
                    break;
                    case "create Line Cancel":createLineCancel();
                    break;
                    case "create Line done": createLinedone();
                    break;       
                            

}
    }
       
    private void LoadFile() {
        JOptionPane.showMessageDialog(this, "Please, select header file!", "Attention", JOptionPane.WARNING_MESSAGE);
        JFileChooser openFile = new JFileChooser();
        int result = openFile.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = openFile.getSelectedFile();
            try{
            FileReader headerFr = new FileReader(headerFile);
            BufferedReader headerBr = new BufferedReader (headerFr);
            String headerLine ;
            
            while (( headerLine = headerBr.readLine()) != null) {
            String[] headerParts = headerLine.split(",");
            String invNumStr = headerParts[0];
            String invDateStr = headerParts[1];
            String custName = headerParts[2];
 
            int invNum = Integer.parseInt(invNumStr);
            Date invDate = df.parse(invDateStr);
            
            InvoiceHeader inv;
            inv = new InvoiceHeader(invNum, custName,invDate );
            invArray.add(inv);
            
            }
            
            JOptionPane.showMessageDialog(this, "Please, select lines file!", "Attention", JOptionPane.WARNING_MESSAGE);
                result = openFile.showOpenDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File linesFile = openFile.getSelectedFile();
                    BufferedReader linesBr= new BufferedReader(new FileReader(linesFile));
                    String linesLine ;
                    while ((linesLine = linesBr.readLine()) !=null) {
                        String[] lineParts = linesLine.split(",");
                        String invNumStr = lineParts[0];
                        String itemName = lineParts[1];
                        String itemPriceStr = lineParts[2];
                        String itemCountStr = lineParts[3];
                 int invNum = Integer.parseInt(invNumStr);
   double itemPrice = Double.parseDouble(itemPriceStr);
   int itemCount = Integer.parseInt(itemCountStr);
   InvoiceHeader header = findInvoiceByNum(invNum);
   InvoiceLine invLine = new InvoiceLine(itemName, itemPrice, itemCount, header);
                  header.getInovicelines().add(invLine);
                    }
 invHeaderTableModel = new HeaderModel(invArray);
 invoicesTable.setModel(invHeaderTableModel);
 invoicesTable.validate();

                }
                
            } catch (HeadlessException | IOException | NumberFormatException | ParseException ex){
            }
                     
        }

     displayInvoices();
    }

    private void SaveFile() {
        
        String headers = "";
        String lines = "";
        
        for (InvoiceHeader header : invArray) {
            headers += header.getCSV();
            headers += "\n";
            lines = header.getInovicelines().stream().map((line) -> line.getCSV()).reduce(lines, String::concat);
        }
        JOptionPane.showMessageDialog(this, "Please, select file to save header data!", "Attention", JOptionPane.WARNING_MESSAGE);
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = fileChooser.getSelectedFile();
            try {
                try (FileWriter hFW = new FileWriter(headerFile)) {
                    hFW.write(headers);
                    hFW.flush();
                }

                JOptionPane.showMessageDialog(this, "Please, select file to save lines data!", "Attention", JOptionPane.WARNING_MESSAGE);
                result = fileChooser.showSaveDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File linesFile = fileChooser.getSelectedFile();
                    try (FileWriter lFW = new FileWriter(linesFile)) {
                        lFW.write(lines);
                        lFW.flush();
                    }
                }
                                           JOptionPane.showMessageDialog(null, "File Saved Successfully ! ");

            } catch (HeadlessException | IOException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
    
    private InvoiceHeader findInvoiceByNum(int invNum){
    InvoiceHeader header = null;
    for(InvoiceHeader inv : invArray) {
        if (invNum == inv.getInvoiceNum()){
            header = inv;
            break;
        }
    }
    return header ;
}

    @Override
    public void valueChanged(ListSelectionEvent e) {
                    invoicesTableRowSelected();
    }

    private void invoicesTableRowSelected() {
                    int selectedRowIndex = invoicesTable.getSelectedRow();
                    if (selectedRowIndex >= 0){
                        InvoiceHeader row = invHeaderTableModel.getInvDataa().get(selectedRowIndex);
                        custNameTF.setText(row.getCustomername());
                        invDateTF.setText(df.format(row.getInvoiceDate()));
                        jLabel1.setText("" + row.getInvoiceNum());
                        invTotalLbl.setText("" + row.getInvTotalPrice());
                        ArrayList<InvoiceLine> lines = row.getInovicelines();
                        invLineTableModel = new LineModel(lines);
                        invLineTable.setModel(invLineTableModel);
                        invLineTableModel.fireTableDataChanged();
    
}
    }
 private void deleteInvoice() {
        int invIndex = invoicesTable.getSelectedRow();
        InvoiceHeader header = invHeaderTableModel.getInvDataa().get(invIndex);
        invHeaderTableModel.getInvDataa().remove(invIndex);
     
        invLineTableModel = new LineModel(new ArrayList<>());
        invLineTable.setModel(invLineTableModel);
      
        custNameTF.setText("");
        invDateTF.setText("");
        jLabel3.setText("");
        invTotalLbl.setText("");
        displayInvoices();
        JOptionPane.showMessageDialog(null, "Invoice Deleted Successfully ;)! ");
 

     }  

   
    private void deleteLine() {
       
           
        int lineIndex = invLineTable.getSelectedRow();
        InvoiceLine line = invLineTableModel.getInvoiceLines().get(lineIndex);
        invLineTableModel.getInvoiceLines().remove(lineIndex);  
        invTotalLbl.setText("" + line.getHeader().getInvTotalPrice());
        JOptionPane.showMessageDialog(null, "Line Deleted Successfully ! ");
        displayInvoices();
        }      
      
       
       
     
     private void displayInvoices(){
         invArray.forEach((header) -> {
             System.out.println(header);
        });
     }
     
      private int getNxtInvNumber() {
        int index = 0;
        for(InvoiceHeader header : invArray) {
            if (header.getInvoiceNum()> index) {
                index = header.getInvoiceNum();
                
            }
        }
        return index + 1;
    }
      
        private void Createinvoice() {
        HDialog  = new HeaderFormDialog();
        HDialog.setVisible(true);

            }
          private void CreateLine() {
        LDialog = new LineFormDialog();
        LDialog.setVisible(true);

            }
    
    private void createInvoiceCancel() {
HDialog.setVisible(false);

    }

    private void createInvoicedone() {
String custName = HDialog.getCustNameField().getText();
String invDateStr = HDialog.getInvDateField().getText();
HDialog.setVisible(false);

try {
    Date invDate = df.parse(invDateStr);
    int invNum;
    invNum = getNxtInvNumber();
    InvoiceHeader invoiceFrame1 = new InvoiceHeader(invNum, custName, invDate);
    invArray.add(invoiceFrame1);
   
} catch(ParseException ex) {
  displayInvoices();
}
    }
    
   

    private void createLineCancel() {
                    LDialog.setVisible(false);
                  
                    
    }

    private void createLinedone() {
                String itemName = LDialog.getItemNameField().getText();
                String itemCountStr = LDialog.getItemCountField().getText();
                String itemPriceStr = LDialog.getItemTPriceField().getText();
                LDialog.setVisible(false);
                
                int itemCount = Integer.parseInt(itemCountStr);
                double itemPrice = Double.parseDouble(itemPriceStr);
                int headerIndex = invoicesTable.getSelectedRow();
                InvoiceHeader invoice = invHeaderTableModel.getInvDataa().get(headerIndex); 
                InvoiceLine invoiceLine = new InvoiceLine(itemName, itemPrice, itemCount, invoice);
                invoice.addLine(invoiceLine);
                invLineTableModel.fireTableDataChanged();
                invHeaderTableModel.fireTableDataChanged();
                invTotalLbl.setText("" + invoice.getInvTotalPrice());                      
                displayInvoices();   
    }

  
    
}