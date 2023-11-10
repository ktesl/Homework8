package homework14;

import homework9.Task1;
import homework9.Task2;
import homework9.Task3;
import homework9.Task4;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class TestNGTest {

    Task1 task1 = new Task1();
    Task2 task2 = new Task2();
    Task3 task3 = new Task3();
    Task4 task4 = new Task4();

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After method");
    }

    @Test(groups = {"recursion"})
    public void checkRecursion() {
        assertEquals("Java, World!", Task1.recursion("!dlroW ,avaJ"));
    }

    @Test(groups = {"recursion"})
    public void checkRecursionNegative() {
        assertNull(Task1.recursion(null));
    }

    @Test(groups = {"remove"})
    public void removePositive(){
        assertEquals("Java, Wor!", Task2.remove("Java, World!", "ld"));
    }

    @Test(groups = {"remove"})
    public void removeNegative(){
        assertNull(null);
    }

    @Test(groups = {"remove"})
    public void removeNegative2(){
        assertEquals("Java, World!", Task2.remove("Java, World!", null));
    }

    @Test(groups = {"remove"})
    public void removePositive2(){
        assertEquals("bc4efbc12ebc", Task3.remove("abcd4efabc123deabcdaaa", "ad3"));
    }

    @Test(groups = {"remove"})
    public void removeNegative3(){
        assertNull(null);
    }

    @Test(dataProvider = "phoneNumberPositive", groups = {"validatePhoneNumber"})
    public void validatePhoneNumberPositive(String phoneNumber){
        assertTrue(Task4.validatePhoneNumber(phoneNumber));
    }

    @Test(dataProvider = "phoneNumberNegative", groups = {"validatePhoneNumber"})
    public void validatePhoneNumberNegative(String phoneNumber){
        assertFalse(Task4.validatePhoneNumber(phoneNumber));
    }

    @DataProvider
    public Object[][] phoneNumberPositive(){
        return new Object[][]{
                { "+38(050)1111111" },
                { "+38(093)9999999" }
        };
    }

    @DataProvider
    public Object[][] phoneNumberNegative(){
        return new Object[][]{
                { "+38(095)123456" },
                { "+(993)99-999-999999" },
        };
    }

}