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

public class ProductionPage extends BaseClass {
	
	@FindBy (id="btnDashBoard")
	WebElement btnDashboard;
	@FindBy (id="LookupFinishedGood")
	WebElement FinishedGood;
	@FindBy (id="calcQuantity")
	WebElement Quantity;
	@FindBy (id="LookUpBOM")
	WebElement BOM;
	@FindBy (name="Product Name row 0")
	WebElement ProductNameRow0;
	@FindBy (name="Quantity row 0")
	WebElement QuantityRow0;
	@FindBy (name="Product Name row 1")
	WebElement ProductNameRow1;
	@FindBy (name="Quantity row 1")
	WebElement QuantityRow1;
	@FindBy (name="Cost Price row 1")
	WebElement CostPriceRow1;
	@FindBy (id="calcLabourCost")
	WebElement LabourCost;
	@FindBy (id="calcLoadingCost")
	WebElement LoadingCost;
	@FindBy (id="calcOverheadCost")
	WebElement OverheadCost;
	@FindBy (id="calcWastageCost")
	WebElement WastageCost;
	@FindBy (id="calcMaterialCost")
	WebElement MaterialCost;
	@FindBy (id="calcUnitprice")
	WebElement Unitprice;
	@FindBy (id="picLogo")
	WebElement JBLogo;
	@FindBy (id="picClose")
	WebElement Close;
	@FindBy (id="btnSaveBOM")
	WebElement SaveBOM;
	@FindBy (id="btnSave")
	WebElement Save;
	@FindBy (id="btnCancel")
	WebElement Cancel;
	@FindBy (id ="lblHeader")
	WebElement Header;
	@FindBy (id ="btnOk")
	WebElement BtnOk;
	@FindBy(name ="Batch No. row 0")
	WebElement BatchNorow1;
	@FindBy(name ="Lot Size row 0")
	WebElement LotSizerow1;
	@FindBy(name ="Manufacturing Date row 0")
	WebElement ManufacturingDaterow1;
	@FindBy(name ="Expiration Date row 0")
	WebElement ExpirationDaterow1;
	@FindBy(name ="Selected Quantity row 0")
	WebElement SelectedQNTY;
   
	//Intialize WebElements
	   public ProductionPage() {
	   PageFactory.initElements(driver, this);
	}
		
