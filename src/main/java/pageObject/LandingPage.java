package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	private By login = By.xpath("//a[contains(@class,'navbar-right')]");
	private By logout = By.partialLinkText("Log out");
	private By navBar = By.className("container");
	private By messageBox = By.className("jumbotron");
	
	
	public WebElement getLogin() {
		return driver.findElement(login);
	}
	
	public WebElement getLogout() {
		return driver.findElement(logout);
	}
	
	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}
	
	public WebElement getMessageBox() {
		return driver.findElement(messageBox);
	}
}
