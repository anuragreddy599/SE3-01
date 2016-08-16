package service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Client;
import com.entity.Invoice;
import com.entity.InvoiceLineItem;
import java.util.Iterator;
import javax.persistence.PersistenceException;

import pojo.ClientTO;
import pojo.InvoiceTO;
import pojo.LineItemTO;


public class InvoiceService {

	private static InvoiceService instance = null;
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Invoice_PU" );
    
        EntityManager entitymanager = emfactory.createEntityManager( );
	
	   private InvoiceService() {
	      // Exists only to defeat instantiation.
	   }
	   public static InvoiceService getInstance() {
	      if(instance == null) {
	         instance = new InvoiceService();
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

    public int addInvoice(InvoiceTO invoiceToObj) {
        int invoiceNo=0;
        try{
        Invoice invoice=new Invoice();
        invoice.setInvoiceDate(invoiceToObj.getInvoiceDate());
        
        invoice.setProjectNumber(invoiceToObj.getProjectNumber());
        invoice.setTotalAmountDue(invoiceToObj.getTotalAmountDue());
        
         entitymanager.getTransaction( ).begin( );
         entitymanager.persist( invoice );
         invoiceNo=invoice.getInvoiceNo();
         entitymanager.getTransaction( ).commit( );
         
         List<LineItemTO> listLineItem=invoiceToObj.getListLineItem();
            Iterator iter= listLineItem.iterator();
            while(iter.hasNext()){
                LineItemTO lineItemTO=(LineItemTO)iter.next();
                InvoiceLineItem invoiceLineItem= new InvoiceLineItem();
                invoiceLineItem.setAmount(lineItemTO.getAmount());
                invoiceLineItem.setDate(lineItemTO.getDate());
                invoiceLineItem.setDescription(lineItemTO.getDescription());
                invoiceLineItem.setHours(lineItemTO.getHours());
                invoiceLineItem.setRate(lineItemTO.getRate());
                invoiceLineItem.setInvoiceNo(invoiceNo);
                
                entitymanager.getTransaction( ).begin( );
                entitymanager.persist( invoiceLineItem );
                entitymanager.getTransaction( ).commit( );
            }
         
        }catch(PersistenceException e){
            e.printStackTrace();
        }finally{
      //entitymanager.close( );
      //emfactory.close( );
        }
        return invoiceNo;
    }
    
    public ClientTO findInvoice(Long number){
        
        //entitymanager.getTransaction( ).begin( ); 
          Client client=  entitymanager.find(Client.class, (int) (long) number);
          ClientTO obj= new ClientTO();
			obj.setNumber(client.getNumber());
			obj.setName(client.getName());
			obj.setAddressLine1(client.getAddressLine1());
			obj.setAddressLine2(client.getAddressLine2());
			obj.setCity(client.getCity());
			obj.setContact(client.getContact());
			obj.setEmail(client.getEmail());
			obj.setInvoiceFreq(client.getInvoiceFreq());
			obj.setInvoiceGrouping(client.getInvoiceGrouping());
                        obj.setBillingTerms(client.getBillingTerm());
			obj.setState(client.getState());
			obj.setStatus(client.getStatus());
			obj.setZip(client.getZip());
            return obj;            
    }
}
