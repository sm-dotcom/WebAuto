package SheetSpecifics;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import java.util.List;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class Active_Directory_Mix_Mode {
	
	WebDriver driver = null;
	//WebDriverWait wait = new WebDriverWait(driver, 15);
	public String siteUrl = "http://172.20.22.81/OmniPCXRECORD/default.aspx";
	public String ExpectedSiteURL = "http://172.20.22.81/OmniPCXRECORD/default.aspx";
	public String ExpectedServerURL = "http://172.20.22.81/OmniPCXRECORD/default.aspx";
	@BeforeTest
	public void setUpTest() {
		
		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrator\\Desktop\\FilesToSetup\\geckodriver.exe");
	     driver=new FirefoxDriver();
	}


	//Test ID 07-01
			//Set active directory authentication with default criteria will not work
			//in our environment as we have our AD users in specific containers
	
	//Test ID 07-04
			//Set active directory with Include all Containers

	@Test(priority=0)
	public void SetADAuthentication() throws InterruptedException {
		System.out.println("SetADAuthentication");
			driver.get(siteUrl);
		//Click on switch role
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
		//Click on login button	
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")));
			String actualurl1="siteUrl";
			String expectedurl1= driver.getCurrentUrl();
			Assert.assertNotEquals(actualurl1,expectedurl1);
		//Click on System page
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
		//Click on the Authentication dropdown	
			Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
		//Select Active Directory	
			dropdown.selectByVisibleText("Active Directory");
			driver.findElement(By.id("txtADDomainName")).clear();
		//Enter Domain Name	
			driver.findElement(By.id("txtADDomainName")).sendKeys("ghostsoftware.local");
			driver.findElement(By.id("txtADUsername")).clear();
		//Enter AD Username
			driver.findElement(By.id("txtADUsername")).sendKeys("ahsan.rehman");
			driver.findElement(By.id("txtADPassword")).clear();
		//Enter the Password of AD user
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
			System.out.println("Expected Message : "+expectedmsg);
			System.out.println("Actual Message : " +actualmsg);
		}






		//Test ID 07-02
		//Add active directory authentication user on server administration

	@Test(priority=1)
	public void AddADAuthenticationUser() throws InterruptedException {
		System.out.println("AddADAuthenticationUser");
			driver.get(siteUrl);
		//Click on switch role
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
			String expectedurl="ExpectedSiteURL";
			String actualurl=driver.getCurrentUrl();
			System.out.println("Actual Url:"+actualurl);
			System.out.println("Expected Url:"+expectedurl);
		//Enter Username	
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		//Enter Password
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		//Click on login button
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")));
			String actualurl1="siteUrl";
			String expectedurl1= driver.getCurrentUrl();
			Assert.assertNotEquals(actualurl1,expectedurl1);
		//Click on Users tab from left panel
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
		//Click on Add active directory user
			driver.findElement(By.id("lnkAddADUser")).click();
		//Search user Muhammad Haris
			driver.findElement(By.xpath("//*[@id=\"gvADUsers_filter\"]/label/input")).sendKeys("Muhammad Haris");
		//Select Muhammad Haris user
			driver.findElement(By.xpath("//*[@id=\"gvADUsers\"]/tbody/tr/td[3]/img")).click();
			Thread.sleep(2000);
		//Enter email address
			driver.findElement(By.xpath("//*[@id=\"divNewAgent1\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input")).sendKeys("muhammad.haris@amigo-software.com");
		//Enable account
			driver.findElement(By.xpath("//*[@id=\"divNewAgent1\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input")).click();
		//Select security group
			driver.findElement(By.xpath("//*[@id=\"divSecurityGroup\"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option")).click();
		//Move security group to assigned section
			driver.findElement(By.xpath("//*[@id=\"divSecurityGroup\"]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();
		//Click on save button
			driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder\"]/table/tbody/tr[5]/td/input[1]")).click();
		//Verify the message
			String expectedmsg = "Settings have been saved successfully";
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-alertMessage")));
			String actualmsg = driver.findElement(By.id("dialog-alertMessage")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);
			System.out.println("Expected Message : "+expectedmsg);
			System.out.println("Actual Message : " +actualmsg);
	}





	//Test ID 07-02-01
			//Add active directory authentication agent on site administration

	@Test(priority=2)
	public void AddADAuthenticationAgent() throws InterruptedException {
		System.out.println("AddADAuthenticationAgent");
			driver.get(siteUrl);
		//Enter Site code	
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username	
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		//Enter Password	
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		//Click on login button	
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
			String actualurl="siteUrl";
			String expectedurl= driver.getCurrentUrl();
			Assert.assertNotEquals(actualurl,expectedurl);
		 //Click on Agent tab from left panel
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();	
		 //Click on add active directory agent
			driver.findElement(By.id("linkAddActiveDirectoryAgent")).click();
		 //Search Tanveer Ahmad
			driver.findElement(By.xpath("//*[@id=\"gvADUsers_filter\"]/label/input")).sendKeys("Tanveer Ahmad");
		 //Select Tanveer Ahmad
			driver.findElement(By.xpath("//*[@id=\"gvADUsers\"]/tbody/tr/td[3]/img")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbEmail")));
		 //Enter email
			driver.findElement(By.id("tbEmail")).sendKeys("tanveer.ahmad@amigo-software.com");
		 //Enable the account
			driver.findElement(By.id("cbEnableAccount")).click();
		 //Select extension
			driver.findElement(By.xpath("//*[@id=\"ddlExtensionLeft\"]/option[1]")).click();
		 //Move the extension to assigned section
			driver.findElement(By.id("btnExtensionFromLeftToRight")).click();
		 //Select team
			driver.findElement(By.xpath("//*[@id=\"ddlTeamLeft\"]/option[1]")).click();
		 //Move the team to assigned section
			driver.findElement(By.id("btnTeamFromLeftToRight")).click();
		 //Select security group
			driver.findElement(By.xpath("//*[@id=\"ddlSGLeft\"]/option[3]")).click();
		 //Move the security group to assigned section
			driver.findElement(By.id("btnSGFromLeftToRight")).click();
		 //Click save
			driver.findElement(By.id("btnSave")).click();
		 //Click cancel on the new window of adding rules against agent
			driver.findElement(By.xpath("//*[@id=\"btnCancel\"]/span")).click();
		 
			String expectedurl2 = "http://localhost/OmniPCXRECORD/SiteAgents.aspx";
			String actualurl2=driver.getCurrentUrl();
			Assert.assertEquals(actualurl2,expectedurl2);
			
			System.out.println("Expected URL : "+expectedurl2);
			System.out.println("Actual URL : " +actualurl2);
		}
		
		
		
		
	
		//Test ID 07-03-01
			//Login with server user created in 07-02
		
	@Test(priority=3)
	public void LoginServerAdministrationWithUser() throws InterruptedException {
		System.out.println("LoginServerAdministrationWithUser");
			driver.get(siteUrl);
		//Click on switch role	
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
			String expectedurl="ExpectedSiteURL";
			String actualurl=driver.getCurrentUrl();
			System.out.println("Actual Url:"+actualurl);
			System.out.println("Expected Url:"+expectedurl);
		//Enter Username	
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("muhammad.haris");
		//Enter Password	
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("Abc123*");
		//Click on Login button	
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			Thread.sleep(1000);
			String actualurl1="ExpectedServerURL";
			String expectedurl1= driver.getCurrentUrl();
			Assert.assertNotEquals(actualurl1,expectedurl1);
			System.out.println("Expected URL : "+expectedurl1);
			System.out.println("Actual URL : " +actualurl1);
		}
		
		
		
		
		
		//Test ID 07-03-02
		//Login with site agent created in 07-02-01
		
	@Test(priority=4)
	public void LoginSiteWithADAuthenticationAgent() throws InterruptedException {
		System.out.println("LoginSiteWithADAuthenticationAgent");
			driver.get(siteUrl);
		//Enter Site code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username	
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("tanveer.ahmad");
		//Enter Password	
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("Abc123*");
		//Click on Login button	
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			String actualurl="siteUrl";
			String expectedurl= driver.getCurrentUrl();
			Assert.assertNotEquals(actualurl,expectedurl);
			System.out.println("Expected URL : "+expectedurl);
			System.out.println("Actual URL : " +actualurl);
		}
			
			
			
			
			
		//Test ID 07-05 is covered in 07-02 and 07-02-01
		//Test ID 07-06 is covered in 07-03-01 and 07-03-02
		
		
		//Test ID 07-07 
			//Set active directory authentication with specific container
		
	@Test(priority=5)
	public void SetADAuthenticationWithSpecificContainer() throws InterruptedException {
		System.out.println("SetADAuthenticationWithSpecificContainer");	
			driver.get(siteUrl);
		//Click on switch role
			driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_lblServerAdministration")));
		//Click on Server Administration	
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
		//Click system tab
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
		//Click on the Authentication dropdown
			Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
		//Select Active Directory	
			dropdown.selectByVisibleText("Active Directory");
			driver.findElement(By.id("txtADDomainName")).clear();
		//Enter domain name	
			driver.findElement(By.id("txtADDomainName")).sendKeys("ghostsoftware.local");	
			driver.findElement(By.id("txtADUsername")).clear();
		//Enter Username	
			driver.findElement(By.id("txtADUsername")).sendKeys("ahsan.rehman");
			driver.findElement(By.id("txtADPassword")).clear();
		//Enter password	
			driver.findElement(By.id("txtADPassword")).sendKeys("Abc123*");  
		//Select specific container criteria
			driver.findElement(By.id("rbADCriteriaSpecfic")).click();
		//Choose container
			driver.findElement(By.id("imgSpecificContainer")).click();
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("j1_2_anchor")));
		//Select specific container (OU=Amigo-A2)
			driver.findElement(By.id("j1_2_anchor")).click();
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("ADPopUpSelect")));
		//Click on select button
			driver.findElement(By.id("ADPopUpSelect")).click(); 
		//Select the checkbox of include all sub containers
			driver.findElement(By.id("EnableContainerUser")).click();
		//Click on update
			driver.findElement(By.id("btnUpdateAuthSettings")).click();
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
		//Verify message
			String expectedmsg = "Settings have been updated successfully";
		//Wait for the browser to respond
			WebDriverWait wait6 = new WebDriverWait(driver,30);
			WebElement btnMain6;
			btnMain6= wait6.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
			String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
			Thread.sleep(2000);
			Assert.assertEquals(actualmsg, expectedmsg);
			System.out.println("Expected Message : "+expectedmsg);
			System.out.println("Actual Message : " +actualmsg);
		}
		
		
		
		
		
		//Test ID 07-08 is covered in 07-02 and 07-02-01
		
		//Test ID 07-09-01
		//Login with server user created in 07-02
	
	@Test(priority=6)
	public void LoginServerAdministrationWithUser1() throws InterruptedException {
		System.out.println("LoginServerAdministrationWithUser1");
			driver.get(siteUrl);
		//Click on switch role
			driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_lblServerAdministration")));
		//Click on Server Administration	
			driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctrl_TenantAdmin1_txtUserName")));
			String expectedurl="ExpectedSiteURL";
			String actualurl=driver.getCurrentUrl();
			System.out.println("Actual Url:"+actualurl);
			System.out.println("Expected Url:"+expectedurl);
		//Enter Username
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("muhammad.haris");
		//Enter Password	
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("Abc123*");
		//Click on Login button
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			Thread.sleep(1000);
			String expectedurl1="ExpectedServerURL";
			String actualurl1= driver.getCurrentUrl();
			Assert.assertNotEquals(actualurl1,expectedurl1);
			System.out.println("Expected URL : "+expectedurl);
			System.out.println("Actual URL : " +actualurl);
	}
		
		
		
		
	
		
		
	//Test ID 07-09-02
		//Login with site agent created in 07-02-01
	
	//Login with site agent created in 07-02-01
	
	@Test(priority=7)
	public void LoginADAuthenticationAgent() throws InterruptedException {
		System.out.println("LoginADAuthenticationAgent");
			driver.get(siteUrl);
		//Enter Site code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username	
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("tanveer.ahmad");
		//Enter Password	
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("Abc123*");
		//Click on Login button	
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			String actualurl="siteUrl";
			String expectedurl= driver.getCurrentUrl();
			Assert.assertNotEquals(actualurl,expectedurl);
			System.out.println("Expected URL : "+expectedurl);
			System.out.println("Actual URL : " +actualurl);
			}
			
			
			
			
			
			
		//Test ID 07-10 and 07-11 is not automated as it is related to make active directory server unavailable
		
		
		
		
		
		//Test ID 07-15
			//Set mix mode authentication with include all containers
		
	@Test(priority=8)
	public void SetMixModeAuthenticationWithAllContainers() throws InterruptedException {
		System.out.println("SetMixModeAuthenticationWithAllContainers");
			driver.get(siteUrl);
		//Click on switch role	
			driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_lblServerAdministration")));
		//Click on Server Administration	
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
		//Click on system tab and configure mix mode authentication
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
		//Click on Authentication dropdown
			Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
		//Select mix mode	
			dropdown.selectByVisibleText("Mix Mode (OmniPCX RECORD - Active Directory)");  
			driver.findElement(By.id("txtADDomainName")).clear();
		//Enter domain name	  
			driver.findElement(By.id("txtADDomainName")).sendKeys("ghostsoftware.local");	  
			driver.findElement(By.id("txtADUsername")).clear();
		//Enter Username  
			driver.findElement(By.id("txtADUsername")).sendKeys("ahsan.rehman");
			driver.findElement(By.id("txtADPassword")).clear();
		//Enter Password	  
			driver.findElement(By.id("txtADPassword")).sendKeys("Abc123*");
		//Select include all containers criteria
			driver.findElement(By.id("rbADCriteriaAll")).click();
			driver.findElement(By.id("btnUpdateAuthSettings")).click();
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
		//Verify message
			String expectedmsg = "Settings have been updated successfully";
			Thread.sleep(5000);
			String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
			Thread.sleep(2000);
			Assert.assertEquals(actualmsg, expectedmsg);
			System.out.println("Expected Message : "+expectedmsg);
			System.out.println("Actual Message : " +actualmsg);
		}
		
		
		
		
		
		
		//Test ID 07-16 is covered in 07-02 and 07-02-01
		
		
		//Test ID 07-17 
		//Login with server user created in 07-02
	@Test(priority=9)
	public void LoginServerAdministrationWithUser2() throws InterruptedException {
		System.out.println("LoginServerAdministrationWithUser2");
			driver.get(siteUrl);
		//Click on switch role
			driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_lblServerAdministration")));
		//Click on Server Administration	
			driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctrl_TenantAdmin1_txtUserName")));
			String expectedurl="ExpectedSiteURL";
			String actualurl=driver.getCurrentUrl();
			System.out.println("Actual Url:"+actualurl);
			System.out.println("Expected Url:"+expectedurl);
		//Enter Username
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("muhammad.haris");
		//Enter password
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("Abc123*");
			//Select active directory from dropdown
			Select dropdown1 = new Select(driver.findElement(By.id("ctrl_TenantAdmin1_drpAuthType")));
			dropdown1.selectByVisibleText("Active Directory");
		//Click on login button
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			Thread.sleep(1000);
			String actualurl1="ExpectedServerURL";
			String expectedurl1= driver.getCurrentUrl();
			Assert.assertNotEquals(actualurl1,expectedurl1);
			System.out.println("Expected URL : "+expectedurl1);
			System.out.println("Actual URL : " +actualurl1);
		}
		
		
		
		
		
	
		//Test ID 07-17-01
		//Login with site agent created in 07-02-01
		
	@Test(priority=10)
	public void LoginADAuthenticationAgent1() throws InterruptedException {
		System.out.println("LoginADAuthenticationAgent1");
			driver.get(siteUrl);
		//Enter Site code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");			
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("tanveer.ahmad");
		//Enter password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("Abc123*");	
		//Select active directory from dropdown
			Select dropdown1 = new Select(driver.findElement(By.id("Ctrl_Login1_drpAuthType")));
			dropdown1.selectByVisibleText("Active Directory");
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_imgBtnLogin")));
		//Click on login button					
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(2000);
			String actualurl="siteUrl";
			String expectedurl= driver.getCurrentUrl();
			Assert.assertNotEquals(actualurl,expectedurl);
			System.out.println("Expected URL : "+expectedurl);
			System.out.println("Actual URL : " +actualurl);
			}
			
			
			
			
			
			

			//Test ID 07-18
				//Set mix mode authentication with specific container
			
	@Test(priority=11)
	public void SetADAuthenticationWithSpecificContainer1() throws InterruptedException {
		System.out.println("SetADAuthenticationWithSpecificContainer1");
			driver.get(siteUrl);
		//Click on switch role	
			driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_lblServerAdministration")));
		//Click on Server Administration	
			driver.findElement(By.id("Ctrl_Login1_lblServerAdministration")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctrl_TenantAdmin1_txtUserName")));
			String expectedurl="ExpectedServerURL";
			String actualurl=driver.getCurrentUrl();
			System.out.println("Actual Url:"+actualurl);
			System.out.println("Expected Url:"+expectedurl);
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			Thread.sleep(1000);
			String actualurl1="siteUrl";
			String expectedurl1= driver.getCurrentUrl();
			Assert.assertNotEquals(actualurl1,expectedurl1);
		//Click on system tab and configure mix mode authentication
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
			Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
			dropdown.selectByVisibleText("Mix Mode (OmniPCX RECORD - Active Directory)");
			driver.findElement(By.id("txtADDomainName")).clear();
			driver.findElement(By.id("txtADDomainName")).sendKeys("ghostsoftware.local");
			driver.findElement(By.id("txtADUsername")).clear();
			driver.findElement(By.id("txtADUsername")).sendKeys("ahsan.rehman");
			driver.findElement(By.id("txtADPassword")).clear();
			driver.findElement(By.id("txtADPassword")).sendKeys("Abc123*");	  
		//Select specific container criteria
			driver.findElement(By.id("rbADCriteriaSpecfic")).click();		  
		//Choose container
			driver.findElement(By.id("imgSpecificContainer")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("j1_2_anchor")));
		//Select specific container (OU=Amigo-A2)
			driver.findElement(By.id("j1_2_anchor")).click();
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("ADPopUpSelect"))); 
		//Click on select button
			driver.findElement(By.id("ADPopUpSelect")).click();  
		//Select the checkbox of include all sub containers
			driver.findElement(By.id("EnableContainerUser")).click();
		//Click on update
			driver.findElement(By.id("btnUpdateAuthSettings")).click();
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
		//Verify message
			String expectedmsg = "Settings have been updated successfully";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
			String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
			Thread.sleep(2000);
			Assert.assertEquals(actualmsg, expectedmsg);
			System.out.println("Expected Message : "+expectedmsg);
			System.out.println("Actual Message : " +actualmsg);
			}
			
			
			
			
			
			
			
			
			//Test ID 07-19 is covered in 07-02 and 07-02-01
			
			
			//Test ID 07-20-01
				//Login with server user created in 07-02
	@Test(priority=12)
	public void LoginServerAdministrationWithUser3() throws InterruptedException {
		System.out.println("LoginServerAdministrationWithUser3");
			driver.get(siteUrl);
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
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("muhammad.haris");
		//Enter Password
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("Abc123*");
		//Select active directory from dropdown
			Select dropdown1 = new Select(driver.findElement(By.id("ctrl_TenantAdmin1_drpAuthType")));
			dropdown1.selectByVisibleText("Active Directory");	
		//Click on login button
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
			Thread.sleep(1000);
			String actualurl1="ExpectedServerURL";
			String expectedurl1= driver.getCurrentUrl();
			Assert.assertNotEquals(actualurl1,expectedurl1);
			System.out.println("Expected URL : "+expectedurl1);
			System.out.println("Actual URL : " +actualurl1);
		}
			
		

			
			
			
			
		//Test ID 07-20-02
			//Login with site agent created in 07-02-01
			
	@Test(priority=13)
	public void LoginADAuthenticationAgent2() throws InterruptedException {
		System.out.println("LoginADAuthenticationAgent2");
			driver.get(siteUrl);		
		//Enter Site code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
		//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("tanveer.ahmad");
		//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("Abc123*");
		//Select active directory from dropdown
			Select dropdown1 = new Select(driver.findElement(By.id("Ctrl_Login1_drpAuthType")));
			dropdown1.selectByVisibleText("Active Directory");
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_imgBtnLogin")));
		//Click on login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(2000);
			String actualurl="siteUrl";
			String expectedurl= driver.getCurrentUrl();
			Assert.assertNotEquals(actualurl,expectedurl);
			System.out.println("Expected URL : "+expectedurl);
			System.out.println("Actual URL : " +actualurl);
			}	
			
			
	
		
		
	
		
		//Test ID 07-21
			//Set the active directory authentication with invalid domain name
	@Test(priority=14)
	public void SetADAuthenticationWithInvalidDomainName() throws InterruptedException {
		System.out.println("SetADAuthenticationWithInvalidDomainName");
			driver.get(siteUrl);
		//Click on switch role	
			driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_lblServerAdministration")));
		//Click on Server Administration		
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
		//Click on system tab and configure Active Directory authentication	
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
		//Click on authenticaiton dropdown	
			Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
		//Select Active Directory	
			dropdown.selectByVisibleText("Active Directory");
			driver.findElement(By.id("txtADDomainName")).clear();
		//Enter invalid Domain name	
			driver.findElement(By.id("txtADDomainName")).sendKeys("ghostsoftware.ca");
			driver.findElement(By.id("txtADUsername")).clear();
		//Enter Username	
			driver.findElement(By.id("txtADUsername")).sendKeys("ahsan.rehman");
			driver.findElement(By.id("txtADPassword")).clear();
		//Enter Password		  
			driver.findElement(By.id("txtADPassword")).sendKeys("Abc123*");
		//Select include all containers criteria
			driver.findElement(By.id("rbADCriteriaAll")).click();
		//Click on Update button		  
			driver.findElement(By.id("btnUpdateAuthSettings")).click();
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
			String expectedmsg = "Invalid domain name";
			Thread.sleep(5000);
			String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
			Thread.sleep(2000);
			Assert.assertEquals(actualmsg, expectedmsg);
			System.out.println("Expected Message : "+expectedmsg);
			System.out.println("Actual Message : " +actualmsg);
			}
		
			
			
			
		//Test ID 07-22
			//Set the active directory authentication with invalid username
	@Test(priority=15)
	public void SetADAuthenticationWithInvalidUsername() throws InterruptedException {
		System.out.println("SetADAuthenticationWithInvalidUsername");
			driver.get(siteUrl);
		//Click on switch role		
			driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_lblServerAdministration")));
		//Click on Server Administration		
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
		//Click on System page	
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
		//Click on Authentication dropdown	
			Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
		//Select Active Directory	
			dropdown.selectByVisibleText("Active Directory");
			driver.findElement(By.id("txtADDomainName")).clear();
		//Enter Domain name	
			driver.findElement(By.id("txtADDomainName")).sendKeys("ghostsoftware.local");
			driver.findElement(By.id("txtADUsername")).clear();
		//Enter Invalid Username		  
			driver.findElement(By.id("txtADUsername")).sendKeys("Test");
			driver.findElement(By.id("txtADPassword")).clear();
		//Enter correct Password		  
			driver.findElement(By.id("txtADPassword")).sendKeys("Abc123*");
		//Select include all containers criteria
			driver.findElement(By.id("rbADCriteriaAll")).click();
		//Click on Update button		  
			driver.findElement(By.id("btnUpdateAuthSettings")).click();
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
			String expectedmsg = "Invalid username or password";
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
			String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
			Thread.sleep(2000);
			Assert.assertEquals(actualmsg, expectedmsg);
			System.out.println("Expected Message : "+expectedmsg);
			System.out.println("Actual Message : " +actualmsg);
			}
			
			
			
			
			
			
			
			
		//Test ID 07-23
			//Set the active directory authentication with invalid password
	@Test(priority=16)
	public void SetADAuthenticationWithInvalidPassword() throws InterruptedException {
		System.out.println("SetADAuthenticationWithInvalidPassword");
			driver.get(siteUrl);
		//Click on switch role		
			driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_lblServerAdministration")));
		//Click on Server Administration		
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
		//Click on System tab		
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
		//Click on Authentication dropdown		
			Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
		//Select Active Directory		  
			dropdown.selectByVisibleText("Active Directory");
			driver.findElement(By.id("txtADDomainName")).clear();
		//Enter Domain name		  
			driver.findElement(By.id("txtADDomainName")).sendKeys("ghostsoftware.local");
			driver.findElement(By.id("txtADUsername")).clear();
		//Enter Username		  
			driver.findElement(By.id("txtADUsername")).sendKeys("ahsan.rehman");
			driver.findElement(By.id("txtADPassword")).clear();
		//Enter Invalid Password		  
			driver.findElement(By.id("txtADPassword")).sendKeys("Abc12345*");
		//Select include all containers criteria
			driver.findElement(By.id("rbADCriteriaAll")).click();
		//Click on Update button		  
			driver.findElement(By.id("btnUpdateAuthSettings")).click();
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
			String expectedmsg = "Invalid username or password";
			Thread.sleep(5000);
			String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
			Thread.sleep(2000);
			Assert.assertEquals(actualmsg, expectedmsg);
			System.out.println("Expected Message : "+expectedmsg);
			System.out.println("Actual Message : " +actualmsg);
			}
			
			
			
			
			
			
			
			
			
		//Test ID 07-24
			//Set the active directory authentication with empty data
			
	@Test(priority=17)
	public void SetADAuthenticationWithEmptyData() throws InterruptedException {
		System.out.println("SetADAuthenticationWithEmptyData");
			driver.get(siteUrl);
		//Click on switch role		
			driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_lblServerAdministration")));
		//Click on Server Administration		
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
		//Click on System tab		
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
		//Click on Authentication dropdown		
			Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
		//Select Active Directory		  
			dropdown.selectByVisibleText("Active Directory");
			driver.findElement(By.id("txtADDomainName")).clear();
			driver.findElement(By.id("txtADUsername")).clear();
			driver.findElement(By.id("txtADPassword")).clear();
		//Select include all containers criteria
			driver.findElement(By.id("rbADCriteriaAll")).click();
		//Click on Update button	
			driver.findElement(By.id("btnUpdateAuthSettings")).click();
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
			String expectedmsg = "Please enter domain name";
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
			String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
			Thread.sleep(2000);
			Assert.assertEquals(actualmsg, expectedmsg);
			System.out.println("Expected Message : "+expectedmsg);
			System.out.println("Actual Message : " +actualmsg);
			}
			
			
			
			
			
			
			
			
			//Set the active directory authentication by providing only domain name
			
	@Test(priority=18)
	public void SetADAuthenticationWithOnlyDomainName() throws InterruptedException {
		System.out.println("SetADAuthenticationWithOnlyDomainName");
			driver.get(siteUrl);
		//Click on switch role		
			driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_lblServerAdministration")));
		//Click on Server Administration		
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
		//Click on System tab		
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
		//Click on Authentication dropdown		
			Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
		//Select Active Directory		  
			dropdown.selectByVisibleText("Active Directory");
			driver.findElement(By.id("txtADDomainName")).clear();
		//Enter Domain name		  
			driver.findElement(By.id("txtADDomainName")).sendKeys("ghostsoftware.local");
			driver.findElement(By.id("txtADUsername")).clear();
			driver.findElement(By.id("txtADPassword")).clear();
		//Select include all containers criteria
			driver.findElement(By.id("rbADCriteriaAll")).click();
		//Click on Update button		 	  
			driver.findElement(By.id("btnUpdateAuthSettings")).click();
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
			String expectedmsg = "Please enter username";
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
			String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
			Thread.sleep(2000);
			Assert.assertEquals(actualmsg, expectedmsg);
			System.out.println("Expected Message : "+expectedmsg);
			System.out.println("Actual Message : " +actualmsg);
			}
		
			
			
			
			
			
			
		//Set the active directory authentication without password
			
	@Test(priority=19)
	public void SetADAuthenticationWithoutPassword() throws InterruptedException {
		System.out.println("SetADAuthenticationWithoutPassword");
			driver.get(siteUrl);
		//Click on switch role		
			driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_lblServerAdministration")));
		//Click on Server Administration		
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
		//Click on System tab		
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
		//Click on Authentication dropdown		
			Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
		//Select Active Directory		  
			dropdown.selectByVisibleText("Active Directory");
			driver.findElement(By.id("txtADDomainName")).clear();
		//Enter Domain name		  
			driver.findElement(By.id("txtADDomainName")).sendKeys("ghostsoftware.local");
			driver.findElement(By.id("txtADUsername")).clear();
		//Enter Username		  
			driver.findElement(By.id("txtADUsername")).sendKeys("ahsan.rehman");
			driver.findElement(By.id("txtADPassword")).clear();
		//Select include all containers criteria
			driver.findElement(By.id("rbADCriteriaAll")).click();
		//Click on Update button		  
			driver.findElement(By.id("btnUpdateAuthSettings")).click();
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
			String expectedmsg = "Please enter password";
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
			String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
			Thread.sleep(2000);
			Assert.assertEquals(actualmsg, expectedmsg);
			System.out.println("Expected Message : "+expectedmsg);
			System.out.println("Actual Message : " +actualmsg);
			}
			
			
			
			
			
			
	
		//Test ID 07-27
			//Set the authentication with wrong AD username
			
	@Test(priority=20)
	public void SetADAuthenticationWithInvalidUsername1() throws InterruptedException {
		System.out.println("SetADAuthenticationWithInvalidUsername1");
			driver.get(siteUrl);
		//Click on switch role	
			driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_lblServerAdministration")));
		//Click on Server Administration	
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
		//Click on System tab		
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
		//Click on Authentication dropdown		
			Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
		//Select Active Directory		  
			dropdown.selectByVisibleText("Active Directory");
		//Enter Domain name	
			driver.findElement(By.id("txtADDomainName")).clear();
			driver.findElement(By.id("txtADDomainName")).sendKeys("ghostsoftware.local");
			driver.findElement(By.id("txtADUsername")).clear();
		//Enter Invalid Username		  
			driver.findElement(By.id("txtADUsername")).sendKeys("test");
			driver.findElement(By.id("txtADPassword")).clear();
		//Enter Password	
			driver.findElement(By.id("txtADPassword")).sendKeys("Abc123*");
		//Select include all containers criteria
			driver.findElement(By.id("rbADCriteriaAll")).click();
		//Click on Update button		  
			driver.findElement(By.id("btnUpdateAuthSettings")).click();
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
			String expectedmsg = "Invalid username or password";
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
			String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
			Thread.sleep(2000);
			Assert.assertEquals(actualmsg, expectedmsg);
			System.out.println("Expected Message : "+expectedmsg);
			System.out.println("Actual Message : " +actualmsg);
			}
		
	
	
	
		
	//Test ID 07-28 
		//Set mix mode authentication with empty data
	@Test(priority=21)
	public void SetMixModeAuthenticationWithEmptyData() throws InterruptedException {
		System.out.println("SetMixModeAuthenticationWithEmptyData");
			driver.get(siteUrl);
		//Click on switch role	
			driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_lblServerAdministration")));
		//Click on Server Administration	
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
		//Click on System tab	
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
		//Click on Authentication dropdown	
			Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
		//Select mix mode	  
			dropdown.selectByVisibleText("Mix Mode (OmniPCX RECORD - Active Directory)");
			driver.findElement(By.id("txtADDomainName")).clear();
			driver.findElement(By.id("txtADUsername")).clear();
			driver.findElement(By.id("txtADPassword")).clear();
		//Select include all containers criteria
			driver.findElement(By.id("rbADCriteriaAll")).click();
		//Click on Update button	  
			driver.findElement(By.id("btnUpdateAuthSettings")).click();
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
			String expectedmsg = "Please enter domain name";
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
			String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
			Thread.sleep(2000);
			Assert.assertEquals(actualmsg, expectedmsg);
			System.out.println("Expected Message : "+expectedmsg);
			System.out.println("Actual Message : " +actualmsg);
		}	
		
	
		
	
	
	
	
		
		//Test ID 07-29-01
			//Set AD authentication and try to login server administration with disabled user
		
	@Test(priority=22)
	public void LoginServerAdministrationWithDisabedUser() throws InterruptedException {
		System.out.println("LoginServerAdministrationWithDisabedUser");
			driver.get(siteUrl);
		//Click on switch role	
			driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_lblServerAdministration")));
		//Click on Server Administration	
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
		//Click on System tab	
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
		//Click on Authentication dropdown	
			Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
		//Select Active Directory	  
			dropdown.selectByVisibleText("Active Directory");
			driver.findElement(By.id("txtADDomainName")).clear();
		//Enter Domain name	  
			driver.findElement(By.id("txtADDomainName")).sendKeys("ghostsoftware.local");
			driver.findElement(By.id("txtADUsername")).clear();
		//Enter Username	  
			driver.findElement(By.id("txtADUsername")).sendKeys("ahsan.rehman");
			driver.findElement(By.id("txtADPassword")).clear();
		//Enter Password	  
			driver.findElement(By.id("txtADPassword")).sendKeys("Abc123*");
		//Select include all containers criteria
			driver.findElement(By.id("rbADCriteriaAll")).click();
		//Click on Update button	  
			driver.findElement(By.id("btnUpdateAuthSettings")).click();
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
			String expectedmsg = "Settings have been updated successfully";
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
			String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")));
			Assert.assertEquals(actualmsg, expectedmsg);
		//Click on User tab
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
		//Wait for the browser to respond
			WebDriverWait wait6 = new WebDriverWait(driver,30);
			WebElement btnMain6;
			btnMain6= wait6.until(ExpectedConditions.visibilityOfElementLocated(By.id("gvServerUsers")));
		//Get the table and row
			WebElement table =driver.findElement(By.id("gvServerUsers"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
		//ArrayList<String> ListOdIds=new ArrayList<>();
			String rowNo="";
			String Usernmae = "muhammad.haris";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//table[@id='gvServerUsers']/tbody/tr["+(i+1)+"]"));
			if(row.getText().trim().contains(Usernmae))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr["+rowNo+"]/td[4]/div/img[1]")).click();
			Thread.sleep(2000);
		//Uncheck Enable Account
			driver.findElement(By.xpath("//*[@id=\"divNewAgent1\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input")).click();
		//Click on Update button
			driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder\"]/table/tbody/tr[5]/td/input[1]")).click();
		//Wait for the browser to respond
			WebDriverWait wait7 = new WebDriverWait(driver,30);
			WebElement btnMain7;
			btnMain7= wait7.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-alertMessage")));
		//Verify the message displayed in popup window
			driver.findElement(By.id("dialog-alertMessage")).click();
		//Check the message in popup window
		//Wait for the browser to respond
			WebDriverWait wait8 = new WebDriverWait(driver,30);
			WebElement btnMain8;
			btnMain8= wait8.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-alertMessage")));
			String expectedmsg1 = "Settings have been updated successfully";
		//Wait for the browser to respond
			WebDriverWait wait9 = new WebDriverWait(driver,30);
			WebElement btnMain9;
			btnMain9= wait9.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-alertMessage")));
			String actualmsg1 = driver.findElement(By.id("dialog-alertMessage")).getText();
			Thread.sleep(2000);
			Assert.assertEquals(actualmsg1, expectedmsg1);
			Thread.sleep(1000);
		//Click on OK button
			driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();
		//Wait for the browser to respond
			WebDriverWait wait10 = new WebDriverWait(driver,30);
			WebElement btnMain10;
			btnMain10= wait10.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_lblLogOut")));
		//Click on Logout
			driver.findElement(By.id("ctl00_lblLogOut")).click();
		//Login with disabled user
		//Enter Username  
			driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("muhammad.haris");
		//Enter Password	  
			driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("Abc123*");
		//Click on Login button	  
			driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait11 = new WebDriverWait(driver,30);
			WebElement btnMain11;
			btnMain11= wait11.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctrl_TenantAdmin1_lblMessage")));
			  String expectedmsg2 = "Your account has been disabled, please contact your system administrator.";
			  Thread.sleep(5000);
			  String actualmsg2 = driver.findElement(By.id("ctrl_TenantAdmin1_lblMessage")).getText();
			  Thread.sleep(2000);
			  Assert.assertEquals(actualmsg2, expectedmsg2);
			  System.out.println("Expected Message : "+expectedmsg2);
			  System.out.println("Actual Message : " +actualmsg2);
	}	
	
	
		
		
		
		
		
		
		
		//Test ID 07-29-02
		//Set AD authentication and try to login site administration with disabled agent
		
	@Test(priority=23)
	public void LoginSiteAdministrationWithDisabledagent() throws InterruptedException {
		System.out.println("LoginSiteAdministrationWithDisabledagent");
			driver.get(siteUrl);
		//Click on switch role	
			driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_lblServerAdministration")));
		//Click on Server Administration
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
		//Click on System tab
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
		//Click on Authentication dropdown
			Select dropdown = new Select(driver.findElement(By.id("cboAuthType")));
		//Select Active Directory  
			dropdown.selectByVisibleText("Active Directory");
			driver.findElement(By.id("txtADDomainName")).clear();
		//Enter Domain name  
			driver.findElement(By.id("txtADDomainName")).sendKeys("ghostsoftware.local");
			driver.findElement(By.id("txtADUsername")).clear();
		//Enter Username  
			driver.findElement(By.id("txtADUsername")).sendKeys("ahsan.rehman");
			driver.findElement(By.id("txtADPassword")).clear();
		//Enter Password  
			driver.findElement(By.id("txtADPassword")).sendKeys("Abc123*");
		//Select include all containers criteria
			driver.findElement(By.id("rbADCriteriaAll")).click();
		//Click on Update button  
			driver.findElement(By.id("btnUpdateAuthSettings")).click();
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
			String expectedmsg = "Settings have been updated successfully";
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
			String actualmsg = driver.findElement(By.id("lblMessageAuthentication")).getText();
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_lblLogOut")));
			Assert.assertEquals(actualmsg, expectedmsg);
		//Logout
			driver.findElement(By.id("ctl00_lblLogOut")).click();
		//Switch role to site administration to login with site admin user
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
			WebDriverWait wait6 = new WebDriverWait(driver,30);
			WebElement btnMain6;
			btnMain6= wait6.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Wait for the browser to respond
			WebDriverWait wait7 = new WebDriverWait(driver,30);
			WebElement btnMain7;
			btnMain7= wait7.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbFind")));
		//Find the agent tanveer
			driver.findElement(By.id("tbFind")).sendKeys("tanveer");
		//Click on find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table =driver.findElement(By.id("gvUsers"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
		//ArrayList<String> ListOdIds=new ArrayList<>();
			String rowNo="";
			String Usernmae = "tanveer.ahmad";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//table[@id='gvUsers']/tbody/tr["+(i+1)+"]"));
			if(row.getText().trim().contains(Usernmae))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[7]/div/img[1]")).click();
		//Wait for the browser to respond
			WebDriverWait wait8 = new WebDriverWait(driver,30);
			WebElement btnMain8;
			btnMain8= wait8.until(ExpectedConditions.visibilityOfElementLocated(By.id("cbEnableAccount")));
		//Uncheck Enable Account
			driver.findElement(By.id("cbEnableAccount")).click();
		//Click on Update button
			driver.findElement(By.id("btnSave")).click();
		//Wait for the browser to respond
			WebDriverWait wait9 = new WebDriverWait(driver,30);
			WebElement btnMain9;
			btnMain9= wait9.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-alertMessage")));		  
		//Verify the message displayed in popup window
			String expectedmsg1 = "Settings have been updated successfully";
		//Wait for the browser to respond
			WebDriverWait wait10 = new WebDriverWait(driver,30);
			WebElement btnMain10;
			btnMain10= wait10.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-alertMessage")));
			String actualmsg1 = driver.findElement(By.id("dialog-alertMessage")).getText();
			Thread.sleep(2000);
			Assert.assertEquals(actualmsg1, expectedmsg1);		  
		//Click on OK in popup window
			driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();
		//Wait for the browser to respond
			WebDriverWait wait11 = new WebDriverWait(driver,30);
			WebElement btnMain11;
			btnMain11= wait11.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_lblLogOut")));		  
		//Click on Logout
			driver.findElement(By.id("ctl00_lblLogOut")).click();		  
		//Login the site with disabled agent
		//Wait for the browser to respond
			WebDriverWait wait12 = new WebDriverWait(driver,30);
			WebElement btnMain12;
			btnMain12= wait12.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_txtSiteCode")));
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).clear();
		//Enter Site code	
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).clear();
		//Enter Username of disabled agent  
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("tanveer.ahmad");
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).clear();
		//Enter Password  
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("Abc123*");
		//Click on Login button  
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
		//Wait for the browser to respond
			WebDriverWait wait13 = new WebDriverWait(driver,30);
			WebElement btnMain13;
			btnMain13= wait13.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_lblMessage")));		  
		//Verify the message at login page
		//Wait for the browser to respond
			WebDriverWait wait14 = new WebDriverWait(driver,30);
			WebElement btnMain14;
			btnMain14= wait14.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_lblMessage")));
			String expectedmsg2 = "Your account has been disabled, please contact your system administrator.";
		//Wait for the browser to respond
			WebDriverWait wait15 = new WebDriverWait(driver,30);
			WebElement btnMain15;
			btnMain15= wait15.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_lblMessage")));
			String actualmsg2 = driver.findElement(By.id("Ctrl_Login1_lblMessage")).getText();
			Thread.sleep(2000);
			Assert.assertEquals(actualmsg2, expectedmsg2); 
			System.out.println("Expected Message : "+expectedmsg2);
			System.out.println("Actual Message : " +actualmsg2);
	}	
	
	
	
		
		
		
	//Test ID 07-31 Related to disable the user from AD so it will not automate
	//Test ID 07-32 Related to disable the user from AD so it will not automate
	//Test ID 07-33 Related to add appostrophe in the name of OU it is not currently available
	//Test ID 07-34 Related to add appostrophe in the name of OU it is not currently available
	//Test ID 07-35 Related to add appostrophe in the name of AD user it is not currently available
	//Test ID 07-36 Related to add appostrophe in the name of AD user it is not currently available
	//Test ID 07-37 Related to export agent from site1 and import on site 2 so it will not automate
	//Test ID 07-38 Related to check the replication so it will not automate
	//Test ID 07-39 Related to make the call on AD agent and check the recording so it will not automate
	//Test ID 07-40 to 07-47 are duplicate cases
	//Test ID 07-48 is already covered in 07-15
		
		
		

		//Delete server user created in 07-02
		
	@Test(priority=24)
	public void DeleteServerUser() throws InterruptedException {
		System.out.println("DeleteServerUser");
			driver.get(siteUrl);
		//Click on switch role	
			driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_lblServerAdministration")));
		//Click on Server Administration	
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
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")));
			String actualurl1="siteUrl";
			String expectedurl1= driver.getCurrentUrl();
			Assert.assertNotEquals(actualurl1,expectedurl1);
		//Click on User tab
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("gvServerUsers")));
		//Get the table and row
			WebElement table =driver.findElement(By.id("gvServerUsers"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
		//ArrayList<String> ListOdIds=new ArrayList<>();
			String rowNo="";
			String Usernmae = "muhammad.haris";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//table[@id='gvServerUsers']/tbody/tr["+(i+1)+"]"));
			if(row.getText().trim().contains(Usernmae))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[2]/tbody/tr[2]/td/div/table/tbody/tr["+rowNo+"]/td[4]/div/img[2]")).click();
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("AlertBoxMessage")));
		//Verify the message
			String expectedmsg = "Are you sure you want to delete?";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("AlertBoxMessage")));
			String actualmsg = driver.findElement(By.id("AlertBoxMessage")).getText();
			Thread.sleep(2000);
			Assert.assertEquals(actualmsg, expectedmsg);
		//Click on delete button
			driver.findElement(By.xpath("//*[@id=\"btnDelete\"]")).click();
		//Wait for the browser to respond
			WebDriverWait wait6 = new WebDriverWait(driver,30);
			WebElement btnMain6;
			btnMain6= wait6.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessage")));
		//Verify the message after deleting the user
			String expectedmsg1 = "Record has been deleted successfully";
		//Wait for the browser to respond
			WebDriverWait wait7 = new WebDriverWait(driver,30);
			WebElement btnMain7;
			btnMain7= wait7.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessage")));
			String actualmsg1 = driver.findElement(By.id("lblMessage")).getText();
			Thread.sleep(2000);
			Assert.assertEquals(actualmsg1, expectedmsg1);
			System.out.println("Expected Message : "+expectedmsg1);
			System.out.println("Actual Message : " +actualmsg1);
		  	}	
	
	
		
		
		
		
		//Delete site agent created in 07-02-01
	@Test(priority=25)
	public void DeleteSiteUser() throws InterruptedException {
		System.out.println("DeleteSiteUser");
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
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_CtrlLeftMenus1_HyperLink5")));
		//Click on Agent tab
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink5")).click();
		//Wait for the browser to respond
			WebDriverWait wait1 = new WebDriverWait(driver,30);
			WebElement btnMain1;
			btnMain1= wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbFind")));
		//Find the agent tanveer
			driver.findElement(By.id("tbFind")).sendKeys("tanveer");
		//Click on find button
			driver.findElement(By.id("btnFind")).click();
		//Get the table and row
			WebElement table =driver.findElement(By.id("gvUsers"));
			WebElement tbody=table.findElement(By.tagName("tbody"));
			List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			//ArrayList<String> ListOdIds=new ArrayList<>();
			String rowNo="";
			String Usernmae = "tanveer.ahmad";
			for(int i=0;i<rows.size();i++)
			{
			WebElement row = tbody.findElement(By.xpath("//table[@id='gvUsers']/tbody/tr["+(i+1)+"]"));
			if(row.getText().trim().contains(Usernmae))
			{
			rowNo=Integer.toString(i+1);
			break;
			}
			}
			System.out.println(rowNo);
			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[6]/td/div/table/tbody/tr["+rowNo+"]/td[7]/div/img[2]")).click();
		//Wait for the browser to respond
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			WebElement btnMain2;
			btnMain2= wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
		//Verify the message
			String expectedmsg = "Are you sure you want to delete?";
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog-message")));
			String actualmsg = driver.findElement(By.id("dialog-message")).getText();
			Thread.sleep(2000);
			Assert.assertEquals(actualmsg, expectedmsg);
		//Click on delete button
			driver.findElement(By.id("btnDelete")).click();
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblErrorMsg")));
		//Verify the message after deleting the user
			String expectedmsg1 = "Record has been deleted successfully";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblErrorMsg")));
			String actualmsg1 = driver.findElement(By.id("lblErrorMsg")).getText();
			Thread.sleep(2000);
			Assert.assertEquals(actualmsg1, expectedmsg1);
			System.out.println("Expected Message : "+actualmsg1);
			System.out.println("Actual Message : " +expectedmsg1);
			}	
		
		
		
		
		
		
		//Reset the authentication settings
	@Test(priority=26)
	public void ResetAuthenticationSettings() throws InterruptedException {
		System.out.println("ResetAuthenticationSettings");
			driver.get(siteUrl);
		//Click on switch role	
			driver.findElement(By.id("Ctrl_Login1_lblSwitchRole")).click();
		//Wait for the browser to respond
			WebDriverWait wait = new WebDriverWait(driver,30);
			WebElement btnMain;
			btnMain= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Ctrl_Login1_lblServerAdministration")));
		//Click on Server Administration	
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
		//Click on system tab
			driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink3")).click();
		//Click on reset button under authentication settings
			driver.findElement(By.id("btnResetAuthSettings")).click();
		//Verify the message
			String expectedmsg1 = "Settings have been updated successfully";
		//Wait for the browser to respond
			WebDriverWait wait3 = new WebDriverWait(driver,30);
			WebElement btnMain3;
			btnMain3= wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
			String actualmsg1 = driver.findElement(By.id("lblMessageAuthentication")).getText();
		//Wait for the browser to respond
			WebDriverWait wait4 = new WebDriverWait(driver,30);
			WebElement btnMain4;
			btnMain4= wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnUpdateAuthSettings")));
			Assert.assertEquals(actualmsg1, expectedmsg1);
		//Click on update button
			driver.findElement(By.id("btnUpdateAuthSettings")).click();
		//Verify the message
			String expectedmsg2 = "Settings have been updated successfully";
		//Wait for the browser to respond
			WebDriverWait wait5 = new WebDriverWait(driver,30);
			WebElement btnMain5;
			btnMain5= wait5.until(ExpectedConditions.visibilityOfElementLocated(By.id("lblMessageAuthentication")));
			String actualmsg2 = driver.findElement(By.id("lblMessageAuthentication")).getText();
			Thread.sleep(2000);
			Assert.assertEquals(actualmsg2, expectedmsg2);
			System.out.println("Expected Message : "+expectedmsg2);
			System.out.println("Actual Message : " +actualmsg2);
			  }	
	
@AfterTest
public void tearDownTest() throws InterruptedException {
			
	System.out.println("Test Completed Successfully");
	driver.quit();
}

	
	
	
	

}
