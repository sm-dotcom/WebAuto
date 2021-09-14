/* 
@author: sarah.mahmood 
Created on July 28, 2021
*/
package ServerAdministration;

import org.testng.annotations.Test;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import Settings.SharedFunctions;
import Settings.TestResult;
import Settings.UpdateTestResult;

public class ServerIncidents {
	
    public ArrayList<TestResult> testresultlist = new ArrayList<TestResult>();
	
	public String baseUrl = "http://172.20.22.81/OmniPCXRecord/TenantAdmin.aspx";

	String driverPath = "C:\\Users\\sarah.mahmood\\Downloads\\gecko-driver\\geckodriver.exe";
		
	public WebDriver driver;	
	
	UpdateTestResult obj = new UpdateTestResult();

		
////Test ID: 30-01
///* 
//* To verify the functionality of field Search Incidents on OPR web. 
//*/	
	@Test (priority = 0)
	public void verifyfieldSearchIncidents() throws InterruptedException, ParseException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
		 String TestCaseID = "30-01";
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
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Enter from date
	    driver.findElement(By.id("txtFromDate")).clear();
	    driver.findElement(By.id("txtFromDate")).sendKeys("01/08/2021");
	    
	    // Click on find
	    driver.findElement(By.xpath("//*[@id=\"btnFind\"]")).click();
	    
	    if (driver.findElement(By.xpath("//*[@id=\"jqueryTable\"]/tbody/tr/td[1]/img")).isDisplayed() == true) {
	    	String expecteddate = driver.findElement(By.id("txtFromDate")).getAttribute("value");

	    	Thread.sleep(6000);
	    	// Click Date and Time on table for sorting
	    	driver.findElement(By.xpath("//*[@id=\"jqueryTable\"]/thead/tr/th[2]")).click();
	    
	    	String actualdate = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table[2]/tbody/tr[4]/td/div[2]/table/tbody/tr/td[2]/span")).getText();
	    	System.out.println(expecteddate);
	    	System.out.println(actualdate);
	    	Assert.assertTrue(actualdate.contains(expecteddate));
	    }
	   
	    else if (driver.findElement(By.xpath("//*[@id=\"jqueryTable\"]/tbody/tr/td")).isDisplayed() == true) {
	    	System.out.println("Try another date");
	    	Assert.assertFalse(true);
	    }
	    
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
	
	
	
	
	

////Test ID: 30-02
///* 
//* To verify the functionality of field Search Incidents on OPR web. To Date
//*/	
	@Test (priority = 1)
	public void verifyFutureEntryToDate() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "30-02";
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
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Add a future date to "To Date"
	    driver.findElement(By.id("txtToDate")).clear();
	    driver.findElement(By.id("txtToDate")).sendKeys("30/02/2024");
	    
	    // Click on find
	    driver.findElement(By.xpath("//*[@id=\"btnFind\"]")).click();
	    
	    // Get error msg
	    Thread.sleep(5000);
	    String Expectedmsg = "Invalid to date";
	    String Actualmsg = driver.findElement(By.id("lblMessage")).getText();

	    Assert.assertEquals(Actualmsg, Expectedmsg);
	    
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
  
  
  
  
	
////Test ID: 30-03
///* 
//* To verify the functionality of field Search Incidents on OPR web. From Date
//*/	
	@Test (priority = 2)
	public void verifyFutureEntryFromDate() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);

	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "30-03";
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
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Add a future date to "From Date"
	    driver.findElement(By.id("txtFromDate")).clear();
	    driver.findElement(By.id("txtFromDate")).sendKeys("30/02/2024");
	    
	    // Click on find
	    driver.findElement(By.xpath("//*[@id=\"btnFind\"]")).click();
	    
	    // Get error msg
	    Thread.sleep(5000);
	    String Expectedmsg = "Invalid from date";
	    String Actualmsg = driver.findElement(By.id("lblMessage")).getText();

	    Assert.assertEquals(Actualmsg, Expectedmsg);
	    
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
	
	
	
	
	
////Test ID: 30-06
///* 
//* Leave empty To Date
//*/	
	@Test (priority = 3)
	public void verifyEmptyToDate() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "30-06";
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
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Add a future date to "To Date"
	    driver.findElement(By.id("txtToDate")).clear();
//	    driver.findElement(By.id("txtToDate")).sendKeys("30/02/2024");
	    
	    // Click on find
	    driver.findElement(By.xpath("//*[@id=\"btnFind\"]")).click();
	    
	    // Get error msg
	    Thread.sleep(5000);
	    String Expectedmsg = "Enter To date";
	    String Actualmsg = driver.findElement(By.id("lblMessage")).getText();
	    
	    Assert.assertEquals(Actualmsg, Expectedmsg);
	    
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
  
  
  
  
	
////Test ID: 30-05
///* 
//* Leave empty From Date
//*/	
	@Test (priority = 4)
	public void verifyEmptyFromDate() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "30-05";
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
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Add a future date to "To Date"
	    driver.findElement(By.id("txtFromDate")).clear();
//	    driver.findElement(By.id("txtFromDate")).sendKeys("30/02/2024");
	    
	    // Click on find
	    driver.findElement(By.xpath("//*[@id=\"btnFind\"]")).click();
	    
	    // Get error msg
	    Thread.sleep(5000);
	    String Expectedmsg = "Enter from date";
	    String Actualmsg = driver.findElement(By.id("lblMessage")).getText();

	    Assert.assertEquals(Actualmsg, Expectedmsg);
	    
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

	
  
	
	

