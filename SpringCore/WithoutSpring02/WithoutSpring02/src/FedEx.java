public class FedEx implements DeliveryService {
    @Override
    public boolean courrierService(double amount) {
        System.out.println( "Courrier delivered safely by FedEx and the amount was "+amount);
        return true;
    }
}
