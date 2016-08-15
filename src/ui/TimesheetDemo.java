package ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;



public class TimesheetDemo extends JPanel {

	private boolean DEBUG = false;
    
    public TimesheetDemo() {
        //super(new GridLayout(1,0));
 
        loadRecords();
    }
 
    void loadRecords(){
    	  final JTable table = new JTable(new MyTableModel(0));
         table.setPreferredScrollableViewportSize(new Dimension(700, 70));
         table.setFillsViewportHeight(true);
  
         //Create the scroll pane and add the table to it.
         JScrollPane scrollPane = new JScrollPane(table);
         
         
         //Set up column sizes.
         initColumnSizes(table);
         setUpSportColumn(table, table.getColumnModel().getColumn(0));
         
         JButton prevBtn= new JButton("Prev");
         prevBtn.setSize(30, 15);
         JButton nextBtn= new JButton("Next");
         nextBtn.setSize(30, 15);
         
         
         nextBtn.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) 
 			{
 				JTable tablem=handleNext();
 				table.setModel(tablem.getModel());
 				setUpSportColumn(table, table.getColumnModel().getColumn(0));
 				
 			}
 		});
         prevBtn.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent arg0) 
  			{
  				JTable tablem=handlePrev();
  				table.setModel(tablem.getModel());
  				setUpSportColumn(table, table.getColumnModel().getColumn(0));
  				
  			}
  		});
         
        
         
         
         add(prevBtn);
         add(nextBtn);
         
         //Add the scroll pane to this panel.
         add(scrollPane);
    }
    
    JTable handleNext(){
    	//Date currentStartDate=MyTableModel.currentStartDate;
    	//Date currentEndDate=MyTableModel.currentStartDate;
    	MyTableModel obj= new MyTableModel();
    	//obj.callNext();
    	JTable table = new JTable(new MyTableModel("test"));
    	return table;
    }
    JTable handlePrev(){
    	//Date currentStartDate=MyTableModel.currentStartDate;
    	//Date currentEndDate=MyTableModel.currentStartDate;
    	MyTableModel obj= new MyTableModel();
    	//obj.callNext();
    	JTable table = new JTable(new MyTableModel("test","test"));
    	return table;
    }
    
    /*
     * This method picks good column sizes.
     * If all column heads are wider than the column's cells'
     * contents, then you can just use column.sizeWidthToFit().
     */
    private void initColumnSizes(JTable table) {
        MyTableModel model = (MyTableModel)table.getModel();
        TableColumn column = null;
        Component comp = null;
        int headerWidth = 0;
        int cellWidth = 0;
        Object[] longValues = model.longValues;
        TableCellRenderer headerRenderer =
            table.getTableHeader().getDefaultRenderer();
 
        for (int i = 0; i < 8; i++) {
            column = table.getColumnModel().getColumn(i);
 
            comp = headerRenderer.getTableCellRendererComponent(
                                 null, column.getHeaderValue(),
                                 false, false, 0, 0);
            headerWidth = comp.getPreferredSize().width;
 
            comp = table.getDefaultRenderer(model.getColumnClass(i)).
                             getTableCellRendererComponent(
                                 table, longValues[i],
                                 false, false, 0, i);
            cellWidth = comp.getPreferredSize().width;
 
            if (true) {
                System.out.println("Initializing width of column "
                                   + i + ". "
                                   + "headerWidth = " + headerWidth
                                   + "; cellWidth = " + cellWidth);
            }
 
            column.setPreferredWidth(Math.max(headerWidth, cellWidth));
        }
    }
 
    public void setUpSportColumn(JTable table,
                                 TableColumn sportColumn) {
        //Set up the editor for the sport cells.
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Snowboarding");
        comboBox.addItem("Rowing");
        comboBox.addItem("Knitting");
        comboBox.addItem("Speed reading");
        comboBox.addItem("Pool");
        comboBox.addItem("None of the above");
        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
 
        //Set up tool tips for the sport cells.
        DefaultTableCellRenderer renderer =
                new DefaultTableCellRenderer();
        renderer.setToolTipText("Click for Selecting project");
        sportColumn.setCellRenderer(renderer);
    }
    
    
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TableRenderDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        TimesheetDemo newContentPane = new TimesheetDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
	
}




class MyTableModel extends AbstractTableModel {
	
	public static Date currentStartDate=new Date(); 
	public static Date currentEndDate=new Date();
	Object[][] data = new Object[2][8];
	
	private static final long serialVersionUID = 1L;
	Calendar cal= Calendar.getInstance();
	//cal.clear();
	String[] columnNames=new String[8];
	MyTableModel(){
		
	}
    
    MyTableModel(int s){
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

    public MyTableModel(String test) {
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

    public MyTableModel(String test,String test1) {
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

    public int getColumnCount() {
        return columnNames.length;
    }
    public String getColumnName(int col) {
        return columnNames[col];
    }
    Calendar initiate(Calendar cal){
    	return cal;
    }
   
    public boolean isCellEditable(int row, int col) {
       
            return true;
    }

	@Override
	public int getRowCount() {
		// Row count equals to number of projects the developer is assigned
		return 2;
	}

	@Override
	 public Object getValueAt(int row, int col) {
        return data[row][col];
	}

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
            //printDebugData();
        }
	}
}