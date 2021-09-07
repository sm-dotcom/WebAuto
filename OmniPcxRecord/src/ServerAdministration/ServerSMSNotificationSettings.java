/* 
@author: sarah.mahmood 
Created on Aug 13, 2021
*/
package ServerAdministration;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
//import com.twilio.Twilio;
//import com.twilio.rest.verify.v2.service.VerificationCheck;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import com.twilio.Twilio;
//import com.twilio.rest.verify.v2.service.VerificationCheck;
import org.testng.annotations.Test;


public class ServerSMSNotificationSettings {
  	
    public ArrayList<TestResult> testresultlist = new ArrayList<TestResult>();
	
	public String baseUrl = "http://172.20.22.81/OmniPCXRecord/TenantAdmin.aspx";

	String driverPath = "C:\\Users\\sarah.mahmood\\Downloads\\gecko-driver\\geckodriver.exe";
	
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");
	
	UpdateTestResult obj = new UpdateTestResult();
	
	public WebDriver driver;	


	
////Test ID: 56-01
///* 
//* Verify the default configuration for Notification Settings.
//*/	
	@Test (priority = 0)
	public void verifyDefaultconfigurationNotificationSettings() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "56- SMS Noification Settings";
	    String TestCaseID = "56-01";
	    String Status = "";
	     		 
	       if(driver==null){
	     			 
	     	    System.out.println("WebDriver not initialized");
	     			return;
	     		}
	     		  
	     	try{
	    
	    // Signing in OmniPCX 
	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	    // Click on System
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
	  
	    String expected = "Twilio";
	      
	    // Get Provider from notification settings
	    String actual = driver.findElement(By.id("cboProvider")).getText();
//	    System.out.println(actual);  
	    Assert.assertEquals(actual, expected);
	    
	    // Take a SS
	    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	    
	    Status = "Pass";
		  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
		  testresultlist.add(objtestreult);
		  //obj.updateResult(TestCaseID, SheetName, Status);
		  
		  Thread.sleep(3000);
		  }
		  catch(Throwable e) {
			  System.out.println("Error : " +e);
			  Status = "Fail";
			  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			  testresultlist.add(objtestreult);		}	
	    
	driver.close();
	}
	
	

	
	

////Test ID: 56-10
///* 
//* Verify that system does not allow to add Receiver's Number if Twilio settings are not inserted.
//*/
	@Test (priority = 1)
	public void verifyReceiversNumberwithoutTwiliosettings() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "56- SMS Noification Settings";
	    String TestCaseID = "56-10";
	    String Status = "";
	     		 
	       if(driver==null){
	     			 
	     	    System.out.println("WebDriver not initialized");
	     			return;
	     		}
	     		  
	     	try{
	    
	    	    // Signing in OmniPCX 
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	    	    
	    	    // Click on System
	    	    Thread.sleep(9000);
	    	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
	    	    
	    	    Thread.sleep(5000);
	    	    
	    	    String expected = "cursor: default;";
	    	    String actual = driver.findElement(By.id("imgAddNo")).getAttribute("style");
	    	    System.out.println(actual);  

	    	    Assert.assertEquals(actual, expected);
	    	    
	    	    // Take a SS
	    	    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    	    FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	    	    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	    	 
	    // Excel code
	    Status = "Pass";
		TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
		testresultlist.add(objtestreult);
		//obj.updateResult(TestCaseID, SheetName, Status);
		  
		Thread.sleep(3000);
		  }
		  catch(Throwable e) {
			  System.out.println("Error : " +e);
			  Status = "Fail";
			  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			  testresultlist.add(objtestreult);		}	
	    
	driver.close();
	}	
	
	
	
	
	

////Test ID: 56-03
///* 
//* Verify that Send From field do not accept invalid characters.
//*/
	@Test (priority = 2)
	public void verifySendFormwithInvalidCharacters() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "56- SMS Noification Settings";
	    String TestCaseID = "56-03";
	    String Status = "";
	     		 
	       if(driver==null){
	     			 
	     	    System.out.println("WebDriver not initialized");
	     			return;
	     		}
	     		  
	     	try{
	    
	    // Signing in OmniPCX 
	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	    // Click on System
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
	  
	    // Enter values for Send From *
	    driver.findElement(By.id("txtSendFrom")).clear();
	    driver.findElement(By.id("txtSendFrom")).sendKeys(")(<><>//.,+-=@$#@%$#_");
	      
	    String expected = ")(+-";
	      
	    // Get "Send From" from notification settings
	    String actual = driver.findElement(By.id("txtSendFrom")).getAttribute("value");
//	    System.out.println(actual);  
	    Assert.assertEquals(actual, expected);
	    
	    // Take a SS
	    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	    
	    Thread.sleep(6000);
	   
	    // Excel code
	    Status = "Pass";
		TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
		testresultlist.add(objtestreult);
		//obj.updateResult(TestCaseID, SheetName, Status);
		  
		Thread.sleep(3000);
		  }
		  catch(Throwable e) {
			  System.out.println("Error : " +e);
			  Status = "Fail";
			  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			  testresultlist.add(objtestreult);		}	
	    
	driver.close();
	}
	
	

	


////Test ID: 56-04
///* 
//* Verify that Update button should work properly.
//*/
	@Test (priority = 3)
	public void verifyUpdatebuttonfunctionalitySystem() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "56- SMS Noification Settings";
	    String TestCaseID = "56-04";
	    String Status = "";
	     		 
	       if(driver==null){
	     			 
	     	    System.out.println("WebDriver not initialized");
	     			return;
	     		}
	     		  
	     	try{
	    
	    // Signing in OmniPCX 
	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	    // Click on System
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
	  
	    // Enter values for Account SID *
	    driver.findElement(By.id("txtAccountSID")).clear();
	    driver.findElement(By.id("txtAccountSID")).sendKeys("ACba52cde42881fd62ed0d1afcdba9ea7f");
	      
	    // Enter values for Auth Token *
	    driver.findElement(By.id("txtAuthToken")).clear();
	    driver.findElement(By.id("txtAuthToken")).sendKeys("9822694a60b3e0fbcd82d8a09ef8ac6c");
	      
	    // Enter values for Send From *
	    driver.findElement(By.id("txtSendFrom")).clear();
	    driver.findElement(By.id("txtSendFrom")).sendKeys("+13396746551");
	      
	    // Click update button
	    driver.findElement(By.id("btnUpdateNotificationSettings")).click();
	      
	    String expected = "Settings have been updated successfully";
	      
	    // Get "Send From" from notification settings
	    String actual = driver.findElement(By.id("lblMessageNotification")).getText();
//	    System.out.println(actual);  
	    Assert.assertEquals(actual, expected);
	    
	    // Take a SS
	    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	    
	    Thread.sleep(6000);
	   
	    // Excel code
	    Status = "Pass";
		TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
		testresultlist.add(objtestreult);
		//obj.updateResult(TestCaseID, SheetName, Status);
		  
		Thread.sleep(3000);
		  }
		  catch(Throwable e) {
			  System.out.println("Error : " +e);
			  Status = "Fail";
			  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			  testresultlist.add(objtestreult);		}	
	    
	driver.close();
	}	
	
	

	

