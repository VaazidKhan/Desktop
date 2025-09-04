package JBWindows_Transactions;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.FRM.FRM_OperatingExpenses;
import JBWindows.PUR.PUR_GoodsReceivedNotes;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import JBWindows.Transactions.Trans_Order_Page;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class Goods_Received_Test extends BaseClass {
	
    Logger log = Logger.getLogger(Goods_Received_Test.class);

	
	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;	
	MessageBoxEffia RefMessageBoxEffia;
	PUR_GoodsReceivedNotes RefGoodsReceived;
	Trans_Order_Page refOrderPage;
	
	FRM_OperatingExpenses RefExpensePage;
	
	public Goods_Received_Test() {
		super();
	}


	@BeforeClass
	public void fnBeforeClass() throws InterruptedException {
		DOMConfigurator.configure("log4j.xml");
		GenericMethods.fnwait(2);
		RefLogin = new Login(driver);
		RefDashboard = new APP_Dashboard(driver);
		RefMenu = new APP_Menu(driver);		
		RefMessageBoxEffia = new MessageBoxEffia(driver);
		RefGoodsReceived = new PUR_GoodsReceivedNotes();
		refOrderPage = new Trans_Order_Page();
		
		RefExpensePage = new FRM_OperatingExpenses();
	}
	
	@BeforeMethod
	public void fn_Login_and_Open_Page() throws FindFailed{
		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		RefLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(2);
		//RefDashboard.activatePage();
		GenericMethods.fnwait(35);
		RefDashboard.clickMenuBtn();
		GenericMethods.fnwait(2);
	           
		       Screen screen=new Screen();
			   Pattern pattern;
			   pattern=new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\GoodsReceived.PNG");
			   screen.click(pattern);
			   GenericMethods.fnwait(2);
    }
	@AfterMethod
	public void fn_Close_InvoiceScreen_And_Logout() {

		RefGoodsReceived.clickCloseButton();
		RefDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		RefMessageBoxEffia.ExitApplication_Yes();
		GenericMethods.fnwait(1);
	}
	
	@AfterClass
	public void fnAfterClass_Close_Application() {
		
		GenericMethods.fnwait(2);
		RefLogin.ClickCloseButton();
	}
	@Test 
	public void validate_GoodsReceivedNote_Creation() {
		GenericMethods.fnStartTestCase("validate_GoodsReceivedNote_Creation");
		log.info("*******GoodsReceivedNote Creation******");
		boolean result=false;
		int rowindex=2;
		String TransferoutOrderNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Goods Received Note", rowindex, 1);
		String ReceivedQunty = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Goods Received Note", rowindex, 2);
		String Type = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Goods Received Note", rowindex, 4);
	    RefGoodsReceived.GoodsReceivedNote_creation(TransferoutOrderNo,ReceivedQunty,Type);
		String Vochure = refOrderPage.get_Vochure_Page();
		String GRNVochure = Vochure.split(" ")[5];
		if(GRNVochure!=null && GRNVochure!="") {
			result=true;
		}
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Goods Received Note", rowindex, 3, GRNVochure.trim());
		log.info("*******GoodsReceivedNote Creation******");
		fnWriteSteps("Pass", "GoodsReceivedNote Creation");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void validate_GoodsReceivedNote_Creation_by_ReceivingLessThan_TransferedQuantity() {
		GenericMethods.fnStartTestCase("validate_GoodsReceivedNote_Creation_by_ReceivingLessThan_TransferedQuantity");
		log.info("*******GoodsReceivedNote Creation by ReceivingLessThan TransferedQuantity******");
		boolean result=false;
		int rowindex=3;
		String TransferoutNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Goods Received Note",rowindex, 1);
		String ReceivedQNTY = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Goods Received Note", rowindex, 2);
		String Type = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Goods Received Note", rowindex, 4);
		RefGoodsReceived.clickCreateNewButton();
		RefGoodsReceived.GoodsReceivedNote_creation(TransferoutNo, ReceivedQNTY,Type);
		String Vochure = refOrderPage.get_Vochure_Page();
		String GRNVochure = Vochure.split(" ")[5];
		if(GRNVochure!=null && GRNVochure!="") {
			result=true;
		}
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Goods Received Note", rowindex, 3, GRNVochure.trim());
		log.info("*******GoodsReceivedNote Creation******");
		fnWriteSteps("Pass", "GoodsReceivedNote Creation");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void validate_GoodsReceivedNote_Creation_In_Breakups() {
		GenericMethods.fnStartTestCase("validate_GoodsReceivedNote_Creation_In_Breakups");
		log.info("*******GoodsReceivedNote Creation In Breakups******");
		boolean result=false;
		int rowindex=4;
		String TransferoutOrderNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Goods Received Note",rowindex , 1);
		String ReceivedQunty = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Goods Received Note", rowindex, 2);
		String Type = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Goods Received Note", rowindex, 4);
		RefGoodsReceived.clickCreateNewButton();
		RefGoodsReceived.GoodsReceivedNote_creation(TransferoutOrderNo, ReceivedQunty, Type);
		String Vochure = refOrderPage.get_Vochure_Page();
		String GRNVochure = Vochure.split(" ")[5];
		if(GRNVochure!=null && GRNVochure!="") {
			result=true;
		}
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Goods Received Note", rowindex, 3, GRNVochure.trim());
		log.info("*******GoodsReceivedNote Creation******");
		fnWriteSteps("Pass", "GoodsReceivedNote Creation");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void validate_GoodsReceivedNote_Creation_by_ReceivingGreatherQNTY_Than_TransferedQuantity() {
		GenericMethods.fnStartTestCase("validate_GoodsReceivedNote_Creation_by_ReceivingGreatherQNTY_Than_TransferedQuantity");
		log.info("*******GoodsReceivedNote Creation by ReceivingGreatherQNTY Than TransferedQuantity******");
		boolean result=false;
		int rowindex=5;
		String TransferoutOrderNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Goods Received Note",4, 3);
		String ReceivedQunty = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Goods Received Note", rowindex, 2);
		RefGoodsReceived.GoodsReceivedNote_Edit(TransferoutOrderNo, ReceivedQunty);
		String Vochure = refOrderPage.get_Vochure_Page();
		String GRNVochure = Vochure.split(" ")[5];
		if(GRNVochure!=null && GRNVochure!="") {
			result=true;
		}
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Goods Received Note", rowindex, 3, GRNVochure.trim());
		log.info("*******GoodsReceivedNote Creation******");
		fnWriteSteps("Pass", "GoodsReceivedNote Creation");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void validate_GoodsReceivedNote_Deletion_Current_Device() {
		GenericMethods.fnStartTestCase("GoodsReceivedNote_Deletion_Current_Device");
		log.info("*****GoodsReceivedNote Deletion****");
		String GRNVochure= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Goods Received Note",
				2, 3);
		String strRemarks = "Current device";
		boolean result = RefGoodsReceived.Record_Deletion(GRNVochure, strRemarks);
		Assert.assertTrue(result);
		log.info("******GoodsReceivedNote Deletion******");
		fnWriteSteps("Pass","GoodsReceivedNote Deletion");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void validate_Partial_GoodsReceivedNote_Deletion() {
		GenericMethods.fnStartTestCase("Partial_GoodsReceivedNote_Deletion");
		log.info("*****GoodsReceivedNote Deletion****");
		String GRNVochure= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Goods Received Note",
				3, 3);
		String strRemarks="Partial Delete";
		boolean result = RefGoodsReceived.Record_Deletion(GRNVochure, strRemarks);
		Assert.assertTrue(result);
		log.info("******GoodsReceivedNote Deletion******");
		fnWriteSteps("Pass","GoodsReceivedNote Deletion");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void GoodsReceivedNote_Deletion_which_has_been_created_with_Receiving_Greater_Qnty_than_TransferredQnty() {
		GenericMethods.fnStartTestCase("GoodsReceivedNote_Deletion_which_has_been_created_with_Receiving_Greater_Qnty_than_TransferredQnty");
		log.info("*****GoodsReceivedNote Deletion****");
		String GRNVochure= ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Goods Received Note",
				4, 3);
		String strRemarks ="Deletion";
		boolean result = RefGoodsReceived.Record_Deletion(GRNVochure, strRemarks);
		Assert.assertTrue(result);
		log.info("******GoodsReceivedNote Deletion******");
		fnWriteSteps("Pass","GoodsReceivedNote Deletion");
		GenericMethods.fnEndTestCase();
		
	}

}
