import java.util.List;

public class SmartChooser implements Chooser {
    @Override
    public ParkingLot choseParkingLot(List<ParkingLot> parkingLotList) {
        if (parkingLotList.size() == 0){
            return null;
        }
        ParkingLot target = parkingLotList.get(0);
        for (ParkingLot parkingLot:parkingLotList){
            if (parkingLot.getBlankRate() > target.getBlankRate()){
                target = parkingLot;
            }
        }
        return target;
    }
}
