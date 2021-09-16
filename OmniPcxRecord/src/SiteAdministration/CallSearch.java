package SiteAdministration;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
	  driver.get(baseUrl);

//		String TestCaseID = "29-01";
//		String Status = "";

	  
	  ((SharedFunctions)sf).CreateUser(driver);
	 
			

  }
}
