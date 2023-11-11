package sweet;

import java.util.ArrayList;
import java.util.List;

public class Present {

  private List<Sweet> sweets;

  public Present() {
    sweets = new ArrayList<>();
  }

  public List<Sweet> filterSweetsBySugarRange(
    double minSugarWeight,
    double maxSugarWeight
  ) {
    List<Sweet> list = new ArrayList<>();
    for (Sweet sweet : sweets) {
      if (
        sweet.getSugarWeight() > minSugarWeight &&
        sweet.getSugarWeight() < maxSugarWeight
      ) {
        list.add(sweet);
      }
    }
    return list;
  }

  public double calculateTotalWeight() {
    double totalWeight = 0.0;
    for (Sweet sweet : sweets) {
      totalWeight += sweet.getWeight();
    }
    return totalWeight;
  }

  public void addSweet(Sweet sweet) {
    sweets.add(sweet);
  }

  public List<Sweet> getSweets() {
    return new ArrayList<>(sweets);
  }
}
