package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

    public void delete(ContactData group) {
        selectContact(group.getId());
        deleteSelectedContact();
        contactsCash = null;

    }

    public void create(ContactData contactData) {
        fillContactForm(contactData);
        submitContactCreation();
        contactsCash = null;
        returnToHomePage();
    }

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactFormWithGroup(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());

        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getPhoneHome());
        type(By.name("mobile"), contactData.getPhoneMobile());
        type(By.name("work"), contactData.getPhoneWork());
        type(By.name("fax"), contactData.getPhoneFax());
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());

        if (creation) {
            new Select(wd.findElement(By.cssSelector("[name = new_group]"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());

        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getPhoneHome());
        type(By.name("mobile"), contactData.getPhoneMobile());
        type(By.name("work"), contactData.getPhoneWork());
        type(By.name("fax"), contactData.getPhoneFax());
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void deleteSelectedContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
        acceptDialogWindow();
    }

    public void selectContact(int id) {
        wd.findElement(By.cssSelector("input[value = '" + id + "']")).click();
    }

    public void returnToHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }


    public boolean isThereAContact() {
        if (isElementPresent(By.name("selected[]"))) {
            return true;
        } else {
            return false;
        }
    }

    private Contacts contactsCash = null;

    public Contacts all() {
        if (contactsCash != null) {
            return new Contacts(contactsCash);
        }
        contactsCash = new Contacts();
        List<WebElement> listOfWebElementsWithContactDataRow = wd.findElements(By.cssSelector("tr"));
        for (int i = 1; i < (listOfWebElementsWithContactDataRow.size() - 1); i++) {
            List<WebElement> listOfColumns = listOfWebElementsWithContactDataRow.get(i).findElements(By.cssSelector("td"));
            int id = Integer.parseInt(listOfColumns.get(0).findElement(By.cssSelector("[type = checkbox]")).getAttribute("value"));
            String lastName = listOfColumns.get(1).getText();
            String firstName = listOfColumns.get(2).getText();
            String address = listOfColumns.get(3).getText();
            //На будущее как разберусь с выражениями для получения отдельных строк
       /* String allEmails = listOfColumns.get(4).getText();
        String allPhones = listOfColumns.get(5).getText();*/
            ContactData contactData = new ContactData().withId(id).withFirstName(firstName).withLastName(lastName).withAddress(address);
            contactsCash.add(contactData);

        }
        return new Contacts(contactsCash);
    }

    public void createWithGroup(ContactData contactData, boolean creation) {
        fillContactFormWithGroup(contactData, creation);
        submitContactCreation();
        returnToHomePage();
    }

    public void selectAllContact() {
        click(By.id("MassCB"));
    }

    public void initContactModification() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitContactModification() {
        click(By.cssSelector("[value = Update]"));
    }
}

