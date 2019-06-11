package ModularFrameWork;
import org.testng.annotations.Test;

public class Tc_1 
{
@Test
public void OrangeHRM() throws Exception
{
	BusinessFunctions br=new BusinessFunctions();
	br.configdriver("chrome");
	
	br.openbrowser("http://apps.qaplanet.in/qahrm/login.php");
	br.LoginOrangeHrm("qaplanet1","lab1");



}
}