////Test ID: 30-06
///* 
//* Leave empty To Date
//*/	
	@Test (priority = 5)
	public void verifyEmptyToandFromDate() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "30-06";
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
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Add a future date to "To Date"
	    driver.findElement(By.id("txtFromDate")).clear();
	    driver.findElement(By.id("txtToDate")).clear();
//	    driver.findElement(By.id("txtFromDate")).sendKeys("30/02/2024");
	    
	    // Click on find
	    driver.findElement(By.xpath("//*[@id=\"btnFind\"]")).click();
	    
	    // Get error msg
	    Thread.sleep(5000);
	    String Expectedmsg = "Enter from date";
	    String Actualmsg = driver.findElement(By.id("lblMessage")).getText();

	    Assert.assertEquals(Actualmsg, Expectedmsg);
	    
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
  
  
	

	

////Test ID: 30-07
///* 
//* To verify the "Type" functionality of search incidents whether it searches according to selected option i.e. 'Information', 'Warning', 'Error', 'Critical Error'.
//*/	
	@Test (priority = 6)
	public void verifyTypefunctionalityAll() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "30-07";
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
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Select Type "All"
	    Select dropdown = new Select(driver.findElement(By.id("ddlIncidentType")));
	   	dropdown.selectByVisibleText("All"); 
	   	Thread.sleep(6000);	
	    
	    // Click on find
	    driver.findElement(By.xpath("//*[@id=\"btnFind\"]")).click();
	   
	    // Data is displayed in table 
	    Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"jqueryTable\"]/tbody")).isDisplayed()); 
	    
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
	
	
	
	

////Test ID: 30-08
///* 
//* To verify the "Type" functionality of search incidents whether it searches according to selected option i.e. 'Information', 'Warning', 'Error', 'Critical Error'.
//*/	
	@Test (priority = 7)
	public void verifyTypefunctionalityInformation() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "30-08";
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
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Enter from date
	    driver.findElement(By.id("txtFromDate")).clear();
	    driver.findElement(By.id("txtFromDate")).sendKeys("03/05/2021");
	    Thread.sleep(6000);	
	    
	    // Select Type "All"
	    Select dropdown = new Select(driver.findElement(By.id("ddlIncidentType")));
	   	dropdown.selectByVisibleText("Information"); 
	   	Thread.sleep(6000);	
	    
	    // Click on find
	    driver.findElement(By.xpath("//*[@id=\"btnFind\"]")).click();
	   
	    Thread.sleep(5000);
	    String Expectedmsg = "Information";
	    
	    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table[2]/tbody/tr[4]/td/div[2]/table/tbody/tr[1]/td[6]/img")).click();
	    
	    Thread.sleep(5000);
	    driver.switchTo().activeElement();

	    String Actualmsg = driver.findElement(By.xpath("//*[@id=\"tblPopUpDetails\"]/tbody/tr/td/table/tbody/tr[7]/td[2]/label")).getText();
	    
	    Assert.assertEquals(Actualmsg, Expectedmsg); 
	    
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
	
	
	
	

	
////Test ID: 30-09
///* 
//* To verify the "Type" functionality of search incidents whether it searches according to selected option i.e. 'Information', 'Warning', 'Error', 'Critical Error'.
//*/	
	@Test (priority = 8)
	public void verifyTypefunctionalityWarning() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);

	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "30-09";
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
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Enter from date
	    driver.findElement(By.id("txtFromDate")).clear();
	    driver.findElement(By.id("txtFromDate")).sendKeys("03/05/2021");
	    Thread.sleep(6000);	
	    
	    // Select Type "All"
	    Select dropdown = new Select(driver.findElement(By.id("ddlIncidentType")));
	   	dropdown.selectByVisibleText("Warning"); 
	   	Thread.sleep(6000);	
	   	
	    // Click on find
	    driver.findElement(By.xpath("//*[@id=\"btnFind\"]")).click();
	   
	    Thread.sleep(5000);
	    String Expectedmsg = "Warning";
	    
	    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table[2]/tbody/tr[4]/td/div[2]/table/tbody/tr[1]/td[6]/img")).click();
	    
	    Thread.sleep(5000);
	    driver.switchTo().activeElement();

	    String Actualmsg = driver.findElement(By.xpath("//*[@id=\"tblPopUpDetails\"]/tbody/tr/td/table/tbody/tr[7]/td[2]/label")).getText();
	    
	    Assert.assertEquals(Actualmsg, Expectedmsg); 
	   
	    driver.close();	
	    
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
  }					
	

	
	
	
	
////Test ID: 30-10
///* 
//* To verify the "Type" functionality of search incidents whether it searches according to selected option i.e. 'Information', 'Warning', 'Error', 'Critical Error'.
//*/	
	@Test (priority = 9)
	public void verifyTypefunctionalityError() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "30-10";
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
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Enter from date
	    driver.findElement(By.id("txtFromDate")).clear();
	    driver.findElement(By.id("txtFromDate")).sendKeys("03/05/2021");
	    Thread.sleep(6000);	    
	    
	    // Select Type "All"
	    Select dropdown = new Select(driver.findElement(By.id("ddlIncidentType")));
	   	dropdown.selectByVisibleText("Error"); 
	   	Thread.sleep(6000);	
	    
	    // Click on find
	    driver.findElement(By.xpath("//*[@id=\"btnFind\"]")).click();
	   
	    Thread.sleep(5000);
	    String Expectedmsg = "Error";
	    
	    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table[2]/tbody/tr[4]/td/div[2]/table/tbody/tr[1]/td[6]/img")).click();
	    
	    Thread.sleep(5000);
	    driver.switchTo().activeElement();

	    String Actualmsg = driver.findElement(By.xpath("//*[@id=\"tblPopUpDetails\"]/tbody/tr/td/table/tbody/tr[7]/td[2]/label")).getText();
	    
	    Assert.assertEquals(Actualmsg, Expectedmsg); 
	    
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
	

	
	


