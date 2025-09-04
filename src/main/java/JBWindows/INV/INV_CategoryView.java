package JBWindows.INV;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.testng.Assert;

import commonClass.BaseClass;
import commonClass.GenericMethods;
import io.appium.java_client.windows.WindowsDriver;

public class INV_CategoryView extends BaseClass {
	private WindowsDriver driver;
	private WebDriverWait wait;

	// Header elements
	@FindBy(id = "picClose")
	WebElement btnClose;
	@FindBy(id = "lblCaption")
	WebElement PageCaption;
	@FindBy(id = "picLogo")
	WebElement HeaderJBLogo;
	@FindBy(id = "lblNoData")
	WebElement lblNoData;

	// Details pane element
	@FindBy(id = "lblCategory")
	WebElement lblCategory;
	@FindBy(id = "lblCategoryType")
	WebElement lblCategoryType;
	@FindBy(id = "lblDiscount")
	WebElement lblDiscount;

	// Master page elements
	@FindBy(name = "Product Categories")
	WebElement pageName;
	@FindBy(name = "ALT + F")
	WebElement txtSearch;
	@FindBy(name = "Type to Search")
	WebElement enterSearchText;

	// Entry OR Edit screen elements
//	@FindBy(className = "image")
//	WebElement ImagePath;
	@FindBy(xpath = "//*[@AutomationId='txtCategoryName']")
	WebElement txtCategory;
	@FindBy(xpath = "//*[@AutomationId='txtCategoryType']")
	WebElement cboCategoryType;
	@FindBy(xpath = "(//*[@Name='Select' and @ClassName='TextBlock'])[1]")
	WebElement lookUpDiscountRule;
	@FindBy(xpath = "(//*[@Name='Select' and @ClassName='TextBlock'])[1]")
	WebElement lookUpParentCategory;
	@FindBy(name = "Search")
	WebElement enterDiscountRule;
	@FindBy(xpath = "//*[@AutomationId='txtDescription']")
	WebElement memoDescription;
	@FindBy(name = "ITEM")
	WebElement lblItem;
	@FindBy(name = "ASSET")
	WebElement lblAsset;
	@FindBy(name = "SERVICE")
	WebElement lblService;

	// Buttons elements
	@FindBy(name = "New")
	WebElement btnAdd;
	@FindBy(name = "ALT + E")
	WebElement btnEdit;
	@FindBy(name = "ALT + S")
	WebElement btnSave;
	@FindBy(name = "ALT + X")
	WebElement btnCancel;
	@FindBy(xpath = "//*[@AutomationId='btnYes']")
	WebElement btnOk;

	// Upload popup element
	@FindBy(id = "1148")
	WebElement uploadFile;
	// -------------2-Feb-2018---modified by Moumita----------------
	@FindBy(id = "1")
	WebElement selectFile;
	@FindBy(id = "2")
	WebElement selectFileCancel;
	@FindBy(name = "ALT + D")
	WebElement DeleteImage;

	/* 28-June-18-----Added by Moumita */
	@FindBy(id = "grdCategory")
	WebElement grdRecordList;
	@FindBy(id = "lblNoData")
	WebElement noCategoryLabel;
	
	@FindBy(xpath = "(//*[@AutomationId='txtDiscountRule'])")
	WebElement existingDiscountRule;
	
	@FindBy(xpath = "(//*[@AutomationId='txtParentCategory'])")
	WebElement existingParentCategory;
	
	@FindBy(name = "Backspace")
	WebElement backBtn;
	

	// WebElement Initialization
	public INV_CategoryView(WindowsDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}

	// Operations
	public void activatePage() {
		pageName.click();
	}

	// Actions
	public void clickCreateNewButton() {
		btnAdd.click();
	}

	public void clickEditButton() {
		btnEdit.click();
	}

	public void clickSaveButton() {
		btnSave.click();
	}

	public void clickCloseButton() {
		GenericMethods.fnwait(5);
		driver.findElement(By.id("picLogo")).click();
		btnClose.click();
	}

//	public void clickOnImage() {
//		ImagePath.click();
//	}

