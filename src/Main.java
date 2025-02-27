public class Main
{
    public static void main(String[] args)
    {
        Menus menus = new Menus();
        Customer customer = new Customer("Customer 1");

        menus.addMenu("Bala-bala", 1_000, 20); // id: 1

        menus.addMenu("Gehu", 1_000, 20); // id: 2

        menus.addMenu("Tahu", 1_000, 0); // id: 3

        menus.addMenu("Molen", 1_000, 20); // id: 4

        menus.addMenu("Makanan Test", 6_969, 3); // id: 5

//        menus.order(5, 2);

        customer.order(menus, 5, 2);

        menus.showMenus();
    }
}