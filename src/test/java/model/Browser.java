package model;

import org.openqa.selenium.WebDriver;

public class Browser {
    private WebDriver driver;
    private String importDriver;
    private String pathDriver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String getImportDriver() {
        return importDriver;
    }

    public void setImportDriver(String importDriver) {
        this.importDriver = importDriver;
    }

    public String getPathDriver() {
        return pathDriver;
    }

    public void setPathDriver(String pathDriver) {
        this.pathDriver = pathDriver;
    }
}
