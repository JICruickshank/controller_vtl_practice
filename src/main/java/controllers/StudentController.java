package controllers;

import db.DBStudent;
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
        }


}
