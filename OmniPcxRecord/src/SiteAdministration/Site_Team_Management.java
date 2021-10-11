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

public class Site_Team_Management {

		WebDriver driver = null;
		public String siteUrl = "http://172.20.22.81/OmniPCXRecord/TenantAdmin.aspx";
		public String ExpectedSiteURL = "http://172.20.22.81/OmniPCXRecord/TenantAdmin.aspx";
		
		
		@BeforeTest
		public void setUpTest() {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrator\\Desktop\\FilesToSetup\\geckodriver.exe");
			
			driver=new FirefoxDriver();
		}
		

		//Test ID 09-01
			// Creation of a team with its description.

		@Test(priority=0)
		public void CreationOfTeam() throws InterruptedException {
			driver.get(siteUrl);
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
			
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink6")).click();
			driver.findElement(By.id("tbTeamName")).sendKeys("Tech_Support");
			driver.findElement(By.id("tbDescription")).sendKeys("This is technical support team");
			driver.findElement(By.id("btnSave")).click();
			String expectedmsg = "Team information added successfully";
			String actualmsg = driver.findElement(By.id("lblMessage")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);
		}

		
		
		
		
		
		
		//Test ID 09-04 
			//Verify all tooltips
		
		@Test(priority=1)
		public void VerifyAllTooltipsOnTeamsPage() throws InterruptedException {
			driver.get(siteUrl);
			//Enter Site code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
			//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
			//Click on login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			
			//Click on Teams tab
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink6")).click();
			Thread.sleep(2000);
			
			//Verify the tooltip of Teams header
			WebElement Team_header = driver.findElement(By.xpath("//*[@id=\"gvTeams\"]/thead/tr/th[2]/span"));
			String actualTooltip = Team_header.getAttribute("title");
		    System.out.println("Actual Title of Tool Tip"+actualTooltip);
		    String expectedTooltip = "Teams";							
	        Assert.assertEquals(actualTooltip, expectedTooltip);
	        
	        //Verify the tooltip of Description header
	        WebElement Description_header = driver.findElement(By.xpath("//*[@id=\"gvTeams\"]/thead/tr/th[3]/span"));
			String actualTooltip1 = Description_header.getAttribute("title");
		    System.out.println("Actual Title of Tool Tip"+actualTooltip);
		    String expectedTooltip1 = "Description";					
	        Assert.assertEquals(actualTooltip1, expectedTooltip1);
	        
	        //Verify the tooltip of added teams (Tech_Support)
	      //Get the table and row
			  WebElement table =driver.findElement(By.id("gvTeams"));
			  //WebElement table1 =driver.findElement(By.xpath("//*[@id=\"gvTeams\"]/tbody/tr[1]/td[2]/span"));
			  WebElement tbody=table.findElement(By.tagName("tbody"));
			  List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			  //ArrayList<String> ListOdIds=new ArrayList<>();
			  String rowNo="";
			  String Teams = "Tech_Support";
			  for(int i=0;i<rows.size();i++)
			  {
			  WebElement row = tbody.findElement(By.xpath("//table[@id='gvTeams']/tbody/tr["+(i+1)+"]"));
			  if(row.getText().trim().contains(Teams))
			  {
			  rowNo=Integer.toString(i+1);
			  break;
			  }
			  }
			  System.out.println(rowNo);
			  Thread.sleep(2000);
			  String actualTooltip2 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[5]/td/div/table/tbody/tr["+rowNo+"]/td[2]/span")).getAttribute("title");
			  Thread.sleep(2000);
		    System.out.println("Actual Title of Tool Tip"+actualTooltip);
		    String expectedTooltip2 = "Tech_Support";					
	        Assert.assertEquals(actualTooltip2, expectedTooltip2);
	        
	      //Verify the tooltip of added team's (Tech_Support) description
	        
	      //Get the table and row
			  WebElement table1 =driver.findElement(By.id("gvTeams"));
			  //WebElement table1 =driver.findElement(By.xpath("//*[@id=\"gvTeams\"]/tbody/tr[1]/td[2]/span"));
			  WebElement tbody1=table1.findElement(By.tagName("tbody"));
			  List<WebElement> rows1=tbody1.findElements(By.tagName("tr"));
			  //ArrayList<String> ListOdIds=new ArrayList<>();
			  String rowNo1="";
			  String Teams1 = "Tech_Support";
			  for(int i=0;i<rows1.size();i++)
			  {
			  WebElement row = tbody1.findElement(By.xpath("//table[@id='gvTeams']/tbody/tr["+(i+1)+"]"));
			  if(row.getText().trim().contains(Teams1))
			  {
			  rowNo1=Integer.toString(i+1);
			  break;
			  }
			  }
			  System.out.println(rowNo1);
			  Thread.sleep(2000);
			  String actualTooltip3 = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[5]/td/div/table/tbody/tr["+rowNo1+"]/td[3]/span")).getAttribute("title");
			  Thread.sleep(2000);
		    System.out.println("Actual Title of Tool Tip"+actualTooltip);
		    String expectedTooltip3 = "This is technical support team";					
	      Assert.assertEquals(actualTooltip3, expectedTooltip3);  
	        
		}
		
		
		
		
		
		
		
