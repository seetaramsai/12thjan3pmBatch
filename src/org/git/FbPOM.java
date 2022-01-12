package org.git;

import org.openqa.selenium.WebElement;

public class FbPOM extends BaseClass{
	
	public static void main(String[] args) {
		
		browserlaunch();
		launchUrl("https://en-gb.facebook.com/");
		maxiWindow();
	
	FBLoginPojo p = new FBLoginPojo();
	
	WebElement txtUser = p.getTxtUser();
	txtUser.sendKeys("java");
	
	WebElement txtpass = p.getTxtpass();
	txtpass.sendKeys("java@321");
	
	WebElement btn = p.getLoginBtn();
	btn.click();
	
	WebElement loginBtn = p.getLoginBtn();
	loginBtn.Click();
	
	}

}
