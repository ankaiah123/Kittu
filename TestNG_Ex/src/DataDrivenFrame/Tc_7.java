package DataDrivenFrame;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tc_7 
{
	Properties pro;
	WebDriver driv;
	Select sel;
	WebElement del;
	Alert alt;
	@BeforeClass
	public void setup() throws Exception
	{		
		pro=new Properties();
		pro.load(new FileInputStream("E:\\ankaiah\\TestNG_Ex\\src\\DataDrivenFrame\\Config.Properties"));
	}
	@Test(groups="qap3")
	public void Tc7() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium_Demp\\chromedriver.exe");
		driv=new ChromeDriver();
		String url=pro.getProperty("url");
		String us=pro.getProperty("username");
		String pass=pro.getProperty("password");
		String SName=pro.getProperty("Sername");
		driv.get(url);
		driv.findElement(By.name("user_name")).sendKeys(us);
		Thread.sleep(2000);
		driv.findElement(By.name("user_password")).sendKeys(pass);
		Thread.sleep(2000);
		driv.findElement(By.id("submitButton")).click();
		driv.findElement(By.linkText("Organizations")).click();
		Thread.sleep(2000);
		driv.findElement(By.name("search_text")).sendKeys(SName);
		Thread.sleep(2000);
		sel=new Select(driv.findElement(By.name("search_field")));
		sel.selectByIndex(1);
		Thread.sleep(2000);
		driv.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		del=driv.findElement(By.xpath("//input[@value='Delete']"));
		del.click();
		Thread.sleep(2000);
		alt=driv.switchTo().alert();
		alt.accept();
		Thread.sleep(2000);
		driv.findElement(By.name("selected_id")).click();
		del.click();
		Thread.sleep(2000);
		alt.dismiss();
		Thread.sleep(2000);
		del.click();
		Thread.sleep(2000);
		alt.accept();
		Thread.sleep(2000);
		
}
}