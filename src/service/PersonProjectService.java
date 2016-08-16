package service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Client;
import com.entity.Employee;
import com.entity.ProjectPerson;
import com.entity.User;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import pojo.ClientTO;
import pojo.PersonProjectTO;


public class PersonProjectService {

	private static PersonProjectService instance = null;
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Invoice_PU" );
    
        EntityManager entitymanager = emfactory.createEntityManager( );
	
	   private PersonProjectService() {
	      // Exists only to defeat instantiation.
	   }
	   public static PersonProjectService getInstance() {
	      if(instance == null) {
	         instance = new PersonProjectService();
	      }
	      return instance;
	   }
	public List<String> getAllProjects() {
		
		Query query = entitymanager.
	      createQuery("Select e.projectNumber from ClientProject e");
		List<String> listProject=query.getResultList();
                
		//Convert from entity to TO
		List<String> listTo= new ArrayList<String>();
		
		return listProject;
	}
        public List<String> getAllDevelopers() {
		
		CriteriaBuilder cb=entitymanager.getCriteriaBuilder();
                CriteriaQuery<Employee> cq=cb.createQuery(Employee.class);
                Root<Employee> root = cq.from(Employee.class);
                cq.where(cb.equal(root.get("role"),"Developer"));
              
               TypedQuery<Employee> query = entitymanager.createQuery(cq);

                List<Employee> employeeList= query.getResultList();
	            
		//Convert from entity to TO
		List<String> listTo= new ArrayList<String>();
		for(Employee empObj:employeeList){
			
			listTo.add(empObj.getName());
		}
		return listTo;
	}

    public boolean updateClient(ClientTO clientObj) {
        try{
           entitymanager.getTransaction( ).begin( ); 
          Client client=  entitymanager.find(Client.class, clientObj.getNumber());
       
        client.setNumber(clientObj.getNumber());
        client.setName(clientObj.getName());
        client.setAddressLine1(clientObj.getAddressLine1());
        client.setAddressLine2(clientObj.getAddressLine2());
        client.setCity(clientObj.getCity());
        client.setState(clientObj.getState());
        client.setZip(clientObj.getZip());
        client.setEmail(clientObj.getEmail());
        client.setContact(clientObj.getContact());
        client.setInvoiceFreq(clientObj.getInvoiceFreq());
        client.setBillingTerm(clientObj.getBillingTerms());
        client.setInvoiceGrouping(clientObj.getInvoiceGrouping());
        client.setStatus(clientObj.getStatus());
        
        
         entitymanager.getTransaction( ).commit( );
        }catch(PersistenceException e){
            e.printStackTrace();
        }finally{
      //entitymanager.close( );
      //emfactory.close( );
        }
      return true;  
    }

    public void addClient(ClientTO clientObj) {
        try{
        Client client=new Client();
        client.setNumber(clientObj.getNumber());
        client.setName(clientObj.getName());
        client.setAddressLine1(clientObj.getAddressLine1());
        client.setAddressLine2(clientObj.getAddressLine2());
        client.setCity(clientObj.getCity());
        client.setState(clientObj.getState());
        client.setZip(clientObj.getZip());
        client.setEmail(clientObj.getEmail());
        client.setContact(clientObj.getContact());
        client.setInvoiceFreq(clientObj.getInvoiceFreq());
        client.setBillingTerm(clientObj.getBillingTerms());
        client.setInvoiceGrouping(clientObj.getInvoiceGrouping());
        client.setStatus(clientObj.getStatus());
         entitymanager.getTransaction( ).begin( );
         entitymanager.persist( client );
         entitymanager.getTransaction( ).commit( );
        }catch(PersistenceException e){
            e.printStackTrace();
        }finally{
      //entitymanager.close( );
      //emfactory.close( );
        }
    }

    public List<PersonProjectTO> getAllAssignedData() {
        Query query = entitymanager.
	      createQuery("Select e from ProjectPerson e");
		List<ProjectPerson> listProjectPerson=query.getResultList();
                //Convert from entity to TO
		List<PersonProjectTO> listTo= new ArrayList<PersonProjectTO>();
                for(ProjectPerson projectPerson:listProjectPerson){
                    PersonProjectTO personProjectTO= new PersonProjectTO();
                    personProjectTO.setName(projectPerson.getName());
                    personProjectTO.setNumber(projectPerson.getNumber());
                   listTo.add(personProjectTO);
                }
	return listTo;	
    }

    public void addRecord(PersonProjectTO personObj) {
        try{
            ProjectPerson projectPerson=new ProjectPerson();
            projectPerson.setNumber(personObj.getNumber());
            projectPerson.setName(personObj.getName());
            
             entitymanager.getTransaction( ).begin( );
             entitymanager.persist( projectPerson );
             entitymanager.getTransaction( ).commit( );
        }catch(PersistenceException e){
            e.printStackTrace();
        }finally{
      //entitymanager.close( );
      //emfactory.close( );
        }
    }
}
