package pageobjects;

import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class NavPage extends BasePage {


	@FindBy(css = ".header-only-mobile .languageLink>a")
	private List<WebElement> langList;

	@FindBy(css = ".lang-bttn>.current-language")
	private WebElement langBtn;


	public NavPage(WebDriver driver) {
		super(driver);
	}


	public void PrintLang() {
		click(langBtn);
		for (WebElement langList : langList) {
			System.out.println(langList.getText());

		}
	} 
	//optional:
	public void PrintLangForEach() {
		click(langBtn);
		System.out.println("available Language:");
		langList.forEach(element -> System.out.println(element.getText()));

	}

	public void languageValidation() {
		for (int i = 0; i < langList.size(); i++) {
			WebElement element = langList.get(i);
			String href = element.getAttribute("href").toLowerCase();
			try {
				element.click();

				String text = langBtn.getText().toLowerCase();
				Pattern pattern = Pattern.compile(Pattern.quote(text));
				Assert.assertTrue(pattern.matcher(href).find());

				click(langBtn);

			} catch (Exception e) {
				System.out.println("Error clicking element: " + e.getMessage());
			}
		}
	}

}

