package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePredictions() {
        app.goTo().homePage();
        if (app.db().groups().size() < 1) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }
        Contacts contacts = app.db().contacts();
        boolean createContact = true;
        for (ContactData contact : contacts) {
            if (contact.getGroups().size() > 0) {
                createContact = false;
                break;
            }
        }
        if (createContact) {
            app.goTo().addNewPage();
            ContactData newContact = new ContactData().withFirstName("TestBeforeMethod").inGroup(app.db().groups().iterator().next());
            app.contact().create(newContact, true, false);
        }
        app.goTo().homePage();

    }

    @Test
    public void testsContactCreation() {
        Contacts contacts = app.db().contacts();

        ContactData beforeContact = new ContactData();
        for (ContactData contact : contacts) {
            if (contact.getGroups().size() > 0) {
                beforeContact = contact;
                break;
            }
        }
        GroupData deletedGroup = beforeContact.getGroups().iterator().next();
        int idOfContact = beforeContact.getId();
        app.contact().deletedFromGroup(deletedGroup.getName(), idOfContact);
        ContactData afterContact = app.db().contacts().stream().filter(g -> g.getId() == idOfContact).findFirst().get();
        assertThat(beforeContact.outGroup(deletedGroup), equalTo(afterContact));

    }
}
