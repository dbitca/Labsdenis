import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String ID;
    private String name;
    private Map<String, List<Integer>> marks = new HashMap<String, List<Integer>>();

    private List<Subject> subjects;

    public Student(String ID){
        this.ID = ID;
    }

    public String getID(){
        return ID;
    }

    public void setMarks(String subject, List<Integer> marks) {
        this.marks.put(subject, marks);
    }
    public List<Integer> getMarks(String subject) {
        return marks.get(subject);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}
