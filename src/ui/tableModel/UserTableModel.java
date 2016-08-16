package ui.tableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import pojo.ClientTO;
import pojo.UserTO;

public class UserTableModel extends AbstractTableModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<UserTO> li = new ArrayList<UserTO>();
    private String[] columnNames = { "User Id", "Password", "Role", "Status","Id"};

    
    public UserTableModel(List<UserTO> list){
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
    	UserTO si = li.get(rowIndex);
        switch (columnIndex) {
            case 0: 
                return si.getUserId();
            case 1:
                return si.getPassword();
            case 2:
                return si.getRole();
            case 3:
                return si.getStatus();
                 case 4:
                return si.getId();
            
                
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
                    
             }
             return null;
      }
}
