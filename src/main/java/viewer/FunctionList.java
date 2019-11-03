package viewer;

import formula.*;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FunctionList {
  private final List<PlottableFunction> functions = new ArrayList<>();

  private FunctionChart functionChart;
  private double lowerBound;
  private double upperBound;

  public FunctionList(FunctionChart functionChart) {
    this.functionChart = functionChart;
    this.lowerBound = functionChart.getLowerBound();
    this.upperBound = functionChart.getUpperBound();
    List<PlottableFunction> functions = List.of(new PlottableFunction(new Logarithm(new VariableX()),"f"),
            new PlottableFunction(new Multiplication(new VariableX(), new Constant(3)), "g"),
            new PlottableFunction(new Division(new Constant(1), new VariableX()), "h"),
            new PlottableFunction(new Cosine(new Multiplication(new Constant(2), new VariableX())), "a"),
            new PlottableFunction(new Exponential(new Multiplication(new Constant(2), new VariableX())), "a"));

    addFunctionsAndTheirDerivative(functions);

  }

  public void toggleFunction(PlottableFunction function) {
    if (function.isPlotted()){
      unplot(function);
    }
    else{
      plot(function);
    }
  }

  private void unplot(PlottableFunction function) {
    functionChart.removeSeries(function.toString());
    function.setPlotted(false);
  }

  public List<PlottableFunction> getFunctions(){
    return functions;
  }

  public void plot(PlottableFunction function){
    XYChart.Series<Number, Number> series = function.getData(lowerBound, upperBound);
    series.setName(function.toString());
    functionChart.getData().add(series);
    function.setPlotted(true);
  }

  public void addFunctionsAndTheirDerivative(Collection<PlottableFunction> functions){
    for(PlottableFunction function: functions){
      addFunctionAndItsDerivative(function);
    }
  }

  public void addFunctionAndItsDerivative(PlottableFunction function){
    add(function);
    add(function.derivative());
  }

  public void add(PlottableFunction function) {
    functions.add(function);
  }

  public void clear() {
    functionChart.getData().clear();
  }
}
