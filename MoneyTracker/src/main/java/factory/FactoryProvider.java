package factory;

public class FactoryProvider {
    public static ITicketFactory getCinemaTicketFactory(){return new CinemaTicketFactory();}
    public static ITicketFactory getRestaurantTicketFactory(){return new RestaurantTicketFactory();}
}
