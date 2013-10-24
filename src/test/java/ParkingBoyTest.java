import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParkingBoyTest {
    @Test
    public void should_manage_parking_lot() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot one = new ParkingLot(1);

        parkingBoy.control(one);

        assertThat(parkingBoy.isContainLot(one), is(true));
    }

    @Test
    public void boy_should_park_car_success() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot one = new ParkingLot(1);
        parkingBoy.control(one);
        MyCar myCar = new MyCar();

        parkingBoy.park(myCar);

        assertThat(parkingBoy.isContainCar(myCar), is(true));
    }
}
