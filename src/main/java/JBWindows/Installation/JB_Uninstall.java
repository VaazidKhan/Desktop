package JBWindows.Installation;

import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import commonClass.BaseClass;
import commonClass.GenericMethods;

public class JB_Uninstall extends BaseClass {

	public JB_Uninstall() {
		PageFactory.initElements(driver, this);
	}

	private static Screen refScreen;

	public void Uninstall_JustBilling() {

		try {
			refScreen = new Screen();
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\Uninstall\\Welcome_BTN_Next.PNG");
			GenericMethods.fnwait(2);
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\Uninstall\\RDBTN_Remove.PNG");
			GenericMethods.fnwait(2);
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\Uninstall\\PGMMain_BTN_Next.PNG");
			GenericMethods.fnwait(2);
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\Uninstall\\RemoveButton.PNG");
			GenericMethods.fnwait(10);
			refScreen.click(System.getProperty("user.dir") + "\\Sikuli-Images\\Uninstall\\FinishButton.PNG");

		} catch (FindFailed e) {
			e.printStackTrace();
			System.out.println("Image not found");
		}
	}
}
