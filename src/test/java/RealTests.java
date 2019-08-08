import com.featurespace.app.Postcode;
import com.featurespace.model.PostcodeStatus;
import com.featurespace.model.PostcodeStatusNearest;
import com.featurespace.model.PostcodeStatusValidate;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

public class RealTests
{
	public PostcodeStatusValidate pcv = new PostcodeStatusValidate();
	public Postcode validPostcode = new Postcode("CB3 0FA");
	public Postcode badPostcode = new Postcode("CB3 0FA");

	@Test public void testGoodPostcode()
	{
		pcv.setResult(true);
		pcv.setStatus(200.00);
		PostcodeStatusValidate psvActual = validPostcode.validate();
		assertEquals(pcv.getResult(), psvActual.getResult());
		assertEquals(pcv.getStatus(), psvActual.getStatus());
	}

	@Test public void testBadPostcode()
	{
		pcv.setResult(false);
		pcv.setStatus(200.00);
		PostcodeStatusValidate psvActual = badPostcode.validate();
		assertEquals(pcv.getStatus(), psvActual.getStatus());
		assertNotSame(pcv.getResult(), psvActual.getResult());
	}

	@Test public void testDetailsNotNull()
	{
		Postcode pc = new Postcode("CB3 0FA3");
		PostcodeStatus psActual = pc.getDetails();
		assertNotNull(psActual);
	}

	@Test public void testNearestNotNull()
	{
		PostcodeStatusNearest psnActual = validPostcode.getNearest();
		assertNotNull(psnActual);
	}

	@Test public void testDetails()
	{
		String expCountry = "England";
		String expRegion = "East of England";
		PostcodeStatus psActual = validPostcode.getDetails();
		String actualCountry = psActual.getResult().getCountry();
		String actualRegion = psActual.getResult().getRegion();
		assertEquals(expCountry,actualCountry);
		assertEquals(expRegion,actualRegion);
	}

	@Test public void testNearest()
	{
		String expCountry = "England";
		String expRegion = "East of England";
		String actualCountry = validPostcode.getNearest().getResult()[1].getCountry();
		String actualRegion = validPostcode.getNearest().getResult()[1].getRegion();
		assertEquals(expCountry,actualCountry);
		assertEquals(expRegion,actualRegion);
	}
}