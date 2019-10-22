package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	public WebDriver driver;
	

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	private By username = By.name("username");
	private By password = By.name("password");
	private By loginButton = By.xpath("//input[contains(@class,'btn-primary')]");
	
	public WebElement getUsername() {
		return driver.findElement(username);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement getLoginButton() {
		return driver.findElement(loginButton);
	}
}
