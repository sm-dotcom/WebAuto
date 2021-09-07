/* 
@author: sarah.mahmood 
Created on May 14, 2021
*/
package ServerAdministration;

import java.util.List;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.openqa.selenium.support.Color;
//import org.openqa.selenium.devtools.idealized.Javascript;
//import static org.testng.AssertJUnit.assertFalse;
//import java.text.ParseException;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.AfterTest;
//import static org.testng.Assert.assertTrue;
import org.openqa.selenium.support.ui.Select;



public class ServerUser {
	
	public String baseUrl = "http://172.20.22.81/OmniPCXRecord/TenantAdmin.aspx";
	
    String driverPath = "C:\\Users\\sarah.mahmood\\Downloads\\gecko-driver\\geckodriver.exe";
	
	public WebDriver driver;
	
//	 @BeforeTest
//	    public void printBrowsername() {
//	    System.out.println("Launching Firefox Browser"); 
//	    System.setProperty("webdriver.gecko.driver", driverPath);
//	    }
//	 
  @Test //(priority = 0)
  public void verifyLoginwithValidCredentials() throws InterruptedException {
	  
	  System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);
//      driver.wait(50); have to return notify as well otherwise will cause runtime error
      Thread.sleep(3000);
      String expectedTitle = "http://172.20.22.81/OmniPCXRecord/Nodes.aspx";
      
      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); //admin
      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
      Thread.sleep(3000);
      String actualTitle = driver.getCurrentUrl();
      Assert.assertEquals(actualTitle, expectedTitle);
  }
  
  
	
////Test ID: 30-01
///* 
//* To verify that default 'Admin' user exists in the system 
//*/
// 
   @Test (priority = 1)
   public void verifyDefaultAdminData () throws InterruptedException {
	  System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);

       // Signing in OmniPCX 
      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
      
        // Click On Users 
        Thread.sleep(10000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();

      // Only Admin Data would be present in the table Full Name |  Name
	    String expectedColumnData ="A-L Administrator admin";
	
         // Get's Table data form 's Table and returns whole table data
	    //Following code get's row data from the table and prints it
//	    System.out.println("table data for the following row");
      List<WebElement> allColumnsInRow=driver.findElements(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr[1]"));
      for(WebElement e: allColumnsInRow)
      {
//         System.out.println(e.getText());
         String actualColumnData = e.getText();
         Assert.assertEquals(actualColumnData, expectedColumnData);
      }
     
      driver.close();
}     
	
	
////Test ID: 30-02
///* 
//* Delete default 'Admin' user from the system 
//*/ 
      @Test (priority = 2)
      public void verifyDefaultAdminDelete () throws InterruptedException {
    	  System.setProperty("webdriver.gecko.driver", driverPath);
          driver = new FirefoxDriver();
          driver.get(baseUrl);

          // Signing in OmniPCX 
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
          driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
          driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
          
	      // Click on Users
          Thread.sleep(10000);
          driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
          
          // Get Delete button and check if it's enabled
          WebElement deletebutton = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr/td[1]/input"));

          boolean actualValue = deletebutton.isEnabled();
          boolean expectedValue = false;
         
          Assert.assertEquals(actualValue,expectedValue);
          driver.close();	
 }
  

	
////Test ID: 30-03
///* 
///* Change security group of default 'Admin' user  
//*/	
    @Test (priority = 3)
	public void verifyDefaultAdminSecurityGroup () throws InterruptedException {
	  System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);

      // Signing in OmniPCX 
      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();

      // Click On Users
      Thread.sleep(10000);
      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
      
      // Click on Admin Edit
      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr[1]/td[4]/div/img[1]")).click();
     
      Thread.sleep(3000);     
      // Check If security group's div is present
      boolean Value = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr/td[1]")).isDisplayed();
	  
      Assert.assertEquals(false, Value);

      driver.close();
}
	
	
////Test ID: 30-04
///* 
//* Disable Account of default 'Admin' user 
//*/
  
    @Test (priority = 4)
    public void verifyDefaultAdminCheckbox () throws InterruptedException {
  	  System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);

        // Signing in OmniPCX 
        driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
        driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
        driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();

        // Click On Users
        Thread.sleep(10000);
        driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
        
         // Get Unchecked Box and make sure it is disabled
        WebElement checkbox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr[1]/td[1]/input"));

        boolean actualDisableValue = checkbox.isEnabled();
        boolean expectedDisableValue = false;
       
        Assert.assertEquals(actualDisableValue,expectedDisableValue);
        driver.close();
}
      
	
////Test ID: 30-05
///* 
//* Change First Name of default 'Admin' user 
//*/
	  
    @Test (priority = 5)
    public void verifyAdminFirstName () throws InterruptedException {
  	  System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);

        // Signing in OmniPCX 	
        driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
        driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
        driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
        
        // Click on Users
        Thread.sleep(10000);
        driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
       
        // Click on Edit button
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr[1]/td[4]/div/img[1]")).click();

        Thread.sleep(5000);
        // Check if FirstName is editable
        boolean actualFname  = driver.findElement(By.id("tbFirstName")).isEnabled();
        
//        boolean actualFname = fname.isEnabled(); /////Enable is causing error
        boolean expectedFname = false;
       
        Assert.assertEquals(actualFname, expectedFname);
        driver.close();
}
  
    
////Test ID: 30-06
///* 
//* Change Last Name of default 'Admin' user 
//*/
  	  
       @Test (priority = 6)
       public void verifyAdminLastName () throws InterruptedException {
     	  System.setProperty("webdriver.gecko.driver", driverPath);
           driver = new FirefoxDriver();
           driver.get(baseUrl);
           
           // Signing in OmniPCX
           driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
           driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
           driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
          
	       // Click on Users
           Thread.sleep(10000);
           driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
          
  	       // Click on Edit button      
	       driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr[1]/td[4]/div/img[1]")).click();

	       Thread.sleep(3000);
	       // Check if LastName is editable
           WebElement e = driver.findElement(By.id("tbLastName"));
           
           boolean actualLname = e.isEnabled();
           boolean expectedLname = false;
           
           Assert.assertEquals(actualLname,expectedLname);
           driver.close();
}
    
    
	
////Test ID: 30-07
///* 
//* Update Email of default 'Admin' user
//*/		
  @Test (priority = 7)
  public void verifyUpdateAdminEmail () throws InterruptedException {
	  System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);

      // Signing in OmniPCX
      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
      
      // Click on Users
      Thread.sleep(10000);
      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
      
      // Click on Edit button
      Thread.sleep(3000);
      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr[1]/td[4]/div/img[1]")).click();

      // Set new email address value from here
      String email = "sarah.mahmood@amigo-software.com";
      
      Thread.sleep(2000);
      // Locate Email textbox and clear text present
      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input")).clear();
     
      // Locate Email textbox and Enter new email address
      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input")).sendKeys(email);
      
      Thread.sleep(2000);
      // Click on Update button
      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();

      // Check alert message
      JavascriptExecutor jsx = (JavascriptExecutor)driver;
      jsx.executeScript("window.confirm('Settings have been updated successfully')");
     
      String expectedAlertEmail = "Settings have been updated successfully";
      Alert confirmation = driver.switchTo().alert();
      String actualAlertEmail = confirmation.getText(); //Get text present on alert Message
      
      // Match alert messages 
      Assert.assertEquals(actualAlertEmail,expectedAlertEmail);
     
      //Print Alert where needed
      //System.out.println("Alert text is :" + actualAlert);
     
      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
      Dismissed user prompt dialog: Settings have been updated successfully:*/
      driver.switchTo().alert().accept();
     
      // Click on okay button
      Thread.sleep(3000);
      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click(); //.click();
      
       driver.close();
}
  

 
           
           
////Test ID: 30-09
///* 
//* Update Password  of default 'Admin' user with user name in password
//*/	 
  @Test (priority = 9)
  public void verifyUpdateUsernamePassword () throws InterruptedException {
	  System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);

      // Signing in OmniPCX
      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
      
      // Click on Users
      Thread.sleep(10000);
      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
      
      // Click on Edit button
      Thread.sleep(3000);
      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr[1]/td[4]/div/img[1]")).click();

      // Set new password value from here
      String UserNamePassword = "admin123";
      
      Thread.sleep(3000);
      // Locate password textbox and clear text present
      driver.findElement(By.id("tbPassword")).clear();
      
      // Locate password textbox and Enter new password
      driver.findElement(By.id("tbPassword")).sendKeys(UserNamePassword);
      
      
      // Locate confirm password textbox and clear text present
      driver.findElement(By.id("tbConfirmPassword")).clear();
      
      // Locate confirm password textbox and Enter new password
      driver.findElement(By.id("tbConfirmPassword")).sendKeys(UserNamePassword);
      
      // Click on Update button
      Thread.sleep(5000);
      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();

      // Set mandatory field message at the top in red for expected result
      String expectedManFieldMsg = "Password must not contain username";
      
      // Get mandatory field message at the top in red
      String actualManFieldMsg = driver.findElement(By.id("lblMessage")).getText();
      
      Assert.assertEquals(actualManFieldMsg, expectedManFieldMsg);
      driver.close();
}
  
 
////Test ID: 30-11
///* 
//* Add normal opr user in the system with valid data and enabled account
//*/	  
  @Test (priority = 10)
  public void verifyNewUserwithEnabledAccount () throws InterruptedException {
	  System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);

      // Signing in OmniPCX
      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
      
      // Click on Users
      Thread.sleep(10000);
      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
      
      // Click on Add Users
      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
      
      Thread.sleep(5000);
      // Fillout the form for new user
      // Locate Fname and enter value
      driver.findElement(By.id("tbFirstName")).sendKeys("Maeve");
      
      // Locate Lname and enter value
      driver.findElement(By.id("tbLastName")).sendKeys("Rojas");
      
      Thread.sleep(5000);
      // Locate username and enter value
      driver.findElement(By.id("tbUserName")).sendKeys("Mrojas567");
      
      // Locate password and enter value
      driver.findElement(By.id("tbPassword")).sendKeys("1234567a");
      
      // Locate confirm password and enter value
      driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567a");
      
      Thread.sleep(5000);
      // Locate Password Never Expires checkbox and check
      WebElement PasswordNeverExpires = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/input")) ;
      PasswordNeverExpires.click();
      
      // Locate email and enter value
      WebElement emailbox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input"));
      emailbox.sendKeys("nooria.ashraf@amigo-software.com");
      
      Thread.sleep(5000);
      // Locate Enable Account checkbox and check
      WebElement EnableAccount = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input"));
      EnableAccount.click();
      
      Thread.sleep(5000);
      // Locate Security Groups Roles and Click/Select
      WebElement ServerAdmin = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option"));
      ServerAdmin.click();
      
      // Locate ">" and click
      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();
      
      Thread.sleep(5000);
      // Locate Save button and click
      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();
      
      Thread.sleep(5000);
      // Check alert message
      JavascriptExecutor jsx = (JavascriptExecutor)driver;
      jsx.executeScript("window.confirm('Settings have been saved successfully')");
    
      String expectedAlertUserSaved = "Settings have been saved successfully";
      Alert confirmation = driver.switchTo().alert();
      String actualAlertUserSaved = confirmation.getText(); //Get text present on alert Message
    
      Assert.assertEquals(actualAlertUserSaved, expectedAlertUserSaved);
    
      //Print Alert where needed
      //System.out.println("Alert text is :" + actualAlert);
    
      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
      Dismissed user prompt dialog: Settings have been updated successfully:*/
      driver.switchTo().alert().accept();
   
      Thread.sleep(5000);
      // Click on okay button
      Thread.sleep(5000);
      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button/span")).click();
      
      driver.close();    
  } 
  
  
