import java.util.ArrayList;
import java.util.List;

public class ParkingBoy implements Parkable {
    private List<Parkable> parkables;
    private String name;

    public void setChooser(Chooser chooser) {
        this.chooser = chooser;
    }

    private Chooser chooser;

    public ParkingBoy() {
        this.parkables = new ArrayList<Parkable>();
        this.chooser = new GenericChooser();
    }

    public boolean isContainLot(Parkable one) {
        return parkables.contains(one);
    }

    public void control(Parkable one) {
        parkables.add(one);
    }

    @Override
    public void park(MyCar myCar) {
        Parkable target = chooser.choseParkable(parkables);
        if (target != null) {
            target.park(myCar);
        }
    }

    @Override
    public boolean contains(final MyCar myCar) {
        for (Parkable parkingLot : parkables) {
            if (parkingLot.contains(myCar)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isAvaiable() {
        return parkables.size() > 0 && allParkablesAvailable();
    }

    @Override
    public String toList() {
        String result = "";
        for (Parkable parkable : parkables) {
            result = result+addPrexy(parkable.toList());
        }
        return name + "\n" + result;
    }

    private String addPrexy(String initial) {
        String result = "";
        String[] strings = initial.split("\n");
        for (String string : strings) {
            result = result + "--" + string + "\n";
        }
        return result;
    }

    private boolean allParkablesAvailable() {
        for (Parkable parkable : parkables) {
            if (parkable.isAvaiable()) return true;
        }
        return false;
    }

    @Override
    public MyCar getOut(final String token) {
        ParkingLot result = null;
        for (Parkable parkingLot : parkables) {
            if (parkingLot.getOut(token) != null) {
                result = (ParkingLot) parkingLot;
                break;
            }
        }
        return result != null ? result.getOut(token) : null;
    }

    public void setName(String name) {
        this.name = name;
    }
}
