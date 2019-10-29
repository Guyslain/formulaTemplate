package formula;

public class Exponential extends UnaryOperation {
  public Exponential(Formula member) {
    super(member, "e^");
  }

  @Override
  protected double compute(double value) {
    return Math.exp(value);
  }

  @Override
  public Formula derivative() {
    return new Multiplication(member.derivative(), new Exponential(member));
  }
}
