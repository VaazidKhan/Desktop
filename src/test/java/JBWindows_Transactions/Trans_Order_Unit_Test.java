package JBWindows_Transactions;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.SAL.SAL_DocumentHistory;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import JBWindows.Transactions.Trans_Order_Page;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;



public class Trans_Order_Unit_Test extends BaseClass {
    Logger log = Logger.getLogger(Trans_Order_Unit_Test.class);

	Login RefLogin;
	APP_Dashboard RefDashboard;
	APP_Menu RefMenu;
	MessageBoxEffia RefMessgBox;
	SAL_DocumentHistory RefEstimationHistory;
	Trans_Order_Page refOrderPage;

	public Trans_Order_Unit_Test() {
		super();
	}


	@BeforeClass
	public void initializingWindows() {
		DOMConfigurator.configure("log4j.xml");
		RefLogin = new Login(driver);
		RefDashboard = new APP_Dashboard(driver);
		RefMenu = new APP_Menu(driver);
		RefMessgBox = new MessageBoxEffia(driver);
		RefEstimationHistory = new SAL_DocumentHistory();
		refOrderPage = new Trans_Order_Page();
	}

	@AfterClass
	public void terminatingBrowser() {
		GenericMethods.fnwait(5);
		RefLogin.ClickCloseButton();
	}

	@BeforeMethod
	public void setUp() {
		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		RefLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(5);
		RefDashboard.clickMenuBtn();
		RefMenu.OpenPage("order");

	}

	@AfterMethod
	public void tearDown() {
		refOrderPage.click_On_DashBoard();
		GenericMethods.fnwait(2);
		RefDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		RefMessgBox.ExitApplication_Yes();
		GenericMethods.fnwait(1);
		}

	@Test 
	public void validate_Sales_Order_Creation_Without_Customer() {
		GenericMethods.fnStartTestCase("validate_Sales_Order_Creation_Without_Customer");
		log.info("*******Sales Order Creatio Without Customer******");
		int rowindex=2;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Order", rowindex, 0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 1);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 2);
		String strCustType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 3);
		String strFirstName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 4);
		String strPhoneNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 5);
		String Date = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 6);
		String strDate = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 7);
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Order", rowindex, 8);
		String salesOrderVochure = refOrderPage.sales_Order_Creation_page(strSalesOrderType, strProduct, Customer,
				strCustType, strFirstName, strPhoneNo, Date, strDate, strInstructions);
		boolean result = refOrderPage.validate_Sales_Order_Creation(salesOrderVochure);
	Assert.assertTrue(result);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,9,salesOrderVochure);
	log.info("**********Sales Order Is Successfully Created*******");
	fnWriteSteps("Pass","Sales Order Is Successfully Created Without Customer");
	GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void validate_Sales_Order_Creation_Without_Cust_For_Sales_Invoice_Test() {
		GenericMethods.fnStartTestCase("validate_Sales_Order_Creation_Without_Cust_For_Sales_Invoice_Test");
		log.info("*******Sales Order Creatio Without Customer******");
		int rowindex=9;
		String strSalesOrderType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Order", rowindex, 0);
		String strProduct = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 1);
		String Customer = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 2);
		String strCustType = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 3);
		String strFirstName = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 4);
		String strPhoneNo = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 5);
		String Date = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 6);
		String strDate = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH, "Sales Order",
				rowindex, 7);
		String strInstructions = ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,
				"Sales Order", rowindex, 8);
		String salesOrderVochure = refOrderPage.sales_Order_Creation_page(strSalesOrderType, strProduct, Customer,
				strCustType, strFirstName, strPhoneNo, Date, strDate, strInstructions);
		boolean result = refOrderPage.validate_Sales_Order_Creation(salesOrderVochure);
	Assert.assertTrue(result);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,9,salesOrderVochure);
	log.info("**********Sales Order Is Successfully Created*******");
	fnWriteSteps("Pass","Sales Order Is Successfully Created Without Customer");
	GenericMethods.fnEndTestCase();
	}

  @Test 
  public void validate_Sales_Order_Creation_Existing_B2C_Cust_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Creation_Existing_B2C_Cust_Test");
	log.info("*******Sales Order Creatio Existing B2C Customer******");
	int rowindex=3;
String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,0);
String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
String Customer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,2);
String strCustType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3);
String strFirstName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,4);
String strPhoneNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,5);
String Date=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,6);
String strDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,7);
String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,8);
String salesOrderVochure=refOrderPage.sales_Order_Creation_page(strSalesOrderType, strProduct, Customer, strCustType, strFirstName,
		strPhoneNo, Date, strDate, strInstructions);
boolean result=refOrderPage.validate_Sales_Order_Creation(salesOrderVochure);
Assert.assertTrue(result);
ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,9,salesOrderVochure);
log.info("**********Sales Order Is Successfully Created*******");
fnWriteSteps("Pass","Sales Order Is Successfully Created Existing B2C Customer");
GenericMethods.fnEndTestCase();
}
 @Test 
 public void validate_Sales_Order_Creation_For_Invoice_Existing_B2C_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Creation_For_Invoice_Existing_B2C_Test");
	log.info("*******Sales Order Creatio Existing B2C Customer******");
	int rowindex=10;
