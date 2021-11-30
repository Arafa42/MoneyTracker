package observers;

import java.util.Observable;
import java.util.Observer;

public class DatabaseObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("DB UPDATED");
    }
}
