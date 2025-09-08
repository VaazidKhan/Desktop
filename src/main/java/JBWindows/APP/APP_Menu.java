package JBWindows.APP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonClass.BaseClass;
import commonClass.GenericMethods;
import io.appium.java_client.windows.WindowsDriver;

public class APP_Menu extends BaseClass {
	
    private WindowsDriver driver;
    private WebDriverWait wait;

	@FindBy(id = "MenuForm")	WebElement pageName;
	@FindBy(id = "picHome")	WebElement picHome;
	@FindBy(id = "lblCompanyName")	WebElement lblCompanyName;
	@FindBy(id = "lblHome")	WebElement lblHome;
	
	
	@FindBy(xpath = "//*[@AutomationId='Thumb']")	WebElement BtnMenu;
	@FindBy(id = "txtMenuSearch")	WebElement SearchBox;
	@FindBy(id = "picHome")	WebElement BtnSearch;
	//@FindBy(name = "TRANSACTIONS")	WebElement Transactions;
	@FindBy(xpath = "(//*[@AutomationId='ExpanderButton'])[1]")	WebElement Transactions;
	@FindBy(name="Product Categories") WebElement ProductCategories;
	@FindBy(name="Agents") WebElement Agents;
	@FindBy(name="Product Brands") WebElement ProductBrands;

	
	
	@FindBy(name = "Invoices")
	private WebElement Invoices;

	public APP_Menu(WindowsDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
	}
	
	
	
	public void moveToMenuHome() {
		new Actions(driver).moveToElement(Invoices).perform();
	}
	
	public void scrollBar() {
		BtnMenu.click();
	}
	
	
	
	
	
	
	//--------------------------------------------------------

	public void activatePage() {
		pageName.click();
	}

