import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class ParkingLotTest {

    @Test
    public void should_park_one_car() throws Exception {
        ParkingLot parkingLot = new ParkingLot(10);
        MyCar myCar = new MyCar();

        parkingLot.park(myCar);

        assertThat(parkingLot.has(myCar),is(true));
    }

    @Test
    public void should_not_park_one_car_when_full() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        MyCar myCar = new MyCar();
        MyCar myNewCar = new MyCar();

        parkingLot.park(myCar);
        parkingLot.park(myNewCar);

        assertThat(parkingLot.has(myNewCar),is(false));
    }

    @Test
    public void should_get_one_car_when_token_right() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        MyCar myCar = new MyCar("99999");

        parkingLot.park(myCar);

        assertThat(parkingLot.getOut(myCar.getToken()),is(myCar));
    }


    @Test
    public void should_not_get_one_car_when_token_wrong() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        MyCar myCar = new MyCar("99999");

        parkingLot.park(myCar);

        assertThat(parkingLot.getOut(myCar.getToken()+"wrongToken"),nullValue());
    }
}
