/* 
@author: sarah.mahmood 
Created on May 24, 2021
*/
package ServerAdministration;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class ServerNodesandPCMllSettings {
 
    public String baseUrl = "http://172.20.22.81/OmniPCXRecord/TenantAdmin.aspx";
	
    String driverPath = "C:\\Users\\sarah.mahmood\\Downloads\\gecko-driver\\geckodriver.exe";
	
	public WebDriver driver;
	
////Test ID: 16-01
///* 
//* Validate a node addition.
//*/		
      @Test (priority = 0)
      public void ValidateNodeAdditionName() throws InterruptedException {
    	  
    	  System.setProperty("webdriver.gecko.driver", driverPath);
          driver = new FirefoxDriver();
          driver.get(baseUrl);

          // Signing in OmniPCX 
          driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
          driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
          driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
          
          // Click On Nodes
          Thread.sleep(7000);
   	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
   	      
   	      // Enter a node name
   	      driver.findElement(By.id("tbNodeName")).sendKeys("testNode");
   	      String exp_node_name = "testNode";
   	      String act_node_name = driver.findElement(By.id("tbNodeName")).getAttribute("value");
   	      
   	      Assert.assertEquals(act_node_name, exp_node_name);
   	       
   	      driver.close();	  
  }
      
      
 
////Test ID: 16-02
///* 
//* Add node with secondary IP
//*/	
      @Test (priority = 1)
      public void AddNodewithSecondaryIP() throws InterruptedException {
    	  
    	  System.setProperty("webdriver.gecko.driver", driverPath);
          driver = new FirefoxDriver();
          driver.get(baseUrl);

          // Signing in OmniPCX 
          driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
          driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
          driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
          
          // Click On Nodes
          Thread.sleep(7000);
   	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
   	      
   	      // Enter secondary IP
   	      driver.findElement(By.id("tbSecondaryIP")).sendKeys("217.64.57.182");
   	      String expectedSecondIP = "217.64.57.182";
   	      String actualSecondIP = driver.findElement(By.id("tbSecondaryIP")).getAttribute("value");
   	      
   	      Assert.assertEquals(actualSecondIP, expectedSecondIP);
   	       
   	      driver.close();	  
  }
      
      
      
////Test ID: 16-03
///* 
//* Add node with IPDR Logger Address
//*/	
          @Test (priority = 2)
          public void AddNodewithIPDRLogger() throws InterruptedException {
        	  
        	  System.setProperty("webdriver.gecko.driver", driverPath);
              driver = new FirefoxDriver();
              driver.get(baseUrl);

              // Signing in OmniPCX 
              driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
              driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
              driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
              
              // Click On Nodes
              Thread.sleep(7000);
       	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
       	      
       	      // Check IPDR Logger Address
       	      driver.findElement(By.id("cbIPLogger")).click();
       	      
       	      // Enter IPDR Logger Address
       	      driver.findElement(By.id("tbIPLogger")).sendKeys("217.64.57.182");
       	      String expectedSecondIP = "217.64.57.182";
       	      String actualSecondIP = driver.findElement(By.id("tbIPLogger")).getAttribute("value");
       	      
       	      Assert.assertEquals(actualSecondIP, expectedSecondIP);
       	       
       	      driver.close();	  
      }
        
                   
 
////Test ID: 16-05
///* 
//* Add node with description
//*/
          @Test (priority = 3)
          public void AddNodewithDescription() throws InterruptedException {
        	  
        	  System.setProperty("webdriver.gecko.driver", driverPath);
              driver = new FirefoxDriver();
              driver.get(baseUrl);

              // Signing in OmniPCX 
              driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
              driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
              driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
              
              // Click On Nodes
              Thread.sleep(7000);
       	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
       	      
       	      // Enter Description
       	      driver.findElement(By.id("tbDescription")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It cut off ");
       	      String expectedSecondIP = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It c";
       	      String actualSecondIP = driver.findElement(By.id("tbDescription")).getAttribute("value");
       	      
       	      Assert.assertEquals(actualSecondIP, expectedSecondIP);
       	       
       	      driver.close();	  
      }  
          
          
          
////Test ID: 16-45
///* 
//* Add node in the system 
//*/
          @Test (priority = 4)
          public void AddaNode() throws InterruptedException {
        	  
        	  System.setProperty("webdriver.gecko.driver", driverPath);
              driver = new FirefoxDriver();
              driver.get(baseUrl);

              // Signing in OmniPCX 
              driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
              driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
              driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
              
              // Click On Nodes
              Thread.sleep(7000);
       	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
       	      
       	      // Enter a node name
       	      driver.findElement(By.id("tbNodeName")).sendKeys("AaNode");
       	      
       	      // Enter Primary Hostname/IP Address
       	      driver.findElement(By.id("tbPrimaryIP")).sendKeys("182.11.42.215");  
       	      
       	      // Click on save button
       	      driver.findElement(By.id("btnSave")).click();
       	      
       	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
    	      jsx.executeScript("window.confirm('After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect')");
          
    	      String expectedAlertnodeUpdated = "After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect";
   		      Alert confirmation = driver.switchTo().alert();
   		      String actualAlertnodeUpdated = confirmation.getText(); //Get text present on alert Message

   		      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
   		   		Dismissed user prompt dialog: Settings have been updated successfully:*/
   		      driver.switchTo().alert().accept();
   		  
   		      // Click on okay button
   		      Thread.sleep(5000);
   		      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     

   		      Assert.assertEquals(actualAlertnodeUpdated, expectedAlertnodeUpdated);
    		  
   		      driver.close();	  
          }

          
          
////Test ID: 16-47
///* 
//* Add node in the system with Empty node name 
//*/ 
          @Test (priority = 5)
          public void AddaNodewithEmptyName() throws InterruptedException {
        	  
        	  System.setProperty("webdriver.gecko.driver", driverPath);
              driver = new FirefoxDriver();
              driver.get(baseUrl);

              // Signing in OmniPCX 
              driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
              driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
              driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
              
              // Click On Nodes
              Thread.sleep(7000);
       	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
       	      
//       	      // Enter a node name
//       	      driver.findElement(By.id("tbNodeName")).sendKeys("AaNode");
       	      
       	      // Enter Primary Hostname/IP Address
       	      driver.findElement(By.id("tbPrimaryIP")).sendKeys("44.21.162.60");  
       	      
       	      // Click on save button
       	      driver.findElement(By.id("btnSave")).click();
       	      
    		  String expected = "Please enter node name";
    		  // Get label msg
        	  String actual = driver.findElement(By.id("lblMessage")).getText();
      
        	  Assert.assertEquals(actual, expected);
    		  
   		      driver.close();	  
          }
          
          
////Test ID: 16-48
///* 
//* Add node in the system with Empty Primary  Node IP Address 
//*/          
          @Test (priority = 6)
          public void AddaNodewithEmptyIP() throws InterruptedException {
        	  
        	  System.setProperty("webdriver.gecko.driver", driverPath);
              driver = new FirefoxDriver();
              driver.get(baseUrl);

              // Signing in OmniPCX 
              driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
              driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
              driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
              
              // Click On Nodes
              Thread.sleep(7000);
       	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
       	      
       	      // Enter a node name
       	      driver.findElement(By.id("tbNodeName")).sendKeys("testNode");
       	      
       	      // Click on save button
       	      driver.findElement(By.id("btnSave")).click();
       	      
    		  String expected = "Please enter Primary PBX IP";
    		  // Get label msg
        	  String actual = driver.findElement(By.id("lblMessage")).getText();
      
        	  Assert.assertEquals(actual, expected);
    		  
   		      driver.close();	  
          }   
          
          
////Test ID: 16-49
///* 
//* Add node in the system with duplicate IP 
//*/          
           @Test (priority = 7)
           public void AddaNodewithDuplicateIP() throws InterruptedException {
                	  
           System.setProperty("webdriver.gecko.driver", driverPath);
           driver = new FirefoxDriver();
           driver.get(baseUrl);

           // Signing in OmniPCX 
           driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
           driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
           driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
           
           // Click On Nodes
           Thread.sleep(7000);
    	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
    	      
    	   // Enter a node name
    	   driver.findElement(By.id("tbNodeName")).sendKeys("testNode");
    	      
    	   // Enter Primary Hostname/IP Address
    	   driver.findElement(By.id("tbPrimaryIP")).sendKeys("182.11.42.215");  
    	      
    	   // Click on save button
    	   driver.findElement(By.id("btnSave")).click();
    	   Thread.sleep(4000);
    	      
    	   String expected = "Primary PBX IP already exist";
   		  // Get label msg
       	  String actual = driver.findElement(By.id("lblMessage")).getText();
     
       	  Assert.assertEquals(actual, expected);
 		  
		      driver.close();	  
       }
           
           
           

////Test ID: 16-50
///* 
//* Add node in the system with duplicate node name 
//*/          
                    @Test (priority = 8)
                    public void AddaNodewithDuplicateNodename() throws InterruptedException {
                         	  
                    System.setProperty("webdriver.gecko.driver", driverPath);
                    driver = new FirefoxDriver();
                    driver.get(baseUrl);

                    // Signing in OmniPCX 
                    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
                    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
                    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
                    
                    // Click On Nodes
                    Thread.sleep(7000);
             	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
             	      
             	   // Enter a node name
             	   driver.findElement(By.id("tbNodeName")).sendKeys("AaNode");
             	      
             	   // Enter Primary Hostname/IP Address
             	   driver.findElement(By.id("tbPrimaryIP")).sendKeys("44.21.162.60");  
             	      
             	   // Click on save button
             	   driver.findElement(By.id("btnSave")).click();
             	   Thread.sleep(4000);
             	      
          		  String expected = "Name already exists";
          		  // Get label msg
              	  String actual = driver.findElement(By.id("lblMessage")).getText();
            
              	  Assert.assertEquals(actual, expected);
          		  
         		      driver.close();	  
                }

                    
                    
////Test ID: 16-56
///* 
//* Add node in the system with duplicate secondary IP 
//*/ 
      @Test (priority = 10)
      public void AddaNodewithDuplicateSecondaryIP() throws InterruptedException { 
                    
      System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);   
      
      // Signing in OmniPCX 
      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
      
      // Click On Nodes
      Thread.sleep(7000);
	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
	     
	   // Enter a node name
 	   driver.findElement(By.id("tbNodeName")).sendKeys("testNode");
 	      
 	   // Enter Primary Hostname/IP Address
 	   driver.findElement(By.id("tbPrimaryIP")).sendKeys("92.108.203.219");  
 	   
 	   // Enter Secondary Hostname/IP Address
 	   driver.findElement(By.id("tbSecondaryIP")).sendKeys("39.197.159.165");
 	      
 	   // Click on save button
 	   driver.findElement(By.id("btnSave")).click();
 	   Thread.sleep(4000);
 	      
 	   String expected = "Secondary PBX IP already exist";
		// Get label msg
  	  	String actual = driver.findElement(By.id("lblMessage")).getText();

  	  	Assert.assertEquals(actual, expected);
		  
		      driver.close();	  
      }	 

                   
                    
////Test ID: 16-55
///* 
//* Add node in the system with valid secondary IP 
//*/   
         @Test (priority = 9)
         public void AddaNodewithValidSecondaryIP() throws InterruptedException { 
         
         System.setProperty("webdriver.gecko.driver", driverPath);
         driver = new FirefoxDriver();
         driver.get(baseUrl);

         // Signing in OmniPCX 
         driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
         driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
         driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
         
         // Click On Nodes
         Thread.sleep(7000);
  	     driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
  	     
  	     // Enter a node name
    	 driver.findElement(By.id("tbNodeName")).sendKeys("BbNode");
    	      
    	   // Enter Primary Hostname/IP Address
    	   driver.findElement(By.id("tbPrimaryIP")).sendKeys("138.144.115.53");  
    	   
    	   // Enter Secondary Hostname/IP Address
    	   driver.findElement(By.id("tbSecondaryIP")).sendKeys("39.197.159.165");
    	      
    	   // Click on save button
    	   driver.findElement(By.id("btnSave")).click();
    	   Thread.sleep(4000);
    	      
    	   JavascriptExecutor jsx = (JavascriptExecutor)driver;
 	      jsx.executeScript("window.confirm('After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect')");
    
 	      String expectedAlertnodeUpdated = "After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect";
 	      Alert confirmation = driver.switchTo().alert();
 	      String actualAlertnodeUpdated = confirmation.getText(); //Get text present on alert Message
 	      driver.switchTo().alert().accept();
 	  
 	      // Click on okay button
 	      Thread.sleep(5000);
 	      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     

 	      Assert.assertEquals(actualAlertnodeUpdated, expectedAlertnodeUpdated);
 		  
		  driver.close();	  
         }	 
 

////Test ID: 16-57
///* 
//* Add node in the system with duplicate secondary IP 
//*/    
      @Test (priority = 11)
      public void AddaNodewithSamePrimary_SecondaryIP() throws InterruptedException { 
                    
      System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);   
      
      // Signing in OmniPCX 
      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
      
      // Click On Nodes
      Thread.sleep(7000);
	     driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
	     
	     // Enter a node name
 	   driver.findElement(By.id("tbNodeName")).sendKeys("testNode");
 	      
 	   // Enter Primary Hostname/IP Address
 	   driver.findElement(By.id("tbPrimaryIP")).sendKeys("83.62.14.248");  
 	   
 	   // Enter Secondary Hostname/IP Address
 	   driver.findElement(By.id("tbSecondaryIP")).sendKeys("83.62.14.248");
 	      
 	   // Click on save button
 	   driver.findElement(By.id("btnSave")).click();
 	   Thread.sleep(4000);
 	      
 	   String expected = "Hostnames/IP addresses cannot be identical.";
		// Get label msg
  	  	String actual = driver.findElement(By.id("lblMessage")).getText();

  	  	Assert.assertEquals(actual, expected);
		  
		      driver.close();	  
      }
      
      
////Test ID: 16-58
///* 
//* Add node in the system with valid PCS IP  
//*/  
      @Test (priority = 12)
      public void AddaNodewithValidPCSIP() throws InterruptedException { 
                    
      System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);   
      
      // Signing in OmniPCX 
      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
      
      // Click On Nodes
      Thread.sleep(7000);
	     driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
	     
	     // Enter a node name
 	   driver.findElement(By.id("tbNodeName")).sendKeys("CcNode");
 	      
 	   // Enter Primary Hostname/IP Address
 	   driver.findElement(By.id("tbPrimaryIP")).sendKeys("217.189.179.227");  
 	   
 	   // Enter PCS Hostname/IP Address
 	   driver.findElement(By.id("tbPCSIP")).sendKeys("39.148.197.111");
 	      
 	   // Click on save button
 	   driver.findElement(By.id("btnSave")).click();
 	   Thread.sleep(4000);
 	      
	   JavascriptExecutor jsx = (JavascriptExecutor)driver;
	   jsx.executeScript("window.confirm('After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect')");

	      String expectedAlertnodeUpdated = "After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect";
	      Alert confirmation = driver.switchTo().alert();
	      String actualAlertnodeUpdated = confirmation.getText(); //Get text present on alert Message
	      driver.switchTo().alert().accept();
	  
	      // Click on okay button
	      Thread.sleep(5000);
	      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     

	      Assert.assertEquals(actualAlertnodeUpdated, expectedAlertnodeUpdated);
		  
		      driver.close();	  
      }
      
      

////Test ID: 16-59
///* 
//* Add node in the system with duplicate PCS IP  
//*/      
      @Test (priority = 13)
      public void AddaNodewithDuplicatePCSIP() throws InterruptedException { 
                    
      System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);   
      
      // Signing in OmniPCX 
      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
      
      // Click On Nodes
      Thread.sleep(7000);
	     driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
	     
	     // Enter a node name
 	   driver.findElement(By.id("tbNodeName")).sendKeys("testNode");
 	      
 	   // Enter Primary Hostname/IP Address
 	   driver.findElement(By.id("tbPrimaryIP")).sendKeys("37.2.137.106");  
 	   
 	   // Enter PCS Hostname/IP Address
 	   driver.findElement(By.id("tbPCSIP")).sendKeys("39.148.197.111");
 	      
 	   // Click on save button
 	   driver.findElement(By.id("btnSave")).click();
 	   Thread.sleep(4000);
 	   
 	   String expected = "PCS PBX IP already exist";
	   // Get label msg
	   String actual = driver.findElement(By.id("lblMessage")).getText();

	   Assert.assertEquals(actual, expected);
		  
		      driver.close();	  
    }
      

      