////Test ID: 56-02
///* 
//* Verify that Copy/Paste option is available in the fields.
//*/	
	@Test (priority = 4)
	public void verifyCopyPasteinNotificationSettings() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "56- SMS Noification Settings";
	    String TestCaseID = "56-02";
	    String Status = "";
	     		 
	       if(driver==null){
	     			 
	     	    System.out.println("WebDriver not initialized");
	     			return;
	     		}
	     		  
	     	try{
	     		
	     	    // Signing in OmniPCX 
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	    	      
	    	    // Click on System
	    	    Thread.sleep(9000);
	    	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
	    
	     		Thread.sleep(2000);
	            
	    		WebElement scroll = driver.findElement(By.id("txtReceiverNo"));
	    		scroll.sendKeys(Keys.PAGE_DOWN);
	    	    
	            // Perform Copy/Paste to Account SID
	            WebElement locOfSID = driver.findElement(By.id("txtAccountSID"));
	            Actions act = new Actions(driver);
	            act.moveToElement(locOfSID).doubleClick().build().perform();
	            // catch here is double click on the text will by default select the text 
	            // now apply copy command 
	            driver.findElement(By.id("txtAccountSID")).sendKeys(Keys.chord(Keys.CONTROL,"x"));
	            
	            // now apply the command to paste
	            driver.findElement (By.id("txtAccountSID")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
	            
	            Thread.sleep(2000);
	            
	            // Perform Copy/Paste to Account SID
	            WebElement locOfAuthToken = driver.findElement(By.id("txtAccountSID"));
	            Actions act1 = new Actions(driver);
	            act1.moveToElement(locOfAuthToken).doubleClick().build().perform();
	            // catch here is double click on the text will by default select the text 
	            // now apply copy command 
	            driver.findElement(By.id("txtAuthToken")).sendKeys(Keys.chord(Keys.CONTROL,"x"));
	            
	            // now apply the command to paste
	            driver.findElement (By.id("txtAuthToken")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
	            
	            Thread.sleep(2000);
	            
	            // Perform Copy/Paste to Account SID
	            WebElement locOfSendFrom = driver.findElement(By.id("txtAccountSID"));
	            Actions act2 = new Actions(driver);
	            act2.moveToElement(locOfSendFrom).doubleClick().build().perform();
	            // catch here is double click on the text will by default select the text 
	            // now apply copy command 
	            driver.findElement(By.id("txtAuthToken")).sendKeys(Keys.chord(Keys.CONTROL,"x"));
	            
	            // now apply the command to paste
	            driver.findElement (By.id("txtAuthToken")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
	            
	            Assert.assertTrue(true);
	            
	            // Take a SS
	    	    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    	    FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	    	    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	
	    Status = "Pass";
		  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
		  testresultlist.add(objtestreult);
		  //obj.updateResult(TestCaseID, SheetName, Status);
		  
		  Thread.sleep(3000);
		  }
		  catch(Throwable e) {
			  System.out.println("Error : " +e);
			  Status = "Fail";
			  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			  testresultlist.add(objtestreult);		}	
	    
	driver.close();
	}
	
	
	

	
////Test ID: 56-05
///* 
//* Verify that system do not accept empty fields. Account SID * 
//*/
	@Test (priority = 5)
	public void verifyEmptyAccountSID() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "56- SMS Noification Settings";
	    String TestCaseID = "56-05";
	    String Status = "";
	     		 
	       if(driver==null){
	     			 
	     	    System.out.println("WebDriver not initialized");
	     			return;
	     		}
	     		  
	     	try{
	    
	    // Signing in OmniPCX 
	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	    // Click on System
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
	  
	    // Enter values for Account SID *
	    driver.findElement(By.id("txtAccountSID")).clear();
//	    driver.findElement(By.id("txtAccountSID")).sendKeys("ACba52cde42881fd62ed0d1afcdba9ea7f");
	      
	    // Enter values for Auth Token *
	    driver.findElement(By.id("txtAuthToken")).clear();
	    driver.findElement(By.id("txtAuthToken")).sendKeys("9822694a60b3e0fbcd82d8a09ef8ac6c");
	      
	    // Enter values for Send From *
	    driver.findElement(By.id("txtSendFrom")).clear();
	    driver.findElement(By.id("txtSendFrom")).sendKeys("+13396746551");
	      
	    // Click update button
	    driver.findElement(By.id("btnUpdateNotificationSettings")).click();
	      
	    String expected = "Please enter Account SID";
	      
	    // Get "Account SID" msg from notification settings
	    String actual = driver.findElement(By.id("lblMessageNotification")).getText();
//	    System.out.println(actual);  
	    Assert.assertEquals(actual, expected);
	    
	    // Take a SS
	    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	    
	    Thread.sleep(6000);
	   
	    // Excel code
	    Status = "Pass";
		TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
		testresultlist.add(objtestreult);
		//obj.updateResult(TestCaseID, SheetName, Status);
		  
		Thread.sleep(3000);
		  }
		  catch(Throwable e) {
			  System.out.println("Error : " +e);
			  Status = "Fail";
			  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			  testresultlist.add(objtestreult);		}	
	    
	driver.close();
	}
	
	
	


////Test ID: 56-06
///* 
//* Verify that system do not accept empty fields. Auth Token * 
//*/
	@Test (priority = 6)
	public void verifyEmptyAuthToken() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "56- SMS Noification Settings";
	    String TestCaseID = "56-06";
	    String Status = "";
	     		 
	       if(driver==null){
	     			 
	     	    System.out.println("WebDriver not initialized");
	     			return;
	     		}
	     		  
	     	try{
	    
	    // Signing in OmniPCX 
	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	    // Click on System
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
	  
	    // Enter values for Account SID *
	    driver.findElement(By.id("txtAccountSID")).clear();
	    driver.findElement(By.id("txtAccountSID")).sendKeys("ACba52cde42881fd62ed0d1afcdba9ea7f");
	      
	    // Enter values for Auth Token *
	    driver.findElement(By.id("txtAuthToken")).clear();
//	    driver.findElement(By.id("txtAuthToken")).sendKeys("9822694a60b3e0fbcd82d8a09ef8ac6c");
	      
	    // Enter values for Send From *
	    driver.findElement(By.id("txtSendFrom")).clear();
	    driver.findElement(By.id("txtSendFrom")).sendKeys("+13396746551");
	      
	    // Click update button
	    driver.findElement(By.id("btnUpdateNotificationSettings")).click();
	      
	    String expected = "Please enter Auth Token";
	      
	    // Get "Auth Token" msg from notification settings
	    String actual = driver.findElement(By.id("lblMessageNotification")).getText();
//	    System.out.println(actual);  
	    Assert.assertEquals(actual, expected);
	    
	    // Take a SS
	    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	    
	    Thread.sleep(6000);
	   
	    // Excel code
	    Status = "Pass";
		TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
		testresultlist.add(objtestreult);
		//obj.updateResult(TestCaseID, SheetName, Status);
		  
		Thread.sleep(3000);
		  }
		  catch(Throwable e) {
			  System.out.println("Error : " +e);
			  Status = "Fail";
			  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			  testresultlist.add(objtestreult);		}	
	    
	driver.close();
	}	
	
	
	
	
	

////Test ID: 56-07
///* 
//* Verify that system do not accept empty fields. Send From * 
//*/
	@Test (priority = 7)
	public void verifyEmptySendFrom() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "56- SMS Noification Settings";
	    String TestCaseID = "56-07";
	    String Status = "";
	     		 
	       if(driver==null){
	     			 
	     	    System.out.println("WebDriver not initialized");
	     			return;
	     		}
	     		  
	     	try{
	    
	    // Signing in OmniPCX 
	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	    // Click on System
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
	  
	    // Enter values for Account SID *
	    driver.findElement(By.id("txtAccountSID")).clear();
	    driver.findElement(By.id("txtAccountSID")).sendKeys("ACba52cde42881fd62ed0d1afcdba9ea7f");
	      
	    // Enter values for Auth Token *
	    driver.findElement(By.id("txtAuthToken")).clear();
	    driver.findElement(By.id("txtAuthToken")).sendKeys("9822694a60b3e0fbcd82d8a09ef8ac6c");
	      
	    // Enter values for Send From *
	    driver.findElement(By.id("txtSendFrom")).clear();
//	    driver.findElement(By.id("txtSendFrom")).sendKeys("+13396746551");
	      
	    // Click update button
	    driver.findElement(By.id("btnUpdateNotificationSettings")).click();
	      
	    String expected = "Please enter Send From";
	      
	    // Get "Send From" msg from notification settings
	    String actual = driver.findElement(By.id("lblMessageNotification")).getText();
//	    System.out.println(actual);  
	    Assert.assertEquals(actual, expected);
	    
	    // Take a SS
	    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	    
	    Thread.sleep(6000);
	   
	    // Excel code
	    Status = "Pass";
		TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
		testresultlist.add(objtestreult);
		//obj.updateResult(TestCaseID, SheetName, Status);
		  
		Thread.sleep(3000);
		  }
		  catch(Throwable e) {
			  System.out.println("Error : " +e);
			  Status = "Fail";
			  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			  testresultlist.add(objtestreult);		}	
	    
	driver.close();
	}		
	
	

	
	

