import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckForIssuesNameTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1928x1080";
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void checkForIssuesNameTest() {
        open("");
        $("[class=search-input]").click();
        $("[id=\"query-builder-test\"]").setValue("jkjnb").submit();






    }
}
