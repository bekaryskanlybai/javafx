package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private GridPane themap;

    private Bomber bomber = new  Bomber(1, 1, null);

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {

        for (int i = 0; i < 10; ++i){
            for (int j = 0; j < 10; ++j){
                themap.add(new Label(), i, j);
            }
        }

        try {
            draw();
        } catch(Exception e){
            e.printStackTrace();
        }
        placeBomber();
    }

    public void draw() throws FileNotFoundException{

        FileReader reader = new FileReader("/home/blueberryninja/IdeaProjects/bomberguy/src/sample/maps/map.txt");
        char[][] charmap = reader.getMap();

        ObservableList<Node> labels = themap.getChildren();

        for (Node node : labels) {
            int i = themap.getRowIndex(node);
            int j = themap.getColumnIndex(node);
            Label temp = (Label) node;
            if (charmap[i][j] == 'x') {
                Image tempImage = new Image(getClass().
                        getResourceAsStream(
                                "img/wall.jpg"), 50, 50, false, false);
                temp.setGraphic(new ImageView(tempImage));
            } else if (charmap[i][j] == '.') {
                Image tempImage = new Image(getClass().
                        getResourceAsStream(
                                "img/B-50.png"), 50, 50, false, false);
                temp.setGraphic(new ImageView(tempImage));
            }
        }
        bomber.setMap(charmap);
    }

    public void placeBomber(){

        ObservableList<Node> labels = themap.getChildren();

        for (Node node : labels) {
            if (themap.getRowIndex(node) == this.bomber.getPosX() && themap.getColumnIndex(node) == bomber.getPosY()){
                Label lbl = (Label) node;
                Image bomberimg = new Image(getClass().
                        getResourceAsStream(
                                "img/C-50.png"), 50, 50, false, false);
                ((Label) node).setGraphic(new ImageView(bomberimg));
            }
        }
    }

    @FXML
    private void handleKeyPressed(KeyEvent event){
        switch (event.getCode()){
            case UP:
                bomber.moveUp();
                break;
            case DOWN:
                bomber.moveDown();
                break;
            case LEFT:
                bomber.moveLeft();
                break;
            case RIGHT:
                bomber.moveRight();
                break;
        }
        try {
            draw();
        } catch(Exception e){
            e.printStackTrace();
        }
        placeBomber();
    }
}
