package JBWindows_Masters;

import java.io.IOException;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import JBWindows.APP.APP_Dashboard;
import JBWindows.APP.APP_Menu;
import JBWindows.INV.INV_ProductAliasEntry;
import JBWindows.INV.INV_ProductPriceListItems;
import JBWindows.INV.INV_ProductPurchasing;
import JBWindows.INV.INV_ProductView;
import JBWindows.PUR.PUR_Suppliers;
import JBWindows.SAL.SAL_SelectMofifier;
import JBWindows.SYS.Login;
import JBWindows.SYS.MessageBoxEffia;
import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class MultiDiscProductCreationTest extends BaseClass {

	Login refLogin;
	APP_Dashboard refDashboard;
	APP_Menu refMenu;
	INV_ProductView refProducts;
	MessageBoxEffia refMessgBox;
	INV_ProductPriceListItems refProductPriceListItems;
	INV_ProductPurchasing refProductPurchasing;
	PUR_Suppliers refSupplierPage;
	SAL_SelectMofifier refProductModifier;
	INV_ProductAliasEntry refProductAliasEntry;

	public MultiDiscProductCreationTest() {
		super();
	}


	@BeforeMethod
	public void fnBeforeMethod() throws InterruptedException, IOException {
		GenericMethods.fnStartTestCase("fn Login and Open Page");
		DOMConfigurator.configure("log4j.xml");
		refLogin = new Login(driver);
		refDashboard = new APP_Dashboard(driver);
		refMenu = new APP_Menu(driver);
		refProducts = new INV_ProductView();
		refMessgBox = new MessageBoxEffia(driver);
		refProductPriceListItems = new INV_ProductPriceListItems();
		refProductPurchasing = new INV_ProductPurchasing();
		refSupplierPage = new PUR_Suppliers();
		refProductModifier = new SAL_SelectMofifier();
		refProductAliasEntry = new INV_ProductAliasEntry();
        GenericMethods.fnwait(28);
		String Username = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Username");
		String Password = ExcelUtils.fn_Get_Expected_Cell_Value_based_on_Execution_Status(
				ApplicationVariables.LoginMasterExcel, "EnvironmentDetails", "Execution", "Yes Win", "Password");
		refLogin.fnDoLogin(Username, Password);
		GenericMethods.fnwait(10);
		refDashboard.clickMenuBtn();
		GenericMethods.fnwait(2);
		refMenu.OpenPage("products");
		GenericMethods.fnwait(1);
		fnWriteSteps("Pass", "Application Open Successfully");
		GenericMethods.fnEndTestCase();

	}
	@Test 
	public void FnVerify_Product_Creation_with_PriceCatalogDiscount(){
		GenericMethods.fnStartTestCase("Verify Product Creation with PriceCatalogDiscount");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Products";
	    int RowNumber = 12;
	    String ProductName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String ProductCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String ProductType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		String CategoryName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String Unit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String DiscType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String DefaultDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String PriceCatalogDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String BrandDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String DepartmentDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		String MaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		String UnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
	refProducts.verify_Product_Creation_with_MultipleDiscounts(ProductName,ProductCode,ProductType,CategoryName,Unit,DiscType,DefaultDisc,PriceCatalogDisc,BrandDisc,DepartmentDisc,MaxRetailPrice,UnitPrice);
		 boolean result = refProducts.Verify_NewProductCreation_SaveorNot(ProductName);
			Assert.assertTrue(result);
		fnWriteSteps("Pass", "Product Creation with PriceCatalogDiscount has been Created & Saved" );
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void FnVerify_Product_Creation_with_DefaultDiscount() {
		GenericMethods.fnStartTestCase("Verify Product Creation with DefaultDiscount");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Products";
	    int RowNumber = 13;
	    String ProductName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String ProductCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String ProductType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		String CategoryName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String Unit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String DiscType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String DefaultDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String PriceCatalogDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String BrandDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String DepartmentDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		String MaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		String UnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
	 refProducts.verify_Product_Creation_with_MultipleDiscounts(ProductName,ProductCode,ProductType,CategoryName,Unit,DiscType,DefaultDisc,PriceCatalogDisc,BrandDisc,DepartmentDisc,MaxRetailPrice,UnitPrice);
		 boolean result = refProducts.Verify_NewProductCreation_SaveorNot(ProductName);
			Assert.assertTrue(result);
		fnWriteSteps("Pass", "Product Creation with DefaultDiscount has been Created & Saved" );
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void FnVerify_Product_Creation_with_BrandDiscount(){
		GenericMethods.fnStartTestCase("Verify Product Creation with BrandDiscount");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Products";
	    int RowNumber = 14;
	    String ProductName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String ProductCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String ProductType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		String CategoryName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String Unit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String DiscType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String DefaultDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
	    String PriceCatalogDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String BrandDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String DepartmentDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		String MaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		String UnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
	refProducts.verify_Product_Creation_with_MultipleDiscounts(ProductName,ProductCode,ProductType,CategoryName,Unit,DiscType,DefaultDisc,PriceCatalogDisc,BrandDisc,DepartmentDisc,MaxRetailPrice,UnitPrice);
		 boolean result = refProducts.Verify_NewProductCreation_SaveorNot(ProductName);
			Assert.assertTrue(result);
		fnWriteSteps("Pass", "Product Creation with BrandDiscount has been Created & Saved" );
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void FnVerify_Product_Creation_with_CategoryDiscount(){
		GenericMethods.fnStartTestCase("Verify Product Creation with CategoryDiscount");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Products";
	    int RowNumber = 15;
	    String ProductName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String ProductCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String ProductType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		String CategoryName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String Unit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String DiscType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String DefaultDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
	    String PriceCatalogDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String BrandDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String DepartmentDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		String MaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		String UnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
	refProducts.verify_Product_Creation_with_MultipleDiscounts(ProductName,ProductCode,ProductType,CategoryName,Unit,DiscType,DefaultDisc,PriceCatalogDisc,BrandDisc,DepartmentDisc,MaxRetailPrice,UnitPrice);
		 boolean result = refProducts.Verify_NewProductCreation_SaveorNot(ProductName);
			Assert.assertTrue(result);
		fnWriteSteps("Pass", "Product Creation with CategoryDiscount has been Created & Saved" );
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void FnVerify_Product_Creation_with_DepartmentDiscount(){
		GenericMethods.fnStartTestCase("Verify Product Creation with DepartmentDiscount");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Products";
	    int RowNumber = 16;
	    String ProductName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String ProductCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String ProductType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		String CategoryName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String Unit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String DiscType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String DefaultDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String PriceCatalogDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String BrandDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String DepartmentDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		String MaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		String UnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
	refProducts.verify_Product_Creation_with_MultipleDiscounts(ProductName,ProductCode,ProductType,CategoryName,Unit,DiscType,DefaultDisc,PriceCatalogDisc,BrandDisc,DepartmentDisc,MaxRetailPrice,UnitPrice);
		 boolean result = refProducts.Verify_NewProductCreation_SaveorNot(ProductName);
			Assert.assertTrue(result);
		fnWriteSteps("Pass", "Product Creation with DepartmentDiscount has been Created & Saved" );
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void FnVerify_Product_Creation_with_DefaultDisc_BrandDisc_CategoryDisc_DeptDisc(){
		GenericMethods.fnStartTestCase("Verify Product Creation with DefaultDisc BrandDisc CategoryDisc DeptDisc");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Products";
	    int RowNumber = 17;
	    String ProductName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String ProductCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String ProductType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		String CategoryName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String Unit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String DiscType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String DefaultDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String PriceCatalogDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String BrandDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String DepartmentDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		String MaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		String UnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
	refProducts.verify_Product_Creation_with_MultipleDiscounts(ProductName,ProductCode,ProductType,CategoryName,Unit,DiscType,DefaultDisc,PriceCatalogDisc,BrandDisc,DepartmentDisc,MaxRetailPrice,UnitPrice);
		 boolean result = refProducts.Verify_NewProductCreation_SaveorNot(ProductName);
			Assert.assertTrue(result);
		fnWriteSteps("Pass", "Product Creation with DefaultDisc,BrandDisc,CategoryDisc and DeptDisc has been Created & Saved" );
		GenericMethods.fnEndTestCase();
		
	}
	
	@Test 
	public void FnVerify_Product_Creation_For_B2C_CustomerDiscount(){
		GenericMethods.fnStartTestCase("Verify Product Creation For_B2C_CustomerDiscount");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Products";
	    int RowNumber = 19;
	    String ProductName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String ProductCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String ProductType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		String CategoryName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String Unit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String DiscType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String DefaultDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String PriceCatalogDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String BrandDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String DepartmentDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		String MaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		String UnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
	refProducts.verify_Product_Creation_with_MultipleDiscounts(ProductName,ProductCode,ProductType,CategoryName,Unit,DiscType,DefaultDisc,PriceCatalogDisc,BrandDisc,DepartmentDisc,MaxRetailPrice,UnitPrice);
		 boolean result = refProducts.Verify_NewProductCreation_SaveorNot(ProductName);
			Assert.assertTrue(result);
		fnWriteSteps("Pass", "Product Creation For_B2C_CustomerDiscount has been Created & Saved" );
		GenericMethods.fnEndTestCase();
		
	}
	@Test 
	public void FnVerify_Product_Creation_For_B2B_CustomerDiscount(){
		GenericMethods.fnStartTestCase("Verify Product Creation For_B2B_CustomerDiscount");
		String StrExcelPath = ApplicationVariables.MasterExcelPath;
	    String StrSheetName = "Products";
	    int RowNumber = 20;
	    String ProductName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
		String ProductCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
		String ProductType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
		String CategoryName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
	    String Unit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		String DiscType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
		String DefaultDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
		String PriceCatalogDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		String BrandDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
		String DepartmentDisc = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
		String MaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		String UnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
	refProducts.verify_Product_Creation_with_MultipleDiscounts(ProductName,ProductCode,ProductType,CategoryName,Unit,DiscType,DefaultDisc,PriceCatalogDisc,BrandDisc,DepartmentDisc,MaxRetailPrice,UnitPrice);
		 boolean result = refProducts.Verify_NewProductCreation_SaveorNot(ProductName);
			Assert.assertTrue(result);
		fnWriteSteps("Pass", "Product Creation For_B2B_CustomerDiscount has been Created & Saved" );
		GenericMethods.fnEndTestCase();
		
	}
	@AfterMethod
	public void fnAfterMethod() {
		GenericMethods.fnStartTestCase("fn Logout");
		GenericMethods.fnwait(2);
		refProducts.clickCloseButton();
		GenericMethods.fnwait(2);
		refDashboard.logoutwithoutmenu();
		GenericMethods.fnwait(1);
		refMessgBox.ExitApplication_Yes();
		GenericMethods.fnwait(23);
		refLogin.ClickCloseButton();
		fnWriteSteps("Pass", "Application Close Successfully");
		GenericMethods.fnEndTestCase();
	}

}


