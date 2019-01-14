package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePredictions() {
        app.goTo().homePage();
        if (!app.contact().isThereAContact()) {
            app.goTo().addNewPage();
            ContactData contact = new ContactData().withFirstName("test").withLastName("test").withAddress("test")/*.withEmail("test").withEmail2("test").withEmail3("test").withPhoneWork("test").withPhoneHome("test").withPhoneFax("test").withPhoneMobile("test").withGroup("test1")*/;
        }
    }

    @Test
    public void testsContactCreation() {
        Set<ContactData> before = app.contact().all();
        ContactData group = before.iterator().next();
        app.contact().delete(group);
        app.goTo().homePage();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(before.size() - 1, after.size());

        before.remove(group);
        Assert.assertEquals(before, after);

    }


}
