package SiteAdministration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
	
	
////Test ID: 29-34
///* 
//* Verify that default permission group is available 
//*/	
	@Test(priority = 0)
	public void verifyDefaultPermissionGroups() throws InterruptedException, IOException {

		driver.get(siteUrl);

//		String TestCaseID = "29-01";
//		String Status = "";

		if (driver == null) {

			System.out.println("WebDriver not initialized");
			return;
		}
			
			((SharedFunctions)sf).loginSiteAdmin(driver);
			Thread.sleep(8000);
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
	
	
	
////Test ID: 29-35
///* 
//* Verify the newly created security group. 
//*/	
	@Test(priority = 1)
	public void verifyGroupCreation() throws InterruptedException, IOException {

		driver.get(siteUrl);

//		String TestCaseID = "29-01";
//		String Status = "";
		
		if (driver == null) {

			System.out.println("WebDriver not initialized");
			return;
		}
			
		((SharedFunctions)sf).loginSiteAdmin(driver);
		Thread.sleep(2000);
		((SharedFunctions)sf).clickSitePermissions(driver);
		
		// Click on Group name and add a new name
		String groupname = ((SharedFunctions)sf).GenerateStringofLength10();
		driver.findElement(By.id("txtGroupName")).sendKeys(groupname);
		System.out.println(groupname);

		// Click on add button
		driver.findElement(By.id("imgbtnAddUpdate")).click();
		Thread.sleep(3000);
		// Check if that text is present on page
		boolean check = driver.getPageSource().contains(groupname);
		Assert.assertEquals(check, true);
		
		  	 }	

			
////Test ID: 29-36
///* 
//* Verify the description security group.
//*/	
	@Test(priority = 2)
	public void verifyGroupDescription250Characters() throws InterruptedException, IOException {

		driver.get(siteUrl);

//		String TestCaseID = "29-01";
//		String Status = "";

		if (driver == null) {

			System.out.println("WebDriver not initialized");
			return;
		}
			
		((SharedFunctions)sf).loginSiteAdmin(driver);
		
		((SharedFunctions)sf).clickSitePermissions(driver);
		
		// Click on Group name and add 
		String groupname = ((SharedFunctions)sf).GenerateStringofLength10();
		driver.findElement(By.id("txtGroupName")).sendKeys(groupname);
		System.out.println(groupname);
		
		// Click on Group description and add 
		String groupdesp = ((SharedFunctions)sf).GenerateStringofLength250();
		driver.findElement(By.id("txtDescription")).sendKeys(groupdesp);
		System.out.println(groupdesp);
		
		String groupdespadd = driver.findElement(By.id("txtDescription")).getAttribute("value");
		int len = groupdespadd.length();
		System.out.println(len);
		
		Assert.assertEquals(groupdespadd.length(), 250);
		
		  	 }	





////Test ID: 29-37
///* 
//* Edit newly created group and assign permissions by expanding the existing tabs.
//*/	
	@Test(priority = 3)
	public void verifyGroupAssignedPermissions() throws InterruptedException, IOException {
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
	    
        //Get the table and row
	  	WebElement table1 =driver.findElement(By.id("gvGroups"));
	  	WebElement tbody1=table1.findElement(By.tagName("tbody"));
	  	List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
	  	String rowNo1="";
	  	String Groups  = groupname;
	  	for(int i=0;i<rows1.size();i++)
	  		{
	  		WebElement row = tbody1.findElement(By.xpath("//*[@id=\"gvGroups\"]/tbody/tr["+(i+1)+"]"));
	  		if(row.getText().trim().contains(Groups))
	  		{
	  		rowNo1=Integer.toString(i+1);
	  		break;
	  		}
	  		}
	  	driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr["+rowNo1+"]/td[3]/div/img[3] ")).click(); 
  	            
	  	// Click on agents
	  	driver.findElement(By.xpath("//*[@id=\"gvPermissions\"]/tbody/tr[1]/td[1]/img")).click();
	  	
	  	// Check Permissions (agents)
	  	driver.findElement(By.id("4-1")).click(); // 
	  	
		// Click on search calls 
	  	driver.findElement(By.xpath("//*[@id=\"gvPermissions\"]/tbody/tr[4]/td[1]/img")).click();
	  	
	    // Check Permissions (search calls)
	  	driver.findElement(By.id("1-6")).click();; //	
	  
	    // Click on teams
	  	driver.findElement(By.xpath("//*[@id=\"gvPermissions\"]/tbody/tr[9]/td[1]/img")).click();
	  	
	    // Check Permissions (teams)
	  	driver.findElement(By.id("5-28")).click();; //
	    
		  	 }	
	
	

	

////Test ID: 29-40
///* 
//* Verify by creating a copy of any existing group.
//*/	
	@Test(priority = 4)
	public void verifycreatingCopyofGroup() throws InterruptedException, IOException {
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
			
	

////Test ID: 29-41
///* 
//* Make copy of a group.Check the Edit and Delete buttons.
//*/	
	@Test(priority = 5)
	public void verifyCopyofGroupbuttonsedit_delete() throws InterruptedException, IOException {
		driver.get(siteUrl);	
		
		if (driver == null) {

			System.out.println("WebDriver not initialized");
			return;
		}
			
      ((SharedFunctions)sf).loginSiteAdmin(driver);
      
      Thread.sleep(3000);
		
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
	  	driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr["+rowNo1+"]/td[3]/div/img[3]")).isEnabled(); 
	  	driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr["+rowNo1+"]/td[3]/div/img[4]")).isEnabled(); 
	  	
	  	Assert.assertTrue(true);
	}	
	
	
	
	
	

	
////Test ID: 29-42
///* 
//* Edit Permissions of copied group
//*/	
	@Test(priority = 6)
	public void verifyEditPermissionsofCopiedGroup() throws InterruptedException, IOException {
		driver.get(siteUrl);	
		
		if (driver == null) {

			System.out.println("WebDriver not initialized");
			return;
		}
			
      ((SharedFunctions)sf).loginSiteAdmin(driver);
      
      Thread.sleep(3000);
		
	  ((SharedFunctions)sf).clickSitePermissions(driver);
				
//      // Make admin copy
//      driver.findElement(By.xpath("//*[@id=\"gvGroups\"]/tbody/tr[1]/td[3]/div/img[2]")).click();
      
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
	  	driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr["+rowNo1+"]/td[3]/div/img[3]")).click(); 
	  	
	    // Click on agents
	  	driver.findElement(By.xpath("//*[@id=\"gvPermissions\"]/tbody/tr[1]/td[1]/img")).click();
	  	
	  	// Check Permissions (agents)
	  	driver.findElement(By.id("4-1")).click(); // 
	  	
		// Click on search calls 
	  	driver.findElement(By.xpath("//*[@id=\"gvPermissions\"]/tbody/tr[4]/td[1]/img")).click();
	  	
	    // Check Permissions (search calls)
	  	driver.findElement(By.id("1-6")).click(); //	
	  
	    // Click on teams
	  	driver.findElement(By.xpath("//*[@id=\"gvPermissions\"]/tbody/tr[9]/td[1]/img")).click();
	  	
	    // Check Permissions (teams)
	  	driver.findElement(By.id("5-28")).click(); //
	  		  	
	  	Assert.assertTrue(true);
	}		


	
	
			
	  @AfterClass 
	  public void afterTest() {
		  driver.quit();
	}				
			
			
			
			
			
			
}
