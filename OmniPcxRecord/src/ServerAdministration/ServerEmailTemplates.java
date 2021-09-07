/* 
@author: sarah.mahmood 
Created on July 13, 2021
*/
package ServerAdministration;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.awt.List;
//import javax.swing.text.html.HTMLDocument.Iterator;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.JavascriptExecutor;
//import java.util.Set;
//import java.util.Iterator;
import org.testng.annotations.Test;


public class ServerEmailTemplates {
 
	 public String baseUrl = "http://172.20.22.81/OmniPCXRecord/TenantAdmin.aspx";
		
	 String driverPath = "C:\\Users\\sarah.mahmood\\Downloads\\gecko-driver\\geckodriver.exe";
		
	 public WebDriver driver;

	 @BeforeTest	
	 public void verifyLanguageSettoEnglish() throws InterruptedException {
	 	
	 	System.setProperty("webdriver.gecko.driver", driverPath);
	     driver = new FirefoxDriver();
	     driver.get(baseUrl);	
	 	
	     Thread.sleep(7000);
	     
	 	// Select English Language
	 	driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/table/tbody/tr/td/div[2]/div[1]/span[3]")).click();   // /li[1]
	 	  WebElement flags = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/table/tbody/tr/td/div[2]/div[1]/span[3]"));
	 	  List<WebElement> links = flags.findElements(By.tagName("li"));
	 	  	for (int i = 0; i < links.size(); i++){
	 	  			System.out.println(links.get(i).getText());}

//	 	  		for (int j = 0; j < 2 ; j++) {
	 	  			driver.findElement(By.xpath("//*[@id=\"ddlLanguages_child\"]/ul/li[1]")).click();   //*[@id="ddlLanguages_child"]/ul/li[1]
	 	  			
//	 	  			Thread.sleep(5000);
//	 	  			WebElement flags1 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/table/tbody/tr/td/div[2]/div[1]/span[3]"));
//	 	  			List<WebElement> links1 = flags1.findElements(By.tagName("li"));
//	 	  			Thread.sleep(5000);
//	 	  			links1.get(j).click();
//	 	  			}
	 	  		 Thread.sleep(7000);
	 	  			driver.close();	
	 	  		}
	 
	 
////Test ID: 18-01
///* 
///* Verify the email Templates with Enable Template (YES/NO)
//*/
	 @Test (priority = 0)	
     public void verifyEmailTemplateswithEnableTemplatesetNo() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
	      driver.get(baseUrl);	
	
	     // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Email Templates
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();
	      
	  	// Get all values in table and store in an array
	  	WebElement table =driver.findElement(By.id("gvEmailTemplates"));
	  	WebElement tbody=table.findElement(By.tagName("tbody"));
	  	List<WebElement> rows1=tbody.findElements(By.tagName("tr"));
	  	int rowsize = rows1.size();
	  	System.out.println(rowsize);
	  	String[] emails = new String[rowsize+2];
	  	for(int i=1;i<=rows1.size();i++)
	  	{
	  	driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr["+i+"]/td[3]/div/img[1]")).click();
	  	emails[i+1]=driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr["+i+"]/td[2]/span")).getText();
	  	System.out.println(emails[i+1]);
	  	Thread.sleep(9000);
	  	}	
	      
    
	  	  // Enable Template "No"
//	      String[] emails = {"Branch Information", "Recorded Call Notification", "OmniPCX RECORD Password Reset", "KPI Service Alert Email", "Critical error incident", "Error Incident", "Warning Incident", "Information Incident"};
	      for (int j=2; j < emails.length; j++) {
	      //Get the table and row
	      WebElement table2 = driver.findElement(By.id("gvEmailTemplates"));
		  WebElement tbody2 = table2.findElement(By.tagName("tbody"));
		  List<WebElement> rows=tbody2.findElements(By.tagName("tr"));
		  String rowNo="";
		  String title = emails[j];
		    for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr["+(i+1)+"]"));
			if(row.getText().trim().contains(title))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr["+rowNo+"]/td[3]/div/img[1]")).click();
			                            
			// Select Node
			Thread.sleep(10000);
			Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[4]/td[2]/select")));
		   	dropdown.selectByVisibleText("No");
		   	
		   	// Click on update button
		   	driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();
			
		   	Thread.sleep(6000);
			String expected = "Settings have been updated successfully";
			// Get label msg
	  	    String actual = driver.findElement(By.id("lblMessage")).getText();
	  	  
	  	    Assert.assertEquals(actual, expected);
		   	
		   	Thread.sleep(6000);
	      }
	      driver.close();	  		  		  
	}
		
		      
	 
	  
	 
	
////Test ID: 18-02
///* 
///* When email template is enabled
//*/
		 @Test (priority = 1)	
	    public void verifyEmailTemplateswithEnableTemplatesetYes() throws InterruptedException {
				System.setProperty("webdriver.gecko.driver", driverPath);
			      driver = new FirefoxDriver();
			      driver.get(baseUrl);	
			
			     // Signing in OmniPCX
			      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
			      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			      
			      // Click on Email Templates
			      Thread.sleep(10000);
			      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();
			      
				  	// Get all values in table and store in an array
				  	WebElement table =driver.findElement(By.id("gvEmailTemplates"));
				  	WebElement tbody=table.findElement(By.tagName("tbody"));
				  	List<WebElement> rows1=tbody.findElements(By.tagName("tr"));
				  	int rowsize = rows1.size();
				  	System.out.println(rowsize);
				  	String[] emails = new String[rowsize+2];
				  	for(int i=1;i<=rows1.size();i++)
				  	{
				  	driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr["+i+"]/td[3]/div/img[1]")).click();
				  	emails[i+1]=driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr["+i+"]/td[2]/span")).getText();
				  	System.out.println(emails[i+1]);
				  	Thread.sleep(9000);
				  	}
			      
				  // Enable Template "Yes"	
//			      String[] email = {"Branch Information", "Recorded Call Notification", "OmniPCX RECORD Password Reset", "KPI Service Alert Email", "Critical error incident", "Error Incident", "Warning Incident", "Information Incident"};
			      for (int j=2; j < emails.length; j++) {
			      //Get the table and row
			      WebElement table1 = driver.findElement(By.id("gvEmailTemplates"));
				  WebElement tbody1 = table1.findElement(By.tagName("tbody"));
				  List<WebElement> rows = tbody1.findElements(By.tagName("tr"));
				  String rowNo="";
				  String title = emails[j];
				    for(int i=0;i<rows.size();i++)
					{
					WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr["+(i+1)+"]"));
					if(row.getText().trim().contains(title))
					{
					rowNo=Integer.toString(i+1);
					break;
					}
					}
					driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr["+rowNo+"]/td[3]/div/img[1]")).click();
					                            
					// Select a Template
					Thread.sleep(10000);
					Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[4]/td[2]/select")));
				   	dropdown.selectByVisibleText("Yes");
				   	
				   	// Click on update button
				   	driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();
					
				   	Thread.sleep(6000);
					String expected = "Settings have been updated successfully";
					// Get label msg
			  	    String actual = driver.findElement(By.id("lblMessage")).getText();
			  	  
			  	    Assert.assertEquals(actual, expected);
				   	
				   	Thread.sleep(6000);  
			      }
 
			      driver.close();	  		  		  
			}	
			
	  
	 
	 
////Test ID: 18-11
///* 
///* Verify the functionality of buttons on the Page of Email Template: Cancel button
//*/
	 @Test (priority = 2)	
	    public void verifyEmailTemplatesbuttonCancel() throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
	      driver.get(baseUrl);	
	
	     // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Email Templates
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 

	      // Click edit of first entry in table
	      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[1]/td[3]/div/img[1]")).click();
	      
	      // Click on cancel button
	      driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/input")).click();
	      
	      Thread.sleep(5000);
	      
	      Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[2]/input")).isEnabled());
	      
	      driver.close();	  		  		  
	}
			     
		
	 
	 

	 
