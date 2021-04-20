package SeleniumSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 *HashMap-one of the dynamic Collections-DataSet/Algorithm
 *Based on Key,Value pair(Key-Set)
 *Not order based-To Sortout Array Use TreeSet,List-Order based
 *Hashing technique used to find the index on how to store the values in HashMap Array.
 *[Map.Entry,entrySet],.keySet(),.values(),streams, 4 ways used to iterate.
 * no duplicate values,not more than one Key Null value is permitted while storing.
 * Any no.of Null values can be stored/used.
 * .put,.get(key),.get(value),(.get(i)-both key and values in keySet), use 
 * Initialization Top-Casting with Generics used.
 */

public class HashMapConcept {

	public static void main(String[] args) {

//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
//		//driver.get("");

//Initialization(Top-Casting)Map-Interface,		
		Map<String, String> emp = new HashMap<String, String>();
		emp.put("name", "suganya");// Duplicate-ignored Latest retain
		emp.put("city", "Ohio");// Added
		emp.put("id", "234");// Added
		emp.put("company", null);// retained
		emp.put("Idcard", null);// retained
		emp.put("null", "Tom");// Ignored
		emp.put("name", "MSS");// retained
		emp.put("null", "Lisa");// Only one null Key is allowed so latest only added.

//Both key and values		
		for (String i : emp.keySet()) {
			System.out.println("key: " + i + " value: " + emp.get(i));
		}
		System.out.println("--------------------------------");

		for (Map.Entry<String, String> i : emp.entrySet()) {
			System.out.println("Key :" + i.getKey() + " Value :" + i.getValue());
		}
		System.out.println("-----------------------");
//Only values
		for (String v : emp.values()) {
			System.out.println(v);
		}
		System.out.println("-----------------------");
//Lambda	//internal iteration
	emp.forEach((K,V)->System.out.println("Key :"+K+" "+"Value :"+V));
	 
	}
}
