package SiteAdministration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Settings.SharedFunctions;
import Settings.TestResult;
import Settings.UpdateTestResult;

public class SitePermissions {
  
	public String siteUrl = "http://172.20.22.81/OmniPCXRECORD/default.aspx";

	public WebDriver driver;
	public String SheetName = "29- Permission's";
	
	public SharedFunctions sf = new SharedFunctions();
     
	UpdateTestResult obj = new UpdateTestResult();


	@BeforeClass
	public void beforeTest() {
		
		System.out.println(this.getClass().getName());
		driver=((SharedFunctions)sf).InitializeDriver(); 
    }
	
	
////Test ID: 29-01
///* 
//* Verify that default permission group is available 
//*/	

	@Test(priority = 0)
	public void verifyDefaultPermissionGroup() throws InterruptedException, IOException {

		driver.get(siteUrl);

//		String TestCaseID = "29-01";
//		String Status = "";

		if (driver == null) {

			System.out.println("WebDriver not initialized");
			return;
		}
			
			((SharedFunctions)sf).loginSiteAdmin(driver);
			Thread.sleep(6000);
			((SharedFunctions)sf).clickSitePermissions(driver);
			
          String[] expectedData  = {"Groups", "Super Admin", "Group Admin", "Agent", "Configuration Manager"};
	
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"gvGroups\"]/tbody/tr"));
			  	int rowscount = rows.size();
			  	System.out.println(rowscount);
			
			  String actualData = "";
			for (int i=0 ; i<=rowscount; i++){    
				List<WebElement> allColumnsInRow=driver.findElements(By.xpath("//*[@id=\"gvGroups\"]/tbody/tr["+i+"]/td[1]"));
		       for(WebElement e: allColumnsInRow) {
		//        System.out.println(e.getText());
		        actualData = e.getText();
		        System.out.println(actualData);
		        Assert.assertEquals(actualData, expectedData[i]);
		        Thread.sleep(2000);
		       }
			}			
			
		  	 }
			
//			String expectedData = "Super Admin Administrator for the whole site, Group Admin Supervisor for the Team(s), Agent User that exist in a team, Configuration Manager Can configure settings only, not allowed to listen calls";
//			
//			List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"gvGroups\"]/tbody/tr"));
//			List<ArrayList<String>> rowsData = new ArrayList<ArrayList<String>>();
//
//			for(WebElement row:rows){
//			List<WebElement> rowElements = row.findElements(By.xpath("//*[@id=\"gvGroups\"]/tbody/tr"));
//
//			ArrayList<String> rowData = new ArrayList<String>();
//
//			for(WebElement column:rowElements){
//			    rowData.add(column.getText().toString());
//			}
//
//			rowsData.add(rowData);
//			System.out.println(rowsData);
//			Assert.assertEquals(rowsData, expectedData);
//			}
//			
//			driver.close();
//	}

			
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			


			
			
			
			
			
			
			
			
			
			
			
			
}
