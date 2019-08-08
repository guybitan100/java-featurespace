import com.featurespace.app.Postcode;
import com.featurespace.model.PostcodeStatusValidate;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class MokTests
{
	Postcode test = mock(Postcode.class);

	@Test public void testValidate()
	{
		PostcodeStatusValidate pcv = new PostcodeStatusValidate();
		pcv.setResult(true);
		pcv.setStatus(200.00);
		when(test.validate()).thenReturn(pcv);
		assertEquals(test.validate(), pcv);
	}

	@Test public void testNotValidate()
	{
		PostcodeStatusValidate pcv404 = new PostcodeStatusValidate();
		pcv404.setResult(true);
		pcv404.setStatus(404.00);
		when(test.validate()).thenReturn(new PostcodeStatusValidate());
		assertNotSame(test.validate(), pcv404);
	}
}