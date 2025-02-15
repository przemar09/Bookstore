package com.example.application.views;

import com.example.application.model.Book;
import com.example.application.service.BookService;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;


import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

import java.time.LocalDateTime;


@PermitAll
@Route("/addbook")
public class AddBookView extends VerticalLayout {

    private final BookService bookService;


    public AddBookView(BookService bookService) {
        this.bookService = bookService;

        VerticalLayout layoutColumn2 = new VerticalLayout();
        H3 h3 = new H3();
        FormLayout formLayout2Col = new FormLayout();
        TextField title = new TextField();
        TextField author = new TextField();
        DateTimePicker added = new DateTimePicker();
        TextField isbn = new TextField();
        EmailField coverUrl = new EmailField();
        HorizontalLayout layoutRow = new HorizontalLayout();
        Button saveBtn = new Button();
        Button cancelBtn = new Button();

        layoutColumn2.setWidth("100%");
        layoutColumn2.setMaxWidth("800px");
        layoutColumn2.setHeight("min-content");
        h3.setText("Book information");
        h3.setWidth("100%");
        formLayout2Col.setWidth("100%");
        title.setLabel("Title");
        author.setLabel("Author");
        added.setLabel("Addition time");
        isbn.setLabel("ISBN");
        coverUrl.setLabel("Cover URL");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        saveBtn.setText("Save");
        saveBtn.setWidth("min-content");
        saveBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        saveBtn.addClickListener(e -> {
            Book book = new Book(title.getValue(), author.getValue(), isbn.getValue(), added.getValue(), coverUrl.getValue());
            bookService.saveBook(book);
        });

        cancelBtn.setText("Cancel");
        cancelBtn.setWidth("min-content");
        layoutColumn2.add(h3);
        layoutColumn2.add(formLayout2Col);
        formLayout2Col.add(title);
        formLayout2Col.add(author);
        formLayout2Col.add(added);
        formLayout2Col.add(isbn);
        formLayout2Col.add(coverUrl);
        layoutColumn2.add(layoutRow);
        layoutRow.add(saveBtn);
        layoutRow.add(cancelBtn);

        add(new H1("Add new book"));
        add(layoutColumn2);


    }
}