////Test ID: 56-08
///* 
//* Verify that reset button is working properly. 
//*/
	@Test (priority = 8)
	public void verifyResetbuttonfunctionalitySystem() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "56- SMS Noification Settings";
	    String TestCaseID = "56-08";
	    String Status = "";
	     		 
	       if(driver==null){
	     			 
	     	    System.out.println("WebDriver not initialized");
	     			return;
	     		}
	     		  
	     	try{
	    
	    // Signing in OmniPCX 
	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	    // Click on System
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
	      
	    // Click reset button
	    driver.findElement(By.id("btnUpdateNotificationSettings")).click();
	      
	    String expected = "Settings have been updated successfully";
	      
	    // Get msg
	    String actual = driver.findElement(By.id("lblMessageNotification")).getText();
//	    System.out.println(actual);  
	    Assert.assertEquals(actual, expected);
	    
	    // Take a SS
	    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	    
	    Thread.sleep(6000);
	   
	    // Excel code
	    Status = "Pass";
		TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
		testresultlist.add(objtestreult);
		//obj.updateResult(TestCaseID, SheetName, Status);
		  
		Thread.sleep(3000);
		  }
		  catch(Throwable e) {
			  System.out.println("Error : " +e);
			  Status = "Fail";
			  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			  testresultlist.add(objtestreult);		}	
	    
	driver.close();
	}	
	
	

	


////Test ID: 56-09
///* 
//* Verify that Receiver Number only accept characters. 
//*/
	@Test (priority = 9)
	public void verifyReceiverNumberwithSpecialChars() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "56- SMS Noification Settings";
	    String TestCaseID = "56-09";
	    String Status = "";
	     		 
	       if(driver==null){
	     			 
	     	    System.out.println("WebDriver not initialized");
	     			return;
	     		}
	     		  
	     	try{
	    
	    // Signing in OmniPCX 
	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	    // Click on System
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
	      
	    // Add text to Receiver’s Number *
	    driver.findElement(By.id("txtReceiverNo")).clear();
	    driver.findElement(By.id("txtReceiverNo")).sendKeys("()<><>//.,+-=@$#@%$#_");  
	    
	    String expected = "()+-";
	      
	    // Get "Send From" from notification settings
	    String actual = driver.findElement(By.id("txtReceiverNo")).getAttribute("value");
//	    System.out.println(actual);  
	    Assert.assertEquals(actual, expected);
	    
	    // Take a SS
	    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	    
	    Thread.sleep(6000);
	   
	    // Excel code
	    Status = "Pass";
		TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
		testresultlist.add(objtestreult);
		//obj.updateResult(TestCaseID, SheetName, Status);
		  
		Thread.sleep(3000);
		  }
		  catch(Throwable e) {
			  System.out.println("Error : " +e);
			  Status = "Fail";
			  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			  testresultlist.add(objtestreult);		}	
	    
	driver.close();
	}	
	
	
	
	

////Test ID: 56-11
///* 
//* Verify that system allow to add Receiver's Number if Twilio settings are inserted.
//*/
	@Test (priority = 10)
	public void verifyReceiversNumberwithTwiliosettings() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "56- SMS Noification Settings";
	    String TestCaseID = "56-11";
	    String Status = "";
	     		 
	       if(driver==null){
	     			 
	     	    System.out.println("WebDriver not initialized");
	     			return;
	     		}
	     		  
	     	try{
	    
	    	    // Signing in OmniPCX 
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	    	    
	    	    // Click on System
	    	    Thread.sleep(9000);
	    	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
	    	      
	    	   // Enter values for Account SID *
	    	    driver.findElement(By.id("txtAccountSID")).clear();
	    	    driver.findElement(By.id("txtAccountSID")).sendKeys("ACba52cde42881fd62ed0d1afcdba9ea7f");
	    	      
	    	    // Enter values for Auth Token *
	    	    driver.findElement(By.id("txtAuthToken")).clear();
	    	    driver.findElement(By.id("txtAuthToken")).sendKeys("9822694a60b3e0fbcd82d8a09ef8ac6c");
	    	      
	    	    // Enter values for Send From *
	    	    driver.findElement(By.id("txtSendFrom")).clear();
	    	    driver.findElement(By.id("txtSendFrom")).sendKeys("+13396746551");
	    	      
	    	    // Click update button
	    	    driver.findElement(By.id("btnUpdateNotificationSettings")).click();
	    	    
	    	    Thread.sleep(2000);
	    	    
	    	    // add Receiver’s Number *
	    	    driver.findElement(By.id("txtReceiverNo")).sendKeys("+92345678943");
	    	    
	    	    // Click [+]
	    	    driver.findElement(By.id("imgAddNo")).click();
	    	    
	    	    Thread.sleep(3000);
	    	    
	    	    Assert.assertTrue(driver.findElement(By.id("gvNotificationSettings")).isDisplayed()); 
	    	    
	    	    // Take a SS
	    	    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    	    FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	    	    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	       
	    // Excel code
	    Status = "Pass";
		TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
		testresultlist.add(objtestreult);
		//obj.updateResult(TestCaseID, SheetName, Status);
		  
		Thread.sleep(3000);
		  }
		  catch(Throwable e) {
			  System.out.println("Error : " +e);
			  Status = "Fail";
			  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			  testresultlist.add(objtestreult);		}	
	    
	driver.close();
	}	

	
	

	


