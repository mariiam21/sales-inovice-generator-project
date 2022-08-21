/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mariiam
 */
public class InvoiceLine {
      
      //variables of the class required
       private int InvoiceNumber;
       private String ItemName;
       private double ItemPrice;
       private int Count;
       
       private double TotalLines;
       private InvoiceHeader Header;
       
       
    //constructor with parameters
    public InvoiceLine(String ItemName, double ItemPrice, int ItemCount, InvoiceHeader Header) {
        this.ItemName = ItemName;
        this.ItemPrice = ItemPrice;
        this.Count = ItemCount;
        this.Header = Header;
        //calling the method
        this.setTotal_lines(this.Count*this.ItemPrice);
    }

    //setters and getters of the variables (private variables)
    public int getInvoiceNumber() {
        return InvoiceNumber;
    }

    public void setInvoiceNumber(int InvoiceNumber) {
        this.InvoiceNumber = InvoiceNumber;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public double getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(double ItemPrice) {
        this.ItemPrice = ItemPrice;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    public double getTotalLines() {
        return TotalLines;
    }

    public void setTotalLines(double TotalLines) {
        this.TotalLines = TotalLines;
    }

    public InvoiceHeader getHeader() {
        return Header;
    }

    public void setHeader(InvoiceHeader Header) {
        this.Header = Header;
    }

   private void setTotal_lines(double  TotalLines) {
       
     // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      this.TotalLines = TotalLines;
    }

    //printing the data in a csv file 
     public String getCSV() {
        return "" + getHeader().getInvoiceNum() + "," + getItemName() + "," + getItemPrice() + "," + getCount();
    }

   
    
}
