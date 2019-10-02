
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

//import spark.template.handlebars.HandlebarsTemplateEngine;
public class App {
    public static void main(String[] args){
        staticFileLocation("/public");
        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }
        port(port);

        get("/",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            return new ModelAndView(model, "layout.hbs");
        }), new HandlebarsTemplateEngine());

        get("/new/department",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            return new ModelAndView(model, "departmentForm.hbs");
        }), new HandlebarsTemplateEngine());

        get("/login",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            String name=request.queryParams("dname");
//            int employees= Integer.parseInt(request.queryParams("members"));
            model.put("dname",name);
//            model.put("members",employees);
            return new ModelAndView(model, "logged.hbs");
        }), new HandlebarsTemplateEngine());

        post ("/login",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            String dname=request.queryParams("dname");
            Integer members= Integer.parseInt(request.queryParams("members"));
            Integer id= Integer.parseInt(request.queryParams("id"));
            String Slogon=request.queryParams("Slogon");
            request.session().attribute("name",dname);
            request.session().attribute("members",members);
            request.session().attribute("id",id);
            request.session().attribute("Slogon",Slogon);
            model.put("dname",dname);
            model.put("members",members);
            model.put("id",id);
            model.put("Slogon",Slogon);
            Departments department=new Departments(id,dname,Slogon,members);
           Departments.save();
            return new ModelAndView(model, "logged.hbs");
        }), new HandlebarsTemplateEngine());



//        get("/departments",(request, response) -> {
//            Map<String,Object>model=new HashMap<>();
//            List<Departments> departements= Departments.all();
//            model.put("department",departements);
//            return new ModelAndView(model,"AllDepartments.hbs");
//        },new HandlebarsTemplateEngine());

        get("/user-new",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            return new ModelAndView(model, "userForm.hbs");
        }), new HandlebarsTemplateEngine());

        get("/news",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            return new ModelAndView(model, "news.hbs");
        }), new HandlebarsTemplateEngine());

        get("/hr",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            return new ModelAndView(model, "HR.hbs");
        }), new HandlebarsTemplateEngine());

        get("/new/department",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            return new ModelAndView(model, "AllDepartments.hbs");
        }), new HandlebarsTemplateEngine());



//        post("/user-new", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            String person=request.queryParams("name");
//            String department=request.queryParams("team");
//            Integer password= Integer.parseInt(request.queryParams("userId"));
//            request.session().attribute("name", person);
//            request.session().attribute("team", department);
//            request.session().attribute("userId", password);
//            model.put("name",person);
//            model.put("team",department);
//            model.put("userId",password);
//            return new ModelAndView(model, "AllDepartments.hbs");
//        }, new HandlebarsTemplateEngine());
//


    }

//    private static Integer paresInt(String userId) {
//    }
}

