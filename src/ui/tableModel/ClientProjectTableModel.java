package ui.tableModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import pojo.ClientProjectTO;



public class ClientProjectTableModel extends AbstractTableModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ClientProjectTO> li = new ArrayList<ClientProjectTO>();
    private String[] columnNames = { "Client", "Project Number", "Project Name",
                "Start Date", "End Date", "Status", "Project Manager","Client Contact","Budget","Id"};

    
    public ClientProjectTableModel(List<ClientProjectTO> list){
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
        return 10; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	ClientProjectTO si = li.get(rowIndex);
        
        SimpleDateFormat parseFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
                          
                          SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
                          SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                          String resultStart = null;
                          String resultEnd = null;
                          Date date = null;
                            try {
                                    date = parseFormat.parse(si.getStartDate().toString());
                                    resultStart=format.format(date);
                                    
                                    
                                    date = parseFormat.parse(si.getEndDate().toString());
                                    resultEnd=format.format(date);
                                    
                                    
                                    
                            } catch (ParseException e) {
                                    e.printStackTrace();
                            }
        switch (columnIndex) {
            case 0: 
                return si.getClient();
            case 1:
                return si.getProjectNumber();
            case 2:
                return si.getProjectName();
            case 3:
                return resultStart;
            case 4:
                return resultEnd;
            case 5:
                return si.getStatus();
            case 6:
                return si.getProjectManager();
            case 7:
                return si.getClientContact();
            case 8:
                return si.getBudget();
                case 9:
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
                  
             }
             return null;
      }
}
