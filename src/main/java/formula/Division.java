package formula;

public class Division extends BinaryOperation {
  public Division(Formula dividend, Formula divisor) {
    super(dividend, divisor, "/");
  }

  @Override
  protected double compute(double leftValue, double rightValue) {
    return leftValue/rightValue;
  }

  @Override
  public Formula derivative() {
    return new Division(new Subtraction(new Multiplication(leftMember.derivative(), rightMember),
            new Multiplication(leftMember, rightMember.derivative())),
            new Multiplication(rightMember, rightMember));
  }
}
