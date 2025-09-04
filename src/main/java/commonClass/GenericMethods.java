package commonClass;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.windows.WindowsDriver;


public class GenericMethods extends BaseClass {
	
	static int timeoutInSeconds = Integer.parseInt(ConfigReader.getProperty("timeoutInSeconds"));



	public void fnOnButtonClick(String elementName) {
		driver.findElement(By.id(elementName)).click();
	}

	public void fnSetTextBoxValue(String elementName, String elementValue) {
		driver.findElement(By.id(elementName)).sendKeys(elementValue);
	}

	public String fnGetTextBoxValue(String elementName, String elementValue) {
		return driver.findElement(By.id(elementName)).getText();
	}

	public static void fnSetDateTimeValue(String elementName, Date elementValue) {
		driver.findElement(By.id(elementName)).sendKeys(String.valueOf(elementValue));
	}

	public static void fnSelectDropdownValue(String elementname, String dropdownValue) {
		Select dropdown = new Select(driver.findElement(By.id(elementname)));
		dropdown.selectByVisibleText(dropdownValue);
	}

	public static void fnCheckBoxClick(String elementName) {
		driver.findElement(By.id(elementName)).click();
	}

	public static boolean fnGetCheckBoxValue(String elementName) {
		return driver.findElement(By.id(elementName)).isSelected();
	}


 
 public static WebElement waitForElement(By locator) {
     WindowsDriver<WebElement> driver = ThreadLocalDriver.getDriver();
     if (driver == null) {
         LogClass.error("Driver is null, cannot wait for element");
         return null;
     }
     
     try {
         WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
         return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
     } catch (Exception e) {
         LogClass.error("Element not found: " + locator.toString());
         return null;
     }
 }

    
    public static void fnStartTestCase(String testCaseName) {
        LogClass.info("======= Starting Test Case: " + testCaseName + " =======");
    }
    
    public static void fnEndTestCase() {
        LogClass.info("======= Ending Test Case =======");
    }
    
