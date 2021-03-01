package com.exxeta.allesTesten.raceResult;

import java.util.Collection;
import java.util.LinkedHashSet;

public class RaceResultService {
    private Collection<Client> clientList = new LinkedHashSet<>();

    public void addSubscriber(Client client) {
        this.clientList.add(client);
    }

    public void send(Message message) {
        for (Client client: clientList)
            client.receive(message);
    }

    public void removeSubscriber(Client client) {
        clientList.remove(client);
    }
}
