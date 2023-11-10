package pl.globallogic.university.clients;

import pl.globallogic.university.clients.enums.SupportedMetalType;
import pl.globallogic.university.clients.exceptions.ClientNotFoundException;
import pl.globallogic.university.clients.exceptions.FullWarehouseException;
import pl.globallogic.university.clients.exceptions.ProhibitedMetalTypeException;
import pl.globallogic.university.clients.interfaces.Warehouse;

import java.util.List;
import java.util.Map;

public class WarehouseManager implements Warehouse {
    @Override
    public void addMetalIngot(String clientId, SupportedMetalType metalType, double mass) throws ClientNotFoundException, ProhibitedMetalTypeException, FullWarehouseException {

    }

    @Override
    public Map<SupportedMetalType, Double> getMetalTypesToMassStoredByClient(String clientId) {
        return null;
    }

    @Override
    public double getTotalVolumeOccupiedByClient(String clientId) {
        return 0;
    }

    @Override
    public List<SupportedMetalType> getStoredMetalTypesByClient(String clientId) {
        return null;
    }
}
