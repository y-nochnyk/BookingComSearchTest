package TestData;

import java.time.LocalDate;

public class TestData {
    public static final String BASE_PAGE_URL = "https://www.booking.com/index.en-gb.html";
    public static final String CITY_NAME = "New York";
    public static LocalDate currentDate = LocalDate.now();
    public static LocalDate currentPlusSeven = currentDate.plusDays(7L);
}
