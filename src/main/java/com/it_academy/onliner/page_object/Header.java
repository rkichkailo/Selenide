package com.it_academy.onliner.page_object;

import com.codeborne.selenide.ElementsCollection;
import com.it_academy.onliner.framework.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$$x;
import static java.time.Duration.ofSeconds;

public class Header extends BasePage{
    public static final ElementsCollection MAIN_NAVIGATION_BAR_LINKS =
            $$x("//*[@class = 'b-main-navigation__text']");

    public void clickOnMainNavigationBarLink(String link){
        MAIN_NAVIGATION_BAR_LINKS
                .findBy(text(link))
                .shouldBe(and("clickable", visible, enabled), ofSeconds(10))
                .click();
    }

    @Step
    public CatalogPage clickOnCatalogLink(){
        clickOnMainNavigationBarLink("Каталог");
        return new CatalogPage();
    }
}
