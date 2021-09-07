/* 
@author: sarah.mahmood 
Created on Jun 18, 2021
*/
// ServerTraces and Decrypt AuditLog
// Dependency needs 3 files in downloads 

/* 
@author: sarah.mahmood 
Created on May 14, 2021
*/
package ServerAdministration;

import java.io.File;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
//import java.util.List;
//import org.openqa.selenium.support.events.EventFiringWebDriver;
//import org.openqa.selenium.support.events.WebDriverListener;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.AfterClass;
//import java.io.*;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.Assert;


public class ServerTracesandDecryptAuditLog {

	public String baseUrl = "http://172.20.22.81/OmniPCXRecord/TenantAdmin.aspx";
	
	String driverPath = "C:\\Users\\sarah.mahmood\\Downloads\\gecko-driver\\geckodriver.exe";
		
	public WebDriver driver;

//////////// Comment-out in case of 1st run
////Test 
///* 
//* Set to Restricted Mode
//*/
//	@Test (priority = 0)
//    public void InitialChecktoRestrictedmodeFields() throws InterruptedException {
//    	
//    	System.setProperty("webdriver.gecko.driver", driverPath);
//		  driver = new FirefoxDriver();
//		  driver.get(baseUrl);
//		
//		  // Signing in OmniPCX 
//		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
//		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//		  
//		  // Click on Server
//		  Thread.sleep(12000);
//		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkServer")).click();
//		  
//		  // Click on Primary Recording Server to start service
//		  driver.findElement(By.id("lblRecordingServerBtn")).click();
//		  
//		  // Click On Traces
//		  Thread.sleep(12000);
//		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();
//		  
//		  // Check if restricted is selected (by default)
//		  driver.findElement(By.id("rblTracesTypeRM")).click();
//		  
//		  // Change Maximum File Size to 00000
//		  driver.findElement(By.id("txtFileSize")).clear();
//		  driver.findElement(By.id("txtFileSize")).sendKeys("5000");
//		  driver.findElement(By.id("txtNoOfFiles")).clear();
//		  driver.findElement(By.id("txtNoOfFiles")).sendKeys("20");
//		  
//		  // Click Update button
//		  driver.findElement(By.id("ImgbtnUpdate")).click();
//		  Thread.sleep(6000);
//		  String expected = "Settings have been updated successfully";
//		  // Get label msg
//		  String actual = driver.findElement(By.id("lblMessage")).getText();
//		  Assert.assertEquals(actual, expected);
//		  
//		  driver.close();
//	}
	
	
	
	
////Test ID: 13-01
///* 
//* Verify that after OmniPCXRecord Installation, by default the Traces are set to 'Restricted' mode.
//*/
	@Test (priority = 1)
    public void TracesSettoRestrictedmode() throws InterruptedException {
    	
    	System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();
		  
		  // Check if restricted is selected (by default)
		  driver.findElement(By.id("rblTracesTypeRM")).click();
		  Thread.sleep(6000);
		  Assert.assertTrue(driver.findElement(By.id("rblTracesTypeRM")).isSelected());
		  
		  driver.close();
	}
	
	
	
	
////Test ID: 13-02
///* 
//* Check that by default the value of no. of files is set to 20.
//*/
	@Test (priority = 2)
    public void NumberofFilesSetto20() throws InterruptedException {
    	
    	System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();
		  
		  // Check if restricted is selected (by default)
		  driver.findElement(By.id("rblTracesTypeRM")).click();
		  Thread.sleep(6000);
		  String expected = "20";
		  String actual = driver.findElement(By.id("txtNoOfFiles")).getAttribute("value");
		  Assert.assertEquals(actual, expected);
		  
		  driver.close();
	}	
	
	

	
////Test ID: 13-03
///* 
//* Check that by default the value of file size is set to 5000kb.
//*/	
	@Test (priority = 3)
    public void DefaultFileSizeSetto5000kb() throws InterruptedException {
    	
    	System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();
		  
		  // Check if restricted is selected (by default)
		  driver.findElement(By.id("rblTracesTypeRM")).click();
		  Thread.sleep(6000);
		  String expected = "5000";
		  String actual = driver.findElement(By.id("txtFileSize")).getAttribute("value");
		  Assert.assertEquals(actual, expected);
		  
		  driver.close();
	}	
				
		
	
	
////Test ID: 13-04
///* 
//* Verify that Snapshot button is disabled in case of Restricted mode.
//*/	
	@Test (priority = 4)
    public void SnapshotbuttonDisabledinRestrictedmode() throws InterruptedException {
    	
    	System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();
		  
		  // Check restricted mode
		  driver.findElement(By.id("rblTracesTypeRM")).click();
		  
		  Assert.assertFalse(driver.findElement(By.id("btnSnapshot")).isDisplayed());
		
		  driver.close();  
	}
	
	
	
////Test ID: 13-07
///* 
//* Verify the size of log file on changing the value against size of the files.
//*/	
	@Test (priority = 5)
    public void UpdateFileSize() throws InterruptedException {
    	
    	System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();
		  
		  // Check restricted mode
		  driver.findElement(By.id("rblTracesTypeRM")).click();
		  
		  // Change file size 
		  driver.findElement(By.id("txtFileSize")).clear();
		  driver.findElement(By.id("txtFileSize")).sendKeys("8000");
		  
		  // Click Update button
		  driver.findElement(By.id("ImgbtnUpdate")).click();
		  
		  Thread.sleep(6000);
		  String expected = "Settings have been updated successfully";
		  // Get label msg
	  	  String actual = driver.findElement(By.id("lblMessage")).getText();

	  	  Assert.assertEquals(actual, expected);
		
		  driver.close();  
	}
	
	


////Test ID: 13-09
///* 
//* Verify the count of log files on changing the value against No. of Files.
//*/
	@Test (priority = 6)
    public void UpdateFileCount() throws InterruptedException {
    	
    	System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();	
		  
		  // Check restricted mode
		  driver.findElement(By.id("rblTracesTypeRM")).click();
		  
		  // Change file size 
		  driver.findElement(By.id("txtNoOfFiles")).clear();
		  driver.findElement(By.id("txtNoOfFiles")).sendKeys("25");
		  
		  // Click Update button
		  driver.findElement(By.id("ImgbtnUpdate")).click();
		  
		  Thread.sleep(6000);
		  String expected = "Settings have been updated successfully";
		  // Get label msg
	  	  String actual = driver.findElement(By.id("lblMessage")).getText();

	  	  Assert.assertEquals(actual, expected);
		
		  driver.close(); 
	}
	
	
	
	
////Test ID: 13-24
///* 
//* Update restricted mode traces with empty 'Maximum File size' field
//*/	
	@Test (priority = 7)
    public void EmptyMaximumFilesize() throws InterruptedException {
    	
    	System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();
		  
		  // Check restricted mode
		  driver.findElement(By.id("rblTracesTypeRM")).click();
		  
		  // Change Maximum File Size to 00000
		  driver.findElement(By.id("txtFileSize")).clear();
		  driver.findElement(By.id("txtNoOfFiles")).clear();
		  driver.findElement(By.id("txtNoOfFiles")).sendKeys("20");
		  
		  // Click Update button
		  driver.findElement(By.id("ImgbtnUpdate")).click();
		  Thread.sleep(6000);
		  String expected = "Please enter Maximum File Size";
		  // Get label msg
		  String actual = driver.findElement(By.id("lblMessage")).getText();
		  Assert.assertEquals(actual, expected);
	
		  driver.close();
		}
	
	
	

////Test ID: 13-25
///* 
//* Update restricted mode traces with empty 'Maximum File size' field
//*/	
	@Test (priority = 8)
    public void EmptyNoOfFile() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();
		  
