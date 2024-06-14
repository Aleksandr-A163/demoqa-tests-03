package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.text;

public class WebFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }


    @Test
    void webFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ahmed");
        $("#lastName").setValue("Ahmedov");
        $("#userEmail").setValue("testahmed@gmail.com");
        $("#gender-radio-1+label").click();
        $("#userNumber").setValue("79047446844");
        $("#dateOfBirth #dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1985");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbies-checkbox-1+label").click();
        $("#hobbies-checkbox-2+label").click();
        $("#hobbies-checkbox-3+label").click();
        $("#uploadPicture").scrollIntoView(true);
        $("#uploadPicture").uploadFromClasspath("leopard.png");
        $("#currentAddress").setValue("Istanbul");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").click();

        $("[class=table-responsive]").shouldHave(text("Ahmed Ahmedov"));
        $("[class=table-responsive]").shouldHave(text("testahmed@gmail.com"));
        $("[class=table-responsive]").shouldHave(text("Male"));
        $("[class=table-responsive]").shouldHave(text("79047446844"));
        $("[class=table-responsive]").shouldHave(text("01 April,1985"));
        $("[class=table-responsive]").shouldHave(text("Maths"));
        $("[class=table-responsive]").shouldHave(text("Sports, Reading, Music"));
        $("[class=table-responsive]").shouldHave(text("leopard.png"));
        $("[class=table-responsive]").shouldHave(text("USA"));
        $("[class=table-responsive]").shouldHave(text("Haryana Karnal"));
    }
}