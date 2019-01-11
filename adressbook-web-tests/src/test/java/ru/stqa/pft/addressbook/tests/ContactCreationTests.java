package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testsContactCreation() {
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoAddNewPage();
        app.getContactHelper().createContact(new ContactData("test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test@test.ru", "test", "test", "test", "test", "test", "test1"), true);
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(before.size()+1 , after.size());


    }

}
