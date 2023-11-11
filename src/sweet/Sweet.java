package sweet;

public abstract class Sweet {

  private String name;
  private double weight;
  private double sugarWeight;

  public Sweet(String name, double weight, double sugarWeight) {
    this.name = name;
    this.weight = weight;
    this.sugarWeight = sugarWeight;
  }

  public double getWeight() {
    return weight;
  }

  public String getName() {
    return name;
  }

  public double getSugarWeight() {
    return sugarWeight;
  }

  @Override
  public String toString() {
    return (
      "name = " +
      name +
      ", weight = " +
      weight +
      ", sugarWeigt = " +
      sugarWeight
    );
  }
}
