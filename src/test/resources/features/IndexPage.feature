Feature: Validate eshop contul meu page

  Scenario: User verifies that all elements are displayed from page
    Given user is on the index page
    When user clicks on contul meu
    When user introduces password and login
    Then user verifies that contul meu page is displayed

  Scenario: User verifies that mobile phones are displayed on screen
    Given user is on the index page
    When user clicks on contul meu
    When user introduces password and login
    When user click on telefoane button
    Then user verifies that telefoane screen is displayed

  Scenario: User verifies detalii cont
    Given user is on the index page
    When user clicks on contul meu
    When user introduces password and login
    When user clicks on contul meu from profile
    When user clicks on detalii cont button
    Then user verfies detalii cont button

  Scenario: User verify that can buy mobile phone with abonement
    Given user is on the index page
    When user clicks on contul meu
    When user introduces password and login
    When user click on telefoane button
    When user selects mobile phone
    When user clicks on cumpara button
    When user selects metoda de livrare
#    When user clicks on alege si continue button
    When user clicks on conectez cu aboiment nou
    Then user verifies abonamente section
    When user clicks on alege si continue button
    When user clicks on selecteaza button
    Then user verifies phone numbers with section

  Scenario: User verify that can buy only mobile phone
    Given user is on the index page
    When user clicks on contul meu
    When user introduces password and login
    When user click on telefoane button
    When user selects mobile phone
    When user clicks on cumpara button
    When user selects metoda de livrare
    When user clicks doar dispozitivul
    Then user verifies plaseaza comanda button
