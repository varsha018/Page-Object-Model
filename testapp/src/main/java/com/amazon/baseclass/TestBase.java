package com.amazon.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public  WebDriver driver;
	public static Properties prop;

	public TestBase() throws IOException {

		prop = new Properties();
		FileInputStream io = new FileInputStream(
				"C:\\Users\\admin\\eclipse\\PageObjectModel\\testapp\\src\\main\\java\\com\\amazon\\config\\config.properties");

		prop.load(io);

	}

	public void initialization() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\chromedriver.exe");
		driver= new ChromeDriver();
		
		String browsername = prop.getProperty("browser");

		if (browsername.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\chromedriver.exe");
			driver= new ChromeDriver();

		}

		else if (browsername.equals("FF")) {

			System.setProperty("webdriver.gecko.driver", "C:\\Users\\admin\\geckodriver.exe");
			driver = new FirefoxDriver();

		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().getImplicitWaitTimeout();

		driver.get(prop.getProperty("URL")); // use config file properties
	}



}
