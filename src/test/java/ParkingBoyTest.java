import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class ParkingBoyTest {

    private ParkingBoy parkingBoy;
    private ParkingLot parkingLot;
    private MyCar myCar;

    @Before
    public void setUp() throws Exception {
        parkingBoy = new ParkingBoy();
        parkingLot = new ParkingLot();
        myCar = new MyCar();
    }

    @Test
    public void should_manage_parking_lot() throws Exception {
        parkingLot.setCapacity(1);
        parkingBoy.control(parkingLot);

        assertThat(parkingBoy.isContainLot(parkingLot), is(true));
    }

    @Test
    public void boy_should_park_car_success() throws Exception {
        parkingLot.setCapacity(1);
        parkingBoy.control(parkingLot);

        parkingBoy.park(myCar);

        assertThat(parkingBoy.isContainCar(myCar), is(true));
    }

    @Test
    public void should_not_park_when_all_lot_is_full() throws Exception {
        parkingLot.setCapacity(0);
        parkingBoy.control(parkingLot);

        parkingBoy.park(myCar);

        assertThat(parkingBoy.isContainCar(myCar),is(false));
    }

    @Test
    public void should_get_out_one_car_by_right_token() throws Exception {
        parkingLot.setCapacity(1);
        parkingBoy.control(parkingLot);
        parkingBoy.park(myCar);

        MyCar result = parkingBoy.getOut(myCar.getToken());

        assertThat(result,is(myCar));
    }

    @Test
    public void should_not_get_out_one_car_by_wrong_token() throws Exception {
        parkingLot.setCapacity(1);
        parkingBoy.control(parkingLot);
        parkingBoy.park(myCar);
        String wrongToken = "wrong";

        MyCar result = parkingBoy.getOut(myCar.getToken() + wrongToken);

        assertThat(result,nullValue());
    }
}
