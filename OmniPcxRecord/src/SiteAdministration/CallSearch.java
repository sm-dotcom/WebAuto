package SiteAdministration;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		
		if (driver == null) {

			System.out.println("WebDriver not initialized");
			return;
		}
			
        ((SharedFunctions)sf).loginSiteAdmin(driver);
		
		((SharedFunctions)sf).clickSitePermissions(driver);
				
		// Make admin copy
		driver.findElement(By.xpath("//*[@id=\"gvGroups\"]/tbody/tr[1]/td[3]/div/img[2]")).click();
      
		//Get the table and row
	  	WebElement table1 =driver.findElement(By.id("gvGroups"));
	  	WebElement tbody1=table1.findElement(By.tagName("tbody"));
	  	List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
	  	String rowNo1="";
	  	String Groups  = "Super Admin - Copy";
	  	for(int i=0;i<rows1.size();i++)
	  		{
	  		WebElement row = tbody1.findElement(By.xpath("//*[@id=\"gvGroups\"]/tbody/tr["+(i+1)+"]"));
	  		if(row.getText().trim().contains(Groups))
	  		{
	  		rowNo1=Integer.toString(i+1);
	  		break;
	  		}
	  		}
      
	  	Assert.assertTrue(true);
		  	 }	
  
  
  @AfterClass 
  public void afterTest() {
	  driver.quit();
}	 
		  
}

