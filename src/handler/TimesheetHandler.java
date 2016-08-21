package handler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.swing.JTable;

import pojo.ClientTO;
import pojo.PersonProjectTO;
import pojo.TimesheetTO;
import service.ClientService;
import service.TimesheetService;

public class TimesheetHandler {

	private static TimesheetHandler instance = null;
	   private TimesheetHandler() {
	      // Exists only to defeat instantiation.
	   }
	   public static TimesheetHandler getInstance() {
	      if(instance == null) {
	         instance = new TimesheetHandler();
	      }
	      return instance;
	   }
	public List<ClientTO> getAllClients() {
		// TODO Auto-generated method stub
		
		return ClientService.getInstance().getAllClients();
	}

    public void addClient(ClientTO clientObj) {
        ClientService.getInstance().addClient(clientObj);
        
    }

    public boolean updateClient(ClientTO clientObj) {
        return ClientService.getInstance().updateClient(clientObj);
        
    }

    public int getRowCount() {
        return getListProject().size();
    }
    
    public List<PersonProjectTO> getListProject(){
        
           return TimesheetService.getInstance().getProjectCount();
    }

    public boolean saveTimesheets(JTable jTable1) {
        try{
        int rowCount=jTable1.getModel().getRowCount();
        List<TimesheetTO> listTO= new ArrayList<TimesheetTO>();
        for(int i=0;i<rowCount;i++){
            for(int j=1;j<8;j++){
                if((null!=jTable1.getValueAt(i, j) && !(jTable1.getValueAt(i, j)).equals(""))){
                    TimesheetTO obj=new TimesheetTO();
                    obj.setProject((int)jTable1.getValueAt(i, 0));
                    System.out.println("Project :"+jTable1.getValueAt(i, 0));
                    obj.setUserId(LoginHandler.getUser().getUserId());
                    //If It is manager then auto approve
                    if(LoginHandler.getUser().getRole().equalsIgnoreCase("Manager")){
                        obj.setApproved(true);
                        obj.setApprovedBy(LoginHandler.getUser().getUserId());
                    }
                    System.out.println("User :"+LoginHandler.getUser().getUserId());
                    String date=jTable1.getColumnName(j);
                    SimpleDateFormat formatter = new SimpleDateFormat(" EEE dd/MMM/yyyy");
                    Date sdate = formatter.parse(date);
                    System.out.println("Date :"+sdate);
                    obj.setDate(sdate);
                    obj.setDuration(Integer.parseInt(String.valueOf(jTable1.getValueAt(i, j))));
                    System.out.println("Duration :"+jTable1.getValueAt(i, j));
                    listTO.add(obj);
                }
            }
               
            }
        TimesheetService.getInstance().saveTimeSheets(listTO);
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }

    public List<TimesheetTO> getSavedTimesheets() {
       return TimesheetService.getInstance().getSavedTimesheets();
    }

    public List<TimesheetTO> getSavedTimesheetsOfDeveloper(String selectedDeveloper) {
        return TimesheetService.getInstance().getSavedTimesheetsOfDeveloper( selectedDeveloper);
    }

    public void approveTimesheets(JTable jTable1, String selectedDeveloper) {
        try{
        int rowCount=jTable1.getModel().getRowCount();
        List<TimesheetTO> listTO= new ArrayList<TimesheetTO>();
        for(int i=0;i<rowCount;i++){
            for(int j=1;j<8;j++){
                if((null!=jTable1.getValueAt(i, j) && !(jTable1.getValueAt(i, j)).equals(""))){
                    TimesheetTO obj=new TimesheetTO();
                    obj.setProject((int)jTable1.getValueAt(i, 0));
                    System.out.println("Project :"+jTable1.getValueAt(i, 0));
                    obj.setUserId(selectedDeveloper);
                    System.out.println("User :"+LoginHandler.getUser().getUserId());
                    String date=jTable1.getColumnName(j);
                    SimpleDateFormat formatter = new SimpleDateFormat(" EEE dd/MMM/yyyy");
                    Date sdate = formatter.parse(date);
                    System.out.println("Date :"+sdate);
                    obj.setDate(sdate);
                    obj.setDuration(Integer.parseInt(String.valueOf(jTable1.getValueAt(i, j))));
                    System.out.println("Duration :"+jTable1.getValueAt(i, j));
                    listTO.add(obj);
                }
            }
               
            }
        TimesheetService.getInstance().approveTimeSheets(listTO);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

   public List<TimesheetTO> getTimesheetsOfProject(Long projectNumber) {
        return TimesheetService.getInstance().getTimesheetsOfProject( projectNumber);
    }

   public int getNumberOfEmplInTimesheet(){
       return TimesheetService.getInstance().getNumberOfEmplInTimesheet( );
   }
   public List<String> getEmplInTimesheet(){
       return TimesheetService.getInstance().getEmplInTimesheet( );
   }

    public Map<String, Object> getWeeklyTimesheets() {
        return TimesheetService.getInstance().getWeeklyTimesheets( );
    }
   
}
