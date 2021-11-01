package com.dobedkina.autotests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.dobedkina.autotests.testData.RandomNumber;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final String PAGE_LINK = "https://hh.ru/?customDomain=1";

    @Step("Open main page")
    public MainPage openPage() {
        Selenide.open(PAGE_LINK);
        return this;
    }

    @Step("Enter {vacancy} in the search field")
    public MainPage setSearchValue(String searchValue) {
        $("[data-qa=search-input]").setValue(searchValue);
        return this;
    }

    @Step("Press button \"Найти работу\"")
    public MainPage pressFindJobButton() {
        $("[data-qa=search-button]").click();
        return this;
    }

    @Step("First vacancy name satisfies the searched value")
    public MainPage checkFirstVacancyNameInTheList(String vacancy) {
        $("[data-qa=vacancy-serp__vacancy-title]").shouldHave(Condition.text(vacancy));
        return this;
    }

    @Step("Search suggestions are visible")
    public MainPage checkIfSuggestionsAreVisible() {
        $(".suggest__items").shouldBe(Condition.visible);
        return this;
    }

    @Step("First search suggestion  = {searchValue}")
    public MainPage checkFirstSuggestionText(String searchValue) {
        $(".suggest__item").shouldHave(Condition.text(searchValue));
        return this;
    }

    @Step("Go to Advanced search page")
    public void goToAdvancedSearchPage() {
        $("[data-qa=advanced-search]").click();
    }

    @Step("Selected experience option is checked in side bar filter panel")
    public MainPage checkThatExperienceSelectedInSideBarFilter(String experience) {
        $(String.format("[value=%s]", experience)).scrollTo().shouldHave(Condition.attribute("checked", ""));
        return this;
    }

    @Step("Vacancies are filtered correctly by selected work experience")
    public void checkThatVacanciesFilteredByExperience(String experience) {
        $$("[data-qa=vacancy-serp__vacancy-title]").get(0).click();
        switchTo().window(1);
        $("[data-qa=vacancy-experience]").shouldHave(Condition.text(experience)); //проверка требуемого опыта у 1й вакансии в списке
        switchTo().window(0);
        $$("[data-qa=vacancy-serp__vacancy-title]").get(RandomNumber.rnd(1, 15)).click(); //проверка требуемого опыта у случайной вакансии со 2й по 15
        switchTo().window(2);
        $("[data-qa=vacancy-experience]").shouldHave(Condition.text(experience));
        closeWindow();
    }

    @Step("Go to Login page")
    public void goToLoginPage() {
        $(By.linkText("Войти")).click();
    }

    @Step("User is logged")
    public MainPage checkThatUserIsLogged() {
        $("[data-qa='mainmenu_applicantProfile ']").shouldBe(Condition.visible);
        $("[data-qa=mainmenu_myResumes]").shouldBe(Condition.visible);
        return this;
    }
}
