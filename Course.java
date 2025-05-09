public class Course {

    // Attributes
    private String name;
    private String subjectNumber;
    private String meetingTime; 

    /**
     * Default constructor for Course class
     * @param name name of the course
     * @param subjectNumber number of the course
     * @param meetingTime meeting time for the course
     */
    public Course(String name, String subjectNumber, String meetingTime) {
        this.name = name;
        this.subjectNumber = subjectNumber;
        this.meetingTime = meetingTime; 
    }

    /**
     * Gives name of the course
     * @return name of the course
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gives number of the course
     * @return number of the course
     */
    public String getSubjectNumber() {
        return this.subjectNumber;
    }

    /**
     * Gives meeting time for the course
     * @return meeting time for the course
     */
    public String getMeetingTime() {
        return this.meetingTime;
    }

    /**
     * Gives information about a course
     * @return course information
     */
    public String toString() {
        return this.subjectNumber + ": " + this.name + " " + this.meetingTime; 
    }

    public static void main(String[] args) {
        Course csc120 = new Course("OOP", "CSC120", "TR 10:50");
        System.out.println(csc120);
    }
    
}
