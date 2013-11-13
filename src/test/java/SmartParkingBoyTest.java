import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SmartParkingBoyTest {
    private ParkingBoy parkingBoy;
    private ParkingLot parkingLot1;
    private ParkingLot parkingLot2;

    @Before
    public void setUp() throws Exception {
        parkingBoy = new ParkingBoy();
        parkingBoy.setChooser(new SmartChooser());
        parkingLot1 = Mockito.mock(ParkingLot.class);
        parkingLot2 = Mockito.mock(ParkingLot.class);
    }

    @Ignore
    @Test
    public void should_park_car_in_most_blank_rate_lot() throws Exception {
        parkingLot1.setCapacity(10);
        parkingLot2.setCapacity(10);
        mockCurrentBlanks(parkingLot1, 0.9);
        mockCurrentBlanks(parkingLot2, 0.5);
        parkingBoy.control(parkingLot1);
        parkingBoy.control(parkingLot2);
        MyCar myCar = new MyCar();

        parkingBoy.park(myCar);

        assertThat(parkingLot1.contains(myCar), is(true));
        assertThat(parkingLot2.contains(myCar), is(false));
    }

    private void mockCurrentBlanks(ParkingLot parkingLot, double blanks) {
        Mockito.when(parkingLot.getBlankRate()).thenReturn(blanks);
    }
}