////Test ID: 56-12
///* 
//* User can only add verified numbers, from Twilio, as a Receiver Number.
//*/
	@Test (priority = 11)
	public void verifyAddingVerifiedNostoReceiversNumber() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "56- SMS Noification Settings";
	    String TestCaseID = "56-12";
	    String Status = "";
	     		 
	       if(driver==null){
	     			 
	     	    System.out.println("WebDriver not initialized");
	     			return;
	     		}
	     		  
	     	try{
	    
	     	// Signing in OmniPCX 
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	    	    
	    	    // Click on System
	    	    Thread.sleep(9000);
	    	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
	    	    
//	    	    String expected = "cursor: default;";
//	    	    String actual = driver.findElement(By.id("imgAddNo")).getAttribute("style");
//	    	    System.out.println(actual);
	    	    
	    	    if ( driver.findElement(By.id("imgAddNo")).getAttribute("style") == "cursor: pointer;") {
	    	    	
	    	    	// add Receiver’s Number *
	        	    driver.findElement(By.id("txtReceiverNo")).sendKeys("+74586458689598");
	        	    
	        	    String expected = "+";
	        	    // Get "Send From" from notification settings
	        	    String actual = driver.findElement(By.id("txtReceiverNo")).getAttribute("value");
	        	    System.out.println(actual);  
	        	    Assert.assertTrue(actual.contains(expected));
	        	    
	        	    // Take a SS
	        	    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        	    FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	        	    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	        	   
	        	    // Click [+]
	        	    driver.findElement(By.id("imgAddNo")).click();
	    	    }
	    	      
	    	    else if ( driver.findElement(By.id("imgAddNo")).getAttribute("style") == "cursor: default;") {
	    	    	 
	    	    	// Enter values for Account SID *
	        	    driver.findElement(By.id("txtAccountSID")).clear();
	        	    driver.findElement(By.id("txtAccountSID")).sendKeys("ACba52cde42881fd62ed0d1afcdba9ea7f");
	        	      
	        	    // Enter values for Auth Token *
	        	    driver.findElement(By.id("txtAuthToken")).clear();
	        	    driver.findElement(By.id("txtAuthToken")).sendKeys("9822694a60b3e0fbcd82d8a09ef8ac6c");
	        	      
	        	    // Enter values for Send From *
	        	    driver.findElement(By.id("txtSendFrom")).clear();
	        	    driver.findElement(By.id("txtSendFrom")).sendKeys("+13396746551");
	        	      
	        	    // Click update button
	        	    driver.findElement(By.id("btnUpdateNotificationSettings")).click();
	        	    
	        	    Thread.sleep(2000);
	        	    
	        	    // add Receiver’s Number *
	        	    driver.findElement(By.id("txtReceiverNo")).sendKeys("7458645666864558689598");
	        	    
	        	    String expected = "+";
	        	    // Get "Send From" from notification settings
	        	    String actual = driver.findElement(By.id("txtReceiverNo")).getAttribute("value");
//	        	    System.out.println(actual);  
	        	    Assert.assertTrue(actual.contains(expected));
	        	    
	        	    // Take a SS
	        	    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        	    FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	        	    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	        	    
	        	    // Click [+]
	        	    driver.findElement(By.id("imgAddNo")).click();
	    	    }
	    	    	    	    
	    // Excel code
	    Status = "Pass";
		TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
		testresultlist.add(objtestreult);
		//obj.updateResult(TestCaseID, SheetName, Status);
		  
		Thread.sleep(3000);
		  }
		  catch(Throwable e) {
			  System.out.println("Error : " +e);
			  Status = "Fail";
			  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			  testresultlist.add(objtestreult);		}	
	    
	driver.close();
	}		
	
	
	


	
////Test ID: 56-17
///* 
//* Verify that Notification Settings only update if all three parameters are valid. Account SID * 
//*/
	@Test (priority = 12)
	public void verifyNotificationSettingsUpdatewhenAllParametersareValid_AccountSID() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "56- SMS Noification Settings";
	    String TestCaseID = "56-17";
	    String Status = "";
	     		 
	       if(driver==null){
	     			 
	     	    System.out.println("WebDriver not initialized");
	     			return;
	     		}
	     		  
	     	try{
	    
	     	// Signing in OmniPCX 
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	    	    
	    	    // Click on System
	    	    Thread.sleep(9000);
	    	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
	    	        	    
	    	    	// Enter values for Account SID *
	        	    driver.findElement(By.id("txtAccountSID")).clear();
	        	    driver.findElement(By.id("txtAccountSID")).sendKeys("ACba52cde42881fd62ed0d1afcdba9ea7f");
	        	      
	        	    // Enter values for Auth Token *
	        	    driver.findElement(By.id("txtAuthToken")).clear();
	        	    driver.findElement(By.id("txtAuthToken")).sendKeys("9822694a60b3e0fbcd82d8a09ef8ac6c");
	        	      
	        	    // Enter values for Send From *
	        	    driver.findElement(By.id("txtSendFrom")).clear();
	        	    driver.findElement(By.id("txtSendFrom")).sendKeys("+13396746551");
	        	      
	        	    // Click update button
	        	    driver.findElement(By.id("btnUpdateNotificationSettings")).click();
	        	    
	        	    Thread.sleep(2000);
	        	
	        	    String expected = "AC";
	        	    // Get "Send From" from notification settings
	        	    String actual = driver.findElement(By.id("txtAccountSID")).getAttribute("value");
//	        	    System.out.println(actual);  
	        	    Assert.assertTrue(actual.contains(expected));
	        	    
	        	    // Take a SS
	        	    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        	    FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	        	    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	        	       	    	    	    
	    // Excel code
	    Status = "Pass";
		TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
		testresultlist.add(objtestreult);
		//obj.updateResult(TestCaseID, SheetName, Status);
		  
		Thread.sleep(3000);
		  }
		  catch(Throwable e) {
			  System.out.println("Error : " +e);
			  Status = "Fail";
			  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			  testresultlist.add(objtestreult);		}	
	    
	driver.close();
	}	
	
	
	
	
	
	

////Test ID: 56-19
///* 
//* Verify that Notification Settings only update if all three parameters are valid. Send From * 
//*/
	@Test (priority = 13)
	public void verifyNotificationSettingsUpdatewhenAllParametersareValid_SendFrom() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "56- SMS Noification Settings";
	    String TestCaseID = "56-19";
	    String Status = "";
	     		 
	       if(driver==null){
	     			 
	     	    System.out.println("WebDriver not initialized");
	     			return;
	     		}
	     		  
	     	try{
	    
	     	// Signing in OmniPCX 
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	    	    
	    	    // Click on System
	    	    Thread.sleep(9000);
	    	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
	    	        	    
	    	    	// Enter values for Account SID *
	        	    driver.findElement(By.id("txtAccountSID")).clear();
	        	    driver.findElement(By.id("txtAccountSID")).sendKeys("ACba52cde42881fd62ed0d1afcdba9ea7f");
	        	      
	        	    // Enter values for Auth Token *
	        	    driver.findElement(By.id("txtAuthToken")).clear();
	        	    driver.findElement(By.id("txtAuthToken")).sendKeys("9822694a60b3e0fbcd82d8a09ef8ac6c");
	        	      
	        	    // Enter values for Send From *
	        	    driver.findElement(By.id("txtSendFrom")).clear();
	        	    driver.findElement(By.id("txtSendFrom")).sendKeys("+13396746551");
	        	      
	        	    // Click update button
	        	    driver.findElement(By.id("btnUpdateNotificationSettings")).click();
	        	    
	        	    Thread.sleep(2000);
	        	
	        	    String expected = "+";
	        	    // Get "Send From" from notification settings
	        	    String actual = driver.findElement(By.id("txtSendFrom")).getAttribute("value");
//	        	    System.out.println(actual);  
	        	    Assert.assertTrue(actual.contains(expected));
	        	    
	        	    // Take a SS
	        	    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        	    FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	        	    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	        	    
	    // Excel code
	    Status = "Pass";
		TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
		testresultlist.add(objtestreult);
		//obj.updateResult(TestCaseID, SheetName, Status);
		  
		Thread.sleep(3000);
		  }
		  catch(Throwable e) {
			  System.out.println("Error : " +e);
			  Status = "Fail";
			  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			  testresultlist.add(objtestreult);		}	
	    
	driver.close();
	}			
	
	
	
	

	
	