////Test ID: 18-09
///* 
///* Verify the functionality of buttons on the Page of Email Template: Preview Email
//*/
	 @Test (priority = 3)	
	    public void verifyEmailTemplatesbuttonPreview() throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
	      driver.get(baseUrl);	
	
	     // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Email Templates
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 

	      // Click edit of first entry in table
	      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[1]/td[3]/div/img[1]")).click();
	      
	      // Click on preview button
	      driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[2]/input")).click();
	      
	      driver.switchTo().activeElement(); //.getText()
	   
	      Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]")).isDisplayed());
	      
	      driver.close();	  		  		  
	}
	 
	 
	 
	 
	
////Test ID: 18-12
///* 
///* Verify the functionality of buttons on the Page of Email Template: Reset button
//*/
		 @Test (priority = 4)	
		    public void verifyEmailTemplatesbuttonReset() throws InterruptedException {
			  System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		
		     // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Email Templates
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 

		      // Click edit of first entry in table
		      Thread.sleep(6000);
		      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[1]/td[3]/div/img[1]")).click();
		      
		      // Clear & Enter some text in subject
		      Thread.sleep(6000);
		      driver.findElement(By.id("tbSubject")).clear(); 
		      driver.findElement(By.id("tbSubject")).sendKeys("Good Intensions");
		      
		      // Select a variable
		      Thread.sleep(6000);
			  Select dropdown = new Select(driver.findElement(By.id("ddlVariables")));
			  dropdown.selectByVisibleText("OPRID - [OPRID]");
		      
		      // Clear & Enter some text in body
			  Thread.sleep(6000);
		      driver.findElement(By.id("txtAreaBody")).clear(); //
		      driver.findElement(By.id("txtAreaBody")).sendKeys("The road to Hell is paved with good intensions");
		      
		      // Click on reset button
		      driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[3]/input")).click();
		      
		      Thread.sleep(10000);
		      
//		      Assert.assertFalse(driver.findElement(By.xpath("/html/body/div[3]")).isDisplayed());
		      
		      driver.close();	  		  		  
		}	 
		 
		 
		 
		 
		 
		 
////Test ID: 18-13
///* 
///* To perform validation checks: Leave Subject Empty
//*/
		    @Test (priority = 5)	
		    public void ValidationCheck_EmptySubject() throws InterruptedException {
			  System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		
		     // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Email Templates
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 

		      // Click edit of first entry in table
		      Thread.sleep(6000);
		      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[1]/td[3]/div/img[1]")).click();
		      
		      // Clear subject
		      Thread.sleep(6000);
		      driver.findElement(By.id("tbSubject")).clear(); 
		      
		      // Click on update button
		      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();
		      
		      Thread.sleep(6000);
			  String expected = "Please enter email subject.";
			  // Get label msg
		  	  String actual = driver.findElement(By.id("lblMessage")).getText();
		  	  
		  	  Assert.assertEquals(actual, expected);
		      
		      driver.close();	  		  		  
		}	 		 
				 
	 
		    
		    
		    

////Test ID: 18-14
///* 
///* To perform validation checks: Leave the Body of Email empty
//*/
		    @Test (priority = 6)	
  		    public void ValidationCheck_EmptyEmailbody() throws InterruptedException {
  			  System.setProperty("webdriver.gecko.driver", driverPath);
  			  driver = new FirefoxDriver();
  		      driver.get(baseUrl);	
  		
  		     // Signing in OmniPCX
  		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
  		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
  		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
  		      
  		      // Click on Email Templates
  		      Thread.sleep(10000);
  		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 

  		      // Click edit of first entry in table
  		      Thread.sleep(6000);
  		      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[1]/td[3]/div/img[1]")).click();
  		      
  		      // Clear email body
  		      Thread.sleep(6000);
  		      driver.findElement(By.id("txtAreaBody")).clear();
  		      
  		      // Click on update button
  		      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();
  		      
  		      Thread.sleep(6000);
  			  String expected = "Please enter email body.";
  			  // Get label msg
  		  	  String actual = driver.findElement(By.id("lblMessage")).getText();
  		  	  
  		  	  Assert.assertEquals(actual, expected);
  		      
  		      driver.close();	  		  		  
  		}	 		 		       
		  		    

		    
		    

////Test ID: 18-15
///* 
///* To perform validation checks: Enter more then 100 characters in the Subject
//*/
		    @Test (priority = 7)	
  		    public void ValidationCheck_100CharinSubject() throws InterruptedException {
  			  System.setProperty("webdriver.gecko.driver", driverPath);
  			  driver = new FirefoxDriver();
  		      driver.get(baseUrl);	
  		
  		     // Signing in OmniPCX
  		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
  		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
  		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
  		      
  		      // Click on Email Templates
  		      Thread.sleep(10000);
  		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 

  		      // Click edit of first entry in table
  		      Thread.sleep(6000);
  		      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[1]/td[3]/div/img[1]")).click();
  		      
  		      // Clear subject
  		      Thread.sleep(6000);
  		      driver.findElement(By.id("tbSubject")).clear();
  		      driver.findElement(By.id("tbSubject")).sendKeys("Returning that there is an add user option at the top right of the page if I ever want to check that|cut off");
  		      
//  		      // Click on update button
//  		      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();
  		      
  		      Thread.sleep(6000);
  			  String expected = "Returning that there is an add user option at the top right of the page if I ever want to check that";
  			  // Get label msg
  		  	  String actual = driver.findElement(By.id("tbSubject")).getAttribute("value");
  		  	  
  		  	  Assert.assertEquals(actual, expected);
  		      
  		      driver.close();	  		  		  
  		}	
		    
		    
		    
		    
		    
		
			    
		  		    
		  			    
	 		 
	 
	 
	
////Test ID: 18-24
///* 
///* Preview Branch Information email 
//*/
	@Test (priority = 8)	
    public void previewBranchInformationEmail() throws InterruptedException {
			  System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		
		     // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Email Templates
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 

//		      // Click edit of first entry in table
//		      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[1]/td[3]/div/img[1]")).click();
		      
		      //Get the table and row
		      WebElement table =driver.findElement(By.id("gvEmailTemplates"));
		      WebElement tbody=table.findElement(By.tagName("tbody"));
			  List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			    String rowNo="";
				String title = "Branch Information";
				for(int i=0;i<rows.size();i++)
				{
				WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr["+(i+1)+"]"));
				if(row.getText().trim().contains(title))
				{
				rowNo=Integer.toString(i+1);
				break;
				}
				}
				Thread.sleep(5000);
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr["+rowNo+"]/td[3]/div/img[2]")).click();
		      
//		      // Click on preview button
//		      driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[2]/input")).click();
		      
		      // Switch to preview dialogue
		      driver.switchTo().activeElement(); 
		      
		      String expected = "Branch Information";
		      String actual = driver.findElement(By.id("tbTitlePreview")).getAttribute("value");
		   
		      Assert.assertEquals(actual, expected);
		      
		      driver.close();	  		  		  
		}	
	
	
	
	
	
////Test ID: 18-25
///* 
///* Preview Critical error incident email  
//*/
	@Test (priority = 9)	
    public void previewCriticalerrorIncidentemail() throws InterruptedException {
			  System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		
		     // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Email Templates
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 

//		      // Click edit of first entry in table
//		      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[1]/td[3]/div/img[1]")).click();
		      
		      //Get the table and row
		      WebElement table =driver.findElement(By.id("gvEmailTemplates"));
		      WebElement tbody=table.findElement(By.tagName("tbody"));
			  List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			    String rowNo="";
				String title = "Critical error incident";
				for(int i=0;i<rows.size();i++)
				{
				WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr["+(i+1)+"]"));
				if(row.getText().trim().contains(title))
				{
				rowNo=Integer.toString(i+1);
				break;
				}
				}
				Thread.sleep(5000);
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr["+rowNo+"]/td[3]/div/img[2]")).click();
		      
		      // Switch to preview dialogue
		      driver.switchTo().activeElement(); 
		      
		      String expected = "Critical error incident";
		      String actual = driver.findElement(By.id("tbTitlePreview")).getAttribute("value");
		   
		      Assert.assertEquals(actual, expected);
		      
		      driver.close();	  		  		  
		}	
	
	
	
	
	
	
