package JBWindows_Masters;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.PUR.PUR_Suppliers;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class SupplierPage_UnitTest extends BaseClass {

	Login refLogin;
	APP_Dashboard refDashboard;
	APP_Menu refMenu;
	PUR_Suppliers refSupplier;
	MessageBoxEffia refMessageBoxEffia;

	public SupplierPage_UnitTest() {
		super();
	}


	@BeforeMethod
	public void fnBeforeMethod() throws InterruptedException, IOException {	
		GenericMethods.fnStartTestCase("fn Login and Open Page");
		DOMConfigurator.configure("log4j.xml");
		
		refLogin = new Login(driver);
		refDashboard = new APP_Dashboard(driver);
		refMenu = new APP_Menu(driver);
		refSupplier = new PUR_Suppliers();
		refMessageBoxEffia = new MessageBoxEffia(driver);
		
		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		refLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(10);
		refDashboard.clickMenuBtn();
		GenericMethods.fnwait(2);
		refMenu.OpenPage("Suppliers");
		GenericMethods.fnwait(5);
		fnWriteSteps("Pass", "Application open Successfully");
		GenericMethods.fnEndTestCase();
	}
	
	@Test 
	public void fnVerifyFieldVisibility() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of Supplier add entry are present or not ");
		
		refSupplier.VerifyFieldVisibility();		

		GenericMethods.fnEndTestCase();
	}

	@Test 
	public void fnVerifyFieldEnableOrNot() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of Supplier add entry are enable or not");

		refSupplier.VerifyFieldEnableOrNot();
		
		  GenericMethods.fnEndTestCase(); 
	}
	@Test 
	public void fnActive_SupplierCreation() throws IOException, InterruptedException {
	GenericMethods.fnStartTestCase("Verify Active Supplier creation");	
	String StrExcelPath = ApplicationVariables.MasterExcelPath;
    String StrSheetName = "Supplier";
    int RowNumber = 1;
   
    String SupplierName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
    String PhNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
    String Email = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
    String DoorNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
    String StreetName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
    String Area = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
    String Address = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
    String State = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
    String City = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
    String Zipcode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
    String CreditDays = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
    String Vat = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
    String GST = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
    String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,15);
    refSupplier.createNewSupplier(SupplierName,PhNo,Email,DoorNo,StreetName,Area,Address,State,City,Zipcode,CreditDays,Vat,GST,Inactive);
    boolean result = refSupplier.Verify_SupplierCreation_Save_or_Not(PhNo);
    Assert.assertTrue(result);
    fnWriteSteps("Pass", "Active Supplier has been Created & Saved");
	GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnInActive_SupplierCreation() throws IOException, InterruptedException {
	GenericMethods.fnStartTestCase("Verify InActive Supplier creation");	
	String StrExcelPath = ApplicationVariables.MasterExcelPath;
    String StrSheetName = "Supplier";
    int RowNumber = 2;
   
    String SupplierName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
    String PhNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
    String Email = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
    String DoorNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
    String StreetName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
    String Area = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
    String Address = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
    String State = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
    String City = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
    String Zipcode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
    String CreditDays = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
    String Vat = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
    String GST = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
    String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,15);
    refSupplier.createNewSupplier(SupplierName,PhNo,Email,DoorNo,StreetName,Area,Address,State,City,Zipcode,CreditDays,Vat,GST,Inactive);
    boolean result = refSupplier.Verify_SupplierCreation_Save_or_Not(PhNo);
    Assert.assertTrue(result);
    fnWriteSteps("Pass", "InActive Supplier has been Created & Saved");
	GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnSupplierCreation_for_WithoutInternet() throws IOException, InterruptedException {
	GenericMethods.fnStartTestCase("Verify Supplier creation for withoutInternet");	
	String StrExcelPath = ApplicationVariables.MasterExcelPath;
    String StrSheetName = "Supplier";
    int RowNumber = 3;
   
    String SupplierName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
    String PhNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
    String Email = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
    String DoorNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
    String StreetName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
    String Area = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
    String Address = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
    String State = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
    String City = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
    String Zipcode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
    String CreditDays = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
    String Vat = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
    String GST = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
    String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,15);
    refSupplier.createNewSupplier(SupplierName,PhNo,Email,DoorNo,StreetName,Area,Address,State,City,Zipcode,CreditDays,Vat,GST,Inactive);
    boolean result = refSupplier.Verify_SupplierCreation_Save_or_Not(PhNo);
    Assert.assertTrue(result);
    fnWriteSteps("Pass", "Supplier has been Created & Saved");
	GenericMethods.fnEndTestCase();
	}

	@Test 
	public void fnSupplierCreation() throws IOException, InterruptedException {
	GenericMethods.fnStartTestCase("Verify Supplier creation");	
	String StrExcelPath = ApplicationVariables.MasterExcelPath;
    String StrSheetName = "Supplier";
    int RowNumber = 4;
   
    String SupplierName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
    String PhNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
    String Email = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
    String DoorNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
    String StreetName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
    String Area = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
    String Address = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
    String State = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
    String City = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
    String Zipcode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
    String CreditDays = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
    String Vat = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
    String GST = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
    String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,15);
    refSupplier.createNewSupplier(SupplierName,PhNo,Email,DoorNo,StreetName,Area,Address,State,City,Zipcode,CreditDays,Vat,GST,Inactive);
    boolean result = refSupplier.Verify_SupplierCreation_Save_or_Not(PhNo);
    Assert.assertTrue(result);
    fnWriteSteps("Pass", "Supplier has been Created & Saved");
	GenericMethods.fnEndTestCase();
	}
	
	@Test 
	public void VerifySupplierEdit() throws IOException, InterruptedException {
	GenericMethods.fnStartTestCase("Verify Supplier Edit");	
	String StrExcelPath = ApplicationVariables.MasterExcelPath;
    String StrSheetName = "Supplier";
    int RowNumber = 5;
   
    String OldSupplierPhNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,14);
    String SupplierName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
    String PhNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
    String Email = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
    String Address = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
    String State = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
    String City = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
    String PinCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
    String CreditDays = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
    String VATNO = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
    String GSTIN = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
    refSupplier.VerifySupplierEdit(OldSupplierPhNo,SupplierName,PhNo,Email,State,City,Address,PinCode, CreditDays, VATNO, GSTIN);
    boolean result = refSupplier.Verify_SupplierEdit_Save_or_Not(PhNo);
    Assert.assertTrue(result);
    fnWriteSteps("Pass", "Supplier has been Updated & Saved");
    GenericMethods.fnEndTestCase();
    
   }
	@Test 
	public void fnSupplierCreation_for_PurchaseInvoiceFeature_One() throws IOException, InterruptedException {
	GenericMethods.fnStartTestCase("Verify Supplier creation for Purchase Invoice Feature - One");	
	String StrExcelPath = ApplicationVariables.MasterExcelPath;
    String StrSheetName = "Supplier";
    int RowNumber = 6;
   
    String SupplierName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
    String PhNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
    String Email = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
    String DoorNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
    String StreetName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
    String Area = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
    String Address = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
    String State = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
    String City = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
    String Zipcode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
    String CreditDays = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
    String Vat = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
    String GST = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
    String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,15);
    refSupplier.createNewSupplier(SupplierName,PhNo,Email,DoorNo,StreetName,Area,Address,State,City,Zipcode,CreditDays,Vat,GST,Inactive);
    boolean result = refSupplier.Verify_SupplierCreation_Save_or_Not(PhNo);
    Assert.assertTrue(result);
    fnWriteSteps("Pass", "Supplier has been Created & Saved");
	GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnSupplierCreation_for_PurchaseInvoiceFeature_Two() throws IOException, InterruptedException {
	GenericMethods.fnStartTestCase("Verify Supplier creation for Purchase Invoice Feature - Two");	
	String StrExcelPath = ApplicationVariables.MasterExcelPath;
    String StrSheetName = "Supplier";
    int RowNumber = 7;
   
    String SupplierName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
    String PhNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
    String Email = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
    String DoorNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
    String StreetName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
    String Area = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
    String Address = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
    String State = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
    String City = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
    String Zipcode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
    String CreditDays = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
    String Vat = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
    String GST = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
    String Inactive = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,15);
    refSupplier.createNewSupplier(SupplierName,PhNo,Email,DoorNo,StreetName,Area,Address,State,City,Zipcode,CreditDays,Vat,GST,Inactive);
    boolean result = refSupplier.Verify_SupplierCreation_Save_or_Not(PhNo);
    Assert.assertTrue(result);
    fnWriteSteps("Pass", "Supplier has been Created & Saved");
	GenericMethods.fnEndTestCase();
	}
	
	@Test 
	public void fnDelete_Active_SupplierCreation() {
		GenericMethods.fnStartTestCase("Verify Delete Active Supplier Feature");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Supplier";
        int RowNumber = 1;
        String PhNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
        refSupplier.fnVerifySupplierDelete(PhNo);
        boolean result = refSupplier.Verify_SupplierDelete_SaveorNot(PhNo);
        Assert.assertTrue(result);
        fnWriteSteps("pass", "Active Supplier has been Deleted");
    	GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnDelete_InActive_SupplierCreation() {
		GenericMethods.fnStartTestCase("Verify Delete InActive Supplier Feature");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Supplier";
        int RowNumber = 2;
        String PhNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
        refSupplier.fnVerifySupplierDelete(PhNo);
        boolean result = refSupplier.Verify_SupplierDelete_SaveorNot(PhNo);
        Assert.assertTrue(result);
        fnWriteSteps("pass", "InActive Supplier has been Deleted");
    	GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnDelete_SupplierCreation() {
		GenericMethods.fnStartTestCase("Verify Delete Supplier Feature");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Supplier";
        int RowNumber = 5;
       String PhNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
       refSupplier.fnVerifySupplierDelete(PhNo);
       boolean result = refSupplier.Verify_SupplierDelete_SaveorNot(PhNo);
       Assert.assertTrue(result);
       fnWriteSteps("pass", "Supplier has been Deleted");
    	GenericMethods.fnEndTestCase();
	}
	@Test 
	public void fnDelete_SupplierCreation_for_WithoutInternet() {
		GenericMethods.fnStartTestCase("Verify Delete Supplier Feature for withoutInternet");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Supplier";
        int RowNumber = 3;
       String PhNo = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
       refSupplier.fnVerifySupplierDelete(PhNo);
       refSupplier.click_On_Yes_Button();
    	fnWriteSteps("pass", "Supplier not Deleted");
    	GenericMethods.fnEndTestCase();
	}
	
    @AfterMethod
	public void fnAfterMethod() {
		GenericMethods.fnStartTestCase("fn Logout");
		refSupplier.clickCloseButton();
		GenericMethods.fnwait(2);
		refDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		refMessageBoxEffia.ExitApplication_Yes();
		GenericMethods.fnwait(5);
		refLogin.ClickCloseButton();
		fnWriteSteps("Pass", "Application Close Successfully");
		GenericMethods.fnEndTestCase();

	}

}