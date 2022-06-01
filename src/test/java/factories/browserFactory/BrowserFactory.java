package factories.browserFactory;

public class BrowserFactory {
    public void  chooseBrowser(String importDriver, String pathDriver) {
        System.setProperty(importDriver, pathDriver);
    }

}
