package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTests
 extends TestBase {


  @Test
  public void testsContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoAddNewPage();
      app.getContactHelper().createContact(new ContactData("test","test","test","test","test","test","test","test","test","test","test","test","test@test.ru","test","test","test","test","test","Test2" ), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Testm","test","Testm","Testm","Testm","Testm","Testm","Testm","Testm","Testm","Testm","Testm","Testm","Testm","Testm","Testm","Testm","Testm", null), false);
    app.getContactHelper().submitContactModification();
    //Требуется добавить задержку, сейчас ей что то плохо
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(before.size(), after.size());
  }
}