    public static String takeScreenshot(String testName) {
        WindowsDriver<WebElement> driver = ThreadLocalDriver.getDriver();
        if (driver == null) {
            LogClass.warn("Driver is null, cannot take screenshot");
            return null;
        }

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String dateName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String destDir = System.getProperty("user.dir") + "/Reports/TestScreenshots/";
            String destPath = destDir + testName + "_" + dateName + ".png";

            Files.createDirectories(new File(destDir).toPath());
            Files.copy(src.toPath(), new File(destPath).toPath());
            
            LogClass.info("Screenshot saved: " + destPath);
            return destPath;
        } catch (IOException e) {
            LogClass.error("Failed to take screenshot: " + e.getMessage());
            return null;
        }
    }


	/*
	 * ConvertIntegerInToFloatAndString
	 * 
	 * @parameter: Integer number & afterDecimalDigitCount
	 */
	public static String fnFloatFormatter(String strStringNumber, int afterDecimalDigitCount) {
		String x = strStringNumber;
		float f = Float.parseFloat(x);
		NumberFormat floatformatter = NumberFormat.getInstance();
		floatformatter.setMaximumFractionDigits(afterDecimalDigitCount);
		floatformatter.setMinimumFractionDigits(afterDecimalDigitCount);
		return String.valueOf(floatformatter.format(f));
	}

	/*
	 * Generate Random Number
	 * 
	 * @parameter: Start number to End number (between this random number will
	 * be generated)
	 */
	public static String fnGenRandNumber(int Max, int Min) {
		Random Rand = new Random();
		int randomnumber = Rand.nextInt((Max - Min) + 1) + Min;
		return String.valueOf(randomnumber);
	}

	/* @parameter - Time in seconds */
	public static void fnwait(int InputTimeInSeconds) {
		int GetTimeInMilliSeconds = InputTimeInSeconds * 1000;
		try {
			Thread.sleep(GetTimeInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Perform Explicit wait based on the locator value
	 * 
	 * @parameter: Locator name & Value
	 */
	public static WebElement fnExplicitWait(String WaitLocatorNameNew, String WaitLoactorValueNew) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement RefElementNew = null;

		switch (WaitLocatorNameNew.toUpperCase().trim()) {
		case "ID":
			RefElementNew = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(WaitLoactorValueNew)));
			break;
		case "NAME":
			RefElementNew = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(WaitLoactorValueNew)));
			break;
		case "CLASSNAME":
			RefElementNew = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.className(WaitLoactorValueNew)));
			break;
		case "XPATH":
			RefElementNew = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WaitLoactorValueNew)));
			break;
		case "LINKTEXT":
			RefElementNew = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(WaitLoactorValueNew)));
			break;
		case "PARTIALLINKTEXT":
			RefElementNew = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(WaitLoactorValueNew)));
			break;
		case "TAGNAME":
			RefElementNew = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(WaitLoactorValueNew)));
			break;
		case "CSSSELECTOR":
			RefElementNew = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(WaitLoactorValueNew)));
			break;
		}
		return RefElementNew;
	}

	/*
	 * Perform double click on element
	 * 
	 * @parameter: Element name, Wait time, Windows or Web
	 */
    public static void fn_ConditionalWaitForElement(WebElement ElementName, int intWaitTimeInSeconds) {
        WebDriverWait wait;
            wait = new WebDriverWait(driver, intWaitTimeInSeconds);
            wait.until(ExpectedConditions.visibilityOf(ElementName));
            
    }

	/*
	 * Perform double click on element
	 * 
	 * @parameter: Element name, Windows or Web
	 */
	public static void DoubleClickAction(String strWindowORWeb, WebElement element) {
		switch (strWindowORWeb.toLowerCase().trim()) {
		case "window":
			Actions Win_Action = new Actions(driver).doubleClick(element);
			Win_Action.build().perform();
			break;
		case "web":
			Actions Web_Action = new Actions(driver).doubleClick(element);
			Web_Action.build().perform();
			break;
		}
	}

	/*
	 * public static Date fnGetDateTimeValue(String elementName, String
	 * elementValue) throws java.text.ParseException { Date dtValue = null;
	 * dtValue =
	 * fnformatPrintDateTimeObject(driver.findElement(By.id(elementName)).
	 * getText()) ; return dtValue; }
	 */

	public static Date fnformatPrintDateTimeObject(String date) throws java.text.ParseException {
		SimpleDateFormat formatter;
		Date returnDate = new Date(0);
		Locale locale = Locale.ENGLISH;


		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(1900, Calendar.JANUARY, 1);
			date = Long.toString(calendar.getTimeInMillis());
		}
		formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss", locale);
		returnDate = (Date) formatter.parse(date);

		return returnDate;
	}

	public static String fnGetCurrentDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
		Date date = new Date();
		String formatdate= dateFormat.format(date).replace("/","_").replace(" ","_").replace(":","_");
	
		return formatdate;
		
	}
	
	/**
     * Generic method to set value in a Windows text box
     * Supports multiple identification strategies: ID, Name, AutomationId, XPath
     * 
     * @param identifierType Type of identifier ("id", "name", "automationid", "xpath")
     * @param identifierValue Value of the identifier
     * @param value Value to set in the text box
     * @param timeoutInSeconds Maximum wait time in seconds
     * @return true if successful, false otherwise
     */
    public static boolean windows_Set_TextBoxValue(String identifierType, String identifierValue, String value) {
        WindowsDriver<WebElement> driver = ThreadLocalDriver.getDriver();
        if (driver == null) {
            LogClass.error("Driver is null, cannot set text box value");
            return false;
        }
        
        try {
            WebElement textBox = null;
            WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
            
            // Determine locator strategy and find element
            switch (identifierType.toLowerCase()) {
                case "id":
                    textBox = wait.until(ExpectedConditions.elementToBeClickable(By.id(identifierValue)));
                    break;
                case "name":
                    textBox = wait.until(ExpectedConditions.elementToBeClickable(By.name(identifierValue)));
                    break;
                case "automationid":
                    textBox = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[@AutomationId='" + identifierValue + "']")));
                    break;
                case "xpath":
                    textBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(identifierValue)));
                    break;
                default:
                    LogClass.error("Unsupported identifier type: " + identifierType);
                    return false;
            }
            
            if (textBox == null) {
                LogClass.error("Text box not found with " + identifierType + ": " + identifierValue);
                return false;
            }
            
            // Clear existing text using multiple strategies
            textBox.click();
            textBox.sendKeys(Keys.CONTROL + "a");
            textBox.sendKeys(Keys.DELETE);
            textBox.clear();
            
            // Set new value
            textBox.sendKeys(value);
            
            LogClass.info("Set text box value: " + identifierValue + " = " + value);
            fnWriteSteps("PASS", "Set text box value: " + identifierValue + " = " + value);
            
            return true;
            
        } catch (Exception e) {
            LogClass.error("Failed to set text box value for " + identifierType + ": " + identifierValue + 
                          ". Error: " + e.getMessage());
            fnWriteSteps("FAIL", "Failed to set text box value: " + identifierValue);
            return false;
        }
    }


	public static String fnformatPrintDateObject(String date, String strExcelDateFormat)
			throws java.text.ParseException {

		// This object can interpret strings representing dates in the format
		// MM/dd/yyyy
		DateFormat df = new SimpleDateFormat(strExcelDateFormat);

		// Convert from String to Date
		Date startDate = df.parse(date);

		/*
		 * // Print the date, with the default formatting. // Here, the
		 * important thing to note is that the parts of the date // were
		 * correctly interpreted, such as day, month, year etc.
		 * System.out.println("Date, with the default formatting: " +
		 * startDate);
		 */

		/*
		 * // Once converted to a Date object, you can convert // back to a
		 * String using any desired format. String startDateString1 =
		 * df.format(startDate); System.out.println(
		 * "Date in format MM/dd/yyyy: " + startDateString1);
		 */

		// Converting to String again, using an alternative format
		DateFormat df2 = new SimpleDateFormat("dd-MMM-yy");
		String startDateString2 = df2.format(startDate);
		// System.out.println("Date in format dd/MM/yyyy: " + startDateString2);

		return startDateString2;

	}

	public static String fnformatPrintDateTimeObject(String date, String strExcelDateFormat) throws ParseException {

		// This object can interpret strings representing dates in the format
		// MM/dd/yyyy
		DateFormat df = new SimpleDateFormat(strExcelDateFormat);

		// Convert from String to Date
		Date startDate = df.parse(date);

		// Converting to String again, using an alternative format
		DateFormat df2 = new SimpleDateFormat("dd-MM-yy hh:mm a");
		String startDateString2 = df2.format(startDate);

		return startDateString2;

	}

	// -----------------------------JavaScript
	// Methods-----------------------------

	public static void fn_WebElement_Highlight(String strWindowORWeb, WebElement element) {
		switch (strWindowORWeb.toLowerCase().trim()) {
		case "window":
			JavascriptExecutor refJS_Win = (JavascriptExecutor) driver;
			refJS_Win.executeScript("arguments[0].setAttribute('style','border: solid 5px red');", element);
			break;
		case "web":
			JavascriptExecutor refJS_Web = (JavascriptExecutor) driver;
			refJS_Web.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
					element);
			break;
		}
	}

	public static void fn_Scroll_Web_Page(WebElement element) {
		fnwait(1);
		JavascriptExecutor refJS = (JavascriptExecutor) driver;
		refJS.executeScript("arguments[0].scrollIntoView();", element);
		fnwait(1);
	}

	// -----------------------------Only for Back
	// Office----------------------------
	public static void fn_SetDropdownBoxValue(WebElement element, String strdropdownValue) {
		fn_Scroll_Web_Page(element);
		if (element.isDisplayed()) {
			if (element.isEnabled()) {
				fn_WebElement_Highlight("Web", element);
				if (strdropdownValue != null) {
					element.click();
					GenericMethods.fnwait(3);
					element.clear();
					GenericMethods.fnwait(7);
					element.sendKeys(strdropdownValue);
					GenericMethods.fnwait(4);
					element.sendKeys(Keys.BACK_SPACE);
					GenericMethods.fnwait(3);
					element.sendKeys(Keys.ARROW_DOWN);
					GenericMethods.fnwait(4);
					element.sendKeys(Keys.RETURN);
					GenericMethods.fnwait(5);
				}
			} else {
				fnWriteSteps("Fail", element + " is not enable on UI");
				TakeScreenshots.fn_take_Screenshot(element + " is not enable");
			}
		} else {
			fnWriteSteps("Fail", element + " is not visible on UI");
			TakeScreenshots.fn_take_Screenshot(element + " is not visible");
		}
	}

	public static void fn_SetTextBoxValue(WebElement element, String strTextFieldValue) {
		
		fn_Scroll_Web_Page(element);
		if (element.isDisplayed()) {
			if (element.isEnabled()) {
				fn_WebElement_Highlight("Web", element);

				
				if (strTextFieldValue != null) {
					GenericMethods.fnwait(2);
					element.click();
					GenericMethods.fnwait(2);
					element.clear();
					GenericMethods.fnwait(2);
					element.sendKeys(strTextFieldValue);
				}
			} else {
				fnWriteSteps("Fail", element + " is not enable on UI");
				TakeScreenshots.fn_take_Screenshot(element + " is not enable");
			}
		} else {
			fnWriteSteps("Fail", element + " is not visible on UI");
			TakeScreenshots.fn_take_Screenshot(element + " is not visible");
		}
	}

	public static void fn_SetDecimalBoxValue(WebElement element, String strDecimalFieldValue) {
		fn_Scroll_Web_Page(element);
		if (element.isDisplayed()) {
			if (element.isEnabled()) {
				fn_WebElement_Highlight("Web", element);
				if (strDecimalFieldValue != null) {
					element.click();
					element.clear();
					GenericMethods.fnwait(1);
					String strDecimalFieldValue_C = GenericMethods.fnFloatFormatter(strDecimalFieldValue, 2);
					element.sendKeys(strDecimalFieldValue_C);
				}
			} else {
				fnWriteSteps("Fail", element + " is not enable on UI");
				TakeScreenshots.fn_take_Screenshot(element + " is not enable");
			}
		} else {
			fnWriteSteps("Fail", element + " is not visible on UI");
			TakeScreenshots.fn_take_Screenshot(element + " is not visible");
		}
	}

	public static void fn_SetActionOnCheckBoxTypeField(WebElement element, String strCheckBoxStatus) {
		fn_Scroll_Web_Page(element);
		if (element.isDisplayed()) {
			if (element.isEnabled()) {
				if (strCheckBoxStatus != null) {
					switch (strCheckBoxStatus.trim().toLowerCase()) {
					case "check":
						if (element.getAttribute("class").contains("Checked")) {
							// no action required as the element default status
							// & user requirement are same.
						} else {
							fn_WebElement_Highlight("Web", element);
							element.click();
						}
						break;
					case "uncheck":
						if (element.getAttribute("class").contains("Unchecked")) {
							// no action required as the element default status
							// & user requirement are same.
						} else {
							fn_WebElement_Highlight("Web", element);
							element.click();
						}
						break;
					}
				}
			} else {
				fnWriteSteps("Fail", element + " is not enable on UI");
				TakeScreenshots.fn_take_Screenshot(element + " is not enable");
			}
		} else {
			fnWriteSteps("Fail", element + " is not visible on UI");
			TakeScreenshots.fn_take_Screenshot(element + " is not visible");
		}
	}

	public static void fn_UploadFile(WebElement element, String strFilePath) {
		fn_Scroll_Web_Page(element);
		if (element.isDisplayed()) {
			if (element.isEnabled()) {
				fn_WebElement_Highlight("Web", element);
				fnwait(2);
				 element.click();
				fnwait(5);
				if (strFilePath != null) {
					System.out.println(strFilePath);
					element.sendKeys(strFilePath);
					fnwait(5);
					element.sendKeys(Keys.ENTER);
					fnwait(5);
				}
			} else {
				fnWriteSteps("Fail", element + " is not enable on UI");
				TakeScreenshots.fn_take_Screenshot(element + " is not enable");
			}
		} else {
			fnWriteSteps("Fail", element + " is not visible on UI");
			TakeScreenshots.fn_take_Screenshot(element + " is not visible");
		}
	}

	public static void fn_SearchRecordFromList(WebElement eleSearchBox, WebElement eleSearchIcon,
			String strSearchKeyword) {
		if (eleSearchBox.isDisplayed()) {
			if (eleSearchBox.isEnabled()) {
				eleSearchBox.click();
				GenericMethods.fnwait(2);
				eleSearchBox.clear();
				GenericMethods.fnwait(10);
				eleSearchBox.sendKeys(strSearchKeyword);
				GenericMethods.fnwait(10);
				if (eleSearchIcon.isDisplayed()) {
					if (eleSearchIcon.isEnabled()) {
						eleSearchIcon.click();
						GenericMethods.fnwait(5);
					} else {
						fnWriteSteps("Fail", eleSearchIcon + " is not enable on UI");
						TakeScreenshots.fn_take_Screenshot(eleSearchIcon + " is not enable");
					}
				} else {
					fnWriteSteps("Fail", eleSearchIcon + " is not enable on UI");
					TakeScreenshots.fn_take_Screenshot(eleSearchIcon + " is not enable");
				}
			} else {
				fnWriteSteps("Fail", eleSearchBox + " is not enable on UI");
				TakeScreenshots.fn_take_Screenshot(eleSearchBox + " is not enable");
			}
		} else {
			fnWriteSteps("Fail", eleSearchBox + " is not enable on UI");
			TakeScreenshots.fn_take_Screenshot(eleSearchBox + " is not enable");
		}
	}

	// Methods to verify field value correctly saved or Not.
	public static void fn_VerifyTextFieldValue(WebElement element, String strExcelValue) {
		fn_Scroll_Web_Page(element);
		if (strExcelValue != null) {
			if (element.isDisplayed()) {
				GenericMethods.fn_WebElement_Highlight("Web", element);
				if (element.getAttribute("value").equals(strExcelValue)) {
					fnWriteSteps("Pass", element + " field value is saved successfully");
				} else {
					fnWriteSteps("Fail", element + " field value is not saved");
					TakeScreenshots.fn_take_Screenshot(element + "Value didn't save successfully");
				}
			} else {
				fnWriteSteps("Fail", element + " is not displayed on UI");
			}
		}
	}

	public static void fn_VerifyCurrencyFieldValue(WebElement element, String strExcelValue) {
		fn_Scroll_Web_Page(element);
		if (strExcelValue != null) {
			if (element.isDisplayed()) {
				GenericMethods.fn_WebElement_Highlight("Web", element);
				if (element.getAttribute("value").substring(1).equals(strExcelValue)) {
					fnWriteSteps("Pass", element + " field value is saved successfully");
				} else {
					fnWriteSteps("Fail", element + " field value is not saved");
					TakeScreenshots.fn_take_Screenshot(element + "Value didn't save successfully");
				}
			} else {
				fnWriteSteps("Fail", element + " is not displayed on UI");
			}
		}
	}

	public static void fn_VerifyDecimalCurrencyFieldValue(WebElement element, String strExcelValue) {
		fn_Scroll_Web_Page(element);
		if (strExcelValue != null) {
			if (element.isDisplayed()) {
				GenericMethods.fn_WebElement_Highlight("Web", element);
				String strExcelValue_C = GenericMethods.fnFloatFormatter(strExcelValue, 2);
				if (element.getAttribute("value").substring(1).equals(strExcelValue_C)) {
					fnWriteSteps("Pass", element + " field value is saved successfully");
				} else {
					fnWriteSteps("Fail", element + " field value is not saved");
					TakeScreenshots.fn_take_Screenshot(element + "Value didn't save successfully");
				}
			} else {
				fnWriteSteps("Fail", element + " is not displayed on UI");
			}
		}
	}

	public static void fn_VerifyDecimalFieldValue(WebElement element, String strExcelValue) {
		fn_Scroll_Web_Page(element);
		if (strExcelValue != null) {
			if (element.isDisplayed()) {
				GenericMethods.fn_WebElement_Highlight("Web", element);
				String strExcelValue_C = GenericMethods.fnFloatFormatter(strExcelValue, 2);
				if (element.getAttribute("value").equals(strExcelValue_C)) {
					fnWriteSteps("Pass", element + " field value is saved successfully");
				} else {
					fnWriteSteps("Fail", element + " field value is not saved");
					TakeScreenshots.fn_take_Screenshot(element + "Value didn't save successfully");
				}
			} else {
				fnWriteSteps("Fail", element + " is not displayed on UI");
			}
		}
	}

	public static void fn_VerifyCheckFieldValue(WebElement element, WebElement element_value, String strExcelValue) {
		fn_Scroll_Web_Page(element);
		if (strExcelValue != null) {
			if (element.isDisplayed()) {
				GenericMethods.fn_WebElement_Highlight("Web", element);
				String CheckBoxValue = element_value.getAttribute("value").toLowerCase().trim();
				switch (CheckBoxValue) {
				case "c":
					if (strExcelValue.toLowerCase().trim().equals("check")) {
						fnWriteSteps("Pass", element + " field value saved successfully");
					} else {
						fnWriteSteps("Fail", element + " field value is not saved successfully");
					}
					break;
				case "u":
					if (strExcelValue.toLowerCase().trim().equals("uncheck")) {
						fnWriteSteps("Pass", element + " field value saved successfully");
					} else {
						fnWriteSteps("Fail", element + " field value is not saved successfully");
					}
					break;
				case "i":
					if (strExcelValue.toLowerCase().trim().equals("uncheck")) {
						fnWriteSteps("Pass", element + " field value saved successfully");
					} else {
						fnWriteSteps("Fail", element + " field value is not saved successfully");
					}
					break;
				}
			} else {
				fnWriteSteps("Fail", element + " is not displayed on UI");
			}
		}
	}

	// Common methods for each web page to search record & perform some action
	public static void fn_Search_And_Edit_Record_From_MasterDataGrid(WebElement eleSearchBox, WebElement eleSearchIcon,
			String strSearchKeyword, String MainTableGrid_Xpath, int intColumnNumberBasedOnSearchKeywordWork) {
		// fn_SearchRecordFromList(eleSearchBox, eleSearchIcon,
		// strSearchKeyword);
		String elementMainTableRowID = MainTableGrid_Xpath + "//tr[1]";
		WebElement elementTableGrid = driver.findElement(By.xpath(MainTableGrid_Xpath));
		WebElement elementTableRow = driver.findElement(By.xpath(elementMainTableRowID));
		List<WebElement> arrayTableRow = elementTableGrid.findElements(By.tagName("tr"));
		List<WebElement> arrayTableColumn = elementTableRow.findElements(By.tagName("td"));
		int intRowActionColumnPosition = arrayTableColumn.size();
		for (int RowNum = 1; RowNum <= arrayTableRow.size(); RowNum++) {
			String rowWiseXpathID = MainTableGrid_Xpath + "//tr[" + RowNum + "]//td["
					+ intColumnNumberBasedOnSearchKeywordWork + "]";
			WebElement rowColumnElement = elementTableGrid.findElement(By.xpath(rowWiseXpathID));
			if (rowColumnElement.getText().toLowerCase().equals(strSearchKeyword.toLowerCase().trim())) {
				rowColumnElement.click();
				String rowColumnElementID = MainTableGrid_Xpath + "//tr[" + RowNum + "]//td["
						+ intRowActionColumnPosition + "]//a[1]";
				WebElement btnEdit = elementTableGrid.findElement(By.xpath(rowColumnElementID));
				btnEdit.click();
				GenericMethods.fnwait(10);
			}
		}
	}

	public static void fn_Search_And_Delete_Record_From_MasterDataGrid(WebElement eleSearchBox,
			WebElement eleSearchIcon, String strSearchKeyword, String MainTableGrid_Xpath,
			int intColumnNumberBasedOnSearchKeywordWork) {
		// fn_SearchRecordFromList(eleSearchBox, eleSearchIcon,
		// strSearchKeyword);
		String elementMainTableRowID = MainTableGrid_Xpath + "//tr[1]";
		WebElement elementTableGrid = driver.findElement(By.xpath(MainTableGrid_Xpath));
		WebElement elementTableRow = driver.findElement(By.xpath(elementMainTableRowID));
		List<WebElement> arrayTableRow = elementTableGrid.findElements(By.tagName("tr"));
		List<WebElement> arrayTableColumn = elementTableRow.findElements(By.tagName("td"));

		int intRowActionColumnPosition = arrayTableColumn.size();
		for (int RowNum = 1; RowNum <= arrayTableRow.size(); RowNum++) {
			String rowWiseXpathID = MainTableGrid_Xpath + "//tr[" + RowNum + "]//td["
					+ intColumnNumberBasedOnSearchKeywordWork + "]";
			WebElement rowColumnElement = elementTableGrid.findElement(By.xpath(rowWiseXpathID));
			if (rowColumnElement.getText().toLowerCase().equals(strSearchKeyword.toLowerCase().trim())) {
				rowColumnElement.click();
				String rowColumnElementID = MainTableGrid_Xpath + "//tr[" + RowNum + "]//td["
						+ intRowActionColumnPosition + "]//a[2]";
				WebElement btnDelete = elementTableGrid.findElement(By.xpath(rowColumnElementID));
				btnDelete.click();
				GenericMethods.fnwait(5);
			}
		}
	}

	public static boolean fn_Search_And_Verify_Record_Exist_Or_Not(WebElement eleSearchBox, WebElement eleSearchIcon,
			String strSearchKeyword, String MainTableGrid_Xpath, int intColumnNumberBasedOnSearchKeywordWork) {
		boolean boolRecordExist = false;
		fn_SearchRecordFromList(eleSearchBox, eleSearchIcon, strSearchKeyword);
		WebElement elementTableGrid = driver.findElement(By.xpath(MainTableGrid_Xpath));
		List<WebElement> arrayTableRow = elementTableGrid.findElements(By.tagName("tr"));
		for (int RowNum = 1; RowNum <= arrayTableRow.size(); RowNum++) {
			String rowWiseXpathID = MainTableGrid_Xpath + "//tr[" + RowNum + "]//td["
					+ intColumnNumberBasedOnSearchKeywordWork + "]";
			WebElement rowColumnElement = elementTableGrid.findElement(By.xpath(rowWiseXpathID));
			if (rowColumnElement.getText().toLowerCase().equals(strSearchKeyword.toLowerCase().trim())) {
				rowColumnElement.click();
				boolRecordExist = true;
			}
		}
		return boolRecordExist;
	}

    public static boolean fn_Wait_For_LoadingPanel_Disappear(int intSeconds, By WebElementLocator) {
        WebDriverWait refDisappearWait = new WebDriverWait(driver, intSeconds);
        boolean element = refDisappearWait.until(ExpectedConditions.invisibilityOfElementLocated(WebElementLocator));
        return element;
    }

    public static void fn_ConditionalWaitForElementToDisappear(String strWindowORWeb, String strElementLocatorID,
            int intWaitTimeInSeconds) {
        WebDriverWait wait;
        switch (strWindowORWeb.trim().toLowerCase()) {
        case "windows":
            wait = new WebDriverWait(driver, intWaitTimeInSeconds);
            wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id(strElementLocatorID), "Loading Panel"));
            break;
        }
    }

	// verification is pending
	public static void fn_Search_And_Select_Row_From_MasterDataGrid(WebElement eleSearchBox, WebElement eleSearchIcon,
			String strSearchKeyword, String MainTableGrid_Xpath, int intColumnNumberBasedOnSearchKeywordWork) {

		fn_SearchRecordFromList(eleSearchBox, eleSearchIcon, strSearchKeyword);

		// String elementMainTableRowID = MainTableGrid_Xpath + "//tr[1]";
		WebElement elementTableGrid = driver.findElement(By.xpath(MainTableGrid_Xpath));
		// WebElement elementTableRow =
		// driver.findElement(By.xpath(elementMainTableRowID));
		List<WebElement> arrayTableRow = elementTableGrid.findElements(By.tagName("tr"));
		// List<WebElement> arrayTableColumn =
		// elementTableRow.findElements(By.tagName("td"));

		// int intRowActionColumnPosition = arrayTableColumn.size();
		for (int RowNum = 1; RowNum <= arrayTableRow.size(); RowNum++) {
			String rowWiseXpathID = MainTableGrid_Xpath + "//tr[" + RowNum + "]//td["
					+ intColumnNumberBasedOnSearchKeywordWork + "]";
			WebElement rowColumnElement = elementTableGrid.findElement(By.xpath(rowWiseXpathID));
			if (rowColumnElement.getText().toLowerCase().equals(strSearchKeyword.toLowerCase().trim())) {
				/*
				 * String rowColumnElementID = MainTableGrid_Xpath + "//tr[" +
				 * RowNum + "]//td[" + intRowActionColumnPosition + "]//a[1]";
				 * WebElement btnEdit =
				 * elementTableGrid.findElement(By.xpath(rowColumnElementID));
				 * btnEdit.click();
				 */
				GenericMethods.fnwait(10);
			}
		}
	}


	/*
	 * @purpose: To delete the record by delete icon from master page
	 * 
	 * @Parameter: element
	 */
	public static void fnVerifyMasterRecordDelete(WebElement element) {
		GenericMethods.fnwait(1);
		element.click();
		PointerInfo a1 = MouseInfo.getPointerInfo();
		Point b1 = a1.getLocation();
		GenericMethods.fnwait(1);
		int x1 = (int) b1.getX();
		GenericMethods.fnwait(1);
		int y1 = (int) b1.getY();

		Robot r1;
		try {
			r1 = new Robot();
			r1.mouseMove(x1 + 420, y1 - 200);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		GenericMethods.fnwait(1);
		Actions builder1 = new Actions(driver);
		builder1.click().build().perform();
	}
	
	public static void fn_Verifly_UploadFile(String UpLoadPath) {
		StringSelection selection  = new StringSelection(UpLoadPath);
	       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
	    Robot robot;
		try {
			fnwait(1);
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_K);
			robot.setAutoDelay(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
	}
	public static void fn_Check_CheckBox(WebElement element, String strValidation) {
		if (element.isEnabled() && element.isDisplayed()) {
			if (strValidation.trim().equalsIgnoreCase("yes")) {
				if (element.getAttribute("class").contains("Unchecked")) {
					System.out.println("clicking the  unchecked box");
					element.click();
					System.out.println("clicked the check box");
				}else{
					System.out.println("Alredy  checked");
				}
			} else {
				if (element.getAttribute("class").contains("Unchecked")) {
					System.out.println("check box allredy un checked");
				} else {
					System.out.println("clicking the checked box");
					element.click();
					System.out.println("clicked the check box");
				}
			}

		}
	}
	
	
	public static String getPropertyValue(String key){
		
	String value=null;
		Properties prop=null;
		FileInputStream refprop=null;
		try {
			prop=new Properties();
			refprop=new FileInputStream(System.getProperty("user.dir")+"\\Properties\\configure.properties");
			prop.load(refprop);
		 value=prop.getProperty(key);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	
return value;
	}
	
	public static String currentDate(){
		   Date date = Calendar.getInstance().getTime();  
           DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");  
           String strDate = dateFormat.format(date);
          String format=  strDate.replace(" ","_").replace(":","_");
          return format;
		
	}
	
	//Genric method to select Standard Sales Order Type in Windows
public static void select_Standard_SalesOrderType(WebElement element,String field) {
	element.click();
	Actions actions=new Actions(driver);
	switch (field) {
	case "standard":
		actions.moveToElement(driver.findElement(By.name("STANDARD"))).click().build().perform();
		break;

	case "home delivery":
		actions.moveToElement(driver.findElement(By.name("Home Delivery"))).click().build().perform();
		break;
	}
	
}

  //Genric method to enter textbox value in windows
public static void windows_Set_TextBoxValue(WebElement element,String strTextValue ) {
	element.clear();
	element.sendKeys(strTextValue);
	element.click();
}
//Genric method to select drop down value
public static void windows_Set_DropDown_Value(WebElement element, String strValue) {
    element.sendKeys(strValue);
	element.submit();
}


public static WebElement scrollToText(String visibleText, String containerAutomationId) {
    WebElement element = null;
    boolean found = false;
    int maxScroll = 40; // safety limit
    int count = 0;

    // focus the scrollable container by AutomationId
    WebElement container = driver.findElement(By.xpath("//*[@AutomationId='"+visibleText+"']"));
    container.click();  // bring focus, not an item

    while (!found && count < maxScroll) {
        try {
            element = driver.findElement(By.name(visibleText));
            if (element.isDisplayed()) {
                found = true;
                break;
            }
        } catch (NoSuchElementException e) {
            // scroll down inside container
            container.sendKeys(Keys.ARROW_DOWN);
        }
        count++;
    }

    if (!found) {
        throw new RuntimeException("Element with text '" + visibleText + "' not found after scrolling.");
    }

    return element;
}


// Scroll until WebElement is visible
public static void scrollToElement(WebElement element) {
    int maxScroll = 50;
    int count = 0;

    while (!element.isDisplayed() && count < maxScroll) {
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
        count++;
    }
}

public static void listItemSelect(WebElement element ,String value, WindowsDriver driver) {
	boolean found = false;
    element.sendKeys(Keys.TAB);
    for (int i = 0; i < 20; i++) {   // loop limit to avoid infinite loop
        // Send ARROW_DOWN key
        element.sendKeys(Keys.ARROW_DOWN);
        GenericMethods.fnwait(3);  // wait for the UI to update
        // Fetch currently highlighted item text
        WebElement highlighted = driver.switchTo().activeElement();
        String currentText = highlighted.getText().trim();
        System.out.println("Current option: " + currentText);

        if (currentText.equalsIgnoreCase(value)) {
            highlighted.sendKeys(Keys.ENTER);  // select the option
            fnWriteSteps("PASS", "Discount rule '" + value + "' selected");
            found = true;
            break;
        }
    }

    if (!found) {
        fnWriteSteps("FAIL", "Discount rule '" + value + "' not found while scrolling");
        Assert.fail("Discount rule not found: " + value);
    }
	
}

public static void listItemSelectwithRobot(WebElement element, String value, WindowsDriver driver) throws AWTException, InterruptedException {
    boolean found = false;

    // Focus on the dropdown first
    element.click();
    fnWriteSteps("INFO", "Dropdown focused before Robot navigation");

    Robot robot = new Robot();

    for (int i = 0; i < 20; i++) {  // loop limit to avoid infinite loop
        // Press Arrow Down
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);

        fnwait(1);  // let UI update

        // Fetch highlighted text from active element
        WebElement highlighted = driver.switchTo().activeElement();
        String currentText = highlighted.getText().trim();
        fnWriteSteps("INFO", "Current option: " + currentText);
        

        if (currentText.equalsIgnoreCase(value)) {
            highlighted.sendKeys(Keys.ENTER);  // select it
            fnWriteSteps("PASS", "Discount rule '" + value + "' selected");
            found = true;
            break;
        }
    }

    if (!found) {
        fnWriteSteps("FAIL", "Discount rule '" + value + "' not found while scrolling");
        Assert.fail("Discount rule not found: " + value);
    }
}

public static void selectOptioFromList(WindowsDriver driver, String value) {
    // Wait for dropdown options to appear
    List<WebElement> options = driver.findElements(By.xpath("//*[@ClassName='TextBlock']"));

    for (WebElement option : options) {
        String text = option.getAttribute("name").trim(); // For WinAppDriver, Name is safer than getText()
        System.out.println("Option: " + text);

        if (text.equalsIgnoreCase(value)) {
            option.click();
            fnWriteSteps("PASS", "Discount rule '" + value + "' selected");
            return;
        }
    }

    fnWriteSteps("FAIL", "Discount rule '" + value + "' not found in list");
    Assert.fail("Discount rule not found: " + value);
}
/**
 * Generic method to enter data into a field using Actions class
 * @param element
 * @param value
 */

public static void enterDataIntoField(WebElement element, String value) {
	try {
    Actions actions = new Actions(driver);
    actions.moveToElement(element).click().sendKeys(value).perform();
    fnWriteSteps("PASS", element + " is clicked and value set to: " + value);    
	} catch (Exception e) {
	    fnWriteSteps("FAIL", element + " is not clicked and value not set to: " + value);
	    throw e;

	}
}
}