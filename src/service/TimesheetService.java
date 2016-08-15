package service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Client;
import com.entity.ProjectPerson;
import com.entity.Timesheets;
import com.entity.User;
import handler.LoginHandler;
import java.util.Date;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import pojo.ClientTO;
import pojo.PersonProjectTO;
import pojo.TimesheetTO;
import pojo.UserTO;


public class TimesheetService {

	private static TimesheetService instance = null;
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Invoice_PU" );
    
        EntityManager entitymanager = emfactory.createEntityManager( );
	
	   private TimesheetService() {
	      // Exists only to defeat instantiation.
	   }
	   public static TimesheetService getInstance() {
	      if(instance == null) {
	         instance = new TimesheetService();
	      }
	      return instance;
	   }
	public List<ClientTO> getAllClients() {
		
		Query query = entitymanager.
	      createQuery("Select e from Client e");
		List<Client> listClient=query.getResultList();
                
		//Convert from entity to TO
		List<ClientTO> listTo= new ArrayList<ClientTO>();
		for(Client clientObj:listClient){
			ClientTO obj= new ClientTO();
			obj.setNumber(clientObj.getNumber());
			obj.setName(clientObj.getName());
			obj.setAddressLine1(clientObj.getAddressLine1());
			obj.setAddressLine2(clientObj.getAddressLine2());
			obj.setCity(clientObj.getCity());
			obj.setContact(clientObj.getContact());
			obj.setEmail(clientObj.getEmail());
			obj.setInvoiceFreq(clientObj.getInvoiceFreq());
			obj.setInvoiceGrouping(clientObj.getInvoiceGrouping());
                        obj.setBillingTerms(clientObj.getBillingTerm());
			obj.setState(clientObj.getState());
			obj.setStatus(clientObj.getStatus());
			obj.setZip(clientObj.getZip());
			listTo.add(obj);
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

    public List<PersonProjectTO> getProjectCount() {
        int rowCount=0;
        List<PersonProjectTO> listTO=new ArrayList<PersonProjectTO>();
         try{
                UserTO user=LoginHandler.getUser();
                System.out.println("User loggedin :"+user.getUserId());
                CriteriaBuilder cb=entitymanager.getCriteriaBuilder();
                CriteriaQuery<ProjectPerson> cq=cb.createQuery(ProjectPerson.class);
                Root<ProjectPerson> root = cq.from(ProjectPerson.class);
                cq.where(cb.equal(root.get("name"),user.getUserId()));
              
               TypedQuery<ProjectPerson> query = entitymanager.createQuery(cq);

                List<ProjectPerson> projectPersonList= query.getResultList();
                
		for(ProjectPerson projectPerson:projectPersonList){
                    PersonProjectTO obj= new PersonProjectTO();
                    obj.setName(projectPerson.getName());
                    obj.setNumber(projectPerson.getNumber());
                    listTO.add(obj);
                }
		rowCount=projectPersonList.size();
            }catch(NoResultException e){
                e.printStackTrace();
            }	
         return listTO;
    }

    public void saveTimeSheets(List<TimesheetTO> listTO) {
       for(TimesheetTO timesheetObj:listTO){
           Timesheets obj= new Timesheets();
           obj.setDate(timesheetObj.getDate());
           obj.setProject(timesheetObj.getProject());
           obj.setDuration(timesheetObj.getDuration());
           obj.setUserId(timesheetObj.getUserId());
           entitymanager.getTransaction( ).begin( );
         entitymanager.merge(obj );
         entitymanager.getTransaction( ).commit( );
       }
    }

    public List<TimesheetTO> getSavedTimesheets() {
        
        UserTO user=LoginHandler.getUser();
                System.out.println("User loggedin :"+user.getUserId());
                CriteriaBuilder cb=entitymanager.getCriteriaBuilder();
                CriteriaQuery<Timesheets> cq=cb.createQuery(Timesheets.class);
                Root<Timesheets> root = cq.from(Timesheets.class);
                cq.where(cb.equal(root.get("userId"),user.getUserId()));
              
               TypedQuery<Timesheets> query = entitymanager.createQuery(cq);

                List<Timesheets> timesheetList= query.getResultList();
                List<TimesheetTO> listTO= new ArrayList<TimesheetTO>();
                for(Timesheets timesheets:timesheetList){
                    TimesheetTO obj= new TimesheetTO();
                    obj.setDate(timesheets.getDate());
                    obj.setDuration(timesheets.getDuration());
                    obj.setProject(timesheets.getProject());
                    
                    listTO.add(obj);
                }
                return listTO;
    }

    public List<TimesheetTO> getSavedTimesheetsOfDeveloper(String selectedDeveloper) {
            
                System.out.println("Developer :"+selectedDeveloper);
                CriteriaBuilder cb=entitymanager.getCriteriaBuilder();
                CriteriaQuery<Timesheets> cq=cb.createQuery(Timesheets.class);
                Root<Timesheets> root = cq.from(Timesheets.class);
                cq.where(cb.equal(root.get("userId"),selectedDeveloper));
              
               TypedQuery<Timesheets> query = entitymanager.createQuery(cq);

                List<Timesheets> timesheetList= query.getResultList();
                List<TimesheetTO> listTO= new ArrayList<TimesheetTO>();
                for(Timesheets timesheets:timesheetList){
                    TimesheetTO obj= new TimesheetTO();
                    obj.setDate(timesheets.getDate());
                    obj.setDuration(timesheets.getDuration());
                    obj.setProject(timesheets.getProject());
                    
                    listTO.add(obj);
                }
                return listTO;
    }

    public void approveTimeSheets(List<TimesheetTO> listTO) {
        for(TimesheetTO timesheetObj:listTO){
           Timesheets obj= new Timesheets();
           obj.setDate(timesheetObj.getDate());
           obj.setProject(timesheetObj.getProject());
           obj.setDuration(timesheetObj.getDuration());
           obj.setUserId(timesheetObj.getUserId());
           obj.setApproved(true);
           obj.setApprovedBy(LoginHandler.getUser().getUserId());
           obj.setApprovedOn(new Date());
           entitymanager.getTransaction( ).begin( );
         entitymanager.merge(obj );
         entitymanager.getTransaction( ).commit( );
       }
    }

    public List<TimesheetTO> getTimesheetsOfProject(Long projectNumber) {
        CriteriaBuilder cb=entitymanager.getCriteriaBuilder();
                CriteriaQuery<Timesheets> cq=cb.createQuery(Timesheets.class);
                Root<Timesheets> root = cq.from(Timesheets.class);
                Predicate andClause =  cb.and(cb.equal(root.get("approved"),true));     
                cq.where(cb.equal(root.get("project"),projectNumber),andClause );
                        
                  
                //cq.where(cb.equal(root.get("approved"),true));
               
               TypedQuery<Timesheets> query = entitymanager.createQuery(cq);

                List<Timesheets> timesheetList= query.getResultList();
                List<TimesheetTO> listTO= new ArrayList<TimesheetTO>();
                for(Timesheets timesheets:timesheetList){
                    TimesheetTO obj= new TimesheetTO();
                    obj.setDate(timesheets.getDate());
                    obj.setDuration(timesheets.getDuration());
                    obj.setProject(timesheets.getProject());
                    obj.setUserId(timesheets.getUserId());
                    listTO.add(obj);
                }
                return listTO;
    }
}
