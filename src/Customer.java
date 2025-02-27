public class Customer
{
    private String name;

    public Customer(String name)
    {
        this.name = name;
    }

    public void order(Menus menus, int menuId, int amount)
    {
        menus.decreaseStock(menuId, amount);
    }
}
