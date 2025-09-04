package JBWindows.FRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonClass.BaseClass;
import commonClass.GenericMethods;

public class FRM_PaymentNotes extends BaseClass {
	
	@FindBy(id = "FRM_PaymentNotes") WebElement pageName;
	@FindBy(id = "picClose") WebElement BtnClose;
	
	@FindBy(id = "calcNetAmount") WebElement calcNetAmount;
	@FindBy(id = "calcChangeAmount") WebElement calcChangeAmount;
	@FindBy(id = "calcReceivedAmount") WebElement calcReceivedAmount;
	@FindBy(id = "btnClear") WebElement BtnClear;
		
	@FindBy(name = "₹ 5") WebElement Btnc5;
	@FindBy(name = "₹ 10") WebElement Btnc10;
	@FindBy(name = "₹ 20") WebElement Btnc20;
	@FindBy(name = "₹ 50") WebElement Btnc50;
	@FindBy(name = "₹ 100") WebElement Btnc100;
	@FindBy(name = "₹ 500") WebElement Btnc500;
	@FindBy(name = "₹ 1000") WebElement Btnc1000;
	@FindBy(name = "₹ 2000") WebElement Btnc2000;
	
	//---26--April-2018--modified by Moumita--------
	@FindBy(id = "btn1") WebElement btn1;
	@FindBy(id = "btn2") WebElement btn2;
	@FindBy(id = "btn3") WebElement btn3;
	@FindBy(id = "btn4") WebElement btn4;
	@FindBy(id = "btn5") WebElement btn5;
	@FindBy(id = "btn6") WebElement btn6;
	@FindBy(id = "btn7") WebElement btn7;
	@FindBy(id = "btn8") WebElement btn8;
	@FindBy(id = "btn9") WebElement btn9;
	@FindBy(id = "btn0") WebElement btn0;
	@FindBy(id = "btn00") WebElement btn00;
	@FindBy(id = "btnDot") WebElement btnDot;
	
	@FindBy(id = "btnBack") WebElement BtnNpBack;
	@FindBy(id = "btnEnter") WebElement BtnNpEnter;
	
	@FindBy(id = "btnNotes1") WebElement BtnPossibleDenominationPlace1;
	@FindBy(id = "btnNotes2") WebElement BtnPossibleDenominationPlace2;
	@FindBy(id = "btnNotes3") WebElement BtnPossibleDenominationPlace3;
	@FindBy(id = "btnNotes4") WebElement BtnPossibleDenominationPlace4;
	@FindBy(id = "btnNotes5") WebElement BtnPossibleDenominationPlace5;
	@FindBy(id = "btnNotes6") WebElement BtnPossibleDenominationPlace6;
	@FindBy(id = "btnNotes7") WebElement BtnPossibleDenominationPlace7;
	@FindBy(id = "btnNotes8") WebElement BtnPossibleDenominationPlace8;
	@FindBy(id = "btnSave") WebElement BtnSave;
	
	
	public FRM_PaymentNotes() {
		PageFactory.initElements(driver, this);
	}

	public void activatePage() {
		pageName.click();
	}
	
	public void clickCloseButton()
	{
		BtnClose.click();
	}
	
	public void clickClearButton()
	{
		BtnClear.click();
	}
	
	public void clickSaveButton()
	{
		BtnSave.click();
	}

	public void selectCurrency(String CurrencyAmount)
	{
		switch(CurrencyAmount)
		{
		case "5" : Btnc5.click();
		break;
		case "10" : Btnc10.click();
		break;
		case "20" : Btnc20.click();
		break;
		case "50" : Btnc50.click();
		break;
		case "100" : Btnc100.click();
		break;
		case "500" : Btnc500.click();
		break;
		case "1000" : Btnc1000.click();
		break;
		case "2000" : Btnc2000.click();
		break;
		}
	}
	
	public void clickNumPad1Button()
	{
		btn1.click();
	}

	public void clickNumPad2Button()
	{
		btn2.click();
	}
	
	public void clickNumPad3Button()
	{
		btn3.click();
	}
	
	public void clickNumPad4Button()
	{
		btn4.click();
	}
	
	public void clickNumPad5Button()
	{
		btn5.click();
	}
	
	public void clickNumPad6Button()
	{
		btn6.click();
	}
	
	public void clickNumPad7Button()
	{
		btn7.click();
	}
	
	public void clickNumPad8Button()
	{
		btn8.click();
	}
	
	public void clickNumPad9Button()
	{
		btn9.click();
	}
	
	public void clickNumPad0Button()
	{
		btn0.click();
	}
	
	public void clickNumPad00Button()
	{
		btn00.click();
	}
	
	public void clickNumPadDOTButton()
	{
		btnDot.click();
	}
	
	public void ClickNumPadBackButton()
	{
		BtnNpBack.click();
	}
	
	public void ClickNumPadEnterButton()
	{
		BtnNpEnter.click();
	}
	
	public void SelectPossibleDenominationPlace(int placeNumber)
	{
		switch (placeNumber)
		{
		case 1: BtnPossibleDenominationPlace1.click();
		break;
		case 2: BtnPossibleDenominationPlace2.click();
		break;
		case 3: BtnPossibleDenominationPlace3.click();
		break;
		case 4: BtnPossibleDenominationPlace4.click();
		break;
		case 5: BtnPossibleDenominationPlace5.click();
		break;
		case 6: BtnPossibleDenominationPlace6.click();
		break;
		case 7: BtnPossibleDenominationPlace7.click();
		break;
		case 8: BtnPossibleDenominationPlace8.click();
		break;	
		}
	}
	//---26--April-2018--Added by Moumita--------
	//This is the method to complete the payment by Cash Payment mode with entering the amount by number pad. 
	//Parameter is amount
	public void paymentCashByNumberPad(String amount) {		
		for (int i = 0;i < amount.length(); i++){
			char input = amount.charAt(i);
			
			switch (input)
			{
			case '1': clickNumPad1Button();
			GenericMethods.fnwait(1);
			break;
			case '2': clickNumPad2Button();
			GenericMethods.fnwait(1);
			break;
			case '3': clickNumPad3Button();
			GenericMethods.fnwait(1);
			break;
			case '4': clickNumPad4Button();
			GenericMethods.fnwait(1);
			break;
			case '5': clickNumPad5Button();
			GenericMethods.fnwait(1);
			break;
			case '6': clickNumPad6Button();
			GenericMethods.fnwait(1);
			break;
			case '7': clickNumPad7Button();
			GenericMethods.fnwait(1);
			break;
			case '8': clickNumPad8Button();
			GenericMethods.fnwait(1);
			break;	
			case '9': clickNumPad9Button();
			GenericMethods.fnwait(1);
			break;	
			case '0': clickNumPad0Button();
			GenericMethods.fnwait(1);
			break;
			case '.': clickNumPadDOTButton();
			GenericMethods.fnwait(1);
			break;
		}		
	}
}
}