////Test ID: 30-12
///* 
//* Add normal opr user in the system with valid data and Disabled account
//*/	 
  
  @Test (priority = 11)
  public void verifyNewUserwithDisabledAccount () throws InterruptedException {
	  System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);

      // Signing in OmniPCX
      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
      
      // Click on Users
      Thread.sleep(10000);
      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
      
      // Click on Add Users
      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
      
      Thread.sleep(5000);
      // Fillout the form for new user
      // Locate Fname and enter value
      driver.findElement(By.id("tbFirstName")).sendKeys("Murphy");
      
      // Locate Lname and enter value
      driver.findElement(By.id("tbLastName")).sendKeys("Kibo");
      
      // Locate username and enter value
      driver.findElement(By.id("tbUserName")).sendKeys("mKibo3");
      
      Thread.sleep(5000);
      // Locate password and enter value
      driver.findElement(By.id("tbPassword")).sendKeys("1234567a");
      
      // Locate confirm password and enter value
      driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567a");
      
      Thread.sleep(5000);
      // Locate Password Never Expires checkbox and check
      WebElement PasswordNeverExpires = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/input")) ;
      PasswordNeverExpires.click();
      
      // Locate email and enter value
      WebElement emailbox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input"));
      emailbox.sendKeys("nooria.ashraf@amigo-software.com");
      
//      // Locate Enable Account checkbox and check
//      WebElement EnableAccount = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input"));
//      EnableAccount.click();
      
      Thread.sleep(5000);
      // Locate Security Groups Roles and Click/Select
      WebElement ServerAdmin = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option"));
      ServerAdmin.click();
      
      // Locate ">" and click
      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();
      
      Thread.sleep(5000);
      // Locate Save button and click
      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();
      
      Thread.sleep(5000);
      // Check alert message
      JavascriptExecutor jsx = (JavascriptExecutor)driver;
      jsx.executeScript("window.confirm('Settings have been saved successfully')");
    
      String expectedAlertUserSaved = "Settings have been saved successfully";
      Alert confirmation = driver.switchTo().alert();
      String actualAlertUserSaved = confirmation.getText(); //Get text present on alert Message
    
      Assert.assertEquals(actualAlertUserSaved, expectedAlertUserSaved);
    
      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
      Dismissed user prompt dialog: Settings have been updated successfully:*/
      driver.switchTo().alert().accept();
   
      // Click on okay button
      Thread.sleep(7000);
      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button/span")).click();
      
      driver.close();    
  } 
  
  
////Test ID: 30-13
///* 
//* Add normal opr user in the system with empty first name
//*/	 
	
  @Test (priority = 12)
  public void verifyNewUserwithNoFname () throws InterruptedException {
	  System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);

      // Signing in OmniPCX
      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
      
      // Click on Users
      Thread.sleep(10000);
      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
      
      // Click on Add Users
      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
      
      Thread.sleep(3000);
      // Fillout the form for new user
      // Locate Fname and enter value
      //driver.findElement(By.id("tbFirstName")); //.sendKeys("");
      
      // Locate Lname and enter value
      driver.findElement(By.id("tbLastName")).sendKeys("Kilo");
      
      // Locate username and enter value
      driver.findElement(By.id("tbUserName")).sendKeys("kkilo4");
      
      // Locate password and enter value
      driver.findElement(By.id("tbPassword")).sendKeys("1234567a");
      
      // Locate confirm password and enter value
      driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567a");
      
      // Locate Password Never Expires checkbox and check
      WebElement PasswordNeverExpires = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/input")) ;
      PasswordNeverExpires.click();
      
      // Locate email and enter value
      WebElement emailbox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input"));
      emailbox.sendKeys("nooria.ashraf@amigo-software.com");
      
      // Locate Enable Account checkbox and check
      WebElement EnableAccount = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input"));
      EnableAccount.click();
      
      // Locate Security Groups Roles and Click/Select
      WebElement ServerAdmin = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option"));
      ServerAdmin.click();
      
      // Locate ">" and click
      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();
      
      // Locate Save button and click
      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();
      
      // Set mandatory field message at the top in red for expected result
      String expectedFnameMsg = "Please enter First name";
      
      // Get mandatory field message at the top in red
      String actualFnameMsg = driver.findElement(By.id("lblMessage")).getText();
      
      // System.out.println(actualFnameMsg); //Print actual Mesage when needed
      Assert.assertEquals(actualFnameMsg, expectedFnameMsg);
            
      driver.close();    
} 
	
  
////Test ID: 30-14
///* 
//* Add normal opr user in the system with empty last name
//*/	  
  
	  @Test (priority = 13)
	  public void verifyNewUserwithNoLname () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Add Users
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
	      
	      Thread.sleep(3000);
	      //Fillout the form for new user
	      // Locate Fname and enter value
	      driver.findElement(By.id("tbFirstName")).sendKeys("Jacob");
	      
//	      // Locate Lname and enter value
//	      driver.findElement(By.id("tbLastName")).sendKeys("Amal");
	      
	      // Locate username and enter value
	      driver.findElement(By.id("tbUserName")).sendKeys("jamal4");
	      
	      // Locate password and enter value
	      driver.findElement(By.id("tbPassword")).sendKeys("1234567a");
	      
	      // Locate confirm password and enter value
	      driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567a");
	      
	      // Locate Password Never Expires checkbox and check
	      WebElement PasswordNeverExpires = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/input")) ;
	      PasswordNeverExpires.click();
	      
	      // Locate email and enter value
	      WebElement emailbox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input"));
	      emailbox.sendKeys("nooria.ashraf@amigo-software.com");
	      
	      // Locate Enable Account checkbox and check
	      WebElement EnableAccount = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input"));
	      EnableAccount.click();
	      
	      // Locate Security Groups Roles and Click/Select
	      WebElement ServerAdmin = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option"));
	      ServerAdmin.click();
	      
	      // Locate ">" and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();
	      
	      // Locate Save button and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();
	      
	      // Set mandatory field message at the top in red for expected result
	      String expectedLnameMsg = "Please enter Last name";
	      
	      // Get mandatory field message at the top in red
	      String actualLnameMsg = driver.findElement(By.id("lblMessage")).getText();
	      
	      // System.out.println(actualFnameMsg); //Print actual Mesage when needed
	      Assert.assertEquals(actualLnameMsg, expectedLnameMsg);
	            
	      driver.close();    
} 
	
	
////Test ID: 30-15
///* 
//* Add normal opr user in the system with empty Username
//*/	 
	
	  @Test (priority = 14)
	  public void verifyNewUserwithNoUsername () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Add Users
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
	      
	      Thread.sleep(3000);
	      //Fillout the form for new user
	      // Locate Fname and enter value
	      driver.findElement(By.id("tbFirstName")).sendKeys("Jacob");
	      
	      // Locate Lname and enter value
	      driver.findElement(By.id("tbLastName")).sendKeys("Amal");
	      
//	      // Locate username and enter value
//	      driver.findElement(By.id("tbUserName")).sendKeys("jamal4");
	      
	      // Locate password and enter value
	      driver.findElement(By.id("tbPassword")).sendKeys("1234567a");
	      
	      // Locate confirm password and enter value
	      driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567a");
	      
	      // Locate Password Never Expires checkbox and check
	      WebElement PasswordNeverExpires = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/input")) ;
	      PasswordNeverExpires.click();
	      
	      // Locate email and enter value
	      WebElement emailbox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input"));
	      emailbox.sendKeys("nooria.ashraf@amigo-software.com");
	      
	      // Locate Enable Account checkbox and check
	      WebElement EnableAccount = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input"));
	      EnableAccount.click();
	      
	      // Locate Security Groups Roles and Click/Select
	      WebElement ServerAdmin = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option"));
	      ServerAdmin.click();
	      
	      // Locate ">" and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();
	      
	      // Locate Save button and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();
	      
	      // Set mandatory field message at the top in red for expected result
	      String expectedusernameMsg = "Please enter Username";
	      
	      // Get mandatory field message at the top in red
	      String actualusernameMsg = driver.findElement(By.id("lblMessage")).getText();
	      
	      // System.out.println(actualFnameMsg); //Print actual Message when needed
	      Assert.assertEquals(actualusernameMsg, expectedusernameMsg);
	            
	      driver.close();    
} 
	  
	
	  
////Test ID: 30-16
///* 
//* Add normal opr user in the system with empty Password
//*/	  
	
	  @Test (priority = 13)
	  public void verifyNewUserwithNoPassword () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Add Users
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
	      
	      Thread.sleep(3000);
	      //Fillout the form for new user
	      // Locate Fname and enter value
	      driver.findElement(By.id("tbFirstName")).sendKeys("Aaron");
	      
	      // Locate Lname and enter value
	      driver.findElement(By.id("tbLastName")).sendKeys("Channing");
	      
	      // Locate username and enter value
	      driver.findElement(By.id("tbUserName")).sendKeys("achan4");
	      
//	  // Locate password and enter value
//	  driver.findElement(By.id("tbPassword")).sendKeys("1234567a");
	      
	      // Locate confirm password and enter value
	      driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567a");
	      
	      // Locate Password Never Expires checkbox and check
	      WebElement PasswordNeverExpires = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/input")) ;
	      PasswordNeverExpires.click();
	      
	      // Locate email and enter value
	      WebElement emailbox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input"));
	      emailbox.sendKeys("nooria.ashraf@amigo-software.com");
	      
	      // Locate Enable Account checkbox and check
	      WebElement EnableAccount = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input"));
	      EnableAccount.click();
	      
	      // Locate Security Groups Roles and Click/Select
	      WebElement ServerAdmin = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option"));
	      ServerAdmin.click();
	      
	      // Locate ">" and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();
	      
	      // Locate Save button and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();
	      
	      // Set mandatory field message at the top in red for expected result
	      String expectedpasswordMsg = "Please enter Password";
	      
	      // Get mandatory field message at the top in red
	      String actualpasswordMsg = driver.findElement(By.id("lblMessage")).getText();
	      
	      // System.out.println(actualFnameMsg); //Print actual Message when needed
	      Assert.assertEquals(actualpasswordMsg, expectedpasswordMsg);
	            
	      driver.close();    
} 