////Test ID: 16-60
///* 
//* Add node in the system with  PCS IP same as of Primary IP  
//*/  
      @Test (priority = 13)
      public void AddaNodewithSamePrimaryPCSIP() throws InterruptedException { 
                    
      System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);   
      
      // Signing in OmniPCX 
      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
      
      // Click On Nodes
      Thread.sleep(7000);
	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
	     
	   // Enter a node name
 	   driver.findElement(By.id("tbNodeName")).sendKeys("testNode");
 	      
 	   // Enter Primary Hostname/IP Address
 	   driver.findElement(By.id("tbPrimaryIP")).sendKeys("37.2.137.106");  
 	   
 	   // Enter PCS Hostname/IP Address
 	   driver.findElement(By.id("tbPCSIP")).sendKeys("37.2.137.106");
 	      
 	   // Click on save button
 	   driver.findElement(By.id("btnSave")).click();
 	   Thread.sleep(4000);
 	   
 	   String expected = "Hostnames/IP addresses cannot be identical.";
	   // Get label msg
	   String actual = driver.findElement(By.id("lblMessage")).getText();

	   Assert.assertEquals(actual, expected);
		  
		      driver.close();	  
    }
    

////Test ID: 16-61
///* 
//* Add node in the system with valid Secondary and PCS IP   
//*/   
      @Test (priority = 14)
      public void AddaNodewithSecondary_PCSIP() throws InterruptedException { 
                    
      System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);   
      
      // Signing in OmniPCX 
      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
      
      // Click On Nodes
      Thread.sleep(7000);
	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
	  
	  // Enter a node name
	   driver.findElement(By.id("tbNodeName")).sendKeys("DdNode");
	   
	   // Enter Primary Hostname/IP Address
	   driver.findElement(By.id("tbPrimaryIP")).sendKeys("115.161.72.117"); 
	      
	   // Enter Secondary Hostname/IP Address
	   driver.findElement(By.id("tbSecondaryIP")).sendKeys("5.234.224.28");  
	   
	   // Enter PCS Hostname/IP Address
	   driver.findElement(By.id("tbPCSIP")).sendKeys("168.250.29.85");
	      
	   // Click on save button
	   driver.findElement(By.id("btnSave")).click();
	   Thread.sleep(4000);
	   
	   JavascriptExecutor jsx = (JavascriptExecutor)driver;
	   jsx.executeScript("window.confirm('After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect')");

	   String expectedAlertnodeUpdated = "After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect";
	   Alert confirmation = driver.switchTo().alert();
	   String actualAlertnodeUpdated = confirmation.getText(); //Get text present on alert Message
	   driver.switchTo().alert().accept();
	  
	   // Click on okay button
	   Thread.sleep(5000);
	   driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     

	   Assert.assertEquals(actualAlertnodeUpdated, expectedAlertnodeUpdated);
	  
	   driver.close();	  
	     
	   
      }
      
      
      
      
 
////Test ID: 16-62
///* 
//* Add node in the system with same Secondary and PCS IP   
//*/     
      @Test (priority = 15)
      public void AddaNodewithSameSecondaryPCSIP() throws InterruptedException { 
                    
      System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);   
      
      // Signing in OmniPCX 
      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
      
      // Click On Nodes
      Thread.sleep(7000);
	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
	     
	   // Enter a node name
 	   driver.findElement(By.id("tbNodeName")).sendKeys("testNode");
 	   
 	   // Enter Primary Hostname/IP Address
 	   driver.findElement(By.id("tbPrimaryIP")).sendKeys("37.2.137.106"); 
 	      
 	   // Enter Secondary Hostname/IP Address
 	   driver.findElement(By.id("tbSecondaryIP")).sendKeys("136.119.204.56");  
 	   
 	   // Enter PCS Hostname/IP Address
 	   driver.findElement(By.id("tbPCSIP")).sendKeys("136.119.204.56");
 	      
 	   // Click on save button
 	   driver.findElement(By.id("btnSave")).click();
 	   Thread.sleep(4000);
 	   
 	   String expected = "Hostnames/IP addresses cannot be identical.";
	   // Get label msg
	   String actual = driver.findElement(By.id("lblMessage")).getText();

	   Assert.assertEquals(actual, expected);
		  
		      driver.close();	  
    }
      

////Test ID: 16-63
///* 
//* Add node in the system with valid IPDR Logger address 
//*/  
	    @Test (priority = 16)
	    public void AddaNodewithValidIPDRLoggerAddress() throws InterruptedException { 
	                  
	    System.setProperty("webdriver.gecko.driver", driverPath);
	    driver = new FirefoxDriver();
	    driver.get(baseUrl);   
	    
	    // Signing in OmniPCX 
	    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	    
	    // Click On Nodes
	    Thread.sleep(7000);
	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
	     
	     // Enter a node name
	   driver.findElement(By.id("tbNodeName")).sendKeys("EeNode");
	   
	   // Enter Primary Hostname/IP Address
	   driver.findElement(By.id("tbPrimaryIP")).sendKeys("193.116.1.55"); 
	      
	   // Click IPDR Logger Address check-box
	   driver.findElement(By.id("cbIPLogger")).click(); 
	   
	   // IPDR Logger Address
	   driver.findElement(By.id("tbIPLogger")).sendKeys("64.244.88.243");
	      
	   // Click on save button
	   driver.findElement(By.id("btnSave")).click();
	   Thread.sleep(4000);
	   
	   JavascriptExecutor jsx = (JavascriptExecutor)driver;
	   jsx.executeScript("window.confirm('After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect')");

	   String expectedAlertnodeUpdated = "After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect";
	   Alert confirmation = driver.switchTo().alert();
	   String actualAlertnodeUpdated = confirmation.getText(); //Get text present on alert Message
	   driver.switchTo().alert().accept();
	   
	   // Click on okay button
	   Thread.sleep(5000);
	   driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     

	   Assert.assertEquals(actualAlertnodeUpdated, expectedAlertnodeUpdated);
		  
	   driver.close();	
		        
    }
	    
	    

////Test ID: 16-64
///* 
//* Add node in the system with Invalid IPDR Logger address 
//*/  
	  @Test (priority = 17)
	  public void AddaNodewithInvalidIPDRLoggerAddress() throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	  	  driver = new FirefoxDriver();
	  	  driver.get(baseUrl);   
	  	    
	  	  // Signing in OmniPCX 
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	  	  
	  	  // Click On Nodes
	  	  Thread.sleep(7000);
	  	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
	  		     
	  	  // Enter a node name
	  	  driver.findElement(By.id("tbNodeName")).sendKeys("testNode");
	  		   
	  	  // Enter Primary Hostname/IP Address
	  	  driver.findElement(By.id("tbPrimaryIP")).sendKeys("14.25.169.225"); 
	  		      
	  	  // Click IPDR Logger Address check-box
	  	  driver.findElement(By.id("cbIPLogger")).click(); 
	  		   
	      // IPDR Logger Address
	  	  driver.findElement(By.id("tbIPLogger")).sendKeys("trtrurtytere");
	  		      
	  	  // Click on save button
	  	  driver.findElement(By.id("btnSave")).click();
	  	  Thread.sleep(4000);
	  	  
	  	  String expected = "Invalid IP Logger";
		  // Get label msg
		  String actual = driver.findElement(By.id("lblMessage")).getText();

		  Assert.assertEquals(actual, expected);
	  			  
	  	  driver.close();	  	      
	      }	  
	  
	  
////Test ID: 16-51
///* 
//* Update node name 
//*/	    
	  @Test (priority = 18)
	  public void UpdateNodeName() throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	  	  driver = new FirefoxDriver();
	  	  driver.get(baseUrl);   
	  	    
	  	  // Signing in OmniPCX 
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	  
	  	  // Click On Nodes
	  	  Thread.sleep(9000);
	  	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
	
		//Get the table and row
		WebElement table =driver.findElement(By.id("NodeTable"));
		WebElement tbody=table.findElement(By.tagName("tbody"));
		List<WebElement> rows=tbody.findElements(By.tagName("tr"));
		//ArrayList<String> ListOdIds=new ArrayList<>();
		String rowNo="";
		String NodeName = "CcNode";
		for(int i=0;i<rows.size();i++)
		{
		WebElement row = tbody.findElement(By.xpath("//*[@id=\"NodeTable\"]/tbody/tr["+(i+1)+"]"));
		if(row.getText().trim().contains(NodeName))
		{
		rowNo=Integer.toString(i+1);
		break;
		}
		}
//		System.out.println(rowNo);
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[10]/div/img[1]")).click();
		
		// Edit node name
		driver.findElement(By.id("tbNodeName")).clear();
	  	driver.findElement(By.id("tbNodeName")).sendKeys("CcNode Updated");
	  	
	  	// Click On save button
	  	driver.findElement(By.id("btnSave")).click();
	  	
	  	JavascriptExecutor jsx = (JavascriptExecutor)driver;
	  	jsx.executeScript("window.confirm('After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect')");
		
	  	 String expectedAlertnodeUpdated = "After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect";
		 Alert confirmation = driver.switchTo().alert();
		 String actualAlertnodeUpdated = confirmation.getText(); //Get text present on alert Message
		 driver.switchTo().alert().accept();
		 
		// Click on okay button
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();
		
		Assert.assertEquals(actualAlertnodeUpdated, expectedAlertnodeUpdated);
		  
		driver.close();	 
		
		}		  
	  
	
	  
	  
////Test ID: 16-52
///* 
//* Update Primary Node IP
//*/	
	  @Test (priority = 19)
	  public void UpdatePrimaryNodeIP() throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	  	  driver = new FirefoxDriver();
	  	  driver.get(baseUrl);   
	  	    
	  	  // Signing in OmniPCX 
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	  
	  	  // Click On Nodes
	  	  Thread.sleep(9000);
	  	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
	
		//Get the table and row
		WebElement table =driver.findElement(By.id("NodeTable"));
		WebElement tbody=table.findElement(By.tagName("tbody"));
		List<WebElement> rows=tbody.findElements(By.tagName("tr"));
		//ArrayList<String> ListOdIds=new ArrayList<>();
		String rowNo="";
		String NodeName = "AaNode";
		for(int i=0;i<rows.size();i++)
		{
		WebElement row = tbody.findElement(By.xpath("//*[@id=\"NodeTable\"]/tbody/tr["+(i+1)+"]"));
		if(row.getText().trim().contains(NodeName))
		{
		rowNo=Integer.toString(i+1);
		break;
		}
		}
		System.out.println(rowNo);
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[10]/div/img[1]")).click();
		
		// Edit node name
		driver.findElement(By.id("tbPrimaryIP")).clear();
	  	driver.findElement(By.id("tbPrimaryIP")).sendKeys("81.121.22.59");
	  	
	  	// Click On save button
	  	driver.findElement(By.id("btnSave")).click();
	  	
		   JavascriptExecutor jsx = (JavascriptExecutor)driver;
		   jsx.executeScript("window.confirm('After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect')");
	
		   String expectedAlertnodeUpdated = "After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect";
		   Alert confirmation = driver.switchTo().alert();
		   String actualAlertnodeUpdated = confirmation.getText(); //Get text present on alert Message
		   driver.switchTo().alert().accept();
		   
		   // Click on okay button
		   Thread.sleep(5000);
		   driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     
	
		   Assert.assertEquals(actualAlertnodeUpdated, expectedAlertnodeUpdated);
			  
		   driver.close();	  
		}
      
    
////Test ID: 16-54
///* 
//* Delete node from System that is not associated with extensions
//*/	
	  @Test (priority = 19)
	  public void DeleteNodewithoutExtension() throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	  	  driver = new FirefoxDriver();
	  	  driver.get(baseUrl);   
	  	    
	  	  // Signing in OmniPCX 
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	  
	  	  // Click On Nodes
	  	  Thread.sleep(9000);
	  	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
	
		//Get the table and row
		WebElement table =driver.findElement(By.id("NodeTable"));
		WebElement tbody=table.findElement(By.tagName("tbody"));
		List<WebElement> rows=tbody.findElements(By.tagName("tr"));
		//ArrayList<String> ListOdIds=new ArrayList<>();
		String rowNo="";
		String NodeName = "EeNode";
		for(int i=0;i<rows.size();i++)
		{
		WebElement row = tbody.findElement(By.xpath("//*[@id=\"NodeTable\"]/tbody/tr["+(i+1)+"]"));
		if(row.getText().trim().contains(NodeName))
		{
		rowNo=Integer.toString(i+1);
		break;
		}
		}
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[10]/div/img[2]")).click();
	  	
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.confirm('Are you sure you want to delete?')");	   
		driver.switchTo().alert().accept();
		   
		   // Click on delete button
		   Thread.sleep(5000);
		   driver.findElement(By.id("btnDelete")).click();
		   
		   
	      Thread.sleep(6000);
		  String expected = "Record has been deleted successfully";
		  // Get label msg
  	      String actual = driver.findElement(By.id("lblGridMsg")).getText();

  	      Assert.assertEquals(actual, expected);
			  
		   driver.close();	  
		   
		}
	  
          
          

////Test ID: 16-10
///* 
//* In Nodes, Check paging for multiple extensions that are assigned to a Node. 
//*/ 
          @Test (priority = 20)
          public void AddNodeCheckpagingforMultipleExtensions() throws InterruptedException {
        	  
        	  System.setProperty("webdriver.gecko.driver", driverPath);
              driver = new FirefoxDriver();
//              driver.get(baseUrl);
   		      
   		      // Signing in OmniPCX --> Site Administration
   		      driver.get("http://172.20.22.81/OmniPCXRecord/default.aspx");
              driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
              driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
              driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
   		      
              String[] extension = {"123", "456", "789", "234", "567", "890", "345", "678", "901", "101"};
              // Add 10 extensions to the same node
              for (int i = 0; i <extension.length; i++) {
              
              // Click on Extensions
              Thread.sleep(7000);
              driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink7")).click();
              
              // Click Add Extension
              Thread.sleep(5000);
              driver.findElement(By.id("linkAddExtensions")).click();
              
              // Extension*
              driver.findElement(By.id("tbExtension")).sendKeys(extension[i]);
             
              // Click add button
              driver.findElement(By.id("imgbtnAddUpdate")).click();
              Thread.sleep(5000);
              
              // Check alert message
      		   JavascriptExecutor jsy = (JavascriptExecutor)driver;
      		   jsy.executeScript("window.confirm('Settings have been saved successfully')");
      		   driver.switchTo().alert().accept();
      		  
      		   // Click on okay button
      		   Thread.sleep(5000);
      		   driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click(); 
              }
              
              // Logout of site admin
              Thread.sleep(3000);
              driver.findElement(By.id("ctl00_lblLogOut")).click();
              
              // Go-to Server Admin
              driver.get(baseUrl);
              // Signing in OmniPCX 
              driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
              driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
              driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
              
              // Click On Nodes
              Thread.sleep(7000);
     	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click(); 
     	      
     	      // Click [+] against node
     	      Thread.sleep(3000);
     	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr[1]/td[1]/img")).click();
     	      
     	      Thread.sleep(10000);
     	      Assert.assertTrue(driver.findElement(By.className("dataTables_wrapper")).isDisplayed());
              
   		      driver.close();
} 
          

          
////Test ID: 16-46
///* 
//* Add multiple nodes in the system 
//*/      
          @Test (priority = 20)
          public void AddMultipleNodes() throws InterruptedException {
        	  
        	  System.setProperty("webdriver.gecko.driver", driverPath);
              driver = new FirefoxDriver();
              driver.get(baseUrl);
              
              // Signing in OmniPCX 
              driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
              driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
              driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
              
              // Click On Nodes
              Thread.sleep(7000);
     	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click(); 
     	      
     	     String[] NodeName = {"MultiNode1", "MultiNode2"};
     	     String[] PrimaryIP  = {"234.34.456.341", "53.12.173.16"};
     	     
             // Add multiple nodes (2 nodes)
             for (int i = 0; i < NodeName.length ; i++) {
            	 
            	 // Enter Name*
                 driver.findElement(By.id("tbNodeName")).sendKeys(NodeName[i]);
                 
                 // Enter Primary Hostname/IP Address*
                 driver.findElement(By.id("tbPrimaryIP")).sendKeys(PrimaryIP[i]);
                 
                 // click on Save button
                 driver.findElement(By.id("btnSave")).click();
                 
	             // Check alert message
	       		 JavascriptExecutor jsy = (JavascriptExecutor)driver;
	       		 jsy.executeScript("window.confirm('After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect')");
	       		 driver.switchTo().alert().accept();
            	 
	       	     // Click on okay button
	       		 Thread.sleep(5000);
	       		 driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click(); 
	       		 
	       		 Thread.sleep(3000);
	       		 String expected = "Node information added successfully";
	       		 String actual = driver.findElement(By.id("lblMessage")).getText();
	       		 Assert.assertEquals(actual, expected);
             } 
            	 	 
             System.out.println("Multiple nodes added.");
              driver.close();
          } 
    
	