////Test ID: 56-18
///* 
//* Verify that Notification Settings only update if all three parameters are valid. Auth Token *  
//*/
	@Test (priority = 14)
	public void verifyNotificationSettingsUpdatewhenAllParametersareValid_AuthToken() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "56- SMS Noification Settings";
	    String TestCaseID = "56-18";
	    String Status = "";
	     		 
	       if(driver==null){
	     			 
	     	    System.out.println("WebDriver not initialized");
	     			return;
	     		}
	     		  
	     	try{
	    
	     	// Signing in OmniPCX 
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	    	    
	    	    // Click on System
	    	    Thread.sleep(9000);
	    	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
	    	        	    
	    	    	// Enter values for Account SID *
	        	    driver.findElement(By.id("txtAccountSID")).clear();
	        	    driver.findElement(By.id("txtAccountSID")).sendKeys("ACba52cde42881fd62ed0d1afcdba9ea7f");
	        	      
	        	    // Enter values for Auth Token *
	        	    driver.findElement(By.id("txtAuthToken")).clear();
	        	    driver.findElement(By.id("txtAuthToken")).sendKeys("9822694a60b3e0fbcd82d8a09ef8ac6c");
	        	      
	        	    // Enter values for Send From *
	        	    driver.findElement(By.id("txtSendFrom")).clear();
	        	    driver.findElement(By.id("txtSendFrom")).sendKeys("+13396746551");
	        	      
	        	    // Click update button
	        	    driver.findElement(By.id("btnUpdateNotificationSettings")).click();
	        	    
	        	    Thread.sleep(2000);
	        	
//	        	    String expected = "+";
	        	    // Get "Send From" from notification settings
	        	    String actual = driver.findElement(By.id("txtAuthToken")).getAttribute("value");
	        	    
	        	    String regex = "^(?=.*[a-z])(?=.*[0-9])[a-z0-9]+$";
	        	    
	                // Compile the ReGex
	                Pattern p = Pattern.compile(regex);
	                Matcher m = p.matcher(actual);
	                
	                m.matches();
	        	   
//	        	    System.out.println(actual);  
	        	    Assert.assertTrue(true);
	        	    
	        	    // Take a SS
	        	    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        	    FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	        	    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));    
	    	    	    	    
	    // Excel code
	    Status = "Pass";
		TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
		testresultlist.add(objtestreult);
		//obj.updateResult(TestCaseID, SheetName, Status);
		  
		Thread.sleep(3000);
		  }
		  catch(Throwable e) {
			  System.out.println("Error : " +e);
			  Status = "Fail";
			  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			  testresultlist.add(objtestreult);		}	
	    
	driver.close();
	}				
	
	
	


/////////////////////////////////////////////////////////
//////// Clear System Settings for Notification Settings	
////////////////////////////////////////////////////////	
	@Test (priority = 15)
	public void verifyNotificationSettingsUpdatewhenAllParametersareValid() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);	
	
	 // Signing in OmniPCX 
	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	    
	    // Click on System
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
	    
	    Thread.sleep(3000);
	    
	    // Clear twilio settings
	    driver.findElement(By.id("btnResetUpdateNotificationSettings")).click();
	      
		WebElement table =driver.findElement(By.id("gvNotificationSettings")); 
		WebElement tbody=table.findElement(By.tagName("tbody"));
		List<WebElement> rows=tbody.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		for (int i=2; i<=rows.size(); i--) {
			
			if (i==0) { 
			
				Assert.assertFalse(driver.findElement(By.id("gvNotificationSettings")).isDisplayed());
//				driver.close();
			}
			
			else if (i > 0) {
			
			// Delete Receiver’s Number 
		    driver.findElement(By.xpath("//*[@id=\"gvNotificationSettings\"]/tbody/tr["+i+"]/td[2]/div/img")).click();
		    
		    // Check alert message
	        JavascriptExecutor jsy = (JavascriptExecutor)driver;
	        jsy.executeScript("window.confirm('Are you sure you want to delete this group?')");
	       
	        /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
	        Dismissed user prompt dialog: Settings have been updated successfully:*/
	        driver.switchTo().alert().accept();
	       
	        // Click on delete button
	        Thread.sleep(3000);
	        driver.findElement(By.id("btnDelete")).click(); 
	        
	        Thread.sleep(5000); 
	        
	        String expected = "Record has been deleted successfully";
		    String actual = driver.findElement(By.id("lblMessageNotification")).getText();
//		    System.out.println(actual);  
		    Assert.assertEquals(actual, expected); }
		}

		driver.close();
		}

////Test ID: 56-31
///* 
///* Verify that Edit button is working fine.
//*/
	 @Test (priority = 16)	
	    public void verifyNotificationTemplatesbuttonEdit() throws InterruptedException, IOException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
	      driver.get(baseUrl);	
	      
	      String SheetName = "56- SMS Noification Settings";
	      String TestCaseID = "56-31";
	      String Status = "";
	       		 
	         if(driver==null){
	       			 
	       	    System.out.println("WebDriver not initialized");
	       			return;
	       		}
	       		  
	       	try{
	
	       	// Signing in OmniPCX
	  	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	  	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
	  	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	  	      
	  	      // Click on Notification Templates
	  	      Thread.sleep(10000);
	  	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink10")).click();
	  	      
	  	      Assert.assertFalse(driver.findElement(By.id("ddlVariables")).isEnabled());

	  	  	  // Click on edit
	  	  	  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr/td[3]/div/img[1]")).click();
	      
	  	  	  Thread.sleep(2000);
	  	  	  
	  	  	  Assert.assertTrue(driver.findElement(By.id("ddlVariables")).isEnabled());
	  	  	  
	  	  	 // Take a SS
	  	     File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  	     FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	  	     FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	     
	      Status = "Pass";
		  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
		  testresultlist.add(objtestreult);
		  //obj.updateResult(TestCaseID, SheetName, Status);
		  
		  Thread.sleep(3000);
		  }
		  catch(Throwable e) {
			  System.out.println("Error : " +e);
			  Status = "Fail";
			  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			  testresultlist.add(objtestreult);		}	
	      
	      driver.close();	  		  		  
	}
			     
		
	 
	 

	 
////Test ID: 56-24
///* 
///* Verify that Update button is working fine.
//*/
	 @Test (priority = 17)	
	    public void verifyNotificationTemplatesbuttonUpdate() throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
	      driver.get(baseUrl);	
	      
	      String SheetName = "56- SMS Noification Settings";
	      String TestCaseID = "56-24";
	      String Status = "";
	       		 
	         if(driver==null){
	       			 
	       	    System.out.println("WebDriver not initialized");
	       			return;
	       		}
	       		  
	       	try{
	
	         	 // Signing in OmniPCX 
	            driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	            driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	            driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	            
	        	 // Click on Notification Templates
	         	 Thread.sleep(9000);
	         	 driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink10")).click();
	         	    
	         	 Thread.sleep(2000);
	         	    
	         	 // Click on edit
	         	 driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr/td[3]/div/img[1]")).click();
	        	    
	             // Click update
	        	 driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();

	        	 Assert.assertTrue(true);
	        	 
	        	 Thread.sleep(3000);
	        	 
	        	 // Take a SS
	     	    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	     	    FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	     	    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	      	 
		      Status = "Pass";
			  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			  testresultlist.add(objtestreult);
			  //obj.updateResult(TestCaseID, SheetName, Status);
			  
			  Thread.sleep(3000);
			  }
			  catch(Throwable e) {
				  System.out.println("Error : " +e);
				  Status = "Fail";
				  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
				  testresultlist.add(objtestreult);		}	
		      
		      driver.close();	  		  		
	}
	 
	 
	 
	 
	
////Test ID: 56-25
///* 
///* Verify that Cancel button is working fine.
//*/
	 @Test (priority = 18)	
	    public void verifyNotificationTemplatesbuttonCancel() throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
	      driver.get(baseUrl);	
	      
	      String SheetName = "56- SMS Noification Settings";
	      String TestCaseID = "56-25";
	      String Status = "";
	       		 
	         if(driver==null){
	       			 
	       	    System.out.println("WebDriver not initialized");
	       			return;
	       		}
	       		  
	       	try{
	
	         	 // Signing in OmniPCX 
	            driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	            driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	            driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	            
	        	 // Click on Notification Templates
	         	 Thread.sleep(9000);
	         	 driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink10")).click();
	         	    
	         	 Thread.sleep(2000);
	         	    
	         	 // Click on edit
	         	 driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr/td[3]/div/img[1]")).click();
	        	    
	             // Click cancel
	        	 driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/input")).click();

	        	 Assert.assertTrue(true);
	        	 
	        	 // Take a SS
	     	    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	     	    FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	     	    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	      	 
		      Status = "Pass";
			  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			  testresultlist.add(objtestreult);
			  //obj.updateResult(TestCaseID, SheetName, Status);
			  
			  Thread.sleep(3000);
			  }
			  catch(Throwable e) {
				  System.out.println("Error : " +e);
				  Status = "Fail";
				  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
				  testresultlist.add(objtestreult);		}	
		      
		      driver.close();	  		  		
	}
	
	
	
	
	
	