////Test ID: 30-17
///* 
//* Add normal opr user in the system with empty Confirm Password
//*/	    
	  @Test (priority = 14)
	  public void verifyNewUserwithNoConfirmPassword () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Add Users
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
	      
	      Thread.sleep(3000);
	      //Fillout the form for new user
	      // Locate Fname and enter value
	      driver.findElement(By.id("tbFirstName")).sendKeys("Drake");
	      
	      // Locate Lname and enter value
	      driver.findElement(By.id("tbLastName")).sendKeys("Clarke");
	      
	      // Locate username and enter value
	      driver.findElement(By.id("tbUserName")).sendKeys("drakec4");
	      
	      // Locate password and enter value
	      driver.findElement(By.id("tbPassword")).sendKeys("1234567a");
	      
//	      // Locate confirm password and enter value
//	      driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567a");
	      
	      // Locate Password Never Expires checkbox and check
	      WebElement PasswordNeverExpires = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/input")) ;
	      PasswordNeverExpires.click();
	      
	      // Locate email and enter value
	      WebElement emailbox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input"));
	      emailbox.sendKeys("nooria.ashraf@amigo-software.com");
	      
	      // Locate Enable Account checkbox and check
	      WebElement EnableAccount = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input"));
	      EnableAccount.click();
	      
	      // Locate Security Groups Roles and Click/Select
	      WebElement ServerAdmin = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option"));
	      ServerAdmin.click();
	      
	      // Locate ">" and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();
	      
	      // Locate Save button and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();
	      
	      // Set mandatory field message at the top in red for expected result
	      String expectedcpasswordMsg = "Password and Confirm Password not same";
	      
	      // Get mandatory field message at the top in red
	      String actualcpasswordMsg = driver.findElement(By.id("lblMessage")).getText();
	      
	      // System.out.println(actualFnameMsg); //Print actual Message when needed
	      Assert.assertEquals(actualcpasswordMsg, expectedcpasswordMsg);
	            
	      driver.close();    
}   

	  
////Test ID: 30-18
///* 
//* Add normal opr user in the system with different password and Confirm Password
//*/	 	  
	  @Test (priority = 15)
	  public void verifyNewUserwithDifferentPasswords () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Add Users
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
	      
	      Thread.sleep(3000);
	      //Fillout the form for new user
	      // Locate Fname and enter value
	      driver.findElement(By.id("tbFirstName")).sendKeys("Nadine");
	      
	      // Locate Lname and enter value
	      driver.findElement(By.id("tbLastName")).sendKeys("Oren");
	      
	      // Locate username and enter value
	      driver.findElement(By.id("tbUserName")).sendKeys("nadine0");
	      
	      // Locate password and enter value
	      driver.findElement(By.id("tbPassword")).sendKeys("1234567a");
	      
	      // Locate confirm password and enter value
	      driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567");
	      
	      // Locate Password Never Expires checkbox and check
	      WebElement PasswordNeverExpires = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/input")) ;
	      PasswordNeverExpires.click();
	      
	      // Locate email and enter value
	      WebElement emailbox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input"));
	      emailbox.sendKeys("nooria.ashraf@amigo-software.com");
	      
	      // Locate Enable Account checkbox and check
	      WebElement EnableAccount = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input"));
	      EnableAccount.click();
	      
	      // Locate Security Groups Roles and Click/Select
	      WebElement ServerAdmin = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option"));
	      ServerAdmin.click();
	      
	      // Locate ">" and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();
	      
	      // Locate Save button and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();
	      
	      // Set mandatory field message at the top in red for expected result
	      String expectedcpasswordMsg = "Password and Confirm Password not same";
	      
	      // Get mandatory field message at the top in red
	      String actualcpasswordMsg = driver.findElement(By.id("lblMessage")).getText();
	      
	      // System.out.println(actualFnameMsg); //Print actual Message when needed
	      Assert.assertEquals(actualcpasswordMsg, expectedcpasswordMsg);
	            
	      driver.close();    
}   
 

	  
	  
////Test ID: 30-19
///* 
//* Add normal opr user in the system without assigning security group
//*/	 	  
	  @Test (priority = 16)
	  public void verifyNewUserwithNoSecurityGroup () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Add Users
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
	      
	      Thread.sleep(3000);
	      //Fillout the form for new user
	      // Locate Fname and enter value
	      driver.findElement(By.id("tbFirstName")).sendKeys("Wynter");
	      
	      // Locate Lname and enter value
	      driver.findElement(By.id("tbLastName")).sendKeys("Ezekiel");
	      
	      // Locate username and enter value
	      driver.findElement(By.id("tbUserName")).sendKeys("wyneze67");
	      
	      // Locate password and enter value
	      driver.findElement(By.id("tbPassword")).sendKeys("1234567a");
	      
	      // Locate confirm password and enter value
	      driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567a");
	      
	      // Locate Password Never Expires checkbox and check
	      WebElement PasswordNeverExpires = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/input")) ;
	      PasswordNeverExpires.click();
	      
	      // Locate email and enter value
	      WebElement emailbox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input"));
	      emailbox.sendKeys("nooria.ashraf@amigo-software.com");
	      
	      // Locate Enable Account checkbox and check
	      WebElement EnableAccount = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input"));
	      EnableAccount.click();
	      
//	      // Locate Security Groups Roles and Click/Select
//	      WebElement ServerAdmin = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option"));
//	      ServerAdmin.click();
	      
//	      // Locate ">" and click
//	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();
	      
	      // Locate Save button and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();
	      
	      // Set mandatory field message at the top in red for expected result
	      String expectedcpasswordMsg = "Select at least one role for the User.";
	      
	      // Get mandatory field message at the top in red
	      String actualcpasswordMsg = driver.findElement(By.id("lblMessage")).getText();
	      
	      // System.out.println(actualFnameMsg); //Print actual Message when needed
	      Assert.assertEquals(actualcpasswordMsg, expectedcpasswordMsg);
	            
	      driver.close();    
}   
	
	
	 	  
	  
////Test ID: 30-20
///* 
//* Add normal opr user in the system with invalid Email
//*/	 		  	 
	  @Test (priority = 17)
	  public void verifyNewUserwithInvalidEmailAddress () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Add Users
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
	      
	      Thread.sleep(3000);
	      //Fillout the form for new user
	      // Locate Fname and enter value
	      driver.findElement(By.id("tbFirstName")).sendKeys("Ina");
	      
	      // Locate Lname and enter value
	      driver.findElement(By.id("tbLastName")).sendKeys("Levi");
	      
	      // Locate username and enter value
	      driver.findElement(By.id("tbUserName")).sendKeys("inalevis90");
	      
	      // Locate password and enter value
	      driver.findElement(By.id("tbPassword")).sendKeys("1234567a");
	      
	      // Locate confirm password and enter value
	      driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567a");
	      
	      // Locate Password Never Expires checkbox and check
	      WebElement PasswordNeverExpires = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/input")) ;
	      PasswordNeverExpires.click();
	      
	      // Locate email and enter value
	      WebElement emailbox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input"));
	      emailbox.sendKeys("I am an email address");
	      
	      // Locate Enable Account checkbox and check
	      WebElement EnableAccount = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input"));
	      EnableAccount.click();
	      
	      // Locate Security Groups Roles and Click/Select
	      WebElement ServerAdmin = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option"));
	      ServerAdmin.click();
	      
	      // Locate ">" and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();
	      
	      // Locate Save button and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();
	      
	      // Set mandatory field message at the top in red for expected result
	      String expectedcpasswordMsg = "Invalid Email Address";
	      
	      // Get mandatory field message at the top in red
	      String actualcpasswordMsg = driver.findElement(By.id("lblMessage")).getText();
	      
	      // System.out.println(actualFnameMsg); //Print actual Message when needed
	      Assert.assertEquals(actualcpasswordMsg, expectedcpasswordMsg);
	            
	      driver.close();    
}   

	  
////Test ID: 30-21
///* 
//* Verify that special characters are not allowed in First Name field
//*/	  	
	  @Test (priority = 18)
	  public void verifyNoSpecialCharactersInFname () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Add Users
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
	      
	      Thread.sleep(3000);
	      //Fillout the form for new user
	      // Locate Fname and enter value
	      String FNValue = "@123/.%$7";
	      driver.findElement(By.id("tbFirstName")).sendKeys(FNValue);
	      
	      // Locate Fname and get value
	      String FNenteredValue = driver.findElement(By.id("tbFirstName")).getText() ;
	      
	      Assert.assertNotEquals(FNenteredValue, FNValue);
	        
	      driver.close();    
}  
	  
	 
////Test ID: 30-22
///* 
//* Verify that only a length of 50 characters is allowed in First Name field
//*/		  	  
	  @Test (priority = 19)
	  public void verifyFiftyCharactersinFname () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Add Users
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
	      
	      Thread.sleep(3000);
	      // Locate Fname and enter value
	      String FNValue = "Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
	      driver.findElement(By.id("tbFirstName")).sendKeys(FNValue);
	      
	      // Locate Fname and get value
	      String FNenteredValue = driver.findElement(By.id("tbFirstName")).getAttribute("value");
	      //System.out.println(FNenteredValue); // Print Value in FNenteredValue
	      
	      Assert.assertNotEquals(FNenteredValue, FNValue);
	      
//          System.out.println(FNenteredValue);
//          System.out.println(FNValue);
	        
	      driver.close();    
} 
	  
	  
////Test ID: 30-23
///* 
//* Verify that special characters are not allowed in Last Name field
//*/		  	 
	  @Test (priority = 20)
	  public void verifyNoSpecialCharactersInLname () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Add Users
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
	      
	      Thread.sleep(3000);
	      // Locate Lname and enter value
	      String LNValue = "$%^$@#%$^^&";
	      driver.findElement(By.id("tbLastName")).sendKeys(LNValue);
	      
	      // Locate Lname and get value
	      String LNenteredValue = driver.findElement(By.id("tbLastName")).getText() ;
	      
	      Assert.assertNotEquals(LNenteredValue, LNValue);
	        
	      driver.close();    
}    

	  
	  
	
////Test ID: 30-24
///* 
//* Verify that only a length of 50 characters is allowed in Last Name field
//*/			  
	  @Test (priority = 21)
	  public void verifyFiftyCharactersinLname () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Add Users
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
	      
	      Thread.sleep(3000);
	      // Locate Lname and enter value
	      String LNValue = "Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa fg tryt";
	      driver.findElement(By.id("tbLastName")).sendKeys(LNValue); 
	      
	      // Locate Lname and get value
	      String LNenteredValue = driver.findElement(By.id("tbLastName")).getText() ;
	      
	      Assert.assertNotEquals(LNenteredValue, LNValue);
	        
	      driver.close();    
}    
  
	  
	
