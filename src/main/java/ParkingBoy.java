import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import java.util.List;

import static com.google.common.collect.Collections2.filter;
import static com.google.common.collect.Lists.newArrayList;

public class ParkingBoy {
    private List<ParkingLot> parkingLotList;

    public ParkingBoy() {
        this.parkingLotList = newArrayList();
    }

    public boolean isContainLot(ParkingLot one) {
        return parkingLotList.contains(one);
    }

    public void control(ParkingLot one) {
        parkingLotList.add(one);
    }

    public void park(MyCar myCar) {
        List<ParkingLot> availableLots = newArrayList(filter(parkingLotList,new Predicate<ParkingLot>() {
            @Override
            public boolean apply(ParkingLot parkingLot) {
                return parkingLot.getBlank()>0;
            }
        }));

        if(availableLots.size()>0){
            availableLots.get(0).park(myCar);
        }
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
