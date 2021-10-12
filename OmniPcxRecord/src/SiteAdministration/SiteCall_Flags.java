package SiteAdministration;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.*;

public class SiteCall_Flags {

		private static final WebElement No_Flag = null;
		WebDriver driver = null;
		//WebDriverWait wait = new WebDriverWait(driver, 15);
		public String siteUrl = "http://172.20.22.81/OmniPCXRECORD/default.aspx";
		public String ExpectedSiteURL = "http://172.20.22.81/OmniPCXRECORD/default.aspx";
		private String url;
		
		
		@BeforeTest
		public void setUpTest() {
			
         System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrator\\Desktop\\FilesToSetup\\geckodriver.exe");
	     driver=new FirefoxDriver();
		}
		

		//Test ID 05-01
			//To verify that Call Flags are associated to the calls.
		@Test(priority=0)
		public void AddCallFlagToCall() throws InterruptedException {
			System.out.println("AddCallFlagToCall");
				driver.get(siteUrl);
			//Enter Site code
//				driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
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
			//Click on Search button  
				driver.findElement(By.id("btnSearch")).click();
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ImgFlg_NaN_8")));
			//Click on ... to select the flag
				driver.findElement(By.id("ImgFlg_NaN_8")).click();
			//Select Notify client flag
				driver.findElement(By.xpath("/html/body/ul[4]/li[2]/span")).click();
				Boolean expectedresult=driver.findElement(By.xpath("//*[@id=\"ImgFlg_2104202115494776309017A_2\"]")).isDisplayed();
				Boolean actualresult = true;
				Thread.sleep(2000);
				Assert.assertEquals(actualresult, expectedresult);	
				System.out.println("Expected Result : "+expectedresult);
				System.out.println("Actual Result : " +actualresult);
				}
		
		
	
		
		
		
		//Test ID 05-02
			// Verify the result of 05-01 through search calls
		
