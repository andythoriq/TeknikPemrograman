public class Menus
{
    private String[] names;
    private double[] prices;
    private int[] stocks;
    private static byte id = 0;

    public Menus() {
        names = new String[10];
        prices = new double[10];
        stocks = new int[10];
    }

    public void addMenu(String name, double price, int stock) {
        nextId();

        this.names[id] = name;
        this.prices[id] = price;
        this.stocks[id] = stock;
    }

    public void showMenus() {
        for (int i = 0; i <= id; i++) {
            if (isStockAvailable(i)) {
                System.out.println(names[i] + "[" + stocks[i] + "]" + "\tRp. " + prices[i]);
            }
        }
    }

    public void order(int menuId, int amount) {
        if (amount <= stocks[menuId]) {
            stocks[menuId] -= amount;
        }
    }

    protected void decreaseStock(int menuId, int amount){
        if (amount <= stocks[menuId]) {
            stocks[menuId] -= amount;
        }
    }

    public boolean isStockAvailable(int id) {
        return stocks[id] > 0;
    }

    private void nextId() {
        id++;
    }
}
