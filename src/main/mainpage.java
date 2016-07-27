package main;

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




import ui.ClientUI;

import java.util.ArrayList;
import java.util.List;

public class mainpage
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
	            java.util.logging.Logger.getLogger(mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
		
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					mainpage window = new mainpage();
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
	public mainpage()
	{
		initialize();
	}
	private void initialize()
	{
		frame = new JFrame();
		//	univname = null;
		
	/*	lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblWelcome.setForeground(SystemColor.activeCaption);*/
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
						.addGap(30)
						//.addComponent(lblWelcome, GroupLayout.PREFERRED_SIZE, 658, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(27, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(39)
						//.addComponent(lblWelcome, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
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
				/*course x=new course(new javax.swing.JFrame(), true);
				x.main(null);*/
			}
		});
		mnSecurity.add(mntmCourse);

		JMenuItem mntmDegreePlan = new JMenuItem("Client Project");
		mntmDegreePlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				/*degreeplan x=new degreeplan(new javax.swing.JFrame(), true);
				x.main(null);*/
			}
		});
		mnSecurity.add(mntmDegreePlan);
                
                JMenuItem mntmForecast = new JMenuItem("Project");
		mntmForecast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				/*degreeplan x=new degreeplan(new javax.swing.JFrame(), true);
				x.main(null);*/
			}
		});
		mnSecurity.add(mntmForecast);
                
                
                JMenuItem mntmDegreePlanReq = new JMenuItem("Company");
		mntmDegreePlanReq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				/*degreeplanReq x=new degreeplanReq(new javax.swing.JFrame(), true);
				x.main(null);*/
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
				/*generateschedule x=new generateschedule();
				x.main(null);*/
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
        				/*user x=new user();
        				x.main(null);*/
        			}
        		});      
                
                
         JMenuItem logoutItem = new JMenuItem("Log out");
		logoutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				/*MainClassExecute x=new MainClassExecute();
				x.main(null);*/
			}
		});
                menuBar.add(logoutItem);
                
               /* //Initialize all data
                if(!importFile.isImported)
                    importFile.importAllFiles();*/
	}
}