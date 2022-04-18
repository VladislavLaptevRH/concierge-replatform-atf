# concierge-replatform-atf
automation testing framework created by mdovbenco

Introductory information                        Automated Testing Framework
===========================================================================

**Introduction**
************
The Automated Testing Framework (ATF) is a collection of libraries to
implement test programs using Java-Selenide-Cucumber. This is a behavior
driven development (BDD) approach to write automation test script to test Web.
It enables you to write and execute automated acceptance/unit tests.
Automate your test cases with minimal coding ATF-based test programs rely
on a separate runtime engine to execute them. The runtime engine is in charge
of isolating the test programs from the rest of the system to ensure that
their results are deterministic and that they cannot affect the running
system. The runtime engine is also responsible for gathering the results
of all tests and composing reports.


**Framework overview**
************
The cucumber BDD testing framework specifies acceptance tests as written
from the view of the Product Owner. Using keywords such as Given, When,
Then and And, acceptance criteria tests known as feature files can then
be broken down into testable steps.

**Hooks class** - Hooks class is most important class as it performs the following functions

**Step Definition Feature File** - Java class whereby the steps from the feature
file are broken down to be coded into automation tests.

**Feature Model Class** - Java class whereby the step definition calls on methods
that require action from the automated user such as entering text, finding/asserting
fields on the UI.

**
**chromeDriver.exe** - Local chromedriver necessary in order

**Download a Framework**
**********************
Github - https://github.com/RHCommerceDev/concierge-replatform-atf/

**Writing a test**
**************
The cucumber features goes in the features library and should have the
".feature" extension. You can start out by looking at features/my_first.feature.
You can extend this feature or make your own features using some of the
predefined steps that comes with selenium-cucumber.

**Use cucumber tags**
*******************
**_There are mainly two types of tag_** −

**Default tag** − Default tag has their predefined meanings. Example @Dev, @Ignore

**Custom tag** − Custom tag provides you full flexibility to choose appropriate
text for defining your tag.

**Generic steps**
*************
By using generic steps you can automate your test cases more quickly,
more efficiently and without much coding.


**Run a tests**
*************
There is a runner class named like RunCukeTests.java it's for run all tests.
You can run only one test too. Also it is possible to run all automation tests using Maven commands:

-to run all automation tests in command mode, please introduce the following command:
mvn clean test

-to run automation tests for filter, please type the following command:
mvn test -Dcucumber.filter.tags='@filter'

-to run automation tests for regression, please type the following command:
mvn test -Dcucumber.filter.tags='@regression'

Structure of automation testing framework:

*concierge-replatform-atf - modue of automation testing framework
    **build - folder with screenshot from tests
    **driver - folder with chromedriver
    **src
        ***main
        ****java
        *****com.test - the main package with classes for automation tests
            ******pageObject - package with page object pattern
            ******runners - package with the class from which tests started to execute
            ******stepdefinitions - package with the Java classes which implement features files
            ******utility - package with Hooks.class - is the main class with driver session settings
        ****resources - resource folder which contains feature files (Feature files use for write test cases in Cucumber style)

application.properties - main properties for automation testing framework (credentials data, base url)
extent.properties - responsible for generating the report


**Reporting**
The report will be created only after you run the tests from RunCuke.class 
or if run tests with: mvn clean tests command. Report will be generated in the following location:
target/cucumber-html-report/Index.html




    


