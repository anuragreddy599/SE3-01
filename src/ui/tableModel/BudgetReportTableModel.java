package ui.tableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import pojo.BudgetReportTO;


public class BudgetReportTableModel extends AbstractTableModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<BudgetReportTO> li = new ArrayList<BudgetReportTO>();

    private String[] columnNames = { "Client Id", "Client Name", "Project Id",
                "Project Name", "Total Budget", "Budget Remaining"};

    
    public BudgetReportTableModel(List<BudgetReportTO> list){
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
        return 6; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	BudgetReportTO si = li.get(rowIndex);
        switch (columnIndex) {
            case 0: 
                return si.getClientId();
            case 1:
                return si.getClientName();
            case 2:
                return si.getProjectId();
            case 3:
                return si.getProjectName();
            case 4:
                return si.getTotalBudget();
            case 5:
                return si.getBudgetRemaining();
              
                
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

              
                    
             }
             return null;
      }
}
