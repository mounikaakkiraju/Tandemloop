package zone;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import POM.loginPage;
import zone.Signup;
public class Login
{
	
	@Test(dataProvider = "credentials")
	public void login(String data,String email,String pass) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		driver.get("https://zone.tandemloop.net/auth/login");
		
//		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys(email);
//		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys(pass);
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
	  
		Signup sn=new Signup();
		sn.signup(data, pass, data, email, pass, pass);
		
		//Using POM
	    loginPage lg = new loginPage(driver);
	    lg.LoginPage(email, pass);
		
		if(data.equals("Bothcorrect"))
		{
			WebElement username = driver.findElement(By.xpath("//span[text()='AM']"));
			Assert.assertEquals(username.isDisplayed(),"login successfully");
			
		}
		else if(data.equals("Bothwrong"))
		{
			String error = driver.findElement(By.xpath("//div[@role='alert']")).getText();
			Assert.assertEquals(error, "Please provide a valid email address.","please provide the valid credentials");
		}
		else if(data.equals("BothNull"))
		{
			String text = driver.findElement(By.xpath("//p[text()='Welcome back! Please enter your details.']")).getText();
			Assert.assertEquals(text, "Welcome back! Please enter your details.");
		}
//		else if(data.equals("WrongEmail"))
//		{
//			String error2 = driver.findElement(By.xpath(" //div[@class='ng-tns-c20-0 ant-form-item-explain-error']")).getText();
//			Assert.assertEquals(error2, "Please provide a valid email address.");
//		}
//		else if(data.equals("WrongPass"))
//		{
//			WebElement username = driver.findElement(By.xpath("//p[.='Welcome back! Please enter your details.']"));
//			Assert.assertEquals(username,"Welcome back! Please enter your details.");	
//		}
//		else if(data.equals("EmailNull"))
//		{
//			String error3 = driver.findElement(By.xpath("//div[text()=' Email is required ']")).getText();
//			Assert.assertEquals(error3, "Email is required");
//		}
//		else if(data.equals("PassNull"))
//		{
//			String error4 = driver.findElement(By.xpath("//div[text()='Please input your Password!']")).getText();
//			if(error4.equals("Please input your Password!"))
//			{
//				System.out.println("pls provide the input");
//			}
//		}
		
		driver.close();
		driver.quit();
		Thread.sleep(3000);
	}
	
		
	@DataProvider(name="credentials")
	public Object[][] getData()
	{
		return new Object[][]
		{
			
			{"BothCorrect","akkiraju.mounika@tandemloop.in","Mounika@123"},
			{"Bothwrong","akkiraju","mouni"},
			{"BothNull","",""},
//			{"WrongEmail","akki","Mounika@123"},
//			{"WrongPass","akkiraju.mounika@tandemloop.in","mouni"},
//			{"EmailNull","","Mounika@123"},
//			{"PassNull","akkiraju.mounika@tandemloop",""}	
		};
	}

}