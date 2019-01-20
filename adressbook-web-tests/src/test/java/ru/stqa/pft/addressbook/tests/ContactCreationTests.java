package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {


    @Test
    public void testsContactCreation() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstName("testFirstName").withLastName("testLastName").withAddress("testAddress").withEmail("testEmail").withEmail2("testEmail2").withEmail3("testEmail3").withPhoneWork("testPhoneWork").withPhoneHome("testPhoneHome").withPhoneMobile("testPhoneMobile");
        app.goTo().addNewPage();
        app.contact().create(contact);
        Contacts after = app.contact().all();
        assertThat(before.size() + 1, equalTo(after.size()));

        assertThat(before.withAdded(contact.withId(after.stream().mapToInt((g1) -> g1.getId()).max().getAsInt())), equalTo(after));


    }

}