String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,0);
String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
String Customer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,2);
String strCustType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3);
String strFirstName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,4);
String strPhoneNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,5);
String Date=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,6);
String strDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,7);
String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,8);
String salesOrderVochure=refOrderPage.sales_Order_Creation_page(strSalesOrderType, strProduct, Customer, strCustType, strFirstName,
		strPhoneNo, Date, strDate, strInstructions);
boolean result=refOrderPage.validate_Sales_Order_Creation(salesOrderVochure);
Assert.assertTrue(result);
ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,9,salesOrderVochure);
log.info("**********Sales Order Is Successfully Created*******");
fnWriteSteps("Pass","Sales Order Is Successfully Created Existing B2C Customer");
GenericMethods.fnEndTestCase();
}

 @Test 
 public void validate_Sales_Order_Creation_Existing_B2B_Cust_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Creation_Existing_B2B_Cust_Test");
	log.info("*******Sales Order Creatio Existing B2B Customer******");
	int rowindex=4;
String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,0);
String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
String Customer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,2);
String strCustType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3);
String strFirstName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,4);
String strPhoneNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,5);
String Date=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,6);
String strDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,7);
String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,8);
String salesOrderVochure=refOrderPage.sales_Order_Creation_page(strSalesOrderType, strProduct, Customer, strCustType, strFirstName,
		strPhoneNo, Date, strDate, strInstructions);
boolean result=refOrderPage.validate_Sales_Order_Creation(salesOrderVochure);
Assert.assertTrue(result);
ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,9,salesOrderVochure);
log.info("**********Sales Order Is Successfully Created*******");
fnWriteSteps("Pass","Sales Order Is Successfully Created Existing B2B Customer");
GenericMethods.fnEndTestCase();
	
}
 @Test 
 public void validate_Sales_Order_Creation_For_Invoice_Existing_B2B_Cust_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Creation_For_Invoice_Existing_B2B_Cust_Test");
	log.info("*******Sales Order Creatio Existing B2B Customer******");
	int rowindex=11;
String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,0);
String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
String Customer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,2);
String strCustType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3);
String strFirstName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,4);
String strPhoneNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,5);
String Date=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,6);
String strDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,7);
String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,8);
String salesOrderVochure=refOrderPage.sales_Order_Creation_page(strSalesOrderType, strProduct, Customer, strCustType, strFirstName,
		strPhoneNo, Date, strDate, strInstructions);
boolean result=refOrderPage.validate_Sales_Order_Creation(salesOrderVochure);
Assert.assertTrue(result);
ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,9,salesOrderVochure);
log.info("**********Sales Order Is Successfully Created*******");
fnWriteSteps("Pass","Sales Order Is Successfully Created Existing B2B Customer");
GenericMethods.fnEndTestCase();
}
 @Test 
 public void validate_Sales_Order_Creation_running_B2C_Cust_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Creation_Running_B2C_Cust_Test");
	log.info("*******Sales Order Creatio Running B2C Customer******");
	int rowindex=5;
String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,0);
String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
String Customer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,2);
String strCustType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3);
String strFirstName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,4);
String strPhoneNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,5);
String Date=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,6);
String strDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,7);
String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,8);
String salesOrderVochure=refOrderPage.sales_Order_Creation_page(strSalesOrderType, strProduct, Customer, strCustType, strFirstName,
		strPhoneNo, Date, strDate, strInstructions);
boolean result=refOrderPage.validate_Sales_Order_Creation(salesOrderVochure);
Assert.assertTrue(result);
ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,9,salesOrderVochure);
log.info("**********Sales Order Is Successfully Created*******");
fnWriteSteps("Pass","Sales Order Is Successfully Created Running B2C Customer");
GenericMethods.fnEndTestCase();
	
}
 @Test 
 public void validate_Sales_Order_Creation_For_Invoice_Running_B2C_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Creation_For_Invoice_Running_B2C_Test");
	log.info("*******Sales Order Creatio Running B2C Customer******");
	int rowindex=12;
String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,0);
String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
String Customer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,2);
String strCustType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3);
String strFirstName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,4);
String strPhoneNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,5);
String Date=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,6);
String strDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,7);
String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,8);
String salesOrderVochure=refOrderPage.sales_Order_Creation_page(strSalesOrderType, strProduct, Customer, strCustType, strFirstName,
		strPhoneNo, Date, strDate, strInstructions);
boolean result=refOrderPage.validate_Sales_Order_Creation(salesOrderVochure);
Assert.assertTrue(result);
ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,9,salesOrderVochure);
log.info("**********Sales Order Is Successfully Created*******");
fnWriteSteps("Pass","Sales Order Is Successfully Created Running B2C Customer");
GenericMethods.fnEndTestCase();
}
 @Test 
 public void validate_Sales_Order_Creation_running_B2B_Cust_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Creation_Running_B2B_Cust_Test");
	log.info("*******Sales Order Creatio Running B2B Customer******");
	int rowindex=6;
