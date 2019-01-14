package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTests extends TestBase {


    @Test
    public void testsContactCreation() {
        app.goTo().homePage();
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData().withFirstName("test").withLastName("test").withAddress("test")/*.withEmail("test").withEmail2("test").withEmail3("test").withPhoneWork("test").withPhoneHome("test").withPhoneFax("test").withPhoneMobile("test").withGroup("test1")*/;
        app.goTo().addNewPage();
        app.contact().create(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(before.size() + 1, after.size());

        before.add(contact.withId(after.stream().mapToInt((g1) -> g1.getId()).max().getAsInt()));
        Assert.assertEquals(before, after);


    }

}
