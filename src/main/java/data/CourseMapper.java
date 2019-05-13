package data;

import Entities.Category;
import Entities.Course;
import Entities.Subject;
import Entities.Teacher;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseMapper {

    public List<Course> courses = new ArrayList();

    public CourseMapper() {
        courses.add(new Course(1, new Subject("System Integration", new Category("IT", ""), 0), new Teacher("Lars", "none", null)));
        courses.add(new Course(2, new Subject("Test", new Category("IT", ""), 0), new Teacher("Ole", "none", null)));
        courses.add(new Course(3, new Subject("Databases", new Category("IT", ""), 0), new Teacher("Hans", "none", null)));

    }

    public List<Course> getCourses() throws ClassNotFoundException, SQLException {
        List<Course> courses = new ArrayList();

        Connection conn = Conn.getConnection();
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM course";
        ResultSet resultSet = stmt.executeQuery(sql);

        while (resultSet.next()) {
            Course course = new Course();

            int id = resultSet.getInt("id");
            int teacherId = resultSet.getInt("teacherId");
            int semesterId = resultSet.getInt("semesterId");
            int subjectId = resultSet.getInt("subjectId");
            String name = resultSet.getString("name");

            course.setId(id);

            courses.add(course);
        }
        for (Course course : courses) {
            System.out.println(course.getId());
        }
        return courses;
    }

    public void deleteCourse(int id) {
        Course courseToDelete = null;

        for (Course course : courses) {
            if (course.getId() == id) {
                courseToDelete = course;
            }
        }
        courses.remove(courseToDelete);
    }

}
