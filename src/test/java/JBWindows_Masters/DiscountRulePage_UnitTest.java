package JBWindows_Masters;


import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.testng.annotations.Test;

import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.SAL.SAL_DiscountRule;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class DiscountRulePage_UnitTest extends BaseClass {

	Login refLogin;
	APP_Dashboard refDashboard;
	APP_Menu refMenu;
	MessageBoxEffia refMessageBoxEffia;
	SAL_DiscountRule refDiscount;

	public DiscountRulePage_UnitTest() {
		super();
	}

	
	@BeforeMethod
	public void fnBeforeMethod() throws InterruptedException {
		GenericMethods.fnStartTestCase("fn Login and Open Page");
		DOMConfigurator.configure("log4j.xml");
		refLogin = new Login(driver);
		refDashboard = new APP_Dashboard(driver);
		refMenu = new APP_Menu(driver);
		refMessageBoxEffia = new MessageBoxEffia(driver);
		refDiscount = new SAL_DiscountRule();
		GenericMethods.fnwait(24);
		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		refLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(10);
	    refDashboard.clickMenuBtn();
		GenericMethods.fnwait(2);
		refMenu.OpenPage("Discount Rules");
		GenericMethods.fnwait(1);
		fnWriteSteps("Pass", "Application open successfully");
		GenericMethods.fnEndTestCase();
		
	}	

	@Test 
	public void fnVerifyFieldVisibility() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of Discount Rule add entry are present or not ");
		refDiscount.verifyFieldVisibility();		
        GenericMethods.fnEndTestCase();
	}

	@Test 
	public void fnVerifyFieldEnableOrNot() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of Discount Rule add entry are enable or not");
	     refDiscount.verifyFieldEnableOrNot();
		 GenericMethods.fnEndTestCase(); 
	}

	@Test 
	public void fnActive_DiscountRuleCreation_withDiscountType_Item() {
		GenericMethods.fnStartTestCase("Verify Active DiscountRule creation withDiscountType_Item");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Discount";
	    int RowNumber = 3;
	    String DiscountName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String DiscountType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String SaleQuantity = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String Promocode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String FixedAmount = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String Percentage = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String MinDiscountAmt = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String MaxDiscountAmt = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		refDiscount.createNewDiscountRule(DiscountName,DiscountType,SaleQuantity,Promocode,FixedAmount,Percentage,Description,MinDiscountAmt,MaxDiscountAmt,Inactive);
		boolean result = refDiscount.Verify_DiscountRule_SaveorNot(DiscountName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Active Item_DiscountRule has been Created & Saved");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnInActive_DiscountRuleCreation_withDiscountType_Item() {
		GenericMethods.fnStartTestCase("Verify Inactive DiscountRule creation withDiscountType_Item");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Discount";
	    int RowNumber = 4;
	    String DiscountName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String DiscountType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String SaleQuantity = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String Promocode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String FixedAmount = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String Percentage = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String MinDiscountAmt = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String MaxDiscountAmt = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		refDiscount.createNewDiscountRule(DiscountName,DiscountType,SaleQuantity,Promocode,FixedAmount,Percentage,Description,MinDiscountAmt,MaxDiscountAmt,Inactive);
		boolean result = refDiscount.Verify_DiscountRule_SaveorNot(DiscountName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Inactive Item_DiscountRule has been Created & Saved");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnDiscountRuleCreation_withDiscountType_Item() {
		GenericMethods.fnStartTestCase("Verify DiscountRule creation withDiscountType_Item");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Discount";
	    int RowNumber = 5;
	    String DiscountName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String DiscountType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String SaleQuantity = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String Promocode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String FixedAmount = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String Percentage = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String MinDiscountAmt = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String MaxDiscountAmt = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		refDiscount.createNewDiscountRule(DiscountName,DiscountType,SaleQuantity,Promocode,FixedAmount,Percentage,Description,MinDiscountAmt,MaxDiscountAmt,Inactive);
		boolean result = refDiscount.Verify_DiscountRule_SaveorNot(DiscountName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Item_DiscountRule has been Created & Saved");
		GenericMethods.fnEndTestCase();
	}
	/*@Test 
	public void fnDiscountRuleEdit_withDiscountType_Item() {
		GenericMethods.fnStartTestCase("Verify DiscountRule Edit withDiscountType_Item ");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Discount";
	    int RowNumber = 6;
	    String OldDiscountName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
	    String DiscountName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String DiscountType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String SaleQuantity = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String Promocode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String FixedAmount = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String Percentage = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String MinDiscountAmt = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String MaxDiscountAmt = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
	    refDiscount.verifyDiscountEdit(OldDiscountName,DiscountName,DiscountType,SaleQuantity,Promocode,FixedAmount,Percentage,Description,MinDiscountAmt,MaxDiscountAmt);
		boolean result = refDiscount.Verify_DiscountRule_SaveorNot(DiscountName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Item_DiscountRule has been Updated & Saved");
		GenericMethods.fnEndTestCase();
	}
	*/
	@Test 
	public void fnDiscountRuleCreation_withDiscountType_Item_for_WithoutInternet() {
		GenericMethods.fnStartTestCase("Verify DiscountRule creation withDiscountType_Item for withoutInternet");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Discount";
	    int RowNumber = 7;
	    String DiscountName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String DiscountType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String SaleQuantity = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String Promocode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String FixedAmount = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String Percentage = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String MinDiscountAmt = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String MaxDiscountAmt = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		refDiscount.createNewDiscountRule(DiscountName,DiscountType,SaleQuantity,Promocode,FixedAmount,Percentage,Description,MinDiscountAmt,MaxDiscountAmt,Inactive);
		boolean result = refDiscount.Verify_DiscountRule_SaveorNot(DiscountName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Item_DiscountRule has been Created & Saved");
		GenericMethods.fnEndTestCase();
	}
	
	@Test 
	public void fnActive_DiscountRuleCreation_withDiscountType_Invoice() {
		GenericMethods.fnStartTestCase("Verify Active DiscountRule creation withDiscountType_Invoice");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Discount";
	    int RowNumber = 1;
	    String DiscountName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String DiscountType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String SaleQuantity = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		String Promocode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String FixedAmount = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
	    String Percentage = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String MinDiscountAmt = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String MaxDiscountAmt = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		refDiscount.createNewDiscountRule(DiscountName,DiscountType,SaleQuantity,Promocode,FixedAmount,Percentage,Description,MinDiscountAmt,MaxDiscountAmt,Inactive);
		boolean result = refDiscount.Verify_DiscountRule_SaveorNot(DiscountName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Active Invoice_DiscountRule has been Created & Saved");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnInActive_DiscountRuleCreation_withDiscountType_Invoice() {
		GenericMethods.fnStartTestCase("Verify InActive DiscountRule creation withDiscountType_Invoice");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Discount";
	    int RowNumber = 2;
	    String DiscountName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String DiscountType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String SaleQuantity = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		String Promocode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String FixedAmount = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
	    String Percentage = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String MinDiscountAmt = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String MaxDiscountAmt = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		refDiscount.createNewDiscountRule(DiscountName,DiscountType,SaleQuantity,Promocode,FixedAmount,Percentage,Description,MinDiscountAmt,MaxDiscountAmt,Inactive);
		boolean result = refDiscount.Verify_DiscountRule_SaveorNot(DiscountName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "InActive Invoice_DiscountRule has been Created & Saved");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnDiscountRuleCreation_withDiscountType_Invoice() {
		GenericMethods.fnStartTestCase("Verify DiscountRule creation withDiscountType_Invoice");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Discount";
	    int RowNumber = 9;
	    String DiscountName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String DiscountType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String SaleQuantity = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		String Promocode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String FixedAmount = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
	    String Percentage = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String MinDiscountAmt = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String MaxDiscountAmt = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		refDiscount.createNewDiscountRule(DiscountName,DiscountType,SaleQuantity,Promocode,FixedAmount,Percentage,Description,MinDiscountAmt,MaxDiscountAmt,Inactive);
		boolean result = refDiscount.Verify_DiscountRule_SaveorNot(DiscountName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Invoice_DiscountRule has been Created & Saved");
		GenericMethods.fnEndTestCase();
	}
	/*@Test 
	public void fnDiscountRuleEdit_withDiscountType_Invoice() {
		GenericMethods.fnStartTestCase("Verify DiscountRule Edit withDiscountType_Invoice");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Discount";
	    int RowNumber = 11;
	    String OldDiscountName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
	    String DiscountName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String DiscountType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String SaleQuantity = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		String Promocode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String FixedAmount = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
	    String Percentage = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String MinDiscountAmt = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String MaxDiscountAmt = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		refDiscount.verifyDiscountEdit(OldDiscountName,DiscountName,DiscountType,SaleQuantity,Promocode,FixedAmount,Percentage,Description,MinDiscountAmt,MaxDiscountAmt);
		boolean result = refDiscount.Verify_DiscountRule_SaveorNot(DiscountName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Invoice_DiscountRule has been Updated & Saved");
		GenericMethods.fnEndTestCase();
	}
	*/
	@Test 
	public void fnDiscountRuleCreation_withDiscountType_Invoice_for_WithoutInternet() {
		GenericMethods.fnStartTestCase("Verify DiscountRule creation withDiscountType_Invoice for withoutInternet");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Discount";
	    int RowNumber = 13;
	    String DiscountName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String DiscountType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String SaleQuantity = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		String Promocode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String FixedAmount = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
	    String Percentage = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String MinDiscountAmt = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String MaxDiscountAmt = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		refDiscount.createNewDiscountRule(DiscountName,DiscountType,SaleQuantity,Promocode,FixedAmount,Percentage,Description,MinDiscountAmt,MaxDiscountAmt,Inactive);
		boolean result = refDiscount.Verify_DiscountRule_SaveorNot(DiscountName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Invoice_DiscountRule has been Created & Saved");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnActive_DiscountRuleCreation_withDiscountType_Item_for_MultiDiscountFeature() {
		GenericMethods.fnStartTestCase("Verify Active DiscountRule creation withDiscountType_Item for MultiDiscountFeature");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Discount";
	    int RowNumber = 14;
	    String DiscountName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String DiscountType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String SaleQuantity = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String Promocode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String FixedAmount = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String Percentage = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String MinDiscountAmt = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String MaxDiscountAmt = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		refDiscount.createNewDiscountRule(DiscountName,DiscountType,SaleQuantity,Promocode,FixedAmount,Percentage,Description,MinDiscountAmt,MaxDiscountAmt,Inactive);
		boolean result = refDiscount.Verify_DiscountRule_SaveorNot(DiscountName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Active Item_DiscountRule has been Created & Saved");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnActive_DiscountRuleDelete_withDiscountType_Item() {
		GenericMethods.fnStartTestCase("Verify Active DiscountRuleDelete withDiscountType_Item");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Discount";
        int RowNumber = 3;
        String DiscountName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
        refDiscount.fnVerifyDiscountDelete(DiscountName);
        boolean result = refDiscount.Verify_DiscountRuleDelete_SaveorNot(DiscountName);
        Assert.assertTrue(result);
        fnWriteSteps("pass", "Active DiscountRule withDiscountType_Item has been Deleted");
    	GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnInActive_DiscountRuleDelete_withDiscountType_Item() {
		GenericMethods.fnStartTestCase("Verify InActive DiscountRuleDelete withDiscountType_Item");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Discount";
        int RowNumber = 4;
        String DiscountName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
        refDiscount.fnVerifyDiscountDelete(DiscountName);
        boolean result = refDiscount.Verify_DiscountRuleDelete_SaveorNot(DiscountName);
        Assert.assertTrue(result);
        fnWriteSteps("pass", "InActive DiscountRule withDiscountType_Item has been Deleted");
    	GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnDiscountRuleDelete_withDiscountType_Item() {
		GenericMethods.fnStartTestCase("Verify DiscountRuleDelete withDiscountType_Item");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Discount";
        int RowNumber = 5;
        String DiscountName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
        refDiscount.fnVerifyDiscountDelete(DiscountName);
        boolean result = refDiscount.Verify_DiscountRuleDelete_SaveorNot(DiscountName);
        Assert.assertTrue(result);
        fnWriteSteps("pass", "DiscountRule withDiscountType_Item has been Deleted");
    	GenericMethods.fnEndTestCase();
	}
	
	@Test 
	public void fnActive_DiscountRuleDelete_withDiscountType_Invoice() {
		GenericMethods.fnStartTestCase("Verify Active DiscountRuleDelete withDiscountType_Invoice");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Discount";
        int RowNumber = 1;
        String DiscountName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
        refDiscount.fnVerifyDiscountDelete(DiscountName);
        boolean result = refDiscount.Verify_DiscountRuleDelete_SaveorNot(DiscountName);
        Assert.assertTrue(result);
        fnWriteSteps("pass", "Active DiscountRule withDiscountType_Invoice has been Deleted");
    	GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnInActive_DiscountRuleDelete_withDiscountType_Invoice() {
		GenericMethods.fnStartTestCase("Verify InActive DiscountRuleDelete withDiscountType_Invoice");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Discount";
        int RowNumber = 2 ;
        String DiscountName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
        refDiscount.fnVerifyDiscountDelete(DiscountName);
        boolean result = refDiscount.Verify_DiscountRuleDelete_SaveorNot(DiscountName);
        Assert.assertTrue(result);
        fnWriteSteps("pass", "InActive DiscountRule withDiscountType_Invoice has been Deleted");
    	GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnDiscountRuleDelete_withDiscountType_Invoice() {
		GenericMethods.fnStartTestCase("Verify DiscountRuleDelete withDiscountType_Invoice");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Discount";
        int RowNumber = 9;
        String DiscountName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
        refDiscount.fnVerifyDiscountDelete(DiscountName);
        boolean result = refDiscount.Verify_DiscountRuleDelete_SaveorNot(DiscountName);
        Assert.assertTrue(result);
        fnWriteSteps("pass", "DiscountRule withDiscountType_Invoice has been Deleted");
    	GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnDiscountRuleDelete_withDiscountType_Invoice_for_withoutInternet() {
		GenericMethods.fnStartTestCase("Verify DiscountRuleDelete withDiscountType_Invoice for withoutInternet");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Discount";
        int RowNumber = 13;
        String DiscountName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
        refDiscount.fnVerifyDiscountDelete(DiscountName);
        refDiscount.click_On_Yes_Button();
        fnWriteSteps("pass", "DiscountRule withDiscountType_Invoice not Deleted");
    	GenericMethods.fnEndTestCase();
	}
	
	@Test 
	public void fnDiscountRuleDelete_withDiscountType_Item_for_withoutInternet() {
		GenericMethods.fnStartTestCase("Verify DiscountRuleDelete withDiscountType_Item for withoutInternet");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Discount";
        int RowNumber = 7;
        String DiscountName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
        refDiscount.fnVerifyDiscountDelete(DiscountName);
        refDiscount.click_On_Yes_Button();
        fnWriteSteps("pass", "DiscountRule withDiscountType_Item not Deleted");
    	GenericMethods.fnEndTestCase();
	}
	
	@AfterMethod
	public void fnAfterMethod() {
        GenericMethods.fnStartTestCase("fn Logout");
		refDiscount.clickCloseButton();
		GenericMethods.fnwait(2);
		refDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		refMessageBoxEffia.ExitApplication_Yes();
		GenericMethods.fnwait(24);
		refLogin.ClickCloseButton();
		fnWriteSteps("Pass", "Application close successfully");
		GenericMethods.fnEndTestCase();

	}

}
