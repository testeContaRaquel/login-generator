package geco;

import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginServiceTest {
    private static final String ANEM = "ANEM";
    private static final String ABIL = "ABIL";
    private LoginService ls;

    @Before
    public void setUp(){
        String[] start = new String[1];
        start[0] = ANEM;
        ls = new LoginService(start);
    }

    @Test
    public void loginExistsTest(){
        assertTrue("Login <ANEM> should exist.", ls.loginExists(ANEM));
        assertFalse("Login <ABIL> should not exist.", ls.loginExists(ABIL));
    }

    @Test
    public void addLoginTest(){
        ls.addLogin("AAAA");
        List<String> allLogins = ls.findAllLogins();
        assertTrue("List should contain 2 logins.", allLogins.size()==2);
    }

    @Test
    public void findAllLoginsStartingWithTest(){
        ls.addLogin("AAAA");
        List<String> allLogins = ls.findAllLoginsStartingWith("A");
        assertTrue("List should contain 2 elements. It contains " + allLogins.size(), allLogins.size()==2);

        allLogins = ls.findAllLoginsStartingWith("AN");
        assertTrue("List should contain 1 element.", allLogins.size()==1);
    }

    @Test
    public void findAllLoginsTest(){
        List<String> allLogins = ls.findAllLogins();
        assertTrue("List should contain 1 element.", allLogins.size()==1);
        ls.addLogin("AAAA");
        allLogins = ls.findAllLogins();
        assertTrue("List should contain 2 elements. It contains " + allLogins.size(), allLogins.size()==2);
    }
}
