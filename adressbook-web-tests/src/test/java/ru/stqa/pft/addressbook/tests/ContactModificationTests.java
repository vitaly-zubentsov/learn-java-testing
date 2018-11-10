package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests
 extends TestBase {


  @Test
  public void testsContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Testm","Testm","Testm","Testm","Testm","Testm","Testm","Testm","Testm","Testm","Testm","Testm","Testm","Testm","Testm","Testm","Testm","Testm"));
    app.getContactHelper().submitContactModification();

  }
}