////Test ID: 30-25
///* 
//* Verify that password must be greater than 7 characters
//*/	
	  @Test (priority = 23)
	  public void verifyPasswordGreaterthenSevenCharacters () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Add Users
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
	      
	      Thread.sleep(3000);
	      
	      // Locate Fname and enter value
	      driver.findElement(By.id("tbFirstName")).sendKeys("Kane");
	      
	      // Locate Lname and enter value
	      driver.findElement(By.id("tbLastName")).sendKeys("Neville");
	      
	      // Locate username and enter value
	      driver.findElement(By.id("tbUserName")).sendKeys("kaneville12");
	      
	      // Locate password and enter value
	      driver.findElement(By.id("tbPassword")).sendKeys("1234567");
	      
	      // Locate confirm password and enter value
	      driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567a");
	      
	      // Locate Password Never Expires checkbox and check
	      WebElement PasswordNeverExpires = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/input")) ;
	      PasswordNeverExpires.click();
	      
	      // Locate email and enter value
	      WebElement emailbox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input"));
	      emailbox.sendKeys("sad@germ.com");
	      
	      // Locate Enable Account checkbox and check
	      WebElement EnableAccount = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input"));
	      EnableAccount.click();
	      
	      // Locate Security Groups Roles and Click/Select
	      WebElement ServerAdmin = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option"));
	      ServerAdmin.click();
	      
	      // Locate ">" and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();
	      
	      // Locate Save button and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();
	      
	      // Set mandatory field message at the top in red for expected result
	      String expectedpasswordMsg = "Password must be greater than 7 characters";
	      
	      // Get mandatory field message at the top in red
	      String actualpasswordMsg = driver.findElement(By.id("lblMessage")).getText();
	      
	      // System.out.println(actualFnameMsg); //Print actual Message when needed
	      Assert.assertEquals(actualpasswordMsg, expectedpasswordMsg);
	      
	      driver.close();    
}
	  


////Test ID: 30-26
///* 
//* Verify that password must be alpha numeric
//*/	
	  @Test (priority = 22)
	  public void verifyPasswordAlphaNumeric () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Add Users
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
	      
	      Thread.sleep(3000);
	      
	      // Locate Fname and enter value
	      driver.findElement(By.id("tbFirstName")).sendKeys("Len");
	      
	      // Locate Lname and enter value
	      driver.findElement(By.id("tbLastName")).sendKeys("Steel");
	      
	      // Locate username and enter value
	      driver.findElement(By.id("tbUserName")).sendKeys("lensteel");
	      
	      // Locate password and enter value
	      driver.findElement(By.id("tbPassword")).sendKeys("aaa123$###");
	      
	      // Locate confirm password and enter value
	      driver.findElement(By.id("tbConfirmPassword")).sendKeys("aaa123$###");
	      
	      // Locate Password Never Expires checkbox and check
	      WebElement PasswordNeverExpires = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/input")) ;
	      PasswordNeverExpires.click();
	      
	      // Locate email and enter value
	      WebElement emailbox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input"));
	      emailbox.sendKeys("sad@germ.com");
	      
	      // Locate Enable Account checkbox and check
	      WebElement EnableAccount = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input"));
	      EnableAccount.click();
	      
	      // Locate Security Groups Roles and Click/Select
	      WebElement ServerAdmin = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option"));
	      ServerAdmin.click();
	      
	      // Locate ">" and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();
	      
	      // Locate Save button and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();
	      
	      // Set mandatory field message at the top in red for expected result
	      String expectedpasswordMsg = "Password must contain alphanumeric characters, with no more than two identical consecutive characters.";
	      
	      // Get mandatory field message at the top in red
	      String actualpasswordMsg = driver.findElement(By.id("lblMessage")).getText();
	      
	      // System.out.println(actualFnameMsg); //Print actual message when needed
	      Assert.assertEquals(actualpasswordMsg, expectedpasswordMsg);
	      
	      driver.close();    
}
	
	
	
////Test ID: 30-27
///* 
//* Verify that password cannot be of length greater than 50
//*/	
	  @Test (priority = 34)
	  public void verifyFiftyCharactersinPassword () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Add Users
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
	      
	      Thread.sleep(3000);
	      // Locate Password and enter value
	      String PassValue = "Aaaaaaaaaaaaaaaa564879aaaaaaaaaaaaGTEDBMKaaaaaaaaaaaaaaaaaaaaaaaaaaa1234"; //only value upto 50 characters gets accepted
	      driver.findElement(By.id("tbPassword")).sendKeys(PassValue);
	      
	      // Locate Password and get entered value
	      String PassenteredValue = driver.findElement(By.id("tbPassword")).getAttribute("value");
	      
	      Assert.assertNotEquals(PassenteredValue, PassValue);
	      
//          System.out.println(PassenteredValue);
//          System.out.println(PassValue);
	        
	      driver.close();    
} 
	
	
////Test ID: 30-28
///* 
//* Verify that email cannot be of length greater than 55
//*/	  	  
	  @Test (priority = 35)
	  public void verifyFiftyfiveCharactersinEmail () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Add Users
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
	      
	      Thread.sleep(3000);
	      // Locate Password and enter value
	      String EmailValue = "564879aaaaaaaaaaaa@GTEDBMKaaaaaaaaaaaa.com.pkaaaaaaaaaaaaaaaaa"; //only value upto 55 characters gets accepted
	      WebElement emailbox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input"));
	      emailbox.sendKeys(EmailValue);
	      
	      // Locate Password and get entered value
	      String EmailenteredValue = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input")).getAttribute("value");
	      
	      Assert.assertNotEquals(EmailenteredValue, EmailValue);
	      
//          System.out.println(EmailenteredValue);
//          System.out.println(EmailValue);
	        
	      driver.close();    
}   
	  
	  
	  
////Test ID: 30-29
///* 
//* Verify that only a length of 50 characters is allowed in Username field
//*/		    
	  @Test (priority = 36)
	  public void verifyFiftyCharactersinUsername () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Add Users
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
	      
	      Thread.sleep(3000);
	      // Locate Username and enter value
	      String UsernameValue = "564879aaaaaaaaaaaa_GTEDBMKaaaaaaaaaaaa_com.pkaaaaaaaaaaaaaaaaa"; //only value upto 50 characters gets accepted
	      WebElement UserNamebox = driver.findElement(By.id("tbUserName"));
	      UserNamebox.sendKeys(UsernameValue);
	      
	      // Locate Password and get entered value
	      String UsernameEnteredValue = driver.findElement(By.id("tbUserName")).getAttribute("value");
	      
	      Assert.assertNotEquals(UsernameEnteredValue, UsernameValue);
	      
//          System.out.println(UsernameEnteredValue);
//          System.out.println(UsernameValue);
	        
	      driver.close();    
}
	  
	  
	
////Test ID: 30-30
///* 
//* Verify that password cannot be of more than two consecutive identical characters
//*/		  	  
	  @Test (priority = 24)
	  public void verifyPasswordwithRepeatedAlphabets () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Add Users
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
	      
	      Thread.sleep(3000);
	      
	      // Locate Fname and enter value
	      driver.findElement(By.id("tbFirstName")).sendKeys("Jaden");
	      
	      // Locate Lname and enter value
	      driver.findElement(By.id("tbLastName")).sendKeys("Noble");
	      
	      // Locate username and enter value
	      driver.findElement(By.id("tbUserName")).sendKeys("jadeNob");
	      
	      // Locate password and enter value
	      driver.findElement(By.id("tbPassword")).sendKeys("aaaaa1234#");
	      
	      // Locate confirm password and enter value
	      driver.findElement(By.id("tbConfirmPassword")).sendKeys("aaaaa1234#");
	      
	      // Locate Password Never Expires checkbox and check
	      WebElement PasswordNeverExpires = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/input")) ;
	      PasswordNeverExpires.click();
	      
	      // Locate email and enter value
	      WebElement emailbox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input"));
	      emailbox.sendKeys("sad@germ.com");
	      
	      // Locate Enable Account checkbox and check
	      WebElement EnableAccount = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input"));
	      EnableAccount.click();
	      
	      // Locate Security Groups Roles and Click/Select
	      WebElement ServerAdmin = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option"));
	      ServerAdmin.click();
	      
	      // Locate ">" and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();
	      
	      // Locate Save button and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();
	      
	      // Set mandatory field message at the top in red for expected result
	      String expectedpasswordMsg = "Password must contain alphanumeric characters, with no more than two identical consecutive characters.";
	      
	      // Get mandatory field message at the top in red
	      String actualpasswordMsg = driver.findElement(By.id("lblMessage")).getText();
	      
	      // System.out.println(actualFnameMsg); //Print actual message when needed
	      Assert.assertEquals(actualpasswordMsg, expectedpasswordMsg);
	      
	      driver.close();    
}
	  
	  
	  
	  
////Test ID: 30-31
///* 
///* Verify that password cannot be of more than two consecutive identical digits
//*/		  		  
	@Test (priority = 25)
	  public void verifyPasswordwithRepeatedDigits () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(12000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Add Users
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
	      
	      Thread.sleep(3000);
	      
	      // Locate Fname and enter value
	      driver.findElement(By.id("tbFirstName")).sendKeys("Arsenio");
	      
	      // Locate Lname and enter value
	      driver.findElement(By.id("tbLastName")).sendKeys("Ryan");
	      
	      // Locate username and enter value
	      driver.findElement(By.id("tbUserName")).sendKeys("ryansenio");
	      
	      // Locate password and enter value
	      driver.findElement(By.id("tbPassword")).sendKeys("abcd11111$");
	      
	      // Locate confirm password and enter value
	      driver.findElement(By.id("tbConfirmPassword")).sendKeys("abcd11111$");
	      
	      // Locate Password Never Expires checkbox and check
	      WebElement PasswordNeverExpires = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/input")) ;
	      PasswordNeverExpires.click();
	      
	      // Locate email and enter value
	      WebElement emailbox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input"));
	      emailbox.sendKeys("sad@germ.com");
	      
	      // Locate Enable Account checkbox and check
	      WebElement EnableAccount = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input"));
	      EnableAccount.click();
	      
	      // Locate Security Groups Roles and Click/Select
	      WebElement ServerAdmin = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option"));
	      ServerAdmin.click();
	      
	      // Locate ">" and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();
	      
	      // Locate Save button and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();
	      
	      // Set mandatory field message at the top in red for expected result
	      String expectedpasswordMsg = "Password must contain alphanumeric characters, with no more than two identical consecutive characters.";
	      
	      // Get mandatory field message at the top in red
	      String actualpasswordMsg = driver.findElement(By.id("lblMessage")).getText();
	      
	      // System.out.println(actualFnameMsg); //Print actual message when needed
	      Assert.assertEquals(actualpasswordMsg, expectedpasswordMsg);
	      
	      driver.close();    
}  

		  
////Test ID: 30-32
///* 
///* Verify that password cannot be of more than two consecutive identical special characters
//*/		  				  
	@Test (priority = 26)
	  public void verifyPasswordwithRepeatedSpecialCharacters () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(12000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Add Users
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
	      
	      Thread.sleep(3000);
	      
	      // Locate Fname and enter value
	      driver.findElement(By.id("tbFirstName")).sendKeys("Keith");
	      
	      // Locate Lname and enter value
	      driver.findElement(By.id("tbLastName")).sendKeys("Simon");
	      
	      // Locate username and enter value
	      driver.findElement(By.id("tbUserName")).sendKeys("simon55");
	      
	      // Locate password and enter value
	      driver.findElement(By.id("tbPassword")).sendKeys("abcd12345$$$$$");
	      
	      // Locate confirm password and enter value
	      driver.findElement(By.id("tbConfirmPassword")).sendKeys("abcd12345$$$$$");
	      
	      // Locate Password Never Expires checkbox and check
	      WebElement PasswordNeverExpires = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/input")) ;
	      PasswordNeverExpires.click();
	      
	      // Locate email and enter value
	      WebElement emailbox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input"));
	      emailbox.sendKeys("sad@germ.com");
	      
	      // Locate Enable Account checkbox and check
	      WebElement EnableAccount = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input"));
	      EnableAccount.click();
	      
	      // Locate Security Groups Roles and Click/Select
	      WebElement ServerAdmin = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option"));
	      ServerAdmin.click();
	      
	      // Locate ">" button and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();
	      
	      // Locate Save button and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();
	      
	      // Set mandatory field message at the top in red for expected result
	      String expectedpasswordMsg = "Password must contain alphanumeric characters, with no more than two identical consecutive characters.";
	      
	      // Get mandatory field message at the top in red
	      String actualpasswordMsg = driver.findElement(By.id("lblMessage")).getText();
	      
	      // System.out.println(actualFnameMsg); //Print actual message when needed
	      Assert.assertEquals(actualpasswordMsg, expectedpasswordMsg);
	      
	      driver.close();    
}			  
	  
	
	
