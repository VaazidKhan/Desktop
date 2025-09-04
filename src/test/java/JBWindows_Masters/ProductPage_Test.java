package JBWindows_Masters;
    
    import org.apache.log4j.xml.DOMConfigurator;
    import org.sikuli.script.FindFailed;
    import org.testng.Assert;
    import org.testng.annotations.AfterMethod;
	import java.io.IOException;
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

	public class ProductPage_Test extends BaseClass {

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

		public ProductPage_Test() {
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
		public void fnVerifyFieldVisibility() throws IOException, InterruptedException {
			GenericMethods.fnStartTestCase("Verify all the fields of Product add entry are present or not ");

			refProducts.verifyFieldVisibility();

			GenericMethods.fnEndTestCase();

		}

		@Test 
		public void fnVerifyFieldEnableOrNot() throws IOException, InterruptedException {
			GenericMethods.fnStartTestCase("Verify all the fields of Product add entry are enable or not");

			refProducts.verifyFieldEnableOrNot();

			GenericMethods.fnEndTestCase();

		}
		@Test 
		public void FnVerify_Active_Product_Creation() throws FindFailed{
			GenericMethods.fnStartTestCase("Verify Active Product Creation");
			String StrExcelPath = ApplicationVariables.MasterExcelPath;
		    String StrSheetName = "Products";
		    int RowNumber = 1;
		    String Image = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
			String ProductName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
			String ProductCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
			String ProductType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
			String CategoryName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
			String ParentProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		    String Brand = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
			String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		    String HSNCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
			String Unit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
			String Department = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
			String StndsaleMaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,13);
			String StndPurchasemaxretailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,14);
			String StndsaleUnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,15);
			String StndPurchaseUnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,16);
			String TaxGroup = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
			String inactive= ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,26);
			refProducts.verify_NewProduct_Creation(Image,ProductName,ProductCode,ProductType,CategoryName,ParentProduct,Brand,Description,HSNCode,Unit,TaxGroup,Department,StndsaleMaxRetailPrice,StndPurchasemaxretailPrice,StndsaleUnitPrice,StndPurchaseUnitPrice,inactive);
			 boolean result = refProducts.Verify_NewProductCreation_SaveorNot(ProductName);
				Assert.assertTrue(result);
			fnWriteSteps("Pass", "Active_Product has been Created & Saved" );
			GenericMethods.fnEndTestCase();
			
		}
		@Test 
		public void FnVerify_InActive_Product_Creation() throws FindFailed{
			GenericMethods.fnStartTestCase("Verify InActive Product Creation");
			String StrExcelPath = ApplicationVariables.MasterExcelPath;
		    String StrSheetName = "Products";
		    int RowNumber = 2;
		    String Image = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
			String ProductName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
			String ProductCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
			String ProductType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
			String CategoryName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
			String ParentProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		    String Brand = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
			String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		    String HSNCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
			String Unit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
			String Department = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
			String StndsaleMaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,13);
			String StndPurchasemaxretailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,14);
			String StndsaleUnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,15);
			String StndPurchaseUnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,16);
			String TaxGroup = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
			String inactive= ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,26);
			refProducts.verify_NewProduct_Creation(Image,ProductName,ProductCode,ProductType,CategoryName,ParentProduct,Brand,Description,HSNCode,Unit,TaxGroup,Department,StndsaleMaxRetailPrice,StndPurchasemaxretailPrice,StndsaleUnitPrice,StndPurchaseUnitPrice,inactive);
			 boolean result = refProducts.Verify_NewProductCreation_SaveorNot(ProductName);
				Assert.assertTrue(result);
			fnWriteSteps("Pass", "InActive_Product has been Created & Saved" );
			GenericMethods.fnEndTestCase();
			
		}
		@Test 
		public void FnVerify_Product_Creation_for_WithoutInternet_Validation() throws FindFailed{
			GenericMethods.fnStartTestCase("Verify Product Creation_for_withoutInternet");
			String StrExcelPath = ApplicationVariables.MasterExcelPath;
		    String StrSheetName = "Products";
		    int RowNumber = 5;
		    String Image = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
			String ProductName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
			String ProductCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
			String ProductType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
			String CategoryName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
			String ParentProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		    String Brand = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
			String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		    String HSNCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
			String Unit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
			String Department = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
			String StndsaleMaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,13);
			String StndPurchasemaxretailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,14);
			String StndsaleUnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,15);
			String StndPurchaseUnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,16);
			String TaxGroup = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
			String inactive= ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,26);
			refProducts.verify_NewProduct_Creation(Image,ProductName,ProductCode,ProductType,CategoryName,ParentProduct,Brand,Description,HSNCode,Unit,TaxGroup,Department,StndsaleMaxRetailPrice,StndPurchasemaxretailPrice,StndsaleUnitPrice,StndPurchaseUnitPrice,inactive);
			 boolean result = refProducts.Verify_NewProductCreation_SaveorNot(ProductName);
				Assert.assertTrue(result);
			fnWriteSteps("Pass", "Product has been Created & Saved" );
			GenericMethods.fnEndTestCase();
			
		}
		@Test 
		public void FnVerify_New_Product_Creation() throws FindFailed{
			GenericMethods.fnStartTestCase("Verify New Product Creation");
			String StrExcelPath = ApplicationVariables.MasterExcelPath;
		    String StrSheetName = "Products";
		    int RowNumber = 3;
		    String Image = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
			String ProductName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
			String ProductCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
			String ProductType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
			String CategoryName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
			String ParentProduct = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
		    String Brand = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
			String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
		    String HSNCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
			String Unit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
			String Department = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
			String StndsaleMaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,13);
			String StndPurchasemaxretailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,14);
			String StndsaleUnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,15);
			String StndPurchaseUnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,16);
			String TaxGroup = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
			String inactive= ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,26);
			refProducts.verify_NewProduct_Creation(Image,ProductName,ProductCode,ProductType,CategoryName,ParentProduct,Brand,Description,HSNCode,Unit,TaxGroup,Department,StndsaleMaxRetailPrice,StndPurchasemaxretailPrice,StndsaleUnitPrice,StndPurchaseUnitPrice,inactive);
			 boolean result = refProducts.Verify_NewProductCreation_SaveorNot(ProductName);
				Assert.assertTrue(result);
			fnWriteSteps("Pass", "New_Product has been Created & Saved" );
			GenericMethods.fnEndTestCase();
			
		}
		@Test 
		public void fnVerifyEditProductFeature() throws FindFailed{
			GenericMethods.fnStartTestCase("Verify Edit Product Feature");
			String StrExcelPath = ApplicationVariables.MasterExcelPath;
		    String StrSheetName = "Products";
		    int RowNumber = 8;
		    String OldProductName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,19);
		    String ProductName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
			String CategoryName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
		    String HSNCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
			String Unit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
			String Brand = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
			String Description = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
			String ProductCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
			String StndPurchaseMaxRetailprice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,14);
			String StndPurchaseUnitprice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,16);
			String StndPurchaseunitPrice1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,24);
			String StndPurchaseTaxGroup = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,20);
			String StndPurchaseDiscount = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,21);
			String StndsaleUnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,15);
			String StndsaleunitPrice1 = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,24);
			String StndsaleMaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,13);
			String StndsaleTaxGroup = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,22);
			String StndsaleDiscount = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,23);
			refProducts.verifyEditProductFeature(OldProductName,ProductName,CategoryName,HSNCode,Unit,Brand,Description,ProductCode,StndsaleMaxRetailPrice,StndPurchaseMaxRetailprice,StndsaleUnitPrice,StndsaleunitPrice1,StndPurchaseUnitprice,StndPurchaseunitPrice1,StndsaleTaxGroup,StndPurchaseTaxGroup,StndsaleDiscount,StndPurchaseDiscount);
			 boolean result = refProducts.Verify_EditProductFeature_SaveorNot(ProductName);
				Assert.assertTrue(result);
			fnWriteSteps("Pass", "Product has been Updated & Saved" );
			GenericMethods.fnEndTestCase();
			
		}
		@Test 
		public void fnProduct_Creation_MappedBy_BatchNumber() {
			GenericMethods.fnStartTestCase("Verify Product Creation MappedBy BatchNumber");
			String StrExcelPath = ApplicationVariables.MasterExcelPath;
		    String StrSheetName = "Products";
		    int RowNumber = 24;
		    String ProductName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
			String ProductCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
			String ProductType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
			String CategoryName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		    String Unit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
			String ManagedBy = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
			String BatchNum = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
			String SerialNum = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
			String MaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
			String UnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
			String ProcurementMethod = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
			String NotAllowNegativeStock = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
			String PurchaseMaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
			String PurchaseUnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,13);
         refProducts.verify_Product_Creation_MappedBy_BatchANDSerialNumber(NotAllowNegativeStock,ProductName, ProductCode, ProductType, CategoryName, Unit,ProcurementMethod, ManagedBy, BatchNum, SerialNum, MaxRetailPrice, UnitPrice,PurchaseMaxRetailPrice,PurchaseUnitPrice);
			 boolean result = refProducts.Verify_NewProductCreation_SaveorNot(ProductName);
				Assert.assertTrue(result);
			fnWriteSteps("Pass", "Product Creation MappedBy BatchNumber has been Created & Saved" );
			GenericMethods.fnEndTestCase();
			
		}
		@Test 
		public void fnProduct_Creation_MappedBy_SerialNumber() {
			GenericMethods.fnStartTestCase("Verify Product Creation MappedBy SerialNumber");
			String StrExcelPath = ApplicationVariables.MasterExcelPath;
		    String StrSheetName = "Products";
		    int RowNumber = 25;
		    String ProductName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
			String ProductCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
			String ProductType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
			String CategoryName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		    String Unit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
			String ManagedBy = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
			String BatchNum = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
			String SerialNum = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
			String MaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
			String UnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
			String ProcurementMethod = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
			String NotAllowNegativeStock = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
			String PurchaseMaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
			String PurchaseUnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,13);
		refProducts.verify_Product_Creation_MappedBy_BatchANDSerialNumber(NotAllowNegativeStock,ProductName, ProductCode, ProductType, CategoryName, Unit,ProcurementMethod, ManagedBy, BatchNum, SerialNum, MaxRetailPrice, UnitPrice,PurchaseMaxRetailPrice,PurchaseUnitPrice);
			 boolean result = refProducts.Verify_NewProductCreation_SaveorNot(ProductName);
				Assert.assertTrue(result);
			fnWriteSteps("Pass", "Product Creation MappedBy SerialNumber has been Created & Saved" );
			GenericMethods.fnEndTestCase();
			
			
		}
		@Test 
		public void fnProduct_Creation_for_Production_as_a_FinishedGood() {
			GenericMethods.fnStartTestCase("Verify Product Creation for Production as a FinishedGood");
			String StrExcelPath = ApplicationVariables.MasterExcelPath;
		    String StrSheetName = "Products";
		    int RowNumber = 28;
		    String ProductName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
			String ProductCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
			String ProductType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
			String CategoryName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		    String Unit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
			String ManagedBy = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
			String BatchNum = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
			String SerialNum = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
			String MaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
			String UnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
			String ProcurementMethod = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
			String NotAllowNegativeStock = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
			String PurchaseMaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
			String PurchaseUnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,13);
         refProducts.verify_Product_Creation_MappedBy_BatchANDSerialNumber(NotAllowNegativeStock,ProductName, ProductCode, ProductType, CategoryName, Unit,ProcurementMethod, ManagedBy, BatchNum, SerialNum, MaxRetailPrice, UnitPrice,PurchaseMaxRetailPrice,PurchaseUnitPrice);
			 boolean result = refProducts.Verify_NewProductCreation_SaveorNot(ProductName);
				Assert.assertTrue(result);
			fnWriteSteps("Pass", "Product Creation for Production has been Created & Saved" );
			GenericMethods.fnEndTestCase();
			
		}
		@Test 
		public void fnProduct_Creation_for_Production_as_a_RawProduct1() {
			GenericMethods.fnStartTestCase("Verify Product Creation for Production as a RawProduct1");
			String StrExcelPath = ApplicationVariables.MasterExcelPath;
		    String StrSheetName = "Products";
		    int RowNumber = 29;
		    String ProductName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
			String ProductCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
			String ProductType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
			String CategoryName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		    String Unit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
			String ManagedBy = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
			String BatchNum = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
			String SerialNum = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
			String MaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
			String UnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
			String ProcurementMethod = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
			String NotAllowNegativeStock = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
			String PurchaseMaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
			String PurchaseUnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,13);
         refProducts.verify_Product_Creation_MappedBy_BatchANDSerialNumber(NotAllowNegativeStock,ProductName, ProductCode, ProductType, CategoryName, Unit,ProcurementMethod, ManagedBy, BatchNum, SerialNum, MaxRetailPrice, UnitPrice,PurchaseMaxRetailPrice,PurchaseUnitPrice);
			 boolean result = refProducts.Verify_NewProductCreation_SaveorNot(ProductName);
				Assert.assertTrue(result);
			fnWriteSteps("Pass", "Product Creation for Production has been Created & Saved" );
			GenericMethods.fnEndTestCase();
			
		}
		@Test 
		public void fnProduct_Creation_for_Production_as_a_RawProduct2() {
			GenericMethods.fnStartTestCase("Verify Product Creation for Production as a RawProduct2");
			String StrExcelPath = ApplicationVariables.MasterExcelPath;
		    String StrSheetName = "Products";
		    int RowNumber = 30;
		    String ProductName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
			String ProductCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
			String ProductType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
			String CategoryName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		    String Unit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
			String ManagedBy = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
			String BatchNum = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
			String SerialNum = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
			String MaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
			String UnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
			String ProcurementMethod = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
			String  NotAllowNegativeStock= ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
			String PurchaseMaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
			String PurchaseUnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,13);
         refProducts.verify_Product_Creation_MappedBy_BatchANDSerialNumber(NotAllowNegativeStock,ProductName, ProductCode, ProductType, CategoryName, Unit,ProcurementMethod, ManagedBy, BatchNum, SerialNum, MaxRetailPrice, UnitPrice,PurchaseMaxRetailPrice,PurchaseUnitPrice);
			 boolean result = refProducts.Verify_NewProductCreation_SaveorNot(ProductName);
				Assert.assertTrue(result);
			fnWriteSteps("Pass", "Product Creation for Production has been Created & Saved" );
			GenericMethods.fnEndTestCase();
			
		}
		@Test 
		public void fnProduct_Creation_for_Production_as_a_NotAllowNegativeStock_RawProduct3() {
			GenericMethods.fnStartTestCase("Verify Product Creation for Production as a NotAllowNegativeStock RawProduct3");
			String StrExcelPath = ApplicationVariables.MasterExcelPath;
		    String StrSheetName = "Products";
		    int RowNumber = 31;
		    String ProductName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
			String ProductCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
			String ProductType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
			String CategoryName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		    String Unit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
			String ManagedBy = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
			String BatchNum = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
			String SerialNum = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
			String MaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
			String UnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
			String ProcurementMethod = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
			String  NotAllowNegativeStock= ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
			String PurchaseMaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
			String PurchaseUnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,13);
         refProducts.verify_Product_Creation_MappedBy_BatchANDSerialNumber(NotAllowNegativeStock,ProductName, ProductCode, ProductType, CategoryName, Unit,ProcurementMethod, ManagedBy, BatchNum, SerialNum, MaxRetailPrice, UnitPrice,PurchaseMaxRetailPrice,PurchaseUnitPrice);
			 boolean result = refProducts.Verify_NewProductCreation_SaveorNot(ProductName);
				Assert.assertTrue(result);
			fnWriteSteps("Pass","NotAllowNegativeStock Product Creation for Production has been Created & Saved" );
			GenericMethods.fnEndTestCase();
			
		}
		@Test 
		public void fnProduct_Creation_for_ProductionOFBatchNO_as_a_FinishedGood() {
			GenericMethods.fnStartTestCase("Verify Product Creation for ProductionOFBatchNO as a FinishedGood");
			String StrExcelPath = ApplicationVariables.MasterExcelPath;
		    String StrSheetName = "Products";
		    int RowNumber = 33;
		    String ProductName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
			String ProductCode = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,1);
			String ProductType = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,2);
			String CategoryName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,3);
		    String Unit = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,4);
			String ManagedBy = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,5);
			String BatchNum = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,6);
			String SerialNum = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,7);
			String MaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,8);
			String UnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,9);
			String ProcurementMethod = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,10);
			String NotAllowNegativeStock = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,11);
			String PurchaseMaxRetailPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,12);
			String PurchaseUnitPrice = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,13);
            refProducts.verify_Product_Creation_MappedBy_BatchANDSerialNumber(NotAllowNegativeStock,ProductName, ProductCode, ProductType, CategoryName, Unit,ProcurementMethod, ManagedBy, BatchNum, SerialNum, MaxRetailPrice, UnitPrice,PurchaseMaxRetailPrice,PurchaseUnitPrice);
			boolean result = refProducts.Verify_NewProductCreation_SaveorNot(ProductName);
			Assert.assertTrue(result);
			fnWriteSteps("Pass", "Product Creation for ProductionOFBatchNO has been Created & Saved" );
			GenericMethods.fnEndTestCase();
			
		}
		
		@Test 
		public void fnDeleteProduct() {
			GenericMethods.fnStartTestCase("Verify DeleteProduct Feature");
			String StrExcelPath = ApplicationVariables.MasterExcelPath;
	        String StrSheetName = "Products";
	        int RowNumber = 8;
	        String ProductName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	        refProducts.fnVerifyProductDelete(ProductName);
	    	boolean result = refProducts.Verify_ProductDelete_SaveorNot(ProductName);
	    	Assert.assertTrue(result);
	    	fnWriteSteps("pass", "Product has been Deleted");
	    	GenericMethods.fnEndTestCase();
		}
		
		@Test 
		public void fnDeleteActive_Product() {
			GenericMethods.fnStartTestCase("Verify Delete Active_Product Feature");
			String StrExcelPath = ApplicationVariables.MasterExcelPath;
	        String StrSheetName = "Products";
	        int RowNumber = 1;
	        String ProductName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	        refProducts.fnVerifyProductDelete(ProductName);
	    	boolean result = refProducts.Verify_ProductDelete_SaveorNot(ProductName);
	    	Assert.assertTrue(result);
	    	fnWriteSteps("pass", "Active_Product has been Deleted");
	    	GenericMethods.fnEndTestCase();
		}
		@Test 
		public void fnDeleteInActive_Product() {
			GenericMethods.fnStartTestCase("Verify Delete InActive_Product Feature");
			String StrExcelPath = ApplicationVariables.MasterExcelPath;
	        String StrSheetName = "Products";
	        int RowNumber = 2;
	        String ProductName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	        refProducts.fnVerifyProductDelete(ProductName);
	    	boolean result = refProducts.Verify_ProductDelete_SaveorNot(ProductName);
	    	Assert.assertTrue(result);
	    	fnWriteSteps("pass", "InActive_Product has been Deleted");
	    	GenericMethods.fnEndTestCase();
		}
		@Test 
		public void fnDelete_Product_for_WithoutInternet() {
			GenericMethods.fnStartTestCase("Verify Delete Product Feature for withoutInternet");
			String StrExcelPath = ApplicationVariables.MasterExcelPath;
	        String StrSheetName = "Products";
	        int RowNumber = 5;
	        String ProductName = ExcelUtils.fnGetExcelCellValue(StrExcelPath, StrSheetName, RowNumber,0);
	        refProducts.fnVerifyProductDelete(ProductName);
	        refProducts.click_On_Yes_Button();
	    	fnWriteSteps("pass", "Product not Deleted");
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
			GenericMethods.fnwait(2);
			refLogin.ClickCloseButton();
			fnWriteSteps("Pass", "Application Close Successfully");
			GenericMethods.fnEndTestCase();
		}

}
