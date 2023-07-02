package tests;

import org.testng.annotations.Test;
import pageobjects.NavPage;

public class NavPageTest extends BaseTest {

	@Test (description = "printLangToConsole")
	public void tc01_printAllLang() {
		NavPage np = new NavPage(driver);
		np.PrintLangForEach();
	}

	@Test (description = "langValidation")
	public void tc02_selectEachLangAndValidate() {
		NavPage np = new NavPage(driver);
		np.languageValidation();
	}
}
