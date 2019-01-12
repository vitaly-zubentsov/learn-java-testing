package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testsContactCreation() {
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoAddNewPage();
        ContactData newContactforFill = new ContactData("test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test@test.ru", "test", "test", "test", "test", "test", "test1");

        app.getContactHelper().createContact(newContactforFill, true);
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(before.size()+1 , after.size());


        int newid = after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId();
        ContactData newContactFromTable = new ContactData(newid, "test" ,"test" ,"test" );
        before.add(newContactFromTable);

        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.stream().sorted(byId);
        after.stream().sorted(byId);

        Assert.assertEquals( before , after);


    }

}
