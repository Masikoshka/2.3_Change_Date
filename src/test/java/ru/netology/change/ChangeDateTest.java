package ru.netology.change;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ChangeDateTest {

    @Test
    void ChangeCardDeliveryDate() {
        Configuration.headless = true;
        String planningDate = DataGenerator.dataDate();
        String planningDateNew = DataGenerator.dataDate();

        open ("http://localhost:9999/");
        $ ("[data-test-id='city'] input").setValue(DataGenerator.dataCity());
        $ ("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $ ("[data-test-id='date'] input").setValue(planningDate);
        $ ("[data-test-id='name'] input").setValue(DataGenerator.dataName());
        $ ("[data-test-id='phone'] input").setValue(DataGenerator.dataPhone());
        $ (".checkbox__box").click();
        $$ (".button__text").find(exactText("Запланировать")).click();
        $ ("[data-test-id='success-notification']").shouldBe(Condition.visible, Duration.ofSeconds(10));
        $ (".notification__content").shouldHave(text("Встреча успешно запланирована на " + planningDate));
        $ ("[data-test-id='date'] input").setValue(planningDateNew);
        $ (".button__text").click();
        $ ("[data-test-id='replan-notification']").shouldBe(Condition.visible);
        $$ (".button__text").find(exactText("Перепланировать")).click();
        $$ (".notification__content").find(exactText("Встреча успешно запланирована на " + planningDateNew));
    }
}
