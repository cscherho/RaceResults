package com.exxeta.allesTesten.raceResult;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

public class RaceResultTest {

    private RaceResultService raceResults = new RaceResultService();

    private Client clientA = mock(Client.class, "ClientA");
    private Client clientB = mock(Client.class, "ClientB");

    private Message message = mock(Message.class);

    @Test
    void notSubscribedClientShouldNotReceiveMessage() {
        raceResults.send(message);
        verify(clientA, never()).receive(message);
        verify(clientB, never()).receive(message);
    }

    @Test
    void subscribedClientShouldReceiveMessage() {
        raceResults.addSubscriber(clientA);
        raceResults.send(message);

    verify(clientA).receive(message);
}

    @Test
    void messageShouldBeSentToAllSubscribedClients() {
        raceResults.addSubscriber(clientA);
        raceResults.addSubscriber(clientB);
        raceResults.send(message);

        verify(clientA).receive(message);
        verify(clientB).receive(message);
    }

    @Test
    void shouldSendOnlyOneMessageToMultipleSubscribers() {
        raceResults.addSubscriber(clientA);
        raceResults.addSubscriber(clientA);
        raceResults.send(message);

        verify(clientA, times(1)).receive(message);
    }

    @Test
    void unsubscribedClientShouldNotReceiveMessages() {
        raceResults.addSubscriber(clientA);
        raceResults.addSubscriber(clientB);
        raceResults.removeSubscriber(clientA);
        raceResults.send(message);

        verify(clientA, times(0)).receive(message);
        verify(clientA, never()).receive(message);
        verify(clientB).receive(message);
    }
}
