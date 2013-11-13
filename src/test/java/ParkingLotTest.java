import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class ParkingLotTest {

    private ParkingLot parkingLot;
    private MyCar myCar;
    private MyCar myNewCar;

    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot();
        myCar = new MyCar();
        myNewCar = new MyCar();
    }

    @Test
    public void should_park_one_car() throws Exception {
        parkingLot.setCapacity(10);

        parkingLot.park(myCar);

        assertThat(parkingLot.contains(myCar), is(true));
    }

    @Test
    public void should_not_park_one_car_when_full() throws Exception {
        parkingLot.setCapacity(1);
        parkingLot.park(myCar);
        parkingLot.park(myNewCar);

        assertThat(parkingLot.contains(myNewCar), is(false));
    }

    @Test
    public void should_get_one_car_when_token_right() throws Exception {
        parkingLot.setCapacity(1);

        parkingLot.park(myCar);

        assertThat(parkingLot.getOut(myCar.getToken()), is(myCar));
    }


    @Test
    public void should_not_get_one_car_when_token_wrong() throws Exception {
        parkingLot.setCapacity(1);
        String wrongToken = "wrongToken";

        parkingLot.park(myCar);

        assertThat(parkingLot.getOut(myCar.getToken() + wrongToken), nullValue());
    }
}
