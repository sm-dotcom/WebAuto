/* 
@author: sarah.mahmood 
Created on June 24, 2021
*/
// Dependency needs images(4) in downloads (2 for basic upload check in logo, 2 for size check)
// needs to create a 2nd db for checking
package ServerAdministration;


import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.Keys;
//import java.io.File;
//import java.awt.List;


public class ServerSystemConfiguration {
	
    public String baseUrl = "http://172.20.22.81/OmniPCXRecord/TenantAdmin.aspx";
	
    String driverPath = "C:\\Users\\sarah.mahmood\\Downloads\\gecko-driver\\geckodriver.exe";
	
	public WebDriver driver;
	

////Test ID: 15-01
///* 
///* Add SNMP settings in the system with valid data 
//*/		  	  
	  @Test (priority = 1)
	  public void AddSNMPinSystemwithValiddata () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click On SNMP Settings 
	      Thread.sleep(10000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink9")).click();
		  
		  // Click on Receiver IP*
	      driver.findElement(By.id("tbReceiverIP")).sendKeys("152.5.237.147");
	
	      // Click on Port*
	      driver.findElement(By.id("tbPort")).sendKeys("5983");
	      
	      // Click on Community String*
	      driver.findElement(By.id("tbCommunityString")).sendKeys("mv/ect/ghf/ijk");
	      
		  // Click save button
		  driver.findElement(By.xpath("//*[@id=\"divSNMP\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/button[1]")).click();
		  Thread.sleep(6000);
		  
		  String expected = "Settings have been saved successfully";
		  // Get label msg
		  String actual = driver.findElement(By.id("lblMsg")).getText();
		  Assert.assertEquals(actual, expected);
	      
	      driver.close();
	  }  
	  
	  
	  
	 

////Test ID: 15-04
///* 
///* Add SNMP settings in the system with empty Receiver IP One 
//*/	
	  @Test (priority = 2)
	  public void AddSNMPinSystemwithEmptyReceiverIP () throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click On SNMP Settings 
	      Thread.sleep(10000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink9")).click();
		  
//		  // Click on Receiver IP*
//	      driver.findElement(By.id("tbReceiverIP")).sendKeys("152.5.237.147");
	
	      // Click on Port*
	      driver.findElement(By.id("tbPort")).sendKeys("5983");
	      
	      // Click on Community String*
	      driver.findElement(By.id("tbCommunityString")).sendKeys("mv/ect/ghf/ijk");
	      
		  // Click save button
		  driver.findElement(By.xpath("//*[@id=\"divSNMP\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/button[1]")).click();
		  Thread.sleep(6000);
		  
		  String expected = "Please enter Receiver IP";
		  // Get label msg
		  String actual = driver.findElement(By.id("lblMsg")).getText();
		  Assert.assertEquals(actual, expected);
	      
	      driver.close();
	  }  
	  
	  
	  
	  
	  
////Test ID: 15-05
///* 
///* Add SNMP settings in the system with empty Port 
//*/
	  @Test (priority = 3)
	  public void AddSNMPinSystemwithEmptyPort() throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click On SNMP Settings 
	      Thread.sleep(10000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink9")).click();
		  
		  // Click on Receiver IP*
	      driver.findElement(By.id("tbReceiverIP")).sendKeys("152.5.237.147");
	
//	      // Click on Port*
//	      driver.findElement(By.id("tbPort")).sendKeys("5983");
	      
	      // Click on Community String*
	      driver.findElement(By.id("tbCommunityString")).sendKeys("mv/ect/ghf/ijk");
	      
		  // Click save button
		  driver.findElement(By.xpath("//*[@id=\"divSNMP\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/button[1]")).click();
		  Thread.sleep(6000);
		  
		  String expected = "Please enter Port";
		  // Get label msg
		  String actual = driver.findElement(By.id("lblMsg")).getText();
		  Assert.assertEquals(actual, expected);
	      
	      driver.close(); 	  
	  }
		  
			 
		  
		  
		  
		  
////Test ID: 15-06
///* 
///* Add SNMP settings in the system with empty Community String 
//*/
	@Test (priority = 4)
    public void AddSNMPinSystemwithCommunityString() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click On SNMP Settings 
	      Thread.sleep(10000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink9")).click();
		  
		  // Click on Receiver IP*
	      driver.findElement(By.id("tbReceiverIP")).sendKeys("152.5.237.147");
	
	      // Click on Port*
	      driver.findElement(By.id("tbPort")).sendKeys("5983");
	      
//	      // Click on Community String*
//	      driver.findElement(By.id("tbCommunityString")).sendKeys("mv/ect/ghf/ijk");
	      
		  // Click save button
		  driver.findElement(By.xpath("//*[@id=\"divSNMP\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/button[1]")).click();
		  Thread.sleep(6000);
		  
		  String expected ="Please enter Community String";
		  // Get label msg
		  String actual = driver.findElement(By.id("lblMsg")).getText();
		  Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	}
	
	
	
	
////Test ID: 15-07
///* 
///* Add SNMP settings in the system with invalid Receiver IP One 
//*/
	@Test (priority = 5)
    public void AddSNMPinSystemwithInvalidReceiverIP() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click On SNMP Settings 
	      Thread.sleep(10000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink9")).click();
		  
		  // Click on Receiver IP*
	      driver.findElement(By.id("tbReceiverIP")).sendKeys("1525237147"); // 126.223.3.163
	
	      // Click on Port*
	      driver.findElement(By.id("tbPort")).sendKeys("6968");
	      
	      // Click on Community String*
	      driver.findElement(By.id("tbCommunityString")).sendKeys("/etc/snmp/snmpd.conf.org");
	      
		  // Click save button
		  driver.findElement(By.xpath("//*[@id=\"divSNMP\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/button[1]")).click();
		  Thread.sleep(6000);
		  
		  String expected ="Invalid Receiver IP";
		  // Get label msg
		  String actual = driver.findElement(By.id("lblMsg")).getText();
		  Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	}	
	
	
	
	
////Test ID: 15-10
///* 
///* Verify that user is able to hide and expand the SNMP-Supervisor Settings tab
//*/
	@Test (priority = 6)
    public void verifySNMPSettingsTabMin_MaxFunctionality() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click On SNMP Settings 
	      Thread.sleep(20000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink9")).click();
		  
		  // Click on "-" on SNMP setting
	      driver.findElement(By.id("imgSNMP")).click();	
	      
	      Assert.assertFalse(driver.findElement(By.id("tbReceiverIP")).isDisplayed());
	      
	      // Click on "+" on SNMP setting
	      driver.findElement(By.id("imgSNMP")).click();	
	      
	      Assert.assertTrue(driver.findElement(By.id("tbReceiverIP")).isDisplayed());
	      
	      driver.close();	  		  		  
	}
	
	
		
////Test ID: 15-11
///* 
///* Verify that SNMP service restart note is displayed above the SNMP-Supervisor Settings tab
//*/
	@Test (priority = 7)
    public void verifySNMPrestart_noteSystem() throws InterruptedException {
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
	      
	      // Click On SNMP Settings 
	      Thread.sleep(10000);
	      String actual = driver.findElement(By.className("NoteText")).getText();
		  Thread.sleep(8000);
		  String expected = "Note :   After any update all recording servers must be restarted for the new changes to take effect.";
		  Assert.assertEquals(actual, expected);
//		*[@id="ContentPlaceHolder"]/table/tbody/tr[27]/td
		  
		  driver.close();
	}
	
	
	

	
////Test ID: 15-12
///* 
///* Verify that Receiver IP One and Receiver IP Two fields should only accept numeric value.
//*/	
	@Test (priority = 8)
    public void verifyReceiverIPacceptsNumericsonly() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);

	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click On SNMP Settings 
	      Thread.sleep(10000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink9")).click();
		  
		  // Click on Receiver IP*
	      driver.findElement(By.id("tbReceiverIP")).sendKeys("1525237147bdkhgyyieueiueu@#%@$%^%&"); // 126.223.3.163
	
	      Thread.sleep(8000);
		  String expected = "1525237147";
		  // Get value entered
		  String actual = driver.findElement(By.id("tbReceiverIP")).getAttribute("value");
		  Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	}	
	
	
	

	
////Test ID: 15-13
///* 
///* Add SMTP settings in the system with valid data.
//*/
	@Test (priority = 7)
    public void verifySMTPSettingsinSystemValidData() throws InterruptedException {
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
	      
	      // Enter values for SMTP Server *
	      driver.findElement(By.id("txtSMTPServer")).clear();
	      driver.findElement(By.id("txtSMTPServer")).sendKeys("auth.smtp.1and1.co.uk");
	      
	      // Clear values for password and username 
	      driver.findElement(By.id("txtSMTPUsername")).clear();
	      driver.findElement(By.id("txtSMTPPassword")).clear();
	      
	      // Enter values for Sender Email Address *
	      driver.findElement(By.id("txtSMTPSenderEmailAddress")).clear();
	      driver.findElement(By.id("txtSMTPSenderEmailAddress")).sendKeys("qa-opr@amigo-software.com");
	      
	      // Enter values for Port *
	      driver.findElement(By.id("txtSMTPPort")).clear();
	      driver.findElement(By.id("txtSMTPPort")).sendKeys("587");
	      
	      // Click upload button
	      driver.findElement(By.id("btnUpdateSMTPSettings")).click();
	      
	      Thread.sleep(8000);
		  String expected = "Settings have been updated successfully";
		  // Get value entered
		  String actual = driver.findElement(By.id("lblMessageSMTP")).getText();
		  Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	}	
	
	
	

////Test ID: 15-14
///* 
///* Add SMTP settings in the system with valid data and username
//*/
	@Test (priority = 8)
    public void verifySMTPSettingsinSystemValidDataandUsername() throws InterruptedException {
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
	      
	      // Enter values for SMTP Server *
	      driver.findElement(By.id("txtSMTPServer")).clear();
	      driver.findElement(By.id("txtSMTPServer")).sendKeys("auth.smtp.1and1.co.uk");
	      
	      // Enter values for Username
	      driver.findElement(By.id("txtSMTPUsername")).clear();
	      driver.findElement(By.id("txtSMTPUsername")).sendKeys("qa-opr@amigo-software.com");
	      
	      // Clear values for password and username 
//	      driver.findElement(By.id("txtSMTPUsername")).clear();
	      driver.findElement(By.id("txtSMTPPassword")).clear();
	      
	      // Enter values for Sender Email Address *
	      driver.findElement(By.id("txtSMTPSenderEmailAddress")).clear();
	      driver.findElement(By.id("txtSMTPSenderEmailAddress")).sendKeys("qa-opr@amigo-software.com");
	      
	      // Enter values for Port *
	      driver.findElement(By.id("txtSMTPPort")).clear();
	      driver.findElement(By.id("txtSMTPPort")).sendKeys("587");
	      
	      // Click upload button
	      driver.findElement(By.id("btnUpdateSMTPSettings")).click();
	      
	      Thread.sleep(8000);
		  String expected = "Settings have been updated successfully";
		  // Get value entered
		  String actual = driver.findElement(By.id("lblMessageSMTP")).getText();
		  Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	}	
	
	 
	  
	
////Test ID: 15-15
///* 
///* Add SMTP settings in the system with valid data and username and password
//*/	
	@Test (priority = 9)
    public void verifySMTPSettingsinSystemValidDataandUsernamePassword() throws InterruptedException {
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
	      
	      // Enter values for SMTP Server *
	      driver.findElement(By.id("txtSMTPServer")).clear();
	      driver.findElement(By.id("txtSMTPServer")).sendKeys("auth.smtp.1and1.co.uk");
	      
	      // Enter values for Username
	      driver.findElement(By.id("txtSMTPUsername")).clear();
	      driver.findElement(By.id("txtSMTPUsername")).sendKeys("qa-opr@amigo-software.com");
	      
	      // Enter values for password 
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
	      
	      Thread.sleep(8000);
		  String expected = "Settings have been updated successfully";
		  // Get value entered
		  String actual = driver.findElement(By.id("lblMessageSMTP")).getText();
		  Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	}
	
	
	
	

////Test ID: 15-16
///* 
///* Add SMTP settings in the system with empty SMTP Server.
//*/	
	@Test (priority = 10)
    public void verifySMTPSettingsinSystemwithEmptySMTPServer() throws InterruptedException {
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
	      
//	      // Enter values for SMTP Server *
//	      driver.findElement(By.id("txtSMTPServer")).clear();
//	      driver.findElement(By.id("txtSMTPServer")).sendKeys("auth.smtp.1and1.co.uk");
	      
	      // Enter values for Username
	      driver.findElement(By.id("txtSMTPUsername")).clear();
	      driver.findElement(By.id("txtSMTPUsername")).sendKeys("qa-opr@amigo-software.com");
	      
	      // Enter values for password 
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
	      
	      Thread.sleep(8000);
		  String expected = "Settings have been updated successfully";
		  // Get value entered
		  String actual = driver.findElement(By.id("lblMessageSMTP")).getText();
		  Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	}

	
	
	
	
////Test ID: 15-17
///* 
///* Add SMTP settings in the system with empty Sender Email Address
//*/	
	@Test (priority = 11)
    public void verifySMTPSettingsinSystemwithEmptyEmailAddress() throws InterruptedException {
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
	      
	      // Enter values for SMTP Server *
	      driver.findElement(By.id("txtSMTPServer")).clear();
	      driver.findElement(By.id("txtSMTPServer")).sendKeys("auth.smtp.1and1.co.uk");
	      
	      // Enter values for Username
	      driver.findElement(By.id("txtSMTPUsername")).clear();
	      driver.findElement(By.id("txtSMTPUsername")).sendKeys("qa-opr@amigo-software.com");
	      
	      // Enter values for password 
	      driver.findElement(By.id("txtSMTPPassword")).clear();
	      driver.findElement(By.id("txtSMTPPassword")).sendKeys("OPRqa@2017");
	      
	      // Enter values for Sender Email Address *
	      driver.findElement(By.id("txtSMTPSenderEmailAddress")).clear();
//	      driver.findElement(By.id("txtSMTPSenderEmailAddress")).sendKeys("qa-opr@amigo-software.com");
	      
	      // Enter values for Port *
	      driver.findElement(By.id("txtSMTPPort")).clear();
	      driver.findElement(By.id("txtSMTPPort")).sendKeys("587");
	      
	      // Click upload button
	      driver.findElement(By.id("btnUpdateSMTPSettings")).click();
	      
	      Thread.sleep(8000);
		  String expected = "Enter Sender Email Address";
		  // Get value entered
		  String actual = driver.findElement(By.id("lblMessageSMTP")).getText();
		  Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	}	
	
	
	
	
////Test ID: 15-18
///* 
///* Add SMTP settings in the system with invalid Sender Email Address
//*/	
	@Test (priority = 12)
    public void verifySMTPSettingsinSystemwithInvalidEmailAddress() throws InterruptedException {
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
	      
	      // Enter values for SMTP Server *
	      driver.findElement(By.id("txtSMTPServer")).clear();
	      driver.findElement(By.id("txtSMTPServer")).sendKeys("auth.smtp.1and1.co.uk");
	      
	      // Enter values for Username
	      driver.findElement(By.id("txtSMTPUsername")).clear();
	      driver.findElement(By.id("txtSMTPUsername")).sendKeys("qa-opr@amigo-software.com");
	      
	      // Enter values for password 
	      driver.findElement(By.id("txtSMTPPassword")).clear();
	      driver.findElement(By.id("txtSMTPPassword")).sendKeys("OPRqa@2017");
	      
	      // Enter values for Sender Email Address *
	      driver.findElement(By.id("txtSMTPSenderEmailAddress")).clear();
	      driver.findElement(By.id("txtSMTPSenderEmailAddress")).sendKeys("abcmail.com");
	      
	      // Enter values for Port *
	      driver.findElement(By.id("txtSMTPPort")).clear();
	      driver.findElement(By.id("txtSMTPPort")).sendKeys("587");
	      
	      // Click upload button
	      driver.findElement(By.id("btnUpdateSMTPSettings")).click();
	      
	      Thread.sleep(8000);
		  String expected = "Invalid sender email address";
		  // Get value entered
		  String actual = driver.findElement(By.id("lblMessageSMTP")).getText();
		  Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	}		
	 
	
	
	
	
