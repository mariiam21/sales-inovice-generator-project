/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

//libraries used

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mariiam
 */
public class HeaderModel extends AbstractTableModel  {
    
       //variables
      //constructor
    private final ArrayList<InvoiceHeader> invoices;
    private final String columns []={"No","Date","Customer","Total"};
    
    
    //setter and getter
    
    public HeaderModel(ArrayList<InvoiceHeader> invoices) {
        this.invoices = invoices;
    }
    
    @Override
    public int getRowCount() {
            return invoices.size();
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
        InvoiceHeader invoice =invoices.get(rowIndex);
        switch (columnIndex){
            case 0 : return invoice.getSonumber();
            case 1 : return invoice.getDate();
            case 2 : return invoice.getCustomerName();
            case 3 : return invoice.getinvoiceCod();
            default : return "";
        }
    }
    
//    //implementation of the abstract methods of the AbstractTableModel class
//    @Override
//    public int getRowCount() {
//        
//       return InvDataa.size();
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public int getColumnCount() {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//      return 4;
//      // invoice number ,date,name ,total price
//    }
//
//    
    
    //  @Override
//    public void addTableModelListener(TableModelListener l) {
//        super.addTableModelListener(l); //To change body of generated methods, choose Tools | Templates.
//    }
//    
    
//    @Override
//    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        //return super.isCellEditable(rowIndex, columnIndex); 
//        return false;
//    }
//
//    @Override
//    public Class<?> getColumnClass(int columnIndex) {
//        //return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
//         switch (columnIndex) {
//          case 0 :
//              return String.class;
//          case 1 :
//              return Integer.class ;
//          case 2 :
//              return String.class;
//          case 3 :
//              return Double.class;
//          default:
//              return Object.class;}
//    }
//
//    @Override
//    public String getColumnName(int column) {
//        // return super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
//        switch (column) {
//            case 0:
//                return "invoice Name";
//            case 1:
//                return "Customer Number";
//            case 2:
//                return  "Invoice Date";
//            case 3:
//                return  "Invoice Total price ";
//            default:
//                return "";
//        }
//       
//     
//      }
//
//    public void setVisible(boolean b) {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//       

    
}


