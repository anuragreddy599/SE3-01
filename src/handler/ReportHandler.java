package handler;

import java.util.List;
import pojo.BudgetReportTO;

import pojo.InvoiceReportTO;
import service.ReportService;

public class ReportHandler {

	private static ReportHandler instance = null;
	   private ReportHandler() {
	      // Exists only to defeat instantiation.
	   }
	   public static ReportHandler getInstance() {
	      if(instance == null) {
	         instance = new ReportHandler();
	      }
	      return instance;
	   }
	public List<BudgetReportTO> getBudgetReport() {
		// TODO Auto-generated method stub
		
		return ReportService.getInstance().getBudgetReport();
	}

   

    public List<InvoiceReportTO> getInvoiceReport() {
        return ReportService.getInstance().getInvoiceReport();
    }

}
