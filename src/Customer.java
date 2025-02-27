import java.util.ArrayList;
import java.util.UUID;

public class Customer
{

    private String customerId;
    private String name;
    private String email;
    private String phone;

    public Customer(String name, String email, String phone)
    {
        this.customerId = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
