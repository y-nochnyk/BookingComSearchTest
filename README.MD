# BookingComSearchTest
End-to-end tests performed for: https://www.booking.com/
## Prerequisites
* **JDK version >= 11.0.1**
* **Apache Maven version >= 3.6.0**
* **Google Chrome version <= 81.0**
* **FireFox Mozilla version <= 76.0**
## Task:
Implement​ ​a​ ​test​ ​suite​ ​that​ ​does​ ​a​ ​single​ ​test: 
1. It​ ​should​ ​go​ ​to​ ​the​ ​https://www.booking.com​ ​page 
2. Fill​ ​in​ ​the​ ​form​ ​with​ ​values: Destination​:​ ​“New​ ​York” Check-in​:​ ​<current​ ​date> Check-out​:​ ​<current​ ​date​ ​+​ ​7​ ​days> And​ ​submit​ ​the​ ​search​ ​form. 
3. On​ ​the​ ​search​ ​results​ ​page,​ ​it​ ​should​ ​check​ ​whether​ ​there​ ​is​ ​at​ ​least​ ​1​ ​result​ ​and​ ​all results​ ​are​ ​from​ ​New​ ​York​ ​(it​ ​should​ ​contain​ ​“New​ ​York”​ ​in​ ​the​ ​location​ ​text).
4. Browsers: Chrome, Firefox. 
## Run 
* **To run tests for Chrome via terminal use:**
```
mvn test -Dbrowser=chrome
```
* **To run tests for Firefox via terminal use:**
```
mvn test -Dbrowser=firefox
```