package viewer;

import formula.Formula;
import javafx.scene.chart.XYChart;

public class PlottableFunction {
  private Formula formula;
  private String name;
  public static final double PRECISION = 0.01;
  private boolean isPlotted = false;
  
  public PlottableFunction(Formula formula, String name) {
    this.formula = formula;
    this.name = name;
  }

  @Override
  public String toString() {
    return name + "(x) = " + formula;
  }

  public PlottableFunction derivative(){
    return new PlottableFunction(formula.derivative(), name + "'");
  }

  public XYChart.Series<Number, Number> getData(double lowerBound, double upperBound) {
    final XYChart.Series<Number, Number> series = new XYChart.Series<>();
    for (int index = 0; index <= 2 * (upperBound-lowerBound) / PRECISION; index++) {
      double x = lowerBound + index * PRECISION;
      series.getData().add(new XYChart.Data<>(x, formula.eval(x)));
    }
    return series;
  }

  public boolean isPlotted() {
    return isPlotted;
  }

  public void setPlotted(boolean plotted) {
    isPlotted = plotted;
  }
}
