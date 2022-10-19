/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mariiam
 */
public class LineModel extends AbstractTableModel{
           
    private final ArrayList<InvoiceLines> lines;    
    private final String columns []={"No","Item Name","Item Price","Quantity","Item Total"};

    public LineModel(ArrayList<InvoiceLines> lines) {
        this.lines = lines;
    }

    public ArrayList<InvoiceLines> getLines() {
        return lines;
    }

    
    
    @Override
    public int getRowCount() {
        return lines.size();
    }

    @Override
    public int getColumnCount() {
          return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
           InvoiceLines line= lines.get(rowIndex);
           switch(columnIndex){
           
               case 0: {
                   return line.getInvoice().getSonumber();
                   
               }
               case 1: {
                   return line.getProduct();
                   
               }
               case 2: {
                   return line.getPrice() ;
               }
               case 3: {
                   return line.getQty();
                   
               }
               case 4:
               return line.getLineTotalPrice();
               
               default: return "";
           
           }
    }
    
//    
//    /implementation of the abstract methods of the AbstractTableModel class
//    
//     @Override
//    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        //return super.isCellEditable(rowIndex, columnIndex); 
//        return false;
//    }
//    
    
    
//
//    @Override
//    public int getRowCount() {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    return InvoiceLines.size();
//    }
//
//    @Override
//    public int getColumnCount() {
//       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//       return 4;
//    }
//    
//    
//    
//
//    @Override
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//   
//        InvoiceLine row =InvoiceLines.get(rowIndex);
//        
//        switch(columnIndex){
//            case 0: return row.getItemName();
//            case 1 : return row.getItemPrice();
//            case 2 : return row.getCount();
//            case 3 : return row. getTotalLines();
//            default:
//            return null;
//    }
//    
//    }
//
//    @Override
//    public Class<?> getColumnClass(int columnIndex) {
//        //return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
//            switch (columnIndex) {
//          case 0 :
//              return String.class;
//          case 1 :
//              return Double.class;
//          case 2 :
//              return Integer.class;
//          case 3 :
//              return Double.class;
//          default:
//              return Object.class;
//    }
//    
//    
//    }
//
//    @Override
//    public String getColumnName(int column) {
//        //return super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
//    switch (column) {
//          case 0 :
//              return "Item Name";
//          case 1 :
//              return "item Price";
//          case 2 :
//              return "Count";
//          case 3 :
//              return "Total Lines";
//          default:
//              return "";
//    
//    }
//    
//    
//    }   
}