////Test ID: 30-11
///* 
//* To verify the "Type" functionality of search incidents whether it searches according to selected option i.e. 'Information', 'Warning', 'Error', 'Critical Error'.
//*/	
	@Test (priority = 10)
	public void verifyTypefunctionalityCritical() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "30-11";
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
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Enter from date
	    driver.findElement(By.id("txtFromDate")).clear();
	    driver.findElement(By.id("txtFromDate")).sendKeys("03/05/2021");
	    Thread.sleep(6000);	
	    
	    // Select Type "All"
	    Select dropdown = new Select(driver.findElement(By.id("ddlIncidentType")));
	   	dropdown.selectByVisibleText("Critical Error"); 
	    
	    // Click on find
	    driver.findElement(By.xpath("//*[@id=\"btnFind\"]")).click();
	   
	    Thread.sleep(7000);
	    String Expectedmsg = "Critical Error";
	    
	    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table[2]/tbody/tr[4]/td/div[2]/table/tbody/tr[1]/td[6]/img")).click();
	    
	    Thread.sleep(7000);
	    driver.switchTo().activeElement();

	    String Actualmsg = driver.findElement(By.xpath("//*[@id=\"tblPopUpDetails\"]/tbody/tr/td/table/tbody/tr[7]/td[2]/label")).getText();
	    
	    Assert.assertEquals(Actualmsg, Expectedmsg); 
	    
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
	
	
	

	

////Test ID: 30-12
///* 
//* To verify the 'Status' functionality of field Search Incidents on OPR web. All
//*/	
	@Test (priority = 11)
	public void verifyStatusfunctionalityAll() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "30-12";
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
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Enter from date
	    driver.findElement(By.id("txtFromDate")).clear();
	    driver.findElement(By.id("txtFromDate")).sendKeys("03/05/2021");
	    Thread.sleep(6000);	
	    
	    // Select Type "All"
	    Select dropdown = new Select(driver.findElement(By.id("ddlStatus")));
	   	dropdown.selectByVisibleText("All"); 
	    
	    // Click on find
	    driver.findElement(By.xpath("//*[@id=\"btnFind\"]")).click();
	   	    
	    // Data is displayed in table 
	    Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"jqueryTable\"]/tbody")).isDisplayed());
	    
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
	
	
	
	
	
	
////Test ID: 30-13
///* 
//* To verify the 'Status' functionality of field Search Incidents on OPR web. Read
//*/		
	@Test (priority = 12)
	public void verifyStatusfunctionalityRead() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "30-13";
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
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Enter from date
	    driver.findElement(By.id("txtFromDate")).clear();
	    driver.findElement(By.id("txtFromDate")).sendKeys("03/05/2021");
	    Thread.sleep(6000);	
	    
	    Thread.sleep(5000);	    // Select Type "Read"
	    Select dropdown = new Select(driver.findElement(By.id("ddlStatus")));
	   	dropdown.selectByVisibleText("Read"); 
	    
	    // Click on find
	    driver.findElement(By.xpath("//*[@id=\"btnFind\"]")).click();
	   	    
	    Thread.sleep(9000);
	    // Get xpath of first row
	    String fontWeight = driver.findElement(By.xpath("//*[@id=\"jqueryTable\"]/tbody/tr[1]")).getCssValue("font-weight");
	    System.out.println(fontWeight);
	    boolean isNormal = "bold".equals(fontWeight) || "bolder".equals(fontWeight) || Integer.parseInt(fontWeight) < 700;
	    System.out.println(isNormal);
	    
	    // Data is displayed in table 
	    Assert.assertTrue(isNormal); 
	    
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
	
	
	
	

	
////Test ID: 30-14
///* 
//* To verify the 'Status' functionality of field Search Incidents on OPR web. Un-Read
//*/	
	@Test (priority = 13)
	public void verifyStatusfunctionalityUnRead() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "30-14";
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
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Enter from date
	    driver.findElement(By.id("txtFromDate")).clear();
	    driver.findElement(By.id("txtFromDate")).sendKeys("03/05/2021");
	    
	    Thread.sleep(5000);	    // Select Type "Unread"
	    Select dropdown = new Select(driver.findElement(By.id("ddlStatus")));
	   	dropdown.selectByVisibleText("Unread"); 
	    
	    // Click on find
	    driver.findElement(By.xpath("//*[@id=\"btnFind\"]")).click();
	   	    
	    Thread.sleep(9000);
	    // Get xpath of first row
	    String fontWeight = driver.findElement(By.xpath("//*[@id=\"jqueryTable\"]/tbody/tr[1]")).getCssValue("font-weight");
	    System.out.println(fontWeight);
	    boolean isBold = "bold".equals(fontWeight) || "bolder".equals(fontWeight) || Integer.parseInt(fontWeight) >= 700;
	    System.out.println(isBold);
	    if (isBold == true) {
	    	// Data is displayed in table 
		    Assert.assertTrue(isBold);  }
	    
	    else if (isBold == false) {
	    	
	    	System.out.println("No Unread data");
		    Assert.assertTrue(false);  }
	    
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
	
	
	
	
	