	// This method for New Category Creation :
	public void fn_Verify_New_Category_Creation(String Image, String CategoryName, String CategoryType,
			String DiscountRule, String ParentCategory, String Description) throws AWTException, InterruptedException {

		if (btnAdd.isDisplayed()) {
			btnAdd.click();

//			if (ImagePath.isDisplayed()) {
//				Actions action = new Actions(driver);
//				action.moveToElement(ImagePath).doubleClick().build().perform();
//				GenericMethods.fn_Verifly_UploadFile(Image);
//
//			} else {
//				fnWriteSteps("Fail", "Image Type is not displayed in UI");
//				Assert.fail();
//			}

			if (txtCategory.isDisplayed()) {
				fnWriteSteps("INFO", "CategoryName displayed in UI");
				txtCategory.sendKeys(CategoryName);
				fnWriteSteps("PASS", CategoryName + " is passed in CategoryName field");

			} else {

				fnWriteSteps("Fail", "CategoryName field is not displayed in UI");
				Assert.fail();

			}
			if (cboCategoryType.isDisplayed()) {
				fnWriteSteps("INFO", "CategoryType displayed in UI");
				GenericMethods.fn_ConditionalWaitForElement(cboCategoryType, 20);
				cboCategoryType.click();
				fnWriteSteps("PASS", "CategoryType clicked in UI");
				if (CategoryType.equalsIgnoreCase("ITEM")) {
					GenericMethods.fn_ConditionalWaitForElement(lblItem, 20);
					fnWriteSteps("PASS", "CategoryType" +CategoryType+"is selected");
					lblItem.click();
				} else if (CategoryType.equalsIgnoreCase("ASSET")) {
					GenericMethods.fn_ConditionalWaitForElement(lblAsset, 20);
					fnWriteSteps("PASS", "CategoryType" +CategoryType+"is selected");
					lblAsset.click();
				} else if (CategoryType.equalsIgnoreCase("SERVICE")) {
					GenericMethods.fn_ConditionalWaitForElement(lblService, 20);
					lblService.click();
					fnWriteSteps("PASS", "CategoryType" +CategoryType+"is selected");
				} else {
					fnWriteSteps("Fail", "Category Type is not matched");
					Assert.fail();

				}
				cboCategoryType.sendKeys(CategoryType);
				cboCategoryType.click();
			} else {
				fnWriteSteps("Fail", "CategoryCode Type is not displayed in UI");
				Assert.fail();
			}
			if (lookUpDiscountRule.isDisplayed()) {
			    fnWriteSteps("PASS", "Discount rule is displayed in UI");

			    GenericMethods.fn_ConditionalWaitForElement(lookUpDiscountRule, 20);
			    lookUpDiscountRule.click();
			    fnWriteSteps("PASS", "Discount rule field is clicked");

			    GenericMethods.fn_ConditionalWaitForElement(enterDiscountRule, 20);
			    GenericMethods.enterDataIntoField(enterDiscountRule, DiscountRule);
			    
			    fnWriteSteps("PASS", "Discount rule entered in search filed");

			    WebElement discountOption = driver.findElement(By.xpath("//*[@Name='" + DiscountRule + "']"));
			    discountOption.click();

			} else {
			    fnWriteSteps("FAIL", "Discount Type is not displayed");
			    Assert.fail();
			}

				
			if (ParentCategory != null && !ParentCategory.isBlank()) {
			    if (lookUpParentCategory.isDisplayed()) {
			        GenericMethods.fn_ConditionalWaitForElement(lookUpParentCategory, 20);
			        lookUpParentCategory.click();
			        fnWriteSteps("PASS", "Parent Category field is clicked");

			        GenericMethods.fn_ConditionalWaitForElement(enterDiscountRule, 20);
			        GenericMethods.enterDataIntoField(enterDiscountRule, ParentCategory);
			        fnWriteSteps("PASS", "Parent Category search clicked and data is sent");

			        WebElement parentCategoryOption = driver.findElement(By.xpath("//*[@Name='" + ParentCategory + "']"));
			        parentCategoryOption.click();
			        fnWriteSteps("PASS", ParentCategory + " Parent Category selected");
			    } else {
			        fnWriteSteps("FAIL", "ParentCategory field is not displayed in UI");
			        Assert.fail();
			    }
			} else {
			    fnWriteSteps("INFO", "ParentCategory is blank or not provided in Excel, skipping selection");
			}

			if (btnSave.isDisplayed())
				btnSave.click();
			fnWriteSteps("PASS", "ProductCategory has been created & Saved");

		} else {
			System.out.println("Add button is not displyed");
			Assert.fail();

		}

		/*
		 * String Actual =
		 * driver.findElement(By.id("lblCategory")).getAttribute("Name"); String
		 * Expected = CategoryName; if(Actual.contains(Expected)){
		 * System.out.println("Successfully Created_ProductCategory Saved");
		 * fnWriteSteps("Pass", "Successfully Created_ProductCategory Saved"); } else {
		 * System.out.println("UnSuccessfully Created_ProductCategory not Saved"); }
		 */
	}
	// This method for Validation of ProductCategory Creation :

