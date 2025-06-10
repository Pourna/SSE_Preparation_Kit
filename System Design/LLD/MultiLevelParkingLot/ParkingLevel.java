import java.util.List;

public class ParkingLevel {
    private final int levelNumber;
    private List<ParkingSlot> slotList;

    public ParkingLevel(int levelNumber, List<ParkingSlot> slotList) {
        this.levelNumber=levelNumber;
        this.slotList=slotList;
    }

    public ParkingSlot getAvailableSlot(Vehicle vehicle) {
        for (ParkingSlot slot : this.slotList) {
            if(slot.canFitVehicle(vehicle))
                return slot;
        }
        return null;
    }

    public int getLevelNumber() {
        return this.levelNumber;
    }
}
