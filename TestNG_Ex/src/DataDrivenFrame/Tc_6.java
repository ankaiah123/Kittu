package DataDrivenFrame;

import java.io.FileInputStream;
import java.sql.Driver;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tc_6 
{
	Properties pro;
	WebDriver driv;
	JavascriptExecutor js;
	@BeforeClass
	public void setup() throws Exception
	{		
		pro=new Properties();
		pro.load(new FileInputStream("E:\\ankaiah\\TestNG_Ex\\src\\DataDrivenFrame\\Config.Properties"));
	}
	@Test(groups="qap3")
	public void Tc6() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium_Demp\\chromedriver.exe");
		driv=new ChromeDriver();
		js=(JavascriptExecutor)driv;
		String url=pro.getProperty("url");
		String us=pro.getProperty("username");
		String pass=pro.getProperty("password");
		String ac=pro.getProperty("firstname");
		driv.get(url);
		driv.findElement(By.name("user_name")).sendKeys(us);
		Thread.sleep(2000);
		driv.findElement(By.name("user_password")).sendKeys(pass);
		Thread.sleep(2000);
		driv.findElement(By.id("submitButton")).click();
		driv.findElement(By.linkText("Organizations")).click();
		Thread.sleep(2000);
		driv.findElement(By.xpath("//a[@title='Organizations']")).click();
		js.executeScript("window.scrollBy(0,550)");
		Thread.sleep(2000);
		driv.findElement(By.xpath("(//input[@name='Edit'])[2]")).click();
		Thread.sleep(2000);
		WebElement acc=driv.findElement(By.name("accountname"));
				acc.clear();
				Thread.sleep(2000);
				acc.sendKeys(ac);
				Thread.sleep(2000);
	js.executeScript("window.scrollBy(0,550)");
	Thread.sleep(2000);
	driv.findElement(By.name("button")).click();
	
	
}
}