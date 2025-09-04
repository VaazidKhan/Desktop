package JBWindows.FRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.BaseClass;
import commonClass.GenericMethods;

public class FRM_PaymentByCard extends BaseClass {

	@FindBy(id = "FRM_PaymentByCard")
	WebElement pageName;
	@FindBy(id = "picClose")
	WebElement BtnClose;

	@FindBy(id = "calcAmount")
	WebElement calcAmount;
	@FindBy(id = "textCardNo")
	WebElement textCardNo;
	@FindBy(id = "touchPad1")
	WebElement touchPad1;

	@FindBy(id = "btnCancel")
	WebElement BtnCancel;
	@FindBy(id = "btnSave")
	WebElement BtnSave;

	// ---27--April-2018--Added by Moumita--------
	@FindBy(id = "buttonOne")
	WebElement buttonOne;
	@FindBy(id = "buttonTwo")
	WebElement buttonTwo;
	@FindBy(id = "buttonThree")
	WebElement buttonThree;
	@FindBy(id = "buttonFour")
	WebElement buttonFour;
	@FindBy(id = "buttonFive")
	WebElement buttonFive;
	@FindBy(id = "buttonSix")
	WebElement buttonSix;
	@FindBy(id = "buttonSeven")
	WebElement buttonSeven;
	@FindBy(id = "buttonEight")
	WebElement buttonEight;
	@FindBy(id = "buttonNine")
	WebElement buttonNine;
	@FindBy(id = "buttonZero")
	WebElement buttonZero;
	@FindBy(id = "buttonDot")
	WebElement buttonDot;

	public FRM_PaymentByCard() {
		PageFactory.initElements(driver, this);
	}

	public void activatePage() {
		pageName.click();
	}

	public void clickCloseButton() {
		BtnClose.click();
	}

	public void clickCancelButton() {
		BtnCancel.click();
	}

	public void clickSaveButton() {
		BtnSave.click();
	}

	// ----19-Feb-18----added by Moumita---------
	//This is the method to collect the full payment by card payment mode
	public void collectFullPaymentByCard() {

		textCardNo.sendKeys("1234");
		clickSaveButton();
		GenericMethods.fnwait(1);

	}

	// ---27--April-2018--Added by Moumita--------
	//This is the method to get the single character from the amount input of string type
	//Parameter is amount
	public void cardPaymentByNumberPad(String amount) {
		for (int i = 0; i < amount.length(); i++) {
			char input = amount.charAt(i);
			
			switch (input) {
			case '1':
				buttonOne.click();
				GenericMethods.fnwait(1);
				break;
			case '2':
				buttonTwo.click();
				GenericMethods.fnwait(1);
				break;
			case '3':
				buttonThree.click();
				GenericMethods.fnwait(1);
				break;
			case '4':
				buttonFour.click();
				GenericMethods.fnwait(1);
				break;
			case '5':
				buttonFive.click();
				GenericMethods.fnwait(1);
				break;
			case '6':
				buttonSix.click();
				GenericMethods.fnwait(1);
				break;
			case '7':
				buttonSeven.click();
				GenericMethods.fnwait(1);
				break;
			case '8':
				buttonEight.click();
				GenericMethods.fnwait(1);
				break;
			case '9':
				buttonNine.click();
				GenericMethods.fnwait(1);
				break;
			case '0':
				buttonZero.click();
				GenericMethods.fnwait(1);
				break;
			case '.':
				buttonDot.click();
				GenericMethods.fnwait(1);
				break;
			}
		}
		
		textCardNo.sendKeys("1234");
		clickSaveButton();
		GenericMethods.fnwait(1);
	}
}