////Test ID: 18-26
///* 
///* Preview Error incident email   
//*/
	@Test (priority = 10)	
    public void previewErrorIncidentemail() throws InterruptedException {
			  System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		
		     // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Email Templates
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 

//		      // Click edit of first entry in table
//		      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[1]/td[3]/div/img[1]")).click();
		      
		      //Get the table and row
		      WebElement table =driver.findElement(By.id("gvEmailTemplates"));
		      WebElement tbody=table.findElement(By.tagName("tbody"));
			  List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			    String rowNo="";
				String title = "Error Incident";
				for(int i=0;i<rows.size();i++)
				{
				WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr["+(i+1)+"]"));
				if(row.getText().trim().contains(title))
				{
				rowNo=Integer.toString(i+1);
				break;
				}
				}
				Thread.sleep(5000);
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr["+rowNo+"]/td[3]/div/img[2]")).click();
						      
		      // Switch to preview dialogue
		      driver.switchTo().activeElement(); 
		      
		      String expected = "Error Incident";
		      String actual = driver.findElement(By.id("tbTitlePreview")).getAttribute("value");
		   
		      Assert.assertEquals(actual, expected);
		      
		      driver.close();	  		  		  
		}	
	
	 
	
	
	

	
////Test ID: 18-27
///* 
///* Preview Warning incident email    
//*/
	@Test (priority = 11)	
    public void previewWarningIncidentemail() throws InterruptedException {
			  System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		
		     // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Email Templates
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 

//		      // Click edit of first entry in table
//		      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[1]/td[3]/div/img[1]")).click();
		      
		      //Get the table and row
		      WebElement table =driver.findElement(By.id("gvEmailTemplates"));
		      WebElement tbody=table.findElement(By.tagName("tbody"));
			  List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			    String rowNo="";
				String title = "Warning Incident";
				for(int i=0;i<rows.size();i++)
				{
				WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr["+(i+1)+"]"));
				if(row.getText().trim().contains(title))
				{
				rowNo=Integer.toString(i+1);
				break;
				}
				}
				Thread.sleep(5000);
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr["+rowNo+"]/td[3]/div/img[2]")).click();
						      
		      // Switch to preview dialogue
		      driver.switchTo().activeElement(); 
		      
		      String expected = "Warning Incident";
		      String actual = driver.findElement(By.id("tbTitlePreview")).getAttribute("value");
		   
		      Assert.assertEquals(actual, expected);
		      
		      driver.close();	  		  		  
		}		
	
	
	
	

////Test ID: 18-28
///* 
///* Preview Information incident email    
//*/
	@Test (priority = 12)	
    public void previewInformationIncidentemail() throws InterruptedException {
			  System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		
		     // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Email Templates
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 

//		      // Click edit of first entry in table
//		      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[1]/td[3]/div/img[1]")).click();
		      
		      //Get the table and row
		      WebElement table =driver.findElement(By.id("gvEmailTemplates"));
		      WebElement tbody=table.findElement(By.tagName("tbody"));
			  List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			    String rowNo="";
				String title = "Information Incident";
				for(int i=0;i<rows.size();i++)
				{
				WebElement row = tbody.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr["+(i+1)+"]"));
				if(row.getText().trim().contains(title))
				{
				rowNo=Integer.toString(i+1);
				break;
				}
				}
				Thread.sleep(5000);
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr["+rowNo+"]/td[3]/div/img[2]")).click();
						      
		      // Switch to preview dialogue
		      driver.switchTo().activeElement(); 
		      
		      String expected = "Information Incident";
		      String actual = driver.findElement(By.id("tbTitlePreview")).getAttribute("value");
		   
		      Assert.assertEquals(actual, expected);
		      
		      driver.close();	  		  		  
		}
	
	
	
	

	
////Test ID: 18-30
///* 
///* Update Title of an Email
//*/
		    @Test (priority = 13)	
		    public void updateEmailTitle() throws InterruptedException {
			  System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		
		     // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Email Templates
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 

		      // Click edit of first entry in table
		      Thread.sleep(6000);
		      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[1]/td[3]/div/img[1]")).click();
		  	  
		  	  Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[2]/input")).isEnabled());
		      
		      driver.close();	  		  		  
		}	 		 
	
	
	
	


////Test ID: 18-31
///* 
///* Update Subject of an Email
//*/
		    @Test (priority = 14)	
		    public void updateSubjectofEmail() throws InterruptedException {
			  System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		
		     // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Email Templates
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 

		      // Click edit of first entry in table
		      Thread.sleep(6000);
		      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[1]/td[3]/div/img[1]")).click();
		      
		      // Clear subject & add something
		      Thread.sleep(6000);
		      driver.findElement(By.id("tbSubject")).clear(); 
		      driver.findElement(By.id("tbSubject")).sendKeys("Subject changed");
		      
		      // Click on update button
		      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();
		      
		      Thread.sleep(6000);
			  String expected = "Settings have been updated successfully";
			  // Get label msg
		  	  String actual = driver.findElement(By.id("lblMessage")).getText();
		  	  
		  	  Assert.assertEquals(actual, expected);
		      
		      driver.close();	  		  		  
		}	 		 
		    
		    
		    
		    
		    
////Test ID: 18-32
///* 
///* Update Body of an Email
//*/
		    @Test (priority = 15)	
  		    public void updateBodyofEmail() throws InterruptedException {
  			  System.setProperty("webdriver.gecko.driver", driverPath);
  			  driver = new FirefoxDriver();
  		      driver.get(baseUrl);	
  		
  		     // Signing in OmniPCX
  		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
  		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
  		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
  		      
  		      // Click on Email Templates
  		      Thread.sleep(10000);
  		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 

  		      // Click edit of first entry in table
  		      Thread.sleep(6000);
  		      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[1]/td[3]/div/img[1]")).click();
  		      
		      // Clear email body
		      Thread.sleep(6000);
		      driver.findElement(By.id("txtAreaBody")).clear();
		      driver.findElement(By.id("txtAreaBody")).sendKeys("Please refer to OmniPCX RECORD Administration Guide to configure Branch Server and enter the following OPR ID in Systems settings.");
		      
		      // Click on update button
		      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();
	      
  		      Thread.sleep(6000);
  			  String expected = "Settings have been updated successfully";
  			  // Get label msg
  		  	  String actual = driver.findElement(By.id("lblMessage")).getText();
  		  	  
  		  	  Assert.assertEquals(actual, expected);
  		      
  		      driver.close();	  		  		  
  		}	 		 		    
	
		    
		    
		   
		 