	//Click on dashboard
	 public void click_On_DashBoard() {
	 btnDashboard.click();
     }
	 public void clickCloseButton() {
		 JBLogo.click();
		 Close.click();
		}
	 public void click_on_SaveButton() {
		 Save.click();
	 }
	 public void click_on_SaveBOMButton() {
		 SaveBOM.click();
	 }
	 public void Production_Creation(String Finishedgoods,String QNTY,String ProductStockType,String RawProduct1,String QNTY1,String RawProduct2,String QNTY2,String CostType,String labourcost,String loadingcost,String overheadcost,String wastagecost) throws FindFailed {
		 JBLogo.click();
		 GenericMethods.windows_Set_DropDown_Value(FinishedGood,Finishedgoods);
		 GenericMethods.windows_Set_TextBoxValue(Quantity,QNTY);
		 ProductNameRow0.click();
		 ProductNameRow0.sendKeys(RawProduct1);
		 switch(ProductStockType) {
		 case "StockNotAllowed":
		 	 Screen screen4 = new Screen();
			 Pattern pr4 = new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\Product3.PNG");
			 screen4.click(pr4);
			 GenericMethods.windows_Set_TextBoxValue(QuantityRow0,QNTY1);
			  break;
		 case "StockAllowed":
		 Screen screen1 = new Screen();
		 Pattern pr1 = new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\Product1.PNG");
		  screen1.click(pr1);
		 GenericMethods.windows_Set_TextBoxValue(QuantityRow0,QNTY1);
		 GenericMethods.fnwait(2);
		 Screen screen2 = new Screen();
		 Pattern pr2 = new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\AddButton.PNG");
		  screen2.click(pr2);
		  GenericMethods.fnwait(2);
		  ProductNameRow1.click();
		  ProductNameRow1.sendKeys(RawProduct2);
			 Screen screen3 = new Screen();
			 Pattern pr3 = new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\Product2.PNG");
			  screen3.click(pr3);
			  GenericMethods.windows_Set_TextBoxValue(QuantityRow1,QNTY2);
		  CostPriceRow1.click();
	     break;
	}
			 switch(CostType) {
			 case "LabourCost":
				 GenericMethods.windows_Set_TextBoxValue(LabourCost, labourcost);
				 break;
			 case "LoadingCost":
				 GenericMethods.windows_Set_TextBoxValue(LoadingCost,loadingcost);
				 break;
			 case "OverheadCost":
				 GenericMethods.windows_Set_TextBoxValue(OverheadCost,overheadcost);
				 break;
			 case "WastageCost":
				 GenericMethods.windows_Set_TextBoxValue(WastageCost,wastagecost);
				 break;
			 case "All":
				 GenericMethods.windows_Set_TextBoxValue(LabourCost, labourcost);
				 GenericMethods.windows_Set_TextBoxValue(LoadingCost,loadingcost);
				 GenericMethods.windows_Set_TextBoxValue(OverheadCost,overheadcost);
				 GenericMethods.windows_Set_TextBoxValue(WastageCost,wastagecost);
				 break;
			}
			
	}
	public boolean Check_Material_and_UnitPrice_Costs(String SaveType) {
		 
		String MaterialCost = (driver.findElement(By.id("calcMaterialCost")).getAttribute("Name"));
		String UnitPriceCost = (driver.findElement(By.id("calcUnitprice")).getAttribute("Name"));
		if(MaterialCost!=UnitPriceCost) {
			switch(SaveType) {
			case"BOM":
				SaveBOM.click();
				break;
			case"Save":
			    Save.click();
				break;
		       }
			Header.click();
			BtnOk.click();
			  return true;
			 }
		
               return false;
		}
	public void Production_Creation_without_adding_Rawproducts(String Finishedgoods,String QNTY,String SaveType) {
		 JBLogo.click();
		 GenericMethods.windows_Set_DropDown_Value(FinishedGood,Finishedgoods);
		 GenericMethods.windows_Set_TextBoxValue(Quantity,QNTY);
		 switch(SaveType) {
		   case"BOM":
		   SaveBOM.click();
		   break;
			case"Save":
			Save.click();
			break;
		       }
		}
	public boolean Validate_Production_Creation_Without_adding_Rawproducts() {
		Header.click();
		if(driver.findElement(By.id("lblMessage")).getAttribute("Name").contains("Are you sure that you want to proceed without selecting raw material product for production?".trim())){
			GenericMethods.fnwait(1);
			BtnOk.click();
			Header.click();
			BtnOk.click();
			return true;
		}
		return false;
	
   }
	public boolean Validate_Production_Creation_with_the_raw_material_Without_having_no_stock_and_not_allowed_to_negative_stock() {
		GenericMethods.fnwait(3);
		 Save.click();
		Header.click();
		if(driver.findElement(By.id("lblMessage")).getAttribute("Name").contains("Product is out of stock.".trim())){
			GenericMethods.fnwait(1);
			BtnOk.click();
			return true;
		}
		return false;
	
   }
	public boolean Validate_Production_of_BOMCreation_Without_adding_Rawproducts() {
		Header.click();
		if(driver.findElement(By.id("lblMessage")).getAttribute("Name").contains("Please select a product.".trim())){
			GenericMethods.fnwait(1);
			BtnOk.click();
			return true;
		}
		return false;
    }
	public void BatchNo_Generation_for_Production(String Finishedgoods,String QNTY,String ProductType,String BatchNo1,String Lotsize,String ManufacturingDate,String ExpiryDate,String RawProduct4,String QNTY4,String SelectedQuantity) throws FindFailed {
		 JBLogo.click();
		 GenericMethods.windows_Set_DropDown_Value(FinishedGood,Finishedgoods);
		 GenericMethods.windows_Set_TextBoxValue(Quantity,QNTY);
		 switch(ProductType) {
		   case"FinishedGood":
			 ProductNameRow0.click();
			 JBLogo.click();
			 BatchNorow1.sendKeys(BatchNo1);
			 LotSizerow1.sendKeys(Lotsize);
			 ManufacturingDaterow1.sendKeys(ManufacturingDate);
			 ExpirationDaterow1.sendKeys(ExpiryDate);
			 GenericMethods.fnwait(1);
			 break;
		   case"RawMaterials":
			     ProductNameRow0.click();
				 ProductNameRow0.sendKeys(RawProduct4);
				 Screen screen1 = new Screen();
				 Pattern pr1 = new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\Product4.PNG");
				 screen1.click(pr1);
				 GenericMethods.windows_Set_TextBoxValue(QuantityRow0,QNTY4);
				 GenericMethods.fnwait(2);
				 Screen screen2 = new Screen();
				 Pattern pr2 = new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\AddButton.PNG");
				  screen2.click(pr2);
				  JBLogo.click();
			      GenericMethods.windows_Set_TextBoxValue(SelectedQNTY,SelectedQuantity);
			  break;
		}
	}
}









	 





