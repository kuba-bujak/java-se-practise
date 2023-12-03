package pl.globallogic.university.clients;

import pl.globallogic.university.clients.enums.SupportedMetalType;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class Client {

    private final String clientId;
    private final String firstName;
    private final String lastName;
    private boolean isPremium;
    private LocalDate creationDate;
    private final Map<SupportedMetalType, Double> metalTypesToMass;


    public Client(String firstName, String lastName) {
        this.clientId = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.creationDate = LocalDate.now();
        this.metalTypesToMass = new HashMap<>();
    }

    public String getClientId() {
        return clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void activatePremium() {
        isPremium = true;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Map<SupportedMetalType, Double> getMetalTypesToMass() {
        return metalTypesToMass;
    }

    public void addMetalIngot(SupportedMetalType metalType, double mass) {
        metalTypesToMass.put(metalType, mass);
    }
}