////Test ID: 18-33
///* 
///* Update Body of an Email with variables
//*/
    @Test (priority = 16)
		    public void verifyEmailTemplateswithVariables() throws InterruptedException {
			  System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		
		     // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Email Templates
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 

		      // Click edit of first entry in table
		      Thread.sleep(6000);
		      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[1]/td[3]/div/img[1]")).click();
		      
		      // Select a variable
		      Thread.sleep(6000);
			  Select dropdown = new Select(driver.findElement(By.id("ddlVariables")));
			  dropdown.selectByVisibleText("OPRID - [OPRID]");
		      
			  // Click on update button
		      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();
	      
  		      Thread.sleep(6000);
  			  String expected = "Settings have been updated successfully";
  			  // Get label msg
  		  	  String actual = driver.findElement(By.id("lblMessage")).getText();
  		  	  
  		  	  Assert.assertEquals(actual, expected);

		    driver.close();    
}
		    

  

	 
////Test ID: 18-36
///* 
///* Update Email Template with Special characters in subject
//*/
	 @Test (priority = 17)	
	    public void updatedEmailwithSpecialCharsinSubject() throws InterruptedException {
		  System.setProperty("webdriver.gecko.driver", driverPath);
		  driver = new FirefoxDriver();
	      driver.get(baseUrl);	
	
	     // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Email Templates
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 

	      // Click edit of first entry in table
	      Thread.sleep(6000);
	      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[1]/td[3]/div/img[1]")).click();
	      
	      // Clear subject & add special chars
	      Thread.sleep(6000);
	      driver.findElement(By.id("tbSubject")).clear(); 
	      driver.findElement(By.id("tbSubject")).sendKeys("$%&#^#$@^*%&()^$%?<><././,");
	      
	      // Click on update button
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();
	     	      
	      Thread.sleep(6000);
		  String expected = "Settings have been updated successfully";
		  // Get Subject after reset
	  	  String actual = driver.findElement(By.id("lblMessage")).getText();
	  	  
	  	  Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
	}			    					       	 
	 
	 
	 
	 
    
    
////Test ID: 18-34
///* 
///* Reset an updated Email Template
//*/
		    @Test (priority = 18)	
		    public void ResetupdatedEmail() throws InterruptedException {
			  System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		
		     // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Email Templates
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 

		      // Click edit of first entry in table
		      Thread.sleep(6000);
		      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[1]/td[3]/div/img[1]")).click();
		      
		      // Click on reset button
		      driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[3]/input")).click();
		     	      
		      Thread.sleep(6000);
			  String expected = "OmniPCX RECORD Branch Setup [Branch: [BRANCHNAME]]";
			  // Get Subject after reset
		  	  String actual = driver.findElement(By.id("tbSubject")).getAttribute("value");
		  	  
		  	  Assert.assertEquals(actual, expected);
		      
		      driver.close();	  		  		  
		}	
		    
		    
		    


////Test ID: 18-04(i)
///* 
///* Add Variable in the Body/Subject: Branch Information
//*/	
		    @Test (priority = 19)
		    public void addVariabletoEmail_BranchInformation() throws InterruptedException {
			  System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		
		     // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Email Templates
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 

		      // Click edit of Branch Information in table
		      Thread.sleep(6000);
		      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[1]/td[3]/div/img[1]")).click();
		      
		      // Select a variable
		      Thread.sleep(6000);
			  Select dropdown = new Select(driver.findElement(By.id("ddlVariables")));
			  dropdown.selectByVisibleText("OPRID - [OPRID]");
		      
			  // Click on update button
		      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();
	      
  		      Thread.sleep(6000);
  			  String expected = "Settings have been updated successfully";
  			  // Get label msg
  		  	  String actual = driver.findElement(By.id("lblMessage")).getText();
  		  	  
  		  	  Assert.assertEquals(actual, expected);

		    driver.close();    
}		    

		    
		    
		    
////Test ID: 18-04(ii)
///* 
///* Add Variable in the Body/Subject: Recorded Call Notification
//*/
		    @Test (priority = 20)
  		    public void addVariabletoEmail_RecordedCallNotification() throws InterruptedException {
  			  System.setProperty("webdriver.gecko.driver", driverPath);
  			  driver = new FirefoxDriver();
  		      driver.get(baseUrl);	
  		
  		     // Signing in OmniPCX
  		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
  		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
  		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
  		      
  		      // Click on Email Templates
  		      Thread.sleep(10000);
  		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 

  		      // Click edit of Recorded Call Notification in table
  		      Thread.sleep(6000);
  		      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[2]/td[3]/div/img[1]")).click();
  		      
  		      // Select a variable
  		      Thread.sleep(6000);
  			  Select dropdown = new Select(driver.findElement(By.id("ddlVariables")));
  			  dropdown.selectByVisibleText("AgentExtension - [AGENTEXTENSION]");
  		      
  			  // Click on update button
  		      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();
  	      
  		      Thread.sleep(6000);
			  String expected = "Settings have been updated successfully";
			  // Get label msg
		  	  String actual = driver.findElement(By.id("lblMessage")).getText();
		  	  
		  	  Assert.assertEquals(actual, expected);
    		     
  		    driver.close();    
  }		    
		  		    
		    

		    
		    
////Test ID: 18-04(iii)
///* 
///* Add Variable in the Body/Subject: OmniPCX RECORD Password Reset
//*/
		    @Test (priority = 21)
		    public void addVariabletoEmail_OmniPCXRECORDPasswordReset() throws InterruptedException {
			  System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		
		     // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Email Templates
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 

		      // Click edit of OmniPCX RECORD Password Reset in table
		      Thread.sleep(6000);
		      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[3]/td[3]/div/img[1]")).click();
		      
		      // Select a variable
		      Thread.sleep(6000);
			  Select dropdown = new Select(driver.findElement(By.id("ddlVariables")));
			  dropdown.selectByVisibleText("AgentName - [AGENTNAME]");
		      
			  // Click on update button
		      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();
	      
		      Thread.sleep(6000);
			  String expected = "Settings have been updated successfully";
			  // Get label msg
		  	  String actual = driver.findElement(By.id("lblMessage")).getText();
		  	  
		  	  Assert.assertEquals(actual, expected);
  		     
		    driver.close();    
}		  		    
		  		   
		    

		    
		    
////Test ID: 18-04(iv)
///* 
///* Add Variable in the Body/Subject: KPI Service Alert Email
//*/
		    @Test (priority = 22)
  		    public void addVariabletoEmail_KPIServiceAlertEmail() throws InterruptedException {
  			  System.setProperty("webdriver.gecko.driver", driverPath);
  			  driver = new FirefoxDriver();
  		      driver.get(baseUrl);	
  		
  		     // Signing in OmniPCX
  		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
  		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
  		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
  		      
  		      // Click on Email Templates
  		      Thread.sleep(10000);
  		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 

  		      // Click edit of KPI Service Alert Email in table
  		      Thread.sleep(6000);
  		      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[4]/td[3]/div/img[1]")).click();
  		      
  		      // Select a variable
  		      Thread.sleep(6000);
  			  Select dropdown = new Select(driver.findElement(By.id("ddlVariables")));
  			  dropdown.selectByVisibleText("ApplicationName - [APPLICATIONNAME]");
  		      
  			  // Click on update button
  		      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();
  	      
  		      Thread.sleep(6000);
  			  String expected = "Settings have been updated successfully";
  			  // Get label msg
  		  	  String actual = driver.findElement(By.id("lblMessage")).getText();
  		  	  
  		  	  Assert.assertEquals(actual, expected);
    		     
  		    driver.close();    
  }		  		    		    
		  		    
		    

		    
		    
		 
////Test ID: 18-04(v)
///* 
///* Add Variable in the Body/Subject: Critical error incident
//*/
		    @Test (priority = 23)
		    public void addVariabletoEmail_CriticalerrorIncident() throws InterruptedException {
			  System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		
		     // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Email Templates
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 

		      // Click edit of Critical error incident in table
		      Thread.sleep(6000);
		      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[5]/td[3]/div/img[1]")).click();
		      
		      // Select a variable
		      Thread.sleep(6000);
			  Select dropdown = new Select(driver.findElement(By.id("ddlVariables")));
			  dropdown.selectByVisibleText("IncidentModuleName - [MODULENAME]");
		      
			  // Click on update button
		      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();
	      
		      Thread.sleep(6000);
			  String expected = "Settings have been updated successfully";
			  // Get label msg
		  	  String actual = driver.findElement(By.id("lblMessage")).getText();
		  	  
		  	  Assert.assertEquals(actual, expected);
  		     
		    driver.close();    
}			    
		  		    
		  
		    
		    
		    
