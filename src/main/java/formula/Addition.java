package formula;

public class Addition extends BinaryOperation {
  public Addition(Formula leftMember, Formula rightMember) {
    super(leftMember, rightMember, "+");
  }

  @Override
  protected double compute(double leftValue, double rightValue) {
    return leftValue + rightValue;
  }

  @Override
  public Formula derivative() {
    return new Addition(leftMember.derivative(), rightMember.derivative());
  }
}