////Test ID: 30-15
///* 
//* To verify the functionality of search bar by given inputs.
//*/	
	@Test (priority = 14)
	public void verifySearchfunctionality() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "30-15";
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
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Enter from date
	    driver.findElement(By.id("txtFromDate")).clear();
	    driver.findElement(By.id("txtFromDate")).sendKeys("03/05/2021");
	    
	    Thread.sleep(5000);	    // Select Type "All"
	    Select dropdown = new Select(driver.findElement(By.id("ddlStatus")));
	   	dropdown.selectByVisibleText("All"); 
	    
	    // Click on find
	    driver.findElement(By.xpath("//*[@id=\"btnFind\"]")).click();
	    
	    // Enter a key word in search 
	    driver.findElement(By.xpath("//*[@id=\"jqueryTable_filter\"]/label/input")).sendKeys("Recording");
	    
	    //Get the table and row
		  WebElement table1 =driver.findElement(By.id("jqueryTable"));
		  WebElement tbody1=table1.findElement(By.tagName("tbody"));
		  List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
		  int count = 0;
		  @SuppressWarnings("unused")
		  String rowNo1="";
		  String key  = "Recording";
			for(int i=0;i<rows1.size();i++)
				{
				Thread.sleep(3000);
				WebElement row = tbody1.findElement(By.xpath("//*[@id=\"jqueryTable\"]/tbody/tr["+(i+1)+"]"));
				if(row.getText().trim().contains(key))
				{
//				rowNo1=Integer.toString(i+1);
				count++;
				}
				}
		  System.out.println(count);
//		  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr["+rowNo1+"]/td[3]/div/img[4]")).click(); 
	      Thread.sleep(6000);
	      
	      Assert.assertTrue(count == 10); // (count == 10||count == 8 );
	      
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
	

	

	
////Test ID: 30-16
///* 
//* To verify the pagination of the Server Incident's page.
//*/	
	@Test (priority = 15)
	public void verifyPaginationfunctionality() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "30-16";
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
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Enter from date
	    driver.findElement(By.id("txtFromDate")).clear();
	    driver.findElement(By.id("txtFromDate")).sendKeys("03/05/2021");
	    
	    // Click on find
	    driver.findElement(By.xpath("//*[@id=\"btnFind\"]")).click();
	    
	    //Get the table and row
		WebElement table =driver.findElement(By.id("jqueryTable"));
		WebElement tbody=table.findElement(By.tagName("tbody"));
		List<WebElement> rows=tbody.findElements(By.tagName("tr"));
//		String Totalrows = Integer.toString(rows.size());
		
//		String NoOfrows = driver.findElement(By.xpath("//*[@id=\"jqueryTable_length\"]/label/select")).getText();
	    
		Assert.assertEquals(rows.size(), 10);
		
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
	

	
	
	

////Test ID: 30-17
///* 
//* verify the Older and button's functionality
//*/	
	@Test (priority = 16)
	public void verifyOlderbuttonfunctionality() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "30-17";
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
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Enter from date
	    driver.findElement(By.id("txtFromDate")).clear();
	    driver.findElement(By.id("txtFromDate")).sendKeys("03/05/2021");
	    
	    // Click on find
	    driver.findElement(By.xpath("//*[@id=\"btnFind\"]")).click();
	    
	    // Click on Older button
	    Thread.sleep(6000);
	    driver.findElement(By.id("lbLoadOlder")).click();
	    
		// Check presence of newer button appears after older is clicked
	    Thread.sleep(6000);
	    Assert.assertTrue(driver.findElement(By.id("lbLoadNewer")).isDisplayed());
		
	    driver.close();		
	    
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
	    
	  }		
	
	
	
	


	
////Test ID: 30-18
///* 
//* verify the 'Newer' and button's functionality
//*/	
	@Test (priority = 17)
	public void verifyNewerbuttonfunctionality() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "30-18";
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
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Enter from date
	    driver.findElement(By.id("txtFromDate")).clear();
	    driver.findElement(By.id("txtFromDate")).sendKeys("03/05/2021");
	    	    
	    // Enter to date
	    driver.findElement(By.id("txtToDate")).clear();
	    driver.findElement(By.id("txtToDate")).sendKeys("10/08/2021");
	   
	    // Click on find
	    driver.findElement(By.xpath("//*[@id=\"btnFind\"]")).click();
	    
	    // Click on Older button
	    Thread.sleep(6000);
	    driver.findElement(By.id("lbLoadOlder")).click();
	    
	    // Click on Newer button
	    Thread.sleep(8000);
	    driver.findElement(By.id("lbLoadNewer")).click();
	    
	    // newer button disappears after click
	    Assert.assertTrue(true);
		
	    driver.close();	
	    
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
	    
	  }	
	
	
	
	
	
	

////Test ID: 30-19
///* 
//* verify the button 1,2,3,4,5.
//*/	
	@Test (priority = 18)
	public void verify12345buttonfunctionality() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "29-04";
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
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Enter from date
	    driver.findElement(By.id("txtFromDate")).clear();
	    driver.findElement(By.id("txtFromDate")).sendKeys("03/05/2021");
	    
	    // Click on find
	    driver.findElement(By.xpath("//*[@id=\"btnFind\"]")).click();
	    