		//Test ID 09-03
			//Verification of modification in Team by changing its name or description.
		
		@Test(priority=2)
		public void ModificationInTeam() throws InterruptedException {
			driver.get(siteUrl);
			//Enter site code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
			//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
			//Click on login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			
			//Click on Teams tab
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink6")).click();
			
			//Get the table and row
			  WebElement table =driver.findElement(By.id("gvTeams"));
			  WebElement tbody=table.findElement(By.tagName("tbody"));
			  List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			  //ArrayList<String> ListOdIds=new ArrayList<>();
			  String rowNo="";
			  String Teams = "Tech_Support";
			  for(int i=0;i<rows.size();i++)
			  {
			  WebElement row = tbody.findElement(By.xpath("//table[@id='gvTeams']/tbody/tr["+(i+1)+"]"));
			  if(row.getText().trim().contains(Teams))
			  {
			  rowNo=Integer.toString(i+1);
			  break;
			  }
			  }
			  System.out.println(rowNo);
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[5]/td/div/table/tbody/tr["+rowNo+"]/td[4]/div/img[1]")).click();
			  Thread.sleep(2000);
			
			driver.findElement(By.id("tbTeamName")).clear();
			driver.findElement(By.id("tbTeamName")).sendKeys("Tech_Support1");
			driver.findElement(By.id("tbDescription")).clear();
			driver.findElement(By.id("tbDescription")).sendKeys("This is technical support team1");
			driver.findElement(By.id("btnSave")).click();
			String expectedmsg = "Team information updated successfully";
			String actualmsg = driver.findElement(By.id("lblMessage")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);
			
		}
		
		
		
		
		
		
		
		//Test ID 09-07
			//Verification of deletion of a Team in case if agents are not associated.

		@Test(priority=3)
		public void VerifyDeletionOfTeamIfAgentNotAssigned() throws InterruptedException {
			driver.get(siteUrl);
			//Enter Site code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
			//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
			//Click on login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			
			//Click on Teams tab
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink6")).click();
			Thread.sleep(2000);
			
			//Get the table and row
			  WebElement table =driver.findElement(By.id("gvTeams"));
			  WebElement tbody=table.findElement(By.tagName("tbody"));
			  List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			  //ArrayList<String> ListOdIds=new ArrayList<>();
			  String rowNo="";
			  String Teams = "Tech_Support";
			  for(int i=0;i<rows.size();i++)
			  {
			  WebElement row = tbody.findElement(By.xpath("//table[@id='gvTeams']/tbody/tr["+(i+1)+"]"));
			  if(row.getText().trim().contains(Teams))
			  {
			  rowNo=Integer.toString(i+1);
			  break;
			  }
			  }
			  System.out.println(rowNo);
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[5]/td/div/table/tbody/tr["+rowNo+"]/td[4]/div/img[2]")).click();
			  Thread.sleep(2000);
			  
			  //Verify the message on popup window
			  String expectedmsg = "Are you sure you want to delete?";
			  Thread.sleep(5000);
			  String actualmsg = driver.findElement(By.id("dialog-message")).getText();
			  Thread.sleep(2000);
			  Assert.assertEquals(actualmsg, expectedmsg);
			  
			  //Click on Delete button
			  driver.findElement(By.id("btnDelete")).click();
			  
			//Verify the message
			  String expectedmsg1 = "Record has been deleted successfully";
			  Thread.sleep(5000);
			  String actualmsg1 = driver.findElement(By.id("lblGridMsg")).getText();
			  Thread.sleep(2000);
			  Assert.assertEquals(actualmsg1, expectedmsg1);
		}
		

		
		
		//Test ID 09-08
			//Verification of deletion of a Team in case if agents are associated.

		@Test(priority=4)
		public void VerifyDeletionOfTeamIfAgentsAreAssigned() throws InterruptedException {
			driver.get(siteUrl);
			//Enter Site code
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			//Enter Username
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
			//Enter Password
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
			//Click on login button
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			
			//Click on Teams tab
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink6")).click();
			Thread.sleep(2000);
			
			//Get the table and row
			  WebElement table =driver.findElement(By.id("gvTeams"));
			  WebElement tbody=table.findElement(By.tagName("tbody"));
			  List<WebElement> rows=tbody.findElements(By.tagName("tr"));
			  //ArrayList<String> ListOdIds=new ArrayList<>();
			  String rowNo="";
			  String Teams = "QA";
			  for(int i=0;i<rows.size();i++)
			  {
			  WebElement row = tbody.findElement(By.xpath("//table[@id='gvTeams']/tbody/tr["+(i+1)+"]"));
			  if(row.getText().trim().contains(Teams))
			  {
			  rowNo=Integer.toString(i+1);
			  break;
			  }
			  }
			  System.out.println(rowNo);
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td/div/table/tbody/tr[5]/td/div/table/tbody/tr["+rowNo+"]/td[4]/div/img[2]")).click();
			  Thread.sleep(2000);
			  
			  //Verify the message on popup window
			  String expectedmsg = "Are you sure you want to delete?";
			  Thread.sleep(5000);
			  String actualmsg = driver.findElement(By.id("dialog-message")).getText();
			  Thread.sleep(2000);
			  Assert.assertEquals(actualmsg, expectedmsg);
			  
			  //Click on Delete button
			  driver.findElement(By.id("btnDelete")).click();
			  Thread.sleep(3000);
			//Verify the message
			  String expectedmsg1 = "Unable to delete Team. This Team is associated with agent(s).";
			  Thread.sleep(5000);
			  String actualmsg1 = driver.findElement(By.id("lblGridMsg")).getText();
			  Thread.sleep(2000);
			  Assert.assertEquals(actualmsg1, expectedmsg1);
		}
		
			
		
		
		
		
		//Test ID 09-09 is not covered yet as it is related to paging
		
		
		
