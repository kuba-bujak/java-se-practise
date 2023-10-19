package pl.globallogic.university.clients;

import java.time.LocalDate;
import java.util.UUID;

class Client {

    private final String clientId;
    private final String firstName;
    private final String lastName;
    private boolean isPremium;
    private LocalDate creationDate;

    public Client(String clientId, String firstName, String lastName) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.creationDate = LocalDate.now();
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
}
