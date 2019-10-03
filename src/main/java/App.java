
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
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

        get("/new/department",(request, response) -> {
            Map<String,Object> model=new HashMap<>();
            return new ModelAndView(model, "departmentForm.hbs");
        }, new HandlebarsTemplateEngine());


        post ("/all/dept",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            String dname=request.queryParams("dname");
            String deptid=request.queryParams("deptid");
            String members= request.queryParams("members");
            String slogon=request.queryParams("slogon");
            model.put("dname",dname);
            model.put("members",members);
            model.put("slogon",slogon);
            Departments department=new Departments(deptid,dname,slogon,members);
            department.save();
            model.put("departmnet",department);
            return new ModelAndView(model, "logged.hbs");
        }), new HandlebarsTemplateEngine());
//to view all list of the depts saved
        get("/depts",(request, response) -> {
            Map<String,Object>model=new HashMap<>();
            model.put("departments", Departments.all());
            return new ModelAndView(model,"AllDepartments.hbs");
        },new HandlebarsTemplateEngine());


//to call the employee form input
        get("/user-new",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            return new ModelAndView(model, "userForm.hbs");
        }), new HandlebarsTemplateEngine());
//notification of being saved as employee
        post("/users",(request, response) -> {
            Map<String,Object> model=new HashMap<>();
            String name=request.queryParams("name");
            String  position= request.queryParams("position");
            String dept= request.queryParams("dept");
            String  badgeid=request.queryParams("badgeid");
            User employee=new User( name, position, dept, badgeid);
            employee.save();
            model.put("name",name);
            model.put("position",position);
            model.put("dept)",badgeid);
            model.put(" badgeid" ,dept);
            model.put("employee",employee);
            return new ModelAndView(model, "usersaved.hbs");
        },new HandlebarsTemplateEngine());

//get list of all saved employees
        get("/all/users",(request, response) -> {
            Map<String,Object> model=new HashMap<>();
            model.put("users",User.all());
            return new ModelAndView(model, "users.hbs");
        },new HandlebarsTemplateEngine());


//call news form
        get("/news",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            return new ModelAndView(model, "newsForm.hbs");
        }), new HandlebarsTemplateEngine());

//get the written articles
        post("/article/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String title=request.queryParams("title");
            String content=request.queryParams("content");
            request.session().attribute("content", content);
            request.session().attribute("title", title);
            model.put("title",title);
            model.put("content",content);
            return new ModelAndView(model, "article.hbs");
        }, new HandlebarsTemplateEngine());
// to see all saved article;
        get("/aricle/all",((request, response) -> {
            Map<String,Object> model=new HashMap<>();
            List<News>article=new ArrayList<>();
            model.put("article",article);
            News.all();
            return new ModelAndView(model, "AllArticles.hbs");
        }), new HandlebarsTemplateEngine());



    }

}

