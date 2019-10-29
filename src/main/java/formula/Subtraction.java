package formula;

public class Subtraction extends BinaryOperation {
  public Subtraction(Formula subtrahend, Formula minuend) {
    super(subtrahend, minuend, "-");
  }

  @Override
  protected double compute(double leftValue, double rightValue) {
    return leftValue - rightValue;
  }

  @Override
  public Formula derivative() {
    return new Subtraction(leftMember.derivative(), rightMember.derivative());
  }
}