	public boolean Verify_ProductCategoryCreation_SaveorNot(String Categoryname) {

		if (txtSearch.isDisplayed()) {
			txtSearch.click();
			GenericMethods.enterDataIntoField(txtSearch, Categoryname);
			WebElement searchResult = driver.findElement(By.xpath("//*[@Name='" + Categoryname + "']"));
			searchResult.isDisplayed();
			return true;
			

		} else {
			fnWriteSteps("Fail", "CategoryName is not displayed in UI");
			return false;

		}
//		String Actual = driver.findElement(By.id("lblCategory")).getAttribute("Name");
//		if (Actual.substring(15, 24).contains(Categoryname.substring(0, 5))) {
//
//			return true;
//		}
	}

	// This method for ProductCategory Edit :

	public void verifyEditCategoryFeature(String Image, String CategoryName, String CategoryType, String DiscountRule1,
			String DiscountRule2, String ParentCategory, String Description, String OldCategoryName, String ParentCategory2) throws FindFailed {

		if (txtSearch.isDisplayed()) {
			txtSearch.click();
			GenericMethods.enterDataIntoField(txtSearch, OldCategoryName);
			fnWriteSteps("Pass", OldCategoryName + " is passed in Search field");
		}
		else {
			fnWriteSteps("Fail", "CategoryName is not displayed in UI");
			Assert.fail();
		}
		
		if (btnEdit.isDisplayed()) {
			btnEdit.click();
			fnWriteSteps("Pass", "Edit button is clicked");
		} else {
			fnWriteSteps("Fail", "Edit button is not displayed in UI");
			Assert.fail();

		}
		if (txtCategory.isDisplayed()) {
			fnWriteSteps("INFO", "CategoryName displayed in UI");
			txtCategory.clear();
			txtCategory.sendKeys(CategoryName);
			fnWriteSteps("PASS", CategoryName + " is passed in CategoryName field");

		} else {

			fnWriteSteps("Fail", "CategoryName field is not displayed in UI");
			Assert.fail();

		}
		if (cboCategoryType.isDisplayed()) {
			fnWriteSteps("INFO", "CategoryType displayed in UI");
			GenericMethods.fn_ConditionalWaitForElement(cboCategoryType, 20);
			cboCategoryType.click();
			fnWriteSteps("PASS", "CategoryType clicked in UI");
			if (CategoryType.equalsIgnoreCase("ITEM")) {
				GenericMethods.fn_ConditionalWaitForElement(lblItem, 20);
				fnWriteSteps("PASS", "CategoryType" +CategoryType+"is selected");
				lblItem.click();
			} else if (CategoryType.equalsIgnoreCase("ASSET")) {
				GenericMethods.fn_ConditionalWaitForElement(lblAsset, 20);
				fnWriteSteps("PASS", "CategoryType" +CategoryType+"is selected");
				lblAsset.click();
			} else if (CategoryType.equalsIgnoreCase("SERVICE")) {
				GenericMethods.fn_ConditionalWaitForElement(lblService, 20);
				lblService.click();
				fnWriteSteps("PASS", "CategoryType" +CategoryType+"is selected");
			} else {
				fnWriteSteps("Fail", "Category Type is not matched");
				Assert.fail();

			}
			cboCategoryType.sendKeys(CategoryType);
			cboCategoryType.click();
		} else {
			fnWriteSteps("Fail", "CategoryCode Type is not displayed in UI");
			Assert.fail();
		}
		
		
		if (existingDiscountRule.isDisplayed()) {
		    fnWriteSteps("PASS", "Discount rule is displayed in UI");

		    GenericMethods.fn_ConditionalWaitForElement(existingDiscountRule, 20);
		    existingDiscountRule.click();
		    fnWriteSteps("PASS", "Discount rule field is clicked");
		    GenericMethods.fn_ConditionalWaitForElement(enterDiscountRule, 20);
		    GenericMethods.enterDataIntoField(enterDiscountRule, DiscountRule2);
		    
		    fnWriteSteps("PASS", "Discount rule entered in search filed");

		    WebElement discountOption = driver.findElement(By.xpath("//*[@Name='" + DiscountRule2 + "']"));
		    discountOption.click();

		} else {
		    fnWriteSteps("FAIL", "Discount Type is not displayed");
		    Assert.fail();
		}

			
		
		if (existingParentCategory.isDisplayed()) {
			GenericMethods.fn_ConditionalWaitForElement(existingParentCategory, 20);
			existingParentCategory.click();
		    fnWriteSteps("PASS", "Parent Category field is clicked");
			GenericMethods.fn_ConditionalWaitForElement(enterDiscountRule, 20);
		    GenericMethods.enterDataIntoField(enterDiscountRule, ParentCategory);

		    fnWriteSteps("PASS", "Parent Category search clicked and data is sent");
			WebElement parentCategoryOption = driver.findElement(By.xpath("//*[@Name='" + ParentCategory + "']"));
			parentCategoryOption.click();
		    fnWriteSteps("PASS", ParentCategory + " Parent Category selected");


		} else {
			fnWriteSteps("Fail", "ParentCategory Type is not displayed in UI");
			Assert.fail();

		}
		if (memoDescription.isDisplayed()) {
			memoDescription.clear();
			memoDescription.sendKeys(Description);
		} else {
			fnWriteSteps("Fail", "Description Type is not displayed in UI");
			Assert.fail();

		}
		if (btnSave.isDisplayed())
			btnSave.click();
		fnWriteSteps("PASS", "ProductCategory has been created & Saved");

	}

