package JBWindows_Transactions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.FRM.FRM_Payment;
import JBWindows.FRM.FRM_PaymentByCard;
import JBWindows.FRM.FRM_PaymentNotes;
import JBWindows.SAL.SAL_CollectDeliveryOrders;
import JBWindows.SAL.SAL_Delivery;
import JBWindows.SAL.SAL_SalesPersonDetails;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class DeliveryListPage_UnitTest extends BaseClass {

	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;
	MessageBoxEffia RefMessgBox;
	SAL_Delivery RefDeliveryWindow;
	SAL_SalesPersonDetails RefSalesPersonSelectionWindow;
	SAL_CollectDeliveryOrders RefCollectDeliveryOrders;
	FRM_Payment RefPaymentWindow;
	FRM_PaymentNotes RefPaymentDenominationWindow;
	FRM_PaymentByCard RefPaymentByCard;

	public DeliveryListPage_UnitTest() {
		super();
	}


	@BeforeClass
	public void fnBeforeClass() throws InterruptedException {

		RefLogin = new Login(driver);
		RefDashboard = new APP_Dashboard(driver);
		RefMenu = new APP_Menu(driver);
		RefMessgBox = new MessageBoxEffia(driver);
		RefDeliveryWindow = new SAL_Delivery();
		RefSalesPersonSelectionWindow = new SAL_SalesPersonDetails();
		RefCollectDeliveryOrders = new SAL_CollectDeliveryOrders();
		RefPaymentWindow = new FRM_Payment();
		RefPaymentDenominationWindow = new FRM_PaymentNotes();
		RefPaymentByCard = new FRM_PaymentByCard();
	}

	@BeforeMethod
	public void fn_Login_and_Open_Page() {

		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		RefLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(3);

		RefDashboard.clickMenuBtn();
		GenericMethods.fnwait(1);
		RefMenu.OpenPage("delivery list");
		GenericMethods.fnwait(1);
	}

	@Test
	public void fnVerifySingleOrMultipleDeliveryDispatchProcess() {
		GenericMethods.fnStartTestCase("Verify dispatch process for single or multiple Delivery order");

		RefDeliveryWindow.searchAndSelectMultipleRecordForDispatch(10,11);
		RefSalesPersonSelectionWindow.selectAgent(1);
		GenericMethods.fnwait(2); 

		GenericMethods.fnEndTestCase();

	}

	@Test
	public void fnVerifyCollectPaymentProcessWithMultiplePaymentModes() {
		GenericMethods.fnStartTestCase("Verify collect payment process for dispatched Delivery order with multiple payment mode");

		RefDeliveryWindow.clickCollectDeliveryButton();
		RefCollectDeliveryOrders.selectFirstPaymentIcon();
		GenericMethods.fnwait(1);	
		
		String Amount = RefPaymentWindow.getReceivableAmount();
		if (Amount.equals("0.00")) {
			
			RefPaymentWindow.SelectPaymentMode("CASH");
			RefMessgBox.ClickOkButton();
			GenericMethods.fnwait(1);
			RefPaymentWindow.clickFinishButton();
			String labelMessage = RefMessgBox.fnGetLabelMessage();
			if (labelMessage.contains("INV/")) {
				fnWriteSteps("pass", "Payment of Delivered order has been completed successfully");
			} else {
				fnWriteSteps("Fail", "Payment of Delivered order has not been completed");
			}

			RefMessgBox.ClickOkButton();
			GenericMethods.fnwait(1);
			RefMessgBox.ClickOkButton();
		} else 
		{
			RefPaymentWindow.SelectPaymentMode("CASH");
			GenericMethods.fnwait(1);
			RefPaymentDenominationWindow.selectCurrency("10");
			GenericMethods.fnwait(1);
			RefPaymentDenominationWindow.clickSaveButton();
			GenericMethods.fnwait(1);
			RefPaymentWindow.SelectPaymentMode("CARD");
			RefPaymentByCard.collectFullPaymentByCard();
			RefPaymentWindow.clickFinishButton();
			GenericMethods.fnwait(1);
			String labelMessagetwo = RefMessgBox.fnGetLabelMessage();
			if (labelMessagetwo.contains("Payment")) {
				fnWriteSteps("pass", "Payment of Delivered order has been completed with multiple payment mode");
			} else {
				fnWriteSteps("Fail", "Payment of Delivered order has not been completed");
			}
			
			GenericMethods.fnwait(1);
			RefMessgBox.ClickOkButton();
			GenericMethods.fnwait(1);
			RefMessgBox.ClickOkButton();
		}
		
		RefCollectDeliveryOrders.clickCloseButton();
		GenericMethods.fnwait(1);

		GenericMethods.fnEndTestCase();

	}
	
	@Test
	public void fnVerifyCollectPaymentProcess() {
		GenericMethods.fnStartTestCase("Verify collect payment process for dispatched Delivery order with Cash payment mode");

		RefDeliveryWindow.clickCollectDeliveryButton();
		RefCollectDeliveryOrders.selectFirstPaymentIcon();
		GenericMethods.fnwait(1);	
		
		String Amount = RefPaymentWindow.getReceivableAmount();
		if (Amount.equals("0.00")) {
			
			RefPaymentWindow.SelectPaymentMode("CASH");
			RefMessgBox.ClickOkButton();
			GenericMethods.fnwait(1);
			RefPaymentWindow.clickFinishButton();
			String labelMessage = RefMessgBox.fnGetLabelMessage();
			if (labelMessage.contains("INV/")) {
				fnWriteSteps("pass", "Payment of Delivered order has been completed successfully");
			} else {
				fnWriteSteps("Fail", "Payment of Delivered order has not been completed");
			}

			RefMessgBox.ClickOkButton();
			GenericMethods.fnwait(1);
			RefMessgBox.ClickOkButton();
		} else 
		{
			RefPaymentWindow.SelectPaymentMode("CASH");
			RefPaymentDenominationWindow.clickSaveButton();
			GenericMethods.fnwait(1);
			RefPaymentWindow.clickFinishButton();
			GenericMethods.fnwait(1);
			String labelMessagetwo = RefMessgBox.fnGetLabelMessage();
			if (labelMessagetwo.contains("Payment")) {
				fnWriteSteps("pass", "Payment of Delivered order has been completed successfully with Cash payment mode");
			} else {
				fnWriteSteps("Fail", "Payment of Delivered order has not been completed");
			}
			
			GenericMethods.fnwait(1);
			RefMessgBox.ClickOkButton();
			GenericMethods.fnwait(1);
			RefMessgBox.ClickOkButton();
		}
		
		RefCollectDeliveryOrders.clickCloseButton();
		GenericMethods.fnwait(1);

		GenericMethods.fnEndTestCase();

	}

	@AfterMethod
	public void fn_Close_InvoiceScreen_And_Logout() {

		RefDeliveryWindow.clickCloseButton();
		GenericMethods.fnwait(1);
		RefDashboard.logoutwithoutmenu();
		RefMessgBox.ExitApplication_Yes();
		GenericMethods.fnwait(1);
	}

	@AfterClass
	public void fnAfterClass() {

		GenericMethods.fnwait(2);
		RefLogin.ClickCloseButton();
	}

}
