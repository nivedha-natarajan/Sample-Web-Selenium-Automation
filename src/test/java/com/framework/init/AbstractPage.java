package com.framework.init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public abstract class AbstractPage extends WebDriverInit {

    /**
     * To get the PageFactory of the DOM
     *
     * @param driver WebDriver
     */
    public AbstractPage(WebDriver driver) {
        WebDriverInit.driver = driver;
        ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, EXPLICIT_WAIT);
        PageFactory.initElements(finder, this);
    }

}
