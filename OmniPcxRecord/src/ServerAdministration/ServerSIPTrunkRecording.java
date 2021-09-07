/* 
@author: sarah.mahmood 
Created on Jun 17, 2021
*/
package ServerAdministration;

import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
import java.util.List;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
//import static org.testng.Assert.assertTrue;

public class ServerSIPTrunkRecording {
	
public String baseUrl = "http://172.20.22.81/OmniPCXRecord/TenantAdmin.aspx";
	
String driverPath = "C:\\Users\\sarah.mahmood\\Downloads\\gecko-driver\\geckodriver.exe";
	
public WebDriver driver;
	
	
////Test ID: 37-01	    
///* 
//* To verify SIP Trunk Configurations.
//*/ 
		@Test (priority = 0)
		public void verifySIPTrunkConfigurations() throws InterruptedException {
		    System.setProperty("webdriver.gecko.driver", driverPath);
		    driver = new FirefoxDriver();
		    driver.get(baseUrl);
		    
		    // Signing in OmniPCX 
		    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			// Click On SIP Trunk
			Thread.sleep(15000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkSIPTrunk")).click();
			
			Assert.assertTrue(driver.findElement(By.id("divSipTrunk")).isDisplayed());
			
			 driver.close();	  
  }
		


		
////Test ID: 37-02	    
///* 
//* Add SIP Trunk Configurations with valid Data
//*/ 	
		@Test (priority = 1)
		public void verifySIPTrunkConfigurationswithValidData() throws InterruptedException {
		    System.setProperty("webdriver.gecko.driver", driverPath);
		    driver = new FirefoxDriver();
		    driver.get(baseUrl);
		    
		    // Signing in OmniPCX 
		    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			// Click On SIP Trunk
			Thread.sleep(20000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkSIPTrunk")).click();

			// Enter DID
	        Thread.sleep(6000);
	 	    driver.findElement(By.id("tbDID")).sendKeys("1089");
	 	    
	 	    // Enter Name
	 	    driver.findElement(By.id("tbName")).sendKeys("Ctrl_A");
	 	    
	 	    // Click Save button
	 	    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[6]/td[2]/button[1]")).click();
	 	      
	 	    Thread.sleep(6000);
			String expected = "Settings have been saved successfully";
			// Get label msg
		  	String actual = driver.findElement(By.id("lblMsg")).getText();

		  	Assert.assertEquals(actual, expected);
	       	       
	       	driver.close();	  
	      }
		
		

////Test ID: 37-03	    
///* 
//* Add SIP Trunk Configurations with empty Name
//*/ 	
		@Test (priority = 3)
		public void verifySIPTrunkConfigurationswithEmptyName() throws InterruptedException {
			System.setProperty("webdriver.gecko.driver", driverPath);
		    driver = new FirefoxDriver();
		    driver.get(baseUrl);
		    
		    // Signing in OmniPCX 
		    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			// Click On SIP Trunk
			Thread.sleep(20000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkSIPTrunk")).click();

			// Enter DID
	        Thread.sleep(6000);
	 	    driver.findElement(By.id("tbDID")).sendKeys("1068");
	 	    
//	 	    // Enter Name
//	 	    driver.findElement(By.id("tbName")).sendKeys("Ctrl_A");
	 	    
	 	    // Click Save button
	 	    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[6]/td[2]/button[1]")).click();
	 	      
	 	    Thread.sleep(6000);
			String expected = "Please enter name";
			// Get label msg
		  	String actual = driver.findElement(By.id("lblMsg")).getText();

		  	Assert.assertEquals(actual, expected);
	       	       
	       	driver.close();	  		
		}
		
		
	

////Test ID: 37-04	    
///* 
//* Add SIP Trunk Configurations with empty DID
//*/ 	
		@Test (priority = 4)
		public void verifySIPTrunkConfigurationswithEmptyDID() throws InterruptedException {
			System.setProperty("webdriver.gecko.driver", driverPath);
		    driver = new FirefoxDriver();
		    driver.get(baseUrl);
		    
		    // Signing in OmniPCX 
		    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			// Click On SIP Trunk
			Thread.sleep(20000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkSIPTrunk")).click();

//			// Enter DID
//	        Thread.sleep(6000);
//	 	    driver.findElement(By.id("tbDID")).sendKeys("1068");
	 	    
	 	    // Enter Name
	 	    driver.findElement(By.id("tbName")).sendKeys("Ctrl_X");
	 	    
	 	    // Click Save button
	 	    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[6]/td[2]/button[1]")).click();
	 	      
	 	    Thread.sleep(6000);
			String expected = "Please enter DID";
			// Get label msg
		  	String actual = driver.findElement(By.id("lblMsg")).getText();

		  	Assert.assertEquals(actual, expected);
	       	       
	       	driver.close();	  		
		}
		
		
		
	
////Test ID: 37-05	    
///* 
//* Update DID
//*/
		@Test (priority = 5)
		public void UpdateDID() throws InterruptedException {
			System.setProperty("webdriver.gecko.driver", driverPath);
		    driver = new FirefoxDriver();
		    driver.get(baseUrl);
		    
		    // Signing in OmniPCX 
		    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			// Click On SIP Trunk
			Thread.sleep(20000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkSIPTrunk")).click();
			
			// Click on edit button against the present SIP Trunk
			driver.findElement(By.xpath("//*[@id=\"gvSIPTrunk\"]/tbody/tr/td[4]/img[1]")).click();
			
			Thread.sleep(8000);
			
			// Update Name
			driver.findElement(By.id("tbName")).sendKeys("Shift_Del");
			
			// Click Save button
	 	    driver.findElement(By.xpath("//*[@id=\"divSipTrunk\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[6]/td[2]/button[1]")).click();
	 	    
	 	    Thread.sleep(6000);
			String expected = "Settings have been updated successfully";
			// Get label msg
		  	String actual = driver.findElement(By.id("lblMsg")).getText();

		  	Assert.assertEquals(actual, expected);  		
			
  			driver.close();	  		
		}
		
		
		
		
////Test ID: 37-06	    
///* 
//* Delete SIP trunk Configurations
//*/	
		@Test (priority = 6)
		public void DeleteSIPtrunkConfigurations() throws InterruptedException {
			System.setProperty("webdriver.gecko.driver", driverPath);
		    driver = new FirefoxDriver();
		    driver.get(baseUrl);
		    
		    // Signing in OmniPCX 
		    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			// Click On SIP Trunk
			Thread.sleep(20000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkSIPTrunk")).click();
			
			//Get the table and row
			WebElement table =driver.findElement(By.id("gvSIPTrunk"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String did = "1089";
				for(int i=0;i<rows.size();i++)
				{
				WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvSIPTrunk\"]/tbody/tr["+(i+1)+"]"));
				if(row.getText().trim().contains(did))
				{
				rowNo=Integer.toString(i+1);
				break;
				}
				}
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[4]/td/div/table/tbody/tr["+rowNo+"]/td[4]/img[2]")).click();

			
			Thread.sleep(8000);
			
			JavascriptExecutor jst = (JavascriptExecutor)driver;
			jst.executeScript("window.confirm('Are you sure you want to delete?')");	   
			driver.switchTo().alert().accept();
			   
			// Click on delete button
			Thread.sleep(5000);
			driver.findElement(By.id("btnDelete")).click();
			
	 	    Thread.sleep(6000);
			String expected = "Record has been deleted successfully";
			// Get label msg
		  	String actual = driver.findElement(By.id("lblMsg")).getText();

		  	Assert.assertEquals(actual, expected);  		
			
  			driver.close();	  		
		}




////Test ID: 37-07	    
///* 
//* Verify that only numeric values are allowed
//*/
		@Test (priority = 7)
		public void verifyOnlyNumericsAllowedinDID() throws InterruptedException {
			System.setProperty("webdriver.gecko.driver", driverPath);
		    driver = new FirefoxDriver();
		    driver.get(baseUrl);
		    
		    // Signing in OmniPCX 
		    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			// Click On SIP Trunk
			Thread.sleep(20000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkSIPTrunk")).click();
			
			// Enter DID
	        Thread.sleep(6000);
	 	    driver.findElement(By.id("tbDID")).sendKeys("gdfgfdgzxasde43546");
	 	    
	 	    Thread.sleep(6000);
			String expected = "43546";
			// Get label msg
		  	String actual = driver.findElement(By.id("tbDID")).getAttribute("value");

		  	Assert.assertEquals(actual, expected);
		
			driver.close();	  		
			}		
		
		
		
		
////Test ID: 37-08	    
///* 
//* Verify that user is able to add special characters in name field
//*/	
		@Test (priority = 8)
		public void verifySpecialCharsAllowedinName() throws InterruptedException {
			System.setProperty("webdriver.gecko.driver", driverPath);
		    driver = new FirefoxDriver();
		    driver.get(baseUrl);
		    
		    // Signing in OmniPCX 
		    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			// Click On SIP Trunk
			Thread.sleep(20000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkSIPTrunk")).click();
			
			// Enter DID
	        Thread.sleep(6000);
	 	    driver.findElement(By.id("tbName")).sendKeys("!@#$%^&*()??:';?,,,<><>");
	 	    
	 	    Thread.sleep(6000);
			String expected = "!@#$%^&*()??:';?,,,";
			// Get label msg
		  	String actual = driver.findElement(By.id("tbName")).getAttribute("value");

		  	Assert.assertEquals(actual, expected);
		
			driver.close();	  		
			}	



////Test ID: 37-09	    
///* 
//* Verify that 50 characters are allowed in DID field
//*/
		@Test (priority = 9)
		public void verify50CharsAllowedinDID() throws InterruptedException {
			System.setProperty("webdriver.gecko.driver", driverPath);
		    driver = new FirefoxDriver();
		    driver.get(baseUrl);
		    
		    // Signing in OmniPCX 
		    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			// Click On SIP Trunk
			Thread.sleep(20000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkSIPTrunk")).click();
			
			// Enter DID
		    Thread.sleep(6000);
			driver.findElement(By.id("tbDID")).sendKeys("66454884485847847584364312132309988213438984345311-");
			    
			Thread.sleep(6000);
			String expected = "66454884485847847584364312132309988213438984345311";
			// Get label msg
		  	String actual = driver.findElement(By.id("tbDID")).getAttribute("value");
		
		  	Assert.assertEquals(actual, expected);
		
			driver.close();	  		
			}		

		
		  

////Test ID: 37-11	    
///* 
//* Enter duplicate DID or Name
//*/
		@Test (priority = 2)
		public void verifyDuplicateSIPTrunkConfigurations() throws InterruptedException {
		    System.setProperty("webdriver.gecko.driver", driverPath);
		    driver = new FirefoxDriver();
		    driver.get(baseUrl);
		    
		    // Signing in OmniPCX 
		    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			// Click On SIP Trunk
			Thread.sleep(20000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkSIPTrunk")).click();
		
			// Enter DID
		    Thread.sleep(6000);
			driver.findElement(By.id("tbDID")).sendKeys("4355");
			
			// Enter Name
		    driver.findElement(By.id("tbName")).sendKeys("Ctrl_A");
		    
		    // Click Save button
		    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[6]/td[2]/button[1]")).click();
   			    			      
			Thread.sleep(6000);
			String expected = "Name already exists";
			// Get label msg
		  	String actual = driver.findElement(By.id("lblMsg")).getText();
		
		  	Assert.assertEquals(actual, expected);
		   	       
		   	driver.close();	  
		  }
		
		
		
		
////Test ID: 37-10	    
///* 
//* Verify that Arrow keys are working in DID field on SIP Trunk page.
//*/
		@Test (priority = 10)
		public void verifyArrowKeysinDID() throws InterruptedException, AWTException {
		    System.setProperty("webdriver.gecko.driver", driverPath);
		    driver = new FirefoxDriver();
		    driver.get(baseUrl);
		    
		    // Signing in OmniPCX 
		    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			// Click On SIP Trunk
			Thread.sleep(15000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkSIPTrunk")).click();
			
			// Enter DID
		    Thread.sleep(6000);
			driver.findElement(By.id("tbDID")).sendKeys("7858497297975");
			
			Actions actions = new Actions(driver);
		    WebElement elementLocator = driver.findElement(By.id("tbDID"));
		    actions.contextClick(elementLocator).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.SPACE).build().perform();
		   	       
		   	driver.close();	  
		  }
		
		
		

////Test ID: 37-12	    
///* 
//* To verify SIP Trunk recording interface on server page
//*/	
		@Test (priority = 11)
		public void verifySIPTrunkRecordingInterfaceonServerPage() throws InterruptedException, AWTException {
		    System.setProperty("webdriver.gecko.driver", driverPath);
		    driver = new FirefoxDriver();
		    driver.get(baseUrl);
		    
		    // Signing in OmniPCX 
		    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			
			// Click On Server
			Thread.sleep(15000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkServer")).click();
			
			// Check presence of SIP Trunk Recording Server
			Thread.sleep(3000);
			Assert.assertTrue(driver.findElement(By.id("lblSIPTrunkRecordingServer")).isDisplayed());
			
			driver.close();	  
		  }





////Test ID: 37-14	    
///* 
//* Select Network Adapter
//*/
		@Test (priority = 12)
		public void SelectNetworkAdapterSIPTrunkRecording() throws InterruptedException, AWTException {
		    System.setProperty("webdriver.gecko.driver", driverPath);
		    driver = new FirefoxDriver();
		    driver.get(baseUrl);
		    
		    // Signing in OmniPCX 
		    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			
			// Click On System
			Thread.sleep(15000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
			
			// Select Node
			Thread.sleep(5000);
			Select dropdownNode = new Select(driver.findElement(By.id("cboNetworkAdaptor")));
		   	dropdownNode.selectByVisibleText("Intel(R) 82574L Gigabit Network Connection-172.20.22.81 [\\Device\\NPF_{6502260B-9253-4FF1-A8CE-0BE69B214557}]"); 
			
			// Click update button
		   	driver.findElement(By.id("btnUpdateRecorderSettings")).click();
		   	
			// Click On Server
			Thread.sleep(15000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkServer")).click();
			
			// Start SIP Trunk Recording Server
			driver.findElement(By.id("sipTrunkServerLeft")).click();
			
		    // To Check recorder working 
			Thread.sleep(5000);
		    String actual = driver.findElement(By.id("lblSIPTrunkServerBtn")).getText();
		      
		    String expected = "Stop";
			
			// Verify SIP Trunk Recording Server button is green --> working
			Assert.assertEquals(actual, expected);
		
			driver.close();	  
		  }


		

		
////Test ID: 37-15	    
///* 
//* UnSelect Network Adapter
//*/	
		@Test (priority = 13)
		public void UnselectNetworkAdapterSIPTrunkRecording() throws InterruptedException, AWTException {
		    System.setProperty("webdriver.gecko.driver", driverPath);
		    driver = new FirefoxDriver();
		    driver.get(baseUrl);
		    
		    // Signing in OmniPCX 
		    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			
			// Click On System
			Thread.sleep(15000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
			
			// Select Node
			Thread.sleep(5000);
			Select dropdownNode = new Select(driver.findElement(By.id("cboNetworkAdaptor")));
		   	dropdownNode.selectByVisibleText(""); 
			
			// Click update button
		   	driver.findElement(By.id("btnUpdateRecorderSettings")).click();
		   	
			// Click On Server
			Thread.sleep(15000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkServer")).click();
			
			// Start SIP Trunk Recording Server
			driver.findElement(By.id("sipTrunkServerLeft")).click();
			
		    // To Check recorder working 
			Thread.sleep(5000);
		    String actual = driver.findElement(By.id("lblSIPTrunkServerBtn")).getText();
		    System.out.println(actual);
		      
		    String expected = "Start";
			
			// Verify SIP Trunk Recording Server button is green --> working
			Assert.assertEquals(actual, expected);
		
			driver.close();	  
		  }
		

		
		
////Test ID: 37-80	    
///* 
//* Add SIP Trunk with branch
//*/	
		@Test (priority = 14)
		public void verifySIPTrunkConfigurationswithBranch() throws InterruptedException {
		    System.setProperty("webdriver.gecko.driver", driverPath);
		    driver = new FirefoxDriver();
		    driver.get(baseUrl);
		    
		    // Signing in OmniPCX 
		    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			// Click On SIP Trunk
			Thread.sleep(20000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkSIPTrunk")).click();

			// Enter DID
	        Thread.sleep(6000);
	 	    driver.findElement(By.id("tbDID")).sendKeys("9740");
	 	    
	 	    // Enter Name
	 	    driver.findElement(By.id("tbName")).sendKeys("Ctrl_End");
	 	    
	 	    // Select Recorder* as Branch
			Select dropdownRC = new Select(driver.findElement(By.xpath("//*[@id=\"divSipTrunk\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[4]/td[2]/select")));
			dropdownRC.selectByVisibleText("Branch"); 
			
//			// Select Branch
//			Select dropdownBranch = new Select(driver.findElement(By.xpath("//*[@id=\"divSipTrunk\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/select")));
//			dropdownBranch.selectByVisibleText("ABranch"); 	    
	 	    
			// Click Save button
	 	    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[6]/td[2]/button[1]")).click();
	 	      
	 	    Thread.sleep(6000);
			String expected = "Settings have been saved successfully";
			// Get label msg
		  	String actual = driver.findElement(By.id("lblMsg")).getText();

		  	Assert.assertEquals(actual, expected);
	       	       
	       	driver.close();	  
	      }
		
		
		
		
////Test ID: 37-81	    
///* 
//* Update SIP Trunk with branch
//*/
		@Test (priority = 15)
		public void UpdateSIPTrunkBranch() throws InterruptedException {
			System.setProperty("webdriver.gecko.driver", driverPath);
		    driver = new FirefoxDriver();
		    driver.get(baseUrl);
		    
		    // Signing in OmniPCX 
		    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			
			// Click On SIP Trunk
			Thread.sleep(20000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkSIPTrunk")).click();
			
			//Get the table and row
			 WebElement table =driver.findElement(By.id("gvSIPTrunk"));
			 WebElement tbody=table.findElement(By.tagName("tbody"));
			 List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			 String rowNo="";
			 String did = "1824";
				for(int i=0;i<rows.size();i++)
				{
				WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvSIPTrunk\"]/tbody/tr["+(i+1)+"]"));
				if(row.getText().trim().contains(did))
				{
				rowNo=Integer.toString(i+1);
				break;
				}
				}
			 driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[4]/td/div/table/tbody/tr["+rowNo+"]/td[4]/img[1]")).click();
			
			Thread.sleep(8000);
			
			// Click Save button
	 	    driver.findElement(By.xpath("//*[@id=\"divSipTrunk\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[6]/td[2]/button[1]")).click();
	 	    
	 	    Thread.sleep(6000);
			String expected = "Settings have been updated successfully";
			// Get label msg
		  	String actual = driver.findElement(By.id("lblMsg")).getText();

		  	Assert.assertEquals(actual, expected);  		
			
  			driver.close();	  		
		}
				
					
					
		
		
		
		
////Test ID: 37-82	    
///* 
//* Add multiple SIP Trunk with same branch
//*/	
		@Test (priority = 16)
		public void AddMultipleSIPTrunkwithSamebranch() throws InterruptedException {
		    System.setProperty("webdriver.gecko.driver", driverPath);
		    driver = new FirefoxDriver();
		    driver.get(baseUrl);
		    
		    // Signing in OmniPCX 
		    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			// Click On SIP Trunk
			Thread.sleep(20000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkSIPTrunk")).click();

			String[] DID = {"1824", "6239", "8405"};
			String[] Name = {"Ctrl_V", "Ctrl_Ins", "Ctrl_C"};
			for (int i=0; i<DID.length; i++)  {
				
				// Enter DID
		        Thread.sleep(5000);
		 	    driver.findElement(By.id("tbDID")).sendKeys(DID[i]);
		 	    
		 	    // Enter Name
		 	    driver.findElement(By.id("tbName")).sendKeys(Name[i]);
		 	    
		 	    // Select Recorder* as Branch
				Select dropdownRC = new Select(driver.findElement(By.xpath("//*[@id=\"divSipTrunk\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[4]/td[2]/select")));
				dropdownRC.selectByVisibleText("Branch"); 
				
//				// Select Branch
//				Select dropdownBranch = new Select(driver.findElement(By.xpath("//*[@id=\"divSipTrunk\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/select")));
//				dropdownBranch.selectByVisibleText("ABranch"); 	    
		 	    
				// Click Save button
		 	    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[6]/td[2]/button[1]")).click();
		 	      
		 	    Thread.sleep(6000);
				String expected = "Settings have been saved successfully";
				// Get label msg
			  	String actual = driver.findElement(By.id("lblMsg")).getText();

			  	Assert.assertEquals(actual, expected);  }
			
	       	driver.close();	  
	      }
		
		
		
		
////Test ID: 37-83	    
///* 
//* Add SIP Trunk with different branch
//*/	
		@Test (priority = 17)
		public void AddSIPTrunkwithDiffbranch() throws InterruptedException {
		    System.setProperty("webdriver.gecko.driver", driverPath);
		    driver = new FirefoxDriver();
		    driver.get(baseUrl);
		    
		    // Signing in OmniPCX 
		    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			// Click On SIP Trunk
			Thread.sleep(20000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkSIPTrunk")).click();

			// Enter DID
	        Thread.sleep(6000);
	 	    driver.findElement(By.id("tbDID")).sendKeys("8101");
	 	    
	 	    // Enter Name
	 	    driver.findElement(By.id("tbName")).sendKeys("Shift_Ins");
	 	    
	 	    // Select Recorder* as Branch
			Select dropdownRC = new Select(driver.findElement(By.xpath("//*[@id=\"divSipTrunk\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[4]/td[2]/select")));
			dropdownRC.selectByVisibleText("Branch"); 
			
			// Select Branch
			Select dropdownBranch = new Select(driver.findElement(By.xpath("//*[@id=\"divSipTrunk\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/select")));
			dropdownBranch.selectByVisibleText("Branch54"); 	    
	 	    
			// Click Save button
	 	    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[6]/td[2]/button[1]")).click();
	 	      
	 	    Thread.sleep(6000);
			String expected = "Settings have been saved successfully";
			// Get label msg
		  	String actual = driver.findElement(By.id("lblMsg")).getText();

		  	Assert.assertEquals(actual, expected);
	       	       
	       	driver.close();	  
	      }		

	

		
////Test ID: 37-84	    
///* 
//* Delete SIP trunk Configurations(branch)
//*/		
		@Test (priority = 17)
		public void DeleteSIPtrunkConfigurationsbranch() throws InterruptedException {
		    System.setProperty("webdriver.gecko.driver", driverPath);
		    driver = new FirefoxDriver();
		    driver.get(baseUrl);
		    
		    // Signing in OmniPCX 
		    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			// Click On SIP Trunk
			Thread.sleep(20000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkSIPTrunk")).click();
			
			 //Get the table and row
			 WebElement table =driver.findElement(By.id("gvSIPTrunk"));
			 WebElement tbody=table.findElement(By.tagName("tbody"));
			 List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			 String rowNo="";
			 String did = "9740";
				for(int i=0;i<rows.size();i++)
				{
				WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvSIPTrunk\"]/tbody/tr["+(i+1)+"]"));
				if(row.getText().trim().contains(did))
				{
				rowNo=Integer.toString(i+1);
				break;
				}
				}
			 driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[4]/td/div/table/tbody/tr["+rowNo+"]/td[4]/img[2]")).click();
			 
			 Thread.sleep(8000);
				
			 JavascriptExecutor jst = (JavascriptExecutor)driver;
			 jst.executeScript("window.confirm('Are you sure you want to delete?')");	   
			 driver.switchTo().alert().accept();
				   
			 // Click on delete button
			 Thread.sleep(5000);
				
		 	 Thread.sleep(6000);
			 String expected = "Record has been deleted successfully";
			 // Get label msg
			 String actual = driver.findElement(By.id("lblMsg")).getText();
	
			 Assert.assertEquals(actual, expected); 
			 
			 driver.close();
	      }			
		
		
		
   @AfterTest
   public void TearDown() {
	 driver.quit();	}		
		
		

}
