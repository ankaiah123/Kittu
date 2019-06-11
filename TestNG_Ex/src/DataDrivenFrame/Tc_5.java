package DataDrivenFrame;

import java.io.FileInputStream;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tc_5 
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
	public void Tc5() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium_Demp\\chromedriver.exe");
		driv=new ChromeDriver();
		js=(JavascriptExecutor)driv;
		String url=pro.getProperty("url");
		String us=pro.getProperty("username");
		String pass=pro.getProperty("password");
		String name=pro.getProperty("accName");
		driv.get(url);
		driv.findElement(By.name("user_name")).sendKeys(us);
		Thread.sleep(2000);
		driv.findElement(By.name("user_password")).sendKeys(pass);
		Thread.sleep(2000);
		driv.findElement(By.id("submitButton")).click();
		driv.findElement(By.linkText("Organizations")).click();
		Thread.sleep(2000);
		driv.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		Thread.sleep(2000);
		driv.findElement(By.name("accountname")).sendKeys(name);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,300)");
		driv.findElement(By.name("button")).click();
		
		
	}

}
