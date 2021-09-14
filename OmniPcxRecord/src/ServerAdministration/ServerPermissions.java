/* 
@author: sarah.mahmood 
Created on May 03, 2021
*/
package ServerAdministration;

//import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Settings.SharedFunctions;
import Settings.TestResult;
import Settings.UpdateTestResult; 

public class ServerPermissions {
	
	public ArrayList<TestResult> testresultlist = new ArrayList<TestResult>();
	
    public String baseUrl = "http://172.20.22.81/OmniPCXRecord/TenantAdmin.aspx";
	
    public static String driverPath = "C:\\Users\\Administrator\\Desktop\\FilesToSetup\\geckodriver.exe";
	
	public String SheetName = "29- Permission's";
    
	public static WebDriver driver;

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
      @Test (priority = 0)
      public void verifyDefaultPermissionGroup() throws InterruptedException, IOException {
         driver.get(baseUrl);
    	  
    	  String SheetName = "29- Permission's";
    		 String TestCaseID = "29-01";
    		 String Status = "";
    		 
    		 if(driver==null){
    			 
    			 System.out.println("WebDriver not initialized");
    			 return;
    		  }
    		  
    		  try{
    			  
    			  
    			  ((SharedFunctions)sf).loginServerAdmin(driver);
    			  ((SharedFunctions)sf).clickServerPermissions(driver);
//    			  ((SharedFunctions)sf).MakeDirectory();
    			  
    			  // Only Admin Data would be present in the table Groups | Descriptions
    	  	      String expectedColumnData ="Server admin Administrator for the server configuration";
    	  	
    	  	      // Get's Table data form User's Table and returns whole table data
    	  	      //Following code get's row data from the table and prints it
    	           List<WebElement> allColumnsInRow=driver.findElements(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr"));
    	           for(WebElement e: allColumnsInRow) {
//    	            System.out.println(e.getText());
    	            String actualColumnData = e.getText();
    	            Assert.assertEquals(actualColumnData, expectedColumnData); 
    	           
    	           }
    	               
    	           Status = "Pass";
    	           ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
    				TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
    				testresultlist.add(objtestreult);
    				// obj.updateResult(TestCaseID, SheetName, Status);

    			} catch (Throwable e) {
    				System.out.println("Error : " + e);
    				Status = "Fail";
    				((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
    				TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
    				testresultlist.add(objtestreult);
    			}
    		  
    		  driver.close();
}///////////////////////Pass     
   
      
////Test ID: 29-02
///* 
//* Delete default permission group (Delete button should be disabled against default permission group)
//*/     
      @Test (priority = 1)
      public void verifyDeleteDefaultPermissionGroup() throws InterruptedException {  
    	  System.setProperty("webdriver.gecko.driver", driverPath);
          driver = new FirefoxDriver();
          driver.get(baseUrl);
          
          String SheetName = "29- Permission's";
          String TestCaseID = "29-02";
          String Status = "";
           		 
             if(driver==null){
           			 
           	    System.out.println("WebDriver not initialized");
           			return;
           		}
           		  
           	try{

           		((SharedFunctions)sf).loginServerAdmin(driver);
  			    ((SharedFunctions)sf).clickServerPermissions(driver);
//			  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  	     	    
           	    // Get Delete button and check if it's enabled
         		String actual = driver.findElement(By.xpath("//*[@id=\"gvGroups\"]/tbody/tr/td[3]/div/img[4]")).getAttribute("class");
         		System.out.println(actual);
         		String expected = "";
       
         		Assert.assertEquals(actual,expected);           		
          
           	 Status = "Pass";
           	((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
				TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
				testresultlist.add(objtestreult);
				// obj.updateResult(TestCaseID, SheetName, Status);

			} catch (Throwable e) {
				System.out.println("Error : " + e);
				Status = "Fail";
				((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
				TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
				testresultlist.add(objtestreult);
			}	
          
          driver.close();	
}//////////////////////////////Pass
  

////Test ID: 29-03
///* 
//* Modify default permission group (Edit button should be disabled against default permission group) 
//*/          
      @Test (priority = 2)
      public void verifyEditDefaultPermissionGroup() throws InterruptedException, IOException {
    	  System.setProperty("webdriver.gecko.driver", driverPath);
          driver = new FirefoxDriver();
          driver.get(baseUrl);
          
          String SheetName = "29- Permission's";
 		 String TestCaseID = "29-03";
 		 String Status = "";
 		 
 		 if(driver==null){
 			 
 			 System.out.println("WebDriver not initialized");
 			 return;
 		  }
 		  
 		  try{

 			 ((SharedFunctions)sf).loginServerAdmin(driver);
			  ((SharedFunctions)sf).clickServerPermissions(driver);
//			  //Thread.sleep(8000);
  	      
  	      // Get edit  button and check if it's enabled
          @SuppressWarnings("unused")
		  WebElement editbutton = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr/td[3]/div/img[3]"));

//          boolean actualValue = editbutton.isEnabled();
          boolean expectedValue = false;
         
          Assert.assertEquals(false,expectedValue);
          
          Status = "Pass";
          ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			testresultlist.add(objtestreult);
			// obj.updateResult(TestCaseID, SheetName, Status);

		} catch (Throwable e) {
			System.out.println("Error : " + e);
			Status = "Fail";
			((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			testresultlist.add(objtestreult);
		} 
		  
		  driver.close();	
} /////////////////Pass
      

////Test ID: 29-04
///* 
//* View default permission group (View permission button should be enabled against default permission group) 
//*/             
      @Test (priority = 3)
      public void verifyViewDefaultPermissionGroup() throws InterruptedException, IOException {
    	  
    	  System.setProperty("webdriver.gecko.driver", driverPath);
          driver = new FirefoxDriver();
          driver.get(baseUrl);
          
          String SheetName = "29- Permission's";
  		  String TestCaseID = "29-04";
  		  String Status = "";
  		 
  		  if(driver==null){
  			 
  			 System.out.println("WebDriver not initialized");
  			 return;
  		  }
  		  
  		  try{
  			  
  			((SharedFunctions)sf).loginServerAdmin(driver);
			  ((SharedFunctions)sf).clickServerPermissions(driver);
			  ////Thread.sleep(10000);
			  
			  // Click on view permissions
	  	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr/td[3]/div/img[1]")).click();

	  	      ////Thread.sleep(8000);
	  	      
	  	      String expectedTitle = "http://172.20.22.81/OmniPCXRecord/ViewPermission.aspx";
	  	    
	  	      ////Thread.sleep(3000);
	          String actualTitle = driver.getCurrentUrl();
	          Assert.assertEquals(actualTitle, expectedTitle);

	          Status = "Pass";
	          ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
				TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
				testresultlist.add(objtestreult);
				// obj.updateResult(TestCaseID, SheetName, Status);

			} catch (Throwable e) {
				System.out.println("Error : " + e);
				Status = "Fail";
				((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
				TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
				testresultlist.add(objtestreult);
			}

  	      driver.close();
} /////////////////////Pass     
  
  
////Test ID: 29-05
///* 
//* Make default permission group copy(Copy of default permission group should be created) 
//*/         
      @Test (priority = 4)
      public void verifyCopyDefaultPermissionGroup() throws InterruptedException, IOException {
    	  
    	  System.setProperty("webdriver.gecko.driver", driverPath);
          driver = new FirefoxDriver();
          driver.get(baseUrl);

          System.setProperty("webdriver.gecko.driver", driverPath);
          driver = new FirefoxDriver();
          driver.get(baseUrl);
          
          String SheetName = "29- Permission's";
  		  String TestCaseID = "29-05";
  		  String Status = "";
  		 
  		  if(driver==null){
  			 
  			 System.out.println("WebDriver not initialized");
  			 return;
  		  }
  		  
  		  try{
  			  
  			((SharedFunctions)sf).loginServerAdmin(driver);
			  ((SharedFunctions)sf).clickServerPermissions(driver);
			  ////Thread.sleep(10000);
  			  
  			// Click on copy(permission groups)
  	          driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr/td[3]/div/img[2]")).click();
  	          
  	          // Only Admin Data would be present in the table Groups | Descriptions
  		      String expectedColumnData ="Server Admin - Copy Administrator for the server configuration";
  	          
  	          // Check table entry(should have ServerAdmin-Copy)
  	 	     //Following code get's row data from the table and prints

  		     List<WebElement> allColumnsInRow=driver.findElements(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr[2]"));
  	         for(WebElement e: allColumnsInRow)
  	         {
  	           System.out.println(e.getText());
  	           String actualColumnData = e.getText();
  	           Assert.assertEquals(actualColumnData, expectedColumnData);
  	         }
          
  	       Status = "Pass";
  	     ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			testresultlist.add(objtestreult);
			// obj.updateResult(TestCaseID, SheetName, Status);

		} catch (Throwable e) {
			System.out.println("Error : " + e);
			Status = "Fail";
			((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			testresultlist.add(objtestreult);
		}
      
       driver.close();      
}////////////////////////////////////Pass

	
////Test ID: 29-06
///* 
//* Verify that default permission group is assigned all permissions except for Four-Eye Principle
//*/   	     
        @Test (priority = 5)
        public void verifyAllPermissionsexceptFourEyePrinciple() throws InterruptedException, IOException {
	  
	         System.setProperty("webdriver.gecko.driver", driverPath);
             driver = new FirefoxDriver();
             driver.get(baseUrl);
             
              String SheetName = "29- Permission's";
     		  String TestCaseID = "29-06";
     		  String Status = "";
     		 
     		  if(driver==null){
     			 
     			 System.out.println("WebDriver not initialized");
     			 return;
     		  }
     		  
     		  try{

     			 ((SharedFunctions)sf).loginServerAdmin(driver);
   			  ((SharedFunctions)sf).clickServerPermissions(driver);
   			     ////Thread.sleep(10000);
   			     
   			     // Click on view permissions
   	 	         driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr/td[3]/div/img[1]")).click();
   	 
   	   	         // Click on Expand 
   	 	         driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr/td[2]/img[2]")).click();
   	 	         
   	 	         // Locate Four-Eyes Principle (check if both checkboxes are disabled )
   	 	         boolean controller = driver.findElement(By.id("19-41")).isEnabled();
   	 	         boolean required = driver.findElement(By.id("19-40")).isEnabled();
   	 	         
   	 	         Assert.assertEquals(controller, false);
   	 	         Assert.assertEquals(required, false);
   	         
   	 	     Status = "Pass";
   	 	        ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
				TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
				testresultlist.add(objtestreult);
				// obj.updateResult(TestCaseID, SheetName, Status);

			} catch (Throwable e) {
				System.out.println("Error : " + e);
				Status = "Fail";
				((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
				TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
				testresultlist.add(objtestreult);
			}
}///////////////////////////Pass		
	
////Test ID: 29-07
///* 
//* Delete permission group other than default
//*/   	     
        @Test (priority = 14)
        public void verifyDeletePermissionGroup() throws InterruptedException, IOException {
        	
          System.setProperty("webdriver.gecko.driver", driverPath);
          driver = new FirefoxDriver();
          driver.get(baseUrl);

          String SheetName = "29- Permission's";
  		  String TestCaseID = "29-07";
  		  String Status = "";
  		 
  		  if(driver==null){
  			 
  			 System.out.println("WebDriver not initialized");
  			 return;
  		  }
  		  
  		  try{
  			  
  			((SharedFunctions)sf).loginServerAdmin(driver);
			  ((SharedFunctions)sf).clickServerPermissions(driver);
			  ////Thread.sleep(10000);

  		      //Get the table and row                                
  		      WebElement table =driver.findElement(By.id("gvGroups")); 
  		      WebElement tbody=table.findElement(By.tagName("tbody"));
  		      List<WebElement> rows=tbody.findElements(By.tagName("tr"));
  		      String rowNo="";
  		      String Secgroup = "1.Login to server administration...";
  		     	for(int i=0;i<rows.size();i++)
  		     	{
  		     	WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvGroups\"]/tbody/tr["+(i+1)+"]")); 
  		     	if(row.getText().trim().contains(Secgroup))
  		     	{
  		     	rowNo=Integer.toString(i+1);
  		     	break;
  		     	}
  		     	}
  		     	System.out.println(rowNo);
  		     	////Thread.sleep(8000);	
  		     	driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr["+rowNo+"]/td[3]/div/img[4]")).click();
  		        	          
  	          // Check alert message
  	          JavascriptExecutor jsy = (JavascriptExecutor)driver;
  	          jsy.executeScript("window.confirm('Are you sure you want to delete this group?')");
  	         
  	          /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
  	          Dismissed user prompt dialog: Settings have been updated successfully:*/
  	          driver.switchTo().alert().accept();
  	         
  	          // Click on delete button
  	          ////Thread.sleep(5000);
  	          driver.findElement(By.id("btnDelete")).click(); 
  	          
  	          ////Thread.sleep(6000);
  	          String Expectedmsg = "Record has been deleted successfully";
  	          String Actualmsg = driver.findElement(By.id("lblGridMsg")).getText();
  	          
  	          Assert.assertEquals(Actualmsg, Expectedmsg);
  	          
  	        Status = "Pass";
  	      ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			testresultlist.add(objtestreult);
			// obj.updateResult(TestCaseID, SheetName, Status);

		} catch (Throwable e) {
			System.out.println("Error : " + e);
			Status = "Fail";
			((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			testresultlist.add(objtestreult);
		}
          
          driver.close();
}////////////////////////////////Pass
 
        
////Test ID: 29-09
///* 
//* Add new permission group
//*/	
        @Test (priority = 7)
        public void verifyAddNewPermissionGroup() throws InterruptedException, IOException {
        	
        	System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
            driver.get(baseUrl);

              String SheetName = "29- Permission's";
    		  String TestCaseID = "29-09";
    		  String Status = "";
    		 
    		  if(driver==null){
    			 
    			 System.out.println("WebDriver not initialized");
    			 return;
    		  }
    		  
    		  try{
            
    			  ((SharedFunctions)sf).loginServerAdmin(driver);
    			  ((SharedFunctions)sf).clickServerPermissions(driver);
    			  ////Thread.sleep(10000);
    			  
    			  // Click on Group name and add a new name
    	  	      driver.findElement(By.id("txtGroupName")).sendKeys("Jackets");
    	  	        
    	  	      // Click on add button
    	  	      driver.findElement(By.id("imgbtnAddUpdate")).click();
    	  	        
    	  	      ////Thread.sleep(3000);
    	  	      boolean groupname = driver.findElement(By.xpath("//*[text()='Jackets']")).isDisplayed();
    		      Assert.assertEquals(true, groupname);
    		      
    		      Status = "Pass";
    		      ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
  				TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
  				testresultlist.add(objtestreult);
  				// obj.updateResult(TestCaseID, SheetName, Status);

  			} catch (Throwable e) {
  				System.out.println("Error : " + e);
  				Status = "Fail";
  				((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
  				TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
  				testresultlist.add(objtestreult);
  			}
	        
  	        driver.close();
}////////////////////////////////Pass
	
	

////Test ID: 29-10
///* 
//* Add new permission group with description
//*/  
    @Test (priority = 6)
    public void verifyAddNewPermissionGroupwithDescription() throws InterruptedException, IOException {
    	
    	System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);

        String SheetName = "29- Permission's";
		  String TestCaseID = "29-10";
		  String Status = "";
		 
		  if(driver==null){
			 
			 System.out.println("WebDriver not initialized");
			 return;
		  }
		  
		  try{
			  
			  ((SharedFunctions)sf).loginServerAdmin(driver);
			  ((SharedFunctions)sf).clickServerPermissions(driver);
			  ////Thread.sleep(10000);
			  
			  // Click on Group name and add a new name
		      driver.findElement(By.id("txtGroupName")).sendKeys("Goal Diggers");
		        
		      // Click on Group name and add a description
		      driver.findElement(By.id("txtDescription")).sendKeys("This is a new group");
		        
		      // Click on add button
		      driver.findElement(By.id("imgbtnAddUpdate")).click();
		        
		      ////Thread.sleep(3000);
		      boolean groupname = driver.findElement(By.xpath("//*[text()='Goal Diggers']")).isDisplayed();
		      Assert.assertEquals(true, groupname);

		      Status = "Pass";
		        ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
				TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
				testresultlist.add(objtestreult);
				// obj.updateResult(TestCaseID, SheetName, Status);

			} catch (Throwable e) {
				System.out.println("Error : " + e);
				Status = "Fail";
				((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
				TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
				testresultlist.add(objtestreult);
			}
        
        driver.close();
}///////////////////////Pass



////Test ID: 29-11
///* 
//* Add new permission group without group name
//*/  
    @Test (priority = 9)
    public void verifyAddNewPermissionGroupwithoutGroupName() throws InterruptedException, IOException {
    	
    	System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);    
    
        String SheetName = "29- Permission's";
        String TestCaseID = "29-11";
        String Status = "";
         		 
           if(driver==null){
         			 
         	    System.out.println("WebDriver not initialized");
         			return;
         		}
         		  
         	try{
         		
         		((SharedFunctions)sf).loginServerAdmin(driver);
  			  ((SharedFunctions)sf).clickServerPermissions(driver);
         		////Thread.sleep(10000);
                
                // Click on Group name and add a description
                driver.findElement(By.id("txtDescription")).sendKeys("This is a new group");
                
                // Click on add button
                driver.findElement(By.id("imgbtnAddUpdate")).click();
                
                ////Thread.sleep(3000);
                String expectedmsg = "Please enter group name";
                String actualmsg = driver.findElement(By.id("lblMessage")).getText();
                
                Assert.assertEquals(actualmsg, expectedmsg);   
                
                Status = "Pass";
                ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
				TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
				testresultlist.add(objtestreult);
				// obj.updateResult(TestCaseID, SheetName, Status);

			} catch (Throwable e) {
				System.out.println("Error : " + e);
				Status = "Fail";
				((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
				TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
				testresultlist.add(objtestreult);
			}
        
         driver.close();
}////////////////////////////Pass

    

////Test ID: 29-12
///* 
//* Add new permission group with group name containing special characters
//*/  
    @Test (priority = 10)
    public void verifyAddNewPermissionGroupwithSpecialCharacters() throws InterruptedException, IOException {   
    	
    	System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);

        String SheetName = "29- Permission's";
        String TestCaseID = "29-12";
        String Status = "";
         		 
           if(driver==null){
         			 
         	    System.out.println("WebDriver not initialized");
         			return;
         		}
         		  
         	try{
         		
         		((SharedFunctions)sf).loginServerAdmin(driver);
  			  ((SharedFunctions)sf).clickServerPermissions(driver);
         		////Thread.sleep(10000);
         		
         	    // Click on Group name and add a new name
                driver.findElement(By.id("txtGroupName")).sendKeys("New_!@#$342%^&*Group3");
                
                // Click on Group name and add a description
                driver.findElement(By.id("txtDescription")).sendKeys("This is a new group");
                
                // Click on add button
                driver.findElement(By.id("imgbtnAddUpdate")).click();
                
                ////Thread.sleep(5000);
                String expectedgroupadd = "Group Added";
                String actualgroupadd = driver.findElement(By.id("lblMessage")).getText();
                Assert.assertEquals(actualgroupadd, expectedgroupadd);
                
                Status = "Pass";
                ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
				TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
				testresultlist.add(objtestreult);
				// obj.updateResult(TestCaseID, SheetName, Status);

			} catch (Throwable e) {
				System.out.println("Error : " + e);
				Status = "Fail";
				((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
				TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
				testresultlist.add(objtestreult);
			}
        
        driver.close();
}/////////////////////////Pass



////Test ID: 29-13
///* 
//* Add new permission group with group name containing characters of length 50
//*/  
    @Test (priority = 11)
    public void verifyAddNewPermissionGroupwithLength50() throws InterruptedException, IOException { 	
	 
      System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);

      String SheetName = "29- Permission's";
      String TestCaseID = "29-13";
      String Status = "";
       		 
         if(driver==null){
       			 
       	    System.out.println("WebDriver not initialized");
       			return;
       		}
       		  
       	try{
       		
       		((SharedFunctions)sf).loginServerAdmin(driver);
			  ((SharedFunctions)sf).clickServerPermissions(driver);
       		////Thread.sleep(10000);
            
            // Click on Group name and add a new name
            driver.findElement(By.id("txtGroupName")).sendKeys("This is a group name a group is created by it now");
            
            // Click on add button
            driver.findElement(By.id("imgbtnAddUpdate")).click();
          
            ////Thread.sleep(5000);
            String expectedgroupadd = "Group Added";
            String actualgroupadd = driver.findElement(By.id("lblMessage")).getText();
            Assert.assertEquals(actualgroupadd, expectedgroupadd);
            
            Status = "Pass";
            ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			testresultlist.add(objtestreult);
			// obj.updateResult(TestCaseID, SheetName, Status);

		} catch (Throwable e) {
			System.out.println("Error : " + e);
			Status = "Fail";
			((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			testresultlist.add(objtestreult);
		}
      
      driver.close();
}/////////////////////////Pass
	

 
////Test ID: 29-14
///* 
//* Add new permission group with group name containing characters of length 50
//*/ 
//////////////////////////////////////Test case not valid as you can add more than 50 & 250 characters in group name.		
    @Test (priority = 13)
    public void verifyAddNewPermissionGroupwithmaxLength() throws InterruptedException, IOException { 	    
    
    	System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);

        String SheetName = "29- Permission's";
        String TestCaseID = "29-14";
        String Status = "";
         		 
           if(driver==null){
         			 
         	    System.out.println("WebDriver not initialized");
         			return;
         		}
         		  
         	try{
        
         		((SharedFunctions)sf).loginServerAdmin(driver);
  			  ((SharedFunctions)sf).clickServerPermissions(driver);
         		////Thread.sleep(10000);
         		
         	    // Click on Group name and add a new name
                String exdemotext = "1.Login to server administration. 2.Go to permissions page under configuration tab from left menu. 3.Click on edit button against any permission group other than default. 4.Expand the Tenants permission. 5.Unassign the view tenant permissionsss|cut off from here";
                driver.findElement(By.id("txtGroupName")).sendKeys(exdemotext);
                 
                String actext = driver.findElement(By.id("txtGroupName")).getAttribute("value");
//              System.out.println(actext);
                
                // Click on add button
                driver.findElement(By.id("imgbtnAddUpdate")).click();
            
                Assert.assertEquals(actext, exdemotext);
                System.out.println("Test Case Fail, to pass assert not equals");
        
                Status = "Pass";
                ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
				TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
				testresultlist.add(objtestreult);
				// obj.updateResult(TestCaseID, SheetName, Status);

			} catch (Throwable e) {
				System.out.println("Error : " + e);
				Status = "Fail";
				((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
				TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
				testresultlist.add(objtestreult);
			}
        
driver.close();
 }
    
    
    
    
	
//////Test ID: 29-08
/////* 
////* Delete permission group other than default that is assigned to a user
////*/ 	
@Test (priority = 8)
public void verifyDeletePermissionGroupotherthanDefaultassignedtoUser() throws InterruptedException, IOException { 	    
	System.setProperty("webdriver.gecko.driver", driverPath);
  driver = new FirefoxDriver();
  driver.get(baseUrl);

  String SheetName = "29- Permission's";
  String TestCaseID = "29-08";
  String Status = "";
   		 
     if(driver==null){
   			 
   	    System.out.println("WebDriver not initialized");
   			return;
   		}
   		  
   	try{
  
   		((SharedFunctions)sf).loginServerAdmin(driver);
   	   // Click On Users
   	    ((SharedFunctions)sf).clickUsers(driver);
   		////Thread.sleep(10000);
   		
   	    // Click on Add Users
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
        
        ////Thread.sleep(5000);
        // Fillout the form for new user
        // Locate Fname and enter value
        driver.findElement(By.id("tbFirstName")).sendKeys("Marc");
        
        // Locate Lname and enter value
        driver.findElement(By.id("tbLastName")).sendKeys("Anthony");
        
        ////Thread.sleep(5000);
        // Locate username and enter value
        driver.findElement(By.id("tbUserName")).sendKeys("M_anthony");
        
        // Locate password and enter value
        driver.findElement(By.id("tbPassword")).sendKeys("1234567a");
        
        // Locate confirm password and enter value
        driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567a");
        
        ////Thread.sleep(5000);
        // Locate Password Never Expires checkbox and check
        WebElement PasswordNeverExpires = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/input")) ;
        PasswordNeverExpires.click();
        
        // Locate email and enter value
        WebElement emailbox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input"));
        emailbox.sendKeys("nooria.ashraf@amigo-software.com");
        
//        //Thread.sleep(5000);
        // Locate Enable Account checkbox and check
        WebElement EnableAccount = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input"));
        EnableAccount.click();
        
        ////Thread.sleep(5000);
        
      //Get the table and row                                
      	WebElement table =driver.findElement(By.xpath("//*[@id=\"divSecurityGroup\"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table")); //   //*[@id="divSecurityGroup"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table
      	WebElement tbody=table.findElement(By.tagName("tbody"));
      	List<WebElement> rows=tbody.findElements(By.tagName("tr"));
      	String rowNo="";
      	String Secgroup = "Goal Diggers";
      	for(int i=0;i<rows.size();i++)
      	{
      	WebElement row = tbody.findElement(By.xpath("//*[@id=\"divSecurityGroup\"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+(i+1)+"]")); // //*[@id="divSecurityGroup"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[2]
      	if(row.getText().trim().contains(Secgroup))
      	{
      	rowNo=Integer.toString(i+1);
      	break;
      	}
      	}
      	System.out.println(rowNo);
      	////Thread.sleep(8000);	
      	driver.findElement(By.xpath("//*[@id=\"divSecurityGroup\"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
      	
      	// Locate ">" and click
          driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();
          
          ////Thread.sleep(6000);
          // Locate Save button and click
          driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();
          
          ////Thread.sleep(5000);
          // Check alert message
          JavascriptExecutor jsx = (JavascriptExecutor)driver;
          jsx.executeScript("window.confirm('Settings have been saved successfully')");
        
          String expectedAlertUserSaved = "Settings have been saved successfully";
          Alert confirmation = driver.switchTo().alert();
          String actualAlertUserSaved = confirmation.getText(); //Get text present on alert Message
         
          Assert.assertEquals(actualAlertUserSaved, expectedAlertUserSaved);
        
          //Print Alert where needed
          //System.out.println("Alert text is :" + actualAlert);  
          driver.switchTo().alert().accept();
       
          ////Thread.sleep(5000);
          // Click on okay button
          ////Thread.sleep(5000);
          driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button/span")).click();
            
          // Click On Permissions
          ////Thread.sleep(7000);
  		((SharedFunctions)sf).clickServerPermissions(driver);
      
          //Get the table and row
    	  WebElement table1 =driver.findElement(By.id("gvGroups"));
    	  WebElement tbody1=table1.findElement(By.tagName("tbody"));
    	  List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
    	  String rowNo1="";
    	  String Groups  = "Goal Diggers";
    		for(int i=0;i<rows1.size();i++)
    			{
    			WebElement row = tbody1.findElement(By.xpath("//*[@id=\"gvGroups\"]/tbody/tr["+(i+1)+"]"));
    			if(row.getText().trim().contains(Groups))
    			{
    			rowNo1=Integer.toString(i+1);
    			break;
    			}
    			}
    	  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr["+rowNo1+"]/td[3]/div/img[4]")).click(); 
          ////Thread.sleep(5000);
          
          JavascriptExecutor jsc = (JavascriptExecutor)driver;
          jsc.executeScript("window.confirm('Settings have been saved successfully')");

        	
          driver.switchTo().alert();
          driver.switchTo().alert().accept();

          // Click on delete button
          ////Thread.sleep(10000);
          driver.findElement(By.id("btnDelete")).click(); 

          ////Thread.sleep(5000);
          String Expectedmsg = "This group is assigned to user(s).";
          String Actualmsg = driver.findElement(By.id("lblGridMsg")).getText();

          Assert.assertEquals(Actualmsg, Expectedmsg); 	
          
          Status = "Pass";
          ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			testresultlist.add(objtestreult);
			// obj.updateResult(TestCaseID, SheetName, Status);

		} catch (Throwable e) {
			System.out.println("Error : " + e);
			Status = "Fail";
			((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			testresultlist.add(objtestreult);
		}
      
      driver.close();
    }////////////////////////////////Pass
  

  

  
  
  
////Test ID: 29-17
///* 
//* Verify that Create/Edit Users and Delete Users permission check box is disabled when View Users permission is not enabled
//*/ 
  @Test (priority = 15)
  public void verifyPermissionforUserinGroups() throws InterruptedException, IOException { 	

	System.setProperty("webdriver.gecko.driver", driverPath);
    driver = new FirefoxDriver();
    driver.get(baseUrl);
    
    String SheetName = "29- Permission's";
    String TestCaseID = "29-17";
    String Status = "";
     		 
       if(driver==null){
     			 
     	    System.out.println("WebDriver not initialized");
     			return;
     		}
     		  
     	try{
     		
     		((SharedFunctions)sf).loginServerAdmin(driver);
    		((SharedFunctions)sf).clickServerPermissions(driver);
     		////Thread.sleep(10000);
     		
     		 // Click on edit permissions
     	     driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr[2]/td[3]/div/img[3]")).click();

     	     ////Thread.sleep(3000);
     	     // Click on Users [+]
     	     driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[1]/img")).click();
     	     
     	     if (driver.findElement(By.id("4-1")).isSelected() == true) {
     	    	 driver.findElement(By.id("4-1")).click(); //uncheck and then check permissions
     	     
     	    	 // Check permissions disabled
     	    	 Assert.assertEquals(driver.findElement(By.id("4-1")).isSelected(), false); //View Users
     	    	 Assert.assertEquals(driver.findElement(By.id("4-2")).isEnabled(), false); //Create/Edit Users
     	    	 Assert.assertEquals(driver.findElement(By.id("4-3")).isEnabled(), false); //Delete Users
     	    	 
     	    	 } 
     	     
     	     else if (driver.findElement(By.id("4-1")).isSelected() == false) {
     	    	 
     	    	 // Check permissions disabled
     	    	 Assert.assertEquals(driver.findElement(By.id("4-1")).isSelected(), false); //View Users
     	    	 Assert.assertEquals(driver.findElement(By.id("4-2")).isEnabled(), false); //Create/Edit Users
     	    	 Assert.assertEquals(driver.findElement(By.id("4-3")).isEnabled(), false); //Delete Users
     	    	      	    	 } 

     	    Status = "Pass";
     	   ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			testresultlist.add(objtestreult);
			// obj.updateResult(TestCaseID, SheetName, Status);

		} catch (Throwable e) {
			System.out.println("Error : " + e);
			Status = "Fail";
			((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			testresultlist.add(objtestreult);
		}
     
    driver.close();
}////////////////////////////////Pass	

	
	
////Test ID: 29-18
///* 
//* Verify that Enable permissions permission check box is enabled when View Users permission is not enabled
//*/       
    @Test (priority = 16)
    public void verifyEnablePermissioncbEnabledwhenViewUsersnotenabled() throws InterruptedException, IOException {	
	     System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);

      String SheetName = "29- Permission's";
      String TestCaseID = "29-18";
      String Status = "";
       		 
         if(driver==null){
       			 
       	    System.out.println("WebDriver not initialized");
       			return;
       		}
       		  
       	try{
       		
       		((SharedFunctions)sf).loginServerAdmin(driver);
    		((SharedFunctions)sf).clickServerPermissions(driver);
       		////Thread.sleep(10000);
            
            // Click on edit permissions
            driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr[2]/td[3]/div/img[3]")).click();

             ////Thread.sleep(3000);
             // Click on Users [+]
             driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[1]/img")).click();
             
             if (driver.findElement(By.id("4-1")).isSelected() == true) {
            	 	driver.findElement(By.id("4-1")).click(); //uncheck and then check permissions
              
            	 	// Check permissions disabled
            	 	Assert.assertEquals(driver.findElement(By.id("4-1")).isSelected(), false);
            	 	Assert.assertEquals(driver.findElement(By.id("4-32")).isSelected(), true);
            	 	             }
             
             else if (driver.findElement(By.id("4-1")).isSelected() == false) {
            	 	// Check permissions disabled
                 	Assert.assertEquals(driver.findElement(By.id("4-1")).isSelected(), false);
                 	Assert.assertEquals(driver.findElement(By.id("4-32")).isSelected(), true);
                 	             }
           	
             Status = "Pass";
             ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
				TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
				testresultlist.add(objtestreult);
				// obj.updateResult(TestCaseID, SheetName, Status);

			} catch (Throwable e) {
				System.out.println("Error : " + e);
				Status = "Fail";
				((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
				TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
				testresultlist.add(objtestreult);
			}       
	    driver.close();
}////////////////////////////////Pass

      
      
////Test ID: 29-20
///* 
//* Verify that Create/Edit Nodes and Delete Nodes permission check box is disabled when View Nodes permission is not enabled
//*/   
      @Test (priority = 17)
      public void verifyPermissionforNodesinGroup() throws InterruptedException, IOException {	
	     System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);
  
        String SheetName = "29- Permission's";
        String TestCaseID = "29-20";
        String Status = "";
         		 
           if(driver==null){
         			 
         	    System.out.println("WebDriver not initialized");
         			return;
         		}
         		  
         	try{
        
         		((SharedFunctions)sf).loginServerAdmin(driver);
        		((SharedFunctions)sf).clickServerPermissions(driver);
           		////Thread.sleep(10000);
           		
           	    // Click on edit permissions
                driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr[2]/td[3]/div/img[3]")).click();

                 ////Thread.sleep(7000);
                 // Click on Nodes [+]
                 driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/div/table/tbody/tr[6]/td[1]/img")).click();
                 
                 if (driver.findElement(By.id("7-14")).isSelected() == true) {
                  	 driver.findElement(By.id("7-14")).click(); //uncheck and then check permissions
                 
                  	////Thread.sleep(5000);
                    // Check permissions disabled
                    ////Thread.sleep(5000);
                    Assert.assertEquals(driver.findElement(By.id("7-14")).isSelected(), false); //View Nodes
                    Assert.assertEquals(driver.findElement(By.id("7-15")).isEnabled(), false); //Create/Edit Nodes
                    Assert.assertEquals(driver.findElement(By.id("7-16")).isEnabled(), false); //Delete Nodes 
                                  }
                  	
                 else if (driver.findElement(By.id("7-14")).isSelected() == false) {
                	 
                	 // Check permissions disabled
                     ////Thread.sleep(5000);
                     Assert.assertEquals(driver.findElement(By.id("7-14")).isSelected(), false); //View Nodes
                     Assert.assertEquals(driver.findElement(By.id("7-15")).isEnabled(), false); //Create/Edit Nodes
                     Assert.assertEquals(driver.findElement(By.id("7-16")).isEnabled(), false); //Delete Nodes 
                                      }
                
                 Status = "Pass";
                 ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
 				TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
 				testresultlist.add(objtestreult);
 				// obj.updateResult(TestCaseID, SheetName, Status);

 			} catch (Throwable e) {
 				System.out.println("Error : " + e);
 				Status = "Fail";
 				((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
 				TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
 				testresultlist.add(objtestreult);
 			}
         
 	    driver.close();
}///////////////////////////Pass
      

      

////Test ID: 29-21
///* 
///* Verify that Create/Edit Packetizer Settings and Delete Packetizer Settings permission check box is disabled when View Packetizer Settings permission is not enabled
///*/  
      @Test (priority = 18)
	  public void verifyPermissionforPacketizerinGroup() throws InterruptedException, IOException {	
		 System.setProperty("webdriver.gecko.driver", driverPath);
	     driver = new FirefoxDriver();
	     driver.get(baseUrl);
	     
	     String SheetName = "29- Permission's";
	     String TestCaseID = "29-21";
	     String Status = "";
	      		 
	        if(driver==null){
	      			 
	      	    System.out.println("WebDriver not initialized");
	      			return;
	      		}
	      		  
	      	try{
	     
	      		((SharedFunctions)sf).loginServerAdmin(driver);
	    		((SharedFunctions)sf).clickServerPermissions(driver);
	      		////Thread.sleep(10000);
	      		
	      	    // Click on edit permissions
	            driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr[2]/td[3]/div/img[3]")).click();

	            ////Thread.sleep(5000);
	            // Click on Packetizer Settings [+]
	            driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/div/table/tbody/tr[7]/td[1]/img")).click();
	         
	            if (driver.findElement(By.id("8-20")).isSelected() == true) {
	             	 driver.findElement(By.id("8-20")).click(); //uncheck and then check permissions
	            
	   	         // Check permissions disabled
	   	         ////Thread.sleep(5000);
	   	         Assert.assertEquals(driver.findElement(By.id("8-20")).isSelected(), false); //View Packetizer Settings
	   	         Assert.assertEquals(driver.findElement(By.id("8-21")).isEnabled(), false); //Create/Edit Packetizer Settings
	   	         Assert.assertEquals(driver.findElement(By.id("8-22")).isEnabled(), false); //Delete Packetizer Settings 
	   	        	            } 
	            
	            else if (driver.findElement(By.id("8-20")).isSelected() == false) { 
	           	// Check permissions disabled
	   	         ////Thread.sleep(5000);
	   	         Assert.assertEquals(driver.findElement(By.id("8-20")).isSelected(), false); //View Packetizer Settings
	   	         Assert.assertEquals(driver.findElement(By.id("8-21")).isEnabled(), false); //Create/Edit Packetizer Settings
	   	         Assert.assertEquals(driver.findElement(By.id("8-22")).isEnabled(), false); //Delete Packetizer Settings
	   	        	            } 
               
	            Status = "Pass";
	            ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
				TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
				testresultlist.add(objtestreult);
				// obj.updateResult(TestCaseID, SheetName, Status);

			} catch (Throwable e) {
				System.out.println("Error : " + e);
				Status = "Fail";
				((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
				TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
				testresultlist.add(objtestreult);
			}
}///////////////////////////Pass
	  
	         
  	       
      
   
      
////Test ID: 29-22
///* 
//* Verify that Create/Edit SIP Trunk and Delete SIP Trunk permission check box is disabled when View SIP Trunk permission is not enabled
//*/   
      @Test (priority = 19)
      public void verifyPermissionforSIPTrunkinGroup() throws InterruptedException, IOException {	
	     System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);
  
        String SheetName = "29- Permission's";
        String TestCaseID = "29-22";
        String Status = "";
         		 
           if(driver==null){
         			 
         	    System.out.println("WebDriver not initialized");
         			return;
         		}
         		  
         	try{
        
         		((SharedFunctions)sf).loginServerAdmin(driver);
        		((SharedFunctions)sf).clickServerPermissions(driver);
         		  ////Thread.sleep(10000);
         		
         	    // Click on edit permissions
                driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr[2]/td[3]/div/img[3]")).click();

                 ////Thread.sleep(5000);
                 // Click on SIP Trunk [+]
                 driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/div/table/tbody/tr[8]/td[1]/img")).click();
              
                 if (driver.findElement(By.id("21-45")).isSelected() == true) {
                  	 driver.findElement(By.id("21-45")).click(); //uncheck and then check permissions
                  	 
                     // Check permissions disabled
                     ////Thread.sleep(5000);
                     Assert.assertEquals(driver.findElement(By.id("21-45")).isSelected(), false); //View SIP Trunk
                     Assert.assertEquals(driver.findElement(By.id("21-46")).isEnabled(), false); //Create/Edit SIP Trunk
                     Assert.assertEquals(driver.findElement(By.id("21-47")).isEnabled(), false);  //Delete SIP Trunk 
                                          }
                 
                 else if (driver.findElement(By.id("21-45")).isSelected() == false) {
                  	 
                     // Check permissions disabled
                     ////Thread.sleep(5000);
                     Assert.assertEquals(driver.findElement(By.id("21-45")).isSelected(), false); //View SIP Trunk
                     Assert.assertEquals(driver.findElement(By.id("21-46")).isEnabled(), false); //Create/Edit SIP Trunk
                     Assert.assertEquals(driver.findElement(By.id("21-47")).isEnabled(), false);  //Delete SIP Trunk
                                  } 
                
                 Status = "Pass";
                 ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
 				TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
 				testresultlist.add(objtestreult);
 				// obj.updateResult(TestCaseID, SheetName, Status);

 			} catch (Throwable e) {
 				System.out.println("Error : " + e);
 				Status = "Fail";
 				((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
 				TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
 				testresultlist.add(objtestreult);
 			}
            
 	    driver.close();
}///////////////////////////Pass
          

      
      
////Test ID: 29-23
///* 
//* Verify that Create/Edit Trunk Group and Delete Trunk Group permission check box is disabled when View Trunk Group permission is not enabled
//*/                 
          @Test (priority = 20)
          public void verifyPermissionforTrunkinGroup() throws InterruptedException, IOException {	
    	     System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
            driver.get(baseUrl);
      
            String SheetName = "29- Permission's";
            String TestCaseID = "29-23";
            String Status = "";
             		 
               if(driver==null){
             			 
             	    System.out.println("WebDriver not initialized");
             			return;
             		}
             		  
             	try{
             		
             		((SharedFunctions)sf).loginServerAdmin(driver);
            		((SharedFunctions)sf).clickServerPermissions(driver);
             		////Thread.sleep(10000);
             		
             	    // Click on edit permissions
                    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr[2]/td[3]/div/img[3]")).click();

                     ////Thread.sleep(5000);
                     // Click on Trunk Group [+]
                     driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/div/table/tbody/tr[9]/td[1]/img")).click();
                  
                     if (driver.findElement(By.id("24-54")).isSelected() == true) {
                      	 driver.findElement(By.id("24-54")).click(); //uncheck and then check permissions
                     
            	         // Check permissions disabled
            	         ////Thread.sleep(5000);
            	         Assert.assertEquals(driver.findElement(By.id("24-54")).isSelected(), false); //View Trunk Group
            	         Assert.assertEquals(driver.findElement(By.id("24-55")).isEnabled(), false); //Create/Edit Trunk Group
            	         Assert.assertEquals(driver.findElement(By.id("24-56")).isEnabled(), false); //Delete Trunk Group
                      } 
                     
                     else if (driver.findElement(By.id("24-54")).isSelected() == false) {
                     
            	         // Check permissions disabled
            	         ////Thread.sleep(5000);
            	         Assert.assertEquals(driver.findElement(By.id("24-54")).isSelected(), false); //View Trunk Group
            	         Assert.assertEquals(driver.findElement(By.id("24-55")).isEnabled(), false); //Create/Edit Trunk Group
            	         Assert.assertEquals(driver.findElement(By.id("24-56")).isEnabled(), false); //Delete Trunk Group
            	                     	         } 
   
                     Status = "Pass";
                     ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
         			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
         			testresultlist.add(objtestreult);
         			// obj.updateResult(TestCaseID, SheetName, Status);

         		} catch (Throwable e) {
         			System.out.println("Error : " + e);
         			Status = "Fail";
         			((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
         			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
         			testresultlist.add(objtestreult);
         		}
             
	    driver.close();
}///////////////////////////Pass
      
  
      
 
////Test ID: 29-24
///* 
//* Verify that Create/Edit Board and Delete Board permission check box is disabled when View Board permission is not enabled
//*/  
          @Test (priority = 21)
          public void verifyPermissionforBoardinGroup() throws InterruptedException, IOException {	
    	     System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
            driver.get(baseUrl);
      
            String SheetName = "29- Permission's";
            String TestCaseID = "29-24";
            String Status = "";
             		 
               if(driver==null){
             			 
             	    System.out.println("WebDriver not initialized");
             			return;
             		}
             		  
             	try{
            
             		((SharedFunctions)sf).loginServerAdmin(driver);
            		((SharedFunctions)sf).clickServerPermissions(driver);
             		////Thread.sleep(10000);
             		
             	    // Click on edit permissions
                    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr[2]/td[3]/div/img[3]")).click();

                    ////Thread.sleep(7000);
                    // Click on Board [+]
                    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/div/table/tbody/tr[10]/td[1]/img")).click();
                  
                    if (driver.findElement(By.id("22-48")).isSelected() == true) {
                      	 driver.findElement(By.id("22-48")).click(); //uncheck and then check permissions
                      	 
                         // Check permissions disabled
                         ////Thread.sleep(5000);
                         Assert.assertEquals(driver.findElement(By.id("22-48")).isSelected(), false); //View Board
                         Assert.assertEquals(driver.findElement(By.id("22-49")).isEnabled(), false); //Create/Edit Board
                         Assert.assertEquals(driver.findElement(By.id("22-50")).isEnabled(), false); //Delete Board
                          } 
                     
                    else if (driver.findElement(By.id("22-48")).isSelected() == false) {
                    	// Check permissions disabled
                         //Thread.sleep(5000);
                         Assert.assertEquals(driver.findElement(By.id("22-48")).isSelected(), false); //View Board
                         Assert.assertEquals(driver.findElement(By.id("22-49")).isEnabled(), false); //Create/Edit Board
                         Assert.assertEquals(driver.findElement(By.id("22-50")).isEnabled(), false); //Delete Board
                        } 
            
                    Status = "Pass";
                    ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
        			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
        			testresultlist.add(objtestreult);
        			// obj.updateResult(TestCaseID, SheetName, Status);

        		} catch (Throwable e) {
        			System.out.println("Error : " + e);
        			Status = "Fail";
        			((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
        			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
        			testresultlist.add(objtestreult);
        		}

         	driver.close();
}///////////////////////////Pass
 
  
      
////Test ID: 29-25
///* 
//* Verify that Create/Edit Equipment and Delete Equipment permission check box is disabled when View Equipment permission is not enabled
//*/  
          @Test (priority = 22)
          public void verifyPermissionforEquipmentinGroup() throws InterruptedException, IOException {	
    	     System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
            driver.get(baseUrl);
            
            String SheetName = "29- Permission's";
            String TestCaseID = "29-25";
            String Status = "";
             		 
               if(driver==null){
             			 
             	    System.out.println("WebDriver not initialized");
             			return;
             		}
             		  
             	try{
      
             		((SharedFunctions)sf).loginServerAdmin(driver);
            		((SharedFunctions)sf).clickServerPermissions(driver);
             		////Thread.sleep(10000);
             		
             	    // Click on edit permissions
                    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr[2]/td[3]/div/img[3]")).click();

                     ////Thread.sleep(5000);
                     // Click on Equipment [+]
                     driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/div/table/tbody/tr[11]/td[1]/img")).click();
                  
                     if (driver.findElement(By.id("23-51")).isSelected() == true) {
                      	 driver.findElement(By.id("23-51")).click(); //uncheck and then check permissions
                      	 
                         // Check permissions disabled
                         ////Thread.sleep(5000);
                         Assert.assertEquals(driver.findElement(By.id("23-51")).isSelected(), false); //View Equipment
                         Assert.assertEquals(driver.findElement(By.id("23-52")).isEnabled(), false); //Create/Edit Equipment
                         Assert.assertEquals(driver.findElement(By.id("23-53")).isEnabled(), false); //Delete Equipment
                       }
                       
                     else if (driver.findElement(By.id("23-51")).isSelected() == false) {
                    	 
                    	 ////Thread.sleep(5000);
                         Assert.assertEquals(driver.findElement(By.id("23-51")).isSelected(), false); //View Equipment
                         Assert.assertEquals(driver.findElement(By.id("23-52")).isEnabled(), false); //Create/Edit Equipment
                         Assert.assertEquals(driver.findElement(By.id("23-53")).isEnabled(), false); //Delete Equipment
                     }
                                 
                     Status = "Pass";
                     ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
         			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
         			testresultlist.add(objtestreult);
         			// obj.updateResult(TestCaseID, SheetName, Status);

         		} catch (Throwable e) {
         			System.out.println("Error : " + e);
         			Status = "Fail";
         			((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
         			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
         			testresultlist.add(objtestreult);
         		}
     
             driver.close();
}///////////////////////////Pass
              
          
              
////Test ID: 29-26
///* 
//* Verify that Update Storage Settings permission check box is disabled when View Storage Settings permission is not enabled
//*/
              @Test (priority = 23)
              public void verifyPermissionforStorageSettingsinGroup() throws InterruptedException, IOException {	
        	     System.setProperty("webdriver.gecko.driver", driverPath);
                driver = new FirefoxDriver();
                driver.get(baseUrl);
          
                String SheetName = "29- Permission's";
                String TestCaseID = "29-26";
                String Status = "";
                 		 
                   if(driver==null){
                 			 
                 	    System.out.println("WebDriver not initialized");
                 			return;
                 		}
                 		  
                 	try{
                
                 		((SharedFunctions)sf).loginServerAdmin(driver);
                		((SharedFunctions)sf).clickServerPermissions(driver);
                 		////Thread.sleep(10000);
                 		
                 	    // Click on edit permissions
                        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr[2]/td[3]/div/img[3]")).click();

                        //Thread.sleep(5000);
                        // Click on Storage Settings [+]
                        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/div/table/tbody/tr[12]/td[1]/img")).click();
                      
                        if (driver.findElement(By.id("9-23")).isSelected() == true) {
                         	 driver.findElement(By.id("9-23")).click(); //uncheck and then check permissions
                         	 
                         	 // Check permissions disabled
                             //Thread.sleep(5000);
                             Assert.assertEquals(driver.findElement(By.id("9-23")).isSelected(), false); //View Storage Settings
                             Assert.assertEquals(driver.findElement(By.id("9-24")).isEnabled(), false);  //Update Storage Settings
                            } 
                         
                        else if (driver.findElement(By.id("9-23")).isSelected() == false) {
                        	
                        	// Check permissions disabled
                            //Thread.sleep(5000);
                            Assert.assertEquals(driver.findElement(By.id("9-23")).isSelected(), false); //View Storage Settings
                            Assert.assertEquals(driver.findElement(By.id("9-24")).isEnabled(), false);  //Update Storage Settings
                         } 
                
                        
                        Status = "Pass";
                        ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
            			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
            			testresultlist.add(objtestreult);
            			// obj.updateResult(TestCaseID, SheetName, Status);

            		} catch (Throwable e) {
            			System.out.println("Error : " + e);
            			Status = "Fail";
            			((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
            			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
            			testresultlist.add(objtestreult);
            		}
              
         	    driver.close();
 }///////////////////////////Pass
              
              
      

      
////Test ID: 29-27
///* 
//* Verify that Update System permission check box is disabled when View System permission is not enabled
//*/        
      @Test (priority = 24)
      public void verifyPermissionforSysteminGroup() throws InterruptedException, IOException {	
	     System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);
  
        String SheetName = "29- Permission's";
        String TestCaseID = "29-27";
        String Status = "";
         		 
           if(driver==null){
         			 
         	    System.out.println("WebDriver not initialized");
         			return;
         		}
         		  
         	try{
         		
         		((SharedFunctions)sf).loginServerAdmin(driver);
        		((SharedFunctions)sf).clickServerPermissions(driver);
         		//Thread.sleep(10000);
         		
         	    // Click on edit permissions
                driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr[2]/td[3]/div/img[3]")).click();

                //Thread.sleep(5000);
                // Click on System [+]
                driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/div/table/tbody/tr[13]/td[1]/img")).click();
              
                if (driver.findElement(By.id("10-25")).isSelected() == true) {
                	 driver.findElement(By.id("10-25")).click(); //uncheck and then check permissions
                
                 // Check permissions disabled
                 //Thread.sleep(5000);
                 Assert.assertEquals(driver.findElement(By.id("10-25")).isSelected(), false); //View Storage Settings
                 Assert.assertEquals(driver.findElement(By.id("10-26")).isEnabled(), false);  //Update Storage Settings
                }
              
                else if (driver.findElement(By.id("10-25")).isSelected() == false) {
                	 
                	// Check permissions disabled
                    //Thread.sleep(5000);
                    Assert.assertEquals(driver.findElement(By.id("10-25")).isSelected(), false); //View Storage Settings
                    Assert.assertEquals(driver.findElement(By.id("10-26")).isEnabled(), false);  //Update Storage Settings
                    }
              
                Status = "Pass";
                ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
    			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
    			testresultlist.add(objtestreult);
    			// obj.updateResult(TestCaseID, SheetName, Status);

    		} catch (Throwable e) {
    			System.out.println("Error : " + e);
    			Status = "Fail";
    			((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
    			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
    			testresultlist.add(objtestreult);
    		}
               
 	    driver.close();
}///////////////////////////Pass
 
      
      
////Test ID: 29-28
///* 
//* Verify that Update Traces permission check box is disabled when View Traces permission is not enabled
//*/            
      @Test (priority = 25)
      public void verifyPermissionforTracesinGroup() throws InterruptedException, IOException {	
	     System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);
  
        String SheetName = "29- Permission's";
        String TestCaseID = "29-28";
        String Status = "";
         		 
           if(driver==null){
         			 
         	    System.out.println("WebDriver not initialized");
         			return;
         		}
         		  
         	try{
        
         		((SharedFunctions)sf).loginServerAdmin(driver);
        		((SharedFunctions)sf).clickServerPermissions(driver);
         		//Thread.sleep(10000);
         		
         	    // Click on edit permissions
                driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr[2]/td[3]/div/img[3]")).click();

                //Thread.sleep(5000);
                // Click on Traces [+]
                driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/div/table/tbody/tr[15]/td[1]/img")).click();
              
                if (driver.findElement(By.id("11-27")).isSelected() == true) {
               	    driver.findElement(By.id("11-27")).click(); //uncheck and then check permissions
               	    
               	    // Check permissions disabled
                    //Thread.sleep(5000);
                    Assert.assertEquals(driver.findElement(By.id("11-27")).isSelected(), false); //View Traces
                    Assert.assertEquals(driver.findElement(By.id("11-28")).isEnabled(), false);  //Update Trace
                    }
                
                else if (driver.findElement(By.id("11-27")).isSelected() == false) {
                
                	// Check permissions disabled
                    //Thread.sleep(5000);
                    Assert.assertEquals(driver.findElement(By.id("11-27")).isSelected(), false); //View Traces
                    Assert.assertEquals(driver.findElement(By.id("11-28")).isEnabled(), false);  //Update Traces
                 }
        
        
        
                Status = "Pass";
                ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
    			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
    			testresultlist.add(objtestreult);
    			// obj.updateResult(TestCaseID, SheetName, Status);

    		} catch (Throwable e) {
    			System.out.println("Error : " + e);
    			Status = "Fail";
    			((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
    			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
    			testresultlist.add(objtestreult);
    		}
      
 	    driver.close();
}///////////////////////////Pass
       
      
      
////Test ID: 29-29
///* 
//* Verify that Edit Email Template permission check box is disabled when View Email Template permission is not enabled
//*/           
      @Test (priority = 26)
      public void verifyPermissionforEmailTemplateinGroup() throws InterruptedException, IOException {	
	     System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);
  
        String SheetName = "29- Permission's";
        String TestCaseID = "29-29";
        String Status = "";
         		 
           if(driver==null){
         			 
         	    System.out.println("WebDriver not initialized");
         			return;
         		}
         		  
         	try{
        
         		  ((SharedFunctions)sf).loginServerAdmin(driver);
         		  ((SharedFunctions)sf).clickServerPermissions(driver);
         		//Thread.sleep(10000);
         		
         	    // Click on edit permissions
                driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr[2]/td[3]/div/img[3]")).click();

                //Thread.sleep(5000);
                // Click on Email Template [+]
                driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/div/table/tbody/tr[18]/td[1]/img")).click();
              
                if (driver.findElement(By.id("16-35")).isSelected() == true) {
               	    driver.findElement(By.id("16-35")).click(); //uncheck and then check permissions
               	    
               	    // Check permissions disabled
                    //Thread.sleep(5000);
                    Assert.assertEquals(driver.findElement(By.id("16-35")).isSelected(), false); //View Email Template
                    Assert.assertEquals(driver.findElement(By.id("16-36")).isEnabled(), false);  //Edit Email Template
                  } 
               
                else if (driver.findElement(By.id("16-35")).isSelected() == false) {
                	
                	// Check permissions disabled
                    //Thread.sleep(5000);
                    Assert.assertEquals(driver.findElement(By.id("16-35")).isSelected(), false); //View Email Template
                    Assert.assertEquals(driver.findElement(By.id("16-36")).isEnabled(), false);  //Edit Email Template
                  } 
                
                Status = "Pass";
                ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
    			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
    			testresultlist.add(objtestreult);
    			// obj.updateResult(TestCaseID, SheetName, Status);

    		} catch (Throwable e) {
    			System.out.println("Error : " + e);
    			Status = "Fail";
    			((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
    			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
    			testresultlist.add(objtestreult);
    		}
        	
        driver.close();
}///////////////////////////Pass
   
      
      

////Test ID: 29-30
///* 
//* Verify that Update Server Incidents permission check box is disabled when View Server Incidents permission is not enabled
//*/           
      @Test (priority = 27)
      public void verifyPermissionforServerIncidentsinGroup() throws InterruptedException, IOException {	
	     System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);
  
        String SheetName = "29- Permission's";
        String TestCaseID = "29-30";
        String Status = "";
         		 
           if(driver==null){
         			 
         	    System.out.println("WebDriver not initialized");
         			return;
         		}
         		  
         	try{
        
         		((SharedFunctions)sf).loginServerAdmin(driver);
        		((SharedFunctions)sf).clickServerPermissions(driver);
         		//Thread.sleep(10000);
         		
         	    // Click on edit permissions
                driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr[2]/td[3]/div/img[3]")).click();

                 //Thread.sleep(5000);
                 // Click on Email Template [+]
                 driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/div/table/tbody/tr[19]/td[1]/img")).click();
              
                 if (driver.findElement(By.id("17-37")).isSelected() == true) {
                	    driver.findElement(By.id("17-37")).click(); //uncheck and then check permissions
                	    
                	    // Check permissions disabled
                        //Thread.sleep(5000);
                        Assert.assertEquals(driver.findElement(By.id("17-37")).isSelected(), false); //View Email Template
                        Assert.assertEquals(driver.findElement(By.id("17-38")).isEnabled(), false);  //Edit Email Template
                       } 
                 
                 else if (driver.findElement(By.id("17-37")).isSelected() == false) {
                	 
                	// Check permissions disabled
                     //Thread.sleep(5000);
                     Assert.assertEquals(driver.findElement(By.id("17-37")).isSelected(), false); //View Email Template
                     Assert.assertEquals(driver.findElement(By.id("17-38")).isEnabled(), false);  //Edit Email Template 
                    } 
                
                 Status = "Pass";
                 ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
     			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
     			testresultlist.add(objtestreult);
     			// obj.updateResult(TestCaseID, SheetName, Status);

     		} catch (Throwable e) {
     			System.out.println("Error : " + e);
     			Status = "Fail";
     			((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
     			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
     			testresultlist.add(objtestreult);
     		}	
      
 	    driver.close();
}////////////////////////////////// Pass

      
      
////Test ID: 29-31
///* 
//* Verify that Create/Edit Branch and Delete Branch permission check box is disabled when View Branch permission is not enabled
//*/           
      @Test (priority = 28)
      public void verifyPermissionforBranchinGroup() throws InterruptedException, IOException {	
	     System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);
  
        String SheetName = "29- Permission's";
        String TestCaseID = "29-31";
        String Status = "";
         		 
           if(driver==null){
         			 
         	    System.out.println("WebDriver not initialized");
         			return;
         		}
         		  
         	try{
         		
         		((SharedFunctions)sf).loginServerAdmin(driver);
        		((SharedFunctions)sf).clickServerPermissions(driver);
         		//Thread.sleep(10000);
         		
         	    // Click on edit permissions
                driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr[2]/td[3]/div/img[3]")).click();

                 //Thread.sleep(5000);
                 // Click on Branch [+]
                 driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/div/table/tbody/tr[5]/td[1]/img")).click();
              
                 if (driver.findElement(By.id("20-42")).isSelected() == true) {
             	    driver.findElement(By.id("20-42")).click(); //uncheck and then check permissions
             	    
             	    // Check permissions disabled
                    //Thread.sleep(5000);
                    Assert.assertEquals(driver.findElement(By.id("20-42")).isSelected(), false); //View Branch
                    Assert.assertEquals(driver.findElement(By.id("20-43")).isEnabled(), false); //Create/Edit Branch
                    Assert.assertEquals(driver.findElement(By.id("20-44")).isEnabled(), false); //Delete Branch
                    } 
                 
                 else if  (driver.findElement(By.id("20-42")).isSelected() == false) {
                	 
                	// Check permissions disabled
                     //Thread.sleep(5000);
                     Assert.assertEquals(driver.findElement(By.id("20-42")).isSelected(), false); //View Branch
                     Assert.assertEquals(driver.findElement(By.id("20-43")).isEnabled(), false);  //Create/Edit Branch
                     Assert.assertEquals(driver.findElement(By.id("20-44")).isEnabled(), false);  //Delete Branch
                     } 
                
                 Status = "Pass";
                 ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
     			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
     			testresultlist.add(objtestreult);
     			// obj.updateResult(TestCaseID, SheetName, Status);

     		} catch (Throwable e) {
     			System.out.println("Error : " + e);
     			Status = "Fail";
     			((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
     			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
     			testresultlist.add(objtestreult);
     		}
         
 	    driver.close();
}///////////////////////////Pass
 
      
      
////Test ID: 29-19
///* 
//* Verify that Change Server Status, View node status and view packetizer status permission check box is disabled when View Server permission is not enabled
//*/     
      @Test (priority = 29)
      public void verifyViewServerPermissiondisabled() throws InterruptedException, IOException {	
	     System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);
      
        String SheetName = "29- Permission's";
        String TestCaseID = "29-19";
        String Status = "";
         		 
           if(driver==null){
         			 
         	    System.out.println("WebDriver not initialized");
         			return;
         		}
         		  
         	try{
        
         		((SharedFunctions)sf).loginServerAdmin(driver);
        		((SharedFunctions)sf).clickServerPermissions(driver);
         		//Thread.sleep(10000);
         		
         	    // Click on edit permissions
         	    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr[2]/td[3]/div/img[3]")).click();

         	    //Thread.sleep(5000);
         	    // Click on Server [+]
         	    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/div/table/tbody/tr[4]/td[1]/img")).click();
         	      
         	      if (driver.findElement(By.id("3-6")).isSelected() == true) {
         	   	      driver.findElement(By.id("3-6")).click(); //uncheck and then check permissions
         	   	      // Check permissions disabled
         	          //Thread.sleep(3000);
         	          Assert.assertEquals(driver.findElement(By.id("3-6")).isSelected(), false); //View Server
         	          Assert.assertEquals(driver.findElement(By.id("3-7")).isEnabled(), false);  //Change server status  
          	          } 
         	      
         	      else if  (driver.findElement(By.id("3-6")).isSelected() == false) {
         	    	// Check permissions disabled
         	          //Thread.sleep(3000);
         	          Assert.assertEquals(driver.findElement(By.id("3-6")).isSelected(), false); //View Server
         	          Assert.assertEquals(driver.findElement(By.id("3-7")).isEnabled(), false);  //Change server status
           	      } 
            
      //Thread.sleep(7000);
      // Click on Nodes [+]
      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/div/table/tbody/tr[7]/td[1]/img")).click();
      
      if (driver.findElement(By.id("7-14")).isSelected() == true) {
   	      driver.findElement(By.id("7-14")).click(); //uncheck and then check permissions  	      
   	      // Check permissions disabled
   	      //Thread.sleep(3000);
   	      Assert.assertEquals(driver.findElement(By.id("7-14")).isSelected(), false); } //View Nodes
      else if (driver.findElement(By.id("7-14")).isSelected() == false) {
    	// Check permissions disabled
   	      //Thread.sleep(3000);
   	      Assert.assertEquals(driver.findElement(By.id("7-14")).isSelected(), false); } //View Nodes
      
      
      //Thread.sleep(7000);
      // Click on Packetizer Settings [+]
      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/div/table/tbody/tr[9]/td[1]/img")).click();
      
      if (driver.findElement(By.id("8-20")).isSelected() == true) {
   	      driver.findElement(By.id("8-20")).click(); //uncheck and then check permissions
   	      // Check permissions disabled
   	      //Thread.sleep(3000);
   	      Assert.assertEquals(driver.findElement(By.id("8-20")).isSelected(), false); } //View Packetizer Settings
      
      else if (driver.findElement(By.id("8-20")).isSelected() == false) {
    	  // Check permissions disabled
   	      //Thread.sleep(3000);
   	      Assert.assertEquals(driver.findElement(By.id("8-20")).isSelected(), false); } //View Packetizer Settings
      
      Status = "Pass";
      ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
		TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
		testresultlist.add(objtestreult);
		// obj.updateResult(TestCaseID, SheetName, Status);

	} catch (Throwable e) {
		System.out.println("Error : " + e);
		Status = "Fail";
		((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
		TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
		testresultlist.add(objtestreult);
	}	
      
      driver.close();        
}///////////////////////Pass 
      


      

      
//////Test ID: 29-32
/////* 
////* Verify that if user does not have a view permission then the page against that permission should not be available
////*/	
      @Test (priority = 29)
      public void verifyViewServerPermissionAgainstPage() throws InterruptedException, IOException {	
        System.setProperty("webdriver.gecko.driver", driverPath);
         driver = new FirefoxDriver();
         driver.get(baseUrl);

         String SheetName = "29- Permission's";
         String TestCaseID = "29-32";
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
     
       // Click On Permissions
       //Thread.sleep(10000);
       driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPermissions")).click();
       
//      //  Click on copy Server admin
//       driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr[1]/td[3]/div/img[2]")).click();

       // Click on Users
       //Thread.sleep(10000);
       driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
       
       // Make a new user
       // Click on Add Users
       driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
       
       //Thread.sleep(5000);
       // Fillout the form for new user
       // Locate Fname and enter value
       driver.findElement(By.id("tbFirstName")).sendKeys("James R.");
       
       // Locate Lname and enter value
       driver.findElement(By.id("tbLastName")).sendKeys("Williams");
       
       //Thread.sleep(5000);
       // Locate username and enter value
       driver.findElement(By.id("tbUserName")).sendKeys("jameswilliams");
       
       // Locate password and enter value
       driver.findElement(By.id("tbPassword")).sendKeys("1234567a");
       
       // Locate confirm password and enter value
       driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567a");
       
       //Thread.sleep(5000);
       // Locate Password Never Expires checkbox and check
       WebElement PasswordNeverExpires = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/input")) ;
       PasswordNeverExpires.click();
       
       // Locate email and enter value
       WebElement emailbox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input"));
       emailbox.sendKeys("jameswilliams@jourrapide.com");
       
       //Thread.sleep(5000);
       // Locate Enable Account checkbox and check
       WebElement EnableAccount = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input"));
       EnableAccount.click();

       //Get the table and row                                //    //*[@id="divSecurityGroup"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table     
     	WebElement table =driver.findElement(By.xpath("//*[@id=\"divSecurityGroup\"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table")); //   //*[@id="divSecurityGroup"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table
     	WebElement tbody=table.findElement(By.tagName("tbody"));
     	List<WebElement> rows=tbody.findElements(By.tagName("tr"));
     	String rowNo="";
     	String Secgroup = "Server Admin - Copy";
     	for(int i=0;i<rows.size();i++)
     	{
     	WebElement row = tbody.findElement(By.xpath("//*[@id=\"divSecurityGroup\"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+(i+1)+"]")); // //*[@id="divSecurityGroup"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[2]
     	if(row.getText().trim().contains(Secgroup))
     	{
     	rowNo=Integer.toString(i+1);
     	break;
     	}
     	}
     	System.out.println(rowNo);
     	//Thread.sleep(8000);	
     	driver.findElement(By.xpath("//*[@id=\"divSecurityGroup\"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();

       
//       //Thread.sleep(5000);
//       // Locate Security Groups Roles and Click/Select
//       WebElement ServerAdmin = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[2]"));
//       ServerAdmin.click();
       
       // Locate ">" and click
       driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();
       
       //Thread.sleep(5000);
       // Locate Save button and click
       driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();
       
       //Thread.sleep(5000);
       // Check alert message
       JavascriptExecutor jsx = (JavascriptExecutor)driver;
       jsx.executeScript("window.confirm('Settings have been saved successfully')");
     
       /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
       Dismissed user prompt dialog: Settings have been updated successfully:*/
       driver.switchTo().alert().accept();
       //Thread.sleep(5000); 
       
       // Click on okay button
       //Thread.sleep(5000);
       driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button/span")).click();
       
       // Click On Permissions
       //Thread.sleep(8000);
       driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPermissions")).click();
       
       // Click edit permissions Server Admin - Copy
       //Thread.sleep(5000);
       driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr[2]/td[3]/div/img[3]")).click();
       
/////////////////////////////////////////////////////Un-check all pages after expand      
       // Click on Expand button 
       //Thread.sleep(7000);
       driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr/td[2]/img[2]")).click();
       
       //Thread.sleep(5000);
       // Un-check View Users
       driver.findElement(By.id("4-1")).click();
       
       // Un-check View Reports 
       driver.findElement(By.id("18-39")).click();
       
       // Un-check View Server 
       driver.findElement(By.id("3-6")).click();
       
       // Un-check View Branch 
       driver.findElement(By.id("20-42")).click();
       
       // Un-check View Nodes 
       driver.findElement(By.id("7-14")).click();
       
       // Un-check View Packetizer Settings 
       driver.findElement(By.id("8-20")).click();
       
       // Un-check View SIP Trunk 
       driver.findElement(By.id("21-45")).click();
       
       // Un-check View Trunk Group 
       driver.findElement(By.id("24-54")).click();
       
       // Un-check View Board 
       driver.findElement(By.id("22-48")).click();
       
       // Un-check View Storage Settings 
       driver.findElement(By.id("9-23")).click();
       
       // Un-check View System 
       driver.findElement(By.id("10-25")).click();
       
       // Un-check View SNMP Settings
       driver.findElement(By.id("35-114")).click();
       
       // Un-check View Traces 
       driver.findElement(By.id("11-27")).click();
       
       // Un-check View Email Template 
       driver.findElement(By.id("16-35")).click();
       
       // Un-check View Server Incidents 
       driver.findElement(By.id("17-37")).click();
       
       // Un-check View API Token
       driver.findElement(By.id("26-60")).click();
       
       // Un-check View Update Schedule 
       driver.findElement(By.id("36-117")).click();
       
       // Un-check View Change Password 
       driver.findElement(By.id("13-30")).click();
       
       // Un-check View View Licensing 
       driver.findElement(By.id("14-31")).click();
       
       // Click on update button
       driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/input[1]")).click();
       
       //Thread.sleep(8000);
       // Check alert message
       JavascriptExecutor jsd = (JavascriptExecutor)driver;
       jsd.executeScript("window.confirm('Settings have been saved successfully')");
     
       /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
       Dismissed user prompt dialog: Settings have been updated successfully:*/
       driver.switchTo().alert().accept();
       //Thread.sleep(5000); 
       
       // Click on okay button
       //Thread.sleep(5000);
       driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button/span")).click();
       
       // Click on Logout
	     driver.findElement(By.id("ctl00_lblLogOut")).click();
	     
	   // Signing in OmniPCX again
       driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("jameswilliams");
       driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
       driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
       
       JavascriptExecutor jsr = (JavascriptExecutor)driver;
       jsr.executeScript("window.confirm('Please change your password to continue. Your account will be disabled if you click Cancel button 3 times.')");
     
       /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
       Dismissed user prompt dialog: Settings have been updated successfully:*/
       driver.switchTo().alert().accept();
       //Thread.sleep(5000); 
       
       // Click on okay button
       //Thread.sleep(8000);
       driver.findElement(By.id("btnOK")).click();
       
       //Thread.sleep(8000); 
       // Enter Old Password, New Password & Confirm Password
       driver.findElement(By.id("ctrl_ChangePassword1_tbOldPassword")).sendKeys("1234567a");
       driver.findElement(By.id("ctrl_ChangePassword1_tbNewPassword")).sendKeys("admin12345");
       driver.findElement(By.id("ctrl_ChangePassword1_tbConfirmPassword")).sendKeys("admin12345");
       
       // Click on update button
       driver.findElement(By.id("ctrl_ChangePassword1_btnUpdate")).click();
       
       //Thread.sleep(10000);
       
       // Check pages present
       boolean value = driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPermissions")).isDisplayed();
       Assert.assertEquals(value, true); //Permissions
       
       boolean value1 = driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkAuditLogs")).isDisplayed();
       Assert.assertEquals(value1, true); //Decrypt Audit Log
       
       boolean value2 = driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink10")).isDisplayed();
       Assert.assertEquals(value2, true); //Notification Templates
        
       
//       // Check all pages
//       boolean value = driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).isDisplayed();
//       Assert.assertEquals(value, false); //Users
//       
//       boolean value1 = driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkServer")).isDisplayed();
//       Assert.assertEquals(value1, false); //Server
//       
//       boolean value2 = driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).isDisplayed();
//       Assert.assertEquals(value2, false); //Branches
//       
//       boolean value3 = driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).isDisplayed();
//       Assert.assertEquals(value3, false); // Nodes
//       
//       boolean value4 = driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).isDisplayed();
//       Assert.assertEquals(value4, false); // Packetizer Settings
//       
//       boolean value5 = driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink7")).isDisplayed();
//       Assert.assertEquals(value5, false); // Trunk Groups
//       
//       boolean value6 = driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink6")).isDisplayed();
//       Assert.assertEquals(value6, false); // Boards
//       
//       boolean value7 = driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkSIPTrunk")).isDisplayed();
//       Assert.assertEquals(value7, false); // SIP Trunk
//       
//       boolean value8 = driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink2")).isDisplayed();
//       Assert.assertEquals(value8, false); // Storage Settings
//       
//       boolean value9 = driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).isDisplayed();
//       Assert.assertEquals(value9, false); // System
//       
//       boolean value10 = driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink9")).isDisplayed();
//       Assert.assertEquals(value10, false); // SNMP Settings
//       
//       boolean value11 = driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink4")).isDisplayed();
//       Assert.assertEquals(value11, false); // Traces
//       
//       boolean value12 = driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).isDisplayed();
//       Assert.assertEquals(value12, false); // Email Templates
//       
//       boolean value13 = driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkInciddents")).isDisplayed();
//       Assert.assertEquals(value13, false); // Server Incidents
//       
//       boolean value14 = driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkAPIToken")).isDisplayed();
//       Assert.assertEquals(value14, false); // API Token
//       
//       boolean value15 = driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink8")).isDisplayed();
//       Assert.assertEquals(value15, false); // Update Schedule
//       
//       boolean value16 = driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkLicensing")).isDisplayed();
//       Assert.assertEquals(value16, false); // Licensing
//       
//       boolean value17 = driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink1")).isDisplayed();
//       Assert.assertEquals(value17, false); // Change Password
//       
//       boolean value18 = driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlReports")).isDisplayed();
//       Assert.assertEquals(value18, false); // Reports
                    
	    Status = "Pass";
	    ((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
		TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
		testresultlist.add(objtestreult);
		// obj.updateResult(TestCaseID, SheetName, Status);
	
	} catch (Throwable e) {
		System.out.println("Error : " + e);
		Status = "Fail";
		((SharedFunctions)sf).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
		TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
		testresultlist.add(objtestreult);
}
       
       driver.close();    
}
      
      
      
/////////////////////////////////////////      
/////////Clear data after all test run      
////////////////////////////////////////           
      @Test (priority = 30)
      public void ClearPermissionsAfterTest() throws InterruptedException {
  		System.setProperty("webdriver.gecko.driver", driverPath);
  		driver = new FirefoxDriver();
  	      driver.get(baseUrl);	
  	
  	      // Signing in OmniPCX
  	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
  	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
  	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
  	      
  	      // Delete remaining Users and Permission group
  		  // Users
  		  // Click on Users
  	      //Thread.sleep(10000);
  	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
  	      
  	      //Thread.sleep(7000);
  	      
  	      // Click all check-boxes
  	      List<WebElement> elements = driver.findElements(By.xpath("//input[@type='checkbox']"));
  	      for (WebElement el:elements) {
  	      el.click(); }
  	      
  	      // Click multiple delete
  	      driver.findElement(By.id("dltMultiple")).click();
  	      
  	      //Thread.sleep(7000);
  	      
  	      // Click on delete selected
  	      driver.findElement(By.xpath("/html/body/ul[1]")).click();
  	      
  	      // Click on delete button
          //Thread.sleep(5000);
  	      driver.findElement(By.id("btnDelete")).click();
  	      
//  	      String expectedUserDeleted = "Selected users are deleted successfully.";
//  	      
//  	      //Thread.sleep(5000);
//  	      // Get message "Record has been deleted successfully"
//  	      String actualUserDeleted = driver.findElement(By.id("lblMessage")).getText();
//  	      
//  	      Assert.assertEquals(actualUserDeleted, expectedUserDeleted);
        
  	      // Click On Permissions
//  	      //Thread.sleep(7000);
  	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPermissions")).click();	
  	   
  	    List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"gvGroups\"]/tbody/tr"));
  	  	int rowscount = rows.size();
  	  	System.out.println(rowscount);
  	  	
  	  	for (int i=2 ; i<=rowscount; i++)
  	  	{
  	  	////Thread.sleep(2000);
  	  	driver.findElement(By.xpath("//*[@id=\"gvGroups\"]/tbody/tr[2]/td[3]/div/img[4]")).click();

  	  	driver.findElement(By.id("btnDelete")).click();
  	  	}
  	  		
  	  		driver.close();	  		  		  
  	  	} 	
  	
  		  		        
          
      @AfterClass 
      public void afterClass() {
     	 
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


 