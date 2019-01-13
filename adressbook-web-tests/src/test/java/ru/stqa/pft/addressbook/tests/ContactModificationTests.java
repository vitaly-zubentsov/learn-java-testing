package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTests
 extends TestBase {


  @Test(enabled = false)
  public void testsContactCreation() {
    app.goTo().homePage();
    if (! app.contact().isThereAContact()) {
      app.goTo().addNewPage();
      app.contact().create(new ContactData().withFirstName("test").withLastName("test").withAddress("test").withEmail("test").withEmail2("test").withEmail3("test").withPhoneWork("test").withPhoneHome("test").withPhoneFax("test").withPhoneMobile("test"), true);
    }
    List<ContactData> before = app.contact().list();
    app.contact().initContactModification();
    app.contact().fillContactForm(new ContactData().withFirstName("test").withLastName("test").withAddress("test").withEmail("test").withEmail2("test").withEmail3("test").withPhoneWork("test").withPhoneHome("test").withPhoneFax("test").withPhoneMobile("test"), false);
    app.contact().submitContactModification();
    //Требуется добавить задержку, сейчас ей что то плохо
    app.goTo().homePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(before.size(), after.size());
  }
}
