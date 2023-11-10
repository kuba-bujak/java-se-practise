package pl.globallogic.university.clients.interfaces;

import pl.globallogic.university.clients.exceptions.ClientNotFoundException;
import pl.globallogic.university.clients.exceptions.FullWarehouseException;
import pl.globallogic.university.clients.exceptions.ProhibitedMetalTypeException;
import pl.globallogic.university.clients.enums.SupportedMetalType;

import java.util.List;
import java.util.Map;

public interface Warehouse {

    void addMetalIngot(String clientId, SupportedMetalType metalType, double mass)
            throws ClientNotFoundException, ProhibitedMetalTypeException, FullWarehouseException;

    Map<SupportedMetalType, Double> getMetalTypesToMassStoredByClient(String clientId);

    double getTotalVolumeOccupiedByClient(String clientId);

    List<SupportedMetalType> getStoredMetalTypesByClient(String clientId);

}
