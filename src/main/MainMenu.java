package main;

import handler.CompanyHandler;
//import handler.InvoiceGenerateHandler;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JPanel;




import ui.ClientUI_back;

import java.util.ArrayList;
import java.util.List;
import ui.AssignProjectUI;
import ui.ClientProjectUI;
import ui.ClientUI;
import ui.CompanyUI;
import ui.EmployeeUI;
import ui.TimesheetsApproveUI;
import ui.TimesheetsUI;
import ui.UserUI;

public class MainMenu
{
	JLabel lblWelcome;
	private JFrame frame;
	static String univname;
	
	public static void main(String[] args)
	{
		 try { 
				for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		             if ("Nimbus".equals(info.getName())) {
		                 javax.swing.UIManager.setLookAndFeel(info.getClassName());
		                 break;
		             }
		         }
		 } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
		
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MainMenu window = new MainMenu();
					window.frame.setTitle("Eagle Consulting Invoice Ltd. ");
					window.frame.setSize(700,500);
					window.frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	public MainMenu()
	{
		initialize();
	}
	private void initialize()
	{
                String companyName=getCompanyName();
                companyName="<html> &nbsp; &nbsp; Welcome To <br/> "+companyName +"</html>";
		frame = new JFrame();
		//	univname = null;
		lblWelcome = new JLabel(companyName, SwingConstants.CENTER);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblWelcome.setForeground(SystemColor.activeCaption);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
						.addGap(30)
						.addComponent(lblWelcome, GroupLayout.PREFERRED_SIZE, 658, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(27, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(39)
						.addComponent(lblWelcome, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(101, Short.MAX_VALUE))
				);
		frame.getContentPane().setLayout(groupLayout);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaption);
		frame.setJMenuBar(menuBar);
                
                //String loggedInRole= MainClassExecute.loggedInRole;
                
		JMenu mnSecurity = new JMenu("Maintenance");
		menuBar.add(mnSecurity);

		JMenuItem mntmXyz = new JMenuItem("Client");
		mntmXyz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				ClientUI x=new ClientUI(new javax.swing.JFrame(), true);
				x.main(null);
			}
		});
		mnSecurity.add(mntmXyz);

		JMenuItem mntmCourse = new JMenuItem("Employee");
		mntmCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
                                
				frame.setVisible(false);
                                 EmployeeUI x=new EmployeeUI(new javax.swing.JFrame(), true);
				x.main(null);
			}
		});
		mnSecurity.add(mntmCourse);

		JMenuItem mntmDegreePlan = new JMenuItem("Client Project");
		mntmDegreePlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
                                 ClientProjectUI x=new ClientProjectUI(new javax.swing.JFrame(), true);
				x.main(null);
			}
		});
		mnSecurity.add(mntmDegreePlan);
                
                JMenuItem mntmForecast = new JMenuItem(" Assign Project");
		mntmForecast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				AssignProjectUI x=new AssignProjectUI(new javax.swing.JFrame(), true);
				x.main(null);
			}
		});
		mnSecurity.add(mntmForecast);
                
                
                JMenuItem mntmDegreePlanReq = new JMenuItem("Company");
		mntmDegreePlanReq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				CompanyUI x=new CompanyUI(new javax.swing.JFrame(), true);
				x.main(null);
			}
		});
		mnSecurity.add(mntmDegreePlanReq);

	
		JMenu mnSchedule = new JMenu("Generate Invoice");
               
                    menuBar.add(mnSchedule);

		JMenuItem mntmGenerateSchedule = new JMenuItem("Generate Invoice");
		mntmGenerateSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				//InvoiceGenerateHandler.getInstance().generateInvoice();
				//x.main(null);
			}
		});
		mnSchedule.add(mntmGenerateSchedule);

		

		JMenu mnTimesheets = new JMenu("Timesheets");     
        menuBar.add(mnTimesheets);
   
        mnTimesheets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				/*user x=new user();
				x.main(null);*/
			}
		});
         //mnSystem.add(mntmUser);
         JMenuItem mntmFillTimesheet = new JMenuItem("Fill Timesheets");
		mntmFillTimesheet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				TimesheetsUI x=new TimesheetsUI(new javax.swing.JFrame(), true);
				x.main(null);
			}
		});
		mnTimesheets.add(mntmFillTimesheet);
                
           JMenuItem mntmApproveTimesheet = new JMenuItem("Approve Timesheets");
		mntmApproveTimesheet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				TimesheetsApproveUI x=new TimesheetsApproveUI(new javax.swing.JFrame(), true);
				x.main(null);
			}
		});
		mnTimesheets.add(mntmApproveTimesheet);     
      
        JMenu mnReport = new JMenu("Generate Report");
               
                    menuBar.add(mnReport);

                JMenuItem mntmBudget_Report = new JMenuItem("Budget Report");
                mnReport.add(mntmBudget_Report);
                JMenuItem mntmTimesheet_Report = new JMenuItem("Timesheet Report ");
                mnReport.add(mntmTimesheet_Report);
               
                mnReport.add(mntmBudget_Report);
                mntmBudget_Report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
                mnReport.add(mntmTimesheet_Report);
                mntmTimesheet_Report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});      
		
                JMenu mnSystem = new JMenu("System");     
                menuBar.add(mnSystem);
                JMenuItem mntmUser = new JMenuItem("Maintain User");
                mnSystem.add(mntmUser);
                mntmUser.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent arg0) 
        			{
        				frame.setVisible(false);
        				UserUI x=new UserUI(new javax.swing.JFrame(), true);
        				x.main(null);
        			}
        		});      
                
                
         JMenuItem logoutItem = new JMenuItem("Log out");
		logoutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				Login x=new Login();
				x.main(null);
			}
		});
                menuBar.add(logoutItem);
                
               /* //Initialize all data
                if(!importFile.isImported)
                    importFile.importAllFiles();*/
	}

    private String getCompanyName() {
        return CompanyHandler.getInstance().getCompany().getName();
    }
}