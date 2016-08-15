package service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import com.entity.User;
import javax.persistence.PersistenceException;

import pojo.UserTO;


public class UserService {

	private static UserService instance = null;
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Invoice_PU" );
    
        EntityManager entitymanager = emfactory.createEntityManager( );
	
	   private UserService() {
	      // Exists only to defeat instantiation.
	   }
	   public static UserService getInstance() {
	      if(instance == null) {
	         instance = new UserService();
	      }
	      return instance;
	   }
	public List<UserTO> getAllUsers() {
		
		Query query = entitymanager.
	      createQuery("Select e from User e");
		List<User> listUser=query.getResultList();
                
		//Convert from entity to TO
		List<UserTO> listTo= new ArrayList<UserTO>();
		for(User userObj:listUser){
			UserTO obj= new UserTO();
			obj.setId(userObj.getId());
			obj.setUserId(userObj.getUserId());
			obj.setPassword(userObj.getPassword());
			obj.setRole(userObj.getRole());
			obj.setStatus(userObj.getStatus());
			
			listTo.add(obj);
		}
		return listTo;
	}

    public boolean updateUser(UserTO userObj) {
        try{
           entitymanager.getTransaction( ).begin( ); 
          User user=  entitymanager.find(User.class, userObj.getId());
       
        user.setId(userObj.getId());
        user.setUserId(userObj.getUserId());
        user.setPassword(userObj.getPassword());
        user.setRole(userObj.getRole());
        user.setStatus(userObj.getStatus());
        
        
         entitymanager.getTransaction( ).commit( );
        }catch(PersistenceException e){
            e.printStackTrace();
        }finally{
      //entitymanager.close( );
      //emfactory.close( );
        }
      return true;  
    }

    public void addUser(UserTO userObj) {
        try{
        User user=new User();
        //user.setId(userObj.getId());
        user.setUserId(userObj.getUserId());
        user.setPassword(userObj.getPassword());
        user.setRole(userObj.getRole());
        user.setStatus(userObj.getStatus());
        
         entitymanager.getTransaction( ).begin( );
         entitymanager.persist( user );
         entitymanager.getTransaction( ).commit( );
        }catch(PersistenceException e){
            e.printStackTrace();
        }finally{
      //entitymanager.close( );
      //emfactory.close( );
        }
    }
}