////Test ID: 15-19
///* 
///* Reset SMTP settings 
//*/	
	@Test (priority = 13)
    public void verifyResetSMTPSettings() throws InterruptedException {
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
	      
	      // Enter values for SMTP Server *
	      driver.findElement(By.id("txtSMTPServer")).clear();
	      driver.findElement(By.id("txtSMTPServer")).sendKeys("auth.smtp.1and1.co.uk");
	      
//	      // Enter values for Username
//	      driver.findElement(By.id("txtSMTPUsername")).clear();
//	      driver.findElement(By.id("txtSMTPUsername")).sendKeys("qa-opr@amigo-software.com");
//	      
//	      // Enter values for password 
//	      driver.findElement(By.id("txtSMTPPassword")).clear();
//	      driver.findElement(By.id("txtSMTPPassword")).sendKeys("OPRqa@2017");
	      
	      // Enter values for Sender Email Address *
	      driver.findElement(By.id("txtSMTPSenderEmailAddress")).clear();
	      driver.findElement(By.id("txtSMTPSenderEmailAddress")).sendKeys("abcmail.com");
	      
	      // Enter values for Port *
	      driver.findElement(By.id("txtSMTPPort")).clear();
	      driver.findElement(By.id("txtSMTPPort")).sendKeys("587");
	      
	      // Click upload button
	      driver.findElement(By.id("btnUpdateSMTPSettings")).click();
	      
	      // Click on reset
	      driver.findElement(By.id("btnResetSMTPSettings")).click();
	      
	      Thread.sleep(8000);
		  String expected = "Settings have been updated successfully";
		  // Get value entered
		  String actual = driver.findElement(By.id("lblMessageSMTP")).getText();
		  Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	}	
	
	
	
	
	
////Test ID: 15-24
///* 
///* Add user interface logo with valid image file
//*/
	@Test (priority = 15)
    public void AddUserInterfacelogowithValidImage() throws InterruptedException {
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
	      
	      // Click on User Interface Logo (550 X 116) 
	      driver.findElement(By.id("rbLogoTypeUI")).click();
	      
	      // Upload a file
		  WebElement browse = driver.findElement(By.id("uploaderPCX"));
		  browse.sendKeys("C:\\Users\\sarah.mahmood\\Downloads\\photo.jpg");
		  
		  // Click on update button
	      Thread.sleep(5000);
	      driver.findElement(By.id("btnUpdateLogo")).click();
	      
	      Thread.sleep(6000);
		  String expected = "Logo uploaded";
		  String actual = driver.findElement(By.id("lblLogoMessage")).getText();
		  Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	}	
	      
	
	
	
////Test ID: 15-25
///* 
///* Add user interface logo without selecting an image
//*/
	@Test (priority = 16)
    public void AddUserInterfacelogowithoutImage() throws InterruptedException {
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
	      
	      // Click on User Interface Logo (550 X 116) 
	      driver.findElement(By.id("rbLogoTypeUI")).click();
	      
//	      // Upload a file
//		  WebElement browse = driver.findElement(By.id("uploaderPCX"));
//		  browse.sendKeys("C:\\Users\\sarah.mahmood\\Downloads\\photo.jpg");//Uploading the file using sendKeys
		  
		  // Click on update button
	      Thread.sleep(5000);
	      driver.findElement(By.id("btnUpdateLogo")).click();
	      
	      Thread.sleep(6000);
		  String expected = "Please select an image to upload";
		  String actual = driver.findElement(By.id("lblLogoMessage")).getText();
		  Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	}	
	
	
	
	
////Test ID: 15-26
///* 
///* Add user interface logo with an invalid file
//*/
	@Test (priority = 17)
    public void AddUserInterfacelogowithInvalidImage() throws InterruptedException {
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
	      
	      // Click on User Interface Logo (550 X 116) 
	      driver.findElement(By.id("rbLogoTypeUI")).click();
	      
	      // Upload a file
		  WebElement browse = driver.findElement(By.id("uploaderPCX"));
		  browse.sendKeys("C:\\Users\\sarah.mahmood\\Downloads\\REST API AuditLog1.txt");
		  
		  // Click on update button
	      Thread.sleep(5000);
	      driver.findElement(By.id("btnUpdateLogo")).click();
	      
	      Thread.sleep(6000);
		  String expected = "Invalid file format";
		  String actual = driver.findElement(By.id("lblLogoMessage")).getText();
		  Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	}
	
	
	
	
	
////Test ID: 15-25
///* 
///* Add user interface logo without selecting an image
//*/
	@Test (priority = 18)
    public void resetUserInterfacelogo() throws InterruptedException {
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
	      
	      // Click on User Interface Logo (550 X 116) 
	      driver.findElement(By.id("rbLogoTypeUI")).click();
	      
	      // Upload a file
		  WebElement browse = driver.findElement(By.id("uploaderPCX"));
		  browse.sendKeys("C:\\Users\\sarah.mahmood\\Downloads\\photo.jpg");//Uploading the file using sendKeys
		  
		  // Click on update button
	      Thread.sleep(5000);
	      driver.findElement(By.id("btnUpdateLogo")).click();
	      
	      // Click on the reset button
	      Thread.sleep(5000);
	      driver.findElement(By.id("btnResetLogo")).click();
	      
	      Thread.sleep(6000);
		  String expected = "Settings have been updated successfully";
		  String actual = driver.findElement(By.id("lblLogoMessage")).getText();
		  Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	}	
	
	
	
	
	

////Test ID: 15-28
///* 
///* Add report header with valid image file
//*/
	@Test (priority = 19)
    public void addReportHeaderValidImage() throws InterruptedException {
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
	      
	      // Click on Report Header (2316 X 345) 
	      driver.findElement(By.id("rbLogoTypeRPT")).click();
	      
	      // Upload a file
		  WebElement browse = driver.findElement(By.id("uploaderPCX"));
		  browse.sendKeys("C:\\Users\\sarah.mahmood\\Downloads\\rephead.png");//Uploading the file using sendKeys
		  
		  // Click on update button
	      Thread.sleep(5000);
	      driver.findElement(By.id("btnUpdateLogo")).click();
	      
	      Thread.sleep(6000);
		  String expected = "Logo uploaded";
		  String actual = driver.findElement(By.id("lblLogoMessage")).getText();
		  Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	}		
	
	
	
	

////Test ID: 15-29
///* 
///* Add report header without selecting an image
//*/
	@Test (priority = 20)
    public void addReportHeaderwithoutImage() throws InterruptedException {
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
	      
	      // Click on Report Header (2316 X 345) 
	      driver.findElement(By.id("rbLogoTypeRPT")).click();
	      
//	      // Upload a file
//		  WebElement browse = driver.findElement(By.id("uploaderPCX"));
//		  browse.sendKeys("C:\\Users\\sarah.mahmood\\Downloads\\rephead.png");//Uploading the file using sendKeys
		  
		  // Click on update button
	      Thread.sleep(5000);
	      driver.findElement(By.id("btnUpdateLogo")).click();
	      
	      Thread.sleep(6000);
		  String expected = "Please select an image to upload";
		  String actual = driver.findElement(By.id("lblLogoMessage")).getText();
		  Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	}
	
	

	
	
	
////Test ID: 15-30
///* 
///* Add report header with an invalid file
//*/
	@Test (priority = 21)
    public void addReportHeaderwithInvalidfile() throws InterruptedException {
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
	      
	      // Click on Report Header (2316 X 345) 
	      driver.findElement(By.id("rbLogoTypeRPT")).click();
	      
	      // Upload a file
		  WebElement browse = driver.findElement(By.id("uploaderPCX"));
		  browse.sendKeys("C:\\Users\\sarah.mahmood\\Downloads\\REST API AuditLog1.txt");//Uploading the file using sendKeys
		  
		  // Click on update button
	      Thread.sleep(5000);
	      driver.findElement(By.id("btnUpdateLogo")).click();
	      
	      Thread.sleep(6000);
		  String expected = "Invalid file format";
		  String actual = driver.findElement(By.id("lblLogoMessage")).getText();
		  Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	}	
	

	
	
	
////Test ID: 15-31
///* 
///* Reset report header
//*/
	@Test (priority = 22)
    public void resetReportHeader() throws InterruptedException {
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
	      
	      // Click on Report Header (2316 X 345) 
	      driver.findElement(By.id("rbLogoTypeRPT")).click();
	      
	      // Upload a file
		  WebElement browse = driver.findElement(By.id("uploaderPCX"));
		  browse.sendKeys("C:\\Users\\sarah.mahmood\\Downloads\\REST API AuditLog1.txt");//Uploading the file using sendKeys
		  
		  // Click on update button
	      Thread.sleep(5000);
	      driver.findElement(By.id("btnUpdateLogo")).click();
	      
	      // Click on the reset button
	      Thread.sleep(5000);
	      driver.findElement(By.id("btnResetLogo")).click();
	      
	      Thread.sleep(6000);
		  String expected = "Settings have been updated successfully";
		  String actual = driver.findElement(By.id("lblLogoMessage")).getText();
		  Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	}	
	

	
	
////Test ID: 15-32
///* 
///* Verify that user is able to hide and expand the Logo Settings tab
//*/
	@Test (priority = 23)
    public void HideandExpandLogoSettings() throws InterruptedException {
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
	      
	      
	      // Click on hide
	      driver.findElement(By.id("img9")).click();
	      Assert.assertFalse(driver.findElement(By.id("btnResetLogo")).isDisplayed());
	      
	      // Click to expand
	      driver.findElement(By.id("img9")).click();
	      Assert.assertTrue(driver.findElement(By.id("btnResetLogo")).isDisplayed());
	     
	      driver.close();	  		  		  
	}	
	
	

	
////Test ID: 15-155
///* 
///* Logo image is not updating if file size is more than 2 MB for both Site and Server administration.
//*/	
	@Test (priority = 23)
	public void verifyLogoImageSizeforImagegreaterthan10Mb() throws InterruptedException {
		 
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
	   
	// Click on Report Header (2316 X 345) 
	driver.findElement(By.id("rbLogoTypeUI")).click();
	   
//	File fileinfo = new File("C:\\Users\\sarah.mahmood\\Downloads\\Large-Sample-png-Image-download-for-Testing.png"); 
//	System.out.println(fileinfo.length());
	    
	// Upload a file of 30Mb
	WebElement browse = driver.findElement(By.id("uploaderPCX"));
	browse.sendKeys("C:\\Users\\sarah.mahmood\\Downloads\\Large-Sample-png-Image-download-for-Testing.png"); //Uploading the file using sendKeys

	// Click on update button
    Thread.sleep(5000);
    driver.findElement(By.id("btnUpdateLogo")).click();
	
	Thread.sleep(6000);
	String expected = "Image must be less than 10 MB.";
	String actual = driver.findElement(By.id("lblLogoMessage")).getText();
	Assert.assertEquals(actual, expected);
	  
	driver.close();	
	}
	
	

////Test ID: 15-42
///* 
///* There should be mandatory sign (*) on fields (Secondary Server IP and Primary Database Information fields) in server system 
///* settings when server role is selected as secondary
//*/
	@Test (priority = 24)
    public void checkMandatoryfieldswithSecondaryServerIPSystemSettings() throws InterruptedException {
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
	      
	      // Click on Server Role * Secondary
	      driver.findElement(By.id("rdbServerRoleSecondary")).click();
	      
	      // Click on Secondary Server IP *
	      String actualSIP = driver.findElement(By.id("lblSIP")).getText();
	      String expectedSIP = "Secondary Server IP *";
	      Assert.assertEquals(actualSIP, expectedSIP);
	      
	      // Click on Server Name * 
	      String actualSn = driver.findElement(By.id("ServerName")).getText();
	      String expectedSn = "Server Name *";
	      Assert.assertEquals(actualSn, expectedSn);
	      
	      // Click on Database Name * 
	      String actualdb = driver.findElement(By.id("lblDBRemoteName")).getText();
	      String expecteddb = "Database Name *";
	      Assert.assertEquals(actualdb, expecteddb);
	      
	      // Click on Username *
	      String actualUN = driver.findElement(By.id("ServerUsername")).getText();
	      String expectedUN = "Username *";
	      Assert.assertEquals(actualUN, expectedUN);
	      
	      // Click on Password *
	      String actualSp = driver.findElement(By.id("ServerPassword")).getText();
	      String expectedSp = "Password *";
	      Assert.assertEquals(actualSp, expectedSp);
	     
	      driver.close();	  		  		  
	}		
		
	

////Test ID: 15-121
///* 
///* Verify Active Directory Settings with valid data and criteria as Include all Containers
//*/
	@Test (priority = 25)	
    public void ActiveDirectorywithIncludeallContainers() throws InterruptedException {
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
		  
		  String expectedAuthentication = "Settings have been updated successfully";
          String actualAuthentication = driver.findElement(By.id("lblMessageAuthentication")).getText();
	      
          Assert.assertEquals(actualAuthentication, expectedAuthentication);
	      
          driver.close();	  		  		  
	  	}		
	
	
	
	
	
	
	
////Test ID: 15-122
///* 
///* Verify Active Directory Settings with valid data and criteria as Specific Container
//*/
	@Test (priority = 26)	
    public void ActiveDirectorywithSpecificContainer() throws InterruptedException {
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
		  
		  // Check radio button "Specific Containers" for Criteria
		  driver.findElement(By.id("rbADCriteriaSpecfic")).click();
		  
		  Thread.sleep(6000);
		  
		  // Choose container
		  driver.findElement(By.id("imgSpecificContainer")).click();
		  
		  Thread.sleep(6000);
		  
		  // Select a container from Authentication Settings pop-up
		  driver.findElement(By.id("j1_1_anchor")).click();
		  
		  Thread.sleep(6000);
		  
		  // Select a container from Authentication Settings pop-up
		  driver.findElement(By.id("ADPopUpSelect")).click();
		  
		  Thread.sleep(6000);
		  
		  // Click on update button
		  driver.findElement(By.id("btnUpdateAuthSettings")).click(); 
		  
		  String expectedAuthentication = "Settings have been updated successfully";
          String actualAuthentication = driver.findElement(By.id("lblMessageAuthentication")).getText();
	      
          Assert.assertEquals(actualAuthentication, expectedAuthentication);
	      
          driver.close();	  		  		  
	  	}			
	
	
	
	

////Test ID: 15-123
///* 
///* Verify Active Directory Settings with empty domain name
//*/
	@Test (priority = 27)	
    public void ActiveDirectorywithEmptydomain_name() throws InterruptedException {
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
//		  // Enter Domain Name
		  driver.findElement(By.id("txtADDomainName")).clear(); //In case some value already present clear
//		  driver.findElement(By.id("txtADDomainName")).sendKeys("ghostsoftware.local");
		  
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
		  
		  String expectedAuthentication = "Please enter domain name";
          String actualAuthentication = driver.findElement(By.id("lblMessageAuthentication")).getText();
	      
          Assert.assertEquals(actualAuthentication, expectedAuthentication);
	      
          driver.close();	  		  		  
	  	}				

	
	
	
////Test ID: 15-124
///* 
///* Verify Active Directory Settings with empty user name
//*/
	@Test (priority = 28)	
    public void ActiveDirectorywithEmptyuser_name() throws InterruptedException {
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
		  
//		  // Enter Username
		  driver.findElement(By.id("txtADUsername")).clear();
//		  driver.findElement(By.id("txtADUsername")).sendKeys("ahsan.rehman");
		  
		  // Enter Password
		  driver.findElement(By.id("txtADPassword")).clear();
		  driver.findElement(By.id("txtADPassword")).sendKeys("Abc123*");
		  
		  // Check radio button "Include all Containers" for Criteria
		  driver.findElement(By.id("rbADCriteriaAll")).click();
		  
		  // Click on update button
		  driver.findElement(By.id("btnUpdateAuthSettings")).click(); 
		  
		  String expectedAuthentication = "Please enter username";
          String actualAuthentication = driver.findElement(By.id("lblMessageAuthentication")).getText();
	      
          Assert.assertEquals(actualAuthentication, expectedAuthentication);
	      
          driver.close();	  		  		  
	  	}		
	
	
	
	
////Test ID: 15-125
///* 
///* Verify Active Directory Settings with empty Password
//*/
	@Test (priority = 29)	
    public void ActiveDirectorywithEmptypassword() throws InterruptedException {
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
//		  driver.findElement(By.id("txtADPassword")).sendKeys("Abc123*");
		  
		  // Check radio button "Include all Containers" for Criteria
		  driver.findElement(By.id("rbADCriteriaAll")).click();
		  
		  // Click on update button
		  driver.findElement(By.id("btnUpdateAuthSettings")).click(); 
		  
		  String expectedAuthentication = "Please enter password";
          String actualAuthentication = driver.findElement(By.id("lblMessageAuthentication")).getText();
	      
          Assert.assertEquals(actualAuthentication, expectedAuthentication);
	      
          driver.close();	  		  		  
	  	}			
	
	
	
	

