package ui.tableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import pojo.ClientTO;
import pojo.PersonProjectTO;

public class PersonProjectTableModel extends AbstractTableModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<PersonProjectTO> li = new ArrayList<PersonProjectTO>();
    private String[] columnNames = { "Project Number", "Project Name"};

    
    public PersonProjectTableModel(List<PersonProjectTO> list){
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
        return 2; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	PersonProjectTO si = li.get(rowIndex);
        switch (columnIndex) {
            case 0: 
                return si.getNumber();
            case 1:
                return si.getName();
            
                
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
            
                    
             }
             return null;
      }
}
