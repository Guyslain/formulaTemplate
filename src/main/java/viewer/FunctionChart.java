package viewer;

import javafx.collections.ObservableList;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;

public abstract class FunctionChart extends LineChart<Double, Double> {
  public FunctionChart(Axis<Double> doubleAxis, Axis<Double> doubleAxis2) {
    super(doubleAxis, doubleAxis2);
  }

  public FunctionChart(Axis<Double> doubleAxis, Axis<Double> doubleAxis2, ObservableList<Series<Double, Double>> data) {
    super(doubleAxis, doubleAxis2, data);
  }
}