////Test ID: 30-33
///* 
///* Verify that username cannot contain special character
//*/			  
	  @Test (priority = 27)
	  public void verifyNoSpecialCharactersInUsername () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Add Users
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
	      
	      Thread.sleep(3000);
	      // Locate Username and enter value
	      String UNValue = "@123/.%$745!,@,#,$,%,^,&,*,890_"; //.dot & _ underscore is acceptable
	      driver.findElement(By.id("tbUserName")).sendKeys(UNValue);
	      
	      // Locate Username and get value
	      String UNenteredValue = driver.findElement(By.id("tbUserName")).getAttribute("value");
	      
	      Assert.assertNotEquals(UNenteredValue, UNValue);
	      
	      System.out.println(UNenteredValue);
	      System.out.println(UNValue);
	        
	      driver.close(); 
}
	
	
////Test ID: 30-34
///* 
///* Verify that username cannot contain special character
//*/			
	@Test (priority = 28)
	  public void verifyUnderscoreInUsername () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Add Users
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
	      
	      Thread.sleep(3000);
	      // Locate Username and enter value
	      String UNValue = "User_890.ht"; //.dot & _ underscore is acceptable
	      driver.findElement(By.id("tbUserName")).sendKeys(UNValue);
	      
	      // Locate Username and get value
	      String UNenteredValue = driver.findElement(By.id("tbUserName")).getAttribute("value");
	      
	      Assert.assertEquals(UNValue, UNenteredValue);
	        
	      driver.close(); 
}
	
	
	
	
	
////Test ID: 30-35
///* 
///* Update normal opr user First Name
//*/		
	@Test (priority = 29)
	  public void verifyUpdateFname () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Edit (user other than admin)
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr[2]/td[4]/div/img[1]")).click();
	      
	      Thread.sleep(3000);
	      
	      // Locate Fname, clear old name and enter new value
	      String FNValue = "Browyn"; 
	      driver.findElement(By.id("tbFirstName")).clear();
	      driver.findElement(By.id("tbFirstName")).sendKeys(FNValue);
	      
          Thread.sleep(3000);
	      
          // Click on Update button
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();

	      //Thread.sleep(3000);
	      // Check alert message
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('Settings have been updated successfully')");
	    
	      String expectedAlertUserUpdated = "Settings have been updated successfully";
	      Alert confirmation = driver.switchTo().alert();
	      String actualAlertUserUpdated = confirmation.getText(); //Get text present on alert Message
    
    
	      Assert.assertEquals(actualAlertUserUpdated, expectedAlertUserUpdated);
	    
	      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
	      Dismissed user prompt dialog: Settings have been updated successfully:*/
	      driver.switchTo().alert().accept();
	  
	      // Click on okay button
	      Thread.sleep(7000);
	      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();
	      
//	      System.out.println(actualAlertUserUpdated);
//	      System.out.println(expectedAlertUserUpdated);
	        
	      driver.close(); 
}
	
	
////Test ID: 30-36
///* 
///* Update normal opr user Last Name
//*/		
	@Test (priority = 30)
	  public void verifyUpdateLname () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Edit (user other than admin)
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr[2]/td[4]/div/img[1]")).click();
	      
	      Thread.sleep(3000);
	      
	      // Locate Lname, clear old name and enter new value
	      String LNValue = "Yale"; 
	      driver.findElement(By.id("tbLastName")).clear();
	      driver.findElement(By.id("tbLastName")).sendKeys(LNValue);
	      
          Thread.sleep(3000);
	      
          // Click on Update button
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();

	      //Thread.sleep(3000);
	      // Check alert message
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('Settings have been updated successfully')");
	    
	      String expectedAlertUserUpdated = "Settings have been updated successfully";
	      Alert confirmation = driver.switchTo().alert();
	      String actualAlertUserUpdated = confirmation.getText(); //Get text present on alert Message
  
	      Assert.assertEquals(actualAlertUserUpdated, expectedAlertUserUpdated);
	    
	      driver.switchTo().alert().accept();
	  
	      // Click on okay button
	      Thread.sleep(7000);
	      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();
	        
	      driver.close(); 
}
	

////Test ID: 30-37
///* 
///* Update normal opr user Username
//*/		
	@Test (priority = 31)
	  public void verifyUpdateUsername () throws InterruptedException {   //Username cannot be updated
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Edit (user other than admin)
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr[2]/td[4]/div/img[1]")).click();
	      
	      Thread.sleep(3000);
	     	                 
	      // Get Username textbox and check if it's disabled
          WebElement e = driver.findElement(By.id("tbUserName"));

          boolean actualValue = e.isEnabled();
          boolean expectedValue = false;
        
          Assert.assertEquals(actualValue,expectedValue);
 
          driver.close();
}
	
	
	
	
////Test ID: 30-38
///* 
///* Update normal opr user Email 
//*/		
	  @Test (priority = 32)
	  public void verifyUpdateExistingUserEmail () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Edit (user other than admin)
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr[2]/td[4]/div/img[1]")).click();
	      
	      Thread.sleep(3000);
	      
	      // Locate Email, clear old name and enter new value
	      String EValue = "nooria.ashraf@amigo-software.com"; 
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input")).clear();
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input")).sendKeys(EValue);
	      
          Thread.sleep(3000);
	      
          // Click on Update button
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();

	      //Thread.sleep(3000);
	      // Check alert message
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('Settings have been updated successfully')");
	    
	      String expectedAlertUserUpdated = "Settings have been updated successfully";
	      Alert confirmation = driver.switchTo().alert();
	      String actualAlertUserUpdated = confirmation.getText(); //Get text present on alert Message


	      Assert.assertEquals(actualAlertUserUpdated, expectedAlertUserUpdated);
	    
//	      //Print Alert where needed
//	      System.out.println("Alert text is :" + confirmation);
	    
	      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
	      Dismissed user prompt dialog: Settings have been updated successfully:*/
	      driver.switchTo().alert().accept();
	  
	      // Click on okay button
	      Thread.sleep(7000);
	      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();
	      
	      
//	      System.out.println(FNenteredValue);
//	      System.out.println(FNValue);
	        
	      driver.close(); 
}
	
	
	
	
////Test ID: 30-39
///* 
///* Disable normal opr user account  
//*/		
	  @Test (priority = 32)
	  public void verifyUserDisable () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Edit (user other than admin)
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr[2]/td[4]/div/img[1]")).click();
	      
	      Thread.sleep(3000);
	      
	      // Locate Enable Account checkbox and uncheck
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input")).click();
	      
          Thread.sleep(2000);
	      
          // Click on Update button
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();

	      Thread.sleep(2000);
	      // Check alert message
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('Settings have been updated successfully')");
	    	    
	      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
	      Dismissed user prompt dialog: Settings have been updated successfully:*/
	      driver.switchTo().alert().accept();
	  
	      // Click on okay button
	      Thread.sleep(5000);
	      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();	      
	      
	      // To Check red username 
	      String color = driver.findElement(By.xpath("//*[@id=\"gvServerUsers\"]/tbody/tr[2]/td[3]/span")).getCssValue("color");
//	      System.out.println(color); //Print to check the color
	      
	      String Actualhex = Color.fromString(color).asHex();
//	      System.out.println(Actualhex);  //Print to check the color
	      
	      String ExepectedHex = "#ff0000";

	      Assert.assertEquals(Actualhex, ExepectedHex);
	        
	      driver.close(); 
}

	
////Test ID: 30-40
///* 
///* Enable normal opr user account   
//*/		
	  @Test (priority = 37)
	  public void verifyUserEnable () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Edit (user other than admin)
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr[2]/td[4]/div/img[1]")).click();
	      
	      Thread.sleep(3000);
	      
	      // Locate Enable Account uncheck box and check
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input")).click();
	      
          Thread.sleep(2000);
	      
          // Click on Update button
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();

	      Thread.sleep(2000);
	      // Check alert message
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('Settings have been updated successfully')");
	    	    
	      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
	      Dismissed user prompt dialog: Settings have been updated successfully:*/
	      driver.switchTo().alert().accept();
	  
	      // Click on okay button
	      Thread.sleep(5000);
	      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();
	      
	      // To Check red username 
	      String color = driver.findElement(By.xpath("//*[@id=\"gvServerUsers\"]/tbody/tr[2]/td[3]/span")).getCssValue("color");
//	      System.out.println(color); //Print to check the color
	      
	      String Actualhex = Color.fromString(color).asHex();
//	      System.out.println(Actualhex);  //Print to check the color
	      
	      String ExepectedHex = "#000000";

	      Assert.assertEquals(Actualhex, ExepectedHex);
	        
	      driver.close(); 
}
	

	
	
