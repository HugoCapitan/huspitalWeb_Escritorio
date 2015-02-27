import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javax.swing.JPanel;

 
public class Core extends Application {

    @Override
    public void start(Stage stage) {
        stage.getIcons().add(new Image(Core.class.getResourceAsStream( "assets/icon.png" )) {}); 
        stage.setTitle("Administrador - Mi Doctor");
        stage.setWidth(640);
        stage.setHeight(480);
        stage.setResizable(true);
        Scene scene = new Scene(new Group());
        VBox root = new VBox();    
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        webEngine.load("http://localhost:8000/admin/");                
        
        final Hyperlink hpl = new Hyperlink("http://localhost:8000/admin/");
        Image doc = new Image("assets/home.png");        
        
        hpl.setGraphic(new ImageView (doc));
        final String url = "http://localhost:8000/admin/";
        
        hpl.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    webEngine.load(url);   
                }
            });
        
        hpl.setText("Regresar al Menu Principal");

        
        HBox ToolBar = new HBox();
        ToolBar.getStyleClass().add("browser-toolbar");
        ToolBar.setCursor(Cursor.HAND);                        
        
        scene.getStylesheets().add("assets/BrowserToolbar.css");
        
        Region spacer = new Region();
        spacer.setMaxHeight(64.0);
        
        HBox.setHgrow(spacer, Priority.ALWAYS);
        
        ToolBar.getChildren().addAll(hpl);
        
        root.getChildren().add(ToolBar);
        root.getChildren().add(browser);
        
        scene.setRoot(root);
 
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