////Test ID: 16-53
///* 
//* Delete node from System that is associated with extensions
//*/	
	  @Test (priority = 21)
	  public void DeleteNodewithExtension() throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	  	  driver = new FirefoxDriver();
	  	  driver.get(baseUrl);   
	  	    
	  	  // Signing in OmniPCX 
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	  
	  	  // Click On Nodes
	  	  Thread.sleep(9000);
	  	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
	
		//Get the table and row
		WebElement table =driver.findElement(By.id("NodeTable"));
		WebElement tbody=table.findElement(By.tagName("tbody"));
		List<WebElement> rows=tbody.findElements(By.tagName("tr"));
		//ArrayList<String> ListOdIds=new ArrayList<>();
		String rowNo="";
		String NodeName = "AaNode";
		for(int i=0;i<rows.size();i++)
		{
		WebElement row = tbody.findElement(By.xpath("//*[@id=\"NodeTable\"]/tbody/tr["+(i+1)+"]"));
		if(row.getText().trim().contains(NodeName))
		{
		rowNo=Integer.toString(i+1);
		break;
		}
		}
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[10]/div/img[2]")).click();
	  	
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.confirm('Are you sure you want to delete?')");	   
		driver.switchTo().alert().accept();
		
		// Click on delete button
		Thread.sleep(5000);
		driver.findElement(By.id("btnDelete")).click();
		      
	    Thread.sleep(6000);
		String expected = "Unable to delete Node. This Node is associated with extension(s).";
		// Get label msg
	    String actual = driver.findElement(By.id("lblGridMsg")).getText();

	    Assert.assertEquals(actual, expected);
		  	  
		driver.close();	  
		   
		}	
	
	

////Test ID: 16-43
///* 
//* Update IP of node assigned to a DR-Link Packetizer
//*/	
	  @Test (priority = 22)
	  public void UpdateIPofNodeAssignedtoDR_LinkPacketizer() throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	  	  driver = new FirefoxDriver();
	  	  driver.get(baseUrl);   
	  	    
	  	  // Signing in OmniPCX 
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	  
	  	  // Click On Nodes
	  	  Thread.sleep(9000);
	  	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
	
		//Get the table and row
		WebElement table =driver.findElement(By.id("NodeTable"));
		WebElement tbody=table.findElement(By.tagName("tbody"));
		List<WebElement> rows=tbody.findElements(By.tagName("tr"));
		//ArrayList<String> ListOdIds=new ArrayList<>();
		String rowNo="";
		String NodeName = "CcNode";
		for(int i=0;i<rows.size();i++)
		{
		WebElement row = tbody.findElement(By.xpath("//*[@id=\"NodeTable\"]/tbody/tr["+(i+1)+"]"));
		if(row.getText().trim().contains(NodeName))
		{
		rowNo=Integer.toString(i+1);
		break;
		}
		}
		System.out.println(rowNo);
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[10]/div/img[1]")).click();
		
		// Edit node ip
		driver.findElement(By.id("tbPrimaryIP")).clear();
	  	driver.findElement(By.id("tbPrimaryIP")).sendKeys("54.85.176.160");
	  	
	  	// Click On save button
	  	driver.findElement(By.id("btnSave")).click();
	  	
	  	JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.confirm('After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect')");

		String expectedAlertnodeUpdated = "After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect";
		Alert confirmation = driver.switchTo().alert();
		String actualAlertnodeUpdated = confirmation.getText(); //Get text present on alert Message
		driver.switchTo().alert().accept();
	  	
        // Click on okay button
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();  
		
		Assert.assertEquals(actualAlertnodeUpdated, expectedAlertnodeUpdated);
			  
		   driver.close();	  
		}
          
          
          
////Test ID: 16-65
///* 
//* Verify user is able to expand and minimize add node tab
//*/
          @Test (priority = 23)
			public void VerifyMinimizeSearchNodeSettingsTab() throws InterruptedException {
									  
		    System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver();
			driver.get(baseUrl);
									
			// Signing in OmniPCX 
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			
			// Click On Nodes
		  	Thread.sleep(9000);
		  	driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();	
			
			// Minimize node search settings
			driver.findElement(By.xpath("//*[@id=\"img1\"]")).click();
			Assert.assertFalse(driver.findElement(By.id("divAddPBX")).isDisplayed());
			
			// Maximize packitizer search settings
			driver.findElement(By.xpath("//*[@id=\"img1\"]")).click();
			Assert.assertTrue(driver.findElement(By.id("divAddPBX")).isDisplayed());
			
			   driver.close();	  
			}	
	
	
        			
	  
////Test ID: 16-07
///* 
//* Verify the modification of node. 
//*/   		      
		@Test (priority = 32)
	    public void ModificationofNode() throws InterruptedException {
	  	  
	  	  System.setProperty("webdriver.gecko.driver", driverPath);
	        driver = new FirefoxDriver();
	        driver.get(baseUrl);
	
	        // Signing in OmniPCX 
	        driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	        driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	        driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	        
	        // Click On Nodes
	        Thread.sleep(7000);
	 	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click(); 
	 	    
			//Get the table and row
			WebElement table =driver.findElement(By.id("NodeTable"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			//ArrayList<String> ListOdIds=new ArrayList<>();
			String rowNo="";
			String NodeName = "MultiNode2";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"NodeTable\"]/tbody/tr["+(i+1)+"]"));
			if(row.getText().trim().contains(NodeName))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[10]/div/img[1]")).click();
		  	
		  	// Click On save button
		  	driver.findElement(By.id("btnSave")).click();
		  	
			   JavascriptExecutor jsx = (JavascriptExecutor)driver;
			   jsx.executeScript("window.confirm('After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect')");
		
			   String expectedAlertnodeUpdated = "After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect";
			   Alert confirmation = driver.switchTo().alert();
			   String actualAlertnodeUpdated = confirmation.getText(); //Get text present on alert Message
			   driver.switchTo().alert().accept();
			   
			   // Click on okay button
			   Thread.sleep(5000);
			   driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     
		
			   Assert.assertEquals(actualAlertnodeUpdated, expectedAlertnodeUpdated);
				  
			   driver.close();	  
			}
 	    
 	          
	       
////Test ID: 16-08
///* 
//* Verify the Deletion of a Node 
//*/          
		@Test (priority = 25)
        public void DeletionofNode () throws InterruptedException {
      	  
      	  System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
            driver.get(baseUrl);

            // Signing in OmniPCX 
            driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
            driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
            driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
            
            // Click On Nodes
            Thread.sleep(7000);
     	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();  
     	    
    		//Get the table and row
    		WebElement table =driver.findElement(By.id("NodeTable"));
    		WebElement tbody=table.findElement(By.tagName("tbody"));
    		List<WebElement> rows=tbody.findElements(By.tagName("tr"));
    		String rowNo="";
    		String NodeName = "50Chars";
    		for(int i=0;i<rows.size();i++)
    		{
    		WebElement row = tbody.findElement(By.xpath("//*[@id=\"NodeTable\"]/tbody/tr["+(i+1)+"]"));
    		if(row.getText().trim().contains(NodeName))
    		{
    		rowNo=Integer.toString(i+1);
    		break;
    		}
    		}
    		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[10]/div/img[2]")).click();
    	  	
    		JavascriptExecutor jsx = (JavascriptExecutor)driver;
    		jsx.executeScript("window.confirm('Are you sure you want to delete?')");	   
    		driver.switchTo().alert().accept();
    		   
    		// Click on delete button
    		Thread.sleep(5000);
    		driver.findElement(By.id("btnDelete")).click();
    		     
    	    Thread.sleep(6000);
    		String expected = "Record has been deleted successfully";
    		// Get label msg
      	    String actual = driver.findElement(By.id("lblGridMsg")).getText();
    
      	    Assert.assertEquals(actual, expected);
    			  
    		driver.close();	  
    		   
   		}
	


////Test ID: 16-66
///* 
//* Delete node which is associated with Trunk Group  
//*/
		@Test (priority = 26)
		public void DeleteNodeAssociatedwithTrunkGroup () throws InterruptedException {
		  
		  System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		  
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Trunk Groups
		  Thread.sleep(9000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink7")).click();		  
		  
		  // add trunk name*
		  driver.findElement(By.id("tbTrunkGroup")).sendKeys("ATrunk");
		  
		  // Select Node
		  Thread.sleep(5000);
		  Select dropdownNode = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/select")));
	   	  dropdownNode.selectByVisibleText("MultiNode2"); 
		  
		  // Click on Save button
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input[1]")).click();
	      
        // Click On Nodes
        Thread.sleep(7000);
 	    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();  
 	    
		//Get the table and row
		WebElement table =driver.findElement(By.id("NodeTable"));
		WebElement tbody=table.findElement(By.tagName("tbody"));
		List<WebElement> rows=tbody.findElements(By.tagName("tr"));
		String rowNo="";
		String NodeName = "MultiNode2";
		for(int i=0;i<rows.size();i++)
		{
		WebElement row = tbody.findElement(By.xpath("//*[@id=\"NodeTable\"]/tbody/tr["+(i+1)+"]"));
		if(row.getText().trim().contains(NodeName))
		{
		rowNo=Integer.toString(i+1);
		break;
		}
		}
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[10]/div/img[2]")).click();
	  	
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.confirm('Are you sure you want to delete?')");	   
		driver.switchTo().alert().accept();
		   
		// Click on delete button
		Thread.sleep(5000);
		driver.findElement(By.id("btnDelete")).click();
		     
	    Thread.sleep(6000);
		String expected = "Unable to delete Node. This Node is associated with Trunk Group(s).";
		// Get label msg
  	    String actual = driver.findElement(By.id("lblGridMsg")).getText();

  	    Assert.assertEquals(actual, expected);
			  
		driver.close();	  
		   
		}	
		
		
		
		
////Test ID: 16-69
///* 
//* Verify that multiple nodes are added for a single branch and is replicated to Branch 
//*/
      @Test (priority = 29)
      public void VerifyMultipleNodesaddedforSingleBranch() throws InterruptedException {
    	  
    	  System.setProperty("webdriver.gecko.driver", driverPath);
          driver = new FirefoxDriver();
          driver.get(baseUrl);

          // Signing in OmniPCX 
          driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
          driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
          driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
          
          // Click On Nodes
          Thread.sleep(9000);
   	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
   	      
   	      // Enter a node name
   	      driver.findElement(By.id("tbNodeName")).sendKeys("BranchNodeExt2");
   	      
   	      // Enter Primary Hostname/IP Address
   	      driver.findElement(By.id("tbPrimaryIP")).sendKeys("92.252.85.190");  
   	      
   	      // Enter Recorder
   	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
	   	  dropdownRC.selectByVisibleText("Branch"); 
   	      
   	      // Click on save button
   	      driver.findElement(By.id("btnSave")).click();
   	      
   	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect')");
		  driver.switchTo().alert().accept();
		  
		  // Click on okay button
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();
		  
		  Thread.sleep(6000);
		  String expected = "Node information added successfully";
		  // Get label msg
	  	  String actual = driver.findElement(By.id("lblMessage")).getText();
	
	  	  Assert.assertEquals(actual, expected);

		  driver.close();	  
}	
	
	
	
////Test ID: 16-73
///* 
//* Add node in the system with 50 or more characters in Primary Hostname/IP Address field
//*/	
	  @Test (priority = 24)
	  public void AddaNodewith50CharactersinPrimaryIP() throws InterruptedException {
		  
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);
	
	      // Signing in OmniPCX 
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
      
	      // Click On Nodes
	      Thread.sleep(7000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
		  
		  // Enter a node name
	      driver.findElement(By.id("tbNodeName")).sendKeys("50Chars");
	      
	      // Enter Primary Hostname/IP Address
	      driver.findElement(By.id("tbPrimaryIP")).sendKeys("Aaaaaaaaa78901132aaaaaaaaaaaaaaaaaaaaaaaaaaaa123456");  
	      
	      // Click on save button
	      driver.findElement(By.id("btnSave")).click();
	      
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect')");
	  
	      String expectedAlertnodeUpdated = "After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect";
		  Alert confirmation = driver.switchTo().alert();
		  String actualAlertnodeUpdated = confirmation.getText(); //Get text present on alert Message
	      driver.switchTo().alert().accept();
	  
	      // Click on okay button
	      Thread.sleep(5000);
	      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     

	      Assert.assertEquals(actualAlertnodeUpdated, expectedAlertnodeUpdated);
	  
	      driver.close();	  
  }
	
	
	
	
////Test ID: 16-79
///* 
//* Verify that PCS Hostname/IP Address is disabled for Branch
//*/
	  @Test (priority = 32)
	  public void VerifyPCSIPAddressDisabledforBranch() throws InterruptedException {
		  
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);
	
	      // Signing in OmniPCX 
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
    
	      // Click On Nodes
	      Thread.sleep(7000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
		  
		  //Get the table and row
		  WebElement table =driver.findElement(By.id("NodeTable"));
		  WebElement tbody=table.findElement(By.tagName("tbody"));
		  List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String NodeName = "BranchNodeExt";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"NodeTable\"]/tbody/tr["+(i+1)+"]"));
			if(row.getText().trim().contains(NodeName))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[10]/div/img[1]")).click();
			
			// Check PCS Hostname/IP Address disabled
			Assert.assertFalse(driver.findElement(By.id("tbPCSIP")).isEnabled());  
				  
			driver.close();	  
			}
	
	
	
	
////Test ID: 16-80
///* 
//* Verify user is not able to update PCX node same as Secondary node IP
//*/
		  @Test (priority = 33)
		  public void  UnabletoUpdatePCXNodesameasSecondaryIP() throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);
	
	      // Signing in OmniPCX 
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click On Nodes
	      Thread.sleep(7000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
	      
		  //Get the table and row
		  WebElement table =driver.findElement(By.id("NodeTable"));
		  WebElement tbody=table.findElement(By.tagName("tbody"));
		  List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String NodeName = "BbNode";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"NodeTable\"]/tbody/tr["+(i+1)+"]"));
			if(row.getText().trim().contains(NodeName))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[10]/div/img[1]")).click();
			
			Thread.sleep(3000);
			
			// Enter secondary IP
		    driver.findElement(By.id("tbSecondaryIP")).clear();
			
			// Check PCS Hostname/IP Address disabled
			driver.findElement(By.id("tbPCSIP")).sendKeys("39.197.159.165"); 
			
		  	// Click On save button
		  	driver.findElement(By.id("btnSave")).click();
		  	
		  	Thread.sleep(5000);
		  	
		  	String expected = "PCS PBX IP already exist";
		  	// Get label msg
		  	String actual = driver.findElement(By.id("lblMessage")).getText();
    
		  	Assert.assertEquals(actual, expected);
		  		  
			driver.close();	  
		  	
			}
		  	
		    
		    
////Test ID: 16-16
///* 
//* Add DR-Link Packetizer details in system.  
//*/
		  		@Test (priority = 34)
		  		public void AddDR_LinkPacketizerinSystem() throws InterruptedException {
		  		  
		  		  System.setProperty("webdriver.gecko.driver", driverPath);
		  		  driver = new FirefoxDriver();
		  		  driver.get(baseUrl);
		  		
		  		  // Signing in OmniPCX 
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  		  
		  		  // Click On Packetizer Settings
		  		  Thread.sleep(7000);
		  		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
		  		  
		  		  // Click on Add Packetizer
		  		  Thread.sleep(5000);
		  		  driver.findElement(By.id("linkAddPacketizers")).click();
		  		  
//		  		  // Select Connection Type
//		  		  driver.findElement(By.id("RecorderTypeExtension")).click();
		  		  
		  		  // Select Node
		  		  Thread.sleep(5000);
		  		  Select dropdownNode = new Select(driver.findElement(By.id("ddlNodes")));
		  	   	  dropdownNode.selectByVisibleText("DdNode"); 
		  		  
		  		  // add PCM II Physical Address * (Crystal - Coupler)
		  		  driver.findElement(By.id("tbCrystal")).sendKeys("12");
		  		  driver.findElement(By.id("tbCoupler")).sendKeys("34");
		  		  
		  		  // add Packetizer IP *
		  		  driver.findElement(By.id("tbPacketizerIp")).sendKeys("209.54.83.64");
		  		  
		  		  // add Packetizer Port *
		  		  driver.findElement(By.id("tbPacketizerPort")).sendKeys("3667");
		  		  
		  		  // Click on Save button
		  		  driver.findElement(By.id("btnSave")).click();
		  		  
		  	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
		            jsx.executeScript("window.confirm('Settings have been saved successfully')");

		            String expectedAlertnodeUpdated = "Settings have been saved successfully";
		  	      Alert confirmation = driver.switchTo().alert();
		  	      String actualAlertnodeUpdated = confirmation.getText(); //Get text present on alert Message

		  	      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
		  	   		Dismissed user prompt dialog: Settings have been updated successfully:*/
		  	      driver.switchTo().alert().accept();
		  	  
		  	      // Click on okay button
		  	      Thread.sleep(5000);
		  	      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     

		  	      Assert.assertEquals(actualAlertnodeUpdated, expectedAlertnodeUpdated);
		  		  
		  		  driver.close();	        	      
		  		     
		  		} 


		  	
		  	
