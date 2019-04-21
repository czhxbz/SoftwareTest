import java.io.IOException;
import java.nio.charset.Charset;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.*;
import com.csvreader.CsvReader;

public class TestCsv {

	public static void main(String[] args) throws IOException {

		int count = 0;
		CsvReader r = new CsvReader("C:\\Users\\86131\\Desktop\\软件测试\\实验二\\软件测试名单.csv", ',', Charset.forName("GBK"));
		r.readHeaders(); // 读头部
		while (r.readRecord()) {
			String number_csv = r.get("学号");
			String name_csv = r.get("姓名");
			String address_csv = r.get("git地址");
			String pwd_csv = number_csv.substring(number_csv.length() - 6, number_csv.length());			
			//System.out.print(number_csv+","+name_csv+","+address_csv+","+pwd_csv);
			// 读取CSV文件中数据

			String driverPath = System.getProperty("user.dir") + "/src/resources/driver/geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverPath);
			WebDriver driver = new FirefoxDriver();
			driver.get("http://121.193.130.195:8800");
			driver.manage().window().maximize();
			// 通过火狐浏览器打开网址

			WebElement input_name = driver.findElement(By.name("id"));
			WebElement input_pwd = driver.findElement(By.name("password"));
			WebElement btn = driver.findElement(By.id("btn_login"));
			input_name.clear();
			input_pwd.clear();
			input_name.sendKeys(number_csv);
			input_pwd.sendKeys(pwd_csv);
			btn.click();
			// 输入CSV中读出的数据
		
			String name = driver.findElement(By.id("student-name")).getText();
			String number = driver.findElement(By.id("student-id")).getText();
			String address = driver.findElement(By.id("student-git")).getText();
			//System.out.print(name+","+number+","+address);
			// 记录网页中的信息

			if (name_csv.equals(name) && number_csv.equals(number) && address_csv.equals(address))
			{
				System.out.println(name + "同学通过");
				count++;
			}
			else
				System.out.println(name + "同学未通过");
			driver.close();
		}
		r.close();
		System.out.println(count+"/143");
	}
}