//	    // Click on Older button
//	    driver.findElement(By.id("lbLoadOlder")).click();
//	    
//	    // Click on Newer button
//	    driver.findElement(By.id("lbLoadNewer")).click();
	    
	    Thread.sleep(8000);
	    
	    // Click on "1" 
	    driver.findElement(By.xpath("//*[@id=\"jqueryTable_paginate\"]/span/a[1]")).click();
	    Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"jqueryTable_paginate\"]/span/a[1]")).isSelected());
	    
	    Thread.sleep(2000);
	    // Click on "2" 
	    driver.findElement(By.xpath("//*[@id=\"jqueryTable_paginate\"]/span/a[1]")).click();
	    Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"jqueryTable_paginate\"]/span/a[2]")).isSelected());
	    
	    Thread.sleep(2000);
	    // Click on "3" 
	    driver.findElement(By.xpath("//*[@id=\"jqueryTable_paginate\"]/span/a[1]")).click();
	    Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"jqueryTable_paginate\"]/span/a[3]")).isSelected());
	    
	    Thread.sleep(2000);
	    // Click on "4" 
	    driver.findElement(By.xpath("//*[@id=\"jqueryTable_paginate\"]/span/a[1]")).click();
	    Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"jqueryTable_paginate\"]/span/a[4]")).isSelected());
	    
	    Thread.sleep(2000);
	    // Click on "5" 
	    driver.findElement(By.xpath("//*[@id=\"jqueryTable_paginate\"]/span/a[1]")).click();
	    Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"jqueryTable_paginate\"]/span/a[5]")).isSelected());
	    
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
	
	
	
	
	

////Test ID: 30-20
///* 
//* verify the button 'Previous' and 'Next' button
//*/	
	@Test (priority = 19)
	public void verifyNext_Previousbuttonfunctionality() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "30-20";
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
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Enter from date
	    driver.findElement(By.id("txtFromDate")).clear();
	    driver.findElement(By.id("txtFromDate")).sendKeys("03/05/2021");
	    
	    // Click on find
	    driver.findElement(By.xpath("//*[@id=\"btnFind\"]")).click();
	    
	    // Click on Next button
	    Thread.sleep(6000);
	    driver.findElement(By.id("jqueryTable_next")).click();
	    Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"jqueryTable_paginate\"]/span/a[2]")).isSelected());
	    
	    // Click on previous button
	    driver.findElement(By.id("jqueryTable_previous")).click();
	    Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"jqueryTable_paginate\"]/span/a[1]")).isSelected());
	    
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
	
	
	
	
	
	
////Test ID: 30-21
///* 
//* To verify the button of ''Mark all as Read"
//*/		
	@Test (priority = 20)
	public void verifyMark_all_as_Readfunctionality() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "30-21";
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
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Enter from date
	    driver.findElement(By.id("txtFromDate")).clear();
	    driver.findElement(By.id("txtFromDate")).sendKeys("03/05/2021");
	    
	    Thread.sleep(5000);	    // Select Type "Read"
	    Select dropdown = new Select(driver.findElement(By.id("ddlStatus")));
	   	dropdown.selectByVisibleText("Unread"); 
	    
	    // Click on find
	    driver.findElement(By.xpath("//*[@id=\"btnFind\"]")).click();
	   	    
	    // Check for bold incidents
	    Thread.sleep(9000);
	    // Get xpath of first row
	    String fontWeight = driver.findElement(By.xpath("//*[@id=\"jqueryTable\"]/tbody/tr[1]")).getCssValue("font-weight");
	    System.out.println(fontWeight);
	    boolean isBold = "bold".equals(fontWeight) || "bolder".equals(fontWeight) || Integer.parseInt(fontWeight) >= 700;
	    System.out.println(isBold);
	    
	    if (isBold == true) { // if bold click "mark all as read" else test fail 
	    	
	    	// Click "mark all as read"
	    	driver.findElement(By.id("MarkAllRead")).click();
	    	
	    	// Get xpath of first row
		    String font_Weight = driver.findElement(By.xpath("//*[@id=\"jqueryTable\"]/tbody/tr[1]")).getCssValue("font-weight");
		    System.out.println(font_Weight);
		    boolean is_normal = "bold".equals(font_Weight) || "bolder".equals(font_Weight) || Integer.parseInt(font_Weight) < 700;
		    System.out.println(is_normal);
		    Assert.assertTrue(is_normal); 
		    driver.close();
	    }
	    
	    
	    else if (isBold == false) {
	    	System.out.println("All Read");
	    	Assert.assertTrue(false);
	    }
	    
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
	
	
  

	
	
	
////Test ID: 30-22
///* 
//* To verify the button of ''Event Detail"
//*/	
	@Test (priority = 21)
	public void verifyEventDetailfunctionality() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "30-22";
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
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Click event detail button
	    driver.findElement(By.xpath("//*[@id=\"jqueryTable\"]/tbody/tr[1]/td[6]/img")).click();
	    
	    driver.switchTo().activeElement();
	    
//	    String title = driver.findElement(By.id("ui-id-1")).getText();
	    
	    Thread.sleep(5000);
	    String expectedtitle = "Event Detail";
	    String actualTitle = driver.findElement(By.id("ui-id-1")).getText();
	    Assert.assertEquals(actualTitle, expectedtitle);
//	    System.out.println(actualTitle);
	    
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
	
	
	

	

////Test ID: 30-23
///* 
//* Check the tooltip of  'Event Detail'
//*/	
	@Test (priority = 22)
	public void verifyEventDetailTooltip() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "30-23";
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
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Get event detail button title
	    String actualTitle = driver.findElement(By.xpath("//*[@id=\"jqueryTable\"]/tbody/tr[1]/td[6]/img")).getAttribute("title");
	    
	    Thread.sleep(5000);
	    String expectedtitle = "Event Detail";
	    Assert.assertEquals(actualTitle, expectedtitle);
//	    System.out.println(actualTitle);
	    
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
	
	
	


	
	
