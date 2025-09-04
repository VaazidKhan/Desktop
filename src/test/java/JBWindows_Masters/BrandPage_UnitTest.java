package JBWindows_Masters;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.INV.INV_ProductBrands;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class BrandPage_UnitTest extends BaseClass {

	Login refLogin;
	APP_Dashboard refDashboard;
	APP_Menu refMenu;
	INV_ProductBrands refBrands;
	MessageBoxEffia refMessgBox;

	public BrandPage_UnitTest() {
		super();
	}
	
	@BeforeMethod
	public void fnBeforeMethod() throws InterruptedException, IOException {	
		GenericMethods.fnStartTestCase("fn Login and Open Page");
		DOMConfigurator.configure("log4j.xml");
		GenericMethods.fnwait(24);
		refLogin = new Login(driver);
		refDashboard = new APP_Dashboard(driver);
		refMenu = new APP_Menu(driver);
		refBrands = new INV_ProductBrands();
		refMessgBox = new MessageBoxEffia(driver);
		GenericMethods.fnwait(24);
		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		refLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(5);
		driver.findElement(By.id("lblUserName")).click();
		refDashboard.clickMenuBtn();
		GenericMethods.fnwait(2);
		refMenu.OpenPage("Product Brands");
		GenericMethods.fnwait(1);
		fnWriteSteps("Pass", "Application Open Successfully");
		GenericMethods.fnEndTestCase();

	}

	@Test 
	public void fnVerifyFieldVisibility() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of Brand add entry are present or not ");
		
		refBrands.verifyFieldVisibility();	
		GenericMethods.fnEndTestCase();

	}

	@Test 
	public void fnVerifyFieldEnableOrNot() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of Brand add entry are enable or not");
		
		refBrands.verifyFieldEnableOrNot();	
		GenericMethods.fnEndTestCase();

	}
	@Test 
	public void fnVerify_BrandCreation_for_withoutInternet() throws IOException, InterruptedException {	
		GenericMethods.fnStartTestCase("Verify Brand Creation for withoutInternet");	
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Brand";
	    int RowNumber = 10;
	    String StrBrandName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String StrManufacturer = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String DiscountRule = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		refBrands.verifyNewBrandCreation(StrBrandName,StrManufacturer,DiscountRule,Description);
	    boolean result = refBrands.Verify_NewBrandCreation_SaveorNot(StrBrandName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Brand has been created & saved");
		GenericMethods.fnEndTestCase();

	}
	@Test 
	public void fnVerifyBrandCreation_for_MultiDiscountFeature() throws IOException, InterruptedException {	
		GenericMethods.fnStartTestCase("Verify Brand Creation for MultiDiscountFeature");	
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Brand";
	    int RowNumber = 3;
	    String StrBrandName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String StrManufacturer = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String DiscountRule = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		refBrands.verifyNewBrandCreation(StrBrandName,StrManufacturer,DiscountRule,Description);
	    boolean result = refBrands.Verify_NewBrandCreation_SaveorNot(StrBrandName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "New Brand has been created & saved");
		GenericMethods.fnEndTestCase();

	}
	
	@Test 
	public void fnVerifySuccessfulBrandCreation() throws IOException, InterruptedException {	
		GenericMethods.fnStartTestCase("Verify New Brand Creation");	
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Brand";
	    int RowNumber = 1;
	    String StrBrandName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String StrManufacturer = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String DiscountRule = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		refBrands.verifyNewBrandCreation(StrBrandName,StrManufacturer,DiscountRule,Description);
	    boolean result = refBrands.Verify_NewBrandCreation_SaveorNot(StrBrandName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "New Brand has been created & saved");
		GenericMethods.fnEndTestCase();

	}

	@Test 
	public void fnVerifyEditBrandFeature() throws InterruptedException, IOException {
		GenericMethods.fnStartTestCase("Verify Edit Brand Feature");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Brand";
	    int RowNumber = 2;
	    String StrBrandName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String StrManufacturer = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String DiscountRule = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
        String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String OldBrandName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
	    refBrands.verifyEditBrandDetails(StrBrandName,StrManufacturer,DiscountRule,Description,OldBrandName);
	    boolean result = refBrands.Verify_EditBrandDetails_SaveorNot(StrBrandName);
		Assert.assertTrue(result);
		 fnWriteSteps("Pass", "Brand has been Updated & Saved");
		GenericMethods.fnEndTestCase();
	}
	
	@Test 
	public void fnVerifyDeleteBrandFeature() {
		GenericMethods.fnStartTestCase("Verify Delete_ProductBrand Feature");
    	String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Brand";
        int RowNumber = 2;
        String strBrandName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
        refBrands.fnVerifyBrandDelete(strBrandName);
    	boolean result = refBrands.Verify_ProductBrandDelete_SaveorNot(strBrandName);
    	Assert.assertTrue(result);
    	fnWriteSteps("pass", "ProductBrand has been Deleted");
    	GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnVerifyDelete_BrandFeature_for_WithoutInternet() {
	    GenericMethods.fnStartTestCase("Verify Delete_ProductBrand Feature for withoutInternet");
    	String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Brand";
        int RowNumber = 10;
        String strBrandName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
        refBrands.fnVerifyBrandDelete(strBrandName);
    	refBrands.click_On_Yes_Button();
    	fnWriteSteps("Pass", "ProductBrand not Deleted");
    	GenericMethods.fnEndTestCase();
	}
	
	@AfterMethod
	public void fnAfterMethod() {
		GenericMethods.fnStartTestCase("fn Logout");
		refBrands.clickCloseButton();
		GenericMethods.fnwait(2);
		refDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		refMessgBox.ExitApplication_Yes();
		GenericMethods.fnwait(24);
		refLogin.ClickCloseButton();	
		fnWriteSteps("Pass", "Application Close Successfully");
		GenericMethods.fnEndTestCase();
	}
}
