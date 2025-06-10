public class ParkingSlot {
    private final int slotNumber;
    private final VehicleType supportedType;
    private boolean isOccupied;
    private Vehicle currentVehicle;

    public ParkingSlot(int slotNumber, VehicleType type){
        this.slotNumber=slotNumber;
        this.supportedType=type;
    }

    public boolean isOccupied(){
        return isOccupied;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.currentVehicle = vehicle;
        this.isOccupied=true;
    }

    public void removeVehicle() {
        this.currentVehicle=null;
        this.isOccupied=false;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return !isOccupied && this.supportedType==vehicle.type;
    }

    public int getSlotNumber(){
        return this.slotNumber;
    }
}
