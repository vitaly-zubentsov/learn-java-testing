package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;


public class ContactDeletionTests extends TestBase {


  @Test
   public void testsContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
    app.getNavigationHelper().gotoAddNewPage();
    app.getContactHelper().createContact(new ContactData("test","test","test","test","test","test","test","test","test","test","test","test","test@test.ru","test","test","test","test","test","Test2" ), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteSelectedContact();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(before.size() -1 , after.size());

    before.remove(before.size() - 1);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }
}