		@Test(priority=1)
		public void VerifyCallFlag() throws InterruptedException {
			System.out.println("VerifyCallFlag");
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
			//Click on Search Call
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
			//Click on Call Date and Time dropdown
				Select dropdown = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day  
				dropdown.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days field  
				driver.findElement(By.id("txtNDays")).sendKeys("999");
			//Click on Other Criteria dropdown	
				Select dropdown1 = new Select(driver.findElement(By.xpath("//*[@id=\"Table2\"]/tbody/tr[10]/td[2]/table/tbody/tr/td[1]/select")));
			//Select Flag	
				dropdown1.selectByVisibleText("Flag");
			//Click on Add button	
				driver.findElement(By.xpath("//*[@id=\"Table2\"]/tbody/tr[10]/td[2]/table/tbody/tr/td[2]/input")).click();
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFlags")));
				Select dropdown2 = new Select(driver.findElement(By.id("ddlFlags")));
			//Select Notify client flag	
				dropdown2.selectByVisibleText("Notify client");
			//Click on Search button  
				driver.findElement(By.id("btnSearch")).click();
			//Wait for the browser to respond
				WebDriverWait wait2 = new WebDriverWait(driver,30);
				WebElement btnMain2;
				btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("ImgFlg_2104202115494776309017A_2")));
				Boolean expectedresult=driver.findElement(By.id("ImgFlg_2104202115494776309017A_2")).isDisplayed();
				Boolean actualresult = true;
				Thread.sleep(2000);
				Assert.assertEquals(actualresult, expectedresult);	
				System.out.println("Expected Result : "+expectedresult);
				System.out.println("Actual Result : " +actualresult);
				}
		
		
		//Test ID 05-03
				// Verify the tooltip
			
		@Test(priority=2)
		public void VerifyTooltip() throws InterruptedException {
			System.out.println("VerifyTooltip");
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
			//Click on Call Date and TIme dropdown	
				Select dropdown = new Select(driver.findElement(By.id("ddlDateTime")));
			//Select Occurring in past N Day	
				dropdown.selectByVisibleText("Occurring in past N Days");
			//Enter 999 in Number of Days
				driver.findElement(By.id("txtNDays")).sendKeys("999");
				Select dropdown1 = new Select(driver.findElement(By.xpath("//*[@id=\"Table2\"]/tbody/tr[10]/td[2]/table/tbody/tr/td[1]/select")));
				dropdown1.selectByVisibleText("Flag");
				driver.findElement(By.xpath("//*[@id=\"Table2\"]/tbody/tr[10]/td[2]/table/tbody/tr/td[2]/input")).click();
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFlags")));
				Select dropdown2 = new Select(driver.findElement(By.id("ddlFlags")));
				dropdown2.selectByVisibleText("Notify client");
				driver.findElement(By.id("btnSearch")).click();
			//Wait for the browser to respond
				WebDriverWait wait2 = new WebDriverWait(driver,30);
				WebElement btnMain2;
				btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("ImgFlg_2104202115494776309017A_2")));
				Boolean expectedresult=driver.findElement(By.id("ImgFlg_2104202115494776309017A_2")).isDisplayed();
				Boolean actualresult = true;
			//Wait for the browser to respond
				WebDriverWait wait3 = new WebDriverWait(driver,30);
				WebElement btnMain3;
				btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("ImgFlg_2104202115494776309017A_2")));
				Assert.assertEquals(actualresult, expectedresult);	
				WebElement Notify_client = driver.findElement(By.id("ImgFlg_2104202115494776309017A_2"));
				String actualTooltip = Notify_client.getAttribute("title");
			    System.out.println("Actual Title of Tool Tip"+actualTooltip);
			    String expectedTooltip = "Notify client";
				Assert.assertEquals(actualTooltip, expectedTooltip);    					
				System.out.println("Expected Tooltip : "+expectedTooltip);
				System.out.println("Actual Tooltip : " +actualTooltip);	
			}
			
				
			//Test ID 05-04 is same as 05-02
			//Test ID 05-05 is not automated as its is related to silent monitoring
			//Test ID 05-06 is same as 05-01
			//Test ID 05-07 is a case for archiving
			//Test ID 05-08 is same as 05-04
			//Test ID 05-09 is for translation
			//Test ID 05-10 is for translation
			
			
			//Test ID 05-11
				//Add apostrophe in the name of call flag
			
		@Test(priority=3)
		public void AddApostropheInCallFlagName() throws InterruptedException {
			System.out.println("AddApostropheInCallFlagName");
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink3")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink3")).click();
				driver.findElement(By.id("flg1")).clear();
				driver.findElement(By.id("flg1")).sendKeys("'Training' 'required'");
				driver.findElement(By.id("btnSave")).click();
				Thread.sleep(8000);
				String expectedresult = "'Training' 'required'";
				String actualresult = driver.findElement(By.id("flg1")).getAttribute("value");
				Assert.assertEquals(actualresult,expectedresult);
				System.out.println("Expected Result : "+expectedresult);
				System.out.println("Actual Result : " +actualresult);
			}
		
				
			
			
			
			
			
			//Test ID 05-13
				//Update the call flag name with empty data
		
		@Test(priority=4)
		public void CallFlagWithEmptyData() throws InterruptedException {
			System.out.println("CallFlagWithEmptyData");
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink3")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink3")).click();
				driver.findElement(By.id("flg1")).clear();
				driver.findElement(By.id("btnSave")).click();
				Thread.sleep(2000);
				String expectedmsg = "Please enter description for the flag.";
				String actualmsg = driver.findElement(By.id("lblMessage")).getText();
				Assert.assertEquals(actualmsg, expectedmsg);
				System.out.println("Expected Message : "+expectedmsg);
				System.out.println("Actual Message : " +actualmsg);
		}
			
		
		
		
		

			//Test ID 05-14
			//Verify the functionality of reset button
		
		@Test(priority=5)
		public void ResetCallFlagNames() throws InterruptedException {
			System.out.println("ResetCallFlagNames");
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
				btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink3")));
				String expectedurl="ExpectedSiteURL";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				String actualurl1="siteUrl";
				String expectedurl1= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl1,expectedurl1);
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink3")).click();
				driver.findElement(By.id("btnReset")).click();
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessage")));
				String expectedmsg = "Flags have been saved successfully.";
				String actualmsg = driver.findElement(By.id("lblMessage")).getText();
				Assert.assertEquals(actualmsg, expectedmsg);
				System.out.println("Expected Message : "+expectedmsg);
				System.out.println("Actual Message : " +actualmsg);
				String expectedresult1 = "Training required";
				String actualresult1 = driver.findElement(By.id("flg1")).getAttribute("value");
				Assert.assertEquals(actualresult1,expectedresult1);
				System.out.println("Expected Result1 : "+expectedresult1);
				System.out.println("Actual Result1 : " +actualresult1);
				String expectedresult2 = "Notify client";
				String actualresult2 = driver.findElement(By.id("flg2")).getAttribute("value");
				Assert.assertEquals(actualresult2,expectedresult2);
				System.out.println("Expected Result2 : "+expectedresult2);
				System.out.println("Actual Result2 : " +actualresult2);
				String expectedresult3 = "Attention required";
				String actualresult3 = driver.findElement(By.id("flg3")).getAttribute("value");
				Assert.assertEquals(actualresult3,expectedresult3);
				System.out.println("Expected Result3 : "+expectedresult3);
				System.out.println("Actual Result3 : " +actualresult3);
				String expectedresult4 = "Great call";
				String actualresult4 = driver.findElement(By.id("flg4")).getAttribute("value");
				Assert.assertEquals(actualresult4,expectedresult4);
				System.out.println("Expected Result4 : "+expectedresult4);
				System.out.println("Actual Result4 : " +actualresult4);
				String expectedresult5 = "Conference call";
				String actualresult5 = driver.findElement(By.id("flg5")).getAttribute("value");
				Assert.assertEquals(actualresult5,expectedresult5);
				System.out.println("Expected Result5 : "+expectedresult5);
				System.out.println("Actual Result5 : " +actualresult5);
				String expectedresult6 = "System problem";
				String actualresult6 = driver.findElement(By.id("flg6")).getAttribute("value");
				Assert.assertEquals(actualresult6,expectedresult6);
				System.out.println("Expected Result6 : "+expectedresult6);
				System.out.println("Actual Result6 : " +actualresult6);
				String expectedresult7 = "See comments";
				String actualresult7 = driver.findElement(By.id("flg7")).getAttribute("value");
				Assert.assertEquals(actualresult7,expectedresult7);
				System.out.println("Expected Result7 : "+expectedresult7);
				System.out.println("Actual Result7 : " +actualresult7);
		}
		
		
		

				//Remove call flag from the call which was assigned in 05-01
		
		@Test(priority=6)
		public void RemoveFlag() throws InterruptedException {
			System.out.println("RemoveFlag");
				driver.get(siteUrl);
				driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
				driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
				driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
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
				driver.findElement(By.id("ctl00_CtrlLeftMenus1_lnkBtnSearchCall")).click();				
				Select dropdown = new Select(driver.findElement(By.id("ddlDateTime")));
				dropdown.selectByVisibleText("Occurring in past N Days");
				driver.findElement(By.id("txtNDays")).sendKeys("999");
				Select dropdown1 = new Select(driver.findElement(By.xpath("//*[@id=\"Table2\"]/tbody/tr[10]/td[2]/table/tbody/tr/td[1]/select")));
																		
				dropdown1.selectByVisibleText("Flag");
				driver.findElement(By.xpath("//*[@id=\"Table2\"]/tbody/tr[10]/td[2]/table/tbody/tr/td[2]/input")).click();
			  
			//Wait for the browser to respond
				WebDriverWait wait1 = new WebDriverWait(driver,30);
				WebElement btnMain1;
				btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlFlags")));
				Select dropdown2 = new Select(driver.findElement(By.id("ddlFlags")));
				dropdown2.selectByVisibleText("Notify client");
				driver.findElement(By.id("btnSearch")).click();
			//Wait for the browser to respond
				WebDriverWait wait2 = new WebDriverWait(driver,30);
				WebElement btnMain2;
				btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("ImgFlg_2104202115494776309017A_2")));
				driver.findElement(By.id("ImgFlg_2104202115494776309017A_2")).click();
				driver.findElement(By.xpath("/html/body/ul[2]/li[8]")).click();
			  
				WebElement NoFlag = driver.findElement(By.id("ImgFlg_2104202115494776309017A_8"));
				String actualTooltip = NoFlag.getAttribute("title");
			    System.out.println("Actual Title of Tool Tip"+actualTooltip);
			    String expectedTooltip = "No Flag";
											
		        Assert.assertEquals(actualTooltip, expectedTooltip);
		        System.out.println("Expected Tooltip : "+expectedTooltip);
		        System.out.println("Actual Tooltip : " +actualTooltip);
		}
		  

			
				
			@AfterTest
			public void tearDownTest() throws InterruptedException {
						
				System.out.println("Test Completed Successfully");
			}	
}
