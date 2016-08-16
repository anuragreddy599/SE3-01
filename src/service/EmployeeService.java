package service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Client;
import com.entity.Employee;


 

public class EmployeeService {

	private static EmployeeService instance = null;
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Invoice_PU" );
    
        EntityManager entitymanager = emfactory.createEntityManager( );
	
	   private EmployeeService() {
	      // Exists only to defeat instantiation.
	   }
	   public static EmployeeService getInstance() {
	      if(instance == null) {
	         instance = new EmployeeService();
	      }
	      return instance;
	   }
	public List<EmployeeTO> getAllEmployees() {
		
		Query query = entitymanager.
	      createQuery("Select e from Employee e");
		List<Employee> listEmployee=query.getResultList();
                
		//Convert from entity to TO
		List<EmployeeTO> listEmployeeTo= new ArrayList<EmployeeTO>();
		for(Employee employeeObj:listEmployee){
			EmployeeTO obj= new EmployeeTO();
			obj.setName(employeeObj.getName());
			obj.setTitle(employeeObj.getTitle());
			obj.setRole(employeeObj.getRole());
			obj.setStatus(employeeObj.getStatus());
			obj.setBillRate(employeeObj.getBillRate());
			
			listEmployeeTo.add(obj);
		}
		return listEmployeeTo;
	}

    public boolean updateEmployee(EmployeeTO employeeObj) {
        try{
           entitymanager.getTransaction( ).begin( ); 
          Employee employee=  entitymanager.find(Employee.class, employeeObj.getName());
       
        employee.setName(employeeObj.getName());
        employee.setTitle(employeeObj.getTitle());
        employee.setRole(employeeObj.getRole());
        employee.setBillRate(employeeObj.getBillRate());
        employee.setStatus(employeeObj.getStatus());
        
         entitymanager.getTransaction( ).commit( );
        }catch(PersistenceException e){
            e.printStackTrace();
        }finally{
      //entitymanager.close( );
      //emfactory.close( );
        }
      return true;  
    }

    public void addEmployee(EmployeeTO employeeObj) {
        try{
        Employee employee=new Employee();
        employee.setName(employeeObj.getName());
        employee.setTitle(employeeObj.getTitle());
        employee.setRole(employeeObj.getRole());
        employee.setBillRate(employeeObj.getBillRate());
        employee.setStatus(employeeObj.getStatus());
        
         entitymanager.getTransaction( ).begin( );
         entitymanager.persist( employee );
         entitymanager.getTransaction( ).commit( );
        }catch(PersistenceException e){
            e.printStackTrace();
        }finally{
      //entitymanager.close( );
      //emfactory.close( );
        }
    }
    
    public EmployeeTO getEmplDetails(String name){
        EmployeeTO obj=null;
        try{
                CriteriaBuilder cb=entitymanager.getCriteriaBuilder();
                CriteriaQuery<Employee> cq=cb.createQuery(Employee.class);
                Root<Employee> root = cq.from(Employee.class);
                cq.where(cb.equal(root.get("name"),name));
              
               TypedQuery<Employee> query = entitymanager.createQuery(cq);

                Employee employeeObj=(Employee) query.getSingleResult();
		
			obj= new EmployeeTO();
			obj.setName(employeeObj.getName());
			obj.setTitle(employeeObj.getTitle());
			obj.setRole(employeeObj.getRole());
			obj.setStatus(employeeObj.getStatus());
			obj.setBillRate(employeeObj.getBillRate());
                        
            }catch(NoResultException e){
                e.printStackTrace();
            }
        return obj;

    }
}
