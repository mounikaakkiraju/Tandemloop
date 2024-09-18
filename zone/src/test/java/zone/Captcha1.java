package zone;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
@Test
public class Captcha1
{
	
	WebDriver driver;
	public void cap() throws IOException, TesseractException, InterruptedException
	{
		    ChromeOptions opt=new ChromeOptions();
//		    opt.addArguments("headless");
		    opt.addArguments("disable-notifications");
		   
			WebDriver driver = new ChromeDriver(opt);
			driver.manage().window().maximize();
     		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			driver.get("https://www.irctc.co.in/nget/train-search");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()=' LOGIN ']")).click();
			Thread.sleep(2000);
		    WebElement captcha= driver.findElement(By.xpath("//img[@class='captcha-img']"));
			
			TakesScreenshot screen= (TakesScreenshot)captcha;
			File src = screen.getScreenshotAs(OutputType.FILE);
			File dsc=new File("./captcha.png");
			FileHandler.copy(src, dsc);
			
			Thread.sleep(2000);
			
			Tesseract ts=new Tesseract();
			ts.setDatapath("C:\\Users\\Mounika1\\Downloads\\Tess4J-3.4.8-src\\Tess4J\\tessdata");
			String image = ts.doOCR(dsc);
			String text = image.replace(" ", "");
			System.out.println(image);
			
			driver.findElement(By.id("captcha")).sendKeys(image);
			
		
	}

}