	// This method for Validation of ProductCategory Edit :
	public boolean Verify_ProductCategoryUpdate_SaveorNot(String Categoryname) {


		if (txtSearch.isDisplayed()) {
			txtSearch.click();
			GenericMethods.enterDataIntoField(txtSearch, Categoryname);
			WebElement searchResult = driver.findElement(By.xpath("//*[@Name='" + Categoryname + "']"));
			searchResult.isDisplayed();
			return true;
			

		} else {
			fnWriteSteps("Fail", "CategoryName is not displayed in UI");
			return false;

		}
	}

	// This method for ProductCategoryDelete :
	public void fnVerifyCategoryDelete(String Categoryname) {
		if (txtSearch.isDisplayed()) {
			txtSearch.click();
			GenericMethods.enterDataIntoField(txtSearch, Categoryname);
		}
		else {
			fnWriteSteps("Fail", "CategoryName is not displayed in UI");
			Assert.fail();
		}
		if(DeleteImage.isDisplayed()) {
			DeleteImage.click();
            fnWriteSteps("Pass", "Delete icon is clicked");
		} else {
			fnWriteSteps("Fail", "Delete icon is not displayed in UI");
			Assert.fail();
		}
		//GenericMethods.fnVerifyMasterRecordDelete(grdRecordList);
		if (btnOk.isDisplayed()) {
			btnOk.click();
			fnWriteSteps("Pass", "OK button is displayed and clicked in UI");
		} else {
			fnWriteSteps("Fail", "OK button is not displayed in UI");
			Assert.fail();
		}
	}

	// This method for To click on YES Button :
	public void click_On_Yes_Button() {
		driver.findElement(By.id("lblHeader")).click();
		GenericMethods.fnwait(2);
		btnOk.click();

	}

	// This method validates whether a ProductCategory still exists after delete
	public boolean Verify_ProductCategoryDelete_SaveorNot(String Categoryname) {
	    try {
	        if (txtSearch.isDisplayed()) {
	            txtSearch.click();
	            GenericMethods.enterDataIntoField(txtSearch, Categoryname);

	            // Try to find the category
	            WebElement searchResult = driver.findElement(By.xpath("//*[@Name='" + Categoryname + "']"));
	            
	            if (searchResult.isDisplayed()) {
	                fnWriteSteps("FAIL", "Category '" + Categoryname + "' still exists after delete");
	                return true;  // ❌ category not deleted
	            } else {
	                fnWriteSteps("PASS", "Category '" + Categoryname + "' not visible after delete");
	                return false; // ✅ deleted
	            }
	        } else {
	            fnWriteSteps("FAIL", "Search box not displayed in UI");
	            return true; // treat as failure
	        }
	    } catch (Exception e) {
	        // If element is not found, it means delete succeeded
	        fnWriteSteps("PASS", "Category '" + Categoryname + "' not found after delete");
	        return false; // ✅ deleted
	    }
	}


	// This method is to verify all the fields are visible or not

