package ServerAdministration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class  SharedFunctions {

	
	public SharedFunctions()
	{
		super();
	}
	
	
	public void InitializeWebdriver() {
   
	System.setProperty("webdriver.gecko.driver", ServerPermissions.driverPath);
	ServerPermissions.driver = new FirefoxDriver();
	
	}

	public void loginServerAdmin()
	{
		
      ServerPermissions.driver.findElement(By.id("ctrl_TenantAdmin1_txtUserName")).sendKeys("admin");
      ServerPermissions.driver.findElement(By.id("ctrl_TenantAdmin1_txtPassword")).sendKeys("1234567a");
      ServerPermissions.driver.findElement(By.id("ctrl_TenantAdmin1_imgBtnLogin")).click();
        
	}

	public  void clickPermissions() {
		 ServerPermissions.driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkPermissions")).click();
	}
	
	
	public  void clickUsers() {
		 ServerPermissions.driver.findElement(By.id("ctl00_ctrl_LeftMenuCloud1_hlnkUsers")).click();
	}
	
	
	public void TakeScreenshot(WebDriver driver, String TestCaseID, String Status)
	{
		TakesScreenshot ts = (TakesScreenshot) driver;

		// capture screenshot as output type FILE
		File file = ts.getScreenshotAs(OutputType.FILE);

		try {
			// save the screenshot taken in destination path
			FileUtils.copyFile(file, new File("C:\\Users\\sarah.mahmood\\Desktop\\ServerPermissions\\"+TestCaseID+"_"+Status+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void MakeDirectory() {
		String Path = "C:\\Users\\sarah.mahmood\\Desktop\\";
	    String FileName = "ServerPermissions";
	    Path = Path + FileName;
	    System.out.println( Path);	    
	    File dir1 = new File(Path);  //Specify the Folder name here
	    dir1.mkdir();  //Creates the folder with the above specified name	
	}
	
}
