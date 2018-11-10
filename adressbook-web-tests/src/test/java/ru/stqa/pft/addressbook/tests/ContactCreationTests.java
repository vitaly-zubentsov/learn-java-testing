package ru.stqa.pft.addressbook.tests;

        import org.testng.annotations.Test;
        import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

 @Test
 public void testsContactCreation (){
  app.getNavigationHelper().gotoAddNewPage();
  app.getContactHelper().fillContactForm(new ContactData("test","test","test","test","test","test","test","test","test","test","test","test","test@test.ru","test","test","test","test","test"));
  app.getContactHelper().submitContactCreation();

 }

}
