
import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLotList;

    public void setChooser(Chooser chooser) {
        this.chooser = chooser;
    }

    private Chooser chooser;

    public ParkingBoy() {
        this.parkingLotList = new ArrayList<ParkingLot>();
        this.chooser = new GenericChooser();
    }

    public boolean isContainLot(ParkingLot one) {
        return parkingLotList.contains(one);
    }

    public void control(ParkingLot one) {
        parkingLotList.add(one);
    }

    public void park(MyCar myCar) {
        ParkingLot target = chooser.choseParkingLot(parkingLotList);
        if (target != null){
            target.park(myCar);
        }
    }


    public boolean isContainCar(final MyCar myCar) {
        for (ParkingLot parkingLot : parkingLotList){
            if (parkingLot.has(myCar)){
                return true;
            }
        }
        return false;
    }

    public MyCar getOut(final String token) {
        ParkingLot result = null;
        for (ParkingLot parkingLot : parkingLotList){
            if (parkingLot.getOut(token) != null){
                result = parkingLot;
                break;
            }
        }
        return result != null ? result.getOut(token) : null;
    }
}