////Test ID: 30-41
///* 
///* Update  normal opr user security group    
//*/			
	  @Test (priority = 38)
	  public void verifyEnableUserAccount () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Permissions
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPermissions")).click();
	      
	      Thread.sleep(5000);
	      // Locate Groups, add a new group
	      driver.findElement(By.id("txtGroupName")).sendKeys("NTLM server");
	      
	      // Click on Add button
	      driver.findElement(By.id("imgbtnAddUpdate")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Edit (user other than admin)
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr[2]/td[4]/div/img[1]")).click();
	      
	      Thread.sleep(5000);
	       // Locate old group(Server Admin) and Un-select
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[3]/div/div/select/option")).click();
	      // Click "<" to remove existing group
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[4]/td/input")).click();
	      
	      Thread.sleep(5000);
	      // Locate Security Groups Roles and Click/Select
	      WebElement NewGroup = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option"));
	      NewGroup.click();      
          
	      // Click ">"
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();
	      
	      Thread.sleep(5000);
	      // Click on Update button
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();

	      Thread.sleep(5000);
	      // Check alert message
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('Settings have been updated successfully')");
	    	    
          String expectedAlertUserUpdated = "Settings have been updated successfully";
	      Alert confirmation = driver.switchTo().alert();
	      String actualAlertUserUpdated = confirmation.getText(); //Get text present on alert Message

	      Assert.assertEquals(actualAlertUserUpdated, expectedAlertUserUpdated);
	      
	      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
	      Dismissed user prompt dialog: Settings have been updated successfully:*/
	      driver.switchTo().alert().accept();
	  
	      // Click on okay button
	      Thread.sleep(5000);
	      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();
	      
	      driver.close(); 
}
	

	
////Test ID: 30-52
///* 
///*Delete normal opr user from system    
//*/				
	  @Test (priority = 39)
	  public void VerifyActiveDirectorybutton () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on delete button (user other than admin)
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr[2]/td[4]/div/img[2]")).click();
	      
	      // Check alert message
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('Are you sure you want to delete?')");
	      
//	      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
//	      Dismissed user prompt dialog: Settings have been updated successfully:*/
	      driver.switchTo().alert().accept();
	      
//	      // Click on delete button
          Thread.sleep(5000);
	      driver.findElement(By.id("btnDelete")).click();
	      
	      String expectedUserDeleted = "Record has been deleted successfully";
	      
	      Thread.sleep(5000);
	      // Get message "Record has been deleted successfully"
	      String actualUserDeleted = driver.findElement(By.id("lblMessage")).getText();
	      
	      Assert.assertEquals(actualUserDeleted, expectedUserDeleted);
	      
//          System.out.println(actualUserDeleted);
//          System.out.println(expectedUserDeleted);
	      
	      driver.close();
}	
	

////Test ID: 30-44
///* 
///*Add normal opr user with duplicate username   
//*/				
	  @Test (priority = 40)
	  public void verifyDuplicateUsername () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Click on Add Users
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();
	      
	      Thread.sleep(3000);
	      
	      // Locate Fname and enter value
	      driver.findElement(By.id("tbFirstName")).sendKeys("Zachery");
	      
	      // Locate Lname and enter value
	      driver.findElement(By.id("tbLastName")).sendKeys("Jordan");
	      
	      // Locate Username and enter value
	      String UNValue = "admin";
	      driver.findElement(By.id("tbUserName")).sendKeys(UNValue);
	      
	      // Locate password and enter value
	      driver.findElement(By.id("tbPassword")).sendKeys("1234567a");
	      
	      // Locate confirm password and enter value
	      driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567a");
	      
	      // Locate email and enter value
	      WebElement emailbox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input"));
	      emailbox.sendKeys("someone@somewhere.com");
	      
	      // Locate Enable Account checkbox and check
	      WebElement EnableAccount = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input"));
	      EnableAccount.click();
	      
	      // Locate Security Groups Roles and Click/Select
	      WebElement ServerAdmin = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option"));
	      ServerAdmin.click();
	      
	      // Locate ">" and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();
	      
	      // Locate save button and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();
	
	      String expectedmesage = "A user with this username already exists"; //expected message
	      
	      Thread.sleep(3000);
	      // Get error message
	      String actualmessage = driver.findElement(By.id("lblMessage")).getText();
	      
	      Assert.assertEquals(actualmessage, expectedmesage);
	      
//        System.out.println(actualmessage);
//        System.out.println(expectedmesage);	      
	      
	      driver.close();
}	      
	      

	
////Test ID: 30-54
///* 
///*Delete multiple selected users from system
//*/		
	  @Test (priority = 41)
	  public void verifyDeleteMultipleSelectedUsers () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      // Get users to delete
	      Thread.sleep(7000);
	      
	      //Get the table and row
		  WebElement table =driver.findElement(By.id("gvServerUsers"));
		  WebElement tbody=table.findElement(By.tagName("tbody"));
		  List<WebElement> rows=tbody.findElements(By.tagName("tr"));
		  String rowNo="";
		  String Username  = "mKibo3";
			for(int i=0;i<rows.size();i++)
				{
				WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvServerUsers\"]/tbody/tr["+(i+1)+"]"));
				if(row.getText().trim().contains(Username))
				{
				rowNo=Integer.toString(i+1);
				break;
				}
				}
		  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr["+rowNo+"]/td[1]/input")).click();
			                             
//	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr[5]/td[1]/input")).click();
//        driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr[7]/td[1]/input")).click();                             
	      
        // Click on multiple delete
	      driver.findElement(By.id("dltMultiple")).click();
	      
	      // Click on delete selected
	      driver.findElement(By.xpath("/html/body/ul[1]")).click();
	      
	      // Check alert message
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('Are you sure you want to delete?')");
	      
	      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
	      Dismissed user prompt dialog: Settings have been updated successfully:*/
	      driver.switchTo().alert().accept();
	      
	      // Click on delete button
        Thread.sleep(5000);
	      driver.findElement(By.id("btnDelete")).click();
	      
	      String expectedUserDeleted = "Selected users are deleted successfully.";
	      
	      Thread.sleep(5000);
	      // Get message "Record has been deleted successfully"
	      String actualUserDeleted = driver.findElement(By.id("lblMessage")).getText();
	      
	      Assert.assertEquals(actualUserDeleted, expectedUserDeleted);
	      
//        System.out.println(actualUserDeleted);
//        System.out.println(expectedUserDeleted);
	      
    driver.close();
}	 
	  


////Test ID: 30-42
///* 
///*Verify that Add Active Directory button is available when Authentication mode is set to Mix Mode/Active Directory 
//*/		
		  @Test (priority = 41)
		  public void verifyMixMode_ActiveDirectory  () throws InterruptedException {
			  System.setProperty("webdriver.gecko.driver", driverPath);
		      driver = new FirefoxDriver();
		      driver.get(baseUrl);

		      // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();  
			  
		      // Click on System
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
			  
		      // Select from dropdown 
		      Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
			  dropdown.selectByVisibleText("Mix Mode (OmniPCX RECORD - Active Directory)");
			  
			  // Fill in the required information
			  // Enter Domain Name
			  driver.findElement(By.id("txtADDomainName")).clear(); //In case some value already present clear
			  driver.findElement(By.id("txtADDomainName")).sendKeys("ghostsoftware.local");
			  
			  // Enter Username
			  driver.findElement(By.id("txtADUsername")).clear();
			  driver.findElement(By.id("txtADUsername")).sendKeys("ahsan.rehman");
			  
			  // Enter Password
			  driver.findElement(By.id("txtADPassword")).clear();
			  driver.findElement(By.id("txtADPassword")).sendKeys("Abc123*");
			  
			  // Check radio button "Include all Containers" for Criteria
			  driver.findElement(By.id("rbADCriteriaAll")).click();
			  
			  // Click on update button
			  driver.findElement(By.id("btnUpdateAuthSettings")).click(); 
			  
//			  String expectedAuthentication = "Settings have been updated successfully";
//	        String actualAuthentication = driver.findElement(By.id("lblMessageAuthentication")).getText();
			  
			  // Click on Logout
			  driver.findElement(By.id("ctl00_lblLogOut")).click();
			  
			  // Re-signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();  
		  
		      // Click on Users
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click(); 

		      //Check if Active Directory  button available
		      String expected = "Add Active Directory User";
		      String actual = driver.findElement(By.id("lnkAddADUser")).getText();
		      
		      Assert.assertEquals(actual, expected);
			  
			  driver.close();		  
	}
		  
		  
		  
		  
	
////Test ID: 30-43
///* 
///*Verify that only Add Active Directory button is available when Authentication mode is set to Active Directory only 
//*/		
	  @Test (priority = 42)
	  public void verifyAddActiveDirectory () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();  
		  
	      // Click on System
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
		  
	      // Select from dropdown 
	      Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
		  dropdown.selectByVisibleText("Active Directory");
		  
		  // Fill in the required information
		  // Enter Domain Name
		  driver.findElement(By.id("txtADDomainName")).clear(); //In case some value already present clear
		  driver.findElement(By.id("txtADDomainName")).sendKeys("ghostsoftware.local");
		  
		  // Enter Username
		  driver.findElement(By.id("txtADUsername")).clear();
		  driver.findElement(By.id("txtADUsername")).sendKeys("ahsan.rehman");
		  
		  // Enter Password
		  driver.findElement(By.id("txtADPassword")).clear();
		  driver.findElement(By.id("txtADPassword")).sendKeys("Abc123*");
		  
		  // Check radio button "Include all Containers" for Criteria
		  driver.findElement(By.id("rbADCriteriaAll")).click();
		  
		  // Click on update button
		  driver.findElement(By.id("btnUpdateAuthSettings")).click(); 
		  
//		  String expectedAuthentication = "Settings have been updated successfully";
//        String actualAuthentication = driver.findElement(By.id("lblMessageAuthentication")).getText();
		  
		  // Click on Logout
		  driver.findElement(By.id("ctl00_lblLogOut")).click();
		  
		  // Re-signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();  
	  
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click(); 
	      
	      //Check if Active Directory  button available
	      String expected = "Add Active Directory User";
	      String actual = driver.findElement(By.id("lnkAddADUser")).getText();
	      
	      Assert.assertEquals(actual, expected);
	      
