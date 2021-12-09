package observers;

import java.util.Observable;
import java.util.Observer;

public class DatabaseObserver implements Observer {
    // Jens heeft gekeken en vondt het in orde omdit tegebruiken!
    // propertychangelistener
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("DB UPDATED");
    }
}