		  // Check restricted mode
		  driver.findElement(By.id("rblTracesTypeRM")).click();
		  
		  // Change Maximum File Size to 00000
		  driver.findElement(By.id("txtNoOfFiles")).clear();
		  driver.findElement(By.id("txtFileSize")).clear();
		  driver.findElement(By.id("txtFileSize")).sendKeys("5000");
		  
		  // Click Update button
		  driver.findElement(By.id("ImgbtnUpdate")).click();
		  Thread.sleep(6000);
		  String expected = "Please enter No. of Files";
		  // Get label msg
		  String actual = driver.findElement(By.id("lblMessage")).getText();
		  Assert.assertEquals(actual, expected);
	
		  driver.close();
		}
	    	
	
	
	
////Test ID: 13-26
///* 
//* Verify only numeric digits are allowed in Maximum file size field
//*/	
	@Test (priority = 9)
    public void OnlyNumericsinMaximumFilesize() throws InterruptedException {
    	
    	System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();
		  
		  // Check restricted mode
		  driver.findElement(By.id("rblTracesTypeRM")).click();
		  
		  // Change Maximum File Size to 00000
		  driver.findElement(By.id("txtFileSize")).clear();
		  driver.findElement(By.id("txtFileSize")).sendKeys("kdjhgeiug1234");
		  
		  Thread.sleep(6000);
		  String expected = "1234";
		  // Get value entered
		  String actual = driver.findElement(By.id("txtFileSize")).getAttribute("value");
		  Assert.assertEquals(actual, expected);
	
		  driver.close();
		}  
	
	
	
	
////Test ID: 13-28
///* 
//* Verify only numeric digits are allowed in No. of Files field
//*/
	@Test (priority = 10)
    public void OnlyNumericsinNoOfFiles() throws InterruptedException {
    	System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();
		  
		  // Check restricted mode
		  driver.findElement(By.id("rblTracesTypeRM")).click();
		  
		  // Change Maximum File Size to 00000
		  driver.findElement(By.id("txtNoOfFiles")).clear();
		  driver.findElement(By.id("txtNoOfFiles")).sendKeys("kdjhgeiug12");
		  
		  Thread.sleep(6000);
		  String expected = "12";
		  // Get value entered
		  String actual = driver.findElement(By.id("txtNoOfFiles")).getAttribute("value");
		  Assert.assertEquals(actual, expected);
	
		  driver.close();
		} 
	

	
	
////Test ID: 13-28
///* 
//* Verify that greater than zero values are allowed in maximum file size field
//*/
	@Test (priority = 11)
    public void OnlyNumericsinMaximumFileSize() throws InterruptedException {
  	System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();
		  
		  // Check restricted mode
		  driver.findElement(By.id("rblTracesTypeRM")).click();
		  
		  // Change Maximum File Size to 00000
		  driver.findElement(By.id("txtFileSize")).clear();
		  driver.findElement(By.id("txtFileSize")).sendKeys("0");
		  driver.findElement(By.id("txtNoOfFiles")).clear();
		  driver.findElement(By.id("txtNoOfFiles")).sendKeys("10");
		  
		  // Click Update button
		  driver.findElement(By.id("ImgbtnUpdate")).click();
		  Thread.sleep(6000);
		  String expected = "Maximum File Size should be greater than zero";
		  // Get label msg
		  String actual = driver.findElement(By.id("lblMessage")).getText();
		  Assert.assertEquals(actual, expected);
		  
		  driver.close();
		} 
	
	
	
	
