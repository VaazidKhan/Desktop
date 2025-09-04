package JBWindows.INV;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import commonClass.ApplicationVariables;
import commonClass.BaseClass;
import commonClass.ExcelUtils;
import commonClass.GenericMethods;

public class INV_ProductView extends BaseClass {
	// Header elements
	@FindBy(id = "picClose")
	WebElement btnClose;
	@FindBy(id = "lblCaption")
	WebElement PageCaption;
	@FindBy(id = "picLogo")
	WebElement HeaderJBLogo;

	// Master page button elements
	@FindBy(id = "INV_ProductView")
	WebElement PageName;
	@FindBy(id = "btnAdd")
	WebElement btnAdd;
	@FindBy(id = "btnSave")
	WebElement btnEdit;
	@FindBy(id = "btnSupplierMapping")
	WebElement btnSupplierMapping;
	@FindBy(id = "btnAliasMapping")
	WebElement btnAliasMapping;
	@FindBy(id = "btnPriceCatalog")
	WebElement btnPriceCatalog;

	@FindBy(id = "TxtSearch")
	WebElement txtSearch;
	@FindBy(id = "btnListView")
	WebElement btnListView;
	@FindBy(id = "btnOk")
	WebElement btnOk;
	
	// --------29-01-2018--------added new element by Moumita----------
	@FindBy(name = "Unit Price row 0")
	WebElement StndSaleUnitPriceColumn;
	@FindBy(name = "Tax Group Row 0")
	WebElement TaxGroupColumn;
	@FindBy(id = "gcProductPriceCatelog")
	WebElement PriceCatalogTable;
	@FindBy(name = "Maximum Retail Price row 0")
	WebElement StndSaleMaxRetailPrice;
	@FindBy(name = "Maximum Retail Price row 2")
	WebElement StndPurchaseMaxRetailPrice;
	@FindBy(name = "Unit Price row 2")
	WebElement StndPurchaseUnitPriceColumn;
	@FindBy(name = "Language row -2147483646")
	WebElement language;
	@FindBy(name = "Product Alias row -2147483646")
	WebElement ProductAlias;
	@FindBy(name = "Tax Group row 0")
	WebElement StndsaletaxGroup;
	@FindBy(name = "Tax Group row 2")
	WebElement StndPurchasetaxGroup;
	@FindBy(name = "Discount row 0")
	WebElement Stndsalediscount;
	@FindBy(name = "Discount row 2")
	WebElement StndPurchasediscount;
	@FindBy(name = "Fixed Price row 2")
	WebElement StndPurchasefixedPrice;
	@FindBy(name = "Inclusive Tax row 2")
	WebElement StndPurchaseInclusiveTax;
	@FindBy(name = "Fixed Price row 0")
	WebElement StndsalefixedPrice;
	@FindBy(name = "Inclusive Tax row 0")
	WebElement StndsaleInclusiveTax;
	@FindBy(id = "lookUpDepartment")
	WebElement lookUpDepartment;
	@FindBy (id = "cboProcurementMethodCode")
	WebElement ProcurementMethodCode;
	
	// --------2-Feb-2018--------added new element by Moumita----------
	@FindBy(name = "layoutControl1")
	WebElement ProductPageBody;
	@FindBy(id = "1148")
	WebElement uploadFile;
	WebElement selectFile;
	@FindBy(id = "2")
	WebElement selectFileCancel;
	@FindBy(name = "Delete Image")
	WebElement DeleteImage;

	// Entry OR Edit page elements
	@FindBy(id = "picProduct")
	WebElement ProductImage;
	@FindBy(id = "txtProductName")
	WebElement txtProductName;
	@FindBy(id = "txtProductCode")
	WebElement txtProductCode;
	@FindBy(id = "txtHSNCode")
	WebElement txtHSNCode;
	@FindBy(id = "lookUpCategory")
	WebElement lookUpCategory;
	@FindBy(id = "lookUpUnit")
	WebElement lookUpUnit;
	@FindBy(id = "lookUpEdit")
	WebElement lookUpEdit;
    @FindBy(id = "lookUpTaxGroup")
	WebElement lookUpTaxGroup;
	@FindBy(id = "loopUpParentProduct")
	WebElement lookUpParentProduct;
	@FindBy(id = "lookUpProductType")
	WebElement lookUpProductType;
	@FindBy(id = "chkActive")
	WebElement chkActive;
	@FindBy(id = "chkReturnAllowed")
	WebElement chkReturnAllowed;
	@FindBy(id = "lookUpBrand")
	WebElement lookUpbrand;
	@FindBy(id = "chkAllowNegativeStock")
	WebElement chkAllowNegativeStock;
	@FindBy(id = "chkSalesItem")
	WebElement chkSalesItem;
	@FindBy(id = "chkPurchaseItem")
	WebElement chkPurchaseItem;
	@FindBy(id = "memoDescription")
	WebElement memoDescription;
	@FindBy(id = "lookUpDiscountRule")
	WebElement  defaultdisc;

	// Entry or Edit page elements
	@FindBy(id = "btnSave")
	WebElement btnSave;
	@FindBy(id = "btnCancel")
	WebElement btnCancel;
	@FindBy(id= "btnOk")
	WebElement ButtonOk;

