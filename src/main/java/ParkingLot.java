import com.google.common.base.Predicate;

import java.util.List;

import static com.google.common.collect.Collections2.filter;
import static com.google.common.collect.Lists.newArrayList;

public class ParkingLot {

    private int capacity;
    private List<MyCar> carList;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.carList = newArrayList();
    }

    public ParkingLot() {
        this.carList = newArrayList();
    }

    public void park(MyCar myCar) {
        if (this.carList.size() < capacity) {
            this.carList.add(myCar);
        }
    }

    public boolean has(MyCar myCar) {
        return this.carList.contains(myCar);
    }

    public MyCar getOut(final String token) {
        List<MyCar> targetCars = newArrayList(filter(carList, new Predicate<MyCar>() {
            @Override
            public boolean apply(MyCar myCar) {
                return myCar.getToken().equals(token);
            }
        }));
        return targetCars.size() > 0 ? targetCars.get(0) : null;
    }

    public int getBlank() {
        return capacity - carList.size();
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
