
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static org.openqa.selenium.By.linkText;

public class CheckForIssuesNameTest extends TestBase {

    private static final String REPOSITORY = "IlveraKrasnova-QA/AllureReportsHomeWork";
    private static final String ISSUES = "simple issue";

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
    public void checkForIssuesNameWithStepLyambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("");
                });

        step("Ищем репозиторий" + REPOSITORY, () -> {
            $("[class=search-input]").click();
            $("[id=\"query-builder-test\"]").setValue(REPOSITORY).submit();
        });

        step("Кликаем на найденный реппозиторий" + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Открываем раздел Issues", () -> {
            $("#issues-tab").click();
        });

        step("Находим нужный Issue" + ISSUES, () -> {
            $("[class=Title-module__container--l9xi7]").shouldHave(text(ISSUES));
        });

    }

    @Test
    public void checkForIssuesNameWithStepsTest() {
        WebSteps steps = new WebSteps();
        SelenideLogger.addListener("allure", new AllureSelenide());

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldBeIssue(ISSUES);

    }
}
