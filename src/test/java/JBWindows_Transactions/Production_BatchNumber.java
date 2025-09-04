package JBWindows_Transactions;

import org.apache.log4j.xml.DOMConfigurator;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.PUR.PUR_PurchaseInvoice;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import JBWindows.Transactions.ProductionPage;
import JBWindows.Transactions.Trans_Order_Page;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class Production_BatchNumber extends BaseClass {

	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;
	MessageBoxEffia RefMessgBox;
	ProductionPage RefProduction;
	Trans_Order_Page refOrderPage;
	PUR_PurchaseInvoice refPurchaseInvoice;

	public Production_BatchNumber() {
		super();
	}


	@BeforeClass
	public void initializingWindows() {
		DOMConfigurator.configure("log4j.xml");
		RefLogin = new Login(driver);
		RefDashboard = new APP_Dashboard(driver);
		RefMenu = new APP_Menu(driver);
		RefMessgBox = new MessageBoxEffia(driver);
		RefProduction = new ProductionPage();
		refOrderPage = new Trans_Order_Page();
		refPurchaseInvoice=new PUR_PurchaseInvoice();
		
		
	}

	@AfterClass
	public void terminatingBrowser() {
		GenericMethods.fnwait(15);
		RefLogin.ClickCloseButton();
	}

	@BeforeMethod
	public void setUp() {
		GenericMethods.fnwait(28);
		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		RefLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(9);
		RefDashboard.clickMenuBtn();
		RefMenu.OpenPage("production");

	}

	@AfterMethod
	public void tearDown() {
		RefProduction.clickCloseButton();
        RefDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		RefMessgBox.ExitApplication_Yes();
		GenericMethods.fnwait(1);

	} 
	@Test 
	public void Generate_BatchNo_for_Finishedgood_while_creating_Production() throws FindFailed {
		GenericMethods.fnStartTestCase("Generate BatchNo for Finishedgood while creating Production");
		int rowindex = 19;
		String ProductType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 0);
		String Finishedgoods = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 1);
		String QNTY = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 2);
		String BatchNo1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 3);
		String Lotsize = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 4);
		String ManufacturingDate = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 5);
		String ExpiryDate = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 6);
		String RawProduct4 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 7);
		String QNTY4 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 8);
		String SelectedQuantity = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 9);
		RefProduction.BatchNo_Generation_for_Production(Finishedgoods, QNTY,ProductType, BatchNo1, Lotsize, ManufacturingDate, ExpiryDate,RawProduct4,QNTY4,SelectedQuantity);
		boolean result = refPurchaseInvoice.Validate_Adding_of_BatchNumber();
		RefProduction.click_on_SaveButton();
		refOrderPage.click_On_OK_Button();
		refOrderPage.click_On_OK_Button();
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Successfully BatchNo generated for Finishedgood while creating production");
		GenericMethods.fnEndTestCase();
		
		
	}
	@Test
	public void Select_BatchNo_for_Rawmaterials_while_creating_Production() throws FindFailed {
	    GenericMethods.fnStartTestCase("Select BatchNo for Rawmaterials while creating Production");
		int rowindex = 20;
		String ProductType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 0);
		String Finishedgoods = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 1);
		String QNTY = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 2);
		String BatchNo1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 3);
		String Lotsize = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 4);
		String ManufacturingDate = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 5);
		String ExpiryDate = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 6);
		String RawProduct4 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 7);
		String QNTY4 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 8);
		String SelectedQuantity = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 9);
		RefProduction.BatchNo_Generation_for_Production(Finishedgoods, QNTY,ProductType, BatchNo1, Lotsize, ManufacturingDate, ExpiryDate,RawProduct4,QNTY4,SelectedQuantity);
		boolean result = refOrderPage.Validate_BatchNO_Selected_or_Not();
		RefProduction.click_on_SaveButton();
		refOrderPage.click_On_OK_Button();
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Successfully BatchNo Selected for Rawmaterials while creating Production");
		GenericMethods.fnEndTestCase();
		
		
	}
	@Test 
	public void Generate_BatchNo_for_Finishedgood_while_creating_with_BOM() throws FindFailed {
		GenericMethods.fnStartTestCase("Generate BatchNo for Finishedgood while creating Production with BOM");
		int rowindex = 21;
		String ProductType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 0);
		String Finishedgoods = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 1);
		String QNTY = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 2);
		String BatchNo1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 3);
		String Lotsize = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 4);
		String ManufacturingDate = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 5);
		String ExpiryDate = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 6);
		String RawProduct4 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 7);
		String QNTY4 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 8);
		String SelectedQuantity = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 9);
		RefProduction.BatchNo_Generation_for_Production(Finishedgoods, QNTY,ProductType, BatchNo1, Lotsize, ManufacturingDate, ExpiryDate,RawProduct4,QNTY4,SelectedQuantity);
		boolean result = refPurchaseInvoice.Validate_Adding_of_BatchNumber();
		RefProduction.click_on_SaveBOMButton();
		refOrderPage.click_On_OK_Button();
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Successfully BatchNo generated for Finishedgood while creating production with BOM");
		GenericMethods.fnEndTestCase();
		
		
	}
	@Test 
	public void Select_BatchNo_for_Rawmaterials_while_creating_Production_with_BOM() throws FindFailed {
	    GenericMethods.fnStartTestCase("Select BatchNo for Rawmaterials while creating Production with BOM");
		int rowindex = 22;
		String ProductType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 0);
		String Finishedgoods = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 1);
		String QNTY = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 2);
		String BatchNo1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 3);
		String Lotsize = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 4);
		String ManufacturingDate = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 5);
		String ExpiryDate = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 6);
		String RawProduct4 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 7);
		String QNTY4 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 8);
		String SelectedQuantity = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 9);
		RefProduction.BatchNo_Generation_for_Production(Finishedgoods, QNTY,ProductType, BatchNo1, Lotsize, ManufacturingDate, ExpiryDate,RawProduct4,QNTY4,SelectedQuantity);
		boolean result = refOrderPage.Validate_BatchNO_Selected_or_Not();
		RefProduction.click_on_SaveBOMButton();
		refOrderPage.click_On_OK_Button();
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Successfully BatchNo Selected for Rawmaterials while creating Production with BOM");
		GenericMethods.fnEndTestCase();
	}
	
}


