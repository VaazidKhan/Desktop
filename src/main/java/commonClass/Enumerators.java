package commonClass;

public class Enumerators {

	public enum ApplicationType {
		Windows("WINDOWS"), Android("ANDROID"), BackOffice("BACKOFFICE");
		private final String value;

		ApplicationType(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum NotificationType {
		SMS("SMS"), Email("EMAIL");
		private final String value;

		NotificationType(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum HeaderChargeCode {
		PKGCHRG("PKGCHRG"), DLVCHRG("DLVCHRG");
		private final String value;

		HeaderChargeCode(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum DBOperationType {
		ADD("ADD"), DELETE("DELETE"), UPDATE("UPDATE");
		private final String value;

		DBOperationType(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum GSTExemptedGroup {
		GSTExepmptedGroupCode("GSTEXMP");

		private final String value;

		GSTExemptedGroup(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum ContraAdjustmentTypeCode {
		ContraCountIN("ContraCountIN"), ContraCountOUT("ContraCountOUT");
		private final String value;

		ContraAdjustmentTypeCode(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum OrgType {
		NewOrg("NewOrg"), ExistingOrg("ExistingOrg");
		private final String value;

		OrgType(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum AccountType {
		Supplier("SUP"), Customer("CUS");
		private final String value;

		AccountType(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum POTypeCode {
		STANDARD("STANDARD");
		private final String value;

		POTypeCode(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum BuildTypeEnvironment {
		UAT("UAT"), LOCAL("LOCAL"), PROD("PROD");
		private final String value;

		BuildTypeEnvironment(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum MessageType {
		Error("Error"), Warning("Warning"), UnObtrusiveWarning("UnObtrusiveWarning"), Success("Success");
		private final String value;

		MessageType(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum InvoiceDeliveryOption {
		Print(1), Email(2), SMS(3), NONE(4);
		private final int value;

		InvoiceDeliveryOption(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	public enum JBRoles {
		Role_RetailOwner(1), Role_QSROwner(2), Role_ProfessionServiceOwner(3), Role_QSRChef(4), Role_RetailCashier(
				5), Role_QSRCashier(6), Role_GasStationAdmin(
						7), Role_GasStationCashier(8), Role_DistributionCashier(9), Role_DistributionOwner(10);

		private final int value;

		JBRoles(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	public enum JBVerticals {
		Retail("JBR"), QSR("JBF"), GasStation("JBG"), Distribution("JBD"), ProfessionService("JBS"), WindowsRetail(
				"JBWR"), WindowsQSR("JBWF"), WindowsDistribution("JBWD"), WindowsProfessionService("JBWS");

		private final String value;

		JBVerticals(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum SyncType {
		DOWNLOAD("DOWNLOAD"), UPLOAD("UPLOAD");
		private final String value;

		SyncType(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum DocumentType {
		Order("ORDER"), Quotation("QUOTATION"), KOT("KOT"), Invoice("INVOICE"), GRN("GRN"), LocalPurchase(
				"LOCALPURCHASE"), Requisition("REQUISITION"), CustomerLedger(
						"CUSTOMER_LEDGER"), CustomerDeposit("CUSTOMER_DEPOSIT"), Return("RETURN");
		private final String value;

		DocumentType(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum PromotionMode {
		SMS(1), Email(2);

		private final int value;

		PromotionMode(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	public enum BillingScreenMode {
		SALESINVOICE("INVOICE"), SALESORDER("ORDER"), SALESQUOTATION("QUOTATION"), SALESRETURN(
				"SALESRETURN"), CUSTOMERRETURNS("CUSTOMERRETURNS"), PURCHASEREQUISITION(
						"PURCHASEREQUISITION"), INVENTORY("INVENTORY"), INVENTORYSTOCKTRANSFER(
								"INVENTORYSTOCKTRANSFER"), PURCHASEINVOICE("PURCHASEINVOICE");
		private final String value;

		BillingScreenMode(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum PaymentMode {
		CASH("CASH"), CARD("CARD"), CHEQUE("CHEQUE"), VOUCHER("VOUCHER"), ONGOWALLET("YouPay Wallet"), ONGOMPOS(
				"YouPay mPOS"), ONACCOUNT("On Account"), LOYALTY("Redeem Amount"), PAYTM("PayTM"), MOBIKWIK(
						"MobiKwik"), FREECHARGE("FreeCharge"), AIRTELMONEY("Airtel Money"), OLAMONEY("Ola Money"), BHIM(
								"BHIM"), AADHAARPAYMENT(
										"Aadhaar Payment"), WALLET("WALLET"), BANK("Bank Transfer"), DEBITNOTE(
												"Debit Note"), CREDITNOTE("Credit Note"), ADVANCE_RECEIVED(
														"Advance Received"), ADVANCE_PAID("Advance Paid");

		private final String value;

		PaymentMode(String value) {
			this.value = value;
		}

		public static PaymentMode findByValue(String value) {
			for (PaymentMode v : values()) {
				if (v.name().equals(value)) {
					return v;
				}
			}
			return null;
		}

		public String getValue() {
			return value;
		}
	}

	public enum InventoryStockFlow {
		CountIN("Physical Count-IN"), CountOUT("Physical Count-OUT");
		private final String value;

		InventoryStockFlow(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum PrinterPageSize {
		TWOINCH("2 inch"), THREEPOINTFIVEINCH("3.5 INCH"), AFOUR("A4");
		private final String value;

		PrinterPageSize(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum A4InvoiceTemplates {
		GST("GST.html"), Standard("Standard.html"), Professional("Professional.html");
		private final String value;

		A4InvoiceTemplates(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum BodyContent {
		SIMPLE("Simple"), PROFESSIONAL("Professional");
		private final String value;

		BodyContent(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum BillGridDisplayMode {

		GRID("GRID"), LIST("LIST"), CARD("CARD");

		private final String value;

		BillGridDisplayMode(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum Language {
		English("en"), Telugu("te");
		private final String value;

		Language(String value) {
			this.value = value;
		}

		public static Language findByValue(String value) {
			for (Language v : values()) {
				if (v.getValue().equals(value)) {
					return v;
				}
			}
			return English;
		}

		public String getValue() {
			return value;
		}
	}

	public enum UserAccessLevel {
		Organization("ORG"), Branch("BRANCH");
		private final String value;

		UserAccessLevel(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum BusinessType {
		B2B("B2B"), B2C("B2C");
		private final String value;

		BusinessType(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum SalesOrderType {
		TABLESERVICE("Dine In"), TAKEAWAY("Takeaway"), STANDARD("Standard"), HOMEDELIVERY("Home Delivery");
		private final String value;

		SalesOrderType(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum YesNo {
		NO("N"), YES("Y");
		final String value;

		YesNo(String value) {
			this.value = value;
		}

		public static YesNo get(boolean v) {
			return (v) ? YES : NO;
		}

		public String getValue() {
			return value;
		}
	}

	public enum CustomerSMSTemplateCode {
		ActivationOTP("CUS_Activation_OTP"), TerminationOTP("CUS_Termination_OTP"), MobileChangeOTP(
				"CUS_Mobile_Change_OTP");

		private final String value;

		CustomerSMSTemplateCode(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum DocumentProofType {
		IDProof("ID Proof"), AddressProof("Address Proof");
		final String value;

		DocumentProofType(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum MenuGroup {
		Transaction("RES_WIN_Transaction"), Master("RES_WIN_Master"), Report("RES_WIN_Report"), Configuration(
				"RES_WIN_Config"), Support("RES_WIN_Support");
		final String value;

		MenuGroup(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum TransactionMenu {
		CreateBilling("SYS_WIN_Billing"), CreateEstimation("SYS_WIN_Estimation"), CreateOrder(
				"SYS_WIN_Order"), HomeDeliveryHistory("SYS_WIN_DeliveryList"), SalesInvoiceHistory(
						"SYS_WIN_SalesInvoices"), SalesOrderHistory("SYS_WIN_SalesOrders"), SalesEstimationHistory(
								"SYS_WIN_Quotations"), SalesReturnHistory(
										"SYS_WIN_ReturnInwards"), InventoryAdjustments(
												"SYS_WIN_InventoryEntry"), OperatingExpense(
														"SYS_WIN_OperatingExpenses"), KitchenOrderTicket(
																"SYS_WIN_KitchenOrderTicket"), CustomerOrderQueue(
																		"SYS_WIN_CustomerOrderQueue"), Productions(
																				"SYS_WIN_Productions"), CustomerFeedback(
																						"SYS_WIN_Feedback"), GRN(
																								"SYS_WIN_GRN"), PurchaseInvoice(
																										"SYS_WIN_PurchaseInvoice"), CustomerPromotions(
																												"SYS_WIN_CustomerPromotions");
		final String value;

		TransactionMenu(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum MasterMenu {
		Import("SYS_WIN_ImportData"), Segments("SYS_WIN_CustomerSegments"), Categories("SYS_WIN_Categories"), Products(
				"SYS_WIN_Products"), Brands("SYS_WIN_Brands"), Departments("SYS_WIN_Departments"), Units(
						"SYS_WIN_MeasurementUnits"), DiscountRule("SYS_WIN_DiscountRule"), Suppliers(
								"SYS_WIN_Suppliers"), Customers("SYS_WIN_Customers"), Agents(
										"SYS_WIN_Agents"), LoyaltyTypes("SYS_WIN_LoyaltyTypes"), TaxRate(
												"SYS_WIN_TaxRate"), TaxGroup("SYS_WIN_TaxGroup"), TableTypes(
														"SYS_WIN_TableTypes"), Tables("SYS_WIN_Tables"), Instructions(
																"SYS_WIN_Instructions"), BinLocations(
																		"SYS_WIN_BinLocations");
		final String value;

		MasterMenu(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum ReportMenu {
		DetailedInvoice("SYS_WIN_DetailedInvoice"), SalesByCategory("SYS_WIN_Salesbycategory"), SalesAnalysis(
				"SYS_WIN_SalesAnalysis"), GSTDashboard("SYS_WIN_GSTDashboard"), DetailedPurchaseInvoice(
						"SYS_WIN_DetailedPurchaseInvoice"), CustomerLedger("SYS_WIN_CustomerLedger"), EndOfDay(
								"SYS_WIN_Endofday"), ComplimentarySales("SYS_WIN_Salesofcomplimentary"), DetailedReturn(
										"SYS_WIN_Detailedreturnreport"), SalesAnalysisByTable(
												"SYS_WIN_Salesanalysisbytableno"), KOTAnalysis(
														"SYS_WIN_KitchenOrderAnalysis"), AverageKOTPreparationTime(
																"SYS_WIN_AverageKOTpreparationtime"), SalesOrderByTableTypes(
																		"SYS_WIN_Salesorderbytabletypes"), SalesByTableTypes(
																				"SYS_WIN_Salesbytabletypes"), SalesbyOrderTypes(
																						"SYS_WIN_Salesbyordertypes"), DetailedSalesOrder(
																								"SYS_WIN_Detailedsalesorder"), OrderSummary(
																										"SYS_WIN_Ordersummary"), OrderAnalysis(
																												"SYS_WIN_OrderAnalysis"), CancelledOrderAnalysis(
																														"SYS_WIN_Cancelledorderanalysis"), DailyBusinessControl(
																																"SYS_WIN_DailyBusinessControl"), HourlySales(
																																		"SYS_WIN_HourlySales"), ExchangeInvoice(
																																				"SYS_WIN_ExchangeInvoice"), ReturnInvoice(
																																						"SYS_WIN_ReturnInvoice"), NoOfProductsSoldBySalesPerson(
																																								"SYS_WIN_TopSeller"), SalesByProductQuantity(
																																										"SYS_WIN_Salesbyproductquantity"), SalesSummary(
																																												"SYS_WIN_Salessummary"), AvailableLoyaltyPoints(
																																														"SYS_WIN_Availableloyaltypoints"), SalesSummeryBySalesPerson(
																																																"SYS_WIN_Salessummerybysalesperson"), StockInHand(
																																																		"SYS_WIN_Stockinhand"), DailySalesByCard(
																																																				"SYS_WIN_Dailysalesbycard"), DailySalesByCash(
																																																						"SYS_WIN_Dailysalesbycash");
		final String value;

		ReportMenu(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum ConfigurationMenu {
		BusinessDetails("SYS_WIN_CompanyDetails"), ApplicationSetting("SYS_WIN_AppSetting"), Users(
				"SYS_WIN_Users"), Diagnostics("SYS_WIN_DataBackup");
		final String value;

		ConfigurationMenu(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum SupportMenu {
		MySubscription("SYS_WIN_MyAccount"), RateUs("SYS_WIN_AppFeedback"), Help("SYS_WIN_Help");
		final String value;

		SupportMenu(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

}
