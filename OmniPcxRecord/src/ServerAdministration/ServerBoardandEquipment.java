/* 
@author: sarah.mahmood 
Created on June 10, 2021
*/
package ServerAdministration;

import java.util.List;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ServerBoardandEquipment {
	
    public String baseUrl = "http://172.20.22.81/OmniPCXRecord/TenantAdmin.aspx";
	
    String driverPath = "C:\\Users\\sarah.mahmood\\Downloads\\gecko-driver\\geckodriver.exe";
	
	public WebDriver driver;

	    
	
////Test ID: 44-27
///* 
//* Add Trunk Group in system with valid data
//*/	   
	    @Test (priority = 0)
	    public void AddTrunkGroupwithValidData() throws InterruptedException {
	    	
	    	System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
			  driver.get(baseUrl);
			
			  // Signing in OmniPCX 
			  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			  // Click On Trunk Group
			  Thread.sleep(12000);
			  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink7")).click();
			  
			  // Click on Name*
			  Thread.sleep(5000);
			  driver.findElement(By.id("tbTrunkGroup")).sendKeys("Acrid");
			  
			  // Select Node
			  Thread.sleep(5000);
			  Select dropdownNode = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/select")));
		   	  dropdownNode.selectByVisibleText("AaNode"); 
			  
			  // Click on Save button
			  Thread.sleep(5000);
			  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input[1]")).click();

			  Thread.sleep(6000);
			  String expected = "Settings have been saved successfully";
			  // Get label msg
		  	  String actual = driver.findElement(By.id("lblMessage")).getText();

		  	  Assert.assertEquals(actual, expected);
	       	       
	       	  driver.close();	  
	      }	 
	    
	    
	    
////Test ID: 44-28
///* 
//* Add Trunk Group in system with Duplicate Trunk Group Name with different OXE(node)
//*/
	  	    @Test (priority = 1)
	  	    public void AddDuplicateTrunkGroupNamewithDifferentOXE() throws InterruptedException {
	  	    	
	  	    	System.setProperty("webdriver.gecko.driver", driverPath);
	  			  driver = new FirefoxDriver();
	  			  driver.get(baseUrl);
	  			
	  			  // Signing in OmniPCX 
	  			  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	  			  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	  			  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	  			  
	  			  // Click On Trunk Group
	  			  Thread.sleep(7000);
	  			  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink7")).click();
	  			  
	  			  // Click on Name*
	  			  Thread.sleep(5000);
	  			  driver.findElement(By.id("tbTrunkGroup")).sendKeys("Acrid");
	  			  
	  			  // Select Node
	  			  Thread.sleep(5000);
	  			  Select dropdownNode = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/select")));
	  		   	  dropdownNode.selectByVisibleText("DdNode"); 
	  			  
	  			  // Click on Save button
	  			  Thread.sleep(5000);
	  			  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input[1]")).click();

	  			  Thread.sleep(6000);
	  			  String expected = "Settings have been saved successfully";
	  			  // Get label msg
	  		  	  String actual = driver.findElement(By.id("lblMessage")).getText();

	  		  	  Assert.assertEquals(actual, expected);
	  	       	       
	  	       	  driver.close();	  
	  	      }	 

	  	    
	  	    
	  	    
////Test ID: 44-29
///* 
//* Add Trunk Group in system with Duplicate Trunk Group Name with same OXE(node)
//*/
	  	@Test (priority = 2)
	    public void AddDuplicateTrunkGroupNamewithSameOXE() throws InterruptedException {
	  		System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
			  driver.get(baseUrl);
			
			  // Signing in OmniPCX 
			  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			  // Click On Trunk Group
			  Thread.sleep(7000);
			  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink7")).click();
			  
			  // Click on Name*
			  Thread.sleep(5000);
			  driver.findElement(By.id("tbTrunkGroup")).sendKeys("Acrid");
			  
			  // Select Node
			  Thread.sleep(5000);
			  Select dropdownNode = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/select")));
		   	  dropdownNode.selectByVisibleText("AaNode"); 
			  
			  // Click on Save button
			  Thread.sleep(5000);
			  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input[1]")).click();

			  Thread.sleep(6000);
			  String expected = "Name already exists";
			  // Get label msg
		  	  String actual = driver.findElement(By.id("lblMessage")).getText();

		  	  Assert.assertEquals(actual, expected);
	       	       
	       	  driver.close();	  
	      }	 
	  	
	  		    	
	  		    
////Test ID: 44-30
///* 
//* Add Trunk Group in system with Empty/Null Trunk Group Name
//*/
	    @Test (priority = 3)
	    public void AddTrunkGroupwithEmptyName() throws InterruptedException {
	    	System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
			  driver.get(baseUrl);
			
			  // Signing in OmniPCX 
			  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			  // Click On Trunk Group
			  Thread.sleep(7000);
			  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink7")).click();
			  
			  // Select Node
			  Thread.sleep(5000);
			  Select dropdownNode = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/select")));
		   	  dropdownNode.selectByVisibleText("AaNode"); 
			  
			  // Click on Save button
			  Thread.sleep(5000);
			  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input[1]")).click();

			  Thread.sleep(6000);
			  String expected = "Please provide Name";
			  // Get label msg
		  	  String actual = driver.findElement(By.id("lblMessage")).getText();

		  	  Assert.assertEquals(actual, expected);
	       	       
	       	  driver.close();	    	  		    	  			
	  		}
	    

	    
////Test ID: 44-32
///* 
//* Update Trunk Group Name
//*/
	    @Test (priority = 4)
  	    public void UpdateTrunkGroupName() throws InterruptedException {
	    	System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver();
			driver.get(baseUrl);
			
		    // Signing in OmniPCX 
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			// Click On Trunk Group
			Thread.sleep(12000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink7")).click();	   
  			  
  			//Get the table and row
  			WebElement table =driver.findElement(By.id("gvTrunkGroups"));
  			WebElement tbody=table.findElement(By.tagName("tbody"));
  			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
  			String rowNo="";
  			String NodeName = "DdNode";
  			for(int i=0;i<rows.size();i++)
  			{
  			WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvTrunkGroups\"]/tbody/tr["+(i+1)+"]"));
  			if(row.getText().trim().contains(NodeName))
  			{
  			rowNo=Integer.toString(i+1);
  			break;
  			}
  			}
  			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[4]/div/img[1]")).click();
  			
			// Click on Name*
			Thread.sleep(5000);
			driver.findElement(By.id("tbTrunkGroup")).clear();
			driver.findElement(By.id("tbTrunkGroup")).sendKeys("Babble");
			
			// Click on Save button
			Thread.sleep(5000);
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input[1]")).click();

			Thread.sleep(6000);
			String expected = "Settings have been updated successfully";
			// Get label msg
		  	String actual = driver.findElement(By.id("lblMessage")).getText();

		  	Assert.assertEquals(actual, expected);                            
	   
  			driver.close();	    	  		    	  			
  		}
	    
	    
	    
	    
