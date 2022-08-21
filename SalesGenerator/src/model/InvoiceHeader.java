
package model;


import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.util.logging.Logger;

/**
 *
 * @author mariiam
 */
public class InvoiceHeader {
    
   //variables
     private int InvoiceNumber; 
     private Date InvoiceDate;
     private String CustomerName;
     private ArrayList<InvoiceLine> Inovicelines;
    //double TotalPrice = 0.0;
     
     
     //constructor 
    public InvoiceHeader(int invoiceNum, Date invoiceDate, String customername, ArrayList<InvoiceLine> Inovicelines) {
        this.InvoiceNumber = invoiceNum;
        this.InvoiceDate = invoiceDate;
        this.CustomerName = customername;
        this.Inovicelines = Inovicelines;
    }

    public InvoiceHeader(int invNum, String custName, Date invDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //setters and getters for private variables 
    public int getInvoiceNum() {
        return InvoiceNumber;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.InvoiceNumber = invoiceNum;
    }

    public Date getInvoiceDate() {
        return InvoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.InvoiceDate = invoiceDate;
    }

    public String getCustomername() {
        return CustomerName;
    }

    public void setCustomername(String customername) {
        this.CustomerName = customername;
    }

    public void setInovicelines(ArrayList<InvoiceLine> Inovicelines) {
        this.Inovicelines = Inovicelines;
    }

    public ArrayList<InvoiceLine> getInovicelines() {
              if (Inovicelines==null)
              { 
                  Inovicelines = new ArrayList<>();
              }
              
              return Inovicelines;
    }

 
 
    public void addLine(InvoiceLine line){
        getInovicelines().add(line);  
     }
    
    

    public double getInvTotalPrice() {
        double TotalPrice = 0.0;
        for (InvoiceLine line : getInovicelines()){
            //calling the method (function) in the headerline class by dot method 
            TotalPrice  =TotalPrice+ line. getTotalLines();
        }
        return TotalPrice ;
    }

     //printing data on a csv 
     public String getCSV() {
         //handle excepyion of wrong date format
        DateFormat dateformaatt;
         dateformaatt = new SimpleDateFormat("dd/MM/yyyy");
        return "" + getInvoiceNum() + "," +dateformaatt.format(getInvoiceDate()) + "," + getCustomername();
}
    
    
     }