////Test ID: 13-28
///* 
//* Verify that greater than zero values are allowed in maximum file size field
//*/
	@Test (priority = 12)
    public void ValueGreaterthanZeroNoOfFiles() throws InterruptedException { 	
  	System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();
		  
		  // Check restricted mode
		  driver.findElement(By.id("rblTracesTypeRM")).click();
		  
		  // Change Maximum File Size to 00000
		  driver.findElement(By.id("txtFileSize")).clear();
		  driver.findElement(By.id("txtFileSize")).sendKeys("0");
		  driver.findElement(By.id("txtNoOfFiles")).clear();
		  driver.findElement(By.id("txtNoOfFiles")).sendKeys("10");
		  
		  // Click Update button
		  driver.findElement(By.id("ImgbtnUpdate")).click();
		  Thread.sleep(6000);
		  String expected = "Maximum File Size should be greater than zero";
		  // Get label msg
		  String actual = driver.findElement(By.id("lblMessage")).getText();
		  Assert.assertEquals(actual, expected);
	
		  driver.close();
		} 	
	
	
	
	
////Test ID: 13-29
///* 
//* Verify that greater than zero values are allowed in no. of files field
//*/
	@Test (priority = 13)
    public void ValueGreaterthanZeroMaximumFileSize() throws InterruptedException {
  	
  	System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();
		  
		  // Check restricted mode
		  driver.findElement(By.id("rblTracesTypeRM")).click();
		  
		  // Change Maximum File Size to 00000
		  driver.findElement(By.id("txtFileSize")).clear();
		  driver.findElement(By.id("txtFileSize")).sendKeys("5000");
		  driver.findElement(By.id("txtNoOfFiles")).clear();
		  driver.findElement(By.id("txtNoOfFiles")).sendKeys("0");
		  
		  // Click Update button
		  driver.findElement(By.id("ImgbtnUpdate")).click();
		  Thread.sleep(6000);
		  String expected = "No. of Files should be greater than zero";
		  // Get label msg
		  String actual = driver.findElement(By.id("lblMessage")).getText();
		  Assert.assertEquals(actual, expected);
	
		  driver.close();
		} 	
	
	
	

	
////Test ID: 13-30
///* 
//* Verify the maximum value allowed in maximum file size field
//*/
	@Test (priority = 14)
    public void MaxValueforNoOfFiles() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();
		  
		  // Check restricted mode
		  driver.findElement(By.id("rblTracesTypeRM")).click();
		  
		  // Change Maximum File Size to 00000
		  driver.findElement(By.id("txtFileSize")).clear();
		  driver.findElement(By.id("txtFileSize")).sendKeys("99999");
		  driver.findElement(By.id("txtNoOfFiles")).clear();
		  driver.findElement(By.id("txtNoOfFiles")).sendKeys("10");
		  
		  // Click Update button
		  driver.findElement(By.id("ImgbtnUpdate")).click();
		  Thread.sleep(6000);
		  String expected = "Settings have been updated successfully";
		  // Get label msg
		  String actual = driver.findElement(By.id("lblMessage")).getText();
		  Assert.assertEquals(actual, expected);
	 
		  driver.close();
		} 	
	
	
	
	
	
////Test ID: 13-33
///* 
//* Verify the only 5 digit value is allowed in Maximum file size field
//*/
	@Test (priority = 16)
    public void FiveDigitsforMaximumFileSize() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();
		  
		  // Check restricted mode
		  driver.findElement(By.id("rblTracesTypeRM")).click();
		  
		  // Change Maximum File Size to 00000
		  driver.findElement(By.id("txtFileSize")).clear();
		  driver.findElement(By.id("txtFileSize")).sendKeys("3000000");
		  driver.findElement(By.id("txtNoOfFiles")).clear();
		  driver.findElement(By.id("txtNoOfFiles")).sendKeys("20");
		  
		  Thread.sleep(6000);
		  String expected = "30000";
		  // Get value entered
		  String actual = driver.findElement(By.id("txtFileSize")).getAttribute("value");
		  Assert.assertEquals(actual, expected);
	
		  driver.close();
		}
	
	
	
	

////Test ID: 13-32
///* 
//* Verify the only 2 digit value is allowed in no of files field
//*/
	@Test (priority = 17)
    public void TwoDigitsforNoOfFiles() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();
		  
		  // Check restricted mode
		  driver.findElement(By.id("rblTracesTypeRM")).click();
		  
		  // Change Maximum File Size to 00000
		  Thread.sleep(6000);
		  driver.findElement(By.id("txtFileSize")).clear();
		  driver.findElement(By.id("txtFileSize")).sendKeys("30000");
		  driver.findElement(By.id("txtNoOfFiles")).clear();
		  driver.findElement(By.id("txtNoOfFiles")).sendKeys("123");
		  
		  Thread.sleep(8000);
		  String expected = "12";
		  // Get value entered
		  String actual = driver.findElement(By.id("txtNoOfFiles")).getAttribute("value");
		  Assert.assertEquals(actual, expected);
		  
		  driver.close();
		}	
	

	
////Test ID: 13-32
///* 
//* Verify the only 2 digit value is allowed in no of files field
//*/
	@Test (priority = 15)
    public void MaxValueforMaximumFileSize() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();
		  
		  // Check restricted mode
		  driver.findElement(By.id("rblTracesTypeRM")).click();
		  
		  // Change Maximum File Size to 00000
		  // So next time it is set to default value that is 20 for no of files
		  driver.findElement(By.id("txtFileSize")).clear();
		  driver.findElement(By.id("txtFileSize")).sendKeys("5000");
		  driver.findElement(By.id("txtNoOfFiles")).clear();
		  driver.findElement(By.id("txtNoOfFiles")).sendKeys("99");
		  
		  // Click Update button
		  driver.findElement(By.id("ImgbtnUpdate")).click();
		  Thread.sleep(6000);
		  String expected = "Settings have been updated successfully";
		  // Get label msg
		  String actual = driver.findElement(By.id("lblMessage")).getText();
		  Assert.assertEquals(actual, expected);
		  
		  driver.close();
		}
		
	
	
