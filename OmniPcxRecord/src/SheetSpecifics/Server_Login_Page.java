package SheetSpecifics;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Server_Login_Page {
	
	WebDriver driver = null;
	public String siteUrl = "http://172.20.22.81/OmniPCXRECORD/Default.aspx";
	
	
	@BeforeTest
	public void setUpTest() {
		//Basic test case of OPR web login
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrator\\Desktop\\FilesToSetup\\geckodriver.exe");
	    driver=new FirefoxDriver();
	}
	
	//Test ID 02-01
		//To verify that Super Admin user should be able to Login into Server Administration web with valid Username and Password:
		//User as Super Admin user with OPR Authentication
	
	@Test(priority=0)
	public void LoginWithValidCredentials() throws InterruptedException {
	
	//String url = "http://172.20.1.64/omniPcxRecord/default.aspx";
	driver.get(siteUrl);
	driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
	Thread.sleep(5000);
	String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
	String actualurl=driver.getCurrentUrl();
	System.out.println("Actual Url:"+actualurl);
	System.out.println("Expected Url:"+expectedurl);
	driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	String actualurl1="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
	String expectedurl1= driver.getCurrentUrl();
	Assert.assertNotEquals(actualurl1,expectedurl1);
	}
	
	
	
	//Test ID 02-02
		//To verify that  Super Admin user should not be able to Login into Server Administration web with invalid Username and valid Password :
		//User as Super Admin user with OPR Authentication
	
	@Test(priority=1)
	public void LoginWithInvalidUsernameButValidPasswordCredentials() throws InterruptedException {
	
	String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
	driver.get(url);
	driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
	Thread.sleep(5000);
	String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
	String actualurl=driver.getCurrentUrl();
	System.out.println("Actual Url:"+actualurl);
	System.out.println("Expected Url:"+expectedurl);
	driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin1");
	driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	String expectedmsg = "Invalid username or password";
	String actualmsg = driver.findElement(By.id("ctrl_TenantAdmin1_lblMessage")).getText();
	Assert.assertEquals(actualmsg, expectedmsg);
	}
	
	
	
	//Test ID 02-03
		//To verify that Super Admin user should not be able to Login into Server Administration with valid Username and invalid Password:
		//User as Super Admin user with OPR Authentication
	
	@Test(priority=2)
	public void LoginWithValidUsernameButInvalidPasswordCredentials() throws InterruptedException {
	
	String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
	driver.get(url);
	driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
	Thread.sleep(5000);
	String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
	String actualurl=driver.getCurrentUrl();
	System.out.println("Actual Url:"+actualurl);
	System.out.println("Expected Url:"+expectedurl);
	driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567b");
	driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	String expectedmsg = "Invalid username or password";
	String actualmsg = driver.findElement(By.id("ctrl_TenantAdmin1_lblMessage")).getText();
	Assert.assertEquals(actualmsg, expectedmsg);
	}
	
	
	
	//Test ID 02-04
		//To verify that Super Admin user should not be able to Login into Server Administration with invalid Username and Password:
		//User as Super Admin user with OPR Authentication
	
	@Test(priority=3)
	public void LoginWithInvalidUsernameandPasswordCredentials() throws InterruptedException {
	
	String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
	driver.get(url);
	driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
	Thread.sleep(5000);
	String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
	String actualurl=driver.getCurrentUrl();
	System.out.println("Actual Url:"+actualurl);
	System.out.println("Expected Url:"+expectedurl);
	driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin1");
	driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567b");
	driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	String expectedmsg = "Invalid username or password";
	String actualmsg = driver.findElement(By.id("ctrl_TenantAdmin1_lblMessage")).getText();
	Assert.assertEquals(actualmsg, expectedmsg);
	}
	
	
	
	//Test ID 02-05
		//To verify that Super Admin user should not be able to Login into Server Administration with Empty Username and valid Password:
		//User as Super Admin user with OPR Authentication
	
	@Test(priority=4)
	public void LoginWithEmptyUsernameandValidPasswordCredentials() throws InterruptedException {
	
	String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
	driver.get(url);
	driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
	Thread.sleep(5000);
	String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
	String actualurl=driver.getCurrentUrl();
	System.out.println("Actual Url:"+actualurl);
	System.out.println("Expected Url:"+expectedurl);
	driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	String expectedmsg = "Please enter Username";
	String actualmsg = driver.findElement(By.id("ctrl_TenantAdmin1_lblMessage")).getText();
	Assert.assertEquals(actualmsg, expectedmsg);
	}
	
	
	
	//Test ID 02-06
		//To verify that Super Admin user should not be able to Login into Server Administration with valid Username and empty Password:
		//User as Super Admin user with OPR Authentication
	
	@Test(priority=5)
	public void LoginWithValidUsernameandEmptyPasswordCredentials() throws InterruptedException {
	
	String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
	driver.get(url);
	driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
	Thread.sleep(5000);
	String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
	String actualurl=driver.getCurrentUrl();
	System.out.println("Actual Url:"+actualurl);
	System.out.println("Expected Url:"+expectedurl);
	driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	String expectedmsg = "Please enter Password";
	String actualmsg = driver.findElement(By.id("ctrl_TenantAdmin1_lblMessage")).getText();
	Assert.assertEquals(actualmsg, expectedmsg);
	}
	
	
	
	//Note: Test ID 02-07 is a duplicated test case
	
	//Test ID 02-08
		//To verify that Super Admin user should be able to Login into Site Administration with valid Username and Password:
		//User as Super Admin user and Site as Site Administration
	
	@Test(priority=6)
	public void LoginToSiteWithValidCredentials() throws InterruptedException {
	
	String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
	driver.get(url);
	driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
	driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
	driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
	driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
	String expectedurl="http://172.20.22.81/OmniPCXRECORD/Default.aspx";
	String actualurl=driver.getCurrentUrl();
	System.out.println("Actual Url:"+actualurl);
	System.out.println("Expected Url:"+expectedurl);
	String actualurl1="http://172.20.22.81/OmniPCXRECORD/default.aspx";
	String expectedurl1= driver.getCurrentUrl();
	Assert.assertNotEquals(actualurl1,expectedurl1);
	}
	
	
	
	//Test ID 02-09
		//To verify that  Super Admin user should not be able to Login into Site Administration with invalid Username and valid Password:
		//User as Super Admin user and Site as Site Administration
	
	@Test(priority=7)
	public void LoginToSiteWithInvalidUsernameButValidPasswordCredentials() throws InterruptedException {
	
	String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
	driver.get(url);
	driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
	driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin1");
	driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
	driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
	String expectedmsg = "Invalid username or password";
	String actualmsg = driver.findElement(By.id("Ctrl_Login1_lblMessage")).getText();
	Assert.assertEquals(actualmsg, expectedmsg);
	}
	
	
	
	//Test ID 02-10
		//To verify that Super Admin user should not be able to Login into Site Administration with valid Username and invalid Password :
		//User as Super Admin user and Site as Site Administration
	
	@Test(priority=8)
	public void LoginToSiteWithValidUsernameButInvalidPasswordCredentials() throws InterruptedException {
	
	String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
	driver.get(url);
	driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
	driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
	driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567b");
	driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
	String expectedmsg = "Invalid username or password";
	String actualmsg = driver.findElement(By.id("Ctrl_Login1_lblMessage")).getText();
	Assert.assertEquals(actualmsg, expectedmsg);
	}
	
	
	
	//Test ID 02-11
		//To verify that Super Admin user should not be able to Login into Site Administration with invalid Username and invalid Password:
		//User as Super Admin user and Site as Site Administration
	
	@Test(priority=9)
	public void LoginToSiteWithInvalidUsernameandPasswordCredentials() throws InterruptedException {
	
	String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
	driver.get(url);
	driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
	driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin1");
	driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567b");
	driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
	String expectedmsg = "Invalid username or password";
	String actualmsg = driver.findElement(By.id("Ctrl_Login1_lblMessage")).getText();
	Assert.assertEquals(actualmsg, expectedmsg);
	}
	
	
	
	//Test ID 02-12
		//To verify that Super Admin user should not be able to Login into Site Administration with Empty Username and valid Password :
		//User as Super Admin user and Site as Site Administration
	
	@Test(priority=10)
	public void LoginToSiteWithEmptyUsernameandValidPasswordCredentials() throws InterruptedException {
	
	String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
	driver.get(url);
	driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
	driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
	driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
	String expectedmsg = "Please enter Username";
	String actualmsg = driver.findElement(By.id("Ctrl_Login1_lblMessage")).getText();
	Assert.assertEquals(actualmsg, expectedmsg);
	}
	
	
	
	//Test ID 02-13
		//To verify that Super Admin user should not be able to Login into Site Administration with valid Username and empty Password:
		//User as Super Admin user and Site as Site Administration
	
	@Test(priority=11)
	public void LoginToSiteWithValidUsernameandEmptyPasswordCredentials() throws InterruptedException {
	
	String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
	driver.get(url);
	driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
	driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
	driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
	String expectedmsg = "Please enter Password";
	String actualmsg = driver.findElement(By.id("Ctrl_Login1_lblMessage")).getText();
	Assert.assertEquals(actualmsg, expectedmsg);
	}
	
	
	
	//Test ID 02-14
		//To verify that Agent should be able to Login into Site Administration with valid Username and Password:
		//User as Normal user and Site as Site Administration
	
	@Test(priority=12)
	public void AgentLoginToSiteWithValidCredentials() throws InterruptedException {
	
	String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
	driver.get(url);
	driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
	driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("ehunt");
	driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
	driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
	String expectedurl="http://172.20.22.81/OmniPCXRECORD/Default.aspx";
	String actualurl=driver.getCurrentUrl();
	System.out.println("Actual Url:"+actualurl);
	System.out.println("Expected Url:"+expectedurl);
	String actualurl1="http://172.20.22.81/OmniPCXRECORD/default.aspx";
	String expectedurl1= driver.getCurrentUrl();
	Assert.assertNotEquals(actualurl1,expectedurl1);
	}
	
	
	
	//Test ID 02-15
		//To verify that Group Admin should be able to Login into Site Administration with valid Username and Password 
	
	@Test(priority=13)
	public void GroupAdminLoginToSiteWithValidCredentials() throws InterruptedException {
	
	String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
	driver.get(url);
	driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
	driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("mjordan");
	driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
	driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
	String expectedurl="http://172.20.22.81/OmniPCXRECORD/Default.aspx";
	String actualurl=driver.getCurrentUrl();
	System.out.println("Actual Url:"+actualurl);
	System.out.println("Expected Url:"+expectedurl);
	String actualurl1="http://172.20.22.81/OmniPCXRECORD/default.aspx";
	String expectedurl1= driver.getCurrentUrl();
	Assert.assertNotEquals(actualurl1,expectedurl1);
	}
	
	
	
	//Test ID 02-16
		//To verify that Configuration Manager should be able to Login into Site Administration with valid Username and Password:
		//User as Normal user and Site as Site Administration
	
	@Test(priority=14)
	public void CMLoginToSiteWithValidCredentials() throws InterruptedException {
	
	String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
	driver.get(url);
	driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
	driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("aakhtar");
	driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
	driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
	String expectedurl="http://172.20.22.81/OmniPCXRECORD/Default.aspx";
	String actualurl=driver.getCurrentUrl();
	System.out.println("Actual Url:"+actualurl);
	System.out.println("Expected Url:"+expectedurl);
	String actualurl1="http://172.20.22.81/OmniPCXRECORD/default.aspx";
	String expectedurl1= driver.getCurrentUrl();
	Assert.assertNotEquals(actualurl1,expectedurl1);
	}
	
	
	
	//Own test case
		//To verify that OmniPCX RECORD agent is not able to login to Site after changing authentication Type to active directory

	@Test(priority=15)
	public void OPRAgentUnableToLoginWhenADAuthenticationIsSet() throws InterruptedException {
	String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
	driver.get(url);
	driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
	Thread.sleep(5000);
	String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
	String actualurl=driver.getCurrentUrl();
	System.out.println("Actual Url:"+actualurl);
	System.out.println("Expected Url:"+expectedurl);
	driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
	Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
	  dropdown.selectByVisibleText("Active Directory");
	  driver.findElement(By.id("txtADDomainName")).sendKeys("ghostsoftware.local");
	  driver.findElement(By.id("txtADUsername")).sendKeys("ahsan.rehman");
	  driver.findElement(By.id("txtADPassword")).sendKeys("Abc123*");
	  driver.findElement(By.id("btnUpdateAuthSettings")).click();
	  Thread.sleep(5000);
	  String expectedmsg = "Settings have been updated successfully";
	  String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
	  Assert.assertEquals(actualmsg, expectedmsg);
	  driver.findElement(By.id("ctl00_lblLogOut")).click();
	String url1 = "http://172.20.22.81/omniPcxRecord/default.aspx";
	driver.get(url1);
	driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
	driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("ehunt");
	driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
	driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
	String expectedmsg1 = "Invalid active directory user";
	String actualmsg1 = driver.findElement(By.id("Ctrl_Login1_lblMessage")).getText();
	Assert.assertEquals(actualmsg1, expectedmsg1);
	}
	
	
	
	
	// Reset the authentication type to OmniPCX RECORD
	@Test(priority=16)
	public void ResetAuthenticationType() throws InterruptedException {
	String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
	driver.get(url);
	driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
	Thread.sleep(5000);
	String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
	String actualurl=driver.getCurrentUrl();
	System.out.println("Actual Url:"+actualurl);
	System.out.println("Expected Url:"+expectedurl);
	driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
	Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
	  dropdown.selectByVisibleText("OmniPCX RECORD");
	  driver.findElement(By.id("btnUpdateAuthSettings")).click();
	  Thread.sleep(5000);
	  String expectedmsg = "Settings have been updated successfully";
	  String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
	  Assert.assertEquals(actualmsg, expectedmsg);
	  driver.findElement(By.id("ctl00_lblLogOut")).click();
	}


	
	//Test ID 02-18
		// To verify that Super Admin should be able to login into Server Administration after changing Authentication to Active Directory
	
	@Test(priority=17)
	public void OPRSUAableToLoginWhenADAuthenticationIsSet() throws InterruptedException {
	String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
	driver.get(url);
	driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
	Thread.sleep(5000);
	String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
	String actualurl=driver.getCurrentUrl();
	System.out.println("Actual Url:"+actualurl);
	System.out.println("Expected Url:"+expectedurl);
	driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
	Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
	  dropdown.selectByVisibleText("Active Directory");
	  driver.findElement(By.id("txtADDomainName")).sendKeys("ghostsoftware.local");
	  driver.findElement(By.id("txtADUsername")).sendKeys("ahsan.rehman");
	  driver.findElement(By.id("txtADPassword")).sendKeys("Abc123*");
	  driver.findElement(By.id("btnUpdateAuthSettings")).click();
	  Thread.sleep(5000);
	  String expectedmsg = "Settings have been updated successfully";
	  String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
	  Assert.assertEquals(actualmsg, expectedmsg);
	  driver.findElement(By.id("ctl00_lblLogOut")).click();
	String url1 = "http://172.20.22.81/omniPcxRecord/default.aspx";
	driver.get(url1);
	driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
	Thread.sleep(5000);
	String expectedurl1="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
	String actualurl1=driver.getCurrentUrl();
	System.out.println("Actual Url:"+actualurl1);
	System.out.println("Expected Url:"+expectedurl1);
	driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	Thread.sleep(1000);
	String expectedurl2="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
	String actualurl2=driver.getCurrentUrl();
	System.out.println("Actual Url:"+actualurl2);
	System.out.println("Expected Url:"+expectedurl2);
	String actualurl3="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
	String expectedurl3= driver.getCurrentUrl();
	Assert.assertNotEquals(actualurl3,expectedurl3);
	}
	
	
	
		
	
	// Reset the authentication type to OmniPCX RECORD
			@Test(priority=18)
			public void ResetAuthenticationType1() throws InterruptedException {
			String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
			driver.get(url);
			driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
			Thread.sleep(5000);
			String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
			String actualurl=driver.getCurrentUrl();
			System.out.println("Actual Url:"+actualurl);
			System.out.println("Expected Url:"+expectedurl);
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
			Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
			  dropdown.selectByVisibleText("OmniPCX RECORD");
			  driver.findElement(By.id("btnUpdateAuthSettings")).click();
			  Thread.sleep(5000);
			  String expectedmsg = "Settings have been updated successfully";
			  String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
			  Assert.assertEquals(actualmsg, expectedmsg);
			  driver.findElement(By.id("ctl00_lblLogOut")).click();
			}
			
			
	
	// Test ID 02-20
		// To verify that Active Directory server user should not be able to login into Server Administration after changing Authentication to Mix Mode when user set Authentication Type to OmniPCX Record from drop down at login page

	@Test(priority=19)
	public void ADUserUnableToLoginWhenMixModeAuthenticationIsSet() throws InterruptedException {
	String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
	driver.get(url);
	driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
	Thread.sleep(5000);
	String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
	String actualurl=driver.getCurrentUrl();
	System.out.println("Actual Url:"+actualurl);
	System.out.println("Expected Url:"+expectedurl);
	driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
	Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
	  dropdown.selectByVisibleText("Mix Mode (OmniPCX RECORD - Active Directory)");
	  driver.findElement(By.id("txtADDomainName")).sendKeys("ghostsoftware.local");
	  driver.findElement(By.id("txtADUsername")).sendKeys("ahsan.rehman");
	  driver.findElement(By.id("txtADPassword")).sendKeys("Abc123*");
	  driver.findElement(By.id("rbADCriteriaAll")).click();
	  driver.findElement(By.id("btnUpdateAuthSettings")).click();
	  Thread.sleep(5000);
	  String expectedmsg = "Settings have been updated successfully";
	  String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
	  Assert.assertEquals(actualmsg, expectedmsg);
	  driver.findElement(By.id("ctl00_lblLogOut")).click();
	String url1 = "http://172.20.22.81/omniPcxRecord/default.aspx";
	driver.get(url1);
	driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
	Thread.sleep(5000);
	String expectedurl1="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
	String actualurl1=driver.getCurrentUrl();
	System.out.println("Actual Url:"+actualurl1);
	System.out.println("Expected Url:"+expectedurl1);
	driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("ahsan.rehman");
	driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("Abc123*");
	Select dropdown1 = new Select(driver.findElement(By.id("ctrl_TenantAdmin1_drpAuthType")));
	dropdown1.selectByVisibleText("OmniPCX RECORD");
	driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	String expectedmsg1 = "Invalid username or password";
	String actualmsg1 = driver.findElement(By.id("ctrl_TenantAdmin1_lblMessage")).getText();
	Assert.assertEquals(actualmsg1, expectedmsg1);
	}
	
	
	
	// Reset the authentication type to OmniPCX RECORD
			@Test(priority=20)
			public void ResetAuthenticationType2() throws InterruptedException {
			String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
				driver.get(url);
				driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
				Thread.sleep(5000);
			String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
				driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
				driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
				Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
				dropdown.selectByVisibleText("OmniPCX RECORD");
				driver.findElement(By.id("btnUpdateAuthSettings")).click();
				Thread.sleep(5000);
				String expectedmsg = "Settings have been updated successfully";
				String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
				Assert.assertEquals(actualmsg, expectedmsg);
				driver.findElement(By.id("ctl00_lblLogOut")).click();
			}
	
			
			
			// Test ID 02-21
				// To verify that Super Admin should be able to login into Site Administration after changing Authentication Type to Active Directory

			@Test(priority=21)
			public void OPRSiteSUAableToLoginWhenADAuthenticationIsSet() throws InterruptedException {
			String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
			driver.get(url);
			driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
			Thread.sleep(5000);
			String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
			String actualurl=driver.getCurrentUrl();
			System.out.println("Actual Url:"+actualurl);
			System.out.println("Expected Url:"+expectedurl);
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
			Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
			  dropdown.selectByVisibleText("Active Directory");
			  driver.findElement(By.id("txtADDomainName")).sendKeys("ghostsoftware.local");
			  driver.findElement(By.id("txtADUsername")).sendKeys("ahsan.rehman");
			  driver.findElement(By.id("txtADPassword")).sendKeys("Abc123*");
			  driver.findElement(By.id("rbADCriteriaAll")).click();
			  driver.findElement(By.id("btnUpdateAuthSettings")).click();
			  Thread.sleep(5000);
			  String expectedmsg = "Settings have been updated successfully";
			  String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
			  Assert.assertEquals(actualmsg, expectedmsg);
			  driver.findElement(By.id("ctl00_lblLogOut")).click();
			String url1 = "http://172.20.22.81/omniPcxRecord/default.aspx";
			driver.get(url1);
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			String expectedurl2="http://172.20.22.81/OmniPCXRECORD/default.aspx";
			String actualurl2=driver.getCurrentUrl();
			System.out.println("Actual Url:"+actualurl2);
			System.out.println("Expected Url:"+expectedurl2);
			String actualurl3="http://172.20.22.81/OmniPCXRECORD/default.aspx";
			String expectedurl3= driver.getCurrentUrl();
			Assert.assertNotEquals(actualurl3,expectedurl3);
			}
			
			
			
			
			// Reset the authentication type to OmniPCX RECORD
			@Test(priority=22)
			public void ResetAuthenticationType3() throws InterruptedException {
			String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
				driver.get(url);
				driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
				Thread.sleep(5000);
			String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
				driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
				driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
				Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
				dropdown.selectByVisibleText("OmniPCX RECORD");
				driver.findElement(By.id("btnUpdateAuthSettings")).click();
				Thread.sleep(5000);
				String expectedmsg = "Settings have been updated successfully";
				String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
				Assert.assertEquals(actualmsg, expectedmsg);
				driver.findElement(By.id("ctl00_lblLogOut")).click();
			}
			
			
			
			
			//Test ID 02-22
				//To verify that Active Directory User should be able to login into Server after changing Authentication Type to Active Directory

			@Test(priority=23)
			public void ServerADUserAbleToLoginWhenADAuthenticationIsSet() throws InterruptedException{
			String url="http://172.20.22.81/omniPcxRecord/Default.aspx";
				driver.get(url);
				driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
				Thread.sleep(5000);
			String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
			String actualurl=driver.getCurrentUrl();
			System.out.println("Actual Url:"+actualurl);
			System.out.println("Expected Url:"+expectedurl);
				driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
				driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
				driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
				Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
				dropdown.selectByVisibleText("Active Directory");
				driver.findElement(By.id("txtADDomainName")).sendKeys("ghostsoftware.local");
				driver.findElement(By.id("txtADUsername")).sendKeys("ahsan.rehman");
				driver.findElement(By.id("txtADPassword")).sendKeys("Abc123*");
				driver.findElement(By.id("rbADCriteriaAll")).click();
				driver.findElement(By.id("btnUpdateAuthSettings")).click();
				Thread.sleep(5000);
				String expectedmsg = "Settings have been updated successfully";
				String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
				Assert.assertEquals(actualmsg, expectedmsg);
				driver.findElement(By.id("ctl00_lblLogOut")).click();
				String url1 = "http://172.20.22.81/omniPcxRecord/default.aspx";
				driver.get(url1);
				driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
				Thread.sleep(5000);
			String expectedurl1="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
			String actualurl1=driver.getCurrentUrl();
			System.out.println("Actual Url:"+actualurl1);
			System.out.println("Expected Url:"+expectedurl1);
				driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("ahsan.rehman");
				driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("Abc123*");
				driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
				Thread.sleep(1000);
				String expectedurl2="http://172.20.22.81/OmniPCXRECORD/default.aspx";
				String actualurl2=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl2);
				System.out.println("Expected Url:"+expectedurl2);
				String actualurl3="http://172.20.22.81/OmniPCXRECORD/default.aspx";
				String expectedurl3= driver.getCurrentUrl();
				Assert.assertNotEquals(actualurl3,expectedurl3);
			}
			
			
			
			
			//Test ID 02-23
			// To verify that Super Admin should be able to login into Server Administration after changing Authentication Type to Radius Server


		@Test(priority=24)
		public void OPRSUAableToLoginWhenRadiusAuthenticationIsSet() throws InterruptedException {
		String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
		driver.get(url);
		driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
		Thread.sleep(5000);
		String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
		String actualurl=driver.getCurrentUrl();
		System.out.println("Actual Url:"+actualurl);
		System.out.println("Expected Url:"+expectedurl);
		driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
		Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
		  dropdown.selectByVisibleText("Radius Server");
		  driver.findElement(By.id("txtRadiusServerIP")).sendKeys("172.20.30.100");
		  driver.findElement(By.id("txtRadiusSecretKey")).sendKeys("public");
		  driver.findElement(By.id("btnUpdateAuthSettings")).click();
		  Thread.sleep(5000);
		  String expectedmsg = "Settings have been updated successfully";
		  String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
		  Assert.assertEquals(actualmsg, expectedmsg);
		  driver.findElement(By.id("ctl00_lblLogOut")).click();
		String url1 = "http://172.20.22.81/omniPcxRecord/default.aspx";
		driver.get(url1);
		driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
		Thread.sleep(5000);
		String expectedurl1="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
		String actualurl1=driver.getCurrentUrl();
		System.out.println("Actual Url:"+actualurl1);
		System.out.println("Expected Url:"+expectedurl1);
		driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		Thread.sleep(1000);
		String expectedurl2="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
		String actualurl2=driver.getCurrentUrl();
		System.out.println("Actual Url:"+actualurl2);
		System.out.println("Expected Url:"+expectedurl2);
		String actualurl3="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
		String expectedurl3= driver.getCurrentUrl();
		Assert.assertNotEquals(actualurl3,expectedurl3);
		}

		
		
		
		// Test 02-24
			//To verify that Super Admin should be able to login into Site Administration after changing Authentication Type to Radius Server
			//Note: Radius authentication is already set in the case 02-23 so I skip the authentication part

		@Test(priority=25)
		public void OPRSUAableToLoginSiteWhenRadiusAuthenticationIsSet() throws InterruptedException {
		String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
		driver.get(url);
		driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		String actualurl="http://172.20.22.81/OmniPCXRECORD/default.aspx";
		String expectedurl= driver.getCurrentUrl();
		Assert.assertNotEquals(actualurl,expectedurl);
		}
		
		
		
		
		//Test ID 02-25
			//To verify that Radius server User should be able to login into Site after changing Authentication Type to Radius Server
			//Note: Radius authentication is already set in the case 02-23 so I skip the authentication part

		@Test(priority=26)
		public void RadiusUserAbleToLoginSiteWhenRadiusAuthenticationIsSet() throws InterruptedException {
		String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
		driver.get(url);
		driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("ali");
		driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("password");
		driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		String actualurl="http://172.20.22.81/OmniPCXRECORD/default.aspx";
		String expectedurl= driver.getCurrentUrl();
		Assert.assertNotEquals(actualurl,expectedurl);
		}		
		
		
		
		
		//Test ID 02-26
			////To verify that Radius server User should be able to login into Server administration after changing Authentication Type to Radius Server
		//Note: Radius authentication is already set in the case 02-23 so I skip the authentication part
		
		@Test(priority=27)
		public void RadiusUserAbleToLoginServerWhenRadiusAuthenticationIsSet() throws InterruptedException {
		String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
		driver.get(url);
		driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
		Thread.sleep(5000);
		String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
		String actualurl=driver.getCurrentUrl();
		System.out.println("Actual Url:"+actualurl);
		System.out.println("Expected Url:"+expectedurl);
		driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("ali");
		driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("password");
		driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		Thread.sleep(1000);
		String actualurl1="http://172.20.22.81/OmniPCXRECORD/default.aspx";
		String expectedurl1= driver.getCurrentUrl();
		Assert.assertNotEquals(actualurl1,expectedurl1);
		}
		
		
		
		
		//Test ID 02-27
			//To verify that AD agent is not able to login to Site after changing authentication Type other than active directory i.e. OmniPCX Record or Radius Server

		@Test(priority=28)
		public void ADAgentNotAbleToLoginWhenOPRAuthenticationIsSet() throws InterruptedException {
		String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
			driver.get(url);
			driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
			Thread.sleep(5000);
		String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
			String actualurl=driver.getCurrentUrl();
			System.out.println("Actual Url:"+actualurl);
			System.out.println("Expected Url:"+expectedurl);
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
			Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
			dropdown.selectByVisibleText("OmniPCX RECORD");
			driver.findElement(By.id("btnUpdateAuthSettings")).click();
			Thread.sleep(5000);
			String expectedmsg = "Settings have been updated successfully";
			String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);
			driver.findElement(By.id("ctl00_lblLogOut")).click();
			String url1 = "http://172.20.22.81/omniPcxRecord/default.aspx";
			driver.get(url1);
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("ahsan.rehman");
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("Abc123*");
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			String expectedmsg1 = "Invalid username or password";
			String actualmsg1 = driver.findElement(By.id("Ctrl_Login1_lblMessage")).getText();
			Assert.assertEquals(actualmsg1, expectedmsg1);
		}
		
		
		
		//Test ID 02-28
		//To verify that AD Group Admin is not able to login to Site after changing authentication Type other than active directory i.e. OmniPCX Record or Radius Server

	@Test(priority=29)
	public void ADGroupAdminNotAbleToLoginWhenOPRAuthenticationIsSet() throws InterruptedException {
	String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
		driver.get(url);
		driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
		Thread.sleep(5000);
	String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
		String actualurl=driver.getCurrentUrl();
		System.out.println("Actual Url:"+actualurl);
		System.out.println("Expected Url:"+expectedurl);
		driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
		Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
		dropdown.selectByVisibleText("OmniPCX RECORD");
		driver.findElement(By.id("btnUpdateAuthSettings")).click();
		Thread.sleep(5000);
		String expectedmsg = "Settings have been updated successfully";
		String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
		Assert.assertEquals(actualmsg, expectedmsg);
		driver.findElement(By.id("ctl00_lblLogOut")).click();
		String url1 = "http://172.20.22.81/omniPcxRecord/default.aspx";
		driver.get(url1);
		driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("adnan.akhtar");
		driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("Abc1234*");
		driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		Thread.sleep(1000);
		String expectedmsg1 = "Invalid username or password";
		String actualmsg1 = driver.findElement(By.id("Ctrl_Login1_lblMessage")).getText();
		Assert.assertEquals(actualmsg1, expectedmsg1);
	}
		
	
	
	
	//Test ID 02-29
	//To verify that AD Configuration Manager is not able to login to Site after changing authentication Type other than active directory i.e. OmniPCX Record or Radius Server

