package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.mantis.model.UserData;

import java.util.ArrayList;
import java.util.List;

public class UserHelper extends HelperBase {

    public UserHelper(ApplicationManager app) {
        super(app);
    }


    public UserData oneFromList() {
        List<WebElement> listOfWebElementsWithUserDataRow = wd.findElements(By.cssSelector(".width100 tr[class *= 'row']"));
        List<UserData> users = new ArrayList<>();
        for (int i = 1; i <= (listOfWebElementsWithUserDataRow.size() - 1); i++) {
            List<WebElement> listOfColumns = listOfWebElementsWithUserDataRow.get(i).findElements(By.cssSelector("td"));
            WebElement webElementToClick =  listOfColumns.get(0);
            String userName = listOfColumns.get(0).getText();
            String email = listOfColumns.get(2).getText();
            String levelOfAccess = listOfColumns.get(3).getText();
            UserData user = new UserData().withWebElementToClick(webElementToClick).withUserName(userName).withEmail(email).withLevelOfAccess(levelOfAccess);
            users.add(user);
        }
        users.remove(0);
        return users.iterator().next();
        }

    public void resetPassword() {
        click(By.cssSelector("[value ='Reset Password']"));
    }
}
