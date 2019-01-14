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
        ContactData contact = new ContactData().withFirstName("test").withLastName("test").withAddress("test")/*.withEmail("test").withEmail2("test").withEmail3("test").withPhoneWork("test").withPhoneHome("test").withPhoneFax("test").withPhoneMobile("test").withGroup("test1")*/;
        app.goTo().addNewPage();
        app.contact().create(contact);
        Contacts after = app.contact().all();
        assertThat(before.size() + 1, equalTo(after.size()));

        assertThat(before.withAdded(contact.withId(after.stream().mapToInt((g1) -> g1.getId()).max().getAsInt())), equalTo(after));


    }

}
