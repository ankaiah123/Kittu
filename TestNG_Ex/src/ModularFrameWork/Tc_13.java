package ModularFrameWork;

import org.testng.annotations.Test;

public class Tc_13 
{
	@Test(groups="QAP1")
	public void OrangeHRM() throws Exception
	{
	BusinessFunctions br=new BusinessFunctions();
	br.configdriver("chrome");
	
	br.openbrowser("http://apps.qaplanet.in/qahrm/login.php");
	br.LoginOrangeHrm("qaplanet1","lab1");
    br.addjobspecifications("aaaaa", "He is a Betting Person");
    br.Editjobspecifications("suman","sai","Going to movie");
}

}