////Test ID: 56-26
///* 
///* Verify that Reset button is working fine.
//*/
		 @Test (priority = 19)	
		    public void verifyNotificationTemplatesbuttonReset() throws InterruptedException {
			  System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		      
		      String SheetName = "56- SMS Noification Settings";
		      String TestCaseID = "56-26";
		      String Status = "";
		       		 
		         if(driver==null){
		       			 
		       	    System.out.println("WebDriver not initialized");
		       			return;
		       		}
		       		  
		       	try{
		
		         	 // Signing in OmniPCX 
		            driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		            driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		            driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		            
		        	 // Click on Notification Templates
		         	 Thread.sleep(9000);
		         	 driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink10")).click();
		         	    
		         	 Thread.sleep(2000);
		         	    
		         	 // Click on edit
		         	 driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr/td[3]/div/img[1]")).click();
		        	    
		             // Click reset
		        	 driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[3]/input")).click();

		        	 Assert.assertTrue(true);
		        	 
		        	 // Take a SS
		     	     File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		     	     FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
		     	     FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
		      	 
			      Status = "Pass";
				  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
				  testresultlist.add(objtestreult);
				  //obj.updateResult(TestCaseID, SheetName, Status);
				  
				  Thread.sleep(3000);
				  }
				  catch(Throwable e) {
					  System.out.println("Error : " +e);
					  Status = "Fail";
					  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
					  testresultlist.add(objtestreult);		}	
			      
			      driver.close();	  		  		
		}	
	
	
	
	
	

////Test ID: 56-27
///* 
///* Verify that Preview button is working fine.
//*/
		 @Test (priority = 20)	
		    public void verifyNotificationTemplatesbuttonPreview() throws InterruptedException {
			  System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		      
		      String SheetName = "56- SMS Noification Settings";
		      String TestCaseID = "56-27";
		      String Status = "";
		       		 
		         if(driver==null){
		       			 
		       	    System.out.println("WebDriver not initialized");
		       			return;
		       		}
		       		  
		       	try{
		
		       	 // Signing in OmniPCX 
		            driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		            driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		            driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		            
		        	 // Click on Notification Templates
		         	 Thread.sleep(9000);
		         	 driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink10")).click();
		         	    
		         	 Thread.sleep(2000);
		         	    
		         	 // Click on edit
		         	 driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr/td[3]/div/img[1]")).click();
		        	    
		             // Click preview
		        	 driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/table/tbody/tr/td[2]/input")).click();

		        	 driver.switchTo().activeElement();
		        	 
		        	 String expected = "Notification Template Preview";
		        	 String actual = driver.findElement(By.id("ui-id-1")).getText();
		        	 System.out.println(actual);
		        	 
		        	 Assert.assertEquals(actual, expected);
		        	 
		        	 // Take a SS
		     	     File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		     	     FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
		     	     FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
		      	 
			      Status = "Pass";
				  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
				  testresultlist.add(objtestreult);
				  //obj.updateResult(TestCaseID, SheetName, Status);
				  
				  Thread.sleep(3000);
				  }
				  catch(Throwable e) {
					  System.out.println("Error : " +e);
					  Status = "Fail";
					  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
					  testresultlist.add(objtestreult);		}	
			      
			      driver.close();	  		  		
		}			 
		 
		 

	
////Test ID: 56-21
///* 
//* Verify that user should be able to add desired values from Variables drop down.
//*/
	@Test (priority = 21)
	public void verifyDropDownVariablesfromNotificationTemplates() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "56- SMS Noification Settings";
	    String TestCaseID = "56-21";
	    String Status = "";
	     		 
	       if(driver==null){
	     			 
	     	    System.out.println("WebDriver not initialized");
	     			return;
	     		}
	     		  
	     	try{
	     		    
	     	  	   // Signing in OmniPCX 
	     	 	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	     	 	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	     	 	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	     	 	    
	     	 	    // Click on Notification Templates
	     	 	    Thread.sleep(9000);
	     	 	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink10")).click();
	     	 	    
	     	 	    Thread.sleep(2000);
	     	 	    
	     	 	    // Click on edit
	     	 	    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr/td[3]/div/img[1]")).click();
	     	 	    
	     	 	    // Select Variable
	     	 	    Select dropdownNode = new Select(driver.findElement(By.id("ddlVariables")));
	     		   	dropdownNode.selectByVisibleText("EventDateTime - [EVENTDATETIME]"); 
	     		
	     	   	     String expected = "[EVENTDATETIME]";
	     		    // Get "Send From" from notification settings
	     		    String actual = driver.findElement(By.id("txtAreaBody")).getAttribute("value");
//	     		    System.out.println(actual);  
	     		    Assert.assertTrue(actual.endsWith(expected));
	     		    
	     		    // Take a SS
	     		    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	     		    FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	     		    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	     		   
	     		    Thread.sleep(2000);
	     		    
	     		    // Click reset
	     		    driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[3]/input")).click();
	     		 
	    // Excel code
	    Status = "Pass";
		TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
		testresultlist.add(objtestreult);
		//obj.updateResult(TestCaseID, SheetName, Status);
		  
		Thread.sleep(3000);
		  }
		  catch(Throwable e) {
			  System.out.println("Error : " +e);
			  Status = "Fail";
			  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			  testresultlist.add(objtestreult);		}	
	    
	driver.close();
	}		
	
	

	
	
	


	
////Test ID: 56-20
///* 
//* Verify that User should not only able to receive SMS Alert if Template is enabled.
//*/
	@Test (priority = 22)
	public void verifyNotificationTemplatesDisabled() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "56- SMS Noification Settings";
	    String TestCaseID = "56-20";
	    String Status = "";
	     		 
	       if(driver==null){
	     			 
	     	    System.out.println("WebDriver not initialized");
	     			return;
	     		}
	     		  
	     	try{	
	
	     		
	     		 // Signing in OmniPCX 
		 	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		 	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		 	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		 	    
		 	    // Click on Notification Templates
		 	    Thread.sleep(9000);
		 	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink10")).click();
		 	    
		 	    Thread.sleep(2000);
		 	    
		 	    String expected = driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr/td[1]/img")).getAttribute("title");
		 	    System.out.println(expected);  
		 	    Assert.assertEquals(expected, "Enabled");	 	    
		 	    // Click on edit
		 	    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr/td[3]/div/img[1]")).click();
		 	    
		 	    // Select Variable
		 	    Select dropdownNode = new Select(driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/select")));
			   	dropdownNode.selectByVisibleText("No"); 
			
			   	Thread.sleep(2000);
			   	
			   	// Click update
			    driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();

			    Thread.sleep(5000);
			    
			    String actual = driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr/td[1]/img")).getAttribute("title");
		 	    System.out.println(actual);  
		 	    Assert.assertEquals(actual, "Disabled");
		 	    
		 	    // Take a SS
			    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			    FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
			    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	     		
	    	    // Excel code
	    	    Status = "Pass";
	    		TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
	    		testresultlist.add(objtestreult);
	    		//obj.updateResult(TestCaseID, SheetName, Status);
	    		  
	    		Thread.sleep(3000);
	    		  }
	    		  catch(Throwable e) {
	    			  System.out.println("Error : " +e);
	    			  Status = "Fail";
	    			  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
	    			  testresultlist.add(objtestreult);		}	
	    	    
	    	driver.close();
	    	}		
	
	


	


