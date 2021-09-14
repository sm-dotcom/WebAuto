/* 
Created on Apr 19, 2021
@author: sarah.mahmood 
*/

package ServerAdministration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import Settings.SharedFunctions;
import Settings.TestResult;
import Settings.UpdateTestResult;





@Test
public class LoginPage {
	
	public ArrayList<TestResult> testresultlist = new ArrayList<TestResult>();

	public String siteurl = "http://172.20.22.81/omnipcxrecord/default.aspx";
	public String driverPath = "C:\\Selenium\\chromedriver.exe";
	public String downloadFilepath ="C:\\Temp";
	public WebDriver driver; 
	UpdateTestResult obj = new UpdateTestResult();
	
@BeforeTest
public void beforeTest(){
	
	  System.setProperty("webdriver.chrome.driver", driverPath);
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--download.default_directory", downloadFilepath);
	  driver = new ChromeDriver(options);
		  }


public void verifyLoingwithValidCredentials() throws IOException {
	  
	  
	 String SheetName = "2- Login";
	 String TestCaseID = "02-01";
	 String Status = "";
	 
	 if(driver==null){
		 
		 System.out.println("WebDriver not initialized");
		 return;
	  }
	 
	 
	  try{
		  
	  driver.get(siteurl);
	  
	  driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
	  driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
	  driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
	  
	  String expectedurl = "http://172.20.22.81/OmniPCXRECORD/Searches.aspx";
	  String actualurl = driver.getCurrentUrl();
	  
	  System.out.println("Actual Url : "+actualurl);
	  System.out.println("Expected Url : "+expectedurl);
	  

	  Assert.assertEquals(actualurl, expectedurl);
	  
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
		  testresultlist.add(objtestreult);
		 //obj.updateResult(TestCaseID,SheetName,Status);
		 
		
		 
	  }     
      	  
  }

public void verifyLoingwithInValidCredentials() throws IOException {
	  
	  
	 String SheetName = "2- Login";
	 String TestCaseID = "02-02";
	 String Status = "";
	 
	 if(driver==null){
		 
		 System.out.println("WebDriver not initialized");
		 return;
	  }
	 
	 
	  try{
		  
	  driver.get(siteurl);
	  
	  driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
	  driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
	  driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
	  
	  String expectedurl = "http://172.20.22.81/OmniPCXRECORD/Searches.aspx";
	  String actualurl = driver.getCurrentUrl();
	  
	  System.out.println("Actual Url : "+actualurl);
	  System.out.println("Expected Url : "+expectedurl);
	  

	  Assert.assertEquals(actualurl, expectedurl);
	  
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
		  testresultlist.add(objtestreult);
		 //obj.updateResult(TestCaseID,SheetName,Status);
		 
		
		 
	  }     
     	  
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







