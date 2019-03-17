package ru.stqa.pft.mantis.model;

import org.openqa.selenium.WebElement;

public class UserData {

    private String userName;
    private String email;
    private String levelOfAccess;

    public WebElement getWebElementToClick() {
        return webElementToClick;
    }

    public UserData withWebElementToClick(WebElement webElementToClick) {
        this.webElementToClick = webElementToClick;
        return this;
    }

    private WebElement webElementToClick;

    public String getName() {
        return userName;
    }

    public UserData withUserName(String name) {
        this.userName = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserData withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getLevelOfAccess() {
        return levelOfAccess;
    }

    public UserData withLevelOfAccess(String levelOfAccess) {
        this.levelOfAccess = levelOfAccess;
        return this;
    }
}
