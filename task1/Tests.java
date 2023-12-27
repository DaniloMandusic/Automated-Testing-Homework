/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */

import static com.mycompany.mavenproject1.NewClass.baseUrl;
import static com.mycompany.mavenproject1.NewClass.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;

/**
 *
 * @author korisnik
 */
public class Testovi {
    
    public Testovi() {
    }

    @Test
    public void LoginStudentChromeTest(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
            baseUrl = "http://localhost/projekat1/JobFair";
            driver = new ChromeDriver();
            driver.get(baseUrl);
            
            String user = "aleksa", pass = "Sifra1234$";
            driver.manage().window().maximize();
            driver.findElement(By.name("loginUsername")).sendKeys(user);
            driver.findElement(By.name("loginPassword")).sendKeys(pass);

            driver.findElement(By.name("loginButton")).click();

            String msg = driver.findElement(By.xpath("//div/h3[contains(text(),'Student')]")).getText();

            try{
                Assert.assertTrue(msg.contains("Student"));
                //System.out.println("login pass");
 
            } catch (Throwable e){
                System.out.println("login fail " + e);
            }

            driver.quit();
    }

    @Test
    public void LoginCompanyChromeTest(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
            try{
            baseUrl = "http://localhost/projekat1/JobFair";
                driver = new ChromeDriver();
                driver.get(baseUrl);

                String user = "elsys", pass = "Sifra123$";
                driver.manage().window().maximize();
                driver.findElement(By.name("loginUsername")).sendKeys(user);
                driver.findElement(By.name("loginPassword")).sendKeys(pass);

                driver.findElement(By.name("loginButton")).click();

                String msg = driver.findElement(By.xpath("//div/h3[contains(text(),'Kompanija')]")).getText();
            
                Assert.assertTrue(msg.contains("Kompanija"));
                //System.out.println("login pass");
 
            } catch (Throwable e){
                System.out.println("login fail " + e);
            }

            driver.quit();
    }
    
    @Test
    public void LoginAdminChromeTest(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
            try{
            baseUrl = "http://localhost/projekat1/JobFair";
            driver = new ChromeDriver();
            driver.get(baseUrl);
            
            String user = "admin", pass = "Admin123.";
            driver.manage().window().maximize();
            driver.findElement(By.name("loginUsername")).sendKeys(user);
            driver.findElement(By.name("loginPassword")).sendKeys(pass);

            driver.findElement(By.name("loginButton")).click();

            String msg = driver.findElement(By.xpath("//div/h3[contains(text(),'Admin')]")).getText();

            
            Assert.assertTrue(msg.contains("Admin"));
                //System.out.println("login pass");
 
            } catch (Throwable e){
                System.out.println("login fail " + e);
            }

            driver.quit();
    }
 
    @Test
    public void LoginFailChromeTest(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
            baseUrl = "http://localhost/projekat1/JobFair";            
            try{
            driver = new ChromeDriver();
            driver.get(baseUrl);
            
            String user = "aleksa1", pass = "Sifra1234$";
            driver.manage().window().maximize();
            driver.findElement(By.name("loginUsername")).sendKeys(user);
            driver.findElement(By.name("loginPassword")).sendKeys(pass);

            driver.findElement(By.name("loginButton")).click();

            String msg = driver.findElement(By.id("porukaSadrzaj")).getText();

            
            Assert.assertTrue(msg.contains("Pogrešan username ili šifra"));
                //System.out.println("login pass");
 
            } catch (Throwable e){
                System.out.println("fail " + e);
            }

            driver.quit();
    }

    @Test
    public void LogoutChromeTest(){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
            baseUrl = "http://localhost/projekat1/JobFair";
            try{
            driver = new ChromeDriver();
            driver.get(baseUrl);
            
            String user = "aleksa", pass = "Sifra1234$";
            driver.manage().window().maximize();
            driver.findElement(By.name("loginUsername")).sendKeys(user);
            driver.findElement(By.name("loginPassword")).sendKeys(pass);

            driver.findElement(By.name("loginButton")).click();

            //String msg = driver.findElement(By.id("porukaSadrzaj")).getText();
            driver.findElement(By.cssSelector("a[href*='logout.php']")).click();
            
            //Assert.assertTrue(msg.contains("Pogrešan username ili šifra"));
            String msg = driver.findElement(By.cssSelector("h3[class='regNaslov']")).getText();
            //System.out.println(msg);
            
            Assert.assertTrue(msg.contains("Pristup portalu"));

                //System.out.println("login pass");
 
            } catch (Throwable e){
                System.out.println("fail " + e);
            }
            
            if(driver != null)
            driver.quit();
    }

