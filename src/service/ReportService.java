package service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Client;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.persistence.PersistenceException;
import pojo.BudgetReportTO;
import pojo.ClientProjectTO;

import pojo.ClientTO;
import pojo.InvoiceReportTO;
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

    public List<InvoiceReportTO> getInvoiceReport() {
        List<InvoiceReportTO> listInvoiceReportTO= new ArrayList<>();
        List<InvoiceTO> listInvoiceTO=InvoiceService.getInstance().getAllInvoice();
        Iterator iter= listInvoiceTO.iterator();
        ClientProjectService clientProj=ClientProjectService.getInstance();
        while(iter.hasNext()){
            InvoiceReportTO invoiceReportTO=new InvoiceReportTO();
            InvoiceTO invoiceTO=(InvoiceTO)iter.next();
            invoiceReportTO.setInvoiceNumber(Long.parseLong(invoiceTO.getInvoiceNo()));
           
            
            invoiceReportTO.setInvoiceDate(invoiceTO.getInvoiceDate());
            invoiceReportTO.setTotalAmountDue(Long.parseLong(invoiceTO.getTotalAmountDue()));
            invoiceReportTO.setProjectNumber(invoiceTO.getProjectNumber());
            invoiceReportTO.setClientId(clientProj.findClientFromProject(invoiceTO.getProjectNumber()));
            invoiceReportTO.setProjectName(clientProj.findProjectName(invoiceTO.getProjectNumber()));
            listInvoiceReportTO.add(invoiceReportTO);
        }
        return listInvoiceReportTO;
    }

   
}