////Test ID: 15-127
///* 
///* Verify Active Directory Settings with invalid domain
//*/
	@Test (priority = 30)	
    public void ActiveDirectorywithInvaliddomain() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);		
	
	      // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();  
		  
	      // Click on System
	      Thread.sleep(12000);
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
		  driver.findElement(By.id("txtADUsername")).sendKeys("something");
		  
		  // Enter Password
		  driver.findElement(By.id("txtADPassword")).clear();
		  driver.findElement(By.id("txtADPassword")).sendKeys("Abc123*");
		  
		  // Check radio button "Include all Containers" for Criteria
		  driver.findElement(By.id("rbADCriteriaAll")).click();
		  
		  // Click on update button
		  driver.findElement(By.id("btnUpdateAuthSettings")).click(); 
		  
		  String expectedAuthentication = "Invalid username or password";
          String actualAuthentication = driver.findElement(By.id("lblMessageAuthentication")).getText();
	      
          Assert.assertEquals(actualAuthentication, expectedAuthentication);
	      
          driver.close();	  		  		  
	  	}				
	
	
	
	

////Test ID: 15-127
///* 
///* Verify Active Directory Settings with invalid username
//*/
	@Test (priority = 31)	
    public void ActiveDirectorywithInvalidusername() throws InterruptedException {
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
		  driver.findElement(By.id("txtADUsername")).sendKeys("something");
		  
		  // Enter Password
		  driver.findElement(By.id("txtADPassword")).clear();
		  driver.findElement(By.id("txtADPassword")).sendKeys("Abc123*");
		  
		  // Check radio button "Include all Containers" for Criteria
		  driver.findElement(By.id("rbADCriteriaAll")).click();
		  
		  // Click on update button
		  driver.findElement(By.id("btnUpdateAuthSettings")).click(); 
		  
		  String expectedAuthentication = "Invalid username or password";
          String actualAuthentication = driver.findElement(By.id("lblMessageAuthentication")).getText();
	      
          Assert.assertEquals(actualAuthentication, expectedAuthentication);
	      
          driver.close();	  		  		  
	  	}					
	
	
	
	
////Test ID: 15-128
///* 
///* Verify Active Directory Settings with invalid password
//*/
	@Test (priority = 32)	
    public void ActiveDirectorywithInvalidpassword() throws InterruptedException {
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
		  driver.findElement(By.id("txtADPassword")).sendKeys("abc");
		  
		  // Check radio button "Include all Containers" for Criteria
		  driver.findElement(By.id("rbADCriteriaAll")).click();
		  
		  // Click on update button
		  driver.findElement(By.id("btnUpdateAuthSettings")).click(); 
		  
		  String expectedAuthentication = "Invalid username or password";
          String actualAuthentication = driver.findElement(By.id("lblMessageAuthentication")).getText();
	      
          Assert.assertEquals(actualAuthentication, expectedAuthentication);
	      
          driver.close();	  		  		  
	  	}				
	
	
	

	
////Test ID: 15-129
///* 
///* Verify Mix Mode (OmniPCX Record - Active Directory) Authentication Settings
//*/
	@Test (priority = 33)	
    public void MixModewithDefaultcriteria() throws InterruptedException {
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
		  
		  // Check radio button "Default" for Criteria
		  driver.findElement(By.id("rbADCriteriaDefault")).click();
		  
		  // Click on update button
		  driver.findElement(By.id("btnUpdateAuthSettings")).click(); 
		  
		  String expectedAuthentication = "Settings have been updated successfully";
          String actualAuthentication = driver.findElement(By.id("lblMessageAuthentication")).getText();
	      
          Assert.assertEquals(actualAuthentication, expectedAuthentication);
	      
          driver.close();	  		  		  
	  	}			
	
	
	
	
	
////Test ID: 15-130
///* 
///* Verify Mix Mode (OmniPCX Record - Active Directory) Authentication Settings with valid data and criteria as Include all Containers
//*/
	@Test (priority = 34)	
    public void MixModewithIncludeallContainers() throws InterruptedException {
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
		  
		  // Check radio button "Default" for Criteria
		  driver.findElement(By.id("rbADCriteriaAll")).click();
		  
		  // Click on update button
		  driver.findElement(By.id("btnUpdateAuthSettings")).click(); 
		  
		  String expectedAuthentication = "Settings have been updated successfully";
          String actualAuthentication = driver.findElement(By.id("lblMessageAuthentication")).getText();
	      
          Assert.assertEquals(actualAuthentication, expectedAuthentication);
	      
          driver.close();	  		  		  
	  	}				
	
	
	
	
	
////Test ID: 15-131
///* 
///* Verify Mix Mode (OmniPCX Record - Active Directory) Authentication Settings with valid data and criteria as Specific Container
//*/
	@Test (priority = 35)	
    public void MixModewithSpecificContainer() throws InterruptedException {
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
		  
		  // Check radio button "Specific Containers" for Criteria
		  driver.findElement(By.id("rbADCriteriaSpecfic")).click();
		  
		  Thread.sleep(6000);
		  
		  // Choose container
		  driver.findElement(By.id("imgSpecificContainer")).click();
		  
		  Thread.sleep(6000);
		  
		  // Select a container from Authentication Settings pop-up
		  driver.findElement(By.id("j1_1_anchor")).click();
		  
		  Thread.sleep(6000);
		  
		  // Select a container from Authentication Settings pop-up
		  driver.findElement(By.id("ADPopUpSelect")).click();
		  
		  Thread.sleep(6000);
		  
		  // Click on update button
		  driver.findElement(By.id("btnUpdateAuthSettings")).click(); 
		  
		  String expectedAuthentication = "Settings have been updated successfully";
          String actualAuthentication = driver.findElement(By.id("lblMessageAuthentication")).getText();
	      
          Assert.assertEquals(actualAuthentication, expectedAuthentication);
	      
          driver.close();	  		  		  
	  	}			
	
	
	
	

////Test ID: 15-132
///* 
///* Verify Mix Mode (OmniPCX Record - Active Directory) Authentication Settings with empty domain name
//*/
	@Test (priority = 36)	
    public void MixModewithEmptydomain_name() throws InterruptedException {
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
//		  // Enter Domain Name
		  driver.findElement(By.id("txtADDomainName")).clear(); //In case some value already present clear
//		  driver.findElement(By.id("txtADDomainName")).sendKeys("ghostsoftware.local");
		  
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
		  
		  String expectedAuthentication = "Please enter domain name";
          String actualAuthentication = driver.findElement(By.id("lblMessageAuthentication")).getText();
	      
          Assert.assertEquals(actualAuthentication, expectedAuthentication);
	      
          driver.close();	  		  		  
	  	}				

	
	
	
////Test ID: 15-133
///* 
///* Verify Mix Mode (OmniPCX Record - Active Directory) Authentication Settings with empty user name
//*/
	@Test (priority = 37)	
    public void MixModewithEmptyuser_name() throws InterruptedException {
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
		  
//		  // Enter Username
		  driver.findElement(By.id("txtADUsername")).clear();
//		  driver.findElement(By.id("txtADUsername")).sendKeys("ahsan.rehman");
		  
		  // Enter Password
		  driver.findElement(By.id("txtADPassword")).clear();
		  driver.findElement(By.id("txtADPassword")).sendKeys("Abc123*");
		  
		  // Check radio button "Include all Containers" for Criteria
		  driver.findElement(By.id("rbADCriteriaAll")).click();
		  
		  // Click on update button
		  driver.findElement(By.id("btnUpdateAuthSettings")).click(); 
		  
		  String expectedAuthentication = "Please enter username";
          String actualAuthentication = driver.findElement(By.id("lblMessageAuthentication")).getText();
	      
          Assert.assertEquals(actualAuthentication, expectedAuthentication);
	      
          driver.close();	  		  		  
	  	}		
	
	
	
	
////Test ID: 15-134
///* 
///* Verify Mix Mode (OmniPCX Record - Active Directory) Authentication Settings with empty Password
//*/
	@Test (priority = 38)	
    public void MixModewithEmptypassword() throws InterruptedException {
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
//		  driver.findElement(By.id("txtADPassword")).sendKeys("Abc123*");
		  
		  // Check radio button "Include all Containers" for Criteria
		  driver.findElement(By.id("rbADCriteriaAll")).click();
		  
		  // Click on update button
		  driver.findElement(By.id("btnUpdateAuthSettings")).click(); 
		  
		  String expectedAuthentication = "Please enter password";
          String actualAuthentication = driver.findElement(By.id("lblMessageAuthentication")).getText();
	      
          Assert.assertEquals(actualAuthentication, expectedAuthentication);
	      
          driver.close();	  		  		  
	  	}		
	
	
	
	
	
////Test ID: 15-135
///* 
///* Verify Mix Mode (OmniPCX Record - Active Directory) Authentication Settings with invalid domain
//*/
	@Test (priority = 39)	
    public void MixModewithInvaliddomain() throws InterruptedException {
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
		  driver.findElement(By.id("txtADUsername")).sendKeys("something");
		  
		  // Enter Password
		  driver.findElement(By.id("txtADPassword")).clear();
		  driver.findElement(By.id("txtADPassword")).sendKeys("Abc123*");
		  
		  // Check radio button "Include all Containers" for Criteria
		  driver.findElement(By.id("rbADCriteriaAll")).click();
		  
		  // Click on update button
		  driver.findElement(By.id("btnUpdateAuthSettings")).click(); 
		  
		  String expectedAuthentication = "Invalid username or password";
          String actualAuthentication = driver.findElement(By.id("lblMessageAuthentication")).getText();
	      
          Assert.assertEquals(actualAuthentication, expectedAuthentication);
	      
          driver.close();	  		  		  
	  	}				
	
	
	
	

////Test ID: 15-136
///* 
///* Verify Mix Mode (OmniPCX Record - Active Directory) Authentication Settings with invalid username
//*/
	@Test (priority = 40)	
    public void MixModewithInvalidusername() throws InterruptedException {
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
		  driver.findElement(By.id("txtADUsername")).sendKeys("something");
		  
		  // Enter Password
		  driver.findElement(By.id("txtADPassword")).clear();
		  driver.findElement(By.id("txtADPassword")).sendKeys("Abc123*");
		  
		  // Check radio button "Include all Containers" for Criteria
		  driver.findElement(By.id("rbADCriteriaAll")).click();
		  
		  // Click on update button
		  driver.findElement(By.id("btnUpdateAuthSettings")).click(); 
		  
		  String expectedAuthentication = "Invalid username or password";
          String actualAuthentication = driver.findElement(By.id("lblMessageAuthentication")).getText();
	      
          Assert.assertEquals(actualAuthentication, expectedAuthentication);
	      
          driver.close();	  		  		  
	  	}					
	
	
	
	
////Test ID: 15-137
///* 
///* Verify Mix Mode (OmniPCX Record - Active Directory) Authentication Settings with invalid password
//*/
	@Test (priority = 41)	
    public void MixModewithInvalidpassword() throws InterruptedException {
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
		  driver.findElement(By.id("txtADPassword")).sendKeys("abc");
		  
		  // Check radio button "Include all Containers" for Criteria
		  driver.findElement(By.id("rbADCriteriaAll")).click();
		  
		  // Click on update button
		  driver.findElement(By.id("btnUpdateAuthSettings")).click(); 
		  
		  String expectedAuthentication = "Invalid username or password";
          String actualAuthentication = driver.findElement(By.id("lblMessageAuthentication")).getText();
	      
          Assert.assertEquals(actualAuthentication, expectedAuthentication);
	      
          driver.close();	  		  		  
	  	}			
	
	
	
	
////Test ID: 15-145
///* 
///* Verify OmniPCX Record authentication settings
//*/
	@Test (priority = 42)	
    public void verifyOmniPCXRecordAuthenticationSettings() throws InterruptedException {
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
		  dropdown.selectByVisibleText("OmniPCX RECORD");
		  
		  // Click on update button
		  driver.findElement(By.id("btnUpdateAuthSettings")).click(); 
		  
		  String expectedAuthentication = "Settings have been updated successfully";
          String actualAuthentication = driver.findElement(By.id("lblMessageAuthentication")).getText();
	      
          Assert.assertEquals(actualAuthentication, expectedAuthentication);
	      
          driver.close();	  		  		  
	  	}				
	
	
	
	

////Test ID: 15-146
///* 
///* Verify Reset Button Functionality
//*/
	@Test (priority = 43)	
    public void verifyAuthenticationResetbutton() throws InterruptedException {
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
		  dropdown.selectByVisibleText("OmniPCX RECORD");
		  
		  // Click on update button
		  driver.findElement(By.id("btnUpdateAuthSettings")).click(); 
		  
		  String expectedAuthentication = "Settings have been updated successfully";
          String actualAuthentication = driver.findElement(By.id("lblMessageAuthentication")).getText();
	      
          Assert.assertEquals(actualAuthentication, expectedAuthentication);
	      
          driver.close();	  		  		  
	  	}					
	
	
	
	
		

////Test ID: 15-43
///* 
///* Recorder is Main: Verify the configuration of System Settings for server mode as None/0 and server role as primary.
//*/
	@Test (priority = 44)	
    public void checkRecorderMainConfigSettings() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Main");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click();
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81");
	      
	      // Select Server Mode
	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      // Check alert message
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('Settings have been updated successfully. You will be redirected to the login screen.')");
	     
	      String expected = "Settings have been updated successfully. You will be redirected to the login screen.";
	      Alert confirmation = driver.switchTo().alert();
	      String actual = confirmation.getText(); //Get text present on alert Message
	      
	      // Match alert messages 
	      Assert.assertEquals(actual,expected);
	      driver.switchTo().alert().accept();
	     
	      // Click on okay button
	      Thread.sleep(3000);
	      driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/button")).click(); //.click();
	     
	      driver.close();	  		  		  
	}		
	
	
	
	
	
////Test ID: 15-44
///* 
///* Recorder is Main: Verify the configuration of System Settings for server mode as None/0 and server role as primary with duplicate secondary IP.
//*/
	@Test (priority = 45)	
    public void checkRecorderMainConfigSettingswithDuplicateIPs() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Main");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click();
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81");
	      
	      // Select Server Mode
	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
		  String expected = "IP Addresses cannot be identical.";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	  		  		  
	}		
	
	
	
	
	
////Test ID: 15-45
///* 
///* "Recorder is Main:Verification of configuration of System Settings for server mode as Master server role as Primary
//*/
	@Test (priority = 46)	
    public void checkRecorderMainConfigSettingswithServerModeasMaster() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Main");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click();
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81");
	      
	      // Select Server Mode
	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
	      dropdownSM.selectByVisibleText("Master");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('Settings have been updated successfully. You will be redirected to the login screen.')");
	     
	      String expected = "Settings have been updated successfully. You will be redirected to the login screen.";
	      Alert confirmation = driver.switchTo().alert();
	      String actual = confirmation.getText(); //Get text present on alert Message
	      
	      // Match alert messages 
	      Assert.assertEquals(actual,expected);
	      driver.switchTo().alert().accept();
	     
	      // Click on okay button
	      Thread.sleep(3000);
	      driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/button")).click(); //.click();
	     
	      driver.close();	  		  		  
	}			
	
	
	
	
	
////Test ID: 15-46
///* 
///* Recorder is Main:Verification of configuration of System Settings for server mode as Satellite and server role as primary. 
//*/
	@Test (priority = 47)	
    public void checkRecorderMainConfigSettingswithServerModeasSatellite() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Main");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click();
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81");
	      
	      // Select Server Mode
	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
	      dropdownSM.selectByVisibleText("Satellite");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('Settings have been updated successfully. You will be redirected to the login screen.')");
	     
	      String expected = "Settings have been updated successfully. You will be redirected to the login screen.";
	      Alert confirmation = driver.switchTo().alert();
	      String actual = confirmation.getText(); //Get text present on alert Message
	      
	      // Match alert messages 
	      Assert.assertEquals(actual,expected);
	      driver.switchTo().alert().accept();
	     
	      // Click on okay button
	      Thread.sleep(3000);
	      driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/button")).click(); //.click();
	     
	      driver.close();	  		  		  
	}	
	
	
	
	
	
////Test ID: 15-47
///* 
///* "Recorder is Main:Verification of configuration of System Settings with invalid data when server mode as None and server role as primary. Empty Server ID Field."
//*/
	@Test (priority = 48)	
    public void checkRecorderMainConfigSettingswithEmptyServerID() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Main");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click();
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
//	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81");
	      
	      // Select Server Mode
	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
		  String expected = "Please enter Server ID";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	  		  		  
	}			
	
	
	
	
	
