package SiteAdministration;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import Settings.SharedFunctions;
import Settings.TestResult;
import Settings.UpdateTestResult;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.*;

public class Site_Agent_Management {

   public ArrayList<TestResult> testresultlist = new ArrayList<TestResult>();
	
    public String siteUrl = "http://172.20.20.134/OmniPCXRECORD/Default.aspx";
	
    public static String driverPath = "C:\\Users\\Administrator\\Desktop\\FilesToSetup\\geckodriver.exe";
	
	public String SheetName = "29- Permission's";
    
	public static WebDriver driver;

	public SharedFunctions SF = new SharedFunctions();
	
	UpdateTestResult obj = new UpdateTestResult();
	
	
//	WebDriver driver = null;
	//WebDriverWait wait = new WebDriverWait(driver, 15);
//	public String siteUrl = "http://172.20.22.81/OmniPCXRECORD/default.aspx";
	public String ExpectedSiteURL = "http://172.20.22.81/OmniPCXRECORD/default.aspx";
	public String ExpectedServerURL = "http://172.20.22.81/OmniPCXRecord/TenantAdmin.aspx";
	
	@BeforeTest
	public void setUpTest() {
		
		System.out.println(this.getClass().getName());
		driver=((SharedFunctions)SF).InitializeDriver(); 
		
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrator\\Desktop\\FilesToSetup\\geckodriver.exe");
//		
//		driver=new FirefoxDriver();
	}

	

	//Test ID 10-01
		//Verification of the 'Add Agents' button.

