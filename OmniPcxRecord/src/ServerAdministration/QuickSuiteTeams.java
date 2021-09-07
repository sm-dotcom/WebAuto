package ServerAdministration;

import org.testng.annotations.Test;
//import java.util.List;



//import java.util.List;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class QuickSuiteTeams {
	
	
	public String siteurl = "http://172.20.11.238/QuickSuite/Dashboard.aspx";;
	public String driverPath = "C:\\Users\\sarah.mahmood\\Downloads\\chromedriver_win32\\chromedriver.exe";
	public String downloadFilepath ="C:\\Users\\sarah.mahmood\\Downloads";
	public WebDriver driver;
	
	@BeforeTest
	public void beforeTest(){

	System.setProperty("webdriver.chrome.driver", driverPath);
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--download.default_directory", downloadFilepath);
	driver = new ChromeDriver(options);
	}


//	@SuppressWarnings("deprecation")
	@Test

	public void TeamsCreation() throws InterruptedException {
	driver.get(siteurl);
	driver.manage().window().maximize();
	
	
	//Enter Username
	driver.findElement(By.id("txtUsername")).sendKeys("admin");
	
	//Enter Password
	driver.findElement(By.id("txtPassword")).sendKeys("admin");
	
	//Click on Login button
    driver.findElement(By.id("login_button")).click();
		
	Thread.sleep(7000);
	
	driver.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_divProducts\"]/div[1]/div[1]/img")).click();
	
//	int size = driver.findElements(By.tagName("iframe")).size();
//	System.out.println(size);

	driver.switchTo().frame("productiframe");
	
	// Click on Agents
    driver.findElement(By.id("ctl00_ctrlTopMenuSuperAdmin1_lblAgents")).click();
    
    Thread.sleep(5000);
    
    // Edit agents
    driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_UsersSearch1_GridView1_ctl07_ImageButton1")).click();
    
    Thread.sleep(6000);
    
    
    driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_Users1_checkBoxtransferredreport")).click();
    
//    List<WebElement> allElements = driver.findElements(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder2_Ctrl_Users1_ul1\"]"));
////    System.out.println(allElements);
//  
//   
//    String rowNo="";
//    String Age_Team = "Support";
//    
//    
//    for (int i = 0; i < allElements.size(); i++){
//    rowNo = allElements.get(i).getText();
//    System.out.println(rowNo);
//    
//    	if (rowNo.equals(Age_Team)) {
//		allElements.get(i).click(); 
//		
//		Thread.sleep(2000);
//		driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_Users1_ImageButton1")).click();
//    	}
//    } 
    


    
    
//  //Select Pre_Sales team from Available teams section
//  //Get the table and row
//  WebElement table =driver.findElement(By.xpath("//*[@id=\"divAgentTeams\"]/table"));
//  WebElement tbody=table.findElement(By.tagName("tbody"));
//  List<WebElement> rows=tbody.findElements(By.tagName("tr"));
//  String rowNo="";
//  System.out.println(rows.size());
//  String Teams = "Pre_Sales";
//  for(int i=0;i<rows.size();i++)
//  {
//  WebElement row = tbody.findElement(By.xpath("/html/body/form/div[3]/div[2]/div[2]/table/tbody/tr/td/div[2]/table/tbody/tr[6]/td/div/table/tbody/tr/td/table/tbody/tr[3]/td[1]/ul/li["+(i+1)+"]"));
//  if(row.getText().trim().contains(Teams))
//  {
//  rowNo=Integer.toString(i+1);
//  break;
//  }
//  }
//  System.out.println(rowNo);
//  driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div[2]/table/tbody/tr/td/div[2]/table/tbody/tr[6]/td/div/table/tbody/tr/td/table/tbody/tr[3]/td[1]/ul/li["+rowNo+"]")).click();  
    
    
    
    
    
   	
   	driver.close();
	} 	
   	
  
//  driver.findElement(By.xpath("//*[@id=\"cboLanguage_msdd\"]/div[1]/span[2]")).click();
//	  WebElement flags = driver.findElement(By.xpath("//*[@id=\"cboLanguage_child\"]/ul"));
//	  List<WebElement> links = flags.findElements(By.tagName("li"));
//	  	for (int i = 0; i < links.size(); i++){
//	  			System.out.println(links.get(i).getText());}
//
//	  		for (int j = 0; j< links.size(); j++) {
//	  			//driver.findElement(By.xpath("//*[@id=\"cboLanguage_msdd\"]/div[1]/span[2]")).click();
//	  			Thread.sleep(2000);
//	  			WebElement flags1 = driver.findElement(By.xpath("//*[@id=\"cboLanguage_child\"]/ul"));
//	  			List<WebElement> links1 = flags1.findElements(By.tagName("li"));
//	  			Thread.sleep(2000);
//	  			links1.get(j).click();
 

