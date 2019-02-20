package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePredictions() {
        app.goTo().homePage();
        if (app.db().groups().size() < 1) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }
        int maxSizeOfGroups = app.db().groups().size();
        Contacts contacts = app.db().contacts();
        boolean createContact = true;
        for (ContactData contact : contacts) {
            if (contact.getGroups().size() < maxSizeOfGroups) {
                createContact = false;
                break;
            }
        }
        if (createContact) {
            app.goTo().addNewPage();
            ContactData newContact = new ContactData().withFirstName("TestBeforeMethod");
            app.contact().create(newContact, false, false);
        }
        app.goTo().homePage();
        app.contact().showAllContacts();
    }

    @Test
    public void testsContactCreation() {
        Contacts contacts = app.db().contacts();
        int maxSizeOfGroups = app.db().groups().size();
        ContactData beforeContact = new ContactData();
        for (ContactData contact : contacts) {
            if (contact.getGroups().size() < maxSizeOfGroups) {
                beforeContact = contact;
                break;
            }
        }
        GroupData addedGroup = app.db().groups().withoutAll(beforeContact.getGroups()).iterator().next();

        app.contact().addedToGroup(addedGroup, beforeContact.getId());
        int idOfContact = beforeContact.getId();
        ContactData afterContact = app.db().contacts().stream().filter(g -> g.getId() == idOfContact).findFirst().get();
        assertThat(beforeContact.inGroup(addedGroup), equalTo(afterContact));

    }
}
