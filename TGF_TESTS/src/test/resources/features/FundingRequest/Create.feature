#Author: hiqatech@gmail.com
#Keywords Summary : FundingRequest Tests

Feature: FundingRequest

@SalesForceRegression
  Scenario: GOS - Funding Request - Malaria Allocation
    Given I read the "FundingRequest" test "TC07" data
    And I connect with the Admin user
    And I login with the "$FundPortfolioManager" user
    And I "click" the "Funding_Request_Main_Tab"
    And I am on the "FundingRequest" page
    And I "click" the "Funding_Request_Tab"
    And I select the "$AllocationCycle" "text" from the "Allocation_Cycle_Funding"
    And I select the "$Country" "text" from the "Country_Funding"
 		And I wait "14" secs for the "Country_Funding"
    And I "click" the "Components_Funding_Malaria_Option"
    And I "click" the "Search_Funding_Request"
    And I "click" the "New_Funding_Request"
    And I "click" the "Funding_Request_Type_Allocation"
    And I "enter" "$TRPWindow" into the "TRP_Window"
    And I wait "10" secs for the "TRP_Window"
    And I "click" the "Create_New_Funding_Request"
    And I take a screenshot as "evidence"
    