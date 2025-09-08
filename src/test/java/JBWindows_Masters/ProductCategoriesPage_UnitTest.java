package JBWindows_Masters;

import java.awt.AWTException;

import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.INV.INV_CategoryView;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import JBWindows_Configurations.BaseTest;
import commonClass.ApplicationVariables;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class ProductCategoriesPage_UnitTest extends BaseTest {
	Login login;
	APP_Dashboard dashboard;
	APP_Menu menu;
	INV_CategoryView categoryView;
	MessageBoxEffia messageBox;
	

	@BeforeClass
	public void fnBeforeClass() {
		
		login = new Login(driver);
		dashboard = new APP_Dashboard(driver);
		menu = new APP_Menu(driver);
		categoryView = new INV_CategoryView(driver);    
	}
	
	@BeforeMethod
	public void fbBeforeMethod() {
		fnStartTestCase("Verify Successful Login");

        String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
                ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
        String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
                ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");

        login.fnDoLogin(Username, Password);
        fnWriteSteps("INFO", "Login method executed");
        dashboard.clickMenuBtn();
        menu.OpenPage("Product Categories");
		fnWriteSteps("INFO", "Product Categories Page Opened Successfully");	
	}

	
	
	@Test 
	public void fnVerifyFieldVisibility() {
		fnStartTestCase("Verify all the fields of Category add entry are present or not ");

		categoryView.verifyFieldVisibility();
		fnEndTestCase();

	}

	@Test 
	public void fnVerifyFieldEnableOrNot() {
		fnStartTestCase("Verify all the fields of Category add entry are enable or not");

		categoryView.verifyFieldEnableOrNot();
		fnEndTestCase();

	}
	
	@Test 
	public void fnverifyParent_Product_CategoryCreation(){
		fnStartTestCase("Verify Parent_Product_category Creation");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Category";
	    int RowNumber = 7;
	    String Image = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String CategoryName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String CategoryType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String DiscountRule = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		String ParentCategory = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		try {
			categoryView.fn_Verify_New_Category_Creation(Image,CategoryName,CategoryType,DiscountRule,ParentCategory,Description);
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean result = categoryView.Verify_ProductCategoryCreation_SaveorNot(CategoryName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Parent_Product_Category has been created & Saved");
		fnEndTestCase();
	}
	@Test 
	public void fnverify_Product_CategoryCreation_for_withoutInternet_Validation() throws AWTException, InterruptedException{
		fnStartTestCase("Verify Product_category Creation");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Category";
	    int RowNumber = 11;
	    String Image = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String CategoryName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String CategoryType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String DiscountRule = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		String ParentCategory = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		categoryView.fn_Verify_New_Category_Creation(Image,CategoryName,CategoryType,DiscountRule,ParentCategory,Description);
		boolean result = categoryView.Verify_ProductCategoryCreation_SaveorNot(CategoryName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Product_Category has been created & Saved");
		fnEndTestCase();
	}
	
	@Test 
	public void fnverifyNewProduct_CategoryCreation() throws AWTException, InterruptedException{
		fnStartTestCase("Verify New category Creation");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Category";
	    int RowNumber = 1;
	    String Image = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String CategoryName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String CategoryType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String DiscountRule = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		String ParentCategory = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		categoryView.fn_Verify_New_Category_Creation(Image,CategoryName,CategoryType,DiscountRule,ParentCategory,Description);
		boolean result = categoryView.Verify_ProductCategoryCreation_SaveorNot(CategoryName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "New Category has been created & Saved");
		fnEndTestCase();
	}
	
	@Test 
    public void fnVerifyEditProductCategoryFeature() throws FindFailed{
	   fnStartTestCase("Verify Edit ProductCategory Feature");
	   String StrExcelPath = ApplicationVariables.MasterExcelPath;
       String StrSheetName = "Category";
       int RowNumber = 6,RowNumber2=11;
       String Image = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
	   String CategoryName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	   String CategoryType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
	   String DiscountRule1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
	   String DiscountRule2 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber2,2);
	   String ParentCategory = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	   String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
	   String OldcategoryName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
	   String ParentCategory2 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber2, 3);

	   categoryView.verifyEditCategoryFeature(Image,CategoryName,CategoryType,DiscountRule1,DiscountRule2,ParentCategory,Description,OldcategoryName,ParentCategory2);
	   boolean result = categoryView.Verify_ProductCategoryUpdate_SaveorNot(CategoryName);
	   Assert.assertTrue(result);
	  fnWriteSteps("Pass", "ProductCategory has been Updated & Saved");
	  fnEndTestCase();
	
}
	@Test 
	public void fnverifyProduct_CategoryCreation_for_MultiDiscountFeature() throws AWTException, InterruptedException{
		fnStartTestCase("Verify Product category Creation for MultiDiscount Feature");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Category";
	    int RowNumber = 2;
	    String Image = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String CategoryName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String CategoryType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String DiscountRule = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		String ParentCategory = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		categoryView.fn_Verify_New_Category_Creation(Image,CategoryName,CategoryType,DiscountRule,ParentCategory,Description);
		boolean result = categoryView.Verify_ProductCategoryCreation_SaveorNot(CategoryName);
		Assert.assertTrue(result);
		fnWriteSteps("Pass", "Product Category has been created & Saved");
		fnEndTestCase();
	}
	@Test 
    public void fnVerifyDeleteParent_Product_CategoryFeature() {
    	fnStartTestCase("Verify DeleteParent_ProductCategory Feature");
    	String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Category";
        int RowNumber = 7;
        String Categoryname = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
    	categoryView.fnVerifyCategoryDelete(Categoryname);
    	//categoryView.click_On_Yes_Button();
    	//fnWriteSteps("Pass", "Parent_ProductCategory not Deleted ");
    	fnEndTestCase();
    }
	
	@Test 
    public void fnVerifyDeleteCategoryFeature() {
    	fnStartTestCase("Verify Delete_ProductCategory Feature");
    	String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Category";
        int RowNumber = 6;
        String Categoryname = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
    	categoryView.fnVerifyCategoryDelete(Categoryname);
    	GenericMethods.fnwait(10);
    	boolean result = categoryView.Verify_ProductCategoryDelete_SaveorNot(Categoryname);
    	Assert.assertFalse(result);
    	//fnWriteSteps("Pass", "ProductCategory has been Deleted ");
    	fnEndTestCase();
    }
	@Test 
    public void fnVerifyDelete_Product_CategoryFeature_for_withoutInternet_Validation() {
    	fnStartTestCase("Verify DeleteProductCategory Feature for withoutInternet");
    	String StrExcelPath = ApplicationVariables.MasterExcelPath;
        String StrSheetName = "Category";
        int RowNumber = 2;
        String Categoryname = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
    	categoryView.fnVerifyCategoryDelete(Categoryname);
    	//categoryView.click_On_Yes_Button();
    	//fnWriteSteps("Pass", "ProductCategory not Deleted ");
    	fnEndTestCase();
    }
    
  
   @AfterMethod
	public void fnAfterMethod() {
    	fnStartTestCase("fn Logout");
    	categoryView.clickBackButton();
		dashboard.logout();
		fnWriteSteps("Pass", "Application Close Successfully");
		fnEndTestCase();
	}


}
	
	

