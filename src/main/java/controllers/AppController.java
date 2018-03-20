package controllers;

import db.Seeds;
import models.Student;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.get;

public class AppController {

    public static void main(String[] args) {

        Seeds.seedData();
        StudentController studentController = new StudentController();


    }
}