////Test ID: 30-24
///* 
//* Event detail Update button functionality
//*/		
	@Test (priority = 23)
	public void verifyEventdetailUpdatefunctionality() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);

	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "30-24";
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
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Click on event detail button
	    driver.findElement(By.xpath("//*[@id=\"jqueryTable\"]/tbody/tr[1]/td[6]/img")).click();
	    
	    driver.switchTo().activeElement();
	    Thread.sleep(3000);
	    
	    // Click on update button 
	    driver.findElement(By.xpath("//*[@id=\"tblPopUpDetails\"]/tbody/tr/td/table/tbody/tr[15]/td[2]/input[1]")).click();
	   	    
	    Thread.sleep(9000);
	    // Get xpath of first row
	    String fontWeight = driver.findElement(By.xpath("//*[@id=\"jqueryTable\"]/tbody/tr[1]")).getCssValue("font-weight");
	    System.out.println(fontWeight);
	    boolean isBold = "bold".equals(fontWeight) || "bolder".equals(fontWeight) || Integer.parseInt(fontWeight) < 700; // <700 mean normal text
	    System.out.println(isBold);
	    
	    // Data is displayed in table 
	    Assert.assertTrue(isBold);
	    
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
	
	
	

	


////Test ID: 31-30
///* 
//* To verify that SNMP traps and email is not subscribed unless snmp and smpt setting  are configured
//*/	
	@Test (priority = 24)
	public void verifySNMPtrapsnotSubscribedwithoutSNMPandSMPTsetting() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "31-30";
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
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Click on Incidents Subscription
	    driver.findElement(By.xpath("//*[@id=\"tblIncidentsSub\"]/tbody/tr[1]/td[2]/a")).click();
	    
	    // Click on select "Email All" checkbox
	    driver.findElement(By.id("cbSelectAllEmail")).click();
	    
	    Thread.sleep(6000);
	     
        // Check alert message
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.confirm('This option is not available. SMTP settings are not configured.')");
       
        String expectedAlert = "This option is not available. SMTP settings are not configured.";
        Alert confirmation = driver.switchTo().alert();
        String actualAlert = confirmation.getText(); //Get text present on alert Message
        
        // Match alert messages 
        Assert.assertEquals(actualAlert,expectedAlert);
        driver.switchTo().alert().accept();
       
        // Click on okay button
        Thread.sleep(3000);
        driver.findElement(By.id("btnOK")).click();
        
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
	
	

	
	

////Test ID: 31-31
///* 
//* verify that email is not subscribed from server incidents page when smpt settings are not configured "
//*/		
	@Test (priority = 25)
	public void verifyEmailnotSubscribedwithoutSNMPandSMPTsetting() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "31-31";
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
	      
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Click on event detail button
	    driver.findElement(By.xpath("//*[@id=\"jqueryTable\"]/tbody/tr[1]/td[6]/img")).click();
	    
	    // Click email cb in event details
	    driver.findElement(By.id("cbIsEmail")).click(); 
	    
	    Thread.sleep(4000);
	    
	    // Check alert message
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.confirm('This option is not available. SMTP settings are not configured.')");
       
        String expectedAlert = "This option is not available. SMTP settings are not configured.";
        Alert confirmation = driver.switchTo().alert();
        String actualAlert = confirmation.getText(); //Get text present on alert Message
        
        // Match alert messages 
        Assert.assertEquals(actualAlert,expectedAlert);
        driver.switchTo().alert().accept();
       
        // Click on okay button
        Thread.sleep(3000);
        driver.findElement(By.id("btnOK")).click();
        
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

	


	
////Test ID: 31-32
///* 
//* verify that snmp traps is not subscribed from server incidents page when snmp settings are not configured 
//*/		
	@Test (priority = 26)
	public void verifySNMPTrapsnotSubscribedwithoutSNMPandSMPTsettingServerincidentsPage() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "31-32";
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
	      
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Click on event detail button
	    driver.findElement(By.xpath("//*[@id=\"jqueryTable\"]/tbody/tr[1]/td[6]/img")).click();
	    
	    Thread.sleep(4000);
	    
	    // Check SNMP Trap cb in event details
	    Assert.assertFalse(driver.findElement(By.id("cbIsSNMP")).isEnabled()); 
	    
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
	
	
	

	
	
	
////Test ID: 31-33
///* 
//* verify that sms is not subscribed from server incidents page when notification settings are not configured 
//*/		
	@Test (priority = 25)
	public void verifySMSnotSubscribedwithoutSNMPandSMPTsettingServerincidentsPage() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "31-33";
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
	      
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Click on event detail button
	    driver.findElement(By.xpath("//*[@id=\"jqueryTable\"]/tbody/tr[1]/td[6]/img")).click();
	    
	    // Click email cb in event details
	    driver.findElement(By.id("cbIsSMS")).click(); 
	    
	    Thread.sleep(4000);
	    
	    // Check alert message
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.confirm('This option is not available as notification settings are not configured')");
       
        String expectedAlert = "This option is not available as notification settings are not configured";
        Alert confirmation = driver.switchTo().alert();
        String actualAlert = confirmation.getText(); //Get text present on alert Message
        
        // Match alert messages 
        Assert.assertEquals(actualAlert,expectedAlert);
        driver.switchTo().alert().accept();
       
        // Click on okay button
        Thread.sleep(3000);
        driver.findElement(By.id("btnOK")).click();
        
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
	
	
	

	
	

