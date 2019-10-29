package formula;

public class Sine extends UnaryOperation {
  public Sine(Formula member) {
    super(member, "sin");
  }

  @Override
  protected double compute(double value) {
    return Math.sin(value);
  }

  @Override
  public Formula derivative() {
    return new Multiplication(member.derivative(), new Cosine(member));
  }
}
