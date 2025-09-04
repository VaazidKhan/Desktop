package JBInstallation;

import org.testng.annotations.Test;

import JBWindows.Installation.JB_Uninstall;
import commonClass.BaseClass;

public class JB_Uninstall_Test extends BaseClass{
	
	JB_Uninstall refUninstall;
	
	public JB_Uninstall_Test() {
		super();
	}

	@Test(priority = 0, enabled = true)
	public void Uninstall_Application() {
		refUninstall = new JB_Uninstall();
		refUninstall.Uninstall_JustBilling();
	}
}