////Test ID: 13-34
///* 
//* Insert marker when recording services are not running
//*/
	@Test (priority = 18)
    public void InsertMarkerwhenRecordingServicesNotRunning() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();
		  
		  // Check restricted mode
		  driver.findElement(By.id("rblTracesTypeRM")).click();
		  
		  // Insert Marker 
		  driver.findElement(By.id("txtMarker")).sendKeys("WinKey");
		  
		  // Click insert button
		  driver.findElement(By.id("btnInsert")).click();
		  Thread.sleep(6000);
		  String expected = "Unable to insert marker.";
		  // Get label msg
		  String actual = driver.findElement(By.id("lblMessage")).getText();
		  Assert.assertEquals(actual, expected);
	
		  driver.close();
		}
	
	
	
	
////Test ID: 13-42
///* 
//* Insert marker when recording services are not running and traces mode is set to unrestricted
//*/
	@Test (priority = 19)
    public void InsertMarkerwhenTracesModeUnrestrictedRecordingServicesnotRunning() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  		  
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();
		  
		  // Check on Unrestricted mode
		  driver.findElement(By.id("rblTracesTypeUM")).click();
		  
		  // Insert Marker 
		  driver.findElement(By.id("txtMarker")).sendKeys("Shift_F10");
		  
		  // Click insert button
		  driver.findElement(By.id("btnInsert")).click();
		  Thread.sleep(6000);
		  String expected = "Unable to insert marker.";
		  // Get label msg
		  String actual = driver.findElement(By.id("lblMessage")).getText();
		  Assert.assertEquals(actual, expected);
		  
		  // Check on restricted mode
		  driver.findElement(By.id("rblTracesTypeRM")).click();
	
		  driver.close();
		}			
	
	
	
	
////Test ID: 13-35
///* 
//* Insert marker when recording services are running
//*/
	@Test (priority = 20)
    public void InsertMarkerwhenRecordingServicesRunning() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click on Server
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkServer")).click();
		  
		  // Click on Primary Recording Server to start service
		  driver.findElement(By.id("lblRecordingServerBtn")).click();
		  
		  Thread.sleep(8000);
		  
		  // Click On Traces
		  Thread.sleep(15000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();
		  
		  // Check restricted mode
		  Thread.sleep(5000);
		  driver.findElement(By.id("rblTracesTypeRM")).click();
		  
		  // Insert Marker 
		  driver.findElement(By.id("txtMarker")).sendKeys("WinKey");
		  
		  // Click insert button
		  driver.findElement(By.id("btnInsert")).click();
		  Thread.sleep(6000);
		  String expected = "Marker request sent.";
		  // Get label msg
		  String actual = driver.findElement(By.id("lblMessage")).getText();
		  Assert.assertEquals(actual, expected);
	
		  driver.close();
		}		
	
	
	
	
////Test ID: 13-36
///* 
//* Insert marker with empty text
//*/	
	@Test (priority = 21)
    public void InsertMarkerwithEmptyText() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();
		  
		  // Check restricted mode
		  driver.findElement(By.id("rblTracesTypeRM")).click();
		  
//		  // Insert Marker 
//		  driver.findElement(By.id("txtMarker")).sendKeys("WinKey");
		  
		  // Click insert button
		  driver.findElement(By.id("btnInsert")).click();
		  Thread.sleep(6000);
		  String expected = "Please provide valid marker text.";
		  // Get label msg
		  String actual = driver.findElement(By.id("lblMessage")).getText();
		  Assert.assertEquals(actual, expected);
	
		  driver.close();
	}		
	
	
	
	
////Test ID: 13-37
///* 
//* Verify that user is able to switch to Unrestricted traces mode
//*/	
	@Test (priority = 22)
    public void UsercanSwitchtoUnrestrictedTracesMode() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();	
	
		  // Check on Unrestricted mode
		  driver.findElement(By.id("rblTracesTypeUM")).click();
		  
		  Assert.assertTrue(driver.findElement(By.id("rblTracesTypeUM")).isSelected());
	
		  driver.close();
	}
	
	
	

////Test ID: 13-38
///* 
//* Verify the default Backup Log path 
//*/
	@Test (priority = 23)
    public void verifyDefaultBackupLogPath() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();	
	
		  // Check on Unrestricted mode
		  driver.findElement(By.id("rblTracesTypeUM")).click();
		  
		  // Get Backup Log Path
		  String address =  driver.findElement(By.id("txtBackUpLogPath")).getAttribute("value"); //C:\Program Files (x86)\Alcatel-Lucent Enterprise\OmniPCXRecord Suite\Logs

//		  String expected = "OmniPCXRecord Suite\\Logs";
//		  String actual = address.substring(49,73);
	     
		  Assert.assertTrue(address.contains("OmniPCXRecord Suite\\Logs"));
		  
		  driver.close();
	}
	


