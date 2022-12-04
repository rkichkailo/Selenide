package com.it_academy.onliner.page_object;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.it_academy.onliner.framework.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.CollectionCondition.allMatch;
import static com.codeborne.selenide.Selenide.$x;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.By.xpath;

public class Product extends BasePage {

    public static final SelenideElement PRODUCTS_ACTIVE_CATEGORY_XPATH =
            $x("//*[contains(@class, 'aside-item_active')]");
    public static final String PRODUCT_TITLES_XPATH
            = ".//*[contains (@class, 'list__dropdown-title')]";
    public static final String PRODUCT_DATA_XPATH
            = ".//*[contains (@class, 'list__dropdown-description')]";
    private static final String PRODUCT_COUNTER_PATTERN = "товар";
    private static final String PRODUCT_PRICE_PATTERN = "р.";

    public static ElementsCollection getProducts(){
        return PRODUCTS_ACTIVE_CATEGORY_XPATH
                .findAll("a")
                .shouldHave(sizeGreaterThan(0), ofSeconds(10));
    }

    public ElementsCollection getProductsTitlesLinks(){
        return PRODUCTS_ACTIVE_CATEGORY_XPATH
                .findAll(xpath(PRODUCT_TITLES_XPATH))
                .shouldHave(sizeGreaterThan(0), ofSeconds(10));
    }

    @Step
    public Product assertEachProductHasTitle(){
        getProductsTitlesLinks()
                .shouldHave(noneMatch("Some categories are empty",
                        element -> element.getText().isBlank()), ofSeconds(10))
                .shouldHave(size(getProducts().size()), ofSeconds(10));
        return this;
    }

    public ElementsCollection getProductsDataLinks(){
        return PRODUCTS_ACTIVE_CATEGORY_XPATH
                .findAll(xpath(PRODUCT_DATA_XPATH))
                .shouldHave(sizeGreaterThan(0), ofSeconds(10));
    }

    @Step
    public Product assertEachProductHasData(){
        getProductsDataLinks()
                .shouldHave(noneMatch("Some categories are empty",
                        element -> element.getText().isBlank()), ofSeconds(10))
                .shouldHave(size(getProducts().size()), ofSeconds(10));
        return this;
    }

    @Step
    public Product assertEachProductHasCount(){
        getProductsDataLinks()
                .shouldHave(allMatch("Each element has count",
                        element -> element.getText()
                .contains(PRODUCT_COUNTER_PATTERN)), ofSeconds(10));
        return this;
    }

    @Step
    public void assertEachProductHasPrice(){
        getProductsDataLinks()
                .shouldHave(allMatch("Each element has price",
                        element -> element.getText()
                .endsWith(PRODUCT_PRICE_PATTERN)), ofSeconds(10));
    }
}
