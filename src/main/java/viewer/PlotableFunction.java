package viewer;

import formula.Formula;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.scene.chart.XYChart;

public class PlotableFunction {
  private Formula formula;
  private String name;
  public static final double PRECISION = 0.01;
  
  public PlotableFunction(Formula formula, String name) {
    this.formula = formula;
    this.name = name;
  }

  @Override
  public String toString() {
    return name + "(x) = " + formula;
  }

  public PlotableFunction derivative(){
    return new PlotableFunction(formula.derivative(), name + "'");
  }

  public XYChart.Series<Double,Double> getData(double range) {
    final XYChart.Series<Double,Double> series = new XYChart.Series<>();
    for (int index = 0; index <= 2 * range / PRECISION; index++) {
      double x = -range + index * PRECISION;
      series.getData().add(new XYChart.Data<>(x, formula.eval(x)));
    }
    return series;
  }

}
