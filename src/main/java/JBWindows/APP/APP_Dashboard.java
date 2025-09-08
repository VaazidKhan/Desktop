package JBWindows.APP;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import JBWindows.CRM.CRM_CustomerMaster;
import JBWindows.FRM.FRM_OperatingExpenses;
import JBWindows.INV.INV_ProductView;
import JBWindows.SAL.SAL_PointOfSales;
import commonClass.BaseClass;
import commonClass.GenericMethods;
import io.appium.java_client.windows.WindowsDriver;

public class APP_Dashboard extends BaseClass {
	
    private WindowsDriver<WebElement> driver;
    private WebDriverWait wait;

	// Header elements
	@FindBy(id = "lblUserName")
	WebElement LoginUserDetails;
	@FindBy(id = "lblLoginlbl")
	WebElement LoginTimeLabel;
	@FindBy(id = "lblLogingTime")
	WebElement LoginTimeDetails;
	@FindBy(id = "btnExit")
	WebElement btnLogout;
	@FindBy(id = "btnBack")
	WebElement btnMinimize;
	@FindBy(name = "Dashboard")
	WebElement PageName;
	@FindBy(id = "picCreatePurchaseInvoice")
	WebElement btnCreatePurchase;

	// JustBelow header panel elements
	@FindBy(id = "picSearch")
	WebElement txtSearch;
	@FindBy(id = "btnSearch")
	WebElement btnSearch;
	@FindBy(id = "DtFromDate")
	WebElement FromDate;
	@FindBy(id = "DtTodate")
	WebElement Todate;

	// CreateNew Box elements
	@FindBy(id = "picCustomer")
	WebElement CustomerPage;
	@FindBy(id = "picProduct")
	WebElement ProductPage;
	@FindBy(id = "picInventory")
	WebElement InventoryPage;
	@FindBy(id = "picExpence")
	WebElement ExpencePage;
	@FindBy(id = "picCreateBill")
	WebElement btnCreateBill;
	@FindBy(id = "picCreateOrder")
	WebElement btnCreateOrder;
	@FindBy(id = "picCreateQuotation")
	WebElement btnCreateQuotation;

	// Other Elements
	@FindBy(id = "appTitleBar1")
	WebElement DashBoard_TitleBar;
	@FindBy(id = "appDashboard1")
	WebElement Dashboard;
	@FindBy(id = "appStatusBar1")
	WebElement Dashboard_StatusBar;
	
	By menuLocator = By.xpath("//Button[@AutomationId='btnMenu']");

    @FindBy (name ="Logout")
    private WebElement logoutBtn;
    @FindBy (xpath ="//*[@AutomationId='btnYes']")
    private WebElement btnYes;
    @FindBy (xpath ="//*[@AutomationId='CloseButton']")
    private WebElement closeBtn;
    
    @FindBy(xpath = "//*[@Name = Menu']")
    private WebElement menuName;

	// Initialization of WebElement
	public APP_Dashboard(WindowsDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
	}

	// Actions
	public void activatePage() {
		PageName.click();
	}

	public boolean fnVerifyDashbaordPage() {
		boolean status;
		if (PageName.isDisplayed()) {
			status = true;
		} else {
			status = false;
		}
		return status;
	}

	public CRM_CustomerMaster ClickCustomerPageButton() {
	    CustomerPage.click();
	    return new CRM_CustomerMaster();
	}

	public INV_ProductView ClickProductPageButton() {
	    ProductPage.click();
	    return new INV_ProductView();
	}

	public FRM_OperatingExpenses ClickInventoryPageButton() {
	    InventoryPage.click();
	    return new FRM_OperatingExpenses();
	}

	public FRM_OperatingExpenses ClickExpencePageButton() {
	    ExpencePage.click();
	    return new FRM_OperatingExpenses();
	}

	public SAL_PointOfSales ClickBillingPageButton() {
	    btnCreateBill.click();
	    return new SAL_PointOfSales();
	}

	public SAL_PointOfSales ClickOrderPageButton() {
	    btnCreateOrder.click();
	    return new SAL_PointOfSales();
	}

	public SAL_PointOfSales ClickQuotationPageButton() {
	    btnCreateQuotation.click();
	    return new SAL_PointOfSales();
	}



	// Element Presence Verification
	public void fnVerifyProductPageButtonPresence() {
		if (ProductPage.isDisplayed()) {
			fnWriteSteps("Pass", "Product page button is present");
		} else {
			fnWriteSteps("Fail", "Product page button is not present");
		}
	}

	public void fnVerifyCustomersPageButtonPresence() {
		if (CustomerPage.isDisplayed()) {
			fnWriteSteps("Pass", "Customer page button is present");
		} else {
			fnWriteSteps("Fail", "Customer page button is not present");
		}
	}

	public void fnVerifyInventoryPageButtonPresence() {
		if (InventoryPage.isDisplayed()) {
			fnWriteSteps("Pass", "Inventory page button is present");
		} else {
			fnWriteSteps("Fail", "Inventory page button is not present");
		}
	}

	public void fnVerifyExpensePageButtonPresence() {
		if (ExpencePage.isDisplayed()) {
			fnWriteSteps("Pass", "Expense page button is present");
		} else {
			fnWriteSteps("Fail", "Expense page button is not present");
		}
	}