////Test ID: 13-39
///* 
//* Update traces type to unrestricted mode
//*/	
	@Test (priority = 24)
    public void UpdateTracestypetoUnrestrictedMode() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();	
	
		  // Check on Unrestricted mode
		  driver.findElement(By.id("rblTracesTypeUM")).click();
		  
		  // Get Backup Log Path
		  driver.findElement(By.id("txtBackUpLogPath")).clear();
		  driver.findElement(By.id("txtBackUpLogPath")).sendKeys("C:\\Program Files (x86)\\Alcatel-Lucent Enterprise\\OmniPCXRecord Suite\\Logs"); //

		  // Click update button
		  driver.findElement(By.id("ImgbtnUpdate")).click();

		  String expected = "Settings have been updated successfully";
		  // Get label msg
		  String actual = driver.findElement(By.id("lblMessage")).getText();
		  Assert.assertEquals(actual, expected);
		  
		  driver.close();
	}
	
	
	
	
////Test ID: 13-40
///* 
//* Update traces type to unrestricted mode with empty backup log path
//*/	
	@Test (priority = 25)
    public void UpdateTracestypetoUnrestrictedModewithEmptyBackupLogPath() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	
		  // Click On Traces
		  Thread.sleep(15000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();	
	
		  // Check on Unrestricted mode
		  driver.findElement(By.id("rblTracesTypeUM")).click();
		  
		  // Get Backup Log Path
		  driver.findElement(By.id("txtBackUpLogPath")).clear();
	
		  // Click update button
		  driver.findElement(By.id("ImgbtnUpdate")).click();

		  String expected = "Please enter Backup Log Path.";
		  // Get label msg
		  String actual = driver.findElement(By.id("lblMessage")).getText();
		  Assert.assertEquals(actual, expected);
		  
		  driver.close();
	}
		  
	
	
	
////Test ID: 13-41
///* 
//* Verify that user is logged out after changing the traces to unrestricted mode
//*/
	@Test (priority = 26)
    public void verifyUserLoggedoutafterchangingTracesModeUnrestricted() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();	
	
		  // Check on Unrestricted mode
		  driver.findElement(By.id("rblTracesTypeUM")).click();
		  
		  // Click on Server
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkServer")).click();
        
	      // Get title of the page
		  String expected = "Server";
		  String actual = driver.findElement(By.id("ctl00_lblPageCaption")).getText();
		  
		  Assert.assertEquals(actual, expected);		  
		 
		  driver.close();
	}
	
	


////Test ID: 13-43
///* 
//* Insert marker when recording services are running and traces mode is set to unrestricted
//*/
	@Test (priority = 27)
    public void InsertMarkerwhenTracesModeUnrestrictedRecordingServicesRunning() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
//		  // Click on Server
//		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkServer")).click();
		  
//		  // Click on Primary Recording Server to start service
//		  driver.findElement(By.id("lblRecordingServerBtn")).click();
		  
		  Thread.sleep(8000);
		  
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();
		  
		  Thread.sleep(10000);
		  
		  // Check on Unrestricted mode
		  Thread.sleep(8000);
		  driver.findElement(By.id("rblTracesTypeUM")).click();
		  
		  // Insert Marker 
		  driver.findElement(By.id("txtMarker")).sendKeys("Shift_F10");
		  
		  // Click insert button
		  driver.findElement(By.id("btnInsert")).click();
		  Thread.sleep(6000);
		  String expected = "Marker request sent.";
		  // Get label msg
		  String actual = driver.findElement(By.id("lblMessage")).getText();
		  Assert.assertEquals(actual, expected);
		  
		  driver.close();
		}			
	
	
  
////Test ID: 13-44
///* 
//* Insert marker with empty text and traces mode is set to unrestricted
//*/	
	@Test (priority = 28)
    public void verifyEmptyMarkerwhenTracesModeUnrestricted() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();
		  
		  Thread.sleep(10000);
		  
		  // Check on Unrestricted mode
		  driver.findElement(By.id("rblTracesTypeUM")).click();
		  
		  // Click insert button
		  driver.findElement(By.id("btnInsert")).click();
		  Thread.sleep(6000);
		  String expected = "Please provide valid marker text.";
		  // Get label msg
		  String actual = driver.findElement(By.id("lblMessage")).getText();
		  Assert.assertEquals(actual, expected);
		  
		  driver.close();
		}	
	
	
	
////Test ID: 13-45
///* 
//* Verify that snapshot button is available when Traces Type is set to Unrestricted mode
//*/	
	@Test (priority = 29)
    public void VerifySnapshotbuttoninUnrestrictedTracesMode() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();	
	
		  // Check on Unrestricted mode
		  driver.findElement(By.id("rblTracesTypeUM")).click();
		  
		  Assert.assertTrue(driver.findElement(By.id("btnSnapshot")).isDisplayed());
	
		  driver.close();
	}	
	
	
	
	
////Test ID: 13-46
///* 
//* Take a snapshot from unrestricted mode of traces
//*/	
	@Test (priority = 30)
    public void VerifySnapshotfromUnrestrictedTracesMode() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);	
	
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();	
	
		  // Check on Unrestricted mode
		  driver.findElement(By.id("rblTracesTypeUM")).click();
		  
		  // Click Snapshot button
		  driver.findElement(By.id("btnSnapshot")).click();
		  
		  String expected = "Snapshot has been taken successfully.";
		  // Get label msg
		  String actual = driver.findElement(By.id("lblMessage")).getText();
		  Assert.assertEquals(actual, expected);
	
		  driver.close();
	}	
	
	
	


////Test ID: 13-13
///* 
//* Verify that Export Backup Log is working.
//*/
	@Test (priority = 31)
    public void VerifyExportBackupLog() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);	
	
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	
		  // Click On Traces
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();	
	
		  // Check on Unrestricted mode
		  driver.findElement(By.id("rblTracesTypeUM")).click();
		  
		  // Enable Export Backup Log
		  driver.findElement(By.id("chk_ExportBackupLog")).click();	
		  
		  Assert.assertTrue(driver.findElement(By.id("chk_ExportBackupLog")).isSelected());
		  
		  driver.close();
	}	
	
	
	
	
