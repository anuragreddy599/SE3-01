package ui.tableModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import pojo.InvoiceReportTO;


public class InvoiceReportTableModel extends AbstractTableModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<InvoiceReportTO> li = new ArrayList<InvoiceReportTO>();
    private String[] columnNames = { "Invoice Number","Client Id", "Project Id", 
                "Project Name", "InvoiceDate", "Amount Due"};

    
    public InvoiceReportTableModel(List<InvoiceReportTO> list){
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
    	InvoiceReportTO si = li.get(rowIndex);
        switch (columnIndex) {
            case 0: 
                return si.getInvoiceNumber();
            case 1:
                return si.getClientId();
            case 2:
                return si.getProjectNumber();
            case 3:
                return si.getProjectName();
            case 4:{
                     String formattedDate=null;
                     try{
                    DateFormat originalFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
                    DateFormat targetFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date date1 = originalFormat.parse(si.getInvoiceDate().toString());
                    formattedDate = targetFormat.format(date1); 
                     }catch(Exception e){
                         e.printStackTrace();
                     }
                return formattedDate;
            }
            case 5:
                return si.getTotalAmountDue();
              
                
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
