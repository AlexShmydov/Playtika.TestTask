package Objects;

import Enums.SimpleTexts;

import java.util.ArrayList;
import java.util.List;

/**
 * Object class Group with variables and getter/setter methods
 */

public class Group {
    private List<Student> group;
    private String groupName;

    public Group() {
        if (this.group == null) {
            group = new ArrayList<>();
        }
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public int getStudentsCount() {
        return this.group.size();
    }

    public List<Student> getGroup() {
        return group;
    }

    public void setGroup(List<Student> group) {
        this.group = group;
    }

    public void addStudentToGroup(Student student) {
        group.add(student);
    }

    public String getAverageMarkOfGroup() {
        double marksSum = 0;
        for (Student student : this.group) {
            marksSum += Double.parseDouble(String.format("%s", student.getMarkValue()));
        }
        double averageMark = marksSum / Double.parseDouble(String.format("%s", getStudentsCount()));
        return String.format("%.2f", averageMark);
    }

    public List<Student> getStudentsByMark(int mark) {
        List<Student> studentsList = new ArrayList<>();
        for (Student student : this.group) {
            if (student.getMarkValue() == mark) {
                studentsList.add(student);
            }
        }
        return studentsList;
    }

    public void printInfoAboutGroup(){
        System.out.print(String.format(SimpleTexts.GROUP_NAME_TEMPLATE.getValue(),getGroupName()));
        for (Student student : this.group) {
           System.out.print(String.format(
                   SimpleTexts.INFO_GROUP_TEMPLATE.getValue(),
                   student.getLastName(),
                   student.getName(),
                   student.getTicketId(),
                   student.getMarkValue()));
        }
    }
}
