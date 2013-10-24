import com.google.common.collect.Lists;
import java.util.List;

public class ParkingLot {

    private int capacity;
    private List<MyCar> carList;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.carList = Lists.newArrayList();
    }

    public void park(MyCar myCar) {
        if (this.carList.size() < capacity) {
            this.carList.add(myCar);
        }
    }

    public boolean has(MyCar myCar) {
        return this.carList.contains(myCar);
    }

    public MyCar getOut(String token) {
        for (MyCar myCar:this.carList){
            if (myCar.getToken().equals(token)){
                return myCar;
            }
        }
        return null;
    }

    public int getBlank() {
        return capacity-carList.size();
    }
}
