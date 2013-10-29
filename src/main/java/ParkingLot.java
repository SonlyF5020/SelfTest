
import java.util.ArrayList;
import java.util.List;


public class ParkingLot {

    private int capacity;
    private List<MyCar> carList;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.carList = new ArrayList<MyCar>();
    }

    public ParkingLot() {
        this.carList = new ArrayList<MyCar>();
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
        for (MyCar myCar : carList){
            if (myCar.getToken().equals(token)){
                return myCar;
            }
        }
        return null;
    }

    public int getBlank() {
        return capacity - carList.size();
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
