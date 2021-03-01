package com.exxeta.allesTesten.messages;

import org.springframework.lang.NonNull;

public class TemplateEngine {

    public String prepareMessage(@NonNull Template template, Client client) {
        template.doSomething();
        return "TestMessage!";
    }
}
