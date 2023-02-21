import java.time.LocalDate;

public class Json {
    String ID;
    String Name;
    String PhoneNumber;
    String Address;
    String  Description;
    String Coordinates;
    String TravelRoute;

    public Json(String ID, String name, String phoneNumber, String address, String description, String coordinates, String travelRoute) {
        ID = ID;
        Name = name;
        PhoneNumber = phoneNumber;
        Address = address;
        Description = description;
        Coordinates = coordinates;
        TravelRoute = travelRoute;
    }

    @Override
    public String toString() {
        return "Json{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Address='" + Address + '\'' +
                ", Description='" + Description + '\'' +
                ", Coordinates='" + Coordinates + '\'' +
                ", TravelRoute='" + TravelRoute + '\'' +
                '}';
    }


}
