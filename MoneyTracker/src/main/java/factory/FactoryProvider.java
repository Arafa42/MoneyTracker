package factory;

public class FactoryProvider {
    public static ITicketFactory getCinemaTicketFactory(){return new CinemaTicketFactory();}
    public static ITicketFactory getRestaurantTicketFactory(){return new RestaurantTicketFactory();}
    public static ITicketFactory getConcertTicketFactory(){return new ConcertTicketFactory();}
    public static ITicketFactory getFlightTicketFactory(){return new FlightTicketFactory();}
    public static ITicketFactory getOtherTicketFactory(){return new OtherTicketFactory();}
}
