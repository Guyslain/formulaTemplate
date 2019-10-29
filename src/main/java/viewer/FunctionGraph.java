package viewer;

import formula.*;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.List;

public class FunctionGraph {
  private final List<PlotableFunction> functions = new ArrayList<>();

  private LineChart<Double, Double> graph;
  private double range;

  public FunctionGraph(LineChart<Double, Double> graph, double range) {
    this.graph = graph;
    this.range = range;
    PlotableFunction function1 = new PlotableFunction(new Logarithm(new VariableX()),"f");
    PlotableFunction function2 = new PlotableFunction(new Multiplication(new VariableX(), new Constant(3)), "g");
    PlotableFunction function3 = new PlotableFunction(new Division(new Constant(1), new VariableX()), "h");
    PlotableFunction function4 = new PlotableFunction(new Cosine(new Multiplication(new Constant(2), new VariableX())), "a");
    PlotableFunction function5 = new PlotableFunction(new Exponential(new Multiplication(new Constant(2), new VariableX())), "a");
    functions.add(function1);
    functions.add(function2);
    functions.add(function3);
    functions.add(function4);
    functions.add(function5);
    functions.add(function1.derivative());
    functions.add(function2.derivative());
    functions.add(function3.derivative());
    functions.add(function4.derivative());
    functions.add(function5.derivative());
  }

  public List<PlotableFunction> getFunctions(){
    return functions;
  }

  public void plot(PlotableFunction function){
    XYChart.Series<Double, Double> series = function.getData(range);
    series.setName(function.toString());
    graph.getData().add(series);
  }

  public void clear() {
    graph.getData().clear();
  }
}
