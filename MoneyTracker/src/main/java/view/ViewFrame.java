package view;
import com.sun.tools.javac.Main;
import view.frames.*;

public class ViewFrame {

    private UserRegistrationFrame userRegistrationFrame;
    private MainAppFrame mainAppFrame;

    public void initialize()
    {
        userRegistrationFrame = new UserRegistrationFrame();
        mainAppFrame = new MainAppFrame();
    }

}