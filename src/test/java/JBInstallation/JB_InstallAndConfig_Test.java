package JBInstallation;

import org.testng.annotations.Test;

import JBWindows.Installation.JB_InstallAndConfig;
import commonClass.BaseClass;

public class JB_InstallAndConfig_Test extends BaseClass {

	JB_InstallAndConfig refInstall;

	public JB_InstallAndConfig_Test() {
		super();
	}

	@Test
	public void Install_And_Configure_Application() {
		refInstall = new JB_InstallAndConfig();
		refInstall.SetupJB();
	}

}
