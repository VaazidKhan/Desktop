package JBWindows_Masters;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import JBWindows.UMX.UMX_BookingMaster;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class BookingMasterPage_Test extends BaseClass {
	Login refLogin;
	APP_Dashboard refDashboard;
	APP_Menu refMenu;
	UMX_BookingMaster refBookingMaster;
	MessageBoxEffia refMessageBoxEffia;

	public BookingMasterPage_Test() {
		super();
	}

	@BeforeMethod
	public void fn_Login_and_Open_Page() throws InterruptedException, FindFailed {
		GenericMethods.fnStartTestCase("fn Login and Open Page");
		DOMConfigurator.configure("log4j.xml");
		refLogin = new Login(driver);
		refDashboard = new APP_Dashboard(driver);
		refMenu = new APP_Menu(driver);
		refBookingMaster = new UMX_BookingMaster();
		refMessageBoxEffia = new MessageBoxEffia(driver);

		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		refLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(10);
		refDashboard.clickMenuBtn();
        GenericMethods.fnwait(2);
        refBookingMaster.click_Booking_Master();
		GenericMethods.fnwait(1);
	    fnWriteSteps("Pass", "Application Open Successfully");
		GenericMethods.fnEndTestCase();
	}
	@Test
	public void fnVerifyFieldVisibility_FieldEnabledorNot() throws IOException, InterruptedException {
		GenericMethods.fnStartTestCase("Verify all the fields of BookingMaster add entry are present/Enable or not ");

		refBookingMaster.VerifyFieldVisibility_FieldEnabledorNot();
		GenericMethods.fnEndTestCase();
	} 
	@Test
	public void fnBookingMastercreation() {
     GenericMethods.fnStartTestCase("Verify Booking Master creation");
		
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName ="BookingMaster";
	    int RowNumber = 1;
	    String Bookingdate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String Bookingname = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String Phno = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String EmailId = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String Noofguests= ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
	    String status= ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
	    String remarks = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
	    refBookingMaster.CreateNewBookingMaster(Bookingdate,Bookingname,Phno,EmailId,Noofguests,status,remarks);
	    boolean result = refBookingMaster.Verify_NewBookingMaster_SaveorNot(Phno);
	    Assert.assertTrue(result);
	    fnWriteSteps("Pass", "BookingMaster has been created & Saved");
          GenericMethods.fnEndTestCase();
	}
	@Test
	public void fnBookingMasterEdit() {
	     GenericMethods.fnStartTestCase("Verify Booking Master Edit ");
			
			String StrExcelPath = ApplicationVariables.MasterExcelPath;
		    String StrSheetName ="BookingMaster";
		    int RowNumber = 2;
		    String Bookingdate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		    String Bookingname = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		    String Phno =  ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		    String EmailId = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		    String Noofguests= ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		    String status= ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		    String remarks = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		    String OldPhno = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		    refBookingMaster.verifyBookingMasterEdit(OldPhno,Bookingdate,Bookingname,Phno,EmailId,Noofguests,status,remarks);
		    boolean result = refBookingMaster.Verify_NewBookingMaster_SaveorNot(Phno);
		    Assert.assertTrue(result);
		    fnWriteSteps("Pass", "BookingMaster has been Updated & Saved");
	          GenericMethods.fnEndTestCase();
		}
	@Test
	public void fnBookingMastercreation_for_withoutInternet() {
     GenericMethods.fnStartTestCase("Verify Booking Master creation for withoutInternet");
		
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName ="BookingMaster";
	    int RowNumber = 3;
	    String Bookingdate = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	    String Bookingname = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	    String Phno = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	    String EmailId = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String Noofguests= ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
	    String status= ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
	    String remarks = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
	    refBookingMaster.CreateNewBookingMaster(Bookingdate, Bookingname, Phno, EmailId, Noofguests, status, remarks);
	    boolean result = refBookingMaster.Verify_NewBookingMaster_SaveorNot(Phno);
	    Assert.assertTrue(result);
	    fnWriteSteps("Pass", "BookingMaster has been created & Saved");
          GenericMethods.fnEndTestCase();
	}
	@Test
	public void fnDeleteBookingMaster() {
		GenericMethods.fnStartTestCase("Verify Delete BookingMaster Feature");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "BookingMaster";
        int RowNumber = 2;
        String Phno = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
        refBookingMaster.fnVerifyBookingMasterDelete(Phno);
        boolean result = refBookingMaster.Verify_BookingMasterDelete_SaveorNot(Phno);
    	Assert.assertTrue(result);
    	fnWriteSteps("pass", "BookingMaster has been Deleted");
    	GenericMethods.fnEndTestCase();
	}
 @Test
    public void fnDeleteBookingMaster_for_withoutInternet() {
	GenericMethods.fnStartTestCase("Verify Delete BookingMaster Feature for withoutInternet");
	String StrExcelPath = ApplicationVariables.MasterExcelPath;
    String StrSheetName = "BookingMaster";
    int RowNumber = 3;
    String Phno = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
    refBookingMaster.fnVerifyBookingMasterDelete(Phno);
    refBookingMaster.click_On_Yes_Button();
	fnWriteSteps("pass", "BookingMaster not Deleted");
	GenericMethods.fnEndTestCase();
}
	
	@AfterMethod
	public void fnAfterMethod() {
		GenericMethods.fnStartTestCase("fn Logout");
		refBookingMaster.clickCloseButton();
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
