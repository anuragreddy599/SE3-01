/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import handler.ClientHandler;
import handler.PersonProjectHandler;
import handler.TimesheetHandler;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import main.MainMenu;
import pojo.ClientTO;
import pojo.PersonProjectTO;
import pojo.TimesheetTO;
import ui.tableModel.ClientTableModel;
import ui.tableModel.FillTimesheetTableModel;

/**
 *
 * @author Mantu
 */
public class TimesheetsApproveUI extends javax.swing.JDialog {

   boolean addRecord = false;

	private void clearInputBoxes() {
		
		

	}
    
    private void loadRecords() {
		TimesheetHandler timesheetHandler= TimesheetHandler.getInstance();
		List<ClientTO> clientList = timesheetHandler.getAllClients();
	        FillTimesheetTableModel tableModel = new FillTimesheetTableModel(0);
		jTable1.setModel(tableModel);
		jTable1.setSize(1000, 700);
                List<PersonProjectTO> personProjList=timesheetHandler.getListProject();
                int count=0;//personProjList.size();
                
                for(PersonProjectTO personProjectTO:personProjList){
                    jTable1.setValueAt(personProjectTO.getNumber(), count, 0);
                    //jTable1.setValueAt(personProjectTO.getNumber(), count, 0);
                    count++;
                }
                fillSavedData(jTable1);
                //jTable1.setModel(tableModel);
//		jTable1.getSelectionModel().addListSelectionListener(
//				new ListSelectionListener() {
//					public void valueChanged(ListSelectionEvent event) {
//						try {
//							if (jTable1.getSelectedRow() >= 0) {
//								jTextField1.setEnabled(false);
//								// String
//								// code,name,desc,hour,txtAddress1,txtAddress2,txtCity,txtState;
//								Object number = jTable1.getValueAt(
//										jTable1.getSelectedRow(), 0);
//								Object name = jTable1.getValueAt(
//										jTable1.getSelectedRow(), 1);
//                                                                Object address1 = jTable1.getValueAt(
//										jTable1.getSelectedRow(), 2);
//								Object address2 = jTable1.getValueAt(
//										jTable1.getSelectedRow(), 3);
//								Object city = jTable1.getValueAt(
//										jTable1.getSelectedRow(), 4);
//								Object state = jTable1.getValueAt(
//										jTable1.getSelectedRow(), 5);
//								Object zip = jTable1.getValueAt(
//										jTable1.getSelectedRow(), 6);
//								Object email = jTable1.getValueAt(
//										jTable1.getSelectedRow(), 7);
//								Object contact = jTable1.getValueAt(
//										jTable1.getSelectedRow(), 8);
//								Object invoiceFreq = jTable1.getValueAt(
//										jTable1.getSelectedRow(), 9);
//								Object billingTerm = jTable1.getValueAt(
//										jTable1.getSelectedRow(), 10);
//								Object invoiceGrouping = jTable1.getValueAt(
//										jTable1.getSelectedRow(), 11);
//                                                                Object status = jTable1.getValueAt(
//										jTable1.getSelectedRow(), 12);
//
//								jTextField1.setText(number.toString());
//                                                                jTextField2.setText(name.toString());
//                                                                jTextField3.setText(address1.toString());
//                                                                jTextField4.setText(address2.toString());
//                                                                jTextField5.setText(city.toString());
//                                                                jTextField6.setText(state.toString());
//                                                                jTextField7.setText(zip.toString());
//                                                                jTextField8.setText(email.toString());
//                                                                jTextField9.setText(contact.toString());
//                                                                jTextField10.setText(invoiceFreq.toString());
//                                                                if(null!=billingTerm)
//                                                                    jTextField11.setText(billingTerm.toString());
//                                                                if(null!=invoiceGrouping)
//                                                                    jTextField12.setText(invoiceGrouping.toString());
//                                                                if(null!=status)
//                                                                jComboBox1.setSelectedItem(status.toString());
//                                                                
//                                                                
//                                                                
//								
//							}
//						} catch (Exception ex) {
//							ex.printStackTrace();
//						}
//					}
//				});

		

		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		jTable1.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
               System.out.println(jTable1.getModel().getValueAt(0, 0));
	}
    
    
    /**
     * Creates new form TimesheetsUI
     */
    public TimesheetsApproveUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setMinimumSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Approve Timesheet"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(159, 189, 251));
        jButton1.setText("Prev");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(159, 189, 251));
        jButton2.setText("Next");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        jButton3.setBackground(new java.awt.Color(159, 189, 251));
        jButton3.setText("Approve");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(159, 189, 251));
        jButton4.setText("Close");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Developer");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JTable tablem=handlePrev();
  	jTable1.setModel(tablem.getModel());
        
         List<PersonProjectTO> personProjList=TimesheetHandler.getInstance().getListProject();
                int count=0;                
                for(PersonProjectTO personProjectTO:personProjList){
                    jTable1.setValueAt(personProjectTO.getNumber(), count, 0);
                    count++;
                }
                fillSavedData(jTable1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JTable tablem=handleNext();
        jTable1.setModel(tablem.getModel());
        List<PersonProjectTO> personProjList=TimesheetHandler.getInstance().getListProject();
                int count=0;                
                for(PersonProjectTO personProjectTO:personProjList){
                    jTable1.setValueAt(personProjectTO.getNumber(), count, 0);
                    count++;
                }
                fillSavedData(jTable1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // approve the timesheet data
        String selectedDeveloper=jComboBox1.getSelectedItem().toString();
        
        int dialogResult = JOptionPane.showConfirmDialog(null,
				"Are you sure you want to Approve ?",
				"Confirm approve?", JOptionPane.YES_NO_OPTION);

		if (dialogResult == JOptionPane.YES_OPTION) {
			try {
				
					TimesheetHandler.getInstance().approveTimesheets(jTable1,selectedDeveloper);
					String message = "";
					
						message = " Record approved";
					;
					JOptionPane.showMessageDialog(new JFrame(), message,
							"Dialog", JOptionPane.INFORMATION_MESSAGE);

			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
       MainMenu x = new MainMenu();
	getContentPane().getParent().getParent().getParent().setVisible(false);
		// getContentPane().getParent().removeAll();
		x.main(null);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        loadRecords();
    }//GEN-LAST:event_formWindowOpened

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        loadRecords();
        fillSavedData(jTable1);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TimesheetsApproveUI dialog = new TimesheetsApproveUI(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
 JTable handleNext(){
    	
    	FillTimesheetTableModel obj= new FillTimesheetTableModel();
    	//obj.callNext();
    	JTable table = new JTable(new FillTimesheetTableModel("test"));
    	return table;
    }
    JTable handlePrev(){
    	
    	FillTimesheetTableModel obj= new FillTimesheetTableModel();
    	//obj.callNext();
    	JTable table = new JTable(new FillTimesheetTableModel("test","test"));
    	return table;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void loadComboBox(){
        PersonProjectHandler personProjectHandler= PersonProjectHandler.getInstance();
        List<String> developerList = personProjectHandler.getAllDevelopers();
        DefaultComboBoxModel modelDeveloper= new DefaultComboBoxModel(developerList.toArray());
        jComboBox1.setModel(modelDeveloper);
    }
    
    private void fillSavedData(JTable jTable1) {
        try{
            String selectedDeveloper=jComboBox1.getSelectedItem().toString();
       List<TimesheetTO> objList=TimesheetHandler.getInstance().getSavedTimesheetsOfDeveloper(selectedDeveloper);
       for(TimesheetTO timesheetTO:objList){
           int project=timesheetTO.getProject();
           int rowCount=jTable1.getModel().getRowCount();
        List<TimesheetTO> listTO= new ArrayList<TimesheetTO>();
        for(int i=0;i<rowCount;i++){
            if(jTable1.getValueAt(i, 0).equals(project)){
                for(int j=1;j<8;j++){
                    Date dateO=timesheetTO.getDate();
                    System.out.println("dateO :"+dateO);
                    String date=jTable1.getColumnName(j);
                    SimpleDateFormat formatter = new SimpleDateFormat(" EEE dd/MMM/yyyy");
                    Date sdate = formatter.parse(date);
                    System.out.println("sdate :"+sdate);
                    if(dateO.equals(sdate))
                        jTable1.setValueAt(timesheetTO.getDuration(), i, j);
                }
            }
        }
       }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