////Test ID: 31-34
///* 
//* verify that sms is not subscribed from server incidents page when sms settings are not configured 
//*/	
	@Test (priority = 24)
	public void verifySMSnotSubscribedwithoutSNMPandSMPTsetting() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "31-34";
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
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Click on Incidents Subscription
	    driver.findElement(By.xpath("//*[@id=\"tblIncidentsSub\"]/tbody/tr[1]/td[2]/a")).click();
	    
	    // Click on select "SMS All" checkbox
	    driver.findElement(By.id("cbSelectAllNotification")).click();
	    
	    Thread.sleep(6000);
	     
        // Check alert message
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.confirm('This option is not available. SMTP settings are not configured.')");
       
        String expectedAlert = "This option is not available. SMTP settings are not configured.";
        Alert confirmation = driver.switchTo().alert();
        String actualAlert = confirmation.getText(); //Get text present on alert Message
        
        // Match alert messages 
        Assert.assertEquals(actualAlert,expectedAlert);
        driver.switchTo().alert().accept();
       
        // Click on okay button
        Thread.sleep(3000);
        driver.findElement(By.id("btnOK")).click();
	   	
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
	
	
	
	
	
	
	
//////Test ID: 31-25
/////* 
////* Check the Email box for that incident
////*/		
	@Test (priority = 28)
	public void checkEmailboxforEventdetails() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "31-25";
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
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
	      
	      // Enter values for SMTP Server *
	      driver.findElement(By.id("txtSMTPServer")).clear();
	      driver.findElement(By.id("txtSMTPServer")).sendKeys("auth.smtp.1and1.co.uk");
	      
	      // Enter values for Username
	      driver.findElement(By.id("txtSMTPUsername")).clear();
	      driver.findElement(By.id("txtSMTPUsername")).sendKeys("qa-opr@amigo-software.com");
	      
	      // Clear values for password and enter value
	      driver.findElement(By.id("txtSMTPPassword")).clear();
	      driver.findElement(By.id("txtSMTPPassword")).sendKeys("OPRqa@2017");
	      
	      // Enter values for Sender Email Address *
	      driver.findElement(By.id("txtSMTPSenderEmailAddress")).clear();
	      driver.findElement(By.id("txtSMTPSenderEmailAddress")).sendKeys("qa-opr@amigo-software.com");
	      
	      // Enter values for Port *
	      driver.findElement(By.id("txtSMTPPort")).clear();
	      driver.findElement(By.id("txtSMTPPort")).sendKeys("587");
	      
	      // Click upload button
	      driver.findElement(By.id("btnUpdateSMTPSettings")).click();
	    
	      Thread.sleep(6000);
	      
	    // Click on Server Incidents
	    Thread.sleep(10000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Click on event detail button
	    driver.findElement(By.xpath("//*[@id=\"jqueryTable\"]/tbody/tr[1]/td[6]/img")).click();
	    
	    if (driver.findElement(By.id("cbIsEmail")).isSelected() == true) {
	    	
	    	// Click on update button 
		    driver.findElement(By.xpath("//*[@id=\"tblPopUpDetails\"]/tbody/tr/td/table/tbody/tr[15]/td[2]/input[1]")).click();
		    Thread.sleep(5000);	    }
	    
	    else if (driver.findElement(By.id("cbIsEmail")).isSelected() == false) {
	    	
	    	     driver.findElement(By.id("cbIsEmail")).click();
	    
			    // Click on update button 
			    driver.findElement(By.xpath("//*[@id=\"tblPopUpDetails\"]/tbody/tr/td/table/tbody/tr[15]/td[2]/input[1]")).click();
			    Thread.sleep(5000);	 
	    }
	   	 
	    
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
	    
	   Assert.assertTrue(true); 
	    driver.close();		  
}		
	
	
	
		

////Test ID: 31-27
///* 
//* Check the SMS box for an incident
//*/		
	@Test (priority = 30)
	public void checkSMSboxforEventdetails() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "31-27";
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
	    Thread.sleep(10000);
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
	    
	    Thread.sleep(6000);
	    
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Click on event detail button
	    driver.findElement(By.xpath("//*[@id=\"jqueryTable\"]/tbody/tr[1]/td[6]/img")).click();
	    
	    if (driver.findElement(By.id("cbIsSMS")).isSelected() == true) {
	    	
	    	// Click on update button 
		    driver.findElement(By.xpath("//*[@id=\"tblPopUpDetails\"]/tbody/tr/td/table/tbody/tr[15]/td[2]/input[1]")).click();
		    
	    }
	    
	    else if (driver.findElement(By.id("cbIsSMS")).isSelected() == false) {
	    	
	    	     driver.findElement(By.id("cbIsSMS")).click();
	    
			    // Click on update button 
			    driver.findElement(By.xpath("//*[@id=\"tblPopUpDetails\"]/tbody/tr/td/table/tbody/tr[15]/td[2]/input[1]")).click();    
	    }
	      
	    Assert.assertTrue(true); 
	    
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

	
	
	


