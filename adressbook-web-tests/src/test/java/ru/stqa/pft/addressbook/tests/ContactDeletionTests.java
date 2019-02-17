package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePredictions() {
        app.goTo().homePage();
        if (!app.contact().isThereAContact()) {
            ContactData contact = new ContactData().withFirstName("test").withLastName("test").withAddress("test");
            app.goTo().addNewPage();
            app.contact().create(contact, false);
        }
    }

    @Test
    public void testsContactCreation() {

        Contacts before = app.db().contacts();
        ContactData contact = before.iterator().next();
        app.contact().delete(contact);
        app.goTo().homePage();
        Contacts after =  app.db().contacts();
        assertThat(before.size() - 1, equalTo(after.size()));

        assertThat(before.without(contact), equalTo(after));
        verifyContactsListInUI();
    }


}