	public void verifyFieldVisibility() {

		if (btnAdd.isDisplayed()) {
			btnAdd.click();

//			if (ImagePath.isDisplayed()) {
//				fnWriteSteps("Pass", "Category image upload field is present");
//			} else {
//				fnWriteSteps("Fail", "Category image upload field is not present");
//				Assert.fail();
//
//			}
			if (txtCategory.isDisplayed()) {
				fnWriteSteps("Pass", "Category field is present");
			} else {
				fnWriteSteps("Fail", "Category field is not present");
				Assert.fail();

			}
			if (cboCategoryType.isDisplayed()) {
				fnWriteSteps("Pass", "Category Type field is present");
			} else {
				fnWriteSteps("Fail", "Category Type field is not present");
				Assert.fail();

			}
			if (lookUpDiscountRule.isDisplayed()) {
				fnWriteSteps("Pass", "Discount Rule field is present");
			} else {
				fnWriteSteps("Fail", "Discount Rule field is not present");
				Assert.fail();

			}
			if (lookUpParentCategory.isDisplayed()) {
				fnWriteSteps("Pass", "Parent Category field is present");
			} else {
				fnWriteSteps("Fail", "Parent Category field is not present");
				Assert.fail();

			}
			if (memoDescription.isDisplayed()) {
				System.out.println("Successfully all fields are Displayed");
				fnWriteSteps("Pass", "Description field is present");
			} else {
				fnWriteSteps("Fail", "Description field is not present");
				Assert.fail();

			}
		}
	}

	// This method is to verify all the fields are enable or not

	public void verifyFieldEnableOrNot() {

		if (btnAdd.isDisplayed()) {
			btnAdd.click();

			/*
			 * Due to some code issue I have commented this part if
			 * (picCategory.isEnabled()) { GenericMethods.DoubleClickAction("Window",
			 * picCategory); GenericMethods.fnwait(2); selectFileCancel.click();
			 * fnWriteSteps("Pass", "Category image upload field is present" ); } else {
			 * fnWriteSteps("Fail", "Category image upload field is not present"); }
			 */
			if (txtCategory.isEnabled()) {
				txtCategory.click();
				fnWriteSteps("Pass", "Category field is enable");
			} else {
				fnWriteSteps("Fail", "Category field is not enable");
				Assert.fail();

			}
			if (cboCategoryType.isEnabled()) {
				cboCategoryType.click();
				fnWriteSteps("Pass", "Category Type field is enable");
			} else {
				fnWriteSteps("Fail", "Category Type field is not enable");
				Assert.fail();

			}
			if (lookUpDiscountRule.isEnabled()) {
				lookUpDiscountRule.click();
				fnWriteSteps("Pass", "Discount Rule field is enable");
			} else {
				fnWriteSteps("Fail", "Discount Rule field is not enable");
				Assert.fail();

			}
			if (lookUpParentCategory.isEnabled()) {
				lookUpParentCategory.click();
				fnWriteSteps("Pass", "Parent Category field is enable");
			} else {
				fnWriteSteps("Fail", "Parent Category field is not enable");
				Assert.fail();

			}
			if (memoDescription.isEnabled()) {
				memoDescription.click();
				System.out.println("Successfully all fields are Enabled");
				fnWriteSteps("Pass", "Description field is enable");
			} else {
				fnWriteSteps("Fail", "Description field is not present");
				Assert.fail();

			}
		}
	}
	/*
	 * Due to some code issue I have commented this part if
	 * (picCategory.isEnabled()) { GenericMethods.DoubleClickAction("Window",
	 * picCategory); GenericMethods.fnwait(2); selectFileCancel.click();
	 * fnWriteSteps("Pass", "Category image upload field is present"); } else {
	 * fnWriteSteps("Fail", "Category image upload field is not present"); }
	 */

	/* 28-June-18-----Added by Moumita */
	/*
	 * This is the method to delete the record by delete icon from master page
	 */

	/* 28-June-18-----Added by Moumita */
	/*
	 * This is the method to verify the record has been deleted successfully or not
	 */
	public void fnVerifyCategoryDeleteSuccessfulOrNot(String strCategoryName) {
		txtSearch.clear();
		txtSearch.sendKeys(strCategoryName);
		String gridNoDataLabel = null;

		WebElement messageEle = driver.findElement(By.id("lblNoData"));
		gridNoDataLabel = messageEle.getAttribute("Name");
		if (gridNoDataLabel.contains("No category found")) {
			fnWriteSteps("pass", "Record has been deleted successfully");
		} else {
			fnWriteSteps("fail", "Record has not been deleted");
			Assert.fail();

		}

	}
	
	public void clickBackButton() {
		GenericMethods.fn_ConditionalWaitForElement(backBtn, 20);
		backBtn.click();
		GenericMethods.fnwait(5);
		fnWriteSteps("INFO", "Back button is clicked");
		
	}
	
	
}
