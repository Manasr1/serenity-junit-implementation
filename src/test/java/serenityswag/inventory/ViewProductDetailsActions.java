package serenityswag.inventory;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class ViewProductDetailsActions extends UIInteractionSteps {

    @Step("view product details for product '{0}'")
    public void forProductWithName(String firstItem) {
       $(ProductList.productDetailsLinkFor(firstItem)).click();
    }
}
