/* 
@author: sarah.mahmood 
Created on July 26, 2021
*/
package ServerAdministration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ServerStorageSettings {
  
	public String baseUrl = "http://172.20.22.81/OmniPCXRecord/TenantAdmin.aspx";
	
	 String driverPath = "C:\\Users\\sarah.mahmood\\Downloads\\gecko-driver\\geckodriver.exe";
		
	 public WebDriver driver;
	 
	  
	 
	
////Test ID: 31-01
///* 
///* Verify Storage Path Configuration for Drive
//*/
		 @Test (priority = 0)	
	    public void verifyStoragePathConfigurationforDrive() throws InterruptedException {
				System.setProperty("webdriver.gecko.driver", driverPath);
			      driver = new FirefoxDriver();
			      driver.get(baseUrl);	
			
			     // Signing in OmniPCX
			      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
			      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			      
			      // Click on Storage Settings
			      Thread.sleep(10000);
			      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink2")).click();
			      
			      String expected = "C:\\ -";
			      String actual = driver.findElement(By.id("cboDrives")).getText();
			      
			      Assert.assertEquals(actual, expected);
			      driver.close();		 	  
  }
		 
		 
		 
		 
	
////Test ID: 31-02
///* 
///* Verify Storage Path Configuration for Disk Space Usage
//*/
		 @Test (priority = 1)	
		 public void verifyStoragePathConfigurationforDiskSpace() throws InterruptedException {
			 System.setProperty("webdriver.gecko.driver", driverPath);
		      driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		
		     // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Storage Settings
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink2")).click();
		      
		      String expected = driver.findElement(By.id("spnDSU")).getText();
		      String actual = driver.findElement(By.id("spnDSU")).getText();
		      
		      Assert.assertEquals(actual, expected);
		      driver.close();		 	  
}		 
		 
			 
	
		 

		 
	
////Test ID: 31-02
///* 
///* Verify Storage Path Configuration for storage path
//*/
		 @Test (priority = 2)	
		 public void verifyStoragePathConfigurationforStoragePath() throws InterruptedException {
			 System.setProperty("webdriver.gecko.driver", driverPath);
		      driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		
		     // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Storage Settings
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink2")).click(); //contains("example")
		     
		      // Get storage path
		      String sp = driver.findElement(By.id("txtStoragePath")).getAttribute("value");
		      
		      System.out.println(sp);
		      
		      Assert.assertTrue(sp.contains("C:\\Program Files (x86)\\Alcatel-Lucent Enterprise\\OmniPCXRecord Suite\\"));
//		      driver.close();		 	  
}		 
				 

		 
		 

////Test ID: 31-07
///* 
///* Empty field validation 
//*/
		 @Test (priority = 3)	
		 public void EmptyfieldValidationforStoragePath() throws InterruptedException {
			 System.setProperty("webdriver.gecko.driver", driverPath);
		      driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		
		     // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Storage Settings
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink2")).click(); //contains("example")
		     
		      // Clear storage path
		      driver.findElement(By.id("txtStoragePath")).clear();
		      driver.findElement(By.id("txtPStoragePath")).clear();
		      
		      // Click update button
		      driver.findElement(By.id("btnUpdate")).click();
		      
		      Thread.sleep(8000);
			  String expected = "Please enter Repository Storage Path";
			  // Get label msg
		  	  String actual = driver.findElement(By.id("lblMessage")).getText();
		  	  
		  	  Assert.assertEquals(actual, expected);
		      driver.close();		 	  
}	
		 
		 

		 

		 
////Test ID: 31-08
///* 
///* Update Storage Path
//*/
		 @Test (priority = 4)	
		 public void UpdateStoragePath() throws InterruptedException {
			 System.setProperty("webdriver.gecko.driver", driverPath);
		      driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		
		     // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Storage Settings
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink2")).click(); //contains("example")
		     
		      // Clear storage path
		      driver.findElement(By.id("txtStoragePath")).clear();
		      driver.findElement(By.id("txtStoragePath")).sendKeys("C:\\Temp");
		      
		      driver.findElement(By.id("txtPStoragePath")).clear();
		      driver.findElement(By.id("txtPStoragePath")).sendKeys("C:\\Temp");
		      
		      // Click update button
		      driver.findElement(By.id("btnUpdate")).click();
		      
		      Thread.sleep(8000);
			  String expected = "Settings have been updated successfully.";
			  // Get label msg
		  	  String actual = driver.findElement(By.id("lblMessage")).getText();
		  	  
		  	  Assert.assertEquals(actual, expected);
		      driver.close();		 	  
}			 
		 
		 
	
		 

		 
////Test ID: 31-11
///* 
///* Verify functionality of Archiving Configuration with valid archiving path
///*/
		 @Test (priority = 5)	
		 public void verifyArchivingConfigwithValidpath() throws InterruptedException {
			 System.setProperty("webdriver.gecko.driver", driverPath);
		      driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		
		     // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Storage Settings
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink2")).click(); //contains("example")
		     
		      // Clear archive path & enter some value
		      driver.findElement(By.id("txtArchivePath")).clear();
		      driver.findElement(By.id("txtArchivePath")).sendKeys("C:\\Temp");
		      
		      // Click update button
		      driver.findElement(By.id("btnUpdate")).click();
		      
		      Thread.sleep(8000);
			  String expected = "Settings have been updated successfully.";
			  // Get label msg
		  	  String actual = driver.findElement(By.id("lblMessage")).getText();
		  	  
		  	  Assert.assertEquals(actual, expected);
		      driver.close();		 	  
}			 		 		 
						 
		 

		 
		 

		 
////Test ID: 31-15
///* 
///* Verify functionality of Archiving Configuration with valid archiving path and Enable mode Master
///*/
		 @Test (priority = 6)	
		 public void verifyArchivingConfigwithValidpathEnablemodeMaster() throws InterruptedException {
			 System.setProperty("webdriver.gecko.driver", driverPath);
		      driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		
		     // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Storage Settings
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink2")).click(); //contains("example")
		     
//		      // Clear archive path & enter some value
//		      driver.findElement(By.id("txtArchivePath")).clear();
//		      driver.findElement(By.id("txtArchivePath")).sendKeys("C:\\Temp");
		      
		      boolean mode = driver.findElement(By.id("cbIsMasterSlaveMode")).isSelected();
		      
		      if (mode == false) {
		      driver.findElement(By.id("cbIsMasterSlaveMode")).click();  }
		      
		      // Select Node
			  Thread.sleep(5000);
			  Select dropdownModeM = new Select(driver.findElement(By.id("ddlMasterSlaveMode")));
		   	  dropdownModeM.selectByVisibleText("Master"); 

		      // Click update button
		      driver.findElement(By.id("btnUpdate")).click();
		      
		      Thread.sleep(8000);
			  String expected = "Settings have been updated successfully.";
			  // Get label msg
		  	  String actual = driver.findElement(By.id("lblMessage")).getText();
		  	  
		  	  Assert.assertEquals(actual, expected);
		      driver.close();		 	  
}		 
				 
		 
		 


		
////Test ID: 31-15
///* 
///* Verify functionality of Archiving Configuration with valid archiving path and Enable mode Master
///*/
		 @Test (priority = 7)	
		 public void verifyArchivingConfigwithValidpathEnablemodeSlave() throws InterruptedException {
			 System.setProperty("webdriver.gecko.driver", driverPath);
		      driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		
		     // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Storage Settings
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink2")).click(); //contains("example")
		     
//		      // Clear archive path & enter some value
//		      driver.findElement(By.id("txtArchivePath")).clear();
//		      driver.findElement(By.id("txtArchivePath")).sendKeys("C:\\Temp");
		      
		      boolean mode = driver.findElement(By.id("cbIsMasterSlaveMode")).isSelected();
		      
		      if (mode == false) {
		      driver.findElement(By.id("cbIsMasterSlaveMode")).click();  }
		      
		      // Select Node
			  Thread.sleep(5000);
			  Select dropdownModeS = new Select(driver.findElement(By.id("ddlMasterSlaveMode")));
		   	  dropdownModeS.selectByVisibleText("Slave"); 

		      // Click update button
		      driver.findElement(By.id("btnUpdate")).click();
		      
		      Thread.sleep(8000);
			  String expected = "Settings have been updated successfully.";
			  // Get label msg
		  	  String actual = driver.findElement(By.id("lblMessage")).getText();
		  	  
		  	  Assert.assertEquals(actual, expected);
		      driver.close();		 	  
				 
		}		 
		 
		 
		 
		 
		 
		 
////Test ID: 31-12
///* 
///* Verify functionality of Archiving Configuration with invalid archiving path
///*/
		 @Test (priority = 8)	
		 public void verifyArchivingConfigwithInvalidpath() throws InterruptedException {
			 System.setProperty("webdriver.gecko.driver", driverPath);
		      driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		
		     // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Storage Settings
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink2")).click(); //contains("example")
		     
		      // Clear archive path & enter some value
		      driver.findElement(By.id("txtArchivePath")).clear();
		      driver.findElement(By.id("txtArchivePath")).sendKeys("yehribbeoiy,nbzviyooi");
		      
		      // Click update button
		      driver.findElement(By.id("btnUpdate")).click();
		      
		      Thread.sleep(8000);
			  String expected = "Archive Path directory location not found.";
			  // Get label msg
		  	  String actual = driver.findElement(By.id("lblMessage")).getText();
		  	  
		  	  Assert.assertEquals(actual, expected);
		      driver.close();		 	  
}			 		 
				
				 
		  
		 
				
    @AfterTest
    public void ChangeStoragePathtoDefault() throws InterruptedException {
    	System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		  
		  // Signing in OmniPCX
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		     
		  // Click on Storage Settings
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink2")).click(); //contains("example")
	      
	      // enter correct storage path
	      driver.findElement(By.id("txtStoragePath")).clear();
	      driver.findElement(By.id("txtStoragePath")).sendKeys("C:\\Program Files (x86)\\Alcatel-Lucent Enterprise\\OmniPCXRecord Suite\\OmniPCXRecord");
	      driver.findElement(By.id("txtPStoragePath")).clear();
	      driver.findElement(By.id("txtPStoragePath")).sendKeys("C:\\Program Files (x86)\\Alcatel-Lucent Enterprise\\OmniPCXRecord Suite\\OmniPCXRecord");
	     
	      // Clear archive path & enter some value
	      driver.findElement(By.id("txtArchivePath")).clear();
	      
	      boolean mode = driver.findElement(By.id("cbIsMasterSlaveMode")).isSelected();
	      
	      if (mode == true) {
	      driver.findElement(By.id("cbIsMasterSlaveMode")).click();  }
	      
	      // Click update button
	      driver.findElement(By.id("btnUpdate")).click();
	      
	      Thread.sleep(9000);
	      String expected = "Settings have been updated successfully.";
		  // Get label msg
	  	  String actual = driver.findElement(By.id("lblMessage")).getText();
	  	  
	  	  Assert.assertEquals(actual, expected);
	      
	      driver.close();		
	      }
    
    	
			
			  
			  
		 

}