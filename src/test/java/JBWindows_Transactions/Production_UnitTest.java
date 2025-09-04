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
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import JBWindows.Transactions.ProductionPage;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class Production_UnitTest extends BaseClass {

	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;
	MessageBoxEffia RefMessgBox;
	ProductionPage RefProduction;

	public Production_UnitTest() {
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
	public void fnProduction_Creation_with_Laborcost() throws FindFailed {
		GenericMethods.fnStartTestCase("fnProduction Creation with Laborcost");
		int rowindex = 1;
		String Finishedgoods = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 0);
		String QNTY = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 1);
		String RawProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 2);
		String QNTY1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 3);
		String RawProduct2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 4);
		String QNTY2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 5);
		String CostType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 6);
		String labourcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 7);
		String loadingcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 8);
		String overheadcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 9);
		String wastagecost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 10);
		String SaveType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 11);
		String ProductStockType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 12);
		RefProduction.Production_Creation(Finishedgoods,QNTY,ProductStockType,RawProduct1,QNTY1,RawProduct2,QNTY2,CostType,labourcost,loadingcost,overheadcost,wastagecost);
		boolean result = RefProduction.Check_Material_and_UnitPrice_Costs(SaveType);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Production has been created with Laborcost");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void fnProduction_Creation_with_LoadingCost() throws FindFailed {
		GenericMethods.fnStartTestCase("fnProduction Creation with LoadingCost");
		int rowindex = 2;
		String Finishedgoods = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 0);
		String QNTY = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 1);
		String RawProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 2);
		String QNTY1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 3);
		String RawProduct2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 4);
		String QNTY2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 5);
		String CostType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 6);
		String labourcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 7);
		String loadingcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 8);
		String overheadcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 9);
		String wastagecost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 10);
		String SaveType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 11);
		String ProductStockType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 12);
		RefProduction.Production_Creation(Finishedgoods,QNTY,ProductStockType,RawProduct1,QNTY1,RawProduct2,QNTY2,CostType,labourcost,loadingcost,overheadcost,wastagecost);
		boolean result = RefProduction.Check_Material_and_UnitPrice_Costs(SaveType);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Production has been created with LoadingCost");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void fnProduction_Creation_with_OverheadCost() throws FindFailed {
		GenericMethods.fnStartTestCase("fnProduction Creation with OverheadCost");
		int rowindex = 3;
		String Finishedgoods = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 0);
		String QNTY = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 1);
		String RawProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 2);
		String QNTY1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 3);
		String RawProduct2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 4);
		String QNTY2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 5);
		String CostType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 6);
		String labourcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 7);
		String loadingcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 8);
		String overheadcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 9);
		String wastagecost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 10);
		String SaveType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 11);
		String ProductStockType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 12);
		RefProduction.Production_Creation(Finishedgoods,QNTY,ProductStockType,RawProduct1,QNTY1,RawProduct2,QNTY2,CostType,labourcost,loadingcost,overheadcost,wastagecost);
		boolean result = RefProduction.Check_Material_and_UnitPrice_Costs(SaveType);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Production has been created with OverheadCost");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void fnProduction_Creation_with_WastageCost() throws FindFailed {
		GenericMethods.fnStartTestCase("fnProduction Creation with WastageCost");
		int rowindex = 4;
		String Finishedgoods = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 0);
		String QNTY = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 1);
		String RawProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 2);
		String QNTY1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 3);
		String RawProduct2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 4);
		String QNTY2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 5);
		String CostType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 6);
		String labourcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 7);
		String loadingcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 8);
		String overheadcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 9);
		String wastagecost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 10);
		String SaveType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 11);
		String ProductStockType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 12);
		RefProduction.Production_Creation(Finishedgoods,QNTY,ProductStockType,RawProduct1,QNTY1,RawProduct2,QNTY2,CostType,labourcost,loadingcost,overheadcost,wastagecost);
		boolean result = RefProduction.Check_Material_and_UnitPrice_Costs(SaveType);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Production has been created with WastageCost");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void fnProduction_Creation_with_Labor_Loading_Overhead_Wastage_costs() throws FindFailed {
		GenericMethods.fnStartTestCase("fnProduction Creation with Labor Loading Overhead Wastage costs");
		int rowindex = 5;
		String Finishedgoods = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 0);
		String QNTY = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 1);
		String RawProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 2);
		String QNTY1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 3);
		String RawProduct2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 4);
		String QNTY2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 5);
		String CostType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 6);
		String labourcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 7);
		String loadingcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 8);
		String overheadcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 9);
		String wastagecost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 10);
		String SaveType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 11);
		String ProductStockType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 12);
		RefProduction.Production_Creation(Finishedgoods,QNTY,ProductStockType,RawProduct1,QNTY1,RawProduct2,QNTY2,CostType,labourcost,loadingcost,overheadcost,wastagecost);
		boolean result = RefProduction.Check_Material_and_UnitPrice_Costs(SaveType);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Production has been created with Labor Loading Overhead Wastage costs");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void fnProduction_Creation_with_BOM() throws FindFailed {
		GenericMethods.fnStartTestCase("fnProduction Creation with BOM");
		int rowindex = 6;
		String Finishedgoods = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 0);
		String QNTY = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 1);
		String RawProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 2);
		String QNTY1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 3);
		String RawProduct2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 4);
		String QNTY2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 5);
		String CostType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 6);
		String labourcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 7);
		String loadingcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 8);
		String overheadcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 9);
		String wastagecost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 10);
		String SaveType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 11);
		String ProductStockType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 12);
		RefProduction.Production_Creation(Finishedgoods,QNTY,ProductStockType,RawProduct1,QNTY1,RawProduct2,QNTY2,CostType,labourcost,loadingcost,overheadcost,wastagecost);
		boolean result = RefProduction.Check_Material_and_UnitPrice_Costs(SaveType);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Production has been created with BOM");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void fnTry_to_create_production_without_adding_Rawproducts() {
		GenericMethods.fnStartTestCase("fnTry to create production without adding Rawproducts");
		int rowindex = 7;
		String Finishedgoods = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 0);
		String QNTY = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 1);
		String SaveType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 11);
		RefProduction.Production_Creation_without_adding_Rawproducts(Finishedgoods, QNTY,SaveType);
		boolean result = RefProduction.Validate_Production_Creation_Without_adding_Rawproducts();
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Production has been created without adding Rawproducts");
		GenericMethods.fnEndTestCase();

	}
	@Test 
	public void fnTry_to_create_production_with_the_raw_material_having_no_stock_and_not_allowed_to_negative_stock() throws FindFailed {
		GenericMethods.fnStartTestCase("fnTry to create production with the raw material having no stock and not allowed to negative stock");
		int rowindex = 8;
		String Finishedgoods = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 0);
		String QNTY = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 1);
		String RawProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 2);
		String QNTY1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 3);
		String RawProduct2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 4);
		String QNTY2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 5);
		String CostType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 6);
		String labourcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 7);
		String loadingcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 8);
		String overheadcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 9);
		String wastagecost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 10);
		String ProductStockType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 12);
		RefProduction.Production_Creation(Finishedgoods, QNTY,ProductStockType,RawProduct1, QNTY1, RawProduct2, QNTY2, CostType, labourcost, loadingcost, overheadcost, wastagecost);
		GenericMethods.fnwait(2);
		boolean result = RefProduction.Validate_Production_Creation_with_the_raw_material_Without_having_no_stock_and_not_allowed_to_negative_stock();
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Production has been not created with the raw material having no stock and not allowed to negative stock");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnProduction_of_BOMCreation_with_Laborcost() throws FindFailed {
		GenericMethods.fnStartTestCase("fnProduction of BOMCreation with Laborcost");
		int rowindex = 9;
		String Finishedgoods = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 0);
		String QNTY = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 1);
		String RawProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 2);
		String QNTY1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 3);
		String RawProduct2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 4);
		String QNTY2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 5);
		String CostType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 6);
		String labourcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 7);
		String loadingcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 8);
		String overheadcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 9);
		String wastagecost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 10);
		String SaveType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 11);
		String ProductStockType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 12);
		RefProduction.Production_Creation(Finishedgoods,QNTY,ProductStockType,RawProduct1,QNTY1,RawProduct2,QNTY2,CostType,labourcost,loadingcost,overheadcost,wastagecost);
		boolean result = RefProduction.Check_Material_and_UnitPrice_Costs(SaveType);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Production of BOM has been created with Laborcost");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void fnProduction_of_BOMCreation_with_LoadingCost() throws FindFailed {
		GenericMethods.fnStartTestCase("fnProduction of BOMCreation with LoadingCost");
		int rowindex = 10;
		String Finishedgoods = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 0);
		String QNTY = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 1);
		String RawProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 2);
		String QNTY1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 3);
		String RawProduct2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 4);
		String QNTY2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 5);
		String CostType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 6);
		String labourcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 7);
		String loadingcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 8);
		String overheadcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 9);
		String wastagecost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 10);
		String SaveType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 11);
		String ProductStockType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 12);
		RefProduction.Production_Creation(Finishedgoods,QNTY,ProductStockType,RawProduct1,QNTY1,RawProduct2,QNTY2,CostType,labourcost,loadingcost,overheadcost,wastagecost);
		boolean result = RefProduction.Check_Material_and_UnitPrice_Costs(SaveType);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Production of BOM has been created with LoadingCost");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void fnProduction_of_BOMCreation_with_OverheadCost() throws FindFailed {
		GenericMethods.fnStartTestCase("fnProduction of BOMCreation with OverheadCost");
		int rowindex = 11;
		String Finishedgoods = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 0);
		String QNTY = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 1);
		String RawProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 2);
		String QNTY1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 3);
		String RawProduct2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 4);
		String QNTY2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 5);
		String CostType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 6);
		String labourcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 7);
		String loadingcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 8);
		String overheadcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 9);
		String wastagecost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 10);
		String SaveType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 11);
		String ProductStockType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 12);
		RefProduction.Production_Creation(Finishedgoods,QNTY,ProductStockType,RawProduct1,QNTY1,RawProduct2,QNTY2,CostType,labourcost,loadingcost,overheadcost,wastagecost);
		boolean result = RefProduction.Check_Material_and_UnitPrice_Costs(SaveType);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Production of BOM has been created with OverheadCost");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void fnProduction_of_BOMCreation_with_WastageCost() throws FindFailed {
		GenericMethods.fnStartTestCase("fnProduction of BOMCreation with WastageCost");
		int rowindex = 12;
		String Finishedgoods = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 0);
		String QNTY = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 1);
		String RawProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 2);
		String QNTY1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 3);
		String RawProduct2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 4);
		String QNTY2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 5);
		String CostType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 6);
		String labourcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 7);
		String loadingcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 8);
		String overheadcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 9);
		String wastagecost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 10);
		String SaveType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 11);
		String ProductStockType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 12);
		RefProduction.Production_Creation(Finishedgoods,QNTY,ProductStockType,RawProduct1,QNTY1,RawProduct2,QNTY2,CostType,labourcost,loadingcost,overheadcost,wastagecost);
		boolean result = RefProduction.Check_Material_and_UnitPrice_Costs(SaveType);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Production of BOM has been created with WastageCost");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void fnProduction_of_BOMCreation_with_Labor_Loading_Overhead_Wastage_costs() throws FindFailed {
		GenericMethods.fnStartTestCase("fnProduction of BOMCreation with Labor Loading Overhead Wastage costs");
		int rowindex = 13;
		String Finishedgoods = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 0);
		String QNTY = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 1);
		String RawProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 2);
		String QNTY1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 3);
		String RawProduct2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 4);
		String QNTY2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 5);
		String CostType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 6);
		String labourcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 7);
		String loadingcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 8);
		String overheadcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 9);
		String wastagecost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 10);
		String SaveType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 11);
		String ProductStockType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 12);
		RefProduction.Production_Creation(Finishedgoods,QNTY,ProductStockType,RawProduct1,QNTY1,RawProduct2,QNTY2,CostType,labourcost,loadingcost,overheadcost,wastagecost);
		boolean result = RefProduction.Check_Material_and_UnitPrice_Costs(SaveType);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Production of BOM has been created with Labor Loading Overhead Wastage costs");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void fnproduction_of_BOMCreation_with_the_raw_material_having_no_stock_and_not_allowed_to_negative_stock() throws FindFailed {
		GenericMethods.fnStartTestCase("fnproduction of BOMCreation with the raw material having no stock and not allowed to negative stock");
		int rowindex = 14;
		String Finishedgoods = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 0);
		String QNTY = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 1);
		String RawProduct1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 2);
		String QNTY1 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 3);
		String RawProduct2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 4);
		String QNTY2 = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 5);
		String CostType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 6);
		String labourcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 7);
		String loadingcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 8);
		String overheadcost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 9);
		String wastagecost = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 10);
		String SaveType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 11);
		String ProductStockType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 12);
		RefProduction.Production_Creation(Finishedgoods, QNTY,ProductStockType,RawProduct1, QNTY1, RawProduct2, QNTY2, CostType, labourcost, loadingcost, overheadcost, wastagecost);
		GenericMethods.fnwait(2);
		boolean result = RefProduction.Check_Material_and_UnitPrice_Costs(SaveType);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Production of BOM has been created with the raw material having no stock and not allowed to negative stock");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnproduction_of_BOMCreation_without_adding_Rawproducts() {
		GenericMethods.fnStartTestCase("fnproduction of BOMCreation without adding Rawproducts");
		int rowindex = 15;
		String Finishedgoods = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 0);
		String QNTY = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 1);
		String SaveType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Production", rowindex, 11);
		RefProduction.Production_Creation_without_adding_Rawproducts(Finishedgoods, QNTY,SaveType);
		boolean result = RefProduction.Validate_Production_of_BOMCreation_Without_adding_Rawproducts();
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Production of BOM has been not created without adding Rawproducts");
		GenericMethods.fnEndTestCase();

	}
	
}
