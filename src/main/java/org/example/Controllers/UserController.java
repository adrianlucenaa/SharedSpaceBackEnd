package org.example.Controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import org.example.App;

public class UserController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