////Test ID: 44-31
///* 
//* Update Trunk Group OXE
//*/
	  	    @Test (priority = 5)
	    	    public void UpdateTrunkGroupOXE() throws InterruptedException {
	  	    	System.setProperty("webdriver.gecko.driver", driverPath);
	  			driver = new FirefoxDriver();
	  			driver.get(baseUrl);
	  			
	  		    // Signing in OmniPCX 
	  			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	  			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	  			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	  			  
	  			// Click On Trunk Group
	  			Thread.sleep(12000);
	  			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink7")).click();	   
	    			  
	    			//Get the table and row
	    			WebElement table =driver.findElement(By.id("gvTrunkGroups"));
	    			WebElement tbody=table.findElement(By.tagName("tbody"));
	    			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
	    			String rowNo="";
	    			String NodeName = "DdNode";
	    			for(int i=0;i<rows.size();i++)
	    			{
	    			WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvTrunkGroups\"]/tbody/tr["+(i+1)+"]"));
	    			if(row.getText().trim().contains(NodeName))
	    			{
	    			rowNo=Integer.toString(i+1);
	    			break;
	    			}
	    			}
	    			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[4]/div/img[1]")).click();
	    			
				// Select Node
				Thread.sleep(5000);
				Select dropdownNode = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/select")));
			   	dropdownNode.selectByVisibleText("BbNode"); 
	  			
	  			// Click on Save button
	  			Thread.sleep(5000);
	  			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input[1]")).click();
	    
				Thread.sleep(6000);
				String expected = "Settings have been updated successfully";
				// Get label msg
			  	String actual = driver.findElement(By.id("lblMessage")).getText();
	
			  	Assert.assertEquals(actual, expected);        
	  			
	  			driver.close();	    	  		    	  			
	  		}
	

	
////Test ID: 44-36
///* 
//* Enter trunk group with 100 characters
//*/
	  	    @Test (priority = 6)
	    	    public void AddTrunkGroupwith100Characters() throws InterruptedException {
	  	    	System.setProperty("webdriver.gecko.driver", driverPath);
	  			driver = new FirefoxDriver();
	  			driver.get(baseUrl);
	  			
	  		    // Signing in OmniPCX 
	  			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	  			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	  			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	  			  
	  			// Click On Trunk Group
	  			Thread.sleep(10000);
	  			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink7")).click();	
	  			
				  // Click on Name*
				  Thread.sleep(5000);
				  driver.findElement(By.id("tbTrunkGroup")).sendKeys("A noisy confused place, any place or situation of noise and confusion Befuddled adjective Confused,,| cut off");
			  
				  // Click on Save button
				  Thread.sleep(5000);
				  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input[1]")).click();
	
				  Thread.sleep(6000);
				  String expected = "Settings have been saved successfully";
				  // Get label msg
			  	  String actual = driver.findElement(By.id("lblMessage")).getText();
	
			  	  Assert.assertEquals(actual, expected);

	driver.close();	    	  		    	  			
	}
	  	    
	  	    

////Test ID: 44-37
///* 
//* Enter trunk group with Special Characters 
//*/
		    @Test (priority = 7)
		    public void AddTrunkGroupwithSpecialCharacters() throws InterruptedException {
		    	
		    	System.setProperty("webdriver.gecko.driver", driverPath);
				  driver = new FirefoxDriver();
				  driver.get(baseUrl);
				
				  // Signing in OmniPCX 
				  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
				  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
				  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
				  
				  // Click On Trunk Group
				  Thread.sleep(10000);
				  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink7")).click();
				  
				  // Click on Name*
				  Thread.sleep(5000);
				  driver.findElement(By.id("tbTrunkGroup")).sendKeys("!@#$$%^&*()'/'");
				  
				  // Click on Save button
				  Thread.sleep(5000);
				  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input[1]")).click();
	
				  Thread.sleep(6000);
				  String expected = "Settings have been saved successfully";
				  // Get label msg
			  	  String actual = driver.findElement(By.id("lblMessage")).getText();
	
			  	  Assert.assertEquals(actual, expected);
		       	       
		       	  driver.close();	  
		      }	 	  	    
	  	    
	

		    