////Test ID: 16-17
///* 
//* Add multiple DR-Link Packetizers in system with same node.  
//*/	
		  		@Test (priority = 35)
		  		public void AddmultipleDR_LinkPacketizerinSystemwithSameNode() throws InterruptedException {
		  		  
		  		  System.setProperty("webdriver.gecko.driver", driverPath);
		  		  driver = new FirefoxDriver();
		  		  driver.get(baseUrl);
		  		
		  		  // Signing in OmniPCX 
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  		  
		  		  // Click On Packetizer Settings
		  		  Thread.sleep(7000);
		  		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
		  		  
		  		  String[] crystal = {"10", "11"};
		    	      String[] coupler  = {"20", "21"};
		    	      String[] packetizerip = {"200.247.210.95", "154.18.192.87"};
		    	      String[] packetizerport = {"1010", "1111"};
		            
		    	      // Add multiple packetizer (2 packetizer)
		            for (int i = 0; i < packetizerip.length ; i++) {
		          	  
		  		  // Click on Add Packetizer
		  		  Thread.sleep(5000);
		  		  driver.findElement(By.id("linkAddPacketizers")).click();
		  		  
//		  		  // Select Connection Type
//		  		  driver.findElement(By.id("RecorderTypeExtension")).click();
		  		  
		  		  // Select Node
		  		  Thread.sleep(5000);
		  		  Select dropdownNode = new Select(driver.findElement(By.id("ddlNodes")));
		  	   	  dropdownNode.selectByVisibleText("AaNode"); 
		  		  
		  		  // add PCM II Physical Address * (Crystal - Coupler)
		  		  driver.findElement(By.id("tbCrystal")).sendKeys(crystal[i]);
		  		  driver.findElement(By.id("tbCoupler")).sendKeys(coupler[i]);
		  		  
		  		  // add Packetizer IP *
		  		  driver.findElement(By.id("tbPacketizerIp")).sendKeys(packetizerip[i]);
		  		  
		  		  // add Packetizer Port *
		  		  driver.findElement(By.id("tbPacketizerPort")).sendKeys(packetizerport[i]);
		  		  
		  		  // Click on Save button
		  		  driver.findElement(By.id("btnSave")).click();
		  		  
		  	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
		            jsx.executeScript("window.confirm('Settings have been saved successfully')");

		            String expectedAlertnodeUpdated = "Settings have been saved successfully";
		  	      Alert confirmation = driver.switchTo().alert();
		  	      String actualAlertnodeUpdated = confirmation.getText(); //Get text present on alert Message

		  	      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
		  	   		Dismissed user prompt dialog: Settings have been updated successfully:*/
		  	      driver.switchTo().alert().accept();
		  	  
		  	      // Click on okay button
		  	      Thread.sleep(5000);
		  	      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     

		  	      Assert.assertEquals(actualAlertnodeUpdated, expectedAlertnodeUpdated);
		            }
		            
		            System.out.println("Multiple packetizer added.");
		  		  driver.close();	        	        
		  		} 
		  		
		  		
////Test ID: 16-18
///* 
//* Add multiple DR-Link Packetizers in system with different nodes.   
//*/
		  		@Test (priority = 36)
		  		public void AddmultipleDR_LinkPacketizerinSystemwithDiffNode() throws InterruptedException {
		  		  
		  		  System.setProperty("webdriver.gecko.driver", driverPath);
		  		  driver = new FirefoxDriver();
		  		  driver.get(baseUrl);
		  		
		  		  // Signing in OmniPCX 
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  		  
		  		  // Click On Packetizer Settings
		  		  Thread.sleep(7000);
		  		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
		  		  
		  		  String[] crystal = {"30", "31"};
		    	      String[] coupler  = {"40", "41"};
		    	      String[] packetizerip = {"150.220.48.68", "164.153.234.141"};
		    	      String[] packetizerport = {"3030", "3131"};
		            
		    	      // Add multiple packetizer (2 packetizer)
		            for (int i = 0; i < packetizerip.length ; i++) {
		          	  
		  		  // Click on Add Packetizer
		  		  Thread.sleep(5000);
		  		  driver.findElement(By.id("linkAddPacketizers")).click();
		  		  
//		  		  // Select Connection Type
//		  		  driver.findElement(By.id("RecorderTypeExtension")).click();
		  		  
		  		  if (i <1) {
		  			  // Select Node
		  			  Thread.sleep(5000);
		  			  Select dropdownNode = new Select(driver.findElement(By.id("ddlNodes")));
		  		   	  dropdownNode.selectByVisibleText("AaNode"); }
		  		  
		  		  else {
		  		      // Select Node
		  			  Thread.sleep(5000);
		  			  Select dropdownNode1 = new Select(driver.findElement(By.id("ddlNodes")));
		  		   	  dropdownNode1.selectByVisibleText("DdNode"); }
		  		  
		  		  // add PCM II Physical Address * (Crystal - Coupler)
		  		  driver.findElement(By.id("tbCrystal")).sendKeys(crystal[i]);
		  		  driver.findElement(By.id("tbCoupler")).sendKeys(coupler[i]);
		  		  
		  		  // add Packetizer IP *
		  		  driver.findElement(By.id("tbPacketizerIp")).sendKeys(packetizerip[i]);
		  		  
		  		  // add Packetizer Port *
		  		  driver.findElement(By.id("tbPacketizerPort")).sendKeys(packetizerport[i]);
		  		  
		  		  // Click on Save button
		  		  driver.findElement(By.id("btnSave")).click();
		  		  
		  	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
		            jsx.executeScript("window.confirm('Settings have been saved successfully')");

		            String expectedAlertnodeUpdated = "Settings have been saved successfully";
		  	      Alert confirmation = driver.switchTo().alert();
		  	      String actualAlertnodeUpdated = confirmation.getText(); //Get text present on alert Message
		  	      driver.switchTo().alert().accept();
		  	  
		  	      // Click on okay button
		  	      Thread.sleep(5000);
		  	      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     

		  	      Assert.assertEquals(actualAlertnodeUpdated, expectedAlertnodeUpdated);
		            }
		            
		            System.out.println("Multiple packetizer, with different nodes added.");
		  		  driver.close();	        	        
		  		} 
		  	
		  		
		  		
////Test ID: 16-19
///* 
//* Verify that user is not able to add DR-Link packetizer when no node is assigned.    
//*/
		  		@Test (priority = 37)
		  		public void AddDR_LinkPacketizerinSystemwithNoNode() throws InterruptedException {
		  		  
		  		  System.setProperty("webdriver.gecko.driver", driverPath);
		  		  driver = new FirefoxDriver();
		  		  driver.get(baseUrl);
		  		
		  		  // Signing in OmniPCX 
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  		  
		  		  // Click On Packetizer Settings
		  		  Thread.sleep(7000);
		  		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
		  		    
		  		  // Click on Add Packetizer
		  		  Thread.sleep(5000);
		  		  driver.findElement(By.id("linkAddPacketizers")).click();
		  		  
		  		  // add PCM II Physical Address * (Crystal - Coupler)
		  		  driver.findElement(By.id("tbCrystal")).sendKeys("56");
		  		  driver.findElement(By.id("tbCoupler")).sendKeys("78");
		  		  
		  		  // add Packetizer IP *
		  		  driver.findElement(By.id("tbPacketizerIp")).sendKeys("116.67.141.203");
		  		  
		  		  // add Packetizer Port *
		  		  driver.findElement(By.id("tbPacketizerPort")).sendKeys("1122");
		  		  
		  		  // Click on Save button
		  		  driver.findElement(By.id("btnSave")).click();
		  		  
		  		  String expected = "Please select node";
		  		  // Get label msg
		  		  String actual = driver.findElement(By.id("lblMessage")).getText();

		  		  Assert.assertEquals(actual, expected);
		  		  
		  		  driver.close();
		  		  
		  		}
		  		
		  		
		  		
		  		
////Test ID: 16-20
///* 
//* Verify that user is not able to add DR-Link packetizer when no crystal is given     
//*/
		  		@Test (priority = 38)
		  		public void AddDR_LinkPacketizerinSystemwithNoCrystal() throws InterruptedException {
		  		  
		  		  System.setProperty("webdriver.gecko.driver", driverPath);
		  		  driver = new FirefoxDriver();
		  		  driver.get(baseUrl);
		  		
		  		  // Signing in OmniPCX 
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  		  
		  		  // Click On Packetizer Settings
		  		  Thread.sleep(7000);
		  		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
		  		    
		  		  // Click on Add Packetizer
		  		  Thread.sleep(5000);
		  		  driver.findElement(By.id("linkAddPacketizers")).click();
		  		  
		  		  // Select Node
		  		  Thread.sleep(5000);
		  		  Select dropdownNode = new Select(driver.findElement(By.id("ddlNodes")));
		  	   	  dropdownNode.selectByVisibleText("DdNode"); 
		  		  
		  		  // add PCM II Physical Address * (Crystal - Coupler)
		  		  driver.findElement(By.id("tbCoupler")).sendKeys("78");
		  		  
		  		  // add Packetizer IP *
		  		  driver.findElement(By.id("tbPacketizerIp")).sendKeys("116.67.141.203");
		  		  
		  		  // add Packetizer Port *
		  		  driver.findElement(By.id("tbPacketizerPort")).sendKeys("1122");
		  		  
		  		  // Click on Save button
		  		  driver.findElement(By.id("btnSave")).click();
		  		  
		  		  String expected = "Please enter Crystal";
		  		  // Get label msg
		  		  String actual = driver.findElement(By.id("lblMessage")).getText();

		  		  Assert.assertEquals(actual, expected);
		  		  
		  		  driver.close();
		  		  }
		  		
		  		
		  		
////Test ID: 16-21
///* 
//* Verify that user is not able to add DR-Link packetizer when no coupler is given     
//*/
		  		@Test (priority = 39)
		  		public void AddDR_LinkPacketizerinSystemwithNoCoupler() throws InterruptedException {
		  		  
		  		  System.setProperty("webdriver.gecko.driver", driverPath);
		  		  driver = new FirefoxDriver();
		  		  driver.get(baseUrl);
		  		
		  		  // Signing in OmniPCX 
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  		  
		  		  // Click On Packetizer Settings
		  		  Thread.sleep(7000);
		  		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
		  		    
		  		  // Click on Add Packetizer
		  		  Thread.sleep(5000);
		  		  driver.findElement(By.id("linkAddPacketizers")).click();
		  		  
//		  		  // Select Connection Type
//		  		  driver.findElement(By.id("RecorderTypeExtension")).click();
		  		  
		  		  // Select Node
		  		  Thread.sleep(5000);
		  		  Select dropdownNode = new Select(driver.findElement(By.id("ddlNodes")));
		  	   	  dropdownNode.selectByVisibleText("DdNode"); 
		  		  
		  		  // add PCM II Physical Address * (Crystal - Coupler)
		  		  driver.findElement(By.id("tbCrystal")).sendKeys("56");
//		  		  driver.findElement(By.id("tbCoupler")).sendKeys("78");
		  		  
		  		  // add Packetizer IP *
		  		  driver.findElement(By.id("tbPacketizerIp")).sendKeys("116.67.141.203");
		  		  
		  		  // add Packetizer Port *
		  		  driver.findElement(By.id("tbPacketizerPort")).sendKeys("1122");
		  		  
		  		  // Click on Save button
		  		  driver.findElement(By.id("btnSave")).click();
		  		  
		  		  String expected = "Please enter Coupler";
		  		  // Get label msg
		  		  String actual = driver.findElement(By.id("lblMessage")).getText();

		  		  Assert.assertEquals(actual, expected);
		  		  
		  		  driver.close();
		  		  }
		  		
		  		
		  		
////Test ID: 16-22
///* 
//* Verify that user is not able to add DR-Link packetizer with Empty Packetizer IP field      
//*/	
		  		@Test (priority = 40)
		  		public void AddDR_LinkPacketizerinSystemwithNoPacketizerIP() throws InterruptedException {
		  		  
		  		  System.setProperty("webdriver.gecko.driver", driverPath);
		  		  driver = new FirefoxDriver();
		  		  driver.get(baseUrl);
		  		
		  		  // Signing in OmniPCX 
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  		  
		  		  // Click On Packetizer Settings
		  		  Thread.sleep(7000);
		  		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
		  		    
		  		  // Click on Add Packetizer
		  		  Thread.sleep(5000);
		  		  driver.findElement(By.id("linkAddPacketizers")).click();
		  		  
		  		  // Select Node
		  		  Thread.sleep(5000);
		  		  Select dropdownNode = new Select(driver.findElement(By.id("ddlNodes")));
		  	   	  dropdownNode.selectByVisibleText("DdNode"); 
		  		  
		  		  // add PCM II Physical Address * (Crystal - Coupler)
		  		  driver.findElement(By.id("tbCrystal")).sendKeys("56");
		  		  driver.findElement(By.id("tbCoupler")).sendKeys("78");
		  		  
		  		  // add Packetizer IP *
//		  		  driver.findElement(By.id("tbPacketizerIp")).sendKeys("116.67.141.203");
		  		  
		  		  // add Packetizer Port *
		  		  driver.findElement(By.id("tbPacketizerPort")).sendKeys("1122");
		  		  
		  		  // Click on Save button
		  		  driver.findElement(By.id("btnSave")).click();
		  		  
		  		  String expected = "Please enter Packetizer IP";
		  		  // Get label msg
		  		  String actual = driver.findElement(By.id("lblMessage")).getText();

		  		  Assert.assertEquals(actual, expected);
		  		  
		  		  driver.close();
		  		  }
		  		
		  		
		  		
////Test ID: 16-23
///* 
//* Verify that user is not able to add DR-Link packetizer with Invalid Packetizer IP field       
//*/	
		  		@Test (priority = 41)
		  		public void AddDR_LinkPacketizerinSystemwithInvalidIP() throws InterruptedException {
		  		  
		  		  System.setProperty("webdriver.gecko.driver", driverPath);
		  		  driver = new FirefoxDriver();
		  		  driver.get(baseUrl);
		  		
		  		  // Signing in OmniPCX 
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  		  
		  		  // Click On Packetizer Settings
		  		  Thread.sleep(7000);
		  		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
		  		    
		  		  // Click on Add Packetizer
		  		  Thread.sleep(5000);
		  		  driver.findElement(By.id("linkAddPacketizers")).click();
		  		  
		  		  // Select Node
		  		  Thread.sleep(5000);
		  		  Select dropdownNode = new Select(driver.findElement(By.id("ddlNodes")));
		  	   	  dropdownNode.selectByVisibleText("DdNode"); 
		  		  
		  		  // add PCM II Physical Address * (Crystal - Coupler)
		  		  driver.findElement(By.id("tbCrystal")).sendKeys("56");
		  		  driver.findElement(By.id("tbCoupler")).sendKeys("78");
		  		  
		  		  // add Packetizer IP *
		  		  driver.findElement(By.id("tbPacketizerIp")).sendKeys("12345");
		  		  
		  		  // add Packetizer Port *
		  		  driver.findElement(By.id("tbPacketizerPort")).sendKeys("1122");
		  		  
		  		  // Click on Save button
		  		  driver.findElement(By.id("btnSave")).click();
		  		  
		  		  String expected = "Invalid Packetizer IP";
		  		  // Get label msg
		  		  String actual = driver.findElement(By.id("lblMessage")).getText();

		  		  Assert.assertEquals(actual, expected);
		  		  
		  		  driver.close();
		  		  }
		  		
		  		
		  		