String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,0);
String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
String Customer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,2);
String strCustType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3);
String strFirstName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,4);
String strPhoneNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,5);
String Date=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,6);
String strDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,7);
String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,8);
String salesOrderVochure=refOrderPage.sales_Order_Creation_page(strSalesOrderType, strProduct, Customer, strCustType, strFirstName,
		strPhoneNo, Date, strDate, strInstructions);
boolean result=refOrderPage.validate_Sales_Order_Creation(salesOrderVochure);
Assert.assertTrue(result);
ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,9,salesOrderVochure);
log.info("**********Sales Order Is Successfully Created*******");
fnWriteSteps("Pass","Sales Order Is Successfully Created Running B2B Customer");
GenericMethods.fnEndTestCase();
}
 @Test 
 public void validate_Sales_Order_Creation_For_Invoice_Running_B2B_Cust_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Creation_Running_B2B_Cust_Test");
	log.info("*******Sales Order Creatio Running B2B Customer******");
	int rowindex=13;
String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,0);
String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
String Customer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,2);
String strCustType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3);
String strFirstName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,4);
String strPhoneNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,5);
String Date=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,6);
String strDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,7);
String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,8);
String salesOrderVochure=refOrderPage.sales_Order_Creation_page(strSalesOrderType, strProduct, Customer, strCustType, strFirstName,
		strPhoneNo, Date, strDate, strInstructions);
boolean result=refOrderPage.validate_Sales_Order_Creation(salesOrderVochure);
Assert.assertTrue(result);
ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,9,salesOrderVochure);
log.info("**********Sales Order Is Successfully Created*******");
fnWriteSteps("Pass","Sales Order Is Successfully Created Running B2B Customer");
GenericMethods.fnEndTestCase();
}

 @SuppressWarnings("unused")
@Test 
 public void validate_Sales_Order_HomeDelivery_From_Dashboard() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_HomeDelivery_From_Dashboard");
	log.info("********Sales Order Creation From DashBoard for Home Delivery***********");
	refOrderPage.click_On_DashBoard();
	RefDashboard.ClickOrderPageButton();
	int rowindex=14;
	boolean result=false;
	String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,0);
	String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
	String Customer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,2);
	String strCustType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3);
	String strFirstName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,4);
	String strPhoneNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,5);
	String Date=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,6);
	String strDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,7);
	String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,8);
	String strDoorNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,10);
	String strStreetName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,11);
	String strArea=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,12);
	String strZipcode=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,13);
	String orderVoucher=refOrderPage.sales_Order_Creation_HomeDelivery_Page(strSalesOrderType, strProduct, Customer, strCustType, strFirstName, strPhoneNo, strDoorNo, strStreetName, strArea, strZipcode);
	if(!orderVoucher.equals(null)&& !orderVoucher.equals("")) {
		result=true;
	}    
	Assert.assertTrue(result);
    ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,9,orderVoucher);
	log.info("*****Sales Order Is Successfully Created********");
	fnWriteSteps("Pass","Sales Order is successfully Creatded");
	GenericMethods.fnEndTestCase();
	
}
 @SuppressWarnings("unused")
