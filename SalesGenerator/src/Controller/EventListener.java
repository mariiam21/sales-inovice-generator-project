/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;


import model.InvoiceHeader;
import model.InvoiceLine;
import model.HeaderModel;
import model.LineModel;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import view.InvoiceFrame;
import view.HeaderFormDialog;
import view.LineFormDialog;




/**
 *
 * @author mariiam
 */
public class EventListener implements ListSelectionListener, ActionListener{
    
    
    private InvoiceFrame generatorframe;
    private final DateFormat df ;
 
    //constructor
    public EventListener(InvoiceFrame generatorframe) {
        this.generatorframe = generatorframe;
         this.df= new SimpleDateFormat("dd/MM/yyyy");
    }

    public InvoiceFrame getGeneratorframe() {
        return generatorframe;
    }

    public void setGeneratorframe(InvoiceFrame generatorframe) {
        this.generatorframe = generatorframe;
    }
    
    
    private void displayNewInv() {
      generatorframe.setHeaderDialog(new HeaderFormDialog(generatorframe));
      generatorframe.getHeaderModel().setVisible(true);
        
    }
    
    
    private void displayInvoices(){
           generatorframe.getInvoicesArray().forEach((header) -> {
               System.out.println(header);
        });
       }
    
     private void displayNewInvoiceDialog() {
                    generatorframe.setHeaderDialog(new HeaderFormDialog(generatorframe));
                    generatorframe.getHeaderDialog().setVisible(true);
       
    }
  private void displayNewLineDialog() {
                    generatorframe.setLineDialog(new LineFormDialog(generatorframe));
                    generatorframe.getLineDialog().setVisible(true);

    }

    
    private void deleteInv() {
        int invIndex = generatorframe.getInvoicesTable().getSelectedRow();
        InvoiceHeader header = generatorframe.getHeaderModel().getInvDataa().get(invIndex);
        generatorframe.getHeaderModel().getInvDataa().remove(invIndex);
        generatorframe.getHeaderModel().fireTableDataChanged();
        generatorframe.setInvLineTableModel(new LineModel(new ArrayList<>()));
        generatorframe.getInvLineTable().setModel(generatorframe.getLineModel());
        generatorframe.getLineModel().fireTableDataChanged();
        generatorframe.getCustNameTF().setText("");
        generatorframe.getInvDateTF().setText("");
        generatorframe.getInvNumLbl().setText("");
        generatorframe.getInvTotalLbl().setText("");
        displayInvoices();
        JOptionPane.showMessageDialog(null, "Invoice Deleted Successfully ! ");
 

     } 
    
