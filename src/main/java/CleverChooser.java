import java.util.List;

public class CleverChooser implements Chooser {
    @Override
    public Parkable choseParkable(List<Parkable> list) {
        if (list.size() == 0){
            return null;
        }

        ParkingLot target = (ParkingLot) list.get(0);

        for (Parkable parkingLot:list){
            ParkingLot realLot = (ParkingLot) parkingLot;
            if (realLot.getBlank() > target.getBlank()){
                target = realLot;
            }
        }
        return target;
    }
}
