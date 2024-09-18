package zone;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
@Test
public class LoginPage 
{
	public LoginPage() throws InterruptedException
	{
	     
		Scanner sc= new Scanner(System.in);
		System.out.println("pls enter the email");
		String emailID = sc.next();
		
		System.out.println("pls enter the password");
		String pwd=sc.next();
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://zone.tandemloop.net/swift/auth/login");
		
		
		WebElement email = driver.findElement(By.xpath("//input[@placeholder='Enter email address']"));
		email.sendKeys(emailID);
		
		WebElement pass = driver.findElement(By.xpath("//input[@placeholder='Enter password']"));
		pass.sendKeys(pwd);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
//		String exp = "https://zone.tandemloop.net/swift/business-acquisition/projects?status=open&view=table&page=1";
        
		Thread.sleep(2000);
        if(url.equalsIgnoreCase("https://zone.tandemloop.net/swift/business-acquisition/projects?status=open&view=table&page=1"))
        {
        	System.out.println("login successfully");
        
        }
        else
        {
        	System.out.println("pls enter the valid credentials");
        }
		
	}

}
//
//
//WebElement alert = driver.findElement(By.xpath("//div[@role='alert']"));
//
//
