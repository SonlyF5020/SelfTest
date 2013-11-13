import java.util.List;

public class SmartChooser implements Chooser {

    @Override
    public Parkable choseParkable(List<Parkable> list) {
        if (list.size() == 0){
            return null;
        }

        ParkingLot target = (ParkingLot) list.get(0);

        for (Parkable parkingLot:list){
            ParkingLot realLot = (ParkingLot) parkingLot;

            if (realLot.getBlankRate() > target.getBlankRate()){
                target = realLot;
            }
        }
        return target;
    }
}
