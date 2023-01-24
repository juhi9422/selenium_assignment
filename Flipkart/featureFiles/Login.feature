@Login
Feature: Login functionality
  @CompleteCred
  Scenario Outline: Title of your scenario outline
    Given User is on login page
    When User enters "<mobile number>" and "<password>"
    And Clicks on login button
		Then Login button is not Displayed
    Examples: 
      |mobile number| password |
      |9403674723 	| juhi9422@|
      |9403674743 	| juhi9422@|
      
      
  @IncompleteCred1
  Scenario Outline: Title of your scenario outline
    Given User is on login page
    When User enters only Mobile number as"<mobile number>"
    And Clicks on login button
		Then Message is Displayed
    Examples: 
      |mobile number|
      |9403674723 	|
      
	@IncompleteCred2
  Scenario Outline: Title of your scenario outline
    Given User is on login page
    When User enters only Password as"<password>"
    And Clicks on login button
		Then Message is Displayed
    Examples: 
      | password |
      | juhi9422@|	
	
