package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

public class RegistationTests extends TestBase{

    @Test
    public void testRegistation() {
        app.registration().start("user1","user1@localhost.localhomain");
    }
}
