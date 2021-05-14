import injectable.Injector;
import somepackage.SomeBean;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Injector injector = new Injector(new File(Main.class.getResource("first.properties").getFile()));
        SomeBean sb = injector.inject(new SomeBean());
        sb.foo();

    }

}
