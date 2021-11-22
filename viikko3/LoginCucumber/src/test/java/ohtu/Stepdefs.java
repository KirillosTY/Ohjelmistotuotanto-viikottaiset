package ohtu;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ohtu.data_access.InMemoryUserDao;
import ohtu.data_access.UserDao;
import ohtu.io.StubIO;
import ohtu.services.AuthenticationService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Stepdefs {
    App app;
    StubIO io;
    UserDao userDao;
    AuthenticationService auth;
    List<String> inputLines;
    
    @Before
    public void setup(){
        userDao = new InMemoryUserDao();
        auth = new AuthenticationService(userDao);
        inputLines = new ArrayList<>();

    }
    
    @Given("^command login is selected$")
    public void commandLoginSelected() throws Throwable {
        inputLines.add("login");
    }

    @When("username {string} and password {string} are entered")
    public void usernameAndPasswordAreEntered(String username, String password) {
       inputLines.add(username);
       inputLines.add(password);

       io = new StubIO(inputLines);
       app = new App(io, auth);
       app.run();
    }

    @When("username {string} and wrong password {string} are entered.")
    public void usernameAndWrongPasswordAreEntered(String username, String password) {
        inputLines.add(username);
        inputLines.add(password);

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }

    @When("when {string} and {string} are entered.")
    public void whenAndAreEntered(String username, String password) {

        inputLines.add(username);
        inputLines.add(password);

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }


    @Then("system will respond with {string}")
    public void systemWillRespondWith(String expectedOutput) {
        assertTrue(io.getPrints().contains(expectedOutput));
    }


    @Given("command new is selected")
    public void commandNewIsSelected() {
        inputLines.add("new");

    }


    @When("{string} and password {string} are entered")
    public void andNoNumbersPAreEntered(String username, String password) {

        inputLines.add(username);
        inputLines.add(password);

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();

    }

    @When("{string} and right login password {string} are entered")
    public void andRightLoginPasswordAreEntered(String string, String string2) {
        inputLines.add(string);
        inputLines.add(string2);

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();


    }


    @When("{string} and shortP {string} are entered")
    public void andShortPAreEntered(String string, String string2) {
        inputLines.add(string);
        inputLines.add(string2);

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }



    @When("{string} and {string} are entered")
    public void andAreEntered(String string, String string2) {
        inputLines.add(string);
        inputLines.add(string2);

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }
    @When("{string} and Numbers0 P {string} are entered")
    public void andNumbers0PAreEntered(String string, String string2) {
        inputLines.add(string);
        inputLines.add(string2);

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }


    @Then("the system will respond with {string}")
    public void theSystemWillRespondWith(String expectedOutput) {
        assertTrue(io.getPrints().contains(expectedOutput));
    }

    @Given("user {string} with password {string} is created")
    public void userWithPasswordIsCreated(String string, String string2) {

        inputLines.add("new");
        inputLines.add(string);
        inputLines.add(string2);

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }
    @When("user {string} with password {string} are entered")
    public void userWithPasswordAreEntered(String string, String string2) {
        inputLines.add(string);
        inputLines.add(string2);

        io = new StubIO(inputLines);
        app = new App(io, auth);
        app.run();
    }

}
