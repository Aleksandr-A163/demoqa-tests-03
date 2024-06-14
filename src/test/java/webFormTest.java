import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class webFormTest {
    @BeforeEach
    void setUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";


    }


    @Test
    void practiceForm() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("[id=firstName]").setValue("Ahmed");
        $("[id=lastName]").setValue("Ahmedov");
        $("[id=userEmail]").setValue("koreantech620@mail.ru").pressEnter();
        $("label[class=custom-control-label]").click();
        $("[id=userNumber]").setValue("79836025158");
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__year-select]>[value='2000']").click();
        $("[class=react-datepicker__month-select]>[value='3']").click();
        $(".react-datepicker__month .react-datepicker__day--024").click();
        $("[id=subjectsContainer]").click();
        $("[id=subjectsInput]").setValue("English").pressEnter();
        $("[id=subjectsInput]").setValue("Maths").pressEnter();
        $("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label").click();
        $("[id=uploadPicture]").uploadFromClasspath("D.jpg");
        $("[id=currentAddress]").click();
        $("[id=currentAddress]").setValue("Lenina 25");
        $("[id=react-select-3-input]").setValue("NCR").pressEnter();
        $("[id=react-select-4-input]").setValue("Delhi").pressEnter();
        $("[id=submit]").submit();
        $("[class=table-responsive]").shouldHave(Condition.text("Ahmed Ahmedov"));
        $("[class=table-responsive]").shouldHave(Condition.text("koreantech620@mail.ru"));
        $("[class=table-responsive]").shouldHave(Condition.text("1 December,1975"));
        $("[class=table-responsive]").shouldHave(Condition.text("Male"));
        $("[class=table-responsive]").shouldHave(Condition.text("7983602515"));
        $("[class=table-responsive]").shouldHave(Condition.text("Arabic"));
        $("[class=table-responsive]").shouldHave(Condition.text("Maths"));
        $("[class=table-responsive]").shouldHave(Condition.text("Sports"));
        $("[class=table-responsive]").shouldHave(Condition.text("D.jpg"));
        $("[class=table-responsive]").shouldHave(Condition.text("Aljamia 95"));
        $("[class=table-responsive]").shouldHave(Condition.text("DDG Cuma"));
        $("#closeLargeModal").click();
    }
}