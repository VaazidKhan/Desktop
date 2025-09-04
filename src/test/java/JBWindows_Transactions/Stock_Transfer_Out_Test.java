package JBWindows_Transactions;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
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
import JBWindows.SAL.SAL_DocumentHistory;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import JBWindows.Transactions.Stock_Transfer_Out_Page;
import JBWindows.Transactions.Trans_Order_Page;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class Stock_Transfer_Out_Test extends BaseClass {
    Logger log = Logger.getLogger(Stock_Transfer_Out_Test.class);

	
	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;	
	MessageBoxEffia RefMessageBoxEffia;
	Stock_Transfer_Out_Page RefStockTransfer;
	Trans_Order_Page refOrderPage;
	SAL_DocumentHistory RefEstimationHistory;
	FRM_OperatingExpenses RefExpensePage;
	
	public Stock_Transfer_Out_Test() {
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
		RefStockTransfer = new Stock_Transfer_Out_Page();
		refOrderPage = new Trans_Order_Page();
		RefEstimationHistory = new SAL_DocumentHistory();
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
			   pattern=new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\Arrow Down.PNG");
			   screen.click(pattern);
			   GenericMethods.fnwait(1);
			   screen.click(pattern);
			   GenericMethods.fnwait(1);
			   screen.click(pattern);
			   GenericMethods.fnwait(2);
			   screen.click(pattern);
			   GenericMethods.fnwait(2);
			   screen.click(pattern);
			   GenericMethods.fnwait(2);
			   screen.click(pattern);
			   pattern=new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\StockTransfer.PNG");
			   screen.click(pattern);
			   GenericMethods.fnwait(2);
    }
	@AfterMethod
	public void fn_Close_InvoiceScreen_And_Logout() {

		RefStockTransfer.clickCloseButton();
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
	public void validate_StockTransfer_Out_Creation() {
		GenericMethods.fnStartTestCase("validate_StockTransfer_Out_Creation");
		log.info("*******Stock Transfer Out Creation******");
		boolean result=false;
		int rowindex=2;
		String RequisitionorderNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Stock Transfer Out", rowindex, 1);
		String TransferQNTY = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Stock Transfer Out", rowindex, 2);
		String Type = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Stock Transfer Out", rowindex,5 );
	    RefStockTransfer.Stock_Transfer_Out_creation(RequisitionorderNo, TransferQNTY,Type);
		String Vochure = refOrderPage.get_Vochure_Page();
		String StockTransferVochure = Vochure.split(" ")[6];
		if(StockTransferVochure!=null && StockTransferVochure!="") {
			result=true;
		}
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Stock Transfer Out", rowindex, 3, StockTransferVochure.trim());
		log.info("*******Stock Transfer Out Creation******");
		fnWriteSteps("Pass", "Stock Transfer Out Creation");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void validate_StockTransfer_Out_Creation_by_SendingLessThan_RequestedQuantity() {
		GenericMethods.fnStartTestCase("validate_StockTransfer_Out_Creation_by_SendingLessThan_RequestedQuantity");
		log.info("*******Stock Transfer Out Creation by sending less than Requested Quantity******");
		boolean result=false;
		int rowindex=3;
		String StocktransferoutVoucher = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Stock Transfer Out", 2, 3);
		String TransferQNTY = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Stock Transfer Out", rowindex, 2);
		String Quantity = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Stock Transfer Out", rowindex, 4);
		RefStockTransfer.Stock_Transfer_Out_Edit(StocktransferoutVoucher, TransferQNTY, Quantity);
	if(driver.findElement(By.id("lblMessage")).getAttribute("Name").contains("Your transfer order number has been saved successfully.".trim())) {
			   result = true;
			   RefStockTransfer.click_On_Button_Ok();
		  }
	    Assert.assertTrue(result);
		log.info("*******Stock Transfer Out Creation******");
		fnWriteSteps("Pass", "Stock Transfer Out Creation");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void validate_StockTransfer_Out_Creation_by_SendingGreaterThan_RequestedQuantity() {
		GenericMethods.fnStartTestCase("validate_StockTransfer_Out_Creation_by_SendingGreaterThan_RequestedQuantity");
		log.info("*******Stock Transfer Out Creation by sending Greater than Requested Quantity******");
		boolean result=false;
		int rowindex=4;
		String StocktransferoutVoucher = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Stock Transfer Out", 2, 3);
		String TransferQNTY = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Stock Transfer Out", rowindex, 2);
		String Quantity = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Stock Transfer Out", rowindex, 4);
		RefStockTransfer.Stock_Transfer_Out_Edit(StocktransferoutVoucher, TransferQNTY, Quantity);
	if(driver.findElement(By.id("lblMessage")).getAttribute("Name").contains("Quantity should be less than or equal to requested quantity.".trim())) {
			   result = true;
			   RefStockTransfer.click_On_Button_Ok();
		}
	    Assert.assertTrue(result);
		log.info("*******Stock Transfer Out Creation******");
		fnWriteSteps("Pass", "Stock Transfer Out Creation");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void validate_Partial_StockTransfer_Out_Creation() {
		GenericMethods.fnStartTestCase("validate_Partial_StockTransfer_Out_Creation");
		log.info("*******Partial Stock Transfer Out Creation******");
		boolean result=false;
		int rowindex=5;
		String RequisitionorderNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Stock Transfer Out", rowindex, 1);
		String TransferQNTY = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Stock Transfer Out", rowindex, 2);
		String Type = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Stock Transfer Out", rowindex,5);
		RefStockTransfer.click_On_Add_Button();
		RefStockTransfer.Stock_Transfer_Out_creation(RequisitionorderNo, TransferQNTY,Type);
		String Vochure = refOrderPage.get_Vochure_Page();
		String StockTransferVochure = Vochure.split(" ")[6];
		if(StockTransferVochure!=null && StockTransferVochure!="") {
			result=true;
		}
		Assert.assertTrue(result);
		ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Stock Transfer Out", rowindex, 3, StockTransferVochure.trim());
		log.info("*******Partial Stock Transfer Out Creation******");
		fnWriteSteps("Pass", "Partial Stock Transfer Out Creation");
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void validate_StockTransfer_Out_Deletion_Current_Device() {
		GenericMethods.fnStartTestCase("validate_StockTransfer_Out_Deletion_Current_Device");
		log.info("*******Stock Transfer Out Deletion Current Device******");
		String StockTransferVoucher = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Stock Transfer Out", 2, 3);
		String Remarks="Current Device";
		RefEstimationHistory.serachRecord(StockTransferVoucher);
		RefExpensePage.click_Delete_Button();
		refOrderPage.click_Header_Button();
	    boolean result=	RefExpensePage.send_Remarks(Remarks);
		Assert.assertTrue(result);
		log.info("******Stock Transfer Out Deletion******");
		fnWriteSteps("Pass","Stock Transfer Out Deletion");
		GenericMethods.fnEndTestCase();
	}
	@Test 
	public void validate_Partial_StockTransfer_Out_Deletion() {
		GenericMethods.fnStartTestCase("validate_Partial_StockTransfer_Out_Deletion");
		log.info("*******Partial Stock Transfer Out Deletion******");
		String StockTransferVoucher = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Stock Transfer Out", 5, 3);
		String Remarks="Deletion";
		RefEstimationHistory.serachRecord(StockTransferVoucher);
		RefExpensePage.click_Delete_Button();
		refOrderPage.click_Header_Button();
	    boolean result=	RefExpensePage.send_Remarks(Remarks);
		Assert.assertTrue(result);
		log.info("******Partial Stock Transfer Out Deletion******");
		fnWriteSteps("Pass","Partial Stock Transfer Out Deletion");
		GenericMethods.fnEndTestCase();
	}
	
   
	
	
}
