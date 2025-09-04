package JBWindows.Configurations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonClass.BaseClass;
import commonClass.GenericMethods;

public class SalesConfigurations extends BaseClass {
	//WebElements 
	@FindBy(id="btnSalesConfiguration") WebElement BtnSalesConfiguration;
	@FindBy(id="lookUpEdit") WebElement SalesOrderandDelivery;
	@FindBy(id="chkDefault") WebElement Default;
    @FindBy(id="picLogo") WebElement Logo;
    @FindBy(id="picClose") WebElement btnClose;
    @FindBy(id="btnSalesConfigurationSave") WebElement SalesConfigurationSave;
    @FindBy(id ="btnOk")   WebElement BtnOk;
	@FindBy(id="btnSave") WebElement SaveOrder;
	@FindBy (id ="btnCustomer") WebElement SelectCustomer;
	@FindBy (id ="txtSearch") WebElement TxtSearch;
	@FindBy(id="memoInstruction") WebElement MEMOInstruction;
	@FindBy (id ="btnDashBoard") WebElement BtnDashboard;
	@FindBy(id="txtArea") WebElement AREA;
	@FindBy(id="btnPayment") WebElement SaveEstimation;
	@FindBy(id="btnRecall")  WebElement BtnRecall;
	@FindBy(id="btnConvert")  WebElement BtnConvert;
	@FindBy(id="btnDelivery")  WebElement BtnDelivery;
	@FindBy(id="btnReturn")  WebElement BtnReturn;
	@FindBy (id ="btnCash") WebElement BtnCash;
	@FindBy (id ="btnFinish") WebElement BtnFinish;
	@FindBy(id="btnExchange") WebElement BtnExchange;
	@FindBy(name="Delivery row 0")  WebElement DeliveryRow;
	@FindBy(id="btnProcess")  WebElement BtnProcess;
	// Action
	public void clickCloseButton()
	{
		btnClose.click();
	}
	//  WebElement Initialization method
    public SalesConfigurations() {
		PageFactory.initElements(driver, this);
	}
    
    // This method for fnSalesConfiguration :
    public void fnSalesConfiguration(String SaleOrdertype) {
    	
    	if(BtnSalesConfiguration.isDisplayed()) {
    		BtnSalesConfiguration.click();
		}
    	if(SalesOrderandDelivery.isDisplayed()&&SalesOrderandDelivery.isEnabled()) {
    		GenericMethods.windows_Set_DropDown_Value(SalesOrderandDelivery, SaleOrdertype);
			fnWriteSteps("Pass", "SalesOrderType field is present and Enable");
		} 
    	if(Default.isDisplayed()&&Default.isEnabled()) {
    		Default.click();
    	}
    	if(SalesConfigurationSave.isDisplayed()) {
			SalesConfigurationSave.click();
			GenericMethods.fnwait(2);
			BtnOk.click();
			GenericMethods.fnwait(1);
			driver.findElement(By.id("picLogo")).click();
			GenericMethods.fnwait(1);
			clickCloseButton();
		}
    	
    }
    // This method for Validation of SalesOrdertype as HomeDeliveryMode or not :
    public boolean Verify_SalesOrderType_as_HomeDeliveryMode_or_not() {
    	
    	String Expected = "Home Delivery";
    	String Actual = driver.findElement(By.id("btnSalesOrderType")).getAttribute("Name");
		 if (Actual.substring(0,13).equalsIgnoreCase(Expected)) {
			       
			        GenericMethods.fnwait(1);
			        BtnDashboard.click();
			        
				   return true;
			       
			  }
				
				   return false;
			}	
    	 
    // This method for EstimationConversion with HomeDeliveryMode :
    public boolean EstimationConversion_with_HomeDeliveryMode(String SelectedCustomer,String strProduct,String Area,String Instruction) {
    	
    	  SelectCustomer.click();
		  GenericMethods.windows_Set_DropDown_Value(TxtSearch,SelectedCustomer);
		  GenericMethods.fnwait(1);
		  GenericMethods.windows_Set_TextBoxValue(TxtSearch,strProduct);
		  GenericMethods.fnwait(1);
		  SaveEstimation.click();
		  GenericMethods.fnwait(1);
		  BtnOk.click();
		  GenericMethods.fnwait(1);
		  BtnRecall.click();
		  BtnOk.click();
		  GenericMethods.fnwait(1);
		  BtnConvert.click();
		  GenericMethods.fnwait(1);
		  BtnOk.click();
		  GenericMethods.fnwait(1);
		  GenericMethods.windows_Set_TextBoxValue(AREA,Area);
		  SaveOrder.click();
		  GenericMethods.fnwait(1);
		  GenericMethods.windows_Set_TextBoxValue(MEMOInstruction,Instruction);
		  SaveOrder.click();
		  BtnOk.click();
		  GenericMethods.fnwait(2);
		  String Expected = "Home Delivery";
	    	String Actual = driver.findElement(By.id("btnSalesOrderType")).getAttribute("Name");
			 if (Actual.substring(0,13).equalsIgnoreCase(Expected)) {
				       
				        GenericMethods.fnwait(1);
				        BtnDashboard.click();
				        BtnOk.click();
					   return true;
				       
				  }
					
					   return false;
				}	
		 
     }
