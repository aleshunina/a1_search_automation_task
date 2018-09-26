package selector.sorting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by daleshun on 25.09.2018.
 */
public class getmaxvalue {



    public String sortmaxvalue(WebDriver driver, By elementslistlocator){

        List<WebElement> myList=driver.findElements(elementslistlocator);
        List<String> all_elements_text=new ArrayList<String>();

        for(int i=0; i<myList.size(); i++){

            all_elements_text.add(myList.get(i).getText());
            System.out.println(myList.get(i).getText());
        }
        String biggestvalue = Collections.max(all_elements_text);
        return biggestvalue;
    }
}
