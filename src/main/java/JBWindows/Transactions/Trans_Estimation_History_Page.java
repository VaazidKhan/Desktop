package JBWindows.Transactions;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import commonClass.BaseClass;
import commonClass.GenericMethods;

public class Trans_Estimation_History_Page extends BaseClass {
	
	@FindBy (id="TxtSearch")
	WebElement searchBox;
	
	@FindBy (id="btnEdit")
	WebElement EditButton;
	
	@FindBy (id="btnConvertToOrder")
	WebElement btnConvertToOrder;
	
	@FindBy (id="btnConvertToInvoice")
	WebElement btnConvertToInvoice;
	
	@FindBy (id="btnShare")
	WebElement btnShare;
	
	@FindBy (id="btnPrint")
	WebElement btnPrint;
	
	@FindBy (id="picClose")
	WebElement imgClose;
	@FindBy (id="picLogo")
	WebElement table;
	
	public Trans_Estimation_History_Page() {
		PageFactory.initElements(driver,this);
	}
	//Functions
	public void estimation_Edit(String strEstimation) throws FindFailed {
		GenericMethods.fnwait(4);
		System.out.println("table ");
		Screen screen=new Screen();
		org.sikuli.script.Pattern pattern=new org.sikuli.script.Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\Capture1.PNG");
		screen.click(pattern);
	
		//table.click();
		//Actions act=new Actions(driver);
		//act.moveToElement(table).click();
	
		System.out.println("search");
		searchBox.sendKeys(strEstimation);
		EditButton.click();
	}
	public boolean validate_Estimation_Converted_To_Order_Invoice_Modification(String strVochure) {
		GenericMethods.fnwait(1);
		table.click();
		GenericMethods.fnwait(1);
		GenericMethods.windows_Set_TextBoxValue(searchBox, strVochure);
		GenericMethods.fnwait(2);
		int editButton=driver.findElements(By.id("lookUpEdit")).size();
	/*	if(!btnEdit.isDisplayed()) {
			return true;
		}*/
		if(editButton==0) {
			return true;
		}
		return false;
		
	}

}