@Test(priority=30)
public void ADCMNotAbleToLoginWhenOPRAuthenticationIsSet() throws InterruptedException {
String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
	driver.get(url);
	driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
	Thread.sleep(5000);
String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
	String actualurl=driver.getCurrentUrl();
	System.out.println("Actual Url:"+actualurl);
	System.out.println("Expected Url:"+expectedurl);
	driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
	Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
	dropdown.selectByVisibleText("OmniPCX RECORD");
	driver.findElement(By.id("btnUpdateAuthSettings")).click();
	Thread.sleep(5000);
	String expectedmsg = "Settings have been updated successfully";
	String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
	Assert.assertEquals(actualmsg, expectedmsg);
	driver.findElement(By.id("ctl00_lblLogOut")).click();
	String url1 = "http://172.20.22.81/omniPcxRecord/default.aspx";
	driver.get(url1);
	driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
	driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("muhammad.haris");
	driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("Abc123*");
	driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
	Thread.sleep(1000);
	String expectedmsg1 = "Invalid username or password";
	String actualmsg1 = driver.findElement(By.id("Ctrl_Login1_lblMessage")).getText();
	Assert.assertEquals(actualmsg1, expectedmsg1);
}

	
	
	
	//Test ID 02-30
		//To verify that AD user is not able to login to Server after changing authentication Type other than active directory i.e. OmniPCX Record or Radius Server

