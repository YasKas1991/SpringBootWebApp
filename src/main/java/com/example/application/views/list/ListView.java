package com.example.application.views.list;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import javax.management.NotificationListener;
import java.awt.*;
import java.util.Collection;

import static javax.management.NotificationListener.*;

@PageTitle("list")
@Route(value = "")
public class ListView extends VerticalLayout {

    public ListView() {

        Button button = new Button("Click me");
        TextField name = new TextField("Name");

        HorizontalLayout hl = new HorizontalLayout(name, button);
        hl.setDefaultVerticalComponentAlignment(Alignment.BASELINE);

        button.addClickListener(click-> Notification.show("Hello" + name.getValue()));
        add(hl);

    }

}
