package JBWindows.SYS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import JBWindows.APP.APP_Dashboard;
import JBWindows.SAL.SAL_PointOfSales;
import commonClass.BaseClass;
import io.appium.java_client.windows.WindowsDriver;

public class MessageBoxEffia extends BaseClass {

    private WindowsDriver<WebElement> driver;
    private WebDriverWait wait;

    @FindBy(id = "picLogo") private WebElement pageName;
    @FindBy(id = "lblMessage") private WebElement lblMessage;
    @FindBy(id = "btnOk") private WebElement btnOk;
    @FindBy(id = "btnCancel") private WebElement btnCancel;
    @FindBy(id = "lblHeader") private WebElement popupHeader;

    // Constructor
    public MessageBoxEffia(WindowsDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    // Operations
    public void activatePage() {
        pageName.click();
    }

    public Login ExitApplication_Yes() {
        btnOk.click();
        return new Login(driver);
    }

    public SAL_PointOfSales clickOkButton() {
        pageName.click();
        btnOk.click();
        return new SAL_PointOfSales(); // ✅ pass driver instead of no-arg
    }

    public APP_Dashboard ExitApplication_No() {
        btnCancel.click();
        return new APP_Dashboard(driver);
    }

    public void clickCancelButton() {
        btnCancel.click();
    }

    public boolean fnVerifyInvalidCredentialEntered() {
        return pageName.isDisplayed();
    }

    public void ClickOkButton() {
        btnOk.click();
    }

    // Utility to get message text
    private String getMessageText() {
        return lblMessage.getAttribute("Name");
    }

    public String fnGetLabelMessage() {
        return getMessageText();
    }

    public String fnGetEstimationNo() {
        String[] wordList = getMessageText().split(":");
        return wordList[1].substring(wordList[1].indexOf("EST/"));
    }

    public String fnGetOrderNo() {
        String[] wordList = getMessageText().split(":");
        return wordList[1].substring(wordList[1].indexOf("ORD/"));
    }

    public String fnGetSalesInvoiceNo() {
        String[] wordList = getMessageText().split(":");
        return wordList[1].substring(wordList[1].indexOf("INV/"));
    }

    public String fnGetPurchaseInvoiceNo() {
        String[] wordList = getMessageText().split(":");
        return wordList[1].substring(wordList[1].indexOf("PUR/"));
    }
}