	// Details display side elements
	@FindBy(id = "picActive")
	WebElement picActive;
	@FindBy(id = "picProductImage")
	WebElement picProductImage;
	@FindBy(id = "lblProductNameCode")
	WebElement lblProductNameCode;
	@FindBy(id = "lblProductcategory")
	WebElement lblProductcategory;
	@FindBy(id = "lblProductCategoryBrand")
	WebElement lblProductCategoryBrand;
	@FindBy(id = "lblProductPrice")
	WebElement lblProductPrice;
	@FindBy(id = "lblInclisiveTax")
	WebElement lblInclisiveTax;
	@FindBy(id = "lblProductUnit")
	WebElement lblProductUnit;
	@FindBy(id = "lblAverageCaption")
	WebElement lblAverageCaption;
	@FindBy(id = "lblAverageSales")
	WebElement lblAverageSales;
	@FindBy(id = "lblProductStockInHand")
	WebElement lblProductStockInHand;
	@FindBy(id = "lblAverageSalesPercentage")
	WebElement lblAverageSalesPercentage;
	@FindBy(id = "lblAllowNegative")
	WebElement lblAllowNegative;
	@FindBy(id = "lblProductDiscount")
	WebElement lblProductDiscount;
	@FindBy(id = "memoProductDescription")
	WebElement memoProductDescription;
    @FindBy(id = "btnModifierMapping")
	WebElement btnModifierMapping;
	@FindBy(id = "btnInstructionMapping")
	WebElement btnInstructionMapping;
	@FindBy(id = "lookUpProductManageBy")
	WebElement ProductManageBy;
	
	
	/* 28-June-18-----Added by Moumita */
	@FindBy(id = "grdProduct")
	WebElement grdRecordList;
	@FindBy(id = "lblNoData")
	WebElement noProductLabel; 
	@FindBy(name = "Open")
	WebElement DepOpen; 
	@FindBy(name = "Close")
	WebElement Close; 


	// Initializing the WebElements

	public INV_ProductView() {
		PageFactory.initElements(driver, this);
	}

	// Operations

	public void activatePage() {
		PageName.click();
	}

	public void clickCreateNewButton() {
		btnAdd.click();
	}

	public void clickEditButton() {
		btnEdit.click();
	}

	public void clickSaveButton() {
		btnSave.click();
	}

	public void clickSupplierMappingButton() {
		btnSupplierMapping.click();
	}

	public void clickPriceCatalogButton() {
		btnPriceCatalog.click();
	}

	public void clickCancelButton() {
		btnCancel.click();
	}

	public void clickCloseButton() {
		driver.findElement(By.id("picLogo")).click();
		btnClose.click();
	}

	public void clickGridViewButton() {
		btnListView.click();
	}

	public boolean checkAddButtonPresence() {
		return btnAdd.isDisplayed();
	}

	public boolean checkEditButtonPresence() {
		return btnSave.isDisplayed();
	}

	public boolean checkAliasMappingButtonPresence() {
		return btnAliasMapping.isDisplayed();
	}

	public boolean checkSupplierMappingButtonPresence() {
		return btnSupplierMapping.isDisplayed();
	}

	public boolean checkPageCaptionPresence() {
		return PageCaption.isDisplayed();
	}

	public boolean checkJBlogopresence() {
		return HeaderJBLogo.isDisplayed();
	}

	public boolean checkCloseButtonpresence() {
		return btnClose.isDisplayed();
	}

	public void searchProductAndOpenInEdit(String productName) {
		txtSearch.sendKeys(productName);
		clickEditButton();
	}

	/*
	 * -----------added by Moumita on 24/May/18--------------- This method is to
	 * open the modifier window from product page
	 */
	public void clickModifierButton() {
		btnModifierMapping.click();
	}
	
	/*
	 * -----------added by Moumita on 25/May/18--------------- This method is to
	 * open the Product alias window from product page
	 */
	public void clickProductAliasButton() {
		btnAliasMapping.click();
	}
	
	/*
	 * -----------added by Moumita on 25/May/18--------------- This method is to
	 * open the instruction window from product page
	 */
	public void clickInstructionButton() {
		btnInstructionMapping.click();
	}
	
	
	// This method is to create product which will take data from Excel.
	// input parameter is StartingRowNumber, LastCountOfRecord
	
