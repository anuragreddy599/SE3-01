package ui.tableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import pojo.ClientTO;
import pojo.EmployeeTO;

public class EmployeeTableModel extends AbstractTableModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<EmployeeTO> li = new ArrayList<EmployeeTO>();
    private String[] columnNames = { "Name", "Title", "Bill Rate", "Role", "Status"};

    
    public EmployeeTableModel(List<EmployeeTO> list){
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
        return 5; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	EmployeeTO si = li.get(rowIndex);
        switch (columnIndex) {
            case 0: 
                return si.getName();
            case 1:
                return si.getTitle();
            case 2:
                return si.getBillRate();
            case 3:
                return si.getRole();
            case 4:
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
               return Integer.class;
             case 3:
               return String.class;
             case 4:
               return String.class;
               
                    
             }
             return null;
      }
}
