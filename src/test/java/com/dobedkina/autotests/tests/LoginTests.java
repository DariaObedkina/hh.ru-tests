package com.dobedkina.autotests.tests;

import com.dobedkina.autotests.config.hh.ru.AppConfig;
import com.dobedkina.autotests.pages.LoginPage;
import com.dobedkina.autotests.pages.MainPage;
import io.qameta.allure.Description;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;


public class LoginTests {
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    AppConfig credentials = ConfigFactory.create(AppConfig.class);

    @Test
    @Description("Successful login with correct email and password")
    void successfulLoginWithEmailAndPassword() {
        mainPage
                .openPage()
                .goToLoginPage();
        loginPage
                .expandLoginForm()
                .enterEmail(credentials.userEmail())
                .enterPassword(credentials.userPassword())
                .submitExpandedLoginForm();
        mainPage
                .checkThatUserIsLogged();
    }

    @Test
    @Description("Failed login with wrong email and password")
    void failedLoginWithWrongEmailAndWrongPassword() {
        mainPage
                .openPage()
                .goToLoginPage();
        loginPage
                .expandLoginForm()
                .enterEmail("wrongemail@test.test")
                .enterPassword("wrongpassword")
                .submitExpandedLoginForm();
        loginPage
                .checkThatEmailIsVisibleAfterFailedLogin()
                .checkThatPasswordIsVisibleAfterFailedLogin()
                .checkIncorrectLoginErrorMessage();
    }

    @Test
    @Description("Failed login with blank email and password")
    void failedLoginWithBlankEmailAndPassword() {
        mainPage
                .openPage()
                .goToLoginPage();
        loginPage
                .expandLoginForm()
                .submitExpandedLoginForm();
        loginPage
                .checkThatEmailIsVisibleAfterFailedLogin()
                .checkThatPasswordIsVisibleAfterFailedLogin()
                .checkThatEmailFieldHasRedBorder()
                .checkThatPasswordFieldHasRedBorder()
                .checkThatLoginFormFieldsHaveMandatoryFieldErrorMessage();

    }
}
