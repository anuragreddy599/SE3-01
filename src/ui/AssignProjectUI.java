/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import handler.ClientHandler;
import handler.PersonProjectHandler;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import main.MainMenu;
import pojo.ClientTO;
import pojo.PersonProjectTO;
import ui.tableModel.ClientTableModel;
import ui.tableModel.PersonProjectTableModel;

/**
 *
 * @author Mantu
 */
public class AssignProjectUI extends javax.swing.JDialog {

    boolean addRecord = false;

	private void clearInputBoxes() {
		
                //jComboBox1.setSelectedItem("Active");
		

	}

        private boolean addNew()  {
           PersonProjectHandler personProjectHandler= PersonProjectHandler.getInstance();
            PersonProjectTO personProjectTO=new PersonProjectTO();
                
                personProjectTO.setNumber(Integer.parseInt(jComboBox1.getSelectedItem().toString()));
                personProjectTO.setName(jComboBox2.getSelectedItem().toString());
		personProjectHandler.addRecord(personProjectTO);
		
		return true;
	}

	private boolean updateRecord() {
		ClientHandler clientHandler= ClientHandler.getInstance();
            ClientTO clientObj=new ClientTO();
                
		boolean flag=clientHandler.updateClient(clientObj);

		return flag;
	}

	

        
        private void loadRecords() {
		PersonProjectHandler personProjectHandler= PersonProjectHandler.getInstance();
		List<PersonProjectTO> peronProjectList = personProjectHandler.getAllAssignedData();
		PersonProjectTableModel tableModel = new PersonProjectTableModel(peronProjectList);
		jTable1.setModel(tableModel);
		jTable1.setSize(1000, 700);
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
	}
    
    private void loadComboBox(){
        PersonProjectHandler personProjectHandler= PersonProjectHandler.getInstance();
	List<String> projectList = personProjectHandler.getAllProjects();
        DefaultComboBoxModel modelProject= new DefaultComboBoxModel(projectList.toArray());
        jComboBox1.setModel(modelProject);
        
        List<String> developerList = personProjectHandler.getAllDevelopers();
        DefaultComboBoxModel modelDeveloper= new DefaultComboBoxModel(developerList.toArray());
        jComboBox2.setModel(modelDeveloper);
        
    }
            
    
    /**
     * Creates new form AssignProjectUI
     */
    public AssignProjectUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Assign Project to Developers"));

        jLabel1.setText("Project");

        jLabel2.setText("Developer");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 276, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(159, 189, 251));
        jButton1.setText("Assign");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(159, 189, 251));
        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        MainMenu x = new MainMenu();
        getContentPane().getParent().getParent().getParent().setVisible(false);
		// getContentPane().getParent().removeAll();
		x.main(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
         loadRecords();
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int dialogResult = JOptionPane.showConfirmDialog(null,
				"Are you sure you want to Assign the project?",
				"Confirm Update Record?", JOptionPane.YES_NO_OPTION);

		if (dialogResult == JOptionPane.YES_OPTION) {
			try {
				
					boolean ret = addNew();
					String message = "";
					if (ret) {
						message = " Record updated";
					} else
						message = " Record failed to update";
					JOptionPane.showMessageDialog(new JFrame(), message,
							"Dialog", JOptionPane.INFORMATION_MESSAGE);

				

				addRecord = false;
				loadRecords();
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AssignProjectUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AssignProjectUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AssignProjectUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AssignProjectUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AssignProjectUI dialog = new AssignProjectUI(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
