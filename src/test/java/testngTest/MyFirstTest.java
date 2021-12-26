package testngTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Objects;

public class MyFirstTest {
    @Test(priority = 10, groups = "group1", dataProvider = "logins")
    public void getUser(String user, String password, String role){
        System.out.printf("User: %s - Pass: %s - Role: %s%n", user, password, role);
        if (Objects.equals(role, "role1")){
            throw new RuntimeException("Test should fail");
        }
    }

    @Test(priority = 20, dependsOnGroups = "group1")
    public void dependOnFirst(){
        System.out.println("This is test2. It depends on test1");
    }

    @Test(priority = 30)
    @Parameters({"param"})
    public void getParam(String paramFromConfig){
        System.out.println("Outside Param: " + paramFromConfig);
    }

    @DataProvider(name = "logins")
    public Object[][] createLogins(){
        String[][] users = {
                {"user1", "password1", "role2"}
        };
        return users;
    }
}
