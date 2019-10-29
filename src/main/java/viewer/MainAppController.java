package viewer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainAppController implements Initializable {

  @FXML
  private LineChart<Double, Double> lineGraph;

  @FXML
  private VBox vBox;

  private FunctionGraph functionGraph;

  @Override
  public void initialize(final URL url, final ResourceBundle rb) {
    lineGraph.setCreateSymbols(false);
    functionGraph = new FunctionGraph(lineGraph, 10);
    addFunctionButtons();
    addClearButton();
  }

  private void addClearButton() {
    Button clearButton = new Button("Clear");
    clearButton.setOnAction(event -> functionGraph.clear());
    addButton(clearButton);
  }

  private void addFunctionButtons() {
    for(PlotableFunction function : functionGraph.getFunctions()){
      addFunctionButton(function);
    }
  }

  private void addFunctionButton(PlotableFunction function) {
    Button button = new Button(function.toString());
    addButton(button);
    button.setOnAction((event -> functionGraph.plot(function)));
  }

  private void addButton(Button button) {
    vBox.getChildren().add(button);
  }
}