////Test ID: 44-39
///* 
//* Delete Trunk Group from system that is associated with Trunk Packetizer 
//*/	
		 @Test (priority = 9)
		 public void DeleteTrunkGroupAssociatedwithPacketizer() throws InterruptedException {
		    	System.setProperty("webdriver.gecko.driver", driverPath);
				  driver = new FirefoxDriver();
				  driver.get(baseUrl);
				
				  // Signing in OmniPCX 
				  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
				  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
				  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();	
				  
				  // Click on Broad
				  Thread.sleep(20000);
				  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink6")).click();
				  
				  // Enter Name *
				  Thread.sleep(5000);
				  driver.findElement(By.id("txtBoardName")).sendKeys("Benign");
				  
				  // Logic Type *
				  driver.findElement(By.id("txtLogicalName")).sendKeys("SPH_uhk4");
				  
				  // Click on save button
				  Thread.sleep(4000);
				  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input[1]")).click();
				  
				  // Click On Packetizer Settings
	  			  Thread.sleep(9000);
	  			  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPCM")).click();
	  			  
	  			  // Click on Add Packetizer
	  			  Thread.sleep(10000);
	  			  driver.findElement(By.id("linkAddPacketizers")).click();
	  			  
	  			  // Select Connection Type
	  			  Thread.sleep(9000);
	  			  driver.findElement(By.id("RecorderTypeTrunk")).click();				  
	  			  
	  			  // add Packetizer IP *
	  			  driver.findElement(By.id("tbPacketizerIp")).sendKeys("132.162.107.209");
	  			  
	  			  // add Packetizer Port *
	  			  driver.findElement(By.id("tbPacketizerPort")).sendKeys("6060");
	  			  
	  			  // Select Truck Group
	  			Thread.sleep(7000);
				Select dropdownTG = new Select(driver.findElement(By.id("trunkGroup_0")));
			   	dropdownTG.selectByVisibleText("Acrid");
			   	
	            // Select Board
			   	Thread.sleep(7000);
				Select dropdownB = new Select(driver.findElement(By.id("board_0")));
			   	dropdownB.selectByVisibleText("Benign-SPH_uhk4");
			   	
                // Click on Save button
	  			Thread.sleep(5000);
	  			driver.findElement(By.id("btnSave")).click();
	  			  
	            JavascriptExecutor jsx = (JavascriptExecutor)driver;
	  		    jsx.executeScript("window.confirm('Settings have been saved successfully')");
	  		    driver.switchTo().alert().accept();
	  		      
	  		    // Click on okay button
	  		    Thread.sleep(9000);
	  		    driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click(); 
	  		    
	  		    // Click On Trunk Group
				Thread.sleep(10000);
				driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink7")).click();
				
    			//Get the table and row
    			WebElement table =driver.findElement(By.id("gvTrunkGroups"));
    			WebElement tbody=table.findElement(By.tagName("tbody"));
    			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
    			String rowNo="";
    			String NodeName = "Acrid";
    			for(int i=0;i<rows.size();i++)
    			{
    			WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvTrunkGroups\"]/tbody/tr["+(i+1)+"]"));
    			if(row.getText().trim().contains(NodeName))
    			{
    			rowNo=Integer.toString(i+1);
    			break;
    			}
    			}
    			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[4]/div/img[2]")).click();

    			JavascriptExecutor jst = (JavascriptExecutor)driver;
    			jst.executeScript("window.confirm('Are you sure you want to delete?')");	   
    			driver.switchTo().alert().accept();
    			   
    			// Click on delete button
    			Thread.sleep(5000);
    			driver.findElement(By.id("btnDelete")).click();
    			
    			Thread.sleep(6000);
				String expected = "Trunk Group is associated with packetizer.";
				// Get label msg
			  	String actual = driver.findElement(By.id("lblGridMsg")).getText();
	
			  	Assert.assertEquals(actual, expected);
				  
				driver.close();	  
	      }
		 


////Test ID: 44-33
///* 
//* Delete Trunk Group from system  
//*/	
		 @Test (priority = 11)
		 public void DeleteTrunkGroupfromSystem() throws InterruptedException {			 
			 System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
			  driver.get(baseUrl);
			
			  // Signing in OmniPCX 
			  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			  // Click On Trunk Group
			  Thread.sleep(7000);
			  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink7")).click();
			  
			  //Get the table and row
  			WebElement table =driver.findElement(By.id("gvTrunkGroups"));
  			WebElement tbody=table.findElement(By.tagName("tbody"));
  			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
  			String rowNo="";
  			String TrunkName = "A noisy confused place, any...";
  			for(int i=0;i<rows.size();i++)
  			{
  			WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvTrunkGroups\"]/tbody/tr["+(i+1)+"]"));
  			if(row.getText().trim().contains(TrunkName))
  			{
  			rowNo=Integer.toString(i+1);
  			break;
  			}
  			}
  			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[4]/div/img[2]")).click();

  			JavascriptExecutor jst = (JavascriptExecutor)driver;
			jst.executeScript("window.confirm('Are you sure you want to delete?')");	   
			driver.switchTo().alert().accept();
			   
			// Click on delete button
			Thread.sleep(5000);
			driver.findElement(By.id("btnDelete")).click();
			
			Thread.sleep(6000);
			String expected = "Record has been deleted successfully.";
			// Get label msg
		  	String actual = driver.findElement(By.id("lblGridMsg")).getText();

		  	Assert.assertEquals(actual, expected);
			  
			driver.close();	  
      }  
	
	
			  

////Test ID: 44-41
///* 
//* Verify Trunk Groups: If less than and greater than sign contains in Name field on Trunk group page 
//*/
	 @Test (priority = 12)
	 public void VerifyLessthanGreaterthannotAllowedinNamefield() throws InterruptedException { 
		 System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
		  driver.get(baseUrl);
		
		  // Signing in OmniPCX 
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		  // Click On Trunk Group
		  Thread.sleep(10000);
		  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink7")).click();
		  
		  // Click on Name*
		  Thread.sleep(5000);
		  driver.findElement(By.id("tbTrunkGroup")).sendKeys("<><>");
		  
		  String expected = "";
		  String accepted = driver.findElement(By.id("tbTrunkGroup")).getAttribute("value");
		  
		  Assert.assertEquals(accepted, expected);
		  driver.close();	  
	      }
	
	
	
////Test ID: 44-42
///* 
//* Verify Node selection is optional while adding Trunk Group
//*/
	    @Test (priority = 13)
	    public void VerifyTrunkGroupaddedWithoutNode() throws InterruptedException {
	    	
	    	System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
			  driver.get(baseUrl);
			
			  // Signing in OmniPCX 
			  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			  // Click On Trunk Group
			  Thread.sleep(12000);
			  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink7")).click();
			  
			  // Click on Name*
			  Thread.sleep(5000);
			  driver.findElement(By.id("tbTrunkGroup")).sendKeys("TrunkwithoutNode");

			  // Click on save
			  Thread.sleep(5000);
			  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input[1]")).click();

			  Thread.sleep(6000);
			  String expected = "Settings have been saved successfully";
			  // Get label msg
		  	  String actual = driver.findElement(By.id("lblMessage")).getText();

		  	  Assert.assertEquals(actual, expected);
	       	       
	       	  driver.close();	  
	      }	 	
	
	 
	 
	 
