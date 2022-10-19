/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
     private int Number;
     private String Date;
     private String CustomerName;
     private ArrayList<InvoiceLines> lines;
     //double TotalPrice = 0.0;
     
     
     //constructors
    public InvoiceHeader() {
    }

    public InvoiceHeader(int number, String Date, String CustomerName) {
        this.Number = number;
        this.Date = Date;
        this.CustomerName = CustomerName;
    }
      
   //getters and setters for private variables
    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getDate() {
        return Date;
    }
    public void setNumber(int number) {
        this.Number = number;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public int getSonumber() {
        return Number;
    }

    public void setSonumber(int Sonumber) {
        this.Number = Sonumber;
    }

    
    public ArrayList<InvoiceLines> getLines() {
        if(lines ==null){
        lines =new ArrayList<>();
        }
        return lines;
    }
    
      public double getinvoiceCod (){
         double invoicePrice=0.0 ;
         invoicePrice = getLines().stream().map((line) -> line.getLineTotalPrice()).reduce(invoicePrice, (accumulator, _item) -> accumulator + _item); //calling the method (function) in the headerline class by dot method
        return invoicePrice;
    }
       //printing data on a csv 
      //handle excepyion of wrong date format
      public String  getAsCsv(){
          
         DateFormat dateformaatt;
         dateformaatt = new SimpleDateFormat("dd/MM/yyyy");
      return Number + "," + Date + "," + CustomerName ;
      
      }
          public double getInvoiceTotal() {
        double total = 0.0;
        total = getLines().stream().map((line) -> line.getLineTotalPrice()).reduce(total, (accumulator, _item) -> accumulator + _item);
        return total;
    }
}
