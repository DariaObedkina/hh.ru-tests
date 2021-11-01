package com.dobedkina.autotests.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class AdvancedSearchPage {
    @Step("Select option in the filter \"Требуемый опыт работы\"")
    public AdvancedSearchPage selectOptionFromWorkExperienceFilter(String experience) {
        $(String.format("[data-qa='control-vacancysearch__experience-item control-vacancysearch__experience-item_%s'", experience))
                .$(".bloko-radio__text").scrollTo().click();
        return this;
    }

    @Step("Apply selected filters")
    public void applyFilters() {
        $(byId("submit-bottom")).click();
    }

}
