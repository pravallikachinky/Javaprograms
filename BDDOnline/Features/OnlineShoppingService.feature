Feature: Test Online shop service

Scenario: User wants to test the service of online shop

When User give call to '/sayHello' service
Then user should receive status 'ok' And response message 'Hello World From RestFulWebService'