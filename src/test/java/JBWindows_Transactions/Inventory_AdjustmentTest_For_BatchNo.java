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
import JBWindows.Transactions.Inventory_Adjustment_Page;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class Inventory_AdjustmentTest_For_BatchNo extends BaseClass {
	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;
	MessageBoxEffia RefMessgBox;
    Inventory_Adjustment_Page refInventoryAdjustment;

	public Inventory_AdjustmentTest_For_BatchNo() {
		super();
	}


	@BeforeClass
	public void initializingWindows() {
		DOMConfigurator.configure("log4j.xml");
		RefLogin = new Login(driver);
		RefDashboard = new APP_Dashboard(driver);
		RefMenu = new APP_Menu(driver);
		RefMessgBox = new MessageBoxEffia(driver);
		refInventoryAdjustment = new Inventory_Adjustment_Page();
	}

	@AfterClass
	public void terminatingBrowser() {
		GenericMethods.fnwait(2);
		RefLogin.ClickCloseButton();
	}

	@BeforeMethod
	public void setUp() {
		GenericMethods.fnwait(10);
		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		RefLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(8);
		RefDashboard.clickMenuBtn();
		RefMenu.OpenPage("inventory adjustments");
		GenericMethods.fnwait(1);
		//fnWriteSteps("Pass", "Application Open Successfully");
		GenericMethods.fnEndTestCase();
  }

	@AfterMethod
	public void tearDown() {

		refInventoryAdjustment.click_On_Close_Image();
		GenericMethods.fnwait(2);
		RefDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(2);
		RefMessgBox.ExitApplication_Yes();
		GenericMethods.fnwait(7);

	}
		@Test 
		public void fnInventoryAdjustment_with_InitialStock() throws FindFailed {
			GenericMethods.fnStartTestCase("Verify fnInventoryAdjustment with InitialStock");
			String StrExcelPath = ApplicationVariables.JBTRANSACTIONEXCELPATH;
		    String StrSheetName = "Inventory Adjustments";
		    int RowNumber = 1;
		    String AdjustmentTYPE = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		    String BatchProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		    String QNTY = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		    String InventoryHit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		    String BatchNo1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		    String Lotsize = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		    String ManufacturingDate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		    String ExpiryDate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		    String BatchType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
		    String SelectedQuantity = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		    String SelectedQuantity1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		    String SelectedQuantity2 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		    refInventoryAdjustment.InventoryAdjustment_with_Different_AdjustmentTypes(AdjustmentTYPE);
		    boolean result = refInventoryAdjustment.Enter_BatchProduct_Details(BatchProduct,QNTY,InventoryHit,BatchNo1,Lotsize,ManufacturingDate,ExpiryDate,BatchType,SelectedQuantity,SelectedQuantity1,SelectedQuantity2);
		    Assert.assertTrue(result);
		    fnWriteSteps("Pass", "Verified InventoryAdjustment with InitialStock");
			GenericMethods.fnEndTestCase();
	}
		@Test 
		public void fnInventoryAdjustment_with_Breakage() throws FindFailed {
			GenericMethods.fnStartTestCase("Verify fnInventoryAdjustment with Breakage");
			String StrExcelPath = ApplicationVariables.JBTRANSACTIONEXCELPATH;
		    String StrSheetName = "Inventory Adjustments";
		    int RowNumber = 2;
		    String AdjustmentTYPE = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		    String BatchProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		    String QNTY = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		    String InventoryHit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		    String BatchNo1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		    String Lotsize = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		    String ManufacturingDate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		    String ExpiryDate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		    String BatchType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
		    String SelectedQuantity = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		    String SelectedQuantity1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		    String SelectedQuantity2 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		    refInventoryAdjustment.InventoryAdjustment_with_Different_AdjustmentTypes(AdjustmentTYPE);
		    boolean result = refInventoryAdjustment.Enter_BatchProduct_Details(BatchProduct,QNTY,InventoryHit,BatchNo1,Lotsize,ManufacturingDate,ExpiryDate,BatchType,SelectedQuantity,SelectedQuantity1,SelectedQuantity2);
		    Assert.assertTrue(result);
		    fnWriteSteps("Pass", "Verified InventoryAdjustment with Breakage");
			GenericMethods.fnEndTestCase();
	}
		@Test 
		public void fnInventoryAdjustment_with_Others_Stock_In() throws FindFailed {
			GenericMethods.fnStartTestCase("Verify fnInventoryAdjustment with Others_Stock_In");
			String StrExcelPath = ApplicationVariables.JBTRANSACTIONEXCELPATH;
		    String StrSheetName = "Inventory Adjustments";
		    int RowNumber = 3;
		    String AdjustmentTYPE = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		    String BatchProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		    String QNTY = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		    String InventoryHit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		    String BatchNo1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		    String Lotsize = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		    String ManufacturingDate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		    String ExpiryDate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		    String BatchType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
		    String SelectedQuantity = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		    String SelectedQuantity1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		    String SelectedQuantity2 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		    refInventoryAdjustment.InventoryAdjustment_with_Different_AdjustmentTypes(AdjustmentTYPE);
		    boolean result = refInventoryAdjustment.Enter_BatchProduct_Details(BatchProduct,QNTY,InventoryHit,BatchNo1,Lotsize,ManufacturingDate,ExpiryDate,BatchType,SelectedQuantity,SelectedQuantity1,SelectedQuantity2);
		    Assert.assertTrue(result);
		    fnWriteSteps("Pass", "Verified InventoryAdjustment with Others_Stock_In");
			GenericMethods.fnEndTestCase();
	}
		@Test 
		public void fnInventoryAdjustment_with_Incorrect_receiving() throws FindFailed {
			GenericMethods.fnStartTestCase("Verify fnInventoryAdjustment with Incorrect_receiving");
			String StrExcelPath = ApplicationVariables.JBTRANSACTIONEXCELPATH;
		    String StrSheetName = "Inventory Adjustments";
		    int RowNumber = 4;
		    String AdjustmentTYPE = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		    String BatchProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		    String QNTY = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		    String InventoryHit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		    String BatchNo1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		    String Lotsize = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		    String ManufacturingDate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		    String ExpiryDate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		    String BatchType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
		    String SelectedQuantity = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		    String SelectedQuantity1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		    String SelectedQuantity2 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		    refInventoryAdjustment.InventoryAdjustment_with_Different_AdjustmentTypes(AdjustmentTYPE);
		    boolean result = refInventoryAdjustment.Enter_BatchProduct_Details(BatchProduct,QNTY,InventoryHit,BatchNo1,Lotsize,ManufacturingDate,ExpiryDate,BatchType,SelectedQuantity,SelectedQuantity1,SelectedQuantity2);
		    Assert.assertTrue(result);
		    fnWriteSteps("Pass", "Verified InventoryAdjustment with Incorrect_receiving");
			GenericMethods.fnEndTestCase();
	}
		@Test 
		public void fnInventoryAdjustment_with_Over_Shipments() throws FindFailed {
			GenericMethods.fnStartTestCase("Verify fnInventoryAdjustment with Over_Shipments");
			String StrExcelPath = ApplicationVariables.JBTRANSACTIONEXCELPATH;
		    String StrSheetName = "Inventory Adjustments";
		    int RowNumber = 5;
		    String AdjustmentTYPE = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		    String BatchProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		    String QNTY = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		    String InventoryHit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		    String BatchNo1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		    String Lotsize = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		    String ManufacturingDate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		    String ExpiryDate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		    String BatchType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
		    String SelectedQuantity = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		    String SelectedQuantity1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		    String SelectedQuantity2 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		    refInventoryAdjustment.InventoryAdjustment_with_Different_AdjustmentTypes(AdjustmentTYPE);
		    boolean result = refInventoryAdjustment.Enter_BatchProduct_Details(BatchProduct,QNTY,InventoryHit,BatchNo1,Lotsize,ManufacturingDate,ExpiryDate,BatchType,SelectedQuantity,SelectedQuantity1,SelectedQuantity2);
		    Assert.assertTrue(result);
		    fnWriteSteps("Pass", "Verified InventoryAdjustment with Over_Shipments");
			GenericMethods.fnEndTestCase();
	}
		@Test 
		public void fnInventoryAdjustment_with_Loss() throws FindFailed {
			GenericMethods.fnStartTestCase("Verify fnInventoryAdjustment with Loss");
			String StrExcelPath = ApplicationVariables.JBTRANSACTIONEXCELPATH;
		    String StrSheetName = "Inventory Adjustments";
		    int RowNumber = 6;
		    String AdjustmentTYPE = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		    String BatchProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		    String QNTY = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		    String InventoryHit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		    String BatchNo1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		    String Lotsize = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		    String ManufacturingDate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		    String ExpiryDate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		    String BatchType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
		    String SelectedQuantity = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		    String SelectedQuantity1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		    String SelectedQuantity2 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		    refInventoryAdjustment.InventoryAdjustment_with_Different_AdjustmentTypes(AdjustmentTYPE);
		    boolean result = refInventoryAdjustment.Enter_BatchProduct_Details(BatchProduct,QNTY,InventoryHit,BatchNo1,Lotsize,ManufacturingDate,ExpiryDate,BatchType,SelectedQuantity,SelectedQuantity1,SelectedQuantity2);
		    Assert.assertTrue(result);
		    fnWriteSteps("Pass", "Verified InventoryAdjustment with Loss");
			GenericMethods.fnEndTestCase();

	}
		
		@Test 
		public void fnInventoryAdjustment_with_Others_Stock_Out() throws FindFailed {
			GenericMethods.fnStartTestCase("Verify fnInventoryAdjustment with Others_Stock_Out");
			String StrExcelPath = ApplicationVariables.JBTRANSACTIONEXCELPATH;
		    String StrSheetName = "Inventory Adjustments";
		    int RowNumber = 7;
		    String AdjustmentTYPE = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		    String BatchProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		    String QNTY = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		    String InventoryHit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		    String BatchNo1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		    String Lotsize = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		    String ManufacturingDate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		    String ExpiryDate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		    String BatchType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
		    String SelectedQuantity = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		    String SelectedQuantity1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		    String SelectedQuantity2 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		    refInventoryAdjustment.InventoryAdjustment_with_Different_AdjustmentTypes(AdjustmentTYPE);
		    boolean result = refInventoryAdjustment.Enter_BatchProduct_Details(BatchProduct,QNTY,InventoryHit,BatchNo1,Lotsize,ManufacturingDate,ExpiryDate,BatchType,SelectedQuantity,SelectedQuantity1,SelectedQuantity2);
		    Assert.assertTrue(result);
		    fnWriteSteps("Pass", "Verified InventoryAdjustment with Others_Stock_Out");
			GenericMethods.fnEndTestCase();

	}
		
		@Test 
		public void fnInventoryAdjustment_with_Physical_Count_IN() throws FindFailed {
			GenericMethods.fnStartTestCase("Verify fnInventoryAdjustment with Physical_Count_IN");
			String StrExcelPath = ApplicationVariables.JBTRANSACTIONEXCELPATH;
		    String StrSheetName = "Inventory Adjustments";
		    int RowNumber = 8;
		    String AdjustmentTYPE = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		    String BatchProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		    String QNTY = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		    String InventoryHit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		    String BatchNo1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		    String Lotsize = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		    String ManufacturingDate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		    String ExpiryDate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		    String BatchType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
		    String SelectedQuantity = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		    String SelectedQuantity1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		    String SelectedQuantity2 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		    refInventoryAdjustment.InventoryAdjustment_with_Different_AdjustmentTypes(AdjustmentTYPE);
		    boolean result = refInventoryAdjustment.Enter_BatchProduct_Details(BatchProduct,QNTY,InventoryHit,BatchNo1,Lotsize,ManufacturingDate,ExpiryDate,BatchType,SelectedQuantity,SelectedQuantity1,SelectedQuantity2);
		    Assert.assertTrue(result);
		    fnWriteSteps("Pass", "Verified InventoryAdjustment with Physical_Count_IN");
			GenericMethods.fnEndTestCase();

	}
		@Test 
		public void fnInventoryAdjustment_with_Physical_Count_OUT() throws FindFailed {
			GenericMethods.fnStartTestCase("Verify fnInventoryAdjustment with Physical_Count_OUT");
			String StrExcelPath = ApplicationVariables.JBTRANSACTIONEXCELPATH;
		    String StrSheetName = "Inventory Adjustments";
		    int RowNumber = 9;
		    String AdjustmentTYPE = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		    String BatchProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		    String QNTY = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		    String InventoryHit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		    String BatchNo1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		    String Lotsize = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		    String ManufacturingDate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		    String ExpiryDate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		    String BatchType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
		    String SelectedQuantity = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		    String SelectedQuantity1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		    String SelectedQuantity2 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		    refInventoryAdjustment.InventoryAdjustment_with_Different_AdjustmentTypes(AdjustmentTYPE);
		    boolean result = refInventoryAdjustment.Enter_BatchProduct_Details(BatchProduct,QNTY,InventoryHit,BatchNo1,Lotsize,ManufacturingDate,ExpiryDate,BatchType,SelectedQuantity,SelectedQuantity1,SelectedQuantity2);
		    Assert.assertTrue(result);
		    fnWriteSteps("Pass", "Verified InventoryAdjustment with Physical_Count_OUT");
			GenericMethods.fnEndTestCase();

	}
		@Test 
		public void fnInventoryAdjustment_with_Spoilt() throws FindFailed {
			GenericMethods.fnStartTestCase("Verify fnInventoryAdjustment with Spoilt");
			String StrExcelPath = ApplicationVariables.JBTRANSACTIONEXCELPATH;
		    String StrSheetName = "Inventory Adjustments";
		    int RowNumber = 10;
		    String AdjustmentTYPE = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		    String BatchProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		    String QNTY = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		    String InventoryHit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		    String BatchNo1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		    String Lotsize = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		    String ManufacturingDate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		    String ExpiryDate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		    String BatchType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
		    String SelectedQuantity = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		    String SelectedQuantity1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		    String SelectedQuantity2 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		    refInventoryAdjustment.InventoryAdjustment_with_Different_AdjustmentTypes(AdjustmentTYPE);
		    boolean result = refInventoryAdjustment.Enter_BatchProduct_Details(BatchProduct,QNTY,InventoryHit,BatchNo1,Lotsize,ManufacturingDate,ExpiryDate,BatchType,SelectedQuantity,SelectedQuantity1,SelectedQuantity2);
		    Assert.assertTrue(result);
		    fnWriteSteps("Pass", "Verified InventoryAdjustment with Spoilt");
			GenericMethods.fnEndTestCase();
	}
		@Test 
		public void fnInventoryAdjustment_with_Theft() throws FindFailed {
			GenericMethods.fnStartTestCase("Verify fnInventoryAdjustment with Theft");
			String StrExcelPath = ApplicationVariables.JBTRANSACTIONEXCELPATH;
		    String StrSheetName = "Inventory Adjustments";
		    int RowNumber = 11;
		    String AdjustmentTYPE = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		    String BatchProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		    String QNTY = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		    String InventoryHit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		    String BatchNo1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		    String Lotsize = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		    String ManufacturingDate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		    String ExpiryDate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		    String BatchType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
		    String SelectedQuantity = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		    String SelectedQuantity1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		    String SelectedQuantity2 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		    refInventoryAdjustment.InventoryAdjustment_with_Different_AdjustmentTypes(AdjustmentTYPE);
		    boolean result = refInventoryAdjustment.Enter_BatchProduct_Details(BatchProduct,QNTY,InventoryHit,BatchNo1,Lotsize,ManufacturingDate,ExpiryDate,BatchType,SelectedQuantity,SelectedQuantity1,SelectedQuantity2);
		    Assert.assertTrue(result);
		    fnWriteSteps("Pass", "Verified InventoryAdjustment with Theft");
			GenericMethods.fnEndTestCase();
	}
		@Test 
		public void fnInventoryAdjustment_with_Wastage() throws FindFailed {
			GenericMethods.fnStartTestCase("Verify fnInventoryAdjustment with Wastage");
			String StrExcelPath = ApplicationVariables.JBTRANSACTIONEXCELPATH;
		    String StrSheetName = "Inventory Adjustments";
		    int RowNumber = 12;
		    String AdjustmentTYPE = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		    String BatchProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		    String QNTY = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		    String InventoryHit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		    String BatchNo1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		    String Lotsize = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		    String ManufacturingDate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		    String ExpiryDate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		    String BatchType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
		    String SelectedQuantity = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		    String SelectedQuantity1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		    String SelectedQuantity2 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		    refInventoryAdjustment.InventoryAdjustment_with_Different_AdjustmentTypes(AdjustmentTYPE);
		    boolean result = refInventoryAdjustment.Enter_BatchProduct_Details(BatchProduct,QNTY,InventoryHit,BatchNo1,Lotsize,ManufacturingDate,ExpiryDate,BatchType,SelectedQuantity,SelectedQuantity1,SelectedQuantity2);
		    Assert.assertTrue(result);
		    fnWriteSteps("Pass", "Verified InventoryAdjustment with Wastage");
			GenericMethods.fnEndTestCase();

	}
}
