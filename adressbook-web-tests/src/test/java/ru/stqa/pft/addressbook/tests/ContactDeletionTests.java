package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;


public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePredictions() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoAddNewPage();
            app.getContactHelper().createContact(new ContactData("test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test@test.ru", "test", "test", "test", "test", "test", "Test2"), true);
        }
    }

    @Test
    public void testsContactCreation() {
        List<ContactData> before = app.getContactHelper().getContactList();
        int index = before.size() - 1;
        app.getContactHelper().delete(index);
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(before.size() - 1, after.size());

        before.remove(index);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    }


}
