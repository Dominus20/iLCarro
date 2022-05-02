package tests;


import org.testng.annotations.Test;

public class RegistrationTest  extends TestBase{

    @Test
    public void registrationSuccess(){
        int i = (int) (System.currentTimeMillis()/1000) %3600;
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis()/1000);

        app.user().openRegistrationForm();
        app.user().fillRegistrationForm("Renata", "Dow", "renata"+i+"@mail.com","Rr12345$");
        //app.user().checkPolicy();
        app.user().checkPolicyXY();
        app.user().submit();
        // AssertTrue(isRegistrationSuccess)





    }


}