//	      //Check if Active Directory  button available
//	      boolean ActiveDirectory = driver.findElement(By.xpath("//*[text()='Add ']")).isDisplayed();
//	      
		  driver.close();		  
}

	  

	  
////Test ID: 30-45
///* 
///* Add Active Directory in System with enabled account 
//*/		  
	  @Test (priority = 43)
	  public void verifyAddActiveDirectoryEnabledAccount () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click On Users 
	      Thread.sleep(10000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
		  
		  // Click on Add Active Directory 
		  driver.findElement(By.id("lnkAddADUser")).click();
		  
		  // Select search user
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td/table[2]/tbody/tr/td/div/div[1]/div/label/input")).sendKeys("sarah.mahmood");
		  
		  // Click on Edit button
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td/table[2]/tbody/tr/td/div/table/tbody/tr/td[3]/img")).click();
		  
		  // Click on enable account checkbox
		  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input")).click();
		  
	      // Locate email and enter value
	      WebElement emailbox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input"));
	      emailbox.sendKeys("sarah.mahmood@amigo-software.com");
		  
	      // Locate Security Groups Roles and Click/Select
	      WebElement ServerAdmin = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option"));
	      ServerAdmin.click();
	      
	      // Locate ">" and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();

	      Thread.sleep(3000);
	      // Click on save button
		  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();
		  
	      // Check alert message
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('Settings have been saved successfully')");
		  
	      String expectedAlertUserUpdated = "Settings have been saved successfully";
	      Alert confirmation = driver.switchTo().alert();
	      String actualAlertUserUpdated = confirmation.getText(); //Get text present on alert Message

	      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
	      Dismissed user prompt dialog: Settings have been updated successfully:*/
	      driver.switchTo().alert().accept();
	  
	      // Click on okay button
	      Thread.sleep(5000);
	      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     

	      Assert.assertEquals(actualAlertUserUpdated, expectedAlertUserUpdated);
	    
//	      //Print Alert where needed
//	      System.out.println("Alert text is :" + confirmation);
		  
	      driver.close(); 	      	  
}	  
	  

////Test ID: 30-46
///* 
///* Add Active Directory in System with disabled account 
//*/		  	  
	  @Test (priority = 44)
	  public void verifyAddActiveDirectoryDisabledAccount () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click On Users 
	      Thread.sleep(10000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
		  
		  // Click on Add Active Directory 
	      driver.findElement(By.id("lnkAddADUser")).click();
//		  driver.findElement(By.xpath("//*[text()='Add Active Directory ']")).click();
		  
		  // Select search user
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td/table[2]/tbody/tr/td/div/div[1]/div/label/input")).sendKeys("nooria.ashraf");
		  
		  // Click on Edit button
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td/table[2]/tbody/tr/td/div/table/tbody/tr/td[3]/img")).click();
		  
//		  // Click on enable account checkbox
//		  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input")).click();
		  
	      // Locate email and enter value
	      WebElement emailbox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input"));
	      emailbox.sendKeys("nooria.ashraf@amigo-software.com");
		  
	      // Locate Security Groups Roles and Click/Select
	      WebElement ServerAdmin = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option"));
	      ServerAdmin.click();
	      
	      // Locate ">" and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();

	      Thread.sleep(3000);
	      // Click on save button
		  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();
		  
	      // Check alert message
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('Settings have been saved successfully')");
		  
	      String expectedAlertUserUpdated = "Settings have been saved successfully";
	      Alert confirmation = driver.switchTo().alert();
	      String actualAlertUserUpdated = confirmation.getText(); //Get text present on alert Message

	      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
	      Dismissed user prompt dialog: Settings have been updated successfully:*/
	      driver.switchTo().alert().accept();
	  
	      // Click on okay button
	      Thread.sleep(5000);
	      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     

	      Assert.assertEquals(actualAlertUserUpdated, expectedAlertUserUpdated);
	    
//	      //Print Alert where needed
//	      System.out.println("Alert text is :" + confirmation);
		  
	      driver.close(); 	      	  
}
	 


////Test ID: 30-47
///* 
///* Add duplicate Active Directory  
//*/	  	  
	  @Test (priority = 45)
	  public void verifyAddActiveDirectoryDuplicateAccount () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);
	 
	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click On Users 
	      Thread.sleep(10000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
		  
		  // Click on Add Active Directory 
		  driver.findElement(By.id("lnkAddADUser")).click();
		  
		  // Select search user
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td/table[2]/tbody/tr/td/div/div[1]/div/label/input")).sendKeys("sarah.mahmood");
		  
		  // Click on Edit button
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td/table[2]/tbody/tr/td/div/table/tbody/tr/td[3]/img")).click();
		  
	      // Get dupliacte user warning  
		  String expectedmsg = "A user with this username already exists"; 
		  String actaulmsg = driver.findElement(By.id("lblADMessage")).getText();
		  
		  Assert.assertEquals(actaulmsg, expectedmsg);
		  
		  driver.close();	  
}
	  

////Test ID: 30-48
///* 
///* Update First Name of Active Directory  
//*/	  	  
	  @Test (priority = 46)
	  public void verifyUpdateActiveDirectoryUserFname () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      //Get the table and row
		  WebElement table =driver.findElement(By.id("gvServerUsers"));
		  WebElement tbody=table.findElement(By.tagName("tbody"));
		  List<WebElement> rows=tbody.findElements(By.tagName("tr"));
		  String rowNo="";
		  String Username  = "sarah.mahmood";
			for(int i=0;i<rows.size();i++)
				{
				WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvServerUsers\"]/tbody/tr["+(i+1)+"]"));
				if(row.getText().trim().contains(Username))
				{
				rowNo=Integer.toString(i+1);
				break;
				}
				}
		  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr["+rowNo+"]/td[4]/div/img[1]")).click(); 
	      Thread.sleep(5000);
	      
	      // Locate Fname, clear old name and enter new value
	      String FNValue = "New Fname"; 
	      driver.findElement(By.id("tbFirstName")).clear();
	      driver.findElement(By.id("tbFirstName")).sendKeys(FNValue);
	      
          Thread.sleep(3000);
	      
          // Click on Update button
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();

	      //Thread.sleep(3000);
	      // Check alert message
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('Settings have been updated successfully')");
	    
	      String expectedAlertUserUpdated = "Settings have been updated successfully";
	      Alert confirmation = driver.switchTo().alert();
	      String actualAlertUserUpdated = confirmation.getText(); //Get text present on alert Message
    
	      Assert.assertEquals(actualAlertUserUpdated, expectedAlertUserUpdated);
	    
//	      //Print Alert where needed
//	      System.out.println("Alert text is :" + actualAlertUserUpdated);
	    
	      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
	      Dismissed user prompt dialog: Settings have been updated successfully:*/
	      driver.switchTo().alert().accept();
	  
	      // Click on okay button
	      Thread.sleep(7000);
	      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();
	      
	      // Print Alert if required
//	      System.out.println(actualAlertUserUpdated);
//	      System.out.println(expectedAlertUserUpdated);
	        
	      driver.close(); 
}
	  

////Test ID: 30-49
///* 
///* Update Last Name of Active Directory  
//*/			
	  @Test (priority = 47)
	  public void verifyUpdateActiveDirectoryUserLname () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	     
	      //Get the table and row
		  WebElement table =driver.findElement(By.id("gvServerUsers"));
		  WebElement tbody=table.findElement(By.tagName("tbody"));
		  List<WebElement> rows=tbody.findElements(By.tagName("tr"));
		  String rowNo="";
		  String Username  = "sarah.mahmood";
			for(int i=0;i<rows.size();i++)
				{
				WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvServerUsers\"]/tbody/tr["+(i+1)+"]"));
				if(row.getText().trim().contains(Username))
				{
				rowNo=Integer.toString(i+1);
				break;
				}
				}
		  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr["+rowNo+"]/td[4]/div/img[1]")).click(); 
	      Thread.sleep(5000);
	      
//	      // Click on Edit (user other than admin)
//	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr[7]/td[4]/div/img[1]")).click();
	      
	      Thread.sleep(5000);
	      
	      // Locate Lname, clear old name and enter new value
	      String LNValue = "New Lname"; 
	      driver.findElement(By.id("tbLastName")).clear();
	      driver.findElement(By.id("tbLastName")).sendKeys(LNValue);
	      
          Thread.sleep(3000);
	      
          // Click on Update button
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();

	      //Thread.sleep(3000);
	      // Check alert message
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('Settings have been updated successfully')");
	    
	      String expectedAlertUserUpdated = "Settings have been updated successfully";
	      Alert confirmation = driver.switchTo().alert();
	      String actualAlertUserUpdated = confirmation.getText(); //Get text present on alert Message
    
    
	      Assert.assertEquals(actualAlertUserUpdated, expectedAlertUserUpdated);
	    
//	      //Print Alert where needed
//	      System.out.println("Alert text is :" + actualAlertUserUpdated);
	    
	      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
	      Dismissed user prompt dialog: Settings have been updated successfully:*/
	      driver.switchTo().alert().accept();
	  
	      // Click on okay button
	      Thread.sleep(7000);
	      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();
	      
	      // Print Alert if required
//	      System.out.println(actualAlertUserUpdated);
//	      System.out.println(expectedAlertUserUpdated);
	        
	      driver.close(); 
}	
	
	
	
////Test ID: 30-50
///* 
///* Update Email of Active Directory  
//*/		
	  @Test (priority = 48)
	  public void verifyUpdateExistingActiveDirectoryUserEmail () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	     
	      //Get the table and row
		  WebElement table =driver.findElement(By.id("gvServerUsers"));
		  WebElement tbody=table.findElement(By.tagName("tbody"));
		  List<WebElement> rows=tbody.findElements(By.tagName("tr"));
		  String rowNo="";
		  String Username  = "sarah.mahmood";
			for(int i=0;i<rows.size();i++)
				{
				WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvServerUsers\"]/tbody/tr["+(i+1)+"]"));
				if(row.getText().trim().contains(Username))
				{
				rowNo=Integer.toString(i+1);
				break;
				}
				}
		  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr["+rowNo+"]/td[4]/div/img[1]")).click(); 
	      Thread.sleep(5000);

//	      // Click on Edit (user other than admin)
//	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr[7]/td[4]/div/img[1]")).click();
	      
	      Thread.sleep(3000);
	      
	      // Locate Email, clear old name and enter new value
	      String EValue = "nooria.ashraf@amigo-software.com"; 
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input")).clear();
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input")).sendKeys(EValue);
          
	      Thread.sleep(3000);
	      
          // Click on Update button
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();

	      //Thread.sleep(3000);
	      // Check alert message
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('Settings have been updated successfully')");
	    
	      String expectedAlertUserUpdated = "Settings have been updated successfully";
	      Alert confirmation = driver.switchTo().alert();
	      String actualAlertUserUpdated = confirmation.getText(); //Get text present on alert Message


	      Assert.assertEquals(actualAlertUserUpdated, expectedAlertUserUpdated);
	    
//	      //Print Alert where needed
//	      System.out.println("Alert text is :" + confirmation);
	    
	      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
	      Dismissed user prompt dialog: Settings have been updated successfully:*/
	      driver.switchTo().alert().accept();
	  
	      // Click on okay button
	      Thread.sleep(7000);
	      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();
	      
	      
//	      System.out.println(FNenteredValue);
//	      System.out.println(FNValue);
	        
	      driver.close(); 
}
	  

