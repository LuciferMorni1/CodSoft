package StudentCourseRegistrationSystem;
//--STUDENT COURSE REGISTRATION SYSTEM--//
import java.util.ArrayList;
import java.util.List;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private int availableSlots;
    private String schedule;
    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.availableSlots = capacity;
        this.schedule = schedule;
    }

    public String getCourseCode() {
        return courseCode;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public int getAvailableSlots() {
        return availableSlots;
    }
    public String getSchedule() {
        return schedule;
    }
    public void decrementAvailableSlots() {
        if (availableSlots > 0) {
            availableSlots--;
        }
    }

    public void incrementAvailableSlots() {
        if (availableSlots < capacity) {
            availableSlots++;
        }
    }
}

class CourseDatabase {
    private List<Course> courses;
    public CourseDatabase() {
        this.courses = new ArrayList<>();
    }
    public void addCourse(Course course) {
        courses.add(course);
    }
    public void removeCourse(Course course) {
        courses.remove(course);
    }
    public List<Course> getAllCourses() {
        return courses;
    }
}

class Student {
    private String studentID;
    private String studentName;
    private List<Course> registeredCourses;
    public Student(String studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.registeredCourses = new ArrayList<>();
    }
    public String getStudentID() {
        return studentID;
    }
    public String getStudentName() {
        return studentName;
    }
    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }
    public void registerCourse(Course course) {
        if (course.getAvailableSlots() > 0) {
            registeredCourses.add(course);
            course.decrementAvailableSlots();
        } else {
            System.out.println("Course " + course.getCourseCode() + " is full. Registration failed.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.incrementAvailableSlots();
            System.out.println("Course " + course.getCourseCode() + " dropped successfully.");
        } else {
            System.out.println("Course " + course.getCourseCode() + " not found in registered courses.");
        }
    }
}

public class Project3 {
    public static void main(String[] args) {
        CourseDatabase courseDatabase = new CourseDatabase();

        // Adding courses
        courseDatabase.addCourse(new Course("C01", "Java Programming", "Introduction to Java programming", 30, "Mon, Wed 10:00 AM"));
        courseDatabase.addCourse(new Course("C02", "Data Structures", "Advanced data structure concepts", 25, "Tue, Thu 2:00 PM"));

        // Displaying available courses
        System.out.println("Available Courses:");
        List<Course> allCourses = courseDatabase.getAllCourses();
        for (Course course : allCourses) {
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Title: " + course.getTitle());
            System.out.println("Description: " + course.getDescription());
            System.out.println("Available Slots: " + course.getAvailableSlots());
            System.out.println("Schedule: " + course.getSchedule());
            System.out.println("------------------------------");
        }

        // Student registration and course removal (sample operations)
        Student student1 = new Student("01", "Ayan Mishra");
        Student student2 = new Student("02", "Om Babu");

        student1.registerCourse(allCourses.get(0));  // Register for course C01
        student1.registerCourse(allCourses.get(1));  // Register for course C02

        student2.registerCourse(allCourses.get(0));  // Register for course C01

        System.out.println("\nRegistered Courses for Ayan Mishra:");
        for (Course course : student1.getRegisteredCourses()) {
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Title: " + course.getTitle());
            System.out.println("------------------------------");
        }

        student1.dropCourse(allCourses.get(0));  // Drop course C01 for Ayan Mishra

        System.out.println("\nRegistered Courses for Ayan Mishra after dropping a course:");
        for (Course course : student1.getRegisteredCourses()) {
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Title: " + course.getTitle());
            System.out.println("------------------------------");
        }
    }
}