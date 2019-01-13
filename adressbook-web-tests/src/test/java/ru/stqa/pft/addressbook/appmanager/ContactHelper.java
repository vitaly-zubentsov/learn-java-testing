package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("nickname"), contactData.getNickName());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHome());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("work"), contactData.getWork());
        type(By.name("fax"), contactData.getFax());
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        type(By.name("homepage"), contactData.getHomepage());
        type(By.name("address2"), contactData.getAddress2());
        type(By.name("notes"), contactData.getNotes());
        type(By.name("phone2"), contactData.getPhone2());
        if (creation) {
            new Select(wd.findElement(By.cssSelector("[name = new_group]"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void delete(int index) {
        selectContact(index);
        deleteSelectedContact();
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void deleteSelectedContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
        acceptDialogWindow();
    }

    public void selectAllContact() {
        click(By.id("MassCB"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void initContactModification() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitContactModification() {
        click(By.cssSelector("[value = Update]"));
    }

    public void returnToHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    public void createContact(ContactData contactData, boolean creation) {
        fillContactForm(contactData, creation);
        submitContactCreation();
        returnToHomePage();
    }

    public boolean isThereAContact() {
        if (isElementPresent(By.name("selected[]"))) {
            return true;
        } else {
            return false;
        }
    }

    public List<ContactData> getContactList() {
        List<ContactData> listOfContact = new ArrayList<ContactData>();
        List<WebElement> listOfWebElementWithRowOfContaсtData = wd.findElements(By.cssSelector("tr"));
        for (int i = 1; i < (listOfWebElementWithRowOfContaсtData.size() - 1); i++) {
            List<WebElement> listOfColumns = listOfWebElementWithRowOfContaсtData.get(i).findElements(By.cssSelector("td"));
            int id = Integer.parseInt(listOfColumns.get(0).findElement(By.cssSelector("[type = checkbox]")).getAttribute("value"));
            String lastname = listOfColumns.get(1).getText();
            String firstname = listOfColumns.get(2).getText();
            String address = listOfColumns.get(3).getText();
            //На будущее как разберусь с выражениями для получения отдельных строк
       /* String allEmails = listOfColumns.get(4).getText();
        String allPhones = listOfColumns.get(5).getText();*/
            ContactData contactData = new ContactData(id, firstname, lastname, address);
            listOfContact.add(contactData);


        }
        return listOfContact;
    }
}