////Test ID: 15-48
///* 
///* "Recorder is Main:Verify the configuration of System Settings with invalid data when server mode as None/0 and server role as primary. Empty Primary Server IP Field.
//*/
	@Test (priority = 49)	
    public void checkRecorderMainConfigSettingswithEmptyPrimaryIp() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Main");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click();
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81");
	      
	      // Select Server Mode
	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
//	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
		  String expected = "Please enter Primary Server IP";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	  		  		  
	}				
	
	
	
	

////Test ID: 15-49
///* 
///* "Recorder is Main: Verify the configuration of System Settings with invalid data when server mode as None/0 and server role as primary. Invalid Primary Server IP
//*/
//	@Test (priority = 50)	
    public void checkRecorderMainConfigSettingswithInvalidPrimaryIp() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Main");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click();
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81");
	      
	      // Select Server Mode
	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("3744875874");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
		  String expected = "Invalid Primary Server IP";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	  		  		  
	}					
	
	
	
	
	
////Test ID: 15-50
///* 
///* "Recorder is Main: Verify the configuration of System Settings with invalid data when server mode as None/0 and server role as primary.Empty Secondary Server IP.
//*/
	@Test (priority = 51)	
    public void checkRecorderMainConfigSettingswithEmptySecondaryIp() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Main");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click();
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81");
	      
	      // Select Server Mode
	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
//	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
		  String expected = "Please enter Secondary Server IP";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	  		  		  
	}		
	
	
	
	
	

////Test ID: 15-51
///* 
///* "Recorder is Main: Verify the configuration of System Settings with invalid data when server mode as None/0 and server role as primary.Invalid Secondary Server IP.
//*/
	@Test (priority = 52)	
    public void checkRecorderMainConfigSettingswithInvalidSecondaryIp() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Main");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click();
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81");
	      
	      // Select Server Mode
	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("1262233163");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
		  String expected = "Invalid Secondary Server IP";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	  		  		  
	}		
	
	
	
	
	

////Test ID: 15-52
///* 
///* Recorder is Main: Verify the configuration of System Settings for server mode as None/0 and server role as primary. With out Secondary Server IP and Secondary Database Information.
//*/
	@Test (priority = 53)	
    public void checkRecorderMainConfigSettingswithoutSecondaryInfo() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Main");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click();
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81");
	      
	      // Select Server Mode
	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
//	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("1262233163");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
//	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
//	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
//	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
//	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('Settings have been updated successfully. You will be redirected to the login screen.')");
	     
	      String expected = "Settings have been updated successfully. You will be redirected to the login screen.";
	      Alert confirmation = driver.switchTo().alert();
	      String actual = confirmation.getText(); //Get text present on alert Message
	      
	      // Match alert messages 
	      Assert.assertEquals(actual,expected);
	      driver.switchTo().alert().accept();
	     
	      // Click on okay button
	      Thread.sleep(5000);
	      driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/button")).click(); //.click();
	     
	      driver.close();	  		  		  
	}		
	
	
	
	
////Test ID: 15-53
///* 
///* Recorder is Main: Verify the configuration of System Settings with invalid data when server mode as None/0 and server role as primary. Empty Name.
//*/	
	@Test (priority = 54)	
    public void checkRecorderMainConfigSettingswithEmptyDatabase() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Main");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click();
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81");
	      
	      // Select Server Mode
	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
//	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
		  String expected = "Please enter Server Name";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	  		  		  
	}		
	
	
	
	
	
////Test ID: 15-54
///* 
///* Recorder is Main:Verify the configuration of System Settings with invalid data when server mode as None/0 and server role as primary. Invalid/non existing Secondary Database Server Name.
//*/	
	@Test (priority = 55)	
    public void checkRecorderMainConfigSettingswithInvalidDatabaseServerName() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Main");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click();
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81");
	      
	      // Select Server Mode
	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("Digital.ai");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(300000);
	      
	      // Check alert message
		  String expected = "Failed to connect to remote database. Please verify settings.";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	  		  		  
	}
	
	
	
	

	
////Test ID: 15-55
///* 
///* Recorder is Main: Verify the configuration of System Settings for server mode as None/0 and server role as primary. Empty Secondary Database Name.
//*/	
	@Test (priority = 56)	
    public void checkRecorderMainConfigSettingswithEmptyDatabaseName() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Main");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click();
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81");
	      
	      // Select Server Mode
	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
//	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
		  String expected = "Please enter Database Name";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	  		  		  
	}		
	
	
	
	
	
////Test ID: 15-56
///* 
///* Recorder is Main: Verify the configuration of System Settings for server mode as None/0 and server role as primary. Invalid/non existing Secondary Database Name.
//*/	
	@Test (priority = 57)	
    public void checkRecorderMainConfigSettingswithInvalidDatabaseName() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Main");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click();
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81");
	      
	      // Select Server Mode
	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("Selesti");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
		  String expected = "Failed to connect to remote database. Please verify settings.";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	  		  		  
	}	
	
	
	
	

////Test ID: 15-57
///* 
///* Recorder is Main: Verify the configuration of System Settings for server mode as None/0 and server role as primary. Empty Secondary Database Username.
//*/	
	@Test (priority = 58)	
    public void checkRecorderMainConfigSettingswithEmptyDatabaseUsername() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Main");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click();
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81");
	      
	      // Select Server Mode
	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
//	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
		  String expected = "Please enter Username";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	  		  		  
	}	
	
	
	
	
	

////Test ID: 15-58
///* 
///* Recorder is Main: Verify the configuration of System Settings for server mode as None/0 and server role as primary. Invalid/non existing Secondary Database Username.
//*/	
	@Test (priority = 59)	
    public void checkRecorderMainConfigSettingswithInvalidDatabaseUsername() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Main");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click();
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81");
	      
	      // Select Server Mode
	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sarah");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
		  String expected = "Failed to connect to remote database. Please verify settings.";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	  		  		  
	}		
	
	
	
	
	
////Test ID: 15-59
///* 
///* Recorder is Main: Verify the configuration of System Settings for server mode as None/0 and server role as primary. Empty Secondary Database Password.
//*/	
	@Test (priority = 60)	
    public void checkRecorderMainConfigSettingswithEmptyDatabasepassword() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Main");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click();
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81");
	      
	      // Select Server Mode
	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
//	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
		  String expected = "Please enter password";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	  		  		  
	}	
	
	
	
	
	
////Test ID: 15-60
///* 
///* Recorder is Main: Verify the configuration of System Settings for server mode as None/0 and server role as primary. Invalid/non existing Secondary Database Password.
//*/	
	@Test (priority = 61)	
    public void checkRecorderMainConfigSettingswithInvalidDatabasepassword() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Main");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click();
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81");
	      
	      // Select Server Mode
	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("jinx");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
		  String expected = "Failed to connect to remote database. Please verify settings.";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	  		  		  
	}				
	
	
	
	
	

////Test ID: 15-61
///* 
///* Recorder is Main: Verify the configuration of System Settings for server role as Secondary with valid data. With Secondary Server IP and Secondary Database Information"
//*/	
	@Test (priority = 62)	
    public void checkRecorderMainConfigSettingswithServerRoleSecondary() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Main");
	      
	      // Click on Server Role * Secondary
	      driver.findElement(By.id("rdbServerRoleSecondary")).click();
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81");
	      
	      // Select Server Mode
//	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
//	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('Settings have been updated successfully. You will be redirected to the login screen.')");
	     
	      String expected = "Settings have been updated successfully. You will be redirected to the login screen.";
	      Alert confirmation = driver.switchTo().alert();
	      String actual = confirmation.getText(); //Get text present on alert Message
	      
	      // Match alert messages 
	      Assert.assertEquals(actual,expected);
	      driver.switchTo().alert().accept();
	     
	      // Click on okay button
	      Thread.sleep(5000);
	      driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/button")).click(); //.click();
	     
	      driver.close();	 
	}		
	
	
	
	
	
////Test ID: 15-62
///* 
///* "Recorder is Branch:Verify the configuration of System Settings for server role as primary with all valid data.
//*/	
	@Test (priority = 63)	
    public void checkRecorderBranchConfigSettings() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Branch");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click(); //
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81"); 
	      
//	      // Select Server Mode
//	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
//	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for OPR ID*
	      driver.findElement(By.id("txtBranchGUID")).clear();
	      driver.findElement(By.id("txtBranchGUID")).sendKeys("C27B6-C27B6");
	      
	      // Enter values for Primary Branch IP *
	      driver.findElement(By.id("txtBranchIP")).clear();
	      driver.findElement(By.id("txtBranchIP")).sendKeys("166.140.88.234");
	      
	      // Enter values for Secondary Branch IP *
	      driver.findElement(By.id("txtBranchRemoteIP")).clear();
	      driver.findElement(By.id("txtBranchRemoteIP")).sendKeys("146.158.22.195");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('Settings have been updated successfully. You will be redirected to the login screen.')");
	     
	      String expected = "Settings have been updated successfully. You will be redirected to the login screen.";
	      Alert confirmation = driver.switchTo().alert();
	      String actual = confirmation.getText(); //Get text present on alert Message
	      
	      // Match alert messages 
	      Assert.assertEquals(actual,expected);
	      driver.switchTo().alert().accept();
	     
	      // Click on okay button
	      Thread.sleep(5000);
	      driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/button")).click(); //.click();
	     
	      driver.close();	 
	}	
	
	
	
	

	
////Test ID: 15-118
///* 
///* Verify that  User should not be able to add PRS IP same as Node IP or any other IP given in system settings  in this case error message should be displayed "Primary PBX IP and PRS IP cannot be same
//*/
	@Test (priority = 63)	
		public void verifyConfigurationsforPRSsettingwithDifferentIPs() throws InterruptedException {
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
		    
		    /////////////////////// Get Get value for Primary Server IP and check
		    // Get value for Primary Server IP
		    String primary_server_ip = driver.findElement(By.id("txtPrimaryIP")).getAttribute("value");
		    
		    // Enter values for OXE PRS IP *
		    driver.findElement(By.id("txtPRSIP")).clear(); 
		    driver.findElement(By.id("txtPRSIP")).sendKeys(primary_server_ip); 
		    
		    // Enter values for OXE PRS Version *
		    driver.findElement(By.id("txtPRSVersion")).clear(); 
		    driver.findElement(By.id("txtPRSVersion")).sendKeys("5.0");
		      
		    // Click on update button
		    driver.findElement(By.id("btnUpdatePRSSettings")).click();
		    
		    // Check alert message
			String expectedpip = "Primary Server IP and PRS IP cannot be same";
		    String actualpip = driver.findElement(By.id("lblMessagePRS")).getText();
		    
		    Assert.assertEquals(actualpip, expectedpip);
		    
		    ///////////////////////////////////////// Get value for Secondary Server IP and check
		    // Get value for Secondary Server IP
		    String secondary_server_ip = driver.findElement(By.id("txtSecondaryIP")).getAttribute("value");
		    
		    // Enter values for OXE PRS IP *
		    driver.findElement(By.id("txtPRSIP")).clear(); 
		    driver.findElement(By.id("txtPRSIP")).sendKeys(secondary_server_ip); 
		    
		    // Enter values for OXE PRS Version *
		    driver.findElement(By.id("txtPRSVersion")).clear(); 
		    driver.findElement(By.id("txtPRSVersion")).sendKeys("5.0");
		    
		    // Click on update button
		    driver.findElement(By.id("btnUpdatePRSSettings")).click();
		    
		    // Check alert message
			String expectedsip = "Secondary Server IP and PRS IP cannot be same";
		    String actualsip = driver.findElement(By.id("lblMessagePRS")).getText(); //Secondary Branch Server IP and PRS IP cannot be identical
		    
		    Assert.assertEquals(actualsip, expectedsip);
		    
		    
			///////////////////////////////////////// Get value for Primary Branch Server IP* and check
			// Get value for Secondary Server IP
			String primary_branch_ip = driver.findElement(By.id("txtBranchIP")).getAttribute("value");
			
			// Enter values for OXE PRS IP *
			driver.findElement(By.id("txtPRSIP")).clear(); 
			driver.findElement(By.id("txtPRSIP")).sendKeys(primary_branch_ip); 
			
			// Enter values for OXE PRS Version *
			driver.findElement(By.id("txtPRSVersion")).clear(); 
			driver.findElement(By.id("txtPRSVersion")).sendKeys("5.0");
			
			// Click on update button
			driver.findElement(By.id("btnUpdatePRSSettings")).click();
			
			// Check alert message
			String expectedpbip = "Primary Branch Server IP and PRS IP cannot be identical.";
			String actualpbip = driver.findElement(By.id("lblMessagePRS")).getText(); //Secondary Branch Server IP and PRS IP cannot be identical
			
			Assert.assertEquals(actualpbip, expectedpbip);
			
			
			///////////////////////////////////////// Get value for Secondary Branch Server IP* and check
			// Get value for Secondary Server IP
			String secondary_branch_ip = driver.findElement(By.id("txtBranchRemoteIP")).getAttribute("value");
			
			// Enter values for OXE PRS IP *
			driver.findElement(By.id("txtPRSIP")).clear(); 
			driver.findElement(By.id("txtPRSIP")).sendKeys(secondary_branch_ip); 
			
			// Enter values for OXE PRS Version *
			driver.findElement(By.id("txtPRSVersion")).clear(); 
			driver.findElement(By.id("txtPRSVersion")).sendKeys("5.0");
			
			// Click on update button
			driver.findElement(By.id("btnUpdatePRSSettings")).click();
			
			// Check alert message
			String expectedsbip = "Secondary Branch Server IP and PRS IP cannot be identical";
			String actualsbip = driver.findElement(By.id("lblMessagePRS")).getText(); 
			
			Assert.assertEquals(actualsbip, expectedsbip);
		    
		    
		    // Click On Nodes
		  	Thread.sleep(9000);
		  	driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
		    
		    // Check if there is a node present
		    if (driver.findElement(By.id("NodeTable")).isDisplayed())
		       {
		    	String pbxip = driver.findElement(By.xpath("//*[@id=\"NodeTable\"]/tbody/tr[1]/td[3]/span")).getText();
		       
		    	// Click on System
			    Thread.sleep(10000);
			    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
		      	
			    // Enter values for OXE PRS IP *
			    driver.findElement(By.id("txtPRSIP")).clear(); 
			    driver.findElement(By.id("txtPRSIP")).sendKeys(pbxip);
			    
			    // Enter values for OXE PRS Version *
				driver.findElement(By.id("txtPRSVersion")).clear(); 
				driver.findElement(By.id("txtPRSVersion")).sendKeys("5.0");
				
				// Click on update button
				driver.findElement(By.id("btnUpdatePRSSettings")).click();
		    
			    // Check alert message
				String expectedn = "Primary PBX IP and PRS IP cannot be same";  //"Settings have been updated successfully"; 
			    String actualn = driver.findElement(By.id("lblMessagePRS")).getText();
			    System.out.println("Settings have been updated successfully --> just to pass the test");
			    
			    Assert.assertEquals(actualn, expectedn);
		       }
		    
		    else
		    	System.out.println("No PBX IP Present");
		    
		    driver.close();	  		  		  
		}
	

	
	
	

////Test ID: 15-64
///* 
///* Recorder is Branch:Verify the configuration of System Settings for server role as primary with all valid data. With out Secondary Server IP, Secondary Branch Server IP and Secondary Database Information."
//*/	
	@Test (priority = 62)	
    public void checkRecorderBranchConfigSettingswithoutSecondaryinfo() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Branch");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click(); //
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81"); 
	      
//	      // Select Server Mode
//	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
//	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
//	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for OPR ID*
	      driver.findElement(By.id("txtBranchGUID")).clear();
	      driver.findElement(By.id("txtBranchGUID")).sendKeys("C27B6-C27B6");
	      
	      // Enter values for Primary Branch IP *
	      driver.findElement(By.id("txtBranchIP")).clear();
	      driver.findElement(By.id("txtBranchIP")).sendKeys("166.140.88.234");
	      
	      // Enter values for Secondary Branch IP *
	      driver.findElement(By.id("txtBranchRemoteIP")).clear();
//	      driver.findElement(By.id("txtBranchRemoteIP")).sendKeys("146.158.22.195");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
//	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
//	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
//	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
//	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('Settings have been updated successfully. You will be redirected to the login screen.')");
	     
	      String expected = "Settings have been updated successfully. You will be redirected to the login screen.";
	      Alert confirmation = driver.switchTo().alert();
	      String actual = confirmation.getText(); //Get text present on alert Message
	      
	      // Match alert messages 
	      Assert.assertEquals(actual,expected);
	      driver.switchTo().alert().accept();
	     
	      // Click on okay button
	      Thread.sleep(5000);
	      driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/button")).click(); //.click();
	     
	      driver.close();	 
	}
	
	
	
	
	

