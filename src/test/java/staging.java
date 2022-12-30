import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class staging {

    ChromeDriver nav;

    @Test
    public void Main(){
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        nav = new ChromeDriver();
        // maximiza a tela
        nav.manage().window().maximize();
        login();
        AcessoTenant();
        TelaDevice();
        TelaGrupo();
        TelaAplicativos();

    }


    public void login(){


        nav.get("https://app.pulsus.mobi");
        nav.findElement(By.xpath("//*[@id=\"identifier\"]")).click();
        nav.findElement(By.id("identifier")).click();
        //Login
        nav.findElement(By.xpath("//*[@id=\"identifier\"]")).sendKeys("timeqa@pulsus.mobi");
        nav.findElement(By.id("password")).click();
        //Password
        //nav.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("QAbggi123");
        nav.findElement(By.xpath("//*[@id=\"action\"]")).click();

    }
    public void AcessoTenant() {
        //fecha o logo do AE
        nav.findElement(By.xpath("//*[@id=\"react-ae-recommended-modal\"]/div/div/div[2]/span")).click();
    }
    public void TelaDevice() {

        nav.findElement(By.xpath("//*[@id=\"root\"]/div/nav/div[6]/a[1]/span[2]")).click();
    }
    public void TelaGrupo(){
        nav.findElement(By.xpath("//*[@id=\"root\"]/div/nav/div[7]/a[1]/span[2]")).click();
    }
    public void TelaAplicativos(){
        nav.findElement(By.xpath("//*[@id=\"root\"]/div/nav/div[8]/a[1]/span[2]")).click();
    }
}






