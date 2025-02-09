import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static org.openqa.selenium.By.linkText;

public class CheckForIssuesNameTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1928x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    private static final String Repository = "IlveraKrasnova-QA/AllureReportsHomeWork";
    private static final String Issues = "simple issue";

    @Test
    public void checkForIssuesNameSelenideTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("");
        $("[class=search-input]").click();
        $("[id=\"query-builder-test\"]").setValue("IlveraKrasnova-QA/AllureReportsHomeWork").submit();
        $(linkText("IlveraKrasnova-QA/AllureReportsHomeWork")).click();
        $("#issues-tab").click();
        $("[class=Title-module__container--l9xi7]").shouldHave(text("simple issue"));
    }

    @Test
    public void checkForIssuesNameWithStepsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("");
                });

        step("Ищем репозиторий" + Repository, () -> {
            $("[class=search-input]").click();
            $("[id=\"query-builder-test\"]").setValue(Repository).submit();
        });

        step("Кликаем на найденный реппозиторий" + Repository, () -> {
            $(linkText(Repository)).click();
        });

        step("Открываем раздел Issues", () -> {
            $("#issues-tab").click();
        });

        step("Находим нужный Issue" + Issues, () -> {
            $("[class=Title-module__container--l9xi7]").shouldHave(text(Issues));
        });

    }


}
