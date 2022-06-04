package manager;

import models.Auth;
import org.testng.annotations.DataProvider;

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
}
