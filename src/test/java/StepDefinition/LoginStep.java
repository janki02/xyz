package StepDefinition;

import org.testng.Assert;

import com.pages.LoginPage;
import com.qa.Factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {
	private static String Title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	

	@Given("user is on longin page")
	public void user_is_on_longin_page() {
		DriverFactory.getDriver().get("https://admin-demo.nopcommerce.com/login");
	}

	@When("user get title of the page")
	public void user_get_title_of_the_page() {
		Title = loginPage.Login_Page_Title();
		System.out.println("The Login page Title is:  " + Title);

	}

	@Then("title should be {string}")
	public void title_should_be(String exptitlename) {
		Assert.assertTrue(Title.equals(exptitlename));
	}

	@Then("Remember me CheckBox should be displayed")
	public void remember_me_check_box_should_be_displayed() {
		Assert.assertTrue(loginPage.Login_CheckBox());

	}

	@When("user enter the Email  {string}")
	public void user_enter_the_email(String Email_id) {
		loginPage.Enter_EmailID(Email_id);
	}

	@When("user enter the Password {string}")
	public void user_enter_the_password(String Password) {
		loginPage.Enter_Password(Password);
		;
	}

	@When("user click longin button")
	public void user_click_longin_button() {
		loginPage.click_on_Login_button();

	}

	@Then("homePage title should be {string}")
	public void home_page_title_should_be(String string) {
		Title = loginPage.Home_Page_Title();
		System.out.println("The Login page Title is:  " + Title);
	}

}
