package JBWindows.CRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.BaseClass;
import commonClass.GenericMethods;

public class CRM_CustomerFeedbackPopup extends BaseClass{
	
	@FindBy(id = "CRM_CustomerFeedbackPopup") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	@FindBy(id = "lookUpCustomer") WebElement lookUpCustomer;
	@FindBy(id = "lookUpInvoiceNo") WebElement lookUpInvoiceNo;
	@FindBy(id = "picHappy") WebElement picHappy;
	@FindBy(id = "picNutral") WebElement picNutral;
	@FindBy(id = "picSad") WebElement picSad;
	@FindBy(id = "memoComments") WebElement memoComments;
	@FindBy(id = "btnNoThanks") WebElement BtnNoThanks;
	@FindBy(id = "btnSend") WebElement BtnSend;

	public CRM_CustomerFeedbackPopup() {
		PageFactory.initElements(driver, this);
	}

	public void activatePage() {
		pageName.click();
	}
	
	public void clickCloseButton()
	{
		BtnClose.click();
	}
	
	public void clickNoThanksButton()
	{
		BtnNoThanks.click();
	}

	public void clickSendButton()
	{
		BtnSend.click();
	}
	
	//---21-Feb-2018---Added by Moumita-----
	public void enterComments() {
		
		memoComments.sendKeys("Demo Commect");
		GenericMethods.fnwait(1);
		clickSendButton();
	}
	
	public void emoticonSelection(String Emotion) {
			switch(Emotion.toUpperCase())
			{
			case "HAPPY" : picHappy.click(); break;
			case "NUTRAL" : picNutral.click(); break;
			case "SAD" : picSad.click(); break;			
			}

		}
	}
	

