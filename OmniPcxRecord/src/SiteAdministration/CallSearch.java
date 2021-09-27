package SiteAdministration;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Settings.SharedFunctions;
import Settings.UpdateTestResult;

public class CallSearch {
	
	public String siteUrl = "http://172.20.22.81/OmniPCXRECORD/default.aspx";
    public String baseUrl = "http://172.20.22.81/OmniPCXRecord/TenantAdmin.aspx";
	
	public WebDriver driver;
	public String SheetName = "29- Permission's";
	
	public SharedFunctions sf = new SharedFunctions();
     
	UpdateTestResult obj = new UpdateTestResult();


	@BeforeClass
	public void beforeTest() {
		
		System.out.println(this.getClass().getName());
		driver=((SharedFunctions)sf).InitializeDriver(); 
    }
	
  @Test
  public void f() throws InterruptedException, IOException {
	  driver.get(siteUrl);

//		String TestCaseID = "29-37";
//		String Status = "";

		if (driver == null) {

			System.out.println("WebDriver not initialized");
			return;
		}
			
		((SharedFunctions)sf).loginSiteAdmin(driver);
		
		((SharedFunctions)sf).clickSitePermissions(driver);
		
		// Click on Group name and add 
		String groupname = ((SharedFunctions)sf).GenerateGroupNames();
		driver.findElement(By.id("txtGroupName")).sendKeys(groupname);
		System.out.println(groupname);
		
		// Click on Group description and add 
		String groupdesp = ((SharedFunctions)sf).GenerateStringofLength10();
		driver.findElement(By.id("txtDescription")).sendKeys(groupdesp);
		System.out.println(groupdesp);
		
		// Click on add button
	    driver.findElement(By.id("imgbtnAddUpdate")).click();
		
//		String groupdespadd = driver.findElement(By.id("txtDescription")).getAttribute("value");
//		int len = groupdespadd.length();
//		System.out.println(len);
//		
//		Assert.assertEquals(groupdespadd.length(), 250);
//		
//		driver.close();
		  	 }	
  
  
  @AfterClass 
  public void afterTest() {
	  driver.quit();
}	 
		  
}

