package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage
{
	public loginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
		
	}

	@FindBy(xpath = "//input[@placeholder='Enter email address']")
	private WebElement Email;
	
	@FindBy(xpath = "//input[@placeholder='Enter password']")
	private WebElement Pass;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement Submit;
	
	public void LoginPage(String email,String pass)
	{
		Email.sendKeys(email);
		Pass.sendKeys(pass);
		Submit.click();
	}
}