////Test ID: 18-04(vi)
///* 
///* Add Variable in the Body/Subject: Error Incident
//*/
		    @Test (priority = 24)
  		    public void addVariabletoEmail_ErrorIncident() throws InterruptedException {
  			  System.setProperty("webdriver.gecko.driver", driverPath);
  			  driver = new FirefoxDriver();
  		      driver.get(baseUrl);	
  		
  		     // Signing in OmniPCX
  		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
  		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
  		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
  		      
  		      // Click on Email Templates
  		      Thread.sleep(10000);
  		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 

  		      // Click edit of Error Incident in table
  		      Thread.sleep(6000);
  		      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[6]/td[3]/div/img[1]")).click();
  		      
  		      // Select a variable
  		      Thread.sleep(6000);
  			  Select dropdown = new Select(driver.findElement(By.id("ddlVariables")));
  			  dropdown.selectByVisibleText("ServerRole - [SERVERROLE]");
  		      
  			  // Click on update button
  		      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();
  	      
  		      Thread.sleep(6000);
  			  String expected = "Settings have been updated successfully";
  			  // Get label msg
  		  	  String actual = driver.findElement(By.id("lblMessage")).getText();
  		  	  
  		  	  Assert.assertEquals(actual, expected);
    		     
  		    driver.close();    
  }			    		    
		  		    
		    
		   

		    
		 
////Test ID: 18-04(vi)
///* 
///* Add Variable in the Body/Subject: Warning Incident
//*/
		    @Test (priority = 25)
		    public void addVariabletoEmail_WarningIncident() throws InterruptedException {
			  System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		
		     // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Email Templates
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 

		      // Click edit of Warning Incident in table
		      Thread.sleep(6000);
		      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[7]/td[3]/div/img[1]")).click();
		      
		      // Select a variable
		      Thread.sleep(6000);
			  Select dropdown = new Select(driver.findElement(By.id("ddlVariables")));
			  dropdown.selectByVisibleText("IncidentType - [INCIDENTTYPE]");
		      
			  // Click on update button
		      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();
	      
		      Thread.sleep(6000);
			  String expected = "Settings have been updated successfully";
			  // Get label msg
		  	  String actual = driver.findElement(By.id("lblMessage")).getText();
		  	  
		  	  Assert.assertEquals(actual, expected);
  		     
		    driver.close();    
}			    
		  		    
		    
		  		    	    

		    
		    
////Test ID: 18-04(viii)
///* 
///* Add Variable in the Body/Subject: Information Incident
//*/
  		    @Test (priority = 26)
  		    public void addVariabletoEmail_InformationIncident() throws InterruptedException {
  			  System.setProperty("webdriver.gecko.driver", driverPath);
  			  driver = new FirefoxDriver();
  		      driver.get(baseUrl);	
  		
  		     // Signing in OmniPCX
  		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
  		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
  		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
  		      
  		      // Click on Email Templates
  		      Thread.sleep(10000);
  		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 

  		      // Click edit of Information Incident in table
  		      Thread.sleep(6000);
  		      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[8]/td[3]/div/img[1]")).click();
  		      
  		      // Select a variable
  		      Thread.sleep(6000);
  			  Select dropdown = new Select(driver.findElement(By.id("ddlVariables")));
  			  dropdown.selectByVisibleText("IncidentDescription - [DESCRIPTION]");
  		      
  			  // Click on update button
  		      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();
  	      
  		      Thread.sleep(6000);
  			  String expected = "Settings have been updated successfully";
  			  // Get label msg
  		  	  String actual = driver.findElement(By.id("lblMessage")).getText();
  		  	  
  		  	  Assert.assertEquals(actual, expected);
    		     
  		    driver.close();    
  }			    
		    

  		    
  		    
  		
  		    
////Test ID: 18-07(i)
///* 
///* Make some editing according to your desire : Branch Information
//*/
  		  @Test (priority = 27)	
		    public void EditingofEmail_BranchInformation() throws InterruptedException {
			  System.setProperty("webdriver.gecko.driver", driverPath);
			  driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		
		     // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Email Templates
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 

		      // Click edit of Branch Information in table
		      Thread.sleep(6000);
		      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[1]/td[3]/div/img[1]")).click();
		      
		      // Clear subject & add something
		      Thread.sleep(6000);
		      driver.findElement(By.id("tbSubject")).clear(); 
		      driver.findElement(By.id("tbSubject")).sendKeys("Subject changed");
		      
	          // Clear email body
		      Thread.sleep(6000);
		      driver.findElement(By.id("txtAreaBody")).clear();
		      driver.findElement(By.id("txtAreaBody")).sendKeys("Please refer to OmniPCX RECORD Administration Guide to configure Branch Server and enter the following OPR ID in Systems settings.");

		      
		      // Click on update button
		      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();
		      
		      Thread.sleep(6000);
			  String expected = "Settings have been updated successfully";
			  // Get label msg
		  	  String actual = driver.findElement(By.id("lblMessage")).getText();
		  	  
		  	  Assert.assertEquals(actual, expected);
		      
		      driver.close();	  		  		  
		}
			   
			    
			    
			    

////Test ID: 18-07(ii)
///* 
///* Make some editing according to your desire : Recorded Call Notification
//*/
	  @Test (priority = 28)	
  	  public void EditingofEmail_RecordedCallNotification() throws InterruptedException {
  		System.setProperty("webdriver.gecko.driver", driverPath);
  		driver = new FirefoxDriver();
  	    driver.get(baseUrl);
  	    
  	      // Signing in OmniPCX
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Email Templates
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 
	
	      // Click edit of Recorded Call Notification in table
	      Thread.sleep(6000);
	      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[2]/td[3]/div/img[1]")).click();
	      
	      // Clear subject & add something
	      Thread.sleep(6000);
	      driver.findElement(By.id("tbSubject")).clear(); 
	      driver.findElement(By.id("tbSubject")).sendKeys("Subject changed");
	      
	      // Clear email body
	      Thread.sleep(6000);
	      driver.findElement(By.id("txtAreaBody")).clear();
	      driver.findElement(By.id("txtAreaBody")).sendKeys("Please refer to OmniPCX RECORD Administration Guide to configure Branch Server and enter the following OPR ID in Systems settings.");
	
	      // Click on update button
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();
	      
	      Thread.sleep(6000);
		  String expected = "Settings have been updated successfully";
		  // Get label msg
	  	  String actual = driver.findElement(By.id("lblMessage")).getText();
	  	  
	  	  Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
}				    
	     
  	
	  
	 
	 
	  
////Test ID: 18-07(iii)
///* 
///* Make some editing according to your desire : OmniPCX RECORD Password Reset
//*/
	  @Test (priority = 29)	
  	  public void EditingofEmail_OmniPCXRECORDPasswordReset() throws InterruptedException {
  		System.setProperty("webdriver.gecko.driver", driverPath);
  		driver = new FirefoxDriver();
  	    driver.get(baseUrl);
  	    
  	      // Signing in OmniPCX
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Email Templates
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 
	
	      // Click edit of OmniPCX RECORD Password Reset in table
	      Thread.sleep(6000);
	      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[3]/td[3]/div/img[1]")).click();
	      
	      // Clear subject & add something
	      Thread.sleep(6000);
	      driver.findElement(By.id("tbSubject")).clear(); 
	      driver.findElement(By.id("tbSubject")).sendKeys("Subject changed");
	      
	      // Clear email body
	      Thread.sleep(6000);
	      driver.findElement(By.id("txtAreaBody")).clear();
	      driver.findElement(By.id("txtAreaBody")).sendKeys("Please refer to OmniPCX RECORD Administration Guide to configure Branch Server and enter the following OPR ID in Systems settings.");
	
	      // Click on update button
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();
	      
	      Thread.sleep(6000);
		  String expected = "Settings have been updated successfully";
		  // Get label msg
	  	  String actual = driver.findElement(By.id("lblMessage")).getText();
	  	  
	  	  Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
}	  	  
  			     

	  
	  
