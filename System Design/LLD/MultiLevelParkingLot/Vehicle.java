public class Vehicle {
    String licenseNumber;
    VehicleType type;

    Vehicle(String licenseNumber, VehicleType type) {
        this.licenseNumber = licenseNumber;
        this.type = type;
    }

    public VehicleType getType() {
        return this.type;
    }

    public String getLicenseNumber() {
        return this.licenseNumber;
    }
}
