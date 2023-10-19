package pl.globallogic.university.clients;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.UUID;

public class ClientManagerTest {

    private ClientManager clientManager;
    protected Logger logger = LoggerFactory.getLogger(ClientManagerTest.class);

    @BeforeClass
    public void setUp() {
        logger.info("========================================");
        logger.info("Test SetUp");
        clientManager = new ClientManager();
    }

    @Test
    public void testCreateNewClient() {
        String clientID = clientManager.createNewClient("John", "Doe");
        Assert.assertNotNull(clientID);
        Assert.assertEquals(UUID.fromString(clientID).toString(), clientID);
    }

    @Test
    public void testActivatePremium() {
        String clientID = clientManager.createNewClient("Jane", "Smith");
        String activatedClientID = clientManager.activatePremiumAccount(clientID);
        Assert.assertTrue(clientManager.isPremiumClient(activatedClientID));
    }

    @Test
    public void testGetClientFullName() {
        String firstName = "John";
        String lastName = "Doe";
        String clientID = clientManager.createNewClient(firstName, lastName);
        Assert.assertEquals((firstName + ' ' + lastName), clientManager.getClientFullName(clientID));
    }

    @Test
    public void testGetCreationDate() {
        LocalDate currentDate = LocalDate.now();
        String clientID = clientManager.createNewClient("John", "Doe");
        Assert.assertEquals(currentDate, clientManager.getClientCreationDate(clientID));
    }

    @Test
    public void testNumberOfClients() {
        int numberOfClientsToCreate = 15;

        for (int i = 1; i <= numberOfClientsToCreate; i++) {
            String firstName = "TestFirstName" + i;
            String lastName = "TestLastName" + i;
            clientManager.createNewClient(firstName, lastName);
        }

        Assert.assertEquals(clientManager.getNumberOfClients(), numberOfClientsToCreate);
    }

    @Test
    public void testNumberOfPremiumCLients() {
        int numberOfClientsToCreate = 15;
        int numberOfPremiumClients = 8;
        int clientsToActivatePremium = numberOfPremiumClients;

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

        Assert.assertEquals(clientManager.getNumberOfClients(), numberOfClientsToCreate);
        Assert.assertEquals(clientManager.getNumberOfPremiumClients(), numberOfPremiumClients);
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        logger.info("Cleaning environment after test");
        clientManager.cleanData();
    }
}