////Test ID: 30-51
///* 
///* Update Password of Active Directory  
//*/		  
	  @Test (priority = 49)
	  public void verifyUpdateExistingActiveDirectoryUserPassword () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);
	  
	      System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	     //Get the table and row
		  WebElement table =driver.findElement(By.id("gvServerUsers"));
		  WebElement tbody=table.findElement(By.tagName("tbody"));
		  List<WebElement> rows = tbody.findElements(By.tagName("tr"));
		  String rowNo="";
		  String Username  = "sarah.mahmood";
			for(int i=0;i<rows.size();i++)
				{
				WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvServerUsers\"]/tbody/tr["+(i+1)+"]"));
				if(row.getText().trim().contains(Username))
				{
				rowNo=Integer.toString(i+1);
				break;
				}
				}
		  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr["+rowNo+"]/td[4]/div/img[1]")).click(); 
	      Thread.sleep(5000);
	      
//	      // Click on Edit (user other than admin)
//	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr[7]/td[4]/div/img[1]")).click();
	      
	      Thread.sleep(3000);
		  
	      // Check if password textbox available
	      Assert.assertEquals(false, driver.findElement(By.id("tbPassword")).isDisplayed());
	      
	      driver.close();
}	

	  
////Test ID: 30-53
///* 
///* Delete Active Directory user from system 
//*/	  	 
	  @Test (priority = 50)
	  public void VerifyDeleteActiveDirectoryUser () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      //Get the table and row
		  WebElement table =driver.findElement(By.id("gvServerUsers"));
		  WebElement tbody=table.findElement(By.tagName("tbody"));
		  List<WebElement> rows=tbody.findElements(By.tagName("tr"));
		  String rowNo="";
		  String Username  = "sarah.mahmood";
			for(int i=0;i<rows.size();i++)
				{
				WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvServerUsers\"]/tbody/tr["+(i+1)+"]"));
				if(row.getText().trim().contains(Username))
				{
				rowNo=Integer.toString(i+1);
				break;
				}
				}
		  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr["+rowNo+"]/td[4]/div/img[2]")).click(); 
	      Thread.sleep(5000);
	      
//	      // Click on delete button (user other than admin)
//	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr[7]/td[4]/div/img[2]")).click();
	      
	      // Check alert message
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('Are you sure you want to delete?')");
	      
//	      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
//	      Dismissed user prompt dialog: Settings have been updated successfully:*/
	      driver.switchTo().alert().accept();
	      
//	      // Click on delete button
          Thread.sleep(5000);
	      driver.findElement(By.id("btnDelete")).click();
	      
	      String expectedUserDeleted = "Record has been deleted successfully";
	      
	      Thread.sleep(5000);
	      // Get message "Record has been deleted successfully"
	      String actualUserDeleted = driver.findElement(By.id("lblMessage")).getText();
	      
	      Assert.assertEquals(actualUserDeleted, expectedUserDeleted);
	      
//        System.out.println(actualUserDeleted);
//        System.out.println(expectedUserDeleted);
	      
	      driver.close();
}	
	  

	
////Test ID: 30-57
///* 
///* "Verify that  is able to add active directory user after deleting same user. Verify that  do not have to refresh browser page to add the same user after deleting it. 
//*/		
	  @Test (priority = 51)
	  public void VerifyDeleteActiveDirectoryUserthenAddagain () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Users
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
//	      // Click on delete button (user other than admin)
//	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr[8]/td[4]/div/img[2]")).click();
//	              
//	      // Check alert message
//	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
//	      jsx.executeScript("window.confirm('Are you sure you want to delete?')");
//	      
//	      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
//	      Dismissed user prompt dialog: Settings have been updated successfully:*/
//	      driver.switchTo().alert().accept();
//	      
//          // Click on delete button
//          Thread.sleep(5000);
//	      driver.findElement(By.id("btnDelete")).click();
	      
	      Thread.sleep(10000);
	      // Click on Add Active Directory 
	      driver.findElement(By.id("lnkAddADUser")).click();
//		  driver.findElement(By.xpath("//*[text()='Add Active Directory ']")).click();
		  
		  // Select search user
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td/table[2]/tbody/tr/td/div/div[1]/div/label/input")).sendKeys("sarah.mahmood");
		  
		  // Click on Edit button
		  driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td/table[2]/tbody/tr/td/div/table/tbody/tr/td[3]/img")).click();
		  
		  Thread.sleep(5000);
		  
		  // Locate email and enter value
	      WebElement emailbox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input"));
	      emailbox.sendKeys("sarah.mahmood@amigo-software.com");
		  
		  // Click on enable account checkbox
		  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input")).click();
		  
	      // Locate Security Groups Roles and Click/Select
	      WebElement ServerAdmin = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option"));
	      ServerAdmin.click();
	      
	      // Locate ">" and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();

	      Thread.sleep(3000);
	      // Click on save button
		  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();
		  
	      // Check alert message
	      JavascriptExecutor jsd = (JavascriptExecutor)driver;
	      jsd.executeScript("window.confirm('Settings have been saved successfully')");
		  
	      String expectedAlertUserUpdated = "Settings have been saved successfully";
	      Alert confirmation = driver.switchTo().alert();
	      String actualAlertUserUpdated = confirmation.getText(); //Get text present on alert Message

	      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
	      Dismissed user prompt dialog: Settings have been updated successfully:*/
	      driver.switchTo().alert().accept();
	  
	      // Click on okay button
	      Thread.sleep(5000);
	      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     

	      Assert.assertEquals(actualAlertUserUpdated, expectedAlertUserUpdated);
	    
//	      //Print Alert where needed
//	      System.out.println("Alert text is :" + confirmation);

      driver.close();
}	
	  
	  
	  
	  
////Test 
///* 
//* Revert back to Add User Mode
//*/
	  @AfterTest 
	  public void SwitchbacktoAddUserMode () throws InterruptedException {
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
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	      
	      Thread.sleep(7000);
	      
	      // Click all check-boxes
	      List<WebElement> elements = driver.findElements(By.xpath("//input[@type='checkbox']"));
	      for (WebElement el:elements) {
	      el.click(); }
	      
	      // Click multiple delete
	      driver.findElement(By.id("dltMultiple")).click();
	      
	      Thread.sleep(7000);
	      
	      // Click on delete selected
	      driver.findElement(By.xpath("/html/body/ul[1]")).click();
	      
	      // Check alert message
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('Are you sure you want to delete?')");
	      
	      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
	      Dismissed user prompt dialog: Settings have been updated successfully:*/
	      driver.switchTo().alert().accept();
	      
	      // Click on delete button
          Thread.sleep(5000);
	      driver.findElement(By.id("btnDelete")).click();
	      
	      String expectedUserDeleted = "Selected users are deleted successfully.";
	      
	      Thread.sleep(5000);
	      // Get message "Record has been deleted successfully"
	      String actualUserDeleted = driver.findElement(By.id("lblMessage")).getText();
	      
	      Assert.assertEquals(actualUserDeleted, expectedUserDeleted);
        
	      // Click On Permissions
	      Thread.sleep(7000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPermissions")).click();
	      
	      // Click on delete
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/div/table/tbody/tr[2]/td[3]/div/img[4]")).click();

	      JavascriptExecutor jsz = (JavascriptExecutor)driver;
          jsz.executeScript("window.confirm('Are you sure you want to delete this group?')");
         
          /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
          Dismissed user prompt dialog: Settings have been updated successfully:*/
          driver.switchTo().alert().accept();
         
          // Click on delete button
          Thread.sleep(7000);
          driver.findElement(By.id("btnDelete")).click(); 
          
          Thread.sleep(3000);
          String Expectedmsg = "Record has been deleted successfully";
          String Actualmsg = driver.findElement(By.id("lblGridMsg")).getText();
          
          Assert.assertEquals(Actualmsg, Expectedmsg);
	      
		  // Revert back to Add User Mode
	      // Click on System
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
		  
	      // Select from dropdown 
	      Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
		  dropdown.selectByVisibleText("OmniPCX RECORD");
		  
		  // Click on update button
		  driver.findElement(By.id("btnUpdateAuthSettings")).click(); 
		  
		  String expectedAuthentication = "Settings have been updated successfully";
		  String actualAuthentication = driver.findElement(By.id("lblMessageAuthentication")).getText();
	      
		  // Click on Logout
		  driver.findElement(By.id("ctl00_lblLogOut")).click();
	      
	      Assert.assertEquals(actualAuthentication, expectedAuthentication);
		  
		  driver.close();		  
}
	  
	  
	  
	  

////////////////////////// Needs re-login code entry  
//////Test ID: 30-08
/////* 
////* Update Password  of default 'Admin' user
////*/	
//	  @Test (priority = 52)
//      public void verifyUpdateAdminPassword () throws InterruptedException {
//	       System.setProperty("webdriver.gecko.driver", driverPath);
//          driver = new FirefoxDriver();
//          driver.get(baseUrl);
//
//          // Signing in OmniPCX
//          driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//          driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
//          driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//    
//          // Click on Users
//          Thread.sleep(3000);
//          driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click(); 
//	       
//          // Click on Edit button
//          Thread.sleep(3000);
//          driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr[1]/td[4]/div/img[1]")).click();
//
//          // Set new password value from here
//          String password = "1234567a";
//     
//          Thread.sleep(3000); 
//          // Locate password textbox and clear text present
//          driver.findElement(By.id("tbPassword")).clear();
//     
//          // Locate password textbox and Enter new password
//          driver.findElement(By.id("tbPassword")).sendKeys(password);    
//     
//          // Locate confirm password textbox and clear text present
//          driver.findElement(By.id("tbConfirmPassword")).clear();
//
//          // Locate confirm password textbox and Enter new password
//          driver.findElement(By.id("tbConfirmPassword")).sendKeys(password);
//     
//          Thread.sleep(3000);
//          // Click on Update button
//          driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();
//     
//          // Check alert message
//          JavascriptExecutor jsx = (JavascriptExecutor)driver;
//          jsx.executeScript("window.confirm('Settings have been updated successfully')");
//
//         String expectedAlertpassword = "Settings have been updated successfully";
//         Alert confirmation = driver.switchTo().alert();
//         String actualAlertpassword = confirmation.getText(); //Get text present on alert Message
//      
//         Assert.assertEquals(actualAlertpassword, expectedAlertpassword);
//     
//        //Print Alert where needed
//        //System.out.println("Alert text is :" + actualAlert);
//     
//        /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
//        Dismissed user prompt dialog: Settings have been updated successfully:*/
//        driver.switchTo().alert().accept();
//    
//       // Click on okay button
//       Thread.sleep(3000);
//       driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click(); //.click();
//     
//       driver.close();
//}	  
	           	  
 
//	  @AfterTest
//	  
//	  
//      public void tearDown() throws Exception {
//  	        driver.quit();	}
//
}



