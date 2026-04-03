public class BlueDart implements DeliveryService {
    @Override
    public boolean courrierService(double amount) {
        System.out.println( "Courrier delivered safely by BlueDart and the amount was "+amount);
        return true;
    }
}
