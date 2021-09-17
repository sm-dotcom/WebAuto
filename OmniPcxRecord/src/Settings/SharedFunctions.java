/**
 * @author sarah.mahmood
 *
 * Sep 14, 2021 6:03:53 PM
 */

package Settings;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.util.Random;



public class SharedFunctions {


public WebDriver driver;
public static String driverPath = "C:\\Users\\Administrator\\Desktop\\FilesToSetup\\geckodriver.exe";

	public SharedFunctions()
	{
	super();
	}
	
	
//	((SharedFunctions)sf).loginServerAdmin(driver);
//	  ((SharedFunctions)sf).clickPermissions(driver);
	
	public FirefoxDriver InitializeDriver() {
	
	System.setProperty("webdriver.gecko.driver", driverPath);
	FirefoxProfile profile = new FirefoxProfile();
	FirefoxOptions options = new FirefoxOptions();
	options.setProfile(profile);
//	options.setHeadless(true);
	driver = new FirefoxDriver(options);
	
//	driver = new FirefoxDriver(options);
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	System.out.println("Browser Name is : "+cap.getBrowserName());
	System.out.println("Browser version is : "+cap.getVersion());
	System.out.println("Platform is : "+cap.getPlatform().toString());
	return (FirefoxDriver)driver;
	}

	public void loginServerAdmin(WebDriver driver)
	{
		
		driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
		driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
		driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
        
	}
	
	public void loginSiteAdmin(WebDriver driver)
	{
		
		driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
		driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
		driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click(); 
	}
	

	public void clickServerPermissions(WebDriver driver) {
		driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPermissions")).click();
	}
	
	public String GenerateNames() {
	String names[] = {
            "Liam", "Olivia", "Noah", "Emma", "Oliver", "Ava", "William", "Sophia", "Elijah", "Isabella", "Jeff",
            "James", "Charlotte", "Benjamin", "Amelia", "Lucas", "Mia", "Mason", "Harper", "Ethan", "Evelyn", 
            "Maeve", "Rojas", "Mark", "Anthony", "Jack", "Black" , "Bloom", "Stella", "Martin", "Edward", "Rowley", 
        };
	
	 System.out.println(names [new Random().nextInt(names.length)]);
	 return names [new Random().nextInt(names.length)];
	
	}
	
	public void CreateUser(WebDriver driver) {
		
		loginServerAdmin(driver);
		clickUsers(driver);
		
//		driver.findElement(By.id("ctl00_lblLogOut")).click();
		
		  // Click on Add Users
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[2]/td/a")).click();		
		  
	      // Fillout the form for new user
	      // Locate Fname and enter value
	      String fname = GenerateNames();
	      driver.findElement(By.id("tbFirstName")).sendKeys(); //sendKeys("Maeve");
	      
	      // Locate Lname and enter value
	      String lname = GenerateNames();
	      driver.findElement(By.id("tbLastName")).sendKeys();
	      
//	      Thread.sleep(5000);
	      // Locate username and enter value
	      driver.findElement(By.id("tbUserName")).sendKeys("Mrojas567");
	      
	      // Locate password and enter value
	      driver.findElement(By.id("tbPassword")).sendKeys("1234567a");
	      
	      // Locate confirm password and enter value
	      driver.findElement(By.id("tbConfirmPassword")).sendKeys("1234567a");
	      
//	      Thread.sleep(5000);
	      // Locate Password Never Expires checkbox and check
	      WebElement PasswordNeverExpires = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td[2]/input")) ;
	      PasswordNeverExpires.click();
	      
	      // Locate email and enter value
	      WebElement emailbox = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[9]/td[2]/input"));
	      emailbox.sendKeys("nooria.ashraf@amigo-software.com");
	      
//	      Thread.sleep(5000);
	      // Locate Enable Account checkbox and check
	      WebElement EnableAccount = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr[10]/td[2]/input"));
	      EnableAccount.click();
	      
//	      Thread.sleep(5000);
	      // Locate Security Groups Roles and Click/Select
	      WebElement ServerAdmin = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/div/select/option"));
	      ServerAdmin.click();
	      
	      // Locate ">" and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")).click();
	      
//	      Thread.sleep(5000);
	      // Locate Save button and click
	      driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/table/tbody/tr[5]/td/input[1]")).click();
	      
//	      Thread.sleep(5000);
	      // Check alert message
	      JavascriptExecutor jsx = (JavascriptExecutor)driver;
	      jsx.executeScript("window.confirm('Settings have been saved successfully')");
	    
	      String expectedAlertUserSaved = "Settings have been saved successfully";
	      Alert confirmation = driver.switchTo().alert();
	      String actualAlertUserSaved = confirmation.getText(); //Get text present on alert Message
	    
	      Assert.assertEquals(actualAlertUserSaved, expectedAlertUserSaved);
	    
	      //Print Alert where needed
	      //System.out.println("Alert text is :" + actualAlert);
	    
	      /* Manage exceptions org.openqa.selenium.UnhandledAlertException: 
	      Dismissed user prompt dialog: Settings have been updated successfully:*/
	      driver.switchTo().alert().accept();
	   
//	      Thread.sleep(5000);
	      // Click on okay button
//	      Thread.sleep(5000);
	      driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button/span")).click();
	}
	
	
	public void CreatePermissionsGroup (WebDriver driver) {
		
		loginServerAdmin(driver);
		clickServerPermissions(driver);
		
		// Click on Group name and add a new name
		driver.findElement(By.id("txtGroupName")).sendKeys("Jackets");
		
		driver.findElement(By.id("txtDescription")).sendKeys("A new group is created.");

		// Click on add button
		driver.findElement(By.id("imgbtnAddUpdate")).click();
		
		boolean groupname = driver.findElement(By.xpath("//*[text()='Jackets']")).isDisplayed();
		Assert.assertEquals(true, groupname);
		
	}
	
