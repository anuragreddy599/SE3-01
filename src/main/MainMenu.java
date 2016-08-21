package main;

import handler.CompanyHandler;
import handler.InvoiceGenerateHandler;
import handler.LoginHandler;
import java.awt.Desktop;
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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JPanel;




import ui.ClientUI_back;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import pojo.UserTO;
import ui.AssignProjectUI;
import ui.BudgetReport;
import ui.ClientProjectUI;
import ui.ClientUI;
import ui.CompanyUI;
import ui.EmployeeUI;
import ui.HelpUI;
import static ui.HelpUI.stream2file;
import ui.InvoiceReportUI;
import ui.TimesheetsApproveUI;
import ui.TimesheetsReportUI;
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
                frame.setMinimumSize(new java.awt.Dimension(800, 700));
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaption);
		frame.setJMenuBar(menuBar);
                
                //String loggedInRole= MainClassExecute.loggedInRole;
                
		JMenu mnMaintenance = new JMenu("Maintenance");
		menuBar.add(mnMaintenance);

		JMenuItem mntmClient = new JMenuItem("Client");
		mntmClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				ClientUI x=new ClientUI(new javax.swing.JFrame(), true);
				x.main(null);
			}
		});
		mnMaintenance.add(mntmClient);

		JMenuItem mntmEmployee = new JMenuItem("Employee");
		mntmEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
                                
				frame.setVisible(false);
                                 EmployeeUI x=new EmployeeUI(new javax.swing.JFrame(), true);
				x.main(null);
			}
		});
		mnMaintenance.add(mntmEmployee);

		JMenuItem mntmClientProj = new JMenuItem("Client Project");
		mntmClientProj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
                                 ClientProjectUI x=new ClientProjectUI(new javax.swing.JFrame(), true);
				x.main(null);
			}
		});
		mnMaintenance.add(mntmClientProj);
                
                JMenuItem mntmAssignProj = new JMenuItem("Assign Project");
		mntmAssignProj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				AssignProjectUI x=new AssignProjectUI(new javax.swing.JFrame(), true);
				x.main(null);
			}
		});
		mnMaintenance.add(mntmAssignProj);
                
                
                JMenuItem mntmCompany = new JMenuItem("Company");
		mntmCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				CompanyUI x=new CompanyUI(new javax.swing.JFrame(), true);
				x.main(null);
			}
		});
		mnMaintenance.add(mntmCompany);

	
		JMenu mnGenerateInv = new JMenu("Generate Invoice");
               
                    menuBar.add(mnGenerateInv);

		JMenuItem mntmGenerateInvoice = new JMenuItem("Generate Invoice");
		mntmGenerateInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				//frame.setVisible(false);
				InvoiceGenerateHandler.getInstance().generateInvoice();
                                String message="The invoices for each project has  been generated \n and sent to respective client";
                                JOptionPane.showMessageDialog(new JFrame(), message,
							"Dialog", JOptionPane.INFORMATION_MESSAGE);
				//x.main(null);
			}
		});
		mnGenerateInv.add(mntmGenerateInvoice);

		

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
				frame.setVisible(false);
                                BudgetReport x=new BudgetReport(new javax.swing.JFrame(), true);
                                x.main(null);
			}
		});
                mnReport.add(mntmTimesheet_Report);
                mntmTimesheet_Report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
                                TimesheetsReportUI x=new TimesheetsReportUI(new javax.swing.JFrame(), true);
                                x.main(null);
			}
		});    
                
                 JMenuItem mntmInvoice_Report = new JMenuItem("Invoice Report");
                 mnReport.add(mntmInvoice_Report);
                 mntmInvoice_Report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
                                InvoiceReportUI x=new InvoiceReportUI(new javax.swing.JFrame(), true);
                                x.main(null);
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
                
                
                JMenu mnHelp = new JMenu("Help");     
                menuBar.add(mnHelp);
               JMenuItem helpItem = new JMenuItem("Help");
		helpItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
                            Desktop ccc=Desktop.getDesktop();
                            InputStream is=this.getClass().getResourceAsStream("/report/Help screen.pdf");
                        try {
                            File file=stream2file(is);
                            ccc.open(file);//(new File("/report/generateInvoice_1001.pdf"));
                            //add(jPanel1);
                        } catch (IOException ex) {
                            Logger.getLogger(HelpUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
			}
		});
                mnHelp.add(helpItem); 
                
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
                
                
                //Role based menu showing
                UserTO userLoggedIn=LoginHandler.getInstance().getUser();
                if(null!=userLoggedIn){
                String loggedinRole=userLoggedIn.getRole();
                //Admin, Accountant, Developer, Manager
                if(loggedinRole.equals("Admin")){
                    mnGenerateInv.setEnabled(false);
                    mntmTimesheet_Report.setEnabled(false);
                    mnReport.setEnabled(false);
                    mntmAssignProj.setEnabled(false);
                    
                }else if(loggedinRole.equals("Accountant")){
                    mntmAssignProj.setEnabled(false);
                    mnSystem.setEnabled(false);
                    mnTimesheets.setEnabled(false);
                    
                }else if(loggedinRole.equals("Developer")){
                    mnMaintenance.setEnabled(false);
                    mnGenerateInv.setEnabled(false);
                    mntmApproveTimesheet.setEnabled(false);
                    mnReport.setEnabled(false);
                    mnSystem.setEnabled(false);
                }else if(loggedinRole.equals("Manager")){
                    //mnMaintenance.setEnabled(false);
                    mntmClient.setEnabled(false);
                    mntmEmployee.setEnabled(false);
                    mntmClientProj.setEnabled(false);
                    mntmCompany.setEnabled(false);
                    mnGenerateInv.setEnabled(false);
                    mnReport.setEnabled(false);
                    mnSystem.setEnabled(false);
                }
                }
                
                
               /* //Initialize all data
                if(!importFile.isImported)
                    importFile.importAllFiles();*/
	}

    private String getCompanyName() {
        return CompanyHandler.getInstance().getCompany().getName();
    }
    public static File stream2file (InputStream in) throws IOException {
                final File tempFile = File.createTempFile("help", ".pdf");
                tempFile.deleteOnExit();
                try (FileOutputStream out = new FileOutputStream(tempFile)) {
                    IOUtils.copy(in, out);
                }
                return tempFile;
            }
}