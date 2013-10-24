import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ParkingBoy {
    private List<ParkingLot> parkingLotList;

    public ParkingBoy() {
        this.parkingLotList = new ArrayList<ParkingLot>();
    }

    public boolean isContainLot(ParkingLot one) {
        return parkingLotList.contains(one);
    }

    public void control(ParkingLot one) {
        parkingLotList.add(one);
    }

    public void park(MyCar myCar) {
        for (ParkingLot parkingLot : parkingLotList) {
            parkingLot.park(myCar);
            if (parkingLot.has(myCar)) {
                break;
            }
        }
//
//        Optional<ParkingLot> parkingLotOptional = Iterables.tryFind(parkingLotList, new Predicate<ParkingLot>() {
//            @Override
//            public boolean apply(ParkingLot parkingLot) {
//                return parkingLot.getBlank() > 0;
//            }
//        });
    }

    public boolean isContainCar(final MyCar myCar) {
        Optional<ParkingLot> parkingLotOptional = Iterables.tryFind(parkingLotList, new Predicate<ParkingLot>() {
            @Override
            public boolean apply(ParkingLot parkingLot) {
                return parkingLot.has(myCar);
            }
        });
        return parkingLotOptional.isPresent();
    }
}
