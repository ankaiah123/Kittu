package ModularFrameWork;

import org.testng.annotations.Test;

public class Tc_11 
{

	@Test()
	public void OrangeHRM() throws Exception
	{
	BusinessFunctions br=new BusinessFunctions();
	br.configdriver("chrome");
	
	br.openbrowser("http://apps.qaplanet.in/qahrm/login.php");
	br.LoginOrangeHrm("qaplanet1","lab1");
   /* br.Adminjob("Ankaiah", "The boy is a Very good Person","Automation");
    br.EditJobTitle("Mahesh", "He is My best Friend");
*/    br.adddelete("a");

}
}