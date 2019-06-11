package DataDrivenFrame;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tc_4 
{
	Properties prop;
	WebDriver driver;
	WebElement delete;
	Alert alert;
	@BeforeClass
	
 public void setup() throws Exception
	{
			prop=new Properties();
		prop.load(new FileInputStream("E:\\ankaiah\\TestNG_Ex\\src\\DataDrivenFrame\\Config.Properties"));
		
		}
	@Test(groups="qap2")
	public void Tc4()throws Exception
	{
	String url=	prop.getProperty("url");
		String uname=prop.getProperty("username");
		String pass=prop.getProperty("password");
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium_Demp\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		Thread.sleep(2000);
		driver.findElement(By.name("user_name")).sendKeys(uname);
		Thread.sleep(2000);
		driver.findElement(By.name("user_password")).sendKeys(pass);
		Thread.sleep(2000);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Leads")).click();
		delete=driver.findElement(By.xpath("(//input[@value='Delete'])[1]"));
		Thread.sleep(2000);
		delete.click();
		alert=driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		WebElement check= driver.findElement(By.id("4"));
		check.click();
		Thread.sleep(2000);
		delete.click();
		Thread.sleep(2000);
		alert.dismiss();
		Thread.sleep(2000);
		delete.click();
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(2000);
	}
	 @AfterClass
	 public void close() throws Exception
	 {
		 driver.close();
			Thread.sleep(2000);
		 driver.quit();
		 
	}

}