////Test ID: 16-24
///* 
//* Verify that user is not able to add DR-Link packetizer with Empty Packetizer Port field        
//*/	
		  		@Test (priority = 42)
		  		public void AddDR_LinkPacketizerinSystemwithNoPort() throws InterruptedException {
		  		  
		  		  System.setProperty("webdriver.gecko.driver", driverPath);
		  		  driver = new FirefoxDriver();
		  		  driver.get(baseUrl);
		  		
		  		  // Signing in OmniPCX 
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  		  
		  		  // Click On Packetizer Settings
		  		  Thread.sleep(7000);
		  		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
		  		    
		  		  // Click on Add Packetizer
		  		  Thread.sleep(5000);
		  		  driver.findElement(By.id("linkAddPacketizers")).click();
		  		  
		  		  // Select Node
		  		  Thread.sleep(5000);
		  		  Select dropdownNode = new Select(driver.findElement(By.id("ddlNodes")));
		  	   	  dropdownNode.selectByVisibleText("DdNode"); 
		  		  
		  		  // add PCM II Physical Address * (Crystal - Coupler)
		  		  driver.findElement(By.id("tbCrystal")).sendKeys("56");
		  		  driver.findElement(By.id("tbCoupler")).sendKeys("78");
		  		  
		  		  // add Packetizer IP *
		  		  driver.findElement(By.id("tbPacketizerIp")).sendKeys("116.67.141.203");
		  		  
		  		  // add Packetizer Port *
//		  		  driver.findElement(By.id("tbPacketizerPort")).sendKeys("1122");
		  		  
		  		  // Click on Save button
		  		  driver.findElement(By.id("btnSave")).click();
		  		  
		  		  String expected = "Please enter Packetizer Port";
		  		  // Get label msg
		  		  String actual = driver.findElement(By.id("lblMessage")).getText();

		  		  Assert.assertEquals(actual, expected);
		  		  
		  		  driver.close();
		  		  }
		  		
		  		
		  		
////Test ID: 16-25
///* 
//* Verify that user is not able to add DR-Link Packetizers with duplicate IP with same node        
//*/		
		  		@Test (priority = 43)
		  		public void AddDR_LinkPacketizerinSystemwithDuplicateIP() throws InterruptedException {
		  		  
		  		  System.setProperty("webdriver.gecko.driver", driverPath);
		  		  driver = new FirefoxDriver();
		  		  driver.get(baseUrl);
		  		
		  		  // Signing in OmniPCX 
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  		  
		  		  // Click On Packetizer Settings
		  		  Thread.sleep(7000);
		  		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
		  		    
		  		  // Click on Add Packetizer
		  		  Thread.sleep(5000);
		  		  driver.findElement(By.id("linkAddPacketizers")).click();
		  		  
		  		  // Select Node
		  		  Thread.sleep(5000);
		  		  Select dropdownNode = new Select(driver.findElement(By.id("ddlNodes")));
		  	   	  dropdownNode.selectByVisibleText("DdNode"); 
		  		  
		  		  // add PCM II Physical Address * (Crystal - Coupler)
		  		  driver.findElement(By.id("tbCrystal")).sendKeys("34");
		  		  driver.findElement(By.id("tbCoupler")).sendKeys("60");
		  		  
		  		  // add Packetizer IP *
		  		  driver.findElement(By.id("tbPacketizerIp")).sendKeys("209.54.83.64");
		  		  
		  		  // add Packetizer Port *
		  		  driver.findElement(By.id("tbPacketizerPort")).sendKeys("1122");
		  		  
		  		  // Click on Save button
		  		  driver.findElement(By.id("btnSave")).click();
		  		  Thread.sleep(5000);
		  		  
		  		  String expected = "Packetizer IP already exists";
		  		  // Get label msg
		  		  String actual = driver.findElement(By.id("lblMessage")).getText();

		  		  Assert.assertEquals(actual, expected);
		  		  
		  		  driver.close();
		  		  }
		  		
		  		
		  		
////Test ID: 16-26
///* 
//* Verify that user is not able to add DR-Link Packetizers with duplicate IP with different node         
//*/
		  		@Test (priority = 44)
		  		public void AddDR_LinkPacketizerinSystemwithDuplicateIPDiffNode() throws InterruptedException {
		  		  
		  		  System.setProperty("webdriver.gecko.driver", driverPath);
		  		  driver = new FirefoxDriver();
		  		  driver.get(baseUrl);
		  		
		  		  // Signing in OmniPCX 
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  		  
		  		  // Click On Packetizer Settings
		  		  Thread.sleep(7000);
		  		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
		  		    
		  		  // Click on Add Packetizer
		  		  Thread.sleep(5000);
		  		  driver.findElement(By.id("linkAddPacketizers")).click();
		  		  
		  		  // Select Node
		  		  Thread.sleep(5000);
		  		  Select dropdownNode = new Select(driver.findElement(By.id("ddlNodes")));
		  	   	  dropdownNode.selectByVisibleText("MultiNode1"); 
		  		  
		  		  // add PCM II Physical Address * (Crystal - Coupler)
		  		  driver.findElement(By.id("tbCrystal")).sendKeys("34");
		  		  driver.findElement(By.id("tbCoupler")).sendKeys("60");
		  		  
		  		  // add Packetizer IP *
		  		  driver.findElement(By.id("tbPacketizerIp")).sendKeys("209.54.83.64");
		  		  
		  		  // add Packetizer Port *
		  		  driver.findElement(By.id("tbPacketizerPort")).sendKeys("1122");
		  		  
		  		  // Click on Save button
		  		  driver.findElement(By.id("btnSave")).click();
		  		  Thread.sleep(5000);
		  		  
		  		  String expected = "Packetizer IP already exists";
		  		  // Get label msg
		  		  String actual = driver.findElement(By.id("lblMessage")).getText();

		  		  Assert.assertEquals(actual, expected);
		  		  
		  		  driver.close();
		  		  }
		  		
		  		
		  		
		  
////Test ID: 16-28
///* 
//* Update DR-Link Packetizer assigned node         
//*/
		  		@Test (priority = 45)
  				public void UpdateDR_LinkPacketizerAssignedNode() throws InterruptedException {
  				  
  				  System.setProperty("webdriver.gecko.driver", driverPath);
  				  driver = new FirefoxDriver();
  				  driver.get(baseUrl);
  				
  				  // Signing in OmniPCX 
  				  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
  				  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
  				  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();			
  				
  				  
  				  // Click On Packetizer Settings
  				  Thread.sleep(7000);
  				  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
  				  
  				    //Get the table and row
  					WebElement table =driver.findElement(By.id("gvPacketizers"));
  					WebElement tbody=table.findElement(By.tagName("tbody"));
  					List<WebElement> rows=tbody.findElements(By.tagName("tr"));
  					String rowNo="";
  					String packetizerip = "150.220.48.68";
  					for(int i=0;i<rows.size();i++)
  					{
  					WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvPacketizers\"]/tbody/tr["+(i+1)+"]"));
  					if(row.getText().trim().contains(packetizerip))
  					{
  					rowNo=Integer.toString(i+1);
  					break;
  					}
  					}
//  					System.out.println(rowNo);
  					driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[7]/div/img[1]")).click();
  				  
  					// Select another node from
  	              Thread.sleep(7000);
  				  Select dropdownNode = new Select(driver.findElement(By.id("ddlNodes")));
  			   	  dropdownNode.selectByVisibleText("MultiNode2");
  			   	  
  			   	  // Click on Update button
  			   	  Thread.sleep(5000);
  			   	  driver.findElement(By.id("btnSave")).click();  
  			   	  
  			   	  JavascriptExecutor jsx = (JavascriptExecutor)driver;
  			   	  jsx.executeScript("window.confirm('Settings have been saved successfully')");
  		  
  		          String expectedAlertnodeUpdated = "Settings have been saved successfully";
  			      Alert confirmation = driver.switchTo().alert();
  			      String actualAlertnodeUpdated = confirmation.getText(); //Get text present on alert Message
  		
  			      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
  			   		Dismissed user prompt dialog: Settings have been updated successfully:*/
  			      driver.switchTo().alert().accept();
  			  
  			      // Click on okay button
  			      Thread.sleep(5000);
  			      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     
  		
  			      Assert.assertEquals(actualAlertnodeUpdated, expectedAlertnodeUpdated);
  			   
  				  driver.close();
  				  }		  		
		  				
		  				

		  		
////Test ID: 16-29
///* 
//* Update DR-Link Packetizer Crystal detail         
//*/
		  		@Test (priority = 46)
  				public void UpdateDR_LinkPacketizerCrystal() throws InterruptedException {
  				  
  				  System.setProperty("webdriver.gecko.driver", driverPath);
  				  driver = new FirefoxDriver();
  				  driver.get(baseUrl);
  				
  				  // Signing in OmniPCX 
  				  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
  				  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
  				  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
  				  
  				  // Click On Packetizer Settings
  				  Thread.sleep(7000);
  				  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
  				  
  				  //Get the table and row
  					WebElement table =driver.findElement(By.id("gvPacketizers"));
  					WebElement tbody=table.findElement(By.tagName("tbody"));
  					List<WebElement> rows=tbody.findElements(By.tagName("tr"));
  					String rowNo="";
  					String packetizerip = "164.153.234.141";
  					for(int i=0;i<rows.size();i++)
  					{
  					WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvPacketizers\"]/tbody/tr["+(i+1)+"]"));
  					//*[@id="gvPacketizers"]/tbody/tr[2]
  					if(row.getText().trim().contains(packetizerip))
  					{
  					rowNo=Integer.toString(i+1);
  					break;
  					}
  					}
//  					System.out.println(rowNo);
  					driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[7]/div/img[1]")).click();

  				  
  				  // Update crystal
  				  Thread.sleep(5000);
  				  driver.findElement(By.id("tbCrystal")).clear();
  				  driver.findElement(By.id("tbCrystal")).sendKeys("90");
  				  
  				  // Click on Update button
  				  Thread.sleep(5000);
  			   	  driver.findElement(By.id("btnSave")).click();  
  			   	  
  			   	  JavascriptExecutor jsx = (JavascriptExecutor)driver;
  			   	  jsx.executeScript("window.confirm('Settings have been saved successfully')");
  		  
  		          String expectedAlertnodeUpdated = "Settings have been saved successfully";
  			      Alert confirmation = driver.switchTo().alert();
  			      String actualAlertnodeUpdated = confirmation.getText(); //Get text present on alert Message
  		
  			      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
  			   		Dismissed user prompt dialog: Settings have been updated successfully:*/
  			      driver.switchTo().alert().accept();
  			  
  			      // Click on okay button
  			      Thread.sleep(5000);
  			      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     
  		
  			      Assert.assertEquals(actualAlertnodeUpdated, expectedAlertnodeUpdated);
  				 
  				  driver.close();
  				  }		  		
		  				
		  				
		  		
////Test ID: 16-30
///* 
//* Update DR-Link Packetizer Coupler detail         
//*/
		  		@Test (priority = 47)
  				public void UpdateDR_LinkPacketizerCoupler() throws InterruptedException {
  				  
  				  System.setProperty("webdriver.gecko.driver", driverPath);
  				  driver = new FirefoxDriver();
  				  driver.get(baseUrl);
  				
  				  // Signing in OmniPCX 
  				  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
  				  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
  				  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
  				  
  				  // Click On Packetizer Settings
  				  Thread.sleep(7000);
  				  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
  				  
  				   //Get the table and row
  					WebElement table =driver.findElement(By.id("gvPacketizers"));
  					WebElement tbody=table.findElement(By.tagName("tbody"));
  					List<WebElement> rows=tbody.findElements(By.tagName("tr"));
  					String rowNo="";
  					String packetizerip = "164.153.234.141";
  					for(int i=0;i<rows.size();i++)
  					{
  					WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvPacketizers\"]/tbody/tr["+(i+1)+"]"));
  					//*[@id="gvPacketizers"]/tbody/tr[2]
  					if(row.getText().trim().contains(packetizerip))
  					{
  					rowNo=Integer.toString(i+1);
  					break;
  					}
  					}
  					driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[7]/div/img[1]")).click();

  				  // Update crystal
  				  Thread.sleep(5000);
  				  driver.findElement(By.id("tbCoupler")).clear();
  				  driver.findElement(By.id("tbCoupler")).sendKeys("90");
  				  
  				  // Click on Update button
  				  Thread.sleep(5000);
  			   	  driver.findElement(By.id("btnSave")).click();  
  			   	  
  			   	  JavascriptExecutor jsx = (JavascriptExecutor)driver;
  			   	  jsx.executeScript("window.confirm('Settings have been saved successfully')");
  		  
  		          String expectedAlertnodeUpdated = "Settings have been saved successfully";
  			      Alert confirmation = driver.switchTo().alert();
  			      String actualAlertnodeUpdated = confirmation.getText(); //Get text present on alert Message
  		
  			      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
  			   		Dismissed user prompt dialog: Settings have been updated successfully:*/
  			      driver.switchTo().alert().accept();
  			  
  			      // Click on okay button
  			      Thread.sleep(5000);
  			      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     
  		
  			      Assert.assertEquals(actualAlertnodeUpdated, expectedAlertnodeUpdated);
  				 
  				  driver.close();
  				  }		  		
		  				
		  				
		  				
////Test ID: 16-31
///* 
//* Update DR-Link Packetizer IP          
//*/
		  @Test (priority = 48)
		  public void UpdateDR_LinkPacketizerIP() throws InterruptedException {
			  System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
			  driver.get(baseUrl);
			
			  // Signing in OmniPCX 
			  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			  // Click On Packetizer Settings
			  Thread.sleep(7000);
			  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();	
			  
			  //Get the table and row
				WebElement table =driver.findElement(By.id("gvPacketizers"));
				WebElement tbody=table.findElement(By.tagName("tbody"));
				List<WebElement> rows=tbody.findElements(By.tagName("tr"));
				String rowNo="";
				String packetizerip = "200.247.210.95";
				for(int i=0;i<rows.size();i++)
				{
				WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvPacketizers\"]/tbody/tr["+(i+1)+"]"));
				//*[@id="gvPacketizers"]/tbody/tr[2]
				if(row.getText().trim().contains(packetizerip))
				{
				rowNo=Integer.toString(i+1);
				break;
				}
				}
//				System.out.println(rowNo);
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[7]/div/img[1]")).click();

			  
			   // Update Packetizer IP
			  Thread.sleep(5000);
			  driver.findElement(By.id("tbPacketizerIp")).clear();
			  driver.findElement(By.id("tbPacketizerIp")).sendKeys("121.12.59.10");
			  
			  // Click on Update button
			  Thread.sleep(5000);
		   	  driver.findElement(By.id("btnSave")).click();  
		   	  
		   	  JavascriptExecutor jsx = (JavascriptExecutor)driver;
		   	  jsx.executeScript("window.confirm('Settings have been saved successfully')");
	  
	          String expectedAlertnodeUpdated = "Settings have been saved successfully";
		      Alert confirmation = driver.switchTo().alert();
		      String actualAlertnodeUpdated = confirmation.getText(); //Get text present on alert Message
	
		      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
		   		Dismissed user prompt dialog: Settings have been updated successfully:*/
		      driver.switchTo().alert().accept();
		  
		      // Click on okay button
		      Thread.sleep(5000);
		      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     
	
		      Assert.assertEquals(actualAlertnodeUpdated, expectedAlertnodeUpdated);
			 
			  driver.close();
			  }		  		
		  		
		  						
		  						  
////Test ID: 16-32
///* 
//* Update DR-Link Packetizer port IP           
//*/
		  @Test (priority = 49)
		  public void UpdateDR_LinkPacketizerPortIP() throws InterruptedException {
			  System.setProperty("webdriver.gecko.driver", driverPath);
				  driver = new FirefoxDriver();
				  driver.get(baseUrl);
				
				  // Signing in OmniPCX 
				  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
				  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
				  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
				  
				  // Click On Packetizer Settings
				  Thread.sleep(7000);
				  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();	
				  
				  //Get the table and row
					WebElement table =driver.findElement(By.id("gvPacketizers"));
					WebElement tbody=table.findElement(By.tagName("tbody"));
					List<WebElement> rows=tbody.findElements(By.tagName("tr"));
					String rowNo="";
					String packetizerip = "209.54.83.64";
					for(int i=0;i<rows.size();i++)
					{
					WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvPacketizers\"]/tbody/tr["+(i+1)+"]"));
					//*[@id="gvPacketizers"]/tbody/tr[2]
					if(row.getText().trim().contains(packetizerip))
					{
					rowNo=Integer.toString(i+1);
					break;
					}
					}
					driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[7]/div/img[1]")).click();

				   // Update Packetizer IP
				  Thread.sleep(5000);
				  driver.findElement(By.id("tbPacketizerPort")).clear();
				  driver.findElement(By.id("tbPacketizerPort")).sendKeys("1210");
				  
				  // Click on Update button
				  Thread.sleep(5000);
			   	  driver.findElement(By.id("btnSave")).click();  
			   	  
			   	  JavascriptExecutor jsx = (JavascriptExecutor)driver;
			   	  jsx.executeScript("window.confirm('Settings have been saved successfully')");
		  
		          String expectedAlertnodeUpdated = "Settings have been saved successfully";
			      Alert confirmation = driver.switchTo().alert();
			      String actualAlertnodeUpdated = confirmation.getText(); //Get text present on alert Message
		
			      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
			   		Dismissed user prompt dialog: Settings have been updated successfully:*/
			      driver.switchTo().alert().accept();
			  
			      // Click on okay button
			      Thread.sleep(5000);
			      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     
		
			      Assert.assertEquals(actualAlertnodeUpdated, expectedAlertnodeUpdated);
				 
				  driver.close();
				  }					
			  					  

