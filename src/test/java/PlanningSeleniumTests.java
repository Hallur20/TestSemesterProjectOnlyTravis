
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en_old.Ða;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.core.IsEqual;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hallur
 */
@RunWith(MockitoJUnitRunner.class)
public class PlanningSeleniumTests {

    WebDriver driver;

    @Given("^user navigates to the teacher page$")
    public void navigatePage() {
        if (System.getProperty("os.name").startsWith("Linux")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        } else if (System.getProperty("os.name").startsWith("Windows")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
        }
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/TestSemesterProject/teacherPage.jsp");
    }

    @When("user clicks on 'see planning period'")
    public void clickBtn() {
        driver.findElement(By.id("planBtn")).click();
        String answ = driver.findElement(By.id("here")).getText();
        assertThat("when we can login with the teacher object, i can then setup the dates on this page", IsEqual.equalTo(answ));
    }
}
