import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchTest {






        @AfterEach
        void EndTest() {
            closeWebDriver();
        }

        @Test
        void SuccessLogin () {
//        Configuration.holdBrowserOpen = true;

            open("https://auth.niffler.qa.guru/login");

            $("[name=username]").setValue("AndreyCipa");
            $("[name=password]").setValue("Cipa1234");
            $("button[type=submit]").click();
            $("[id=spendings]").shouldHave(text("History of Spendings"));

        }

        @Test
        void unSuccessLogin () {
//        Configuration.holdBrowserOpen = true;

            open("https://auth.niffler.qa.guru/login");

            $("[name=username]").setValue("AndreyCipa");
            $("[name=password]").setValue("Cipa1234");
            $("button[type=submit]").click();
            $("[id=spendings]").shouldHave(text("History of Spendings"));
            $("button[aria-label=Menu]").click();
            $("[role=menu]"). $(byText("Sign out")).click();
            $("[role=dialog]"). $(byText("Log out")).click();
            $("[class=header]").shouldHave(text("Log in"));

        }

        @Test
        void SuccessPressEnterLogin () {
//        Configuration.holdBrowserOpen = true;

            open("https://auth.niffler.qa.guru/login");

            $("[name=username]").setValue("AndreyCipa");
            $("[name=password]").setValue("Cipa1234").pressEnter();

            $("[id=spendings]").shouldHave(text("History of Spendings"));

        }
        @Test
        void errorSuccessLogin () {
//        Configuration.holdBrowserOpen = true;

            open("https://auth.niffler.qa.guru/login");

            $("[name=username]").setValue("AndreyCipa");
            $("[name=password]").setValue("Cipa12341").pressEnter();

            $("[class=form__error]").shouldHave(text("Неверные учетные данные пользователя"));

        }

    }