////Test ID: 16-33
///* 
//* Delete DR-Link Packetizer from System        
//*/
		  @Test (priority = 50)
		  public void DeleteDR_LinkPacketizerfromSystem() throws InterruptedException {
			  System.setProperty("webdriver.gecko.driver", driverPath);
	  			driver = new FirefoxDriver();
	  			driver.get(baseUrl);
	  									
	  			// Signing in OmniPCX 
	  			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	  			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	  			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	  									  
	  			// Click On Packetizer Settings
	  			Thread.sleep(7000);
	  			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();		
	  			
	  			//Get the table and row
	  			WebElement table =driver.findElement(By.id("gvPacketizers"));
	  			WebElement tbody=table.findElement(By.tagName("tbody"));
	  			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
	  			String rowNo="";
	  			String packetizerip = "209.54.83.64";
	  			for(int i=0;i<rows.size();i++)
	  			{
	  			WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvPacketizers\"]/tbody/tr["+(i+1)+"]"));
	  			//*[@id="gvPacketizers"]/tbody/tr[2]
	  			if(row.getText().trim().contains(packetizerip))
	  			{
	  			rowNo=Integer.toString(i+1);
	  			break;
	  			}
	  			}
	  			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[7]/div/img[2]")).click();
	  			                            
	  		    // Check alert message
	  		    JavascriptExecutor jsd = (JavascriptExecutor)driver;
	  		    jsd.executeScript("window.confirm('Call recordings in progress on this packetizer will be stopped. Are you sure you want to delete?')");  
	  			driver.switchTo().alert().accept();
	  			  
	  		    String expectedAlertBranchUpdated = "Record has been deleted successfully";
	  		    
	  		     // Click on Delete button
	  			  Thread.sleep(4000);
	  			  driver.findElement(By.id("btnDelete")).click(); 
	  			  
	  			  // Get label msg
	  			  Thread.sleep(4000);
	  			  String actualAlertBranchUpdated = driver.findElement(By.id("lblMessage")).getText();
	  		
	  			  Assert.assertEquals(actualAlertBranchUpdated, expectedAlertBranchUpdated);
	  		 
	  			driver.close();
		  }
		  			
		  									  
		  		    
		  					
////Test ID: 16-34
///* 
//* Add Trunk Packetizer in System  
//*/
		  @Test (priority = 51)
		  public void AddTrunkPacketizerinSystem() throws InterruptedException {
			  System.setProperty("webdriver.gecko.driver", driverPath);
  			  driver = new FirefoxDriver();
  			  driver.get(baseUrl);
  			  
  			  // Signing in OmniPCX 
  			  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
  			  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
  			  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
  			  
  			  // Click On Packetizer Settings
  			  Thread.sleep(7000);
  			  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
  			  
  			  // Click on Add Packetizer
  			  Thread.sleep(5000);
  			  driver.findElement(By.id("linkAddPacketizers")).click();
  			  
  			  // Select Connection Type
  			  driver.findElement(By.id("RecorderTypeTrunk")).click();				  
  			  
  			  // add Packetizer IP *
  			  driver.findElement(By.id("tbPacketizerIp")).sendKeys("202.29.112.168");
  			  
  			  // add Packetizer Port *
  			  driver.findElement(By.id("tbPacketizerPort")).sendKeys("3233");
  			  
  			  // Click on Save button
  			  Thread.sleep(5000);
  			  driver.findElement(By.id("btnSave")).click();
  			  
  		      JavascriptExecutor jsx = (JavascriptExecutor)driver;
  		      jsx.executeScript("window.confirm('Settings have been saved successfully')");
  		      
  		      String expectedAlertnodeUpdated = "Settings have been saved successfully";
  		      Alert confirmation = driver.switchTo().alert();
  		      String actualAlertnodeUpdated = confirmation.getText(); //Get text present on alert Message
  		      driver.switchTo().alert().accept();
  		      
  		      // Click on okay button
  		      Thread.sleep(5000);
  		      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();  
  		      
  		      Assert.assertEquals(actualAlertnodeUpdated, expectedAlertnodeUpdated);
  			  
  			  driver.close();	        	      			
		  }
		  			
		  			  
		  			  			
////Test ID: 16-35
///* 
//* Add multiple Trunk Packetizers in System  
//*/
		  @Test (priority = 52)
		  public void AddMultipleTrunkPacketizerinSystem() throws InterruptedException {
			  System.setProperty("webdriver.gecko.driver", driverPath);
  			  driver = new FirefoxDriver();
  			  driver.get(baseUrl);
  			
  			  // Signing in OmniPCX 
  			  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
  			  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
  			  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
  			  
  			  // Click On Packetizer Settings
  			  Thread.sleep(7000);
  			  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
  			  
  			  String[] packetizerip = {"172.207.48.158", "32.146.248.0"};
  			  String[] packetizerport = {"3434", "3535"};
  		      
  			  // Add multiple trunk packetizer (2 packetizer)
  		      for (int i = 0; i < packetizerip.length ; i++) {
  			  
  			  // Click on Add Packetizer
  			  Thread.sleep(5000);
  			  driver.findElement(By.id("linkAddPacketizers")).click();
  			  
  			  // Select Connection Type
  			  driver.findElement(By.id("RecorderTypeTrunk")).click();
  			    
  			  // add Packetizer IP *
  			  driver.findElement(By.id("tbPacketizerIp")).sendKeys(packetizerip[i]);
  			  
  			  // add Packetizer Port *
  			  driver.findElement(By.id("tbPacketizerPort")).sendKeys(packetizerport[i]);
  			  
  			  // Click on Save button
  			  Thread.sleep(5000);
  			  driver.findElement(By.id("btnSave")).click();
  			  
  		      JavascriptExecutor jsx = (JavascriptExecutor)driver;
  		      jsx.executeScript("window.confirm('Settings have been saved successfully')");

  		      String expectedAlertnodeUpdated = "Settings have been saved successfully";
  		      Alert confirmation = driver.switchTo().alert();
  		      String actualAlertnodeUpdated = confirmation.getText(); //Get text present on alert Message
  		      driver.switchTo().alert().accept();
  		  
  		      // Click on okay button
  		      Thread.sleep(5000);
  		      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     

  		      Assert.assertEquals(actualAlertnodeUpdated, expectedAlertnodeUpdated);
  		      }
  			  
  		      driver.close();	        	      
		  }
		 				

		  			
////Test ID: 16-36
///* 
//* Add Trunk Packetizers in System with duplicate IP
//*/
		  @Test (priority = 52)
		  public void AddTrunkPacketizerinSystemduplicateIP() throws InterruptedException {
			  System.setProperty("webdriver.gecko.driver", driverPath);
  			  driver = new FirefoxDriver();
  			  driver.get(baseUrl);
  			  
  			  // Signing in OmniPCX 
  			  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
  			  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
  			  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
  			  
  			  // Click On Packetizer Settings
  			  Thread.sleep(7000);
  			  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
  			  
  			  // Click on Add Packetizer
  			  Thread.sleep(5000);
  			  driver.findElement(By.id("linkAddPacketizers")).click();
  			  
  			  // Select Connection Type
  			  driver.findElement(By.id("RecorderTypeTrunk")).click();				  
  			  
  			  // add Packetizer IP *
  			  driver.findElement(By.id("tbPacketizerIp")).sendKeys("202.29.112.168");
  			  
  			  // add Packetizer Port *
  			  driver.findElement(By.id("tbPacketizerPort")).sendKeys("3233");
  			  
  			  // Click on Save button
  			  Thread.sleep(5000);
  			  driver.findElement(By.id("btnSave")).click();
  			  
  			  Thread.sleep(5000);
  			  String expected = "Packetizer IP already exists";
  			  // Get label msg
  			  String actual = driver.findElement(By.id("lblMessage")).getText();

  			  Assert.assertEquals(actual, expected);
  			  
  			  driver.close();	        	      
  			  }
		  			
		  			  
		  			 		  					  

		  			
////Test ID: 16-37
///* 
//* Add Trunk Packetizers in System with Invalid IP
//*/
		 @Test (priority = 53)
		 public void AddTrunkPacketizerinSystemwithInvalidIP() throws InterruptedException {
			 System.setProperty("webdriver.gecko.driver", driverPath);
 			  driver = new FirefoxDriver();
 			  driver.get(baseUrl);
 			  
 			  // Signing in OmniPCX 
 			  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
 			  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
 			  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
 			  
 			  // Click On Packetizer Settings
 			  Thread.sleep(9000);
 			  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
 			  
 			  // Click on Add Packetizer
 			  Thread.sleep(5000);
 			  driver.findElement(By.id("linkAddPacketizers")).click();
 			  
 			  // Select Connection Type
 			  driver.findElement(By.id("RecorderTypeTrunk")).click();				  
 			  
 			  // add Packetizer IP *
 			  driver.findElement(By.id("tbPacketizerIp")).sendKeys("123456");
 			  
 			  // add Packetizer Port *
 			  driver.findElement(By.id("tbPacketizerPort")).sendKeys("3233");
 			  
 			  // Click on Save button
 			  Thread.sleep(5000);
 			  driver.findElement(By.id("btnSave")).click();
 			  
 			  Thread.sleep(5000);
 			  String expected = "Invalid Packetizer IP";
 			  // Get label msg
 			  String actual = driver.findElement(By.id("lblMessage")).getText();

 			  Assert.assertEquals(actual, expected);
 			  
 			  driver.close();	        	      
 			     
		 }
			 			

		  			
////Test ID: 16-38
///* 
//* Add Trunk Packetizers in System with empty IP
//*/
		 @Test (priority = 54)
		 public void AddTrunkPacketizerinSystemwithEmptyIP() throws InterruptedException {
			 System.setProperty("webdriver.gecko.driver", driverPath);
 			  driver = new FirefoxDriver();
 			  driver.get(baseUrl);
 			  
 			  // Signing in OmniPCX 
 			  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
 			  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
 			  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
 			  
 			  // Click On Packetizer Settings
 			  Thread.sleep(9000);
 			  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
 			  
 			  // Click on Add Packetizer
 			  Thread.sleep(5000);
 			  driver.findElement(By.id("linkAddPacketizers")).click();
 			  
 			  // Select Connection Type
 			  driver.findElement(By.id("RecorderTypeTrunk")).click();				  
 			  
 			  // add Packetizer Port *
 			  driver.findElement(By.id("tbPacketizerPort")).sendKeys("3233");
 			  
 			  // Click on Save button
 			  Thread.sleep(5000);
 			  driver.findElement(By.id("btnSave")).click();
 			  
 			  Thread.sleep(5000);
 			  String expected = "Please enter Packetizer IP";
 			  // Get label msg
 			  String actual = driver.findElement(By.id("lblMessage")).getText();
 		
 			  Assert.assertEquals(actual, expected);
 			  
 			  driver.close();	        	      
		 }
		  			  
		  			  
		  			     			
////Test ID: 16-39
///* 
//* Add Trunk Packetizers in System with empty Packetizer Port
//*/
		 @Test (priority = 55)
	     public void AddTrunkPacketizerinSystemwithEmptyPacketizerPort() throws InterruptedException {
			 System.setProperty("webdriver.gecko.driver", driverPath);
 			  driver = new FirefoxDriver();
 			  driver.get(baseUrl);
 			  
 			  // Signing in OmniPCX 
 			  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
 			  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
 			  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
 			  
 			  // Click On Packetizer Settings
 			  Thread.sleep(9000);
 			  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
 			  
 			  // Click on Add Packetizer
 			  Thread.sleep(5000);
 			  driver.findElement(By.id("linkAddPacketizers")).click();
 			  
 			  // Select Connection Type
 			  driver.findElement(By.id("RecorderTypeTrunk")).click();				  
 			  
 			  // add Packetizer IP *
 			  driver.findElement(By.id("tbPacketizerIp")).sendKeys("233.217.254.115"); 
 			  
 			  // Click on Save button
 			  Thread.sleep(5000);
 			  driver.findElement(By.id("btnSave")).click();
 			  
 			  Thread.sleep(5000);
 			  String expected = "Please enter Packetizer Port"; 
 			  // Get label msg
 			  String actual = driver.findElement(By.id("lblMessage")).getText();
 		
 			  Assert.assertEquals(actual, expected);
 			  
 			  driver.close();	        	      
		 }
		  			
		  			  
		  			
////Test ID: 16-40
///* 
//* Update Trunk packetizer IP
//*/
		 @Test (priority = 56)
		 public void UpdateTrunkPacketizerIP() throws InterruptedException {
			 System.setProperty("webdriver.gecko.driver", driverPath);
 			  driver = new FirefoxDriver();
 			  driver.get(baseUrl);
 			
 			  // Signing in OmniPCX 
 			  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
 			  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
 			  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
 			  
 			  // Click On Packetizer Settings
 			  Thread.sleep(7000);
 			  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
 			  
 			    //Get the table and row
 				WebElement table =driver.findElement(By.id("gvPacketizers"));
 				WebElement tbody=table.findElement(By.tagName("tbody"));
 				List<WebElement> rows=tbody.findElements(By.tagName("tr"));
 				String rowNo="";
 				String packetizerip = "172.207.48.158";
 				for(int i=0;i<rows.size();i++)
 				{
 				WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvPacketizers\"]/tbody/tr["+(i+1)+"]"));
 				if(row.getText().trim().contains(packetizerip))
 				{
 				rowNo=Integer.toString(i+1);
 				break;
 				}
 				}
 				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[7]/div/img[1]")).click();
 				
 				// Add another IP
 		      Thread.sleep(7000);
 		      driver.findElement(By.id("tbPacketizerIp")).clear();
 		      driver.findElement(By.id("tbPacketizerIp")).sendKeys("24.220.40.239"); 
 		   	  
 		   	  // Click on Update button
 		   	  Thread.sleep(5000);
 		   	  driver.findElement(By.id("btnSave")).click();  
 		   	  
 		   	  JavascriptExecutor jsx = (JavascriptExecutor)driver;
 		   	  jsx.executeScript("window.confirm('Settings have been saved successfully')");

 		      String expectedAlertnodeUpdated = "Settings have been saved successfully";
 		      Alert confirmation = driver.switchTo().alert();
 		      String actualAlertnodeUpdated = confirmation.getText(); //Get text present on alert Message
 		      driver.switchTo().alert().accept();
 		  
 		      // Click on okay button
 		      Thread.sleep(5000);
 		      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     

 		      Assert.assertEquals(actualAlertnodeUpdated, expectedAlertnodeUpdated);
 		   
 			  driver.close();	
		 }
		  			  
		  			  
		  			
////Test ID: 16-40
///* 
//* Update Trunk packetizer port
//*/
		@Test (priority = 57)
		public void UpdateTrunkPacketizerPort() throws InterruptedException {
			System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
			  driver.get(baseUrl);
			
			  // Signing in OmniPCX 
			  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			  // Click On Packetizer Settings
			  Thread.sleep(7000);
			  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
			  
			    //Get the table and row
				WebElement table =driver.findElement(By.id("gvPacketizers"));
				WebElement tbody=table.findElement(By.tagName("tbody"));
				List<WebElement> rows=tbody.findElements(By.tagName("tr"));
				String rowNo="";
				String packetizerip = "202.29.112.168";
				for(int i=0;i<rows.size();i++)
				{
				WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvPacketizers\"]/tbody/tr["+(i+1)+"]"));
				//*[@id="gvPacketizers"]/tbody/tr[2]
				if(row.getText().trim().contains(packetizerip))
				{
				rowNo=Integer.toString(i+1);
				break;
				}
				}
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[7]/div/img[1]")).click();
				
				// Add another IP
		      Thread.sleep(7000);
		      driver.findElement(By.id("tbPacketizerPort")).clear();
		      driver.findElement(By.id("tbPacketizerPort")).sendKeys("3232"); 
		   	  
		   	  // Click on Update button
		   	  Thread.sleep(5000);
		   	  driver.findElement(By.id("btnSave")).click();  
		   	  
		   	  JavascriptExecutor jsx = (JavascriptExecutor)driver;
		   	  jsx.executeScript("window.confirm('Settings have been saved successfully')");

		      String expectedAlertnodeUpdated = "Settings have been saved successfully";
		      Alert confirmation = driver.switchTo().alert();
		      String actualAlertnodeUpdated = confirmation.getText(); //Get text present on alert Message
		      driver.switchTo().alert().accept();
		  
		      // Click on okay button
		      Thread.sleep(5000);
		      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     

		      Assert.assertEquals(actualAlertnodeUpdated, expectedAlertnodeUpdated);
		   
			  driver.close();
		}
			  
		  			
		  						
