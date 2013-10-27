
public class CleverParkingBoy extends ParkingBoy {

    @Override
    public void park(MyCar myCar) {
        ParkingLot target = choseLot();
        target.park(myCar);
    }
}
