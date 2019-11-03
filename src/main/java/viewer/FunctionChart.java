package viewer;

import com.sun.javafx.charts.Legend;
import javafx.geometry.Side;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.input.MouseButton;

public class FunctionChart extends LineChart<Number, Number> {

  private static final int TICK_UNIT = 1;
  private static final int LOWER_BOUND = -10;
  private static final int UPPER_BOUND = 10;

  int getLowerBound() {
    return LOWER_BOUND;
  }

  int getUpperBound() {
    return UPPER_BOUND;
  }

  public FunctionChart(){
    super(new NumberAxis(LOWER_BOUND, UPPER_BOUND, TICK_UNIT), new NumberAxis(LOWER_BOUND, UPPER_BOUND, TICK_UNIT));
    getXAxis().setSide(Side.BOTTOM);
    getYAxis().setSide(Side.LEFT);
    setPrefWidth(900);
    setPrefHeight(900);
    setCreateSymbols(false);
  }

  public Series<Number, Number> getSeries(String name){
    for (Series<Number, Number> series : getData())
      if(series.getName().equals(name)){
        return series;
      }
    return null;
  }

  public void removeSeries(String name){
    Series<Number, Number> series = getSeries(name);
    if(series != null){
      getData().remove(series);
    }
  }
}
