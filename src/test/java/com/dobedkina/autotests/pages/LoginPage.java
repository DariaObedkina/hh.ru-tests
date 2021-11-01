package com.dobedkina.autotests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage {

    @Step("Expand login form to access password field")
    public LoginPage expandLoginForm() {
        $("[data-qa=expand-login-by-password]").click();
        return this;
    }

    @Step("Enter email")
    public LoginPage enterEmail(String email) {
        $("[data-qa=login-input-username]").setValue(email);
        return this;
    }

    @Step("Enter password")
    public LoginPage enterPassword(String password) {
        $("[data-qa=login-input-password]").setValue(password);
        return this;
    }

    @Step("Submit expanded login form")
    public LoginPage submitExpandedLoginForm() {
        $("[data-qa=account-login-submit]").click();
        return this;
    }


    @Step("Email field is visible after failed login attempt")
    public LoginPage checkThatEmailIsVisibleAfterFailedLogin() {
        $("[data-qa=login-input-username]").shouldBe(Condition.visible);
        return this;
    }

    @Step("Password field is visible after failed login attempt")
    public LoginPage checkThatPasswordIsVisibleAfterFailedLogin() {
        $("[data-qa=login-input-password]").shouldBe(Condition.visible);
        return this;
    }

    @Step("Error message \"Неправильные данные для входа. Пожалуйста, попробуйте снова.\" is displayed")
    public LoginPage checkIncorrectLoginErrorMessage() {
        $("[data-qa=account-login-error]")
                .shouldHave(Condition.text("Неправильные данные для входа. Пожалуйста, попробуйте снова."));
        return this;
    }

    @Step("Email field has red border")
    public LoginPage checkThatEmailFieldHasRedBorder() {
        $("[data-qa=login-input-username]").shouldHave(cssClass("bloko-input_invalid"));
        return this;
    }

    @Step("Password field has red border")
    public LoginPage checkThatPasswordFieldHasRedBorder() {
        $("[data-qa=login-input-password]").shouldHave(cssClass("bloko-input_invalid"));
        return this;
    }

    @Step("Every login form field has message \"Обязательное поле\"")
    public LoginPage checkThatLoginFormFieldsHaveMandatoryFieldErrorMessage() {
        for (SelenideElement element : $$("div .bloko-form-item + div")) {
            element.shouldHave(text("Обязательное поле"));
        }
        return this;
    }


}