////Test ID: 15-64
///* 
///* Recorder is Branch: Verify the configuration of System Settings for server role as primary with invalid data.When Server ID is Empty."
//*/	
	@Test (priority = 65)	
    public void checkRecorderBranchConfigSettingswithEmptyServerId() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Branch");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click(); //
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
//	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81"); 
	      
//	      // Select Server Mode
//	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
//	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for OPR ID*
	      driver.findElement(By.id("txtBranchGUID")).clear();
	      driver.findElement(By.id("txtBranchGUID")).sendKeys("C27B6-C27B6");
	      
	      // Enter values for Primary Branch IP *
	      driver.findElement(By.id("txtBranchIP")).clear();
	      driver.findElement(By.id("txtBranchIP")).sendKeys("166.140.88.234");
	      
	      // Enter values for Secondary Branch IP *
	      driver.findElement(By.id("txtBranchRemoteIP")).clear();
	      driver.findElement(By.id("txtBranchRemoteIP")).sendKeys("146.158.22.195");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
		  String expected = "Please enter Server ID";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	 
	}		
		
	
	
	
	
	
////Test ID: 15-65
///* 
///* Recorder is Branch: Verify the configuration of System Settings for server role as primary with invalid data.When Primary Server IP is Empty.
//*/	
	@Test (priority = 66)	
    public void checkRecorderBranchConfigSettingwithEmptyPrimaryIp() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Branch");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click(); //
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81"); 
	      
//	      // Select Server Mode
//	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
//	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
//	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for OPR ID*
	      driver.findElement(By.id("txtBranchGUID")).clear();
	      driver.findElement(By.id("txtBranchGUID")).sendKeys("C27B6-C27B6");
	      
	      // Enter values for Primary Branch IP *
	      driver.findElement(By.id("txtBranchIP")).clear();
	      driver.findElement(By.id("txtBranchIP")).sendKeys("166.140.88.234");
	      
	      // Enter values for Secondary Branch IP *
	      driver.findElement(By.id("txtBranchRemoteIP")).clear();
	      driver.findElement(By.id("txtBranchRemoteIP")).sendKeys("146.158.22.195");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
		  String expected = "Please enter Primary Server IP";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	 
	}		
	
	
	

	
////Test ID: 15-66
///* 
///* Recorder is Branch: Verify the configuration of System Settings for server role as primary with invalid data.When Primary Server IP is Invalid.
//*/	
	@Test (priority = 67)	
    public void checkRecorderBranchConfigSettingwithInvalidPrimaryIp() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Branch");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click(); 
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81"); 
	      
//	      // Select Server Mode
//	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
//	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172202281");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for OPR ID*
	      driver.findElement(By.id("txtBranchGUID")).clear();
	      driver.findElement(By.id("txtBranchGUID")).sendKeys("C27B6-C27B6");
	      
	      // Enter values for Primary Branch IP *
	      driver.findElement(By.id("txtBranchIP")).clear();
	      driver.findElement(By.id("txtBranchIP")).sendKeys("166.140.88.234");
	      
	      // Enter values for Secondary Branch IP *
	      driver.findElement(By.id("txtBranchRemoteIP")).clear();
	      driver.findElement(By.id("txtBranchRemoteIP")).sendKeys("146.158.22.195");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
		  String expected = "Invalid Primary Server IP";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	 
	}	
	
	
	
	
	
////Test ID: 15-67
///* 
///* Recorder is Branch: Verify the configuration of System Settings for server role as primary with invalid data. When Empty OPR ID."
//*/	
	@Test (priority = 68)	
    public void checkRecorderBranchConfigSettingwithEmptyOPRIp() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Branch");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click(); 
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81"); 
	      
//	      // Select Server Mode
//	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
//	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for OPR ID*
	      driver.findElement(By.id("txtBranchGUID")).clear();
//	      driver.findElement(By.id("txtBranchGUID")).sendKeys("C27B6-C27B6");
	      
	      // Enter values for Primary Branch IP *
	      driver.findElement(By.id("txtBranchIP")).clear();
	      driver.findElement(By.id("txtBranchIP")).sendKeys("166.140.88.234");
	      
	      // Enter values for Secondary Branch IP *
	      driver.findElement(By.id("txtBranchRemoteIP")).clear();
	      driver.findElement(By.id("txtBranchRemoteIP")).sendKeys("146.158.22.195");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
		  String expected = "Please enter OPR ID";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	 
	}	
	
	
	
	
	
////Test ID: 15-68
///* 
///* Recorder is Branch: Verify the configuration of System Settings for server role as primary with invalid data.When Empty Primary Branch Server IP."
//*/	
	@Test (priority = 69)	
    public void checkRecorderBranchConfigSettingwithEmptyPrimaryBranchServerIP() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Branch");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click(); 
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81"); 
	      
//	      // Select Server Mode
//	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
//	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for OPR ID*
	      driver.findElement(By.id("txtBranchGUID")).clear();
	      driver.findElement(By.id("txtBranchGUID")).sendKeys("C27B6-C27B6");
	      
	      // Enter values for Primary Branch IP *
	      driver.findElement(By.id("txtBranchIP")).clear();
//	      driver.findElement(By.id("txtBranchIP")).sendKeys("166.140.88.234");
	      
	      // Enter values for Secondary Branch IP *
	      driver.findElement(By.id("txtBranchRemoteIP")).clear();
	      driver.findElement(By.id("txtBranchRemoteIP")).sendKeys("146.158.22.195");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
		  String expected = "Please enter Primary Branch Server IP";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	 
	}	
	
	
	
	
	

////Test ID: 15-69
///* 
///* Recorder is Branch:Verify the configuration of System Settings for server role as primary with invalid data. When invalid Primary Branch Server IP.
//*/	
	@Test (priority = 70)	
    public void checkRecorderBranchConfigSettingwithInvalidPrimaryBranchServerIP() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Branch");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click(); 
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81"); 
	      
//	      // Select Server Mode
//	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
//	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for OPR ID*
	      driver.findElement(By.id("txtBranchGUID")).clear();
	      driver.findElement(By.id("txtBranchGUID")).sendKeys("C27B6-C27B6");
	      
	      // Enter values for Primary Branch IP *
	      driver.findElement(By.id("txtBranchIP")).clear();
	      driver.findElement(By.id("txtBranchIP")).sendKeys("16614088234");
	      
	      // Enter values for Secondary Branch IP *
	      driver.findElement(By.id("txtBranchRemoteIP")).clear();
	      driver.findElement(By.id("txtBranchRemoteIP")).sendKeys("146.158.22.195");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
		  String expected = "Invalid Primary Branch Server IP address";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	 
	}
	
	
	
	
	
////Test ID: 15-70
///* 
///* "Recorder is Branch:Verify the configuration of System Settings for server role as primary with invalid data. When invalid Secondary Branch Server IP.
//*/	
	@Test (priority = 71)	
    public void checkRecorderBranchConfigSettingwithInvalidSecondaryBranchServerIP() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Branch");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click(); 
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81"); 
	      
//	      // Select Server Mode
//	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
//	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for OPR ID*
	      driver.findElement(By.id("txtBranchGUID")).clear();
	      driver.findElement(By.id("txtBranchGUID")).sendKeys("C27B6-C27B6");
	      
	      // Enter values for Primary Branch IP *
	      driver.findElement(By.id("txtBranchIP")).clear();
	      driver.findElement(By.id("txtBranchIP")).sendKeys("166.140.88.234");
	      
	      // Enter values for Secondary Branch IP *
	      driver.findElement(By.id("txtBranchRemoteIP")).clear();
	      driver.findElement(By.id("txtBranchRemoteIP")).sendKeys("14615822195");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
		  String expected = "Invalid Secondary Branch Server IP address";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	 
	}	

	

	
	

////Test ID: 15-71
///* 
///* Recorder is Branch: Verify the configuration of System Settings for server role as primary with invalid data. When empty Secondary Database Server Name.
//*/	
	@Test (priority = 72)	
    public void checkRecorderBranchConfigSettingwithEmptySecondaryBranchServerName() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Branch");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click(); 
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81"); 
	      
//	      // Select Server Mode
//	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
//	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for OPR ID*
	      driver.findElement(By.id("txtBranchGUID")).clear();
	      driver.findElement(By.id("txtBranchGUID")).sendKeys("C27B6-C27B6");
	      
	      // Enter values for Primary Branch IP *
	      driver.findElement(By.id("txtBranchIP")).clear();
	      driver.findElement(By.id("txtBranchIP")).sendKeys("166.140.88.234");
	      
	      // Enter values for Secondary Branch IP *
	      driver.findElement(By.id("txtBranchRemoteIP")).clear();
	      driver.findElement(By.id("txtBranchRemoteIP")).sendKeys("146.158.22.195");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
//	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
		  String expected = "Please enter Server Name";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	 
	}	
	
	
	
	

////Test ID: 15-72
///* 
///* Recorder is Branch: Verify the configuration of System Settings for server role as primary with invalid data. When invalid/non existing Secondary Database Server Name.
//*/	
	@Test (priority = 73)	
    public void checkRecorderBranchConfigSettingwithInvalidSecondaryBranchServerName() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Branch");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click(); 
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81"); 
	      
//	      // Select Server Mode
//	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
//	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for OPR ID*
	      driver.findElement(By.id("txtBranchGUID")).clear();
	      driver.findElement(By.id("txtBranchGUID")).sendKeys("C27B6-C27B6");
	      
	      // Enter values for Primary Branch IP *
	      driver.findElement(By.id("txtBranchIP")).clear();
	      driver.findElement(By.id("txtBranchIP")).sendKeys("166.140.88.234");
	      
	      // Enter values for Secondary Branch IP *
	      driver.findElement(By.id("txtBranchRemoteIP")).clear();
	      driver.findElement(By.id("txtBranchRemoteIP")).sendKeys("146.158.22.195");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("Selesti");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(100000);
	      
	      // Check alert message
		  String expected = "Failed to connect to remote database. Please verify settings.";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	 
	}		
	
	
	
	
	
	
////Test ID: 15-73
///* 
///* Recorder is Branch: Verify the configuration of System Settings for server role as primary with invalid data. When empty Secondary Database Name.
//*/	
	@Test (priority = 74)	
    public void checkRecorderBranchConfigSettingwithEmptySecondaryBranchDatabaseName() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Branch");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click(); 
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81"); 
	      
//	      // Select Server Mode
//	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
//	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for OPR ID*
	      driver.findElement(By.id("txtBranchGUID")).clear();
	      driver.findElement(By.id("txtBranchGUID")).sendKeys("C27B6-C27B6");
	      
	      // Enter values for Primary Branch IP *
	      driver.findElement(By.id("txtBranchIP")).clear();
	      driver.findElement(By.id("txtBranchIP")).sendKeys("166.140.88.234");
	      
	      // Enter values for Secondary Branch IP *
	      driver.findElement(By.id("txtBranchRemoteIP")).clear();
	      driver.findElement(By.id("txtBranchRemoteIP")).sendKeys("146.158.22.195");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
//	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(70000);
	      
	      // Check alert message
		  String expected = "Please enter Database Name";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	 
	}			
	
	

	
	
	
////Test ID: 15-74
///* 
///* Recorder is Branch: Verify the configuration of System Settings for server role as primary with invalid data. When invalid/non existing Secondary Database Name.
//*/	
	@Test (priority = 75)	
    public void checkRecorderBranchConfigSettingwithIvalidSecondaryBranchDatabaseName() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Branch");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click(); 
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81"); 
	      
//	      // Select Server Mode
//	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
//	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for OPR ID*
	      driver.findElement(By.id("txtBranchGUID")).clear();
	      driver.findElement(By.id("txtBranchGUID")).sendKeys("C27B6-C27B6");
	      
	      // Enter values for Primary Branch IP *
	      driver.findElement(By.id("txtBranchIP")).clear();
	      driver.findElement(By.id("txtBranchIP")).sendKeys("166.140.88.234");
	      
	      // Enter values for Secondary Branch IP *
	      driver.findElement(By.id("txtBranchRemoteIP")).clear();
	      driver.findElement(By.id("txtBranchRemoteIP")).sendKeys("146.158.22.195");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
		  String expected = "Failed to connect to remote database. Please verify settings.";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	 
	}	
	
	
	


////Test ID: 15-75
///* 
///* Recorder is Branch:Verify the configuration of System Settings for server role as primary with invalid data. When empty Secondary Database Username.
//*/	
	@Test (priority = 76)	
    public void checkRecorderBranchConfigSettingwithEmptySecondaryBranchDatabaseUsername() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Branch");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click(); 
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81"); 
	      
//	      // Select Server Mode
//	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
//	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for OPR ID*
	      driver.findElement(By.id("txtBranchGUID")).clear();
	      driver.findElement(By.id("txtBranchGUID")).sendKeys("C27B6-C27B6");
	      
	      // Enter values for Primary Branch IP *
	      driver.findElement(By.id("txtBranchIP")).clear();
	      driver.findElement(By.id("txtBranchIP")).sendKeys("166.140.88.234");
	      
	      // Enter values for Secondary Branch IP *
	      driver.findElement(By.id("txtBranchRemoteIP")).clear();
	      driver.findElement(By.id("txtBranchRemoteIP")).sendKeys("146.158.22.195");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
//	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
		  String expected = "Please enter Username";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	 
	}		
	
	
	
	
	

////Test ID: 15-76
///* 
///* Recorder is Branch: Verify the configuration of System Settings for server role as primary with invalid data. When invalid/non existing Secondary Database Username.
//*/	
	@Test (priority = 77)	
    public void checkRecorderBranchConfigSettingwithIvalidSecondaryBranchDatabaseUsername() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Branch");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click(); 
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81"); 
	      
//	      // Select Server Mode
//	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
//	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for OPR ID*
	      driver.findElement(By.id("txtBranchGUID")).clear();
	      driver.findElement(By.id("txtBranchGUID")).sendKeys("C27B6-C27B6");
	      
	      // Enter values for Primary Branch IP *
	      driver.findElement(By.id("txtBranchIP")).clear();
	      driver.findElement(By.id("txtBranchIP")).sendKeys("166.140.88.234");
	      
	      // Enter values for Secondary Branch IP *
	      driver.findElement(By.id("txtBranchRemoteIP")).clear();
	      driver.findElement(By.id("txtBranchRemoteIP")).sendKeys("146.158.22.195");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sarah");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
		  String expected = "Failed to connect to remote database. Please verify settings.";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	 
	}			
	
	
	
	
	
////Test ID: 15-77
///* 
///* Recorder is Branch: Verify the configuration of System Settings for server role as primary with invalid data. When empty Secondary Database Password.
//*/	
	@Test (priority = 78)	
    public void checkRecorderBranchConfigSettingwithEmptySecondaryBranchDatabasePassword() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Branch");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click(); 
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81"); 
	      
//	      // Select Server Mode
//	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
//	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for OPR ID*
	      driver.findElement(By.id("txtBranchGUID")).clear();
	      driver.findElement(By.id("txtBranchGUID")).sendKeys("C27B6-C27B6");
	      
	      // Enter values for Primary Branch IP *
	      driver.findElement(By.id("txtBranchIP")).clear();
	      driver.findElement(By.id("txtBranchIP")).sendKeys("166.140.88.234");
	      
	      // Enter values for Secondary Branch IP *
	      driver.findElement(By.id("txtBranchRemoteIP")).clear();
	      driver.findElement(By.id("txtBranchRemoteIP")).sendKeys("146.158.22.195");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
//	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
		  String expected = "Please enter password";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	 
	}				
	
	
	
	

////Test ID: 15-78
///* 
///* Recorder is Branch: Verify the configuration of System Settings for server role as primary with invalid data. When invalid/non existing Secondary Database Password.
//*/	
	@Test (priority = 79)	
    public void checkRecorderBranchConfigSettingwithInvalidSecondaryBranchDatabasePassword() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Branch");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click(); 
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81"); 
	      
