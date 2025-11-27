package serenity.dojo.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ASimplePlaywrightTestRefactoredByBeforeEach {
    Playwright playwright;
    Browser browser;
    Page page;


    @BeforeEach
    void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @AfterEach
    void teardown() {
        browser.close();
        page.close();
    }

    //TEST 1: CREATE A WEB BROWSER AND PAGE

    // @Test
    void shouldShowThePageTitle() {
        page.navigate("https://practicesoftwaretesting.com/");

        //Step 5: Let the test begin:
        String title = page.title();
        System.out.println("Title of the page is: " + title);
        Assertions.assertTrue(title.contains("Practice Software Testing"));

    }

    // TEST 2: INTERACTING WITH ELEMENTS:
    @Test
    void shouldSearchByKeyword() {

        page.navigate("https://practicesoftwaretesting.com/");
        page.locator("[placeholder=Search]").fill("Pliers");
        page.locator("button:has-text('Search')").click();

    }
}
