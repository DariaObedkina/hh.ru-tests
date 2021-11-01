package com.dobedkina.autotests.tests;

import com.dobedkina.autotests.pages.AdvancedSearchPage;
import com.dobedkina.autotests.pages.MainPage;
import com.dobedkina.autotests.testData.ExperienceSearchOptions;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;


public class SearchTests {
    MainPage mainPage = new MainPage();
    AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage();

    @Test
    @Description("Search by vacancy name without advanced filters")
    void simpleSearchByVacancyName() {
        String vacancy = "Водитель";
        mainPage
                .openPage()
                .setSearchValue(vacancy)
                .pressFindJobButton();
        mainPage
                .checkFirstVacancyNameInTheList(vacancy);

    }

    @EnumSource(value = ExperienceSearchOptions.class, names = {"DOESNOTMATTER"}, mode = EnumSource.Mode.EXCLUDE)
    @ParameterizedTest(name = "Advanced search. Filtering vacancies by desired work experience: " + "{0}")
    void advancedSearchExperienceFilter(ExperienceSearchOptions experienceSearchOptions) {
        mainPage
                .openPage()
                .goToAdvancedSearchPage();
        advancedSearchPage
                .selectOptionFromWorkExperienceFilter(experienceSearchOptions.getSelector())
                .applyFilters();
        mainPage
                .checkThatExperienceSelectedInSideBarFilter(experienceSearchOptions.getSelector())
                .checkThatVacanciesFilteredByExperience(experienceSearchOptions.getTextInVacancy());
    }
}