	@Test(priority=0)
	public void VerificationOfAddAgentButton() throws InterruptedException {
		System.out.println("VerificationOfAddAgentButton");
		driver.get(siteUrl);
		
		String SheetName = "10- Agents Management";
		 String TestCaseID = "10-01";
		 String Status = "";
		 
		 if(driver==null){
			 
			 System.out.println("WebDriver not initialized");
			 return;
		  }
		  
		  try{
			  
			  
			  ((SharedFunctions)SF).loginTenantSiteAdmin(driver);
			  ((SharedFunctions)SF).clickServerPermissions(driver);
		
		
//		//Enter Site Code
//			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
//		//Enter Username
//			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
//		//Enter Password
//			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
//		//Click on Login button
//			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
		
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Add Agent 
			driver.findElement(By.id("linkAddAgent")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_lblPageCaption")));
		//Check the Agent details page is open
			String expectedmsg= "Agent Details";
			String actualmsg = driver.findElement(By.id("ctl00_lblPageCaption")).getText();
			Assert.assertEquals(actualmsg, expectedmsg); 
		Thread.sleep(2000);
	      
          Status = "Pass";
          ((SharedFunctions)SF).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			testresultlist.add(objtestreult);
			// obj.updateResult(TestCaseID, SheetName, Status);

		} catch (Throwable e) {
			System.out.println("Error : " + e);
			Status = "Fail";
			((SharedFunctions)SF).TakeScreenshot(driver, TestCaseID, Status, this.getClass().getName());
			TestResult objtestreult = new TestResult(SheetName, TestCaseID, Status);
			testresultlist.add(objtestreult);
		}
		
		
		
	}		
	

	
	
	//Test ID 10-02
		//Verify Add Agent functionality 
	@Test(priority=1)
	public void VerifyAddAgent() throws InterruptedException {
		System.out.println("VerifyAddAgent");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Add Agent 
			driver.findElement(By.id("linkAddAgent")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbFirstName")));
		//Enter First Name
			driver.findElement(By.id("tbFirstName")).sendKeys("Test");
		//Enter Last Name
			driver.findElement(By.id("tbLastName")).sendKeys("Agent");
		//Enter Username
			driver.findElement(By.id("tbUsername")).sendKeys("testagent");
		//Enter Password
			driver.findElement(By.id("tbPassword")).sendKeys("1234567b");
		//Enter Confirm Password
			driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567b");
		//Enter Email
			driver.findElement(By.id("tbEmail")).sendKeys("testagent@msn.com");
		//Select checkbox "Enable Account"
			driver.findElement(By.id("cbEnableAccount")).click();
		//Select Extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
		
			
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		//Select the Agent security group from Available table
			//Get the table and row
			WebElement table1 =driver.findElement(By.id("Table2"));
			WebElement tbody1=table1.findElement(By.tagName("tbody"));
			List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
			String row1No="";
			String Security_Group = "Agent";
			for(int i=0;i<rows1.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
			//row1No=row1No+1;
			row1No=Integer.toString(i+1);
			
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
		
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg = "Settings have been saved successfully. Do you want to add rules for this user?";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);
			
		//Click on Cancel button on popup window
			driver.findElement(By.xpath("//*[@id=\"btnCancel\"]/span")).click();
		Thread.sleep(2000);
		//Search the added agent
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("testagent");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "testagent";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
			
			if(row.getText().trim().contains(Username))
			{
				String expectedusername = row.getText();
				Assert.assertEquals(Username, expectedusername);
				
				System.out.println("Expected User name : "+expectedusername);
				System.out.println("Actual Username : " +Username);
			//break;
			}
			}
	}
	
	
	
	
	//Delete the agent which is created in Test ID 10-02
	
	@Test(priority=2)
	public void DeleteAgent() throws InterruptedException {
		System.out.println("DeleteAgent");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFieldName")));
		//Search the added agent	
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("testagent");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "testagent";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
			
			if(row.getText().trim().contains(Username))
			{
				String expectedusername = row.getText();
				Assert.assertEquals(Username, expectedusername);
				
				System.out.println("Expected User name : "+expectedusername);
				System.out.println("Actual Username : " +Username);
				row2No=Integer.toString(i+1);
				break;
			 }
			 }
			 System.out.println(row2No);
			 driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/table/tbody/tr["+row2No+"]/td[7]/div/img[2]")).click();
			 
			 String expectedmsg1="Are you sure you want to delete?";
		//Wait for the browser to respond
			 WebDriverWait wait2 = new WebDriverWait(driver,30);
			 WebElement btnMain2;
			 btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			 String actualmsg1 = driver.findElement(By.id("dialog-message")).getText();
			 Assert.assertEquals(actualmsg1, expectedmsg1);
			 
			 System.out.println("Expected Result : "+expectedmsg1);
			 System.out.println("Actual Result : " +actualmsg1);
		//Click on Delete button
			 driver.findElement(By.id("btnDelete")).click();
		//Verify the message
			 String expectedmsg2="Record has been deleted successfully";
		//Wait for the browser to respond
			 WebDriverWait wait3 = new WebDriverWait(driver,30);
			 WebElement btnMain3;
			 btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblErrorMsg")));
			 String actualmsg2 = driver.findElement(By.id("lblErrorMsg")).getText();
			 Assert.assertEquals(actualmsg2, expectedmsg2);
			 
			 System.out.println("Expected Result1 : "+expectedmsg2);
			 System.out.println("Actual Result1 : " +actualmsg2);
			 
			}

	
	
	


	
	//Test ID 10-03
		//Verify validation of Add Agent functionality by leaving first name empty
	@Test(priority=3)
	public void VerifyAddAgentWithEmptyFirstName() throws InterruptedException {
		System.out.println("VerifyAddAgentWithEmptyFirstName");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Add Agent 
			driver.findElement(By.id("linkAddAgent")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbFirstName")));
		//Enter First Name
			driver.findElement(By.id("tbFirstName")).sendKeys("");
		//Enter Last Name
			driver.findElement(By.id("tbLastName")).sendKeys("Agent");
		//Enter Username
			driver.findElement(By.id("tbUsername")).sendKeys("testagent");
		//Enter Password
			driver.findElement(By.id("tbPassword")).sendKeys("1234567b");
		//Enter Confirm Password
			driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567b");
		//Enter Email
			driver.findElement(By.id("tbEmail")).sendKeys("testagent@msn.com");
		//Select checkbox "Enable Account"
			driver.findElement(By.id("cbEnableAccount")).click();
		//Select Extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
		
			
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		//Select the Agent security group from Available table
			//Get the table and row
			WebElement table1 =driver.findElement(By.id("Table2"));
			WebElement tbody1=table1.findElement(By.tagName("tbody"));
			List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
			String row1No="";
			String Security_Group = "Agent";
			for(int i=0;i<rows1.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
			//row1No=row1No+1;
			row1No=Integer.toString(i+1);
			
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
		
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg = "Please enter First name";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMsg")));
			String actualmsg = driver.findElement(By.id("lblMsg")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);			
				System.out.println("Expected Result : "+expectedmsg);
				System.out.println("Actual Result : " +actualmsg);
			
			}			


	
	
	
	
	//Test ID 10-04
		//Verify validation of Add Agent functionality by leaving Last name empty
	@Test(priority=4)
	public void VerifyAddAgentWithEmptyLastName() throws InterruptedException {
		System.out.println("VerifyAddAgentWithEmptyLastName");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Add Agent 
			driver.findElement(By.id("linkAddAgent")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbFirstName")));
		//Enter First Name
			driver.findElement(By.id("tbFirstName")).sendKeys("Test");
		//Enter Last Name
			driver.findElement(By.id("tbLastName")).sendKeys("");
		//Enter Username
			driver.findElement(By.id("tbUsername")).sendKeys("testagent");
		//Enter Password
			driver.findElement(By.id("tbPassword")).sendKeys("1234567b");
		//Enter Confirm Password
			driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567b");
		//Enter Email
			driver.findElement(By.id("tbEmail")).sendKeys("testagent@msn.com");
		//Select checkbox "Enable Account"
			driver.findElement(By.id("cbEnableAccount")).click();
		//Select Extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
		
			
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		//Select the Agent security group from Available table
			//Get the table and row
			WebElement table1 =driver.findElement(By.id("Table2"));
			WebElement tbody1=table1.findElement(By.tagName("tbody"));
			List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
			String row1No="";
			String Security_Group = "Agent";
			for(int i=0;i<rows1.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
			//row1No=row1No+1;
			row1No=Integer.toString(i+1);
			
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
		
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg = "Please enter Last name";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMsg")));
			String actualmsg = driver.findElement(By.id("lblMsg")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);			
				System.out.println("Expected Result : "+expectedmsg);
				System.out.println("Actual Result : " +actualmsg);
			
			}			
	
	
	
	
	
	//Test ID 10-05
		//Verify validation of Add Agent functionality by leaving username empty
	@Test(priority=5)
	public void VerifyAddAgentWithEmptyUsername() throws InterruptedException {
		System.out.println("VerifyAddAgentWithEmptyUsername");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Add Agent 
			driver.findElement(By.id("linkAddAgent")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbFirstName")));
		//Enter First Name
			driver.findElement(By.id("tbFirstName")).sendKeys("Test");
		//Enter Last Name
			driver.findElement(By.id("tbLastName")).sendKeys("Agent");
		//Enter Username
			driver.findElement(By.id("tbUsername")).sendKeys("");
		//Enter Password
			driver.findElement(By.id("tbPassword")).sendKeys("1234567b");
		//Enter Confirm Password
			driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567b");
		//Enter Email
			driver.findElement(By.id("tbEmail")).sendKeys("testagent@msn.com");
		//Select checkbox "Enable Account"
			driver.findElement(By.id("cbEnableAccount")).click();
		//Select Extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
		
			
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		//Select the Agent security group from Available table
			//Get the table and row
			WebElement table1 =driver.findElement(By.id("Table2"));
			WebElement tbody1=table1.findElement(By.tagName("tbody"));
			List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
			String row1No="";
			String Security_Group = "Agent";
			for(int i=0;i<rows1.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
			//row1No=row1No+1;
			row1No=Integer.toString(i+1);
			
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
		
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg = "Please enter Username";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMsg")));
			String actualmsg = driver.findElement(By.id("lblMsg")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);			
				System.out.println("Expected Result : "+expectedmsg);
				System.out.println("Actual Result : " +actualmsg);
			}
	
	
	
	
	
	//Test ID 10-06
		//Verify validation of Add Agent functionality by leaving Password field empty
	@Test(priority=6)
	public void VerifyAddAgentWithEmptyPassword() throws InterruptedException {
		System.out.println("VerifyAddAgentWithEmptyPassword");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Add Agent 
			driver.findElement(By.id("linkAddAgent")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbFirstName")));
		//Enter First Name
			driver.findElement(By.id("tbFirstName")).sendKeys("Test");
		//Enter Last Name
			driver.findElement(By.id("tbLastName")).sendKeys("Agent");
		//Enter Username
			driver.findElement(By.id("tbUsername")).sendKeys("testagent");
		//Enter Password
			driver.findElement(By.id("tbPassword")).sendKeys("");
		//Enter Confirm Password
			driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567b");
		//Enter Email
			driver.findElement(By.id("tbEmail")).sendKeys("testagent@msn.com");
		//Select checkbox "Enable Account"
			driver.findElement(By.id("cbEnableAccount")).click();
		//Select Extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
		
			
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		//Select the Agent security group from Available table
			//Get the table and row
			WebElement table1 =driver.findElement(By.id("Table2"));
			WebElement tbody1=table1.findElement(By.tagName("tbody"));
			List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
			String row1No="";
			String Security_Group = "Agent";
			for(int i=0;i<rows1.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
			//row1No=row1No+1;
			row1No=Integer.toString(i+1);
			
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
		
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg = "Please enter Password";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMsg")));
			String actualmsg = driver.findElement(By.id("lblMsg")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);			
				System.out.println("Expected Result : "+expectedmsg);
				System.out.println("Actual Result : " +actualmsg);
			}
	
	
	
	

	
	
		//Verify validation of Add Agent functionality with mismatched password and confirm password
	@Test(priority=7)
	public void VerifyAddAgentWithMismatchedPassword() throws InterruptedException {
		System.out.println("VerifyAddAgentWithMismatchedPassword");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Add Agent 
			driver.findElement(By.id("linkAddAgent")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbFirstName")));
		//Enter First Name
			driver.findElement(By.id("tbFirstName")).sendKeys("Test");
		//Enter Last Name
			driver.findElement(By.id("tbLastName")).sendKeys("Agent");
		//Enter Username
			driver.findElement(By.id("tbUsername")).sendKeys("testagent");
		//Enter Password
			driver.findElement(By.id("tbPassword")).sendKeys("1234567a");
		//Enter Confirm Password
			driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567b");
		//Enter Email
			driver.findElement(By.id("tbEmail")).sendKeys("testagent@msn.com");
		//Select checkbox "Enable Account"
			driver.findElement(By.id("cbEnableAccount")).click();
		//Select Extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
		
			
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		//Select the Agent security group from Available table
			//Get the table and row
			WebElement table1 =driver.findElement(By.id("Table2"));
			WebElement tbody1=table1.findElement(By.tagName("tbody"));
			List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
			String row1No="";
			String Security_Group = "Agent";
			for(int i=0;i<rows1.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
			//row1No=row1No+1;
			row1No=Integer.toString(i+1);
			
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
		
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg = "Password and Confirm Password not same";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMsg")));
			String actualmsg = driver.findElement(By.id("lblMsg")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);			
				System.out.println("Expected Result : "+expectedmsg);
				System.out.println("Actual Result : " +actualmsg);
			}
	
	
	
	
	//Test ID 10-07
		//Verify validation of Add Agent functionality by leaving Extension tab empty
	@Test(priority=8)
	public void VerifyAddAgentWithoutExtension() throws InterruptedException {
		System.out.println("VerifyAddAgentWithoutExtension");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Add Agent 
			driver.findElement(By.id("linkAddAgent")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbFirstName")));
		//Enter First Name
			driver.findElement(By.id("tbFirstName")).sendKeys("Test");
		//Enter Last Name
			driver.findElement(By.id("tbLastName")).sendKeys("Agent");
		//Enter Username
			driver.findElement(By.id("tbUsername")).sendKeys("testagent");
		//Enter Password
			driver.findElement(By.id("tbPassword")).sendKeys("1234567b");
		//Enter Confirm Password
			driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567b");
		//Enter Email
			driver.findElement(By.id("tbEmail")).sendKeys("testagent@msn.com");
		//Select checkbox "Enable Account"
			driver.findElement(By.id("cbEnableAccount")).click();
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
		
			
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		//Select the Agent security group from Available table
			//Get the table and row
			WebElement table1 =driver.findElement(By.id("Table2"));
			WebElement tbody1=table1.findElement(By.tagName("tbody"));
			List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
			String row1No="";
			String Security_Group = "Agent";
			for(int i=0;i<rows1.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
			//row1No=row1No+1;
			row1No=Integer.toString(i+1);
			
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
		
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg = "The agent must have at least one extension";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMsg")));
			String actualmsg = driver.findElement(By.id("lblMsg")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);			
				System.out.println("Expected Result : "+expectedmsg);
				System.out.println("Actual Result : " +actualmsg);
			}
	
	
	
	
	//Test ID 10-08
		//Verify validation of Add Agent functionality by leaving Team tab empty
	@Test(priority=9)
	public void VerifyAddAgentWithoutTeam() throws InterruptedException {
		System.out.println("VerifyAddAgentWithoutTeam");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Add Agent 
			driver.findElement(By.id("linkAddAgent")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbFirstName")));
		//Enter First Name
			driver.findElement(By.id("tbFirstName")).sendKeys("Test");
		//Enter Last Name
			driver.findElement(By.id("tbLastName")).sendKeys("Agent");
		//Enter Username
			driver.findElement(By.id("tbUsername")).sendKeys("testagent");
		//Enter Password
			driver.findElement(By.id("tbPassword")).sendKeys("1234567b");
		//Enter Confirm Password
			driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567b");
		//Enter Email
			driver.findElement(By.id("tbEmail")).sendKeys("testagent@msn.com");
		//Select checkbox "Enable Account"
			driver.findElement(By.id("cbEnableAccount")).click();
		//Select Extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select the Agent security group from Available table
			//Get the table and row
			WebElement table1 =driver.findElement(By.id("Table2"));
			WebElement tbody1=table1.findElement(By.tagName("tbody"));
			List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
			String row1No="";
			String Security_Group = "Agent";
			for(int i=0;i<rows1.size();i++)
			{
			WebElement row = tbody1.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
			//row1No=row1No+1;
			row1No=Integer.toString(i+1);
			
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
		
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg = "The agent must be member of at least one team";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMsg")));
			String actualmsg = driver.findElement(By.id("lblMsg")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);			
				System.out.println("Expected Result : "+expectedmsg);
				System.out.println("Actual Result : " +actualmsg);
			}
	
	
	
	
	
	//Test ID 10-09
		//Verify validation of Add Agent functionality by leaving Role tab empty
	@Test(priority=10)
	public void VerifyAddAgentWithoutSecurityGroup() throws InterruptedException {
		System.out.println("VerifyAddAgentWithoutSecurityGroup");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Add Agent 
			driver.findElement(By.id("linkAddAgent")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbFirstName")));
		//Enter First Name
			driver.findElement(By.id("tbFirstName")).sendKeys("Test");
		//Enter Last Name
			driver.findElement(By.id("tbLastName")).sendKeys("Agent");
		//Enter Username
			driver.findElement(By.id("tbUsername")).sendKeys("testagent");
		//Enter Password
			driver.findElement(By.id("tbPassword")).sendKeys("1234567b");
		//Enter Confirm Password
			driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567b");
		//Enter Email
			driver.findElement(By.id("tbEmail")).sendKeys("testagent@msn.com");
		//Select checkbox "Enable Account"
			driver.findElement(By.id("cbEnableAccount")).click();
		//Select Extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
		
			
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg = "Select at least one role for the agent.";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMsg")));
			String actualmsg = driver.findElement(By.id("lblMsg")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);			
				System.out.println("Expected Result : "+expectedmsg);
				System.out.println("Actual Result : " +actualmsg);
			}
	
	
	
	
	
	
	//Test ID 10-10
		//Verify validation of Add Agent functionality by Special char in username
		//This test case will not be executed because web is not accepting special char in username and added the agent without special char in username
	
	
	
	//Test ID 10-11
		//Verify validation of Add Agent functionality by entering 5 digit numeric in password/ confirm password field
	@Test(priority=11)
	public void VerifyAddAgentWith5DigitPassword() throws InterruptedException {
		System.out.println("VerifyAddAgentWith5DigitPassword");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Add Agent 
			driver.findElement(By.id("linkAddAgent")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbFirstName")));
		//Enter First Name
			driver.findElement(By.id("tbFirstName")).sendKeys("Test");
		//Enter Last Name
			driver.findElement(By.id("tbLastName")).sendKeys("Agent");
		//Enter Username
			driver.findElement(By.id("tbUsername")).sendKeys("testagent");
		//Enter Password
			driver.findElement(By.id("tbPassword")).sendKeys("12345");
		//Enter Confirm Password
			driver.findElement(By.id("tbConfirmPassword")).sendKeys("12345");
		//Enter Email
			driver.findElement(By.id("tbEmail")).sendKeys("testagent@msn.com");
		//Select checkbox "Enable Account"
			driver.findElement(By.id("cbEnableAccount")).click();
		//Select Extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
		
			
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		//Select the Agent security group from Available table
			//Get the table and row
			WebElement table1 =driver.findElement(By.id("Table2"));
			WebElement tbody1=table1.findElement(By.tagName("tbody"));
			List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
			String row1No="";
			String Security_Group = "Agent";
			for(int i=0;i<rows1.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
			//row1No=row1No+1;
			row1No=Integer.toString(i+1);
			
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
		
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg = "Password must be greater than 7 characters";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMsg")));
			String actualmsg = driver.findElement(By.id("lblMsg")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);			
				System.out.println("Expected Result : "+expectedmsg);
				System.out.println("Actual Result : " +actualmsg);
			}
	
	
	
	
	
	
	//Test ID 10-12
		//Verify validation of Add Agent functionality by entering 9 digit numeric in password/ confirm password field
	@Test(priority=12)
	public void VerifyAddAgentWith9DigitNumericPassword() throws InterruptedException {
		System.out.println("VerifyAddAgentWith9DigitNumericPassword");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Add Agent 
			driver.findElement(By.id("linkAddAgent")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbFirstName")));
		//Enter First Name
			driver.findElement(By.id("tbFirstName")).sendKeys("Test");
		//Enter Last Name
			driver.findElement(By.id("tbLastName")).sendKeys("Agent");
		//Enter Username
			driver.findElement(By.id("tbUsername")).sendKeys("testagent");
		//Enter Password
			driver.findElement(By.id("tbPassword")).sendKeys("123456789");
		//Enter Confirm Password
			driver.findElement(By.id("tbConfirmPassword")).sendKeys("123456789");
		//Enter Email
			driver.findElement(By.id("tbEmail")).sendKeys("testagent@msn.com");
		//Select checkbox "Enable Account"
			driver.findElement(By.id("cbEnableAccount")).click();
		//Select Extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
		
			
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		//Select the Agent security group from Available table
			//Get the table and row
			WebElement table1 =driver.findElement(By.id("Table2"));
			WebElement tbody1=table1.findElement(By.tagName("tbody"));
			List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
			String row1No="";
			String Security_Group = "Agent";
			for(int i=0;i<rows1.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
			//row1No=row1No+1;
			row1No=Integer.toString(i+1);
			
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
		
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg = "Password must contain alphanumeric characters, with no more than two identical consecutive characters.";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMsg")));
			String actualmsg = driver.findElement(By.id("lblMsg")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);			
				System.out.println("Expected Result : "+expectedmsg);
				System.out.println("Actual Result : " +actualmsg);
			}
	
	

	
	
	
	//Test ID 10-13 is same as 10-02
	
	
	
	//Test ID 10-14
		//Verify validation of Add Agent functionality by entering Invalid email address
	@Test(priority=13)
	public void VerifyAddAgentWithInvalidEmail() throws InterruptedException {
		System.out.println("VerifyAddAgentWithInvalidEmail");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Add Agent 
			driver.findElement(By.id("linkAddAgent")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbFirstName")));
		//Enter First Name
			driver.findElement(By.id("tbFirstName")).sendKeys("Test");
		//Enter Last Name
			driver.findElement(By.id("tbLastName")).sendKeys("Agent");
		//Enter Username
			driver.findElement(By.id("tbUsername")).sendKeys("testagent");
		//Enter Password
			driver.findElement(By.id("tbPassword")).sendKeys("1234567b");
		//Enter Confirm Password
			driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567b");
		//Enter Email
			driver.findElement(By.id("tbEmail")).sendKeys("testagent@msn");
		//Select checkbox "Enable Account"
			driver.findElement(By.id("cbEnableAccount")).click();
		//Select Extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
		
			
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		//Select the Agent security group from Available table
			//Get the table and row
			WebElement table1 =driver.findElement(By.id("Table2"));
			WebElement tbody1=table1.findElement(By.tagName("tbody"));
			List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
			String row1No="";
			String Security_Group = "Agent";
			for(int i=0;i<rows1.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
			//row1No=row1No+1;
			row1No=Integer.toString(i+1);
			
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
		
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg = "Invalid Email Address";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMsg")));
			String actualmsg = driver.findElement(By.id("lblMsg")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);			
				System.out.println("Expected Result : "+expectedmsg);
				System.out.println("Actual Result : " +actualmsg);
			}
	
	
	
	
	
	//Test ID 10-15
		//Verify validation of Add Agent functionality with empty windows username and Enable Video is true/yes
	@Test(priority=14)
	public void VerifyAddAgentWithEmptyWindowsUsername() throws InterruptedException {
		System.out.println("VerifyAddAgentWithEmptyWindowsUsername");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Add Agent 
			driver.findElement(By.id("linkAddAgent")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbFirstName")));
		//Enter First Name
			driver.findElement(By.id("tbFirstName")).sendKeys("Test");
		//Enter Last Name
			driver.findElement(By.id("tbLastName")).sendKeys("Agent");
		//Enter Username
			driver.findElement(By.id("tbUsername")).sendKeys("testagent");
		//Enter Password
			driver.findElement(By.id("tbPassword")).sendKeys("1234567b");
		//Enter Confirm Password
			driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567b");
		//Enter Email
			driver.findElement(By.id("tbEmail")).sendKeys("testagent@msn.com");
		//Select checkbox "Enable Account"
			driver.findElement(By.id("cbEnableAccount")).click();
		//Enable Video
			driver.findElement(By.id("ddlSCCriteria")).click();
			Select dropdown = new Select(driver.findElement(By.id("ddlSCCriteria")));
			  dropdown.selectByVisibleText("Yes");
			
		//Select Extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
		
			
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		//Select the Agent security group from Available table
			//Get the table and row
			WebElement table1 =driver.findElement(By.id("Table2"));
			WebElement tbody1=table1.findElement(By.tagName("tbody"));
			List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
			String row1No="";
			String Security_Group = "Agent";
			for(int i=0;i<rows1.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
			//row1No=row1No+1;
			row1No=Integer.toString(i+1);
			
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
		
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg = "Please enter Windows Username or set Enable video option to 'No'";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMsg")));
			String actualmsg = driver.findElement(By.id("lblMsg")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);			
				System.out.println("Expected Result : "+expectedmsg);
				System.out.println("Actual Result : " +actualmsg);
			}
	
	
	
	
	
	
	//Test ID 10-16 is pending
	
	
	//Test ID 10-17
		//"Verification of assigning multiple ‘Teams’ and 'Extensions' to an agent.
	@Test(priority=15)
	public void VerifyAddAgentWithMultipleTeamsAndExtensions() throws InterruptedException {
		System.out.println("VerifyAddAgentWithMultipleTeamsAndExtensions");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Add Agent 
			driver.findElement(By.id("linkAddAgent")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbFirstName")));
		//Enter First Name
			driver.findElement(By.id("tbFirstName")).sendKeys("Test");
		//Enter Last Name
			driver.findElement(By.id("tbLastName")).sendKeys("Agent");
		//Enter Username
			driver.findElement(By.id("tbUsername")).sendKeys("testagent");
		//Enter Password
			driver.findElement(By.id("tbPassword")).sendKeys("1234567b");
		//Enter Confirm Password
			driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567b");
		//Enter Email
			driver.findElement(By.id("tbEmail")).sendKeys("testagent@msn.com");
		//Select checkbox "Enable Account"
			driver.findElement(By.id("cbEnableAccount")).click();
		//Select first Extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select second Extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[2]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();	
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
		
			
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
			
			
			//Select the Support team from the All teams table
			//Get the table and row
				WebElement table1 =driver.findElement(By.id("Table1"));
				WebElement tbody1=table1.findElement(By.tagName("tbody"));
				List<WebElement> rows1=tbody.findElements(By.tagName("tr"));
				String row1No="";
				String Teams1 = "Support";
				for(int i=0;i<rows.size();i++)
				{
				WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
				if(row.getText().trim().contains(Teams1))
				{
				row1No=Integer.toString(i+1);
				break;
				}
				}
				System.out.println(row1No);
			
				
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
			//Wait for the browser to respond
				WebDriverWait wait3 = new WebDriverWait(driver,30);
				WebElement btnMain3;
				btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
			//Move the selected Team to the assigned section
				driver.findElement(By.id("btnTeamFromLeftToRight")).click();	
			
		//Select the Agent security group from Available table
			//Get the table and row
			WebElement table2 =driver.findElement(By.id("Table2"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Security_Group = "Agent";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
			//row1No=row1No+1;
			row2No=Integer.toString(i+1);
			
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
		
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
			//Verify message
			String expectedmsg = "Settings have been saved successfully. Do you want to add rules for this user?";
		//Wait for the browser to respond
			WebDriverWait wait6 = new WebDriverWait(driver,30);
			WebElement btnMain6;
			btnMain6= wait6.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);
			
		//Click on Cancel button on popup window
			driver.findElement(By.xpath("//*[@id=\"btnCancel\"]/span")).click();
		Thread.sleep(2000);
		//Search the added agent
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("testagent");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table3 =driver.findElement(By.id("gvUsers"));
			WebElement tbody3=table3.findElement(By.tagName("tbody"));
			List<WebElement> rows3=tbody3.findElements(By.tagName("tr"));
			String row3No="";
			String Username = "testagent";
			for(int i=0;i<rows3.size();i++)
			{
			WebElement row = tbody3.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
			
			if(row.getText().trim().contains(Username))
			{
				String expectedusername = row.getText();
				Assert.assertEquals(Username, expectedusername);
				
				System.out.println("Expected User name : "+expectedusername);
				System.out.println("Actual Username : " +Username);
			//break;
			}
			}
	}
	
	
	
	
	
	//Test ID 10-18
		//Verification of adding a ‘Recording Rule’ for a created/existing agent.
	@Test(priority=16)
	public void VerifyAddRuleAgainstAddedAgent() throws InterruptedException {
		System.out.println("VerifyAddAgentWithMultipleTeamsAndExtensions");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
			//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFieldName")));
		//Search the added agent	
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("testagent");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "testagent";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
			
			if(row.getText().trim().contains(Username))
			{
				String expectedusername = row.getText();
				Assert.assertEquals(Username, expectedusername);
				
				System.out.println("Expected User name : "+expectedusername);
				System.out.println("Actual Username : " +Username);
				row2No=Integer.toString(i+1);
				break;
			 }
			 }
			 System.out.println(row2No);
			 driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/table/tbody/tr["+row2No+"]/td[7]/div/img[1]")).click();
		//Click on Recording Rules button
			 driver.findElement(By.id("btnRecordingFilter")).click();
		//Click on Update button
			 driver.findElement(By.xpath("//*[@id=\"divUserF\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input[1]")).click();
		//Verify the message
			 String expectedmsg="Settings have been updated successfully";
		//Wait for the browser to respond
			 WebDriverWait wait2 = new WebDriverWait(driver,30);
			 WebElement btnMain2;
			 btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessage")));
			 String actualmsg = driver.findElement(By.id("lblMessage")).getText();
			 Assert.assertEquals(actualmsg, expectedmsg);
					 
			 System.out.println("Expected Result : "+expectedmsg);
			 System.out.println("Actual Result : " +actualmsg);
			 
		//Enter Rule Name
			 driver.findElement(By.id("tbRuleName")).sendKeys("Rule1");
		//Select the criteria for Rule
			 driver.findElement(By.xpath("//*[@id=\"divUserF\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[13]/td[2]/select")).click();
			 driver.findElement(By.xpath("//*[@id=\"divUserF\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[13]/td[2]/select/option[27]")).click();
		//Click on + button to add the Rule
			 driver.findElement(By.xpath("//*[@id=\"divUserF\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[64]/td[2]/img")).click();
		//Verify message
			 String expectedmsg1="Rule added successfully";
		//Wait for the browser to respond
			 WebDriverWait wait3 = new WebDriverWait(driver,30);
			 WebElement btnMain3;
			 btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessage")));
			 String actualmsg1 = driver.findElement(By.id("lblMessage")).getText();
			 Assert.assertEquals(actualmsg1, expectedmsg1);
							 
			 System.out.println("Expected Result : "+expectedmsg1);
			 System.out.println("Actual Result : " +actualmsg1); 
	}

	
	
	
	//Delete the agent created in Test ID 10-17
	@Test(priority=17)
	public void DeleteAgent1() throws InterruptedException {
		System.out.println("DeleteAgent1");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFieldName")));
		//Search the added agent	
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("testagent");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "testagent";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
			
			if(row.getText().trim().contains(Username))
			{
				String expectedusername = row.getText();
				Assert.assertEquals(Username, expectedusername);
				
				System.out.println("Expected User name : "+expectedusername);
				System.out.println("Actual Username : " +Username);
				row2No=Integer.toString(i+1);
				break;
			 }
			 }
			 System.out.println(row2No);
			 driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/table/tbody/tr["+row2No+"]/td[7]/div/img[2]")).click();
			 
			 String expectedmsg1="Are you sure you want to delete?";
		//Wait for the browser to respond
			 WebDriverWait wait2 = new WebDriverWait(driver,30);
			 WebElement btnMain2;
			 btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			 String actualmsg1 = driver.findElement(By.id("dialog-message")).getText();
			 Assert.assertEquals(actualmsg1, expectedmsg1);
			 
			 System.out.println("Expected Result : "+expectedmsg1);
			 System.out.println("Actual Result : " +actualmsg1);
		//Click on Delete button
			 driver.findElement(By.id("btnDelete")).click();
		//Verify the message
			 String expectedmsg2="Record has been deleted successfully";
		//Wait for the browser to respond
			 WebDriverWait wait3 = new WebDriverWait(driver,30);
			 WebElement btnMain3;
			 btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblErrorMsg")));
			 String actualmsg2 = driver.findElement(By.id("lblErrorMsg")).getText();
			 Assert.assertEquals(actualmsg2, expectedmsg2);
			 
			 System.out.println("Expected Result1 : "+expectedmsg2);
			 System.out.println("Actual Result1 : " +actualmsg2);
			 
			}
	
	
	
	
	//Test ID 10-19
		//Creation of an user as 'Configuration manager'.
	@Test(priority=18)
	public void VerifyAddConfigurationManager() throws InterruptedException {
		System.out.println("VerifyAddConfigurationManager");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Add Agent 
			driver.findElement(By.id("linkAddAgent")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbFirstName")));
		//Enter First Name
			driver.findElement(By.id("tbFirstName")).sendKeys("Test");
		//Enter Last Name
			driver.findElement(By.id("tbLastName")).sendKeys("Agent");
		//Enter Username
			driver.findElement(By.id("tbUsername")).sendKeys("testagent");
		//Enter Password
			driver.findElement(By.id("tbPassword")).sendKeys("1234567b");
		//Enter Confirm Password
			driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567b");
		//Enter Email
			driver.findElement(By.id("tbEmail")).sendKeys("testagent@msn.com");
		//Select checkbox "Enable Account"
			driver.findElement(By.id("cbEnableAccount")).click();
		//Select Extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
		
			
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		//Select the Configuration Manager security group from Available table
			//Get the table and row
			WebElement table1 =driver.findElement(By.id("Table2"));
			WebElement tbody1=table1.findElement(By.tagName("tbody"));
			List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
			String row1No="";
			String Security_Group = "Configuration Manager";
			for(int i=0;i<rows1.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
			//row1No=row1No+1;
			row1No=Integer.toString(i+1);
			
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
		
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg = "Settings have been saved successfully. Do you want to add rules for this user?";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);
			
		//Click on Cancel button on popup window
			driver.findElement(By.xpath("//*[@id=\"btnCancel\"]/span")).click();
		Thread.sleep(2000);
		//Search the added agent
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("testagent");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "testagent";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
			
			if(row.getText().trim().contains(Username))
			{
				String expectedusername = row.getText();
				Assert.assertEquals(Username, expectedusername);
				
				System.out.println("Expected User name : "+expectedusername);
				System.out.println("Actual Username : " +Username);
			//break;
			}
			}
	}
	
	
	
	//Delete the agent created in Test ID 10-19
	@Test(priority=19)
	public void DeleteConfigurationManager() throws InterruptedException {
		System.out.println("DeleteConfigurationManager");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFieldName")));
		//Search the added agent	
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("testagent");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "testagent";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
			
			if(row.getText().trim().contains(Username))
			{
			String expectedusername = row.getText();
			Assert.assertEquals(Username, expectedusername);
				
			System.out.println("Expected User name : "+expectedusername);
			System.out.println("Actual Username : " +Username);
			row2No=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(row2No);
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/table/tbody/tr["+row2No+"]/td[7]/div/img[2]")).click();
				 
			String expectedmsg1="Are you sure you want to delete?";
		//Wait for the browser to respond
			 WebDriverWait wait2 = new WebDriverWait(driver,30);
			 WebElement btnMain2;
			 btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			 String actualmsg1 = driver.findElement(By.id("dialog-message")).getText();
			 Assert.assertEquals(actualmsg1, expectedmsg1);
			 
			 System.out.println("Expected Result : "+expectedmsg1);
			 System.out.println("Actual Result : " +actualmsg1);
		//Click on Delete button
			 driver.findElement(By.id("btnDelete")).click();
		//Verify the message
			 String expectedmsg2="Record has been deleted successfully";
		//Wait for the browser to respond
			 WebDriverWait wait3 = new WebDriverWait(driver,30);
			 WebElement btnMain3;
			 btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblErrorMsg")));
			 String actualmsg2 = driver.findElement(By.id("lblErrorMsg")).getText();
			 Assert.assertEquals(actualmsg2, expectedmsg2);
			 
			 System.out.println("Expected Result1 : "+expectedmsg2);
			 System.out.println("Actual Result1 : " +actualmsg2);
			 
			}
		
	
		
		
		//Test ID 10-20
			//Creation of an user as 'Super Admin'.
	@Test(priority=20)
	public void VerifyAddSuperAdmin() throws InterruptedException {
		System.out.println("VerifyAddSuperAdmin");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Add Agent 
			driver.findElement(By.id("linkAddAgent")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbFirstName")));
		//Enter First Name
			driver.findElement(By.id("tbFirstName")).sendKeys("Test");
		//Enter Last Name
			driver.findElement(By.id("tbLastName")).sendKeys("Agent");
		//Enter Username
			driver.findElement(By.id("tbUsername")).sendKeys("testagent");
		//Enter Password
			driver.findElement(By.id("tbPassword")).sendKeys("1234567b");
		//Enter Confirm Password
			driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567b");
		//Enter Email
			driver.findElement(By.id("tbEmail")).sendKeys("testagent@msn.com");
		//Select checkbox "Enable Account"
			driver.findElement(By.id("cbEnableAccount")).click();
		//Select Extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
		
				
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		//Select the Configuration Manager security group from Available table
		//Get the table and row
			WebElement table1 =driver.findElement(By.id("Table2"));
			WebElement tbody1=table1.findElement(By.tagName("tbody"));
			List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
			String row1No="";
			String Security_Group = "Super Admin";
			for(int i=0;i<rows1.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
		//row1No=row1No+1;
			row1No=Integer.toString(i+1);
			
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
		
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg = "Settings have been saved successfully. Do you want to add rules for this user?";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);
			
		//Click on Cancel button on popup window
			driver.findElement(By.xpath("//*[@id=\"btnCancel\"]/span")).click();
			Thread.sleep(2000);
		//Search the added agent
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("testagent");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "testagent";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
			
			if(row.getText().trim().contains(Username))
			{
			String expectedusername = row.getText();
			Assert.assertEquals(Username, expectedusername);
					
			System.out.println("Expected User name : "+expectedusername);
			System.out.println("Actual Username : " +Username);
		//break;
			}
			}
		}
		
		
		
		
	
		//Delete the Super Admin created in Test ID 10-20
	@Test(priority=21)
	public void DeleteSuperAdmin() throws InterruptedException {
		System.out.println("DeleteConfigurationManager");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFieldName")));
		//Search the added agent	
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("testagent");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "testagent";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
			
			if(row.getText().trim().contains(Username))
			{
			String expectedusername = row.getText();
			Assert.assertEquals(Username, expectedusername);
				
			System.out.println("Expected User name : "+expectedusername);
			System.out.println("Actual Username : " +Username);
			row2No=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(row2No);
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/table/tbody/tr["+row2No+"]/td[7]/div/img[2]")).click();
				 
			String expectedmsg1="Are you sure you want to delete?";
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg1 = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg1, expectedmsg1);
					 
			System.out.println("Expected Result : "+expectedmsg1);
			System.out.println("Actual Result : " +actualmsg1);
		//Click on Delete button
			driver.findElement(By.id("btnDelete")).click();
		//Verify the message
			String expectedmsg2="Record has been deleted successfully";
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblErrorMsg")));
			String actualmsg2 = driver.findElement(By.id("lblErrorMsg")).getText();
			Assert.assertEquals(actualmsg2, expectedmsg2);
						 
			System.out.println("Expected Result1 : "+expectedmsg2);
			System.out.println("Actual Result1 : " +actualmsg2);
						 
			}
		
		
		
		
		
		//Test ID 10-21
			//Creation of an user as 'Group Admin'.
	@Test(priority=22)
	public void VerifyAddGroupAdmin() throws InterruptedException {
		System.out.println("VerifyAddGroupAdmin");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Add Agent 
			driver.findElement(By.id("linkAddAgent")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbFirstName")));
		//Enter First Name
			driver.findElement(By.id("tbFirstName")).sendKeys("Test");
		//Enter Last Name
			driver.findElement(By.id("tbLastName")).sendKeys("Agent");
		//Enter Username
			driver.findElement(By.id("tbUsername")).sendKeys("testagent");
		//Enter Password
			driver.findElement(By.id("tbPassword")).sendKeys("1234567b");
		//Enter Confirm Password
			driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567b");
		//Enter Email
			driver.findElement(By.id("tbEmail")).sendKeys("testagent@msn.com");
		//Select checkbox "Enable Account"
			driver.findElement(By.id("cbEnableAccount")).click();
		//Select Extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
		
				
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		//Select the Configuration Manager security group from Available table
		//Get the table and row
			WebElement table1 =driver.findElement(By.id("Table2"));
			WebElement tbody1=table1.findElement(By.tagName("tbody"));
			List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
			String row1No="";
			String Security_Group = "Group Admin";
			for(int i=0;i<rows1.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
		//row1No=row1No+1;
			row1No=Integer.toString(i+1);
				
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
		
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg = "Settings have been saved successfully. Do you want to add rules for this user?";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);
			
		//Click on Cancel button on popup window
			driver.findElement(By.xpath("//*[@id=\"btnCancel\"]/span")).click();
			Thread.sleep(2000);
		//Search the added agent
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("testagent");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "testagent";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
				
			if(row.getText().trim().contains(Username))
			{
			String expectedusername = row.getText();
			Assert.assertEquals(Username, expectedusername);
					
			System.out.println("Expected User name : "+expectedusername);
			System.out.println("Actual Username : " +Username);
		//break;
			}
			}
		}
		
		
		
		
	
		//Delete the Group Admin created in Test ID 10-21
	@Test(priority=23)
	public void DeleteGroupAdmin() throws InterruptedException {
		System.out.println("DeleteGroupAdmin");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFieldName")));
		//Search the added agent	
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("testagent");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "testagent";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
			
			if(row.getText().trim().contains(Username))
			{
			String expectedusername = row.getText();
			Assert.assertEquals(Username, expectedusername);
				
			System.out.println("Expected User name : "+expectedusername);
			System.out.println("Actual Username : " +Username);
			row2No=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(row2No);
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/table/tbody/tr["+row2No+"]/td[7]/div/img[2]")).click();
					 
			String expectedmsg1="Are you sure you want to delete?";
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg1 = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg1, expectedmsg1);
						 
			System.out.println("Expected Result : "+expectedmsg1);
			System.out.println("Actual Result : " +actualmsg1);
		//Click on Delete button
			driver.findElement(By.id("btnDelete")).click();
		//Verify the message
			String expectedmsg2="Record has been deleted successfully";
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblErrorMsg")));
			String actualmsg2 = driver.findElement(By.id("lblErrorMsg")).getText();
			Assert.assertEquals(actualmsg2, expectedmsg2);
					 
			System.out.println("Expected Result1 : "+expectedmsg2);
			System.out.println("Actual Result1 : " +actualmsg2);
					 
			}
		
	
		
		
		
		//Test ID 10-22 is already covered in 10-02
		//Test ID 10-23 is already covered
		
		//Test ID 10-24
			//Verification of deletion of an Multiple agents.

		//First we need to create multiple agents
		//Create first agent "testagent"
	@Test(priority=24)
	public void CreateTestAgentFor1024() throws InterruptedException {
		System.out.println("CreateTestAgentFor1024");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Add Agent 
			driver.findElement(By.id("linkAddAgent")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbFirstName")));
		//Enter First Name
			driver.findElement(By.id("tbFirstName")).sendKeys("Test");
		//Enter Last Name
			driver.findElement(By.id("tbLastName")).sendKeys("Agent");
		//Enter Username
			driver.findElement(By.id("tbUsername")).sendKeys("testagent");
		//Enter Password
			driver.findElement(By.id("tbPassword")).sendKeys("1234567b");
		//Enter Confirm Password
			driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567b");
		//Enter Email
			driver.findElement(By.id("tbEmail")).sendKeys("testagent@msn.com");
		//Select checkbox "Enable Account"
			driver.findElement(By.id("cbEnableAccount")).click();
		//Select Extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
		
			
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		//Select the Configuration Manager security group from Available table
		//Get the table and row
			WebElement table1 =driver.findElement(By.id("Table2"));
			WebElement tbody1=table1.findElement(By.tagName("tbody"));
			List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
			String row1No="";
			String Security_Group = "Agent";
			for(int i=0;i<rows1.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
		//row1No=row1No+1;
			row1No=Integer.toString(i+1);
				
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
			
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg = "Settings have been saved successfully. Do you want to add rules for this user?";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);
			
		//Click on Cancel button on popup window
			driver.findElement(By.xpath("//*[@id=\"btnCancel\"]/span")).click();
			Thread.sleep(2000);
		//Search the added agent
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("testagent");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "testagent";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
			
			if(row.getText().trim().contains(Username))
			{
			String expectedusername = row.getText();
			Assert.assertEquals(Username, expectedusername);
					
			System.out.println("Expected User name : "+expectedusername);
			System.out.println("Actual Username : " +Username);
		//break;
			}
			}
		}
		
		
		//Create another agent "testagent1"
	@Test(priority=25)
	public void CreateTestAgent1For1024() throws InterruptedException {
		System.out.println("CreateTestAgent1For1024");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Add Agent 
			driver.findElement(By.id("linkAddAgent")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbFirstName")));
		//Enter First Name
			driver.findElement(By.id("tbFirstName")).sendKeys("Test");
		//Enter Last Name
			driver.findElement(By.id("tbLastName")).sendKeys("Agent");
		//Enter Username
			driver.findElement(By.id("tbUsername")).sendKeys("testagent1");
		//Enter Password
			driver.findElement(By.id("tbPassword")).sendKeys("1234567b");
		//Enter Confirm Password
			driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567b");
		//Enter Email
			driver.findElement(By.id("tbEmail")).sendKeys("testagent1@msn.com");
		//Select checkbox "Enable Account"
			driver.findElement(By.id("cbEnableAccount")).click();
		//Select Extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
			
				
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		//Select the Configuration Manager security group from Available table
		//Get the table and row
			WebElement table1 =driver.findElement(By.id("Table2"));
			WebElement tbody1=table1.findElement(By.tagName("tbody"));
			List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
			String row1No="";
			String Security_Group = "Agent";
			for(int i=0;i<rows1.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
		//row1No=row1No+1;
			row1No=Integer.toString(i+1);
			
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
		
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg = "Settings have been saved successfully. Do you want to add rules for this user?";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);
			
		//Click on Cancel button on popup window
			driver.findElement(By.xpath("//*[@id=\"btnCancel\"]/span")).click();
			Thread.sleep(2000);
		//Search the added agent
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("testagent1");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "testagent1";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
			
			if(row.getText().trim().contains(Username))
			{
			String expectedusername = row.getText();
			Assert.assertEquals(Username, expectedusername);
					
			System.out.println("Expected User name : "+expectedusername);
			System.out.println("Actual Username : " +Username);
		//break;
			}
			}
		}
			
	
		//Delete multiple agents
	@Test(priority=26)
	public void DeleteMultipleAgentsFor1024() throws InterruptedException {
		System.out.println("DeleteMultipleAgentsFor1024");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();	
		//Search the added agent
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("testagent");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Select testagent
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/table/tbody/tr[1]/td[1]/input")).click();
		//Select testagent1
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/table/tbody/tr[2]/td[1]/input")).click();
		//Click to see options for delete agents
			driver.findElement(By.id("dltMultiple")).click();
		//Click on Delete Selected option
			driver.findElement(By.xpath("/html/body/ul[1]/li[1]/span")).click();
		//Verify message
			String expectedmsg = "Deleting multiple agents requires Recording Server to restart. Are you sure you want to delete agents?";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);
		//Click on Delete button
			driver.findElement(By.id("btnDelete")).click();	
		//Verify message
			String expectedmsg1 = "Selected agents are deleted successfully.";
		//Wait for the browser to respond
			WebDriverWait wait6 = new WebDriverWait(driver,30);
			WebElement btnMain6;
			btnMain6= wait6.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblErrorMsg")));
			String actualmsg1 = driver.findElement(By.id("lblErrorMsg")).getText();
			Assert.assertEquals(actualmsg1, expectedmsg1);
		}		
		
		
		
		//Test ID 10-25 is not automated as it is related to live call
		
	
		//Test ID 10-27
			//Verify Export Agent button functionality
	@Test(priority=27)
	public void ExportAgent() throws InterruptedException {
		System.out.println("ExportAgent");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Export Agents
			driver.findElement(By.id("linkExportAgents")).click();
		
	}
		
		
		
		
		//Test ID 10-28
			//Verification of the 'Import Agent button.
	@Test(priority=28)
	public void ImportAgent() throws InterruptedException {
		System.out.println("ImportAgent");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Import Agent
			driver.findElement(By.id("linkImportAgents")).click();
		//Browse the file
			WebElement browse = driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_ImportAgents1_fileUpload"));
		//click on ‘Choose file’ to upload the desired file
			browse.sendKeys("E:\\Automation (Do not delete)\\ExportAgent.csv"); 
		//Click on Import button
			driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_ImportAgents1_btnImport")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ContentPlaceHolder2_Ctrl_ImportAgents1_btnSave")));
		//Click on Save button
			driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_ImportAgents1_btnSave")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-alertMessage")));
		//Verify the message
			String expectedmsg1 = "Settings have been saved successfully";
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-alertMessage")));
			String actualmsg1 = driver.findElement(By.id("dialog-alertMessage")).getText();
			Assert.assertEquals(actualmsg1, expectedmsg1);
		//Click on OK button
			driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();
	}	
		
				
			
		
		//Delete agents which were imported in Test ID 10-28
	@Test(priority=29)
	public void DeleteMultipleAgentsFor1028() throws InterruptedException {
		System.out.println("DeleteMultipleAgentsFor1024");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();	
		//Search the added agent
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("testagent");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Select testagent
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/table/tbody/tr[1]/td[1]/input")).click();
		//Select testagent1
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/table/tbody/tr[2]/td[1]/input")).click();
		//Click to see options for delete agents
			driver.findElement(By.id("dltMultiple")).click();
		//Click on Delete Selected option
			driver.findElement(By.xpath("/html/body/ul[1]/li[1]/span")).click();
		//Verify message
			String expectedmsg = "Deleting multiple agents requires Recording Server to restart. Are you sure you want to delete agents?";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);
		//Click on Delete button
			driver.findElement(By.id("btnDelete")).click();	
		//Verify message
			String expectedmsg1 = "Selected agents are deleted successfully.";
		//Wait for the browser to respond
			WebDriverWait wait6 = new WebDriverWait(driver,30);
			WebElement btnMain6;
			btnMain6= wait6.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblErrorMsg")));
			String actualmsg1 = driver.findElement(By.id("lblErrorMsg")).getText();
			Assert.assertEquals(actualmsg1, expectedmsg1);
		}	
		
	

				
				
				
		//Test ID 10-29
				//Verification of the 'Import  button.
	@Test(priority=30)
	public void ImportAgentWithoutSelectingAFile() throws InterruptedException {
		System.out.println("ImportAgentWithoutSelectingAFile");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Import Agent
			driver.findElement(By.id("linkImportAgents")).click();
		//Click on Import button
			driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_ImportAgents1_btnImport")).click();
		//Verify the message
			String expectedmsg = "Please browse the file to import";
		//Wait for the browser to respond
			WebDriverWait wait6 = new WebDriverWait(driver,30);
			WebElement btnMain6;
			btnMain6= wait6.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-alertMessage")));
			String actualmsg = driver.findElement(By.id("dialog-alertMessage")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);
		}
					
				
				
		//Test ID 10-30
				//Verification of the Browse functionality 
	@Test(priority=31)
	public void ImportAgentWithInvalidFile() throws InterruptedException {
		System.out.println("ImportAgentWithInvalidFile");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Import Agent
			driver.findElement(By.id("linkImportAgents")).click();
		//Browse the file
			WebElement browse = driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_ImportAgents1_fileUpload"));
		//click on ‘Choose file’ to upload the desired file
			browse.sendKeys("E:\\Automation (Do not delete)\\Untitled.jpg"); 
		//Click on Import button
			driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_ImportAgents1_btnImport")).click();
		//Verify the message
			String expectedmsg1 = "Only csv files are allowed";
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-alertMessage")));
			String actualmsg1 = driver.findElement(By.id("dialog-alertMessage")).getText();
			Assert.assertEquals(actualmsg1, expectedmsg1);
		
			}
				
		
		
		
		
		//Test ID 10-31
			//Verification of the CSV file functionality
	@Test(priority=32)
	public void NoAgentFoundWhileImporting() throws InterruptedException {
		System.out.println("NoAgentFoundWhileImporting");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
			//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Import Agent
			driver.findElement(By.id("linkImportAgents")).click();
		//Browse the file
			WebElement browse = driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_ImportAgents1_fileUpload"));
		//click on ‘Choose file’ to upload the desired file
			browse.sendKeys("E:\\Automation (Do not delete)\\ExportAgent1.csv"); 
		//Click on Import button
			driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_ImportAgents1_btnImport")).click();
		//Click on Save button
			driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_ImportAgents1_btnSave")).click();
		//Verify the message
			String expectedmsg1 = "No new agent has been added.";
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-alertMessage")));
			String actualmsg1 = driver.findElement(By.id("dialog-alertMessage")).getText();
			Assert.assertEquals(actualmsg1, expectedmsg1);
	
		}
		
	
		
		
		//Test ID 10-41
			//"Verify Fields validation of ULF page, Leave empty field ""Rule Name"""
	@Test(priority=33)
	public void VerifyAddULFWithoutRuleName() throws InterruptedException {
		System.out.println("VerifyAddULFWithoutRuleName");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Add Agent 
			driver.findElement(By.id("linkAddAgent")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbFirstName")));
		//Enter First Name
			driver.findElement(By.id("tbFirstName")).sendKeys("Test");
		//Enter Last Name
			driver.findElement(By.id("tbLastName")).sendKeys("Agent");
		//Enter Username
			driver.findElement(By.id("tbUsername")).sendKeys("testagent");
		//Enter Password
			driver.findElement(By.id("tbPassword")).sendKeys("1234567b");
		//Enter Confirm Password
			driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567b");
		//Enter Email
			driver.findElement(By.id("tbEmail")).sendKeys("testagent@msn.com");
		//Select checkbox "Enable Account"
			driver.findElement(By.id("cbEnableAccount")).click();
		//Select Extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
			
				
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		//Select the Agent security group from Available table
		//Get the table and row
			WebElement table1 =driver.findElement(By.id("Table2"));
			WebElement tbody1=table1.findElement(By.tagName("tbody"));
			List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
			String row1No="";
			String Security_Group = "Agent";
			for(int i=0;i<rows1.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
		//row1No=row1No+1;
			row1No=Integer.toString(i+1);
			
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
		
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg = "Settings have been saved successfully. Do you want to add rules for this user?";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);
		//Click OK to add ULF
			driver.findElement(By.id("btnOK")).click();
		//Click on Update button
			 driver.findElement(By.xpath("//*[@id=\"divUserF\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input[1]")).click();
		//Verify the message
			 String expectedmsg1="Settings have been updated successfully";
		//Wait for the browser to respond
			 WebDriverWait wait6 = new WebDriverWait(driver,30);
			 WebElement btnMain6;
			 btnMain6= wait6.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessage")));
			 String actualmsg1 = driver.findElement(By.id("lblMessage")).getText();
			 Assert.assertEquals(actualmsg1, expectedmsg1);
					 
			 System.out.println("Expected Result : "+expectedmsg1);
			 System.out.println("Actual Result : " +actualmsg);
		//Select the criteria for Rule
			 driver.findElement(By.xpath("//*[@id=\"divUserF\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[13]/td[2]/select")).click();
			 driver.findElement(By.xpath("//*[@id=\"divUserF\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[13]/td[2]/select/option[27]")).click();
		//Click on + button to add the Rule
			 driver.findElement(By.xpath("//*[@id=\"divUserF\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[64]/td[2]/img")).click();
		//Verify message
			 String expectedmsg2="Please enter rule name";
		//Wait for the browser to respond
			 WebDriverWait wait7 = new WebDriverWait(driver,30);
			 WebElement btnMain7;
			 btnMain7= wait7.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessage")));
			 String actualmsg2 = driver.findElement(By.id("lblMessage")).getText();
			 Assert.assertEquals(actualmsg2, expectedmsg2);
							 
			 System.out.println("Expected Result : "+expectedmsg2);
			 System.out.println("Actual Result : " +actualmsg2); 
	}	
		
		
		
		
		
		//Delete Agent created in Test ID 10-41
	@Test(priority=34)
	public void DeleteAgent1041() throws InterruptedException {
		System.out.println("DeleteAgent1041");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFieldName")));
		//Search the added agent	
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("testagent");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "testagent";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
			
			if(row.getText().trim().contains(Username))
			{
			String expectedusername = row.getText();
			Assert.assertEquals(Username, expectedusername);
					
			System.out.println("Expected User name : "+expectedusername);
			System.out.println("Actual Username : " +Username);
			row2No=Integer.toString(i+1);
			break;
			 }
			 }
			System.out.println(row2No);
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/table/tbody/tr["+row2No+"]/td[7]/div/img[2]")).click();
			 
			String expectedmsg1="Are you sure you want to delete?";
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg1 = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg1, expectedmsg1);
			
			System.out.println("Expected Result : "+expectedmsg1);
			System.out.println("Actual Result : " +actualmsg1);
		//Click on Delete button
			driver.findElement(By.id("btnDelete")).click();
		//Verify the message
			String expectedmsg2="Record has been deleted successfully";
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblErrorMsg")));
			String actualmsg2 = driver.findElement(By.id("lblErrorMsg")).getText();
			Assert.assertEquals(actualmsg2, expectedmsg2);
			
			System.out.println("Expected Result1 : "+expectedmsg2);
			System.out.println("Actual Result1 : " +actualmsg2);
				 
	}
		
		
		
		
		
		//Test ID 10-42
			//"Verify Fields validation of ULF page, Leave  ""When"""""
	@Test(priority=35)
	public void VerifyAddULFWithoutCriteria() throws InterruptedException {
		System.out.println("VerifyAddULFWithoutCriteria");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Add Agent 
			driver.findElement(By.id("linkAddAgent")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbFirstName")));
		//Enter First Name
			driver.findElement(By.id("tbFirstName")).sendKeys("Test");
		//Enter Last Name
			driver.findElement(By.id("tbLastName")).sendKeys("Agent");
		//Enter Username
			driver.findElement(By.id("tbUsername")).sendKeys("testagent");
		//Enter Password
			driver.findElement(By.id("tbPassword")).sendKeys("1234567b");
		//Enter Confirm Password
			driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567b");
		//Enter Email
			driver.findElement(By.id("tbEmail")).sendKeys("testagent@msn.com");
		//Select checkbox "Enable Account"
			driver.findElement(By.id("cbEnableAccount")).click();
		//Select Extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
		
				
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		//Select the Agent security group from Available table
			//Get the table and row
			WebElement table1 =driver.findElement(By.id("Table2"));
			WebElement tbody1=table1.findElement(By.tagName("tbody"));
			List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
		String row1No="";
			String Security_Group = "Agent";
			for(int i=0;i<rows1.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
		//row1No=row1No+1;
			row1No=Integer.toString(i+1);
			
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
		
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg = "Settings have been saved successfully. Do you want to add rules for this user?";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);
		//Click OK to add ULF
			driver.findElement(By.id("btnOK")).click();
		//Click on Update button
			driver.findElement(By.xpath("//*[@id=\"divUserF\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input[1]")).click();
		//Verify the message
			String expectedmsg1="Settings have been updated successfully";
		//Wait for the browser to respond
			WebDriverWait wait6 = new WebDriverWait(driver,30);
			WebElement btnMain6;
			btnMain6= wait6.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessage")));
			String actualmsg1 = driver.findElement(By.id("lblMessage")).getText();
			Assert.assertEquals(actualmsg1, expectedmsg1);
				 
			System.out.println("Expected Result : "+expectedmsg1);
			System.out.println("Actual Result : " +actualmsg);
		//Enter Rule Name
			driver.findElement(By.id("tbRuleName")).sendKeys("Rule1");
		//Click on + button to add the Rule
			driver.findElement(By.xpath("//*[@id=\"divUserF\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[64]/td[2]/img")).click();
		//Verify message
			String expectedmsg2="Please add at least one criteria to save rule";
		//Wait for the browser to respond
			WebDriverWait wait7 = new WebDriverWait(driver,30);
			WebElement btnMain7;
			btnMain7= wait7.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessage")));
			String actualmsg2 = driver.findElement(By.id("lblMessage")).getText();
			Assert.assertEquals(actualmsg2, expectedmsg2);
							 
			System.out.println("Expected Result : "+expectedmsg2);
			System.out.println("Actual Result : " +actualmsg2); 
		}		
		
		
		
		
		//Delete Agent created in Test ID 10-42
	@Test(priority=36)
	public void DeleteAgent1042() throws InterruptedException {
		System.out.println("DeleteAgent1041");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFieldName")));
		//Search the added agent	
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("testagent");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "testagent";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
			
			if(row.getText().trim().contains(Username))
			{
			String expectedusername = row.getText();
			Assert.assertEquals(Username, expectedusername);
			
			System.out.println("Expected User name : "+expectedusername);
			System.out.println("Actual Username : " +Username);
			row2No=Integer.toString(i+1);
			break;
			 }
			 }
			System.out.println(row2No);
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/table/tbody/tr["+row2No+"]/td[7]/div/img[2]")).click();
			 
			String expectedmsg1="Are you sure you want to delete?";
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg1 = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg1, expectedmsg1);
			 
			System.out.println("Expected Result : "+expectedmsg1);
			System.out.println("Actual Result : " +actualmsg1);
		//Click on Delete button
			driver.findElement(By.id("btnDelete")).click();
		//Verify the message
			String expectedmsg2="Record has been deleted successfully";
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblErrorMsg")));
			String actualmsg2 = driver.findElement(By.id("lblErrorMsg")).getText();
			Assert.assertEquals(actualmsg2, expectedmsg2);
			 
			System.out.println("Expected Result1 : "+expectedmsg2);
			System.out.println("Actual Result1 : " +actualmsg2);
			 
			}
		
		
		
		
		
		//Test ID 10-43,44 is already covered in 10-02
		
		
		//Test ID 10-45
			//"Verify add ULF by adding new extension agent Verify Popup alert and check ok button functionality". In that case when agent is added and when you click on OK button, the ULF page should be open
	@Test(priority=37)
	public void VerifyULFPageIsOpen() throws InterruptedException {
		System.out.println("VerifyULFPageIsOpen");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Add Agent 
			driver.findElement(By.id("linkAddAgent")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbFirstName")));
		//Enter First Name
			driver.findElement(By.id("tbFirstName")).sendKeys("Test");
		//Enter Last Name
			driver.findElement(By.id("tbLastName")).sendKeys("Agent");
		//Enter Username
			driver.findElement(By.id("tbUsername")).sendKeys("testagent");
		//Enter Password
			driver.findElement(By.id("tbPassword")).sendKeys("1234567b");
		//Enter Confirm Password
			driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567b");
		//Enter Email
			driver.findElement(By.id("tbEmail")).sendKeys("testagent@msn.com");
		//Select checkbox "Enable Account"
			driver.findElement(By.id("cbEnableAccount")).click();
		//Select Extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
		
			
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		//Select the Agent security group from Available table
		//Get the table and row
			WebElement table1 =driver.findElement(By.id("Table2"));
			WebElement tbody1=table1.findElement(By.tagName("tbody"));
			List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
			String row1No="";
			String Security_Group = "Agent";
			for(int i=0;i<rows1.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
			//row1No=row1No+1;
			row1No=Integer.toString(i+1);
			
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
		
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg = "Settings have been saved successfully. Do you want to add rules for this user?";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);
		//Click OK to add ULF
			driver.findElement(By.id("btnOK")).click();	
		//The web should be redirected to ULF page
			String ExpectedURL = "http://localhost/OmniPCXRECORD/UserLevelFilters.aspx";
			String ActualURL= driver.getCurrentUrl();
			Assert.assertEquals(ActualURL,ExpectedURL);
	}
				
		
		
		
				
				
		
				
		
		//Test ID 10-46 and 47 will not covered as special characters are not accepted in Rule name
		
				
		
		
		//Test ID 10-48
			//Add normal opr Agent with duplicate username
	@Test(priority=38)
	public void VerifyAddAgentWithDuplicateUsername() throws InterruptedException {
		System.out.println("VerifyAddAgentWithDuplicateUsername");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Click on Add Agent 
			driver.findElement(By.id("linkAddAgent")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbFirstName")));
		//Enter First Name
			driver.findElement(By.id("tbFirstName")).sendKeys("Test");
		//Enter Last Name
			driver.findElement(By.id("tbLastName")).sendKeys("Agent");
		//Enter Username
			driver.findElement(By.id("tbUsername")).sendKeys("testagent");
		//Enter Password
			driver.findElement(By.id("tbPassword")).sendKeys("1234567b");
		//Enter Confirm Password
			driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567b");
		//Enter Email
			driver.findElement(By.id("tbEmail")).sendKeys("testagent@msn.com");
		//Select checkbox "Enable Account"
			driver.findElement(By.id("cbEnableAccount")).click();
		//Select Extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
			
				
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		//Select the Agent security group from Available table
			//Get the table and row
			WebElement table1 =driver.findElement(By.id("Table2"));
			WebElement tbody1=table1.findElement(By.tagName("tbody"));
			List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
			String row1No="";
			String Security_Group = "Agent";
			for(int i=0;i<rows1.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
			//row1No=row1No+1;
			row1No=Integer.toString(i+1);
				
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
		
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg = "An agent with this user name already exists";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMsg")));
			String actualmsg = driver.findElement(By.id("lblMsg")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);
	}
				
			
				
		//Delete Agent created in Test ID 10-45
	@Test(priority=39)
	public void DeleteAgent1045() throws InterruptedException {
		System.out.println("DeleteAgent1045");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFieldName")));
		//Search the added agent	
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("testagent");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "testagent";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
			
			if(row.getText().trim().contains(Username))
			{
			String expectedusername = row.getText();
			Assert.assertEquals(Username, expectedusername);
			
			System.out.println("Expected User name : "+expectedusername);
			System.out.println("Actual Username : " +Username);
			row2No=Integer.toString(i+1);
			break;
			 }
			 }
			System.out.println(row2No);
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/table/tbody/tr["+row2No+"]/td[7]/div/img[2]")).click();
			 
			String expectedmsg1="Are you sure you want to delete?";
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg1 = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg1, expectedmsg1);
			 
			System.out.println("Expected Result : "+expectedmsg1);
			System.out.println("Actual Result : " +actualmsg1);
		//Click on Delete button
			driver.findElement(By.id("btnDelete")).click();
		//Verify the message
			String expectedmsg2="Record has been deleted successfully";
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblErrorMsg")));
			String actualmsg2 = driver.findElement(By.id("lblErrorMsg")).getText();
			Assert.assertEquals(actualmsg2, expectedmsg2);
			 
			System.out.println("Expected Result1 : "+expectedmsg2);
			System.out.println("Actual Result1 : " +actualmsg2);
			 
			}
		
		
	
		
		
		//Test ID 10-49
			//Add Active Directory Agent in System with enabled account
	@Test(priority=40)
	public void VerifyAddADAgent() throws InterruptedException {
		System.out.println("VerifyAddADAgent");
		driver.get(siteUrl);
		//Click on Switch Role in log in page
			driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_lblServerAdministration")));
		//Select Server Administration
			driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctrl_TenantAdmin1_txtUserName")));
		
			String expectedurl="ExpectedServerURL";
			String actualurl=driver.getCurrentUrl();
			System.out.println("Actual Url:"+actualurl);
			System.out.println("Expected Url:"+expectedurl);
		//Enter Username
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")));
			String actualurl1="siteUrl";
			String expectedurl1= driver.getCurrentUrl();
			Assert.assertNotEquals(actualurl1,expectedurl1);
		
		//Click on system page and configure AD authentication
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
			Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
			dropdown.selectByVisibleText("Mix Mode (OmniPCX RECORD - Active Directory)");
			driver.findElement(By.id("txtADDomainName")).clear();
			driver.findElement(By.id("txtADDomainName")).sendKeys("ghostsoftware.local");
			driver.findElement(By.id("txtADUsername")).clear();
			driver.findElement(By.id("txtADUsername")).sendKeys("ahsan.rehman");
			driver.findElement(By.id("txtADPassword")).clear();
			driver.findElement(By.id("txtADPassword")).sendKeys("Abc123*");
		//Select include all containers criteria
			driver.findElement(By.id("rbADCriteriaAll")).click();
		//Click on Update button
			driver.findElement(By.id("btnUpdateAuthSettings")).click();
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
		//Verify message
			String expectedmsg = "Settings have been updated successfully";
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
		
			String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
			Thread.sleep(2000);
			Assert.assertEquals(actualmsg, expectedmsg);
		//Click on logout
			driver.findElement(By.id("ctl00_lblLogOut")).click();
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctrl_TenantAdmin1_lblSwitchRole")));
		//Click on Switch Role in log in page
			driver.findElement(By.id("ctrl_TenantAdmin1_lblSwitchRole")).click();
		//Wait for the browser to respond
			WebDriverWait wait6 = new WebDriverWait(driver,30);
			WebElement btnMain6;
			btnMain6= wait6.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctrl_TenantAdmin1_lblSiteAdministration")));
		//Select Site Administration
			driver.findElement(By.id("ctrl_TenantAdmin1_lblSiteAdministration")).click();
		//Wait for the browser to respond
			WebDriverWait wait7 = new WebDriverWait(driver,30);
			WebElement btnMain7;
			btnMain7= wait7.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_txtSiteCode")));
		
			String expectedurl2="ExpectedServerURL";
			String actualurl2=driver.getCurrentUrl();
			System.out.println("Actual Url:"+actualurl2);
			System.out.println("Expected Url:"+expectedurl2);	
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait8 = new WebDriverWait(driver,30);
			WebElement btnMain8;
			btnMain8= wait8.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Wait for the browser to respond
			WebDriverWait wait9 = new WebDriverWait(driver,30);
			WebElement btnMain9;
			btnMain9= wait9.until(ExpectedConditions.visibilityOfElementLocated(By.id("linkAddActiveDirectoryAgent")));
		//Click on Add Active Directory Agent
			driver.findElement(By.id("linkAddActiveDirectoryAgent")).click();
			Thread.sleep(2000);
		//Search Tanveer Ahmad
			driver.findElement(By.xpath("//*[@id=\"gvADUsers_filter\"]/label/input")).sendKeys("Tanveer Ahmad"); 
		//Select Tanveer Ahmad
			driver.findElement(By.xpath("//*[@id=\"gvADUsers\"]/tbody/tr/td[3]/img")).click();
		//Wait for the browser to respond
			WebDriverWait wait10 = new WebDriverWait(driver,30);
			WebElement btnMain10;
			btnMain10= wait10.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbEmail")));
		//Enter email
			driver.findElement(By.id("tbEmail")).sendKeys("tanveer.ahmad@amigo-software.com"); 
		//Enable the account
			driver.findElement(By.id("cbEnableAccount")).click();
		//Select extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
		
			
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait11 = new WebDriverWait(driver,30);
			WebElement btnMain11;
			btnMain11= wait11.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		//Select the Agent security group from Available table
		//Get the table and row
			WebElement table1 =driver.findElement(By.id("Table2"));
			WebElement tbody1=table1.findElement(By.tagName("tbody"));
			List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
			String row1No="";
			String Security_Group = "Agent";
			for(int i=0;i<rows1.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
			//row1No=row1No+1;
			row1No=Integer.toString(i+1);
			
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait12 = new WebDriverWait(driver,30);
			WebElement btnMain12;
			btnMain12= wait12.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
		
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait13 = new WebDriverWait(driver,30);
			WebElement btnMain13;
			btnMain13= wait13.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg1 = "Settings have been saved successfully. Do you want to add rules for this user?";
		//Wait for the browser to respond
			WebDriverWait wait14 = new WebDriverWait(driver,30);
			WebElement btnMain14;
			btnMain14= wait14.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg1 = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg1, expectedmsg1);
			
		//Click on Cancel button on popup window
			driver.findElement(By.xpath("//*[@id=\"btnCancel\"]/span")).click();
		Thread.sleep(2000);
		//Search the added agent
			Select dropdown1 = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown1.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("tanveer.ahmad");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "tanveer.ahmad";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
			
			if(row.getText().trim().contains(Username))
			{
			String expectedusername = row.getText();
			Assert.assertEquals(Username, expectedusername);
					
			System.out.println("Expected User name : "+expectedusername);
			System.out.println("Actual Username : " +Username);
		//break;
			}
			}
	}
		
		
	
	
		//Delete Agent created in Test ID 10-49
	@Test(priority=41)
	public void DeleteAgent1049() throws InterruptedException {
		System.out.println("DeleteAgent1049");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFieldName")));
		//Search the added agent	
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("tanveer.ahmad");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "tanveer.ahmad";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
			
			if(row.getText().trim().contains(Username))
			{
			String expectedusername = row.getText();
			Assert.assertEquals(Username, expectedusername);
			
			System.out.println("Expected User name : "+expectedusername);
			System.out.println("Actual Username : " +Username);
			row2No=Integer.toString(i+1);
			break;
			 }
			 }
			System.out.println(row2No);
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/table/tbody/tr["+row2No+"]/td[7]/div/img[2]")).click();
				 
			String expectedmsg1="Are you sure you want to delete?";
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg1 = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg1, expectedmsg1);
			 
			System.out.println("Expected Result : "+expectedmsg1);
			System.out.println("Actual Result : " +actualmsg1);
		//Click on Delete button
			driver.findElement(By.id("btnDelete")).click();
		//Verify the message
			String expectedmsg2="Record has been deleted successfully";
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblErrorMsg")));
			String actualmsg2 = driver.findElement(By.id("lblErrorMsg")).getText();
			Assert.assertEquals(actualmsg2, expectedmsg2);
				 
			System.out.println("Expected Result1 : "+expectedmsg2);
			System.out.println("Actual Result1 : " +actualmsg2);
			 
			}
	
	
	
	
	//Test ID 10-50
		//Add Active Directory Agent in System with disabled account
	@Test(priority=42)
	public void VerifyAddADDisabledAgent() throws InterruptedException {
		System.out.println("VerifyAddADDisabledAgent");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait8 = new WebDriverWait(driver,30);
			WebElement btnMain8;
			btnMain8= wait8.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Wait for the browser to respond
			WebDriverWait wait9 = new WebDriverWait(driver,30);
			WebElement btnMain9;
			btnMain9= wait9.until(ExpectedConditions.visibilityOfElementLocated(By.id("linkAddActiveDirectoryAgent")));
		//Click on Add Active Directory Agent
			driver.findElement(By.id("linkAddActiveDirectoryAgent")).click();
		Thread.sleep(2000);
		//Search Tanveer Ahmad
			driver.findElement(By.xpath("//*[@id=\"gvADUsers_filter\"]/label/input")).sendKeys("Tanveer Ahmad"); 
		//Select Tanveer Ahmad
			driver.findElement(By.xpath("//*[@id=\"gvADUsers\"]/tbody/tr/td[3]/img")).click();
		//Wait for the browser to respond
			WebDriverWait wait10 = new WebDriverWait(driver,30);
			WebElement btnMain10;
			btnMain10= wait10.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbEmail")));
		//Enter email
			driver.findElement(By.id("tbEmail")).sendKeys("tanveer.ahmad@amigo-software.com"); 
		//Select extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
		
			
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait11 = new WebDriverWait(driver,30);
			WebElement btnMain11;
			btnMain11= wait11.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		//Select the Agent security group from Available table
		//Get the table and row
			WebElement table1 =driver.findElement(By.id("Table2"));
			WebElement tbody1=table1.findElement(By.tagName("tbody"));
			List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
			String row1No="";
			String Security_Group = "Agent";
			for(int i=0;i<rows1.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
			//row1No=row1No+1;
			row1No=Integer.toString(i+1);
			
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait12 = new WebDriverWait(driver,30);
			WebElement btnMain12;
			btnMain12= wait12.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
		
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait13 = new WebDriverWait(driver,30);
			WebElement btnMain13;
			btnMain13= wait13.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg1 = "Settings have been saved successfully. Do you want to add rules for this user?";
		//Wait for the browser to respond
			WebDriverWait wait14 = new WebDriverWait(driver,30);
			WebElement btnMain14;
			btnMain14= wait14.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg1 = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg1, expectedmsg1);
			
		//Click on Cancel button on popup window
			driver.findElement(By.xpath("//*[@id=\"btnCancel\"]/span")).click();
		Thread.sleep(2000);
		//Search the added agent
			Select dropdown1 = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown1.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("tanveer.ahmad");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "tanveer.ahmad";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
			
			if(row.getText().trim().contains(Username))
			{
				String expectedusername = row.getText();
				Assert.assertEquals(Username, expectedusername);
				
				System.out.println("Expected User name : "+expectedusername);
				System.out.println("Actual Username : " +Username);
			//break;
			}
			}
	}
				
		
	
	
	
	//Test ID 10-51
		//Add duplicate Active Directory Agent
	@Test(priority=43)
	public void VerifyAddDuplicateADAgent() throws InterruptedException {
		System.out.println("VerifyAddDuplicateADAgent");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait8 = new WebDriverWait(driver,30);
			WebElement btnMain8;
			btnMain8= wait8.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Wait for the browser to respond
			WebDriverWait wait9 = new WebDriverWait(driver,30);
			WebElement btnMain9;
			btnMain9= wait9.until(ExpectedConditions.visibilityOfElementLocated(By.id("linkAddActiveDirectoryAgent")));
		//Click on Add Active Directory Agent
			driver.findElement(By.id("linkAddActiveDirectoryAgent")).click();
		Thread.sleep(2000);
		//Search Tanveer Ahmad
			driver.findElement(By.xpath("//*[@id=\"gvADUsers_filter\"]/label/input")).sendKeys("Tanveer Ahmad"); 
		//Select Tanveer Ahmad
			driver.findElement(By.xpath("//*[@id=\"gvADUsers\"]/tbody/tr/td[3]/img")).click();
		//Verify message
			String expectedmsg1 = "An agent with this user name already exists";
		Thread.sleep(2000);
			String actualmsg1 = driver.findElement(By.xpath("//*[@id=\"dialog-ADUsers\"]/table/tbody/tr[1]/td/label")).getText();
			Assert.assertEquals(actualmsg1, expectedmsg1);
			
		}	
	

	
	
	
	//Test ID 10-52
		//Update First Name of Active Directory User
	@Test(priority=44)
	public void EditFirstNameOfADAgentCreatedIn1050() throws InterruptedException {
		System.out.println("EditFirstNameOfADAgentCreatedIn1050");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFieldName")));
		//Search the added agent	
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("tanveer.ahmad");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "tanveer.ahmad";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
			
			if(row.getText().trim().contains(Username))
			{
			String expectedusername = row.getText();
			Assert.assertEquals(Username, expectedusername);
			
			System.out.println("Expected User name : "+expectedusername);
			System.out.println("Actual Username : " +Username);
			row2No=Integer.toString(i+1);
			break;
			 }
			 }
			System.out.println(row2No);
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/table/tbody/tr["+row2No+"]/td[7]/div/img[1]")).click();
		//Update the First Name
			driver.findElement(By.id("tbFirstName")).clear();
			driver.findElement(By.id("tbFirstName")).sendKeys("Tanveer1");
		//Click on Update button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg = "Settings have been updated successfully";
		//Wait for the browser to respond
			WebDriverWait wait14 = new WebDriverWait(driver,30);
			WebElement btnMain14;
			btnMain14= wait14.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-alertMessage")));
			String actualmsg = driver.findElement(By.id("dialog-alertMessage")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);
			System.out.println("Expected Message : "+expectedmsg);
			System.out.println("Actual Message : " +actualmsg);
	}
			
	
	
	
	//Test ID 10-53
		//Update Last Name of Active Directory User
	@Test(priority=45)
	public void EditLastNameOfADAgentCreatedIn1050() throws InterruptedException {
		System.out.println("EditLastNameOfADAgentCreatedIn1050");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFieldName")));
		//Search the added agent	
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("tanveer.ahmad");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "tanveer.ahmad";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
			
			if(row.getText().trim().contains(Username))
			{
			String expectedusername = row.getText();
			Assert.assertEquals(Username, expectedusername);
			
			System.out.println("Expected User name : "+expectedusername);
			System.out.println("Actual Username : " +Username);
			row2No=Integer.toString(i+1);
			break;
			 }
			 }
			System.out.println(row2No);
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/table/tbody/tr["+row2No+"]/td[7]/div/img[1]")).click();
		//Update the First Name
			driver.findElement(By.id("tbLastName")).clear();
			driver.findElement(By.id("tbLastName")).sendKeys("Ahmad1");
		//Click on Update button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg = "Settings have been updated successfully";
		//Wait for the browser to respond
			WebDriverWait wait14 = new WebDriverWait(driver,30);
			WebElement btnMain14;
			btnMain14= wait14.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-alertMessage")));
			String actualmsg = driver.findElement(By.id("dialog-alertMessage")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);
			System.out.println("Expected Message : "+expectedmsg);
			System.out.println("Actual Message : " +actualmsg);
	}
	
	
	
	
	
	
	//Test ID 10-54
		//Update Email of Active Directory User
	@Test(priority=46)
	public void EditEmailOfADAgentCreatedIn1050() throws InterruptedException {
		System.out.println("EditEmailOfADAgentCreatedIn1050");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFieldName")));
		//Search the added agent	
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("tanveer.ahmad");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "tanveer.ahmad";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
			
			if(row.getText().trim().contains(Username))
			{
			String expectedusername = row.getText();
			Assert.assertEquals(Username, expectedusername);
			
			System.out.println("Expected User name : "+expectedusername);
			System.out.println("Actual Username : " +Username);
			row2No=Integer.toString(i+1);
			break;
			 }
			 }
			System.out.println(row2No);
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/table/tbody/tr["+row2No+"]/td[7]/div/img[1]")).click();
		//Update the First Name
			driver.findElement(By.id("tbEmail")).clear();
			driver.findElement(By.id("tbEmail")).sendKeys("tanveer.ahmad1@amigo-software.com");
		//Click on Update button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg = "Settings have been updated successfully";
		//Wait for the browser to respond
			WebDriverWait wait14 = new WebDriverWait(driver,30);
			WebElement btnMain14;
			btnMain14= wait14.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-alertMessage")));
			String actualmsg = driver.findElement(By.id("dialog-alertMessage")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);
			System.out.println("Expected Message : "+expectedmsg);
			System.out.println("Actual Message : " +actualmsg);
	}
	
	
	
	
	
	
	//Test ID 10-57
			//Delete Active Directory user from system
	@Test(priority=47)
	public void DeleteAgent1050() throws InterruptedException {
		System.out.println("DeleteAgent1050");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFieldName")));
		//Search the added agent	
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("tanveer.ahmad");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "tanveer.ahmad";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
			
			if(row.getText().trim().contains(Username))
			{
			String expectedusername = row.getText();
			Assert.assertEquals(Username, expectedusername);
			
			System.out.println("Expected User name : "+expectedusername);
			System.out.println("Actual Username : " +Username);
			row2No=Integer.toString(i+1);
			break;
			 }
			 }
			System.out.println(row2No);
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/table/tbody/tr["+row2No+"]/td[7]/div/img[2]")).click();
				 
			String expectedmsg1="Are you sure you want to delete?";
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg1 = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg1, expectedmsg1);
			 
			System.out.println("Expected Result : "+expectedmsg1);
			System.out.println("Actual Result : " +actualmsg1);
		//Click on Delete button
			driver.findElement(By.id("btnDelete")).click();
		//Verify the message
			String expectedmsg2="Record has been deleted successfully";
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblErrorMsg")));
			String actualmsg2 = driver.findElement(By.id("lblErrorMsg")).getText();
			Assert.assertEquals(actualmsg2, expectedmsg2);
				 
			System.out.println("Expected Result1 : "+expectedmsg2);
			System.out.println("Actual Result1 : " +actualmsg2);
			 
			}
	
	
	
	//Test ID 10-58 is already covered in 10-24
	

	//Test ID 10-62
		//Verify that "Notify when a call is recorded" option is available while adding/updating an agent
	@Test(priority=48)
	public void VerifyNotifyCallIsAvailableWhileAddingADAgent() throws InterruptedException {
		System.out.println("VerifyNotifyCallIsAvailableWhileAddingADAgent");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait8 = new WebDriverWait(driver,30);
			WebElement btnMain8;
			btnMain8= wait8.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Wait for the browser to respond
			WebDriverWait wait9 = new WebDriverWait(driver,30);
			WebElement btnMain9;
			btnMain9= wait9.until(ExpectedConditions.visibilityOfElementLocated(By.id("linkAddActiveDirectoryAgent")));
		//Click on Add Active Directory Agent
			driver.findElement(By.id("linkAddActiveDirectoryAgent")).click();
			Thread.sleep(2000);
		//Search Tanveer Ahmad
			driver.findElement(By.xpath("//*[@id=\"gvADUsers_filter\"]/label/input")).sendKeys("Tanveer Ahmad"); 
		//Select Tanveer Ahmad
			driver.findElement(By.xpath("//*[@id=\"gvADUsers\"]/tbody/tr/td[3]/img")).click();
		//Wait for the browser to respond
			WebDriverWait wait10 = new WebDriverWait(driver,30);
			WebElement btnMain10;
			btnMain10= wait10.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbEmail")));
		//Verify "Notify when a call is recorded" label is available
			String expectedLabel = "Notify when a call is recorded";
			String actualLabel = driver.findElement(By.xpath("//*[@id=\"update-selected-info\"]/tbody/tr[9]/td[1]/label")).getText();
			Assert.assertEquals(actualLabel, expectedLabel);
			System.out.println("Expected Label while adding AD agent : "+expectedLabel);
			System.out.println("Actual Label while adding AD agent: " +actualLabel);
		//Enter email
			driver.findElement(By.id("tbEmail")).sendKeys("tanveer.ahmad@amigo-software.com"); 
		//Enable the account
			driver.findElement(By.id("cbEnableAccount")).click();
		//Select extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
		
			
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait11 = new WebDriverWait(driver,30);
			WebElement btnMain11;
			btnMain11= wait11.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		//Select the Agent security group from Available table
		//Get the table and row
			WebElement table1 =driver.findElement(By.id("Table2"));
			WebElement tbody1=table1.findElement(By.tagName("tbody"));
			List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
			String row1No="";
			String Security_Group = "Agent";
			for(int i=0;i<rows1.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
			//row1No=row1No+1;
			row1No=Integer.toString(i+1);
			
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait12 = new WebDriverWait(driver,30);
			WebElement btnMain12;
			btnMain12= wait12.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
		
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait13 = new WebDriverWait(driver,30);
			WebElement btnMain13;
			btnMain13= wait13.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg1 = "Settings have been saved successfully. Do you want to add rules for this user?";
		//Wait for the browser to respond
			WebDriverWait wait14 = new WebDriverWait(driver,30);
			WebElement btnMain14;
			btnMain14= wait14.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg1 = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg1, expectedmsg1);
			
		//Click on Cancel button on popup window
			driver.findElement(By.xpath("//*[@id=\"btnCancel\"]/span")).click();
		Thread.sleep(2000);
		//Search the added agent
			Select dropdown1 = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown1.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("tanveer.ahmad");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "tanveer.ahmad";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
			
			if(row.getText().trim().contains(Username))
			{
			String expectedusername = row.getText();
			Assert.assertEquals(Username, expectedusername);
					
			System.out.println("Expected User name : "+expectedusername);
			System.out.println("Actual Username : " +Username);
		//break;
			}
			}
			System.out.println(row2No);
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/table/tbody/tr/td[7]/div/img[1]")).click();
		//Verify "Notify when a call is recorded" label is available
			String expectedLabel1 = "Notify when a call is recorded";
			String actualLabel1 = driver.findElement(By.xpath("//*[@id=\"update-selected-info\"]/tbody/tr[9]/td[1]/label")).getText();
			Assert.assertEquals(actualLabel1, expectedLabel1);
			System.out.println("Expected Label while updating AD agent : "+expectedLabel1);
			System.out.println("Actual Label while updating AD agent: " +actualLabel1);
	}
	
	
	
	

	//Delete Active Directory user from system
	@Test(priority=49)
	public void DeleteAgentCreatedIn1062() throws InterruptedException {
		System.out.println("DeleteAgentCreatedIn1062");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFieldName")));
		//Search the added agent	
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("tanveer.ahmad");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "tanveer.ahmad";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
	
			if(row.getText().trim().contains(Username))
			{
			String expectedusername = row.getText();
			Assert.assertEquals(Username, expectedusername);
	
			System.out.println("Expected User name : "+expectedusername);
			System.out.println("Actual Username : " +Username);
			row2No=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(row2No);
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/table/tbody/tr["+row2No+"]/td[7]/div/img[2]")).click();
		 
			String expectedmsg1="Are you sure you want to delete?";
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg1 = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg1, expectedmsg1);
	 
			System.out.println("Expected Result : "+expectedmsg1);
			System.out.println("Actual Result : " +actualmsg1);
		//Click on Delete button
			driver.findElement(By.id("btnDelete")).click();
		//Verify the message
			String expectedmsg2="Record has been deleted successfully";
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblErrorMsg")));
			String actualmsg2 = driver.findElement(By.id("lblErrorMsg")).getText();
			Assert.assertEquals(actualmsg2, expectedmsg2);
		 
			System.out.println("Expected Result1 : "+expectedmsg2);
			System.out.println("Actual Result1 : " +actualmsg2);
	 
		}








	//Test ID 10-63
		//Verify that user is able to enable "Notify when a call is recorded" option against any newly created agent
	@Test(priority=50)
	public void VerifyAddingADAgentWithNotify() throws InterruptedException {
		System.out.println("VerifyAddingADAgentWithNotify");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait8 = new WebDriverWait(driver,30);
			WebElement btnMain8;
			btnMain8= wait8.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Wait for the browser to respond
			WebDriverWait wait9 = new WebDriverWait(driver,30);
			WebElement btnMain9;
			btnMain9= wait9.until(ExpectedConditions.visibilityOfElementLocated(By.id("linkAddActiveDirectoryAgent")));
		//Click on Add Active Directory Agent
			driver.findElement(By.id("linkAddActiveDirectoryAgent")).click();
			Thread.sleep(2000);
		//Search Tanveer Ahmad
			driver.findElement(By.xpath("//*[@id=\"gvADUsers_filter\"]/label/input")).sendKeys("Tanveer Ahmad"); 
		//Select Tanveer Ahmad
			driver.findElement(By.xpath("//*[@id=\"gvADUsers\"]/tbody/tr/td[3]/img")).click();
		//Wait for the browser to respond
			WebDriverWait wait10 = new WebDriverWait(driver,30);
			WebElement btnMain10;
			btnMain10= wait10.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbEmail")));
		//Select a checkbox against Notify when call is recorded
			driver.findElement(By.id("cbSendEmail")).click();
		//Enter email
			driver.findElement(By.id("tbEmail")).sendKeys("tanveer.ahmad@amigo-software.com"); 
		//Enable the account
			driver.findElement(By.id("cbEnableAccount")).click();
		//Select extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
	
		
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait11 = new WebDriverWait(driver,30);
			WebElement btnMain11;
			btnMain11= wait11.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		//Select the Agent security group from Available table
		//Get the table and row
			WebElement table1 =driver.findElement(By.id("Table2"));
			WebElement tbody1=table1.findElement(By.tagName("tbody"));
			List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
			String row1No="";
			String Security_Group = "Agent";
			for(int i=0;i<rows1.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
		//row1No=row1No+1;
			row1No=Integer.toString(i+1);
		
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait12 = new WebDriverWait(driver,30);
			WebElement btnMain12;
			btnMain12= wait12.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
	
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait13 = new WebDriverWait(driver,30);
			WebElement btnMain13;
			btnMain13= wait13.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg1 = "Settings have been saved successfully. Do you want to add rules for this user?";
		//Wait for the browser to respond
			WebDriverWait wait14 = new WebDriverWait(driver,30);
			WebElement btnMain14;
			btnMain14= wait14.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg1 = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg1, expectedmsg1);
		
		//Click on Cancel button on popup window
			driver.findElement(By.xpath("//*[@id=\"btnCancel\"]/span")).click();
			Thread.sleep(2000);
		//Search the added agent
			Select dropdown1 = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown1.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("tanveer.ahmad");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "tanveer.ahmad";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
		
			if(row.getText().trim().contains(Username))
			{
			String expectedusername = row.getText();
			Assert.assertEquals(Username, expectedusername);
				
			System.out.println("Expected User name : "+expectedusername);
			System.out.println("Actual Username : " +Username);
			}
			}
	}


	
	
	
	
	//Delete Active Directory user from system
	@Test(priority=51)
	public void VerifyDeleteADAgent1063() throws InterruptedException {
		System.out.println("VerifyDeleteADAgent1063");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFieldName")));
		//Search the added agent	
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("tanveer.ahmad");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "tanveer.ahmad";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
			if(row.getText().trim().contains(Username))
			{
			String expectedusername = row.getText();
			Assert.assertEquals(Username, expectedusername);
	
			System.out.println("Expected User name : "+expectedusername);
			System.out.println("Actual Username : " +Username);
			row2No=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(row2No);
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/table/tbody/tr["+row2No+"]/td[7]/div/img[2]")).click();
		 
			String expectedmsg1="Are you sure you want to delete?";
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg1 = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg1, expectedmsg1);
	 
			System.out.println("Expected Result : "+expectedmsg1);
			System.out.println("Actual Result : " +actualmsg1);
		//Click on Delete button
			driver.findElement(By.id("btnDelete")).click();
		//Verify the message
			String expectedmsg2="Record has been deleted successfully";
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblErrorMsg")));
			String actualmsg2 = driver.findElement(By.id("lblErrorMsg")).getText();
			Assert.assertEquals(actualmsg2, expectedmsg2);
		 
			System.out.println("Expected Result1 : "+expectedmsg2);
			System.out.println("Actual Result1 : " +actualmsg2);
	 	}
	
	
		
	
		

		
	//Test ID 10-64
		//Verify that user is able to enable "Notify when a call is recorded" option against any created  agent
	@Test(priority=52)
	public void VerifyNotifyForAlreadyCreatedADAgent() throws InterruptedException {
		System.out.println("VerifyNotifyOptionForAlreadyCreatedADAgent");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait8 = new WebDriverWait(driver,30);
			WebElement btnMain8;
			btnMain8= wait8.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Wait for the browser to respond
			WebDriverWait wait9 = new WebDriverWait(driver,30);
			WebElement btnMain9;
			btnMain9= wait9.until(ExpectedConditions.visibilityOfElementLocated(By.id("linkAddActiveDirectoryAgent")));
		//Click on Add Active Directory Agent
			driver.findElement(By.id("linkAddActiveDirectoryAgent")).click();
			Thread.sleep(2000);
		//Search Tanveer Ahmad
			driver.findElement(By.xpath("//*[@id=\"gvADUsers_filter\"]/label/input")).sendKeys("Tanveer Ahmad"); 
		//Select Tanveer Ahmad
			driver.findElement(By.xpath("//*[@id=\"gvADUsers\"]/tbody/tr/td[3]/img")).click();
		//Wait for the browser to respond
			WebDriverWait wait10 = new WebDriverWait(driver,30);
			WebElement btnMain10;
			btnMain10= wait10.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbEmail")));
		//Enter email
			driver.findElement(By.id("tbEmail")).sendKeys("tanveer.ahmad@amigo-software.com"); 
		//Enable the account
			driver.findElement(By.id("cbEnableAccount")).click();
		//Select extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		//Move the selected extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		//Select the QA team from the All teams table
		//Get the table and row
			WebElement table =driver.findElement(By.id("Table1"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			String rowNo="";
			String Teams = "QA";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Teams))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
					
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[7]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+rowNo+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait11 = new WebDriverWait(driver,30);
			WebElement btnMain11;
			btnMain11= wait11.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnTeamFromLeftToRight")));
		//Move the selected Team to the assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		//Select the Agent security group from Available table
		//Get the table and row
			WebElement table1 =driver.findElement(By.id("Table2"));
			WebElement tbody1=table1.findElement(By.tagName("tbody"));
			List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
			String row1No="";
			String Security_Group = "Agent";
			for(int i=0;i<rows1.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option["+(i+1)+"]"));
			if(row.getText().trim().contains(Security_Group))
			{
		//row1No=row1No+1;
			row1No=Integer.toString(i+1);
		
			break;
			}
			}
			System.out.println(row1No);
		//Wait for the browser to respond
			WebDriverWait wait12 = new WebDriverWait(driver,30);
			WebElement btnMain12;
			btnMain12= wait12.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option[\"+row1No+\"]")));
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[9]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option["+row1No+"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait13 = new WebDriverWait(driver,30);
			WebElement btnMain13;
			btnMain13= wait13.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSGFromLeftToRight")));
		//Move the selected security group to the assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		//Click on Save button
			driver.findElement(By.id("btnSave")).click();
		//Verify message
			String expectedmsg1 = "Settings have been saved successfully. Do you want to add rules for this user?";
		//Wait for the browser to respond
			WebDriverWait wait14 = new WebDriverWait(driver,30);
			WebElement btnMain14;
			btnMain14= wait14.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg1 = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg1, expectedmsg1);
		
		//Click on Cancel button on popup window
			driver.findElement(By.xpath("//*[@id=\"btnCancel\"]/span")).click();
			Thread.sleep(2000);
		//Search the added agent
			Select dropdown1 = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown1.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("tanveer.ahmad");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "tanveer.ahmad";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
		
			if(row.getText().trim().contains(Username))
			{
			String expectedusername = row.getText();
			Assert.assertEquals(Username, expectedusername);
				
			System.out.println("Expected User name : "+expectedusername);
			System.out.println("Actual Username : " +Username);
		//break;
			}
			}
			System.out.println(row2No);
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/table/tbody/tr/td[7]/div/img[1]")).click();
		//Select a checkbox against Notify when call is recorded
			driver.findElement(By.id("cbSendEmail")).click();
			
		//Click on Update button
	 		driver.findElement(By.id("btnSave")).click();
	 	//Verify the message
	 		String expectedmsg="Settings have been updated successfully";
	 	//Wait for the browser to respond
	 		WebDriverWait wait2 = new WebDriverWait(driver,30);
	 		WebElement btnMain2;
	 		btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-alertMessage")));
	 		String actualmsg = driver.findElement(By.id("dialog-alertMessage")).getText();
	 		Assert.assertEquals(actualmsg, expectedmsg);
			 
	 		System.out.println("Expected Result : "+expectedmsg);
	 		System.out.println("Actual Result : " +actualmsg);
			}
			

	
	
	
	
	//Test ID 10-72
		//Verify that error message is displayed when agent enables the "Notify when a call is recorded" option and leaves the email field empty
	@Test(priority=53)
	public void VerifyNotifyCallWithEmptyEmailID() throws InterruptedException {
		System.out.println("VerifyNotifyCallWithEmptyEmailID");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFieldName")));
		//Search the added agent	
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("tanveer.ahmad");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "tanveer.ahmad";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
			if(row.getText().trim().contains(Username))
			{
			String expectedusername = row.getText();
			Assert.assertEquals(Username, expectedusername);
			System.out.println("Expected User name : "+expectedusername);
			System.out.println("Actual Username : " +Username);
			row2No=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(row2No);
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/table/tbody/tr/td[7]/div/img[1]")).click();
		//Remove the email ID
			driver.findElement(By.id("tbEmail")).clear();
		//Click on Update button
	 		driver.findElement(By.id("btnSave")).click();
	 	//Verify the message
	 		String expectedmsg="Please enter Email";
	 	//Wait for the browser to respond
	 		WebDriverWait wait2 = new WebDriverWait(driver,30);
	 		WebElement btnMain2;
	 		btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMsg")));
	 		String actualmsg = driver.findElement(By.id("lblMsg")).getText();
	 		Assert.assertEquals(actualmsg, expectedmsg);
			 
	 		System.out.println("Expected Result : "+expectedmsg);
	 		System.out.println("Actual Result : " +actualmsg);
			}
	
	
	
	
	
	//Delete Active Directory user from system
	@Test(priority=54)
	public void VerifyDeleteADAgent1064() throws InterruptedException {
		System.out.println("VerifyDeleteADAgent1064");
		driver.get(siteUrl);
		//Enter Site Code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on Login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFieldName")));
		//Search the added agent	
			Select dropdown = new Select(driver.findElement(By.id("ddlFieldName")));
			dropdown.selectByVisibleText("Username");
			driver.findElement(By.id("tbFind")).sendKeys("tanveer.ahmad");
		//Click on Find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table2 =driver.findElement(By.id("gvUsers"));
			WebElement tbody2=table2.findElement(By.tagName("tbody"));
			List<WebElement> rows2=tbody2.findElements(By.tagName("tr"));
			String row2No="";
			String Username = "tanveer.ahmad";
			for(int i=0;i<rows2.size();i++)
			{
			WebElement row = tbody2.findElement(By.xpath("//*[@id=\"gvUsers\"]/tbody/tr["+(i+1)+"]/td[3]/span"));
			if(row.getText().trim().contains(Username))
			{
			String expectedusername = row.getText();
			Assert.assertEquals(Username, expectedusername);
			System.out.println("Expected User name : "+expectedusername);
			System.out.println("Actual Username : " +Username);
			row2No=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(row2No);
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/table/tbody/tr["+row2No+"]/td[7]/div/img[2]")).click();
			 
			String expectedmsg1="Are you sure you want to delete?";
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg1 = driver.findElement(By.id("dialog-message")).getText();
			Assert.assertEquals(actualmsg1, expectedmsg1);
		 
			System.out.println("Expected Result : "+expectedmsg1);
			System.out.println("Actual Result : " +actualmsg1);
		//Click on Delete button
			driver.findElement(By.id("btnDelete")).click();
		//Verify the message
			String expectedmsg2="Record has been deleted successfully";
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblErrorMsg")));
			String actualmsg2 = driver.findElement(By.id("lblErrorMsg")).getText();
			Assert.assertEquals(actualmsg2, expectedmsg2);
			 
			System.out.println("Expected Result1 : "+expectedmsg2);
			System.out.println("Actual Result1 : " +actualmsg2);
			}
		
		
		
	
	//Reset the authentication settings
	@Test(priority=55)
	public void ResetAuthenticationSettings() throws InterruptedException {
		driver.get(siteUrl);
		//Switch the role to server administration
			driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_lblServerAdministration")));
			
			driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctrl_TenantAdmin1_txtUserName")));
				String expectedurl="ExpectedServerURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
			//Enter Username
				driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			//Enter Password
				driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			//Click on Login button
				driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
				
				Thread.sleep(1000);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
				
			//Click on system tab
				driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
			
			//Click on reset button under authentication settings
				driver.findElement(By.id("btnResetAuthSettings")).click();
				
			//Verify the message
				String expectedmsg1 = "Settings have been updated successfully";
			//Wait for the browser to respond
				WebDriverWait wait2 = new WebDriverWait(driver,30);
				WebElement btnMain2;
				btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
				  String actualmsg1 = driver.findElement(By.id("lblMessageAuthentication")).getText();
				  Thread.sleep(2000);
				  Assert.assertEquals(actualmsg1, expectedmsg1);
				  
				//Click on update button
				  driver.findElement(By.id("btnUpdateAuthSettings")).click();
				  
				//Verify the message
					String expectedmsg2 = "Settings have been updated successfully";
				//Wait for the browser to respond
					WebDriverWait wait3 = new WebDriverWait(driver,30);
					WebElement btnMain3;
					btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
					String actualmsg2 = driver.findElement(By.id("lblMessageAuthentication")).getText();
					Assert.assertEquals(actualmsg2, expectedmsg2);
				  }	

	
	
	
	
	@AfterTest
	public void tearDownTest() throws InterruptedException {
				
		System.out.println("Test Completed Successfully");
		driver.quit();
	}


	}
