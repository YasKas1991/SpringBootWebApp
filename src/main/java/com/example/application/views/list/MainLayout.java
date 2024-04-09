package com.example.application.views.list;

import com.example.application.security.SecurityService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightAction;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.component.button.Button;


import java.awt.*;

public class MainLayout extends AppLayout {
    private final SecurityService securityService;

    public MainLayout(SecurityService securityService) {
        this.securityService = securityService;

        createHeader();
        createDrawer();
    }
    private void createHeader() {
        H1 logo = new H1("Athletes CRM");
        logo.addClassNames("text-l","m-m");
        Button logOut = new Button ("Log out", e -> securityService.logout());
        // Create an invisible spacer
        Div spacer = new Div();
        spacer.setWidthFull(); // This will make the spacer take up all available space


        HorizontalLayout header =  new HorizontalLayout (new DrawerToggle(), logo, spacer, logOut);


        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.expand(spacer); // Tell the layout to expand the spacer, pushing the logout button to the right
        header.setWidthFull(); // Ensure the header takes the full width of its container
//        header.expand(logo);
        header.addClassNames("py-0","px-m");

       addToNavbar(header);

    }
    private void createDrawer() {
        RouterLink listView = new RouterLink("List", ListView.class);
        listView.setHighlightCondition(HighlightConditions.sameLocation());


        addToDrawer(new VerticalLayout(
                listView,

                new RouterLink("Dashboard", DashboardView.class)
        ));


    }


}
