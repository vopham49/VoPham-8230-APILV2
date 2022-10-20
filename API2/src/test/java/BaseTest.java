import authen.Oauth2;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;


public class BaseTest {

    protected String access_Token = Oauth2.getTokenKey();
    protected String couldID = Oauth2.getCouldID();

    public org.apache.log4j.Logger log = LogManager.getLogger(BaseTest.class);
    static {
        BasicConfigurator.configure();
    }

}
