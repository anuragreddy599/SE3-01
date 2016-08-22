package handler;

import com.entity.Invoice;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.activation.DataSource;
import javax.mail.util.ByteArrayDataSource;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import pojo.ClientProjectTO;
import pojo.ClientTO;
import pojo.CompanyTO;
import pojo.EmployeeTO;
import pojo.InvoiceGenTO;
import pojo.InvoiceTO;
import pojo.LineItemTO;
import pojo.TimesheetTO;
import service.ClientProjectService;
import service.ClientService;
import service.CompanyService;
import service.EmployeeService;
import service.InvoiceGenerateService;
import service.InvoiceService;
import service.JavaMailService;


public class InvoiceGenerateHandler {

    final static long MILLIS_PER_DAY = 24 * 3600 * 1000;
	private static InvoiceGenerateHandler instance = null;
	   private InvoiceGenerateHandler() {
	      // Exists only to defeat instantiation.
	   }
	   public static InvoiceGenerateHandler getInstance() {
	      if(instance == null) {
	         instance = new InvoiceGenerateHandler();
	      }
	      return instance;
	   }

    public boolean generateInvoice() {
        
       Map <Long,InvoiceGenTO> invoiceMap= getConsolidatedData();
       Map <Long,InvoiceGenTO> filteredMap= filterBasedOnLastInvoiceDate(invoiceMap);
       //Iterate map for each client
       Iterator<Map.Entry<Long, InvoiceGenTO>> iter = filteredMap.entrySet().iterator();
            while (iter.hasNext()) {
                //Iterate through each projects of client
                Map.Entry<Long, InvoiceGenTO> entry = iter.next();
                InvoiceGenTO invoiceGenTO=entry.getValue();
                Map<Long, List<TimesheetTO>> timesheetsTO=invoiceGenTO.getTimeSheets();
                if(null!=timesheetsTO){
                Iterator<Map.Entry<Long, List<TimesheetTO>>> projIter = timesheetsTO.entrySet().iterator();
                Date lastInvoiceDate=invoiceGenTO.getLastInvoiceDate();
                while(projIter.hasNext()){
                   Map.Entry<Long, List<TimesheetTO>> projEntry = projIter.next();
                    List<TimesheetTO> listTimesheet=projEntry.getValue();
                    //Get developer wise timesheets
                    if(listTimesheet.size()!=0){
                        Map<String, List<TimesheetTO>> developerWiseTime= getDeveloperWiseTimesheets(listTimesheet);
                        InvoiceTO invoiceTO=prepareDataForInvoiceLineItem(entry.getKey(),projEntry.getKey(),developerWiseTime);

                        //Send to generate PDF
                        handleGenerateAndSendInvoicePDF(invoiceTO);
                    }
                    
                }
            }
<<<<<<< HEAD
=======
            }
>>>>>>> refs/remotes/origin/final
        return true;
    }

    private Map<Long, InvoiceGenTO> getConsolidatedData() {
        
        //Get the client list
        //Get the invoice generated 
        //Retrieve the invoice freq of each client
        InvoiceGenerateService invService=InvoiceGenerateService.getInstance();
        ClientService clientService=ClientService.getInstance();
        ClientProjectService clienttProjecService=ClientProjectService.getInstance();
        List<ClientProjectTO> clientProjectList=clienttProjecService.getAllClientProjects();
        List<ClientTO> listClient=clientService.getAllClients();
        //This map conaints client wise project and timesheets duration
        //client--->project----->timesheet durations
        Map <Long,InvoiceGenTO> map= new HashMap<Long,InvoiceGenTO>();
        //Get the project list of each client
        for(ClientProjectTO clientProjectTO:clientProjectList){
           
            if(map.containsKey(clientProjectTO.getClient())){
                InvoiceGenTO obj=map.get(clientProjectTO.getClient());
                List<Long> projList=obj.getProjectList();
                projList.add(clientProjectTO.getProjectNumber());
                obj.setProjectList(projList);
                List<TimesheetTO> listTimesheet=TimesheetHandler.getInstance().getTimesheetsOfProject(clientProjectTO.getProjectNumber());
                
                if(null!=obj.getTimeSheets()){
                    Map<Long, List<TimesheetTO>> timesMap=obj.getTimeSheets();
                    if(!timesMap.containsKey(clientProjectTO.getProjectNumber())){
                        timesMap.put(clientProjectTO.getProjectNumber(), listTimesheet);
                         obj.setTimeSheets(timesMap);
                    }
                }else{
                    Map<Long, List<TimesheetTO>> newMap= new HashMap<Long, List<TimesheetTO>>();  
                    newMap.put(clientProjectTO.getProjectNumber(), listTimesheet);
                    obj.setTimeSheets(newMap);
                }
                
                map.put(clientProjectTO.getClient(), obj);
            }else{
                InvoiceGenTO obj=new InvoiceGenTO();
                obj.setClient(clientProjectTO.getClient());
                List<Long> projList=new ArrayList<Long>();
                projList.add(clientProjectTO.getProjectNumber());
                obj.setProjectList(projList);
                List<TimesheetTO> listTimesheet=TimesheetHandler.getInstance().getTimesheetsOfProject(clientProjectTO.getProjectNumber());
                 Map<Long, List<TimesheetTO>> newMap= new HashMap<Long, List<TimesheetTO>>();  
                    newMap.put(clientProjectTO.getProjectNumber(), listTimesheet);
                    obj.setTimeSheets(newMap);
                    
                    
                 //Get the invoice freq and last invoice date
                ClientTO clientTO=clientService.findClient(clientProjectTO.getClient());
                Invoice invoice=invService.getInvoice(clientProjectTO.getClient());
                obj.setInvoiceFreq(clientTO.getInvoiceFreq());
                if(invoice!=null)
                    obj.setLastInvoiceDate(invoice.getInvoiceDate());   
                    
                map.put(clientProjectTO.getClient(), obj);
            }
           
            
        }
        return map;
    }

