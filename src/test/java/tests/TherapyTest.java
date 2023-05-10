package tests;

import org.example.pages.BasePage;
import org.example.pages.TherapyHomePage;
import org.testng.annotations.Test;

public class TherapyTest extends BasePage {


    @Test(priority=0)
    public void therapyPageInteract() {
        TherapyHomePage therapyHomePage = new TherapyHomePage(driver);
        therapyHomePage.navigateToTherapiesPage();

    }
}