	// This method for New Product Creation :
   public void verify_NewProduct_Creation(String Image,String ProductName,String ProductCode,String ProductType,String CategoryName,String ParentProduct,String Brand,String Description,String HSNCode,String Unit,String TaxGroup,String Department,String StndsaleMaxRetailPrice,String StndpurchaseMaxretailprice,String StndsaleUnitprice,String StndpurchaseUnitprice,String Inactive) throws FindFailed {
		 
				if (btnAdd.isDisplayed()) {
					btnAdd.click();
					if (ProductImage.isDisplayed()) {
						Actions action = new Actions(driver);
						action.moveToElement(ProductImage).doubleClick().build().perform();
						GenericMethods.fn_Verifly_UploadFile(Image);
						
			         } else {
			        	 
						fnWriteSteps("Fail", "Image Type is not displayed in UI");
				    }

					if (txtProductName.isDisplayed()) {
						txtProductName.sendKeys(ProductName);
					} else {
						fnWriteSteps("Fail", "Product name field is not enable");
					}
					
					if (txtProductCode.isDisplayed()) {
						txtProductCode.sendKeys(ProductCode);
					} else {
						fnWriteSteps("Fail", "Product code field is not enable");
					}
					if (lookUpProductType.isDisplayed()) {
						lookUpProductType.sendKeys(ProductType);
						lookUpProductType.click();
					} else {
						fnWriteSteps("Fail", "ProductType field is not enable");
					}
					if (lookUpCategory.isDisplayed()) {
						lookUpCategory.sendKeys(CategoryName);
						lookUpCategory.click();
						
					} else {
						fnWriteSteps("Fail", "Category field is not enable");
					}
					GenericMethods.fnwait(1);
					driver.findElement(By.name("Line Down")).click();
					
					if (lookUpParentProduct.isDisplayed()){
						lookUpParentProduct.sendKeys(ParentProduct);
						lookUpParentProduct.click();
						
					} else { 
						fnWriteSteps("Fail", "ParentProduct field is not enabled");
					}
					if (lookUpbrand.isDisplayed()) {
						lookUpbrand.sendKeys(Brand);
						lookUpbrand.click();
						
					} else {
						fnWriteSteps("Fail", "Brand field is not enable");
					}
					if (memoDescription.isDisplayed()) {
						memoDescription.sendKeys(Description);
					} else {
						fnWriteSteps("Fail", "Description field is not enable");
					}
					if (txtHSNCode.isDisplayed()) {
						txtHSNCode.sendKeys(HSNCode);
					} else {
						fnWriteSteps("Fail", "HSN Code field is not enable");
					}
					
					if (lookUpUnit.isDisplayed()) {
						lookUpUnit.sendKeys(Unit);
						lookUpUnit.click();
						
					} else {
						fnWriteSteps("Fail", "Unit field is not enable");
					}
						if (lookUpEdit.isDisplayed()) {
							lookUpEdit.sendKeys(Department);
							lookUpEdit.submit();
							
						} else {
							fnWriteSteps("Fail", "Department field is not enable");
						}
						
						
					if (lookUpTaxGroup.isDisplayed()) {
						lookUpTaxGroup.sendKeys(TaxGroup);
						GenericMethods.fnwait(6);
						lookUpTaxGroup.submit();
						
					} else {
						fnWriteSteps("Fail", "Tax group field is not enable");
					}
					
					if (chkActive.isSelected()) {
						switch (Inactive) {
						case "Inactive":
							chkActive.click();
							break;
						}
						
						fnWriteSteps("Pass", "Active checkbox is checked by default ");
					} else {
						fnWriteSteps("Fail", "Active checkbox is not checked by default ");
					}																									
					if (chkReturnAllowed.isSelected()) {
						
						fnWriteSteps("Pass", "Return Allowed checkbox is checked by default ");
					} else {
						fnWriteSteps("Fail", "Return Allowed checkbox is not checked by default ");
					}
					if (chkAllowNegativeStock.isDisplayed()) {
						
						fnWriteSteps("Pass", "Allow Negative Stock checkbox is Disabled ");
					} else {
						fnWriteSteps("Fail", "Allow Negative Stock checkbox is Enabled ");
					}
					if (chkSalesItem.isSelected()) {
						fnWriteSteps("Pass", "Sales Item checkbox is checked by default ");
					} else {
						fnWriteSteps("Fail", "Sales Item checkbox is not checked by default ");
					}
					if (chkPurchaseItem.isSelected()) {
						
						fnWriteSteps("Pass", "Purchase Item checkbox is checked by default ");
					} else {
						fnWriteSteps("Fail", "Purchase Item checkbox is not checked by default ");
					}
					
					btnSave.click();
					GenericMethods.fnwait(2);

					if (StndSaleMaxRetailPrice.isDisplayed()) {
						StndSaleMaxRetailPrice.sendKeys(StndsaleMaxRetailPrice);
						
				  } else {
						fnWriteSteps("Fail", "StandardSaleMaxRetailPrice field is not enable");
					}
					if (StndPurchaseMaxRetailPrice.isDisplayed()) {
						StndPurchaseMaxRetailPrice.sendKeys(StndpurchaseMaxretailprice);
						
				  } else {
						fnWriteSteps("Fail", "StandardPurchaseMaxRetailPrice field is not enable");
					}
					if (StndSaleUnitPriceColumn.isDisplayed()) {
						GenericMethods.fnwait(2);
						StndSaleUnitPriceColumn.click();
						StndSaleUnitPriceColumn.sendKeys(StndsaleUnitprice);
						
				  } else {
						fnWriteSteps("Fail", "StandardSaleUnitPrice field is not enable");
					}
					if (StndPurchaseUnitPriceColumn.isDisplayed()) {
						GenericMethods.fnwait(2);
						StndPurchaseUnitPriceColumn.click();
					    StndPurchaseUnitPriceColumn.sendKeys(StndpurchaseUnitprice);
						
				  } else {
						fnWriteSteps("Fail", "StandardPurchaseUnitPrice field is not enable");
					}
					
					btnSave.click();
					GenericMethods.fnwait(2);
				System.out.println("Product has been Created & Saved");
	  }
   }
	  // This method for Validation of New Product Creation :		
				public boolean Verify_NewProductCreation_SaveorNot(String ProductName) {
					HeaderJBLogo.click();
					if(txtSearch.isDisplayed()) {
					   txtSearch.click();
					   txtSearch.clear();
					   txtSearch.sendKeys(ProductName.trim());
					   GenericMethods.fnwait(3);
					
					}else {
						fnWriteSteps("Fail", "Product name field is not enable");
					}
					String Actual = driver.findElement(By.id("lblProductNameCode")).getAttribute("Name");
					if(Actual.substring(15,34).trim().contains(ProductName.substring(0, 7).trim())){
						return true;
						
				  } else {
						return false;
						
					}
					

			}
				
				
    // This method is to verify created product which took data from Excel.
	// input parameter is StartingRowNumber, LastCountOfRecord
	public void verifyCreatedProductSavedOrNot(int StartingRowNumber, int LastCountOfRecord) throws IOException {
		int count = 0;
		for (int StartFrom = StartingRowNumber; StartFrom <= LastCountOfRecord; StartFrom++) {
			count = count + 1;
			txtSearch.sendKeys(
					ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Products", StartFrom, 0));

			clickEditButton();
			try {

				if (txtProductName.getText().equals(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Products", StartFrom, 0))) {
					fnWriteSteps("Pass", "Product field value is saved successfully.");
				} else {
					fnWriteSteps("Fail", "Product field value is not saving successfully");
				}

				if (txtProductCode.getText().equals(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Products", StartFrom, 1))) {
					fnWriteSteps("Pass", "Product Code field value is saved successfully.");
				} else {
					fnWriteSteps("Fail", "Product Code field value is not saved successfully.");
				}

				if (txtHSNCode.getText().equals(ExcelUtils.fnGetExcelCellValue(ApplicationVariables.MasterExcelPath,
						"Products", StartFrom, 2))) {
					fnWriteSteps("Pass", "HSN Code field value is saved successfully.");
				} else {
					fnWriteSteps("Fail", "HSN Code field value is not saved successfully.");
				}

				/*
				 * Due to some technical issue, this code has been commented
				 * 
				 * if (lookUpCategory.getText().equals(ExcelUtils.fnGetExcelCellValue(
				 * ApplicationVariables.MasterExcelPath, "Products", StartFrom, 3))) {
				 * fnWriteSteps("Pass", "Category field value is saved successfully."); } else {
				 * fnWriteSteps("Fail", "Category field value is not saved successfully."); }
				 * 
				 * if (lookUpUnit.getText().equals(ExcelUtils.fnGetExcelCellValue(
				 * ApplicationVariables.MasterExcelPath, "Products", StartFrom, 4))) {
				 * fnWriteSteps("Pass", "Unit field value is saved successfully."); } else {
				 * fnWriteSteps("Fail", "Unit field value is not saved successfully."); }
				 * 
				 * if (lookUpTaxGroup.getText().equals(ExcelUtils.fnGetExcelCellValue(
				 * ApplicationVariables.MasterExcelPath, "Products", StartFrom, 5))) {
				 * fnWriteSteps("Pass", "Tax Group field value is saved successfully."); } else
				 * { fnWriteSteps("Fail", "Tax Group field value is not saved successfully."); }
				 * 
				 * if (lookUpParentProduct.getText().equals(ExcelUtils
				 * .fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Products",
				 * StartFrom, 6))) { fnWriteSteps("Pass",
				 * "Parent Product field value is saved successfully."); } else {
				 * fnWriteSteps("Fail",
				 * "Parent Product field value is not saved successfully."); }
				 * 
				 * if (lookUpProductType.getText().equals(ExcelUtils
				 * .fnGetExcelCellValue(ApplicationVariables.MasterExcelPath, "Products",
				 * StartFrom, 7))) { fnWriteSteps("Pass",
				 * "Product Type field value is saved successfully."); } else {
				 * fnWriteSteps("Fail", "Product Type field value is not saved successfully.");
				 * }
				 */

				/*
				 * if (DeleteImage.isDisplayed()) { fnWriteSteps("Pass",
				 * "Image has been uploaded successfully"); } else { fnWriteSteps("Fail",
				 * "Image has not been uploaded"); }
				 */

				fnWriteSteps("Pass", "Product has been saved successfully " + count);

			} catch (Exception e) {
				fnWriteSteps("Fail", "Product has not been saved " + count);
			}
			btnCancel.click();
		}
	}

	// This method for Product Edit :
	public void verifyEditProductFeature(String OldProductName,String ProductName,String CategoryName,String HSNCode,String Unit,String Brand,String Description,String ProductCode,String StndsaleMaxretailPrice,String StndPurchaseMaxRetailprice,String StndsaleUnitPrice,String StndsaleUnitPrice1,String StndPurchaseUnitprice,String StndPurchaseUnitPrice1,String StndsaleTaxGroup,String StndPurchaseTaxGroup,String StndsaleDiscount,String StndPurchaseDiscount) throws FindFailed {
		
		if(txtSearch.isDisplayed()) {
			txtSearch.click();
			txtSearch.sendKeys(OldProductName.trim());
			btnEdit.click();
		
		if(txtProductName.isDisplayed()) {
			txtProductName.clear();
			txtProductName.sendKeys(ProductName);
		}else {
			fnWriteSteps("Fail", "Product name field is not enable");
		}
		
		if(lookUpCategory.isDisplayed()) {
		   lookUpCategory.clear();
		   lookUpCategory.sendKeys(CategoryName);
		   lookUpCategory.click();
		} else {
			fnWriteSteps("Fail", "Category name field is not enable");
		}
		
		if(txtHSNCode.isDisplayed()) {
		  txtHSNCode.clear();
		  txtHSNCode.sendKeys(HSNCode);
		  txtHSNCode.click();
		} else {
			fnWriteSteps("Fail", "HSNCode field is not enable");
		}
		
		if(lookUpUnit.isDisplayed()) {
		   lookUpUnit.clear();
		   lookUpUnit.sendKeys(Unit);
		   lookUpUnit.submit();
		} else {
			fnWriteSteps("Fail", "Unit field is not enable");
		}
		if (lookUpbrand.isDisplayed()) {
			lookUpbrand.sendKeys(Brand);
			lookUpbrand.click();
			
		} else {
			fnWriteSteps("Fail", "Brand field is not enable");
		}
		 
		
		if(memoDescription.isDisplayed()) {
		  memoDescription.clear();
		  memoDescription.sendKeys(Description);
		} else {
			fnWriteSteps("Fail", "Description field is not enable");
		}
		
		 if(txtProductCode.isDisplayed()) {
			 
			 fnWriteSteps("Pass", "ProductCode field is not Disabled");
			  } else {
				  fnWriteSteps("Fail", "ProductCode field is Disabled");
			  }
		 
		 if (chkAllowNegativeStock.isDisplayed()) {
				
				fnWriteSteps("Pass", "Allow Negative Stock checkbox is Disabled ");
			} else {
				fnWriteSteps("Fail", "Allow Negative Stock checkbox is not Disabled ");
			}
		 
		 /*if (chkReturnAllowed.isSelected()) {
			 chkReturnAllowed.click();
				fnWriteSteps("Pass", "Return Allowed checkbox is not checked by default ");
			} else {
				fnWriteSteps("Fail", "Return Allowed checkbox is checked by default ");
			}
		*/ if (chkActive.isSelected()) {
				chkActive.click();
				fnWriteSteps("Pass", "Active checkbox is not checked by default ");
			} else {
				fnWriteSteps("Fail", "Active checkbox is checked by default ");
			}
		 if (chkPurchaseItem.isSelected()) {
			
				fnWriteSteps("Pass", "Purchase Item checkbox is Disabled by default ");
			} else {
				fnWriteSteps("Fail", "Purchase Item checkbox is not Disabled by default ");
			}
		 if (chkSalesItem.isSelected()) {
			 chkSalesItem.click();
				fnWriteSteps("Pass", "Sales Item checkbox is not checked by default ");
			} else {
				fnWriteSteps("Fail", "Sales Item checkbox is checked by default ");
			}
		 
			btnSave.click();
			GenericMethods.fnwait(2);
			
		   if(StndSaleMaxRetailPrice.isDisplayed()) {
			   StndSaleMaxRetailPrice.clear();
			   StndSaleMaxRetailPrice.sendKeys(StndsaleMaxretailPrice);
				} else {
					fnWriteSteps("Fail", "StndsaleMaxRetailPrice field is not enable");
				}
		 if(StndPurchaseMaxRetailPrice.isDisplayed()) {
			  StndPurchaseMaxRetailPrice.clear();
			  StndPurchaseMaxRetailPrice.sendKeys(StndPurchaseMaxRetailprice);
			} else {
				fnWriteSteps("Fail", "StndPurchaseMaxRetailPrice field is not enable");
			}

         if(StndSaleUnitPriceColumn.isDisplayed()) {
			  GenericMethods.fnwait(2);
			  StndSaleUnitPriceColumn.clear();
			  StndSaleUnitPriceColumn.click();
			  StndSaleUnitPriceColumn .sendKeys(StndsaleUnitPrice);
			} else {
				fnWriteSteps("Fail", "StndsaleUnitPrice field is not enable");
			}
		  if(StndPurchaseUnitPriceColumn.isDisplayed()) {
			  GenericMethods.fnwait(2);
			  StndPurchaseUnitPriceColumn.clear();
			  StndPurchaseUnitPriceColumn.sendKeys(StndPurchaseUnitprice);
		      fnWriteSteps("Pass", "UnitPrice should be less than or Equal to MRP for the PriceCatalog");
			  
		  } else {
				fnWriteSteps("Fail", "StndPurchaseUnitPriceColumn field is not enable");
			}
		  if(StndsaletaxGroup.isDisplayed()) {
			  StndsaletaxGroup.clear();
			  StndsaletaxGroup.sendKeys(StndsaleTaxGroup);
			  driver.findElement(By.name("Close")).click();
				Screen sr = new Screen();
				Pattern pr = new Pattern("E:\\Projects\\QAAutomation\\TestScripts\\Windows\\Sikuli-Images\\AppConfig\\DiscountRule_Remove.PNG");
				sr.click(pr);
			} else {
				fnWriteSteps("Fail", "StndsaleTaxGroup field is not enable");
			}
		  
		  if(StndPurchasetaxGroup.isDisplayed()) {
			  StndPurchasetaxGroup.clear();
			  StndPurchasetaxGroup.sendKeys(StndPurchaseTaxGroup);
			  DepOpen.click();
			} else {
				fnWriteSteps("Fail", "StndPurchaseTaxGroup field is not enable");
			}
		  
		  if(Stndsalediscount.isDisplayed()) {
			  Stndsalediscount.clear();
			  Stndsalediscount.sendKeys(StndsaleDiscount);
			  driver.findElement(By.name("Close")).click();
				Screen sr = new Screen();
				Pattern pr = new Pattern("E:\\Projects\\QAAutomation\\TestScripts\\Windows\\Sikuli-Images\\AppConfig\\DiscountRule_Remove.PNG");
				sr.click(pr);
			} else {
				fnWriteSteps("Fail", "StndsaleDiscount field is not enable");
			}
		 
		  if(StndPurchasediscount.isDisplayed()) {
			  StndPurchasediscount.clear();
			  StndPurchasediscount.sendKeys(StndPurchaseDiscount);
			  DepOpen.click();
			} else {
				fnWriteSteps("Fail", "StndPurchaseDiscount field is not enable");
			}
		  
		  if(StndPurchasefixedPrice.isDisplayed()) {
			  GenericMethods.fnwait(2);
			  StndPurchasefixedPrice.click();
			  fnWriteSteps("Pass", "Fixed price checkbox is not checked by default");
		  } else {
			  fnWriteSteps("Fail", "Fixed price checkbox is checked by default");
			  
		  }
		  if(StndPurchaseInclusiveTax.isDisplayed()) {
			  GenericMethods.fnwait(2);
			  StndPurchaseInclusiveTax.click();
			  fnWriteSteps("Pass", "InclusiveTax checkbox is not checked by default");
		  } else {
			  fnWriteSteps("Fail", "InclusiveTax checkbox is checked by default");
			  
		  }
		  if(StndsalefixedPrice.isDisplayed()) {
			  GenericMethods.fnwait(2);
			  StndsalefixedPrice.click();
			  fnWriteSteps("Pass", "Fixed price checkbox is not checked by default");
		  } else {
			  fnWriteSteps("Fail", "Fixed price checkbox is checked by default");
			  
		  }
		  if(StndsaleInclusiveTax.isDisplayed()) {
			  GenericMethods.fnwait(2);
			  StndsaleInclusiveTax.click();
			  fnWriteSteps("Pass", "InclusiveTax checkbox is not checked by default");
		  } else {
			  fnWriteSteps("Fail", "InclusiveTax checkbox is checked by default");
			  
		  }
		  Screen screen=new Screen();
		   Pattern pattern;
		   pattern=new Pattern(System.getProperty("user.dir")+"\\Sikuli-Images\\ArrowDown.PNG");
		   screen.click(pattern);
		   GenericMethods.fnwait(1);
		   btnSave.click();
		  GenericMethods.fnwait(2);
		  ButtonOk.click();
		  
		  if(StndPurchaseUnitPriceColumn.isDisplayed()) {
			  GenericMethods.fnwait(2);
			  StndPurchaseUnitPriceColumn.clear();
			  StndPurchaseUnitPriceColumn.sendKeys(StndPurchaseUnitPrice1);
		      fnWriteSteps("Pass", "UnitPrice should be less than or Equal to MRP for the PriceCatalog");
			  
		  } else {
				fnWriteSteps("Fail", "StndPurchaseUnitPriceColumn field is not enable");
			}
		  if(StndSaleUnitPriceColumn.isDisplayed()) {
			  GenericMethods.fnwait(2);
			  StndSaleUnitPriceColumn.clear();
			  StndSaleUnitPriceColumn.click();
			  StndSaleUnitPriceColumn .sendKeys(StndsaleUnitPrice1);
			} else {
				fnWriteSteps("Fail", "StndsaleUnitPrice field is not enable");
			}
		  btnSave.click();
		  GenericMethods.fnwait(2);
			System.out.println("Product has been Updated & Saved");
		}
	}	
		// This method for Validation of Product Edit :	
		  public boolean Verify_EditProductFeature_SaveorNot(String ProductName) {
				if(txtSearch.isDisplayed()) {
				   txtSearch.clear();
				   txtSearch.sendKeys(ProductName.trim());
				   GenericMethods.fnwait(5);
				
				}else {
					fnWriteSteps("Fail", "Product name field is not enable");
				}
				String Actual = driver.findElement(By.id("lblProductNameCode")).getAttribute("Name");
				if(Actual.substring(15,30).trim().contains(ProductName.substring(0, 11).trim())){
					return true;
					
				} else {
					return false;
					
				}

		}
		  
		
	
	// This method is to verify all the fields are visible or not

	public void verifyFieldVisibility() {
		
		  if (btnAdd.isDisplayed()) {
				btnAdd.click();
				if (ProductImage.isDisplayed()) {
					fnWriteSteps("Pass", "Product image upload field is present");
				} else {
					fnWriteSteps("Fail", "Product image upload field is not present");
				}
				if (txtProductName.isDisplayed()) {
					fnWriteSteps("Pass", "Product Name field is present");
				} else {
					fnWriteSteps("Fail", "Product Name field is not present");
				}
				if (txtProductCode.isDisplayed()) {
					fnWriteSteps("Pass", "Product Code field is present");
				} else {
					fnWriteSteps("Fail", "Product Code field is not present");
				}
				if (txtHSNCode.isDisplayed()) {
					fnWriteSteps("Pass", "HSN code field is present");
				} else {
					fnWriteSteps("Fail", "HSN Code field is not present");
				}
				if (lookUpCategory.isDisplayed()) {
					fnWriteSteps("Pass", "Category field is present");
				} else {
					fnWriteSteps("Fail", "Category field is not present");
				}
				if (lookUpUnit.isDisplayed()) {
					fnWriteSteps("Pass", "Unit field is present");
				} else {
					fnWriteSteps("Fail", "Unit field is not present");
				}
				if (lookUpTaxGroup.isDisplayed()) {
					fnWriteSteps("Pass", "Tax Group field is present");
				} else {
					fnWriteSteps("Fail", "Tax Group field is not present");
				}
				if (lookUpParentProduct.isDisplayed()) {
					fnWriteSteps("Pass", "Parent Product field is present");
				} else {
					fnWriteSteps("Fail", "Parent Product field is not present");
				}
				if (lookUpProductType.isDisplayed()) {
					fnWriteSteps("Pass", "Product Type field is present");
				} else {
					fnWriteSteps("Fail", "Product Type field is not present");
				}
				if (chkActive.isDisplayed()) {
					fnWriteSteps("Pass", "Active checkbox is present");
				} else {
					fnWriteSteps("Fail", "Active checkbox is not present");
				}
				if (chkReturnAllowed.isDisplayed()) {
					fnWriteSteps("Pass", "Returned Allowed checkbox is present");
				} else {
					fnWriteSteps("Fail", "Returned Allowed checkbox is not present");
				}
				if (lookUpbrand.isDisplayed()) {
					fnWriteSteps("Pass", "Brand field is present");
				} else {
					fnWriteSteps("Fail", "Brand field is not present");
				}
				if (chkAllowNegativeStock.isDisplayed()) {
					fnWriteSteps("Pass", "Allow Negative Stock checkbox is present");
				} else {
					fnWriteSteps("Fail", "Allow Negative Stock checkbox is not present");
				}
				if (chkSalesItem.isDisplayed()) {
					fnWriteSteps("Pass", "Sales Item checkbox is present");
				} else {
					fnWriteSteps("Fail", "Sales Item checkbox is not present");
				}
				if (chkPurchaseItem.isDisplayed()) {
					fnWriteSteps("Pass", "Purchase Item checkbox is present");
				} else {
					fnWriteSteps("Fail", "Purchase Item checkbox is not present");
				}
				if (memoDescription.isDisplayed()) {
					System.out.println("Successfully all fields are Displayed");
					fnWriteSteps("Pass", "Description field is present");
				} else {
					fnWriteSteps("Fail", "Description field is not present");
				}
			}
		} 
	// This method is to verify all the fields are enable or not

	public void verifyFieldEnableOrNot() {
		   
		if (btnAdd.isDisplayed()) {
				btnAdd.click();

				if (txtProductName.isEnabled()) {
					txtProductName.click();
					fnWriteSteps("Pass", "Product Name field is enable");
				} else {
					fnWriteSteps("Fail", "Product Name field is not enable");
				}
				if (txtProductCode.isEnabled()) {
					txtProductCode.click();
					fnWriteSteps("Pass", "Product Code field is enable");
				} else {
					fnWriteSteps("Fail", "Product Code field is not enable");
				}
				if (txtHSNCode.isEnabled()) {
					txtHSNCode.click();
					fnWriteSteps("Pass", "HSN code field is enable");
				} else {
					fnWriteSteps("Fail", "HSN code field is not enable");
				}
				if (lookUpCategory.isEnabled()) {
					lookUpCategory.click();
					ProductPageBody.click();
					fnWriteSteps("Pass", "Category field is enable");
				} else {
					fnWriteSteps("Fail", "Category field is not enable");
				}
				if (lookUpUnit.isEnabled()) {
					lookUpUnit.click();
					ProductPageBody.click();
					fnWriteSteps("Pass", "Unit field is enable");
				} else {
					fnWriteSteps("Fail", "Unit field is not enable");
				}
				if (lookUpTaxGroup.isEnabled()) {
					lookUpTaxGroup.click();
					ProductPageBody.click();
					fnWriteSteps("Pass", "Tax Group field is enable");
				} else {
					fnWriteSteps("Fail", "Tax Group field is not enable");
				}
				if (lookUpParentProduct.isEnabled()) {
					lookUpParentProduct.click();
					ProductPageBody.click();
					fnWriteSteps("Pass", "Parent Product field is enable");
				} else {
					fnWriteSteps("Fail", "Parent Product field is not enable");
				}
				if (lookUpProductType.isEnabled()) {
					lookUpProductType.click();
					ProductPageBody.click();
					fnWriteSteps("Pass", "Product Type field is enable");
				} else {
					fnWriteSteps("Fail", "Product Type field is not enable");
				}
				if (chkActive.isEnabled()) {
					chkActive.click();
					fnWriteSteps("Pass", "Active checkbox is enable");
				} else {
					fnWriteSteps("Fail", "Active checkbox is not enable");
				}
				if (chkReturnAllowed.isEnabled()) {
					chkReturnAllowed.click();
					fnWriteSteps("Pass", "Returned Allowed checkbox is enable");
				} else {
					fnWriteSteps("Fail", "Returned Allowed checkbox is not enable");
				}
				if (lookUpbrand.isEnabled()) {
					lookUpbrand.click();
					GenericMethods.fnwait(2);
					fnWriteSteps("Pass", "Brand field is enable");
				} else {
					fnWriteSteps("Fail", "Brand field is not enable");
				}
				if (chkAllowNegativeStock.isEnabled()) {
					chkAllowNegativeStock.click();
					fnWriteSteps("Pass", "Allow Negative Stock checkbox is enable");
				} else {
					fnWriteSteps("Fail", "Allow Negative Stock checkbox is not enable");
				}
				if (chkSalesItem.isEnabled()) {
					chkSalesItem.click();
					fnWriteSteps("Pass", "Sales Item checkbox is enable");
				} else {
					fnWriteSteps("Fail", "Sales Item checkbox is not enable");
				}
				if (chkPurchaseItem.isEnabled()) {
					chkPurchaseItem.click();
					fnWriteSteps("Pass", "Purchase Item checkbox is enable");
				} else {
					fnWriteSteps("Fail", "Purchase Item checkbox is not enable");
				}
				if (memoDescription.isEnabled()) {
					memoDescription.click();
					System.out.println("Successfully all fields are Enabled");
					fnWriteSteps("Pass", "Description field is enable");
				} else {
					fnWriteSteps("Fail", "Description field is not enable");
				}
			}
		} 
	
	/*
	 * 28-June-18-----Added by Moumita
	 * @purpose: This is the method to delete the record by delete icon from
	 * Product master page 
	 * @Parameter: element
	 */
	
	// This method for Access the Delete Button :
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
			r1.mouseMove(x1 + 277, y1 - 181);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		GenericMethods.fnwait(1);
		Actions builder1 = new Actions(driver);
		builder1.click().build().perform();
	}
	
	// This method for To click on YES Button :
	    public void click_On_Yes_Button() {
			driver.findElement(By.id("lblHeader")).click();
			GenericMethods.fnwait(1);
			btnOk.click();
		  }
	
	/* 28-June-18-----Added by Moumita */
	/* This is the method to delete the record by delete icon from master page */
	    
	// This method for ProductDelete :  
	public void fnVerifyProductDelete(String ProductName) {
		
		txtSearch.sendKeys(ProductName.trim());
		GenericMethods.fnwait(2);
		fnVerifyMasterRecordDelete(grdRecordList);
		btnOk.click();
		GenericMethods.fnwait(37);
		System.out.println("Created Product has been Deleted");
	}
	// This method for Validation of Product Delete :
	public boolean Verify_ProductDelete_SaveorNot(String ProductName) {
		
		    if(txtSearch.isDisplayed()) {
		       txtSearch.clear();
			   txtSearch.click();
			   txtSearch.sendKeys(ProductName.trim());
			   GenericMethods.fnwait(1);
			  
			}else {
				fnWriteSteps("Fail", "Product name field is not enable");
			}
		String Actual = driver.findElement(By.id("lblProductNameCode")).getAttribute("Name");
		if(!Actual.substring(15, 31).contains(ProductName.trim())){
			
			return true;
			
		} else {
			return false;
			
		}

		
		
	}
	
	
	/* 28-June-18-----Added by Moumita */
	/* This is the method to verify the record has been deleted successfully or not*/
	public void fnVerifyProductDeleteSuccessfulOrNot(String strProductName) {
		txtSearch.clear();
		txtSearch.sendKeys(strProductName);
		String gridNoDataLabel = null;			

		WebElement messageEle = driver.findElement(By.id("lblNoData"));
		gridNoDataLabel = messageEle.getAttribute("Name");		
		if (gridNoDataLabel.contains("No product found")) {
			fnWriteSteps("pass", "Record has been deleted successfully");
		} else
		{
			fnWriteSteps("pass", "Record has not been deleted");
		}
		
	}
	 public void verify_Product_Creation_with_MultipleDiscounts(String ProductName,String ProductCode,String ProductType,String CategoryName,String Unit,String DiscType,String DefaultDisc,String PriceCatalogDisc,String BrandDisc,String DepartmentDisc,String MaxRetailPrice,String UnitPrice){
		 GenericMethods.fnwait(1);
		 HeaderJBLogo.click();
		 btnAdd.click();
		 GenericMethods.windows_Set_TextBoxValue(txtProductName, ProductName);
		 GenericMethods.windows_Set_TextBoxValue(txtProductCode, ProductCode);
		 GenericMethods.windows_Set_DropDown_Value(lookUpProductType,ProductType);
		 GenericMethods.windows_Set_DropDown_Value(lookUpCategory,CategoryName);
		 GenericMethods.windows_Set_DropDown_Value(lookUpUnit, Unit);
		 
		 switch(DiscType) {
		 case "DefaultDisc":
			GenericMethods.windows_Set_DropDown_Value(defaultdisc,DefaultDisc);
		    break;
		 case "PriceCatalogDisc" :
			 clickSaveButton();
			 GenericMethods.fnwait(2);
			 HeaderJBLogo.click();
			 GenericMethods.windows_Set_DropDown_Value(Stndsalediscount,PriceCatalogDisc);
			 break;
		 case "BrandDisc": 
			 GenericMethods.windows_Set_DropDown_Value(lookUpbrand,BrandDisc);
			 break;
		 case "DepartmentDisc": 
			GenericMethods.windows_Set_DropDown_Value(lookUpDepartment,DepartmentDisc);
			 break;
		 case "All": 
			 GenericMethods.windows_Set_DropDown_Value(defaultdisc,DefaultDisc);
			 GenericMethods.windows_Set_DropDown_Value(lookUpbrand,BrandDisc);
			 GenericMethods.windows_Set_DropDown_Value(lookUpDepartment,DepartmentDisc);
			 break;
		 }
		 
		 if(!DiscType.contains("PriceCatalogDisc")) {
			 clickSaveButton();
		 }
         GenericMethods.fnwait(1);
		 GenericMethods.windows_Set_TextBoxValue(StndSaleMaxRetailPrice,MaxRetailPrice);
		 GenericMethods.fnwait(1);
		 GenericMethods.windows_Set_TextBoxValue(StndSaleUnitPriceColumn,UnitPrice);
		 clickSaveButton();
	    }
	 public void verify_Product_Creation_MappedBy_BatchANDSerialNumber(String NotAllowNegativeStock,String ProductName,String ProductCode,String ProductType,String CategoryName,String Unit,String ProcurementMethod,String ManagedBy,String BatchNum,String SerialNum,String SalMaxRetailPrice,String SalUnitPrice,String PurchaseMaxRetailPrice,String PurchaseUnitPrice){
		 GenericMethods.fnwait(1);
		 HeaderJBLogo.click();
		 btnAdd.click();
		 if (chkAllowNegativeStock.isSelected()) {
				switch (NotAllowNegativeStock) {
				case "NotAllowNegativeStock":
					chkAllowNegativeStock.click();
					break;
				}
		 GenericMethods.windows_Set_TextBoxValue(txtProductName, ProductName);
		 GenericMethods.windows_Set_TextBoxValue(txtProductCode, ProductCode);
		 GenericMethods.windows_Set_DropDown_Value(lookUpProductType,ProductType);
		 GenericMethods.windows_Set_DropDown_Value(lookUpCategory,CategoryName);
		 GenericMethods.windows_Set_DropDown_Value(lookUpUnit, Unit);
		 GenericMethods.windows_Set_DropDown_Value(ProcurementMethodCode, ProcurementMethod);
		 
		 switch(ManagedBy) {
		 case "BatchNumber":
	     GenericMethods.windows_Set_DropDown_Value(ProductManageBy, BatchNum);
	     break;
		 case "SerialNumber":
		GenericMethods.windows_Set_DropDown_Value(ProductManageBy, SerialNum);
		break;
		 
		 }
		 GenericMethods.fnwait(1);
		 clickSaveButton();
		 GenericMethods.fnwait(1);
		 GenericMethods.windows_Set_TextBoxValue(StndSaleMaxRetailPrice,SalMaxRetailPrice);
		 GenericMethods.fnwait(1);
		 GenericMethods.windows_Set_TextBoxValue(StndSaleUnitPriceColumn,SalUnitPrice);
		 GenericMethods.fnwait(1);
		 GenericMethods.windows_Set_TextBoxValue(StndPurchaseMaxRetailPrice,PurchaseMaxRetailPrice);
		 GenericMethods.fnwait(1);
		 GenericMethods.windows_Set_TextBoxValue(StndPurchaseUnitPriceColumn,PurchaseUnitPrice);
		 clickSaveButton();
  }
 }  
}





