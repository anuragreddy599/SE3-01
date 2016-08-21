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
import java.util.Locale;
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
        static Calendar cal=Calendar.getInstance( Locale.US);
        public static int currentStartWeek=0;
        public static int currentEndWeek=0;
        static{
            cal.clear();
        cal.setTime (currentStartDate);
        currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
       
        }
        int r=getRowCount();
	Object[][] data = new Object[r][8];
	
	private static final long serialVersionUID = 1L;
	
	String[] columnNames=new String[8];
	public TimesheetReportTableModel(){
		data = new Object[r][8];
	}
    
    public TimesheetReportTableModel(int s){
    	SimpleDateFormat sdf;
    	sdf = new SimpleDateFormat("dd/MMM/yyyy ");
    	
    	
    	Calendar cal= Calendar.getInstance( Locale.US);
    	cal.clear();
    	//String[] columnNames=new String[7];
    	cal.setTime(new Date());
    	cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        
    	currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        Calendar clone=(Calendar)cal.clone();
        clone.getFirstDayOfWeek();
        clone.add(Calendar.DAY_OF_YEAR, 6);
    	this.columnNames[0]="Employee";
    	this.columnNames[1]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(clone.getTime())+"</html>";
    	
        
        cal.add(Calendar.WEEK_OF_YEAR,1);
        currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        clone=getClone(cal);
        
    	this.columnNames[2]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(clone.getTime())+"</html>";
        System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	cal.add(Calendar.WEEK_OF_YEAR,1);
        currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        clone=getClone(cal);
    	this.columnNames[3]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(clone.getTime())+"</html>";
        System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	cal.add(Calendar.WEEK_OF_YEAR,1);
        currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        clone=getClone(cal);
    	this.columnNames[4]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(clone.getTime())+"</html>";
        System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	cal.add(Calendar.WEEK_OF_YEAR,1);
        currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        clone=getClone(cal);
    	this.columnNames[5]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(clone.getTime())+"</html>";
        System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	cal.add(Calendar.WEEK_OF_YEAR,1);
        currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        clone=getClone(cal);
    	this.columnNames[6]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(clone.getTime())+"</html>";
        System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	cal.add(Calendar.WEEK_OF_YEAR,1);
        currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        clone=getClone(cal);
    	this.columnNames[7]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(clone.getTime())+"</html>";
        System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	currentEndWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	
    }

    public TimesheetReportTableModel(String test) {
		// TODO Auto-generated constructor stub
    	
    	SimpleDateFormat sdf;
    	sdf = new SimpleDateFormat("dd/MMM/yyyy ");
    	
    	
    	Calendar cal= Calendar.getInstance( Locale.US);
    	cal.clear();
    	cal.setTime(currentEndDate);
        
        cal.set(Calendar.WEEK_OF_YEAR, currentEndWeek);
        cal.add(Calendar.WEEK_OF_YEAR,1);
    	currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        Calendar clone=(Calendar)cal.clone();
        clone.getFirstDayOfWeek();
        //clone.add(Calendar.DAY_OF_YEAR, 6);
        
        
    	this.columnNames[0]="Employee";
		this.columnNames[1]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(clone.getTime())+"</html>";
                System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	cal.add(Calendar.WEEK_OF_YEAR,1);
        currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        clone=getClone(cal);
    	this.columnNames[2]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(cal.getTime())+"</html>";
        System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	cal.add(Calendar.WEEK_OF_YEAR,1);
        currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        clone=getClone(cal);
    	this.columnNames[3]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(cal.getTime())+"</html>";
        System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	cal.add(Calendar.WEEK_OF_YEAR,1);
        currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        clone=getClone(cal);
    	this.columnNames[4]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(cal.getTime())+"</html>";
        System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	cal.add(Calendar.WEEK_OF_YEAR,1);
        currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        clone=getClone(cal);
    	this.columnNames[5]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(cal.getTime())+"</html>";
        System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	cal.add(Calendar.WEEK_OF_YEAR,1);
        currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        clone=getClone(cal);
    	this.columnNames[6]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(cal.getTime())+"</html>";
        System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	cal.add(Calendar.WEEK_OF_YEAR,1);
        currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        clone=getClone(cal);
    	this.columnNames[7]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(cal.getTime())+"</html>";
        System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	currentEndWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	
	}

    public TimesheetReportTableModel(String test,String test1) {
		// TODO Auto-generated constructor stub
    	
    	SimpleDateFormat sdf;
    	sdf = new SimpleDateFormat("dd/MMM/yyyy ");
    	
    	
    	Calendar cal= Calendar.getInstance( Locale.US);
    	cal.clear();
    	cal.setTime(currentEndDate);
        
        cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        cal.add(Calendar.WEEK_OF_YEAR,-13);
    	currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        Calendar clone=(Calendar)cal.clone();
        clone.getFirstDayOfWeek();
        //clone.add(Calendar.DAY_OF_YEAR, 6);
        
        
    	this.columnNames[0]="Employee";
		this.columnNames[1]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(clone.getTime())+"</html>";
                System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	cal.add(Calendar.WEEK_OF_YEAR,1);
        currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        clone=getClone(cal);
    	this.columnNames[2]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(cal.getTime())+"</html>";
        System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	cal.add(Calendar.WEEK_OF_YEAR,1);
        currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        clone=getClone(cal);
    	this.columnNames[3]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(cal.getTime())+"</html>";
        System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	cal.add(Calendar.WEEK_OF_YEAR,1);
        currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        clone=getClone(cal);
    	this.columnNames[4]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(cal.getTime())+"</html>";
        System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	cal.add(Calendar.WEEK_OF_YEAR,1);
        currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        clone=getClone(cal);
    	this.columnNames[5]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(cal.getTime())+"</html>";
        System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	cal.add(Calendar.WEEK_OF_YEAR,1);
        currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        clone=getClone(cal);
    	this.columnNames[6]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(cal.getTime())+"</html>";
        System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	cal.add(Calendar.WEEK_OF_YEAR,1);
        currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        clone=getClone(cal);
    	this.columnNames[7]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(cal.getTime())+"</html>";
        System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	currentEndWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	
	}
	public  void callNext() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf;
    	sdf = new SimpleDateFormat(" dd/MMM/yyyy ");
    	
    	
    	Calendar cal= Calendar.getInstance( Locale.US);
    	cal.clear();
    	cal.setTime(currentEndDate);
    	cal.add(Calendar.WEEK_OF_YEAR,1);
        
        currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        Calendar clone=(Calendar)cal.clone();
        clone.getFirstDayOfWeek();
        clone.add(Calendar.DAY_OF_YEAR, 6);
        
    	
    	this.columnNames[0]="Employee";
		this.columnNames[1]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(clone.getTime())+"</html>";
                System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	cal.add(Calendar.WEEK_OF_YEAR,1);
        currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        clone=getClone(cal);
    	this.columnNames[2]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(clone.getTime())+"</html>";
        System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	cal.add(Calendar.WEEK_OF_YEAR,1);
        currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        clone=getClone(cal);
    	this.columnNames[3]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(clone.getTime())+"</html>";
        System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	cal.add(Calendar.WEEK_OF_YEAR,1);
        currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        clone=getClone(cal);
    	this.columnNames[4]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(clone.getTime())+"</html>";
        System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	cal.add(Calendar.WEEK_OF_YEAR,1);
        currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        clone=getClone(cal);
    	this.columnNames[5]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(clone.getTime())+"</html>";
        System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	cal.add(Calendar.WEEK_OF_YEAR,1);
        currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        clone=getClone(cal);
    	this.columnNames[6]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(clone.getTime())+"</html>";
        System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	cal.add(Calendar.WEEK_OF_YEAR,1);
        currentStartWeek=cal.get(Calendar.WEEK_OF_YEAR);
    	cal.set(Calendar.WEEK_OF_YEAR, currentStartWeek);
        clone=getClone(cal);
    	this.columnNames[7]="<html>"+"Week "+currentStartWeek+" Ending on"+"<br/>"+sdf.format(clone.getTime())+"</html>";
        System.out.println("WEEK"+cal.get(Calendar.WEEK_OF_YEAR));
    	currentEndWeek=cal.get(Calendar.WEEK_OF_YEAR);
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
         return false;
    }

	//@Override
	public int getRowCount() {
		// Row count equals to number of projects the developer is assigned
                TimesheetHandler timesheetHandler= TimesheetHandler.getInstance();
                int i=timesheetHandler.getNumberOfEmplInTimesheet();
                //data=new Object[i][8];
		return i;
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
         
         Calendar getClone(Calendar cal){
             Calendar clone=(Calendar)cal.clone();
                clone.getFirstDayOfWeek();
                clone.add(Calendar.DAY_OF_YEAR, 6);
                
                return clone;
         }
}
