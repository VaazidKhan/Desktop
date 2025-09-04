package JBWindows.Transactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import commonClass.BaseClass;
import commonClass.GenericMethods;

public class Inventory_Adjustment_Page extends BaseClass {
	@FindBy(id = "picLogo")
	WebElement jbPicLogo;
	@FindBy(id ="lblCaption")
	WebElement Caption;
	@FindBy(id = "btnDashBoard")
	WebElement btnDashboard;
	@FindBy (id="lblHeader")
	WebElement header;
	@FindBy(id ="btnOk")
	WebElement BtnOk;
	@FindBy(id ="lookupAdjustmentType")
	WebElement AdjustmentType;
	@FindBy(id ="txtSearch")
	WebElement TxtSearch;
	@FindBy(name ="Quantity row 0")
	WebElement Quantity ;
	@FindBy(id ="btnSave")
	WebElement BtnSave;
	@FindBy(name ="Batch No. row 0")
	WebElement BatchNorow1;
	@FindBy(name ="Lot Size row 0")
	WebElement LotSizerow1;
	@FindBy(name ="Manufacturing Date row 0")
	WebElement ManufacturingDaterow1;
	@FindBy(name ="Expiration Date row 0")
	WebElement ExpirationDaterow1;
	@FindBy(name ="Adjustment")
	WebElement Adjust;
	@FindBy(name ="Stock Allocation")
	WebElement Allocation;
	@FindBy(name ="Selected Quantity row 0")
	WebElement SelectedQUNTY;
	@FindBy(name ="Selected Quantity row 1")
	WebElement SelectedQUNTY1;
	@FindBy(name ="Selected Quantity row 2")
	WebElement SelectedQUNTY2;
	public Inventory_Adjustment_Page() {
		PageFactory.initElements(driver, this);
	}
	public void click_On_Close_Image() {
		jbPicLogo.click();
		driver.findElement(By.id("picClose")).click();
	}
	public void click_On_DashBoard() {
		btnDashboard.click();
	}
	public void click_On_OK_Button() {
		header.click();
		BtnOk.click();
	}
	public boolean Enter_BatchProduct_Details(String BatchProduct,String QNTY,String InventoryHit,String BatchNo1,String Lotsize,String ManufacturingDate,String ExpiryDate,String BatchType,String SelectedQuantity,String SelectedQuantity1,String SelectedQuantity2) {
		GenericMethods.fnwait(3);
		TxtSearch.click();
		TxtSearch.sendKeys(BatchProduct);
		GenericMethods.fnwait(1);
		Quantity.sendKeys(QNTY);
		BtnSave.click();
		GenericMethods.fnwait(1);
		switch(InventoryHit) {
		case "IN":
		jbPicLogo.click();
		BatchNorow1.sendKeys(BatchNo1);
		LotSizerow1.sendKeys(Lotsize);
		ManufacturingDaterow1.sendKeys(ManufacturingDate);
		ExpirationDaterow1.sendKeys(ExpiryDate);
		BtnOk.click();
		break;
		case "OUT":
		Caption.click();
		GenericMethods.fnwait(1);
		switch(BatchType) {
		case "B1":
			
		GenericMethods.windows_Set_TextBoxValue(SelectedQUNTY, SelectedQuantity);
	     break;
		case "B2":
			
		GenericMethods.windows_Set_TextBoxValue(SelectedQUNTY1, SelectedQuantity1);
		break;
		case "B3":
			
		GenericMethods.windows_Set_TextBoxValue(SelectedQUNTY2, SelectedQuantity2);
		break;
		}
		GenericMethods.fnwait(1);
		BtnSave.click();
		break;
	}
		GenericMethods.fnwait(1);
		BtnSave.click();
		BtnOk.click();
		GenericMethods.fnwait(1);
		if(driver.findElement(By.id("lblMessage")).getAttribute("Name").contains("Saved successfully".trim())) {
			BtnOk.click();
			return true;
			
		}
		return false;
		
	}
		public void InventoryAdjustment_with_Different_AdjustmentTypes(String AdjustmentTYPE) throws FindFailed {
          
		Caption.click();
		GenericMethods.fnwait(1);
		/*Adjust.click();
		BtnOk.click();*/
		jbPicLogo.click();
		AdjustmentType.click();
		GenericMethods.fnwait(2);
		
		switch(AdjustmentTYPE) {
		case "Initial Stock" :
			Screen screen=new Screen();
			  Pattern pr = new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\Initialstock.PNG");
			  screen.click(pr);
	   break;
		case "Breakage":
			Screen screen1=new Screen();
			  Pattern pr1 = new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\Breakage.PNG");
			  screen1.click(pr1);
			break;
		case "Incorrect receiving":
			 Screen screen2=new Screen();
			  Pattern pr2 = new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\IncorrectReceiving.PNG");
			  screen2.click(pr2);
			break;
		case "Loss":
			 Screen screen3=new Screen();
			  Pattern pr3 = new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\Loss.PNG");
			  screen3.click(pr3);
			break;
		case "Others - stock In":
			 Screen screen4=new Screen();
			 Pattern pr4;
			   pr4=new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\SmallArrowDown.PNG");
			   screen4.click(pr4);
			   screen4.click(pr4);
			   GenericMethods.fnwait(2);
			  pr4 = new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\Others-Stock-IN.PNG");
			  screen4.click(pr4);
			break;
		case "Others - stock Out":
			 Screen screen5=new Screen();
			  Pattern pr5 ;
			  pr5=new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\SmallArrowDown.PNG");
			   screen5.click(pr5);
			   screen5.click(pr5);
			   screen5.click(pr5);
			   GenericMethods.fnwait(2);
			  pr5 = new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\Others-Stock-OUT.PNG");
			  screen5.click(pr5);
			break;
		case "Over shipments":
			 Screen screen6=new Screen();
			  Pattern  pr6 = new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\OverShipments.PNG");
			  screen6.click(pr6);
			break;
		case "Physical Count-IN":
			 Screen screen7=new Screen();
			  Pattern pr7;
			  pr7=new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\SmallArrowDown.PNG");
			   screen7.click(pr7);
			   screen7.click(pr7);
			   screen7.click(pr7);
			   screen7.click(pr7);
			   GenericMethods.fnwait(2);
			   pr7 = new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\Physical-Count-IN.PNG");
			  screen7.click(pr7);
			break;
		case "Physical Count-Out":
			 Screen screen8=new Screen();
			  Pattern pr8;
			pr8=new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\SmallArrowDown.PNG");
			   screen8.click(pr8);
			   screen8.click(pr8);
			   screen8.click(pr8);
			   screen8.click(pr8);
			   screen8.click(pr8);
			   GenericMethods.fnwait(2);
			  pr8 = new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\Physical-Count-OUT.PNG");
			  screen8.click(pr8);
			break;
		case "Spoilt":
			 Screen screen9=new Screen();
			  Pattern pr9;
			  pr9=new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\SmallArrowDown.PNG");
			   screen9.click(pr9);
			   screen9.click(pr9);
			   screen9.click(pr9);
			   screen9.click(pr9);
			   screen9.click(pr9);
			   screen9.click(pr9);
			   GenericMethods.fnwait(2);
			  pr9 = new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\Spoilt.PNG");
			  screen9.click(pr9);
			break;
		case "Theft":
			 Screen screen10=new Screen();
			  Pattern pr10 = new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\Theft.PNG");
			  screen10.click(pr10);
			break;
		case "Wastage":
			 Screen screen11=new Screen();
			  Pattern pr11 = new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\Wastage.PNG");
			  screen11.click(pr11);
			break;
		
 }
		
	}
}
   