////Test ID: 44-43
///* 
//* Verify error message when user enter space in name field of Trunk Group and click on save button. 
//*/
	    @Test (priority = 14)
	    public void VerifySpaceinTrunkGroupName() throws InterruptedException {	
	    	System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
			  driver.get(baseUrl);
			
			  // Signing in OmniPCX 
			  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			  // Click On Trunk Group
			  Thread.sleep(12000);
			  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink7")).click();
			  
			  // Click on Name*
			  Thread.sleep(5000);
			  driver.findElement(By.id("tbTrunkGroup")).sendKeys("        ");
			  
			  // Select Node
			  Thread.sleep(5000);
			  Select dropdownNode = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/select")));
		   	  dropdownNode.selectByVisibleText("AaNode"); 
			  
			  // Click on Save button
			  Thread.sleep(5000);
			  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input[1]")).click();

			  Thread.sleep(6000);
			  String expected = "Please provide Name";
			  // Get label msg
		  	  String actual = driver.findElement(By.id("lblMessage")).getText();

		  	  Assert.assertEquals(actual, expected);
	       	       
	       	  driver.close();	  
	      }
	    
	    
	    
	    
////Test ID: 44-38
///* 
//* Add Trunk Group when no node is added in the system
//*/
	  	 @Test (priority = 15)
	  	 public void AddTrunkGroupwithNoNode() throws InterruptedException {
		    	System.setProperty("webdriver.gecko.driver", driverPath);
				  driver = new FirefoxDriver();
				  driver.get(baseUrl);
				
				  // Signing in OmniPCX 
				  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
				  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
				  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
				  
				  // Click on Nodes
	              Thread.sleep(12000);
	       	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkNodes")).click();
	       	      
	       	      // Check if any nodes present
	       	      Assert.assertFalse(driver.findElement(By.id("NodeTable")).isDisplayed());				  
				  
	       	      // Click On Trunk Group
				  Thread.sleep(12000);
				  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink7")).click();
				  
				  // Click on Name*
				  Thread.sleep(5000);
				  driver.findElement(By.id("tbTrunkGroup")).sendKeys("Caboodle");
				  
				  // Click on Save button
				  Thread.sleep(5000);
				  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input[1]")).click();
	
				  Thread.sleep(6000);
				  String expected = "Settings have been saved successfully";
				  // Get label msg
			  	  String actual = driver.findElement(By.id("lblMessage")).getText();
	
			  	  Assert.assertEquals(actual, expected);
		       	       
		       	  driver.close();	  
	  	 }
	  
	    
	    
	    
	       
	    
	    
//////////////////////////////////////////////////////////////Board & Equipment
////Test ID: 44-01	    
///* 
//* To verify that user is able to add board with valid Board name and logic type 
//*/
	  	 @Test (priority = 16)
	  	 public void AddValidBoardwithNameLogic() throws InterruptedException {
		    	System.setProperty("webdriver.gecko.driver", driverPath);
				  driver = new FirefoxDriver();
				  driver.get(baseUrl);
				  
				  // Signing in OmniPCX 
				  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
				  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
				  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
				  
				  // Click On Boards
				  Thread.sleep(7000);
				  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink6")).click();
				  
				  // Click on Name*
				  Thread.sleep(5000);
				  driver.findElement(By.id("txtBoardName")).sendKeys("Zero-in-on");
				  
				  // Click on Logic Type *
				  Thread.sleep(5000);
				  driver.findElement(By.id("txtLogicalName")).sendKeys("ALT_F");
				  
				  // Click on Save button
				  Thread.sleep(5000);
				  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input[1]")).click();

				  Thread.sleep(6000);
				  String expected = "Settings have been saved successfully";
				  // Get label msg
			  	  String actual = driver.findElement(By.id("lblMessage")).getText();

			  	  Assert.assertEquals(actual, expected);
		       	       
		       	  driver.close();	  
		      }
	  	 
	  	 
	  	 
	  	 
//Test ID: 44-02	    
////* 
//* To verify that user is not able to add board with duplicate board name 
///*/	 
	  	@Test (priority = 17)
	  	 public void VerifyDuplicateBoardName() throws InterruptedException {
		    	System.setProperty("webdriver.gecko.driver", driverPath);
				  driver = new FirefoxDriver();
				  driver.get(baseUrl);
				  
				  // Signing in OmniPCX 
				  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
				  driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
				  driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
				  
				  // Click On Boards
				  Thread.sleep(10000);
				  driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink6")).click();
				  
				  // Click on Name* same as before
				  Thread.sleep(5000);
				  driver.findElement(By.id("txtBoardName")).sendKeys("Zero-in-on");
				  
				  // Click on Logic Type* same as before
				  Thread.sleep(5000);
				  driver.findElement(By.id("txtLogicalName")).sendKeys("ALT_F");
				  
				  // Click on Save button
				  Thread.sleep(5000);
				  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input[1]")).click();

				  Thread.sleep(6000);
				  String expected = "Settings have been saved successfully";
				  // Get label msg
			  	  String actual = driver.findElement(By.id("lblMessage")).getText();

			  	  Assert.assertEquals(actual, expected);
		       	       
		       	  driver.close();	  
		      }
	  	
	  	
	  	
	  	
	  	
