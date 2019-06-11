package ModularFrameWork;
import org.testng.annotations.Test;

import ModularFrameWork.BusinessFunctions;

public class Tc_4 
{
	@Test()
	public void OrangeHRM() throws Exception
	{
	BusinessFunctions br=new BusinessFunctions();
	br.configdriver("chrome");
	
	br.openbrowser("http://apps.qaplanet.in/qahrm/login.php");
	br.LoginOrangeHrm("qaplanet1","lab1");
	/*br.Addemployee("Amarendra", "Boddu","C:\\Users\\Qaplanet\\Desktop\\abc.jpeg");
	br.editbutton("Chowdary","Ankaiah");
	br.calender("01-06-2019");*/

	br.emplist("s");
}
}