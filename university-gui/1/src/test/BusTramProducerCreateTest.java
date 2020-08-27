import java.math.BigDecimal;
import java.time.LocalDate;

import com.gui.Bus;
import com.gui.FuelType;
import com.gui.Producer;
import com.gui.Tram;
import org.junit.*;

public class BusTramProducerCreateTest {

    @Test(expected = Exception.class)
    public void invalidVehicleManufactureDateTest() throws Exception {
        Producer testProducer = new Producer("Solaris", LocalDate.of(1998, 1, 1));

        new Bus(testProducer, LocalDate.of(20188, 10, 5), true, false,
                150000L, FuelType.NATURAL_GAS, new BigDecimal(7.8d));
    }

	@Test
	public void createBusAndTramTest() throws Exception {
        Producer producer = new Producer("Solaris", LocalDate.of(1999,1,1));

        Bus bus = new Bus(producer, LocalDate.of(2018, 10, 5), true, false,
                150000L, FuelType.NATURAL_GAS, new BigDecimal(7.8d));

        Tram tram = new Tram(producer, LocalDate.of(2015, 2, 5), false, true,
                110000L);


        Assert.assertEquals(2, bus.getAge());
        Assert.assertEquals("Solaris", bus.getProducer().getName());
        Assert.assertEquals(FuelType.NATURAL_GAS, bus.getFuelType());

        Assert.assertEquals(5, tram.getAge());
        Assert.assertEquals("Solaris", tram.getProducer().getName());
	}

    /*@BeforeClass
    public static void initializeTestClass() {
        // INVOKED ONCE WHEN A TEST CLASS IS LOADED
        testProducer
    }

	@Before
	public void initialize() {
		// INVOKED BEFORE EACH TEST
		System.out.println("before");
	}

	@After
	public void deinitialize() {
		// INVOKED AFTER EACH TEST
		System.out.println("after");
	}

	@AfterClass
	public static void deinitializeTestClass() {
		// INVOKED ONCE WHEN A TEST CLASS IS UNLOADED
		System.out.println("after class");
	}*/
}