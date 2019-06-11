package DataDrivenFrame;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tc_2 
{
	Properties prop;
	WebDriver driver; 
	Select sel;
	WebElement lead;
@BeforeClass
public void ex() throws Exception
{
   prop=new Properties();

  prop.load(new FileInputStream("E:\\ankaiah\\TestNG_Ex\\src\\DataDrivenFrame\\Config.Properties"));
	

}
 @Test(groups="qap1")
 public void ex2()throws Exception
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
lead=driver.findElement(By.xpath("//img[@alt='Create Lead...']"));
lead.click();
Thread.sleep(2000);
sel=new Select(driver.findElement(By.name("salutationtype")));
sel.selectByIndex(1);
Thread.sleep(2000);
	String fname=prop.getProperty("firstname");
	Thread.sleep(2000);
	String lname1=prop.getProperty("lastname");
	Thread.sleep(2000);
	String company=prop.getProperty("companyname");
	String Search=prop.getProperty("search");
	Thread.sleep(2000);
driver.findElement(By.name("firstname")).sendKeys(fname);
Thread.sleep(2000);
driver.findElement(By.name("lastname")).sendKeys(lname1);
Thread.sleep(2000);
driver.findElement(By.name("company")).sendKeys(company);
Thread.sleep(2000);
driver.findElement(By.xpath("(//input[@value='  Save  '])[2]")).click();
Thread.sleep(2000);
driver.findElement(By.linkText("Leads")).click();
Thread.sleep(2000);
driver.findElement(By.name("search_text")).sendKeys(Search);
Thread.sleep(2000);
sel=new Select(driver.findElement(By.name("search_field")));
sel.selectByIndex(2);
driver.findElement(By.name("submit")).click();
Thread.sleep(2000);
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