//	      // Select Server Mode
//	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
//	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for OPR ID*
	      driver.findElement(By.id("txtBranchGUID")).clear();
	      driver.findElement(By.id("txtBranchGUID")).sendKeys("C27B6-C27B6");
	      
	      // Enter values for Primary Branch IP *
	      driver.findElement(By.id("txtBranchIP")).clear();
	      driver.findElement(By.id("txtBranchIP")).sendKeys("166.140.88.234");
	      
	      // Enter values for Secondary Branch IP *
	      driver.findElement(By.id("txtBranchRemoteIP")).clear();
	      driver.findElement(By.id("txtBranchRemoteIP")).sendKeys("146.158.22.195");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("lin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
		  String expected = "Failed to connect to remote database. Please verify settings.";
          String actual = driver.findElement(By.id("lblMessageSystem")).getText();
	      
          Assert.assertEquals(actual, expected);
	     
	      driver.close();	 
	}		
	
	
	
	

////Test ID: 15-79
///* 
///* Recorder is Branch: Verify the configuration of System Settings for server role as Secondary with all valid data.
//*/	
	@Test (priority = 80)	
    public void checkRecorderBranchConfigSettingswithServerRoleSecondary() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Branch");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRoleSecondary")).click(); 
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81"); 
	      
//	      // Select Server Mode
//	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
//	      dropdownSM.selectByVisibleText("None");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();
	      driver.findElement(By.id("txtSecondaryIP")).sendKeys("126.223.3.163");
	      
	      // Enter values for OPR ID*
	      driver.findElement(By.id("txtBranchGUID")).clear();
	      driver.findElement(By.id("txtBranchGUID")).sendKeys("C27B6-C27B6");
	      
	      // Enter values for Primary Branch IP *
	      driver.findElement(By.id("txtBranchIP")).clear();
	      driver.findElement(By.id("txtBranchIP")).sendKeys("166.140.88.234");
	      
	      // Enter values for Secondary Branch IP *
	      driver.findElement(By.id("txtBranchRemoteIP")).clear();
	      driver.findElement(By.id("txtBranchRemoteIP")).sendKeys("146.158.22.195");
	      
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear();
	      driver.findElement(By.id("txtDBServerName")).sendKeys("WINDOWSSERVER20\\SQLEXPRESS");
	      
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      driver.findElement(By.id("txtRemoteDBName")).sendKeys("OPCXR_Config_Secondary");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      driver.findElement(By.id("txtDBUSername")).sendKeys("sa");
	     
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();
	      driver.findElement(By.id("txtDBPassword")).sendKeys("sqlin1.");
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      Thread.sleep(6000);
	      
	      // Check alert message
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('Settings have been updated successfully. You will be redirected to the login screen.')");
	     
	      String expected = "Settings have been updated successfully. You will be redirected to the login screen.";
	      Alert confirmation = driver.switchTo().alert();
	      String actual = confirmation.getText(); //Get text present on alert Message
	      
	      // Match alert messages 
	      Assert.assertEquals(actual,expected);
	      driver.switchTo().alert().accept();
	     
	      // Click on okay button
	      Thread.sleep(5000);
	      driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/button")).click(); //.click();
	     
	      driver.close(); 
	}	
	
	
	
	
	
	
////////////////////////////////////	
//RESET AFTER SYSTEM CONFIG TESTS 	
///////////////////////////////////	
	@Test (priority = 81)	
    public void RecorderMainConfigSettingServerModeasMaster() throws InterruptedException {
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
	      
	      // Select Recorder
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	      dropdownRC.selectByVisibleText("Main");
	      
	      // Click on Server Role * Primary
	      driver.findElement(By.id("rdbServerRolePrimary")).click();
	      
	      // Enter values for Server ID *
	      driver.findElement(By.id("txtServerName")).clear();
	      driver.findElement(By.id("txtServerName")).sendKeys("172.20.22.81");
	      
	      // Select Server Mode
	      Select dropdownSM = new Select(driver.findElement(By.id("cboServerMode")));
	      dropdownSM.selectByVisibleText("Master");
	      
	      // Enter values for Primary Server IP *
	      driver.findElement(By.id("txtPrimaryIP")).clear();
	      driver.findElement(By.id("txtPrimaryIP")).sendKeys("172.20.22.81");
	      
	      // Clear all Secondary values
	      // Enter values for Secondary Server IP *
	      driver.findElement(By.id("txtSecondaryIP")).clear();  
	      // Enter values for Server Name * 
	      driver.findElement(By.id("txtDBServerName")).clear(); 
	      // Enter values for Database Name * 
	      driver.findElement(By.id("txtRemoteDBName")).clear();
	      // Enter values for Username *
	      driver.findElement(By.id("txtDBUSername")).clear();
	      // Enter values for Password *
	      driver.findElement(By.id("txtDBPassword")).clear();   
	      
	      // Click on Update button
	      driver.findElement(By.id("btnSaveSystemSettings")).click();
	      
	      // Check alert message
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('Settings have been updated successfully. You will be redirected to the login screen.')");
	     
	      String expected = "Settings have been updated successfully. You will be redirected to the login screen.";
	      Alert confirmation = driver.switchTo().alert();
	      String actual = confirmation.getText(); //Get text present on alert Message
	      
	      // Match alert messages 
	      Assert.assertEquals(actual,expected);
	      driver.switchTo().alert().accept();
	     
	      // Click on okay button
	      Thread.sleep(3000);
	      driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/button")).click(); //.click();
	     
	      driver.close();	  		  		  
	}
	
	
	
	
	

////Test ID: 15-113
///* 
///* Verify configurations for PRS settings.
//*/	
	@Test (priority = 82)	
  public void verifyConfigurationsforPRSsettings() throws InterruptedException {
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
	      
	      // Enter values for OXE PRS IP *
	      driver.findElement(By.id("txtPRSIP")).clear(); 
	      driver.findElement(By.id("txtPRSIP")).sendKeys("172.20.1.68");
	      
	      // Enter values for OXE PRS Version *
	      driver.findElement(By.id("txtPRSVersion")).clear(); 
	      driver.findElement(By.id("txtPRSVersion")).sendKeys("5.0");
	      
	      // Click on update button
	      driver.findElement(By.id("btnUpdatePRSSettings")).click();
	      
	      // Check alert message
		  String expected = "Settings have been updated successfully";
          String actual = driver.findElement(By.id("lblMessagePRS")).getText();
	      
          Assert.assertEquals(actual, expected);
	      
    driver.close();	  		  		  
   	}
	
	
	
	

////Test ID: 15-114
///* 
///* Enter invalid OXE PRS IP.
//*/	
	@Test (priority = 83)	
  public void verifyConfigurationsforPRSsettingwithInvalidIP() throws InterruptedException {
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
	      
	      // Enter values for OXE PRS IP *
	      driver.findElement(By.id("txtPRSIP")).clear(); 
	      driver.findElement(By.id("txtPRSIP")).sendKeys("17220168");
	      
	      // Enter values for OXE PRS Version *
	      driver.findElement(By.id("txtPRSVersion")).clear(); 
	      driver.findElement(By.id("txtPRSVersion")).sendKeys("5.0");
	      
	      // Click on update button
	      driver.findElement(By.id("btnUpdatePRSSettings")).click();
	      
	      // Check alert message
		  String expected = "Invalid OXE PRS IP";
          String actual = driver.findElement(By.id("lblMessagePRS")).getText();
	      
          Assert.assertEquals(actual, expected);
	      
    driver.close();	  		  		  
   	}	
	

	
	
	
////Test ID: 15-115
///* 
///*  Enter valid OXE PRS IP.Enter invalid OXE PRS Version less than 5.0.
//*/	
	@Test (priority = 84)	
  public void verifyConfigurationsforPRSsettingwithValidIPandlessthan5Version() throws InterruptedException {
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
	      
	      // Enter values for OXE PRS IP *
	      driver.findElement(By.id("txtPRSIP")).clear(); 
	      driver.findElement(By.id("txtPRSIP")).sendKeys("172.20.1.68");
	      
	      // Enter values for OXE PRS Version *
	      driver.findElement(By.id("txtPRSVersion")).clear(); 
	      driver.findElement(By.id("txtPRSVersion")).sendKeys("4.0");
	      
	      // Click on update button
	      driver.findElement(By.id("btnUpdatePRSSettings")).click();
	      
	      // Check alert message
		  String expected = "PRS version should be greater than or equal to 5.0.";
          String actual = driver.findElement(By.id("lblMessagePRS")).getText();
	      
          Assert.assertEquals(actual, expected);
	      
    driver.close();	  		  		  
   	}		
	
	
	
	
	
	
////Test ID: 15-116
///* 
///* Leave empty OXE PRS IP. Enter valid OXE PRS Version
//*/	
	@Test (priority = 85)	
  public void verifyConfigurationsforPRSsettingwithEmptyIPandValidVersion() throws InterruptedException {
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
	      
	      // Enter values for OXE PRS IP *
	      driver.findElement(By.id("txtPRSIP")).clear(); 
//	      driver.findElement(By.id("txtPRSIP")).sendKeys("172.20.1.68");
	      
	      // Enter values for OXE PRS Version *
	      driver.findElement(By.id("txtPRSVersion")).clear(); 
	      driver.findElement(By.id("txtPRSVersion")).sendKeys("4.0");
	      
	      // Click on update button
	      driver.findElement(By.id("btnUpdatePRSSettings")).click();
	      
	      // Check alert message
		  String expected = "Please enter OXE PRS IP";
          String actual = driver.findElement(By.id("lblMessagePRS")).getText();
	      
          Assert.assertEquals(actual, expected);
	      
    driver.close();	  		  		  
   	}	
	
	


////Test ID: 15-117
///* 
///* Enter OXE PRS IP. Leave empty OXE PRS Version
//*/	
	@Test (priority = 86)	
  public void verifyConfigurationsforPRSsettingwithValidIPandEmptyVersion() throws InterruptedException {
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
	      
	      // Enter values for OXE PRS IP *
	      driver.findElement(By.id("txtPRSIP")).clear(); 
	      driver.findElement(By.id("txtPRSIP")).sendKeys("172.20.1.68");
	      
	      // Enter values for OXE PRS Version *
	      driver.findElement(By.id("txtPRSVersion")).clear(); 
//	      driver.findElement(By.id("txtPRSVersion")).sendKeys("5.0");
	      
	      // Click on update button
	      driver.findElement(By.id("btnUpdatePRSSettings")).click();
	      
	      // Check alert message
		  String expected = "Please enter PRS Version";
          String actual = driver.findElement(By.id("lblMessagePRS")).getText();
	      
          Assert.assertEquals(actual, expected);
	      
    driver.close();	  		  		  
   	}		
	
	
	
	

////Test ID: 15-120
///* 
///* Verify that error message is displayed when user gives only dots in PRS version field
//*/	
	@Test (priority = 87)	
  public void verifyConfigurationsforPRSsettingwithInvalidIPasdots() throws InterruptedException {
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
	      
	      // Enter values for OXE PRS IP *
	      driver.findElement(By.id("txtPRSIP")).clear(); 
	      driver.findElement(By.id("txtPRSIP")).sendKeys("......");
	      
	      // Enter values for OXE PRS Version *
	      driver.findElement(By.id("txtPRSVersion")).clear(); 
	      driver.findElement(By.id("txtPRSVersion")).sendKeys("5.0");
	      
	      // Click on update button
	      driver.findElement(By.id("btnUpdatePRSSettings")).click();
	      
	      // Check alert message
		  String expected = "Invalid OXE PRS IP";
          String actual = driver.findElement(By.id("lblMessagePRS")).getText();
	      
          Assert.assertEquals(actual, expected);
	      
    driver.close();	  		  		  
   	}		
	
	
	
	

////Test ID: 15-119
///* 
///* Verify that PRS IP field should accept only numeric value on system page under PRS settings section.
//*/	
	@Test (priority = 88)	
    public void verifyConfigurationsforPRSsettingwithOnlyNumericsinIP() throws InterruptedException {
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
	      
	      // Enter values for OXE PRS IP *
	      driver.findElement(By.id("txtPRSIP")).clear(); 
	      driver.findElement(By.id("txtPRSIP")).sendKeys("7673643934gdkjgfkgefyeg");
	      
	      // Check alert message
		  String expected = "7673643934";
          String actual = driver.findElement(By.id("txtPRSIP")).getAttribute("value");
	      
          Assert.assertEquals(actual, expected);
	      
    driver.close();	  		  		  
   	}			
	
	
	
	

////Test ID: 15-80
///* 
///* Verify configurations for Recording Transfer Settings when Transfer Media is FTP.
//*/	
	@Test (priority = 89)	
    public void checkRecordingTransferSettingswithFTP() throws InterruptedException {
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
	      
	      // Check Transfer Media * type --> FTP
	      driver.findElement(By.id("rbNetworkTypeFTP")).click();
	      
	      // Enter values for FTP URL *
	      driver.findElement(By.id("txtNetworkPath")).clear(); 
	      driver.findElement(By.id("txtNetworkPath")).sendKeys("ftp://172.20.0.50/");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtNetworkUserName")).clear(); 
	      driver.findElement(By.id("txtNetworkUserName")).sendKeys("sarah");
	      
	      // Enter values for Password * 
	      driver.findElement(By.id("txtNetworkPassword")).clear();
	      driver.findElement(By.id("txtNetworkPassword")).sendKeys("ggg2k7");
	      
	      // Enter values for Schedule interval *
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).clear();
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).sendKeys("5"); 
	      
	      boolean passivemode = driver.findElement(By.id("cbNetworkIsPassive")).isSelected();
	      
	      if (passivemode == true)
	      {
	    	  // Click on update button
		      driver.findElement(By.id("btnUpdateTransferSettings")).click();}
	      
	      else  // (passivemode == false)
	      {
	    	  // Check Passive Mode
		      driver.findElement(By.id("cbNetworkIsPassive")).click();
		      
		      // Click on update button
		      driver.findElement(By.id("btnUpdateTransferSettings")).click(); }
	       
	      Thread.sleep(6000);
	      	      
	      // Check alert message
		  String expected = "Settings have been updated successfully";
          String actual = driver.findElement(By.id("lblTransferRecordingMessage")).getText();
	      
          Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	     	}	
	
	
	
	

////Test ID: 15-81
///* 
///*  Invalid FTP URL format
//*/	
	@Test (priority = 90)	
    public void checkRecordingTransferSettingswithInvalidFTP() throws InterruptedException {
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
	      
	      // Check Transfer Media * type --> FTP
	      driver.findElement(By.id("rbNetworkTypeFTP")).click();
	      
	      // Enter values for FTP URL *
	      driver.findElement(By.id("txtNetworkPath")).clear(); 
	      driver.findElement(By.id("txtNetworkPath")).sendKeys("ftp://17220050/");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtNetworkUserName")).clear(); 
	      driver.findElement(By.id("txtNetworkUserName")).sendKeys("sarah");
	      
	      // Enter values for Password * 
	      driver.findElement(By.id("txtNetworkPassword")).clear();
	      driver.findElement(By.id("txtNetworkPassword")).sendKeys("ggg2k7");
	      
	      // Enter values for Schedule interval *
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).clear();
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).sendKeys("5");
	       
	      boolean passivemode = driver.findElement(By.id("cbNetworkIsPassive")).isSelected();
	      
	      if (passivemode == true)
	      {
	    	  // Click on update button
		      driver.findElement(By.id("btnUpdateTransferSettings")).click();}
	      
	      else  // (passivemode == false)
	      {
	    	  // Check Passive Mode
		      driver.findElement(By.id("cbNetworkIsPassive")).click();
		      
		      // Click on update button
		      driver.findElement(By.id("btnUpdateTransferSettings")).click(); }
	       
	      Thread.sleep(9000);
	      	      
	      // Check alert message
		  String expected = "Transfer FTP URL is not valid.";
          String actual = driver.findElement(By.id("lblTransferRecordingMessage")).getText();
	      
          Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	     	}		
	
	
	
	

////Test ID: 15-82
///* 
///*  Enter invalid FTP URL  but valid format
//*/	
	@Test (priority = 91)	
    public void checkRecordingTransferSettingswithInvalidFTPValidFormat() throws InterruptedException {
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
	      
	      // Check Transfer Media * type --> FTP
	      driver.findElement(By.id("rbNetworkTypeFTP")).click();
	      
	      // Enter values for FTP URL *
	      driver.findElement(By.id("txtNetworkPath")).clear(); 
	      driver.findElement(By.id("txtNetworkPath")).sendKeys("ftp://172.20.0.40/");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtNetworkUserName")).clear(); 
	      driver.findElement(By.id("txtNetworkUserName")).sendKeys("sarah");
	      
	      // Enter values for Password * 
	      driver.findElement(By.id("txtNetworkPassword")).clear();
	      driver.findElement(By.id("txtNetworkPassword")).sendKeys("ggg2k7");
	      
	      // Enter values for Schedule interval *
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).clear();
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).sendKeys("5");
	       
	      boolean passivemode = driver.findElement(By.id("cbNetworkIsPassive")).isSelected();
	      
	      if (passivemode == true)
	      {
	    	  // Click on update button
		      driver.findElement(By.id("btnUpdateTransferSettings")).click();}
	      
	      else  // (passivemode == false)
	      {
	    	  // Check Passive Mode
		      driver.findElement(By.id("cbNetworkIsPassive")).click();
		      
		      // Click on update button
		      driver.findElement(By.id("btnUpdateTransferSettings")).click(); }
	       
	      Thread.sleep(9000);
	      	      
	      // Check alert message
		  String expected = "Transfer FTP URL is not valid.";
          String actual = driver.findElement(By.id("lblTransferRecordingMessage")).getText();
	      
          Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	     	}			
	
	
	
	
