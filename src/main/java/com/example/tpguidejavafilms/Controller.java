package com.example.tpguidejavafilms;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDeleteAll;

    @FXML
    private Button btnDeleteOne;

    @FXML
    private Button btnImport;

    @FXML
    private TextField tfRang;

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfAnnee;

    @FXML
    private TextField tfActeurPrincipal;

    @FXML
    private TableView table;

    @FXML
    private TableColumn colRang;

    @FXML
    private TableColumn colId;

    @FXML
    private TableColumn colNom;

    @FXML
    private TableColumn colAnnee;

    @FXML
    private TableColumn colActeurPrincipal;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colRang.setCellValueFactory(new PropertyValueFactory<Film, Integer>("rang"));
        colId.setCellValueFactory(new PropertyValueFactory<Film, String>("Id"));
        colNom.setCellValueFactory(new PropertyValueFactory<Film, String>("nom"));
        colAnnee.setCellValueFactory(new PropertyValueFactory<Film, Integer>("annee"));
        colActeurPrincipal.setCellValueFactory(new PropertyValueFactory<Film, String>("acteurPrincipal"));

//        try {
//            BufferedReader br = new BufferedReader(new FileReader("films.csv")); // je n'arrives pas à utiliser .files().skip(1) parce qu'il faut changer le type de br etc. Faire une boucle for plus tard au lieu d'un conmpteur dans un while!
//            String line = "" ;
//            String[] filmData = null;
//            Integer counter = 0;
//            while((line = br.readLine()) != null) {
//                if (counter == 0){}
//                else {
//                    filmData = line.split(",");
//                    ajouterFilmDansTab(Integer.valueOf(filmData[0]), filmData[1], filmData[2], Integer.valueOf((filmData[3])), filmData[4]);
//                }
//                counter++;
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


    }

    @FXML
    public void ajouterFilmDansTab(Integer rang, String id, String nom, Integer annee, String acteurPrincipal) {

        Film film = new Film();
        film.setRang(rang);
        film.setId(id);
        film.setNom(nom);
        film.setAnnee(annee);
        film.setActeurPrincipal(acteurPrincipal);

        ObservableList<Film> films = table.getItems();
        films.add(film);
        table.setItems(films);
    }

    @FXML
    public void ajouterFilm() {

        int rang = Integer.parseInt(tfRang.getText());
        String id = tfId.getText();
        String nom = tfName.getText();
        int annee = Integer.parseInt(tfAnnee.getText());
        String acteurPrincipal = tfActeurPrincipal.getText();
        tfRang.clear();
        tfId.clear();
        tfName.clear();
        tfAnnee.clear();
        tfActeurPrincipal.clear();

        if(tfRang.getText() != null && tfId.getText() != null && tfName.getText() != null && tfAnnee.getText() != null && tfActeurPrincipal.getText() != null){
            ajouterFilmDansTab(rang, id, nom, annee, acteurPrincipal);
        }
    }

    @FXML
    public void viderTableau(){
        table.getItems().clear();
    }

    @FXML
    public void viderLigneTableau(){
        table.getItems().removeAll(table.getSelectionModel().getSelectedItems());
    }

    @FXML
    public void importerFilms(){
        FileChooser fl = new FileChooser();
        fl.setTitle("Open Resource File");
        fl.showOpenDialog(Stage);
            try {
                BufferedReader br = new BufferedReader(new FileReader(""  + ".csv"));
                String line = "";
                String[] filmData = null;
                Integer counter = 0;
                while((line = br.readLine()) != null) {
                    if (counter == 0){}
                    else {
                        filmData = line.split(",");
                        ajouterFilmDansTab(Integer.valueOf(filmData[0]), filmData[1], filmData[2], Integer.valueOf((filmData[3])), filmData[4]);
                    }
                    counter++;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}