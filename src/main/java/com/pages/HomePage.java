package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	private WebDriver driver;
	private By Logo = By.xpath("//a[@class=\"brand-link navbar-dark logo-switch\"]/child::*");
	private By LinkCount = By.xpath("//ul[@class=\"nav nav-pills nav-sidebar flex-column nav-legacy\"]/child::*");
	private By Logout = By.xpath("//ul[@class=\"navbar-nav ml-auto pl-2\"]/child::li[@class=\"nav-item\"]/descendant::a[@class=\"nav-link\"]");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	public String Home_Page_Title() {
		return driver.getTitle();
	} 
	
	public boolean nopcommerce_Logo() {
		return driver.findElement(Logo).isDisplayed();
	}
	
	public int Home_Page_Link_Count() {
		return driver.findElements(LinkCount).size();
	}
	
	public List<String> Dashboard_Link() {
		List<String> DashbordLink = new ArrayList<>();
		List<WebElement>LinkName = driver.findElements(LinkCount);
		
		for(WebElement L :LinkName) {
		String Text =L.getText();
		System.out.println("LinkName: " +Text);
		DashbordLink.add(Text);
		}
		return DashbordLink;
	
	}
	
	public WebElement Logout() {
		return driver.findElement(Logout);
	}
	
	
	
	
}
