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
public class LineModel extends AbstractTableModel {
    
    //variables
    private List<InvoiceLine> InvoiceLines;
    private final DateFormat df ;

    //constructor
    public LineModel(List<InvoiceLine> InvoiceLines) {
        this.InvoiceLines = InvoiceLines;
        this.df = new SimpleDateFormat("dd/MM/yyyy");
    }

    //setter and getter of the privste variable
    public List<InvoiceLine> getInvoiceLines() {
        return InvoiceLines;
    }

    public void setInvoiceLines(List<InvoiceLine> InvoiceLines) {
        this.InvoiceLines = InvoiceLines;
    }
    
    //implementation of the abstract methods of the AbstractTableModel class
    
     @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //return super.isCellEditable(rowIndex, columnIndex); 
        return false;
    }
    
    
    

    @Override
    public int getRowCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return InvoiceLines.size();
    }

    @Override
    public int getColumnCount() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       return 4;
    }
    
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
        InvoiceLine row =InvoiceLines.get(rowIndex);
        
        switch(columnIndex){
            case 0: return row.getItemName();
            case 1 : return row.getItemPrice();
            case 2 : return row.getCount();
            case 3 : return row. getTotalLines();
            default:
            return null;
    }
    
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        //return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
            switch (columnIndex) {
          case 0 :
              return String.class;
          case 1 :
              return Double.class;
          case 2 :
              return Integer.class;
          case 3 :
              return Double.class;
          default:
              return Object.class;
    }
    
    
    }

    @Override
    public String getColumnName(int column) {
        //return super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
    switch (column) {
          case 0 :
              return "Item Name";
          case 1 :
              return "item Price";
          case 2 :
              return "Count";
          case 3 :
              return "Total Lines";
          default:
              return "";
    
    }
    
    
    }   
}