////Test ID: 18-07(iv)
///* 
///* Make some editing according to your desire : KPI Service Alert Email
//*/
	  @Test (priority = 30)	
  	  public void EditingofEmail_KPIServiceAlertEmail() throws InterruptedException {
  		System.setProperty("webdriver.gecko.driver", driverPath);
  		driver = new FirefoxDriver();
  	    driver.get(baseUrl);
  	    
  	      // Signing in OmniPCX
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Email Templates
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 
	
	      // Click edit of KPI Service Alert Email in table
	      Thread.sleep(6000);
	      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[4]/td[3]/div/img[1]")).click();
	      
	      // Clear subject & add something
	      Thread.sleep(6000);
	      driver.findElement(By.id("tbSubject")).clear(); 
	      driver.findElement(By.id("tbSubject")).sendKeys("Subject changed");
	      
	      // Clear email body
	      Thread.sleep(6000);
	      driver.findElement(By.id("txtAreaBody")).clear();
	      driver.findElement(By.id("txtAreaBody")).sendKeys("Please refer to OmniPCX RECORD Administration Guide to configure Branch Server and enter the following OPR ID in Systems settings.");
	
	      // Click on update button
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();
	      
	      Thread.sleep(6000);
		  String expected = "Settings have been updated successfully";
		  // Get label msg
	  	  String actual = driver.findElement(By.id("lblMessage")).getText();
	  	  
	  	  Assert.assertEquals(actual, expected);
	      
	      driver.close();	  		  		  
}	
	  
	  
	  
	
	  
////Test ID: 18-07(v)
///* 
///* Make some editing according to your desire : Critical error incident
//*/
	  @Test (priority = 29)	
  	  public void EditingofEmail_Criticalerrorincident() throws InterruptedException {
  		System.setProperty("webdriver.gecko.driver", driverPath);
  		driver = new FirefoxDriver();
  	    driver.get(baseUrl);
  	    
  	      // Signing in OmniPCX
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Email Templates
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 
	
	      // Click edit of Critical error incident in table
	      Thread.sleep(6000);
	      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[5]/td[3]/div/img[1]")).click();
	      
	      // Clear subject & add something
	      Thread.sleep(6000);
	      driver.findElement(By.id("tbSubject")).clear(); 
	      driver.findElement(By.id("tbSubject")).sendKeys("Subject changed");
	      
	      // Clear email body
	      Thread.sleep(6000);
	      driver.findElement(By.id("txtAreaBody")).clear();
	      driver.findElement(By.id("txtAreaBody")).sendKeys("Please refer to OmniPCX RECORD Administration Guide to configure Branch Server and enter the following OPR ID in Systems settings.");
	
	      // Click on update button
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();
	      
	      Thread.sleep(6000);
		  String expected = "Settings have been updated successfully";
		  // Get label msg
	  	  String actual = driver.findElement(By.id("lblMessage")).getText();
	  	  
	  	  Assert.assertEquals(actual, expected);
	      
	      driver.close();	  			   		  
	}	  
	
	  	  
		  
	  
	
////Test ID: 18-07(vi)
///* 
///* Make some editing according to your desire : Error Incident
//*/
	  @Test (priority = 29)	
  	  public void EditingofEmail_ErrorIncident() throws InterruptedException {
  		System.setProperty("webdriver.gecko.driver", driverPath);
  		driver = new FirefoxDriver();
  	    driver.get(baseUrl);
  	    
  	      // Signing in OmniPCX
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Email Templates
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 
	
	      // Click edit of Error Incident in table
	      Thread.sleep(6000);
	      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[6]/td[3]/div/img[1]")).click();
	      
	      // Clear subject & add something
	      Thread.sleep(6000);
	      driver.findElement(By.id("tbSubject")).clear(); 
	      driver.findElement(By.id("tbSubject")).sendKeys("Subject changed");
	      
	      // Clear email body
	      Thread.sleep(6000);
	      driver.findElement(By.id("txtAreaBody")).clear();
	      driver.findElement(By.id("txtAreaBody")).sendKeys("Please refer to OmniPCX RECORD Administration Guide to configure Branch Server and enter the following OPR ID in Systems settings.");
	
	      // Click on update button
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();
	      
	      Thread.sleep(6000);
		  String expected = "Settings have been updated successfully";
		  // Get label msg
	  	  String actual = driver.findElement(By.id("lblMessage")).getText();
	  	  
	  	  Assert.assertEquals(actual, expected);
	      
	      driver.close();	  			   		  
	}	  
		  

	  
	  
	 
	  
////Test ID: 18-07(vii)
///* 
///* Make some editing according to your desire : Warning Incident
//*/
	  @Test (priority = 29)	
  	  public void EditingofEmail_WarningIncident() throws InterruptedException {
  		System.setProperty("webdriver.gecko.driver", driverPath);
  		driver = new FirefoxDriver();
  	    driver.get(baseUrl);
  	    
  	      // Signing in OmniPCX
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Email Templates
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 
	
	      // Click edit of Warning Incident in table
	      Thread.sleep(6000);
	      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[7]/td[3]/div/img[1]")).click();
	      
	      // Clear subject & add something
	      Thread.sleep(6000);
	      driver.findElement(By.id("tbSubject")).clear(); 
	      driver.findElement(By.id("tbSubject")).sendKeys("Subject changed");
	      
	      // Clear email body
	      Thread.sleep(6000);
	      driver.findElement(By.id("txtAreaBody")).clear();
	      driver.findElement(By.id("txtAreaBody")).sendKeys("Please refer to OmniPCX RECORD Administration Guide to configure Branch Server and enter the following OPR ID in Systems settings.");
	
	      // Click on update button
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();
	      
	      Thread.sleep(6000);
		  String expected = "Settings have been updated successfully";
		  // Get label msg
	  	  String actual = driver.findElement(By.id("lblMessage")).getText();
	  	  
	  	  Assert.assertEquals(actual, expected);
	      
	      driver.close();	  			   		  
	}	  
		  
 		    
	
	  
	  

////Test ID: 18-07(viii)
///* 
///* Make some editing according to your desire : Information Incident
//*/
	  @Test (priority = 29)	
  	  public void EditingofEmail_InformationIncident() throws InterruptedException {
  		System.setProperty("webdriver.gecko.driver", driverPath);
  		driver = new FirefoxDriver();
  	    driver.get(baseUrl);
  	    
  	      // Signing in OmniPCX
	  	  driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a"); 
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Email Templates
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();	 
	
	      // Click edit of Information Incident in table
	      Thread.sleep(6000);
	      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[8]/td[3]/div/img[1]")).click();
	      
	      // Clear subject & add something
	      Thread.sleep(6000);
	      driver.findElement(By.id("tbSubject")).clear(); 
	      driver.findElement(By.id("tbSubject")).sendKeys("Subject changed");
	      
	      // Clear email body
	      Thread.sleep(6000);
	      driver.findElement(By.id("txtAreaBody")).clear();
	      driver.findElement(By.id("txtAreaBody")).sendKeys("Please refer to OmniPCX RECORD Administration Guide to configure Branch Server and enter the following OPR ID in Systems settings.");
	
	      // Click on update button
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[3]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[1]/input")).click();
	      
	      Thread.sleep(6000);
		  String expected = "Settings have been updated successfully";
		  // Get label msg
	  	  String actual = driver.findElement(By.id("lblMessage")).getText();
	  	  
	  	  Assert.assertEquals(actual, expected);
	      
	      driver.close();	  			   		  
	}	  

	  
	  
	  

	  
