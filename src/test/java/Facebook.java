import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.Test;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Facebook {
    @Test
    public void facebook(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://www.facebook.com/";
        System.setProperty("webdriver.chrome.driver", "files/chromedriver.exe");
        Configuration.startMaximized = true;
        Selenide.open("https://www.facebook.com/");
        $(byText("Create New Account")).click();
        $(byName("firstname")).setValue("Keti");
        $(byName("lastname")).setValue("Nozadze");
        $(byName("reg_email__")).setValue("nozadze.kate@gmail.com");
        $(byName("reg_passwd__")).setValue("Aa0981BB");
        $("#month").selectOption("Nov");
        $("#day").selectOption("8");
        $("#year").selectOption("1989");
        $(byText("Custom")).click();
        $(byText("Select your pronoun")).shouldBe(Condition.visible);
        $(byName("custom_gender")).shouldBe(Condition.visible);
        $("._7-16").selectOption("She: \"Wish her a happy birthday!\"");
        $(byText("Female")).click();
        $(byText("Select your pronoun")).shouldBe(Condition.hidden);
        $(byName("custom_gender")).shouldBe(Condition.hidden);

    }

}
