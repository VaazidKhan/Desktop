package JBWindows_Transactions;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import JBWindows.APP.APP_AppSettings;
import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.COM.COM_TransactionDelete;
import JBWindows.CRM.CRM_CustomerLoyaltyInfo;
import JBWindows.CRM.CRM_CustomerMaster;
import JBWindows.CRM.CRM_CustomerPopup;
import JBWindows.FRM.FRM_Payment;
import JBWindows.FRM.FRM_PaymentByBank;
import JBWindows.FRM.FRM_PaymentByCard;
import JBWindows.FRM.FRM_PaymentByCheque;
import JBWindows.FRM.FRM_PaymentByVoucher;
import JBWindows.FRM.FRM_PaymentNotes;
import JBWindows.FRM.FRM_YouPayWalletAuthentication;
import JBWindows.SAL.SAL_DocumentHistory;
import JBWindows.SAL.SAL_DueDateEntry;
import JBWindows.SAL.SAL_ExchangePopup;
import JBWindows.SAL.SAL_InvoiceRecall;
import JBWindows.SAL.SAL_InvoiceTaxAndDiscount;
import JBWindows.SAL.SAL_PointOfSales;
import JBWindows.SAL.SAL_Refund;
import JBWindows.SAL.SR_Table;
import JBWindows.SAL.SR_TablePopUp;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class DineIn_InvoiceCreation_UnitTest extends BaseClass {

	Login refLogin;
	APP_Dashboard refDashboard;
	APP_Menu refMenu;
	MessageBoxEffia refMessgBox;
	SAL_PointOfSales refInvoiceScreen;
	CRM_CustomerPopup refCustomerPopup;
	APP_AppSettings refAppSettings;
	CRM_CustomerMaster refCustomerMaster;
	SAL_DocumentHistory refInvoiceHistory;
	SAL_InvoiceRecall refRecallPage;
	SAL_InvoiceTaxAndDiscount refInvoiceTaxAndDiscount;
	SAL_DueDateEntry refDueDateEntry;
	COM_TransactionDelete refTransactionDeletePopUp;
	FRM_Payment refPaymentWindow;
	FRM_PaymentNotes refPaymentDenominationWindow;
	SR_TablePopUp refTablePopUp;
	SAL_Refund refRefundWindow;
	SAL_ExchangePopup refExchangePopup;
	SR_Table refTablePage;
	FRM_PaymentByCard refPaymentByCard;
	FRM_YouPayWalletAuthentication refPaymentByWallet;
	FRM_PaymentByBank refPaymentByBank;
	FRM_PaymentByVoucher refPaymentByVoucher;
	FRM_PaymentByCheque refPaymentByCheque;
	CRM_CustomerLoyaltyInfo refPaymentByCustomerLoyalty;

	public DineIn_InvoiceCreation_UnitTest() {
		super();
	}


	@BeforeMethod
	public void fn_Login_and_Open_Page() {
		refLogin = new Login(driver);
		refDashboard = new APP_Dashboard(driver);
		refMenu = new APP_Menu(driver);
		refMessgBox = new MessageBoxEffia(driver);
		refInvoiceScreen = new SAL_PointOfSales();
		refCustomerPopup = new CRM_CustomerPopup();
		refAppSettings = new APP_AppSettings();
		refCustomerMaster = new CRM_CustomerMaster();
		refInvoiceHistory = new SAL_DocumentHistory();
		refRecallPage = new SAL_InvoiceRecall();
		refInvoiceTaxAndDiscount = new SAL_InvoiceTaxAndDiscount();
		refDueDateEntry = new SAL_DueDateEntry();
		refTransactionDeletePopUp = new COM_TransactionDelete();
		refPaymentWindow = new FRM_Payment();
		refPaymentDenominationWindow = new FRM_PaymentNotes();
		refTablePopUp = new SR_TablePopUp();
		refRefundWindow = new SAL_Refund();
		refExchangePopup = new SAL_ExchangePopup();
		refTablePage = new SR_Table();
		refPaymentByCard = new FRM_PaymentByCard();
		refPaymentByWallet = new FRM_YouPayWalletAuthentication();
		refPaymentByBank = new FRM_PaymentByBank();
		refPaymentByVoucher = new FRM_PaymentByVoucher();
		refPaymentByCheque = new FRM_PaymentByCheque();
		refPaymentByCustomerLoyalty = new CRM_CustomerLoyaltyInfo();

		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		refLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(3);
		refDashboard.clickMenuBtn();
		GenericMethods.fnwait(1);
		refMenu.activatePage();
		GenericMethods.fnwait(2);
		refMenu.OpenPage("invoicing");
		GenericMethods.fnwait(2);
	}

	@Test
	public void fnDoRequiredSettings() {

		refInvoiceScreen.clickDashboardButton();
		GenericMethods.fnwait(2);

		refDashboard.clickMenuBtn();
		refMenu.OpenPage("application settings");
		GenericMethods.fnwait(5);
		refAppSettings.enableAllPaymentmodes();
		refMessgBox.clickOkButton();
		GenericMethods.fnwait(1);

		refDashboard.clickMenuBtn();
		refMenu.OpenPage("application settings");
		GenericMethods.fnwait(5);
		refAppSettings.salesOrderTypechange("Dine-In");
		GenericMethods.fnwait(1);
		refMessgBox.clickOkButton();
		GenericMethods.fnwait(1);

		refDashboard.clickMenuBtn();
		refMenu.OpenPage("invoicing");
		GenericMethods.fnwait(2);
	}

	@Test
	public void fnVerifyTableCreation_RuntimeCustmerAndDineIn_InvoiceCreation() {
		GenericMethods.fnStartTestCase("Verify table, runtime Customer and Dine In Invoice creation");

		refInvoiceScreen.clickDashboardButton();
		GenericMethods.fnwait(2);
		refDashboard.clickMenuBtn();
		refMenu.OpenPage("tables");
		GenericMethods.fnwait(1);

		int startingRowNumber = Integer
				.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Tables", 1, 4));

		int lastRowNumber = Integer
				.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Tables", 1, 5));

		int rowNumber_runTimeCustomer = Integer
				.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Customers", 1, 25));

		int startingRowNumber_Product = Integer.parseInt(ExcelUtils
				.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Transaction_Invoice_TakeAway", 1, 0));

		int lastRowNumber_Product = Integer.parseInt(ExcelUtils
				.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Transaction_Invoice_TakeAway", 1, 1));

		refTablePage.fnCreateTable(startingRowNumber, lastRowNumber);
		GenericMethods.fnwait(1);
		refTablePage.clickCloseButton();
		GenericMethods.fnwait(1);
		refDashboard.ClickBillingPageButton();
		GenericMethods.fnwait(1);

		refInvoiceScreen.clickTableButton();
		GenericMethods.fnwait(1);
		refTablePopUp.tableSelection();
		GenericMethods.fnwait(1);		

		refInvoiceScreen.clickCustomerButton();
		refCustomerPopup.fnRuntimeCustomerCreation(rowNumber_runTimeCustomer);
		refInvoiceScreen.addProductToCart(startingRowNumber_Product, lastRowNumber_Product);
		refInvoiceScreen.clickPaymentButton();
		GenericMethods.fnwait(1);

		refPaymentWindow.SelectPaymentMode("CASH");
		GenericMethods.fnwait(3);
		refPaymentDenominationWindow.clickSaveButton();
		GenericMethods.fnwait(1);
		refPaymentWindow.clickFinishButton();

		String labelMessage = refMessgBox.fnGetLabelMessage();
		if (labelMessage.contains("INV/")) {
			fnWriteSteps("pass", "Dine-In invoice has been created successfully");
		} else {
			fnWriteSteps("Fail", "Dine-In invoice has not been created");
		}

		GenericMethods.fnwait(1);
		refMessgBox.ClickOkButton();
		GenericMethods.fnwait(1);

		GenericMethods.fnEndTestCase();

	}

	@Test
	public void fnVerifyDineIn_InvoiceCreationWithCashPaymentMode() {
		GenericMethods.fnStartTestCase("Verify Dine-In invoice creation with Cash Payment mode");

		refInvoiceScreen.clickTableButton();
		GenericMethods.fnwait(1);
		refTablePopUp.tableSelection();
		GenericMethods.fnwait(1);
		
		refInvoiceScreen.clickCustomerButton();
		GenericMethods.fnwait(2);

		int rowNumberExistingCustomer = Integer.parseInt(ExcelUtils
				.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Transaction_Invoice_TakeAway", 1, 13));

		refCustomerPopup.fnExistingCustomerSelection(rowNumberExistingCustomer);

		int startingRowNumber = Integer.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Transaction_Invoice_TakeAway", 1, 0));

		int lastRowNumber = Integer.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Transaction_Invoice_TakeAway", 1, 1));

		refInvoiceScreen.addProductToCart(startingRowNumber, lastRowNumber);
		GenericMethods.fnwait(1);
		refInvoiceScreen.clickPaymentButton();
		GenericMethods.fnwait(1);

		String totalAmount = refPaymentWindow.getReceivableAmount();

		refPaymentWindow.SelectPaymentMode("CASH");
		GenericMethods.fnwait(3);
		refPaymentDenominationWindow.paymentCashByNumberPad(totalAmount);
		refPaymentDenominationWindow.clickSaveButton();
		GenericMethods.fnwait(1);

		String balanceAmount_Cash = refPaymentWindow.getBalanceAmount();
		if (balanceAmount_Cash.equals("0.00")) {
			fnWriteSteps("pass", "Invoice has been created successfully with Cash payment mode");
		} else {
			fnWriteSteps("Fail", "Invoice has not been created successfully with Cash payment mode");
		}
		refPaymentWindow.clickFinishButton();
		GenericMethods.fnwait(2);
		refMessgBox.ClickOkButton();
		GenericMethods.fnwait(2);

		GenericMethods.fnEndTestCase();

	}

	@Test
	public void fnVerifyDineIn_InvoiceCreationWithCardPaymentMode() {
		GenericMethods.fnStartTestCase("Verify Dine-In invoice creation with Card Payment mode");

		refInvoiceScreen.clickTableButton();
		GenericMethods.fnwait(1);
		refTablePopUp.tableSelection();
		GenericMethods.fnwait(1);		

		refInvoiceScreen.clickCustomerButton();
		GenericMethods.fnwait(2);
		int rowNumberExistingCustomer = Integer.parseInt(ExcelUtils
				.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Transaction_Invoice_TakeAway", 1, 13));

		refCustomerPopup.fnExistingCustomerSelection(rowNumberExistingCustomer);

		int startingRowNumber = Integer.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Transaction_Invoice_TakeAway", 1, 0));

		int lastRowNumber = Integer.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Transaction_Invoice_TakeAway", 1, 1));

		refInvoiceScreen.addProductToCart(startingRowNumber, lastRowNumber);
		refInvoiceScreen.clickPaymentButton();
		GenericMethods.fnwait(1);

		refPaymentWindow.SelectPaymentMode("CARD");
		GenericMethods.fnwait(3);
		refPaymentByCard.collectFullPaymentByCard();

		String balanceAmount_Card = refPaymentWindow.getBalanceAmount();
		if (balanceAmount_Card.equals("0.00")) {
			fnWriteSteps("pass", "Invoice has been created successfully with Card payment mode");
		} else {
			fnWriteSteps("Fail", "Invoice has not been created successfully with Card payment mode");
		}
		refPaymentWindow.clickFinishButton();
		GenericMethods.fnwait(2);
		refMessgBox.ClickOkButton();
		GenericMethods.fnwait(1);

		GenericMethods.fnEndTestCase();

	}

	@Test
	public void fnVerifyDineIn_InvoiceCreationWithWalletPaymentMode() {
		GenericMethods.fnStartTestCase("Verify Dine-In invoice creation with Wallet Payment modes");

		refInvoiceScreen.clickTableButton();
		GenericMethods.fnwait(1);
		refTablePopUp.tableSelection();
		GenericMethods.fnwait(1);		

		refInvoiceScreen.clickCustomerButton();
		GenericMethods.fnwait(2);
		int rowNumberExistingCustomer = Integer.parseInt(ExcelUtils
				.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Transaction_Invoice_TakeAway", 1, 13));

		refCustomerPopup.fnExistingCustomerSelection(rowNumberExistingCustomer);

		int startingRowNumber = Integer.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Transaction_Invoice_TakeAway", 1, 0));

		int lastRowNumber = Integer.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Transaction_Invoice_TakeAway", 1, 1));

		refInvoiceScreen.addProductToCart(startingRowNumber, lastRowNumber);
		refInvoiceScreen.clickPaymentButton();
		GenericMethods.fnwait(2);
		String totalAmount_One = refPaymentWindow.getReceivableAmount();

		refPaymentWindow.SelectPaymentMode("WALLET");
		GenericMethods.fnwait(3);
		refPaymentByWallet.selectWalletPaymentType("PAYTM", totalAmount_One);

		String balanceAmount_Wallet_Paytm = refPaymentWindow.getBalanceAmount();
		if (balanceAmount_Wallet_Paytm.equals("0.00")) {
			fnWriteSteps("pass", "Invoice has been created successfully with Paytm wallet payment mode");
		} else {
			fnWriteSteps("Fail", "Invoice has not been created successfully with Paytm wallet payment mode");
		}
		refPaymentWindow.clickFinishButton();
		GenericMethods.fnwait(2);
		refMessgBox.ClickOkButton();
		GenericMethods.fnwait(2);

		refInvoiceScreen.clickTableButton();
		GenericMethods.fnwait(1);
		refTablePopUp.tableSelection();
		GenericMethods.fnwait(1);		

		refInvoiceScreen.clickCustomerButton();
		GenericMethods.fnwait(2);
		refCustomerPopup.fnExistingCustomerSelection(rowNumberExistingCustomer);
		refInvoiceScreen.addProductToCart(startingRowNumber, lastRowNumber);
		refInvoiceScreen.clickPaymentButton();
		GenericMethods.fnwait(2);
		String totalAmount_Two = refPaymentWindow.getReceivableAmount();
		refPaymentWindow.SelectPaymentMode("WALLET");
		GenericMethods.fnwait(3);
		refPaymentByWallet.selectWalletPaymentType("MOBIKWIK", totalAmount_Two);

		String balanceAmount_Wallet_Mobikwik = refPaymentWindow.getBalanceAmount();
		if (balanceAmount_Wallet_Mobikwik.equals("0.00")) {
			fnWriteSteps("pass", "Invoice has been created successfully with Mobikwik wallet payment mode");
		} else {
			fnWriteSteps("Fail", "Invoice has not been created successfully with Mobikwik wallet payment mode");
		}
		refPaymentWindow.clickFinishButton();
		GenericMethods.fnwait(2);
		refMessgBox.ClickOkButton();
		GenericMethods.fnwait(1);

		refInvoiceScreen.clickTableButton();
		GenericMethods.fnwait(1);
		refTablePopUp.tableSelection();
		GenericMethods.fnwait(1);		

		refInvoiceScreen.clickCustomerButton();
		GenericMethods.fnwait(2);
		refCustomerPopup.fnExistingCustomerSelection(rowNumberExistingCustomer);
		refInvoiceScreen.addProductToCart(startingRowNumber, lastRowNumber);
		refInvoiceScreen.clickPaymentButton();
		GenericMethods.fnwait(2);
		String totalAmount_Three = refPaymentWindow.getReceivableAmount();
		refPaymentWindow.SelectPaymentMode("WALLET");
		GenericMethods.fnwait(3);
		refPaymentByWallet.selectWalletPaymentType("FREECHARGE", totalAmount_Three);

		String balanceAmount_Wallet_Freecharge = refPaymentWindow.getBalanceAmount();
		if (balanceAmount_Wallet_Freecharge.equals("0.00")) {
			fnWriteSteps("pass", "Invoice has been created successfully with Freecharge wallet payment mode");
		} else {
			fnWriteSteps("Fail", "Invoice has not been created successfully with Freecharge wallet payment mode");
		}
		refPaymentWindow.clickFinishButton();
		GenericMethods.fnwait(2);
		refMessgBox.ClickOkButton();
		GenericMethods.fnwait(1);

		refInvoiceScreen.clickTableButton();
		GenericMethods.fnwait(1);
		refTablePopUp.tableSelection();
		GenericMethods.fnwait(1);		

		refInvoiceScreen.clickCustomerButton();
		GenericMethods.fnwait(2);
		refCustomerPopup.fnExistingCustomerSelection(rowNumberExistingCustomer);
		refInvoiceScreen.addProductToCart(startingRowNumber, lastRowNumber);
		refInvoiceScreen.clickPaymentButton();
		GenericMethods.fnwait(2);
		String totalAmount_Four = refPaymentWindow.getReceivableAmount();
		refPaymentWindow.SelectPaymentMode("WALLET");
		GenericMethods.fnwait(3);
		refPaymentByWallet.selectWalletPaymentType("AIRTEL_MONEY", totalAmount_Four);

		String balanceAmount_Wallet_AIRTEL_MONEY = refPaymentWindow.getBalanceAmount();
		if (balanceAmount_Wallet_AIRTEL_MONEY.equals("0.00")) {
			fnWriteSteps("pass", "Invoice has been created successfully with Airtel Money wallet payment mode");
		} else {
			fnWriteSteps("Fail", "Invoice has not been created successfully with Airtel Money wallet payment mode");
		}
		refPaymentWindow.clickFinishButton();
		GenericMethods.fnwait(2);
		refMessgBox.ClickOkButton();
		GenericMethods.fnwait(1);

		refInvoiceScreen.clickTableButton();
		GenericMethods.fnwait(1);
		refTablePopUp.tableSelection();
		GenericMethods.fnwait(1);		

		refInvoiceScreen.clickCustomerButton();
		GenericMethods.fnwait(2);
		refCustomerPopup.fnExistingCustomerSelection(rowNumberExistingCustomer);
		refInvoiceScreen.addProductToCart(startingRowNumber, lastRowNumber);
		refInvoiceScreen.clickPaymentButton();
		GenericMethods.fnwait(2);
		String totalAmount_Five = refPaymentWindow.getReceivableAmount();
		refPaymentWindow.SelectPaymentMode("WALLET");
		GenericMethods.fnwait(3);
		refPaymentByWallet.selectWalletPaymentType("OLA_MONEY", totalAmount_Five);

		String balanceAmount_Wallet_OLA_MONEY = refPaymentWindow.getBalanceAmount();
		if (balanceAmount_Wallet_OLA_MONEY.equals("0.00")) {
			fnWriteSteps("pass", "Invoice has been created successfully with Ola Money wallet payment mode");
		} else {
			fnWriteSteps("Fail", "Invoice has not been created successfully with Ola Money wallet payment mode");
		}
		refPaymentWindow.clickFinishButton();
		GenericMethods.fnwait(2);
		refMessgBox.ClickOkButton();
		GenericMethods.fnwait(1);

		GenericMethods.fnEndTestCase();

	}

	@Test
	public void fnVerifyDineIn_InvoiceCreationWithBankPaymentMode() {
		GenericMethods.fnStartTestCase("Verify Dine-In invoice creation with Bank Payment modes");

		refInvoiceScreen.clickTableButton();
		GenericMethods.fnwait(1);
		refTablePopUp.tableSelection();
		GenericMethods.fnwait(1);
		
		refInvoiceScreen.clickCustomerButton();
		GenericMethods.fnwait(2);
		int rowNumberExistingCustomer = Integer.parseInt(ExcelUtils
				.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Transaction_Invoice_TakeAway", 1, 13));

		refCustomerPopup.fnExistingCustomerSelection(rowNumberExistingCustomer);

		int startingRowNumber = Integer.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Transaction_Invoice_TakeAway", 1, 0));

		int lastRowNumber = Integer.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Transaction_Invoice_TakeAway", 1, 1));

		refInvoiceScreen.addProductToCart(startingRowNumber, lastRowNumber);
		refInvoiceScreen.clickPaymentButton();
		GenericMethods.fnwait(1);
		String totalAmount = refPaymentWindow.getReceivableAmount();

		refPaymentWindow.SelectPaymentMode("BANK");
		GenericMethods.fnwait(1);

		int rowNumber_BankAccountDetails = Integer.parseInt(ExcelUtils
				.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Transaction_Invoice_TakeAway", 1, 4));
		refPaymentByBank.selectBankDetails(rowNumber_BankAccountDetails, totalAmount);

		String balanceAmount = refPaymentWindow.getBalanceAmount();
		if (balanceAmount.equals("0.00")) {
			fnWriteSteps("pass", "Invoice has been created successfully with Bank payment mode");
		} else {
			fnWriteSteps("Fail", "Invoice has not been created successfully with Bank payment mode");
		}
		refPaymentWindow.clickFinishButton();
		GenericMethods.fnwait(2);
		refMessgBox.ClickOkButton();
		GenericMethods.fnwait(1);

		GenericMethods.fnEndTestCase();

	}

	@Test
	public void fnVerifyDineIn_InvoiceCreationWithGiftVoucherPaymentMode() {
		GenericMethods.fnStartTestCase("Verify Dine-IN invoice creation with Gift Voucher Payment modes");

		refInvoiceScreen.clickTableButton();
		GenericMethods.fnwait(1);
		refTablePopUp.tableSelection();
		GenericMethods.fnwait(1);		

		refInvoiceScreen.clickCustomerButton();
		GenericMethods.fnwait(2);

		int rowNumberExistingCustomer = Integer.parseInt(ExcelUtils
				.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Transaction_Invoice_TakeAway", 1, 13));

		refCustomerPopup.fnExistingCustomerSelection(rowNumberExistingCustomer);

		int startingRowNumber = Integer.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Transaction_Invoice_TakeAway", 1, 0));

		int lastRowNumber = Integer.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Transaction_Invoice_TakeAway", 1, 1));

		refInvoiceScreen.addProductToCart(startingRowNumber, lastRowNumber);
		GenericMethods.fnwait(1);
		String totalAmount_3rdParty = refInvoiceScreen.getTotalAmount();
		refInvoiceScreen.clickPaymentButton();
		GenericMethods.fnwait(1);

		refPaymentWindow.SelectPaymentMode("VOUCHER");
		int rowNumber_VoucherDetails = Integer.parseInt(ExcelUtils
				.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Transaction_Invoice_TakeAway", 1, 9));

		refPaymentByVoucher.selectVoucherPaymentType("3RD_PARTY_VOUCHER", rowNumber_VoucherDetails,
				totalAmount_3rdParty);
		GenericMethods.fnwait(1);

		String balanceAmount_3rdPartyVoucher = refPaymentWindow.getBalanceAmount();
		if (balanceAmount_3rdPartyVoucher.equals("0.00")) {
			fnWriteSteps("pass", "Invoice has been created successfully with 3rd party gift voucher");
		} else {
			fnWriteSteps("Fail", "Invoice has not been created successfully with 3rd party gift voucher");
		}

		refPaymentWindow.clickFinishButton();
		GenericMethods.fnwait(2);
		refMessgBox.ClickOkButton();
		GenericMethods.fnwait(1);

		refInvoiceScreen.clickTableButton();
		GenericMethods.fnwait(1);
		refTablePopUp.tableSelection();
		GenericMethods.fnwait(1);	
		refInvoiceScreen.clickCustomerButton();
		GenericMethods.fnwait(2);

		refCustomerPopup.fnExistingCustomerSelection(rowNumberExistingCustomer);

		refInvoiceScreen.addProductToCart(startingRowNumber, lastRowNumber);
		GenericMethods.fnwait(1);
		String totalAmount_Own = refInvoiceScreen.getTotalAmount();
		refInvoiceScreen.clickPaymentButton();
		GenericMethods.fnwait(1);

		refPaymentWindow.SelectPaymentMode("VOUCHER");
		refPaymentByVoucher.selectVoucherPaymentType("OWN_VOUCHER", rowNumber_VoucherDetails, totalAmount_Own);
		GenericMethods.fnwait(1);

		String balanceAmount_OwnVoucher = refPaymentWindow.getBalanceAmount();
		if (balanceAmount_OwnVoucher.equals("0.00")) {
			fnWriteSteps("pass", "Invoice has been created successfully with own gift voucher");
		} else {
			fnWriteSteps("Fail", "Invoice has not been created successfully with own gift voucher");
		}

		refPaymentWindow.clickFinishButton();
		GenericMethods.fnwait(2);
		refMessgBox.ClickOkButton();
		GenericMethods.fnwait(1);

		GenericMethods.fnEndTestCase();

	}

	@Test
	public void fnVerifyDineIn_InvoiceCreationWithChequePaymentMode() {
		GenericMethods.fnStartTestCase("Verify Dine-In invoice creation with Cheque Payment mode");

		refInvoiceScreen.clickTableButton();
		GenericMethods.fnwait(1);
		refTablePopUp.tableSelection();
		GenericMethods.fnwait(1);
		/*String strConfirmationMessage = refMessgBox.fnGetLabelMessage();	
		if (strConfirmationMessage.contains("occupied")) {
		refMessgBox.ClickOkButton();
		}*/
		refInvoiceScreen.clickCustomerButton();
		GenericMethods.fnwait(2);
		int rowNumberExistingCustomer = Integer.parseInt(ExcelUtils
				.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Transaction_Invoice_TakeAway", 1, 13));

		refCustomerPopup.fnExistingCustomerSelection(rowNumberExistingCustomer);

		int startingRowNumber = Integer.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Transaction_Invoice_TakeAway", 1, 0));

		int lastRowNumber = Integer.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Transaction_Invoice_TakeAway", 1, 1));

		refInvoiceScreen.addProductToCart(startingRowNumber, lastRowNumber);
		refInvoiceScreen.clickPaymentButton();
		GenericMethods.fnwait(1);
		String totalAmount = refPaymentWindow.getReceivableAmount();

		refPaymentWindow.SelectPaymentMode("CHEQUE");
		GenericMethods.fnwait(2);
		int rowNumber_ChequeDetails = Integer.parseInt(ExcelUtils
				.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Transaction_Invoice_TakeAway", 1, 4));
		refPaymentByCheque.selectChequeDetails(rowNumber_ChequeDetails, totalAmount);

		String balanceAmount = refPaymentWindow.getBalanceAmount();
		if (balanceAmount.equals("0.00")) {
			fnWriteSteps("pass", "Invoice has been created successfully with Cheque payment mode");
		} else {
			fnWriteSteps("Fail", "Invoice has not been created successfully with Cheque payment mode");
		}
		refPaymentWindow.clickFinishButton();
		GenericMethods.fnwait(2);
		refMessgBox.ClickOkButton();
		GenericMethods.fnwait(1);

		GenericMethods.fnEndTestCase();

	}	
	
	@Test
	public void fnVerifyDineIn_InvoiceCreationAsOnAccount() {
		GenericMethods.fnStartTestCase("Verify Dine-In invoice creation as On Account");

		refInvoiceScreen.clickTableButton();
		GenericMethods.fnwait(1);
		refTablePopUp.tableSelection();
		GenericMethods.fnwait(1);
		refInvoiceScreen.clickCustomerButton();
		GenericMethods.fnwait(2);

		int rowNumberExistingCustomer = Integer.parseInt(ExcelUtils
				.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Transaction_Invoice_TakeAway", 1, 13));

		refCustomerPopup.fnExistingCustomerSelection(rowNumberExistingCustomer);

		int startingRowNumber = Integer.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Transaction_Invoice_TakeAway", 1, 0));

		int lastRowNumber = Integer.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Transaction_Invoice_TakeAway", 1, 1));

		refInvoiceScreen.addProductToCart(startingRowNumber, lastRowNumber);
		refInvoiceScreen.clickPaymentButton();
		GenericMethods.fnwait(1);

		refPaymentWindow.SelectPaymentMode("CREDIT");
		GenericMethods.fnwait(1);

		String balanceAmount = refPaymentWindow.getBalanceAmount();
		if (balanceAmount.equals("0.00")) {
			fnWriteSteps("pass", "Invoice has been created successfully on Credit");
		} else {
			fnWriteSteps("Fail", "Invoice has not been created successfully on Credit");
		}
		refPaymentWindow.clickFinishButton();
		GenericMethods.fnwait(2);
		refMessgBox.ClickOkButton();
		GenericMethods.fnwait(1);

		GenericMethods.fnEndTestCase();

	}
	
	@Test
	public void fnVerifyDineIn_InvoiceCreationWithRedeemPaymentMode() {
		GenericMethods.fnStartTestCase("Verify Dine-In invoice creation with Redeem Payment mode");

		refInvoiceScreen.clickTableButton();
		GenericMethods.fnwait(1);
		refTablePopUp.tableSelection();
		GenericMethods.fnwait(1);
		refInvoiceScreen.clickCustomerButton();
		GenericMethods.fnwait(2);
		int rowNumberExistingCustomer = Integer.parseInt(ExcelUtils
				.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Transaction_Invoice_TakeAway", 1, 13));

		refCustomerPopup.fnExistingCustomerSelection(rowNumberExistingCustomer);

		int startingRowNumber = Integer.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Transaction_Invoice_TakeAway", 1, 0));

		int lastRowNumber = Integer.parseInt(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
				"Transaction_Invoice_TakeAway", 1, 1));

		refInvoiceScreen.addProductToCart(startingRowNumber, lastRowNumber);
		GenericMethods.fnwait(1);
		refInvoiceScreen.clickPaymentButton();
		GenericMethods.fnwait(1);

		refPaymentWindow.SelectPaymentMode("CASH");
		GenericMethods.fnwait(3);
		refPaymentDenominationWindow.clickSaveButton();
		GenericMethods.fnwait(1);
		refPaymentWindow.clickFinishButton();
		GenericMethods.fnwait(1);
		refMessgBox.ClickOkButton();

		refInvoiceScreen.clickDashboardButton();
		GenericMethods.fnwait(3);
		refDashboard.ClickBillingPageButton();
		GenericMethods.fnwait(3);

		refInvoiceScreen.clickTableButton();
		GenericMethods.fnwait(1);
		refTablePopUp.tableSelection();
		GenericMethods.fnwait(1);
		refInvoiceScreen.clickCustomerButton();
		GenericMethods.fnwait(2);
		refCustomerPopup.fnExistingCustomerSelection(rowNumberExistingCustomer);
		refInvoiceScreen.addProductToCart(startingRowNumber, lastRowNumber);

		GenericMethods.fnwait(2);
		String totalAmount = refInvoiceScreen.getTotalAmount();
		refInvoiceScreen.clickPaymentButton();
		GenericMethods.fnwait(1);

		refPaymentWindow.SelectPaymentMode("LOYALTYWALLET");
		GenericMethods.fnwait(1);

		refPaymentByCustomerLoyalty.selectLoyaltyDetails(totalAmount);
		GenericMethods.fnwait(1);
		refPaymentByCustomerLoyalty.clickSaveButton();

		String redeemedAmount = refPaymentWindow.getRedeemedAmount();
		if (!redeemedAmount.equals("0.00")) {
			fnWriteSteps("pass", "Invoice has been created successfully with Redeeming the Loyalty point");
		} else {
			fnWriteSteps("Fail", "Invoice has not been created successfully with Redeeming the Loyalty point");
		}
		refPaymentWindow.clickFinishButton();
		GenericMethods.fnwait(2);
		refMessgBox.ClickOkButton();
		GenericMethods.fnwait(1);

		GenericMethods.fnEndTestCase();

	}

	/*
	 * HAve to separate Tax & Discount
	 * 
	 * @Test(priority = 2, enabled = false) public void fnSetDiscountAndTaxRuntime()
	 * { GenericMethods.fnStartTestCase("Set Invoice level Discount and Tax at runtime");
	 * 
	 * RefInvoiceScreen.clickTableButton(); GenericMethods.fnwait(1);
	 * RefTablePopUp.tableSelection(); GenericMethods.fnwait(1);
	 * RefMessgBox.ClickOkButton(); GenericMethods.fnwait(1);
	 * 
	 * RefInvoiceScreen.addProductToCart(1,1);
	 * RefInvoiceScreen.clickTaxDiscountButton();
	 * RefInvoiceTaxAndDiscount.setTaxAndDiscount(1);
	 * RefInvoiceScreen.clickPaymentButton(); GenericMethods.fnwait(1);
	 * 
	 * RefPaymentWindow.SelectPaymentMode("CASH"); GenericMethods.fnwait(3);
	 * RefPaymentDenominationWindow.clickSaveButton(); GenericMethods.fnwait(1);
	 * RefPaymentWindow.clickFinishButton();
	 * 
	 * GenericMethods.fnwait(1); RefMessgBox.ClickOkButton();
	 * GenericMethods.fnwait(1);
	 * 
	 * GenericMethods.fnEndTestCase(); }
	 */

	@Test
	public void fnVerifyHoldAndRecall() {
		GenericMethods.fnStartTestCase("Verify Invoice Hold and Recall feature");

		refInvoiceScreen.clickTableButton();
		GenericMethods.fnwait(1);
		refTablePopUp.tableSelection();
		GenericMethods.fnwait(1);
		refMessgBox.ClickOkButton();
		GenericMethods.fnwait(1);

		refInvoiceScreen.addProductToCart(1, 1);
		refInvoiceScreen.clickHoldButton();
		GenericMethods.fnwait(1);

		refMessgBox.clickOkButton();
		fnWriteSteps("Pass", "Invoice has been kept on hold successfully");
		refInvoiceScreen.clickRecallButton();
		GenericMethods.fnwait(1);
		refRecallPage.recallHoldInvoice();
		fnWriteSteps("Pass", "Invoice has been recalled successfully");
		refInvoiceScreen.clickPaymentButton();
		GenericMethods.fnwait(1);

		refPaymentWindow.SelectPaymentMode("CASH");
		GenericMethods.fnwait(3);
		refPaymentDenominationWindow.clickSaveButton();
		GenericMethods.fnwait(1);
		refPaymentWindow.clickFinishButton();

		GenericMethods.fnwait(1);
		refMessgBox.clickOkButton();
		GenericMethods.fnwait(1);

		GenericMethods.fnEndTestCase();
	}
	
	@Test
	public void fnVerifyPaymentOfDueInvoice() {
		GenericMethods.fnStartTestCase("Verify payment of a Due Invoice from Invoice screen");

		refInvoiceScreen.clickTableButton();
		GenericMethods.fnwait(1);
		refTablePopUp.tableSelection();
		GenericMethods.fnwait(1);
		refMessgBox.ClickOkButton();
		GenericMethods.fnwait(1);

		refInvoiceScreen.addProductToCart(1, 1);
		refInvoiceScreen.clickPaymentButton();
		GenericMethods.fnwait(1);
		refPaymentWindow.clickFinishButton();

		String labelMessageOne = refMessgBox.fnGetLabelMessage();
		if (labelMessageOne.contains("credit")) {
			fnWriteSteps("pass", "Due invoice has been created successfully");
		} else {
			fnWriteSteps("Fail", "Due invoice has not been created");
		}
		refMessgBox.clickOkButton();
		GenericMethods.fnwait(1);
		String invoiceNo = refMessgBox.fnGetSalesInvoiceNo();
		GenericMethods.fnwait(1);
		refMessgBox.clickOkButton();
		GenericMethods.fnwait(1);

		refInvoiceScreen.clickRecallButton();
		GenericMethods.fnwait(1);
		refRecallPage.searchRecord(invoiceNo);
		GenericMethods.fnwait(1);
		refRecallPage.clickOkButton();
		GenericMethods.fnwait(1);

		refInvoiceScreen.clickPaymentButton();
		GenericMethods.fnwait(1);

		refPaymentWindow.SelectPaymentMode("CASH");
		GenericMethods.fnwait(3);
		refPaymentDenominationWindow.clickSaveButton();
		GenericMethods.fnwait(1);
		refPaymentWindow.clickFinishButton();

		GenericMethods.fnwait(1);
		String labelMessageTwo = refMessgBox.fnGetLabelMessage();
		if (labelMessageTwo.contains("Payment")) {
			fnWriteSteps("pass", "Payment of due invoice has been completed successfully");
		} else {
			fnWriteSteps("Fail", "Payment of due invoice has not been completed");
		}
		refMessgBox.clickOkButton();
		GenericMethods.fnwait(1);

		GenericMethods.fnEndTestCase();
	}

	@Test
	public void fnVerifyInvoiceSavedOrNot() {
		GenericMethods.fnStartTestCase("Verify Dine In Invoice has been successfully saved or not");

		refInvoiceScreen.clickTableButton();
		GenericMethods.fnwait(1);
		refTablePopUp.tableSelection();
		GenericMethods.fnwait(1);
		refMessgBox.ClickOkButton();
		GenericMethods.fnwait(1);

		refInvoiceScreen.addProductToCart(1, 1);
		refInvoiceScreen.clickPaymentButton();
		GenericMethods.fnwait(1);

		refPaymentWindow.SelectPaymentMode("CASH");
		GenericMethods.fnwait(3);
		refPaymentDenominationWindow.clickSaveButton();
		GenericMethods.fnwait(1);
		refPaymentWindow.clickFinishButton();

		String invoiceNo = refMessgBox.fnGetSalesInvoiceNo();
		refMessgBox.clickOkButton();
		GenericMethods.fnwait(1);
		refInvoiceScreen.clickDashboardButton();
		GenericMethods.fnwait(2);

		refDashboard.clickMenuBtn();
		refMenu.OpenPage("invoice history");
		GenericMethods.fnwait(1);
		refInvoiceHistory.serachRecord(invoiceNo);
		GenericMethods.fnwait(1);
		refInvoiceHistory.verifyInvoiceIsSavedOrNot();
		GenericMethods.fnwait(1);
		refInvoiceHistory.clickCloseButton();

		refDashboard.clickMenuBtn();
		GenericMethods.fnwait(1);
		refMenu.OpenPage("invoicing");
		GenericMethods.fnwait(2);

		GenericMethods.fnEndTestCase();
	}

	@Test
	public void fnVerifyRuntimeCreatedCustomerSavedOrNot() throws IOException {
		GenericMethods.fnStartTestCase("Verify runtime created customer has been successfully saved or not");

		refInvoiceScreen.clickDashboardButton();
		GenericMethods.fnwait(2);
		refDashboard.clickMenuBtn();
		refMenu.OpenPage("customers");
		GenericMethods.fnwait(2);
		refCustomerMaster.VerifyRuntimeCustomerSavedOrNot(80);
		GenericMethods.fnwait(2);
		refCustomerMaster.clickCloseButton();
		GenericMethods.fnwait(1);

		refDashboard.clickMenuBtn();
		GenericMethods.fnwait(1);
		refMenu.OpenPage("invoicing");
		GenericMethods.fnwait(2);

		GenericMethods.fnEndTestCase();
	}

	@Test
	public void fnVerifyRefundFeature() throws IOException {
		GenericMethods.fnStartTestCase("Verify Refund feature for Dine In Invoice");

		refInvoiceScreen.clickTableButton();
		GenericMethods.fnwait(1);
		refTablePopUp.tableSelection();
		GenericMethods.fnwait(1);
		refMessgBox.ClickOkButton();
		GenericMethods.fnwait(1);

		refInvoiceScreen.addProductToCart(1, 1);
		refInvoiceScreen.clickPaymentButton();
		GenericMethods.fnwait(1);

		refPaymentWindow.SelectPaymentMode("CASH");
		GenericMethods.fnwait(3);
		refPaymentDenominationWindow.clickSaveButton();
		GenericMethods.fnwait(1);
		refPaymentWindow.clickFinishButton();

		GenericMethods.fnwait(1);
		String invoiceNo = refMessgBox.fnGetSalesInvoiceNo();
		refMessgBox.clickOkButton();
		GenericMethods.fnwait(1);

		refInvoiceScreen.clickReturnButton();
		GenericMethods.fnwait(1);
		refRecallPage.searchRecord(invoiceNo);
		GenericMethods.fnwait(1);
		refRecallPage.clickOkButton();
		GenericMethods.fnwait(1);

		refInvoiceScreen.clickRefundButton();
		GenericMethods.fnwait(1);
		refRefundWindow.clickCashButton();
		GenericMethods.fnwait(1);
		refInvoiceScreen.checkRefundIsSuccessfulOrNot();
		GenericMethods.fnwait(1);

		GenericMethods.fnEndTestCase();
	}

	@Test
	public void fnVerifyExchangeFeature() throws IOException {
		GenericMethods.fnStartTestCase("Verify Exchange feature for Dine In Invoice");

		refInvoiceScreen.clickTableButton();
		GenericMethods.fnwait(1);
		refTablePopUp.tableSelection();
		GenericMethods.fnwait(1);
		refMessgBox.ClickOkButton();
		GenericMethods.fnwait(1);

		refInvoiceScreen.addProductToCart(1, 1);
		refInvoiceScreen.clickPaymentButton();
		GenericMethods.fnwait(1);

		refPaymentWindow.SelectPaymentMode("CASH");
		GenericMethods.fnwait(3);
		refPaymentDenominationWindow.clickSaveButton();
		GenericMethods.fnwait(1);
		refPaymentWindow.clickFinishButton();

		GenericMethods.fnwait(1);
		String invoiceNo = refMessgBox.fnGetSalesInvoiceNo();
		refMessgBox.clickOkButton();
		GenericMethods.fnwait(1);

		refInvoiceScreen.clickReturnButton();
		GenericMethods.fnwait(1);
		refRecallPage.searchRecord(invoiceNo);
		GenericMethods.fnwait(1);
		refRecallPage.clickOkButton();
		GenericMethods.fnwait(1);

		refInvoiceScreen.clickExchangeButton();
		GenericMethods.fnwait(1);
		refExchangePopup.clickOkButton();
		GenericMethods.fnwait(1);

		refInvoiceScreen.addProductToCart(1, 2);
		refInvoiceScreen.clickPaymentButton();
		GenericMethods.fnwait(1);

		refPaymentWindow.SelectPaymentMode("CASH");
		GenericMethods.fnwait(3);
		refPaymentDenominationWindow.clickSaveButton();
		GenericMethods.fnwait(1);
		refPaymentWindow.clickFinishButton();

		String labelMessage = refMessgBox.fnGetLabelMessage();
		GenericMethods.fnwait(1);
		if (labelMessage.contains("INV/")) {
			fnWriteSteps("pass", "Exchange process is successful");
		} else {
			fnWriteSteps("Fail", "Exchange process is not successful");
		}
		refMessgBox.clickOkButton();
		GenericMethods.fnwait(1);

		GenericMethods.fnEndTestCase();
	}

	@AfterMethod
	public void fn_Close_InvoiceScreen_And_Logout() {

		refInvoiceScreen.clickDashboardButton();
		GenericMethods.fnwait(2);
		refDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		refMessgBox.ExitApplication_Yes();
		GenericMethods.fnwait(1);
		refLogin.ClickCloseButton();
	}

}