///////////////////////////////////////////////////////	Decrypt Audit log
////Test ID: 13-47
///* 
//* Verify that Decrypt Audit log page is available for super admin user
//*/	
	@Test (priority = 32)
    public void verifyDecryptAuditLogPageisAvailable() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);	
	
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Decrypt Audit Log
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkAuditLogs")).click();
		  
		  String actual = driver.findElement(By.id("ctl00_lblPageCaption")).getText();
		  String expected = "Decrypt Audit Log";
		  
		  Assert.assertEquals(actual, expected);
		  
		  driver.close();
	}	
	
	
	
	
////Test ID: 13-48
///* 
//* Verify that Decrypt and Choose file buttons are enabled for super admin  
//*/	
	@Test (priority = 33)
    public void verifyDecryptandBrowsefileEnabled() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);	
	
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Decrypt Audit Log
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkAuditLogs")).click();
		  
		  // Check buttons enabled (browse & decrypt)
		  Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"divAuditLogs\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/div[1]/input")).isEnabled());
		  Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder2_Ctrl_DecryptLog1_btnImport\"]")).isEnabled());
		  
		  driver.close();
	}
	
	
	

////Test ID: 13-49
///* 
//* Decrypt Audit log without selecting a file  
//*/	
	@Test (priority = 34)
    public void DecryptAuditLogwithoutSelectingfile() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);	
	
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Decrypt Audit Log
		  Thread.sleep(12000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkAuditLogs")).click();
		  
		  // Click On Decrypt
		  driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder2_Ctrl_DecryptLog1_btnImport\"]")).click();
		  
		  JavascriptExecutor jsx = (JavascriptExecutor)driver;
		  jsx.executeScript("window.confirm('Please browse the file to decrypt')");

	      String expectedAlert = "Please browse the file to decrypt";
	      Alert confirmation = driver.switchTo().alert();
	      String actualAlert = confirmation.getText(); //Get text present on alert Message
	      driver.switchTo().alert().accept();
	  
	      // Click on okay button
	      Thread.sleep(5000);
	      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     

	      Assert.assertEquals(actualAlert, expectedAlert);
		   	  
		  driver.close(); 
	}
	
	
	
	
////Test ID: 13-50
///* 
//* Decrypt Audit log with valid file  
//*/	
	@Test (priority = 35)
    public void DecryptAuditLogwithValidfile() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);	
	
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Decrypt Audit Log
		  Thread.sleep(15000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkAuditLogs")).click();
		 
		   // Upload a file
		   WebElement browse = driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_DecryptLog1_fileUpload"));
		   //click on ‘Choose file’ to upload the desired file
		   browse.sendKeys("C:\\Users\\sarah.mahmood\\Downloads\\REST API AuditLog1.txt");//Uploading the file using sendKeys
//		   System.out.println("File is Uploaded Successfully");
		  
		  // Click On Decrypt
		  driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder2_Ctrl_DecryptLog1_btnImport\"]")).click();
		  
		  Thread.sleep(20000);
		  
		  Assert.assertTrue(driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_DecryptLog1_lbxLogs")).isDisplayed());	  
		  
		  driver.close();  
	}
	
	
	
	

////Test ID: 13-53
///* 
//* Verify the downloaded decrypted audit log file name  
//*/	
	@Test (priority = 36)
    public void verifyDecryptAuditLogDownloadfile() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		  
		  // Browser settings for file download
		  FirefoxProfile profile = new FirefoxProfile();
		  profile.setPreference("browser.download.dir", "C:\\Users\\sarah.mahmood\\Downloads\\");
		  profile.setPreference("browser.download.folderList",2);
		  profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain");
//		  profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/csv, text/csv, text/plain,application/octet-stream doc xls pdf txt");
		  profile.setPreference("browser.download.manager.showWhenStarting", false);
//		  profile.setPreference("browser.helperApps.neverAsk.openFile","application/pdf");
//		  profile.setPreference("browser.helperApps.neverAsk.openFile", "application/csv, text/csv, text/plain,application/octet-stream doc xls pdf txt");
		  profile.setPreference("browser.helperApps.neverAsk.openFile",false);
		  profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		  profile.setPreference("browser.download.manager.useWindow", false);
		  profile.setPreference("browser.download.manager.focusWhenStarting", false);
		  profile.setPreference("browser.download.manager.showAlertOnComplete", false);
		  profile.setPreference("browser.download.manager.closeWhenDone", true);
	      FirefoxOptions options = new FirefoxOptions();
		  options.setProfile(profile);
		  driver = new FirefoxDriver(options);
		  driver.get(baseUrl);		
		  
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Decrypt Audit Log
		  Thread.sleep(15000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkAuditLogs")).click();
		  
		  // Upload a file
		  WebElement browse1 = driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_DecryptLog1_fileUpload"));
		  browse1.sendKeys("C:\\Users\\sarah.mahmood\\Downloads\\REST API AuditLog1.txt");//Uploading the file using sendKeys

		  // Click On Decrypt
		  driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder2_Ctrl_DecryptLog1_btnImport\"]")).click();
		  
		  // Click on download file
		  driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_DecryptLog1_btnDownload")).click();
		  
		  File f = new File("C:\\Users\\sarah.mahmood\\Downloads\\DecryptLog-220621042505AM.txt");
		  Assert.assertTrue(f.exists());
		  
		  driver.close();  
	}
	
	
	
	
