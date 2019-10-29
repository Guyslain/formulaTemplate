package formula;

public class Logarithm extends UnaryOperation {
  public Logarithm(Formula member) {
    super(member, "log");
  }

  @Override
  protected double compute(double value) {
    return Math.log(value);
  }

  @Override
  public Formula derivative() {
    return new Division(member.derivative(), member);
  }
}
