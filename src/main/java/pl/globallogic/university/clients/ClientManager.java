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

    private Client getClientById(String clientId) {
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
        Client client = getClientById(clientId);
        client.activatePremium();
        premiumClients.add(client);
        return clientId;
    }

    @Override
    public String getClientFullName(String clientId) {
        Client client = getClientById(clientId);
        logger.info("Client's firstName: '{}' and lastName: '{}'", client.getFirstName(), client.getLastName());
        return client.getFirstName() + ' ' + client.getLastName();
    }

    @Override
    public LocalDate getClientCreationDate(String clientId) {
        Client client = getClientById(clientId);
        logger.info("Client's creation date: '{}'", client.getCreationDate());
        return client.getCreationDate();
    }

    @Override
    public boolean isPremiumClient(String clientId) {
        Client client = getClientById(clientId);
        return client.isPremium();
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
