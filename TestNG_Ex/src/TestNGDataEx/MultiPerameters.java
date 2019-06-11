package TestNGDataEx;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class MultiPerameters
{
	private static WebDriver driver;
@Test
@Parameters({"strUrl","sUsername","spassword"})
public void test(String strUrl,String sUsername,String spassword)
{
	driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.get(strUrl);
	driver.findElement(By.name("txtUserName")).sendKeys(sUsername);
	driver.findElement(By.name("txtPassword")).sendKeys(spassword);
	driver.findElement(By.name("Submit")).click();
	driver.findElement(By.linkText("Logout")).click();
}
}
