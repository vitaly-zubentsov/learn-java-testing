package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {



    @Test
    public void testsContactCreation() {
        app.goTo().homePage();
        List<ContactData> before = app.contact().list();
        ContactData newContactForFill = new ContactData().withFirstName("test").withLastName("test").withAddress("test").withEmail("test").withEmail2("test").withEmail3("test").withPhoneWork("test").withPhoneHome("test").withPhoneFax("test").withPhoneMobile("test").withGroup("test1");
        app.goTo().addNewPage();
        app.contact().create(newContactForFill, true);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(before.size()+1 , after.size());


        int idForNewContact = after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId();
        ContactData newContactFromTable = new ContactData().withId(idForNewContact).withFirstName("test").withLastName("test").withAddress("test");
        before.add(newContactFromTable);

        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.stream().sorted(byId);
        after.stream().sorted(byId);

        Assert.assertEquals( before , after);


    }

}
