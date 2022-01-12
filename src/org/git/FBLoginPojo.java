package org.git;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FBLoginPojo extends BaseClass{
	public FBLoginPojo() {
	PageFactory.initElements(driver, this);
	}
		
		@FindBy(id="email")
	
	private WebElement TxtUser;		
		
		
			@FindBy(id="pass")		
		
	private WebElement Txtpass;
		
		
		@FindBy(name = "login")
		
	private WebElement loginBtn;


		public WebElement getTxtUser() {
			return TxtUser;
		}


		public WebElement getTxtpass() {
			return Txtpass;
		}


		public WebElement getLoginBtn() {
			return loginBtn;
		}
		
		
		
	}

