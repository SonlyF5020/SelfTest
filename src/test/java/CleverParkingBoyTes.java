import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CleverParkingBoyTes {

    private  CleverParkingBoy cleverParkingBoy;
    private  ParkingLot parkingLot1;
    private  ParkingLot parkingLot2;

    @Before
    public void setUp() throws Exception {
        cleverParkingBoy = new CleverParkingBoy();
        parkingLot1 = new ParkingLot();
        parkingLot2 = new ParkingLot();
    }
    @Ignore
    @Test
    public void should_park_car_in_most_blank_lot() throws Exception {
        parkingLot1.setCapacity(4);
        parkingLot2.setCapacity(5);
        cleverParkingBoy.control(parkingLot1);
        cleverParkingBoy.control(parkingLot2);
        MyCar myCar = new MyCar();

        cleverParkingBoy.park(myCar);

        assertThat(parkingLot2.has(myCar),is(true));
    }
}
