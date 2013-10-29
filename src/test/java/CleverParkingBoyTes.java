import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class CleverParkingBoyTes {

    private  ParkingBoy parkingBoy;
    private  ParkingLot parkingLot1;
    private  ParkingLot parkingLot2;

    @Before
    public void setUp() throws Exception {
        parkingBoy = new ParkingBoy();
        parkingBoy.setChooser(new CleverChooser());
        parkingLot1 = new ParkingLot();
        parkingLot2 = new ParkingLot();
    }

    @Test
    public void should_park_car_in_most_blank_lot() throws Exception {
        parkingLot1.setCapacity(4);
        parkingLot2.setCapacity(5);
        parkingBoy.control(parkingLot1);
        parkingBoy.control(parkingLot2);
        MyCar myCar = new MyCar();

        parkingBoy.park(myCar);

        assertThat(parkingLot2.has(myCar),is(true));
    }

    @Test
    public void should_not_park_car_when_all_lot_is_full() throws Exception {
        parkingLot1.setCapacity(0);
        parkingLot2.setCapacity(0);
        parkingBoy.control(parkingLot1);
        parkingBoy.control(parkingLot2);
        MyCar myCar = new MyCar();

        parkingBoy.park(myCar);

        assertThat(parkingLot1.has(myCar),is(false));
        assertThat(parkingLot2.has(myCar),is(false));
    }

    @Test
    public void should_get_car_when_token_right() throws Exception {
        parkingLot1.setCapacity(10);
        parkingLot2.setCapacity(7);
        parkingBoy.control(parkingLot1);
        parkingBoy.control(parkingLot2);
        MyCar myCar = new MyCar();

        parkingBoy.park(myCar);

        assertThat(parkingBoy.getOut(myCar.getToken()),is(myCar));
    }

    @Test
    public void should_not_get_car_when_token_false() throws Exception {
        parkingLot1.setCapacity(10);
        parkingLot2.setCapacity(7);
        parkingBoy.control(parkingLot1);
        parkingBoy.control(parkingLot2);
        MyCar myCar = new MyCar();

        parkingBoy.park(myCar);

        String wrongToken = "wrong token";
        assertThat(parkingBoy.getOut(myCar.getToken()+ wrongToken),nullValue());
    }
}
