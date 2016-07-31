package ui.tableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import pojo.ClientTO;

public class ClientTableModel extends AbstractTableModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ClientTO> li = new ArrayList<ClientTO>();
    private String[] columnNames = { "Number", "Name", "Address1",
                "Address2", "City", "State", "Zip","Email","Contact","InvoiceFreq","BillingTerm","InvoiceGrouping","Status"};

    
    public ClientTableModel(List<ClientTO> list){
         this.li = list;
    }

    @Override
    public String getColumnName(int columnIndex){
         return columnNames[columnIndex];
    }

    @Override     
    public int getRowCount() {
        return li.size();
    }

    @Override        
    public int getColumnCount() {
        return 13; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	ClientTO si = li.get(rowIndex);
        switch (columnIndex) {
            case 0: 
                return si.getNumber();
            case 1:
                return si.getName();
            case 2:
                return si.getAddressLine1();
            case 3:
                return si.getAddressLine2();
            case 4:
                return si.getCity();
            case 5:
                return si.getState();
            case 6:
                return si.getZip();
            case 7:
                return si.getEmail();
            case 8:
                return si.getContact();
            case 9:
                return si.getInvoiceFreq();
            case 10:
                return si.getBillingTerms();
            case 11:
                return si.getInvoiceGrouping();
            case 12:
                return si.getStatus();    
                
           }
           return null;
   }

   @Override
   public Class<?> getColumnClass(int columnIndex){
          switch (columnIndex){
             case 0:
               return String.class;
             case 1:
               return String.class;
             case 2:
               return String.class;
             case 3:
               return String.class;
             case 4:
               return String.class;
             case 5:
               return String.class;
             case 6:
               return String.class;
                case 7:
               return String.class;
                case 8:
               return String.class;
                case 9:
               return String.class;
                case 10:
                    return String.class;
                case 11:
                    return String.class;
                case 12:
                    return String.class;    
                    
             }
             return null;
      }
}
