package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContactsFromJson() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<ContactData> contact = gson.fromJson(json, new TypeToken<List<ContactData>>() {
            }.getType()); //List <ContactDara>.class
            return contact.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }

    @BeforeMethod
    public void ensurePredictions() {
        app.goTo().homePage();
        if (app.db().groups().size() < 1 ) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test(dataProvider = "validContactsFromJson")
    public void testsContactCreation(ContactData contact) {
        GroupData group = app.db().groups().iterator().next();
        Contacts before = app.db().contacts();
        app.goTo().addNewPage();
        app.contact().create(contact.inGroup(group), true);
        Contacts after = app.db().contacts();
        Contacts test = before.withAdded(contact.withId(after.stream().mapToInt((g1) -> g1.getId()).max().getAsInt()));
        assertThat(test, equalTo(after));
        verifyContactsListInUI();

    }

}
