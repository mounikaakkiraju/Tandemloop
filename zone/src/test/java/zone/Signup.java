package zone;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.SignUp;

public class Signup 
{
	
	@Test(dataProvider="credentials")
    public void signup(String data,String Fname,String Lname,String email,String pass,String Cpass) throws InterruptedException
    {
    	WebDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
      	driver.get("https://zone.tandemloop.net/auth/signup");
      	
      	
//    	driver.findElement(By.id("first-name")).sendKeys(Fname);
//    	driver.findElement(By.id("lastName")).sendKeys(Lname); 	
//    	driver.findElement(By.id("email")).sendKeys(email);
//    	driver.findElement(By.id("password")).sendKeys(pass);
//    	driver.findElement(By.id("check-password")).sendKeys(Cpass);
      	
      	driver.findElement(By.xpath("//label[contains(@class,'ant-checkbo')]")).click();
     	driver.findElement(By.xpath("//button[@type='submit']")).click();
    	
      	//Using POM class
      	
    	SignUp sn=new SignUp(driver);
    	sn.signUpPage(Fname, Lname, email, pass, Cpass);
		
		if(data.equals("AllValid"))
		{
    	String text=driver.findElement(By.xpath(" //h5[text()=' Email verification ']")).getText();
    	Assert.assertEquals(text, "Email verification");
		}
		
		else if(data.equals("InvalidEmail"))
		{
    	String Email = driver.findElement(By.xpath(" //div[text()=' Please enter a valid email address ']")).getText();
    	Assert.assertEquals(Email, "Please enter a valid email address");
		}
		
		else if(data.equals("EmailNull"))
		{
    	String Email1 = driver.findElement(By.xpath("//div[@class='ng-tns-c15-2 ant-form-item-explain-error']")).getText();
    	Assert.assertEquals(Email1, "Email address is required']");
		}
		
//		else if(data.equals("InvalidFirsName"))
//		{
//    	String FirstName = driver.findElement(By.xpath("//div[text()=' Please enter a valid first name ']")).getText();
//    	Assert.assertEquals(FirstName, "Please enter a valid first name");
//		}
//		
//		else if(data.equals("FnameNull"))
//		{
//    	String FirstNameNull=driver.findElement(By.xpath("//div[@class='ng-tns-c15-0 ant-form-item-explain-error']")).getText();
//    	Assert.assertEquals(FirstNameNull, " First name is required ");
//		}
//		
////		else if(data.equals("Lname"))
////		{
////    	String LastName=driver.findElement(By.id("lastName")).getText();
////    	Thread.sleep(2000);
////    	Assert.assertEquals(LastName, "Lname");
////		}
//		
//		else if(data.equals("pass<8char"))
//		{
//    	String PwdLess8char=driver.findElement(By.xpath("//div[@class='ng-tns-c15-3 ant-form-item-explain-error']")).getText();
//    	Assert.assertEquals(PwdLess8char, "Use 8 or more characters with a mix of letters (A-Z & a-z), numbers & symbols.");
//		}
//		
//		else if(data.equals("passWithoutUpperCase"))
//		{
//    	String PwdWithoutUpperCase=driver.findElement(By.xpath("//div[@class='ng-tns-c15-3 ant-form-item-explain-error']")).getText();
//    	Assert.assertEquals(PwdWithoutUpperCase, "Use 8 or more characters with a mix of letters (A-Z & a-z), numbers & symbols.");
//		}
//		
//		else if(data.equals("passWithoutlowercase"))
//		{
//    	String PwdWithoutLowerCase=driver.findElement(By.xpath("//div[@class='ng-tns-c15-3 ant-form-item-explain-error']")).getText();
//    	Assert.assertEquals(PwdWithoutLowerCase, "Use 8 or more characters with a mix of letters (A-Z & a-z), numbers & symbols.");
//		}
//		
//		else if(data.equals("passWithoutNum"))
//		{
//    	String PwdWithoutNum=driver.findElement(By.xpath("//div[@class='ng-tns-c15-3 ant-form-item-explain-error']")).getText();
//    	Assert.assertEquals(PwdWithoutNum, "Use 8 or more characters with a mix of letters (A-Z & a-z), numbers & symbols.");
//		}
//		
//		else if(data.equals("passWithoutSpChar"))
//		{
//    	String PwdWithoutSpecChar=driver.findElement(By.xpath("//span[text()=' Use 8 or more characters with a mix of letters (A-Z & a-z), numbers & symbols. ']")).getText();
//    	Assert.assertEquals(PwdWithoutSpecChar, "Use 8 or more characters with a mix of letters (A-Z & a-z), numbers & symbols.");
//		}
//		
//		else if(data.equals("passNull"))
//		{
//    	String PwdNull=driver.findElement(By.xpath("//div[@class='ng-tns-c15-3 ant-form-item-explain-error']")).getText();
//    	Assert.assertEquals(PwdNull, "Password is required");
//		}
//		
//		else if(data.equals("CpassNull"))
//		{
//    	String CpassNull=driver.findElement(By.xpath("//div[@class='ng-tns-c15-4 ant-form-item-explain-error']")).getText();
//    	Assert.assertEquals(CpassNull,"Confirm password is required");
//		}
//		else if(data.equals("CpassNotSame"))
//		{
//    	String CpassNotSame=driver.findElement(By.xpath("//div[text()=' Both passwords must match ']")).getText();
//    	Assert.assertEquals(CpassNotSame, " Both passwords must match ");
//		}
		
		driver.close();
		Thread.sleep(2000);
		driver.quit();
		
		Thread.sleep(2000);
    }
	
	
	
	
	@DataProvider(name="credentials")
	public Object[][] getData()
	{
		//Unique Email
		Random ra=new Random();
		int ran=ra.nextInt(500);
		String Email="akiraju@gmail.com";
		String[] em = Email.split("@");
		String mail = em[0]+ran+"@"+em[1];
	    String pass="Mouni@123";
	    String Fname="akki";
	    String Lname="mouni";
		return new Object[][]
		{
			
			
			{"AllValid","akkiraju",Lname,mail,pass,pass},
			{"InvalidEmail","akkiraju",Lname,"akki",pass,pass},
			{"EmailNull","akkiraju",Lname,"",pass,pass},
//			{"InvalidFirsName","@124fd",Lname,mail,pass,pass},
//			{"FnameNull","",Lname,mail,pass,pass},
//			{"Lname",Fname,Lname,mail,pass,pass},
//			{"LnameNull",Fname,"",mail,pass,pass},
//			{"pass<8char","akki",Lname,mail,"mouni","mouni"},
//			{"passWithoutUpperCase",Fname,Lname,mail,"mouni@23","mouni@23"},
//			{"passWithoutlowercase",Fname,Lname,mail,"MOUNI@12","MOUNI@12"},
//			{"passWithoutNum",Fname,Lname,mail,"Mouni#","Mouni#"},
//			{"passWithoutSpChar",Fname,Lname,mail,"Mouni123","Mouni123"},
//			{"passNull",Fname,Lname,mail,"",""},
//			{"CpassNull",Fname,Lname,mail,"Mouni@123",""},
//			{"CpassNotSame",Fname,Lname,mail,pass,pass}
					
		
		};
	}

}
