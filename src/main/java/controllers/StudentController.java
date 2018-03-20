package controllers;

import db.DBCourse;
import db.DBStudent;
import models.Course;
import models.Student;
import static spark.Spark.get;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;

public class StudentController {

    public StudentController() {
        this.setupEndPoints();

        }

        private void setupEndPoints() {

            VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
            get("/students", (req, res) -> {
                List<Student> students = DBStudent.getStudents();
                HashMap<String, Object> model = new HashMap<>();
                model.put("students", students);
                model.put("template", "templates/students/index.vtl");
                return new ModelAndView(model, "templates/layout.vtl");
            }, velocityTemplateEngine);

            get("/students/new", (req, res) -> {
                List<Course> courses = DBCourse.getCourses();
                HashMap<String, Object> model = new HashMap<>();
                model.put("template", "templates/students/create.vtl");
                model.put("courses", courses);
                return new ModelAndView(model, "templates/layout.vtl");
            }, velocityTemplateEngine);


            get("/students/:id", (req, res) -> {
                int id = Integer.parseInt(req.params(":id"));
                Student student = DBStudent.findStudentById(id);
                HashMap<String, Object> model = new HashMap<>();
                model.put("student", student);
                model.put("template", "templates/students/read.vtl");
                return new ModelAndView(model, "templates/layout.vtl");
            }, velocityTemplateEngine);

        }




}
