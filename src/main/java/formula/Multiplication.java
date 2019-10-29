package formula;

public class Multiplication extends BinaryOperation {
  public Multiplication(Formula leftMember, Formula rightMember) {
    super(leftMember, rightMember, "*");
  }

  @Override
  protected double compute(double leftValue, double rightValue) {
    return leftValue * rightValue;
  }

  @Override
  public Formula derivative() {
    return new Addition(new Multiplication(leftMember.derivative(), rightMember),
            new Multiplication(leftMember, rightMember.derivative()));
  }
}
