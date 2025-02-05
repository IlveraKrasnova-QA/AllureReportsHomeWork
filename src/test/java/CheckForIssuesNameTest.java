import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class CheckForIssuesNameTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1928x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true; //потом удалить

    }

    @Test
    void checkForIssuesNameTest() {
        open("");
        $("[class=search-input]").click();
        $("[id=\"query-builder-test\"]").setValue("IlveraKrasnova-QA/AllureReportsHomeWork").submit();
        $(linkText("IlveraKrasnova-QA/AllureReportsHomeWork")).click();
        $("#issues-tab").click();
        $("[class=Title-module__container--l9xi7]").shouldHave(text("simple issue"));







    }
}
