package pl.globallogic.university.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.globallogic.university.clients.enums.SupportedMetalType;

import java.util.List;
import java.util.Map;

public class WarehouseManagerTest {
    private WarehouseManager warehouseManager;
    private ClientManager clientManager;
    protected Logger logger = LoggerFactory.getLogger(ClientManagerTest.class);

    @BeforeClass
    public void setUp() {
        logger.info("========================================");
        logger.info("Test SetUp");
        clientManager = new ClientManager();
        warehouseManager = new WarehouseManager(clientManager);
    }

    @Test
    public void testAddMetalIngot() {
        // Given
        String clientId = clientManager.createNewClient("John", "Doe");

        // When
        SupportedMetalType metalType = SupportedMetalType.COPPER;
        double mass = 10.0;
        warehouseManager.addMetalIngot(clientId, metalType, mass);

        // Then
        Map<SupportedMetalType, Double> metalTypesToMass = warehouseManager.getMetalTypesToMassStoredByClient(clientId);
        Assert.assertTrue(metalTypesToMass.containsKey(metalType));
        Assert.assertEquals(metalTypesToMass.get(metalType), mass);
    }

    @Test(expectedExceptions = RuntimeException.class, expectedExceptionsMessageRegExp = "Client not found")
    public void testAddMetalIngotForNonExistentClient() {
        // Given
        String nonExistentClientId = "nonexistentclientid";

        // When
        warehouseManager.addMetalIngot(nonExistentClientId, SupportedMetalType.IRON, 20.0);

        // Then (Expecting an exception)
    }

    @Test(expectedExceptions = RuntimeException.class, expectedExceptionsMessageRegExp = "Prohibited metal type for the client")
    public void testAddProhibitedMetalTypeForNonPremiumClient() {
        // Given
        String clientId = clientManager.createNewClient("John", "Doe");

        // When
        warehouseManager.addMetalIngot(clientId, SupportedMetalType.GOLD, 15.0);

        // Then (Expecting an exception)
    }

    @Test(expectedExceptions = RuntimeException.class, expectedExceptionsMessageRegExp = "The warehouse is full")
    public void testAddMetalIngotToFullWarehouse() {
        // Given
        String clientId = clientManager.createNewClient("John", "Doe");

        // When
        warehouseManager.addMetalIngot(clientId, SupportedMetalType.COPPER, 50000.0);
        warehouseManager.addMetalIngot(clientId, SupportedMetalType.TIN, 60000.0);

        // Then (Expecting an exception)
    }

    @Test
    public void testGetTotalVolumeOccupiedByClient() {
        // Given
        String clientId = clientManager.createNewClient("John", "Doe");
        double massCopper = 10.0;
        double massTin = 15.0;

        // When
        warehouseManager.addMetalIngot(clientId, SupportedMetalType.COPPER, massCopper);
        warehouseManager.addMetalIngot(clientId, SupportedMetalType.TIN, massTin);

        // Then
        double totalVolume = warehouseManager.getTotalVolumeOccupiedByClient(clientId);
        double expectedVolume = SupportedMetalType.COPPER.getDensity() * massCopper +
                SupportedMetalType.TIN.getDensity() * massTin;

        Assert.assertEquals(totalVolume, expectedVolume);
    }

    @Test
    public void testGetStoredMetalTypesByClient() {
        // Given
        String clientId = clientManager.createNewClient("John", "Doe");
        double massCopper = 10.0;
        double massTin = 15.0;

        // When
        warehouseManager.addMetalIngot(clientId, SupportedMetalType.COPPER, massCopper);
        warehouseManager.addMetalIngot(clientId, SupportedMetalType.TIN, massTin);

        // Then
        List<SupportedMetalType> storedMetalTypes = warehouseManager.getStoredMetalTypesByClient(clientId);
        Assert.assertTrue(storedMetalTypes.contains(SupportedMetalType.COPPER));
        Assert.assertTrue(storedMetalTypes.contains(SupportedMetalType.TIN));
    }

    @Test
    public void testAddMetalTypeForPremiumClient() {
        // Given
        SupportedMetalType metalType = SupportedMetalType.GOLD;
        double mass = 20.0;
        String clientId = clientManager.createNewClient("Jane", "Smith");
        clientManager.activatePremiumAccount(clientId);

        // When
        warehouseManager.addMetalIngot(clientId, metalType, mass);

        // Then
        Map<SupportedMetalType, Double> metalTypesToMass = warehouseManager.getMetalTypesToMassStoredByClient(clientId);
        Assert.assertTrue(metalTypesToMass.containsKey(metalType));
        Assert.assertEquals(metalTypesToMass.get(metalType), mass);
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        logger.info("Cleaning environment after test");
        warehouseManager.cleanData();
    }
}