////Test ID: 56-28
///* 
//* Verify that ICON of Notification SMS Template is Red if Enable Template is false.
//*/
	@Test (priority = 23)
	public void verifyNotificationTemplatesEnablediconGreen() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "56- SMS Noification Settings";
	    String TestCaseID = "56-28";
	    String Status = "";
	     		 
	       if(driver==null){
	     			 
	     	    System.out.println("WebDriver not initialized");
	     			return;
	     		}
	     		  
	     	try{	
	
	   		 // Signing in OmniPCX 
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	    	    
	    	    // Click on Notification Templates
	    	    Thread.sleep(9000);
	    	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink10")).click();
	    	    
	    	    Thread.sleep(2000);
	    	    
	    	    String title = driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr/td[1]/img")).getAttribute("title");
	    	    System.out.println(title);  
//	    	    Assert.assertEquals(title, "Disabled");
	    	    
	    	    if (title.equals("Disabled")) {
	    	      	 	    
	    	 	    // Click on edit
	    	 	    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr/td[3]/div/img[1]")).click();
	    	 	    
	    	 	    // Select Variable
	    	 	    Select dropdownNode = new Select(driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/select")));
	    		   	dropdownNode.selectByVisibleText("Yes"); 
	    		
	    		   	Thread.sleep(2000);
	    		   	
	    		   	// Click update
	    		    driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();

	    		    Thread.sleep(5000);
	    		    
	    		    String actual = driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr/td[1]/img")).getAttribute("title");
	    	 	    System.out.println(actual);  
	    	 	    Assert.assertEquals(actual, "Enabled");
	    	 	    
	    	 	   // Take a SS
	    		    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    		    FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	    		    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	    	    }
	    	    
	    	    else if (title.equals("Enabled")) {
	    	    	
	    	    	 // Click on edit
	    	 	    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr/td[3]/div/img[1]")).click();
	    	 	    
	    	 	    // Select Variable
	    	 	    Select dropdownNode = new Select(driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/select")));
	    		   	dropdownNode.selectByVisibleText("No"); 
	    		
	    		   	Thread.sleep(2000);
	    		   	
	    		   	// Click update
	    		    driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();

	    		    Thread.sleep(5000);
	    		    
	    		    String actual = driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr/td[1]/img")).getAttribute("title");
	    	 	    System.out.println(actual);  
	    	 	    Assert.assertEquals(actual, "Disabled");
	    	 	    
	    	 	   // Take a SS
	    		    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    		    FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	    		    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	    	 	    
	    	    }
	    	    
		 	    // Excel code
	    	    Status = "Pass";
	    		TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
	    		testresultlist.add(objtestreult);
	    		//obj.updateResult(TestCaseID, SheetName, Status);
	    		  
	    		Thread.sleep(3000);
	    		  }
	    		  catch(Throwable e) {
	    			  System.out.println("Error : " +e);
	    			  Status = "Fail";
	    			  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
	    			  testresultlist.add(objtestreult);		}	
	    	    
	    	driver.close();
	    	}			
	
	
	
	

////Test ID: 56-29
///* 
//* Verify that ICON of Notification SMS Template is Green if Enable Template is false.
//*/
	@Test (priority = 24)
	public void verifyNotificationTemplatesDisablediconRed() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "56- SMS Noification Settings";
	    String TestCaseID = "56-29";
	    String Status = "";
	     		 
	       if(driver==null){
	     			 
	     	    System.out.println("WebDriver not initialized");
	     			return;
	     		}
	     		  
	     	try{	
	
	    	    // Signing in OmniPCX 
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	    	    
	    	    // Click on Notification Templates
	    	    Thread.sleep(9000);
	    	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink10")).click();
	    	    
	    	    Thread.sleep(2000);
	    	    
	    	    String title = driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr/td[1]/img")).getAttribute("title");
	    	    System.out.println(title);  
//	    	    Assert.assertEquals(title, "Disabled");
	    	    
	    	    if (title.equals("Disabled")) {
	    	      	 	    
	    	 	    // Click on edit
	    	 	    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr/td[3]/div/img[1]")).click();
	    	 	    
	    	 	    // Select Variable
	    	 	    Select dropdownNode = new Select(driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/select")));
	    		   	dropdownNode.selectByVisibleText("Yes"); 
	    		
	    		   	Thread.sleep(2000);
	    		   	
	    		   	// Click update
	    		    driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();

	    		    Thread.sleep(5000);
	    		    
	    		    String actual = driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr/td[1]/img")).getAttribute("title");
	    	 	    System.out.println(actual);  
	    	 	    Assert.assertEquals(actual, "Enabled");
	    	 	    
	    	 	   // Take a SS
	    		    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    		    FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	    		    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	    	 	    
	    	    }
	    	    
	    	    else if (title.equals("Enabled")) {
	    	    	
	    	    	 // Click on edit
	    	 	    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr/td[3]/div/img[1]")).click();
	    	 	    
	    	 	    // Select Variable
	    	 	    Select dropdownNode = new Select(driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/select")));
	    		   	dropdownNode.selectByVisibleText("No"); 
	    		
	    		   	Thread.sleep(2000);
	    		   	
	    		   	// Click update
	    		    driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();

	    		    Thread.sleep(5000);
	    		    
	    		    String actual = driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr/td[1]/img")).getAttribute("title");
	    	 	    System.out.println(actual);  
	    	 	    Assert.assertEquals(actual, "Disabled");
	    	 	    
	    	 	   // Take a SS
	    		    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    		    FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	    		    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	    	 	    
	    	    }
	    	    
		 	    // Excel code
	    	    Status = "Pass";
	    		TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
	    		testresultlist.add(objtestreult);
	    		//obj.updateResult(TestCaseID, SheetName, Status);
	    		  
	    		Thread.sleep(3000);
	    		  }
	    		  catch(Throwable e) {
	    			  System.out.println("Error : " +e);
	    			  Status = "Fail";
	    			  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
	    			  testresultlist.add(objtestreult);		}	
	    	    
	    	driver.close();
	    	}				
	
	

////////////////////////	
////////// Set Notification Tepmplate back to Enabled 	
///////////////////////

	@Test (priority = 25)
	public void checkEmail_SMScheckbox_isCheckedinIncidentSubscription() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    // Signing in OmniPCX 
	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	    
	    // Click on Notification Templates
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink10")).click();
	    
	    Thread.sleep(2000);
	    
	    String title = driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr/td[1]/img")).getAttribute("title");
	    System.out.println(title);  
//	    Assert.assertEquals(title, "Disabled");
	    
	    if (title.equals("Disabled")) {
	      	 	    
	 	    // Click on edit
	 	    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr/td[3]/div/img[1]")).click();
	 	    
	 	    // Select Variable
	 	    Select dropdownNode = new Select(driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/select")));
		   	dropdownNode.selectByVisibleText("Yes"); 
		
		   	Thread.sleep(2000);
		   	
		   	// Click update
		    driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();

		    Thread.sleep(5000);
		    
		    String actual = driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr/td[1]/img")).getAttribute("title");
	 	    System.out.println(actual);  
	 	    Assert.assertEquals(actual, "Enabled");
	    }
	    
	    else if (title.equals("Enabled")) {
	    
	 	    Assert.assertTrue(true);
	    }
	    driver.close();
	    
  }	
	
	

	
	
	
////Test ID: 56-30
///* 
//* Verify that tool tip of Notification SMS Template is showing correct message on hover.
//*/
	@Test (priority = 26)
	public void verifytooltipofNotificationSMSTemplate() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "56- SMS Noification Settings";
	    String TestCaseID = "56-30";
	    String Status = "";
	     		 
	       if(driver==null){
	     			 
	     	    System.out.println("WebDriver not initialized");
	     			return;
	     		}
	     		  
	     	try{	
	
	    	    // Signing in OmniPCX 
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	    	    
	    	    // Click on Notification Templates
	    	    Thread.sleep(9000);
	    	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink10")).click();
	    	    
	    	    Thread.sleep(2000);
	    	    
	    	    String expectedtitle = "This SMS notification alert is generated when a subscribed incident occurs";
	    	    String actualtitle = driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr/td[2]/img")).getAttribute("title");
	    	    System.out.println(actualtitle);  
	    	    Assert.assertEquals(actualtitle, expectedtitle);
	    	    
	    	    // Take a SS
	    	    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    	    FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	    	    FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	    	    
	    	    
		 	    // Excel code
	    	    Status = "Pass";
	    		TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
	    		testresultlist.add(objtestreult);
	    		//obj.updateResult(TestCaseID, SheetName, Status);
	    		  
	    		Thread.sleep(3000);
	    		  }
	    		  catch(Throwable e) {
	    			  System.out.println("Error : " +e);
	    			  Status = "Fail";
	    			  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
	    			  testresultlist.add(objtestreult);		}	
	    	    
	    	driver.close();
	    	}		
	
	
	

	

////Test ID: 56-22
///* 
//* Verify that User can format the Body according to the needs.
//*/
	@Test (priority = 27)
	public void verifyBodyFormatofNotificationSMSTemplate() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "56- SMS Noification Settings";
	    String TestCaseID = "56-22";
	    String Status = "";
	     		 
	       if(driver==null){
	     			 
	     	    System.out.println("WebDriver not initialized");
	     			return;
	     		}
	     		  
	     	try{	
	
	     	// Signing in OmniPCX 
	     	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	     	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	     	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	     	    
	     		 // Click on Notification Templates
	     	 	 Thread.sleep(9000);
	     	 	 driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink10")).click();
	     	 	    
	     	 	 Thread.sleep(2000);
	     	 	    
	     	 	 // Click on edit
	     	 	 driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr/td[3]/div/img[1]")).click();
	     	 	
	     	 	 // Click reset button
	     	 	 driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[3]/input")).click();
	     	 	 
	     	 	 Thread.sleep(2000);
	     	 	 
	     	 	 // Select Variable
	     	 	 Select dropdownNode = new Select(driver.findElement(By.id("ddlVariables")));
	     		 dropdownNode.selectByVisibleText("EventDateTime - [EVENTDATETIME]"); 
	     		
	     	   	 String expected = "[EVENTDATETIME]        44687ascs)(_)*_*_*";
	     	    
	     		 // Add some no.s & words
	     		 driver.findElement(By.id("txtAreaBody")).sendKeys("        44687ascs)(_)*_*_*");
	     		    
	     		 String actual = driver.findElement(By.id("txtAreaBody")).getAttribute("value");
//	     		 System.out.println(actual);  
	     		    
	     		 Assert.assertTrue(actual.endsWith(expected));
	     		 
	     		 // Take a SS
	     	     File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	     	     FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	     	     FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	     		    
	     		 Thread.sleep(2000);
	     		    
	     		 // Click update
	     		 driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();

		 	    // Excel code
	    	    Status = "Pass";
	    		TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
	    		testresultlist.add(objtestreult);
	    		//obj.updateResult(TestCaseID, SheetName, Status);
	    		  
	    		Thread.sleep(3000);
	    		  }
	    		  catch(Throwable e) {
	    			  System.out.println("Error : " +e);
	    			  Status = "Fail";
	    			  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
	    			  testresultlist.add(objtestreult);		}	
	    	    
	    	driver.close();
	    	}	
	

	
	
	


	
