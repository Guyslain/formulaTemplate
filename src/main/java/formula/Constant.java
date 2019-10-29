package formula;

public class Constant implements Formula {
  final double value;

  public Constant(double value) {
    this.value = value;
  }

  @Override
  public double eval(double xValue) {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @Override
  public Formula derivative() {
    return new Constant(0);
  }
}
