
import java.util.*;

class Item {
    int weight;
    int profit;
    double ratio;

    Item(int weight, int profit) {
        this.weight = weight;
        this.profit = profit;
        this.ratio = (double) profit / weight;
    }
}

public class FractionalKnapsack {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {

            System.out.println("Enter weight and profit of item " + (i + 1));

            int weight = sc.nextInt();
            int profit = sc.nextInt();

            items[i] = new Item(weight, profit);
        }

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        // Sort items by profit/weight ratio
        Arrays.sort(items,
            (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalProfit = 0;

        System.out.println("\nSelected Items:");

        for (int i = 0; i < n; i++) {

            if (capacity == 0) {
                break;
            }

            if (items[i].weight <= capacity) {

                capacity -= items[i].weight;
                totalProfit += items[i].profit;

                System.out.println("Full item selected: Weight = "
                    + items[i].weight);

            } else {

                double fraction =
                    (double) capacity / items[i].weight;

                totalProfit += items[i].profit * fraction;

                System.out.println("Fraction selected: " + fraction);

                capacity = 0;
            }
        }

        System.out.println("\nMaximum Profit: " + totalProfit);

        sc.close();
    }
}
