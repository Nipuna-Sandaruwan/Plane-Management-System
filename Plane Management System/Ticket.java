import java.io.IOException;
import java.io.FileWriter;

public class Ticket {
    String row;
    int seat;
    int price;
    Person person;

    public Ticket(String row, int seat,int price, Person person){
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    public String getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public int getPrice() {
        return price;
    }

    void printTicketsInfo(){
        System.out.println("Row: "+row);

        System.out.println("Seat: "+seat);
        System.out.println("Price: £"+price);
        person.printPersonInfo();
    }

    void save(){
        try {
            FileWriter writer = new FileWriter(row + seat + ".txt");
            writer.append("Row:").append(row).append("\nSeat: ").append(String.valueOf(seat)).append("\nPrice: £").append(String.valueOf(price)).append("\nName: ").append(person.getName()).append("\nSurname: ").append(person.getSurname()).append("\nEmail: ").append(person.getEmail());
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}