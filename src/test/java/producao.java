import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;


public class producao {
    WebDriver nav = new ChromeDriver();

    @BeforeClass
    public void testScreen(){
        // System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        //WebDriver nav = new ChromeDriver();
        nav.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        nav.manage().window().maximize();
        nav.get("https://app.pulsus.mobi");
        nav.findElement(By.id("identifier")).click();
        nav.findElement(By.id("identifier")).sendKeys("");
        nav.findElement(By.id("password")).click();
        nav.findElement(By.id("password")).sendKeys("");
        nav.findElement(By.id("action")).click();
        nav.findElement(By.xpath("//*[@id=\"react-ae-recommended-modal\"]/div/div/div[2]/span")).click();
    }

    @AfterClass
    public void logoff () {
        nav.findElement(By.cssSelector(".dropdown:nth-child(4) > a svg")).click();
        nav.findElement(By.linkText("Sair")).click();
    }
    @Test
    public void dashboard() {
         nav.findElement(By.cssSelector(".nav-item-dashboard .nav-item-label")).click();
         nav.findElement(By.cssSelector(".dashboard-header")).click();
    }
    @Test
    public void consumoDeDados() {
        nav.findElement(By.cssSelector("nav > .nav-item:nth-child(2) .nav-item-label")).click();
        Assert.assertEquals(nav.findElement(By.cssSelector(".content-title")).getText(), "Consumo de Dados");
    }
    @Test
    public void localizacao() {
        nav.findElement(By.cssSelector(".nav-item:nth-child(3) > a > .nav-item-label")).click();
        Assert.assertEquals(nav.findElement(By.cssSelector(".content-title")).getText(), "Mapa de localizações");
    }
    @Test
    public void track() {
        nav.findElement(By.cssSelector("nav > .nav-item:nth-child(4) > a")).click();
        Assert.assertEquals(nav.findElement(By.cssSelector(".map-sidebar-header > h3")).getText(), "Track");
    }
    @Test
    public void pulsusInsight() {
        nav.findElement(By.cssSelector(".nav-item:nth-child(5) .nav-item-label")).click();
    }

    @Test
    public void geofence() {
        nav.findElement(By.cssSelector(".nav-item:nth-child(6) .nav-item-label")).click();
    }

    @Test
    public void dispositivosPaginasInternas() {
        nav.findElement(By.cssSelector(".nav-item:nth-child(8) .nav-item-label")).click();
        Assert.assertEquals(nav.findElement(By.cssSelector(".datagrid-title > h3")).getText(), "Dispositivos");
        nav.switchTo().frame("devices-new-iframe");
        nav.findElement(By.cssSelector(".sc-fLRopR:nth-child(9) .id-link")).click();
        Assert.assertEquals(nav.findElement(By.cssSelector(".active:nth-child(2)")).getText(), "205");
        nav.findElement(By.id("tab-app-load")).click();
        nav.findElement(By.cssSelector(".nav-item:nth-child(3) > .nav-link")).click();
        nav.findElement(By.cssSelector(".nav-item:nth-child(4) > .nav-link")).click();
        nav.findElement(By.id("tab-phone-calls-load")).click();
        nav.findElement(By.cssSelector(".nav-item:nth-child(6) > .nav-link")).click();
    }
    @Test
    public void grupos() {
        nav.findElement(By.cssSelector(".nav-item:nth-child(9) .nav-item-label")).click();
        Assert.assertEquals(nav.findElement(By.cssSelector(".datagrid-title > h3")).getText(), "Grupos");
    }
    @Test
    public void aplicativos() {
        nav.findElement(By.cssSelector(".nav-item:nth-child(10) .nav-item-label")).click();
        Assert.assertEquals(nav.findElement(By.cssSelector(".datagrid-title > h3")).getText(), "Aplicativos");
    }
    @Test
    public void launchers() {
        nav.findElement(By.cssSelector(".launcher-nav .nav-item-label")).click();
        Assert.assertEquals(nav.findElement(By.cssSelector(".datagrid-title > h3")).getText(), "Launchers");
        nav.findElement(By.cssSelector("tr:nth-child(13) .media a")).click();
        Assert.assertEquals(nav.findElement(By.cssSelector(".launcher-name")).getText(), "teste_Gabi");
    }
    @Test
    public void configuracoes() {
        nav.findElement(By.cssSelector(".nav-item:nth-child(2) > .div .nav-item-label")).click();
        Assert.assertEquals(nav.findElement(By.cssSelector(".datagrid-title > h3")).getText(), "Configurações");
        nav.findElement(By.cssSelector("tr:nth-child(1) .media span")).click();
        Assert.assertEquals(nav.findElement(By.cssSelector(".clipped")).getText(), "config_gabi");
        nav.findElement(By.linkText("FM+WP")).click();
        nav.findElement(By.cssSelector(".nav-item:nth-child(3) > .nav-link")).click();
        nav.findElement(By.cssSelector(".nav-item:nth-child(4) > .nav-link")).click();
        nav.findElement(By.cssSelector(".nav-item:nth-child(5) > .nav-link")).click();
        nav.findElement(By.cssSelector(".nav-item:nth-child(6) > .nav-link")).click();
        nav.findElement(By.cssSelector(".nav-item:nth-child(7) > .nav-link")).click();
    }
    @Test
    public void arquivos() {
        nav.findElement(By.cssSelector(".nav-item:nth-child(3) > .div .nav-item-label")).click();
        Assert.assertEquals(nav.findElement(By.cssSelector(".datagrid-title > h3")).getText(), "Arquivos");
    }
    @Test
    public void enterprise() {
        nav.findElement(By.cssSelector(".nav-category-body > .nav-item:nth-child(4) .nav-item-label")).click();
        Assert.assertEquals(nav.findElement(By.cssSelector(".info:nth-child(1) > .info-label")).getText(), "ENTERPRISE ID");
    }
    @Test
    public void configuracoesIos() {
        nav.findElement(By.cssSelector(".nav-category:nth-child(12) .div .nav-item-label")).click();
        Assert.assertEquals(nav.findElement(By.cssSelector(".datagrid-title > h3")).getText(), "Configurações iOS");
        nav.findElement(By.cssSelector(".nav-category-body > .nav-item:nth-child(2) > a > .nav-item-label")).click();
        Assert.assertEquals(nav.findElement(By.cssSelector("h3:nth-child(1)")).getText(), "APNS");
    }
}
