package formula;

public abstract class UnaryOperation implements Formula {
  protected final Formula member;
  private final String symbol;

  public UnaryOperation(Formula member, String symbol) {
    this.member = member;
    this.symbol = symbol;
  }

  @Override
  public double eval(double xValue) {
    return compute(member.eval(xValue));
  }

  protected abstract double compute(double value);

  @Override
  public String toString() {
    return  symbol + "(" + member + ")";
  }
}
