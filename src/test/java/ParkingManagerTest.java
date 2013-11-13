import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ParkingManagerTest {

    @Test
    public void testParkingManager() throws Exception {
        ParkingBoy parkingManager = new ParkingBoy();
        ParkingBoy basicBoy = generateBoy(10);
        parkingManager.control(basicBoy);
        MyCar car = new MyCar();

        parkingManager.park(car);

        assertThat(basicBoy.contains(car),is(true));
    }

    @Test
    public void testParkingManagerOwnLot() throws Exception {
        ParkingBoy parkingManager = new ParkingBoy();
        ParkingBoy basicBoy = generateBoy(0);
        parkingManager.control(basicBoy);
        ParkingLot personalLot = new ParkingLot();
        personalLot.setCapacity(2);
        parkingManager.control(personalLot);
        MyCar car = new MyCar();

        parkingManager.park(car);

        assertThat(basicBoy.contains(car),is(false));
        assertThat(personalLot.contains(car),is(true));

    }

    private ParkingBoy generateBoy(int capacity) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setCapacity(capacity);
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.control(parkingLot);
        return parkingBoy;
    }
}
