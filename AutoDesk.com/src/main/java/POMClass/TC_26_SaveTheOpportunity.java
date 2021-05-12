package POMClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.objectrepository.CreateOpportunityPage;
import com.crm.comcast.objectrepository.HomePage;
import com.crm.comcast.objectrepository.OpportunityInformationPage;
import com.crm.comcast.objectrepository.OpportunityPage;
import com.crm.vtiger.genericUtilities.BaseClass;

public class TC_26_SaveTheOpportunity extends BaseClass {

	@Test
	
	public void createOpportunityAndClickOnSave() throws Throwable 
	{
		
		String oppName = eutil.getExcelDatas("Sheet1", 1, 2)+"_"+ju.getRandomData();
		
		//Navigate to Opportunity page
		
		HomePage hp=new HomePage(driver);
		hp.getOpportunityLink().click();
		
		//Navigate to create new opp name
		
		OpportunityPage oPage=new OpportunityPage(driver);
		oPage.getCreateOpportunityIMG().click();
		
		//
		CreateOpportunityPage cop=new CreateOpportunityPage(driver);
		cop.createOpportunity(oppName);
		cop.getOpportunityNameTF();
		
		//cop.getRelatedToDropDown();
		cop.getRelatedToBtn().click();
		cop.getSaveBtn().click();
		
//		OpportunityInformationPage oip= new OpportunityInformationPage(driver);
//		String oppSuccessfulMsg = oip.getOpportunityInfo().getText();
//		 
//		boolean status = oppSuccessfulMsg.contains(oppName);
//		Assert.assertTrue(status);
	}
}
