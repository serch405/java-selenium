package tests.my;

import org.junit.jupiter.api.*;
import pages.my.GlobalIncidents;
import tests.BaseTestForAuthorized;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SidebarTest extends BaseTestForAuthorized {

    @Test
    @Order(1)
    public void defaultState() {
        Assertions.assertTrue(BaseTestForAuthorized.dashboardPage.sidebar.isSidebarExpended());
        Assertions.assertFalse(BaseTestForAuthorized.dashboardPage.sidebar.isWorkspacesSublistExpended());
    }

    @Test
    @Order(2)
    public void expandWorkspacesSublist() {
        BaseTestForAuthorized.dashboardPage.sidebar.clickWorkspacesExpendIcon();
        Assertions.assertTrue(BaseTestForAuthorized.dashboardPage.sidebar.isSidebarExpended());
    }

    @Test
    @Order(3)
    public void openGlobalIncidents() throws Exception {
        GlobalIncidents globalIncidentsPage = BaseTestForAuthorized.dashboardPage.sidebar.openGlobalIncidentsPage();
        Assertions.assertTrue(globalIncidentsPage.breadcrumb.getItemTextByIndex(0).contains("WORKSPACES"));
        Assertions.assertTrue(globalIncidentsPage.breadcrumb.getItemTextByIndex(1).contains("GLOBAL INCIDENTS"));
        Assertions.assertTrue(globalIncidentsPage.breadcrumb.isItemActive("GLOBAL INCIDENTS"));
    }

}
