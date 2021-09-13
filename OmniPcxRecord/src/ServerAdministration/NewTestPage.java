package ServerAdministration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import org.apache.commons.collections4.FactoryUtils;
import org.apache.commons.io.FileUtils;
//import java.util.List;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.remote.ScreenshotException;
//import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.AfterTest;
//import com.twilio.jwt.accesstoken.AccessToken;
//import com.twilio.jwt.accesstoken.ChatGrant;
//import com.twilio.Twilio;
//import com.twilio.rest.chat.v2.Service;
//import com.twilio.rest.verify.v2.service.VerificationCheck;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import org.testng.annotations.Test;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.BeforeTest;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import com.google.common.io.Files;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.nio.charset.Charset;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.Set;

public class NewTestPage {
  
	public ArrayList<TestResult> testresultlist = new ArrayList<TestResult>();

	public String baseUrl = "http://172.20.22.81/OmniPCXRecord/TenantAdmin.aspx";

	public WebDriver driver;
//	public String SheetName = "29- Permission's";

	
   public SharedFunctions sf = new SharedFunctions();
     
	UpdateTestResult obj = new UpdateTestResult();


	@BeforeClass
	public void beforeTest() {
		
		System.out.println(this.getClass().getName());
		driver=((SharedFunctions)sf).InitializeDriver(); 
    }
	  
	
////Test ID: 31-28
///* 
//* Open "Incident Subscription" and see if check box is mark as check
//*/		
//	@Test (priority = 1)
//	public void checkEmail_SMScheckbox_isCheckedinIncidentSubscription() throws InterruptedException, IOException {
//		System.setProperty("webdriver.gecko.driver", driverPath);
//	    driver = new FirefoxDriver();
//	    driver.get(baseUrl);
//    
//	       // Signing in OmniPCX 
//	      driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//	      driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
//	      driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//	      
//	        // Click On Permissions 
//	        Thread.sleep(10000);
//		    driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPermissions")).click();
//	 	    
////		    (SharedFunctions)sf).loginServerAdmin();
////			  ((SharedFunctions)sf).clickPermissions();
////         		Thread.sleep(10000);
//	     	    
//         		// Get Delete button and check if it's enabled
//         		String actual = driver.findElement(By.xpath("//*[@id=\"gvGroups\"]/tbody/tr/td[3]/div/img[4]")).getAttribute("class");
//         		System.out.println(actual);
//         		String expected = "";
//       
//         		Assert.assertEquals(actual,expected);
//	  	  
////	  	MakeDirectory();
//         		
//         		driver.close();         		
//  }	
	

	
	
//	@Test (priority = 0)
//	public void ClearBranchTable() throws InterruptedException {
//
//	driver.get(baseUrl);
//
//	// Signing in OmniPCX
//	driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
//	driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
//	driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
//
//	// Click On Branches
//	//Thread.sleep(2000);
//	driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_HyperLink5")).click();
//
//
//	// int size = driver.findElements(By.xpath("//*[@id=\"tblBranch\"]/tbody/tr[1]/td[5]/img[2]")).size();
//
//	List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"tblBranch\"]/tbody/tr"));
//	int rowscount = rows.size();
//	System.out.println(rowscount);
//
//	for (int i=1 ; i<=rowscount; i++)
//	{
//
//	// Check if branch is already disabled then click delete
//	String title = driver.findElement(By.xpath("//*[@id=\"tblBranch\"]/tbody/tr[1]/td[4]/img")).getAttribute("title");
//	if (title.equals("Disabled")) {
//
//	driver.findElement(By.xpath("//*[@id=\"tblBranch\"]/tbody/tr[1]/td[5]/img[3]")).click();
//
//	driver.findElement(By.id("btnDelete")).click();
//	i=i+1;
//	}
//
//	// If branch is active, edit > Disable
//	else {
//	driver.findElement(By.xpath("//*[@id=\"tblBranch\"]/tbody/tr[1]/td[5]/img[2]")).click();
//	Select dropdown = new Select(driver.findElement(By.id("ddlBranchLicenseEnable")));
//	dropdown.selectByValue("0");
//
//	driver.findElement(By.id("btnSvae")).click();
//
//	// driver.switchTo().alert();
//	driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button")).click();
//	driver.findElement(By.xpath("//*[@id=\"tblBranch\"]/tbody/tr[1]/td[5]/img[3]")).click();
//
//	driver.findElement(By.id("btnDelete")).click();
//	i=i+1;
//
//	}
//
//	}
//
//	driver.close();
//	}
	
	
	
	
	
	
	@Test (priority = 30)
	public void ClearPermissionsAfterTest() throws InterruptedException, IOException {
		
		driver.get(baseUrl);
		
	((SharedFunctions)sf).loginServerAdmin(driver);
	((SharedFunctions)sf).clickServerPermissions(driver);
	
//	// Delete remaining Users and Permission group
//	// Users
//	// Click on Users
//	//Thread.sleep(10000);
//	driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
//	
//	//Thread.sleep(7000);
//	
//	// Click all check-boxes
//	List<WebElement> elements = driver.findElements(By.xpath("//input[@type='checkbox']"));
//	for (WebElement el:elements) {
//	el.click(); }
//	
//	// Click multiple delete
//	driver.findElement(By.id("dltMultiple")).click();
//	
//	//Thread.sleep(7000);
//	
//	// Click on delete selected
//	driver.findElement(By.xpath("/html/body/ul[1]")).click();
//	
//	// Click on delete button
//	//Thread.sleep(5000);
//	driver.findElement(By.id("btnDelete")).click();
//	
//	// Click On Permissions
//	//Thread.sleep(7000);
//	driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPermissions")).click();	
//	
	List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"gvGroups\"]/tbody/tr"));
	int rowscount = rows.size();
	System.out.println(rowscount);
	
	for (int i=2 ; i<=rowscount; i++)
	{
	////Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"gvGroups\"]/tbody/tr[2]/td[3]/div/img[4]")).click();
	
	driver.findElement(By.id("btnDelete")).click();
	}
	
	driver.close();	  		  		  
	} 
	
	
	

//	public void MakeDirectory() {
//		String Path = "C:\\\\Users\\\\sarah.mahmood\\\\Desktop\\\\";
//	    String FileName = "ServerPermissions";
//	    Path = Path + FileName;
//	    System.out.println( Path);	    
//	    File dir1 = new File(Path);  //Specify the Folder name here
//	    dir1.mkdir();  //Creates the folder with the above specified name	
//	}	

}
	
	
	
	


	
	
