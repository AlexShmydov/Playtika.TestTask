package Objects;

/**
 * Object class Ticket with variables and getter/setter methods
 */

public class Ticket {
    private Integer id;
    private String question;

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }
}
