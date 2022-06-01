package com.amazon.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.baseclass.TestBase;

public class LoginPage extends TestBase {
	
	
	//Page Factory..Object Repository
	
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//span[@id ='continue'")
	WebElement Continuebtn;
	
	@FindBy(xpath ="//span[@id ='auth-signin-button']")
	WebElement SignInbtn;
	
	@FindBy(xpath ="//a[@id = 'nav-logo-sprites'] ")
	WebElement AmazonLogo;
	
	@FindBy(xpath = "//a[@id='nav-link-accountList']")
	WebElement Hello_SignIn;
	
	
	
	

	public LoginPage() throws IOException {
		super();				
		PageFactory.initElements(driver, this);  //by using "this" , all the variables of current class will be initialized.
												// "this" points to current class objects 
	}
	
	
	public String LoginPageTitle() {
		return driver.getTitle();
		
		
	}
	
	public Boolean AmazonImg() {
		return AmazonLogo.isDisplayed();
		
	}
	
	public SignInPage login(String un ,String pwd) throws IOException {
		
		Actions ac = new Actions(driver);
		
		ac.moveToElement(Hello_SignIn).build().perform();
		
		driver.switchTo().frame("sis_pixel_r2");
		
		username.sendKeys(un);
		Continuebtn.click();
		password.sendKeys(pwd);
		SignInbtn.click();
		
		return new SignInPage();
	}
	
	
	

}
