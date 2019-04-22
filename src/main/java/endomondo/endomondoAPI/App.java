package endomondo.endomondoAPI;

import org.wso2.msf4j.MicroservicesRunner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	new MicroservicesRunner().deploy(new EndomondoService()).start();
    }
}