@Test 
 public void validate_Sales_Order_HomeDelivery_From_Dashboard_for_Without_Internet() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_HomeDelivery_From_Dashboard_for_Without_Internet");
	log.info("********Sales Order Creation From DashBoard for Home Delivery***********");
	refOrderPage.click_On_DashBoard();
	RefDashboard.ClickOrderPageButton();
	int rowindex=7;
	boolean result=false;
	String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,0);
	String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
	String Customer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,2);
	String strCustType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3);
	String strFirstName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,4);
	String strPhoneNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,5);
	String Date=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,6);
	String strDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,7);
	String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,8);
	String strDoorNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,10);
	String strStreetName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,11);
	String strArea=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,12);
	String strZipcode=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,13);
	String orderVoucher=refOrderPage.sales_Order_Creation_HomeDelivery_Page(strSalesOrderType, strProduct, Customer, strCustType, strFirstName, strPhoneNo, strDoorNo, strStreetName, strArea, strZipcode);
	if(!orderVoucher.equals(null)  &&  !orderVoucher.equals("")) {
		result=true;
	}    
	Assert.assertTrue(result);
	log.info("*****Sales Order Is Successfully Created********");
	fnWriteSteps("Pass","Sales Order is successfully Creatded");
	GenericMethods.fnEndTestCase();
	
}

 @Test 
 public void validate_Sales_Order_Creation_FutureDate() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Creation_FutureDate");
	log.info("*******Sales Order Creation with Future Date******");
	int rowindex=8;
     String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,0);
     String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
     String Customer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,2);
     String strCustType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3);
     String strFirstName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,4);
     String strPhoneNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,5);
     String Date=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,6);
     String strDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,7);
     String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,8);
     String salesOrderVochure=refOrderPage.sales_Order_Creation_page(strSalesOrderType, strProduct, Customer, strCustType, strFirstName,
		strPhoneNo, Date, strDate, strInstructions);
   boolean result=refOrderPage.validate_Sales_Order_Creation(salesOrderVochure);
   Assert.assertTrue(result);
   ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,9,salesOrderVochure);
   log.info("**********Sales Order Is Successfully Created*******");
   fnWriteSteps("Pass","Sales Order Is Successfully Created Future Date");
   GenericMethods.fnEndTestCase();
 }
  @Test 
  public void validate_Sales_Order_Creation_PastDate() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Creation_PastDate");
	log.info("*******Sales Order Creation with Past Date******");
	int rowindex=15;
    String strSalesOrderType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,0);
    String strProduct=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
    String Customer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,2);
    String strCustType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3);
    String strFirstName=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,4);
    String strPhoneNo=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,5);
    String Date=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,6);
    String strDate=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,7);
    String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,8);
    String salesOrderVochure=refOrderPage.sales_Order_Creation_page(strSalesOrderType, strProduct, Customer, strCustType, strFirstName,
		strPhoneNo, Date, strDate, strInstructions);
    boolean result=refOrderPage.validate_Sales_Order_Creation(salesOrderVochure);
    Assert.assertTrue(result);
    ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,9,salesOrderVochure);
    log.info("**********Sales Order Is Successfully Created*******");
    fnWriteSteps("Pass","Sales Order Is Successfully Created Past Date");
    GenericMethods.fnEndTestCase();
}


 @Test 
 public void validate_Sales_Order_Modification_Increasing_Quantity() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Modification_Increasing_Quantity");
	log.info("validate sales Order Modification by Increasing Quantity");
	int rowindex=18;
	String strSalesOrder=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",4 ,9);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
	String strFieldValue=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,2);
	String PageType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3);
	String Invoice="NULL";
	String  amount =refOrderPage.sales_Order_Modification_Page(strSalesOrder,PageType, field, strFieldValue,Invoice);
    boolean result=refOrderPage.validate_Sales_Order_Modification(amount);
	Assert.assertTrue(result);
	log.info("validated sales Order Modification");
	fnWriteSteps("Pass", "Successfully Modified by Increasing Qunatity");
	GenericMethods.fnEndTestCase();
}
 @Test 
 public void validate_Sales_Order_Modification_Decreasing_Quantity() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Modification_Decreasing_Quantity");
	log.info("validate sales Order Modification by Increasing Quantity");
	int rowindex=19;
	String strSalesOrder=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",4 ,9);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
	String strFieldValue=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,2);
	String PageType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3);
	String Invoice="NULL";
	String  amount=refOrderPage.sales_Order_Modification_Page(strSalesOrder,PageType, field, strFieldValue,Invoice);
	boolean result=refOrderPage.validate_Sales_Order_Modification(amount);
	Assert.assertTrue(result);
	log.info("validated sales Order Modification");
	fnWriteSteps("Pass", "Successfully Modified by DEcrreasingeQunatity");
	GenericMethods.fnEndTestCase();
}
 @Test 
 public void validate_Sales_Order_Modification_Adding_Product_Recall_Window() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Modification_Adding_Product_Recall_Window");
	log.info("validate sales Order Modification by Adding product");
	int rowindex=20;
	String strSalesOrder=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",4 ,9);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
	String strFieldValue=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,2);
	String PageType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3);
	String Invoice=null;
	String  amount=refOrderPage.sales_Order_Modification_Page(strSalesOrder,PageType, field, strFieldValue,Invoice);
	boolean result=refOrderPage.validate_Sales_Order_Modification(amount);	Assert.assertTrue(result);
	log.info("validated sales Order Modification");
	fnWriteSteps("Pass", "Successfully Modified by Adding Product");
	GenericMethods.fnEndTestCase();
}
 @Test 
 public void validate_Sales_Order_Modification_Deleting_Product_Recall_Window() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Modification_Deleting_Product_Recall_Window");
	log.info("validate sales Order Modification by Deleting product");
	int rowindex=21;
	String strSalesOrder=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",4 ,9);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
	String strFieldValue=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,2);
	String PageType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3);
	String Invoice=null;
	String  amount=refOrderPage.sales_Order_Modification_Page(strSalesOrder,PageType, field, strFieldValue,Invoice);
	boolean result=refOrderPage.validate_Sales_Order_Modification(amount);	Assert.assertTrue(result);
	log.info("validated sales Order Modification");
	fnWriteSteps("Pass", "Successfully Modified by Deleting Product");
	GenericMethods.fnEndTestCase();
}
 @Test 
 public void validate_Sales_Order_Modification_Increasing_Product_Order_History() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Modification_Increasing_Product_Order_History");
	log.info("validate sales Order Modification by Increasing Quantity from Order History");
	int rowindex=22;
	String strSalesOrder=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",4 ,9);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
	String strFieldValue=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,2);
	String PageType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3);
	refOrderPage.click_On_DashBoard();
	RefMenu.OpenPage("order history ");
	RefEstimationHistory.verifyEditFeature(strSalesOrder);
	String Invoice="NULL";
	String  amount=refOrderPage.sales_Order_Modification_Page(strSalesOrder,PageType, field, strFieldValue,Invoice);
	boolean result=refOrderPage.validate_Sales_Order_Modification(amount);	GenericMethods.fnwait(3);
	refOrderPage.click_On_DashBoard();
    driver.findElement(By.id("lblCaption")).click();
	RefEstimationHistory.clickCloseButton();
	RefMenu.OpenPage("order");
	Assert.assertTrue(result);
	log.info("validated sales Order Modification");
	fnWriteSteps("Pass", "Successfully Modified by Increasing Qunatity");
	GenericMethods.fnEndTestCase();
}
 @Test 
 public void validate_Sales_Order_Modification_Decreasing_Quantity_Order_History() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Modification_Decreasing_Quantity_Order_History");
	log.info("validate sales Order Modification by Decreasing Quantity from Order History");
	int rowindex=23;
	String strSalesOrder=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",4 ,9);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
	String strFieldValue=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,2);
	String PageType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3);
	refOrderPage.click_On_DashBoard();
	RefMenu.OpenPage("order history ");
	RefEstimationHistory.verifyEditFeature(strSalesOrder);
	String Invoice="NULL";
	String  amount=refOrderPage.sales_Order_Modification_Page(strSalesOrder,PageType, field, strFieldValue,Invoice);
	boolean result=refOrderPage.validate_Sales_Order_Modification(amount);	GenericMethods.fnwait(3);
	refOrderPage.click_On_DashBoard();
    driver.findElement(By.id("lblCaption")).click();
	RefEstimationHistory.clickCloseButton();
	RefMenu.OpenPage("order");
	Assert.assertTrue(result);
	log.info("validated sales Order Modification");
	fnWriteSteps("Pass", "Successfully Modified by Decreasing Qunatity");
	GenericMethods.fnEndTestCase();
}
 @Test 
 public void validate_Sales_Order_Modification_Adding_Product_Order_History() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Modification_Adding_Product_Order_History");
	log.info("validate sales Order Modification by Adding_Product from Order History");
	int rowindex=24;
	String strSalesOrder=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",4 ,9);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
	String strFieldValue=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,2);
	String PageType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3);
	refOrderPage.click_On_DashBoard();
	RefMenu.OpenPage("order history ");
	RefEstimationHistory.verifyEditFeature(strSalesOrder);
    String Invoice="NULL";
	String  amount=refOrderPage.sales_Order_Modification_Page(strSalesOrder,PageType, field, strFieldValue,Invoice);
	boolean result=refOrderPage.validate_Sales_Order_Modification(amount);	GenericMethods.fnwait(3);
	refOrderPage.click_On_DashBoard();
    driver.findElement(By.id("lblCaption")).click();
	RefEstimationHistory.clickCloseButton();
	RefMenu.OpenPage("order");
	Assert.assertTrue(result);
	log.info("validated sales Order Modification");
	fnWriteSteps("Pass", "Successfully Modified by Adding product");
	GenericMethods.fnEndTestCase();
}
 @Test 
 public void validate_Sales_Order_Modification_Deleting_Product_Order_History() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Modification_Adding_Product_Order_History");
	log.info("validate sales Order Modification by Adding_Product from Order History");
	int rowindex=25;
	String strSalesOrder=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",4 ,9);
	String field=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
	String strFieldValue=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,2);
	String PageType=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,3);
	refOrderPage.click_On_DashBoard();
	RefMenu.OpenPage("order history ");
	RefEstimationHistory.verifyEditFeature(strSalesOrder);
	String Invoice="NULL";
	String  amount=refOrderPage.sales_Order_Modification_Page(strSalesOrder,PageType,field, strFieldValue,Invoice);
	boolean result=refOrderPage.validate_Sales_Order_Modification(amount);	GenericMethods.fnwait(3);
	refOrderPage.click_On_DashBoard();
	driver.findElement(By.id("lblCaption")).click();
	RefEstimationHistory.clickCloseButton();
	RefMenu.OpenPage("order");
	Assert.assertTrue(result);
	log.info("validated sales Order Modification");
	fnWriteSteps("Pass", "Successfully Modified by Adding product");
	GenericMethods.fnEndTestCase();
}
 @Test 
 public void validate_Sales_Order_To_Sales_Invoice_Existing_B2B_Cust_Conversion_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_To_Sales_Invoice_Conversion_Test");
	log.info("********Sales Order To Sales Invoice Conversion*******");
	String strSalesOrder=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",11 ,9);
	String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",34 ,1);
	String Customer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",34 ,3);
	String invoiceVochure=refOrderPage.sales_Order_To_Sales_Invoice_Conversion(strSalesOrder,Customer, strInstructions);
	System.out.println(invoiceVochure);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",35 ,2, invoiceVochure);
	boolean result=refOrderPage.validation_Sales_Order_Converted_To_Sales_Invoice_From_Recall_Window(strSalesOrder);
	Assert.assertTrue(result);
	log.info("Sales Order Is Converted To Sales Invoice");
	fnWriteSteps("Pass","Sales Order is Converted Sales Invoice");
	GenericMethods.fnEndTestCase();
}

 @Test 
 public void validate_Sales_Order_Convererd_To_Sales_Invoice_Modification_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Convererd_To_Sales_Invoice_Modification_Test");
	log.info("Validate Sales Order Converted To Sales Invoice Modification");
	String strStatus="Completed";
	String strVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",10,9);
	refOrderPage.click_On_DashBoard();
	RefMenu.OpenPage("order history ");
	boolean result=RefEstimationHistory.validate_Sales_Order_Converted_Sales_Invoice_Modifification(strStatus, strVochure);
	RefEstimationHistory.clickCloseButton();
	RefMenu.OpenPage("order");
	Assert.assertTrue(result);
	log.info("Modification Of Sales Order Converted To Sales Invoice Is Successfully Validated");
	fnWriteSteps("Pass","Successfully validated Modification Of Sales Order Converted To Sales Invoice");
	GenericMethods.fnEndTestCase();
}
/*@Test
public void Validate_Sales_Order_To_Sales_Invoice_conversion() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_To_Sales_Invoice_Conversion_Test");
	log.info("********Sales Order To Sales Invoice Conversion*******");
	String strSalesOrder=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",34 ,0);
	String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",34 ,1);
	String invoiceVochure=refOrderPage.sales_Order_To_Sales_Invoice_Conversion(strSalesOrder, strInstructions);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",34 ,2, invoiceVochure);
	boolean result=refOrderPage.validation_Sales_Order_Converted_To_Sales_Invoice_From_Recall_Window(strSalesOrder);
	Assert.assertTrue(result);
	log.info("Sales Order Is Converted To Sales Invoice");
	fnWriteSteps("Pass","Sales Order is Converted Sales Invoice");
	GenericMethods.fnEndTestCase();
}*/

 @Test 
 public void validate_Sales_Order_Conversion_Sales_invoice_Existing_B2C_From_OrderHistory_Page() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Conversion_Sales_invoice_From_OrderHistory_Page");
	log.info("Validate Sales Order Conversion In To Sales invoice From Sales Order History ");
	refOrderPage.click_On_DashBoard();
	RefMenu.OpenPage("order history");
	int rowindex=35;
	String salesOrderVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",10 ,9);
	String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
	String Salesinvoice=RefEstimationHistory.validate_Sales_Order_To_Sales_Invoice_From_History_Page(salesOrderVochure, strInstructions);
	RefEstimationHistory.clickCloseButton();
	RefMenu.OpenPage("order");
	boolean result=refOrderPage.validation_Sales_Order_Converted_To_Sales_Invoice_From_Recall_Window(salesOrderVochure);
	Assert.assertTrue(result);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,2, Salesinvoice);
	log.info("Successfully created and validated sales Order to Sales Invoice");
	fnWriteSteps("Pass", "Sales Ordre Is Converted To Sales Invoice From Order History Page");
	GenericMethods.fnEndTestCase();

	}
 @Test 
 public void validate_Sales_Order_Conversion_Sales_Invoice_Running_B2B_Cust() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Conversion_Sales_Invoice_Running_B2C_Cust");
	log.info("Validate Sales Order Converted To Sales Invoice For Running B2C Cust");
	int rowindex=36;
	String strSalesOrder=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",12 ,9);
	//String Customer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",35 ,3);
	String Customer="With Customer";
	String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
	String invoiceVochure=refOrderPage.sales_Order_To_Sales_Invoice_Conversion(strSalesOrder, Customer, strInstructions);
	boolean result=refOrderPage.validation_Sales_Order_Converted_To_Sales_Invoice_From_Recall_Window(strSalesOrder);
	Assert.assertTrue(result);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,2, invoiceVochure);
	log.info("Successfully converted sales ordre to sales invoice");
	GenericMethods.fnEndTestCase();	
	
}
 @Test 
 public void validate_Sales_Order_Conversion_Sales_Invoice_Running_B2C_Cust() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Conversion_Sales_Invoice_Running_B2C_Cust");
	log.info("Validate Sales Order Converted To Sales Invoice For Running B2C Cust");
	int rowindex=37;
	String strSalesOrder=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",13 ,9);
	String Customer="With Customer";
	String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
	String invoiceVochure=refOrderPage.sales_Order_To_Sales_Invoice_Conversion(strSalesOrder, Customer, strInstructions);
	boolean result=refOrderPage.validation_Sales_Order_Converted_To_Sales_Invoice_From_Recall_Window(strSalesOrder);
	Assert.assertTrue(result);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,2, invoiceVochure);
	log.info("Successfully converted sales ordre to sales invoice");
	GenericMethods.fnEndTestCase();
}
/*@Test
public void validate_Sales_Order_Conversion_Sales_Invoice_Existing_B2C_Cust_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Conversion_Sales_Invoice_Existing_B2C_Cust");
	log.info("Validate Sales Order Converted To Sales Invoice For Existing B2C Cust");
	int rowindex=37;
	String strSalesOrder=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,0);
	//String Customer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
	String Customer="With Customer";
	String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
	String invoiceVochure=refOrderPage.sales_Order_To_Sales_Invoice_Conversion(strSalesOrder, Customer, strInstructions);
	boolean result=refOrderPage.validation_Sales_Order_Converted_To_Sales_Invoice_From_Recall_Window(strSalesOrder);
	Assert.assertTrue(result);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,2, invoiceVochure);
	log.info("Successfully converted sales ordre to sales invoice");
	GenericMethods.fnEndTestCase();
}*/
/*@Test
public void validate_Sales_Order_Conversion_Sales_Invoice_Existing_B2B_Cust_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Conversion_Sales_Invoice_Existing_B2B_Cust");
	log.info("Validate Sales Order Converted To Sales Invoice For Existing B2B Cust");
	int rowindex=38;
	String strSalesOrder=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,0);
	//String Customer=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
	String Customer="With Customer";
	String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
	String invoiceVochure=refOrderPage.sales_Order_To_Sales_Invoice_Conversion(strSalesOrder, Customer, strInstructions);
	boolean result=refOrderPage.validation_Sales_Order_Converted_To_Sales_Invoice_From_Recall_Window(strSalesOrder);
	Assert.assertTrue(result);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,2, invoiceVochure);
	log.info("Successfully converted sales ordre to sales invoice");
	GenericMethods.fnEndTestCase();
}*/
 @Test 
 public void validate_Sales_Order_Conversion_Sales_Invoice_Without_Cust() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Conversion_Sales_Invoice_Without_Cust");
	log.info("Validate Sales Order Converted To Sales Invoice Without Cust");
	int rowindex=38;
	String strSalesOrder=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",9 ,9);
	String Customer="Without Customer";
	String strInstructions=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
	String invoiceVochure=refOrderPage.sales_Order_To_Sales_Invoice_Conversion(strSalesOrder, Customer, strInstructions);
	boolean result=refOrderPage.validation_Sales_Order_Converted_To_Sales_Invoice_From_Recall_Window(strSalesOrder);
	Assert.assertTrue(result);
	ExcelUtils.fn_Set_Value(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,2, invoiceVochure);
	log.info("Successfully converted sales ordre to sales invoice");
	GenericMethods.fnEndTestCase();
}
 @Test 
 public void sales_Order_Deletion_HomeDelivery_From_OrderHistory_Page_WithoutInternet()  {
	GenericMethods.fnStartTestCase("sales_Order_Deletion_HomeDelivery_From_OrderHistory_Page");
	log.info("Sales Order Deletion Of Home Delivery From Order History Page");
	int rowindex=46;
	String strVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",7 ,9);
	String strRemarks=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
	String internet = "Without Internet";
	refOrderPage.click_On_DashBoard();
	RefMenu.OpenPage("order history ");
	boolean result=RefEstimationHistory.document_History_Deletion(strVochure, strRemarks,internet);
    RefMenu.OpenPage("order");
    Assert.assertTrue(result);
	log.info("Successfully deleted Sales Order for Home Dewlivery");
	fnWriteSteps("Pass", "Successfully deleted Sales Order of Home Delivery ");
	GenericMethods.fnEndTestCase();
	
}
 @Test 
 public void validate_SalesOrder_Deletion_B2C_Cust_Test() {
	GenericMethods.fnStartTestCase("validate_SalesOrder_Deletion_B2C_Cust_Test");
	log.info("Sales Order Deletion Of  B2C Customer");
	int rowindex=47;
	String strVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",3 ,9);
	String strRemarks=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
	String internet = "NULL";
	refOrderPage.click_On_DashBoard();
	RefMenu.OpenPage("order history ");
    RefEstimationHistory.document_History_Deletion(strVochure, strRemarks,internet);
    RefEstimationHistory.click_On_Close_Button();
	RefMenu.OpenPage("order");
	
	boolean result=refOrderPage.validation_Sales_Order_Converted_To_Sales_Invoice_From_Recall_Window(strVochure);
	Assert.assertTrue(result);
	log.info("Successfully deleted Sales Order for  B2C Customer");
	fnWriteSteps("Pass", "Successfully deleted Sales Order of B2C Customer ");
	GenericMethods.fnEndTestCase();
}
 @Test 
 public void validate_SalesOrder_Deletion_B2B_Cust_Test() {
	GenericMethods.fnStartTestCase("validate_SalesOrder_Deletion_B2B_Cust_Test");
	log.info("Sales Order Deletion Of  B2B Customer");
	int rowindex=48;
	String strVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",6 ,9);
	String strRemarks=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
	String internet = "NULL";
	refOrderPage.click_On_DashBoard();
	RefMenu.OpenPage("order history ");
    RefEstimationHistory.document_History_Deletion(strVochure, strRemarks,internet);
    RefEstimationHistory.click_On_Close_Button();
	RefMenu.OpenPage("order");
	boolean result=refOrderPage.validation_Sales_Order_Converted_To_Sales_Invoice_From_Recall_Window(strVochure);
	Assert.assertTrue(result);
	log.info("Successfully deleted Sales Order for  B2B Customer");
	fnWriteSteps("Pass", "Successfully deleted Sales Order of B2B Customer ");
	GenericMethods.fnEndTestCase();
}
 @Test 
 public void validate_SalesOrder_Deletion_Without_Cust_Test() {
	GenericMethods.fnStartTestCase("validate_SalesOrder_Deletion_Without_Cust_Test");
	log.info("Sales Order Deletion without Customer");
	int rowindex=49;
	String strVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",2 ,9);
	String strRemarks=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
	String internet = "NULL";
	refOrderPage.click_On_DashBoard();
	RefMenu.OpenPage("order history ");
    RefEstimationHistory.document_History_Deletion(strVochure, strRemarks,internet);
    RefEstimationHistory.click_On_Close_Button();
	RefMenu.OpenPage("order");
	boolean result=refOrderPage.validation_Sales_Order_Converted_To_Sales_Invoice_From_Recall_Window(strVochure);
	Assert.assertTrue(result);
	log.info("Successfully deleted Sales Order Without Customer");
	fnWriteSteps("Pass", "Successfully deleted Sales Order Without Customer ");
	GenericMethods.fnEndTestCase();
}
 @Test 
 public void validate_Sales_Order_Deletion_HomeDelivery_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Deletion_HomeDelivery_Test");
	log.info("Sales Order Deletion For home Delivery Customer");
	int rowindex=50;
	String strVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",14 ,9);
	String strRemarks=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
	String internet = "NULL";
	refOrderPage.click_On_DashBoard();
	RefMenu.OpenPage("order history ");
    RefEstimationHistory.document_History_Deletion(strVochure, strRemarks,internet);
    RefEstimationHistory.click_On_Close_Button();
	RefMenu.OpenPage("order");
	boolean result=refOrderPage.validation_Sales_Order_Converted_To_Sales_Invoice_From_Recall_Window(strVochure);
	Assert.assertTrue(result);
	log.info("Successfully deleted Sales Order For Home Delivery Custimer");
	fnWriteSteps("Pass", "Successfully deleted Sales Order For Home Delivery Customer ");
	GenericMethods.fnEndTestCase();
}
 @Test 
 public void validate_SalesOrder_Deletion_Converted_From_Estimation_Test() {
	GenericMethods.fnStartTestCase("validate_SalesOrder_Converted_From_Estimation_Test");
	log.info("Sales Order Deletion For Converted Sales Estimation");
	int rowindex=51;
	String strVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"EStimations",55,1);
	String strRemarks=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",rowindex ,1);
	String internet ="NULL";
	refOrderPage.click_On_DashBoard();
	RefMenu.OpenPage("order history ");
    RefEstimationHistory.document_History_Deletion(strVochure, strRemarks,internet);
    RefEstimationHistory.click_On_Close_Button();
	RefMenu.OpenPage("order");
	boolean result=refOrderPage.validation_Sales_Order_Converted_To_Sales_Invoice_From_Recall_Window(strVochure);
	Assert.assertTrue(result);
	log.info("Successfully deleted Sales Order Converted Sales estimation");
	fnWriteSteps("Pass", "Successfully deleted Sales Order For Estimation Converted");
	GenericMethods.fnEndTestCase();
}
 @Test 
 public void validate_Sales_Order_Deletion_Converted_To_Invoice_Test() {
	GenericMethods.fnStartTestCase("validate_Sales_Order_Deletion_Converted_To_Invoice_Test");
	log.info("Validate Sales Order Deletion For Order Converted To Sales invoice");
	String strStatus="Completed";
	String strVochure=ExcelUtils.fnGetExcelCellValue(ApplicationVariables.JBTRANSACTIONEXCELPATH,"Sales Order",11 ,9);
	refOrderPage.click_On_DashBoard();
	RefMenu.OpenPage("order history");
    boolean result=RefEstimationHistory.delete_Vochure_Converted_Page(strStatus, strVochure);
    Assert.assertTrue(result);
	RefMenu.OpenPage("order");
	log.info("Sales Order Converted To Sales Invoice Deletion Is Successfully Modified");
	fnWriteSteps("Pass","Successfully Validated Sales Order Converted To Sales Invoice Deletion");
	GenericMethods.fnEndTestCase();
	
}

}
