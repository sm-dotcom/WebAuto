package SiteAdministration;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import java.io.Console;
import java.io.File;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
import org.openqa.selenium.firefox.FirefoxDriver;

public class SiteSearch_Calls {
		
		private final WebElement TimeZone = null;
		WebDriver driver = null;
		//WebDriverWait wait = new WebDriverWait(driver, 15);
		public String siteUrl = "http://172.20.22.81/OmniPCXRECORD/default.aspx";
		public String ExpectedSiteURL = "http://172.20.22.81/OmniPCXRECORD/default.aspx";
		public String ExpectedServerURL = "http://172.20.22.81/OmniPCXRecord/TenantAdmin.aspx";
		
		@BeforeTest
		public void setUpTest() {
			
			SimpleDateFormat date_format=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrator\\Desktop\\FilesToSetup\\geckodriver.exe");
			driver=new FirefoxDriver();
		}

			

		//Test ID 28-01
			//Verify Search button functionality 
		@Test(priority=0)
		public void VerifySearchCallPageFunctionality() throws InterruptedException {
			System.out.println("VerifySearchCallPageFunctionality");
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();
			//Verify the web page
				String ExpectedURL = "http://localhost/OmniPCXRECORD/Searches.aspx";
				String ActualURL= driver.getCurrentUrl();
				Assert.assertEquals(ActualURL,ExpectedURL);
				System.out.println("Expected URL : "+ExpectedURL);
				System.out.println("Actual URL : " +ActualURL);
		}
		
		
		
		
		//Test ID 28-02
			//Verify Count result button functionality (for today's call)
		@Test(priority=1)
		public void VerifyCountResultsButtonForTodayCallFunctionality() throws InterruptedException {
			System.out.println("VerifyCountResultsButtonForTodayCallFunctionality");
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();
			//Verify the web page
				String ExpectedURL = "http://localhost/OmniPCXRECORD/Searches.aspx";
				String ActualURL= driver.getCurrentUrl();
				Assert.assertEquals(ActualURL,ExpectedURL);
				System.out.println("Expected URL : "+ExpectedURL);
				System.out.println("Actual URL : " +ActualURL);
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
			//Verify the result is displayed
				String currentresult = driver.findElement(By.id("lblCountRecords")).getText();
				System.out.println("Current Result : "+currentresult);
		}
		
		
		
		
		
