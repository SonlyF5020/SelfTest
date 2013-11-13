import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class OutputTest {

    @Test
    public void testParkingLot() throws Exception {
        String lotName = "parlingLot";
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName(lotName);

        String result = parkingLot.toList();
        System.out.println(result);

        assertThat(result,notNullValue());
    }

    @Test
    public void testParkingBoy() throws Exception {
        String boyName = "parkingBoy";
        String lotName1 = "parkingLot_1";
        String lotName2 = "parkingLot_2";

        ParkingBoy boy = new ParkingBoy();
        boy.setName(boyName);

        ParkingLot lot1 = new ParkingLot();
        lot1.setName(lotName1);
        ParkingLot lot2 = new ParkingLot();
        lot2.setName(lotName2);

        boy.control(lot1);
        boy.control(lot2);

        String result = boy.toList();
        System.out.println(result);

        assertThat(result,notNullValue());
    }

    @Test
    public void testParkingManager() throws Exception {
        String managerName = "parkingManager";
        String boyName = "parkingBoy";
        String lotName = "parkingLot";

        ParkingBoy manager = new ParkingBoy();
        manager.setName(managerName);

        ParkingBoy boy = new ParkingBoy();
        boy.setName(boyName);

        ParkingLot lot = new ParkingLot();
        lot.setName(lotName);

        boy.control(lot);
        manager.control(boy);

        String result = manager.toList();
        System.out.println(result);

        assertThat(result,notNullValue());

    }

    @Test
    public void testComplexPart() throws Exception {
        String bigManagerName = "Big";
        ParkingBoy big = new ParkingBoy();
        big.setName(bigManagerName);

        String manager1_name = "parkingManager_1";
        String manager2_name = "parkingManager_2";
        ParkingBoy manager_1 = new ParkingBoy();
        manager_1.setName(manager1_name);
        ParkingBoy manager_2 = new ParkingBoy();
        manager_2.setName(manager2_name);

        String boy1_name = "parkingBoy_1";
        String boy2_name = "parkingBoy_2";
        ParkingBoy boy_1 = new ParkingBoy();
        boy_1.setName(boy1_name);
        ParkingBoy boy_2 = new ParkingBoy();
        boy_2.setName(boy2_name);

        String lot1_name = "parkingLot_1";
        String lot2_name = "parkingLot_2";
        String lot3_name = "parkingLot_3";
        String lot4_name = "parkingLot_4";
        ParkingLot lot_1 = new ParkingLot();
        lot_1.setName(lot1_name);
        ParkingLot lot_2 = new ParkingLot();
        lot_2.setName(lot2_name);
        ParkingLot lot_3 = new ParkingLot();
        lot_3.setName(lot3_name);
        ParkingLot lot_4 = new ParkingLot();
        lot_4.setName(lot4_name);


        big.control(manager_1);
        big.control(manager_2);
        manager_1.control(lot_1);
        boy_1.control(lot_2);
        boy_1.control(lot_3);
        boy_2.control(lot_4);
        manager_2.control(boy_1);
        manager_2.control(boy_2);

        String result = big.toList();
        System.out.println(result);

        assertThat(result,notNullValue());

    }
}
