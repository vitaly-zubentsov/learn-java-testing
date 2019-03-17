package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class changePasswordForUserTests extends TestBase {

    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testRegistation() throws IOException, MessagingException {
        app.session().login(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"));
        app.navigate().goToManagePage();
        app.navigate().goToManageUsersPage();
        UserData user = app.user().oneFromList();
        app.navigate().goToUserPage(user);
        app.user().resetPassword();
        app.session().logout();
        String newPassword = "New password 123";
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 20000);
        String confirmationLink = findConfirmationLink(mailMessages, user.getEmail());
        app.registration().changePassword(confirmationLink, newPassword);

        HttpSession session = app.newSession();
        assertTrue(session.login(user.getName(), newPassword));
        assertTrue(session.isLoggedInAs(user.getName()));


    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }
}