////Test ID: 18-16
///* 
///* Verify the Email Template by switching the Languages.French Language
//*/	
	  @Test (priority = 30)
	  public void verifyChangeinEmailTemplatewithFrenchLanguage() throws InterruptedException {
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
		      
		      // Select French Language
		      driver.findElement(By.xpath("//*[@id=\"cboLanguage_msdd\"]/div[1]/span[2]")).click();
		  	  WebElement flags = driver.findElement(By.xpath("//*[@id=\"cboLanguage_child\"]/ul"));
		  	  List<WebElement> links = flags.findElements(By.tagName("li"));
		  	  	for (int i = 0; i < links.size(); i++){
		  	  			System.out.println(links.get(i).getText());}

		  	  		for (int j = 1; j < 2; j++) {
		  	  			//driver.findElement(By.xpath("//*[@id=\"cboLanguage_msdd\"]/div[1]/span[2]")).click();
		  	  			Thread.sleep(2000);
		  	  			WebElement flags1 = driver.findElement(By.xpath("//*[@id=\"cboLanguage_child\"]/ul"));
		  	  			List<WebElement> links1 = flags1.findElements(By.tagName("li"));
		  	  			Thread.sleep(2000);
		  	  			links1.get(j).click();
			  
			  // Click update button 
			  driver.findElement(By.id("btnUpdateLanguage")).click();
			  
			  Thread.sleep(10000);
			  
			  driver.get(baseUrl);
			  
			  // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Email Templates
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();
		      
		      if (j == 1) {
		      // Get page caption
		      String expected = "Modèles d'e-mails";
		      String actual = driver.findElement(By.id("ctl00_lblPageCaption")).getText();
		      
		      Assert.assertEquals(actual,expected);
		      
		      // Click edit of Branch Information in table
		      Thread.sleep(9000);
		      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[8]/td[3]/div/img[1]")).click();
		      
		      // Click on reset button
		      driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[3]/input")).click();	      
		      }
		      
		      else {
		      System.out.println("Test Failed");}  			   		  
		}	
		      driver.close();	
}
	  


	  
	  
////Test ID: 18-16
///* 
///* Verify the Email Template by switching the Languages. German Language
//*/	
	  @Test (priority = 31)
	  public void verifyChangeinEmailTemplatewithGermanLanguage() throws InterruptedException {
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
	      
	      // Select German Language
	      driver.findElement(By.xpath("//*[@id=\"cboLanguage_msdd\"]/div[1]/span[2]")).click();
	  	  WebElement flags = driver.findElement(By.xpath("//*[@id=\"cboLanguage_child\"]/ul"));
	  	  List<WebElement> links = flags.findElements(By.tagName("li"));
	  	  	for (int i = 0; i < links.size(); i++){
	  	  			System.out.println(links.get(i).getText());}

	  	  		for (int j = 2; j < 3; j++) {
	  	  			//driver.findElement(By.xpath("//*[@id=\"cboLanguage_msdd\"]/div[1]/span[2]")).click();
	  	  			Thread.sleep(2000);
	  	  			WebElement flags1 = driver.findElement(By.xpath("//*[@id=\"cboLanguage_child\"]/ul"));
	  	  			List<WebElement> links1 = flags1.findElements(By.tagName("li"));
	  	  			Thread.sleep(2000);
	  	  			links1.get(j).click();
		  
		  // Click update button 
		  driver.findElement(By.id("btnUpdateLanguage")).click();
		  
		  Thread.sleep(10000);
		  
		  driver.get(baseUrl);
		  
		  // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Email Templates
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();
	      
	      if (j == 2) {
	      // Get page caption
	      String expected = "E-Mail-Vorlagen";
	      String actual = driver.findElement(By.id("ctl00_lblPageCaption")).getText();
	      
	      Assert.assertEquals(actual,expected);
	      
	      // Click edit of Branch Information in table
	      Thread.sleep(9000);
	      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[8]/td[3]/div/img[1]")).click();
	      
	      // Click on reset button
	      driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[3]/input")).click();	      
	      }
	      
	      else {
		      System.out.println("Test Failed");}
	      driver.close();	  			   		  
	}	  			
}	  
  
	  
	  		  
	  		  

	  
////Test ID: 18-16
///* 
///* Verify the Email Template by switching the Languages.Italian Language
//*/
	  @Test (priority = 32)
	  public void verifyChangeinEmailTemplatewithItalianLanguage() throws InterruptedException {
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
	      
	      // Select Italian Language
	      driver.findElement(By.xpath("//*[@id=\"cboLanguage_msdd\"]/div[1]/span[2]")).click();
	  	  WebElement flags = driver.findElement(By.xpath("//*[@id=\"cboLanguage_child\"]/ul"));
	  	  List<WebElement> links = flags.findElements(By.tagName("li"));
	  	  	for (int i = 0; i < links.size(); i++){
	  	  			System.out.println(links.get(i).getText());}

	  	  		for (int j = 3; j < 4; j++) {
	  	  			//driver.findElement(By.xpath("//*[@id=\"cboLanguage_msdd\"]/div[1]/span[2]")).click();
	  	  			Thread.sleep(2000);
	  	  			WebElement flags1 = driver.findElement(By.xpath("//*[@id=\"cboLanguage_child\"]/ul"));
	  	  			List<WebElement> links1 = flags1.findElements(By.tagName("li"));
	  	  			Thread.sleep(2000);
	  	  			links1.get(j).click();
		  
		  // Click update button 
		  driver.findElement(By.id("btnUpdateLanguage")).click();
		  
		  Thread.sleep(10000);
		  
		  driver.get(baseUrl);
		  
		  // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Email Templates
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();
	      
	      if (j == 3) {
	      // Get page caption
	      String expected = "Modelli e-mail";
	      String actual = driver.findElement(By.id("ctl00_lblPageCaption")).getText();
	      
	      Assert.assertEquals(actual,expected);
	      
	      // Click edit of Branch Information in table
	      Thread.sleep(9000);
	      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[8]/td[3]/div/img[1]")).click();
	      
	      // Click on reset button
	      driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[3]/input")).click();	      
	      }
	      
	      else {
		      System.out.println("Test Failed");}
	      driver.close();	  					     		  
	}	  			
}	  
	  		  
	  		  
	  		  
	  		  

	  
	
