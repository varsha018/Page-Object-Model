package com.amazon.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.baseclass.TestBase;
import com.amazon.pages.LoginPage;
import com.amazon.pages.SignInPage;

public class LoginPageTest extends TestBase {

	LoginPage L_Page;
	SignInPage S_Page;

	@BeforeMethod
	public void Setup() throws IOException {

		initialization();

		L_Page = new LoginPage();

	}

	@Test(priority = 1)
	public void loginpagetitleTest() {

		String title = L_Page.LoginPageTitle();

		Assert.assertEquals(title, " Amazon.com. Spend less. Smile more. ");

		/*
		 * if(title.contains("Amazon.com.")) { System.out.println("correct title");
		 * 
		 * }else { System.out.println("incorrect title"); }
		 */

	}

	@Test(priority = 2)
	public void amazonlogoTest() {
		Boolean a_logo = L_Page.AmazonImg();
		Assert.assertTrue(a_logo);

	}

	@Test(priority = 3)
	public void logintest() throws IOException {
		S_Page = L_Page.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void TearDown() {

		driver.quit();

	}

	public LoginPageTest() throws IOException {
		super();

	}

}