////Test ID: 16-41
///* 
//* Delete Trunk Packetizer from system
//*/		  
		 @Test (priority = 58)
		 public void DeleteTrunkPacketizer() throws InterruptedException {
			 System.setProperty("webdriver.gecko.driver", driverPath);
	  			driver = new FirefoxDriver();
	  			driver.get(baseUrl);
	  									
	  			// Signing in OmniPCX 
	  			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	  			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	  			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	  			
	  			// Click On Packetizer Settings
	  			Thread.sleep(7000);
	  			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();		
	  			
	  			//Get the table and row
	  			WebElement table =driver.findElement(By.id("gvPacketizers"));
	  			WebElement tbody=table.findElement(By.tagName("tbody"));
	  			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
	  			String rowNo="";
	  			String packetizerip = "32.146.248.0";
	  			for(int i=0;i<rows.size();i++)
	  			{
	  			WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvPacketizers\"]/tbody/tr["+(i+1)+"]"));
	  			if(row.getText().trim().contains(packetizerip))
	  			{
	  			rowNo=Integer.toString(i+1);
	  			break;
	  			}
	  			}
	  			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[7]/div/img[2]")).click();
	  			                            
	  		    // Check alert message
	  		    JavascriptExecutor jsd = (JavascriptExecutor)driver;
	  		    jsd.executeScript("window.confirm('Call recordings in progress on this packetizer will be stopped. Are you sure you want to delete?')");  
	  			driver.switchTo().alert().accept();
	  			  
	  		    String expectedAlertBranchUpdated = "Record has been deleted successfully";
	  		    
	  		     // Click on Delete button
	  			  Thread.sleep(4000);
	  			  driver.findElement(By.id("btnDelete")).click(); 
	  			  
	  			  // Get label msg
	  			  Thread.sleep(4000);
	  			  String actualAlertBranchUpdated = driver.findElement(By.id("lblMessage")).getText();
	  		
	  			  Assert.assertEquals(actualAlertBranchUpdated, expectedAlertBranchUpdated);
	  		 
	  			driver.close();
		 }
		  									  
		  		    
		  			  			
		  			
////Test ID: 16-44
///* 
//* Verify user is able to expand and minimize Search Packetizer Settings tab
//*/
	 @Test (priority = 59)
     public void VerifyMinimizeSearchPacketizerSettingsTab() throws InterruptedException {
		 System.setProperty("webdriver.gecko.driver", driverPath);
		 driver = new FirefoxDriver();
		 driver.get(baseUrl);
									
		 // Signing in OmniPCX 
		 driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		 driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		 driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			
		 // Click On Packetizer Settings
		 Thread.sleep(7000);
		 driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();	
			
		 // Minimize packitizer search settings
		 driver.findElement(By.xpath("//*[@id=\"img1\"]")).click();
		 Assert.assertFalse(driver.findElement(By.id("divAgents")).isDisplayed());
			
		// Maximize packitizer search settings
		driver.findElement(By.xpath("//*[@id=\"img1\"]")).click();
		Assert.assertTrue(driver.findElement(By.id("divAgents")).isDisplayed());
			
	    driver.close();	    
}			
		  				
		  			
		  			
		  			
////Test ID: 16-67
///* 
//* Verify that user is not able to delete packetizer when it is assigned to extension 
//*/
	  @Test (priority = 60)
	  public void VerifydeletePacketizerwhenExtension() throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
	          driver = new FirefoxDriver();
	          driver.get(baseUrl);

	          // Signing in OmniPCX 
	          driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	          driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	          driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	          
	          // Click On Nodes
	          Thread.sleep(9000);
	   	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
	   	      
	   	      // Enter a node name
	   	      driver.findElement(By.id("tbNodeName")).sendKeys("PackNodeExt");
	   	      
	   	      // Enter Primary Hostname/IP Address
	   	      driver.findElement(By.id("tbPrimaryIP")).sendKeys("191.108.121.3");  
	   	      
	   	      // Click on save button
	   	      driver.findElement(By.id("btnSave")).click();
	   	      
	   	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
		      jsx.executeScript("window.confirm('After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect')");
			  driver.switchTo().alert().accept();
			  
			  // Click on okay button
			  Thread.sleep(5000);
			  driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click(); 
			      
			  // Click On Packetizer Settings
			  Thread.sleep(7000);
			  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
			  
			  // Click on Add Packetizer
			  Thread.sleep(5000);
			  driver.findElement(By.id("linkAddPacketizers")).click();
			  
			  // Select Node
			  Thread.sleep(10000);
			  Select dropdownNode = new Select(driver.findElement(By.id("ddlNodes")));
		   	  dropdownNode.selectByVisibleText("PackNodeExt"); 
			  
			  // add PCM II Physical Address * (Crystal - Coupler)
			  driver.findElement(By.id("tbCrystal")).sendKeys("3");
			  driver.findElement(By.id("tbCoupler")).sendKeys("5");
			  
			  // add Packetizer IP *
			  driver.findElement(By.id("tbPacketizerIp")).sendKeys("20.56.234.80");
			  
			  // add Packetizer Port *
			  driver.findElement(By.id("tbPacketizerPort")).sendKeys("3887");
			  
			  // Click on Save button
			  driver.findElement(By.id("btnSave")).click();
			  
		      JavascriptExecutor jsd = (JavascriptExecutor)driver;
	          jsd.executeScript("window.confirm('Settings have been saved successfully')");
		      driver.switchTo().alert().accept();
		  
		      // Click on okay button
		      Thread.sleep(5000);
		      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click(); 
		      
		      // Logout of server admin
		      driver.findElement(By.id("ctl00_lblLogOut")).click();
		      
		      // Signing in OmniPCX --> Site Administration
		      driver.get("http://172.20.22.81/OmniPCXRecord/default.aspx");
		      driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		      driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		      
		      // Click on Extensions
		      Thread.sleep(7000);
		      driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink7")).click();
		        
		      // Click Add Extension
		      Thread.sleep(5000);
		      driver.findElement(By.id("linkAddExtensions")).click();
		        
		      // Extension*
		      driver.findElement(By.id("tbExtension")).sendKeys("1568");
		        
		      // Select Recording Interface
		      Select dropdownRI = new Select(driver.findElement(By.id("ddlRecordingInterface")));
			  dropdownRI.selectByVisibleText("DR-Link"); 
		      
			  // Select PBX Node *
			  Thread.sleep(5000);
		      Select dropdownN = new Select(driver.findElement(By.id("ddlNode")));
		      dropdownN.selectByVisibleText("PackNodeExt - 191.108.121.3");
		      
		      // Select packitizer option
		      Thread.sleep(5000);
		      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td/table/tbody/tr[10]/td[1]/div/div/select/option")).click();
		      
		      // Click ">" button
		      Thread.sleep(5000);
		      driver.findElement(By.id("btnMoveToList")).click();
		      
		      // check Enable Recording
		      Thread.sleep(5000);
		      driver.findElement(By.id("cbEnableRecording")).click();
		      
	         // Click add button
		      Thread.sleep(5000);
	         driver.findElement(By.id("imgbtnAddUpdate")).click();
	         Thread.sleep(5000);
	        
	        // Check alert message
			JavascriptExecutor jsy = (JavascriptExecutor)driver;
			jsy.executeScript("window.confirm('Settings have been saved successfully')");
			driver.switchTo().alert().accept();
			
			// Click on okay button
			Thread.sleep(5000);
			driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click(); 
			
			// Logout of site admin
	        Thread.sleep(3000);
	        driver.findElement(By.id("ctl00_lblLogOut")).click();
	        
	        // Go-to Server Admin
	        driver.get(baseUrl);
	        // Signing in OmniPCX 
	        driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	        driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	        driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	        
	        // Click On Packetizer Settings
			Thread.sleep(7000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
						
			    //Get the table and row
				WebElement table =driver.findElement(By.id("gvPacketizers"));
				WebElement tbody=table.findElement(By.tagName("tbody"));
				List<WebElement> rows=tbody.findElements(By.tagName("tr"));
				String rowNo="";
				String packetizerip = "20.56.234.80";
				for(int i=0;i<rows.size();i++)
				{
				WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvPacketizers\"]/tbody/tr["+(i+1)+"]"));
				//*[@id="gvPacketizers"]/tbody/tr[2]
				if(row.getText().trim().contains(packetizerip))
				{
				rowNo=Integer.toString(i+1);
				break;
				}
				}
				Thread.sleep(5000);
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[7]/div/img[2]")).click();
		  	
			JavascriptExecutor jst = (JavascriptExecutor)driver;
			jst.executeScript("window.confirm('Are you sure you want to delete?')");	   
			driver.switchTo().alert().accept();
			   
			// Click on delete button
			Thread.sleep(5000);
			driver.findElement(By.id("btnDelete")).click();
			     
		    Thread.sleep(6000);
			String expected = "Unable to delete Packetizer. This Packetizer is associated with extension(s).";
			// Get label msg
	  	    String actual = driver.findElement(By.id("lblMessage")).getText();

	  	    Assert.assertEquals(actual, expected);
				  
			driver.close();	  
	  }
		  		    	  
		  		    	  
		  			
		  			
		  			
		  			
