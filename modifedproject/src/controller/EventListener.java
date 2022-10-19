/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.InvoiceHeader;
import Model.HeaderModel;
import Model.InvoiceLines;
import Model.LineModel;

import View.InvoiceFrame;
import View.HeaderFormDialog;
import View.LineFormDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
//
//import java.awt.HeadlessException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.io.FileWriter;



/**
 *
 * @author mariiam
 */
public class EventListener implements ActionListener , ListSelectionListener{

    private final InvoiceFrame frame;
    
    private InvoiceFrame generatorframe;
    //private final DateFormat df ;
    private HeaderFormDialog newInvoiceData;
    private LineFormDialog newItemData;
    
    public EventListener(InvoiceFrame frame){
    this.frame =frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String actionCommand = e.getActionCommand();
    System.out.println("Action : " + actionCommand);
    
        switch (actionCommand) {
            case "":
                
                break;
                 case "load file":
                loadfile();
                break;
                
                 case "save":
                saveFile();
                break;
                
                 case "New Invoice":
                createInvoice();
                break;
                
                 case "Delete Invoice":
                deleteInvoice();
                break;
                
                 case "New Item":
                createItem();
                break;
                case "Delete Item":
                deleteItem();
                break;
                
                case "createInvoiceOK":
                    
                    createInvoiceOK();
                    break;
                case "createInvoiceCancel":
                    createInvoiceCancel();
                    break;
                    
                case "createOK":    
                    createLineOK();
                   
                    break;
                case "createLineCancel":  
                    createLineCancel();
                    break;
            default:
                throw new AssertionError();
        }
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        
        int selectedInvoiceRow =frame.getInvoiceTable().getSelectedRow();
        
        if(selectedInvoiceRow != -1){
          System.out.println("row number "+ selectedInvoiceRow);
          InvoiceHeader selectedInvoice= frame.getInvoices().get(selectedInvoiceRow);
          frame.getSoLabel().setText(""+selectedInvoice.getSonumber());
          frame.getDateLabel().setText(selectedInvoice.getDate());
          frame.getNameLabel().setText(selectedInvoice.getCustomerName());
          frame.getTotalLabel().setText(""+selectedInvoice.getinvoiceCod());
          LineModel linesTableModel= new LineModel(selectedInvoice.getLines());

          frame.getLinesTable().setModel(linesTableModel);
          linesTableModel.fireTableDataChanged(); 
        }
    }
    
    private void loadfile() {
        JFileChooser fileChooser =new JFileChooser() ;
        try {
       int result = fileChooser.showOpenDialog(frame);
         if(result==JFileChooser.APPROVE_OPTION) {
           
             File headerFile=fileChooser.getSelectedFile();
            Path headerPath = Paths.get(headerFile.getAbsolutePath());
            List<String> headerLines = Files.readAllLines(headerPath);
            System.out.println("upload is Done");
            ArrayList<InvoiceHeader> invoices = new ArrayList<>();
            
            headerLines.stream().map((headerLine) -> headerLine.split(",")).map((parts) -> {
                int soNumber = Integer.parseInt(parts[0]);
                String invoiceDate = parts[1];
                String customerName= parts[2];
                InvoiceHeader invoice = new InvoiceHeader(soNumber, invoiceDate, customerName);
               return invoice;
           }).forEachOrdered((invoice) -> {
               invoices.add(invoice);
           });
            System.out.println("check"); 
            result= fileChooser.showOpenDialog(frame);
            if(result==JFileChooser.APPROVE_OPTION){
            File lineFile= fileChooser.getSelectedFile();
            Path linePath = Paths.get(lineFile.getAbsolutePath());
            List<String> lineLines =Files.readAllLines(linePath);
           
            System.out.println("upload is Done");
           
            for(String lineLine : lineLines){
                
                String lineParts [] =lineLine.split(",");
                 int soNumb = Integer.parseInt(lineParts[0]);
                 String itemname= lineParts[1];
                 double itemPrice= Double.parseDouble(lineParts[2]);
                 int quantity = Integer.parseInt(lineParts[3]);
                 
                 InvoiceHeader invo =null;
                 for(InvoiceHeader invoice :invoices){
                    if(invoice.getSonumber()==soNumb){
                        invo= invoice ;
                        break;
                    }
                 }
                 
                 InvoiceLines line = new InvoiceLines( itemname, itemPrice, quantity, invo);
                 
                boolean add;
                add = invo.getLines().add(line);
                 
                
              }
      
            }
             frame.setInvoices(invoices);
             HeaderModel invoicesTableModel = new HeaderModel(invoices);
             frame.setInvoicesTableModel(invoicesTableModel);
             frame.getInvoiceTable().setModel(invoicesTableModel);
             frame.getInvoicesTableModel().fireTableDataChanged();
         }
        } catch(IOException ex){
        }
   }
    
    
    
    
    
   
        private void saveFile() {
            JFileChooser fileChooser = new JFileChooser();
            ArrayList<InvoiceHeader> invoices = frame.getInvoices();
            ArrayList<InvoiceLines> saveLines = null;
           try {
            int result = fileChooser.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fileChooser.getSelectedFile();
                try (FileWriter headerWriter = new FileWriter(headerFile)) {
                    for (InvoiceHeader invoice :invoices ){
                        String invoiceNumber = "" + invoice.getSonumber();
                        String invoiceDate = invoice.getDate();
                        String customerName = invoice.getCustomerName();
                        
                        headerWriter.write(invoiceNumber + "," + invoiceDate + "," + customerName + "\n");
                        headerWriter.flush();
                    }
                }
                result = fileChooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File lineFile = fileChooser.getSelectedFile();
                    try (FileWriter lineWriter = new FileWriter(lineFile)) {
                        for (InvoiceHeader saveInvoice : invoices) {
                            saveLines = saveInvoice.getLines();
                            for (InvoiceLines saveLine : saveLines) {
                                String invoiceNumber = "" + saveLine.getInvoice().getSonumber();
                                String itemName = saveLine.getProduct();
                                String itemPrice = "" + saveLine.getPrice();
                                String count = "" + saveLine.getQty();
                                lineWriter.write(invoiceNumber + "," + itemName + "," + itemPrice + "," + count + "\n");
                                lineWriter.flush();
                            }
                        }
                    }
                }
            }
        } catch (IOException exception) {
        }
        System.out.println("Files Saved Successfully");
      
    }
               
