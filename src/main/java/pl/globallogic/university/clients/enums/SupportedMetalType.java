package pl.globallogic.university.clients.enums;

public enum SupportedMetalType {
    COPPER(8960),
    TIN(7260),
    IRON(7870),
    LEAD(11300),
    SILVER(10500),
    TUNGSTEN(19300),
    GOLD(19300),
    PLATINUM(21500);

    private int density;

    SupportedMetalType(int density) {
        this.density = density;
    }

    /**
     * @return Metal density kg/m^3.
     */
    public double getDensity() {
        return density;
    }

    public static boolean isValid(String metalType) {
        for (SupportedMetalType value : SupportedMetalType.values()) {
            if (value.name().equals(metalType)) {
                return true;
            }
        }
        return false;
    }
}