////Test ID: 16-68
///* 
//* Verify that multiple packetizers are not displayed in packetizer list when user select branch node while adding DR-Link extension for Branch 
//*/
		@Test (priority = 61)
		public void VerifyMultiplePacketizernotDisplayedforBranchExtension() throws InterruptedException {
			 System.setProperty("webdriver.gecko.driver", driverPath);
		          driver = new FirefoxDriver();
		          driver.get(baseUrl);

		          // Signing in OmniPCX 
		          driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		          driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		          driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		          
		          // Click On Nodes
		          Thread.sleep(9000);
		   	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
		   	      
		   	      // Enter a node name
		   	      driver.findElement(By.id("tbNodeName")).sendKeys("BranchNodeExt");
		   	      
		   	      // Enter Primary Hostname/IP Address
		   	      driver.findElement(By.id("tbPrimaryIP")).sendKeys("1.12.30.38");  
		   	      
		   	      // Enter Recorder
		   	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
			   	  dropdownRC.selectByVisibleText("Branch"); 
		   	      
		   	      // Click on save button
		   	      driver.findElement(By.id("btnSave")).click();
		   	      
		   	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
			      jsx.executeScript("window.confirm('After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect')");
				  driver.switchTo().alert().accept();
				  
				  // Click on okay button
				  Thread.sleep(5000);
				  driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click(); 
				      
				  // Click On Packetizer Settings
				  Thread.sleep(7000);
				  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
				  
				  // Click on Add Packetizer
				  Thread.sleep(5000);
				  driver.findElement(By.id("linkAddPacketizers")).click();
				  
				  // Select Node
				  Thread.sleep(10000);
				  Select dropdownNode = new Select(driver.findElement(By.id("ddlNodes")));
			   	  dropdownNode.selectByVisibleText("BranchNodeExt"); 
				  
				  // add PCM II Physical Address * (Crystal - Coupler)
				  driver.findElement(By.id("tbCrystal")).sendKeys("9");
				  driver.findElement(By.id("tbCoupler")).sendKeys("8");
				  
				  // add Packetizer IP *
				  driver.findElement(By.id("tbPacketizerIp")).sendKeys("27.41.76.0");
				  
				  // add Packetizer Port *
				  driver.findElement(By.id("tbPacketizerPort")).sendKeys("6000");
				  
				  // Click on Save button
				  driver.findElement(By.id("btnSave")).click();
				  
			      JavascriptExecutor jsd = (JavascriptExecutor)driver;
		          jsd.executeScript("window.confirm('Settings have been saved successfully')");
			      driver.switchTo().alert().accept();
			  
			      // Click on okay button
			      Thread.sleep(5000);
			      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click(); 
			      
			      // Logout of server admin
			      driver.findElement(By.id("ctl00_lblLogOut")).click();
			      
			      // Signing in OmniPCX --> Site Administration
			      driver.get("http://172.20.22.81/OmniPCXRecord/default.aspx");
			      driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
			      driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
			      driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			      
			      // Click on Extensions
			      Thread.sleep(7000);
			      driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink7")).click();
			        
			      // Click Add Extension
			      Thread.sleep(5000);
			      driver.findElement(By.id("linkAddExtensions")).click();
			        
			      // Extension*
			      driver.findElement(By.id("tbExtension")).sendKeys("1568");
			        
			      // Select Recording Interface
			      Select dropdownRI = new Select(driver.findElement(By.id("ddlRecordingInterface")));
				  dropdownRI.selectByVisibleText("DR-Link"); 
			      
				  // Select PBX Node *
				  Thread.sleep(5000);
			      Select dropdownN = new Select(driver.findElement(By.id("ddlNode")));
			      dropdownN.selectByVisibleText("BranchNodeExt - 1.12.30.38");
			      
			      // Select packitizer option
			      Thread.sleep(5000);
			      Assert.assertFalse(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td/table/tbody/tr[10]/td[1]/div/div/select/option")).isEnabled());
				  
				  driver.close();	  	
		}
		  		    	  
		  		    	 
		  			

////Test ID: 16-75
///* 
//* Verify that user is able to search through Connection Type and Crystal Coupler string on Packetizer Settings page.
//*/
		@Test (priority = 62)
	    public void SearchwithConnectionTypeandCrystalCoupler () throws InterruptedException {
			System.setProperty("webdriver.gecko.driver", driverPath);
  			driver = new FirefoxDriver();
  			driver.get(baseUrl);
  									
  			// Signing in OmniPCX 
  			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
  			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
  			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
  			
  			// Click On Packetizer Settings
  			Thread.sleep(7000);
  			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();	
  			
  			// Click on search --> Crystal Coupler
  			Thread.sleep(3000);
  			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/div[1]/div/label/input")).sendKeys("9-8");
  			
  			String expectedColumnDataCC = "27.41.76.0 6000 9-8 BranchNodeExt DR-Link";
  		    //Following code get's row data from the table and prints it
  			List<WebElement> allColumnsInRow = driver.findElements(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr[1]"));
  				for(WebElement e: allColumnsInRow)
  					{
  						String actualColumnDataCC = e.getText();
  						Assert.assertEquals(actualColumnDataCC, expectedColumnDataCC);
  					}	
  			
  			// Click on search --> Connection Type
  			Thread.sleep(3000);
  			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/div[1]/div/label/input")).clear();
  			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/div[1]/div/label/input")).sendKeys("Trunk");	
  			
  			String expectedColumnDataCT = "24.220.40.239 3434 N/A N/A Trunk";
  		    //Following code get's row data from the table and prints it
  			List<WebElement> allColumnsInRow1 = driver.findElements(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr[1]"));
  				for(WebElement a: allColumnsInRow1)
  					{
  						String actualColumnDataCT = a.getText();
  						Assert.assertEquals(actualColumnDataCT, expectedColumnDataCT);
  					}			
  				driver.close();	  
		}
		  			
		  									  
		  		    	
////Test ID: 16-78
///* 
//* Verify When manual mapping option is unchecked then Channel information should be displayed as "All" for Trunk Packetizer as Trunk Group and Board information will be displayed with all channels.
//*/
		@Test (priority = 63)
		public void ManualMappingUncheckedthenInformationdisplayedAllTrunkPacketizer() throws InterruptedException {
			System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
			  driver.get(baseUrl);
			  
			  // Signing in OmniPCX 
			  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			  // Click On Packetizer Settings
			  Thread.sleep(10000);
			  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
			  
			  // Click on Add Packetizer
			  Thread.sleep(5000);
			  driver.findElement(By.id("linkAddPacketizers")).click();
			  
			  // Select Connection Type
			  driver.findElement(By.id("RecorderTypeTrunk")).click();
			  
			  // Check (Manual mapping) is unchecked
			  Assert.assertFalse(driver.findElement(By.id("cbSelectAll")).isSelected());
			  
		      // Check Trunk Group and Board Association displayed as "All"
		      String exp_node_name = "All";
		      String act_node_name = driver.findElement(By.id("channel_0")).getText();
		      
		      Assert.assertEquals(act_node_name, exp_node_name);
			  
				driver.close();	  

		}
		  			
		  			  
		  			 			
////Test ID: 16-77
///* 
//* Verify when user copy paste alpha character in "PCM II Physical Address and Packetizer Port " input fields
//*/
		@Test (priority = 64)  
		public void  CopyPasteAlphaCharacterinPCMIIandPacketizerPort() throws InterruptedException {
			System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
			  driver.get(baseUrl);

			    // Signing in OmniPCX 
			    driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			    driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			    driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
				  
			    // Click On Packetizer Settings
				Thread.sleep(10000);
				driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
				
				// Click on Add Packetizer
				Thread.sleep(5000);
				driver.findElement(By.id("linkAddPacketizers")).click();
			 	
			    // add PCM II Physical Address * (Crystal - Coupler)
				driver.findElement(By.id("tbCrystal")).sendKeys("a");
				driver.findElement(By.id("tbCoupler")).sendKeys("b");
				  
				// add Packetizer Port *
				driver.findElement(By.id("tbPacketizerPort")).sendKeys("ftftft");
				
				String eCrystal = "";
				String eCoupler = "";
				String eport = "";
				
				// Get text that is added
				String aCrystal = driver.findElement(By.id("tbCrystal")).getAttribute("value");
				String aCoupler = driver.findElement(By.id("tbCoupler")).getAttribute("value");
				String aport = driver.findElement(By.id("tbPacketizerPort")).getAttribute("value");
				
				Assert.assertEquals(eCrystal, aCrystal);
				Assert.assertEquals(aCoupler, eCoupler);
				Assert.assertEquals(aport, eport);
		
				driver.close();	  
				}
		  			
		  			  
		  			
////Test ID: 16-71
///* 
//* Verify that when user updates the main node as branch node then associated packetizers with main node are associated to branch node 
//*/
		@Test (priority = 65)
		public void UpdateNodewithBranchnode() throws InterruptedException {
			System.setProperty("webdriver.gecko.driver", driverPath);
		      driver = new FirefoxDriver();
		      driver.get(baseUrl);
		
		      // Signing in OmniPCX 
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click On Nodes
		      Thread.sleep(12000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
		      
			  // Get the table and row
			  WebElement table =driver.findElement(By.id("NodeTable"));
			  WebElement tbody=table.findElement(By.tagName("tbody"));
			  List<WebElement> rows=tbody.findElements(By.tagName("tr"));
				
			  String rowNo="";
			  String NodeName = "DdNode";
			  for(int i=0;i<rows.size();i++)
				{
				WebElement row = tbody.findElement(By.xpath("//*[@id=\"NodeTable\"]/tbody/tr["+(i+1)+"]"));
				if(row.getText().trim().contains(NodeName))
				{
				rowNo=Integer.toString(i+1);
				break;
				}
				}
			  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[10]/div/img[1]")).click();

			  // Select Recorder
			  Thread.sleep(5000);
			  Select dropdownRC = new Select(driver.findElement(By.id("ddlRecorder")));
		   	  dropdownRC.selectByVisibleText("Branch"); 
		   	  
		   	  // Click update button
		   	  driver.findElement(By.id("btnSave")).click();
		   	  
			  JavascriptExecutor jsx = (JavascriptExecutor)driver;
			  jsx.executeScript("window.confirm('After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect')");
			  driver.switchTo().alert().accept();
			   
			  // Click on okay button
			  Thread.sleep(5000);
			  driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();
			  
			  // Click On Packetizer Settings
			  Thread.sleep(7000);
			  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
			  
		      Assert.assertTrue(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr[2]/td[6]/img")).isDisplayed());  	  
		   	 
		      driver.close();	  
		      }				  
		  				  
		  			
////Test ID: 16-70
///* 
//* Add node in system with all valid data in each field of node 
//*/	
	@Test (priority = 66)
	public void AddaNodewithAllValidData() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
	      driver = new FirefoxDriver();
	      driver.get(baseUrl);
	
	      // Signing in OmniPCX 
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click On Nodes
	      Thread.sleep(7000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
	      
	      // Enter a node name
	      driver.findElement(By.id("tbNodeName")).sendKeys("DetailedNode");
	      
	      // Enter Primary Hostname/IP Address
	      driver.findElement(By.id("tbPrimaryIP")).sendKeys("74.190.9.55");
	      
	      // Enter Secondary Hostname/IP Address
	      driver.findElement(By.id("tbSecondaryIP")).sendKeys("15.131.167.14");
	      
	      // Enter PCS Hostname/IP Address
	      driver.findElement(By.id("tbPCSIP")).sendKeys("43.232.246.93");
	      
	      // Check & enter IPDR Logger Address
	      driver.findElement(By.id("cbIPLogger")).click();
	      driver.findElement(By.id("tbIPLogger")).sendKeys("98.168.13.117");
	      
	      // Check & enter Remote Recorder for Network DR-Link
	      driver.findElement(By.id("cbRemoteRecorder")).click();
	      Thread.sleep(3000);
	      Select dropdownRC = new Select(driver.findElement(By.id("ddlRemoteRecorder")));
	      dropdownRC.selectByVisibleText("PackNodeExt"); 
	      
	      // Enter Description
	      driver.findElement(By.id("tbDescription")).sendKeys("Just a node with all valid data.");
	      
	      // Click on save button
	      driver.findElement(By.id("btnSave")).click();
	      
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect')");
	
	      String expectedAlertnodeUpdated = "After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect";
	      Alert confirmation = driver.switchTo().alert();
	      String actualAlertnodeUpdated = confirmation.getText(); //Get text present on alert Message
	
	      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
	   		Dismissed user prompt dialog: Settings have been updated successfully:*/
	      driver.switchTo().alert().accept();
	  
	      // Click on okay button
	      Thread.sleep(5000);
	      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     
	
	      Assert.assertEquals(actualAlertnodeUpdated, expectedAlertnodeUpdated);
	  
	      driver.close();	  
	      
  }	
		  				  
		  				  	  			 
		  			 
////Test ID: 16-72
///* 
//* Update PCS Hostname/IP against a node
//*/
		 @Test (priority = 67)
		 public void UpdatePCSHostnameIP() throws InterruptedException {
			 System.setProperty("webdriver.gecko.driver", driverPath);
			  	  driver = new FirefoxDriver();
			  	  driver.get(baseUrl);   
			  	    
			  	  // Signing in OmniPCX 
			  	  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			  	  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			  	  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			  	  // Click On Nodes
			  	  Thread.sleep(9000);
			  	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
			
				//Get the table and row
				WebElement table =driver.findElement(By.id("NodeTable"));
				WebElement tbody=table.findElement(By.tagName("tbody"));
				List<WebElement> rows=tbody.findElements(By.tagName("tr"));
				String rowNo="";
				String NodeName = "BbNode";
				for(int i=0;i<rows.size();i++)
				{
				WebElement row = tbody.findElement(By.xpath("//*[@id=\"NodeTable\"]/tbody/tr["+(i+1)+"]"));
				if(row.getText().trim().contains(NodeName))
				{
				rowNo=Integer.toString(i+1);
				break;
				}
				}
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[10]/div/img[1]")).click();
				
				// Edit node name
				Thread.sleep(7000);
				driver.findElement(By.id("tbPCSIP")).clear();
			  	driver.findElement(By.id("tbPCSIP")).sendKeys("100.13.121.255");
			  	
			  	// Click On save button
			  	driver.findElement(By.id("btnSave")).click();
			  	Thread.sleep(5000);
			  	
			  	JavascriptExecutor jsx = (JavascriptExecutor)driver;
				jsx.executeScript("window.confirm('After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect')");
				String expectedAlertnodeUpdated = "After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect";
				Alert confirmation = driver.switchTo().alert();
				String actualAlertnodeUpdated = confirmation.getText(); //Get text present on alert Message
				driver.switchTo().alert().accept();
				   
				// Click on okay button
				Thread.sleep(5000);
				driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     
			
				Assert.assertEquals(actualAlertnodeUpdated, expectedAlertnodeUpdated);
					  
				driver.close();	  
		 }
		  				  
		  			 

		  			 
////Test ID: 16-15
///* 
//* when user updates IP of a node then associated packetizer node is unassigned from packetizer.
//*/
		 @Test (priority = 68)
		 public void UpdateNodeIPthenAssociatedPacketizerNodeisUnassigned() throws InterruptedException {
			 System.setProperty("webdriver.gecko.driver", driverPath);
			  	  driver = new FirefoxDriver();
			  	  driver.get(baseUrl);   
			  	    
			  	  // Signing in OmniPCX 
			  	  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			  	  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			  	  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			  	  // Click On Nodes
			  	  Thread.sleep(9000);
			  	  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
			
				//Get the table and row
				WebElement table =driver.findElement(By.id("NodeTable"));
				WebElement tbody=table.findElement(By.tagName("tbody"));
				List<WebElement> rows=tbody.findElements(By.tagName("tr"));
				//ArrayList<String> ListOdIds=new ArrayList<>();
				String rowNo="";
				String NodeName = "MultiNode2";
				for(int i=0;i<rows.size();i++)
				{
				WebElement row = tbody.findElement(By.xpath("//*[@id=\"NodeTable\"]/tbody/tr["+(i+1)+"]"));
				if(row.getText().trim().contains(NodeName))
				{
				rowNo=Integer.toString(i+1);
				break;
				}
				}
				System.out.println(rowNo);
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[10]/div/img[1]")).click();
				
				// Edit node ip
				driver.findElement(By.id("tbPrimaryIP")).clear();
			  	driver.findElement(By.id("tbPrimaryIP")).sendKeys("112.1.224.212");
			  	
			  	// Click On save button
			  	driver.findElement(By.id("btnSave")).click();
			  	
			  	JavascriptExecutor jsx = (JavascriptExecutor)driver;
				jsx.executeScript("window.confirm('After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect')");
				driver.switchTo().alert().accept();
				   
				// Click on okay button
				Thread.sleep(5000);
				driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click(); 
			  	
				// Click On Packetizer Settings
				Thread.sleep(12000);
				driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
				
				// Click on search --> Crystal Coupler
				Thread.sleep(5000);
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/div[1]/div/label/input")).sendKeys("MultiNode2");
				
				String expectedColumnDataCC = "150.220.48.68 3030 30-40 MultiNode2 DR-Link";
			    //Following code get's row data from the table and prints it
				List<WebElement> allColumnsInRow = driver.findElements(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr[1]"));
					for(WebElement e: allColumnsInRow)
						{
							String actualColumnDataCC = e.getText();
							Assert.assertEquals(actualColumnDataCC, expectedColumnDataCC);
						}	

		   driver.close();	  		 				  
		 }
		  				 
		  			 				  			 
		  			 
////Test ID: 16-27
///* 
//* Verify that search criteria for packetizer settings are working         
//*/	
//		 @Test (priority = 69)
//		 public void SearchCriteriaforPacketizerSetting() throws InterruptedException {
//			 System.setProperty("webdriver.gecko.driver", driverPath);
//			 driver = new FirefoxDriver();
//			 driver.get(baseUrl);
//			 
//			  // Signing in OmniPCX 
//			  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//			  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
//			  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();	  
//			  
//			  // Click On Nodes
//	          Thread.sleep(7000);
//	   	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
//			  String expectedColumnData2 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr[1]/td[2]")).getText();// DdNode
//			  String expectedColumnData3 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr[1]/td[3]")).getText(); //85.85.28.114"
//			  
//			  // Click On Packetizer Settings
//			  Thread.sleep(7000);
//			  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
//			  
//			  // Select Field Name
//			  Thread.sleep(5000);
//			  Select dropdownNode = new Select(driver.findElement(By.id("ddlFieldName")));
//		   	  dropdownNode.selectByVisibleText("Packetizer IP"); 
//		   	  
//		   	  // Click on find and enter value to search by Packetizer IP
//			  Thread.sleep(7000);
//			  driver.findElement(By.id("tbFind")).clear();
//			  driver.findElement(By.id("tbFind")).sendKeys("209.54.83.64");
//			  
//			  // Click find button
//			  driver.findElement(By.id("btnFind")).click();
//			  
//			  String expectedColumnData ="209.54.83.64";
//			  
//			  Thread.sleep(4000);
//	    	    //Following code get's row data from the table and prints it
////	    	    System.out.println("table data for the following row");
//	          List<WebElement> allColumnsInRow=driver.findElements(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr/td[1]"));
//	            for(WebElement e: allColumnsInRow)
//	            	{
//	             		System.out.println(e.getText());
//	            		String actualColumnData = e.getText();
//	            		Assert.assertEquals(actualColumnData, expectedColumnData);
//	            	}
//	            
//	              Thread.sleep(5000);
//	              // Select Field Name
//				  Select dropdownNode1 = new Select(driver.findElement(By.id("ddlFieldName")));
//			   	  dropdownNode1.selectByVisibleText("Packetizer Port"); 
//			   	  
//			   // Click on find and enter value to search by Packetizer Port
//				  Thread.sleep(7000);
//				  driver.findElement(By.id("tbFind")).clear();
//				  driver.findElement(By.id("tbFind")).sendKeys("1082");
//				  
//				  // Click find button
//				  driver.findElement(By.id("btnFind")).click();
//				  
//				  String expectedColumnData1 ="1082";
//				  Thread.sleep(4000);
//		    	    //Following code get's row data from the table and prints it
////		    	    System.out.println("table data for the following row");
//		          List<WebElement> allColumnsInRow1=driver.findElements(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr/td[2]"));
//		            for(WebElement e1: allColumnsInRow1)
//		            	{
//		             		System.out.println(e1.getText());
//		            		String actualColumnData1 = e1.getText();
//		            		Assert.assertEquals(actualColumnData1, expectedColumnData1);
//		            	}
//		            
//		            Thread.sleep(5000);
//		            // Select Field Name
//					Select dropdownNode2 = new Select(driver.findElement(By.id("ddlFieldName")));
//				   	dropdownNode2.selectByVisibleText("Node"); 
//				   	  
//				   	// Click on find and enter value to search by Node
//					Thread.sleep(7000);
//					driver.findElement(By.id("tbFind")).clear();
//					driver.findElement(By.id("tbFind")).sendKeys(expectedColumnData2);
//					  
//					// Click find button
//					driver.findElement(By.id("btnFind")).click();
//					  
//					Thread.sleep(4000);
//			    	//Following code get's row data from the table and prints it
////			    	System.out.println("table data for the following row");
//			        List<WebElement> allColumnsInRow2=driver.findElements(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr/td[4]"));
//			           for(WebElement e2: allColumnsInRow2)
//			            {
//			               System.out.println(e2.getText());
//			               String actualColumnData2 = e2.getText();
//			               Assert.assertEquals(actualColumnData2, expectedColumnData2);
//			            }
//			           
//			           Thread.sleep(5000);
//			            // Select Field Name
//						Select dropdownNode3 = new Select(driver.findElement(By.id("ddlFieldName")));
//					   	dropdownNode3.selectByVisibleText("PBX IP"); 
//					   	  
//					   	// Click on find and enter value to search by PBX IP
//						Thread.sleep(7000);
//						driver.findElement(By.id("tbFind")).clear();
//						driver.findElement(By.id("tbFind")).sendKeys(expectedColumnData3);
//						  
//						// Click find button
//						driver.findElement(By.id("btnFind")).click();
//						
//						Thread.sleep(4000);
//						
//						Assert.assertTrue(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr/td[4]")).isDisplayed());			
//									  			  
//			  driver.close();
//			  }		  			 		  	
				  
			
	  
////Test ID: 16-04
///* 
//* Add node with remote logger
//*/
		 @Test (priority = 70)
	     public void AddNodewithRemoteLogger() throws InterruptedException { 
	        	  System.setProperty("webdriver.gecko.driver", driverPath);
	              driver = new FirefoxDriver();
	              driver.get(baseUrl);

	              // Signing in OmniPCX 
	              driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	              driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	              driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	              
	              // Click On Nodes
	              Thread.sleep(20000);
	       	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
	       	      
	       	      // Enter a node name
	       	      driver.findElement(By.id("tbNodeName")).sendKeys("RemoteRecorderNode");
	       	      
	       	      // Enter Primary Hostname/IP Address
	       	      driver.findElement(By.id("tbPrimaryIP")).sendKeys("152.5.237.147"); 
	       	      
	       	      // Check Remote Recorder for Network DR-Link
	       	      driver.findElement(By.id("cbRemoteRecorder")).click();
	       	      
	       	      // Enter Remote Recorder for Network DR-Link Node
	       	      Select dropdownRR = new Select(driver.findElement(By.id("ddlRemoteRecorder")));
	       	      dropdownRR.selectByVisibleText("AaNode"); 
	       	      
	       	     Thread.sleep(5000);
	       	      // Click on save button
	       	      driver.findElement(By.id("btnSave")).click();
	       	      
	       	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	    	      jsx.executeScript("window.confirm('After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect')");
	          
	    	      String expectedAlertnodeUpdated = "After any update on this page, OmniPCX RECORD Server needs to be restarted for the new changes to take effect";
	   		      Alert confirmation = driver.switchTo().alert();
	   		      String actualAlertnodeUpdated = confirmation.getText(); //Get text present on alert Message

	   		      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
	   		   		Dismissed user prompt dialog: Settings have been updated successfully:*/
	   		      driver.switchTo().alert().accept();
	   		  
	   		      // Click on okay button
	   		      Thread.sleep(5000);
	   		      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();     

	   		      Assert.assertEquals(actualAlertnodeUpdated, expectedAlertnodeUpdated);
	    		  
	   		      driver.close();	  
	          }			     
	  

		 @AfterClass
		 public void tearDown() throws Exception {
			        driver.quit();	}
	
} 	  
	
  


	
	

          