//                 //handling multiple exception
//            } catch (ParseException ex) {
//               JOptionPane.showMessageDialog(generatorframe, "Weong Date Format \n" + ex.getMessage(), "Error!!", JOptionPane.ERROR_MESSAGE);
//            } catch (NumberFormatException ex) {
//                JOptionPane.showMessageDialog(generatorframe, " Wrong Number Format \n" + ex.getMessage(), "Error!!", JOptionPane.ERROR_MESSAGE);
//            } catch (FileNotFoundException ex) {
//                JOptionPane.showMessageDialog(generatorframe, "File/path Not Found\n" + ex.getMessage(), "Error!!", JOptionPane.ERROR_MESSAGE);
//            } catch (IOException ex) {
//                JOptionPane.showMessageDialog(generatorframe, "Reading Error\n" + ex.getMessage(), "Error!!", JOptionPane.ERROR_MESSAGE);
//            }
//   

    private void createInvoice() {
        newInvoiceData = new HeaderFormDialog(frame);
        newInvoiceData.setVisible(true);
        
   }
    
    
        
//    
//    @Override
//    public void valueChanged(ListSelectionEvent e) {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    
//       System.out.println("Invoice Selected!");
//       invRowSelected();
//    
//    
//    }

    private void deleteInvoice() {
        int selectedInvoiceRow = frame.getInvoiceTable().getSelectedRow();
        if(selectedInvoiceRow != -1){
             frame.getInvoices().remove(selectedInvoiceRow);
             for (int i = 0; i < frame.getInvoices().size(); i++) {
                frame.getInvoices().get(i).setNumber(i + 1);
            }
             frame.getInvoicesTableModel().fireTableDataChanged();
        }
    }

    private void createItem() {
        newItemData = new LineFormDialog(frame);
        newItemData.setVisible(true);
   }

    private void deleteItem() {
        int selectedinvoice =frame.getInvoiceTable().getSelectedRow();
        int selectedItemRow= frame.getLinesTable().getSelectedRow();
        if( selectedItemRow != -1){
             LineModel lineTableModel = (LineModel) frame.getLinesTable().getModel();
             lineTableModel.getLines().remove(selectedItemRow);
             lineTableModel.fireTableDataChanged();
             frame.getInvoicesTableModel().fireTableDataChanged();
             

        }
    } 

    private void createInvoiceOK() {
           String date = newInvoiceData.getinvoiceDateField().getText();
           String Customer= newInvoiceData.getcustomerNameField().getText();
           int number = frame.getNextInvoicenumber();
           
           InvoiceHeader invoice = new InvoiceHeader(number,date,Customer);
           frame.getInvoices().add(invoice);
           frame.getInvoicesTableModel().fireTableDataChanged();
           newInvoiceData.setVisible(false);
           newInvoiceData.dispose();
           newInvoiceData = null;
           
    }

    private void createInvoiceCancel() {
        newInvoiceData.setVisible(false);
        newInvoiceData.dispose();
        newInvoiceData =null;
        
    }

    private void createLineCancel() { 
         newItemData.setVisible(false);
         newItemData.dispose();
         newItemData = null;

    }

    private void createLineOK() {
        String itemName = newItemData.getItemNameField().getText();
        String quantityStr = newItemData.getItemQtyField().getText();
        String priceStr = newItemData.getItemPriceField().getText();
        
        int quantity = Integer.parseInt(quantityStr);
        double price =  Double.parseDouble(priceStr);
        
        int selectedInvoice = frame.getInvoiceTable().getSelectedRow();
        
        if(selectedInvoice!=-1){
        InvoiceHeader invoice = frame.getInvoices().get(selectedInvoice);
        
        InvoiceLines line = new InvoiceLines(itemName, price, quantity, invoice);
        invoice.getLines().add(line);
        LineModel linesTableModel = (LineModel) frame.getLinesTable().getModel();
        linesTableModel.fireTableDataChanged();
        frame.getInvoicesTableModel().fireTableDataChanged(); 
        frame.getTotalLabel().setText("" + invoice.getInvoiceTotal());
                
        }
        
        
        newItemData.setVisible(false);
        newItemData.dispose();
        newItemData = null;    }

    
    
}




//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    
//            switch (e.getActionCommand()){
//            
//                case "CreateNewInvoice": displayNewInv();
//                break;
//                case "DeleteInvoice":deleteInv();
//                break;
//                case "LoadFile":LoadFile();
//                break;
//                case "SaveFile": savefile();
//                //contuine;
//                case "CreateNewLine": createline();
//                break;
//                case "DeleteLine": deleteLineBtn();
//                break;
//                case "createInvCancel": createInvCancel();
//                break;
//                case "createInvOK": createInvDone();
//                break;
//                case "createLineCancel":createLineCancel();
//                break;
//                case "createLineOK": createLinedone();
//                break;
//
//        }
//    
//    
//    
//    }