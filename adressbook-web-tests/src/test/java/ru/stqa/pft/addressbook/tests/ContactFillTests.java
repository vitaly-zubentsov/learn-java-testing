package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

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
        assertThat(contactFromHomePage, equalTo(contactFromModification));
        assertThat(contactFromHomePage.getAllEmails(), equalTo(mergeAllEmails(contactFromModification)));
        assertThat(contactFromHomePage.getAllPhones(), equalTo(mergeAllPhones(contactFromModification)));
    }

    private String mergeAllEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3()).stream().filter((s) -> !s.equals("")).collect(Collectors.joining("\n"));
    }

    private String mergeAllPhones(ContactData contact) {
        return Arrays.asList(contact.getPhoneHome(), contact.getPhoneMobile(), contact.getPhoneWork()).stream().filter((s) -> !s.equals("")).map(ContactFillTests::cleaned).collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone){
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
