# Selenium Grid w Docker

Test project using Selenium with Docker, TestNG, ITestListener, and Extent Reports creating a efficient way to setup and run tests in parallel with multiple os and webdriver versions. Also, generating concise html reports on test completion.

## Getting Started

* In `SuiteBase.java` change line 32 to 
```
String nodeURL = "http://localhost:4444/wd/hub";
```

* Pull hub and node images
```
docker pull selenium/hub
```
```
docker pull selenium/node-firefox
```
```
docker pull selenium/node-chrome
```
```
docker pull selenium/node-edge
```
* Start Docker container
```
docker-compose up -d
```
* Open Selenium Hub in browser to view sessions
http://localhost:4444/

* Run `GridDocker.xml` to execute tests

### View generated report 
* go to `ReportsFolder` > right click the new report > open in > select browser of your choice



