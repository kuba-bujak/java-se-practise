package pl.globallogic.university.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.globallogic.university.clients.exceptions.ClientNotFoundException;
import pl.globallogic.university.clients.interfaces.Clients;

import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.*;

public class ClientManager implements Clients {
    private final Map<String, Client> clients = new HashMap<>();
    private final List<Client> premiumClients = new ArrayList<>();

    protected Logger logger = LoggerFactory.getLogger(ClientManager.class);

    @Override
    public String createNewClient(String firstName, String lastName) {
        String clientId = UUID.randomUUID().toString();
        Client newClient = new Client(clientId, firstName, lastName);
        logger.info("User was created successfully with id: {}", clientId);
        clients.put(clientId, newClient);
        logger.info("User was added to the clients list with id: {}", clients.get(clientId).getClientId());
        return clientId;
    }

    @Override
    public String activatePremiumAccount(String clientId){
        if (clients.containsKey(clientId)) {
            Client client = clients.get(clientId);
            client.activatePremium();
            premiumClients.add(client);
            return clientId;
        } else {
            throw new ClientNotFoundException("Client not found");
        }
    }

    @Override
    public String getClientFullName(String clientId) {
        if (clients.containsKey(clientId)) {
            Client client = clients.get(clientId);
            logger.info("Client's firstName: '{}' and lastName: '{}'", client.getFirstName(), client.getLastName());
            return client.getFirstName() + ' ' + client.getLastName();
        } else {
            throw new ClientNotFoundException("Client not found");
        }
    }

    @Override
    public LocalDate getClientCreationDate(String clientId) {
        if (clients.containsKey(clientId)) {
            Client client = clients.get(clientId);
            logger.info("Client's creation date: '{}'", client.getCreationDate());
            return client.getCreationDate();
        } else {
            throw new ClientNotFoundException("Client not found");
        }
    }

    @Override
    public boolean isPremiumClient(String clientId) {
        if (clients.containsKey(clientId)) {
            Client client = clients.get(clientId);
            return client.isPremium();
        } else {
            throw new ClientNotFoundException("Client not found");
        }
    }

    @Override
    public int getNumberOfClients() {
        logger.info("There are: {} created users", clients.size());
        return clients.size();
    }

    @Override
    public int getNumberOfPremiumClients() {
        logger.info("There are: {} premium clients", premiumClients.size());
        return premiumClients.size();
    }

    public void cleanData() {
        clients.clear();
        premiumClients.clear();
    }
}
