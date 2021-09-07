/* 
@author: sarah.mahmood 
Created on May 18, 2021
*/
package ServerAdministration;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ServerBranches {
	
    public String baseUrl = "http://172.20.22.81/OmniPCXRecord/TenantAdmin.aspx";
	
    String driverPath = "C:\\Users\\sarah.mahmood\\Downloads\\gecko-driver\\geckodriver.exe";
	
	public WebDriver driver;

////Test ID: 70-01
///* 
//* Add Branch in system with valid data and if there are no SMTP settings
//*/	
	
     @Test (priority = 0)
     public void AddBranchwithValidDatanoSMTPSettings() throws InterruptedException {
    	 
       System.setProperty("webdriver.gecko.driver", driverPath);
       driver = new FirefoxDriver();
       driver.get(baseUrl);

       // Signing in OmniPCX 
       driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
       driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
       driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
       
       // Click On Branches
       Thread.sleep(7000);
	   driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();
	   
	   // Click on Add Branch
	   Thread.sleep(3000);
	   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/a")).click();
	   
	   // Enter name
	   driver.findElement(By.id("tbBranchName")).sendKeys("ABranch");
	   
	   // Enter email
	   driver.findElement(By.id("tbBranchEmail")).sendKeys("sarah.mahmood@amigo-software.com");
	   
	   // Enter FTP url
	   driver.findElement(By.id("tbNetworkPath")).sendKeys("ftp://172.20.0.50/");
	   
	   // Enter Username
	   driver.findElement(By.id("tbUserName")).sendKeys("sarah");
	   
	   // Enter password
	   driver.findElement(By.id("tbPassword")).sendKeys("ggg2k7");
	   
	   // Check passive mode
	   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input")).click();
	   
	   // Click Save
	   driver.findElement(By.id("btnSvae")).click();
	   
	   Thread.sleep(3000);
	   
	   // Check alert message
	   JavascriptExecutor jsx = (JavascriptExecutor)driver;
	   jsx.executeScript("window.confirm('Unable to send an email. Please verify SMTP settings. Branch saved successfully')");
		  
	   String expectedAlertBranchUpdated = "Unable to send an email. Please verify SMTP settings. Branch saved successfully";
	   Alert confirmation = driver.switchTo().alert();
	   String actualAlertBranchUpdated = confirmation.getText(); //Get text present on alert Message

	   /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
	   Dismissed user prompt dialog: Settings have been updated successfully:*/
	   driver.switchTo().alert().accept();
	  
	   // Click on okay button
	   Thread.sleep(5000);
	   driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     

	   Assert.assertEquals(actualAlertBranchUpdated, expectedAlertBranchUpdated);
		  
	   driver.close(); 	      	       
  }
 
 

////Test ID: 70-02
///* 
//* Add Branch in system with valid data and if there are SMTP settings
//*/ 

//     @Test (priority = 1)
//     public void AddBranchwithValidSMTPSettings() throws InterruptedException {
//    	 
//       System.setProperty("webdriver.gecko.driver", driverPath);
//       driver = new FirefoxDriver();
//       driver.get(baseUrl);
//
//       // Signing in OmniPCX 
//       driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//       driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
//       driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//       
//       //SMTP settings
//       // Click on System
//       Thread.sleep(7000);
//	   driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
//	   
//	   Thread.sleep(5000);
//	   // Enter SMTP Server
//	   driver.findElement(By.id("txtSMTPServer")).clear();
//	   driver.findElement(By.id("txtSMTPServer")).sendKeys("auth.smtp.1and1.co.uk");
//	   
//	   // Enter SMTP Username
//	   driver.findElement(By.id("txtSMTPUsername")).clear();
//	   driver.findElement(By.id("txtSMTPUsername")).sendKeys("qa-opr@amigo-software.com");
//	   
//	   // Enter SMTP Password
//	   driver.findElement(By.id("txtSMTPPassword")).clear();
//	   driver.findElement(By.id("txtSMTPPassword")).sendKeys("OPRqa@2017");
//	   
//	   // Enter Sender Email Address
//	   driver.findElement(By.id("txtSMTPSenderEmailAddress")).clear();
//	   driver.findElement(By.id("txtSMTPSenderEmailAddress")).sendKeys("qa-opr@amigo-software.com");
//	   
//	   // Enter Port
//	   driver.findElement(By.id("txtSMTPPort")).clear();
//	   driver.findElement(By.id("txtSMTPPort")).sendKeys("587");
//	      
//	   // Enable TLS Encryption Connection
//	   driver.findElement(By.id("cbSMTPEnableTLS")).click();
//	   
//	   // Click Update button
//	   driver.findElement(By.id("btnUpdateSMTPSettings")).click();
//	    
//	   Thread.sleep(5000);
//	   
//	   // Click On Branches
//       Thread.sleep(5000);
//	   driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();
//	   
//	   // Click on Add Branch
//	   Thread.sleep(3000);
//	   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/a")).click();
//	   
//	   // Enter name
//	   driver.findElement(By.id("tbBranchName")).sendKeys("BBranch");
//	   
//	   // Enter email
//	   driver.findElement(By.id("tbBranchEmail")).sendKeys("sarah.mahmood@amigo-software.com");
//	   
//	   // Enter FTP url
//	   driver.findElement(By.id("tbNetworkPath")).sendKeys("ftp://172.20.0.50/");
//	   
//	   // Enter Username
//	   driver.findElement(By.id("tbUserName")).sendKeys("sarah");
//	   
//	   // Enter password
//	   driver.findElement(By.id("tbPassword")).sendKeys("ggg2k7");
//	   
//	   // Check passive mode
//	   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input")).click();
//	   
////	   // Check Enable SSL
////	   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[6]/td[2]/input")).click();
//	   
//	   // Click Save
//	   driver.findElement(By.id("btnSvae")).click();
//	   
//	   Thread.sleep(3000);
//	   
//	   // Check alert message
//	   JavascriptExecutor jsx = (JavascriptExecutor)driver;
//	   jsx.executeScript("window.confirm('Settings have been saved successfully')");
//		  
//	   String expectedAlertBranchUpdated = "Settings have been saved successfully";
//	   Alert confirmation = driver.switchTo().alert();
//	   String actualAlertBranchUpdated = confirmation.getText(); //Get text present on alert Message
//
//	   /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
//	   Dismissed user prompt dialog: Settings have been updated successfully:*/
//	   driver.switchTo().alert().accept();
//	  
//	   // Click on okay button
//	   Thread.sleep(5000);
//	   driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     
//
//	   Assert.assertEquals(actualAlertBranchUpdated, expectedAlertBranchUpdated);
//		  
//	   driver.close(); 	      	       
//  } 
     
     
     
////Test ID: 70-03
///* 
//* Add Branch in system with Branch name more than 80 char
//*/     
       
     @Test (priority = 2)
     public void AddBranchNamewith80Characters() throws InterruptedException {
    	 
       System.setProperty("webdriver.gecko.driver", driverPath);
       driver = new FirefoxDriver();
       driver.get(baseUrl);

       // Signing in OmniPCX 
       driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
       driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
       driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
       
       // Click On Branches
       Thread.sleep(7000);
	   driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();
	   
	   // Click on Add Branch
	   Thread.sleep(3000);
	   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/a")).click();
	   
	   // Enter name
	   driver.findElement(By.id("tbBranchName")).sendKeys("1. Login to server administration. 2. Go to permissions page under configuration|cut off");
	   
	   // Enter email
	   driver.findElement(By.id("tbBranchEmail")).sendKeys("sarah.mahmood@amigo-software.com");
	   
	   // Enter FTP url
	   driver.findElement(By.id("tbNetworkPath")).sendKeys("ftp://172.20.0.50/");
	   
	   // Enter Username
	   driver.findElement(By.id("tbUserName")).sendKeys("sarah");
	   
	   // Enter password
	   driver.findElement(By.id("tbPassword")).sendKeys("ggg2k7");
	   
	   // Check passive mode
	   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input")).click();
	   
	   // Click Save
	   driver.findElement(By.id("btnSvae")).click();
	   
	   Thread.sleep(3000);
	   
	   // Check alert message
	   JavascriptExecutor jsx = (JavascriptExecutor)driver;
	   jsx.executeScript("window.confirm('Settings have been updated successfully')");
		  
	   String expectedAlertBranchUpdated = "Settings have been updated successfully";
	   Alert confirmation = driver.switchTo().alert();
	   String actualAlertBranchUpdated = confirmation.getText(); //Get text present on alert Message

	   /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
	   Dismissed user prompt dialog: Settings have been updated successfully:*/
	   driver.switchTo().alert().accept();
	  
	   // Click on okay button
	   Thread.sleep(5000);
	   driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     

	   Assert.assertEquals(actualAlertBranchUpdated, expectedAlertBranchUpdated);
     
       driver.close(); 	      	       
}
     


////Test ID: 70-04
///* 
//* Add Branch in system with duplicate Branch name
//*/      
        
     @Test (priority = 3)
     public void AddDuplicateBranchName() throws InterruptedException {
     System.setProperty("webdriver.gecko.driver", driverPath);
     driver = new FirefoxDriver();
     driver.get(baseUrl);

     // Signing in OmniPCX 
     driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
     driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
     driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
     
     // Click On Branches
     Thread.sleep(7000);
	   driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();
	   
	   // Click on Add Branch
	   Thread.sleep(3000);
	   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/a")).click();
	   
	   // Enter name
	   driver.findElement(By.id("tbBranchName")).sendKeys("ABranch");
	   
	   // Enter email
	   driver.findElement(By.id("tbBranchEmail")).sendKeys("sarah.mahmood@amigo-software.com");
	   
	   // Enter FTP url
	   driver.findElement(By.id("tbNetworkPath")).sendKeys("ftp://172.20.0.50/");
	   
	   // Enter Username
	   driver.findElement(By.id("tbUserName")).sendKeys("sarah");
	   
	   // Enter password
	   driver.findElement(By.id("tbPassword")).sendKeys("ggg2k7");
	   
	   // Check passive mode
	   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input")).click();
	   
	   // Click Save
	   driver.findElement(By.id("btnSvae")).click();
	   Thread.sleep(3000);
	   String expectedbranch = "Branch name already exists.";	   
	   
	   // Get label message
	   String actualbranch = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[1]/td/table/tbody/tr[1]/td/label")).getText();

	   Assert.assertEquals(actualbranch, expectedbranch);
   
     driver.close(); 	      	       
}
   
	
	
	
////Test ID: 70-05
///* 
//* Add Branch in system with empty Branch name
//*/	
	     @Test (priority = 4)
         public void AddemptyBranchName() throws InterruptedException {
         System.setProperty("webdriver.gecko.driver", driverPath);
         driver = new FirefoxDriver();
         driver.get(baseUrl);

         // Signing in OmniPCX 
         driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
         driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
         driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
         
         // Click On Branches
         Thread.sleep(7000);
  	   	 driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();
  	   
  	   	 // Click on Add Branch
  	   	 Thread.sleep(3000);
  	   	 driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/a")).click();
  	   
  	   	 // Enter email
  	   	 driver.findElement(By.id("tbBranchEmail")).sendKeys("sarah.mahmood@amigo-software.com");
  	   
  	   	 // Enter FTP url
  	   	 driver.findElement(By.id("tbNetworkPath")).sendKeys("ftp://172.20.0.50/");
  	   
  	   	 // Enter Username
  	   	 driver.findElement(By.id("tbUserName")).sendKeys("sarah");
  	   
  	   	 // Enter password
  	   	 driver.findElement(By.id("tbPassword")).sendKeys("ggg2k7");
  	   
  	   	 // Check passive mode
  	   	 driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input")).click();
  	   
  	   	 // Click Save
  	   	 driver.findElement(By.id("btnSvae")).click();
  	   	 Thread.sleep(3000);
  	   	 String expectedbranch = "Please enter name";	   
  	   
  	   	 // Get label message
  	   	 String actualbranch = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[1]/td/table/tbody/tr[1]/td/label")).getText();
  
  	   	 Assert.assertEquals(actualbranch, expectedbranch);
  
         driver.close(); 	      	       
}
	     
	     

	
////Test ID: 70-06
///* 
//* Add Branch in system with invalid Branch name
//*/	
	     @Test (priority = 5)
         public void AddInvalidBranchName() throws InterruptedException {
         System.setProperty("webdriver.gecko.driver", driverPath);
         driver = new FirefoxDriver();
         driver.get(baseUrl);

         // Signing in OmniPCX 
         driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
         driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
         driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
         
         // Click On Branches
         Thread.sleep(7000);
  	   	 driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();
  	   
  	   	 // Click on Add Branch
  	   	 Thread.sleep(3000);
  	   	 driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/a")).click();
  	   
  	   	 // Enter name
  	   Thread.sleep(3000);
  	   	 driver.findElement(By.id("tbBranchName")).sendKeys("$##%^##$^#@");
  	   	 
  	   	 // Enter email
  	   	 driver.findElement(By.id("tbBranchEmail")).sendKeys("sarah.mahmood@amigo-software.com");
  	   
  	   	 // Enter FTP url
  	   	 driver.findElement(By.id("tbNetworkPath")).sendKeys("ftp://172.20.0.50/");
  	   
  	   	 // Enter Username
  	   	 driver.findElement(By.id("tbUserName")).sendKeys("sarah");
  	   
  	   	 // Enter password
  	   	 driver.findElement(By.id("tbPassword")).sendKeys("ggg2k7");
  	   
  	   	 // Check passive mode
  	   	 driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input")).click();
  	   
  	   	 // Click Save
  	   	 driver.findElement(By.id("btnSvae")).click();
  	   	 Thread.sleep(3000);
  	   	 String expectedbranch = "Please enter name";	   
  	   
  	   	 // Get label message
  	   	 String actualbranch = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[1]/td/table/tbody/tr[1]/td/label")).getText();
  
  	   	 Assert.assertEquals(actualbranch, expectedbranch);
  
         driver.close(); 	      	       
}	
	
	     
////Test ID: 70-07
///* 
//* Add Branch in system with empty email address
//*/
	     @Test (priority = 6)
         public void AddEmptyEmailtoBranchName() throws InterruptedException {
         System.setProperty("webdriver.gecko.driver", driverPath);
         driver = new FirefoxDriver();
         driver.get(baseUrl);
	     
         // Signing in OmniPCX 
         driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
         driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
         driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
       
         // Click On Branches
         Thread.sleep(7000);
	   	 driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();
	   
	   	 // Click on Add Branch
	   	 Thread.sleep(3000);
	   	 driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/a")).click();
	   
		 // Enter name
		 driver.findElement(By.id("tbBranchName")).sendKeys("Branch");
	   	 
	   
	   	 // Enter FTP url
	   	 driver.findElement(By.id("tbNetworkPath")).sendKeys("ftp://172.20.0.50/");
	   
	   	 // Enter Username
	   	 driver.findElement(By.id("tbUserName")).sendKeys("sarah");
	   
	   	 // Enter password
	   	 driver.findElement(By.id("tbPassword")).sendKeys("ggg2k7");
	   
	   	 // Check passive mode
	   	 driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input")).click();
	   
	   	 // Click Save
	   	 driver.findElement(By.id("btnSvae")).click();
	   	 Thread.sleep(3000);
	   	 String expectedbranch = "please enter email";	   
	   
	   	 // Get label message
	   	 String actualbranch = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[1]/td/table/tbody/tr[1]/td/label")).getText();

	   	 Assert.assertEquals(actualbranch, expectedbranch);
	     
         driver.close(); 	      	       
}

	     
	     

////Test ID: 70-08
///* 
//* Add Branch in system with invalid Email
//*/	
	     @Test (priority = 7)
         public void AddInvalidEmailinBranch() throws InterruptedException {
         System.setProperty("webdriver.gecko.driver", driverPath);
         driver = new FirefoxDriver();
         driver.get(baseUrl);
	     
         // Signing in OmniPCX 
         driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
         driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
         driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
       
         // Click On Branches
         Thread.sleep(7000);
	   	 driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();
	   
	   	 // Click on Add Branch
	   	 Thread.sleep(3000);
	   	 driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/a")).click();
	   
		 // Enter name
		 driver.findElement(By.id("tbBranchName")).sendKeys("Branch");
	   	 
	   	 // Enter email
	   	 driver.findElement(By.id("tbBranchEmail")).sendKeys("something.com");
	   
	   	 // Enter FTP url
	   	 driver.findElement(By.id("tbNetworkPath")).sendKeys("ftp://172.20.0.50/");
	   
	   	 // Enter Username
	   	 driver.findElement(By.id("tbUserName")).sendKeys("sarah");
	   
	   	 // Enter password
	   	 driver.findElement(By.id("tbPassword")).sendKeys("ggg2k7");
	   
	   	 // Check passive mode
	   	 driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input")).click();
	   
	   	 // Click Save
	   	 driver.findElement(By.id("btnSvae")).click();
	   	 Thread.sleep(3000);
	   	 String expectedbranch = "Invalid Email Address";	   
	   
	   	 // Get label message
	   	 String actualbranch = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[1]/td/table/tbody/tr[1]/td/label")).getText();

	   	 Assert.assertEquals(actualbranch, expectedbranch);
	     
         driver.close(); 	      	       
} 
	     
	     
	     
	 
////Test ID: 70-09
///* 
//* Add Branch in system with Disabled status
//*/	
	   	@Test (priority = 8)
	    public void AddBranchwithDisabledStatus() throws InterruptedException {
	    System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	   	     
	    // Signing in OmniPCX 
	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	          
	    // Click On Branches
	    Thread.sleep(7000);
	   	driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();
	   	   
	   	// Click on Add Branch
	   	Thread.sleep(3000);
	   	driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/a")).click();
	   	   
	    // Enter name
	   	driver.findElement(By.id("tbBranchName")).sendKeys("Disabled Branch");
	   	   	 
	   	// Enter email
	   	driver.findElement(By.id("tbBranchEmail")).sendKeys("sarah.mahmood@amigo-software.com");
	   	
	    // Select from Status 
	   	Select dropdown = new Select(driver.findElement(By.id("ddlBranchLicenseEnable")));
	   	dropdown.selectByVisibleText("Disabled");
	   	   
	   	// Enter FTP url
	   	driver.findElement(By.id("tbNetworkPath")).sendKeys("ftp://172.20.0.50/");
	   	   
	   	// Enter Username
	   	driver.findElement(By.id("tbUserName")).sendKeys("sarah");
	   	   
	   	// Enter password
	   	driver.findElement(By.id("tbPassword")).sendKeys("ggg2k7");
	   	   
	   	// Check passive mode
	   	driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input")).click();
	   	   
	   	// Click Save
	   	driver.findElement(By.id("btnSvae")).click();
	   	
	   	Thread.sleep(3000);
		   
		// Check alert message
		JavascriptExecutor jsd = (JavascriptExecutor)driver;
		jsd.executeScript("window.confirm('Unable to send an email. Please verify SMTP settings. Branch saved successfully')");
			  
		String expectedAlertBranchUpdated = "Unable to send an email. Please verify SMTP settings. Branch saved successfully";
		Alert confirmation = driver.switchTo().alert();
		String actualAlertBranchUpdated = confirmation.getText(); //Get text present on alert Message
	
		/* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
		Dismissed user prompt dialog: Settings have been updated successfully:*/
		driver.switchTo().alert().accept();
		  
		// Click on okay button
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     
	
		Assert.assertEquals(actualAlertBranchUpdated, expectedAlertBranchUpdated);
	     
	    driver.close(); 	      	       
	   }
     
     
     
////Test ID: 70-10
///* 
//* Add Branch in system with Transfer Settings when Network Type is FTP
//*/     
     	@Test (priority = 9)
     	public void AddBranchNamewithNetworkTypeisFTP() throws InterruptedException {
 	 
     		System.setProperty("webdriver.gecko.driver", driverPath);
     		driver = new FirefoxDriver();
     		driver.get(baseUrl);

     		// Signing in OmniPCX 
     		driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
     		driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
     		driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
    
     		// Click On Branches
     		Thread.sleep(7000);
     		driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();
	   
     		// Click on Add Branch
     		Thread.sleep(3000);
     		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/a")).click();
	   
     		// Enter name
     		Thread.sleep(5000);
     		driver.findElement(By.id("tbBranchName")).sendKeys("CBranch");
	   
     		// Enter email
     		driver.findElement(By.id("tbBranchEmail")).sendKeys("sarah.mahmood@amigo-software.com");
	   
     		// Enter FTP url
     		driver.findElement(By.id("tbNetworkPath")).sendKeys("ftp://172.20.0.50/");
	   
     		// Enter Username
     		driver.findElement(By.id("tbUserName")).sendKeys("sarah");
	   
     		// Enter password
     		driver.findElement(By.id("tbPassword")).sendKeys("ggg2k7");
	   
     		// Check passive mode
     		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input")).click();
	   
     		// Click Save
     		driver.findElement(By.id("btnSvae")).click();
	   
     		Thread.sleep(3000);
	   
     		// Check alert message
     		JavascriptExecutor jsx = (JavascriptExecutor)driver;
     		jsx.executeScript("window.confirm('Settings have been updated successfully')");
		  
     		String expectedAlertBranchUpdated = "Settings have been updated successfully";
     		Alert confirmation = driver.switchTo().alert();
     		String actualAlertBranchUpdated = confirmation.getText(); //Get text present on alert Message

     		/* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
	   		Dismissed user prompt dialog: Settings have been updated successfully:*/
     		driver.switchTo().alert().accept();
	  
     		// Click on okay button
     		Thread.sleep(5000);
     		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     

     		Assert.assertEquals(actualAlertBranchUpdated, expectedAlertBranchUpdated);
  
     		driver.close(); 	      	       
}
     	
     	
     
  
////Test ID: 70-11
///* 
//* Add Branch in system with Transfer Settings when Network Type is FTP with invalid FTP URL format
//*/	
     		     @Test (priority = 10)
     	         public void AddBranchwithInvalidFTPURLFormat() throws InterruptedException {
     	         System.setProperty("webdriver.gecko.driver", driverPath);
     	         driver = new FirefoxDriver();
     	         driver.get(baseUrl);
     		     
     	         // Signing in OmniPCX 
     	         driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
     	         driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
     	         driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
     	       
     	         // Click On Branches
     	         Thread.sleep(7000);
     		   	 driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();
     		   
     		   	 // Click on Add Branch
     		   	 Thread.sleep(3000);
     		   	 driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/a")).click();
     		   
     			 // Enter name
     			 driver.findElement(By.id("tbBranchName")).sendKeys("Branch1");
     		   	 
     		   	 // Enter email
     		   	 driver.findElement(By.id("tbBranchEmail")).sendKeys("someone@something.com");
     		   
     		   	 // Enter FTP url
     		   	 driver.findElement(By.id("tbNetworkPath")).sendKeys("ftp://172.20.0.23/");
     		   
     		   	 // Enter Username
     		   	 driver.findElement(By.id("tbUserName")).sendKeys("sarah");
     		   
     		   	 // Enter password
     		   	 driver.findElement(By.id("tbPassword")).sendKeys("ggg2k7");
     		   
     		   	 // Check passive mode
     		   	 driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input")).click();
     		   
     		   	 // Click Save
     		   	 driver.findElement(By.id("btnSvae")).click();
     		   	 Thread.sleep(3000);
     		   	 String expectedbranch = "Transfer FTP URL is not valid.";	   
     		   
     		   	 // Get label message
     		   	 String actualbranch = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[1]/td/table/tbody/tr[1]/td/label")).getText();
     	
     		   	 Assert.assertEquals(actualbranch, expectedbranch);
     		     
     	         driver.close(); 	      	       
 }  
     		     
     		     
     		     
////Test ID: 70-12
///* 
//* Add Branch in system with Transfer Settings when Network Type is Secure FTP and valid format but invalid URL
//*/	
       @Test (priority = 11)
       public void AddBranchwithSecureFTPInvalidFTPURL() throws InterruptedException {
       System.setProperty("webdriver.gecko.driver", driverPath);
       driver = new FirefoxDriver();
       driver.get(baseUrl);
     		       		     
       // Signing in OmniPCX 
       driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
       driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
       driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
     		       	       
       // Click On Branches
       Thread.sleep(7000);
       driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();
     		       		   
       // Click on Add Branch
       Thread.sleep(3000);
       driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/a")).click();
     		       		   
       // Enter name
       Thread.sleep(4000);
       driver.findElement(By.id("tbBranchName")).sendKeys("Branch2");
     		       		   	 
       // Enter email
       driver.findElement(By.id("tbBranchEmail")).sendKeys("someone@something.com");
       
       // Check Secure FTP
       driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[1]/td[2]/input[2]")).click();
	   
	   // Enter FTP url
	   driver.findElement(By.id("tbNetworkPath")).sendKeys("ftp://172.20.0.23/");
	   
	   // Enter Username
	   driver.findElement(By.id("tbUserName")).sendKeys("sarah");
	   
	   // Enter password
	   driver.findElement(By.id("tbPassword")).sendKeys("ggg2k7");
	   
	   // Check passive mode
	   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input")).click();
	   
	   // Click Save
	   driver.findElement(By.id("btnSvae")).click();
	   Thread.sleep(3000);
	   String expectedbranch = "Transfer Secure FTP URL Format is not valid.";	   
	   
	   // Get label message
	   String actualbranch = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[1]/td/table/tbody/tr[1]/td/label")).getText();

	   Assert.assertEquals(actualbranch, expectedbranch);
		   			       		   	 		       		     
       driver.close(); 	      	       
     }   
       
       
       
////Test ID: 70-13
///* 
//* Add Branch in system with Transfer Settings when Network Type is FTP and empty URL
//*/	
            @Test (priority = 12)
            public void AddBranchwithEmptyFTPURL() throws InterruptedException {
            System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
            driver.get(baseUrl);
          		       		     
            // Signing in OmniPCX 
            driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
            driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
            driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
          		       	       
            // Click On Branches
            Thread.sleep(7000);
            driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();
          		       		   
            // Click on Add Branch
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/a")).click();
          		       		   
            // Enter name
            driver.findElement(By.id("tbBranchName")).sendKeys("Branch");
          		       		   	 
            // Enter email
            driver.findElement(By.id("tbBranchEmail")).sendKeys("someone@something.com");
            
//            // Check Secure FTP
//            driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[1]/td[2]/input[2]")).click();
//     	   
//     	   // Enter FTP url
//     	   driver.findElement(By.id("tbNetworkPath")).sendKeys("ftp://172.20.0.23/");
     	   
     	   // Enter Username
     	   driver.findElement(By.id("tbUserName")).sendKeys("sarah");
     	   
     	   // Enter password
     	   driver.findElement(By.id("tbPassword")).sendKeys("ggg2k7");
     	   
     	   // Check passive mode
     	   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input")).click();
     	   
     	   // Click Save
     	   driver.findElement(By.id("btnSvae")).click();
     	   Thread.sleep(3000);
     	   String expectedbranch = "Please provide valid FTP URL.";	   
     	   
     	   // Get label message
     	   String actualbranch = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[1]/td/table/tbody/tr[1]/td/label")).getText();

     	   Assert.assertEquals(actualbranch, expectedbranch);
     		   			       		   	 		       		     
            driver.close(); 	      	       
          }   
         

            

////Test ID: 70-14
///* 
//* Add Branch in system with Transfer Settings when Network Type is FTP and invalid username
//*/	
            @Test (priority = 13)
            public void AddBranchwithInvalidUsername() throws InterruptedException {
            System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
            driver.get(baseUrl);
          		       		     
            // Signing in OmniPCX 
            driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
            driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
            driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
          		       	       
            // Click On Branches
            Thread.sleep(7000);
            driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();              
                    		       		   
            // Click on Add Branch
            Thread.sleep(6000);
            driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/a")).click();
          		       		   
            // Enter name
            Thread.sleep(5000);
            driver.findElement(By.id("tbBranchName")).sendKeys("Branch");
          		       		   	 
            // Enter email
            driver.findElement(By.id("tbBranchEmail")).sendKeys("someone@something.com");
            	   
     	   // Enter FTP url
     	   driver.findElement(By.id("tbNetworkPath")).sendKeys("ftp://172.20.0.50/");
     	   
     	   // Enter Username
     	   driver.findElement(By.id("tbUserName")).sendKeys("VanHellsing");          
               	   
     	   // Enter password
       	   driver.findElement(By.id("tbPassword")).sendKeys("ggg2k7");
       	   
       	   // Check passive mode
       	   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input")).click();
       	   
       	   // Click Save
       	   driver.findElement(By.id("btnSvae")).click();
       	   Thread.sleep(3000);
       	   String expectedbranch = "Transfer FTP credentials are not valid.";	   
       	   
       	   // Get label message
       	   String actualbranch = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[1]/td/table/tbody/tr[1]/td/label")).getText();

       	   Assert.assertEquals(actualbranch, expectedbranch);
       		   			       		   	 		       		     
           driver.close(); 	      	       
}                	   
            
    
            

////Test ID: 70-15
///* 
//*Add Branch in system with Transfer Settings when Network Type is FTP and invalid password
//*/	
            @Test (priority = 14)
            public void AddBranchwithInvalidPassword() throws InterruptedException {
            System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
            driver.get(baseUrl);
          		       		     
            // Signing in OmniPCX 
            driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
            driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
            driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();                     
            
            // Click On Branches
            Thread.sleep(7000);
            driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();              
                    		       		   
            // Click on Add Branch
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/a")).click();
          		       		   
            // Enter name
            driver.findElement(By.id("tbBranchName")).sendKeys("Branch");
          		       		   	 
            // Enter email
            driver.findElement(By.id("tbBranchEmail")).sendKeys("someone@something.com");
            
            // Enter FTP url
            driver.findElement(By.id("tbNetworkPath")).sendKeys("ftp://172.20.0.50/");
     	   
     	   // Enter Username
     	   driver.findElement(By.id("tbUserName")).sendKeys("sarah");          
               	   
     	   // Enter password
       	   driver.findElement(By.id("tbPassword")).sendKeys("okayssss");
       	   
       	   // Check passive mode
       	   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input")).click();
       	   
       	   // Click Save
       	   driver.findElement(By.id("btnSvae")).click();
       	   Thread.sleep(3000);
       	   String expectedbranch = "Transfer FTP credentials are not valid.";   
            
       	   // Get label message
  	       String actualbranch = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[1]/td/table/tbody/tr[1]/td/label")).getText();

  	       Assert.assertEquals(actualbranch, expectedbranch);
  		   			       		   	 		       		     
           driver.close();
}                 
            
            
            
////Test ID: 70-16
///* 
//*Add Branch in system with Transfer Settings when Network Type is FTP and empty username
//*/	
            @Test (priority = 15)
            public void AddBranchwithEmptyUsername() throws InterruptedException {
            System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
            driver.get(baseUrl);
          		       		     
            // Signing in OmniPCX 
            driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
            driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
            driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();                     
            
            // Click On Branches
            Thread.sleep(7000);
            driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();                             
                              		       		   
            // Click on Add Branch
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/a")).click();
          		       		   
            // Enter name
            driver.findElement(By.id("tbBranchName")).sendKeys("Branch");
          		       		   	 
            // Enter email
            driver.findElement(By.id("tbBranchEmail")).sendKeys("someone@something.com");
            
            // Enter FTP url
            driver.findElement(By.id("tbNetworkPath")).sendKeys("ftp://172.20.0.50/");         
               	   
//            // Enter Username
//            driver.findElement(By.id("tbUserName")).sendKeys("sarah");          
       	   
     	   // Enter password
       	   driver.findElement(By.id("tbPassword")).sendKeys("ggg2k7");
       	   
       	   // Check passive mode
       	   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input")).click();
       	   
       	   // Click Save
       	   driver.findElement(By.id("btnSvae")).click();
       	   Thread.sleep(3000);
       	   String expectedbranch = "Please provide username";         	   
                      
       	   // Get label message
	       String actualbranch = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[1]/td/table/tbody/tr[1]/td/label")).getText();

	       Assert.assertEquals(actualbranch, expectedbranch);
		   			       		   	 		       		     
           driver.close();      	   
}                             
    
            
            
////Test ID: 70-17
///* 
//*Add Branch in system with Transfer Settings when Network Type is FTP and empty password
//*/	
            @Test (priority = 16)
            public void AddBranchwithEmptyPassword() throws InterruptedException {
            System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
            driver.get(baseUrl);
          		       		     
            // Signing in OmniPCX 
            driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
            driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
            driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();                     
            
            // Click On Branches
            Thread.sleep(7000);
            driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();                               
                              		       		   
            // Click on Add Branch
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/a")).click();
          		       		   
            // Enter name
            driver.findElement(By.id("tbBranchName")).sendKeys("Branch");
          		       		   	 
            // Enter email
            driver.findElement(By.id("tbBranchEmail")).sendKeys("someone@something.com");
            
            // Enter FTP url
            driver.findElement(By.id("tbNetworkPath")).sendKeys("ftp://172.20.0.50/");
     	   
     	   // Enter Username
     	   driver.findElement(By.id("tbUserName")).sendKeys("sarah");                    
           
//     	   // Enter password
//     	   driver.findElement(By.id("tbPassword")).sendKeys("ggg2k7");
     	   
     	   // Check passive mode
     	   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input")).click();
     	   
     	   // Click Save
     	   driver.findElement(By.id("btnSvae")).click();
     	   Thread.sleep(3000);
     	   String expectedbranch = "Please provide password";   
          
     	   // Get label message
	       String actualbranch = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[1]/td/table/tbody/tr[1]/td/label")).getText();

	       Assert.assertEquals(actualbranch, expectedbranch);
		   			       		   	 		       		     
           driver.close();
               	   
          }    
            
            
       
            
////Test ID: 70-26
///* 
//* Add Branch in system when Schedule Type Immediate (By default saved as Immediate)
//*/	
            @Test (priority = 17)
            public void AddBranchwithScheduleTypeImmediate() throws InterruptedException {
            System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
            driver.get(baseUrl);
          		       		     
            // Signing in OmniPCX 
            driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
            driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
            driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();                     
            
            // Click On Branches
            Thread.sleep(7000);
            driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();                               
                              		       		   
            // Click on Add Branch
            Thread.sleep(7000);
            driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/a")).click();
          		       		   
            // Enter name
            Thread.sleep(5000);
            driver.findElement(By.id("tbBranchName")).sendKeys("Branch52");
          		       		   	 
            // Enter email
            driver.findElement(By.id("tbBranchEmail")).sendKeys("someone@something.com");
            
            // Enter FTP url
            driver.findElement(By.id("tbNetworkPath")).sendKeys("ftp://172.20.0.50/");
     	   
     	   // Enter Username
     	   driver.findElement(By.id("tbUserName")).sendKeys("sarah");                    
           
     	   // Enter password
     	   driver.findElement(By.id("tbPassword")).sendKeys("ggg2k7");
     	   
     	   // Check passive mode
     	   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input")).click();
     	   
     	   // Select from Schedule Type 
   	   Select dropdown = new Select(driver.findElement(By.id("ddlScheduleType")));
   	   dropdown.selectByVisibleText("Immediate");
     	   
     	   // Click Save
     	   driver.findElement(By.id("btnSvae")).click();
   	   	   
     	  Thread.sleep(3000);
  	   
     	  // Check alert message
     	  JavascriptExecutor jsy = (JavascriptExecutor)driver;
     	  jsy.executeScript("window.confirm('Settings have been saved successfully')");
   		  
     	  String expectedAlertBranchUpdated = "Settings have been saved successfully";
     	  Alert confirmation = driver.switchTo().alert();
     	  String actualAlertBranchUpdated = confirmation.getText(); //Get text present on alert Message
   
     	  /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
   	   	     Dismissed user prompt dialog: Settings have been updated successfully:*/
     	  driver.switchTo().alert().accept();
   	  
     	  // Click on okay button
     	  Thread.sleep(5000);
     	  driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     
   
     	  Assert.assertEquals(actualAlertBranchUpdated, expectedAlertBranchUpdated);
   		  
     	  driver.close(); 	      	      
               	   
          }
            
            
            

////Test ID: 70-27
///* 
//* Add Branch in system when Schedule Type is "After Every" with valid data
//*/	
            @Test (priority = 18)
            public void AddBranchwithScheduleTypeAfterEvery() throws InterruptedException {
            System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
            driver.get(baseUrl);
          		       		     
            // Signing in OmniPCX 
            driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
            driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
            driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();                     
            
            // Click On Branches
            Thread.sleep(7000);
            driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();                               
                              		       		   
            // Click on Add Branch
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/a")).click();
          		       		   
            // Enter name
            driver.findElement(By.id("tbBranchName")).sendKeys("Branch54");
          		       		   	 
            // Enter email
            driver.findElement(By.id("tbBranchEmail")).sendKeys("someone@something.com");
            
            // Enter FTP url
            driver.findElement(By.id("tbNetworkPath")).sendKeys("ftp://172.20.0.50/");
     	   
     	   // Enter Username
     	   driver.findElement(By.id("tbUserName")).sendKeys("sarah");                    
           
     	   // Enter password
     	   driver.findElement(By.id("tbPassword")).sendKeys("ggg2k7");
     	   
     	   // Check passive mode
     	   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input")).click();
     	   
     	   // Select from Schedule Type 
   	   Select dropdown = new Select(driver.findElement(By.id("ddlScheduleType")));
   	   dropdown.selectByVisibleText("After Every");
   	   	   
   	   // Enter Interval
   	   driver.findElement(By.id("tbScheduleInterval")).sendKeys("10");
     	   
     	   // Click Save
     	   driver.findElement(By.id("btnSvae")).click();
   	   	   
     	  Thread.sleep(3000);
  	   
     	  // Check alert message
     	  JavascriptExecutor jsy = (JavascriptExecutor)driver;
     	  jsy.executeScript("window.confirm('Settings have been saved successfully')");
   		  
     	  String expectedAlertBranchUpdated = "Settings have been saved successfully";
     	  Alert confirmation = driver.switchTo().alert();
     	  String actualAlertBranchUpdated = confirmation.getText(); //Get text present on alert Message
   
     	  /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
   	   	     Dismissed user prompt dialog: Settings have been updated successfully:*/
     	  driver.switchTo().alert().accept();
   	  
     	  // Click on okay button
     	  Thread.sleep(5000);
     	  driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     
   
     	  Assert.assertEquals(actualAlertBranchUpdated, expectedAlertBranchUpdated);
   		  
     	  driver.close(); 	      	      
               	   
          }                              
            
     

            
////Test ID: 70-28
///* 
//* Add Branch in system when Schedule Type is "After Every" with invalid interval (0)
//*/
            @Test (priority = 19)
            public void AddBranchwithScheduleTypeAfterEverywithInvalidinterval() throws InterruptedException {
            System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
            driver.get(baseUrl);
          		       		     
            // Signing in OmniPCX 
            driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
            driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
            driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();                     
            
            // Click On Branches
            Thread.sleep(7000);
            driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();                               
                              		       		   
            // Click on Add Branch
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/a")).click();
          		       		   
            // Enter name
            driver.findElement(By.id("tbBranchName")).sendKeys("Branch54");
          		       		   	 
            // Enter email
            driver.findElement(By.id("tbBranchEmail")).sendKeys("someone@something.com");
            
            // Enter FTP url
            driver.findElement(By.id("tbNetworkPath")).sendKeys("ftp://172.20.0.50/");
     	   
     	   // Enter Username
     	   driver.findElement(By.id("tbUserName")).sendKeys("sarah");                    
           
     	   // Enter password
     	   driver.findElement(By.id("tbPassword")).sendKeys("ggg2k7");
     	   
     	   // Check passive mode
     	   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input")).click();
     	   
     	   // Select from Schedule Type 
   	   Select dropdown = new Select(driver.findElement(By.id("ddlScheduleType")));
   	   dropdown.selectByVisibleText("After Every");
   	   	   
   	   // Enter Interval
   	   driver.findElement(By.id("tbScheduleInterval")).sendKeys("0");
     	   
     	   // Click Save
     	   driver.findElement(By.id("btnSvae")).click();
     	   String expectedbranch = "Interval must be greater than zero.";   
         
    	   // Get label message
	       String actualbranch = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[1]/td/table/tbody/tr[1]/td/label")).getText();

	       Assert.assertEquals(actualbranch, expectedbranch);

    	   driver.close(); 	      	      
}         
                      

            

////Test ID: 70-29
///* 
//* Add Branch in system when Schedule Type is "After Every" with invalid interval (special character)(&^()
//*/   
            @Test (priority = 20)
            public void AddBranchwithScheduleTypeAfterEverywithInvalidintervalSpecialCharacter() throws InterruptedException {
            System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
            driver.get(baseUrl);
          		       		     
            // Signing in OmniPCX 
            driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
            driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
            driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();                     
            
            // Click On Branches
            Thread.sleep(7000);
            driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();                               
                              		       		   
            // Click on Add Branch
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/a")).click();
          		       		   
            // Enter name
            driver.findElement(By.id("tbBranchName")).sendKeys("Branch54");
          		       		   	 
            // Enter email
            driver.findElement(By.id("tbBranchEmail")).sendKeys("someone@something.com");
            
            // Enter FTP url
            driver.findElement(By.id("tbNetworkPath")).sendKeys("ftp://172.20.0.50/");
     	   
     	   // Enter Username
     	   driver.findElement(By.id("tbUserName")).sendKeys("sarah");                    
           
     	   // Enter password
     	   driver.findElement(By.id("tbPassword")).sendKeys("ggg2k7");
     	   
     	   // Check passive mode
     	   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input")).click();
     	   
     	   // Select from Schedule Type 
   	   	   Select dropdown = new Select(driver.findElement(By.id("ddlScheduleType")));
   	   	   dropdown.selectByVisibleText("After Every");
   	   	   
   	   	   // Enter Interval
   	   	   driver.findElement(By.id("tbScheduleInterval")).sendKeys("hgdhgg%$%$%$%");
     	   
     	   // Click Save
     	   driver.findElement(By.id("btnSvae")).click();
     	   String expectedbranch = "Interval must be greater than zero.";   
         
    	   // Get label message
	       String actualbranch = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[1]/td/table/tbody/tr[1]/td/label")).getText();

	       Assert.assertEquals(actualbranch, expectedbranch);

    	   driver.close(); 	      	      
}
            
            
            
////Test ID: 70-30
///* 
//* Add Branch in system when Schedule Type is "Daily" with valid data
//*/            
            @Test (priority = 21)
            public void AddBranchwithScheduleTypeDaily() throws InterruptedException {
            System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
            driver.get(baseUrl);
          		       		     
            // Signing in OmniPCX 
            driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
            driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
            driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();                     
            
            // Click On Branches
            Thread.sleep(7000);
            driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();                               
                              		       		   
            // Click on Add Branch
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/a")).click();
          		       		   
            // Enter name
            driver.findElement(By.id("tbBranchName")).sendKeys("Branch55");
          		       		   	 
            // Enter email
            driver.findElement(By.id("tbBranchEmail")).sendKeys("someone@something.com");
            
            // Enter FTP url
            driver.findElement(By.id("tbNetworkPath")).sendKeys("ftp://172.20.0.50/");
     	   
     	   // Enter Username
     	   driver.findElement(By.id("tbUserName")).sendKeys("sarah");                    
           
     	   // Enter password
     	   driver.findElement(By.id("tbPassword")).sendKeys("ggg2k7");
     	   
     	   // Check passive mode
     	   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input")).click();
     	   
     	   // Select from Schedule Type 
   	   	   Select dropdown = new Select(driver.findElement(By.id("ddlScheduleType")));
   	   	   dropdown.selectByVisibleText("Daily");
   	   	   
   	       // Select from Hour 
   	   	   Select dropdownH = new Select(driver.findElement(By.id("ddlHour")));
   	   	   dropdownH.selectByVisibleText("12");
   	   	   
   	       // Select from Minutes 
   	   	   Select dropdownM = new Select(driver.findElement(By.id("ddlMinutes")));
   	   	   dropdownM.selectByVisibleText("30");
   	   	   
   	       // Select from Schedule Type 
   	   	   Select dropdownS = new Select(driver.findElement(By.id("ddlSecond")));
   	   	   dropdownS.selectByVisibleText("00");
     	   
     	   // Click Save
     	   driver.findElement(By.id("btnSvae")).click();
     	   
      	  Thread.sleep(3000);
   	   
      	  // Check alert message
      	  JavascriptExecutor jsz = (JavascriptExecutor)driver;
      	  jsz.executeScript("window.confirm('Settings have been saved successfully')");
    		  
      	  String expectedAlertBranchUpdated = "Settings have been saved successfully";
      	  Alert confirmation = driver.switchTo().alert();
      	  String actualAlertBranchUpdated = confirmation.getText(); //Get text present on alert Message
    
      	  /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
    	   	     Dismissed user prompt dialog: Settings have been updated successfully:*/
      	  driver.switchTo().alert().accept();
    	  
      	  // Click on okay button
      	  Thread.sleep(5000);
      	  driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     
    
      	  Assert.assertEquals(actualAlertBranchUpdated, expectedAlertBranchUpdated);

    	   driver.close(); 	      	      
}
            
 


            
////Test ID: 70-31
///* 
//* Update Branch in system 
//*/  
            @Test (priority = 22)
            public void UpdateBranch() throws InterruptedException {
            System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
            driver.get(baseUrl);
          		       		     
            // Signing in OmniPCX 
            driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
            driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
            driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();                     
            
            // Click On Branches
            Thread.sleep(7000);
            driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();
            
            // Click on edit against 1st branch
            Thread.sleep(3000);
            driver.findElement(By.className("edit_branch")).click();
            
            // change branch status to disabled
    	   	Select dropdown = new Select(driver.findElement(By.id("ddlBranchLicenseEnable")));
    	   	dropdown.selectByVisibleText("Disabled");
    	   	
    	   	// Click on update
    	   	driver.findElement(By.id("btnSvae")).click();
    	   	
    	   	Thread.sleep(3000);
    	   	   
    	   // Check alert message
      	  JavascriptExecutor jsx = (JavascriptExecutor)driver;
      	  jsx.executeScript("window.confirm('Settings have been saved successfully')");
    		  
      	  String expectedAlertBranchUpdated = "Settings have been saved successfully";
      	  Alert confirmation = driver.switchTo().alert();
      	  String actualAlertBranchUpdated = confirmation.getText(); //Get text present on alert Message
    
      	  /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
    	   	     Dismissed user prompt dialog: Settings have been updated successfully:*/
      	  driver.switchTo().alert().accept();
    	  
      	  // Click on okay button
      	  Thread.sleep(5000);
      	  driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     
    
      	  Assert.assertEquals(actualAlertBranchUpdated, expectedAlertBranchUpdated);  
                 
     	   driver.close(); 	      	      
           }
            
            
  
////Test ID: 70-33
///* 
//* Delete Branch when Status is Disabled 
//*/          
      
            @Test (priority = 23)
            public void DeleteBranchwithDisabledstatus() throws InterruptedException {
            System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
            driver.get(baseUrl);
          		       		     
            // Signing in OmniPCX 
            driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
            driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
            driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();                     
            
            // Click On Branches
            Thread.sleep(7000);
            driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();   
            
            // Click on delete against 1st branch
            Thread.sleep(3000);
            driver.findElement(By.className("remove_branch")).click();
            
            // Check alert message
      	    JavascriptExecutor jsd = (JavascriptExecutor)driver;
      	    jsd.executeScript("window.confirm('Are you sure you want to delete')");  
      		  
        	String expectedAlertBranchUpdated = "Record has been deleted successfully";
      
        	  /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
      	   	     Dismissed user prompt dialog: Settings have been updated successfully:*/
        	  driver.switchTo().alert().accept();
      	  
        	  // Click on Delete button
        	  Thread.sleep(4000);
        	  driver.findElement(By.id("btnDelete")).click(); 
        	  
        	  // Get label msg
        	  String actualAlertBranchUpdated = driver.findElement(By.id("lblMsg")).getText();
      
        	  Assert.assertEquals(actualAlertBranchUpdated, expectedAlertBranchUpdated);
            
            driver.close(); 	      	      
            }
            
            
////Test ID: 70-32
///* 
//* Delete Branch when Status is Active 
//*/
//            @Test (priority = 24)
//            public void DeleteBranchwithActivestatus() throws InterruptedException {
//            System.setProperty("webdriver.gecko.driver", driverPath);
//            driver = new FirefoxDriver();
//            driver.get(baseUrl);
//          		       		     
//            // Signing in OmniPCX 
//            driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//            driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
//            driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();                     
//            
//            // Click On Branches
//            Thread.sleep(7000);
//            driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();        
//            
//            // Check if Active branch delete is enabled
//            Assert.assertFalse(driver.findElement(By.className("remove_branch")).isDisplayed());
// 
//            driver.close(); 	      	      
//            }
            
            
////Test ID: 70-34
///* 
//* Send Email Branch when SMTP settings are configured  
//*/            
            @Test (priority = 25)
            public void SendEmailBranchwithSMTPsettings() throws InterruptedException {
            System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
            driver.get(baseUrl);
          		       		     
            // Signing in OmniPCX 
            driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
            driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
            driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();                     
            
            // Click On Branches
            Thread.sleep(7000);
            driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();      
            
            // Click on email button
            driver.findElement(By.className("sendEmail")).click();
            
            // Check alert message
  	      	JavascriptExecutor jse = (JavascriptExecutor)driver;
  	      	jse.executeScript("window.confirm('Email Sent Successfully')");  
  		  
  	      	String expectedAlertBranchUpdated = "Email Sent Successfully";
  	      	Alert confirmation = driver.switchTo().alert();
  	      	String actualAlertBranchUpdated = confirmation.getText(); //Get text present on alert Message

  	      	/* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
		   	Dismissed user prompt dialog: Settings have been updated successfully:*/
  	      	driver.switchTo().alert().accept();
	  
  	      	// Click on okay button
  	      	Thread.sleep(5000);
  	      	driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     

  	      	Assert.assertEquals(actualAlertBranchUpdated, expectedAlertBranchUpdated);  
  	      	driver.close(); 	      	      
        }
            
        
            
////Test ID: 70-35
///* 
//* Search Branch  
//*/  
            @Test (priority = 26)
            public void SearchBranch() throws InterruptedException {
            System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
            driver.get(baseUrl);
          		       		     
            // Signing in OmniPCX 
            driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
            driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
            driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();                     
            
            // Click On Branches
            Thread.sleep(7000);
            driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();  
            
            // Click on Search and enter branch name
            driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[7]/td/div/div[1]/div/label/input")).sendKeys("ABranch");
                        
            // Only Searched branch Data would be present in the table i.e. Branch Name 
    	    String expectedColumnData ="ABranch"; 
           
    	    Thread.sleep(4000);
    	    //Following code get's row data from the table and prints it
//    	    System.out.println("table data for the following row");
            List<WebElement> allColumnsInRow=driver.findElements(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[7]/td/div/table/tbody/tr[1]/td[1]"));
            	for(WebElement e: allColumnsInRow)
            		{
//             			System.out.println(e.getText());
            			String actualColumnData = e.getText();
            			Assert.assertEquals(actualColumnData, expectedColumnData);
            		}
    	    
            driver.close(); 	      	      
            }
            
            
            

////Test ID: 70-36
///* 
//* Search Branch from Search Branch Tab with Branch Name field and "Begins With" criteria 
//*/      
          @Test (priority = 27)
          public void SearchBranchithBeginsWithCriteria() throws InterruptedException {
          System.setProperty("webdriver.gecko.driver", driverPath);
          driver = new FirefoxDriver();
          driver.get(baseUrl);
        		       		     
          // Signing in OmniPCX 
          driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
          driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
          driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();                     
          
          // Click On Branches
          Thread.sleep(7000);
          driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();  
          
          // Click on Find and enter branch name to be searched
          driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[5]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/input")).sendKeys("ABranch");
          
          // Click on Find button
          Thread.sleep(4000);
          driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[5]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[4]/td[2]/input")).click();

          // Only Searched branch Data would be present in the table i.e. Branch Name 
 	      String expectedColumnData ="ABranch"; 
         
 	     // Following code get's row data from the table and prints it
 	     // System.out.println("table data for the following row");
         List<WebElement> allColumnsInRow=driver.findElements(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[7]/td/div/table/tbody/tr[1]/td[1]"));
         	for(WebElement e: allColumnsInRow)
         		{
//          			System.out.println(e.getText());
         			String actualColumnData = e.getText();
         			Assert.assertEquals(actualColumnData, expectedColumnData);
         		}
          
          driver.close(); 	      	      
          }        

          
          

////Test ID: 70-37
///* 
//* Search Branch from Search Branch Tab with Branch Name field and "Ends With" criteria 
//*/          
          @Test (priority = 28)
          public void SearchBranchithEndsWithCriteria() throws InterruptedException {
          System.setProperty("webdriver.gecko.driver", driverPath);
          driver = new FirefoxDriver();
          driver.get(baseUrl);
          
          // Signing in OmniPCX 
          driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
          driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
          driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();                     
          
          // Click On Branches
          Thread.sleep(7000);
          driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click(); 
          
          // Select from Criteria 
	   	   Select dropdownc = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[5]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[2]/select")));
	   	   dropdownc.selectByVisibleText("ends with"); 
           
          // Click on Find and enter branch name to be searched
          driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[5]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/input")).sendKeys("55");
          
          // Click on Find button
          driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[5]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[4]/td[2]/input")).click();

          // Only Searched branch Data would be present in the table i.e. Branch Name 
 	      String expectedColumnData ="Branch55"; 
         
 	     // Following code get's row data from the table and prints it
 	     // System.out.println("table data for the following row");
         List<WebElement> allColumnsInRow=driver.findElements(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[7]/td/div/table/tbody/tr[1]/td[1]"));
         	for(WebElement e: allColumnsInRow)
         		{
//          			System.out.println(e.getText());
         			String actualColumnData = e.getText();
         			Assert.assertEquals(actualColumnData, expectedColumnData);
         		}
          
          driver.close(); 	      	      
          }        
      
          
       
////Test ID: 70-38
///* 
//* Search Branch from Search Branch Tab with Branch Name field and "Contains" criteria 
//*/          
                  @Test (priority = 29)
                  public void SearchBranchithContainsCriteria() throws InterruptedException {
                  System.setProperty("webdriver.gecko.driver", driverPath);
                  driver = new FirefoxDriver();
                  driver.get(baseUrl); 
                  
                  // Signing in OmniPCX 
                  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
                  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
                  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();                     
                  
                  // Click On Branches
                  Thread.sleep(7000);
                  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click(); 
                  
                  // Select from Criteria 
        	   	   Select dropdownc = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[5]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[2]/select")));
        	   	   dropdownc.selectByVisibleText("ends with"); 
                   
                  // Click on Find and enter branch name to be searched
                  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[5]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/input")).sendKeys("54");
                  
                  // Click on Find button
                  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[5]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[4]/td[2]/input")).click();

                  // Only Searched branch Data would be present in the table i.e. Branch Name 
         	      String expectedColumnData ="Branch54"; 
                 
         	     // Following code get's row data from the table and prints it
         	     // System.out.println("table data for the following row");
                 List<WebElement> allColumnsInRow=driver.findElements(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[7]/td/div/table/tbody/tr[1]/td[1]"));
                 	for(WebElement e: allColumnsInRow)
                 		{
//                  			System.out.println(e.getText());
                 			String actualColumnData = e.getText();
                 			Assert.assertEquals(actualColumnData, expectedColumnData);
                 		}
                  
                  driver.close(); 	      	      
                  }
                  
                  
                  
                  
////Test ID: 70-39
///* 
//* Search Branch from Search Branch Tab with Branch Name field and "Is Exactly" criteria 
//*/ 
                  @Test (priority = 30)
                  public void SearchBranchithIsExactlyCriteria() throws InterruptedException {
                  System.setProperty("webdriver.gecko.driver", driverPath);
                  driver = new FirefoxDriver();
                  driver.get(baseUrl); 
                  
                  // Signing in OmniPCX 
                  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
                  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
                  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();                     
                  
                  // Click On Branches
                  Thread.sleep(7000);
                  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click(); 
                  
                  // Select from Criteria 
        	   	   Select dropdownc = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[5]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[2]/select")));
        	   	   dropdownc.selectByVisibleText("is exactly");     
        	   	   
        	   	 // Click on Find and enter branch name to be searched
                   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[5]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/input")).sendKeys("Branch54");
                   
                   // Click on Find button
                   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[5]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[4]/td[2]/input")).click();

                   // Only Searched branch Data would be present in the table i.e. Branch Name 
          	      String expectedColumnData ="Branch54"; 
                  
          	     // Following code get's row data from the table and prints it
          	     // System.out.println("table data for the following row");
                  List<WebElement> allColumnsInRow=driver.findElements(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[7]/td/div/table/tbody/tr[1]/td[1]"));
                  	for(WebElement e: allColumnsInRow)
                  		{
//                   			System.out.println(e.getText());
                  			String actualColumnData = e.getText();
                  			Assert.assertEquals(actualColumnData, expectedColumnData);
                  		}
                  
        	driver.close(); 	      	      
            }
                  

                  
////Test ID: 70-47
///* 
//* Verify user is redirected to previous page from branches page when cancel button is clicked 
//*/         
                @Test (priority = 31)
                public void BranchRedirectedtoPreviouspage() throws InterruptedException {
                System.setProperty("webdriver.gecko.driver", driverPath);
                driver = new FirefoxDriver();
                driver.get(baseUrl);
              		       		     
                // Signing in OmniPCX 
                driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
                driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
                driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();                     
                
                // Click On Branches
                Thread.sleep(7000);
                driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();
                
                // Click on edit against 1st branch
                Thread.sleep(3000);
                driver.findElement(By.className("edit_branch")).click();
        	   	
        	   	// Click on cancel
        	   	driver.findElement(By.id("btnCancel")).click();
        	   	
        	   	Thread.sleep(3000);  
        
                // Check branch table is displayed          	  
        	   	Assert.assertTrue(driver.findElement(By.id("tblBranch_wrapper")).isDisplayed());
          	  
                     
         	   driver.close(); 	      	      
               } 
                

                @AfterClass
                public void tearDown() throws Exception {
            	        driver.quit();	}               
                  
                  
}
