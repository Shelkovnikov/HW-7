import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckName {
    public CheckName  headerNamesCheck(String Name) {
        $(".tab-list__custom-wrap").shouldHave(text(Name));
        return this;
    }
}