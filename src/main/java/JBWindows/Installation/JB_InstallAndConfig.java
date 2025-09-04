package JBWindows.Installation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class JB_InstallAndConfig extends BaseClass {
	// Registration Type
	@FindBy(id = "rbtnNewOrganisation")
	WebElement rbtnNewOrganisation;
	@FindBy(id = "rbtnExistingOrganisation")
	WebElement rbtnExistingOrganisation;
	@FindBy(id = "txtOrganizationCode")
	WebElement txtOrganizationCode;
	@FindBy(id = "txtAccountID")
	WebElement txtAccountID;
	@FindBy(id = "btnNext")
	WebElement btnNext;

	// UserDetails
	@FindBy(name = "New User")
	WebElement rbtnNewUser;
	@FindBy(name = "Existing User")
	WebElement rbtnExistingUser;
	@FindBy(id = "txtName")
	WebElement txtName;
	@FindBy(id = "txtMobileNumber")
	WebElement txtMobileNumber;
	@FindBy(id = "txtEmailAddress")
	WebElement txtEmailAddress;
	@FindBy(id = "txtPassword")
	WebElement txtPassword;
	@FindBy(id = "txtBranchCode")
	WebElement txtBranchCode;

	// Subscription days details
	@FindBy(id = "chkFreeTrail")
	WebElement chkFreeTrail;
	@FindBy(id = "txtSubscriptionCode")
	WebElement txtSubscriptionCode;

	public JB_InstallAndConfig() {
		PageFactory.initElements(driver, this);
	}

	private static Screen refScreen;

	public void SetupJB() {

		// Installation
		refScreen = new Screen();
		try {
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\Install\\Welcome_BTN_Next.PNG");
			GenericMethods.fnwait(2);
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\Install\\LA_RDBTN_LAccept.png");
			GenericMethods.fnwait(2);
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\Install\\LA_BTN_Next.PNG");
			GenericMethods.fnwait(2);
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\Install\\Destination_BTN_Next.PNG");
			GenericMethods.fnwait(2);
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\Install\\BTN_Install.PNG");
			GenericMethods.fnwait(30);
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\Install\\BTN_Finish.PNG");
		} catch (FindFailed e) {
			e.printStackTrace();
			System.out.println("Image not found");
		}

		GenericMethods.fnwait(120);
		System.out.println("Configuration start");

		String strOrgCode = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes", "OrganisationCode");
		System.out.println("Organisation code : " + strOrgCode);

		String strAccountID = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes", "AccountID");
		System.out.println("Account ID : " + strAccountID);

		rbtnExistingOrganisation.click();
		GenericMethods.fnwait(2);
		txtOrganizationCode.sendKeys(strOrgCode);
		GenericMethods.fnwait(1);
		txtAccountID.sendKeys(strAccountID);
		GenericMethods.fnwait(1);
		btnNext.click();
		GenericMethods.fnwait(5);

		/* UserDetails configuration from here */
		rbtnExistingUser.click();
		GenericMethods.fnwait(1);
		
		String strEmailID = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes", "Username");
		System.out.println("Email ID : " + strEmailID);
		
		txtEmailAddress.sendKeys(strEmailID);
		GenericMethods.fnwait(1);
		
		String strPassword = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes", "Password");
		System.out.println("Password : " + strPassword);
		
		txtPassword.sendKeys(strPassword);
		GenericMethods.fnwait(1);
		
		btnNext.click();
		GenericMethods.fnwait(5);

		/* Subscription days configuration starts from here */
		String strSubscriptionCode = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes", "subscriptioncode");
		System.out.println("Subscription Code : " + strSubscriptionCode);

		chkFreeTrail.click();
		GenericMethods.fnwait(2);
		txtSubscriptionCode.sendKeys(strSubscriptionCode);
		System.out.println("20 sec to get the remaining subscription days");
		GenericMethods.fnwait(20);
		btnNext.click();
		System.out.println("40 sec wait to appear download data popup");
		GenericMethods.fnwait(40);

		try {
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\AppConfig\\Transdatadownload_No.PNG");
			GenericMethods.fnwait(180);
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\AppConfig\\App_BTN_Logout.PNG");
			GenericMethods.fnwait(2);
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\AppConfig\\App_BTN_Logout_Yes.PNG");
			GenericMethods.fnwait(2);
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\AppConfig\\JB_Icon_TaskBar.PNG");
			GenericMethods.fnwait(2);
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\AppConfig\\LoginScreen_BTN_Close.PNG");
		} catch (FindFailed e) {
			e.printStackTrace();
			System.out.println("Image not found");
		}
	}


	public void SetupJB_WithTransactionData() {

		// Installation
		refScreen = new Screen();
		try {
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\Install\\Welcome_BTN_Next.PNG");
			GenericMethods.fnwait(2);
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\Install\\LA_RDBTN_LAccept.png");
			GenericMethods.fnwait(2);
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\Install\\LA_BTN_Next.PNG");
			GenericMethods.fnwait(2);
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\Install\\Destination_BTN_Next.PNG");
			GenericMethods.fnwait(2);
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\Install\\BTN_Install.PNG");
			GenericMethods.fnwait(30);
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\Install\\BTN_Finish.PNG");
		} catch (FindFailed e) {
			e.printStackTrace();
			System.out.println("Image not found");
		}

		GenericMethods.fnwait(120);
		System.out.println("Configuration start");

		String strOrgCode = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes", "OrganisationCode");
		System.out.println("Organisation code : " + strOrgCode);

		String strAccountID = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes", "AccountID");
		System.out.println("Account ID : " + strAccountID);

		rbtnExistingOrganisation.click();
		GenericMethods.fnwait(2);
		txtOrganizationCode.sendKeys(strOrgCode);
		GenericMethods.fnwait(1);
		txtAccountID.sendKeys(strAccountID);
		GenericMethods.fnwait(1);
		btnNext.click();
		GenericMethods.fnwait(5);

		/* UserDetails configuration from here */
		rbtnExistingUser.click();
		GenericMethods.fnwait(1);
		
		String strEmailID = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes", "Username");
		System.out.println("Email ID : " + strEmailID);
		
		txtEmailAddress.sendKeys(strEmailID);
		GenericMethods.fnwait(1);
		
		String strPassword = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes", "Password");
		System.out.println("Password : " + strPassword);
		
		txtPassword.sendKeys(strPassword);
		GenericMethods.fnwait(1);
		
		btnNext.click();
		GenericMethods.fnwait(5);

		/* Subscription days configuration starts from here */
		String strSubscriptionCode = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes", "subscriptioncode");
		System.out.println("Subscription Code : " + strSubscriptionCode);

		chkFreeTrail.click();
		GenericMethods.fnwait(2);
		txtSubscriptionCode.sendKeys(strSubscriptionCode);
		System.out.println("20 sec to get the remaining subscription days");
		GenericMethods.fnwait(20);
		btnNext.click();
		System.out.println("40 sec wait to appear download data popup");
		GenericMethods.fnwait(40);

		try {
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\AppConfig\\Transdatadownload_Yes.PNG");
			GenericMethods.fnwait(180);
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\AppConfig\\App_BTN_Logout.PNG");
			GenericMethods.fnwait(2);
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\AppConfig\\App_BTN_Logout_Yes.PNG");
			GenericMethods.fnwait(2);
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\AppConfig\\JB_Icon_TaskBar.PNG");
			GenericMethods.fnwait(2);
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\AppConfig\\LoginScreen_BTN_Close.PNG");
		} catch (FindFailed e) {
			e.printStackTrace();
			System.out.println("Image not found");
		}
	}
	
}
