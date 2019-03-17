package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.UserData;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager app) {
        super(app);
    }

    public void goToManagePage() {
      click(By.cssSelector(".menu [href *= 'manage']"));
    }

    public void goToManageUsersPage() {
        click(By.cssSelector(".bracket-link [href *= 'user']"));
    }


    public void finish(String confirmationLink, String password) {
        wd.get(confirmationLink);
        type(By.cssSelector("[name=password]"), password);
        type(By.cssSelector("[name= 'password_confirm']"), password);
        click(By.cssSelector("input[value ='Update User']"));
    }


    public void goToUserPage(UserData user) {
        user.getWebElementToClick().click();
    }
}
