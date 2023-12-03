package pl.globallogic.university.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.globallogic.university.clients.enums.SupportedMetalType;
import pl.globallogic.university.clients.exceptions.ClientNotFoundException;
import pl.globallogic.university.clients.exceptions.FullWarehouseException;
import pl.globallogic.university.clients.exceptions.ProhibitedMetalTypeException;
import pl.globallogic.university.clients.interfaces.Warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WarehouseManager implements Warehouse {

    private final Map<String, Client> wareHouseClients = new HashMap<>();
    private final double totalWareHouseVolume = 1000000.0;
    private final ClientManager clientManager;

    protected Logger logger = LoggerFactory.getLogger(WarehouseManager.class);

    public WarehouseManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    @Override
    public void addMetalIngot(String clientId, SupportedMetalType metalType, double mass) throws ClientNotFoundException, ProhibitedMetalTypeException, FullWarehouseException {
        try {
            Client client = clientManager.getClientById(clientId);

            if (!isMetalTypeAllowedForClient(client, metalType)) {
                logger.error("Prohibited metal type: '{}' for the client: '{}'", metalType, clientId);
                throw new ProhibitedMetalTypeException("Prohibited metal type for the client");
            }

            if (!isWarehouseSpaceAvailable(clientId, metalType, mass)) {
                logger.error("The warehouse is full");
                throw new FullWarehouseException("The warehouse is full");
            }

            client.addMetalIngot(metalType, mass);
            logger.info("Metal ingot added for client '{}'. Metal type: '{}', Mass: '{}'", clientId, metalType, mass);

        } catch (ClientNotFoundException e) {
            logger.error("Error adding metal ingot for client '{}': {}", clientId, e.getMessage());
            throw e;
        }

    }

    @Override
    public Map<SupportedMetalType, Double> getMetalTypesToMassStoredByClient(String clientId) {
        Client client = clientManager.getClientById(clientId);
        logger.info("Added '{}' to the client with ID: '{}'", client.getMetalTypesToMass().toString(), client.getClientId());
        return client.getMetalTypesToMass();
    }

    @Override
    public double getTotalVolumeOccupiedByClient(String clientId) {
        double totalOccupiedVolume = 0;
        Client client = clientManager.getClientById(clientId);
        Map <SupportedMetalType, Double> metalTypeToMass = client.getMetalTypesToMass();
        logger.info("Current Client metal list: '{}'", metalTypeToMass);

        for (Map.Entry<SupportedMetalType, Double> entry : metalTypeToMass.entrySet()) {
            SupportedMetalType metalType = entry.getKey();
            double mass = entry.getValue();
            totalOccupiedVolume += metalType.getDensity() * mass;
        }

        return totalOccupiedVolume;
    }

    @Override
    public List<SupportedMetalType> getStoredMetalTypesByClient(String clientId) {
        Client client = clientManager.getClientById(clientId);
        return new ArrayList<>(client.getMetalTypesToMass().keySet());
    }

    private boolean isMetalTypeAllowedForClient(Client client, SupportedMetalType metalType) {
        if (!client.isPremium()) {
            return metalType != SupportedMetalType.GOLD;
        }
        return true;
    }

    private boolean isWarehouseSpaceAvailable(String clientId, SupportedMetalType metalType, double mass) {
        double totalOccupiedVolume = getTotalVolumeOccupiedByClient(clientId);
        double totalVolume = getTotalWarehouseVolume();

        logger.info("Total occupied volume: '{}'", totalOccupiedVolume);
        logger.info("Total volume: '{}'", totalVolume);
        return (totalOccupiedVolume + metalType.getDensity() * mass) <= totalVolume;
    }

    private double getTotalWarehouseVolume() {
        return totalWareHouseVolume;
    }

    public void cleanData() {
        wareHouseClients.clear();
    }
}
