package com.dobedkina.autotests.testData;

public enum ExperienceSearchOptions {
    DOESNOTMATTER("doesNotMatter", "не имеет значения"),
    NOEXP("noExperience", "Нет опыта", "не требуется"),
    ONE_THREE("between1And3", "От 1 года до 3 лет", "1–3 года"),
    THREE_SIX("between3And6", "От 3 до 6 лет", "3–6 лет"),
    SIX_PLUS("moreThan6", "Более 6 лет", "более 6 лет");

    private String selector; //часть селектора data-qa, явно указывающая на  опцию фильтра
    private String filterOptionName; //текст опции фильтра
    private String textInVacancy; //текст, который отображается в вакансии

    ExperienceSearchOptions(String selector, String filterOptionName, String textInVacancy) {
        this.selector = selector;
        this.filterOptionName = filterOptionName;
        this.textInVacancy = textInVacancy;
    }

    ExperienceSearchOptions(String selector, String filterOptionName) {
        this.selector = selector;
        this.filterOptionName = filterOptionName;
    }

    public String getSelector() {
        return selector;
    }

    public String getFilterOptionName() {
        return filterOptionName;
    }

    public String getTextInVacancy() {
        return textInVacancy;
    }
}
