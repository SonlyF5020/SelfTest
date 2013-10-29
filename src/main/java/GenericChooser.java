import java.util.List;

public class GenericChooser implements Chooser {
    @Override
    public ParkingLot choseParkingLot(List<ParkingLot> parkingLotList) {
        ParkingLot target = null;
        for (ParkingLot parkingLot : parkingLotList){
            if (parkingLot.getBlank() > 0){
                target = parkingLot;
                break;
            }
        }
        return target;
    }
}
