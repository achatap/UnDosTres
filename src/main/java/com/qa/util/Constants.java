package com.qa.util;

public interface Constants {

    String browser= System.getProperty(BROWSER_SPECIFICATION.BROWSERKEY,BROWSER_SPECIFICATION.BROWSERDEFAULTVALUE);

    interface BROWSER_SPECIFICATION {

        String BROWSERKEY = "browser";
        String CHROME = "chrome";
        String FIREFOX = "firefox";
        String IE = "ie";
        String SAFARI = "safari";
        String BROWSERDEFAULTVALUE = CHROME;
    }
}