//  for(WebElement li : allElements) 
//  {
//       System.out.println(li.getText());
//       System.out.println();
//
//       for (int i=0; i<Name.length(); i++)
//       {
//          if(li.getText().equalsIgnoreCase(Name[i]))
//          {
//              //Clicks on the matched webelement    
//              li.click();
//          }
//        }
//  }	
	
	
//  
// 	/html/body/form/div[3]/div[2]/div[2]/table/tbody/tr/td/div[2]/table/tbody/tr[6]/td/div/table/tbody/tr/td/table/tbody/tr[3]/td[1]/ul/li[1]
//  
// 	/html/body/form/div[3]/div[2]/div[2]/table/tbody/tr/td/div[2]/table/tbody/tr[6]/td/div/table/tbody/tr/td/table/tbody/tr[3]/td[1]/ul/li[1]
/////////////////////////////////////////////////////Diff method    	
	
    
    
//    for (WebElement element: allElements) {
//        System.out.println(element.getText());
//        element.click();          
//    }
  
    
//	//Get the table and row  
//    driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder2_Ctrl_Users1_ul1\"]"));
//    WebElement table =driver.findElement(By.xpath("//*[@id=\"li1_1\"]/ul"));; 
////    WebElement flags = driver.findElement(By.xpath("//*[@id=\"cboLanguage_child\"]/ul"));
//	  List<WebElement> links = table.findElements(By.tagName("li"));
//
//	  for (int i = 0; i < links.size(); i++){
//			System.out.println(links.get(i).getText());}

//    String rowNo="";
//    String Age_Team = "Support";
//   	for(int i=0;i<rows.size();i++)
//   	{
//   		WebElement row = table.findElement(By.xpath(" //*[@id=\"li"+i+"_1\"]  ")); 
////   		WebElement row = tbody.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder2_Ctrl_Users1_ul1\"]/tbody/tr["+(i+1)+"]")); 
//   	if(row.getText().trim().contains(Age_Team))
//   	{
//   	rowNo=Integer.toString(i+1);
//   	break;
//   	}
//   	}
//   	System.out.println(rowNo);
//   	Thread.sleep(8000);	
//   	driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div[2]/table/tbody/tr/td/div[2]/table/tbody/tr[6]/td/div/table/tbody/tr/td/table/tbody/tr[3]/td[1]/ul/li["+rowNo+"]")).click();
//
//
//   	driver.findElement(By.id("ctl00_ContentPlaceHolder2_Ctrl_Users1_ImageButton1")).click();

  
  //*[@id="li2_1"]   
  //*[@id="li2_1"]
   	
  //*[@id="li1_1"]
   	
  //*[@id="gvServerUsers"]
   	
  //*[@id="gvServerUsers_wrapper"]
   	
  //*[@id="li2_1"]
   	
  //*[@id="ctl00_ContentPlaceHolder2_Ctrl_Users1_ul1"]
   	

//   	[@id=\"ContentPlaceHolder1_divProducts\"]/div[1]/div[1]/img")).click();
//   	Thread.sleep(2000);
//
//   	driver.findElement(By.xpath("//ul/li/a[text()='Teams']")).click();
   	
   	
  //*[@id="gvServerUsers"]/tbody/tr
  //*[@id="li1_1"]
   	
   	
//   	/html/body/form/div[3]/div[2]/div[2]/table/tbody/tr/td/div[2]/table/tbody/tr[6]/td/div/table/tbody/tr/td/table/tbody/tr[3]/td[1]/ul/li[1]
    
//   	/html/body/form/div[3]/div[2]/div[2]/table/tbody/tr/td/div[2]/table/tbody/tr[6]/td/div/table/tbody/tr/td/table/tbody/tr[3]/td[1]/ul/li[2]
   	
   	


//	@AfterTest
//	public void afterTest() {
//
//	try {
//	System.out.println("Closing the Browser");
//
//	driver.quit();
//	}
//
//	catch(Throwable e) {
//	System.out.println("Error :" +e);
//	}	
//	
//	}
	
	
}
	


