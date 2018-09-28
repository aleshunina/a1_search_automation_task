package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ElementMaxValue {

    public String sortmaxvalue(WebDriver driver, By elementslistlocator){

        List<WebElement> myList=driver.findElements(elementslistlocator);
        List<String> all_elements_text=new ArrayList<String>();


        for(int i=1; i<myList.size(); i++){
            all_elements_text.add(myList.get(i).getAttribute("data-qa-selector-value"));
        }

        List<Integer> all_elements_int = new ArrayList<Integer>(all_elements_text.size());
        for(String current:all_elements_text){
            all_elements_int.add(Integer.parseInt(current));
        }

        String biggestvalue = Collections.max(all_elements_int).toString();
        return biggestvalue;
    }
}
