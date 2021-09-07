/* 
@author: sarah.mahmood 
Created on May 17, 2021
*/
package ServerAdministration;

//import java.io.File;
import java.io.IOException;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.remote.LocalFileDetector;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class ServerReport {
	
    public String baseUrl = "http://172.20.22.81/OmniPCXRecord/TenantAdmin.aspx";
	
    String driverPath = "C:\\Users\\sarah.mahmood\\Downloads\\gecko-driver\\geckodriver.exe";
	
	public WebDriver driver;
  

////Test ID: 21-01
///* 
//* To verify the 'System Usage Report'
//*/		
//     @Test (priority = 0)
//     public void verifySystemUsageReport() throws InterruptedException {
//    	 
//   	   System.setProperty("webdriver.gecko.driver", driverPath);
//       driver = new FirefoxDriver();
//       driver.get(baseUrl);
//
//       // Signing in OmniPCX 
//       driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//       driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
//       driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//       
//       // Click On Reports
//       Thread.sleep(10000);
//	   driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlReports")).click();
//	   
//	   // Click on show report button (Note: By default appropriate date selected)
//	   driver.findElement(By.id("ctl00_ContentPlaceHolder2_ctrl_TenantReports1_btnShowSSR")).click();
//	   
//	   Thread.sleep(5000);
//	   boolean viewrep = driver.findElement(By.id("ctl00_ContentPlaceHolder2_ctrl_TenantReports1_pnlReportViewer")).isDisplayed();
//	   
//	   Assert.assertEquals(viewrep, true);
//	   
//	   driver.close();  	 
//  }
     
     
     

////Test ID: 21-01
///* 
//* To verify the 'System Usage Report' "The following message was displayed : ""'To Call date/time' should be greater than or equal to 'From Call date/time'"""
//*/         
//     @Test (priority = 1)
//     public void verifySystemUsageReportwithFuturedate() throws InterruptedException {
//    	 
//    	 System.setProperty("webdriver.gecko.driver", driverPath);
//         driver = new FirefoxDriver();
//         driver.get(baseUrl);
//
//         // Signing in OmniPCX 
//         driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//         driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
//         driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//         
//         // Click On Reports
//         Thread.sleep(7000);
//  	     driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlReports")).click();
//  	     
//    	   driver.close();  	 
// }




////Test ID: 21-03
///* 
//* To verify the 'System Usage Report' "The following message was displayed : ""Please provide 'From Date'"""
//*/ 
//     @Test (priority = 2)
//     public void verifySystemUsageReportwithemptyFromdate() throws InterruptedException {
//    	 
//    	 System.setProperty("webdriver.gecko.driver", driverPath);
//         driver = new FirefoxDriver();
//         driver.get(baseUrl);
//
//         // Signing in OmniPCX 
//         driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//         driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
//         driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//         
//         // Click On Reports
//         Thread.sleep(10000);
//  	     driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlReports")).click();
//  	     
//  	     // Clear from date
//  	     driver.findElement(By.id("ctl00_ContentPlaceHolder2_ctrl_TenantReports1_txtDateFromSSR")).clear();
//  	     
//  	     // Click on show report button
//  	     driver.findElement(By.id("ctl00_ContentPlaceHolder2_ctrl_TenantReports1_btnShowSSR")).click();
//  	     
//  	     String expected = "Please provide 'From Date'";
//  	     String actual = driver.findElement(By.id("ctl00_ContentPlaceHolder2_ctrl_TenantReports1_lblMessage")).getText();
//  	     Assert.assertEquals(actual, expected);
//  	      	 
//    	 driver.close();  	 
//}
     
     
     
     
////Test ID: 21-04
///* 
//* To verify the 'System Usage Report' ""The following message was displayed : ""Please provide 'To Date'"""
//*/   
//        @Test (priority = 3)
//        public void verifySystemUsageReportwithemptyTodate() throws InterruptedException {
//       	 
//       	 System.setProperty("webdriver.gecko.driver", driverPath);
//            driver = new FirefoxDriver();
//            driver.get(baseUrl);
//
//            // Signing in OmniPCX 
//            driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//            driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
//            driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//            
//            // Click On Reports
//            Thread.sleep(10000);
//     	     driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlReports")).click();
//     	     
//     	     // Clear to date
//     	     driver.findElement(By.id("ctl00_ContentPlaceHolder2_ctrl_TenantReports1_txtDateToSSR")).clear();
//     	     
//     	     // Click on show report button
//     	     driver.findElement(By.id("ctl00_ContentPlaceHolder2_ctrl_TenantReports1_btnShowSSR")).click();
//     	     
//     	     String expected = "Please provide 'To Date'";
//     	     String actual = driver.findElement(By.id("ctl00_ContentPlaceHolder2_ctrl_TenantReports1_lblMessage")).getText();
//     	     Assert.assertEquals(actual, expected);
//     	      	 
//       	 driver.close();  	 
//        }  
	
	
	
////Test ID: 21-05
///* 
//* System Usage Report should be exported in PDF and Excel format without any errors and data of the report should be same.
//*/ 
//	  @SuppressWarnings("deprecation")
	  
	@Test (priority = 3)
      public void verifySystemUsageReportDownload() throws InterruptedException, IOException {
	    System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);		

		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Reports
		  Thread.sleep(10000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlReports")).click();
	  
  	     // Click on show report button
		  Thread.sleep(6000);
		  driver.findElement(By.id("ctl00_ContentPlaceHolder2_ctrl_TenantReports1_btnShowSSR")).click();
  	     
  	     // Click on download report button
		  Thread.sleep(9000);
  	     driver.findElement(By.id("ctl00_ContentPlaceHolder2_ctrl_TenantReports1_ReportViewer2_ctl05_ctl04_ctl00_ButtonImg")).click();
  	     
         // Click on excel --> download file in excel format
         Thread.sleep(7000);
  	     driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td/div/table/tbody/tr/td/span/div/table/tbody/tr[4]/td/div/div/div[3]/table/tbody/tr/td/div[2]/div[1]/a")).click();
// 	     Thread.sleep(3000);
  	     Runtime.getRuntime().exec("C:\\Users\\sarah.mahmood\\Desktop\\AutoIT\\DownloadFile.exe");
  	
//  	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  	     Thread.sleep(100000); 
  	     
         // Click on pdf --> download file in pdf format
  	     driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td/div/table/tbody/tr/td/span/div/table/tbody/tr[4]/td/div/div/div[3]/table/tbody/tr/td/div[2]/div[2]/a")).click();  	     
    	 Thread.sleep(3000);
  	     Runtime.getRuntime().exec("C:\\Users\\sarah.mahmood\\Desktop\\AutoIT\\DownloadFile.exe");
  	     
  	     driver.close();
  	    	      	     
}
	  
	  

	  
////Test ID: 21-06
///* 	  
//* Drop Down functionality should work in accordance with the date.
//*/ 	  	  
//      @Test (priority = 6)
//      public void verifyDropDownfunctionalityofReport() throws InterruptedException {
//   	 
//  	  System.setProperty("webdriver.gecko.driver", driverPath);
//      driver = new FirefoxDriver();
//      driver.get(baseUrl);
//
//      // Signing in OmniPCX 
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
//      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//      
//       // Click On Reports
//       Thread.sleep(10000);
//	   driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlReports")).click();
//	   
//	   // Click on show report button (Note: By default appropriate date selected)
//	   Thread.sleep(7000);
//	   driver.findElement(By.id("ctl00_ContentPlaceHolder2_ctrl_TenantReports1_btnShowSSR")).click();
//	   
//	   // Click on [+] button after report generated
//	   Thread.sleep(5000);
//	   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td/div/table/tbody/tr/td/span/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td[3]/table/tbody/tr[3]/td[2]/div/a/img")).click();
//	   
//	   String eFromdate = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td/div/table/tbody/tr/td/span/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td[3]/table/tbody/tr[3]/td[3]/div/a")).getText();;
//	   String aFromdate = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td/div/table/tbody/tr/td/span/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td[3]/table/tbody/tr[3]/td[3]/div/a")).getText();
//	   
////	   System.out.println(eFromdate);
////	   System.out.println(aFromdate);
//	   
//	   Assert.assertEquals(aFromdate, eFromdate);
//	   
//	   driver.close();  	 
// }     
	  

      
////Test ID: 21-08
///* 
//* Following buttons should be functional:First Page, Previous Page, Next Page, Last Page, Export, Refresh and  Go back to the parent report
//*/              
//      @Test (priority = 7)
//      public void verifyButtonfunctionalityofReport() throws InterruptedException {
//   	 
//  	  System.setProperty("webdriver.gecko.driver", driverPath);
//      driver = new FirefoxDriver();
//      driver.get(baseUrl);
//
//      // Signing in OmniPCX 
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
//      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//      
//       // Click On Reports
//       Thread.sleep(10000);
//	   driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlReports")).click();
//	   
//	   // Click on show report button (Note: By default appropriate date selected)
//	   driver.findElement(By.id("ctl00_ContentPlaceHolder2_ctrl_TenantReports1_btnShowSSR")).click();
//	   Thread.sleep(6000);
//	   boolean viewrep = driver.findElement(By.id("ctl00_ContentPlaceHolder2_ctrl_TenantReports1_pnlReportViewer")).isDisplayed();
//       Assert.assertEquals(viewrep, true);
//       
//       // Click on Next button of report
//       Thread.sleep(5000);
//       driver.findElement(By.id("ctl00_ContentPlaceHolder2_ctrl_TenantReports1_ReportViewer2_ctl05_ctl00_Next_ctl00_ctl00")).click();
//       Thread.sleep(5000);
//	   String eNextpage = "Page 2 of 2";
//       String aNextpage = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td/div/table/tbody/tr/td/span/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr[2]/td[2]/table/tbody/tr/td/div")).getText();
//       Assert.assertEquals(aNextpage, eNextpage);
//       
//       // Click on Previous button of report
//       Thread.sleep(5000);
//       driver.findElement(By.id("ctl00_ContentPlaceHolder2_ctrl_TenantReports1_ReportViewer2_ctl05_ctl00_Previous_ctl00_ctl00")).click();
//       Thread.sleep(5000);
//	   String ePrevious = "Page 1 of 2";
//       String aPrevious = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td/div/table/tbody/tr/td/span/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr[2]/td[2]/table/tbody/tr/td/div")).getText();
//       Assert.assertEquals(aPrevious, ePrevious);
//       
//       // Click on Last button of report
//       Thread.sleep(5000);
//       driver.findElement(By.id("ctl00_ContentPlaceHolder2_ctrl_TenantReports1_ReportViewer2_ctl05_ctl00_Last_ctl00_ctl00")).click();
//       Thread.sleep(5000);
//	   String eLastpage = "Page 2 of 2";
//       String aLastpage = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td/div/table/tbody/tr/td/span/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr[2]/td[2]/table/tbody/tr/td/div")).getText();
//       Assert.assertEquals(aLastpage, eLastpage);
//       
//       // Click on First button of report
//       Thread.sleep(5000);
//       driver.findElement(By.id("ctl00_ContentPlaceHolder2_ctrl_TenantReports1_ReportViewer2_ctl05_ctl00_First_ctl00_ctl00")).click();
//       Thread.sleep(5000);
//	   String eFirstpage = "Page 1 of 2";
//       String aFirstpage = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td/div/table/tbody/tr/td/span/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr[2]/td[2]/table/tbody/tr/td/div")).getText();
//       Assert.assertEquals(aFirstpage, eFirstpage);
//	   
//       // Click on the Parent report button
//	   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td/div/table/tbody/tr/td/span/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td[3]/table/tbody/tr[3]/td[2]/div/a/img")).click();
//       Thread.sleep(7000);
//       driver.findElement(By.id("ctl00_ContentPlaceHolder2_ctrl_TenantReports1_ReportViewer2_ctl05_ctl01_ctl00_ctl00_ctl00")).click();
//       Thread.sleep(5000);
//	   String eParentpage = "Page 1 of 2";
//       String aParentpage = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td/div/table/tbody/tr/td/span/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr[2]/td[2]/table/tbody/tr/td/div")).getText();
//       Assert.assertEquals(aParentpage, eParentpage);
//       
//       // Click on Refresh button
//       driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td/div/table/tbody/tr/td/span/div/table/tbody/tr[4]/td/div/div/div[4]/table/tbody/tr/td/div/div[1]/table/tbody/tr/td/input")).click();
//       Thread.sleep(5000);
//	   String eRefreshpage = "Page 1 of 2";
//       String aRefreshpage = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td/div/table/tbody/tr/td/span/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr[2]/td[2]/table/tbody/tr/td/div")).getText();
//       Assert.assertEquals(aRefreshpage, eRefreshpage);
//       
//       //Export Pdf/Excel Reports
//	   
//	   driver.close();  	 
//      }     
	
      
      
////Test ID: 21-09
///* 
//* In System Reports section result time is should be correct when we expand report form hourly time to minutes.
//*/        
//    @Test (priority = 8)
//    public void verifyResultTimeisCorrectforReport() throws InterruptedException {
//	 
//	  System.setProperty("webdriver.gecko.driver", driverPath);
//      driver = new FirefoxDriver();
//      driver.get(baseUrl);
//
//      // Signing in OmniPCX 
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
//      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//  
//      // Click On Reports
//      Thread.sleep(10000);
//      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlReports")).click();
//   
//   
//      // Click on show report button (Note: By default appropriate date selected)
//      Thread.sleep(7000);
//      driver.findElement(By.id("ctl00_ContentPlaceHolder2_ctrl_TenantReports1_btnShowSSR")).click();
//   
//      // Click on [+] button after report generated
//      Thread.sleep(5000);
//      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td/div/table/tbody/tr/td/span/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td[3]/table/tbody/tr[3]/td[2]/div/a/img")).click();
//   
//      String eFromdate = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td/div/table/tbody/tr/td/span/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td[3]/table/tbody/tr[3]/td[3]/div/a")).getText();;
//      String aFromdate = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr[6]/td/div/table/tbody/tr/td/span/div/table/tbody/tr[5]/td[3]/div/div[1]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td[3]/table/tbody/tr[3]/td[3]/div/a")).getText();
//   
//      Assert.assertEquals(aFromdate, eFromdate);
//   
//      driver.close();  	 
//}     
    
    	
   
    
////Test ID: 21-05
///* 
//* System Usage Report should be exported in PDF and Excel format without any errors and data of the report should be same.
//*/ 
//    public boolean isFileDownloaded() throws Exception {
//        final int SLEEP_TIME_MILLIS = 1000;
//        File file = new File(filePath);
//        final int timeout = 60* SLEEP_TIME_MILLIS;
//        int timeElapsed = 0;
//        while (timeElapsed<timeout){
//            if (file.exists()) {
//                System.out.println(fileName + " is present");
//                return true;
//            } else {
//                timeElapsed +=SLEEP_TIME_MILLIS;
//                Thread.sleep(SLEEP_TIME_MILLIS);
//            }
//        }
//        return false;
//    }
        
//    @Test (priority = 9)
//    public void verifyReportDownloaded() throws InterruptedException {    
//    
//    
//    
//    driver.close();  	 
//    }     
	
//	
//    @AfterClass
//    public void tearDown() throws Exception {
//	        driver.quit();	}
        





	
	


}

  
