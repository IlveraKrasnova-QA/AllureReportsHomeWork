package AllureTest;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $("[class=search-input]").click();
        $("[id=\"query-builder-test\"]").setValue(repo).submit();
    }

    @Step("Кликаем на найденный репозиторий {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открываем раздел Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Находим нужный Issue {issue}")
    public void shouldBeIssue(String issue) {
        $("[class=Title-module__container--l9xi7]").shouldHave(text(issue));
    }
}


