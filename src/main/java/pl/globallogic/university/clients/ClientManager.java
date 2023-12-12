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

    public Client getClientById(String clientId) {
        if (clients.containsKey(clientId)) {
            return clients.get(clientId);
        }
        throw new ClientNotFoundException("Client not found");
    }

    @Override
    public String createNewClient(String firstName, String lastName) {
        Client newClient = new Client(firstName, lastName);
        String clientId = newClient.getClientId();
        logger.info("User was created successfully with id: {}", clientId);
        clients.put(clientId, newClient);
        logger.info("User was added to the clients list with id: {}", clients.get(clientId).getClientId());
        return clientId;
    }

    @Override
    public String activatePremiumAccount(String clientId){
        try {
            Client client = getClientById(clientId);
            client.activatePremium();
            premiumClients.add(client);
            return clientId;
        } catch (ClientNotFoundException e) {
            logger.error("Error activating premium account for client '{}': {}", clientId, e.getMessage());
            throw e;
        }

    }

    @Override
    public String getClientFullName(String clientId) {
        try {
            Client client = getClientById(clientId);
            logger.info("Client's firstName: '{}' and lastName: '{}'", client.getFirstName(), client.getLastName());
            return client.getFirstName() + ' ' + client.getLastName();
        } catch (ClientNotFoundException e) {
            logger.error("Error retrieving client full name for ID '{}': {}", clientId, e.getMessage());
            throw e;
        }

    }

    @Override
    public LocalDate getClientCreationDate(String clientId) {
        try {
            Client client = getClientById(clientId);
            logger.info("Client's creation date: '{}'", client.getCreationDate());
            return client.getCreationDate();
        } catch (ClientNotFoundException e) {
            logger.error("Error retrieving client creation date for ID '{}': {}", clientId, e.getMessage());
            throw e;
        }

    }

    @Override
    public boolean isPremiumClient(String clientId) {
        try {
            Client client = getClientById(clientId);
            return client.isPremium();
        } catch (ClientNotFoundException e) {
            logger.error("Error checking premium status for client '{}': {}", clientId, e.getMessage());
            throw e;
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
}
