Feature: Automate Undostres web application

  Scenario: Verify if the user gets a success message and recharge gets successful after entering correct details
    Given Go to "http://sanbox.undostres.com.mx" under recarga celular select operator as "Telcel" from Operador field
    And Give this number "5523261151" under Numero de celular field
    And under  Monto de Recarga select 10 dollar normal recharge
    When click on siguiente
    Then Verify if the user able to reach to the next screen(Payment screen) or not
    And On payment screen click on tarjeta
    And enter the following details under card name:Test ,Card number:"4111111111111111" ,month="11",date="25",cvv="111"
    And under correo electronico field give email id as "test@test.com"
    And Click on Pagar con Tarjeta to do the recharge
    And on popup Enter the following email "automationexcersise@test.com"  and password "123456"
    And Verify if the user gets a success message and recharge gets successful

