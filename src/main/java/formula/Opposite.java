package formula;

public class Opposite extends UnaryOperation{
  public Opposite(Formula member) {
    super(member, "-");
  }

  @Override
  public Formula derivative() {
    return new Opposite(member.derivative());
  }

  @Override
  protected double compute(double value) {
    return -value;
  }
}
