package handler;

import java.util.List;

import pojo.ClientTO;
import pojo.EmployeeTO;
import service.ClientService;
import service.EmployeeService;

public class EmployeeHandler {

	private static EmployeeHandler instance = null;
	   private EmployeeHandler() {
	      // Exists only to defeat instantiation.
	   }
	   public static EmployeeHandler getInstance() {
	      if(instance == null) {
	         instance = new EmployeeHandler();
	      }
	      return instance;
	   }
	public List<EmployeeTO> getAllEmployees() {
		// TODO Auto-generated method stub
		
		return EmployeeService.getInstance().getAllEmployees();
	}

    public void addEmployee(EmployeeTO employeeObj) {
        EmployeeService.getInstance().addEmployee(employeeObj);
        
    }

    public boolean updateEmployee(EmployeeTO employeeObj) {
        return EmployeeService.getInstance().updateEmployee(employeeObj);
        
    }

}