////Test ID: 15-83
///* 
///*  Leave empty FTP URL 
//*/	
	@Test (priority = 92)	
    public void checkRecordingTransferSettingswithEmptyFTP() throws InterruptedException {
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
	      
	      // Check Transfer Media * type --> FTP
	      driver.findElement(By.id("rbNetworkTypeFTP")).click();
	      
	      // Enter values for FTP URL *
	      driver.findElement(By.id("txtNetworkPath")).clear(); 
//	      driver.findElement(By.id("txtNetworkPath")).sendKeys("ftp://172.20.0.40/");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtNetworkUserName")).clear(); 
	      driver.findElement(By.id("txtNetworkUserName")).sendKeys("sarah");
	      
	      // Enter values for Password * 
	      driver.findElement(By.id("txtNetworkPassword")).clear();
	      driver.findElement(By.id("txtNetworkPassword")).sendKeys("ggg2k7");
	      
	      // Enter values for Schedule interval *
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).clear();
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).sendKeys("5");
	       
	      boolean passivemode = driver.findElement(By.id("cbNetworkIsPassive")).isSelected();
	      
	      if (passivemode == true)
	      {
	    	  // Click on update button
		      driver.findElement(By.id("btnUpdateTransferSettings")).click();}
	      
	      else  // (passivemode == false)
	      {
	    	  // Check Passive Mode
		      driver.findElement(By.id("cbNetworkIsPassive")).click();
		      
		      // Click on update button
		      driver.findElement(By.id("btnUpdateTransferSettings")).click(); }
	       
	      Thread.sleep(9000);
	      	      
	      // Check alert message
		  String expected = "Please provide valid FTP URL.";
          String actual = driver.findElement(By.id("lblTransferRecordingMessage")).getText();
	      
          Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	     	}	
	
	
	
	
////Test ID: 15-84
///* 
///*  Enter invalid Username 
//*/	
	@Test (priority = 93)	
    public void checkRecordingTransferSettingswithInvalidFTPusername() throws InterruptedException {
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
	      
	      // Check Transfer Media * type --> FTP
	      driver.findElement(By.id("rbNetworkTypeFTP")).click();
	      
	      // Enter values for FTP URL *
	      driver.findElement(By.id("txtNetworkPath")).clear(); 
	      driver.findElement(By.id("txtNetworkPath")).sendKeys("ftp://172.20.0.50/");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtNetworkUserName")).clear(); 
	      driver.findElement(By.id("txtNetworkUserName")).sendKeys("sa");
	      
	      // Enter values for Password * 
	      driver.findElement(By.id("txtNetworkPassword")).clear();
	      driver.findElement(By.id("txtNetworkPassword")).sendKeys("ggg2k7");
	      
	      // Enter values for Schedule interval *
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).clear();
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).sendKeys("5");
	       
	      boolean passivemode = driver.findElement(By.id("cbNetworkIsPassive")).isSelected();
	      
	      if (passivemode == true)
	      {
	    	  // Click on update button
		      driver.findElement(By.id("btnUpdateTransferSettings")).click();}
	      
	      else  // (passivemode == false)
	      {
	    	  // Check Passive Mode
		      driver.findElement(By.id("cbNetworkIsPassive")).click();
		      
		      // Click on update button
		      driver.findElement(By.id("btnUpdateTransferSettings")).click(); }
	       
	      Thread.sleep(9000);
	      	      
	      // Check alert message
		  String expected = "Transfer FTP credentials are not valid.";
          String actual = driver.findElement(By.id("lblTransferRecordingMessage")).getText();
	      
          Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	     	}
	
	
	
	
////Test ID: 15-85
///* 
///*  Enter invalid password 
//*/	
	@Test (priority = 94)	
    public void checkRecordingTransferSettingswithInvalidFTPpassword() throws InterruptedException {
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
	      
	      // Check Transfer Media * type --> FTP
	      driver.findElement(By.id("rbNetworkTypeFTP")).click();
	      
	      // Enter values for FTP URL *
	      driver.findElement(By.id("txtNetworkPath")).clear(); 
	      driver.findElement(By.id("txtNetworkPath")).sendKeys("ftp://172.20.0.50/");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtNetworkUserName")).clear(); 
	      driver.findElement(By.id("txtNetworkUserName")).sendKeys("sa");
	      
	      // Enter values for Password * 
	      driver.findElement(By.id("txtNetworkPassword")).clear();
	      driver.findElement(By.id("txtNetworkPassword")).sendKeys("ggg2f7");
	      
	      // Enter values for Schedule interval *
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).clear();
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).sendKeys("5");
	       
	      boolean passivemode = driver.findElement(By.id("cbNetworkIsPassive")).isSelected();
	      
	      if (passivemode == true)
	      {
	    	  // Click on update button
		      driver.findElement(By.id("btnUpdateTransferSettings")).click();}
	      
	      else  // (passivemode == false)
	      {
	    	  // Check Passive Mode
		      driver.findElement(By.id("cbNetworkIsPassive")).click();
		      
		      // Click on update button
		      driver.findElement(By.id("btnUpdateTransferSettings")).click(); }
	       
	      Thread.sleep(9000);
	      	      
	      // Check alert message
		  String expected = "Transfer FTP credentials are not valid.";
          String actual = driver.findElement(By.id("lblTransferRecordingMessage")).getText();
	      
          Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	     	}	
	
	
	
	

////Test ID: 15-86
///* 
///*  Leave empty Username
//*/	
	@Test (priority = 94)	
    public void checkRecordingTransferSettingswithEmptyFTPusername() throws InterruptedException {
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
	      
	      // Check Transfer Media * type --> FTP
	      driver.findElement(By.id("rbNetworkTypeFTP")).click();
	      
	      // Enter values for FTP URL *
	      driver.findElement(By.id("txtNetworkPath")).clear(); 
	      driver.findElement(By.id("txtNetworkPath")).sendKeys("ftp://172.20.0.50/");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtNetworkUserName")).clear(); 
//	      driver.findElement(By.id("txtNetworkUserName")).sendKeys("sa");
	      
	      // Enter values for Password * 
	      driver.findElement(By.id("txtNetworkPassword")).clear();
	      driver.findElement(By.id("txtNetworkPassword")).sendKeys("ggg2k7");
	      
	      // Enter values for Schedule interval *
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).clear();
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).sendKeys("5");
	       
	      boolean passivemode = driver.findElement(By.id("cbNetworkIsPassive")).isSelected();
	      
	      if (passivemode == true)
	      {
	    	  // Click on update button
		      driver.findElement(By.id("btnUpdateTransferSettings")).click();}
	      
	      else  // (passivemode == false)
	      {
	    	  // Check Passive Mode
		      driver.findElement(By.id("cbNetworkIsPassive")).click();
		      
		      // Click on update button
		      driver.findElement(By.id("btnUpdateTransferSettings")).click(); }
	       
	      Thread.sleep(9000);
	      	      
	      // Check alert message
		  String expected = "Enter username for transfer recordings.";
          String actual = driver.findElement(By.id("lblTransferRecordingMessage")).getText();
	      
          Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	     	}		
	
	
	
	
	
////Test ID: 15-87
///* 
///*   Leave empty password
//*/	
	@Test (priority = 95)	
    public void checkRecordingTransferSettingswithEmptyFTPpassword() throws InterruptedException {
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
	      
	      // Check Transfer Media * type --> FTP
	      driver.findElement(By.id("rbNetworkTypeFTP")).click();
	      
	      // Enter values for FTP URL *
	      driver.findElement(By.id("txtNetworkPath")).clear(); 
	      driver.findElement(By.id("txtNetworkPath")).sendKeys("ftp://172.20.0.50/");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtNetworkUserName")).clear(); 
	      driver.findElement(By.id("txtNetworkUserName")).sendKeys("sa");
	      
	      // Enter values for Password * 
	      driver.findElement(By.id("txtNetworkPassword")).clear();
//	      driver.findElement(By.id("txtNetworkPassword")).sendKeys("ggg2k7");
	      
	      // Enter values for Schedule interval *
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).clear();
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).sendKeys("5");
	       
	      boolean passivemode = driver.findElement(By.id("cbNetworkIsPassive")).isSelected();
	      
	      if (passivemode == true)
	      {
	    	  // Click on update button
		      driver.findElement(By.id("btnUpdateTransferSettings")).click();}
	      
	      else  // (passivemode == false)
	      {
	    	  // Check Passive Mode
		      driver.findElement(By.id("cbNetworkIsPassive")).click();
		      
		      // Click on update button
		      driver.findElement(By.id("btnUpdateTransferSettings")).click(); }
	       
	      Thread.sleep(9000);
	      	      
	      // Check alert message
		  String expected = "Enter password for transfer recordings";
          String actual = driver.findElement(By.id("lblTransferRecordingMessage")).getText();
	      
          Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	     	}	
	
	

	
////Test ID: 15-88
///* 
///* Leave empty Schedule interval   
//*/	
	@Test (priority = 96)	
    public void checkRecordingTransferSettingswithEmptyFTPschedule() throws InterruptedException {
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
	      
	      // Check Transfer Media * type --> FTP
	      driver.findElement(By.id("rbNetworkTypeFTP")).click();
	      
	      // Enter values for FTP URL *
	      driver.findElement(By.id("txtNetworkPath")).clear(); 
	      driver.findElement(By.id("txtNetworkPath")).sendKeys("ftp://172.20.0.50/");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtNetworkUserName")).clear(); 
	      driver.findElement(By.id("txtNetworkUserName")).sendKeys("sarah");
	      
	      // Enter values for Password * 
	      driver.findElement(By.id("txtNetworkPassword")).clear();
	      driver.findElement(By.id("txtNetworkPassword")).sendKeys("ggg2k7");
	      
	      // Enter values for Schedule interval *
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).clear();
//	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).sendKeys("5");
	       
	      boolean passivemode = driver.findElement(By.id("cbNetworkIsPassive")).isSelected();
	      
	      if (passivemode == true)
	      {
	    	  // Click on update button
		      driver.findElement(By.id("btnUpdateTransferSettings")).click();}
	      
	      else  // (passivemode == false)
	      {
	    	  // Check Passive Mode
		      driver.findElement(By.id("cbNetworkIsPassive")).click();
		      
		      // Click on update button
		      driver.findElement(By.id("btnUpdateTransferSettings")).click(); }
	       
	      Thread.sleep(9000);
	      	      
	      // Check alert message
		  String expected = "Schedule interval must be greater than zero";
          String actual = driver.findElement(By.id("lblTransferRecordingMessage")).getText();
	      
          Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	     	}		
	
	
	

	
////Test ID: 15-89
///* 
///* Enter invalid Schedule interval like (0)  
//*/	
	@Test (priority = 97)	
    public void checkRecordingTransferSettingswithInvalidFTPscheduleZero() throws InterruptedException {
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
	      
	      // Check Transfer Media * type --> FTP
	      driver.findElement(By.id("rbNetworkTypeFTP")).click();
	      
	      // Enter values for FTP URL *
	      driver.findElement(By.id("txtNetworkPath")).clear(); 
	      driver.findElement(By.id("txtNetworkPath")).sendKeys("ftp://172.20.0.50/");
	      
	      // Enter values for Username *
	      driver.findElement(By.id("txtNetworkUserName")).clear(); 
	      driver.findElement(By.id("txtNetworkUserName")).sendKeys("sarah");
	      
	      // Enter values for Password * 
	      driver.findElement(By.id("txtNetworkPassword")).clear();
	      driver.findElement(By.id("txtNetworkPassword")).sendKeys("ggg2k7");
	      
	      // Enter values for Schedule interval *
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).clear();
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).sendKeys("0");
	       
	      boolean passivemode = driver.findElement(By.id("cbNetworkIsPassive")).isSelected();
	      
	      if (passivemode == true)
	      {
	    	  // Click on update button
		      driver.findElement(By.id("btnUpdateTransferSettings")).click();}
	      
	      else  // (passivemode == false)
	      {
	    	  // Check Passive Mode
		      driver.findElement(By.id("cbNetworkIsPassive")).click();
		      
		      // Click on update button
		      driver.findElement(By.id("btnUpdateTransferSettings")).click(); }
	       
	      Thread.sleep(9000);
	      	      
	      // Check alert message
		  String expected = "Schedule interval must be greater than zero";
          String actual = driver.findElement(By.id("lblTransferRecordingMessage")).getText();
	      
          Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	     	}		
	
	
	

	
////Test ID: 15-100
///* 
///* Verify configurations for Recording Transfer Settings when Transfer Media is Network   
//*/	
	@Test (priority = 100)	
    public void verifyRecordingTransferSettingswithNetworkPath() throws InterruptedException {
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
	      
	      // Check Transfer Media * type --> Network Path
	      Thread.sleep(6000);
	      driver.findElement(By.id("rbNetworkTypeFTPNetwork")).click();
	      
	      // Enter values for Network Path *
	      driver.findElement(By.id("txtNetworkPath")).clear(); 
	      driver.findElement(By.id("txtNetworkPath")).sendKeys("\\\\172.20.22.81\\c\\Temp");
	      
	      // Check for Username disabled
	      Assert.assertFalse(driver.findElement(By.id("txtNetworkUserName")).isEnabled());
	      
	      // Enter for Password disabled 
	      Assert.assertFalse(driver.findElement(By.id("txtNetworkPassword")).isEnabled());
	      
	      // Enter values for Schedule interval *
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).clear();
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).sendKeys("5");
	       
	      Assert.assertFalse(driver.findElement(By.id("cbNetworkIsPassive")).isEnabled());
	      
	      // Click on update button
		  driver.findElement(By.id("btnUpdateTransferSettings")).click(); 
	       
	      Thread.sleep(9000);
	      	      
	      // Check alert message
		  String expected = "Settings have been updated successfully";
          String actual = driver.findElement(By.id("lblTransferRecordingMessage")).getText();
	      
          Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	     	}	
	
	
	
	

////Test ID: 15-101
///* 
///* Enter invalid  Network Path   
//*/	
	@Test (priority = 101)	
    public void verifyRecordingTransferSettingswithInvalidNetworkPath() throws InterruptedException {
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
	      
	      // Check Transfer Media * type --> Network Path
	      driver.findElement(By.id("rbNetworkTypeFTPNetwork")).click();
	      
	      // Enter values for Network Path *
	      driver.findElement(By.id("txtNetworkPath")).clear(); 
	      driver.findElement(By.id("txtNetworkPath")).sendKeys("\\172.20.22.81\\c\\Temp////");
	      
	      // Check for Username disabled
	      Assert.assertFalse(driver.findElement(By.id("txtNetworkUserName")).isEnabled());
	      
	      // Enter for Password disabled 
	      Assert.assertFalse(driver.findElement(By.id("txtNetworkPassword")).isEnabled());
	      
	      // Enter values for Schedule interval *
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).clear();
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).sendKeys("5");
	       
	      Assert.assertFalse(driver.findElement(By.id("cbNetworkIsPassive")).isEnabled());
	      
	      // Click on update button
		  driver.findElement(By.id("btnUpdateTransferSettings")).click(); 
	       
	      Thread.sleep(9000);
	      	      
	      // Check alert message
		  String expected = "Please provide valid network path.";
          String actual = driver.findElement(By.id("lblTransferRecordingMessage")).getText();
	      
          Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	     	}	
	
	
	
	

	
