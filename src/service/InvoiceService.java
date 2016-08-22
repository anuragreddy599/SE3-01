package service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entity.Client;
import com.entity.Invoice;
import com.entity.InvoiceLineItem;
import com.entity.Timesheets;
import java.util.Iterator;
import javax.persistence.PersistenceException;
<<<<<<< HEAD

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

=======
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
>>>>>>> refs/remotes/origin/final
import javax.persistence.criteria.Root;

import pojo.ClientTO;
import pojo.InvoiceTO;
import pojo.LineItemTO;
import pojo.TimesheetTO;


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

   public List<InvoiceTO> findInvoiceForBudget(Long client, Long projectNumber) {
        
       CriteriaBuilder cb=entitymanager.getCriteriaBuilder();
                CriteriaQuery<Invoice> cq=cb.createQuery(Invoice.class);
                Root<Invoice> root = cq.from(Invoice.class);
                //Predicate andClause =  cb.and(cb.equal(root.get("projectNumber"),true));     
                cq.where(cb.equal(root.get("projectNumber"),projectNumber));
                        
                  
                //cq.where(cb.equal(root.get("approved"),true));
               
               TypedQuery<Invoice> query = entitymanager.createQuery(cq);

                List<Invoice> invoiceList= query.getResultList();
                List<InvoiceTO> listTO= new ArrayList<InvoiceTO>();
                for(Invoice invoice:invoiceList){
                    InvoiceTO obj= new InvoiceTO();
                    obj.setInvoiceDate(invoice.getInvoiceDate());
                    obj.setProjectNumber(invoice.getProjectNumber());
                    obj.setTotalAmountDue(invoice.getTotalAmountDue());
                    obj.setInvoiceNo(String.valueOf(invoice.getInvoiceNo()));
                    listTO.add(obj);
                }
                return listTO;
    }

   
   public List<InvoiceTO> getAllInvoice(){
           List<InvoiceTO> listInvoiceTO=new ArrayList<>();
            Query query = entitymanager.
	      createQuery("Select e from Invoice e");
		List<Invoice> listInvoice=query.getResultList();  
                Iterator iter=listInvoice.iterator();
                while(iter.hasNext()){
                    Invoice invoice=(Invoice)iter.next();
                    InvoiceTO invoiceTo= new InvoiceTO();
                    invoiceTo.setProjectNumber(invoice.getProjectNumber());
                    invoiceTo.setInvoiceDate(invoice.getInvoiceDate());
                    invoiceTo.setInvoiceNo(String.valueOf(invoice.getInvoiceNo()));
                    invoiceTo.setTotalAmountDue(invoice.getTotalAmountDue());
                    listInvoiceTO.add(invoiceTo);
                }
              return listInvoiceTO;     
         }

}