////Test ID: 44-03	    
///* 
//* Add Board in system with Empty/Null Name 
//*/	 
	  	  	@Test (priority = 18)
	  	  	 public void AddBoardwithEmptyName() throws InterruptedException {
	  	  	  System.setProperty("webdriver.gecko.driver", driverPath);
			     driver = new FirefoxDriver();
			     driver.get(baseUrl);
			  
			     // Signing in OmniPCX 
			     driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			     driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			     driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			     // Click On Boards
			     Thread.sleep(10000);
			     driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink6")).click();
			  
			     // Click on Name* same as before
//			     Thread.sleep(5000);
//			     driver.findElement(By.id("txtBoardName")).sendKeys("Zero-in-on");
//			  
			     // Click on Logic Type* same as before
			     Thread.sleep(5000);
			     driver.findElement(By.id("txtLogicalName")).sendKeys("ALT_T");
			  
			     // Click on Save button
			     Thread.sleep(5000);
			     driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input[1]")).click();

			     Thread.sleep(6000);
			     String expected = "Please provide Name";
			     // Get label msg
			     String actual = driver.findElement(By.id("lblMessage")).getText();

			     Assert.assertEquals(actual, expected);
	       	       
	       	  driver.close();	  
	      }
	  	  	
	  	  	
	  	  	
	  	  	
////Test ID: 44-04	    
///* 
//* Add Board in system with Empty/Null Logic Type
//*/	 	  	  	
	  	  	@Test (priority = 19)
	  	  	 public void AddBoardwithEmptyLogicType() throws InterruptedException {
	  	  	  System.setProperty("webdriver.gecko.driver", driverPath);
			     driver = new FirefoxDriver();
			     driver.get(baseUrl);
			  
			     // Signing in OmniPCX 
			     driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			     driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			     driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			     // Click On Boards
			     Thread.sleep(10000);
			     driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink6")).click();
			  
			     // Click on Name* same as before
			     Thread.sleep(5000);
			     driver.findElement(By.id("txtBoardName")).sendKeys("Zero-in-on");
			  
//			     // Click on Logic Type* same as before
//			     Thread.sleep(5000);
//			     driver.findElement(By.id("txtLogicalName")).sendKeys("ALT_T");
			  
			     // Click on Save button
			     Thread.sleep(5000);
			     driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input[1]")).click();

			     Thread.sleep(6000);
			     String expected = "Please provide logic type.";
			     // Get label msg
			     String actual = driver.findElement(By.id("lblMessage")).getText();

			     Assert.assertEquals(actual, expected);
	       	       
	       	  driver.close();	  
	      }	 
	  	  	
	  	  	
	  	  	
	  	  	
////Test ID: 44-05	    
///* 
//* Update Board information 
//*/
	  	@Test (priority = 20)
	  	public void UpdateBoardInformation() throws InterruptedException {
	  	    System.setProperty("webdriver.gecko.driver", driverPath);
			   driver = new FirefoxDriver();
			   driver.get(baseUrl);
			   
			   // Signing in OmniPCX 
			   driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			   driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			   driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			   // Click On Boards
			   Thread.sleep(10000);
			   driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink6")).click(); 	
							   
			   // Edit 2nd Board
			   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr[2]/td[4]/img[1]")).click();

			   // Press update button
			   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input[1]")).click();			   
			   
			   Thread.sleep(6000);
			   String expected = "Settings have been updated successfully";
			   // Get label msg
			   String actual = driver.findElement(By.id("lblMessage")).getText();

			   Assert.assertEquals(actual, expected);
			   
			   driver.close();	  
	      }	   
	  	  	
	  	  	
	  	
	  	
