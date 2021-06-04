package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class SampleController {
    @FXML
    private Button teachBtn;
    @FXML
    private Button speechBtn;
    @FXML
    private Label welcomeLabel;
    @FXML
    private Button backBtn;

    static private boolean teach = false;
    static private boolean transcript = false;
    static private boolean summary = false;

    @FXML
    public void startOnClick(ActionEvent ex) throws IOException {
        if (ex.getSource() == teachBtn) {
            if (teachBtn.getText().equals("Teaching")) {
                teach = true;
            } else {
                summary = true;
            }

            welcomeLabel.setText("Welcome to Big Note 6");
            backBtn.setVisible(false);
            speechBtn.setText("Speech");
            teachBtn.setText("Teaching");

            Stage appStage;
            Parent root;
            appStage = (Stage) ((Node)ex.getSource()).getScene().getWindow();

            root = FXMLLoader.load(getClass().getResource("write.fxml"));
            appStage.getScene().setRoot(root);
            appStage.show();


        } else {
            if (speechBtn.getText().equals("Speech")) {
                welcomeLabel.setText("");
                backBtn.setVisible(true);
                speechBtn.setText("Transcript");
                teachBtn.setText("Summary");
            } else {
                transcript = true;

                welcomeLabel.setText("Welcome to Big Note 6");
                backBtn.setVisible(false);
                speechBtn.setText("Speech");
                teachBtn.setText("Teaching");

                Stage appStage;
                Parent root;
                appStage = (Stage) ((Node)ex.getSource()).getScene().getWindow();

                root = FXMLLoader.load(getClass().getResource("write.fxml"));
                appStage.getScene().setRoot(root);
                appStage.show();


            }
        }
    }

    @FXML
    public void backOnClick(ActionEvent ex) {
        welcomeLabel.setText("Welcome to Big Note 6");
        backBtn.setVisible(false);
        speechBtn.setText("Speech");
        teachBtn.setText("Teaching");
    }

    public static boolean isTeach() {
        return teach;
    }

    public static boolean isTranscript() {
        return transcript;
    }

    public static boolean isSummary() {
        return summary;
    }

    public static void setTeach(boolean teach) {
        SampleController.teach = teach;
    }

    public static void setTranscript(boolean transcript) {
        SampleController.transcript = transcript;
    }

    public static void setSummary(boolean summary) {
        SampleController.summary = summary;
    }
}