		//Test ID 09-10
			//Verification of creation of a team with duplicate name.

		@Test(priority=5)
		public void CreationOfTeamWithDuplicateName() throws InterruptedException {
			driver.get(siteUrl);
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
			
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink6")).click();
			driver.findElement(By.id("tbTeamName")).sendKeys("QA");
			driver.findElement(By.id("tbDescription")).sendKeys("This is Quality Assurance team");
			driver.findElement(By.id("btnSave")).click();
			Thread.sleep(2000);
			String expectedmsg = "Duplicate team names not allowed";
			String actualmsg = driver.findElement(By.id("lblMessage")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);
		}
		

		
		//Test ID 09-11 is not a valid case as special characters are disabled on web
		//Test ID 09-12 is not included in automation as its related to replication
		
		//Test ID 09-13
			//Check the spelling on teams page

		@Test(priority=6)
		public void CheckTheSpellings() throws InterruptedException {
			driver.get(siteUrl);
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
			
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink6")).click();
			Thread.sleep(2000);
			
			//Verify the spelling of top header (Teams)
			  String expectedresult = "Teams";
			  Thread.sleep(3000);
			  String actualresult = driver.findElement(By.id("ctl00_lblPageCaption")).getText();
			  Thread.sleep(2000);
			  Assert.assertEquals(actualresult, expectedresult);
			  
			//Verify spelling of Add Team header
			  String expectedresult1 = "Add Team";
			  Thread.sleep(3000);
			  String actualresult1 = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder2_UpdatePanel1\"]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/label")).getText();
			  Thread.sleep(2000);
			  Assert.assertEquals(actualresult1, expectedresult1);
		
			//Verify the spelling of Team Name*
			  String expectedresult2 = "Team Name *";
			  Thread.sleep(3000);
			  String actualresult2 = driver.findElement(By.xpath("//*[@id=\"divAgentTeams\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[1]/label")).getText();
			  Thread.sleep(2000);
			  Assert.assertEquals(actualresult2, expectedresult2); 
		
			//Verify the spelling of Description
			  String expectedresult3 = "Description";
			  Thread.sleep(3000);
			  String actualresult3 = driver.findElement(By.xpath("//*[@id=\"divAgentTeams\"]/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[1]/label")).getText();
			  Thread.sleep(2000);
			  Assert.assertEquals(actualresult3, expectedresult3); 
			  
			//Verify the spelling of Teams from the grid
			  String expectedresult6 = "Teams";
			  Thread.sleep(3000);
			  String actualresult6 = driver.findElement(By.xpath("//*[@id=\"gvTeams\"]/thead/tr/th[2]/span")).getText();
			  Thread.sleep(2000);
			  Assert.assertEquals(actualresult6, expectedresult6);
			  
			//Verify the spelling of Description from the grid
			  String expectedresult7 = "Description";
			  Thread.sleep(3000);
			  String actualresult7 = driver.findElement(By.xpath("//*[@id=\"gvTeams\"]/thead/tr/th[3]/span")).getText();
			  Thread.sleep(2000);
			  Assert.assertEquals(actualresult7, expectedresult7); 
		}
			
	  
		
		
		
		//Test ID 09-14
			//Verification of Creation of a team with empty team name.
		@Test(priority=7)
		public void CreationOfTeamWithEmptyName() throws InterruptedException {
			driver.get(siteUrl);
			driver.findElement(By.id("Ctrl_Login1_txtSiteCode")).sendKeys("010001");
			driver.findElement(By.id("Ctrl_Login1_txtUserName")).sendKeys("admin");
			driver.findElement(By.id("Ctrl_Login1_txtPassword")).sendKeys("1234567a");
			
			driver.findElement(By.id("Ctrl_Login1_imgBtnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("ctl00_CtrlLeftMenus1_HyperLink6")).click();
			driver.findElement(By.id("btnSave")).click();
			String expectedmsg = "Please enter Team name";
			String actualmsg = driver.findElement(By.id("lblMessage")).getText();
			Assert.assertEquals(actualmsg, expectedmsg);
		}
		
		@AfterTest
		public void tearDownTest() throws InterruptedException {
					
			System.out.println("Test Completed Successfully");
		}

}
