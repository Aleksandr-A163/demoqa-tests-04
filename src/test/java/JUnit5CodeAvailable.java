import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.Selenide.open;

public class JUnit5CodeAvailable {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @AfterEach
    void afterEach(){
        closeWebDriver();
    }
    @Test
        void searchJUnit5Code() {
        open("/selenide/selenide");


        $("#wiki-tab").click();

        $("#wiki-body .markdown-body").$$("li").shouldHave(itemWithText("Soft assertions"));

        $("#wiki-body .markdown-body").$(byText("Soft assertions")).click();
        $(".markdown-body").shouldHave(text("""
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                @Test
                void test() {
                Configuration.assertionMode = SOFT;
                open("page.html");
                $("#first").should(visible).click();
                $("#second").should(visible).click();
                }
                }"""));
    }
}