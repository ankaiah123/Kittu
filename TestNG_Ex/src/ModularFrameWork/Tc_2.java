package ModularFrameWork;


import org.testng.annotations.Test;

import ModularFrameWork.BusinessFunctions;

public class Tc_2 
{
	@Test
	public void OrangeHRM() throws Exception
	{
		BusinessFunctions br=new BusinessFunctions();
		br.configdriver("chrome");
		
		br.openbrowser("http://apps.qaplanet.in/qahrm/login.php");
		br.LoginOrangeHrm("qaplanet1","lab1");
		br.Addemployee("Amarendra", "Boddu","C:\\Users\\Qaplanet\\Desktop\\abc.jpeg");
	}
}
