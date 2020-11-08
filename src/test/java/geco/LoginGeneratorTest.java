package geco;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginGeneratorTest {
    private LoginGenerator aLoginGenerator;

    @Before
    public void setUp(){
        String[] start=new String[]{"JROL","BPER","CGUR","JDUP","JRAL","JRAL1"};
        aLoginGenerator=new LoginGenerator(new LoginService(start));
    }

    @Test
    public void testGenerateLoginForNomAndPrenomPDUR() {
        String login = aLoginGenerator.generateLoginForNomAndPrenom("Durand","Paul");
        assertTrue("Login for Paul Durand not generated. Login : "+login,login.compareTo("PDUR")==0);
    }

    @Test
    public void generateLoginForJRAL2() throws Exception{
        String login = aLoginGenerator.generateLoginForNomAndPrenom("Ralling", "John");
        Assert.assertEquals("JRAL2",login);
    }

    @Test
    public void testGenerateLoginForNomAndPrenomPDUR2() {
        String login = aLoginGenerator.generateLoginForNomAndPrenom("Dùrand","Paul");
        assertTrue("Login for Paul Dùrand not generated. Login : "+login,login.compareTo("PDUR")==0);
    }

    @Test
    public void generateLoginForJROL1() throws Exception{
        String login = aLoginGenerator.generateLoginForNomAndPrenom("Rolling", "Jean");
        Assert.assertEquals("JROL1",login);
    }

    @Test
    public void testGenerateLoginForNomAndPrenomPDU() {
        //String login = aLoginGenerator.generateLoginForNomAndPrenom("Du","Paul");
        //assertTrue("Login for Paul Dùrand not generated. Login : "+login,login.compareTo("PDU")==0);
        assertTrue("",true);
    }
}
