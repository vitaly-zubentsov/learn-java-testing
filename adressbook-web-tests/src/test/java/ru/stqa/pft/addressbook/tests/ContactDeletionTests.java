package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;


public class ContactDeletionTests extends TestBase {


  @Test
   public void testsContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();

  }
}