////Test ID: 44-06	    
///* 
//* Delete board from system 
//*/	  	
	  	@Test (priority = 21)
	  	public void DeleteBoardInformation() throws InterruptedException {
	  	    System.setProperty("webdriver.gecko.driver", driverPath);
			   driver = new FirefoxDriver();
			   driver.get(baseUrl);
			   
			   // Signing in OmniPCX 
			   driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			   driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			   driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			   // Click On Boards
			   Thread.sleep(10000);
			   driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink6")).click(); 	
			   
			   // Delete 2nd Board
			   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr[2]/td[4]/img[2]")).click();
			   
			   JavascriptExecutor jst = (JavascriptExecutor)driver;
			   jst.executeScript("window.confirm('Are you sure you want to delete?')");	   
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
	  	
	  	
	
	  	
////Test ID: 44-07	    
///* 
//* User should not be able to add equipment when no board is added in the system
//*/	
	  	@Test (priority = 8)
	  	public void AddEquipmentwithNoBoard() throws InterruptedException {
	  	    System.setProperty("webdriver.gecko.driver", driverPath);
			   driver = new FirefoxDriver();
			   driver.get(baseUrl);
			   
			   // Signing in OmniPCX 
			   driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			   driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			   driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			   // Click On Boards
			   Thread.sleep(12000);
			   driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink6")).click();
			   
			   // Click on add equipment
			   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a")).click();
			   
			   // Add Number/Trunk*
			   driver.findElement(By.id("tbEquipmentNo")).sendKeys("4");
			   
			   // Enter Trunk Group
		   	   Select dropdownTG = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/select")));
			   dropdownTG.selectByVisibleText("Acrid"); 
			   
			   // press save button
			   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[6]/td[2]/input[1]")).click();
			   
			   Thread.sleep(6000);
			   String expected = "Please provide board.";
			   // Get label msg
			   String actual = driver.findElement(By.id("lblMessage")).getText();

			   Assert.assertEquals(actual, expected);
			   
			   driver.close();	  
	      }	
	  	
	  	
	  	
	  	
////Test ID: 44-09	    
///* 
//* User is able to add duplicate equipment number with Trunk group of different OXE
//*/	 
	  	@Test (priority = 22)
	  	public void AddEquipmentwithDuplicateNumberandDifferentOXE() throws InterruptedException {
	  	    System.setProperty("webdriver.gecko.driver", driverPath);
			   driver = new FirefoxDriver();
			   driver.get(baseUrl);
			   
			   // Signing in OmniPCX 
			   driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			   driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			   driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			   // Click On Boards
			   Thread.sleep(10000);
			   driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink6")).click();
			   
			   String[] TrunkNo = {"4", "4"};
			   
			   // Click on add equipment
			   Thread.sleep(3000);
		       driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a")).click();

			   
			   for (int i = 0; i < TrunkNo.length; i++)
			   {			   
			        // Add Number/Trunk*
			       Thread.sleep(4000);
			        driver.findElement(By.id("tbEquipmentNo")).sendKeys(TrunkNo[i]);
			   
			        if (i<1) {
			        	      // Enter Trunk Group
			   	              Select dropdownTG = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/select")));
				              dropdownTG.selectByVisibleText("Acrid"); }
			   
			        else {
			        	  // Enter Trunk Group
					   	   Select dropdownTG = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/select")));
						   dropdownTG.selectByVisibleText("Babble"); }
	
			   // press save button
			   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[6]/td[2]/input[1]")).click();
			   Thread.sleep(4000);
			   }
			   
			   Thread.sleep(6000);
			   String expected = "Settings have been saved successfully";
			   // Get label msg
			   String actual = driver.findElement(By.id("lblMessage")).getText();

			   Assert.assertEquals(actual, expected);
			   
			   driver.close();	  
	      }	
	  	
	  	


	  	
////Test ID: 44-10	    
///* 
//* User is able to add duplicate equipment number with Trunk group of different OXE
//*/
	  	@Test (priority = 23)
	  	public void AddEquipmentwithDuplicateNumberandSameOXE() throws InterruptedException {
	  	    System.setProperty("webdriver.gecko.driver", driverPath);
			   driver = new FirefoxDriver();
			   driver.get(baseUrl);
			   
			   // Signing in OmniPCX 
			   driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			   driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			   driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			   // Click On Boards
			   Thread.sleep(10000);
			   driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink6")).click();
			   
			   // Click on add equipment
			   Thread.sleep(3000);
		       driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a")).click();

		       // Add Number/Trunk*
		       Thread.sleep(4000);
		       driver.findElement(By.id("tbEquipmentNo")).sendKeys("4"); 
		        
		       // Enter Trunk Group
 	           Select dropdownTG = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/select")));
	           dropdownTG.selectByVisibleText("Acrid"); 
			   
			   // press save button
			   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[6]/td[2]/input[1]")).click();
			   Thread.sleep(4000);
			  
			   String expected = "Number already exists.";
			   // Get label msg
			   String actual = driver.findElement(By.id("lblMessage")).getText();

			   Assert.assertEquals(actual, expected);
			   
			   driver.close();	  
	      }	
	  	
	  	

	  	
////Test ID: 44-16	    
///* 
//* Enter board with same board name and logic type
//*/
	  	@Test (priority = 24)
	  	public void AddBoardwithSameNameandLogicType() throws InterruptedException {
	  	    System.setProperty("webdriver.gecko.driver", driverPath);
			   driver = new FirefoxDriver();
			   driver.get(baseUrl);
			   
			   // Signing in OmniPCX 
			   driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			   driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			   driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			   
			  // Click On Boards
			   Thread.sleep(10000);
			   driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink6")).click();
			   
			   // Click on Name* same as before
			   Thread.sleep(5000);
			   driver.findElement(By.id("txtBoardName")).sendKeys("Zilch");
			   
			   // Click on Logic Type* same as before
			   Thread.sleep(5000);
			   driver.findElement(By.id("txtLogicalName")).sendKeys("Zilch");
			   
			   // Click on Save button
			   Thread.sleep(5000);
			   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input[1]")).click();

			   Thread.sleep(6000);
			   String expected = "Settings have been saved successfully";
			   // Get label msg
			   String actual = driver.findElement(By.id("lblMessage")).getText();

			   Assert.assertEquals(actual, expected);
			   
			   driver.close();	  
	      }	
	  	
	  	
	  	
	  	
////Test ID: 44-14	    
///* 
//* Enter board with Special Characters in board name field
//*/
	  	@Test (priority = 25)
	  	public void AddBoardwithSpecialCharactersinName() throws InterruptedException {
	  	    System.setProperty("webdriver.gecko.driver", driverPath);
			   driver = new FirefoxDriver();
			   driver.get(baseUrl);
			   
			   // Signing in OmniPCX 
			   driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			   driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			   driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			   
			   // Click On Boards
			   Thread.sleep(10000);
			   driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink6")).click();
			   
			   // Click on Name* 
			   Thread.sleep(5000);
			   driver.findElement(By.id("txtBoardName")).sendKeys("'/'/'\"\"\"\"/';';$%$&$%##");
			   
			   // Click on Logic Type* 
			   Thread.sleep(5000);
			   driver.findElement(By.id("txtLogicalName")).sendKeys("NADA");
			   
			   // Click on Save button
			   Thread.sleep(5000);
			   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input[1]")).click();

			   Thread.sleep(6000);
			   Assert.assertFalse(driver.findElement(By.id("lblMessage")).isDisplayed());
			   
			   driver.close();	  
	      }	
	  	
	  	
	  	
	  	
////Test ID: 44-15	    
///* 
//* Enter board with Special Characters in logic type field
//*/				  
	  	@Test (priority = 26)
	  	public void AddBoardwithSpecialCharactersinLogicType() throws InterruptedException {
	  	    System.setProperty("webdriver.gecko.driver", driverPath);
			   driver = new FirefoxDriver();
			   driver.get(baseUrl);
			   
			   // Signing in OmniPCX 
			   driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			   driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			   driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			   
			   // Click On Boards
			   Thread.sleep(12000);
			   driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink6")).click();
			   
			   // Click on Name* 
			   Thread.sleep(5000);
			   driver.findElement(By.id("txtBoardName")).sendKeys("NADA"); 
			   
			   // Click on Logic Type* 
			   Thread.sleep(5000);
			   driver.findElement(By.id("txtLogicalName")).sendKeys("'/'/'\\\"\\\"\\\"\\\"/';';");
			   
			   // Click on Save button
			   Thread.sleep(5000);
			   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input[1]")).click();

			   Thread.sleep(6000);
			   Assert.assertTrue(driver.findElement(By.id("lblMessage")).isDisplayed());
			   
			   driver.close();	  
	      }			 				    	
	  	 
	

	
////Test ID: 44-17	    
///* 
//* Verify that board name field allows 100 characters
//*/
  	@Test (priority = 27)
  	public void VerifyBoardNameallows100Characters() throws InterruptedException {
  	    System.setProperty("webdriver.gecko.driver", driverPath);
		   driver = new FirefoxDriver();
		   driver.get(baseUrl);
		   
		   // Signing in OmniPCX 
		   driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		   driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		   driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		   
		   // Click On Boards
		   Thread.sleep(12000);
		   driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink6")).click();
		   
		   // Click on Name* 
		   Thread.sleep(5000);
		   driver.findElement(By.id("txtBoardName")).sendKeys("Returning that there is an add user option at the top right of the page if I ever want to check that|cut off"); 
		   
		   // Click on Logic Type* 
		   Thread.sleep(5000);
		   driver.findElement(By.id("txtLogicalName")).sendKeys("ALT_Esc");
		   
		   String expected = "Returning that there is an add user option at the top right of the page if I ever want to check that";
		   String accepted = driver.findElement(By.id("txtBoardName")).getAttribute("value");
		   Assert.assertEquals(accepted, expected);
		   
		   // Click on Save button
		   Thread.sleep(5000);
		   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input[1]")).click();

		   Thread.sleep(6000);
		   Assert.assertTrue(driver.findElement(By.id("lblMessage")).isDisplayed());
		   
		   driver.close();	  
      }			 				 		 
	
	
  	
  	
////Test ID: 44-18	    
///* 
//* Verify that logic type field allows 100 characters
//*/  
  	@Test (priority = 28)
  	public void VerifyBoardLogicTypeallows100Characters() throws InterruptedException {
  	    System.setProperty("webdriver.gecko.driver", driverPath);
		   driver = new FirefoxDriver();
		   driver.get(baseUrl);
		   
		   // Signing in OmniPCX 
		   driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		   driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		   driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		   
		   // Click On Boards
		   Thread.sleep(12000);
		   driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink6")).click();
		   
		   // Click on Name* 
		   Thread.sleep(5000);
		   driver.findElement(By.id("txtBoardName")).sendKeys("WINKEY"); 
		   
		   // Click on Logic Type* 
		   Thread.sleep(5000);
		   driver.findElement(By.id("txtLogicalName")).sendKeys("Returning that there is an add user option at the top right of the page if I ever want to check that|cut off");
		   
		   String expected = "Returning that there is an add user option at the top right of the page if I ever want to check that";
		   String accepted = driver.findElement(By.id("txtLogicalName")).getAttribute("value");
		   Assert.assertEquals(accepted, expected);
		   
		   // Click on Save button
		   Thread.sleep(5000);
		   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[5]/td[2]/input[1]")).click();

		   Thread.sleep(6000);
		   Assert.assertTrue(driver.findElement(By.id("lblMessage")).isDisplayed());
		   
		   driver.close();	  
      }	
	

	
	
////Test ID: 44-19	    
///* 
//* Verify Number\Trunk fields allows only numeric digits
//*/	
  	@Test (priority = 29)
  	public void VerifyNumber_TrunkallowsOnlyNumerics() throws InterruptedException {
  	    System.setProperty("webdriver.gecko.driver", driverPath);
		   driver = new FirefoxDriver();
		   driver.get(baseUrl);
		   
		   // Signing in OmniPCX 
		   driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		   driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		   driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		   // Click On Boards
		   Thread.sleep(15000);
		   driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink6")).click();
		   
		   // Click on add equipment
		   Thread.sleep(3000);
	       driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a")).click();

	       // Add Number/Trunk*
	       Thread.sleep(4000);
	       driver.findElement(By.id("tbEquipmentNo")).sendKeys("hgfhkgdgfgnkjgd");
	       
		   String expected = "";
		   String accepted = driver.findElement(By.id("tbEquipmentNo")).getAttribute("value");
		   Assert.assertEquals(accepted, expected);
		   
		   driver.close();	  
      }	
  	
  	
  	
  	
////Test ID: 44-20	    
///* 
//* Add equipment in system with empty equipment number
//*/ 
  	@Test (priority = 30)
  	public void AddEquipmentwithEmptyEquipmentNumber() throws InterruptedException {
  	    System.setProperty("webdriver.gecko.driver", driverPath);
		   driver = new FirefoxDriver();
		   driver.get(baseUrl);
		   
		   // Signing in OmniPCX 
		   driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		   driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		   driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		   // Click On Boards
		   Thread.sleep(15000);
		   driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink6")).click();
		   
		   // Click on add equipment
		   Thread.sleep(3000);
	       driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a")).click();

//	       // Add Number/Trunk*
//	       Thread.sleep(4000);
//	       driver.findElement(By.id("tbEquipmentNo")).sendKeys("hgfhkgdgfgnkjgd");
	       
	       // Enter Trunk Group
	       Select dropdownTG = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/select")));
           dropdownTG.selectByVisibleText("Acrid"); 
		   
		   // press save button
		   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[6]/td[2]/input[1]")).click();
		   Thread.sleep(4000);
		  
		   String expected = "Please provide equipment number.";
		   // Get label msg
		   String actual = driver.findElement(By.id("lblMessage")).getText();

		   Assert.assertEquals(actual, expected);
		   
		   driver.close();	  
      }
  	
  	

////Test ID: 44-21	    
///* 
//* Add equipment in system without Trunk group
//*/  	
  	@Test (priority = 31)
  	public void AddEquipmentwithNoTrunkgroup() throws InterruptedException {
  	    System.setProperty("webdriver.gecko.driver", driverPath);
		   driver = new FirefoxDriver();
		   driver.get(baseUrl);
		   
		   // Signing in OmniPCX 
		   driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		   driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		   driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		   // Click On Boards
		   Thread.sleep(20000);
		   driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink6")).click();
		   
		   // Click on add equipment
		   Thread.sleep(6000);
	       driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a")).click();

	       // Add Number/Trunk*
	       Thread.sleep(7000);
	       driver.findElement(By.id("tbEquipmentNo")).sendKeys("5");
	       
//	       // Enter Trunk Group
//	       Select dropdownTG = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/select")));
//           dropdownTG.selectByVisibleText("Acrid"); 
		   
		   // press save button
		   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[6]/td[2]/input[1]")).click();
		   Thread.sleep(7000);
		  
		   String expected = "Settings have been saved successfully";
		   // Get label msg
		   String actual = driver.findElement(By.id("lblMessage")).getText();

		   Assert.assertEquals(actual, expected);
		   
		   driver.close();	  
      }
  	
	
  	  
	
////Test ID: 44-23	    
///* 
//* Verify that there is no length restriction on Number/Trunk field on add equipment page. Range and csv is also allowed so it cannot be restricted 
//*/	
	@Test (priority = 32)
	public void VerifyEquipmentAllowsRange() throws InterruptedException {
	    System.setProperty("webdriver.gecko.driver", driverPath);
		   driver = new FirefoxDriver();
		   driver.get(baseUrl);
		   
		   // Signing in OmniPCX 
		   driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		   driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		   driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		   // Click On Boards
		   Thread.sleep(20000);
		   driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink6")).click();
		   
		   // Click on add equipment
		   Thread.sleep(6000);
	       driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a")).click();
	
	       // Add Number/Trunk*
	       Thread.sleep(7000);
	       driver.findElement(By.id("tbEquipmentNo")).sendKeys("100-150,400-450");
		   
		   // press save button
		   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[6]/td[2]/input[1]")).click();
		   Thread.sleep(9000);
		  
		   String expected = "Settings have been saved successfully";
		   // Get label msg
		   String actual = driver.findElement(By.id("lblMessage")).getText();
	
		   Assert.assertEquals(actual, expected);
		   
		   driver.close();	  
	  }
	
	
	
	
////Test ID: 44-25	    
///* 
//* To Verify if back button is working on Equipment Page
//*/
	@Test (priority = 33)
	public void VerifyEquipmentBackButtonworking() throws InterruptedException {
	    System.setProperty("webdriver.gecko.driver", driverPath);
		   driver = new FirefoxDriver();
		   driver.get(baseUrl);
		   
		   // Signing in OmniPCX 
		   driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		   driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		   driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		   // Click On Boards
		   Thread.sleep(20000);
		   driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink6")).click();
		   
		   // Click on add equipment
		   Thread.sleep(6000);
	       driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a")).click();
	
	       // Click on back button
		   Thread.sleep(6000);
	       driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a")).click();
	
	       Thread.sleep(7000);
	       
	       Assert.assertTrue(driver.findElement(By.id("dvBoard")).isDisplayed());
	       
	       driver.close();	  
		  }
	
	
	
	
////Test ID: 44-22	    
///* 
//* Verify the functionality of Search Box on Boards page 
//*/	
	@Test (priority = 34)
	public void VerifySearchonBoard() throws InterruptedException {
	    System.setProperty("webdriver.gecko.driver", driverPath);
		   driver = new FirefoxDriver();
		   driver.get(baseUrl);
		   
		   // Signing in OmniPCX 
		   driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		   driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		   driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		  
		   // Click On Boards
		   Thread.sleep(20000);
		   driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink6")).click();
		   
		   // Search with board name
		   String expected = "WINKEY Returning that there is an add user option at the top rig...";
		   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/div[1]/div/label/input")).sendKeys("winKey");       
		   List <WebElement> listItems = driver.findElements(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr[1]"));
		   String actual = listItems.get(0).getText(); //make sure you have enough implicit wait on Global level to wait till list appear
		   
		   Assert.assertEquals(actual, expected);
		   
		   // Clear search
		   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/div[1]/div/label/input")).clear();
		   
		   // Search with logic type
		   String expected1 = "Zero-in-on ALT_F";
		   driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/div[1]/div/label/input")).sendKeys("ALT_F");       
		   List <WebElement> listItems1 = driver.findElements(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr[1]"));
		   String actual1 = listItems1.get(0).getText(); //make sure you have enough implicit wait on Global level to wait till list appear
		   
		   Assert.assertEquals(actual1, expected1);
		 
	//   System.out.println(actual1);
	//   System.out.println(expected1);
		   
		   driver.close();	  
		  }
	
	
	

////Test ID: 44-24	    
///* 
//* Delete board when it is associated with Trunk packetizer
//*/
		@Test (priority = 10)
		public void DeleteBoardAssociatedwithTrunkPacketizer() throws InterruptedException {
			 System.setProperty("webdriver.gecko.driver", driverPath);
			   driver = new FirefoxDriver();
			   driver.get(baseUrl);
			   
			   // Signing in OmniPCX 
			   driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			   driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			   driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			  
			   // Click On Boards
			   Thread.sleep(30000);
			   driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink6")).click();
			   
			 //Get the table and row
			   Thread.sleep(20000);
			WebElement table =driver.findElement(By.id("gvBoards"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String BoardName = "Benign";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvBoards\"]/tbody/tr["+(i+1)+"]"));
			if(row.getText().trim().contains(BoardName))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[4]/img[2]")).click();
			
			JavascriptExecutor jst = (JavascriptExecutor)driver;
			jst.executeScript("window.confirm('Are you sure you want to delete?')");	   
			driver.switchTo().alert().accept();
				   
			// Click on delete button
			Thread.sleep(5000);
			driver.findElement(By.id("btnDelete")).click();
			
			String expected = "Board is associated with a packetizer.";
			// Get label msg
			String actual = driver.findElement(By.id("lblGridMsg")).getText();
		
			Assert.assertEquals(actual, expected);
			    
			   driver.close();	  
			  }
		 
			 
		@AfterClass
	    public void tearDown() throws Exception {
		        driver.quit();	}
	    
	    
 } 
