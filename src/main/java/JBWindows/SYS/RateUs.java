package JBWindows.SYS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonClass.BaseClass;

public class RateUs extends BaseClass {
	
	// Header elements
	@FindBy(id = "picClose")	WebElement btnClose;
	@FindBy(id = "lblCaption")	WebElement PageCaption;
	@FindBy(id = "picLogo")	WebElement HeaderJBLogo;
	
	// Master page elements
	@FindBy(id = "RateUs")	WebElement pageName;
	@FindBy(id = "picHappy")	WebElement picHappy;
	@FindBy(id = "picNutral")	WebElement picNutral;
	@FindBy(id = "picSad")	WebElement picSad;
	@FindBy(id = "memoComments")	WebElement memoComments;

	// Buttons elements
	@FindBy(id = "btnNoThanks")	WebElement btnNoThanks;
	@FindBy(id = "btnSend")	WebElement btnSend;
	
	//WebElement Initialization method
	public RateUs()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void clickSendButton()
	{
		btnSend.click();
	}
	public void clickNoThanksButton()
	{
		btnNoThanks.click();
	}
	public void selectHappyOption()
	{
		picHappy.click();
	}
	public void selectNeutralOption()
	{
		picNutral.click();
	}
	public void selectSadOption()
	{
		picSad.click();
	}

	//Operations
	public void createNewFeedback(String MoodSelection, String givecommment)
	{
		switch (MoodSelection.toUpperCase())
		{
			case "HAPPY" :
				picHappy.click();
				break;
			case "NEUTRAL" :
				picNutral.click();
				break;
			case "SAD":
				picSad.click();
				break;
		}
		memoComments.sendKeys(givecommment);
		//send the changes
		btnSend.click();
		
	}
	
}
