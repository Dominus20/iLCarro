package manager;

import models.Auth;
import models.Car;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> loginValidDataSTR(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"noa@gmail.com", "Nnoa12345$"});
        list.add(new Object[]{"noa@gmail.com", "Nnoa12345$"});
        list.add(new Object[]{"noa@gmail.com", "Nnoa12345$"});
        list.add(new Object[]{"noa@gmail.com", "Nnoa12345$"});


        return  list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginValidDataAuth(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Auth.builder().email("noa@gmail.com").password("Nnoa12345$").build()});
        list.add(new Object[]{Auth.builder().email("noa@gmail.com").password("Nnoa12345$").build()});
        list.add(new Object[]{Auth.builder().email("noa@gmail.com").password("Nnoa12345$").build()});


        return  list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> carValidData(){

        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Car.builder().address("Tel Aviv, Israel")//adress
                .make("BMW")
                .model("M5")
                .year("2018")
                .engine("2.5")
                .fuel("Electric")//select
                .gear("MT")//select
                .wD("AWD")//select
                .doors("4")
                .seats("5")
                .carClass("C")
                .fuelConsumption("6.5")
                .carRegNumber("000-00-689" )
                .price("80")
                .distanceIncluded("700")
                .features("type of features")
                .about("very nice car").build()});
        list.add(new Object[]{Car.builder().address("Tel Aviv, Israel")//adress
                .make("BMW")
                .model("M5")
                .year("2018")
                .engine("2.5")
                .fuel("Electric")//select
                .gear("MT")//select
                .wD("AWD")//select
                .doors("4")
                .seats("5")
                .carClass("C")
                .fuelConsumption("6.5")
                .carRegNumber("000-00-670" )
                .price("80")
                .distanceIncluded("700")
                .features("type of features")
                .about("very nice car").build()});
        list.add(new Object[]{Car.builder().address("Tel Aviv, Israel")//adress
                .make("BMW")
                .model("M5")
                .year("2018")
                .engine("2.5")
                .fuel("Electric")//select
                .gear("MT")//select
                .wD("AWD")//select
                .doors("4")
                .seats("5")
                .carClass("C")
                .fuelConsumption("6.5")
                .carRegNumber("000-00-671")
                .price("80")
                .distanceIncluded("700")
                .features("type of features")
                .about("very nice car").build()});
        list.add(new Object[]{Car.builder().address("Tel Aviv, Israel")//adress
                .make("BMW")
                .model("M5")
                .year("2018")
                .engine("2.5")
                .fuel("Electric")//select
                .gear("MT")//select
                .wD("AWD")//select
                .doors("4")
                .seats("5")
                .carClass("C")
                .fuelConsumption("6.5")
                .carRegNumber("000-00-672")
                .price("80")
                .distanceIncluded("700")
                .features("type of features")
                .about("very nice car").build()});
        list.add(new Object[]{Car.builder().address("Tel Aviv, Israel")//adress
                .make("BMW")
                .model("M5")
                .year("2018")
                .engine("2.5")
                .fuel("Electric")//select
                .gear("MT")//select
                .wD("AWD")//select
                .doors("4")
                .seats("5")
                .carClass("C")
                .fuelConsumption("6.5")
                .carRegNumber("000-00-673")
                .price("80")
                .distanceIncluded("700")
                .features("type of features")
                .about("very nice car").build()});

        return  list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> regValidData() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("D:\\QA_TelRan\\iLCarro\\123.csv")));
        String line = reader.readLine();      //Sony,Snow,wow@gmail.com,Ww12345$

        while (line!= null){
           String[]split =  line.split(",");     //[Sony],[Snow],[wow@gmail.com],[Ww12345$]
            list.add(new Object[]{Auth.builder().name(split[0]).lastName(split[1]).email(split[2]).password(split[3]).build()});
           line = reader.readLine();   //Tony,Dow,wow1@gmail.com,Ww12345$
        }

        return  list.iterator();

    }
}
