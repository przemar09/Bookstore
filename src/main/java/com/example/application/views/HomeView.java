package com.example.application.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@PermitAll
@Route("")
public class HomeView extends VerticalLayout {

    public HomeView() {

        add(new H1("Welcome to Bookstore application"));
        add(new Paragraph("Please select tab on the left"));

    }
}
