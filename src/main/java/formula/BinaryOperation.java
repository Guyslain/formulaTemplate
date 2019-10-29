package formula;

public abstract class BinaryOperation implements Formula {
  final Formula leftMember;
  final Formula rightMember;
  final String operatorSymbol;

  public BinaryOperation(Formula leftMember, Formula rightMember, String operatorSymbol) {
    this.leftMember = leftMember;
    this.rightMember = rightMember;
    this.operatorSymbol = operatorSymbol;
  }

  @Override
  public String toString() {
    return "(" + leftMember + " " + operatorSymbol + " " + rightMember + ")";
  }

  @Override
  public double eval(double xValue) {
    return compute(leftMember.eval(xValue), rightMember.eval(xValue));
  }

  protected abstract double compute(double leftValue, double rightValue);
}
