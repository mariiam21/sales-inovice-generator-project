/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

//libraries used

import java.util.List;


import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mariiam
 */
public class HeaderModel extends AbstractTableModel {
    
    //variables
    private List<InvoiceHeader> InvDataa;
    private final DateFormat df;
    
    //constructor
    public HeaderModel(List<InvoiceHeader> InvDataa) {
        this.df = new SimpleDateFormat("dd/MM/yyyy");
        this.InvDataa = InvDataa;
        
   
    }
    
    //setter and getter
    public List<InvoiceHeader> getInvDataa() {
        return InvDataa;
        
    }
  
    public void setInvDataa(List<InvoiceHeader> InvDataa) {    
        this.InvDataa = InvDataa;
    }
    
    

    //implementation of the abstract methods of the AbstractTableModel class
    @Override
    public int getRowCount() {
        
       return InvDataa.size();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      return 4;
      // invoice number ,date,name ,total price
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
        InvoiceHeader row =InvDataa.get(rowIndex);
        switch(columnIndex){
            case 0: return row.getCustomername();
            case 1 : return row.getInvoiceNum();
            case 2 : return df.format(row.getInvoiceDate());
            case 3 : return row.getInvTotalPrice();
            default:
            return null;
    }
    
    }
    
    
//  @Override
//    public void addTableModelListener(TableModelListener l) {
//        super.addTableModelListener(l); //To change body of generated methods, choose Tools | Templates.
//    }
//    
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //return super.isCellEditable(rowIndex, columnIndex); 
        return false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        //return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
         switch (columnIndex) {
          case 0 :
              return String.class;
          case 1 :
              return Integer.class ;
          case 2 :
              return String.class;
          case 3 :
              return Double.class;
          default:
              return Object.class;}
    }

    @Override
    public String getColumnName(int column) {
        // return super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
        switch (column) {
            case 0:
                return "invoice Name";
            case 1:
                return "Customer Number";
            case 2:
                return  "Invoice Date";
            case 3:
                return  "Invoice Total price ";
            default:
                return "";
        }
       
     
      }

    public void setVisible(boolean b) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
    
    
}