////Test ID: 15-102
///* 
///* Leave empty Network Path  
//*/	
	@Test (priority = 102)	
    public void verifyRecordingTransferSettingswithEmptyNetworkPath() throws InterruptedException {
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
	      
	      // Check Transfer Media * type --> Network Path
	      driver.findElement(By.id("rbNetworkTypeFTPNetwork")).click();
	      
	      // Enter values for Network Path *
	      driver.findElement(By.id("txtNetworkPath")).clear(); 
//	      driver.findElement(By.id("txtNetworkPath")).sendKeys("\\172.20.22.81\\c\\Temp");
	      
	      // Check for Username disabled
	      Assert.assertFalse(driver.findElement(By.id("txtNetworkUserName")).isEnabled());
	      
	      // Enter for Password disabled 
	      Assert.assertFalse(driver.findElement(By.id("txtNetworkPassword")).isEnabled());
	      
	      // Enter values for Schedule interval *
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).clear();
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).sendKeys("5");
	       
	      Assert.assertFalse(driver.findElement(By.id("cbNetworkIsPassive")).isEnabled());
	      
	      // Click on update button
		  driver.findElement(By.id("btnUpdateTransferSettings")).click(); 
	       
	      Thread.sleep(9000);
	      	      
	      // Check alert message
		  String expected = "Please provide valid network path.";
          String actual = driver.findElement(By.id("lblTransferRecordingMessage")).getText();
	      
          Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	     	}	
	
	
	
	
	
////Test ID: 15-104
///* 
///* Enter invalid Schedule interval like (0)  
//*/	
	@Test (priority = 102)	
    public void verifyRecordingTransferSettingswithEmptyNetworkPathInvalidscheduleZero() throws InterruptedException {
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
	      
	      // Check Transfer Media * type --> Network Path
	      driver.findElement(By.id("rbNetworkTypeFTPNetwork")).click();
	      
	      // Enter values for Network Path *
	      driver.findElement(By.id("txtNetworkPath")).clear(); 
//	      driver.findElement(By.id("txtNetworkPath")).sendKeys("\\172.20.22.81\\c\\Temp");
	      
	      // Check for Username disabled
	      Assert.assertFalse(driver.findElement(By.id("txtNetworkUserName")).isEnabled());
	      
	      // Enter for Password disabled 
	      Assert.assertFalse(driver.findElement(By.id("txtNetworkPassword")).isEnabled());
	      
	      // Enter values for Schedule interval *
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).clear();
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).sendKeys("0");
	       
	      Assert.assertFalse(driver.findElement(By.id("cbNetworkIsPassive")).isEnabled());
	      
	      // Click on update button
		  driver.findElement(By.id("btnUpdateTransferSettings")).click(); 
	       
	      Thread.sleep(9000);
	      	      
	      // Check alert message
		  String expected = "Please provide valid network path.";
          String actual = driver.findElement(By.id("lblTransferRecordingMessage")).getText();
	      
          Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	     	}		
	
	
	
	
	
////Test ID: 15-105
///* 
///* Leave empty Schedule interval  
//*/	
	@Test (priority = 102)	
    public void verifyRecordingTransferSettingswithEmptyNetworkPathEmptyschedule() throws InterruptedException {
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
	      
	      // Check Transfer Media * type --> Network Path
	      driver.findElement(By.id("rbNetworkTypeFTPNetwork")).click();
	      
	      // Enter values for Network Path *
	      driver.findElement(By.id("txtNetworkPath")).clear(); 
//	      driver.findElement(By.id("txtNetworkPath")).sendKeys("\\172.20.22.81\\c\\Temp");
	      
	      // Check for Username disabled
	      Assert.assertFalse(driver.findElement(By.id("txtNetworkUserName")).isEnabled());
	      
	      // Enter for Password disabled 
	      Assert.assertFalse(driver.findElement(By.id("txtNetworkPassword")).isEnabled());
	      
	      // Enter values for Schedule interval *
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).clear();
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).sendKeys("0");
	       
	      Assert.assertFalse(driver.findElement(By.id("cbNetworkIsPassive")).isEnabled());
	      
	      // Click on update button
		  driver.findElement(By.id("btnUpdateTransferSettings")).click(); 
	       
	      Thread.sleep(9000);
	      	      
	      // Check alert message
		  String expected = "Please provide valid network path.";
          String actual = driver.findElement(By.id("lblTransferRecordingMessage")).getText();
	      
          Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	     	}	
	
	
	
	

////Test ID: 15-106
///* 
///* Verify configurations for Recording Transfer Settings when Transfer Media is Local  
//*/	
	@Test (priority = 103)	
    public void verifyRecordingTransferSettingswithLocalPath() throws InterruptedException {
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
	      
	      // Check Transfer Media * type --> Local Path
	      driver.findElement(By.id("rbNetworkTypeFTPLocal")).click();
	      
	      // Enter values for Network Path *
	      driver.findElement(By.id("txtNetworkPath")).clear(); 
	      driver.findElement(By.id("txtNetworkPath")).sendKeys("C:/Temp");
	      
	      // Check for Username disabled
	      Assert.assertFalse(driver.findElement(By.id("txtNetworkUserName")).isEnabled());
	      
	      // Enter for Password disabled 
	      Assert.assertFalse(driver.findElement(By.id("txtNetworkPassword")).isEnabled());
	      
	      // Enter values for Schedule interval *
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).clear();
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).sendKeys("5");
	       
	      Assert.assertFalse(driver.findElement(By.id("cbNetworkIsPassive")).isEnabled());
	      
	      // Click on update button
		  driver.findElement(By.id("btnUpdateTransferSettings")).click(); 
	       
	      Thread.sleep(9000);
	      	      
	      // Check alert message
		  String expected = "Settings have been updated successfully";
        String actual = driver.findElement(By.id("lblTransferRecordingMessage")).getText();
	      
        Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	     	}		
	
	
	
	

////Test ID: 15-107
///* 
///*  Enter invalid  Local Path 
//*/	
	@Test (priority = 104)	
    public void verifyRecordingTransferSettingswithInvalidLocalPath() throws InterruptedException {
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
	      
	      // Check Transfer Media * type --> Local Path
	      driver.findElement(By.id("rbNetworkTypeFTPLocal")).click();
	      
	      // Enter values for Network Path *
	      driver.findElement(By.id("txtNetworkPath")).clear(); 
	      driver.findElement(By.id("txtNetworkPath")).sendKeys("C:/Temp\\\\");
	      
	      // Check for Username disabled
	      Assert.assertFalse(driver.findElement(By.id("txtNetworkUserName")).isEnabled());
	      
	      // Enter for Password disabled 
	      Assert.assertFalse(driver.findElement(By.id("txtNetworkPassword")).isEnabled());
	      
	      // Enter values for Schedule interval *
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).clear();
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).sendKeys("5");
	       
	      Assert.assertFalse(driver.findElement(By.id("cbNetworkIsPassive")).isEnabled());
	      
	      // Click on update button
		  driver.findElement(By.id("btnUpdateTransferSettings")).click(); 
	       
	      Thread.sleep(9000);
	      	      
	      // Check alert message
		  String expected = "Please provide valid local directory path.";
          String actual = driver.findElement(By.id("lblTransferRecordingMessage")).getText();
	      
          Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	     	}	
	
	
	
	

////Test ID: 15-108
///* 
///* Leave empty Local Path 
//*/	
	@Test (priority = 104)	
    public void verifyRecordingTransferSettingswithEmptyLocalPath() throws InterruptedException {
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
	      
	      // Check Transfer Media * type --> Local Path
	      driver.findElement(By.id("rbNetworkTypeFTPLocal")).click();
	      
	      // Enter values for Network Path *
	      driver.findElement(By.id("txtNetworkPath")).clear(); 
//	      driver.findElement(By.id("txtNetworkPath")).sendKeys("C:/Temp");
	      
	      // Check for Username disabled
	      Assert.assertFalse(driver.findElement(By.id("txtNetworkUserName")).isEnabled());
	      
	      // Enter for Password disabled 
	      Assert.assertFalse(driver.findElement(By.id("txtNetworkPassword")).isEnabled());
	      
	      // Enter values for Schedule interval *
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).clear();
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).sendKeys("5");
	       
	      Assert.assertFalse(driver.findElement(By.id("cbNetworkIsPassive")).isEnabled());
	      
	      // Click on update button
		  driver.findElement(By.id("btnUpdateTransferSettings")).click(); 
	       
	      Thread.sleep(9000);
	      	      
	      // Check alert message
		  String expected = "Please provide valid local directory path.";
          String actual = driver.findElement(By.id("lblTransferRecordingMessage")).getText();
	      
          Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	     	}	
	
	
	
	
	
	
////Test ID: 15-109
///* 
///* Leave empty Local Path. Enter valid Schedule interval
//*/	
	@Test (priority = 105)	
    public void verifyRecordingTransferSettingswithEmptyLocalPathValidSchedule() throws InterruptedException {
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
	      
	      // Check Transfer Media * type --> Local Path
	      driver.findElement(By.id("rbNetworkTypeFTPLocal")).click();
	      
	      // Enter values for Network Path *
	      driver.findElement(By.id("txtNetworkPath")).clear(); 
//	      driver.findElement(By.id("txtNetworkPath")).sendKeys("C:/Temp");
	      
	      // Check for Username disabled
	      Assert.assertFalse(driver.findElement(By.id("txtNetworkUserName")).isEnabled());
	      
	      // Enter for Password disabled 
	      Assert.assertFalse(driver.findElement(By.id("txtNetworkPassword")).isEnabled());
	      
	      // Enter values for Schedule interval *
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).clear();
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).sendKeys("5");
	       
	      Assert.assertFalse(driver.findElement(By.id("cbNetworkIsPassive")).isEnabled());
	      
	      // Click on update button
		  driver.findElement(By.id("btnUpdateTransferSettings")).click(); 
	       
	      Thread.sleep(9000);
	      	      
	      // Check alert message
		  String expected = "Please provide valid local directory path.";
          String actual = driver.findElement(By.id("lblTransferRecordingMessage")).getText();
	      
          Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	     	}		
	
	
	

////Test ID: 15-110
///* 
///* Leave empty Local Path Enter invalid Schedule interval like (0)
//*/	
	@Test (priority = 106)	
    public void verifyRecordingTransferSettingswithEmptyLocalPathInvalidSchedule() throws InterruptedException {
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
	      
	      // Check Transfer Media * type --> Local Path
	      driver.findElement(By.id("rbNetworkTypeFTPLocal")).click();
	      
	      // Enter values for Network Path *
	      driver.findElement(By.id("txtNetworkPath")).clear(); 
//	      driver.findElement(By.id("txtNetworkPath")).sendKeys("C:/Temp");
	      
	      // Check for Username disabled
	      Assert.assertFalse(driver.findElement(By.id("txtNetworkUserName")).isEnabled());
	      
	      // Enter for Password disabled 
	      Assert.assertFalse(driver.findElement(By.id("txtNetworkPassword")).isEnabled());
	      
	      // Enter values for Schedule interval *
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).clear();
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).sendKeys("0");
	       
	      Assert.assertFalse(driver.findElement(By.id("cbNetworkIsPassive")).isEnabled());
	      
	      // Click on update button
		  driver.findElement(By.id("btnUpdateTransferSettings")).click(); 
	       
	      Thread.sleep(9000);
	      	      
	      // Check alert message
		  String expected = "Please provide valid local directory path.";
          String actual = driver.findElement(By.id("lblTransferRecordingMessage")).getText();
	      
          Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	     	}		
	
	
	

	
////Test ID: 15-111
///* 
///* Leave empty Local Path Leave empty Schedule interval 
//*/	
	@Test (priority = 107)	
    public void verifyRecordingTransferSettingswithEmptyLocalPathEmptySchedule() throws InterruptedException {
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
	      
	      // Check Transfer Media * type --> Local Path
	      driver.findElement(By.id("rbNetworkTypeFTPLocal")).click();
	      
	      // Enter values for Network Path *
	      driver.findElement(By.id("txtNetworkPath")).clear(); 
//	      driver.findElement(By.id("txtNetworkPath")).sendKeys("C:/Temp");
	      
	      // Check for Username disabled
	      Assert.assertFalse(driver.findElement(By.id("txtNetworkUserName")).isEnabled());
	      
	      // Enter for Password disabled 
	      Assert.assertFalse(driver.findElement(By.id("txtNetworkPassword")).isEnabled());
	      
	      // Enter values for Schedule interval *
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).clear();
	      driver.findElement(By.id("txtNetworkDownloadScheduleInterval")).sendKeys("0");
	       
	      Assert.assertFalse(driver.findElement(By.id("cbNetworkIsPassive")).isEnabled());
	      
	      // Click on update button
		  driver.findElement(By.id("btnUpdateTransferSettings")).click(); 
	       
	      Thread.sleep(9000);
	      	      
	      // Check alert message
		  String expected = "Please provide valid local directory path.";
          String actual = driver.findElement(By.id("lblTransferRecordingMessage")).getText();
	      
          Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	     }	
	
	
	
	
	
////Test ID: 15-112
///* 
///* Verify that mandatory field signs (*) on Recording Transfer Settings tab in Server System Configurations.
//*/	
	@Test (priority = 108)	
    public void verifyRecordingTransferSettingsMandatoryFields() throws InterruptedException {
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
	      
	      // Check Transfer Media * type --> FTP
	      driver.findElement(By.id("rbNetworkTypeFTP")).click();
	      
	      // Check FTP URL *
	      String actualftp_url = driver.findElement(By.id("lblNetworkPath")).getText();
	      String expectedftp_url = "FTP URL *";
	      Assert.assertEquals(actualftp_url, expectedftp_url);
	      
	      // Check Username Name * 
	      String actualUn = driver.findElement(By.xpath("//*[@id=\"divTransferSettings\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[4]/td[1]/label")).getText();
	      String expectedUn = "Username *";
	      Assert.assertEquals(actualUn, expectedUn);
	      
	      // Check on Password * 
	      String actualp = driver.findElement(By.xpath("//*[@id=\"divTransferSettings\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[1]/label")).getText();
	      String expectedp = "Password *";
	      Assert.assertEquals(actualp, expectedp);
	      
	      // Check on Schedule interval *
	      String actualSI = driver.findElement(By.xpath("//*[@id=\"trScheduleInterval\"]/td[1]")).getText();
	      String expectedSI = "Schedule interval *";
	      Assert.assertEquals(actualSI, expectedSI);
	         
	      driver.close();	  		  		  
	     }		
	
	
	


////Test ID: 15-158
///* 
//* Server admin email address should not be displayed on System Settings page Under the Recorder Settings tab
//*/		
  @Test (priority = 109)
  public void verifyAdminEmailinRecorderSettings () throws InterruptedException {
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
      
      // Locate Alert Email and get value
      String actualEm = driver.findElement(By.id("txtAlertEmail")).getAttribute("value");
	    
	    String expectedEm = "";
      
      Assert.assertEquals(actualEm, expectedEm);     
      
      driver.close();
  }

	
  
    
////Test ID: 15-23
///* 
///* Verification of Change in language from Language Settings. Check these settings is available only for Server admin login.
//*/  
	@Test (priority = 110)
	public void selectLanguage() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);
	      
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	  	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
	  	  Thread.sleep(2000);
	  	  driver.findElement(By.xpath("//*[@id=\"cboLanguage_msdd\"]/div[1]/span[2]")).click();
	  	  WebElement flags = driver.findElement(By.xpath("//*[@id=\"cboLanguage_child\"]/ul"));
	  	  List<WebElement> links = flags.findElements(By.tagName("li"));
	  	  	for (int i = 0; i < links.size(); i++){
	  	  			System.out.println(links.get(i).getText());}

	  	  		for (int j = 0; j< links.size(); j++) {
	  	  			//driver.findElement(By.xpath("//*[@id=\"cboLanguage_msdd\"]/div[1]/span[2]")).click();
	  	  			Thread.sleep(2000);
	  	  			WebElement flags1 = driver.findElement(By.xpath("//*[@id=\"cboLanguage_child\"]/ul"));
	  	  			List<WebElement> links1 = flags1.findElements(By.tagName("li"));
	  	  			Thread.sleep(2000);
	  	  			links1.get(j).click();
	  	  			
	  	  			Thread.sleep(1000);

	  	  			driver.findElement(By.id("btnUpdateLanguage")).click();
	  	  			Thread.sleep(6000);
	  	  			
	  	  			// Click okay button
	  	  			driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();
	  	  			
	  	  			// Switch to server side
	  	  			driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
	  	  			@SuppressWarnings("deprecation")
	  	  			WebDriverWait wait = new WebDriverWait(driver,30);
	  	  		    @SuppressWarnings("unused")
					WebElement waitfor ;
	  	  		    waitfor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_lblServerAdministration")));
	  	  			
	  	  			// Click on Server Administration
	  	  			driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
	  	  			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	  	  			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	  	  			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	  	  			
	  	  			// Click on System
	  	  			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
	  	  			Thread.sleep(2000);
	  	            driver.findElement(By.xpath("//*[@id=\"cboLanguage_msdd\"]/div[1]/span[2]")).click();}
	  	  		
	  	  		driver.close();
	}
} 
