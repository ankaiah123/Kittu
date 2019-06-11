package ModularFrameWork;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Frame;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.xml.dom.ParentSetter;

public class BusinessFunctions 
{
WebDriver driver;
WebDriverWait wait;
WebElement ObjUn;
WebElement objpwd;
WebElement objlog;
Alert alert;
Actions act;
public void configdriver(String browser)
{
	if(browser.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Qaplanet\\Downloads\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	else if(browser.equals("firefox"))
	{
		System.setProperty("webdricver.firefox.driver","D:\\Selenium_Demp\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	else if(browser.equals("ie"))
	{
		System.setProperty("webdriver.ie.driver","D:\\Selenium_Demp\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		
	}
	else{
		System.out.println("invalid browser");
	}
	wait=new WebDriverWait(driver, 30);
	driver.manage().window().maximize();
}
public void openbrowser(String url)
{
	driver.get(url);
	
	wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
	assertEquals(driver.getTitle(), "OrangeHRM - New Level of HR Management");
	Reporter.log("homepage is displayed");
	ObjUn=driver.findElement(By.name("txtUserName"));
	objpwd=driver.findElement(By.name("txtPassword"));
   objlog=driver.findElement(By.name("Submit"));
	assertTrue(ObjUn.isDisplayed()&&objpwd.isDisplayed());
	Reporter.log("un,pwd is displayed");
}
public void LoginOrangeHrm(String username,String password)
{
	ObjUn.sendKeys(username);
	objpwd.sendKeys(password);
	objlog.sendKeys(Keys.ENTER);
	wait.until(ExpectedConditions.titleIs("OrangeHRM"));
	assertEquals(driver.getTitle(), "OrangeHRM");
	Reporter.log("OrangeHRM Page displayed");
	String weltext=driver.findElement(By.xpath("//ul[@id='option-menu']/li[1]")).getText();
	assertEquals(weltext, "Welcome "+username);
	Reporter.log("welcome page is displayed");

}
public void Addemployee(String Lname,String Fname,String photo) throws Exception
{
	act=new Actions(driver);
	WebElement pim=driver.findElement(By.xpath("//span[@class='drop current']"));
	act.moveToElement(pim).perform();
	assertTrue(pim.isDisplayed());
	Reporter.log("pim is displayed");

	WebElement addemp=driver.findElement(By.linkText("Add Employee"));
	addemp.click();
Thread.sleep(2000);

	Reporter.log("addemployee is displayed");
	driver.switchTo().frame("rightMenu");
	driver.findElement(By.name("txtEmpLastName")).sendKeys(Lname);
	Thread.sleep(2000);
    driver.findElement(By.name("txtEmpFirstName")).sendKeys(Fname);	
	Thread.sleep(2000);
	act.click(driver.findElement(By.name("photofile"))).perform();
	Robot rt=new Robot();
	StringSelection sel=new StringSelection(photo);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
	Thread.sleep(2000);

	rt.keyPress(KeyEvent.VK_CONTROL);
	rt.keyPress(KeyEvent.VK_V);
	rt.keyRelease(KeyEvent.VK_V);
	rt.keyRelease(KeyEvent.VK_CONTROL);
	Thread.sleep(2000);

	rt.keyPress(KeyEvent.VK_ENTER);
	rt.delay(2000);
	rt.keyRelease(KeyEvent.VK_ENTER);
	rt.delay(2000);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@class='savebutton']")).click();
	Thread.sleep(2000);
	driver.findElement(By.name("EditMain")).click();
	Thread.sleep(2000);
	
	
}
public void editbutton(String lname,String fname)
{
	WebElement editlname=driver.findElement(By.name("txtEmpLastName"));
	editlname.clear();
	editlname.sendKeys(lname);
	WebElement editfname=driver.findElement(By.name("txtEmpFirstName"));
	editfname.clear();
	editfname.sendKeys(fname);
   
    Select sel=new Select( driver.findElement(By.id("cmbNation")));
	sel.selectByVisibleText("indiann");
	driver.findElement(By.id("chkSmokeFlag")).click();
	/*WebElement calender=driver.findElement(By.name("btnLicExpDate"));
	calender.click();
	driver.findElement(By.xpath("//a[@title='Next month']")).click();
	driver.findElement(By.xpath("//a[@class='selector']")).click();*/	
}
public void calender(String calender)
{
WebElement cal=driver.findElement(By.id("txtLicExpDate"));
cal.sendKeys(calender);
driver.findElement(By.id("btnEditPers")).click();
}
public void emplist(String sname)
{
	driver.switchTo().parentFrame();
	act=new Actions(driver);
	WebElement pim=driver.findElement(By.xpath("//span[@class='drop current']"));
	act.moveToElement(pim).perform();
	driver.findElement(By.linkText("Employee List")).click();
	driver.switchTo().frame("rightMenu");
	Select sel=new Select( driver.findElement(By.id("loc_code")));
	sel.selectByIndex(3);
	driver.findElement(By.name("loc_name")).sendKeys(sname);
	driver.findElement(By.cssSelector("[value='Search']")).click();
	/*driver.findElement(By.name("chkLocID[]")).click();
	WebElement delete=driver.findElement(By.cssSelector("input[value='Delete']"));
	delete.click();*/
	driver.findElement(By.name("allCheck")).click();
	WebElement delete1=driver.findElement(By.cssSelector("input[value='Delete']"));
	delete1.click();
}
public void Admin(String name,String count) throws Exception
{
	
	driver.switchTo().parentFrame();
	WebElement a=driver.findElement(By.linkText("Admin"));
	act=new Actions(driver);
act.moveToElement(a).perform();
	WebElement com=driver.findElement(By.linkText("Company Info"));
	act.moveToElement(com).perform();
	driver.findElement(By.linkText("Locations")).click();
	
driver.switchTo().frame("rightMenu");

driver.findElement(By.xpath("//input[@value='Add']")).click();
WebElement locName=driver.findElement(By.id("txtLocDescription"));
locName.sendKeys(name);
driver.findElement(By.cssSelector("[value='Save']")).click();
alert=driver.switchTo().alert();
alert.accept();
Select sel=new Select(driver.findElement(By.id("cmbCountry")));
sel.selectByVisibleText(count);
}
public void address(String addre)
{
driver.findElement(By.id("txtAddress")).sendKeys(addre);	
		
}
public void zipcode(String zcode,String phone)
{
	driver.findElement(By.id("txtZIP")).sendKeys(zcode);
	driver.findElement(By.id("txtPhone")).sendKeys(phone);
	WebElement ss=driver.findElement(By.cssSelector("[value='Save']"));
	ss.click();
	
}
public void edit(String sname) throws Exception
{
	Select sel=new Select( driver.findElement(By.id("loc_code")));
	sel.selectByIndex(2);
	Thread.sleep(2000);
	driver.findElement(By.name("loc_name")).sendKeys(sname);
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("[value='Search']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//td[@class='odd']/a")).click();
	Thread.sleep(2000);
}
public void editlocation(String SNAME,String state) throws Exception
{
driver.findElement(By.id("editBtn")).click();
Thread.sleep(2000);
	WebElement sname=driver.findElement(By.id("txtLocDescription"));
	sname.clear();
			sname.sendKeys(SNAME);
	Thread.sleep(2000);
	WebElement cstate=driver.findElement(By.id("txtState"));
	cstate.clear();
	cstate.sendKeys(state);
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("[value='Save']")).click();
}
public void LocationDele(String name,String search)
{
	Select s1=new Select(driver.findElement(By.name("loc_code")));
	s1.selectByVisibleText(name);
	driver.findElement(By.name("loc_name")).sendKeys(search);
	driver.findElement(By.cssSelector("[value='Search']")).click();
	driver.findElement(By.name("chkLocID[]")).click();
	driver.findElement(By.cssSelector("[value='Delete']")).click();
	alert=driver.switchTo().alert();
	alert.accept();
}
public void LocationAllDele(String name,String search) throws Exception
{
	Select s1=new Select(driver.findElement(By.name("loc_code")));
	s1.selectByVisibleText(name);
	Thread.sleep(2000);
	driver.findElement(By.name("loc_name")).sendKeys(search);
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("[value='Search']")).click();
	Thread.sleep(2000);
	driver.findElement(By.name("allCheck")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("[value='Delete']")).click();
	Thread.sleep(2000);
	alert=driver.switchTo().alert();
	alert.accept();
}
public void Adminjob(String Jobname,String description,String Speci)throws Exception
{
	driver.switchTo().parentFrame();
	WebElement aa=driver.findElement(By.linkText("Admin"));
	act=new Actions(driver);
act.moveToElement(aa).perform();	
Thread.sleep(2000);
WebElement job=driver.findElement(By.xpath("(//span[contains(..,'Job')])[1]"));
act.moveToElement(job).perform();
driver.findElement(By.linkText("Job Titles")).click();	
driver.switchTo().frame("rightMenu");

driver.findElement(By.xpath("//input[@value='Add']")).click();
Thread.sleep(2000);
driver.findElement(By.name("txtJobTitleName")).sendKeys(Jobname);
Thread.sleep(2000);
driver.findElement(By.name("txtJobTitleDesc")).sendKeys(description);
Thread.sleep(2000);
Select sss=new Select(driver.findElement(By.name("cmbJobSpecId")));
sss.selectByVisibleText(Speci);
Thread.sleep(2000);
Select s1s=new Select(driver.findElement(By.name("cmbPayGrade")));
s1s.selectByIndex(1);;
Thread.sleep(2000);
WebElement savee=driver.findElement(By.cssSelector("[value='Save']"));
savee.click();

}
public void EditJobTitle(String ejobname,String eddescr) throws Exception
{
	driver.findElement(By.id("editBtn")).click();
	
	WebElement n1=driver.findElement(By.name("txtJobTitleName"));
	n1.clear();
	n1.sendKeys(ejobname);
	Thread.sleep(2000);
	WebElement d1=driver.findElement(By.name("txtJobTitleDesc"));
	d1.clear();
	d1.sendKeys(eddescr);
	Thread.sleep(2000);
	Select s2s=new Select(driver.findElement(By.name("cmbJobSpecId")));
	
	s2s.selectByIndex(10);;
	Thread.sleep(2000);
	Select s3s=new Select(driver.findElement(By.name("cmbPayGrade")));
	s3s.selectByIndex(10);
	Thread.sleep(2000);
	WebElement sas=driver.findElement(By.id("editBtn"));
			sas.click();

}
public void adddelete(String ssname)throws Exception
{
	driver.switchTo().parentFrame();
	WebElement a12=driver.findElement(By.linkText("Admin"));
	act=new Actions(driver);
act.moveToElement(a12).perform();	
Thread.sleep(2000);
WebElement job=driver.findElement(By.xpath("(//span[contains(..,'Job')])[1]"));
act.moveToElement(job).perform();
driver.findElement(By.linkText("Job Titles")).click();	
driver.switchTo().frame("rightMenu");
Select s4=new Select(driver.findElement(By.id("loc_code")));
s4.selectByIndex(2);
driver.findElement(By.id("loc_name")).sendKeys(ssname);
driver.findElement(By.cssSelector("[value='Search']")).click();
driver.findElement(By.cssSelector("[name='chkLocID[]']")).click();
driver.findElement(By.cssSelector("[value='Delete']")).click();
alert=driver.switchTo().alert();
alert.accept();
}

public void addjobspecifications(String SpecName,String SpecDesc) throws Exception
{
driver.switchTo().parentFrame();
WebElement a12=driver.findElement(By.linkText("Admin"));
act=new Actions(driver);
act.moveToElement(a12).perform();	
Thread.sleep(2000);
WebElement job1=driver.findElement(By.xpath("(//span[contains(..,'Job')])[1]"));
act.moveToElement(job1).perform();

driver.findElement(By.linkText("Job Specifications")).click();
driver.switchTo().frame("rightMenu");
WebElement savv=driver.findElement(By.xpath("//input[@onclick='returnAdd();']"));
savv.click();
driver.findElement(By.xpath("//input[@tabindex='1']")).sendKeys(SpecName);
driver.findElement(By.xpath("//textarea[@tabindex='2']")).sendKeys(SpecDesc);

driver.findElement(By.xpath("//input[@onclick='edit();']")).click();
}
public void Editjobspecifications(String ssss,String ssname,String ssdec)throws Exception
{
	Select s5s=new Select(driver.findElement(By.id("loc_code")));
	s5s.selectByIndex(2);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='loc_name']")).sendKeys(ssss);
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("[value='Search']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/div/div[2]/form/table/tbody/tr[1]/td[3]/a")).click();
	Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id='editBtn']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//input[@tabindex='1']")).sendKeys(ssname);
Thread.sleep(2000);
driver.findElement(By.xpath("//textarea[@tabindex='2']")).sendKeys(ssdec);
Thread.sleep(2000);
WebElement raja=driver.findElement(By.xpath("//input[@onclick='edit();']"));
raja.click();
}
public void specDelete(String del) throws Exception
{
	driver.switchTo().parentFrame();
	WebElement a12=driver.findElement(By.linkText("Admin"));
	act=new Actions(driver);
	act.moveToElement(a12).perform();	
	Thread.sleep(2000);
	WebElement job1=driver.findElement(By.xpath("(//span[contains(..,'Job')])[1]"));
	act.moveToElement(job1).perform();

	driver.findElement(By.linkText("Job Specifications")).click();
	driver.switchTo().frame("rightMenu");
	 Select s6s=new Select(driver.findElement(By.id("loc_code")));
		s6s.selectByIndex(2);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='loc_name']")).sendKeys(del);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[value='Search']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("allCheck")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		Thread.sleep(2000);
		alert=driver.switchTo().alert();
		alert.accept();
}

}
