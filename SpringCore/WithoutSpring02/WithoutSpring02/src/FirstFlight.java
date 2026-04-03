public class FirstFlight implements DeliveryService {
    @Override
    public boolean courrierService(double amount) {
        System.out.println( "Courrier delivered safely by FirstFlight and the amount was "+amount);
        return true;
    }
}
