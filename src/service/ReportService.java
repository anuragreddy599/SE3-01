package service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Client;
import java.util.Iterator;
import javax.persistence.PersistenceException;
import pojo.BudgetReportTO;
import pojo.ClientProjectTO;

import pojo.ClientTO;
import pojo.InvoiceTO;


public class ReportService {

	private static ReportService instance = null;
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Invoice_PU" );
    
        EntityManager entitymanager = emfactory.createEntityManager( );
	
	   private ReportService() {
	      // Exists only to defeat instantiation.
	   }
	   public static ReportService getInstance() {
	      if(instance == null) {
	         instance = new ReportService();
	      }
	      return instance;
	   }
	public List<BudgetReportTO> getBudgetReport() {
		
            List<ClientProjectTO> listClientProject=ClientProjectService.getInstance().getAllClientProjects();
            Iterator iter=listClientProject.iterator();
            List<BudgetReportTO> listBudgetReport= new ArrayList<>();
            while(iter.hasNext()){
                ClientProjectTO clientProjectTO=(ClientProjectTO)iter.next();
                BudgetReportTO budgetReportTO= new BudgetReportTO();
                List<InvoiceTO> invoiceToList=InvoiceService.getInstance().findInvoiceForBudget(clientProjectTO.getClient(),clientProjectTO.getProjectNumber());
                int totalInvoiceAmountTillDate=0;
                Iterator invIter=invoiceToList.iterator();
                while(invIter.hasNext()){
                    InvoiceTO invoiceTO=(InvoiceTO)invIter.next();
                    totalInvoiceAmountTillDate=totalInvoiceAmountTillDate+Integer.parseInt(invoiceTO.getTotalAmountDue());
                }
                budgetReportTO.setClientId(clientProjectTO.getClient());
                budgetReportTO.setProjectName(clientProjectTO.getProjectName());
                budgetReportTO.setProjectId(clientProjectTO.getProjectNumber());
                budgetReportTO.setTotalBudget(clientProjectTO.getBudget());
                budgetReportTO.setBudgetRemaining(clientProjectTO.getBudget()-totalInvoiceAmountTillDate);
                
                listBudgetReport.add(budgetReportTO);
            }
		
		return listBudgetReport;
	}

   
}