    private Map<Long, InvoiceGenTO> filterBasedOnLastInvoiceDate(Map<Long, InvoiceGenTO> invoiceMap) {
        ConcurrentHashMap<Long, InvoiceGenTO> cc= new ConcurrentHashMap<Long, InvoiceGenTO>();
            cc.putAll(invoiceMap);
            Iterator<Map.Entry<Long, InvoiceGenTO>> iter = invoiceMap.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<Long, InvoiceGenTO> entry = iter.next();
                InvoiceGenTO invoiceGenTO=entry.getValue();
                String invoiceFreq=invoiceGenTO.getInvoiceFreq();
                Date lastInvoiceDate=invoiceGenTO.getLastInvoiceDate();
                if(invoiceFreq.equals("Weekly")){
                    Date currentDate=new Date();
                    if(null!=lastInvoiceDate){
                        long msDiff=currentDate.getTime()-lastInvoiceDate.getTime();
                       long daysDiff = Math.round(msDiff / ((double)MILLIS_PER_DAY)); 
                       if( daysDiff<7){
                           iter.remove();
                       }
                    }
                }
                if(invoiceFreq.equals("BiWeekly")){
                    Date currentDate=new Date();
                   if(null!=lastInvoiceDate){
                        long msDiff=currentDate.getTime()-lastInvoiceDate.getTime();
                       long daysDiff = Math.round(msDiff / ((double)MILLIS_PER_DAY)); 
                       if( daysDiff<14){
                           iter.remove();
                       }
                    }
                }
                if(invoiceFreq.equals("Monthly")){
                    Date currentDate=new Date();
                    if(null!=lastInvoiceDate){
                        long msDiff=currentDate.getTime()-lastInvoiceDate.getTime();
                       long daysDiff = Math.round(msDiff / ((double)MILLIS_PER_DAY)); 
                       if( daysDiff<30){
                           iter.remove();
                       }
                    }
                }
<<<<<<< HEAD
=======
                if(invoiceFreq.equals("Monthly-Cal")){
                    Date currentDate=new Date();
                    invoiceGenTO=removeTimesheets(invoiceGenTO,lastInvoiceDate);
                    invoiceMap.put(entry.getKey(), invoiceGenTO);
//                    if(null!=lastInvoiceDate){
//                        long msDiff=currentDate.getTime()-lastInvoiceDate.getTime();
//                       long daysDiff = Math.round(msDiff / ((double)MILLIS_PER_DAY)); 
//                       if( daysDiff<30){
//                           iter.remove();
//                       }
//                    }
                }
>>>>>>> refs/remotes/origin/final
               
            }
                return invoiceMap;
    }

    private Map<String, List<TimesheetTO>> getDeveloperWiseTimesheets(List<TimesheetTO> listTimesheet) {
            
        Map<String, List<TimesheetTO>> map= new HashMap<String, List<TimesheetTO>>();
        Iterator iter= listTimesheet.iterator();
        while(iter.hasNext()){
            TimesheetTO timesheet=(TimesheetTO )iter.next();
            if(map.containsKey(timesheet.getUserId())){
                List<TimesheetTO> listTime=map.get(timesheet.getUserId());
                listTime.add(timesheet);
                map.put(timesheet.getUserId(), listTime);
            }else{
                List<TimesheetTO> list= new ArrayList<TimesheetTO>();
                list.add(timesheet);
                map.put(timesheet.getUserId(), list);
        }
        
        }
	return map;

    }

    private InvoiceTO prepareDataForInvoiceLineItem(Long clinetId, Long projectId, Map<String, List<TimesheetTO>> developerWiseTime) {
        InvoiceTO invoiceTO= new InvoiceTO();
        invoiceTO.setInvoiceDate(new Date());
        invoiceTO.setProjectNumber(projectId);
        invoiceTO.setClient(clinetId);
        
        List<LineItemTO> listLineItem= new ArrayList<LineItemTO>();
        Iterator<Map.Entry<String, List<TimesheetTO>>> iter = developerWiseTime.entrySet().iterator();
        int totalAmountDue=0;
            while (iter.hasNext()) {
                Map.Entry<String, List<TimesheetTO>> entry=iter.next();
                List<TimesheetTO> listTime=entry.getValue();
                //Set the values in lineitem
                Date fromDate=null;
                Date toDate= null;
                List<Date> listDate= new ArrayList<Date>();
                int duration=0;
                LineItemTO lineItemTO= new LineItemTO();
                lineItemTO.setDescription(entry.getKey());
                Iterator iterTime=listTime.iterator();
                while(iterTime.hasNext()){
                    TimesheetTO timesheetTO=(TimesheetTO)iterTime.next();
                    if(timesheetTO.getProject()==projectId){
                    Date d=timesheetTO.getDate();
                    listDate.add(d);
                    duration=duration+timesheetTO.getDuration();
                    }
                }
                lineItemTO.setHours(duration);
                Collections.sort(listDate);
                
                
                String dateS=formatDate(listDate.get(0))+" To "+formatDate(listDate.get(listDate.size()-1));
                lineItemTO.setDate(dateS);
                EmployeeTO empTO=EmployeeService.getInstance().getEmplDetails(entry.getKey());
                lineItemTO.setRate(empTO.getBillRate());
                totalAmountDue=totalAmountDue+(duration* empTO.getBillRate());
                lineItemTO.setAmount(duration* empTO.getBillRate());
                listLineItem.add(lineItemTO);
            }
       
        invoiceTO.setTotalAmountDue(String.valueOf(totalAmountDue));
        invoiceTO.setListLineItem(listLineItem);
        
        return invoiceTO;
    }

    private void handleGenerateAndSendInvoicePDF(InvoiceTO invoiceTO) {
        
        try{
        //Save the invoice details for the client
          invoiceTO.setInvoiceDate(new Date());
          int invoiceNo=InvoiceService.getInstance().addInvoice(invoiceTO);
          invoiceTO.setInvoiceNo(String.valueOf(invoiceNo));
          //Generate PDF
          DataSource attachement=generateJasperPDF(invoiceTO);
        // Create Email
        //Attach the generated PDF 
        Map<String,Object> mailData=new HashMap<String,Object>();
        mailData.put("attachment", attachement);
        mailData.put("project",invoiceTO.getProjectNumber());
        ClientTO clientObj=ClientService.getInstance().findClient(invoiceTO.getClient());
        mailData.put("clientEmail",clientObj.getEmail());
        //Send email to client with registered email
        if(attachement!=null)
            JavaMailService.getInstance().sendMail(mailData);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private DataSource generateJasperPDF(InvoiceTO invoiceTO) {
        JasperPrint jasperPrint = null;
        DataSource aAttachment=null;
        try{
		
            InputStream is=this.getClass().getResourceAsStream("/report/generateInvoice.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(is);
        is.close();
        Collection<Map<String, ?>> list = new ArrayList<Map<String,?>>();
       
       Map mapDs= new HashMap();
       mapDs.put("clientId", invoiceTO.getClient());
       ClientTO client=ClientService.getInstance().findClient(invoiceTO.getClient());
       mapDs.put("clientName",client.getName());
       mapDs.put("clientAddress1",client.getAddressLine1());
       mapDs.put("clientAddress2",client.getAddressLine2());
       mapDs.put("clientCity",client.getCity());
       mapDs.put("clientState",client.getState());
       mapDs.put("clientZip",client.getZip());
       mapDs.put("paymentTerm",client.getBillingTerms());
       mapDs.put("billingFreq",client.getInvoiceFreq());
      
       CompanyTO  companyTO= CompanyService.getInstance().getCompany();
       mapDs.put("companyName",companyTO.getName());
       mapDs.put("companyAddress1",companyTO.getAddressLine1());
       mapDs.put("companyAddress2",companyTO.getAddressLine2());
       mapDs.put("companyCity",companyTO.getCity());
       mapDs.put("companyState",companyTO.getState());
       mapDs.put("companyZip",companyTO.getZip());
       
       String projName=ClientProjectService.getInstance().findProjectName(invoiceTO.getProjectNumber());
       mapDs.put("projectName",projName);
       
       mapDs.put("invoiceNo",invoiceTO.getInvoiceNo());
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String sDate= sdf.format(date);
       mapDs.put("invoiceDate",sDate);
       mapDs.put("totalAmountDue",invoiceTO.getTotalAmountDue());
       mapDs.put("Logo","logo");
       
       List<Map<String,?>> listLine= new ArrayList<Map<String,?>>();
       List<LineItemTO> lineItemList=invoiceTO.getListLineItem();
       Iterator iter= lineItemList.iterator();
       while(iter.hasNext()){
           LineItemTO obj=(LineItemTO)iter.next();
           Map<String,String> map= new HashMap<String,String>();
           map.put("date", obj.getDate());
           map.put("description", obj.getDescription());
           map.put("rate", String.valueOf(obj.getRate()));
           map.put("hours", String.valueOf(obj.getHours()));
           map.put("amount", String.valueOf(obj.getAmount()));
           listLine.add(map);
       }
       mapDs.put("lineItemList", listLine);
       list.add(mapDs);
       

        //JRMapCollectionDataSource mapColDataSource = new JRMapCollectionDataSource(col);
        Map parameters = new HashMap();
        parameters.put("INFO", "Hello");
        String imagePath =this.getClass().getResource("/image/logo1.png").toString();
        parameters.put("imagePath",imagePath);
        parameters.put("lineItemList", new JRMapCollectionDataSource(listLine));
        //parameters.put("lineItemList", listLine);

       jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JRMapCollectionDataSource(list));
       System.out.println("Printing.......");
       
<<<<<<< HEAD
//       /* START :Enable this to generate pdf file instead of send email*/
//            String outputFile="G:/Documents/Anurag/Project2/workspace_eclipse/generatedInvoice/generateInvoice_"+invoiceTO.getProjectNumber()+".pdf";
//            /* outputStream to create PDF */
//            OutputStream outputStream = new FileOutputStream(new File(outputFile));
//            /* Write content to PDF file */
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
//            outputStream.flush();
//            outputStream.close();
//            /* END :Enable this to generate pdf file instead of send email*/
            
=======
      /*  START :Enable this to generate pdf file instead of send email
            String outputFile="G:/Documents/Anurag/Project2/workspace_eclipse/generatedInvoice/generateInvoice_"+invoiceTO.getProjectNumber()+".pdf";
             outputStream to create PDF 
            OutputStream outputStream = new FileOutputStream(new File(outputFile));
             Write content to PDF file 
>>>>>>> refs/remotes/origin/final
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
            outputStream.flush();
            outputStream.close();
             END :Enable this to generate pdf file instead of send email*/
            
          ByteArrayOutputStream baos = new ByteArrayOutputStream();
           JasperExportManager.exportReportToPdfStream(jasperPrint, baos);// Commented to 
            aAttachment =  new ByteArrayDataSource(baos.toByteArray(), "application/pdf");

 //     ByteArrayOutputStream baos =new ByteArrayOutputStream();
//       JasperExportManager.exportReportToPdfStream(jasperPrint,baos);
       //JasperExportManager.exportReportToPdf(jasperPrint, "G:/Documents/jasper_Training/SpermAnalysisReport.pdf");
		}catch(Exception e){
			e.printStackTrace();
		}
        return aAttachment;
    }
    
    String formatDate(Date date){
        String formattedDate=null;
        try{
                    DateFormat originalFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
                    DateFormat targetFormat = new SimpleDateFormat("dd/MM");
                    Date date1 = originalFormat.parse(date.toString());
                    formattedDate = targetFormat.format(date1);  // 20120821
        }catch(Exception e){
            e.printStackTrace();
        }
        return formattedDate;
    }

    private InvoiceGenTO removeTimesheets(InvoiceGenTO invoiceGenTO, Date lastInvoiceDate) {
        Calendar cal= Calendar.getInstance();
        Date invDate=null;
        if(null==lastInvoiceDate){
            invDate=new Date();
        }else{
            invDate=lastInvoiceDate;
        }
            cal.setTime(invDate);
            
            int monthTobeConsidered=invDate.getMonth()-1;
            if((lastInvoiceDate==null) || lastInvoiceDate.getMonth()!=invDate.getMonth()){
                Map<Long, List<TimesheetTO>> timesheets=invoiceGenTO.getTimeSheets();
                Iterator<Map.Entry<Long, List<TimesheetTO>>> iter = timesheets.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<Long, List<TimesheetTO>> entry = iter.next();
                    List<TimesheetTO> timesheetList=entry.getValue();
                    Iterator timeIter=timesheetList.iterator();
                    while(timeIter.hasNext()){
                        TimesheetTO timesheetTO=(TimesheetTO)timeIter.next();
                        if(timesheetTO.getDate().getMonth()!=monthTobeConsidered)
                            timeIter.remove();
                    }
                }
            }else{
                invoiceGenTO.setTimeSheets(null);
            }
        return invoiceGenTO;
    }
}