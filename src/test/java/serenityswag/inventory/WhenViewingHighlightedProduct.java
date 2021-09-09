package serenityswag.inventory;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.LoginActions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static serenityswag.authentication.User.STANDARD_USER;


@RunWith(SerenityRunner.class)

public class WhenViewingHighlightedProduct {

    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;

    @Steps
    ViewProductDetailsActions viewProductDetails;

    ProductList productList;
    ProductDetails productDetails;

    @Test
    public void shouldSeeHighlightedProductsOnHomePage(){

        login.as(STANDARD_USER);
        List<String> highlightedItems = productList.titles();
        assertThat(highlightedItems).hasSize(6).contains("Sauce Labs Backpack");
    }

    @Test
    public void shouldDisplayTheCorrectDetails(){

        login.as(STANDARD_USER);
        String firstItem = productList.titles().get(0);
        viewProductDetails.forProductWithName(firstItem);
        Serenity.reportThat("Product name should be correctly displayed", () -> assertThat(productDetails.productName()).isEqualTo(firstItem));;
        Serenity.reportThat("Product image should show thw correct alt text", () -> productDetails.productImageWithAltValueOf(firstItem).shouldBeVisible());
    }

    @Test
    public void highlightedItemsShouldDisplayTheCorrectImages(){

        login.as(STANDARD_USER);
        List<String> highlightedItems = productList.titles();
        SoftAssertions softly = new SoftAssertions();
        highlightedItems.forEach(
                productName -> softly.assertThat(productList.imageTextForEachProduct(productName)).isEqualTo(productName)
        );
        softly.assertAll();
    }
}