	public  void clickSitePermissions(WebDriver driver) {
		driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink21")).click();
	}
	
	public  void clickUsers(WebDriver driver) {
		driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	}
	
	public void TakeScreenshot(WebDriver driver, String TestCaseID, String Status, String ClassName)
	{
		TakesScreenshot ts = (TakesScreenshot) driver;

		// capture screenshot as output type FILE
		File file = ts.getScreenshotAs(OutputType.FILE);

		try {
			// save the screenshot taken in destination path
			FileUtils.copyFile(file, new File("C:\\Users\\Administrator\\Pictures\\"+ClassName+"\\"+Status+"\\"+TestCaseID+"_"+Status+".png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String GenerateStringofLength10()
	{
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String randomString = "";
		int length = 11;
		
		Random rand = new Random();
		char[] text = new char[length];
		
		for (int i=0; i<length; i++) {
			text[i] = characters.charAt(rand.nextInt(characters.length()));	
		}
		
		for (int i = 0; i<text.length; i++) {
			randomString += text[i];
		}
		
		return randomString;
	}
	
	public String GenerateStringofLength250()
	{
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
		String randomString = "";
		int length = 260;
		
		Random rand = new Random();
		char[] text = new char[length];
		
		for (int i=0; i<length; i++) {
			text[i] = characters.charAt(rand.nextInt(characters.length()));	
		}
		
		for (int i = 0; i<text.length; i++) {
			randomString += text[i];
		}
		
		return randomString;
	}
	
	
	
	public void SendEmail()
	{
		 String to = "muhammad.haris@amigo-software.com";

			// Add sender
			 String from = "qa-opr@amigo-software.com";
			 final String username = "qa-opr@amigo-software.com";
			 final String password = "OPRqa@2017";

			String host = "auth.smtp.1and1.co.uk";

			Properties props = new Properties();
			 props.put("mail.smtp.auth", "true");
			 props.put("mail.smtp.host", host);
			 props.put("mail.smtp.port", "587");

			// Get the Session object
			 Session session = Session.getInstance(props,
			 new javax.mail.Authenticator() {
			 protected PasswordAuthentication getPasswordAuthentication() {
			 return new PasswordAuthentication(username, password);
			 }
			 });

			try {
			 // Create a default MimeMessage object
			 Message message = new MimeMessage(session);
			 
			 message.setFrom(new InternetAddress(from));
			 
			 message.setRecipients(Message.RecipientType.TO,
			 InternetAddress.parse(to));
			 message.addRecipient(RecipientType.CC, new InternetAddress(
			            "ahsan.rehman@amigo-software.com"));
			 
			 // Set Subject
			 message.setSubject("Web Test Automation Result R2.5.0.2");
			 
			 
			 
			 // Put the content of your message
			

			// Create another object to add another content
						MimeBodyPart messageBodyPart2 = new MimeBodyPart();
						MimeBodyPart messageBodyPart1= new MimeBodyPart();
						
						String filename = "C:\\Selenium\\Book1.xlsx";
			 
						// Create data source and pass the filename
						DataSource source = new FileDataSource(filename);
			 
						// set the handler
						messageBodyPart2.setDataHandler(new DataHandler(source));
			 
						// set the file
						messageBodyPart2.setFileName(new File(filename).getName());;
			 
						// Create object of MimeMultipart class
						Multipart multipart = new MimeMultipart();
			 
						// add body part 1
						messageBodyPart1.setText("Hi All, \nWe have successfully executed the code for Web Automation for R2.5.0.2. Please see the attached sheet for the results. \n\nRegards, \nQA Team \n\n\n=====================================================================================\r\n"
								+ "This is an auto-generated message by Automation Testing. Please do not reply to this email address.\r\n"
								+ "=====================================================================================\r\n"
								+ "");
			 
						// add body part 2
						multipart.addBodyPart(messageBodyPart2);
						multipart.addBodyPart(messageBodyPart1);
						// set the content
						message.setContent(multipart);
			// Send message
			 Transport.send(message);

			System.out.println("Sent message successfully....");

			} catch (MessagingException e) {
			 throw new RuntimeException(e);
			 }
			 }
	
	public void setDate() {
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
		   LocalDateTime now = LocalDateTime.now().plusDays(1);  
		   System.out.println(dtf.format(now)); 
	}
	}
	


	
//	public void MakeDirectory() {
//		String Path = "C:\\Users\\sarah.mahmood\\Desktop\\";
//	    String FileName = "ServerPermissions";
//	    Path = Path + FileName;
//	    System.out.println( Path);	    
//	    File dir1 = new File(Path);  //Specify the Folder name here
//	    dir1.mkdir();  //Creates the folder with the above specified name	
//	}
	
//}






	
