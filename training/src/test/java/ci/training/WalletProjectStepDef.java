package ci.training;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import ci.training.beans.Customer;
import ci.training.repo.WalletRepo;
import ci.training.repo.WalletRepoImpl;
import ci.training.service.WalletService;
import ci.training.service.WalletServiceImpl;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WalletProjectStepDef {

	private WalletService ws;
	private Customer cust;
	private WalletRepo myRepo = new WalletRepoImpl();
@Given("^I want a new account$")
public void i_want_a_new_account() throws Throwable {
    ws = new WalletServiceImpl(myRepo);
}

@When("^I pass in the name as \"(.*?)\" and the phone number as \"(.*?)\", and the amount as (\\d+)$")
public void i_pass_in_the_name_as_and_the_phone_number_as_and_the_amount_as(String name, String phone, BigDecimal amount) throws Throwable {
    cust = ws.createWallet(name, phone, amount);
}

@Then("^I should have an account with the name as \"(.*?)\" and the phone number as \"(.*?)\" and the balance as (\\d+)$")
public void i_should_have_an_account_with_the_name_as_and_the_phone_number_as_and_the_balance_as(String name, String phone, BigDecimal amount) throws Throwable {
    cust = myRepo.find(phone);
	assertEquals(cust.getName(), name);
    assertEquals(cust.getPhoneNumber(), phone);
    assertEquals(cust.getWallet().getBalance(), amount);
}

}