	public void fnVerifyCreateBillButtonPresence() {
		if (btnCreateBill.isDisplayed()) {
			fnWriteSteps("Pass", "Create Bill button is present");
		} else {
			fnWriteSteps("Fail", "Create Bill button is not present");
		}
	}

	public void fnVerifyCreateEstimationButtonPresence() {
		if (btnCreateQuotation.isDisplayed()) {
			fnWriteSteps("Pass", "Create Estimation button is present");
		} else {
			fnWriteSteps("Fail", "Create Estimation button is not present");
		}
	}

	public void fnVerifyCreateOrderButtonPresence() {
		if (btnCreateOrder.isDisplayed()) {
			fnWriteSteps("Pass", "Create Order button is present");
		} else {
			fnWriteSteps("Fail", "Create Order button is not present");
		}
	}

	public void fnVerifySearchfieldPresence() {
		if (txtSearch.isDisplayed()) {
			fnWriteSteps("Pass", "Search Box is present");
		} else {
			fnWriteSteps("Fail", "Search Box is not present");
		}
	}

	public void fnVerifySearchbuttonPresence() {
		if (btnSearch.isDisplayed()) {
			fnWriteSteps("Pass", "Search button is present");
		} else {
			fnWriteSteps("Fail", "Search button is not present");
		}
	}

	public void fnVerifyFromDateFieldPresence() {
		if (FromDate.isDisplayed()) {
			fnWriteSteps("Pass", "From Date field is present");
		} else {
			fnWriteSteps("Fail", "From Date field is not present");
		}
	}

	public void fnVerifyToDateFieldPresence() {
		if (Todate.isDisplayed()) {
			fnWriteSteps("Pass", "To Date field is present");
		} else {
			fnWriteSteps("Fail", "To Date field is not present");
		}
	}

	public void fnVerifyLogoutButtonPresence() {
		if (btnLogout.isDisplayed()) {
			fnWriteSteps("Pass", "Logout button is present");
		} else {
			fnWriteSteps("Fail", "Logout button is not present");
		}
	}


	public void fnVerifyMinimizeButtonPresence() {
		if (btnMinimize.isDisplayed()) {
			fnWriteSteps("Pass", "Minimize button is present");
		} else {
			fnWriteSteps("Fail", "Minimize button is not present");
		}
	}

	public void click_Purchase_Page_Button() {
		btnCreatePurchase.click();
	}


	public APP_Dashboard clickMenuBtn() {
	    By menuLocator = By.xpath("//Button[@AutomationId='btnMenu']");

	    try {
	        for (int attempt = 1; attempt <= 3; attempt++) {
	            try {
	                // ✅ Always switch to the active window (HWND can change)
	                for (String handle : driver.getWindowHandles()) {
	                    driver.switchTo().window(handle);
	                }

	                fnWriteSteps("INFO", "Looking for Menu button (attempt " + attempt + ")");
	                List<WebElement> menuList = driver.findElements(menuLocator);
	                fnWriteSteps("INFO", "Menu button count found: " + menuList.size());

	                if (menuList.isEmpty()) {
	                    GenericMethods.fnwait(2); // wait and retry
	                    continue;
	                }

	                WebElement menuBtn = menuList.get(0);

	                try {
	                    menuBtn.click();
	                } catch (Exception ex1) {
	                    fnWriteSteps("WARN", "Normal click failed, trying Actions");
	                    try {
	                        new Actions(driver).moveToElement(menuBtn).click().perform();
	                    } catch (Exception ex2) {
	                        fnWriteSteps("WARN", "Actions click failed, trying InvokePattern");
	                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menuBtn);
	                    }
	                }

	                fnWriteSteps("PASS", "Clicked Menu button");
	                return this;

	            } catch (Exception ex) {
	                fnWriteSteps("WARN", "Retry failed: " + ex.getMessage());
	                GenericMethods.fnwait(2);
	            }
	        }

	        throw new RuntimeException("Menu button not found after retries");

	    } catch (Exception e) {
	        fnWriteSteps("FAIL", "Failed to click menu button - " + e.getMessage());
	        throw new RuntimeException("Menu button not found or not clickable", e);
	    }
	}


    public APP_Dashboard clickLogoutBtn() {
        try {
            WebElement logOut = wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
            fnWriteSteps("INFO", "Clicking Logout button");
            logOut.click();
            fnWriteSteps("PASS", "Clicked Logout button");

            WebElement yesBtn = wait.until(ExpectedConditions.elementToBeClickable(btnYes));
            fnWriteSteps("INFO", "Confirming logout");
            yesBtn.click();
            fnWriteSteps("PASS", "Logout Confirmed");

        } catch (Exception e) {
            fnWriteSteps("FAIL", "Failed to click Logout button");
            throw e;
        }
        return this;
    }


    public APP_Dashboard logout() {
        try {
            clickMenuBtn();
            clickLogoutBtn();
        } catch (Exception e) {
            fnWriteSteps("FAIL", "❌ Dashboard not loaded, cannot logout: " + e.getMessage());
            throw new RuntimeException("Logout failed", e);
        }
        return this;
    }

    
    public APP_Dashboard logoutwithoutmenu() {
    	 try {
            closeBtn.click();
         } catch (Exception e) {
         	fnWriteSteps("FAIL", "❌ Dashboard not loaded, cannot logout");
         	Assert.fail();
         }
         return this;
    }
    
    
}
