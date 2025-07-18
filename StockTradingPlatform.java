import java.util.*;

class Stock {
    String symbol;
    double price;

    Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }
}

class Portfolio {
    Map<String, Integer> holdings = new HashMap<>();

    void buy(String symbol, int qty) {
        holdings.put(symbol, holdings.getOrDefault(symbol, 0) + qty);
    }

    void sell(String symbol, int qty) {
        holdings.put(symbol, holdings.getOrDefault(symbol, 0) - qty);
        if (holdings.get(symbol) <= 0) holdings.remove(symbol);
    }

    void viewPortfolio() {
        System.out.println("--- Portfolio ---");
        if (holdings.isEmpty()) {
            System.out.println("No stocks yet.");
        } else {
            for (Map.Entry<String, Integer> entry : holdings.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " shares");
            }
        }
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Portfolio pf = new Portfolio();
        Map<String, Stock> market = new HashMap<>();

        // Sample stock data
        market.put("AAPL", new Stock("AAPL", 185.0));
        market.put("GOOG", new Stock("GOOG", 2750.0));
        market.put("TSLA", new Stock("TSLA", 750.0));

        while (true) {
            System.out.println("\n1. View Market\n2. Buy Stock\n3. Sell Stock\n4. View Portfolio\n5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    for (Stock s : market.values()) {
                        System.out.println(s.symbol + " - $" + s.price);
                    }
                    break;
                case 2:
                    System.out.print("Enter stock symbol: ");
                    String buySymbol = sc.nextLine().toUpperCase();
                    if (market.containsKey(buySymbol)) {
                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();
                        pf.buy(buySymbol, qty);
                        System.out.println("Bought " + qty + " of " + buySymbol);
                    } else {
                        System.out.println("Stock not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter stock symbol: ");
                    String sellSymbol = sc.nextLine().toUpperCase();
                    if (pf.holdings.containsKey(sellSymbol)) {
                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();
                        pf.sell(sellSymbol, qty);
                        System.out.println("Sold " + qty + " of " + sellSymbol);
                    } else {
                        System.out.println("You don't own that stock.");
                    }
                    break;
                case 4:
                    pf.viewPortfolio();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}