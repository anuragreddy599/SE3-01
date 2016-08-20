/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.tableModel;

import handler.TimesheetHandler;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mantu
 */
public class TimesheetReportTableModel extends AbstractTableModel {
	
	public static Date currentStartDate=new Date(); 
	public static Date currentEndDate=new Date();
        int r=getRowCount();
	Object[][] data = new Object[r][8];
	
	private static final long serialVersionUID = 1L;
	Calendar cal= Calendar.getInstance();
	//cal.clear();
	String[] columnNames=new String[8];
	public TimesheetReportTableModel(){
		data = new Object[r][8];
	}
    
    public TimesheetReportTableModel(int s){
    	SimpleDateFormat sdf;
    	sdf = new SimpleDateFormat(" EEE dd/MMM/yyyy ");
    	
    	
    	Calendar cal= Calendar.getInstance();
    	cal.clear();
    	//String[] columnNames=new String[7];
    	cal.setTime(new Date());
    	cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
    	currentStartDate=cal.getTime();
    	
    	this.columnNames[0]="Project";
    	this.columnNames[1]=sdf.format(cal.getTime());
    	cal.add(Calendar.DATE,1);
    	this.columnNames[2]=sdf.format(cal.getTime());
    	cal.add(Calendar.DATE,1);
    	this.columnNames[3]=sdf.format(cal.getTime());
    	cal.add(Calendar.DATE,1);
    	this.columnNames[4]=sdf.format(cal.getTime());
    	cal.add(Calendar.DATE,1);
    	this.columnNames[5]=sdf.format(cal.getTime());
    	cal.add(Calendar.DATE,1);
    	this.columnNames[6]=sdf.format(cal.getTime());
    	cal.add(Calendar.DATE,1);
    	this.columnNames[7]=sdf.format(cal.getTime());
    	currentEndDate=cal.getTime();
    	
    }

    public TimesheetReportTableModel(String test) {
		// TODO Auto-generated constructor stub
    	
    	SimpleDateFormat sdf;
    	sdf = new SimpleDateFormat(" EEE dd/MMM/yyyy ");
    	
    	
    	Calendar cal= Calendar.getInstance();
    	cal.clear();
    	cal.setTime(currentEndDate);
    	cal.add(Calendar.DATE,1);
    	currentStartDate=cal.getTime();
    	this.columnNames[0]="Project";
		this.columnNames[1]=sdf.format(cal.getTime());
    	cal.add(Calendar.DATE,1);
    	this.columnNames[2]=sdf.format(cal.getTime());
    	cal.add(Calendar.DATE,1);
    	this.columnNames[3]=sdf.format(cal.getTime());
    	cal.add(Calendar.DATE,1);
    	this.columnNames[4]=sdf.format(cal.getTime());
    	cal.add(Calendar.DATE,1);
    	this.columnNames[5]=sdf.format(cal.getTime());
    	cal.add(Calendar.DATE,1);
    	this.columnNames[6]=sdf.format(cal.getTime());
    	cal.add(Calendar.DATE,1);
    	this.columnNames[7]=sdf.format(cal.getTime());
    	currentEndDate=cal.getTime();
    	
	}

    public TimesheetReportTableModel(String test,String test1) {
		// TODO Auto-generated constructor stub
    	
    	SimpleDateFormat sdf;
    	sdf = new SimpleDateFormat(" EEE dd/MMM/yyyy ");
    	
    	
    	Calendar cal= Calendar.getInstance();
    	cal.clear();
    	cal.setTime(currentStartDate);
    	cal.add(Calendar.DATE,-7);
    	//cal.setTime(currentEndDate);
    	//cal.add(Calendar.DATE,1);
    	currentStartDate=cal.getTime();
    	this.columnNames[0]="Project";
		this.columnNames[1]=sdf.format(cal.getTime());
    	cal.add(Calendar.DATE,1);
    	this.columnNames[2]=sdf.format(cal.getTime());
    	cal.add(Calendar.DATE,1);
    	this.columnNames[3]=sdf.format(cal.getTime());
    	cal.add(Calendar.DATE,1);
    	this.columnNames[4]=sdf.format(cal.getTime());
    	cal.add(Calendar.DATE,1);
    	this.columnNames[5]=sdf.format(cal.getTime());
    	cal.add(Calendar.DATE,1);
    	this.columnNames[6]=sdf.format(cal.getTime());
    	cal.add(Calendar.DATE,1);
    	this.columnNames[7]=sdf.format(cal.getTime());
    	currentEndDate=cal.getTime();
    	
	}
	public  void callNext() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf;
    	sdf = new SimpleDateFormat(" EEE dd/MMM/yyyy ");
    	
    	
    	Calendar cal= Calendar.getInstance();
    	cal.clear();
    	cal.setTime(currentEndDate);
    	cal.add(Calendar.DATE,1);
    	currentStartDate=cal.getTime();
    	this.columnNames[0]="Project";
		this.columnNames[1]=sdf.format(cal.getTime());
    	cal.add(Calendar.DATE,1);
    	this.columnNames[2]=sdf.format(cal.getTime());
    	cal.add(Calendar.DATE,1);
    	this.columnNames[3]=sdf.format(cal.getTime());
    	cal.add(Calendar.DATE,1);
    	this.columnNames[4]=sdf.format(cal.getTime());
    	cal.add(Calendar.DATE,1);
    	this.columnNames[5]=sdf.format(cal.getTime());
    	cal.add(Calendar.DATE,1);
    	this.columnNames[6]=sdf.format(cal.getTime());
    	cal.add(Calendar.DATE,1);
    	this.columnNames[7]=sdf.format(cal.getTime());
    	currentEndDate=cal.getTime();
	}

	public final Object[] longValues = {"JaneXXXXXXXXXXXX", "KathyXXXXXXXXXXXX",
                                        "None of the above","xxxXXXXXXXXXXX","uyyuXXXXXXXXXX",
                                        new Integer(20), "XXXXXXXXXXXXXXXXXX","XXXXXXXXXXXXXXX"};
    //@Override
    public int getColumnCount() {
        return columnNames.length;
    }
    //@Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    Calendar initiate(Calendar cal){
    	return cal;
    }
   //@Override
    public void addTableModelListener(TableModelListener l){
       System.out.println("addTableModelListener");
   }
    
    //@Override
    public boolean isCellEditable(int row, int col) {
        if(col==0)
            return false;
         else
         return true;
    }

	//@Override
	public int getRowCount() {
		// Row count equals to number of projects the developer is assigned
                TimesheetHandler timesheetHandler= TimesheetHandler.getInstance();
                //int i=timesheetHandler.getRowCount();
                //data=new Object[i][8];
		return 5;
	}

	//@Override
	 public Object getValueAt(int row, int col) {
        return data[row][col];
	}
         //@Override
	public void setValueAt(Object value, int row, int col) {
           
        if (true) {
            System.out.println("Setting value at " + row + "," + col
                               + " to " + value
                               + " (an instance of "
                               + value.getClass() + ")");
        }

        data[row][col] = value;
        fireTableCellUpdated(row, col);

        if (true) {
            System.out.println("New value of data:");
            printDebugData();
        }
	}
        
         private void printDebugData() {
      int numRows = getRowCount();
      int numCols = getColumnCount();

      for (int i = 0; i < numRows; i++) {
        System.out.print("    row " + i + ":");
        for (int j = 0; j < numCols; j++) {
          System.out.print("  " + data[i][j]);
        }
        System.out.println();
      }
      System.out.println("--------------------------");
    }
}
