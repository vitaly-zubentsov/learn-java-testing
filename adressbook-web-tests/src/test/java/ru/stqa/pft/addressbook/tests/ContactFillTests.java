package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactFillTests extends TestBase {

    @BeforeMethod
    public void ensurePredictions() {
        app.goTo().homePage();
        if (!app.contact().isThereAContact()) {
            ContactData contact = new ContactData().withFirstName("test").withLastName("test").withAddress("test").withEmail("test").withEmail2("test").withEmail3("test").withPhoneWork("test").withPhoneHome("test").withPhoneFax("test").withPhoneMobile("test");
            app.goTo().addNewPage();
            app.contact().create(contact);
        }
    }

    @Test
    public void testsContactFill() {
        app.goTo().homePage();
        ContactData contactFromHomePage = app.contact().oneFromTable();
        ContactData contactFromModification = app.contact().oneFromModification(contactFromHomePage.getId());
        app.goTo().addNewPage();
//        app.contact().create(contact);
//        Contacts after = app.contact().all();
//        assertThat(before.size() + 1, equalTo(after.size()));
//
//        assertThat(before.withAdded(contact.withId(after.stream().mapToInt((g1) -> g1.getId()).max().getAsInt())), equalTo(after));


    }

}