		//Test ID 28-03
			//Verify Select a Team dropdown functionality.
		@Test(priority=2)
		public void VerifyTeamDropdownFunctionalityInSearchCalls() throws InterruptedException {
			System.out.println("VerifyTeamDropdownFunctionalityInSearchCalls");
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();
			//Verify the web page
				String ExpectedURL = "http://localhost/OmniPCXRECORD/Searches.aspx";
				String ActualURL= driver.getCurrentUrl();
				Assert.assertEquals(ActualURL,ExpectedURL);
				System.out.println("Expected URL : "+ExpectedURL);
				System.out.println("Actual URL : " +ActualURL);
			//Click on Select a Team dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlGroups")));
			//Select QA Team
				dropdown.selectByVisibleText("QA");
			//Click on Call Date and Time dropdown
				Select dropdown1 = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day
				dropdown1.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//The available columns exists as options in SELECT element
				WebElement element = driver.findElement(By.id("FromLB")); 
			//Creating an object for the element type Select
				Select select = new Select(element);
			//Get the total number of options available in the Select
				int rowcount = select.getOptions().size();
				String Column = "Team";
				Boolean Expected = false;
			//Search the select option
				for(int i=0;i<=rowcount;i++)
				{
				if(element.getText().trim().contains(Column))
				{
			//Select the element if the passed column exist in the available options
				select.selectByVisibleText(Column);
			//Move the selected option to assigned column
				driver.findElement(By.xpath("//*[@id=\"Table3\"]/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();
			//Click on Search Search button
				driver.findElement(By.id("btnSearch")).click();
				Expected = true;
				break;
				}
				}
				Boolean Actual = true;
				Assert.assertEquals(Actual, Expected);
			Thread.sleep(2000);
			//Check the web page is changed to searchresult	
				String expectedurl = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String actualurl= driver.getCurrentUrl();
				Assert.assertEquals(actualurl,expectedurl);
				}
		
		
		

		
		//Test ID 28-04
			//Verify Time Zone functionality.
		@Test(priority=3)
		public void VerifyTimeZoneInSearchCallsWithSystem() throws InterruptedException {
			System.out.println("VerifyTimeZoneInSearchCallsWithSystem");
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();
			//Verify the web page
				String ExpectedURL = "http://localhost/OmniPCXRECORD/Searches.aspx";
				String ActualURL= driver.getCurrentUrl();
				Assert.assertEquals(ActualURL,ExpectedURL);
				System.out.println("Expected URL : "+ExpectedURL);
				System.out.println("Actual URL : " +ActualURL);
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				Select select = new Select(driver.findElement(By.id("ddlTimeZone")));
				WebElement option = select.getFirstSelectedOption();
				String TimeZoneInSearchCalls = option.getText();
				System.out.println("Default Time Zone : "+TimeZoneInSearchCalls );
			//Object TimeZoneInfo;
			//Get the client system timezone where this test is executed
			//String CurrentTimeZoneOfSystem = TimeZone.getDefault();
				Calendar now = Calendar.getInstance();
			//get current TimeZone using getTimeZone method of Calendar class
				TimeZone timeZone = now.getTimeZone();
				//display current TimeZone using getDisplayName() method of TimeZone class
				System.out.println("Current TimeZone is : " + timeZone.getDisplayName());
				String CurrentTimeZoneOfSystem = timeZone.getDisplayName();
				if (CurrentTimeZoneOfSystem== "Pakistan Standard Time") {
					CurrentTimeZoneOfSystem = "(GMT +5:00) Ekaterinburg, Islamabad, Karachi, Tashkent";
					
				}
				
				Assert.assertEquals(TimeZoneInSearchCalls, CurrentTimeZoneOfSystem);
				
				System.out.println("Timezone get from Search : "+TimeZoneInSearchCalls);
		}
				
				
					
		
		
		//Test ID 28-06
				//Verify Call Date and time functionality
		@Test(priority=4)
		public void VerifyCallDateAndTimeFunctionality() throws InterruptedException {
			System.out.println("VerifyCallDateAndTimeFunctionality");
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();
			//Verify the web page
				String ExpectedURL = "http://localhost/OmniPCXRECORD/Searches.aspx";
				String ActualURL= driver.getCurrentUrl();
				Assert.assertEquals(ActualURL,ExpectedURL);
				System.out.println("Expected URL : "+ExpectedURL);
				System.out.println("Actual URL : " +ActualURL);
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
			//Verify the result is displayed
				String currentresult = driver.findElement(By.id("lblCountRecords")).getText();
				System.out.println("Current Result : "+currentresult);
			//Wait for the browser to respond
				WebDriverWait wait2 = new WebDriverWait(driver,30);
				WebElement btnMain2;
				btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSearch")));
			//Verify the result of search calls button
				driver.findElement(By.id("btnSearch")).click();
				Thread.sleep(5000);
			//Verify the web page
				String ExpectedURL1 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String ActualURL1= driver.getCurrentUrl();
				Assert.assertEquals(ActualURL1,ExpectedURL1);
				System.out.println("Expected URL : "+ExpectedURL1);
				System.out.println("Actual URL : " +ActualURL1);
			}
				
		
		
		
		
		//Test ID 28-07
				//Verify Count result button functionality (for yesterday's call)
		@Test(priority=5)
		public void VerifyCountResultsButtonFunctionalityForYesterdayCalls() throws InterruptedException {
			System.out.println("VerifyCountResultsButtonFunctionalityForYesterdayCalls");
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();
			//Verify the web page
				String ExpectedURL = "http://localhost/OmniPCXRECORD/Searches.aspx";
				String ActualURL= driver.getCurrentUrl();
				Assert.assertEquals(ActualURL,ExpectedURL);
				System.out.println("Expected URL : "+ExpectedURL);
				System.out.println("Actual URL : " +ActualURL);
			//Click on Call Date and Time dropdown	
				Select dropdown = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring Yesterday	  
				dropdown.selectByVisibleText("Occurring Yesterday");
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
			//Verify the result is displayed
				String currentresult = driver.findElement(By.id("lblCountRecords")).getText();
				System.out.println("Current Result : "+currentresult);
			//Verify the result of search calls button
				driver.findElement(By.id("btnSearch")).click();
				Thread.sleep(5000);
			//Verify the web page
				String ExpectedURL1 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String ActualURL1= driver.getCurrentUrl();
				Assert.assertEquals(ActualURL1,ExpectedURL1);
				System.out.println("Expected URL : "+ExpectedURL1);
				System.out.println("Actual URL : " +ActualURL1);
			}

		
		
		
		
		//Test ID 28-08
			//Verify Count result button functionality (for past 1 hour call)
		@Test(priority=6)
		public void VerifyCountResultsButtonFunctionalityForPast1HrCalls() throws InterruptedException {
			System.out.println("VerifyCountResultsButtonFunctionalityForPast1HrCalls");
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();
			//Verify the web page
				String ExpectedURL = "http://localhost/OmniPCXRECORD/Searches.aspx";
				String ActualURL= driver.getCurrentUrl();
				Assert.assertEquals(ActualURL,ExpectedURL);
				System.out.println("Expected URL : "+ExpectedURL);
				System.out.println("Actual URL : " +ActualURL);
			//Click on Call Date and Time dropdown	
				Select dropdown = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring Yesterday	  
				dropdown.selectByVisibleText("Occurring in past 1 Hour");
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
			//Verify the result is displayed
				String currentresult = driver.findElement(By.id("lblCountRecords")).getText();
				System.out.println("Current Result : "+currentresult);
			//Verify the result of search calls button
				driver.findElement(By.id("btnSearch")).click();
				Thread.sleep(5000);
			//Verify the web page
				String ExpectedURL1 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String ActualURL1= driver.getCurrentUrl();
				Assert.assertEquals(ActualURL1,ExpectedURL1);
				System.out.println("Expected URL : "+ExpectedURL1);
				System.out.println("Actual URL : " +ActualURL1);
			}
		
		
		
		
		
		
		//Test ID 28-09
			//Verify Count result button functionality (for past 4 hours call)
		@Test(priority=7)
		public void VerifyCountResultsButtonFunctionalityForPast4HrsCalls() throws InterruptedException {
			System.out.println("VerifyCountResultsButtonFunctionalityForPast4HrsCalls");
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();
			//Verify the web page
				String ExpectedURL = "http://localhost/OmniPCXRECORD/Searches.aspx";
				String ActualURL= driver.getCurrentUrl();
				Assert.assertEquals(ActualURL,ExpectedURL);
				System.out.println("Expected URL : "+ExpectedURL);
				System.out.println("Actual URL : " +ActualURL);
			//Click on Call Date and Time dropdown	
				Select dropdown = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring Yesterday	  
				dropdown.selectByVisibleText("Occurring in past 4 Hours");
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
			//Verify the result is displayed
				String currentresult = driver.findElement(By.id("lblCountRecords")).getText();
				System.out.println("Current Result : "+currentresult);
			//Verify the result of search calls button
				driver.findElement(By.id("btnSearch")).click();
				Thread.sleep(5000);
			//Verify the web page
				String ExpectedURL1 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String ActualURL1= driver.getCurrentUrl();
				Assert.assertEquals(ActualURL1,ExpectedURL1);
				System.out.println("Expected URL : "+ExpectedURL1);
				System.out.println("Actual URL : " +ActualURL1);
			}	
		
		
		
		
		
		
		//Test ID 28-10
			//Verify Count result button functionality (for past 7 days call)
		@Test(priority=8)
		public void VerifyCountResultsButtonFunctionalityForPast7DaysCalls() throws InterruptedException {
			System.out.println("VerifyCountResultsButtonFunctionalityForPast7DaysCalls");
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();
			//Verify the web page
				String ExpectedURL = "http://localhost/OmniPCXRECORD/Searches.aspx";
				String ActualURL= driver.getCurrentUrl();
				Assert.assertEquals(ActualURL,ExpectedURL);
				System.out.println("Expected URL : "+ExpectedURL);
				System.out.println("Actual URL : " +ActualURL);
			//Click on Call Date and Time dropdown	
				Select dropdown = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring Yesterday	  
				dropdown.selectByVisibleText("Occurring in past 7 Days");
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
			//Verify the result is displayed
				String currentresult = driver.findElement(By.id("lblCountRecords")).getText();
				System.out.println("Current Result : "+currentresult);
			//Verify the result of search calls button
				driver.findElement(By.id("btnSearch")).click();
				Thread.sleep(5000);
			//Verify the web page
				String ExpectedURL1 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String ActualURL1= driver.getCurrentUrl();
				Assert.assertEquals(ActualURL1,ExpectedURL1);
				System.out.println("Expected URL : "+ExpectedURL1);
				System.out.println("Actual URL : " +ActualURL1);
			}
		
		
		
		
		
		
		//Test ID 28-11
			//Verify Count result and Search button functionality (for past 30 days call)
		@Test(priority=9)
		public void VerifyCountNSearchResultsButtonFunctionalityForPast30DaysCalls() throws InterruptedException {
			System.out.println("VerifyCountNSearchResultsButtonFunctionalityForPast30DaysCalls");
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();
			//Verify the web page
				String ExpectedURL = "http://localhost/OmniPCXRECORD/Searches.aspx";
				String ActualURL= driver.getCurrentUrl();
				Assert.assertEquals(ActualURL,ExpectedURL);
				System.out.println("Expected URL : "+ExpectedURL);
				System.out.println("Actual URL : " +ActualURL);
			//Click on Call Date and Time dropdown	
				Select dropdown = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring Yesterday	  
				dropdown.selectByVisibleText("Occurring in past 30 Days");
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
			//Verify the result is displayed
				String currentresult = driver.findElement(By.id("lblCountRecords")).getText();
				System.out.println("Current Result : "+currentresult);
			//Verify the result of search calls button
				driver.findElement(By.id("btnSearch")).click();
				Thread.sleep(5000);
			//Verify the web page
				String ExpectedURL1 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String ActualURL1= driver.getCurrentUrl();
				Assert.assertEquals(ActualURL1,ExpectedURL1);
				System.out.println("Expected URL : "+ExpectedURL1);
				System.out.println("Actual URL : " +ActualURL1);
			}
		
		
		
		
		
		//Test ID 28-12
			//Verify Count result button functionality (for past 30 days call)
		@Test(priority=10)
		public void VerifyCountNSearchResultsButtonFunctionalityFor999DaysCalls() throws InterruptedException {
			System.out.println("VerifyCountNSearchResultsButtonFunctionalityFor999DaysCalls");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day  
				dropdown.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field  
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
			//Verify the result is displayed
				String currentresult = driver.findElement(By.id("lblCountRecords")).getText();
				System.out.println("Current Result : "+currentresult);
			//Verify the result of search calls button
				driver.findElement(By.id("btnSearch")).click();
				Thread.sleep(5000);
			//Verify the web page
				String ExpectedURL1 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String ActualURL1= driver.getCurrentUrl();
				Assert.assertEquals(ActualURL1,ExpectedURL1);
				System.out.println("Expected URL : "+ExpectedURL1);
				System.out.println("Actual URL : " +ActualURL1);
			}
		
		
		
		
		
		
		//Test ID 28-13
			//1-Go to Call Date and time area select "Occurring in past N days" criteria from drop down.  
			//2- do not enter any value in empty field.
			//3-Click on search button 
		@Test(priority=11)
		public void VerifyErrorMessageNdaysWithoutNoOfDays() throws InterruptedException {
			System.out.println("VerifyErrorMessageNdaysWithoutNoOfDays");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day  
				dropdown.selectByVisibleText("Occurring in past N Days");
				//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMsgVal")));
				//Verify message
				String expectedmsg = "Please enter number of days";
			//Wait for the browser to respond
				WebDriverWait wait14 = new WebDriverWait(driver,30);
				WebElement btnMain14;
				btnMain14= wait14.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMsgVal")));
				String actualmsg = driver.findElement(By.id("lblMsgVal")).getText();
				Assert.assertEquals(actualmsg, expectedmsg);
				System.out.println("Expected Message : "+expectedmsg);
				System.out.println("Actual Message : " +actualmsg);
		}
		
		

		
		
		
		//Test ID 28-15
			//Verify the count and search result in User specified criteria
		@Test(priority=12)
		public void VerifyCountNSearchResultInUserSpecifiedCriteria() throws InterruptedException {
			System.out.println("VerifyCountNSearchResultInUserSpecifiedCriteria");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select User Specified  
				dropdown.selectByVisibleText("User Specified");
			//Enter From date
				driver.findElement(By.id("tbStartDate")).sendKeys("01/01/2021");
			//Enter To date
				driver.findElement(By.id("tbEndDate")).sendKeys("08/07/2021");
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
			//Verify the result is displayed
				String currentresult = driver.findElement(By.id("lblCountRecords")).getText();
				System.out.println("Current Result : "+currentresult);
			//Verify the result of search calls button
				driver.findElement(By.id("btnSearch")).click();
				Thread.sleep(5000);
			//Verify the web page
				String ExpectedURL1 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String ActualURL1= driver.getCurrentUrl();
				Assert.assertEquals(ActualURL1,ExpectedURL1);
				System.out.println("Expected URL : "+ExpectedURL1);
				System.out.println("Actual URL : " +ActualURL1);
			}
		
		
		
			
		
		
		//Test ID 28-16
			//"1-Make some call.
			//2-Go to Call Date and time area select ""User Specified"" criteria from drop down.
			//3- Enter wrong date in ""From"" field and in ""To"" field.
			//3-Click on Count Results button. 
			//4-Click on search button"
		@Test(priority=13)
		public void VerifyErrorMessageInUserSpecifiedWithFutureFromDate() throws InterruptedException {
			System.out.println("VerifyErrorMessageInUserSpecifiedWithFutureFromDate");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select User Specified  
				dropdown.selectByVisibleText("User Specified");
			//Enter From date
			//First get the current date from the system where this test is executed
				//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, 1);
				Date d = (Date) cal.getTime();
				//System.out.println("Date d :: " + d);
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String dateString = sdf.format(d);
				String insert = driver.findElement(By.tagName("dateString")).getText(); 
				driver.findElement(By.id("tbStartDate")).sendKeys("09/07/2021");
			//Enter To date
				driver.findElement(By.id("tbEndDate")).sendKeys("08/07/2021");
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMsgVal")));
			//Verify message
				String expectedmsg = "From date cannot be a future date.";
			//Wait for the browser to respond
				WebDriverWait wait14 = new WebDriverWait(driver,30);
				WebElement btnMain14;
				btnMain14= wait14.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMsgVal")));
				String actualmsg = driver.findElement(By.id("lblMsgVal")).getText();
				Assert.assertEquals(actualmsg, expectedmsg);
				System.out.println("Expected Message : "+expectedmsg);
				System.out.println("Actual Message : " +actualmsg);
		}
		
		
		
		
		
		
		
		
		//Test ID 28-17
			//1-Make some call.
			//2-Go to Call Date and time area select ""User Specified"" criteria from drop down.
			//3- Enter wrong date in ""From"" field and correct date in ""To"" field.
			//3-Click on Count Results button. 
			//4-Click on search button"

			@Test(priority=13)
			public void VerifyErrorMessageInUserSpecifiedWithOlderToDate() throws InterruptedException {
				System.out.println("VerifyErrorMessageInUserSpecifiedWithOlderToDate");
					driver.get(siteUrl);
				//Enter Site code
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
					btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
					String expectedurl="ExpectedSiteURL";
					String actualurl=driver.getCurrentUrl();
					System.out.println("Actual Url:"+actualurl);
					System.out.println("Expected Url:"+expectedurl);
					String actualurl1="siteUrl";
					String expectedurl1= driver.getCurrentUrl();
					Assert.assertNotEquals(actualurl1,expectedurl1);
				//Click on Search Calls
					driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
				//Click on Call Date and Time dropdown
					Select dropdown = new Select(driver.findElement(By.id("ddlDateTime")));
				//Select User Specified  
					dropdown.selectByVisibleText("User Specified");
				//Enter From date
					driver.findElement(By.id("tbStartDate")).sendKeys("08/07/2021");
				//Enter To date
					driver.findElement(By.id("tbEndDate")).sendKeys("07/07/2021");
				//Click on Count Result button
					driver.findElement(By.id("btnCount")).click();
				//Wait for the browser to respond
					WebDriverWait wait1 = new WebDriverWait(driver,30);
					WebElement btnMain1;
					btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMsgVal")));
				//Verify message
					String expectedmsg = "'To Call date/time' should be greater than or equal to 'From Call date/time'";
				//Wait for the browser to respond
					WebDriverWait wait14 = new WebDriverWait(driver,30);
					WebElement btnMain14;
					btnMain14= wait14.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMsgVal")));
					String actualmsg = driver.findElement(By.id("lblMsgVal")).getText();
					Assert.assertEquals(actualmsg, expectedmsg);
					System.out.println("Expected Message : "+expectedmsg);
					System.out.println("Actual Message : " +actualmsg);
			}
		

			
			
			
			
			
			
		
		//Test ID 28-18
			//"1-Make some call.
			//2-Go to Call Date and time area select ""User Specified"" criteria from drop down.
			//3- Enter correct ""From ""date in field and wrong  ""To"" date in field. (2021/08/28)
			//3-Click on Count Results button. 
			//4-Click on search button"
		
		
		
		@Test(priority=14)
		public void VerifyErrorMessageWithWrongToDate() throws InterruptedException {
			System.out.println("VerifyErrorMessageWithWrongToDate");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select User Specified  
				dropdown.selectByVisibleText("User Specified");
			//Enter From date
				driver.findElement(By.id("tbStartDate")).sendKeys("08/07/2021");
			//Define the date format
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			//Plus 1 day in current date	
				LocalDateTime now = LocalDateTime.now().plusDays(1);
				String NewDate= (dtf.format(now));
				System.out.println(dtf.format(now));  
				
			//Enter To date
				driver.findElement(By.id("tbEndDate")).sendKeys(NewDate);
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMsgVal")));
			//Verify message
				String expectedmsg = "Please provide valid 'To Date'";
			//Wait for the browser to respond
				WebDriverWait wait14 = new WebDriverWait(driver,30);
				WebElement btnMain14;
				btnMain14= wait14.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMsgVal")));
				String actualmsg = driver.findElement(By.id("lblMsgVal")).getText();
				Assert.assertEquals(actualmsg, expectedmsg);
				System.out.println("Expected Message : "+expectedmsg);
				System.out.println("Actual Message : " +actualmsg);
		}	

		
		
		
		
		
		
		//Test ID 28-19
			//"1-Make some call.
			//2-Go to Call Date and time area select ""User Specified"" criteria from drop down.
			//3- select correct time in ""From ""date  and  ""To"" date dropdown.
			//3-Click on Count Results button. 
			//4-Click on search button"

			//"In this case calls count should be displayed and only those calls should be shown which recorded in specified time and date you entered in field.
			//Notify: Number of calls count and calls in search should be the same. "

			@Test(priority=15)
			public void VerifyCountAndSearchResultAreSame() throws InterruptedException {
				System.out.println("VerifyCountAndSearchResultAreSame");
					driver.get(siteUrl);
				//Enter Site code
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
					btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
					String expectedurl="ExpectedSiteURL";
					String actualurl=driver.getCurrentUrl();
					System.out.println("Actual Url:"+actualurl);
					System.out.println("Expected Url:"+expectedurl);
					String actualurl1="siteUrl";
					String expectedurl1= driver.getCurrentUrl();
					Assert.assertNotEquals(actualurl1,expectedurl1);
				//Click on Search Calls
					driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
				//Click on Call Date and Time dropdown
					Select dropdown = new Select(driver.findElement(By.id("ddlDateTime")));
				//Select User Specified  
					dropdown.selectByVisibleText("User Specified");
				//Enter From date
					driver.findElement(By.id("tbStartDate")).sendKeys("01/01/2021");
				//Enter To date
					driver.findElement(By.id("tbEndDate")).sendKeys("31/07/2021");
				//Click on Count Result button
					driver.findElement(By.id("btnCount")).click();
				
				//Wait for the browser to respond
					WebDriverWait wait1 = new WebDriverWait(driver,30);
					WebElement btnMain1;
					btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
				//Verify the result is displayed
					String currentresult = driver.findElement(By.id("lblCountRecords")).getText();
					System.out.println("Current Result : "+currentresult);
				//Wait for the browser to respond
					WebDriverWait wait2 = new WebDriverWait(driver,30);
					WebElement btnMain2;
					btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
					String actualresult = driver.findElement(By.id("lblCountRecords")).getText();
					Assert.assertEquals(actualresult, currentresult);
					System.out.println("Expected Message : "+currentresult);
					System.out.println("Actual Message : " +actualresult);
					
				//Click on Search button
					driver.findElement(By.id("btnSearch")).click();
				Thread.sleep(5000);
				//Check the web page is changed to searchresult	
					String expectedurl2 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
					String actualurl2= driver.getCurrentUrl();
					Assert.assertEquals(actualurl2,expectedurl2);
					Thread.sleep(5000);
				//Identifying the number of rows having <tr> tag
					
					WebElement ToGetrows = driver.findElement(By.xpath("//table[@id='tblCallDetail']/tbody/tr"));

					List<WebElement> TotalRowsList = ToGetrows.findElements(By.tagName("tr"));
				//Total rows -2 because the table includes header and footer so we need to exclude them
					int totalCalls= TotalRowsList.size()-2;
				//Now convert the integer value to String
					String s=Integer.toString(totalCalls);
					System.out.println("Total Number of Rows found in the table are: "+totalCalls);
					Thread.sleep(2000);
				//Match the count and search result which should be same
					Assert.assertEquals(s, currentresult);
					}
			
			
			
		
			
			
			
		//Test ID 28-20 is covered in 28-18
		
		
		//Test ID 28-22
			//"1-Make some call.
			//2-Go to Call Date and time area select ""User Specified"" criteria from drop down.
			//3- select wrong time in ""From ""date  and  ""To"" date dropdown.
			//3-Click on Count Results button. 
			//4-Click on search button"
			//It should display error "'To Call date/time' should be greater than or equal to 'From Call date/time'  " 


		@Test(priority=16)
		public void VerifyErrorMessageToDateCannotBeFutureDate() throws InterruptedException {
			System.out.println("VerifyErrorMessageToDateCannotBeFutureDate");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select User Specified  
				dropdown.selectByVisibleText("User Specified");
			//Enter From date
				driver.findElement(By.id("tbStartDate")).sendKeys("08/07/2021");
			//Define the date format
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			//Plus 1 day in current date	
				LocalDateTime now = LocalDateTime.now().plusDays(1);
				String NewDate= (dtf.format(now));
				System.out.println(dtf.format(now));  
				
			//Enter To date
				driver.findElement(By.id("tbEndDate")).sendKeys(NewDate);
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMsgVal")));
			//Verify message
				String expectedmsg = "To date cannot be a future date.";
			//Wait for the browser to respond
				WebDriverWait wait14 = new WebDriverWait(driver,30);
				WebElement btnMain14;
				btnMain14= wait14.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMsgVal")));
				String actualmsg = driver.findElement(By.id("lblMsgVal")).getText();
				Assert.assertEquals(actualmsg, expectedmsg);
				System.out.println("Expected Message : "+expectedmsg);
				System.out.println("Actual Message : " +actualmsg);
		}	
		
		
		
		
		
		
		//Test ID 28-23
			//Verify First Name functionality
			//"1-Make some call.
		//2-Go to First Name area. Select ""Starts With"" from dropdown.
		//3-Enter some starting alphabets of first name of agent whom you want to search.
		//4-Click on Count Results button.                                           
		//5-Click on search button"

		@Test(priority=17)
		public void VerifySearchCallsWithFirstNameStartsWith() throws InterruptedException {
			System.out.println("VerifySearchCallsWithFirstNameStartsWith");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown1 = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day
				dropdown1.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFirstName")));
			//Click on First Name dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlFirstName")));
			//Select Start With criteria
				dropdown.selectByVisibleText("Starts with");
			//Enter Ma as a first name starts
				driver.findElement(By.id("txtFirstName")).sendKeys("Ma");
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			
			//Wait for the browser to respond
				WebDriverWait wait2 = new WebDriverWait(driver,30);
				WebElement btnMain2;
				btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
			//Verify the result is displayed
				String currentresult = driver.findElement(By.id("lblCountRecords")).getText();
				System.out.println("Current Result : "+currentresult);
			//Wait for the browser to respond
				WebDriverWait wait3 = new WebDriverWait(driver,30);
				WebElement btnMain3;
				btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
				String actualresult = driver.findElement(By.id("lblCountRecords")).getText();
				Assert.assertEquals(actualresult, currentresult);
				System.out.println("Expected Message : "+currentresult);
				System.out.println("Actual Message : " +actualresult);
				
			//Click on Search button
				driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(5000);
			//Check the web page is changed to searchresult	
				String expectedurl2 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String actualurl2= driver.getCurrentUrl();
				Assert.assertEquals(actualurl2,expectedurl2);
				Thread.sleep(5000);
			//Identifying the number of rows having <tr> tag
				
				WebElement ToGetrows = driver.findElement(By.xpath("//table[@id='tblCallDetail']/tbody/tr"));

				List<WebElement> TotalRowsList = ToGetrows.findElements(By.tagName("tr"));
			//Total rows -2 because the table includes header and footer so we need to exclude them
				int totalCalls= TotalRowsList.size()-2;
			//Now convert the integer value to String
				String s=Integer.toString(totalCalls);
				System.out.println("Total Number of Rows found in the table are: "+totalCalls);
				Thread.sleep(2000);
			//Match the count and search result which should be same
				Assert.assertEquals(s, currentresult);
				
		}	
		
		
		
		
		
		
		//Test ID 28-24
			//"1-Make some call.
			//2-Go to First Name area. Select ""Starts With"" from dropdown.
			//3-Do not enter any value in field.
			//4-Click on Count Results button.                                           
			//5-Click on search button"
				//Result: It must display error "Please enter value in field " 
				//Comment from developers: Those fields are not mandatory fields and can be left empty.
		//This test case will not be automated
		
		
		
		//Test ID 28-25
			//"1-Make some call.
			//2-Go to First Name area. Select ""Starts With"" from dropdown.
			//3-enter special characters and negative values in field
			//4-Click on Count Results button.                                           
			//5-Click on search button"
				//Result: it should not allow you to enter any of these value.

		@Test(priority=18)
		public void VerifySearchCallsWithFirstNameIncludingSpecChar() throws InterruptedException {
			System.out.println("VerifySearchCallsWithFirstNameIncludingSpecChar");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown1 = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day
				dropdown1.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFirstName")));
			//Click on First Name dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlFirstName")));
			//Select Start With criteria
				dropdown.selectByVisibleText("Starts with");
			//Enter !@$Ma as a first name starts
				driver.findElement(By.id("txtFirstName")).sendKeys("!@$Ma");
			//Click on Search button
				driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(5000);
			//Check the web page is changed to searchresult	
				String expectedurl2 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String actualurl2= driver.getCurrentUrl();
				Assert.assertEquals(actualurl2,expectedurl2);
				Thread.sleep(5000);
				
		}	
		
		
		
		
		

		
		
		//Test ID 28-26
			//"1-Make some call.
			//2-Go to First Name area. Select ""Ends With"" from dropdown.
			//3-Enter some ending alphabets of first name of agent whom you want to search.
			//4-Click on Count Results button.                                           
			//5-Click on search button"

		@Test(priority=19)
		public void VerifySearchCallsWithFirstNameEndsWith() throws InterruptedException {
			System.out.println("VerifySearchCallsWithFirstName");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown1 = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day
				dropdown1.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFirstName")));
			//Click on First Name dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlFirstName")));
			//Select Ends With criteria
				dropdown.selectByVisibleText("Ends with");
			//Enter rk as a first name starts
				driver.findElement(By.id("txtFirstName")).sendKeys("rk");
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			
			//Wait for the browser to respond
				WebDriverWait wait2 = new WebDriverWait(driver,30);
				WebElement btnMain2;
				btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
			//Verify the result is displayed
				String currentresult = driver.findElement(By.id("lblCountRecords")).getText();
				System.out.println("Current Result : "+currentresult);
			//Wait for the browser to respond
				WebDriverWait wait3 = new WebDriverWait(driver,30);
				WebElement btnMain3;
				btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
				String actualresult = driver.findElement(By.id("lblCountRecords")).getText();
				Assert.assertEquals(actualresult, currentresult);
				System.out.println("Expected Message : "+currentresult);
				System.out.println("Actual Message : " +actualresult);
				
			//Click on Search button
				driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(5000);
			//Check the web page is changed to searchresult	
				String expectedurl2 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String actualurl2= driver.getCurrentUrl();
				Assert.assertEquals(actualurl2,expectedurl2);
				Thread.sleep(5000);
			//Identifying the number of rows having <tr> tag
				
				WebElement ToGetrows = driver.findElement(By.xpath("//table[@id='tblCallDetail']/tbody/tr"));

				List<WebElement> TotalRowsList = ToGetrows.findElements(By.tagName("tr"));
			//Total rows -2 because the table includes header and footer so we need to exclude them
				int totalCalls= TotalRowsList.size()-2;
			//Now convert the integer value to String
				String s=Integer.toString(totalCalls);
				System.out.println("Total Number of Rows found in the table are: "+totalCalls);
				Thread.sleep(2000);
			//Match the count and search result which should be same
				Assert.assertEquals(s, currentresult);
				
		}	
		
		
		
		
		
		
		
		
		
		
		//Test ID 28-27
			//"1-Make some call.
			//2-Go to First Name area. Select ""Ends With"" from dropdown.
			//3-Do not enter any value in field.
			//4-Click on Count Results button.                                           
			//5-Click on search button"
				//Result:It must display error "Please enter value in field " 
				//Comment from developers: Those fields are not mandatory fields and can be left empty.
			//This test case will not be automated
		
		
		
		
		
		
		
		
		
		//Test ID 28-28
			//"1-Make some call.
			//2-Go to First Name area. Select ""Ends With"" from dropdown.
			//3-Enter special characters and negative values in field
			//4-Click on Count Results button.                                           
			//5-Click on search button"

		
		@Test(priority=20)
		public void VerifySearchCallsWithFirstNameEndsWithIncludingSpecChar() throws InterruptedException {
			System.out.println("VerifySearchCallsWithFirstNameEndsWithIncludingSpecChar");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown1 = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day
				dropdown1.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFirstName")));
			//Click on First Name dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlFirstName")));
			//Select Ends With criteria
				dropdown.selectByVisibleText("Ends with");
			//Enter !@$rk as a first name ends with
				driver.findElement(By.id("txtFirstName")).sendKeys("!@$rk");
			//Click on Search button
				driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(5000);
			//Check the web page is changed to searchresult	
				String expectedurl2 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String actualurl2= driver.getCurrentUrl();
				Assert.assertEquals(actualurl2,expectedurl2);
				Thread.sleep(5000);
				
		}	
		
		
		
		
		
		
		
		
		//Test ID 28-29
			//"1-Make some call.
			//2-Go to First Name area. Select ""Contains"" from dropdown.
			//3-Enter some alphabets containing  agent's first name whom you want to search.
			//4-Click on Count Results button.                                           
			//5-Click on search button"

		@Test(priority=21)
		public void VerifySearchCallsWithFirstNameContainsWith() throws InterruptedException {
			System.out.println("VerifySearchCallsWithFirstNameContainsWith");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown1 = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day
				dropdown1.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFirstName")));
			//Click on First Name dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlFirstName")));
			//Select Start With criteria
				dropdown.selectByVisibleText("Contains");
			//Enter rk as a first name Contains
				driver.findElement(By.id("txtFirstName")).sendKeys("rk");
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			
			//Wait for the browser to respond
				WebDriverWait wait2 = new WebDriverWait(driver,30);
				WebElement btnMain2;
				btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
			//Verify the result is displayed
				String currentresult = driver.findElement(By.id("lblCountRecords")).getText();
				System.out.println("Current Result : "+currentresult);
			//Wait for the browser to respond
				WebDriverWait wait3 = new WebDriverWait(driver,30);
				WebElement btnMain3;
				btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
				String actualresult = driver.findElement(By.id("lblCountRecords")).getText();
				Assert.assertEquals(actualresult, currentresult);
				System.out.println("Expected Message : "+currentresult);
				System.out.println("Actual Message : " +actualresult);
				
			//Click on Search button
				driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(5000);
			//Check the web page is changed to searchresult	
				String expectedurl2 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String actualurl2= driver.getCurrentUrl();
				Assert.assertEquals(actualurl2,expectedurl2);
				Thread.sleep(5000);
			//Identifying the number of rows having <tr> tag
				
				WebElement ToGetrows = driver.findElement(By.xpath("//table[@id='tblCallDetail']/tbody/tr"));

				List<WebElement> TotalRowsList = ToGetrows.findElements(By.tagName("tr"));
			//Total rows -2 because the table includes header and footer so we need to exclude them
				int totalCalls= TotalRowsList.size()-2;
			//Now convert the integer value to String
				String s=Integer.toString(totalCalls);
				System.out.println("Total Number of Rows found in the table are: "+totalCalls);
				Thread.sleep(2000);
			//Match the count and search result which should be same
				Assert.assertEquals(s, currentresult);
				
		}	
		
		
		
		
		
		
		
		//Test ID 28-30
			//"1-Make some call.
			//2-Go to First Name area. Select ""Contains"" from dropdown.
			//3-Do not enter any value in field.
			//4-Click on Count Results button.                                           
			//5-Click on search button"
				//Result:It must display error "Please enter value in field " 
				//Comment from developers: Those fields are not mandatory fields and can be left empty.
			//This test case will not be automated
		
		
		
		
		
		
		
		//Test ID 28-31
			//"1-Make some call.
			//2-Go to First Name area. Select ""Contains"" from dropdown.
			//3-Enter special characters and negative values in field
			//4-Click on Count Results button.                                           
			//5-Click on search button"

		@Test(priority=22)
		public void VerifySearchCallsWithFirstNameContainsSpecChar() throws InterruptedException {
			System.out.println("VerifySearchCallsWithFirstNameContainsSpecChar");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown1 = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day
				dropdown1.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFirstName")));
			//Click on First Name dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlFirstName")));
			//Select Contains With criteria
				dropdown.selectByVisibleText("Contains");
			//Enter !@$rk as a first name Contains
				driver.findElement(By.id("txtFirstName")).sendKeys("!@$rk");
			//Click on Search button
				driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(5000);
			//Check the web page is changed to searchresult	
				String expectedurl2 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String actualurl2= driver.getCurrentUrl();
				Assert.assertEquals(actualurl2,expectedurl2);
				Thread.sleep(5000);
				
		}

		
		
		
		
		
		
		
		//Test ID 28-32
			//"1-Make some call.
			//2-Go to First Name area. Select ""Is Exactly"" from dropdown.
			//3-Enter exactly first name of agent
			//4-Click on Count Results button.                                           
			//5-Click on search button"
		@Test(priority=23)
		public void VerifySearchCallsWithFirstNameExactlyCriteria() throws InterruptedException {
			System.out.println("VerifySearchCallsWithFirstNameExactlyCriteria");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown1 = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day
				dropdown1.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFirstName")));
			//Click on First Name dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlFirstName")));
			//Select Start With criteria
				dropdown.selectByVisibleText("Is exactly");
			//Enter Mark as a first name exacly
				driver.findElement(By.id("txtFirstName")).sendKeys("Mark");
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			
			//Wait for the browser to respond
				WebDriverWait wait2 = new WebDriverWait(driver,30);
				WebElement btnMain2;
				btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
			//Verify the result is displayed
				String currentresult = driver.findElement(By.id("lblCountRecords")).getText();
				System.out.println("Current Result : "+currentresult);
			//Wait for the browser to respond
				WebDriverWait wait3 = new WebDriverWait(driver,30);
				WebElement btnMain3;
				btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
				String actualresult = driver.findElement(By.id("lblCountRecords")).getText();
				Assert.assertEquals(actualresult, currentresult);
				System.out.println("Expected Message : "+currentresult);
				System.out.println("Actual Message : " +actualresult);
				
			//Click on Search button
				driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(5000);
			//Check the web page is changed to searchresult	
				String expectedurl2 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String actualurl2= driver.getCurrentUrl();
				Assert.assertEquals(actualurl2,expectedurl2);
				Thread.sleep(5000);
			//Identifying the number of rows having <tr> tag
				
				WebElement ToGetrows = driver.findElement(By.xpath("//table[@id='tblCallDetail']/tbody/tr"));

				List<WebElement> TotalRowsList = ToGetrows.findElements(By.tagName("tr"));
			//Total rows -2 because the table includes header and footer so we need to exclude them
				int totalCalls= TotalRowsList.size()-2;
			//Now convert the integer value to String
				String s=Integer.toString(totalCalls);
				System.out.println("Total Number of Rows found in the table are: "+totalCalls);
				Thread.sleep(2000);
			//Match the count and search result which should be same
				Assert.assertEquals(s, currentresult);
				
		}	
		
		
		
		
		
		
		
		
		
		
		//Test Id 28-33
			//"1-Make some call.
			//2-Go to First Name area. Select ""Is Exactly"" from dropdown.
			//3-Do not enter any value in field.
			//4-Click on Count Results button.                                           
			//5-Click on search button"
				//Result:It must display error "Please enter value in field " 
				//Comment from developers: Those fields are not mandatory fields and can be left empty.
				//This test case will not be automated
		
		
		
		
		
		
		//Test ID 28-34
			//"1-Make some call.
			//2-Go to First Name area. Select ""Is Exactly"" from dropdown.
			//3-Enter special characters and negative values in field
			//4-Click on Count Results button.                                           
			//5-Click on search button"
		@Test(priority=24)
		public void VerifySearchCallsWithFirstNameExactlyWithSpecChar() throws InterruptedException {
			System.out.println("VerifySearchCallsWithFirstNameExactlyWithSpecChar");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown1 = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day
				dropdown1.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFirstName")));
			//Click on First Name dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlFirstName")));
			//Select Is exactly criteria
				dropdown.selectByVisibleText("Is exactly");
			//Enter !@$rk as a first name Contains
				driver.findElement(By.id("txtFirstName")).sendKeys("!@$rk");
			//Click on Search button
				driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(5000);
			//Check the web page is changed to searchresult	
				String expectedurl2 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String actualurl2= driver.getCurrentUrl();
				Assert.assertEquals(actualurl2,expectedurl2);
				Thread.sleep(5000);
				
		}
			
		
		
		
		
		
		
		
		
		//Test ID 28-35
			//"1-Make some call.
			//2-Go to First Name area. Select ""Not Starts With"" from dropdown.
			//3-Enter those alphabets which does not starts with agents first name.
			//4-Click on Count Results button.                                           
			//5-Click on search button"
				//Result:"In this case calls count should be displayed and only those calls should be shown which are recorded by the agent whose first  name does not start with alphabets you entered in field.
				//Notify: Number of calls count and calls in search should be the same. "

		@Test(priority=25)
		public void VerifySearchCallsWithFirstNameNotStartsWith() throws InterruptedException {
			System.out.println("VerifySearchCallsWithFirstNameNotStartsWith");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day
				dropdown.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFirstName")));
			//Click on First Name dropdown
				Select dropdown1 = new Select(driver.findElement(By.id("ddlFirstName")));
			//Select Not starts With criteria
				dropdown1.selectByVisibleText("Not starts with");
			//Enter Mark as a first name exacly
				driver.findElement(By.id("txtFirstName")).sendKeys("agen");
			//Click on Results Per Page dropdown
				Select dropdown2 = new Select(driver.findElement(By.id("ddlPageSize")));
			//Select 20
				dropdown2.selectByVisibleText("20");
				
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			
			//Wait for the browser to respond
				WebDriverWait wait2 = new WebDriverWait(driver,30);
				WebElement btnMain2;
				btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
			//Verify the result is displayed
				String currentresult = driver.findElement(By.id("lblCountRecords")).getText();
				System.out.println("Current Result : "+currentresult);
			//Wait for the browser to respond
				WebDriverWait wait3 = new WebDriverWait(driver,30);
				WebElement btnMain3;
				btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
				String actualresult = driver.findElement(By.id("lblCountRecords")).getText();
				Assert.assertEquals(actualresult, currentresult);
				System.out.println("Expected Message : "+currentresult);
				System.out.println("Actual Message : " +actualresult);
				
			//Click on Search button
				driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(5000);
			//Check the web page is changed to searchresult	
				String expectedurl2 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String actualurl2= driver.getCurrentUrl();
				Assert.assertEquals(actualurl2,expectedurl2);
				Thread.sleep(5000);
			//Identifying the number of rows having <tr> tag
				
				WebElement ToGetrows = driver.findElement(By.xpath("//table[@id='tblCallDetail']/tbody/tr"));

				List<WebElement> TotalRowsList = ToGetrows.findElements(By.tagName("tr"));
			//Total rows -2 because the table includes header and footer so we need to exclude them
				int totalCalls= TotalRowsList.size()-2;
			//Now convert the integer value to String
				String s=Integer.toString(totalCalls);
				System.out.println("Total Number of Rows found in the table are: "+totalCalls);
				Thread.sleep(2000);
			//Match the count and search result which should be same
				Assert.assertEquals(s, currentresult);
				
		}	
		
		
		
		
		
		
		
		
		//Test ID 28-36
			//"1-Make some call.
			//2-Go to First Name area. Select ""Not Starts With"" from dropdown.
			//3-Do not enter any value in field.
			//4-Click on Count Results button.                                           
			//5-Click on search button"
				//Result:It must display error "Please enter value in field " 
				//Comment from developers: Those fields are not mandatory fields and can be left empty.
			//This test case will not be automated
		
		
		
		
		
		
		
		
		//Test ID 28-37
			//"1-Make some call.
			//2-Go to First Name area. Select ""Not Starts With"" from dropdown.
			//3-Enter special characters and negative values in field
			//4-Click on Count Results button.                                           
			//5-Click on search button"
		@Test(priority=26)
		public void VerifySearchCallsWithFirstNameNotStartsWithSpecChar() throws InterruptedException {
			System.out.println("VerifySearchCallsWithFirstNameNotStartsWithSpecChar");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown1 = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day
				dropdown1.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFirstName")));
			//Click on First Name dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlFirstName")));
			//Select Not starts with criteria
				dropdown.selectByVisibleText("Not starts with");
			//Enter !@$rk as a first name Not starts with
				driver.findElement(By.id("txtFirstName")).sendKeys("!@$rk");
			//Click on Search button
				driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(5000);
			//Check the web page is changed to searchresult	
				String expectedurl2 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String actualurl2= driver.getCurrentUrl();
				Assert.assertEquals(actualurl2,expectedurl2);
				Thread.sleep(5000);
				
		}
		
		
		
		
		
		
		
		
		
		
		//Test ID 28-38
			//"1-Make some call.
			//2-Go to First Name area. Select ""Not Ends With"" from dropdown.
			//3-Enter those alphabets which does not Ends with agents first name.
			//4-Click on Count Results button.                                           
			//5-Click on search button"
				//Result:"In this case calls count should be displayed and only those calls should be shown which are recorded by the agent whose first name does not Ends with alphabets you entered in field.
				//Notify: Number of calls count and calls in search should be the same. "
		@Test(priority=27)
		public void VerifySearchCallsWithFirstNameNotEndsWith() throws InterruptedException {
			System.out.println("VerifySearchCallsWithFirstNameNotEndsWith");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day
				dropdown.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFirstName")));
			//Click on First Name dropdown
				Select dropdown1 = new Select(driver.findElement(By.id("ddlFirstName")));
			//Select Not ends With criteria
				dropdown1.selectByVisibleText("Not ends with");
			//Enter ent as a first name exacly
				driver.findElement(By.id("txtFirstName")).sendKeys("ent");
			//Click on Results Per Page dropdown
				Select dropdown2 = new Select(driver.findElement(By.id("ddlPageSize")));
			//Select 20
				dropdown2.selectByVisibleText("20");
				
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			
			//Wait for the browser to respond
				WebDriverWait wait2 = new WebDriverWait(driver,30);
				WebElement btnMain2;
				btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
			//Verify the result is displayed
				String currentresult = driver.findElement(By.id("lblCountRecords")).getText();
				System.out.println("Current Result : "+currentresult);
			//Wait for the browser to respond
				WebDriverWait wait3 = new WebDriverWait(driver,30);
				WebElement btnMain3;
				btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
				String actualresult = driver.findElement(By.id("lblCountRecords")).getText();
				Assert.assertEquals(actualresult, currentresult);
				System.out.println("Expected Message : "+currentresult);
				System.out.println("Actual Message : " +actualresult);
				
			//Click on Search button
				driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(5000);
			//Check the web page is changed to searchresult	
				String expectedurl2 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String actualurl2= driver.getCurrentUrl();
				Assert.assertEquals(actualurl2,expectedurl2);
				Thread.sleep(5000);
			//Identifying the number of rows having <tr> tag
				
				WebElement ToGetrows = driver.findElement(By.xpath("//table[@id='tblCallDetail']/tbody/tr"));

				List<WebElement> TotalRowsList = ToGetrows.findElements(By.tagName("tr"));
			//Total rows -2 because the table includes header and footer so we need to exclude them
				int totalCalls= TotalRowsList.size()-2;
			//Now convert the integer value to String
				String s=Integer.toString(totalCalls);
				System.out.println("Total Number of Rows found in the table are: "+totalCalls);
				Thread.sleep(2000);
			//Match the count and search result which should be same
				Assert.assertEquals(s, currentresult);
				
		}	
		
		
		
		
		
		
		
		
		
		
		//Test ID 28-39
			//"1-Make some call.
			//2-Go to First Name area. Select ""Not Ends With"" from dropdown.
			//3-Do not enter any value in field.
			//4-Click on Count Results button.                                           
			//5-Click on search button"
				//Result:It must display error "Please enter value in field " 
				//Comment from developers: Those fields are not mandatory fields and can be left empty.
			//This test case will not be automated
		
		
		
		
		
		
		
		
		
		
		//Test ID 28-40
			//"1-Make some call.
			//2-Go to First Name area. Select ""Not Ends With"" from dropdown.
			//3-Enter special characters and negative values in field
			//4-Click on Count Results button.                                           
			//5-Click on search button"
		@Test(priority=28)
		public void VerifySearchCallsWithFirstNameNotEndsWithSpecChar() throws InterruptedException {
			System.out.println("VerifySearchCallsWithFirstNameNotEndsWithSpecChar");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown1 = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day
				dropdown1.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFirstName")));
			//Click on First Name dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlFirstName")));
			//Select Not Ends with criteria
				dropdown.selectByVisibleText("Not ends with");
			//Enter !@$rk as a first name Not starts with
				driver.findElement(By.id("txtFirstName")).sendKeys("!@$rk");
			//Click on Search button
				driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(5000);
			//Check the web page is changed to searchresult	
				String expectedurl2 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String actualurl2= driver.getCurrentUrl();
				Assert.assertEquals(actualurl2,expectedurl2);
				Thread.sleep(5000);
				
		}
		
		
		
		
		
		
		
		
		
		//Test ID 28-41
			//"1-Make some call.
			//2-Go to First Name area. Select ""Not Contains"" from dropdown.
			//3-Enter those alphabets which does not contains agents first name.
			//4-Click on Count Results button.                                           
			//5-Click on search button"
		@Test(priority=29)
		public void VerifySearchCallsWithFirstNameNotContains() throws InterruptedException {
			System.out.println("VerifySearchCallsWithFirstNameNotContains");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day
				dropdown.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFirstName")));
			//Click on First Name dropdown
				Select dropdown1 = new Select(driver.findElement(By.id("ddlFirstName")));
			//Select Not contains criteria
				dropdown1.selectByVisibleText("Not contains");
			//Enter ent as a first name not contains
				driver.findElement(By.id("txtFirstName")).sendKeys("ent");
			//Click on Results Per Page dropdown
				Select dropdown2 = new Select(driver.findElement(By.id("ddlPageSize")));
			//Select 20
				dropdown2.selectByVisibleText("20");
				
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			
			//Wait for the browser to respond
				WebDriverWait wait2 = new WebDriverWait(driver,30);
				WebElement btnMain2;
				btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
			//Verify the result is displayed
				String currentresult = driver.findElement(By.id("lblCountRecords")).getText();
				System.out.println("Current Result : "+currentresult);
			//Wait for the browser to respond
				WebDriverWait wait3 = new WebDriverWait(driver,30);
				WebElement btnMain3;
				btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
				String actualresult = driver.findElement(By.id("lblCountRecords")).getText();
				Assert.assertEquals(actualresult, currentresult);
				System.out.println("Expected Message : "+currentresult);
				System.out.println("Actual Message : " +actualresult);
				
			//Click on Search button
				driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(5000);
			//Check the web page is changed to searchresult	
				String expectedurl2 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String actualurl2= driver.getCurrentUrl();
				Assert.assertEquals(actualurl2,expectedurl2);
				Thread.sleep(5000);
			//Identifying the number of rows having <tr> tag
				
				WebElement ToGetrows = driver.findElement(By.xpath("//table[@id='tblCallDetail']/tbody/tr"));

				List<WebElement> TotalRowsList = ToGetrows.findElements(By.tagName("tr"));
			//Total rows -2 because the table includes header and footer so we need to exclude them
				int totalCalls= TotalRowsList.size()-2;
			//Now convert the integer value to String
				String s=Integer.toString(totalCalls);
				System.out.println("Total Number of Rows found in the table are: "+totalCalls);
				Thread.sleep(2000);
			//Match the count and search result which should be same
				Assert.assertEquals(s, currentresult);
				
		}	
		
		
		
		
		
		
		
		
		
		
		
		//Test ID 28-42
			//"1-Make some call.
			//2-Go to First Name area. Select ""Not Contains"" from dropdown.
			//3-Do not enter any value in field.
			//4-Click on Count Results button.                                           
			//5-Click on search button"
				//Result:It must display error "Please enter value in field " 
				//Comment from developers: Those fields are not mandatory fields and can be left empty.
			//This test case will not be automated
		
		
		
		
		
		
		
		
		
		
		
		
		//Test ID 28-43
			//"1-Make some call.
			//2-Go to First Name area. Select ""Not Contains"" from dropdown.
			//3-Enter special characters and negative values in field
			//4-Click on Count Results button.                                           
			//5-Click on search button"
		@Test(priority=30)
		public void VerifySearchCallsWithFirstNameNotContainsSpecChar() throws InterruptedException {
			System.out.println("VerifySearchCallsWithFirstNameNotContainsSpecChar");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown1 = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day
				dropdown1.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFirstName")));
			//Click on First Name dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlFirstName")));
			//Select Not contains criteria
				dropdown.selectByVisibleText("Not contains");
			//Enter !@$rk as a first name Not contains with
				driver.findElement(By.id("txtFirstName")).sendKeys("!@$rk");
				//Click on Results Per Page dropdown
				Select dropdown2 = new Select(driver.findElement(By.id("ddlPageSize")));
			//Select 20
				dropdown2.selectByVisibleText("20");
				
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			
			//Wait for the browser to respond
				WebDriverWait wait2 = new WebDriverWait(driver,30);
				WebElement btnMain2;
				btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
			//Verify the result is displayed
				String currentresult = driver.findElement(By.id("lblCountRecords")).getText();
				System.out.println("Current Result : "+currentresult);
			//Wait for the browser to respond
				WebDriverWait wait3 = new WebDriverWait(driver,30);
				WebElement btnMain3;
				btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
				String actualresult = driver.findElement(By.id("lblCountRecords")).getText();
				Assert.assertEquals(actualresult, currentresult);
				System.out.println("Expected Message : "+currentresult);
				System.out.println("Actual Message : " +actualresult);
				
			//Click on Search button
				driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(5000);
			//Check the web page is changed to searchresult	
				String expectedurl2 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String actualurl2= driver.getCurrentUrl();
				Assert.assertEquals(actualurl2,expectedurl2);
				Thread.sleep(5000);
			//Identifying the number of rows having <tr> tag
				
				WebElement ToGetrows = driver.findElement(By.xpath("//table[@id='tblCallDetail']/tbody/tr"));

				List<WebElement> TotalRowsList = ToGetrows.findElements(By.tagName("tr"));
			//Total rows -2 because the table includes header and footer so we need to exclude them
				int totalCalls= TotalRowsList.size()-2;
			//Now convert the integer value to String
				String s=Integer.toString(totalCalls);
				System.out.println("Total Number of Rows found in the table are: "+totalCalls);
				Thread.sleep(2000);
			//Match the count and search result which should be same
				Assert.assertEquals(s, currentresult);
				
		}
		
		
		
		
		
		
		
		//Test ID 28-44
			//"1-Make some call.
			//2-Go to First Name area. Select ""Not Exactly"" from dropdown.
			//3-Enter first name of agent whom you not exactly want to search
			//4-Click on Count Results button.                                           
			//5-Click on search button"
		@Test(priority=31)
		public void VerifySearchCallsWithFirstNameNotExactly() throws InterruptedException {
			System.out.println("VerifySearchCallsWithFirstNameNotExactly");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day
				dropdown.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFirstName")));
			//Click on First Name dropdown
				Select dropdown1 = new Select(driver.findElement(By.id("ddlFirstName")));
			//Select Not exactly criteria
				dropdown1.selectByVisibleText("Not exactly");
			//Enter Agent as a first name not exactly
				driver.findElement(By.id("txtFirstName")).sendKeys("Agent");
			//Click on Results Per Page dropdown
				Select dropdown2 = new Select(driver.findElement(By.id("ddlPageSize")));
			//Select 20
				dropdown2.selectByVisibleText("20");
				
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			
			//Wait for the browser to respond
				WebDriverWait wait2 = new WebDriverWait(driver,30);
				WebElement btnMain2;
				btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
			//Verify the result is displayed
				String currentresult = driver.findElement(By.id("lblCountRecords")).getText();
				System.out.println("Current Result : "+currentresult);
			//Wait for the browser to respond
				WebDriverWait wait3 = new WebDriverWait(driver,30);
				WebElement btnMain3;
				btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
				String actualresult = driver.findElement(By.id("lblCountRecords")).getText();
				Assert.assertEquals(actualresult, currentresult);
				System.out.println("Expected Message : "+currentresult);
				System.out.println("Actual Message : " +actualresult);
				
			//Click on Search button
				driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(5000);
			//Check the web page is changed to searchresult	
				String expectedurl2 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String actualurl2= driver.getCurrentUrl();
				Assert.assertEquals(actualurl2,expectedurl2);
				Thread.sleep(5000);
			//Identifying the number of rows having <tr> tag
				
				WebElement ToGetrows = driver.findElement(By.xpath("//table[@id='tblCallDetail']/tbody/tr"));

				List<WebElement> TotalRowsList = ToGetrows.findElements(By.tagName("tr"));
			//Total rows -2 because the table includes header and footer so we need to exclude them
				int totalCalls= TotalRowsList.size()-2;
			//Now convert the integer value to String
				String s=Integer.toString(totalCalls);
				System.out.println("Total Number of Rows found in the table are: "+totalCalls);
				Thread.sleep(2000);
			//Match the count and search result which should be same
				Assert.assertEquals(s, currentresult);
				
		}	
		
		
		
		
		
		
		
		
		
		
		
		
		//Test ID 28-45
			//"1-Make some call.
			//2-Go to First Name area. Select ""Not Exactly"" from dropdown.
			//3-Do not enter any value in field.
			//4-Click on Count Results button.                                           
			//5-Click on search button"
				//Result:It must display error "Please enter value in field " 
				//Comment from developers: Those fields are not mandatory fields and can be left empty.
			//This test case will not be automated
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Test ID 28-46
			//"1-Make some call.
			//2-Go to First Name area. Select ""Not Exactly"" from dropdown.
			//3-Enter special characters and negative values in field
			//4-Click on Count Results button.                                           
			//5-Click on search button"
		@Test(priority=32)
		public void VerifySearchCallsWithFirstNameNotExactlySpecChar() throws InterruptedException {
			System.out.println("VerifySearchCallsWithFirstNameNotExactlySpecChar");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown1 = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day
				dropdown1.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFirstName")));
			//Click on First Name dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlFirstName")));
			//Select Not exactly criteria
				dropdown.selectByVisibleText("Not exactly");
			//Enter !@$rk as a first name Not exactly
				driver.findElement(By.id("txtFirstName")).sendKeys("!@$rk");
			//Click on Results Per Page dropdown
				Select dropdown2 = new Select(driver.findElement(By.id("ddlPageSize")));
			//Select 20
				dropdown2.selectByVisibleText("20");
				
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			
			//Wait for the browser to respond
				WebDriverWait wait2 = new WebDriverWait(driver,30);
				WebElement btnMain2;
				btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
			//Verify the result is displayed
				String currentresult = driver.findElement(By.id("lblCountRecords")).getText();
				System.out.println("Current Result : "+currentresult);
			//Wait for the browser to respond
				WebDriverWait wait3 = new WebDriverWait(driver,30);
				WebElement btnMain3;
				btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
				String actualresult = driver.findElement(By.id("lblCountRecords")).getText();
				Assert.assertEquals(actualresult, currentresult);
				System.out.println("Expected Message : "+currentresult);
				System.out.println("Actual Message : " +actualresult);
				
			//Click on Search button
				driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(5000);
			//Check the web page is changed to searchresult	
				String expectedurl2 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String actualurl2= driver.getCurrentUrl();
				Assert.assertEquals(actualurl2,expectedurl2);
				Thread.sleep(5000);
			//Identifying the number of rows having <tr> tag
				
				WebElement ToGetrows = driver.findElement(By.xpath("//table[@id='tblCallDetail']/tbody/tr"));

				List<WebElement> TotalRowsList = ToGetrows.findElements(By.tagName("tr"));
			//Total rows -2 because the table includes header and footer so we need to exclude them
				int totalCalls= TotalRowsList.size()-2;
			//Now convert the integer value to String
				String s=Integer.toString(totalCalls);
				System.out.println("Total Number of Rows found in the table are: "+totalCalls);
				Thread.sleep(2000);
			//Match the count and search result which should be same
				Assert.assertEquals(s, currentresult);
				
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Test ID 28-47
			//"1-Make some call.
			//2-Go to Last Name area. Select ""Starts With"" from dropdown.
			//3-Enter some starting alphabets of last name of agent whom you want to search.
			//4-Click on Count Results button.                                           
			//5-Click on search button"
		@Test(priority=33)
		public void VerifySearchCallsWithLastNameStartsWith() throws InterruptedException {
			System.out.println("VerifySearchCallsWithLastNameStartsWith");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown1 = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day
				dropdown1.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFirstName")));
			//Click on Last Name dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlLastName")));
			//Select Start With criteria
				dropdown.selectByVisibleText("Starts with");
			//Enter Zuc as a Last name starts
				driver.findElement(By.id("txtLastName")).sendKeys("Zuc");
			//Click on Results Per Page dropdown
				Select dropdown2 = new Select(driver.findElement(By.id("ddlPageSize")));
			//Select 20
				dropdown2.selectByVisibleText("20");
				
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			
			//Wait for the browser to respond
				WebDriverWait wait2 = new WebDriverWait(driver,30);
				WebElement btnMain2;
				btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
			//Verify the result is displayed
				String currentresult = driver.findElement(By.id("lblCountRecords")).getText();
				System.out.println("Current Result : "+currentresult);
			//Wait for the browser to respond
				WebDriverWait wait3 = new WebDriverWait(driver,30);
				WebElement btnMain3;
				btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
				String actualresult = driver.findElement(By.id("lblCountRecords")).getText();
				Assert.assertEquals(actualresult, currentresult);
				System.out.println("Expected Message : "+currentresult);
				System.out.println("Actual Message : " +actualresult);
				
			//Click on Search button
				driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(5000);
			//Check the web page is changed to searchresult	
				String expectedurl2 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String actualurl2= driver.getCurrentUrl();
				Assert.assertEquals(actualurl2,expectedurl2);
				Thread.sleep(5000);
			//Identifying the number of rows having <tr> tag
				
				WebElement ToGetrows = driver.findElement(By.xpath("//table[@id='tblCallDetail']/tbody/tr"));

				List<WebElement> TotalRowsList = ToGetrows.findElements(By.tagName("tr"));
			//Total rows -2 because the table includes header and footer so we need to exclude them
				int totalCalls= TotalRowsList.size()-2;
			//Now convert the integer value to String
				String s=Integer.toString(totalCalls);
				System.out.println("Total Number of Rows found in the table are: "+totalCalls);
				Thread.sleep(2000);
			//Match the count and search result which should be same
				Assert.assertEquals(s, currentresult);
				
		}	
		
		
		
		
		
		
		
		
		
		
		
		
		//Test ID 28-48
			//"1-Make some call.
			//2-Go to Last Name area. Select ""Starts With"" from dropdown.
			//3-Do not enter any value in field.
			//4-Click on Count Results button.                                           
			//5-Click on search button"
					//Result:It must display error "Please enter value in field "  
					//Comment from developers: Those fields are not mandatory fields and can be left empty.
				//This test case will not be automated
		
		
		
		
		
		
		
		
		
		
		
		
		//Test ID 28-49
			//"1-Make some call.
			//2-Go to Last Name area. Select ""Starts With"" from dropdown.
			//3-enter special characters and negative values in field
			//4-Click on Count Results button.                                           
			//5-Click on search button"
		@Test(priority=34)
		public void VerifySearchCallsWithLastNameStartsWithSpecChar() throws InterruptedException {
			System.out.println("VerifySearchCallsWithLastNameStartsWithSpecChar");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown1 = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day
				dropdown1.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFirstName")));
			//Click on Last Name dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlLastName")));
			//Select Start With criteria
				dropdown.selectByVisibleText("Starts with");
			//Enter @#$Zuc as a Last name starts
				driver.findElement(By.id("txtLastName")).sendKeys("@#$Zuc");
			//Click on Results Per Page dropdown
				Select dropdown2 = new Select(driver.findElement(By.id("ddlPageSize")));
			//Select 20
				dropdown2.selectByVisibleText("20");
							
			//Click on Search button
				driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(5000);
			Thread.sleep(5000);
			//Check the web page is changed to searchresult	
				String expectedurl2 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String actualurl2= driver.getCurrentUrl();
				Assert.assertEquals(actualurl2,expectedurl2);
				Thread.sleep(5000);			
		}	
		
		
		
		
		
		
		
		
		
		
		
		
		//Test ID 28-50
			//"1-Make some call.
			//2-Go to Last Name area. Select ""Ends With"" from dropdown.
			//3-Enter some ending alphabets of Last Name of agent whom you want to search.
			//4-Click on Count Results button.                                           
			//5-Click on search button"
		@Test(priority=35)
		public void VerifySearchCallsWithLastNameEndsWith() throws InterruptedException {
			System.out.println("VerifySearchCallsWithLastNameEndsWith");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown1 = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day
				dropdown1.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFirstName")));
			//Click on Last Name dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlLastName")));
			//Select Ends With criteria
				dropdown.selectByVisibleText("Ends with");
			//Enter erg as a Last name ends
				driver.findElement(By.id("txtLastName")).sendKeys("erg");
			//Click on Results Per Page dropdown
				Select dropdown2 = new Select(driver.findElement(By.id("ddlPageSize")));
			//Select 20
				dropdown2.selectByVisibleText("20");
				
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			
			//Wait for the browser to respond
				WebDriverWait wait2 = new WebDriverWait(driver,30);
				WebElement btnMain2;
				btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
			//Verify the result is displayed
				String currentresult = driver.findElement(By.id("lblCountRecords")).getText();
				System.out.println("Current Result : "+currentresult);
			//Wait for the browser to respond
				WebDriverWait wait3 = new WebDriverWait(driver,30);
				WebElement btnMain3;
				btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
				String actualresult = driver.findElement(By.id("lblCountRecords")).getText();
				Assert.assertEquals(actualresult, currentresult);
				System.out.println("Expected Message : "+currentresult);
				System.out.println("Actual Message : " +actualresult);
				
			//Click on Search button
				driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(5000);
			//Check the web page is changed to searchresult	
				String expectedurl2 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String actualurl2= driver.getCurrentUrl();
				Assert.assertEquals(actualurl2,expectedurl2);
				Thread.sleep(5000);
			//Identifying the number of rows having <tr> tag
				
				WebElement ToGetrows = driver.findElement(By.xpath("//table[@id='tblCallDetail']/tbody/tr"));

				List<WebElement> TotalRowsList = ToGetrows.findElements(By.tagName("tr"));
			//Total rows -2 because the table includes header and footer so we need to exclude them
				int totalCalls= TotalRowsList.size()-2;
			//Now convert the integer value to String
				String s=Integer.toString(totalCalls);
				System.out.println("Total Number of Rows found in the table are: "+totalCalls);
				Thread.sleep(2000);
			//Match the count and search result which should be same
				Assert.assertEquals(s, currentresult);
				
		}	
		
		
		
		
		
		
		
		
		
		
		//Test ID 28-51
			//"1-Make some call.
			//2-Go to Last Name area. Select ""Ends With"" from dropdown.
			//3-Do not enter any value in field.
			//4-Click on Count Results button.                                           
			//5-Click on search button"
						//Result:It must display error "Please enter value in field "   
						//Comment from developers: Those fields are not mandatory fields and can be left empty.
					//This test case will not be automated
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Test ID 28-52
			//"1-Make some call.
			//2-Go to Last Name area. Select ""Ends With"" from dropdown.
			//3-Enter special characters and negative values in field
			//4-Click on Count Results button.                                           
			//5-Click on search button"
		@Test(priority=36)
		public void VerifySearchCallsWithLastNameEndsWithSpecChar() throws InterruptedException {
			System.out.println("VerifySearchCallsWithLastNameEndsWithSpecChar");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown1 = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day
				dropdown1.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFirstName")));
			//Click on Last Name dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlLastName")));
			//Select Ends with With criteria
				dropdown.selectByVisibleText("Ends with");
			//Enter @#$erg as a Last name ends
				driver.findElement(By.id("txtLastName")).sendKeys("@#$erg");
			//Click on Results Per Page dropdown
				Select dropdown2 = new Select(driver.findElement(By.id("ddlPageSize")));
			//Select 20
				dropdown2.selectByVisibleText("20");
							
			//Click on Search button
				driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(5000);
			Thread.sleep(5000);
			//Check the web page is changed to searchresult	
				String expectedurl2 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String actualurl2= driver.getCurrentUrl();
				Assert.assertEquals(actualurl2,expectedurl2);
				Thread.sleep(5000);			
		}	
		
		
		
		
		
		
		
		
		
		
		
		
		//Test ID 28-53
			//"1-Make some call.
			//2-Go to Last Name area. Select ""Contains"" from dropdown.
			//3-Enter some alphabets containing  agent's last name whom you want to search.
			//4-Click on Count Results button.                                           
			//5-Click on search button"
		@Test(priority=37)
		public void VerifySearchCallsWithLastNameContains() throws InterruptedException {
			System.out.println("VerifySearchCallsWithLastNameContains");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown1 = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day
				dropdown1.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFirstName")));
			//Click on Last Name dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlLastName")));
			//Select Contains criteria
				dropdown.selectByVisibleText("Contains");
			//Enter erg as a Last name contains
				driver.findElement(By.id("txtLastName")).sendKeys("erg");
			//Click on Results Per Page dropdown
				Select dropdown2 = new Select(driver.findElement(By.id("ddlPageSize")));
			//Select 20
				dropdown2.selectByVisibleText("20");
				
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			
			//Wait for the browser to respond
				WebDriverWait wait2 = new WebDriverWait(driver,30);
				WebElement btnMain2;
				btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
			//Verify the result is displayed
				String currentresult = driver.findElement(By.id("lblCountRecords")).getText();
				System.out.println("Current Result : "+currentresult);
			//Wait for the browser to respond
				WebDriverWait wait3 = new WebDriverWait(driver,30);
				WebElement btnMain3;
				btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
				String actualresult = driver.findElement(By.id("lblCountRecords")).getText();
				Assert.assertEquals(actualresult, currentresult);
				System.out.println("Expected Message : "+currentresult);
				System.out.println("Actual Message : " +actualresult);
				
			//Click on Search button
				driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(5000);
			//Check the web page is changed to searchresult	
				String expectedurl2 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String actualurl2= driver.getCurrentUrl();
				Assert.assertEquals(actualurl2,expectedurl2);
				Thread.sleep(5000);
			//Identifying the number of rows having <tr> tag
				
				WebElement ToGetrows = driver.findElement(By.xpath("//table[@id='tblCallDetail']/tbody/tr"));

				List<WebElement> TotalRowsList = ToGetrows.findElements(By.tagName("tr"));
			//Total rows -2 because the table includes header and footer so we need to exclude them
				int totalCalls= TotalRowsList.size()-2;
			//Now convert the integer value to String
				String s=Integer.toString(totalCalls);
				System.out.println("Total Number of Rows found in the table are: "+totalCalls);
				Thread.sleep(2000);
			//Match the count and search result which should be same
				Assert.assertEquals(s, currentresult);
				
		}	
		
		
		
		
		
		
		
		
		
		
		
		//Test ID 28-54
			//"1-Make some call.
			//2-Go to Last Name area. Select ""Contains"" from dropdown.
			//3-Do not enter any value in field.
			//4-Click on Count Results button.                                           
			//5-Click on search button"
						//Result:It must display error "Please enter value in field "   
						//Comment from developers: Those fields are not mandatory fields and can be left empty.
					//This test case will not be automated
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Test ID 28-55
			//"1-Make some call.
			//2-Go to Last Name area. Select ""Contains"" from dropdown.
			//3-Enter special characters and negative values in field
			//4-Click on Count Results button.                                           
			//5-Click on search button"
		@Test(priority=38)
		public void VerifySearchCallsWithLastNameContainsSpecChar() throws InterruptedException {
			System.out.println("VerifySearchCallsWithLastNameContainsSpecChar");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown1 = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day
				dropdown1.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFirstName")));
			//Click on Last Name dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlLastName")));
			//Select Contains criteria
				dropdown.selectByVisibleText("Contains");
			//Enter @#$erg as a Last name contains
				driver.findElement(By.id("txtLastName")).sendKeys("@#$erg");
			//Click on Results Per Page dropdown
				Select dropdown2 = new Select(driver.findElement(By.id("ddlPageSize")));
			//Select 20
				dropdown2.selectByVisibleText("20");
							
			//Click on Search button
				driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(5000);
			Thread.sleep(5000);
			//Check the web page is changed to searchresult	
				String expectedurl2 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String actualurl2= driver.getCurrentUrl();
				Assert.assertEquals(actualurl2,expectedurl2);
				Thread.sleep(5000);			
		}	

		
		
		
		
		
		
		
		
		
		
		//Test ID 28-56
			//"1-Make some call.
			//2-Go to Last Name area. Select ""Is Exactly"" from dropdown.
			//3-Enter exactly Last Name of agent
			//4-Click on Count Results button.                                           
			//5-Click on search button"
		@Test(priority=39)
		public void VerifySearchCallsWithLastNameIsExactly() throws InterruptedException {
			System.out.println("VerifySearchCallsWithLastNameIsExactly");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown1 = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day
				dropdown1.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFirstName")));
			//Click on Last Name dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlLastName")));
			//Select Is exactly criteria
				dropdown.selectByVisibleText("Is exactly");
			//Enter Zuckerberg as a Last name Is exactly
				driver.findElement(By.id("txtLastName")).sendKeys("Zuckerberg");
			//Click on Results Per Page dropdown
				Select dropdown2 = new Select(driver.findElement(By.id("ddlPageSize")));
			//Select 20
				dropdown2.selectByVisibleText("20");
				
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			
			//Wait for the browser to respond
				WebDriverWait wait2 = new WebDriverWait(driver,30);
				WebElement btnMain2;
				btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
			//Verify the result is displayed
				String currentresult = driver.findElement(By.id("lblCountRecords")).getText();
				System.out.println("Current Result : "+currentresult);
			//Wait for the browser to respond
				WebDriverWait wait3 = new WebDriverWait(driver,30);
				WebElement btnMain3;
				btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
				String actualresult = driver.findElement(By.id("lblCountRecords")).getText();
				Assert.assertEquals(actualresult, currentresult);
				System.out.println("Expected Message : "+currentresult);
				System.out.println("Actual Message : " +actualresult);
				
			//Click on Search button
				driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(5000);
			//Check the web page is changed to searchresult	
				String expectedurl2 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String actualurl2= driver.getCurrentUrl();
				Assert.assertEquals(actualurl2,expectedurl2);
				Thread.sleep(5000);
			//Identifying the number of rows having <tr> tag
				
				WebElement ToGetrows = driver.findElement(By.xpath("//table[@id='tblCallDetail']/tbody/tr"));

				List<WebElement> TotalRowsList = ToGetrows.findElements(By.tagName("tr"));
			//Total rows -2 because the table includes header and footer so we need to exclude them
				int totalCalls= TotalRowsList.size()-2;
			//Now convert the integer value to String
				String s=Integer.toString(totalCalls);
				System.out.println("Total Number of Rows found in the table are: "+totalCalls);
				Thread.sleep(2000);
			//Match the count and search result which should be same
				Assert.assertEquals(s, currentresult);
				
		}	
			
	
		
		//Test ID 28-57
			//"1-Make some call.
			//2-Go to Last Name area. Select ""Is Exactly"" from dropdown.
			//3-Do not enter any value in field.
			//4-Click on Count Results button.                                           
			//5-Click on search button"
							//Result:It must display error "Please enter value in field "   
							//Comment from developers: Those fields are not mandatory fields and can be left empty.
						//This test case will not be automated
			
		
		//Test ID 28-58
			//"1-Make some call.
			//2-Go to Last Name area. Select ""Is Exactly"" from dropdown.
			//3-Enter special characters and negative values in field
			//4-Click on Count Results button.                                           
			//5-Click on search button"
		@Test(priority=40)
		public void VerifySearchCallsWithLastNameIsExactlySpecChar() throws InterruptedException {
			System.out.println("VerifySearchCallsWithLastNameIsExactlySpecChar");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown1 = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day
				dropdown1.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFirstName")));
			//Click on Last Name dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlLastName")));
			//Select Is exactly criteria
				dropdown.selectByVisibleText("Is exactly");
			//Enter @#$Zuckerberg as a Last name contains
				driver.findElement(By.id("txtLastName")).sendKeys("@#$Zuckerberg");
			//Click on Results Per Page dropdown
				Select dropdown2 = new Select(driver.findElement(By.id("ddlPageSize")));
			//Select 20
				dropdown2.selectByVisibleText("20");
							
			//Click on Search button
				driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(5000);
			Thread.sleep(5000);
			//Check the web page is changed to searchresult	
				String expectedurl2 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String actualurl2= driver.getCurrentUrl();
				Assert.assertEquals(actualurl2,expectedurl2);
				Thread.sleep(5000);			
		}	
	
		
		//Test ID 28-59
			//"1-Make some call.
			//2-Go to Last Name area. Select ""Not Starts With"" from dropdown.
			//3-Enter those alphabets which does not starts with agents Last Name.
			//4-Click on Count Results button.                                           
			//5-Click on search button"
		@Test(priority=41)
		public void VerifySearchCallsWithLastNameNotStartsWith() throws InterruptedException {
			System.out.println("VerifySearchCallsWithLastNameNotStartsWith");
				driver.get(siteUrl);
			//Enter Site code
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
			//Click on Search Calls
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown1 = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day
				dropdown1.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFirstName")));
			//Click on Last Name dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlLastName")));
			//Select Not starts with criteria
				dropdown.selectByVisibleText("Not starts with");
			//Enter ucker as a Last name Is exactly
				driver.findElement(By.id("txtLastName")).sendKeys("ucker");
			//Click on Results Per Page dropdown
				Select dropdown2 = new Select(driver.findElement(By.id("ddlPageSize")));
			//Select 20
				dropdown2.selectByVisibleText("20");
				
			//Click on Count Result button
				driver.findElement(By.id("btnCount")).click();
			
			//Wait for the browser to respond
				WebDriverWait wait2 = new WebDriverWait(driver,30);
				WebElement btnMain2;
				btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
			//Verify the result is displayed
				String currentresult = driver.findElement(By.id("lblCountRecords")).getText();
				System.out.println("Current Result : "+currentresult);
			//Wait for the browser to respond
				WebDriverWait wait3 = new WebDriverWait(driver,30);
				WebElement btnMain3;
				btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblCountRecords")));
				String actualresult = driver.findElement(By.id("lblCountRecords")).getText();
				Assert.assertEquals(actualresult, currentresult);
				System.out.println("Expected Message : "+currentresult);
				System.out.println("Actual Message : " +actualresult);
				
			//Click on Search button
				driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(5000);
			//Check the web page is changed to searchresult	
				String expectedurl2 = "http://localhost/OmniPCXRECORD/SearchResults.aspx";
				String actualurl2= driver.getCurrentUrl();
				Assert.assertEquals(actualurl2,expectedurl2);
				Thread.sleep(5000);
			//Identifying the number of rows having <tr> tag
				
				WebElement ToGetrows = driver.findElement(By.xpath("//table[@id='tblCallDetail']/tbody/tr"));

				List<WebElement> TotalRowsList = ToGetrows.findElements(By.tagName("tr"));
			//Total rows -2 because the table includes header and footer so we need to exclude them
				int totalCalls= TotalRowsList.size()-2;
			//Now convert the integer value to String
				String s=Integer.toString(totalCalls);
				System.out.println("Total Number of Rows found in the table are: "+totalCalls);
				Thread.sleep(2000);
			//Match the count and search result which should be same
				Assert.assertEquals(s, currentresult);
				
		}
		
		//Test ID 28-57
			//"1-Make some call.
			//2-Go to Last Name area. Select ""Not Starts With"" from dropdown.
			//3-Do not enter any value in field.
			//4-Click on Count Results button.                                           
			//5-Click on search button"
						//Result:It must display error "Please enter value in field "   
						//Comment from developers: Those fields are not mandatory fields and can be left empty.
					//This test case will not be automated
		
		
		
		
		
		
		@AfterTest
		public void tearDownTest() throws InterruptedException {
					
			System.out.println("Test Completed Successfully");
			driver.quit();
		}

}