@Test(priority=31)
public void ADUserNotAbleToLoginServerWhenOPRAuthenticationIsSet() throws InterruptedException {
String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
	driver.get(url);
	driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
	Thread.sleep(5000);
String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
	String actualurl=driver.getCurrentUrl();
	System.out.println("Actual Url:"+actualurl);
	System.out.println("Expected Url:"+expectedurl);
	driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
	driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
	driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
	Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
	dropdown.selectByVisibleText("OmniPCX RECORD");
	driver.findElement(By.id("btnUpdateAuthSettings")).click();
	Thread.sleep(5000);
	String expectedmsg = "Settings have been updated successfully";
	String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
	Assert.assertEquals(actualmsg, expectedmsg);
	driver.findElement(By.id("ctl00_lblLogOut")).click();
	String url1 = "http://172.20.22.81/omniPcxRecord/default.aspx";
	driver.get(url1);
	driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
	Thread.sleep(5000);
String expectedurl1="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
	String actualurl1=driver.getCurrentUrl();
	System.out.println("Actual Url:"+actualurl1);
	System.out.println("Expected Url:"+expectedurl1);
	driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("ahsan.rehman");
	driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("Abc123*");
	driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	Thread.sleep(1000);
	String expectedmsg1 = "Invalid username or password";
	String actualmsg1 = driver.findElement(By.id("ctrl_TenantAdmin1_lblMessage")).getText();
	Assert.assertEquals(actualmsg1, expectedmsg1);
}

	
	
		//Test ID 02-31
			// To verify that Radius user is able to login to Server after changing authentication Type to OmniPCX Record
			// Note: OmniPCX RECORD authentication is already set in case 02-30 so I skip the authentication part
			// Radius server user is treated as normal user after changing the authentication type from Radius to OmniPCX record. I am passing the password which is being used at the time of creating the user

	@Test(priority=32)
	public void RadiusUserAbleToLoginServerWhenOPRAuthenticationIsSet() throws InterruptedException {
	String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
	driver.get(url);
	driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
	Thread.sleep(5000);
	String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
	String actualurl=driver.getCurrentUrl();
	System.out.println("Actual Url:"+actualurl);
	System.out.println("Expected Url:"+expectedurl);
	driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("ali");
	driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567aa");
	driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
	Thread.sleep(1000);
	String actualurl1="http://172.20.22.81/OmniPCXRECORD/default.aspx";
	String expectedurl1= driver.getCurrentUrl();
	Assert.assertNotEquals(actualurl1,expectedurl1);
	}
	
	
	
	
		//Test ID 02-32
			//To verify that Radius server agent is able to login to Site after changing authentication Type to OmniPCX Record
			// Note: OmniPCX RECORD authentication is already set in case 02-30 so I skip the authentication part
			// Radius server user is treated as normal user after changing the authentication type from Radius to OmniPCX record. I am passing the password which is being used at the time of creating the user
	
	@Test(priority=33)
	public void RadiusUserAbleToLoginSiteWhenOPRAuthenticationIsSet() throws InterruptedException {
	String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
		driver.get(url);
		driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("ali");
		driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567aa");
		driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		Thread.sleep(1000);
		String actualurl1="http://172.20.22.81/OmniPCXRECORD/default.aspx";
		String expectedurl1= driver.getCurrentUrl();
		Assert.assertNotEquals(actualurl1,expectedurl1);
	}
	
	
	
		// Test ID 02-35
			// To verify that Super Admin should be able to login into Server Administration after changing Authentication Type to Mix Mode (OmniPCX Record - Active Directory) when Authentication type is set to OmniPCX Record from down list at login page


		@Test(priority=34)
		public void SUAbleToLoginServerAdministrationWhenMixModeAuthenticationIsSet() throws InterruptedException {
		String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
		driver.get(url);
		driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
		Thread.sleep(5000);
		String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
		String actualurl=driver.getCurrentUrl();
		System.out.println("Actual Url:"+actualurl);
		System.out.println("Expected Url:"+expectedurl);
		driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
		Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
		  dropdown.selectByVisibleText("Mix Mode (OmniPCX RECORD - Active Directory)");
		  driver.findElement(By.id("txtADDomainName")).sendKeys("ghostsoftware.local");
		  driver.findElement(By.id("txtADUsername")).sendKeys("ahsan.rehman");
		  driver.findElement(By.id("txtADPassword")).sendKeys("Abc123*");
		  driver.findElement(By.id("rbADCriteriaAll")).click();
		  driver.findElement(By.id("btnUpdateAuthSettings")).click();
		  Thread.sleep(5000);
		  String expectedmsg = "Settings have been updated successfully";
		  String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
		  Assert.assertEquals(actualmsg, expectedmsg);
		  driver.findElement(By.id("ctl00_lblLogOut")).click();
		String url1 = "http://172.20.22.81/omniPcxRecord/default.aspx";
		driver.get(url1);
		driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
		Thread.sleep(5000);
		String expectedurl1="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
		String actualurl1=driver.getCurrentUrl();
		System.out.println("Actual Url:"+actualurl1);
		System.out.println("Expected Url:"+expectedurl1);
		driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		Select dropdown1 = new Select(driver.findElement(By.id("ctrl_TenantAdmin1_drpAuthType")));
		dropdown1.selectByVisibleText("OmniPCX RECORD");
		driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		String expectedurl2="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
		String actualurl2=driver.getCurrentUrl();
		System.out.println("Actual Url:"+actualurl2);
		System.out.println("Expected Url:"+expectedurl2);
		String actualurl3="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
		String expectedurl3= driver.getCurrentUrl();
		Assert.assertNotEquals(actualurl3,expectedurl3);
		}

		
		
		
		//Test ID 02-36
			//To verify that Super Admin should be able to login into Server Administration after changing Authentication Type to Mix Mode (OmniPCX Record - Active Directory) when Authentication type is set to Active Directory from down list at login page
			// Note: Mix mode authentication is already set in case 02-35 so I skip the authentication part
			//This is incomplete
	
		@Test(priority=35)
		public void SUAbleToLoginServerBySelectingADFromDropDownWhenMixModeAuthenticationIsSet() throws InterruptedException {
		String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
		driver.get(url);
		driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
		Thread.sleep(5000);
		String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
		String actualurl=driver.getCurrentUrl();
		System.out.println("Actual Url:"+actualurl);
		System.out.println("Expected Url:"+expectedurl);
		driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		driver.findElement(By.xpath("//*[@id=\"ctrl_TenantAdmin1_drpAuthType\"]/option[2]")).click();
		driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		Thread.sleep(1000);
		}
		
		
		
		
		//Test ID 02-37
			//To verify that Super Admin should be able to login into Site Administration after changing Authentication Type to Mix Mode (OmniPCX Record - Active Directory)
			// Note: Mix mode authentication is already set in case 02-35 so I skip the authentication part
		
		@Test(priority=36)
		public void SUAbleToLoginSiteWhenMixModeAuthenticationIsSet() throws InterruptedException {
		String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
			driver.get(url);
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			String actualurl1="http://172.20.22.81/OmniPCXRECORD/default.aspx";
			String expectedurl1= driver.getCurrentUrl();
			Assert.assertNotEquals(actualurl1,expectedurl1);
		}
		
		
		
		
		//Test ID 02-38
			//To verify that Super Admin should be able to login into Site Administration after changing Authentication Type to Mix Mode (OmniPCX Record - Active Directory) when Authentication type is set to Active Directory from down list at login page
			//This is incomplete
		
		@Test(priority=37)
		public void SUAbleToLoginSiteBySelectingADFromDropdownWhenMixModeAuthenticationIsSet() throws InterruptedException {
		String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
			driver.get(url);
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
			driver.findElement(null);
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			String actualurl1="http://172.20.22.81/OmniPCXRECORD/default.aspx";
			String expectedurl1= driver.getCurrentUrl();
			Assert.assertNotEquals(actualurl1,expectedurl1);
		}
		
		
		
		// Reset the authentication type to OmniPCX RECORD
		@Test(priority=38)
		public void ResetAuthenticationType4() throws InterruptedException {
		String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
			driver.get(url);
			driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
			Thread.sleep(5000);
		String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
			String actualurl=driver.getCurrentUrl();
			System.out.println("Actual Url:"+actualurl);
			System.out.println("Expected Url:"+expectedurl);
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
			Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
			dropdown.selectByVisibleText("OmniPCX RECORD");
			driver.findElement(By.id("btnUpdateAuthSettings")).click();
			Thread.sleep(5000);
			String expectedmsg = "Settings have been updated successfully";
			String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);
			driver.findElement(By.id("ctl00_lblLogOut")).click();
		}
		
		
		
		
		
		//TestID 02-39
			//"To verify that error message is displayed after 7 wrong attempts of password at site login
			//Note : This is for all types of users"

		@Test(priority=39)
		public void Verify7AttemptmessageAtSite() throws InterruptedException {
		String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
			driver.get(url);
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567b");
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567b");
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567b");
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567b");
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567b");
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567b");
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567b");
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			String expectedmsg1 = "Your account will be disabled with one more wrong try.";
			String actualmsg1 = driver.findElement(By.id("Ctrl_Login1_lblMessage")).getText();
			Assert.assertEquals(actualmsg1, expectedmsg1);
		}
		
		
		
		
		
		//Test ID 02-40
			//To verify that error message is displayed after 7 wrong attempts of password at server login 
			//Note: This is for all types of users

		@Test(priority=40)
		public void Verify7wrongAttemptmessageAtServer() throws InterruptedException {
		String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
			driver.get(url);
			driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
			Thread.sleep(5000);
		String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
			String actualurl=driver.getCurrentUrl();
			System.out.println("Actual Url:"+actualurl);
			System.out.println("Expected Url:"+expectedurl);
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567b");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).clear();
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).clear();
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567b");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).clear();
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).clear();
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567b");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).clear();
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).clear();
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567b");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).clear();
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).clear();
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567b");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).clear();
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).clear();
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567b");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).clear();
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).clear();
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567b");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			Thread.sleep(1000);
			String expectedmsg1 = "Your account will be disabled with one more wrong try.";
			String actualmsg1 = driver.findElement(By.id("ctrl_TenantAdmin1_lblMessage")).getText();
			Assert.assertEquals(actualmsg1, expectedmsg1);
		}
		
		
		
		
		//Test ID 02-41
			//To verify that error message is displayed after 8 wrong attempts of password at site login and user gets disabled
			//Note: This is for all types of users
		
		@Test(priority=41)
		public void SiteUserDisabled() throws InterruptedException {
		String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
			driver.get(url);
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("ehunt");
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567b");
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("ehunt");
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567b");
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("ehunt");
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567b");
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("ehunt");
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567b");
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("ehunt");
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567b");
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("ehunt");
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567b");
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("ehunt");
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567b");
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("ehunt");
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).clear();
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567b");
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			String expectedmsg1 = "Your account has been disabled, please contact your system administrator.";
			String actualmsg1 = driver.findElement(By.id("Ctrl_Login1_lblMessage")).getText();
			Assert.assertEquals(actualmsg1, expectedmsg1);
		}
		

		// Enable the user which got disabled in case 02-41
		//This is incomplete
		@Test(priority=42)
		public void Enable_the_user_which_got_disabled_case_02_41() throws InterruptedException {
		String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
			driver.get(url);
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
			driver.findElement(null);
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			String actualurl1="http://172.20.22.81/OmniPCXRECORD/default.aspx";
			String expectedurl1= driver.getCurrentUrl();
			Assert.assertNotEquals(actualurl1,expectedurl1);
			Thread.sleep(1000);
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
			
		}
		
		
		
		//Test ID 02-42
			//To verify that error message is displayed after 8 wrong attempts of password at server login and user gets disabled
			//Note: This is for all types of users

		@Test(priority=43)
		public void Verify7AttemptmessageAtServer() throws InterruptedException {
			String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
				driver.get(url);
				driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
				Thread.sleep(5000);
			String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
				String actualurl=driver.getCurrentUrl();
				System.out.println("Actual Url:"+actualurl);
				System.out.println("Expected Url:"+expectedurl);
				driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("albert");
				driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567c");
				driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).clear();
				driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("albert");
				driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).clear();
				driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567c");
				driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).clear();
				driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("albert");
				driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).clear();
				driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567c");
				driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).clear();
				driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("albert");
				driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).clear();
				driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567c");
				driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).clear();
				driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("albert");
				driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).clear();
				driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567c");
				driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).clear();
				driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("albert");
				driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).clear();
				driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567c");
				driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).clear();
				driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("albert");
				driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).clear();
				driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567c");
				driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).clear();
				driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("albert");
				driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).clear();
				driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567c");
				driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
				Thread.sleep(1000);
				String expectedmsg1 = "Your account has been disabled, please contact your system administrator.";
				String actualmsg1 = driver.findElement(By.id("ctrl_TenantAdmin1_lblMessage")).getText();
				Assert.assertEquals(actualmsg1, expectedmsg1);
		}
		
		
		
		
			// Enable the user which got disabled in case 02-42
				//This is incomplete
					@Test(priority=44)
					public void Enable_the_user_which_got_disabled_case_02_42() throws InterruptedException {
					String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
						driver.get(url);
						driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
						Thread.sleep(1000);
						driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
						Thread.sleep(5000);
					String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
						String actualurl=driver.getCurrentUrl();
						System.out.println("Actual Url:"+actualurl);
						System.out.println("Expected Url:"+expectedurl);
						driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
						driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
						driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
						Thread.sleep(1000);
						driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
						}
					
					
					
					
			//Test ID 02-43
				//To verify that server admin lands on change password page after first login

					@Test(priority=45)
					public void SUServerlandsOnChangePasswordPage() throws InterruptedException {
					String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
						driver.get(url);
						driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
						Thread.sleep(1000);
						driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
						Thread.sleep(5000);
					String expectedurl="http://172.20.22.81/OmniPCXRECORD/TenantAdmin.aspx";
						String actualurl=driver.getCurrentUrl();
						System.out.println("Actual Url:"+actualurl);
						System.out.println("Expected Url:"+expectedurl);
						driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("adnan");
						driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
						driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
						Thread.sleep(1000);
						String actualurl1="http://172.20.22.81/OmniPCXRECORD/ChangePassword.aspx";
						String expectedurl1= driver.getCurrentUrl();
						Assert.assertEquals(actualurl1,expectedurl1);
						}	
				
					
					
					
					//Test ID 02-44 is duplicated
					
					//Test ID 02-45
						//To verify that Site admin lands on change password page after first login

					@Test(priority=46)
					public void SUSitelandsOnChangePasswordPage() throws InterruptedException {
					String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
						driver.get(url);
						driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
						driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("su");
						driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
						
						driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
						Thread.sleep(1000);
						String actualurl1="http://172.20.22.81/OmniPCXRECORD/ChangePassword.aspx";
						String expectedurl1= driver.getCurrentUrl();
						Assert.assertEquals(actualurl1,expectedurl1);
						Thread.sleep(1000);
					}
					
					
					
					
					//Test ID 02-46
						//To verify that Site agent lands on change password page after first login

					@Test(priority=47)
					public void SiteAgentlandsOnChangePasswordPage() throws InterruptedException {
					String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
						driver.get(url);
						driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
						driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("agent");
						driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
						
						driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
						Thread.sleep(1000);
						String actualurl1="http://172.20.22.81/OmniPCXRECORD/ChangePassword.aspx";
						String expectedurl1= driver.getCurrentUrl();
						Assert.assertEquals(actualurl1,expectedurl1);
						Thread.sleep(1000);
					}
					
					
					
					
					//Test ID 02-47
						//To verify that Site Group Admin lands on change password page after first login

					@Test(priority=48)
					public void SiteGroupAdminlandsOnChangePasswordPage() throws InterruptedException {
					String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
						driver.get(url);
						driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
						driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("gadmin");
						driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
						
						driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
						Thread.sleep(1000);
						String actualurl1="http://172.20.22.81/OmniPCXRECORD/ChangePassword.aspx";
						String expectedurl1= driver.getCurrentUrl();
						Assert.assertEquals(actualurl1,expectedurl1);
						Thread.sleep(1000);
					}
					
					
					
					
					//Test ID 02-48
						//To verify that Site Configuration Manager lands on change password page after first login

					@Test(priority=49)
					public void SiteConfigManagerlandsOnChangePasswordPage() throws InterruptedException {
					String url = "http://172.20.22.81/omniPcxRecord/default.aspx";
						driver.get(url);
						driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
						driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("configmanager");
						driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
						
						driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
						Thread.sleep(1000);
						String actualurl1="http://172.20.22.81/OmniPCXRECORD/ChangePassword.aspx";
						String expectedurl1= driver.getCurrentUrl();
						Assert.assertEquals(actualurl1,expectedurl1);
						Thread.sleep(1000);
					}
					
					
					
					// Test ID 02-49 and 02-50 are duplicated
					
					
					
					// Skip Test ID 02-51,52,53,54,55,56,57,58,59,60,,61
				
					
					// Skip Test ID 62,63,64,65,66,67 are not automated
					// Test ID 02-68,69,70 are incorrect. Asked Ahsan about them
							
					
	@AfterTest
	public void tearDownTest() throws InterruptedException {
				
		System.out.println("Test Completed Successfully");
	}
	

	

}
