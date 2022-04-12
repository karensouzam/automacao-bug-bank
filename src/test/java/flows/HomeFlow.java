package flows;

import pages.HomePage;

public class HomeFlow {
    HomePage homePage;

    public void sair () {
        homePage = new HomePage();

        homePage.sair();
    }
}
