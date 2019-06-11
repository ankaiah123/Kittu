package ModularFrameWork;

import org.testng.annotations.Test;

public class Tc_7 
{
	@Test()
	public void OrangeHRM() throws Exception
	{
	BusinessFunctions br=new BusinessFunctions();
	br.configdriver("chrome");
	
	br.openbrowser("http://apps.qaplanet.in/qahrm/login.php");
	br.LoginOrangeHrm("qaplanet1","lab1");
    br.Admin("Venkatadri","India");
    br.address("nellore ");
    br.zipcode("524345","9956190082");
    br.edit("venkat");
    br.editlocation("Prathap", "Andhrapradesh");
    br.LocationDele("Name", "S");
}
}