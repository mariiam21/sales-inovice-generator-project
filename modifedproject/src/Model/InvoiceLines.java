/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author mariiam
 */
public class InvoiceLines {
   
    //variables of the class required
    private String product;
    private double Price;
    private int size;
    private InvoiceHeader invoice;
    
    public InvoiceLines() {
    }

    
 //constructor with parameters
    public InvoiceLines( String product, double Price, int size, InvoiceHeader invoice) {
        
        this.product = product;
        this.Price = Price;
        this.size = size;
        this.invoice = invoice;
    }
//setters and getters of the variables (private variables)
    public double getLineTotalPrice(){
    return Price*size ;
    }
    
    public int getQty() {
        return size;
    }

    public void setQty(int size) {
        this.size = size;
    }

   
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
    

    @Override
    public String toString() {
        return "Lines{" + "SO=" + invoice.getSonumber() + ", product=" + product + ", Price=" + Price + ", size=" + size + '}';
    }

    public InvoiceHeader getInvoice() {
        return invoice;
    }
    
    public String  getAsCsv(){
   //printing the data in a csv file 
      return invoice.getSonumber() + "," + product + "," + Price + "," + size;
      
      }
    
}