	public void clickSearchButton() {
		BtnSearch.click();
	}
public void click_On_Home() {
	driver.findElement(By.id("lblUserName")).click();
}
	public void OpenPage(String PageName) {
		//moveToMenuHome();
		
		switch (PageName.toLowerCase().trim()) {
		// Transactions - Retail - Menu items
		case "invoicing":
			SearchBox.sendKeys("SYS_WIN_Billing");
			clickSearchButton();
			break;
		case "estimation":
			SearchBox.sendKeys("SYS_WIN_Estimation");
			clickSearchButton();
			break;
		case "order":
			SearchBox.sendKeys("SYS_WIN_Order");
			clickSearchButton();
			break;
		case "delivery list":
			SearchBox.sendKeys("SYS_WIN_DeliveryList");
			clickSearchButton();
			break;
		case "invoice history":
			SearchBox.sendKeys("SYS_WIN_SalesInvoices");
			clickSearchButton();
			break;
		case "return history":
			SearchBox.sendKeys("SYS_WIN_ReturnInwards");
			clickSearchButton();
			break;
		case "order history":
			SearchBox.sendKeys("SYS_WIN_SalesOrders");
			clickSearchButton();
			break;
		case "estimation history":
			SearchBox.sendKeys("SYS_WIN_Quotations");
			clickSearchButton();
			break;
		case "inventory adjustments":
			SearchBox.sendKeys("SYS_WIN_InventoryEntry");
			clickSearchButton();
			break;
		case "goods received":
			SearchBox.sendKeys("SYS_WIN_GRN");
			clickSearchButton();
			break;
		case "purchase invoices":
			SearchBox.sendKeys("SYS_WIN_PurchaseInvoice");
			clickSearchButton();
			break;
		case "expenses":
			SearchBox.sendKeys("SYS_WIN_OperatingExpenses");
			clickSearchButton();
			break;
		case "customer feedback":
			SearchBox.sendKeys("SYS_WIN_Feedback");
			clickSearchButton();
			break;
		case "production":
			SearchBox.sendKeys("SYS_WIN_Productions");
			clickSearchButton();
			break;
		case "customer promotions":
			SearchBox.sendKeys("SYS_WIN_CustomerPromotions");
			clickSearchButton();
			break;
		// Transactions - Restaurant- Menu items (Additional)
		case "kitchen order ticket":
			SearchBox.sendKeys("SYS_WIN_KitchenOrderTicket");
			clickSearchButton();
			break;
		case "customer order queue":
			SearchBox.sendKeys("SYS_WIN_CustomerOrderQueue");
			clickSearchButton();
			break;

		// Masters - Retail Menu items
		case "product categories":
		    GenericMethods.fn_ConditionalWaitForElement(Transactions, 30);
			GenericMethods.moveAndClick(Transactions);
			GenericMethods.fn_ConditionalWaitForElement(ProductCategories, 30);
			GenericMethods.moveAndClick(ProductCategories);
			break;
		case "product brands":
			GenericMethods.fn_ConditionalWaitForElement(Transactions, 30);
			GenericMethods.moveAndClick(Transactions);
			GenericMethods.fn_ConditionalWaitForElement(ProductBrands, 30);
			GenericMethods.moveAndClick(ProductBrands);
			break;
		case "products":
			SearchBox.sendKeys("SYS_WIN_Products");
			clickSearchButton();
			break;
		case "discount rules":
			SearchBox.sendKeys("SYS_WIN_DiscountRule");
			clickSearchButton();
			break;
		case "tax groups":
			SearchBox.sendKeys("SYS_WIN_TaxGroup");
			clickSearchButton();
			break;
		case "tax rates":
			SearchBox.sendKeys("SYS_WIN_TaxRate");
			clickSearchButton();
			break;
		case "units":
			SearchBox.sendKeys("SYS_WIN_MeasurementUnits");
			clickSearchButton();
			break;
		case "customers":
			SearchBox.sendKeys("SYS_WIN_Customers");
			clickSearchButton();
			break;
		case "suppliers":
			SearchBox.sendKeys("SYS_WIN_Suppliers");
			clickSearchButton();
			break;
		case "agents":
			GenericMethods.fn_ConditionalWaitForElement(Transactions, 30);
			GenericMethods.moveAndClick(Transactions);
			GenericMethods.fn_ConditionalWaitForElement(Agents, 30);
			GenericMethods.moveAndClick(Agents);
			break;
		case "departments":
			SearchBox.sendKeys("SYS_WIN_Departments");
			clickSearchButton();
			break;
		case "import data":
			SearchBox.sendKeys("SYS_WIN_ImportData");
			clickSearchButton();
			break;

		// Name Validation pending from Restaurant LITE
		case "loyalty types":
			SearchBox.sendKeys("SYS_WIN_LoyaltyTypes");
			clickSearchButton();
			break;
		case "table types":
			SearchBox.sendKeys("SYS_WIN_TableTypes");
			clickSearchButton();
			break;
		case "tables":
			SearchBox.sendKeys("SYS_WIN_Tables");
			clickSearchButton();
			break;
		case "instructions":
			SearchBox.sendKeys("SYS_WIN_Instructions");
			clickSearchButton();
			break;
		case "bin locations":
			SearchBox.sendKeys("SYS_WIN_BinLocations");
			clickSearchButton();
			break;
		case "segments":
			SearchBox.sendKeys("SYS_WIN_CustomerSegments");
			clickSearchButton();
			break;

		// Settings menu list
		case "business details":
			SearchBox.sendKeys("SYS_WIN_CompanyDetails");
			clickSearchButton();
			break;
		case "application settings":
			SearchBox.sendKeys("SYS_WIN_AppSetting");
			clickSearchButton();
			break;
		case "users":
			SearchBox.sendKeys("SYS_WIN_Users");
			clickSearchButton();
			break;
		case "diagnostics":
			SearchBox.sendKeys("SYS_WIN_DataBackup");
			clickSearchButton();
			break;

		// Support menu list
		case "my subscription":
			SearchBox.sendKeys("SYS_WIN_MyAccount");
			clickSearchButton();
			break;
		case "feedback":
			SearchBox.sendKeys("SYS_WIN_AppFeedback");
			clickSearchButton();
			break;
		case "help":
			SearchBox.sendKeys("SYS_WIN_Help");
			clickSearchButton();
			break;

		// Reports
		case "order summary":
			SearchBox.sendKeys("SYS_WIN_Ordersummary");
			clickSearchButton();
			break;
		case "sales summary":
			SearchBox.sendKeys("SYS_WIN_Salessummary");
			clickSearchButton();
			break;
		case "hourly sales":
			SearchBox.sendKeys("SYS_WIN_HourlySales");
			clickSearchButton();
			break;
		case "sales analysis":
			SearchBox.sendKeys("SYS_WIN_SalesAnalysis");
			clickSearchButton();
			break;
		case "stock in hand":
			SearchBox.sendKeys("SYS_WIN_Stockinhand");
			clickSearchButton();
			break;
		case "end of day":
			SearchBox.sendKeys("SYS_WIN_Endofday");
			clickSearchButton();
			break;
		case "customer ledger":
			SearchBox.sendKeys("SYS_WIN_CustomerLedger");
			clickSearchButton();
			break;
		case "available wallet amount by customer":
			SearchBox.sendKeys("SYS_WIN_Availableloyaltypoints");
			clickSearchButton();
			break;
		case "daily business control":
			SearchBox.sendKeys("SYS_WIN_DailyBusinessControl");
			clickSearchButton();
			break;
		case "daily sales by card payment":
			SearchBox.sendKeys("SYS_WIN_Dailysalesbycard");
			clickSearchButton();
			break;
		case "daily sales by cash payment":
			SearchBox.sendKeys("SYS_WIN_Dailysalesbycash");
			clickSearchButton();
			break;
		case "detailed sales invoice":
			SearchBox.sendKeys("SYS_WIN_DetailedInvoice");
			clickSearchButton();
			break;
		case "detailed return order":
			SearchBox.sendKeys("SYS_WIN_Detailedreturnreport");
			clickSearchButton();
			break;
		case "detailed sales order":
			SearchBox.sendKeys("SYS_WIN_Detailedsalesorder");
			clickSearchButton();
			break;
		case "exchange invoice":
			SearchBox.sendKeys("SYS_WIN_ExchangeInvoice");
			clickSearchButton();
			break;
		case "order analysis":
			SearchBox.sendKeys("SYS_WIN_OrderAnalysis");
			clickSearchButton();
			break;
		case "return invoice":
			SearchBox.sendKeys("SYS_WIN_ReturnInvoice");
			clickSearchButton();
			break;
		case "total sales by category":
			SearchBox.sendKeys("SYS_WIN_Salesbycategory");
			clickSearchButton();
			break;
		case "sales by order type":
			SearchBox.sendKeys("SYS_WIN_Salesbyordertypes");
			clickSearchButton();
			break;
		case "sales by product quantity":
			SearchBox.sendKeys("SYS_WIN_Salesbyproductquantity");
			clickSearchButton();
			break;
		case "complimentary sales by quantity":
			SearchBox.sendKeys("SYS_WIN_Salesofcomplimentary");
			clickSearchButton();
			break;
		case "sales summary by salesperson":
			SearchBox.sendKeys("SYS_WIN_Salessummerybysalesperson");
			clickSearchButton();
			break;
		case "products sold by salesperson":
			SearchBox.sendKeys("SYS_WIN_TopSeller");
			clickSearchButton();
			break;
		case "detailed purchase invoice":
			SearchBox.sendKeys("SYS_WIN_DetailedPurchaseInvoice");
			clickSearchButton();
			break;
		case "gst dashboard":
			SearchBox.sendKeys("SYS_WIN_GSTDashboard");
			clickSearchButton();
			break;
		case "sales analysis by table no.":
			SearchBox.sendKeys("SYS_WIN_Salesanalysisbytableno");
			clickSearchButton();
			break;
		case "kot analysis":
			SearchBox.sendKeys("SYS_WIN_KitchenOrderAnalysis");
			clickSearchButton();
			break;
		case "average kot preparation time":
			SearchBox.sendKeys("SYS_WIN_AverageKOTpreparationtime");
			clickSearchButton();
			break;
		case "sales order by table type":
			SearchBox.sendKeys("SYS_WIN_Salesorderbytabletypes");
			clickSearchButton();
			break;
		case "sales by table type":
			SearchBox.sendKeys("SYS_WIN_Salesbytabletypes");
			clickSearchButton();
			break;
		case "cancelled order analysis":
			SearchBox.sendKeys("SYS_WIN_Cancelledorderanalysis");
			clickSearchButton();
			break;

		}

	}

}