         private InvoiceHeader findInvoice(int invNum){
                        InvoiceHeader header = null;
                        for(InvoiceHeader inv : generatorframe.getInvoicesArray()) {
                            if (invNum == inv.getInvoiceNum()){
                                header = inv;
                                break;
                            }
                        }
                        return header ;
}  
   private void LoadFile() {
           JOptionPane.showMessageDialog(generatorframe, "Attention:(" ," Select a header file!!!", JOptionPane.WARNING_MESSAGE);
           JFileChooser openFile = new JFileChooser();
           int result = openFile.showOpenDialog(generatorframe);
        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = openFile.getSelectedFile();
            try{
            FileReader headerFr = new FileReader(headerFile);
            BufferedReader headerBr = new BufferedReader (headerFr);
            String headerLine;
            
            while (( headerLine = headerBr.readLine()) != null) {
            String[] headerParts = headerLine.split(",");
            String invNumStr = headerParts[0];
            String invDateStr = headerParts[1];
            String custName = headerParts[2];
 
            int invNum = Integer.parseInt(invNumStr);
            Date invDate = df.parse(invDateStr);
            
            InvoiceHeader inv = new InvoiceHeader(invNum, custName, invDate);
            generatorframe.getInvoicesArray().add(inv);
            
            }
            
            JOptionPane.showMessageDialog(generatorframe,"Attention:(", " Select a line file!!!",  JOptionPane.WARNING_MESSAGE);
                result = openFile.showOpenDialog(generatorframe);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File linesFile = openFile.getSelectedFile();
                    BufferedReader linesBr= new BufferedReader(new FileReader(linesFile));
                    String linesLine;
                    while ((linesLine = linesBr.readLine()) !=null) {
                        String[] lineParts = linesLine.split(",");
                        String invNumStr = lineParts[0];
                        String itemName = lineParts[1];
                        String itemPriceStr = lineParts[2];
                        String itemCountStr = lineParts[3];
                 int invNum = Integer.parseInt(invNumStr);
                           double itemPrice = Double.parseDouble(itemPriceStr);
                           int itemCount = Integer.parseInt(itemCountStr);
                           InvoiceHeader header = findInvoice(invNum);
                           InvoiceLine invLine = new InvoiceLine(itemName, itemPrice, itemCount, header);
                                          header.getInovicelines().add(invLine);
                                            }
                         generatorframe.setInvHeaderTableModel(new HeaderModel(generatorframe.getInvoicesArray()));
                         generatorframe.getInvoicesTable().setModel(generatorframe.getHeaderModel());
                         generatorframe.getInvoicesTable().validate();

                }
                 System.out.println("Check");
                 
                 //handling multiple exception
            } catch (ParseException ex) {
               JOptionPane.showMessageDialog(generatorframe, "Weong Date Format \n" + ex.getMessage(), "Error!!", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(generatorframe, " Wrong Number Format \n" + ex.getMessage(), "Error!!", JOptionPane.ERROR_MESSAGE);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(generatorframe, "File/path Not Found\n" + ex.getMessage(), "Error!!", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(generatorframe, "Reading Error\n" + ex.getMessage(), "Error!!", JOptionPane.ERROR_MESSAGE);
            }
        }
        displayInvoices();
    }  

     
     private void savefile() {
        String headers = "";
                String lines = "";
        for (InvoiceHeader header : generatorframe.getInvoicesArray()) {
            headers += header.getCSV();
            headers += "\n";
            for (InvoiceLine line : header.getInovicelines()) {
                lines += line.getCSV();
                lines += "\n";
            }
        }
                JOptionPane.showMessageDialog(generatorframe,  "Attention;("," Select file to save header data!", JOptionPane.WARNING_MESSAGE);
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(generatorframe);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File headerFile = fileChooser.getSelectedFile();
                    try {
                        try (FileWriter hFW = new FileWriter(headerFile)) {
                            hFW.write(headers);
                            hFW.flush();
                        }

                        JOptionPane.showMessageDialog(generatorframe,  "Attention;(","Select file to save lines data!", JOptionPane.WARNING_MESSAGE);
                        result = fileChooser.showSaveDialog(generatorframe);
                        if (result == JFileChooser.APPROVE_OPTION) {
                            File linesFile = fileChooser.getSelectedFile();
                            try (FileWriter lFW = new FileWriter(linesFile)) {
                                lFW.write(lines);
                                lFW.flush();
                            }
                        }
                                                   JOptionPane.showMessageDialog(null, "File Saved Successfully ! ");

                    } catch (HeadlessException | IOException ex) {
                        JOptionPane.showMessageDialog(generatorframe, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
    }
   

 
    private void deleteLineBtn() {
       
           
        int lineIndex = generatorframe.getInvLineTable().getSelectedRow();
        InvoiceLine linee;
        linee = generatorframe.getLineModel().getInvoiceLines().get(lineIndex);
        generatorframe.getLineModel().getInvoiceLines().remove(lineIndex);
        generatorframe.getHeaderModel().fireTableDataChanged();
        generatorframe.getLineModel().fireTableDataChanged();
        generatorframe.getInvTotalLbl().setText("" + linee.getHeader().getInvTotalPrice());
        JOptionPane.showMessageDialog(null, "Line Deleted Successfully ! ");
        displayInvoices();
        }      
      
    
      
 
    private int getNxtInvNumber() {
        int index = 0;
        
        for(InvoiceHeader header : generatorframe.getInvoicesArray()) {
            //index=0;
            if (header.getInvoiceNum()> index) {
                index = header.getInvoiceNum();
                
            }
        }
        return index + 1;
    }
  
    private void createInvDone() {
                String custName = generatorframe.getHeaderDialog().getCustNameField().getText();
                String invDateStr = generatorframe.getHeaderDialog().getInvDateField().getText();
                generatorframe.getHeaderDialog().setVisible(false);
                generatorframe.getHeaderDialog().dispose();
                generatorframe.setHeaderDialog(null);
                try {
                    Date invDate = df.parse(invDateStr);
                    int invNum = getNxtInvNumber();
                    InvoiceHeader invoiceFrame1 = new InvoiceHeader(invNum, custName, invDate);
                    generatorframe.getInvoicesArray().add(invoiceFrame1);
                    generatorframe.getHeaderModel().fireTableDataChanged();}
                    catch (ParseException ex) {
                    JOptionPane.showMessageDialog(generatorframe , "Wrong date Format, please use correct format(dd/MM/YYYY) " , "Error!!" , JOptionPane.ERROR_MESSAGE);
                  displayInvoices();
                }
    }
     
  
       
    private void createInvCancel() {
                generatorframe.getHeaderDialog().setVisible(false);
                generatorframe.getHeaderDialog().dispose();
               
    }

     


    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
            switch (e.getActionCommand()){
            
                case "CreateNewInvoice": displayNewInv();
                break;
                case "DeleteInvoice":deleteInv();
                break;
                case "LoadFile":LoadFile();
                break;
                case "SaveFile": savefile();
                //contuine;
                case "CreateNewLine": createline();
                break;
                case "DeleteLine": deleteLineBtn();
                break;
                case "createInvCancel": createInvCancel();
                break;
                case "createInvOK": createInvDone();
                break;
                case "createLineCancel":createLineCancel();
                break;
                case "createLineOK": createLinedone();
                break;

        }
    
    
    
    }
    
    
    
    private void invRowSelected() {
                int selectedRowIndex = generatorframe.getInvoicesTable().getSelectedRow();
                if (selectedRowIndex >= 0){
                    InvoiceHeader row = generatorframe.getHeaderModel().getInvDataa().get(selectedRowIndex);
                    generatorframe.getCustNameTF().setText(row.getCustomername());
                   generatorframe.getInvDateTF().setText(df.format(row.getInvoiceDate()));
                   generatorframe.getInvNumLbl().setText("" + row.getInvoiceNum());
                    generatorframe.getInvTotalLbl().setText("" + row.getInvTotalPrice());
                    ArrayList<InvoiceLine> lines = row.getInovicelines();
                    generatorframe.setInvLineTableModel(new LineModel(lines));
                    generatorframe.getInvLineTable().setModel(generatorframe.getLineModel());
                   

}
    }
 
    
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
       System.out.println("Invoice Selected!");
       invRowSelected();
    
    
    }
    
     private void createLineCancel() {
            generatorframe.getLineDialog().setVisible(false);
         
    }
    
     
     
    private void createLinedone() {
String itemName ; 
      itemName=  generatorframe.getLineDialog().getItemNameField().getText();
String itemCountStr ;
       itemCountStr  = generatorframe.getLineDialog().getItemCountField().getText();
                        String itemPriceStr;
                        itemPriceStr = generatorframe.getLineDialog().getItemTPriceField().getText();
                        generatorframe.getLineDialog().setVisible(false);
                        generatorframe.getLineDialog().dispose();

                        int itemCount = Integer.parseInt(itemCountStr);
                        double itemPrice = Double.parseDouble(itemPriceStr);
                        int headerIndex = generatorframe.getInvoicesTable().getSelectedRow();
                        InvoiceHeader invoice; 
                        invoice = generatorframe.getHeaderModel().getInvDataa().get(headerIndex);
                        InvoiceLine invoiceLine = new InvoiceLine(itemName, itemPrice, itemCount, invoice);
                        invoice.addLine(invoiceLine);
                        displayInvoices();   
                            }

    private void createline() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     
     
}
  