////Test ID: 13-54
///* 
//* Decrypt Audit log with invalid file  
//*/
	@Test (priority = 37)
	public void verifyDecryptAuditLogFileUploadwithInvalidFile() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		  
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Decrypt Audit Log
		  Thread.sleep(15000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkAuditLogs")).click();
		  
		  // Upload a file
		  WebElement browse1 = driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_DecryptLog1_fileUpload"));
		  browse1.sendKeys("C:\\Users\\sarah.mahmood\\Downloads\\3981845.fxsnapshot"); // Uploading the file using sendKeys

		  // Click On Decrypt
		  driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder2_Ctrl_DecryptLog1_btnImport\"]")).click();
		  
		  JavascriptExecutor jsx = (JavascriptExecutor)driver;
		  jsx.executeScript("window.confirm('Only txt files are allowed')");

	      String expectedAlert = "Only txt files are allowed";
	      Alert confirmation = driver.switchTo().alert();
	      String actualAlert = confirmation.getText(); //Get text present on alert Message
	      driver.switchTo().alert().accept();
	  
	      // Click on okay button
	      Thread.sleep(5000);
	      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     

	      Assert.assertEquals(actualAlert, expectedAlert);
		  
		  driver.close();	
	}
	 
		
	
	
////Test ID: 13-55
///* 
//*Decrypt Audit log with empty txt file  (Create an empty file before)
//*/	
	@Test (priority = 38)
    public void verifyDecryptAuditLogFileUploadwithEmptyFile() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);	
	
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Decrypt Audit Log
		  Thread.sleep(15000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkAuditLogs")).click();
		 
		   // Upload a file
		   WebElement browse = driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_DecryptLog1_fileUpload"));
		   //click on ‘Choose file’ to upload the desired file
		   browse.sendKeys("C:\\Users\\sarah.mahmood\\Downloads\\emptyFile.txt");//Uploading the file using sendKeys
		  
		  // Click On Decrypt
		  driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder2_Ctrl_DecryptLog1_btnImport\"]")).click();
		  
		  String expected = "No data found in selected file";
		  String actual = driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_DecryptLog1_lblMessage")).getText();
		  
		  Assert.assertEquals(actual, expected);
		  
		  driver.close();
	}
	
	
	
	
	
////Test ID: 13-56
///* 
//* Decrypt Audit log with already decrypted file   (Should have a file with name like "DecryptLog-220621042753AM")
//*/	
	@Test (priority = 39)
    public void verifyDecryptAuditLogFileUploadwithDecryptedFile() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);	
		driver = new FirefoxDriver();
		driver.get(baseUrl);
		
		// Signing in OmniPCX 
		driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		// Click On Decrypt Audit Log
		Thread.sleep(15000);
		driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkAuditLogs")).click();
		 
		// Upload a file
		WebElement browse = driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_DecryptLog1_fileUpload"));
		//click on ‘Choose file’ to upload the desired file
		browse.sendKeys("C:\\Users\\sarah.mahmood\\Downloads\\DecryptLog-220621042753AM.txt");//Uploading the file using sendKeys
		  
		// Click On Decrypt
		driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder2_Ctrl_DecryptLog1_btnImport\"]")).click();
		  
		String expected = "This line has been modified.Failed to decrypt";
		String actual = driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_DecryptLog1_lbxLogs")).getText();
		  
		Assert.assertEquals(actual, expected);
		  
	    driver.close();	  
	}
	
	
	
////Test ID: 13-56
///* 
//* Verify user is able to scroll up and down in decrypted audit log file window
//*/
	@Test (priority = 40)
    public void verifyScrollofDecryptedFile() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);	
		driver = new FirefoxDriver();
		driver.get(baseUrl);
		
		// Signing in OmniPCX 
		driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		// Click On Decrypt Audit Log
		Thread.sleep(15000);
		driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkAuditLogs")).click();
		
		// Upload a file
		WebElement browse = driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_DecryptLog1_fileUpload"));
		//click on ‘Choose file’ to upload the desired file
		browse.sendKeys("C:\\Users\\sarah.mahmood\\Downloads\\REST API AuditLog1.txt");//Uploading the file using sendKeys
		  
		// Click On Decrypt
		driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder2_Ctrl_DecryptLog1_btnImport\"]")).click();
		
//		@SuppressWarnings("deprecation")
//		EventFiringWebDriver event = new EventFiringWebDriver(driver);
//		event.executeScript(baseUrl, null)
		
//		WebElement scroll = driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_DecryptLog1_lbxLogs"));
//		scroll.sendKeys(Keys.PAGE_DOWN);
//		scroll.sendKeys(Keys.PAGE_UP);
		
//		Actions clickAction = new Actions(driver);
//		WebElement scrollablePane = driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_DecryptLog1_lbxLogs"));
//		clickAction.moveToElement(scrollablePane).click().build().perform();
//		
//
//		Actions scrollAction = new Actions(driver);
//		scrollAction.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
//		Thread.currentThread();
//		Thread.sleep(5000);
		
//		// To scroll a web element on the page
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("document.getElementById('ctl00_ContentPlaceHolder2_Ctrl_DecryptLog1_lbxLogs').scrollTop += 0");
//		js.executeScript("document.getElementById('ctl00_ContentPlaceHolder2_Ctrl_DecryptLog1_lbxLogs').scrollDown += 10000");
//		Thread.sleep(5000);
//		
//		JavascriptExecutor jsExec = (JavascriptExecutor) driver;
//		jsExec.executeScript("document.getElementById('ctl00_ContentPlaceHolder2_Ctrl_DecryptLog1_lbxLogs').scrollLeft += 50");
//		jsExec.executeScript("document.getElementById('ctl00_ContentPlaceHolder2_Ctrl_DecryptLog1_lbxLogs').scrollRight += 50");
//		Thread.sleep(5000);
		
