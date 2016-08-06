package service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Client;
import javax.persistence.PersistenceException;

import pojo.ClientTO;


public class ClientService {

	private static ClientService instance = null;
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Invoice_PU" );
    
        EntityManager entitymanager = emfactory.createEntityManager( );
	
	   private ClientService() {
	      // Exists only to defeat instantiation.
	   }
	   public static ClientService getInstance() {
	      if(instance == null) {
	         instance = new ClientService();
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
}
