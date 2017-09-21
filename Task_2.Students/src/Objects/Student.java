package Objects;

/**
 * Object class Student with variables and getter/setter methods
 */

public class Student {
    private String name;
    private String lastName;
    private int ticketId;
    private int markValue;

    public void setName(String name){
        this.name = name;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public int getMarkValue() {
        return markValue;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setMark(int markValue) {
        this.markValue = markValue;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }
}