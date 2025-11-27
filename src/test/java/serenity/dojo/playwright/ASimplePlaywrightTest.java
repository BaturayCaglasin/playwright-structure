package serenity.dojo.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ASimplePlaywrightTest {


    //TEST 1: CREATE A WEB BROWSER AND PAGE

    // @Test
    void shouldShowThePageTitle() {
        //Step 1: Create an instance from playwright:
        Playwright playwright = Playwright.create(); //it will set up the playwright for us.
        //Step 2: Create a browser from that playwright instance:
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); //it will set up the browser.
        /**
         * typed "launch(new BrowserType.LaunchOptions().setHeadless(false)" becuase the playwright starts with always headless.
         * I wanted to see the elements while I executed the code.
         * You can switch the headless mode by typing setHeadless(true)
         */
        //Step 3: This browser has many pages. Create a page instance to use it:
        Page page = browser.newPage();
        //Step 4: Navigate to the URL that you will test:
        page.navigate("https://practicesoftwaretesting.com/");

        //Step 5: Let the test begin:
        String title = page.title();
        System.out.println("Title of the page is: " + title);
        Assertions.assertTrue(title.contains("Practice Software Testing"));

        //Step 6: Close the browser:
        browser.close();
        //Step 7: Close the Playwright:
        playwright.close();

    }

    // TEST 2: INTERACTING WITH ELEMENTS:
    @Test
    void shouldSearchByKeyword() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://practicesoftwaretesting.com/");
        page.locator("[placeholder=Search]").fill("Pliers");
        page.locator("button:has-text('Search')").click();

        browser.close();
        playwright.close();
    }
}
