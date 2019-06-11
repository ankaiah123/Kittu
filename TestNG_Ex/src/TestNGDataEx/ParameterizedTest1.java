package TestNGDataEx;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class ParameterizedTest1
{
@Test
@Parameters("strUn")
public void parameterTest(String strUn)
{
	System.out.println("parameterized value is:"+strUn);
}

}