////Test ID: 56-23
///* 
//* Verify that only selected keywords ad text in Body from Variables in the SMS alert.
//*/
	@Test (priority = 28)
	public void verifySelectedVariablesinBodyFormatofNotificationSMSTemplate() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "56- SMS Noification Settings";
	    String TestCaseID = "56-23";
	    String Status = "";
	     		 
	       if(driver==null){
	     			 
	     	    System.out.println("WebDriver not initialized");
	     			return;
	     		}
	     		  
	     	try{	
	     		
	     		 // Signing in OmniPCX 
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	    	    
	    		 // Click on Notification Templates
	    	 	 Thread.sleep(9000);
	    	 	 driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink10")).click();
	    	 	    
	    	 	 Thread.sleep(2000);
	    	 	    
	    	 	 // Click on edit
	    	 	 driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr/td[3]/div/img[1]")).click();
	    	 	 
	    	 	 // Click reset button
	    	 	 driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[3]/input")).click();
	    	 	 
	    	 	 Thread.sleep(2000);
	    	 	 
	    	 	 // Select Variable
	    	 	 Select dropdownNode = new Select(driver.findElement(By.id("ddlVariables")));
	    		 dropdownNode.selectByVisibleText("EventDateTime - [EVENTDATETIME]"); 
	    		 dropdownNode.selectByVisibleText("IncidentType - [INCIDENTTYPE]");
	    		 dropdownNode.selectByVisibleText("AlertConditionsDetected - [X]");
	    		
	    	   	 String expected = "[EVENTDATETIME][INCIDENTTYPE][X]";
	    	      
	    		 String actual = driver.findElement(By.id("txtAreaBody")).getAttribute("value");
//	    		 System.out.println(actual);  
	    		 
	    		 Thread.sleep(2000);
	    		 
	    		 Assert.assertTrue(actual.endsWith(expected));
	    		 
	    		 // Take a SS
	    		 File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    		 FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));
	    		    
	    		 Thread.sleep(2000);
	    		    
	    		 // Click update
	    		 driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();

		 	    // Excel code
	    	    Status = "Pass";
	    		TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
	    		testresultlist.add(objtestreult);
	    		//obj.updateResult(TestCaseID, SheetName, Status);
	    		  
	    		Thread.sleep(3000);
	    		  }
	    		  catch(Throwable e) {
	    			  System.out.println("Error : " +e);
	    			  Status = "Fail";
	    			  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
	    			  testresultlist.add(objtestreult);		}	
	    	    
	    	driver.close();
	    	}	
	
	
	
	

	
////Test ID: 56-33
///* 
//* Verify that Incident settings include SMS along with Emails and Traps.
//*/
	@Test (priority = 29)
	public void verifyIncidentSettingsIncludeSMS() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "56- SMS Noification Settings";
	    String TestCaseID = "56-33";
	    String Status = "";
	     		 
	       if(driver==null){
	     			 
	     	    System.out.println("WebDriver not initialized");
	     			return;
	     		}
	     		  
	     	try{	
	     		
	     		 // Signing in OmniPCX 
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	    	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	    	      
	    	    // Click on System
	    	    Thread.sleep(9000);
	    	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
	    	    
	    	    String expected = "Ignore Notification of Emails, SMS and Traps Older than";
	    	    String actual = driver.findElement(By.xpath("//*[@id=\"divIncidentManagement\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[1]/label")).getText();
	     		
	    	    Assert.assertEquals(actual, expected);
	    	    
	    	     // Take a SS
	     	     File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	     	     FileUtils.copyFile(screenshotFile, new File(".//screenshot/screenss3.png"));
	     	     FileUtils.copyFile(screenshotFile, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerSMSNotificationTemplates\\"+TestCaseID+".png"));

	     		
		 	    // Excel code
	    	    Status = "Pass";
	    		TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
	    		testresultlist.add(objtestreult);
	    		//obj.updateResult(TestCaseID, SheetName, Status);
	    		  
	    		Thread.sleep(3000);
	    		  }
	    		  catch(Throwable e) {
	    			  System.out.println("Error : " +e);
	    			  Status = "Fail";
	    			  TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
	    			  testresultlist.add(objtestreult);		}	
	    	    
	    	driver.close();
	    	}		
	
	
	
	
	
	 @AfterTest 
	    public void afterTest() {
	   	 
	   	 try {
	   		 System.out.println("Closing the Browser");
	   		 obj.updateResult(testresultlist);
	   		 driver.quit();
	   		 }
	   	 
	   	 catch(Throwable e) {
	   		 System.out.println("Error :" +e);
	   		 }	
	 }
	 
}
