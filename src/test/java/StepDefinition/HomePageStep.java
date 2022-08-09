package StepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.Factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStep {
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homepage;
	private static String title;

	@Given("User has already Logged in to applicatioin")
	public void user_has_already_logged_in_to_applicatioin(DataTable dataTable) {
		List<Map<String, String>> UserList = dataTable.asMaps();
		String Email_id = UserList.get(0).get("Email");
		String PWS = UserList.get(0).get("Password");

		DriverFactory.getDriver().get("https://admin-demo.nopcommerce.com/login");
		homepage = loginPage.DoLogin(Email_id, PWS);

	}
	
	@Then("nopcommerce Logo Should be displayed")
	public void nopcommerce_logo_should_be_displayed() {
		Assert.assertTrue(homepage.nopcommerce_Logo());

	}

	@Given("User is on Home_Page")
	public void user_is_on_home_page() {
		homepage.Home_Page_Title();
		

	}

	@Then("User gets Dashboard Link")
	public void user_gets_dashboard_link(DataTable dataTable) {
		List<String> ExpDashboardLink =homepage.Dashboard_Link();
		System.out.println("Expedted List:  "+ ExpDashboardLink );
		
		List<String> ActulDashboardLink =homepage.Dashboard_Link();
		System.out.println("Expedted List:  "+ ActulDashboardLink );
		Assert.assertTrue(ExpDashboardLink.containsAll(ActulDashboardLink));
	}

	@Then("Dashboard Link Count Should be {int}")
	public void dashboard_link_count_should_be(Integer expectedCount) {
		Assert.assertTrue(homepage.Home_Page_Link_Count() == expectedCount);
	}

	@Then("Logout")
	public void logout() {
		homepage.Logout();

	}

}
