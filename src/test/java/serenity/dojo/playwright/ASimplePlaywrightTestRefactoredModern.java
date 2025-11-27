package serenity.dojo.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UsePlaywright
public class ASimplePlaywrightTestRefactoredModern {


    //TEST 1: CREATE A WEB BROWSER AND PAGE

    // @Test
    void shouldShowThePageTitle(Page page) {
        page.navigate("https://practicesoftwaretesting.com/");

        //Step 5: Let the test begin:
        String title = page.title();
        System.out.println("Title of the page is: " + title);
        Assertions.assertTrue(title.contains("Practice Software Testing"));

    }

    // TEST 2: INTERACTING WITH ELEMENTS:
    @Test
    void shouldSearchByKeyword(Page page) {

        page.navigate("https://practicesoftwaretesting.com/");
        page.locator("[placeholder=Search]").fill("Pliers");
        page.locator("button:has-text('Search')").click();

    }
}
