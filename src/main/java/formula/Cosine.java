package formula;

public class Cosine extends UnaryOperation {
  public Cosine(Formula member) {
    super(member, "cos");
  }

  @Override
  protected double compute(double value) {
    return Math.cos(value);
  }

  @Override
  public Formula derivative() {
    return new Opposite(new Multiplication(member.derivative(), new Sine(member)));
  }
}
