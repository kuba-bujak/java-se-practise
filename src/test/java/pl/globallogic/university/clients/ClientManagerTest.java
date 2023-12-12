package pl.globallogic.university.clients;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pl.globallogic.university.clients.enums.SupportedMetalType;

import java.time.LocalDate;
import java.util.UUID;

public class ClientManagerTest {

    private ClientManager clientManager;
    protected Logger logger = LoggerFactory.getLogger(ClientManagerTest.class);

    @BeforeMethod
    public void setUp() {
        logger.info("========================================");
        logger.info("Test SetUp");
        clientManager = new ClientManager();
    }

    @Test
    public void testCreateNewClient() {
        // Given
        String firstName = "John";
        String lastName = "Doe";

        // When
        String clientID = clientManager.createNewClient(firstName, lastName);

        // Then
        Assert.assertNotNull(clientID);
        Assert.assertEquals(UUID.fromString(clientID).toString(), clientID);
    }

    @Test
    public void testCreateClientWithMaxNameLength() {
        // Given
        String firstName = "J".repeat(255); // Max length for first name
        String lastName = "D".repeat(255);  // Max length for last name

        // When
        String clientID = clientManager.createNewClient(firstName, lastName);

        // Then (No exception is expected)
    }

    @Test(expectedExceptions = RuntimeException.class, expectedExceptionsMessageRegExp = "Invalid first name")
    public void testCreateClientWithInvalidFirstName() {
        // Given, When
        clientManager.createNewClient("!@#&", "Doe");

        //Then (Expecting an exception)
    }

    @Test(expectedExceptions = RuntimeException.class, expectedExceptionsMessageRegExp = "Invalid last name")
    public void testCreateClientWithInvalidLastName() {
        // Given, When
        clientManager.createNewClient("John", "!@#&");

        //Then (Expecting an exception)
    }

    @Test(expectedExceptions = RuntimeException.class, expectedExceptionsMessageRegExp = "Invalid first name")
    public void testCreateClientWithEmptyName() {
        // Given, When
        clientManager.createNewClient("", "Doe");
        // Then (Expecting an exception)
    }

    @Test(expectedExceptions = RuntimeException.class, expectedExceptionsMessageRegExp = "Invalid first name")
    public void testCreateClientWithExceededMaxNameLength() {
        // Given
        String firstName = "J".repeat(256); // Exceeding max length for first name
        String lastName = "Doe";

        // When
        clientManager.createNewClient(firstName, lastName);

        // Then (Expecting an exception)
    }

    @Test
    public void testActivatePremium() {
        // Given
        String clientID = clientManager.createNewClient("Jane", "Smith");

        // When
        String activatedClientID = clientManager.activatePremiumAccount(clientID);

        // Then
        Assert.assertTrue(clientManager.isPremiumClient(activatedClientID));
    }

    @Test(expectedExceptions = RuntimeException.class, expectedExceptionsMessageRegExp = "Client not found")
    public void testActivatePremiumForNonExistentClient() {
        // Given
        String nonExistentClientID = UUID.randomUUID().toString();

        // When
        clientManager.activatePremiumAccount(nonExistentClientID);

        // Then (Expecting an exception)
    }

    @Test
    public void testGetClientFullName() {
        // Given, When
        String firstName = "John";
        String lastName = "Doe";
        String clientID = clientManager.createNewClient(firstName, lastName);

        // Then
        Assert.assertEquals((firstName + ' ' + lastName), clientManager.getClientFullName(clientID));
    }

    @Test(expectedExceptions = RuntimeException.class, expectedExceptionsMessageRegExp = "Client not found")
    public void testGetFullNameForNonExistentClient() {
        // Given
        String nonExistentClientID = UUID.randomUUID().toString();

        // When
        clientManager.getClientFullName(nonExistentClientID);

        // Then (Expecting an exception)
    }

    @Test
    public void testGetCreationDate() {
        // Given, When
        LocalDate currentDate = LocalDate.now();
        String clientID = clientManager.createNewClient("John", "Doe");

        //Then
        Assert.assertEquals(currentDate, clientManager.getClientCreationDate(clientID));
    }

    @Test(expectedExceptions = RuntimeException.class, expectedExceptionsMessageRegExp = "Client not found")
    public void testGetCreationDateForNonExistentClient() {
        // Given
        String nonExistentClientID = UUID.randomUUID().toString();

        // When
        clientManager.getClientCreationDate(nonExistentClientID);

        // Then (Expecting an exception)
    }

    @Test
    public void testNumberOfClients() {
        // Given
        int numberOfClientsToCreate = 15;

        // When
        for (int i = 1; i <= numberOfClientsToCreate; i++) {
            String firstName = "TestFirstName" + i;
            String lastName = "TestLastName" + i;
            clientManager.createNewClient(firstName, lastName);
        }

        // Then
        Assert.assertEquals(clientManager.getNumberOfClients(), numberOfClientsToCreate);
    }

    @Test
    public void testNumberOfPremiumClients() {
        // Given
        int numberOfClientsToCreate = 15;
        int numberOfPremiumClients = 8;
        int clientsToActivatePremium = numberOfPremiumClients;

        // When
        for (int i = 1; i <= numberOfClientsToCreate; i++) {
            String firstName = "TestFirstName" + i;
            String lastName = "TestLastName" + i;
            String clientID = clientManager.createNewClient(firstName, lastName);

            if (clientsToActivatePremium > 0) {
                clientManager.activatePremiumAccount(clientID);
                Assert.assertTrue(clientManager.isPremiumClient(clientID));

                clientsToActivatePremium--;
            }
        }

        // Then
        Assert.assertEquals(clientManager.getNumberOfClients(), numberOfClientsToCreate);
        Assert.assertEquals(clientManager.getNumberOfPremiumClients(), numberOfPremiumClients);
    }
}
