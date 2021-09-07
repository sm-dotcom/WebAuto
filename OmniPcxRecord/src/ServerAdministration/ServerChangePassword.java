/* 
@author: sarah.mahmood 
Created on Apr 27, 2021
*/
package ServerAdministration;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
//import org.openqa.selenium.support.ui.Select;

public class ServerChangePassword {
	
    public String baseUrl = "http://172.20.22.81/OmniPCXRecord/TenantAdmin.aspx";
	
    String driverPath = "C:\\Users\\sarah.mahmood\\Downloads\\gecko-driver\\geckodriver.exe";
	
	public WebDriver driver;
	
////Test ID: 03-01
///* 
//* Verify that change password page exists for default server 'admin' user 
//*/    
	
//	  @Test (priority = 0)
//      public void VerifyChangePasswordexistsforAdmin() throws InterruptedException {
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
//      // Click On Change Password
//      Thread.sleep(7000);
//	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink1")).click();
//	  
//	  Assert.assertTrue(driver.findElement(By.id("txtOldPwd")).isDisplayed());
//	  
//	  driver.close();	     	
//  }
	  

	 
////Test ID: 03-02
///* 
//* Verify that change password page exists for normal opr user 
//*/ 	  
	  
//	  @Test (priority = 1)
//      public void VerifyChangePasswordexistsforNormalUser() throws InterruptedException {	
//        System.setProperty("webdriver.gecko.driver", driverPath);
//         driver = new FirefoxDriver();
//         driver.get(baseUrl);
//	   
//         // Signing in OmniPCX 
//         driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//         driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
//         driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//       
//         // Click on Users
//         Thread.sleep(5000);
//         driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
//         
//         // Make a new user
//         // Click on Add Users
//         driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
//         
//         Thread.sleep(5000);
//         // Fillout the form for new user
//         // Locate Fname and enter value
//         driver.findElement(By.id("tbFirstName")).sendKeys("Tracy");
//         
//         // Locate Lname and enter value
//         driver.findElement(By.id("tbLastName")).sendKeys("West");
//         
//         Thread.sleep(5000);
//         // Locate username and enter value
//         driver.findElement(By.id("tbUserName")).sendKeys("twest");
//         
//         // Locate password and enter value
//         driver.findElement(By.id("tbPassword")).sendKeys("1234567a");
//         
//         // Locate confirm password and enter value
//         driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567a");
//         
//         Thread.sleep(5000);
//         // Locate Password Never Expires checkbox and check
//         WebElement PasswordNeverExpires = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/input")) ;
//         PasswordNeverExpires.click();
//         
//         // Locate email and enter value
//         WebElement emailbox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input"));
//         emailbox.sendKeys("tracy.west@example.com");
//         
//         Thread.sleep(5000);
//         // Locate Enable Account checkbox and check
//         WebElement EnableAccount = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input"));
//         EnableAccount.click();
//         
//         Thread.sleep(5000);
//         // Locate Security Groups Roles and Click/Select
//         WebElement ServerAdmin = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option"));
//         ServerAdmin.click();
//         
//         // Locate ">" and click
//         driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();
//         
//         Thread.sleep(5000);
//         // Locate Save button and click
//         driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();
//         
//         Thread.sleep(5000);
//         // Check alert message
//         JavascriptExecutor jsx = (JavascriptExecutor)driver;
//         jsx.executeScript("window.confirm('Settings have been saved successfully')");
//       
//         /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
//         Dismissed user prompt dialog: Settings have been updated successfully:*/
//         driver.switchTo().alert().accept();
//         Thread.sleep(5000); 
//         
//         // Click on okay button
//         Thread.sleep(5000);
//         driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button/span")).click();
//         
//         // Click on Logout
//  	     driver.findElement(By.id("ctl00_lblLogOut")).click();
//  	     
//  	     // Signing in OmniPCX again
//         driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("twest");
//         driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
//         driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//         
//         JavascriptExecutor jsr = (JavascriptExecutor)driver;
//         jsr.executeScript("window.confirm('Please change your password to continue. Your account will be disabled if you click Cancel button 3 times.')");
//       
//         /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
//         Dismissed user prompt dialog: Settings have been updated successfully:*/
//         driver.switchTo().alert().accept();
//         Thread.sleep(5000); 
//         
//         // Click on okay button
//         Thread.sleep(5000);
//         driver.findElement(By.id("btnOK")).click();
//         
//         // Enter Old Password, New Password & Confirm Password
//         driver.findElement(By.id("ctrl_ChangePassword1_tbOldPassword")).sendKeys("1234567a");
//         driver.findElement(By.id("ctrl_ChangePassword1_tbNewPassword")).sendKeys("admin12345");
//         driver.findElement(By.id("ctrl_ChangePassword1_tbConfirmPassword")).sendKeys("admin12345");
//         
//         // Click on update button
//         driver.findElement(By.id("ctrl_ChangePassword1_btnUpdate")).click();
////         Thread.sleep(7000);
//         
//         // Click On Change Password
//         Thread.sleep(7000);
//   	     driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink1")).click();
//   	  
//   	     Assert.assertTrue(driver.findElement(By.id("txtOldPwd")).isDisplayed());
//   	     
//         driver.close();    
//}
	  
	  
	 
	  
////Test ID: 03-03
///* 
//* Verify that change password page exists for Active Directory user 
//*/	  
	   
//	  @Test (priority = 2)
//      public void VerifyChangePasswordexistsforActiveDirectoryUser() throws InterruptedException {
//		  System.setProperty("webdriver.gecko.driver", driverPath);
//	      driver = new FirefoxDriver();
//	      driver.get(baseUrl);
//
//	      // Signing in OmniPCX
//	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
//	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();  
//		  
//	      // Click on System
//	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
//		  
//	      // Select from dropdown 
//	      Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
//		  dropdown.selectByVisibleText("Active Directory");
//		  
//		  // Fill in the required information
//		  // Enter Domain Name
//		  driver.findElement(By.id("txtADDomainName")).clear(); //In case some value already present clear
//		  driver.findElement(By.id("txtADDomainName")).sendKeys("ghostsoftware.local");
//		  
//		  // Enter Username
//		  driver.findElement(By.id("txtADUsername")).clear();
//		  driver.findElement(By.id("txtADUsername")).sendKeys("ahsan.rehman");
//		  
//		  // Enter Password
//		  driver.findElement(By.id("txtADPassword")).clear();
//		  driver.findElement(By.id("txtADPassword")).sendKeys("Abc123*");
//		  
//		  // Check radio button "Include all Containers" for Criteria
//		  driver.findElement(By.id("rbADCriteriaAll")).click();
//		  
//		  // Click on update button
//		  driver.findElement(By.id("btnUpdateAuthSettings")).click(); 
//		  
//		  // Click on Logout
//		  driver.findElement(By.id("ctl00_lblLogOut")).click();
//		  
//		  // Re-signing in OmniPCX
//	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
//	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();  
//	      
//	      // Click on Users
//	      Thread.sleep(7000);
//	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
//	      
//	      // Click on Add Active Directory User
//	      Thread.sleep(3000);
//		  driver.findElement(By.xpath("//*[text()='Add Active Directory User']")).click();
//		  
//		  // Select search user
//		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td/table[2]/tbody/tr/td/div/div[1]/div/label/input")).sendKeys("sarah.mahmood");
//		  
//		  // Click on Edit button
//		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td/table[2]/tbody/tr/td/div/table/tbody/tr/td[3]/img")).click();
//		  
//		  // Click on enable account checkbox
//		  Thread.sleep(3000);
//		  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input")).click();
//		  
//	      // Locate email and enter value
//	      WebElement emailbox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input"));
//	      emailbox.sendKeys("sarah.mahmood@amigo-software.com");
//		  
//	      // Locate Security Groups Roles and Click/Select
//	      Thread.sleep(3000);
//	      WebElement ServerAdmin = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option"));
//	      ServerAdmin.click();
//	      
//	      // Locate ">" and click
//	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();
//
//	      Thread.sleep(3000);
//	      // Click on save button
//		  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();
//		  
//	      // Check alert message
//	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
//	      jsx.executeScript("window.confirm('Settings have been saved successfully')");
//		  
//	      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
//	      Dismissed user prompt dialog: Settings have been updated successfully:*/
//	      driver.switchTo().alert().accept();
//	  
//	      // Click on okay button
//	      Thread.sleep(5000);
//	      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();  
//	      
//	      // Click on Logout
//		  driver.findElement(By.id("ctl00_lblLogOut")).click();
//	      
//	      // Re re-signing in OmniPCX
//	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("sarah.mahmood");
//	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("Abc123*");
//	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();  
//	      
//	      // Click On Change Password
//	      Thread.sleep(7000);
//	   	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink1")).click();
//	   	  
//	   	  Assert.assertFalse(driver.findElement(By.id("txtOldPwd")).isEnabled());
//	   	  	    
//	      driver.close();    
//} //////////////////////////Check with someone
	  

	  
	  
////Test ID: 03-06
///* 
//* Verify that change password fields are disabled for Active Directory user on change password page
//*/	  
		   
//		  @Test (priority = 3)
//	      public void VerifyChangePasswordDisabledforActiveDirectoryUser() throws InterruptedException {
//			  System.setProperty("webdriver.gecko.driver", driverPath);
//		      driver = new FirefoxDriver();
//		      driver.get(baseUrl);
//		      
//		      // Signing in OmniPCX
//		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("sarah.mahmood");
//		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("Abc123*");
//		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();  
//		      
//		      // Click On Change Password
//		      Thread.sleep(7000);
//		   	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink1")).click();
//		   	  
//		   	  Assert.assertFalse(driver.findElement(By.id("txtOldPwd")).isEnabled());
//		   	  Assert.assertFalse(driver.findElement(By.id("txtNewPwd")).isEnabled());
//		   	  Assert.assertFalse(driver.findElement(By.id("txtCnfrmPwd")).isEnabled());
//		   	  
//		    
//		      driver.close();    
//	}  
	  
	  
	  
	  
////Test ID: 03-04
///* 
//* Verify that change password fields are enabled for default server 'admin' user on change password page 
//*/    
		
//		  @Test (priority = 4)
//	      public void VerifyChangePasswordenabledforAdmin() throws InterruptedException {
//			  
//	  	  System.setProperty("webdriver.gecko.driver", driverPath);
//	      driver = new FirefoxDriver();
//	      driver.get(baseUrl);
//	      
//	      // Signing in OmniPCX 
//	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
//	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//	      
//	      // To set back to omnipcx record currently set to active directory
//	      // Click on System
//	      Thread.sleep(3000);
//	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
//		  
//	      // Select from dropdown 
//	      Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
//		  dropdown.selectByVisibleText("OmniPCX RECORD");
//		  
//		  // Click on update button
//		  driver.findElement(By.id("btnUpdateAuthSettings")).click(); 
//		  
//		  // Click on Logout
//		  driver.findElement(By.id("ctl00_lblLogOut")).click();
//		  
//		  // Re-signing in OmniPCX
//	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
//	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();  
//	      
//	    	
//	      // Click On Change Password
//	      Thread.sleep(7000);
//		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink1")).click();
//		  
//		  Assert.assertTrue(driver.findElement(By.id("txtOldPwd")).isEnabled());
//		  Assert.assertTrue(driver.findElement(By.id("txtNewPwd")).isEnabled());
//		  Assert.assertTrue(driver.findElement(By.id("txtCnfrmPwd")).isEnabled());
//		  
//		  driver.close();	     	
//}
	  

////Test ID: 03-05
///* 
//* Verify that change password fields are enabled for normal opr user on change password page 
//*/    
/////////////////////Normal OPR user created in previous test cases	

//	    @Test (priority = 5)
//      public void VerifyChangePasswordenabledforNormalUser() throws InterruptedException {
//		  
//  	  System.setProperty("webdriver.gecko.driver", driverPath);
//      driver = new FirefoxDriver();
//      driver.get(baseUrl);
//
//      // Signing in OmniPCX 
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("twest");
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("admin12345");
//      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//    	
//      // Click On Change Password
//      Thread.sleep(7000);
//	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink1")).click();
//	  
//	  Assert.assertTrue(driver.findElement(By.id("txtOldPwd")).isEnabled());
//	  Assert.assertTrue(driver.findElement(By.id("txtNewPwd")).isEnabled());
//	  Assert.assertTrue(driver.findElement(By.id("txtCnfrmPwd")).isEnabled());
//	  
//	  driver.close();	     	
//  }
  
	  
////Test ID: 03-07
///* 
//* Verify that only three fields are available on change password page  
//*/ 	  
	  
//	  @Test (priority = 6)
//      public void VerifyThreeFieldsinChangePassword() throws InterruptedException {
//		  
//  	  System.setProperty("webdriver.gecko.driver", driverPath);
//      driver = new FirefoxDriver();
//      driver.get(baseUrl);
//
//      // Signing in OmniPCX 
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("twest");
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("admin12345");
//      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//    	
//      // Click On Change Password
//      Thread.sleep(7000);
//	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink1")).click();
//	  
//	  Assert.assertTrue(driver.findElement(By.id("txtOldPwd")).isDisplayed());
//	  Assert.assertTrue(driver.findElement(By.id("txtNewPwd")).isDisplayed());
//	  Assert.assertTrue(driver.findElement(By.id("txtCnfrmPwd")).isDisplayed());
//	  
//	  driver.close();	     	
//  }
	  
	  
	  
////Test ID: 03-08
///* 
//* Change password of default server 'admin' user with valid data  
//*/ 	  
	  
//	  @Test (priority = 7)
//      public void VerifyChangePasswordforDefaultUser() throws InterruptedException {
//		  
//  	  System.setProperty("webdriver.gecko.driver", driverPath);
//      driver = new FirefoxDriver();
//      driver.get(baseUrl);
//
//      // Signing in OmniPCX 
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567aa");
//      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//    	
//      // Click On Change Password
//      Thread.sleep(7000);
//	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink1")).click();
//	  
//	  // Change password
//	  driver.findElement(By.id("txtOldPwd")).sendKeys("1234567aa");
//	  driver.findElement(By.id("txtNewPwd")).sendKeys("bucket123");
//	  driver.findElement(By.id("txtCnfrmPwd")).sendKeys("bucket123");
//	  
//	  // Click on Update button
//	  driver.findElement(By.id("btnUpdate")).click();                              
//	  
//	  String expectedmsg = "Settings have been updated successfully";
//	  String actualmsg = driver.findElement(By.id("lblMessage")).getText();
//	  
//	  Assert.assertEquals(actualmsg, expectedmsg);
//	  	  
//	  driver.close();	     	
//	  }
	  
	
	  
	  
////Test ID: 03-09
///* 
//* Change password of normal opr user with valid data  
//*/	  
	  
//	  @Test (priority = 8)
//      public void VerifyChangePasswordforNormalUser() throws InterruptedException {
//		  
//		  System.setProperty("webdriver.gecko.driver", driverPath);
//	      driver = new FirefoxDriver();
//	      driver.get(baseUrl);
//	
//	      // Signing in OmniPCX 
//	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("twest");
//	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("admin12345");
//	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//	    	
//	      // Click On Change Password
//	      Thread.sleep(7000);
//		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink1")).click();
//    	
//	  
//	  // Change password
//	  driver.findElement(By.id("txtOldPwd")).sendKeys("admin12345");
//	  driver.findElement(By.id("txtNewPwd")).sendKeys("1234567a");
//	  driver.findElement(By.id("txtCnfrmPwd")).sendKeys("1234567a");
//	  
//	  // Click on Update button
//	  driver.findElement(By.id("btnUpdate")).click();                              
//	  
//	  String expectedmsg = "Settings have been updated successfully";
//	  String actualmsg = driver.findElement(By.id("lblMessage")).getText();
//	  
//	  Assert.assertEquals(actualmsg, expectedmsg);
//	  	  
//	  driver.close();	     	
//	  } 
	  
	  
	
	
////Test ID: 03-10
///* 
//* Change password with empty Old Password  
//*/	
	
//	  @Test (priority = 9)
//     public void VerifyChangePasswordwithemptyOldPassword() throws InterruptedException {
//	
//	  System.setProperty("webdriver.gecko.driver", driverPath);
//      driver = new FirefoxDriver();
//      driver.get(baseUrl);
//
//      // Signing in OmniPCX 
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("bucket123");
//      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//  	
//      // Click On Change Password
//      Thread.sleep(7000);
//	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink1")).click();
//	  
//	  // Change password
//	  //driver.findElement(By.id("txtOldPwd")).sendKeys("admin12345");
//	  driver.findElement(By.id("txtNewPwd")).sendKeys("1234567a");
//	  driver.findElement(By.id("txtCnfrmPwd")).sendKeys("1234567a");
//	  
//	  // Click on Update button
//	  driver.findElement(By.id("btnUpdate")).click();                              
//	  
//	  String expectedmsg = "Please enter Old Password";
//	  String actualmsg = driver.findElement(By.id("lblMessage")).getText();
//	  
//	  Assert.assertEquals(actualmsg, expectedmsg);
//	  	  
//	  driver.close();	     	
//	  } 
	  


////Test ID: 03-11
///* 
//* Change password with empty New Password  
//*/	
	 
//	  @Test (priority = 10)
//      public void VerifyChangePasswordwithemptyNewPassword() throws InterruptedException {
//	
//	  System.setProperty("webdriver.gecko.driver", driverPath);
//      driver = new FirefoxDriver();
//      driver.get(baseUrl);
//
//      // Signing in OmniPCX 
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("bucket123");
//      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//	
//      // Click On Change Password
//      Thread.sleep(7000);
//	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink1")).click();
//	  
//	  // Change password
//	  driver.findElement(By.id("txtOldPwd")).sendKeys("admin12345");
////	  driver.findElement(By.id("txtNewPwd")).sendKeys("1234567a");
//	  driver.findElement(By.id("txtCnfrmPwd")).sendKeys("1234567a");
//	  
//	  // Click on Update button
//	  driver.findElement(By.id("btnUpdate")).click();                              
//	  
//	  String expectedmsg = "Password cannot be empty. Please provide New Password"; 
//	  String actualmsg = driver.findElement(By.id("lblMessage")).getText();
//	  
//	  Assert.assertEquals(actualmsg, expectedmsg);
//	  	  
//	  driver.close();	     	
//	  } 
	  
	  
	  
////Test ID: 03-12
///* 
//* Change password with empty Confirm New Password  
//*/	  
     
//	  @Test (priority = 11)
//      public void VerifyChangePasswordwithemptyCnfrmPassword() throws InterruptedException {
//	
//	  System.setProperty("webdriver.gecko.driver", driverPath);
//      driver = new FirefoxDriver();
//      driver.get(baseUrl);
//
//      // Signing in OmniPCX 
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("bucket123");
//      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//	
//      // Click On Change Password
//      Thread.sleep(7000);
//	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink1")).click();
//	  
//	  // Change password
//	  driver.findElement(By.id("txtOldPwd")).sendKeys("bucket123");
//	  driver.findElement(By.id("txtNewPwd")).sendKeys("1234567a");
////	  driver.findElement(By.id("txtCnfrmPwd")).sendKeys("1234567a");
//	  
//	  // Click on Update button
//	  driver.findElement(By.id("btnUpdate")).click();                              
//	  
//	  String expectedmsg = "New Password and Confirm New Password are not same";
//	  String actualmsg = driver.findElement(By.id("lblMessage")).getText();
//	  
//	  Assert.assertEquals(actualmsg, expectedmsg);
//	  	  
//	  driver.close();	     	
//	  } 

	  
	  

////Test ID: 03-13
///* 
//* Change password with wrong old password 
//*/	  
     
//	  @Test (priority = 12)
//      public void VerifyChangePasswordwrongOldPassword() throws InterruptedException {
//	
//	  System.setProperty("webdriver.gecko.driver", driverPath);
//      driver = new FirefoxDriver();
//      driver.get(baseUrl);
//
//      // Signing in OmniPCX 
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("bucket123");
//      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//	
//      // Click On Change Password
//      Thread.sleep(7000);
//	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink1")).click();
//	  
//	  // Change password
//	  driver.findElement(By.id("txtOldPwd")).sendKeys("errtrt");
//	  driver.findElement(By.id("txtNewPwd")).sendKeys("bucks123");
//	  driver.findElement(By.id("txtCnfrmPwd")).sendKeys("bucks123");
//	  
//	  // Click on Update button
//	  driver.findElement(By.id("btnUpdate")).click();                              
//	  
//	  String expectedmsg = "Old password is incorrect";
//	  String actualmsg = driver.findElement(By.id("lblMessage")).getText();
//	  
//	  Assert.assertEquals(actualmsg, expectedmsg);
//	  	  
//	  driver.close();	     	
//	  } 
	  

	  

////Test ID: 03-14
///* 
//* Change password with same old password and new password 
//*/	  
	    
//	  @Test (priority = 13)
//      public void VerifyChangePasswordsameOldNewPassword() throws InterruptedException {
//	
//	  System.setProperty("webdriver.gecko.driver", driverPath);
//      driver = new FirefoxDriver();
//      driver.get(baseUrl);
//
//      // Signing in OmniPCX 
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("bucket123");
//      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//	
//      // Click On Change Password
//      Thread.sleep(7000);
//	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink1")).click();
//	  
//	  // Change password
//	  driver.findElement(By.id("txtOldPwd")).sendKeys("bucket123");
//	  driver.findElement(By.id("txtNewPwd")).sendKeys("bucket123");
//	  driver.findElement(By.id("txtCnfrmPwd")).sendKeys("bucket123");
//	  
//	  // Click on Update button
//	  driver.findElement(By.id("btnUpdate")).click();                              
//	  
//	  String expectedmsg = "You cannot repeat an old password.";
//	  String actualmsg = driver.findElement(By.id("lblMessage")).getText();
//	  
//	  Assert.assertEquals(actualmsg, expectedmsg);
//	  	  
//	  driver.close();	     	
//	  } 
	  
	   

////Test ID: 03-15
///* 
//* Change password with different new password and Confirm new password
//*/
      
//	  @Test (priority = 14)
//      public void VerifyChangePasswordwithdifferentNewCnfrmPassword() throws InterruptedException {
//	
//	  System.setProperty("webdriver.gecko.driver", driverPath);
//      driver = new FirefoxDriver();
//      driver.get(baseUrl);
//
//      // Signing in OmniPCX 
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("bucket123");
//      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//	
//      // Click On Change Password
//      Thread.sleep(7000);
//	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink1")).click();
//	  
//	  // Change password
//	  driver.findElement(By.id("txtOldPwd")).sendKeys("1234567a");
//	  driver.findElement(By.id("txtNewPwd")).sendKeys("1234567a");
//	  driver.findElement(By.id("txtCnfrmPwd")).sendKeys("hghgghgf");
//	  
//	  // Click on Update button
//	  driver.findElement(By.id("btnUpdate")).click();                              
//	  
//	  String expectedmsg = "New Password and Confirm New Password are not same";
//	  String actualmsg = driver.findElement(By.id("lblMessage")).getText();
//	  
//	  Assert.assertEquals(actualmsg, expectedmsg);
//	  	  
//	  driver.close();	     	
//	  } 
	    
	
	  
////Test ID: 03-16
///* 
//* Change password with username in password for default server 'admin' user
//*/
	     
//	  @Test (priority = 15)
//      public void VerifyChangePasswordwithDefaultUsernamePassword() throws InterruptedException {
//	
//	  System.setProperty("webdriver.gecko.driver", driverPath);
//      driver = new FirefoxDriver();
//      driver.get(baseUrl);
//
//      // Signing in OmniPCX 
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("bucket123");
//      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//	
//      // Click On Change Password
//      Thread.sleep(7000);
//	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink1")).click();
//	  
//	  // Change password
//	  driver.findElement(By.id("txtOldPwd")).sendKeys("bucket123");
//	  driver.findElement(By.id("txtNewPwd")).sendKeys("admin123");
//	  driver.findElement(By.id("txtCnfrmPwd")).sendKeys("admin123");
//	  
//	  // Click on Update button
//	  driver.findElement(By.id("btnUpdate")).click();                              
//	  
//	  String expectedmsg = "Password must not contain username";
//	  String actualmsg = driver.findElement(By.id("lblMessage")).getText();
//	  
//	  Assert.assertEquals(actualmsg, expectedmsg);
//	  	  
//	  driver.close();	     	
//	  } 

	  
	  
////Test ID: 03-17
///* 
//* Change password that was set previously
//*/	  
	  
//	  @Test (priority = 17)
//      public void VerifyChangePasswordwithOldPasswordforDefaultUsernamePassword() throws InterruptedException {
//	
//	  System.setProperty("webdriver.gecko.driver", driverPath);
//      driver = new FirefoxDriver();
//      driver.get(baseUrl);
//
//      // Signing in OmniPCX 
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("bucket123");
//      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//	
//      // Click On Change Password
//      Thread.sleep(7000);
//	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink1")).click();
//	  
//	  // Change password
//	  driver.findElement(By.id("txtOldPwd")).sendKeys("bucket123");
//	  driver.findElement(By.id("txtNewPwd")).sendKeys("1234567a");
//	  driver.findElement(By.id("txtCnfrmPwd")).sendKeys("1234567a");
//	  
//	  // Click on Update button
//	  driver.findElement(By.id("btnUpdate")).click();                              
//	  
//	  String expectedmsg = "You can't enter any of your previous 4 passwords";
//	  String actualmsg = driver.findElement(By.id("lblMessage")).getText();
//	  
//	  Assert.assertEquals(actualmsg, expectedmsg);
//	  	  
//	  driver.close();	     	
//	  } 
	  
	  
	  
////Test ID: 03-18
///* 
//* Verify that password must be greater than 7 characters
//*/	  
	   
//	  @Test (priority = 18)
//      public void VerifyChangePasswordwithgreaterthanSevenCharacters() throws InterruptedException {
//	
//	  System.setProperty("webdriver.gecko.driver", driverPath);
//      driver = new FirefoxDriver();
//      driver.get(baseUrl);
//
//      // Signing in OmniPCX 
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("bucket123");
//      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//	
//      // Click On Change Password
//      Thread.sleep(7000);
//	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink1")).click();
//	  
//	  // Change password
//	  driver.findElement(By.id("txtOldPwd")).sendKeys("bucket123");
//	  driver.findElement(By.id("txtNewPwd")).sendKeys("123456");
//	  driver.findElement(By.id("txtCnfrmPwd")).sendKeys("123456");
//	  
//	  // Click on Update button
//	  driver.findElement(By.id("btnUpdate")).click();                              
//	  
//	  String expectedmsg = "Password must be greater than 7 characters.";
//	  String actualmsg = driver.findElement(By.id("lblMessage")).getText();
//	  
//	  Assert.assertEquals(actualmsg, expectedmsg);
//	  	  
//	  driver.close();	     	
//	  } 
	  
	  
	  
////Test ID: 03-19
///* 
//* Verify that password must be alpha numeric
//*/	  

//	  @Test (priority = 19)
//      public void VerifyChangePasswordwithAlphaNumeric() throws InterruptedException {
//	
//	  System.setProperty("webdriver.gecko.driver", driverPath);
//      driver = new FirefoxDriver();
//      driver.get(baseUrl);
//
//      // Signing in OmniPCX 
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("bucket123");
//      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//	
//      // Click On Change Password
//      Thread.sleep(7000);
//	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink1")).click();
//	  
//	  // Change password
//	  driver.findElement(By.id("txtOldPwd")).sendKeys("bucket123");
//	  driver.findElement(By.id("txtNewPwd")).sendKeys("123456aaa");
//	  driver.findElement(By.id("txtCnfrmPwd")).sendKeys("123456aaa");
//	  
//	  // Click on Update button
//	  driver.findElement(By.id("btnUpdate")).click();                              
//	  
//	  String expectedmsg = "Password must contain alphanumeric characters, with no more than two identical consecutive characters.";
//	  String actualmsg = driver.findElement(By.id("lblMessage")).getText();
//	  
//	  Assert.assertEquals(actualmsg, expectedmsg);
//	  	  
//	  driver.close();	     	
//	  } 
	
	  

////Test ID: 03-20
///* 
//* Verify that password cannot be of length greater than 50
//*/	  
	   
//	  @Test (priority = 20)
//      public void VerifyChangePasswordwithPasswordlengh50() throws InterruptedException {
//	
//	  System.setProperty("webdriver.gecko.driver", driverPath);
//      driver = new FirefoxDriver();
//      driver.get(baseUrl);
//
//      // Signing in OmniPCX 
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("bucket123");
//      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//	
//      // Click On Change Password
//      Thread.sleep(7000);
//	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink1")).click();
//	  
//	  // Change password
//	  driver.findElement(By.id("txtOldPwd")).sendKeys("bucket123");
//	  driver.findElement(By.id("txtNewPwd")).sendKeys("This is a group name a group is created by it now okaymove on");
//	  driver.findElement(By.id("txtCnfrmPwd")).sendKeys("This is a group name a group is created by it now okay move on");
//	  
//	  // Click on Update button
//	  driver.findElement(By.id("btnUpdate")).click();                              
//	  
//	  String expectedmsg = "Password must contain alphanumeric characters, with no more than two identical consecutive characters.";
//	  String actualmsg = driver.findElement(By.id("lblMessage")).getText();
//	  
//	  Assert.assertEquals(actualmsg, expectedmsg);
//	  	  
//	  driver.close();	     	
//	  } ////////////////////////// Check-in
	  
	  
	  

////Test ID: 03-21
///* 
//* Verify that password cannot be of more than two consecutive identical characters
//*/	
	  
//	  @Test (priority = 21)
//      public void VerifyChangePasswordwithtwoconsecutiveAlphaNumeric() throws InterruptedException {
//	
//	  System.setProperty("webdriver.gecko.driver", driverPath);
//      driver = new FirefoxDriver();
//      driver.get(baseUrl);
//
//      // Signing in OmniPCX 
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("bucket123");
//      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//	
//      // Click On Change Password
//      Thread.sleep(7000);
//	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink1")).click();
//	  
//	  // Change password
//	  driver.findElement(By.id("txtOldPwd")).sendKeys("bucket123");
//	  driver.findElement(By.id("txtNewPwd")).sendKeys("123456aaa");
//	  driver.findElement(By.id("txtCnfrmPwd")).sendKeys("123456aaa");
//	  
//	  // Click on Update button
//	  driver.findElement(By.id("btnUpdate")).click();                              
//	  
//	  String expectedmsg = "Password must contain alphanumeric characters, with no more than two identical consecutive characters.";
//	  String actualmsg = driver.findElement(By.id("lblMessage")).getText();
//	  
//	  Assert.assertEquals(actualmsg, expectedmsg);
//	  	  
//	  driver.close();	     	
//	  } 



////Test ID: 03-22
///* 
//* Verify that password cannot be of more than two consecutive identical digits
//*/	
		  
//		@Test (priority = 22)
//	    public void VerifyChangePasswordwithtwoconsecutiveDigits() throws InterruptedException {
//		
//		  System.setProperty("webdriver.gecko.driver", driverPath);
//	      driver = new FirefoxDriver();
//	      driver.get(baseUrl);
//
//	      // Signing in OmniPCX 
//	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("bucket123");
//	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//		
//	      // Click On Change Password
//	      Thread.sleep(7000);
//		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink1")).click();
//		  
//		  // Change password
//		  driver.findElement(By.id("txtOldPwd")).sendKeys("bucket123");
//		  driver.findElement(By.id("txtNewPwd")).sendKeys("12345666abc");
//		  driver.findElement(By.id("txtCnfrmPwd")).sendKeys("12345666abc");
//		  
//		  // Click on Update button
//		  driver.findElement(By.id("btnUpdate")).click();                              
//		  
//		  String expectedmsg = "Password must contain alphanumeric characters, with no more than two identical consecutive characters.";
//		  String actualmsg = driver.findElement(By.id("lblMessage")).getText();
//		  
//		  Assert.assertEquals(actualmsg, expectedmsg);
//		  	  
//		  driver.close();	     	
//		  } 

		
		
////Test ID: 03-23
///* 
//* Verify that password cannot be of more than two consecutive identical special characters
//*/	
				  
	  @Test (priority = 23)
	 public void VerifyChangePasswordwithtwoconsecutiveSpecialCharacters() throws InterruptedException {
				
	    System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);

	    // Signing in OmniPCX 
	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("bucket123");
		driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
				
	    // Click On Change Password
		Thread.sleep(7000);
		driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink1")).click();
				  
		// Change password
		driver.findElement(By.id("txtOldPwd")).sendKeys("bucket123");
		driver.findElement(By.id("txtNewPwd")).sendKeys("123456abc####");
		driver.findElement(By.id("txtCnfrmPwd")).sendKeys("123456abc####");
				  
		// Click on Update button
		driver.findElement(By.id("btnUpdate")).click();                              
				  
		String expectedmsg = "Password must contain alphanumeric characters, with no more than two identical consecutive characters.";
	    String actualmsg = driver.findElement(By.id("lblMessage")).getText();
				  
		Assert.assertEquals(actualmsg, expectedmsg);
				  	  
//		driver.close();	     	
				  } 
	  
	  
	  @AfterClass
      public void tearDown() throws Exception {
  	        driver.quit();	}
		
}


