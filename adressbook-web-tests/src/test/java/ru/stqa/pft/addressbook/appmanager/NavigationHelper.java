package ru.stqa.pft.addressbook.appmanager;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {

    if (isElementPresent(By.name("new")) && isElementPresent(By.cssSelector("#content h1"))
            && wd.findElement(By.cssSelector("#content h1")).getText().equals("Groups")){
     return;
    }
    click(By.linkText("groups"));
    }

  public void gotoAddNewPage() {
    if (isElementPresent(By.cssSelector("#content h1"))
            && wd.findElement(By.cssSelector("#content h1")).getText().equals("Edit / add address book entry")){
      return;
    }

    click(By.linkText("add new"));
  }

  public void gotoHomePage() {
    if (isElementPresent(By.id("maintable"))){
      return;
    }
    click(By.linkText("home"));
  }
}
