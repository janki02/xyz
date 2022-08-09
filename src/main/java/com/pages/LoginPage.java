package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	private By Email = By.id("Email");
	private By PassWord = By.id("Password");
	private By CheckBox = By.id("RememberMe");
	private By Login = By.xpath("//div[@class=\"buttons\"]/child::*");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String Login_Page_Title() {
		return driver.getTitle();
	}

	public boolean Login_CheckBox() {
		return driver.findElement(CheckBox).isDisplayed();
	}

	public void Enter_EmailID(String E_id) {
		driver.findElement(Email).clear();
		driver.findElement(Email).sendKeys(E_id);
	}

	public void Enter_Password(String pwd) {
		driver.findElement(PassWord).clear();
		driver.findElement(PassWord).sendKeys(pwd);

	}

	public void click_on_Login_button() {
		driver.findElement(Login).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String Home_Page_Title() {
		return driver.getTitle();
	}
	
	public HomePage DoLogin (String e, String p) {
		System.out.println("Login with: "+ e + "And " + p);
		driver.findElement(Email).clear();
		driver.findElement(Email).sendKeys(e);
		driver.findElement(PassWord).clear();
		driver.findElement(PassWord).sendKeys(p);
		driver.findElement(Login).click();
		return new HomePage(driver);
		
	}
	}