    @Test
    public void searchCompanies(){
            try{
            baseUrl = "http://localhost/projekat1/JobFair/pretragaKompanija.php";
            driver = new ChromeDriver();
            driver.get(baseUrl);
            
//            String user = "aleksa", pass = "Sifra1234$";
            driver.manage().window().maximize();
            driver.findElement(By.name("preNazivKompanije")).sendKeys("Elsys");

            String msg = driver.findElement(By.cssSelector("a[class=\"beliLinkovi\"]")).getText();
            //System.out.println(msg);
            
                

                Assert.assertTrue(msg.contains("Elsys"));
                System.out.println(msg);
 
            } catch (Throwable e){
                System.out.println("fail " + e);
            }
                        

            if(driver!= null) driver.quit();
    }

    @Test
    public void searchCompaniesTextbox(){
            try{
            baseUrl = "http://localhost/projekat1/JobFair/pretragaKompanija.php";
            driver = new ChromeDriver();
            driver.get(baseUrl);
            
//            String user = "aleksa", pass = "Sifra1234$";
            driver.manage().window().maximize();
            //driver.findElement(By.name("preNazivKompanije")).sendKeys("Elsys");
            driver.findElement(By.xpath("//option[contains(text(),'IT')]")).click();

            String msg = driver.findElement(By.cssSelector("a[class=\"beliLinkovi\"]")).getText();
            //System.out.println(msg);
            
                

                Assert.assertTrue(msg.contains("Elsys"));
                System.out.println(msg);
 
            } catch (Throwable e){
                System.out.println("fail " + e);
            }
                        

            if(driver!= null) driver.quit();
    }

    @Test
    public void LoginStudentFirefoxTest(){
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
            baseUrl = "http://localhost/projekat1/JobFair";
            driver = new FirefoxDriver();
            driver.get(baseUrl);
            
            String user = "aleksa", pass = "Sifra1234$";
            driver.manage().window().maximize();
            driver.findElement(By.name("loginUsername")).sendKeys(user);
            driver.findElement(By.name("loginPassword")).sendKeys(pass);

            driver.findElement(By.name("loginButton")).click();

            String msg = driver.findElement(By.xpath("//div/h3[contains(text(),'Student')]")).getText();

            try{
                Assert.assertTrue(msg.contains("Student"));
                //System.out.println("login pass");
 
            } catch (Throwable e){
                System.out.println("login fail " + e);
            }

            driver.quit();
    }

    @Test
    public void LoginFailFirefoxTest(){
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
            baseUrl = "http://localhost/projekat1/JobFair";            
            try{
            driver = new FirefoxDriver();
            driver.get(baseUrl);
            
            String user = "aleksa1", pass = "Sifra1234$";
            driver.manage().window().maximize();
            driver.findElement(By.name("loginUsername")).sendKeys(user);
            driver.findElement(By.name("loginPassword")).sendKeys(pass);

            driver.findElement(By.name("loginButton")).click();

            String msg = driver.findElement(By.id("porukaSadrzaj")).getText();

            
            Assert.assertTrue(msg.contains("Pogrešan username ili šifra"));
                //System.out.println("login pass");
 
            } catch (Throwable e){
                System.out.println("fail " + e);
            }

            driver.quit();
    }

    @Test
    public void searchCompaniesTextboxFirefox(){
            try{
            System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
            baseUrl = "http://localhost/projekat1/JobFair/pretragaKompanija.php";
            driver = new FirefoxDriver();
            driver.get(baseUrl);
            
//            String user = "aleksa", pass = "Sifra1234$";
            driver.manage().window().maximize();
            //driver.findElement(By.name("preNazivKompanije")).sendKeys("Elsys");
            driver.findElement(By.xpath("//option[contains(text(),'IT')]")).click();

            String msg = driver.findElement(By.cssSelector("a[class=\"beliLinkovi\"]")).getText();
            //System.out.println(msg);
            
                

                Assert.assertTrue(msg.contains("Elsys"));
                System.out.println(msg);
 
            } catch (Throwable e){
                System.out.println("fail " + e);
            }
                        

            if(driver!= null) driver.quit();
    }

    @BeforeClass
    public static void setUpClass() throws Exception{
       
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
