package DataDrivenFrame;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tc_3 
{
	Properties prop;
	WebDriver driver; 
	Select sel;
	Actions act;
@BeforeClass
public void ex() throws Exception
{
   prop=new Properties();

  prop.load(new FileInputStream("E:\\ankaiah\\TestNG_Ex\\src\\DataDrivenFrame\\Config.Properties"));
	

}
 @Test(groups="qap1")
 public void ex3()throws Exception
 {
	 String strurl=prop.getProperty("url");
		String struname=prop.getProperty("username");
		String strpass=prop.getProperty("password");
	
	 System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Demp\\chromedriver.exe");
	 driver=new ChromeDriver();
driver.navigate().to(strurl);
Thread.sleep(2000);
driver.findElement(By.name("user_name")).sendKeys(struname);
driver.findElement(By.name("user_password")).sendKeys(strpass);
driver.findElement(By.id("submitButton")).click();
Thread.sleep(2000);
driver.findElement(By.linkText("Leads")).click();
Thread.sleep(2000);

	String Search=prop.getProperty("search");
	String editfname=prop.getProperty("ffirstname");
	String editlname=prop.getProperty("llastname");
	String comp=prop.getProperty("company");
	String design=prop.getProperty("designation");
    String indust=prop.getProperty("industry");
    String mob=prop.getProperty("mobile");
driver.findElement(By.name("search_text")).sendKeys(Search);
Thread.sleep(2000);
sel=new Select(driver.findElement(By.name("search_field")));
sel.selectByIndex(2);
driver.findElement(By.name("submit")).click();
Thread.sleep(2000);
WebElement lead=driver.findElement(By.xpath("//tr[@id='row_39']/td[3]/a"));
lead.click();
Thread.sleep(2000);
driver.findElement(By.name("Edit")).click();
Thread.sleep(1000);
WebElement editFname=driver.findElement(By.name("firstname"));
editFname.clear();
editFname.sendKeys(editfname);
Thread.sleep(2000);
WebElement editname=driver.findElement(By.name("lastname"));
editname.clear();
editname.sendKeys(editlname);
Thread.sleep(2000);
WebElement comany=driver.findElement(By.name("company"));
comany.clear();
comany.sendKeys(comp);
Thread.sleep(2000);
WebElement designation=driver.findElement(By.name("designation"));
designation.clear();
designation.sendKeys(design);
Thread.sleep(2000);
sel=new Select(driver.findElement(By.name("industry")));
sel.selectByVisibleText(indust);
WebElement mob1=driver.findElement(By.name("mobile"));
mob1.clear();
mob1.sendKeys(mob);

driver.findElement(By.name("button")).click();
//driver.findElement(By.name("Delete")).click();
//driver.switchTo().alert().accept();

driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
driver.findElement(By.linkText("Sign Out")).click();
}
 @AfterClass
 public void close()
 {
	 driver.close();
	 driver.quit();
 }
 }
