package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {


  @Test
  public void testGroupDeletion() {
    gotoGroupPage();
     selectGroup();
    deleteSelectedGroups();
    returnToGroupPage();
  }

}