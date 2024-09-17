package pages;

import java.util.HashMap;

public class FundingRequest {

    public static HashMap<String, String> elementLocators = new HashMap<>();

    public static void setElements()
    {
    	elementLocators.put("Allocation_Cycle_Tab", "//*[contains(@id,'AllocationCycle_lbl')]");
        elementLocators.put("Allocation_Program_Split_Tab", "//*[contains(@id,'AllocationTab_lbl')]");
        elementLocators.put("Funding_Request_Tab", "//*[contains(@id,'Form:FundingRequest_lbl')]");
        elementLocators.put("UQD_Register_Tab", "//*[contains(@id,'Form:PAAR_UQD_lbl')]");

        elementLocators.put("Allocation_Cycle_Allocation", "//select[contains(@id,'allocationCycleSearch')]");
        elementLocators.put("Country_Allocation", "//select[contains(@id,'Allocation_Split:countrySearch')]");
        elementLocators.put("Group_Of_Countries_Allocation", "//select[contains(@id,'Allocation_Split:groupOfCountriesSearch')]");
        elementLocators.put("Search_Allocation;", "//input[contains(@value,'Search')]");
        elementLocators.put("Clear_Selection_Allocation", "//input[contains(@value,'Clear Selection')]");
        elementLocators.put("Allocation_Utilization_Period","//*[contains(text(),'Allocation Utilization Period')]");
    	elementLocators.put("Allocation_And_Program_Split","//*[contains(text(),'Allocation & Program Split')]");
    	elementLocators.put("Copy_Original_Program_Split","//input[contains(@id,'agreeWithOriginalProgramSplit')]");
    	elementLocators.put("Revise_Program_Split","//input[contains(@id,'reviseProgramSplit')]");
    	elementLocators.put("HIV_AIDS_Allocation","//td//span[text()='HIV/AIDS']");
    	elementLocators.put("Tuberculosis_Allocation","//td//span[text()='Tuberculosis']");
    	elementLocators.put("Malaria_Allocation","//td//span[text()='Malaria']");
    	elementLocators.put("RSSH_Allocation","//td//span[text()='RSSH']");

    	elementLocators.put("Save_Allocation","//input[@value='Save']");
    	elementLocators.put("Delete_Allocation","//input[@value='Delete']");
    	elementLocators.put("Reject_Allocation","//input[@value='Reject']");
    	elementLocators.put("Attachments_Allocation_Table_Allocation_Letter","//*[@id='TableAndButtonsallocationSplit']//table//tbody//tr//td[text()='AllocationLetter']");
    	elementLocators.put("Attachments_Allocation_Table_Originel_File_Name_Select","//*[@name='Select Original Name']//select");
    	elementLocators.put("Attached_File_Delete_Confirm","//*[@id='openModalDelete']//input[@value='Delete']");
    	elementLocators.put("Attached_File_Delete_Confirm_Close","//*[@id='openModalDelete']//*[@class='close']");

    	elementLocators.put("Allocation_Cycle_Funding","//select[contains(@id,'frCycleSearch')]");
    	elementLocators.put("Country_Funding","//select[contains(@id,'frCountrySearch')]");
    	elementLocators.put("Group_Of_Countries_Funding","//select[contains(@id,'frGroupOfCountriesSearch')]");
    	elementLocators.put("Components_Funding_HIVAIDS_Option","//select[contains(@id,'frComponents')]//option[text()='HIV/AIDS']");
    	elementLocators.put("Components_Funding_Tuberculosis_Option","//select[contains(@id,'frComponents')]//option[text()='Tuberculosis']");
    	elementLocators.put("Components_Funding_Malaria_Option","//select[contains(@id,'frComponents')]//option[text()='Malaria']");
    	elementLocators.put("Components_Funding_RRSH_Option","//select[contains(@id,'frComponents')]//option[text()='RSSH']");
    	elementLocators.put("Components_Funding","//select[contains(@id,'frComponents')]");

    	elementLocators.put("Search_Funding_Request","//label[normalize-space(.)='Component(s)']/parent::div/following-sibling::div//input[1]");
    	elementLocators.put("Clear_Selection_Funding","//label[normalize-space(.)='Component(s)']/parent::div/following-sibling::div//input[2]");
    	elementLocators.put("New_Funding_Request","//input[@value='New Funding Request']");
    	elementLocators.put("PAAR_Preselected_Info","//*[text()='Funding Request Type PAAR is Pre-Selected']");
    	elementLocators.put("PAAR_Preselected_Message","//*[text()='The PAAR Funding Request type will automatically be selected for you']");

    	elementLocators.put("Allocation_Checked","//span[normalize-space(.)='Allocation']/parent::div//input[@checked='checked']");
    	elementLocators.put("Funding_Request_Type_Allocation","//span[normalize-space(.)='Allocation']/parent::div//input");
    	elementLocators.put("PAAR_Checked","//span[normalize-space(.)='PAAR']/parent::div//input[@checked='checked']");
    	elementLocators.put("Funding_Request_Type_PAAR","//span[normalize-space(.)='PAAR']/parent::div//input");
    	elementLocators.put("Funding_Request_Type_Matching_Funds","//span[normalize-space(.)='Matching Funds']/parent::div//input");
    	elementLocators.put("Funding_Request_Type_Multicountry","//span[normalize-space(.)='Multicountry']/parent::div//input");
    	elementLocators.put("Funding_Request_Type_Strategic_Initiative","//span[normalize-space(.)='Strategic Initiative']/parent::div//input");
    	elementLocators.put("Funding_Request_Type_Technical_Record","//span[normalize-space(.)='Technical Record']/parent::div//input");
    	elementLocators.put("Funding_Request_Type_PAAR_Update","//span[normalize-space(.)='PAAR Update']/parent::div//input");
    	elementLocators.put("Funding_Request_Type_Other","//span[normalize-space(.)='Other']/parent::div//input");
    	elementLocators.put("TRP_Window","//*[normalize-space(.)='TRP Window']/parent::div/following-sibling::div//span/input");
    	elementLocators.put("Create_New_Funding_Request","//input[@value='Create New Funding Request']");
    	elementLocators.put("Cancel_New_Funding_Request","//input[@value='Cancel']");
    	elementLocators.put("Error_You_Cannot_Create","//*[contains(text(),'Error: You cannot create')]");
    	elementLocators.put("Error_TPR_Window_Must_Be","//*[contains(text(),'Error:TRP Window must be')]");
    	elementLocators.put("RSSH_Popup","//*[@class='custPopupFr' and contains(text(),'select RSSH')]");
    	elementLocators.put("RSSH_Proceed","//input[@value='Proceed']");
    	elementLocators.put("RSSH_Cancel","//input[@value='Cancel']");

    	elementLocators.put("DeleteFRQuestion","//*[text()='You are about to delete a Funding Request including all records and related documents. Do you want to proceed?']");
    	elementLocators.put("DeleteFRConfirm","//*[contains(text(),'delete a Funding Request')]//following-sibling::footer//input[@value='Delete']");
    	elementLocators.put("LastFundingRequestName","//b[contains(text(), 'Funding Request')]/ancestor::div/following-sibling::span/table//tr[last()]//td[2]");
    	elementLocators.put("FR_Access_Message","//*[text()='Error: You cannot create, edit or delete Funding Request for your role Finance Specialist']");
    	elementLocators.put("FR_Name","//label[text() = 'Funding Request:']/following::a[1]");
    	elementLocators.put("FR_Component","//label[text() = 'Component:']/following::span[1]");
    	elementLocators.put("FR_TRP_Window","//label[text() = 'TRP Window Registration:']/following::span[1]/input[@value]");
    	elementLocators.put("FR_Stage","//label[text() = 'Funding Request Stage:']/following::span[1]");
    	elementLocators.put("FR_Type","//label[text() = 'Funding Request Type:']/following::span[1]");
    	elementLocators.put("FR_Submission_Type","//label[text() = 'Submission Type:']/following::span[1]");
    	elementLocators.put("AUP_Start_Date","//label[text()='AUP Start Date:']/following-sibling::span");
    	elementLocators.put("AUP_End_Date","//label[text()='AUP End Date:']/following-sibling::span");
    	elementLocators.put("Set_Proposed_Imp_Start_Date","//label[normalize-space(.)='Proposed Implementation Period Start Date:']/following-sibling::span//input");
    	elementLocators.put("Set_Proposed_Imp_End_Date","//label[normalize-space(.)='Proposed Implementation Period End Date:']/following-sibling::span//input");
    	elementLocators.put("Proposed_Imp_Start_Date","//label[normalize-space(.)='Proposed Implementation Period Start Date:']/following-sibling::span");
    	elementLocators.put("Proposed_Imp_End_Date","//label[normalize-space(.)='Proposed Implementation Period End Date:']/following-sibling::span");
    	elementLocators.put("Allocation_Amount","//td[text()='Allocation Request']/following::input[1]");
    	elementLocators.put("PAAR_Amount","//td[text()='Prioritized Above Allocation Request (PAAR)']/following::input[1]");
    	elementLocators.put("Strategic_Initiative_Amount","//td[text()='Strtegic Initiative']/following::input[1]");
    	elementLocators.put("Technical_Record_Amount","//td[text()='Technical Record']/following::input[1]");
    	elementLocators.put("Multicountry_Amount","//td[text()='Multicountry']/following::input[1]");
    	elementLocators.put("Other_Amount","//td[text()='Other']/following::input[1]");
    	elementLocators.put("MatchingFunds_HIV_Amount","//td[contains(text(), 'HIV')]//following::td/input");
    	elementLocators.put("MatchingFunds_Malaria_Amount","//td[contains(text(), 'Malaria')]//following::td/input");
    	elementLocators.put("MatchingFunds_TB_Amount","//td[contains(text(), 'Tuberculosis')]//following::td/input");
    	elementLocators.put("MatchingFunds_RSSH_Amount","//td[contains(text(), 'RSSH')]//following::td/input");
    	elementLocators.put("Save_Funding_Request","//*[contains(@id,'Form:FundingRequest')]//input[@value='Save']");
    	elementLocators.put("Save_And_Return_Funding_Request","//*[contains(@id,'Form:FundingRequest')]//input[@value='Save & Return']");
    	elementLocators.put("Delete_Funding_Request","//*[contains(@id,'Form:FundingRequest')]//input[@value='Delete']");
    	elementLocators.put("Cancel_Funding_Request","//input[@value='Cancel']");
    	elementLocators.put("Rollback_Funding_Request","//input[@value='Rollback']");

        elementLocators.put("FundingRequest", "//*[@class='oneAlohaPage']//iframe");

    }

    public static String getElementSelector(String element_name)
    {
        setElements();
        String elementLocator = elementLocators.get(element_name);
        return elementLocator;
    }

}