////Test ID: 18-16
///* 
///* Verify the Email Template by switching the Languages. Spanish Language
//*/
	 @Test (priority = 33)
	 public void verifyChangeinEmailTemplatewithSpanishLanguage() throws InterruptedException {
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
	      
	      // Select Spanish Language
	      driver.findElement(By.xpath("//*[@id=\"cboLanguage_msdd\"]/div[1]/span[2]")).click();
	  	  WebElement flags = driver.findElement(By.xpath("//*[@id=\"cboLanguage_child\"]/ul"));
	  	  List<WebElement> links = flags.findElements(By.tagName("li"));
	  	  	for (int i = 0; i < links.size(); i++){
	  	  			System.out.println(links.get(i).getText());}

	  	  		for (int j = 4; j < 5; j++) {
	  	  			//driver.findElement(By.xpath("//*[@id=\"cboLanguage_msdd\"]/div[1]/span[2]")).click();
	  	  			Thread.sleep(2000);
	  	  			WebElement flags1 = driver.findElement(By.xpath("//*[@id=\"cboLanguage_child\"]/ul"));
	  	  			List<WebElement> links1 = flags1.findElements(By.tagName("li"));
	  	  			Thread.sleep(2000);
	  	  			links1.get(j).click();
		  
		  // Click update button 
		  driver.findElement(By.id("btnUpdateLanguage")).click();
		  
		  Thread.sleep(10000);
		  
		  driver.get(baseUrl);
		  
		  // Signing in OmniPCX
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	      
	      // Click on Email Templates
	      Thread.sleep(10000);
	      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();
	      
	      if (j == 4) {
	      // Get page caption
	      String expected = "Modelos de mensagens"; //"Plantillas de correo";
	      String actual = driver.findElement(By.id("ctl00_lblPageCaption")).getText();
	      
	      Assert.assertEquals(actual,expected);
	      
	      // Click edit of Branch Information in table
	      Thread.sleep(9000);
	      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[8]/td[3]/div/img[1]")).click();
	      
	      // Click on reset button
	      driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[3]/input")).click();	      
	      }
	      
	      else {
		      System.out.println("Test Failed");}
	      driver.close();	  					     		  
	}	  			
}	  		  
	  		  
	  		  
	  		  

	 
////Test ID: 18-16
///* 
///* Verify the Email Template by switching the Languages. Portuguese Language
//*/
		 @Test (priority = 34)
		 public void verifyChangeinEmailTemplatewithPortugueseLanguage() throws InterruptedException {
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
		      
		      // Select Portuguese Language
		      driver.findElement(By.xpath("//*[@id=\"cboLanguage_msdd\"]/div[1]/span[2]")).click();
		  	  WebElement flags = driver.findElement(By.xpath("//*[@id=\"cboLanguage_child\"]/ul"));
		  	  List<WebElement> links = flags.findElements(By.tagName("li"));
		  	  	for (int i = 0; i < links.size(); i++){
		  	  			System.out.println(links.get(i).getText());}

		  	  		for (int j = 5; j < 6; j++) {
		  	  			//driver.findElement(By.xpath("//*[@id=\"cboLanguage_msdd\"]/div[1]/span[2]")).click();
		  	  			Thread.sleep(2000);
		  	  			WebElement flags1 = driver.findElement(By.xpath("//*[@id=\"cboLanguage_child\"]/ul"));
		  	  			List<WebElement> links1 = flags1.findElements(By.tagName("li"));
		  	  			Thread.sleep(2000);
		  	  			links1.get(j).click();
			  
			  // Click update button 
			  driver.findElement(By.id("btnUpdateLanguage")).click();
			  
			  Thread.sleep(10000);
			  
			  driver.get(baseUrl);
			  
			  // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Email Templates
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();
		      
		      if (j == 5) {
		      // Get page caption
		      String expected = "Plantillas de correo"; // Modelos de mensagens
		      String actual = driver.findElement(By.id("ctl00_lblPageCaption")).getText();
		      
		      Assert.assertEquals(actual,expected);
		      
		      // Click edit of Branch Information in table
		      Thread.sleep(9000);
		      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[8]/td[3]/div/img[1]")).click();
		      
		      // Click on reset button
		      driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[3]/input")).click();	      
		      }
		      
		      else {
			      System.out.println("Test Failed");}
		      driver.close();	  					     		  
		}	  			
	}	 
	 
		 

		 
		 
	
////Test ID: 18-16
///* 
///* Verify the Email Template by switching the Languages. Brazilian Language
//*/
		 @Test (priority = 35)
		 public void verifyChangeinEmailTemplatewithBrazilianLanguage() throws InterruptedException {
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
		      
		      // Select Brazilian Language
		      driver.findElement(By.xpath("//*[@id=\"cboLanguage_msdd\"]/div[1]/span[2]")).click();
		  	  WebElement flags = driver.findElement(By.xpath("//*[@id=\"cboLanguage_child\"]/ul"));
		  	  List<WebElement> links = flags.findElements(By.tagName("li"));
		  	  	for (int i = 0; i < links.size(); i++){
		  	  			System.out.println(links.get(i).getText());}

		  	  		for (int j = 6; j < 7; j++) {
		  	  			//driver.findElement(By.xpath("//*[@id=\"cboLanguage_msdd\"]/div[1]/span[2]")).click();
		  	  			Thread.sleep(2000);
		  	  			WebElement flags1 = driver.findElement(By.xpath("//*[@id=\"cboLanguage_child\"]/ul"));
		  	  			List<WebElement> links1 = flags1.findElements(By.tagName("li"));
		  	  			Thread.sleep(2000);
		  	  			links1.get(j).click();
			  
			  // Click update button 
			  driver.findElement(By.id("btnUpdateLanguage")).click();
			  
			  Thread.sleep(10000);
			  
			  driver.get(baseUrl);
			  
			  // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Email Templates
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();
		      
		      if (j == 6) {
		      // Get page caption
		      String expected = "Modelos de e-mail";
		      String actual = driver.findElement(By.id("ctl00_lblPageCaption")).getText();
		      
		      Assert.assertEquals(actual,expected);
		      
		      // Click edit of Branch Information in table
		      Thread.sleep(9000);
		      driver.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr[8]/td[3]/div/img[1]")).click();
		      
		      // Click on reset button
		      driver.findElement(By.xpath("//*[@id=\"divEmailTemplates\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[8]/td[2]/table/tbody/tr/td[1]/table/tbody/tr/td[3]/input")).click();	      
		      }
		      
		      else {
			      System.out.println("Test Failed");}
		      driver.close();	  					     		  
		}	  			
	}	 		 				 
	  
	  
////Test ID: 18-22
///* 
///* Verify that default email templates names
//*/
	  @Test (priority = 14)
	  public void verifyChangeinLanguageSettings() throws InterruptedException {
			System.setProperty("webdriver.gecko.driver", driverPath);
		      driver = new FirefoxDriver();
		      driver.get(baseUrl);	
		
		     // Signing in OmniPCX
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		      
		      // Click on Email Templates
		      Thread.sleep(10000);
		      driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink12")).click();
		            
	      String[] emails = {"Branch Information", "Critical error incident", "Error Incident", "Warning Incident", "Information Incident"};
	      for (int j=0; j < emails.length; j++) {
	      //Get the table and row
	      WebElement table2 = driver.findElement(By.id("gvEmailTemplates"));
		  WebElement tbody2 = table2.findElement(By.tagName("tbody"));
		  List<WebElement> rows=tbody2.findElements(By.tagName("tr"));
		  @SuppressWarnings("unused")
		  String rowNo="";
		  String title = emails[j];
		    for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvEmailTemplates\"]/tbody/tr["+(i+1)+"]"));
			if(row.getText().trim().contains(title))
			{
			Assert.assertEquals(title, emails[j]);
			rowNo=Integer.toString(i+1);
			break;
			}
			}
//			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[3]/td/div/table/tbody/tr["+rowNo+"]/td[3]/div/img[1]")).click();
	      }
		      driver.close();	  			   		  
}	  
	  

	  
	  
@AfterTest
public void ChangeLanguagetoEnglish() throws InterruptedException {
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
	     
	     // Select English Language
	     driver.findElement(By.xpath("//*[@id=\"cboLanguage_msdd\"]/div[1]/span[2]")).click();
	 	  WebElement flags = driver.findElement(By.xpath("//*[@id=\"cboLanguage_child\"]/ul"));
	 	  List<WebElement> links = flags.findElements(By.tagName("li"));
	 	  	for (int i = 0; i < links.size(); i++){
	 	  			System.out.println(links.get(i).getText());}

//	 	  		for (int j = 6; j < 7; j++) {
	 	  			driver.findElement(By.xpath("//*[@id=\"cboLanguage_child\"]/ul/li[1]")).click();
//	 	  			Thread.sleep(2000);
//	 	  			WebElement flags1 = driver.findElement(By.xpath("//*[@id=\"cboLanguage_child\"]/ul")); //
//	 	  			List<WebElement> links1 = flags1.findElements(By.tagName("li"));
//	 	  			Thread.sleep(2000);
//	 	  			links1.get(j).click();
		  
		  // Click update button 
		  driver.findElement(By.id("btnUpdateLanguage")).click();
		  
		  Thread.sleep(10000);
			  
	     driver.close();	  					     		  
		  			
	}	 		 				 
	  
    
	  
	  
	  
	  
		  	
		      
}