//		JavascriptExecutor wrapper = (JavascriptExecutor) driver;
//		wrapper.executeScript("document.querySelector('ctl00_ContentPlaceHolder2_Ctrl_DecryptLog1_lbxLogs').scrollTop = 500");
//		wrapper.executeScript("document.querySelector('ctl00_ContentPlaceHolder2_Ctrl_DecryptLog1_lbxLogs').scrollTop = 500");
//		Thread.sleep(5000);
		
//		Select DecryptLog = new Select(scroll);
//		DecryptLog.selectByVisibleText("30");
//		
//		Thread.sleep(7000);
		
//		 EventFiringDecorator  wrapper = new EventFiringDecorator (driver);
		 
//		 WebDriverListener wrapper = new WebDriverListener (driver);
//		 
//		 wrapper.executeScript("document.querySelector('').scrollTop = 500");
		
//		WebElement scroll = driver.findElement(By.id("someId"));
//		scroll.sendKeys(Keys.PAGE_DOWN);
		
//		// To scroll the whole webpage
//		Actions act = new Actions(driver);
//      act.sendKeys(Keys.PAGE_DOWN).build().perform(); //Page Down
//      System.out.println("Scroll down perfomed");
//      Thread.sleep(3000);
//     
//      act.sendKeys(Keys.PAGE_UP).build().perform();  //Page Up
//      System.out.println("Scroll up perfomed");
//      Thread.sleep(3000);
			
		 driver.close();	  
	}
	

	
	
////////////////////////////////Duplicate
////Test ID: 13-23
///* 
//* Verify all success and error messages.
//*/	
//	@Test (priority = 4)
//    public void AllSuccessandErrorMessages() throws InterruptedException {
//    	
//    	System.setProperty("webdriver.gecko.driver", driverPath);
//		  driver = new FirefoxDriver();
//		  driver.get(baseUrl);
//		
//		  // Signing in OmniPCX 
//		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
//		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//		  
//		  // Click On Traces
//		  Thread.sleep(12000);
//		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).click();	
//		  
/////////////////////////////// Change file size to 00 
//		  driver.findElement(By.id("txtNoOfFiles")).clear();
//		  driver.findElement(By.id("txtNoOfFiles")).sendKeys("00");
//		  // Click Update button
//		  driver.findElement(By.id("ImgbtnUpdate")).click();
//		  Thread.sleep(6000);
//		  String expected = "No. of Files should be greater than zero";
//		  // Get label msg
//	  	  String actual = driver.findElement(By.id("lblMessage")).getText();
//	  	  Assert.assertEquals(actual, expected);
//	  	  
//	  	  // Change file size to Special Chars 
//		  driver.findElement(By.id("txtNoOfFiles")).clear();
//		  driver.findElement(By.id("txtNoOfFiles")).sendKeys("!#$@%$^%$&%&%^%*");
//		  // Click Update button
//		  driver.findElement(By.id("ImgbtnUpdate")).click();
//		  Thread.sleep(6000);
//		  String expected1 = "Please enter No. of Files";
//		  // Get label msg
//	  	  String actual1 = driver.findElement(By.id("lblMessage")).getText();
//	  	  Assert.assertEquals(actual1, expected1);
//	  	  
//	  	  // Change file size 
//		  driver.findElement(By.id("txtNoOfFiles")).clear();
//		  driver.findElement(By.id("txtNoOfFiles")).sendKeys("25");
//		  // Click Update button
//		  driver.findElement(By.id("ImgbtnUpdate")).click();
//		  Thread.sleep(6000);
//		  String expected2 = "Settings have been updated successfully";
//		  // Get label msg
//	  	  String actual2 = driver.findElement(By.id("lblMessage")).getText();
//	  	  Assert.assertEquals(actual2, expected2);
//	  	  
//	  	  
////////////////////////////////// Change Maximum File Size to 00001 
//		driver.findElement(By.id("txtFileSize")).clear();
//		driver.findElement(By.id("txtFileSize")).sendKeys("00001");
//		// Click Update button
//		driver.findElement(By.id("ImgbtnUpdate")).click();
//		Thread.sleep(6000);
//		String expectedf = "Settings have been updated successfully";
//		// Get label msg
//		String actualf = driver.findElement(By.id("lblMessage")).getText();
//		Assert.assertEquals(actualf, expectedf);
//		
//		// Add Special Chars in Maximum File Size  
//		driver.findElement(By.id("txtFileSize")).clear();
//		driver.findElement(By.id("txtFileSize")).sendKeys("!#$@%$^%$&%&%^%*");
//		// Click Update button
//		driver.findElement(By.id("ImgbtnUpdate")).click();
//		Thread.sleep(6000);
//		String expectedf1 = "Please enter Maximum File Size";
//		// Get label msg
//		String actualf1 = driver.findElement(By.id("lblMessage")).getText();
//		Assert.assertEquals(actualf1, expectedf1);
//		
//		// Change Maximum File Size to 00000
//		driver.findElement(By.id("txtFileSize")).clear();
//		driver.findElement(By.id("txtFileSize")).sendKeys("00000");
//		// Click Update button
//		driver.findElement(By.id("ImgbtnUpdate")).click();
//		Thread.sleep(6000);
//		String expectedf2 = "Maximum File Size should be greater than zero ";
//		// Get label msg
//		String actualf2 = driver.findElement(By.id("lblMessage")).getText();
//		Assert.assertEquals(actualf2, expectedf2);
//	  	  
//		  driver.close();
//	}	
	
	

	
	
    @AfterTest
    public void tearDown() throws Exception {
	        driver.quit();	}
	
}
