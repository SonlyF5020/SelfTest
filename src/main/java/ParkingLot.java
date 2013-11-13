import java.util.ArrayList;
import java.util.List;


public class ParkingLot implements Parkable {

    private int capacity;
    private List<MyCar> carList;
    private String name;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.carList = new ArrayList<MyCar>();
    }

    public ParkingLot() {
        this.carList = new ArrayList<MyCar>();
    }

    @Override
    public void park(MyCar myCar) {
        if (this.carList.size() < capacity) {
            this.carList.add(myCar);
        }
    }

    @Override
    public MyCar getOut(String token) {
        for (MyCar myCar : carList){
            if (myCar.getToken().equals(token)){
                return myCar;
            }
        }
        return null;
    }

    public boolean contains(MyCar myCar) {
        return this.carList.contains(myCar);
    }

    @Override
    public boolean isAvaiable() {
        return capacity>0;
    }

    @Override
    public String toList() {
        return name+"\n";
    }

    public int getBlank() {
        return capacity - carList.size();
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getBlankRate() {
        return (double)getBlank()/(double)capacity;
    }

    public void setName(String name) {
        this.name = name;
    }
}