////Test ID: 31-28
///* 
//* Open "Incident Subscription" and see if check box is mark as check
//*/		
	@Test (priority = 31)
	public void checkEmail_SMScheckbox_isCheckedinIncidentSubscription() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);
	    
	    String SheetName = "22- Server Incidents";
	    String TestCaseID = "31-28";
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
	      
	    // Click on Server Incidents
	    Thread.sleep(9000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
	    
	    // Click on event detail button
	    driver.findElement(By.xpath("//*[@id=\"jqueryTable\"]/tbody/tr[1]/td[6]/img")).click();
	    
	    if (driver.findElement(By.id("cbIsEmail")).isSelected() == true && driver.findElement(By.id("cbIsSMS")).isSelected() == true ) {
	    	
	    	// Click on update button 
		    driver.findElement(By.xpath("//*[@id=\"tblPopUpDetails\"]/tbody/tr/td/table/tbody/tr[15]/td[2]/input[1]")).click(); }
	    
	    else if (driver.findElement(By.id("cbIsEmail")).isSelected() == false && driver.findElement(By.id("cbIsSMS")).isSelected() == false  ) {
	    	
	    	     driver.findElement(By.id("cbIsEmail")).click();
	    	     driver.findElement(By.id("cbIsSMS")).click();
	    
			    // Click on update button 
			    driver.findElement(By.xpath("//*[@id=\"tblPopUpDetails\"]/tbody/tr/td/table/tbody/tr[15]/td[2]/input[1]")).click(); }
	     
	    else if (driver.findElement(By.id("cbIsEmail")).isSelected() == false && driver.findElement(By.id("cbIsSMS")).isSelected() == true  ) { 
	    	
	    	 driver.findElement(By.id("cbIsEmail")).click();
    	   
		    // Click on update button 
		    driver.findElement(By.xpath("//*[@id=\"tblPopUpDetails\"]/tbody/tr/td/table/tbody/tr[15]/td[2]/input[1]")).click(); }
	    
	    else if (driver.findElement(By.id("cbIsEmail")).isSelected() == true && driver.findElement(By.id("cbIsSMS")).isSelected() == false  ) { 
	    	
	    	 driver.findElement(By.id("cbIsSMS")).click();
   	   
		     // Click on update button 
		     driver.findElement(By.xpath("//*[@id=\"tblPopUpDetails\"]/tbody/tr/td/table/tbody/tr[15]/td[2]/input[1]")).click(); }
	    
	    Thread.sleep(6000);
	    
	    // Click on Incident Description
	    driver.findElement(By.xpath("//*[@id=\"tblIncidentsSub\"]/tbody/tr[1]/td[2]/a")).click();
	    
	    String expected = driver.findElement(By.xpath("//*[@id=\"jqueryTable\"]/tbody/tr[1]/td[5]/span")).getText();
	    Thread.sleep(6000);
	    
	    driver.findElement(By.xpath("//*[@id=\"jqueryTable_filter\"]/label/input")).sendKeys(expected);
	    
	    Assert.assertTrue(driver.findElement(By.id("chkSMTP")).isSelected() == true && driver.findElement(By.id("chkSMS")).isSelected() == true);
	    
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
	
	
	

	
	
//////////////////////////////////////////////////
//// Clear all System Configs for Server incidents 	
//////////////////////////////////////////////////
	@Test (priority = 32)
	public void checkSNMPTrapforEventdetails() throws InterruptedException {
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
	      
	    // Click reset button SMTP Settings
	    driver.findElement(By.id("btnResetSMTPSettings")).click();
	    
	    // Click reset button Notification Settings
	    driver.findElement(By.id("btnResetUpdateNotificationSettings")).click();
	    
	    Thread.sleep(6000);
	      
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

    
    
////Test ID: 31-26
///* 
//* Check the SNMP Trap box for an incident
//*/		
//	@Test (priority = 25)
//	public void checkSNMPTrapforEventdetails() throws InterruptedException {
//		System.setProperty("webdriver.gecko.driver", driverPath);
//	    driver = new FirefoxDriver();
//	    driver.get(baseUrl);
//
//	    // Signing in OmniPCX 
//	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
//	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//	      
//	      // Click on System
//	      Thread.sleep(10000);
//	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
//	      
//	      // Enter values for SMTP Server *
//	      driver.findElement(By.id("txtSMTPServer")).clear();
//	      driver.findElement(By.id("txtSMTPServer")).sendKeys("auth.smtp.1and1.co.uk");
//	      
//	      // Enter values for Username
//	      driver.findElement(By.id("txtSMTPUsername")).clear();
//	      driver.findElement(By.id("txtSMTPUsername")).sendKeys("qa-opr@amigo-software.com");
//	      
//	      // Clear values for password and enter value
//	      driver.findElement(By.id("txtSMTPPassword")).clear();
//	      driver.findElement(By.id("txtSMTPPassword")).sendKeys("OPRqa@2017");
//	      
//	      // Enter values for Sender Email Address *
//	      driver.findElement(By.id("txtSMTPSenderEmailAddress")).clear();
//	      driver.findElement(By.id("txtSMTPSenderEmailAddress")).sendKeys("qa-opr@amigo-software.com");
//	      
//	      // Enter values for Port *
//	      driver.findElement(By.id("txtSMTPPort")).clear();
//	      driver.findElement(By.id("txtSMTPPort")).sendKeys("587");
//	      
//	      // Click upload button
//	      driver.findElement(By.id("btnUpdateSMTPSettings")).click();
//	    
//	      Thread.sleep(6000);
//	      
//	    // Click on Server Incidents
//	    Thread.sleep(9000);
//	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).click();
//	    
//	    // Click on event detail button
//	    driver.findElement(By.xpath("//*[@id=\"jqueryTable\"]/tbody/tr[1]/td[6]/img")).click();
//	    
//	    if (driver.findElement(By.id("cbIsSNMP")).isSelected() == true) {
//	    	
//	    	// Click on update button 
//		    driver.findElement(By.xpath("//*[@id=\"tblPopUpDetails\"]/tbody/tr/td/table/tbody/tr[15]/td[2]/input[1]")).click();
//		    
//	    }
//	    
//	    else if (driver.findElement(By.id("cbIsSNMP")).isSelected() == false) {
//	    	
//	    	     driver.findElement(By.id("cbIsSNMP")).click();
//	    
//			    // Click on update button 
//			    driver.findElement(By.xpath("//*[@id=\"tblPopUpDetails\"]/tbody/tr/td/table/tbody/tr[15]/td[2]/input[1]")).click();	    
//	    }	
//	    driver.close();		  
//	  }	    
    
    
    
}
