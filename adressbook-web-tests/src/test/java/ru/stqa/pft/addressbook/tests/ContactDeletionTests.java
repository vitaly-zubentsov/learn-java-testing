package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactDeletionTests extends TestBase {


  @Test
   public void testsContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoAddNewPage();
      app.getContactHelper().createContact(new ContactData("test","test","test","test","test","test","test","test","test","test","test","test","test@test.ru","test","test","test","test","test","Test2" ), true);
    }

    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();

  }
}
