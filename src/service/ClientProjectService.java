package service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.ClientProject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import pojo.ClientProjectTO;



public class ClientProjectService {

	private static ClientProjectService instance = null;
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Invoice_PU" );
    
        EntityManager entitymanager = emfactory.createEntityManager( );
	
	   private ClientProjectService() {
	      // Exists only to defeat instantiation.
	   }
	   public static ClientProjectService getInstance() {
	      if(instance == null) {
	         instance = new ClientProjectService();
	      }
	      return instance;
	   }
	public List<ClientProjectTO> getAllClientProjects() {
		
		Query query = entitymanager.
	      createQuery("Select e from ClientProject e");
		List<ClientProject> listClientProject=query.getResultList();
                
		//Convert from entity to TO
		List<ClientProjectTO> listTo= new ArrayList<ClientProjectTO>();
		for(ClientProject clientObj:listClientProject){
			ClientProjectTO obj= new ClientProjectTO();
                        obj.setId(clientObj.getId());
			obj.setClient(clientObj.getClient());
			obj.setProjectNumber(clientObj.getProjectNumber());
			obj.setProjectName(clientObj.getProjectName());
                        Date sDate=clientObj.getStartDate();
                        Date eDate=clientObj.getEndDate();
                         SimpleDateFormat parseFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
                          
                          SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
                          SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                          String result = null;
                          Date date = null;
                            try {
                                    date = parseFormat.parse(sDate.toString());
                                    result=format.format(date);
                                    obj.setStartDate(formatter.parse(result));
                                    
                                    date = parseFormat.parse(eDate.toString());
                                    result=format.format(date);
                                    obj.setEndDate(formatter.parse(result));
                                    
                                    
                            } catch (ParseException e) {
                                    e.printStackTrace();
                            }
                        
			//obj.setStartDate(sDate);
			//obj.setEndDate(eDate);
			obj.setStatus(clientObj.getStatus());
			obj.setProjectManager(clientObj.getProjectManager());
			obj.setClientContact(clientObj.getClientContact());
			obj.setBudget(clientObj.getBudget());
                        
			listTo.add(obj);
		}
		return listTo;
	}

    public boolean updateClientProject(ClientProjectTO clientObj) {
        try{
           entitymanager.getTransaction( ).begin( ); 
          ClientProject obj=  entitymanager.find(ClientProject.class, clientObj.getId());
       
                        obj.setId(clientObj.getId());
			obj.setClient(clientObj.getClient());
			obj.setProjectNumber(clientObj.getProjectNumber());
			obj.setProjectName(clientObj.getProjectName());
			obj.setStartDate(clientObj.getStartDate());
			obj.setEndDate(clientObj.getEndDate());
			obj.setStatus(clientObj.getStatus());
			obj.setProjectManager(clientObj.getProjectManager());
			obj.setClientContact(clientObj.getClientContact());
			obj.setBudget(clientObj.getBudget());
        
        
         entitymanager.getTransaction( ).commit( );
        }catch(PersistenceException e){
            e.printStackTrace();
        }finally{
      //entitymanager.close( );
      //emfactory.close( );
        }
      return true;  
    }

    public void addClientProject(ClientProjectTO clientObj) {
        try{
        ClientProject obj=new ClientProject();
        obj.setClient(clientObj.getClient());
			obj.setProjectNumber(clientObj.getProjectNumber());
			obj.setProjectName(clientObj.getProjectName());
			obj.setStartDate(clientObj.getStartDate());
			obj.setEndDate(clientObj.getEndDate());
			obj.setStatus(clientObj.getStatus());
			obj.setProjectManager(clientObj.getProjectManager());
			obj.setClientContact(clientObj.getClientContact());
			obj.setBudget(clientObj.getBudget());
         entitymanager.getTransaction( ).begin( );
         entitymanager.persist( obj );
         entitymanager.getTransaction( ).commit( );
        }catch(PersistenceException e){
            e.printStackTrace();
        }finally{
      //entitymanager.close( );
      //emfactory.close( );
        }
    }
    
    public List<Long> findAllProjectsOfClient(Long client){
        
        List<Long> projList=null;
         try{
                CriteriaBuilder cb=entitymanager.getCriteriaBuilder();
                CriteriaQuery<ClientProject> cq=cb.createQuery(ClientProject.class);
                Root<ClientProject> root = cq.from(ClientProject.class);
                cq.where(cb.equal(root.get("client"),client));
              
               TypedQuery<ClientProject> query = entitymanager.createQuery(cq);
                List<ClientProject> clientProjectList= query.getResultList();
                projList=new ArrayList<Long>();
		for(ClientProject clientProject:clientProjectList){
                    projList.add(clientProject.getProjectNumber());
                }
			
            }catch(NoResultException e){
                e.printStackTrace();
            }
         return projList;
    }
    
    public String findProjectName(Long projectNo){
        
       String projectName=null;
         try{
                CriteriaBuilder cb=entitymanager.getCriteriaBuilder();
                CriteriaQuery<ClientProject> cq=cb.createQuery(ClientProject.class);
                Root<ClientProject> root = cq.from(ClientProject.class);
                cq.where(cb.equal(root.get("projectNumber"),projectNo));
              
               TypedQuery<ClientProject> query = entitymanager.createQuery(cq);
                ClientProject clientProject= query.getSingleResult();
                
		
                    projectName=clientProject.getProjectName();
                
			
            }catch(NoResultException e){
                e.printStackTrace();
            }
         return projectName;
    }
    public Long findClientFromProject(Long projectNo){
        
       Long projectName=null;
         try{
                CriteriaBuilder cb=entitymanager.getCriteriaBuilder();
                CriteriaQuery<ClientProject> cq=cb.createQuery(ClientProject.class);
                Root<ClientProject> root = cq.from(ClientProject.class);
                cq.where(cb.equal(root.get("projectNumber"),projectNo));
              
               TypedQuery<ClientProject> query = entitymanager.createQuery(cq);
                ClientProject clientProject= query.getSingleResult();
                
		
                    projectName=clientProject.getClient();
                
			
            }catch(NoResultException e){
                e.printStackTrace();
            }
         return projectName;
    }
}
