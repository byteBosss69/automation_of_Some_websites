/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;
import java.awt.AWTException;
import java.net.MalformedURLException;


public class App {
    public void getGreeting() throws InterruptedException, MalformedURLException, AWTException {
        TestCases tests = new TestCases(); // Initialize your test class

        //TODO: call your test case functions one after other here

        tests.testCase01();
        //tests.testCase_01();
        // tests.testCase02();
        // tests.testCase03();
        // tests.testCase04();
        //  tests.testCase05();
        // tests.testCase06();
        // tests.testCase07();
        // tests.testCase08();
        // tests.testCase09();
        // tests.testCase10();
        // tests.testCase11();
        
        //END Tests
        tests.endTest(); // End your test by clearning connections and closing browser
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException, AWTException {
        new App().getGreeting();
    }
}
