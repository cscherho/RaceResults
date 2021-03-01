package com.exxeta.allesTesten.messages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class TestMessenger {

    @Test
    void shouldSendEmail() {
        MailServer mailServer = mock(MailServer.class);
        TemplateEngine templateEngine = mock(TemplateEngine.class);
        Client client = mock(Client.class);
        Template template = mock(Template.class);

        Messenger messenger = new Messenger(templateEngine, mailServer);

        when(client.getEmail()).thenReturn("mockMail");
        when(templateEngine.prepareMessage(template, client)).thenReturn("irgendeinenContent");

        messenger.sendMessage(client, template);

        verify(mailServer).send("mockMail", "irgendeinenContent");
        System.out.println("done");
    }

}
