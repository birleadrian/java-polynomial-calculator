import javax.swing.*;
import java.io.IOException;

public class MVC {
    public static void main(String[] args) throws IOException {

        Model 		model 		= new Model();
        View 		view 		= new View(model);
        Controller  controller  = new Controller(model,view);

        view.setVisible(true);
    }
}
