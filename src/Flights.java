import java.util.ArrayList;

public class Flights {
    private  String flightId;
    private String origin;
    private String destination;
    private String date;
    private String time;
    private int price;
    private int seats;
    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Flights(String flightId, String origin, String destination, String date, String time, int price, int seats) {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.price = price;
        this.seats = seats;
    }

    public Flights() {

    }
    public void showFlights(ArrayList<Flights> flightData){
        Flights data1 = new Flights("wx-20" ,"Yazd" ,"Shiraz" , "2023-09-25" ,"12:30" ,2500000 , 110 );
        Flights data2 = new Flights("gh-45" ,"Kish" ,"Tehran" , "2023-09-30" ,"8:45" ,2250000 , 105 );
        Flights data3 = new Flights("wx-67" ,"Tehran" ,"Mashhad" , "2023-08-30" ,"4:25" ,1500000 , 102 );
        Flights data4 = new Flights("ab-26" ,"Ahvaz" ,"Mashhad" , "2023-09-16" ,"1:50" ,1250000 , 150 );
        Flights data5 = new Flights("wx-24" ,"Gorgan" ,"Esfahan" , "2023-09-05" ,"18:55" ,700000, 0 );
        Flights data6 = new Flights("gh-97" ,"Kish" ,"Tehran" , "2023-10-08" ,"14:50" ,2250000 , 105 );
        Flights data7 = new Flights("wx-57" ,"Tabriz" ,"Mashhad" , "2023-11-22" ,"16:00" ,2250000 , 51 );
        Flights data8 = new Flights("cd-44" ,"Mashhad" ,"Kish" , "2023-10-18" ,"0:00" ,2150000 , 105 );
        Flights data9 = new Flights("wx-18" ,"Yazd" ,"Mashhad" , "2023-09-15" ,"14:50" ,950000 , 56 );
        Flights data10 = new Flights("gh-22" ,"Yazd" ,"Mashhad" , "2023-09-25" ,"20:20" ,2250000 , 40 );
        Flights data11 = new Flights("wx-45" ,"Yazd" ,"Mashhad" , "2023-09-15" ,"1:50" ,950000 , 56 );
        Flights data12 = new Flights("wx-78" ,"Yazd" ,"Mashhad" , "2023-09-15" ,"14:50" ,3000000 , 56 );
        Flights data13 = new Flights("wx-122" ,"Yazd" ,"Mashhad" , "2023-09-15" ,"14:50" ,3000000 , 0 );

        flightData.add(0,data1);
        flightData.add(1,data2);
        flightData.add(2,data3);
        flightData.add(3,data4);
        flightData.add(4,data5);
        flightData.add(5,data6);
        flightData.add(6,data7);
        flightData.add(7,data8);
        flightData.add(8,data9);
        flightData.add(9,data10);
        flightData.add(10,data11);
        flightData.add(11,data12);
        flightData.add(12,data13);
    }
    public void flightSchedules2(int i ){

        System.out.println( Admin.flightData.get(i).getFlightId() + "\t\t\t" + Admin.flightData.get(i).getOrigin() + "\t\t\t" +
                Admin.flightData.get(i).getDestination() + "\t\t\t" + Admin.flightData.get(i).getDate() + "\t\t\t" +
                Admin. flightData.get(i).getTime() + "\t\t\t" +  Admin.flightData.get(i).getPrice() + "\t\t\t" +
                Admin.flightData.get(i).getSeats());

    }

    public void flightSchedules(ArrayList<Flights> flightData){

        System.out.println("FlightId\t\tOrigin\t\tDestination\t\t\tDate\t\t\t\tTime\t\t\tPrice\t\tSeats" );

        for(int i = 0 ; i < flightData.size() ; i++) {
            System.out.println(flightData.get(i).getFlightId() + "\t\t\t" + flightData.get(i).getOrigin() + "\t\t\t" +
                    flightData.get(i).getDestination() + "\t\t\t" + flightData.get(i).getDate() + "\t\t\t" +
                    flightData.get(i).getTime() + "\t\t\t" + flightData.get(i).getPrice() + "\t\t\t" +
                    flightData.get(i).getSeats());
        }

    }
    }

