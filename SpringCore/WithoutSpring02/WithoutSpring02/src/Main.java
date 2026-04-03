//Code to Interface
public class Main {
    public static void main(String[] args) {
        Amazon a=new Amazon();
        a.setService(new FedEx());
        boolean status=a.initiateDelivery(123.4);
        if(status) System.out.println("Order delivered successfully");
        else System.out.println("Failed to deliver");
    }
}