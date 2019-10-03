import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class News  {
   private String title;
   private String content;
   private int id;

    public News(String title, String content) {
        this.title = title;
        this.content = content;

    }



    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getId(int id) {
        return id;
    }


    public void save() {
        String given="INSERT INTO news (title,content)VALUES(:title,:content)";
        try(Connection con= DB.sql2o.open()){
            con.createQuery(given).addParameter("title", title)
                    .addParameter("content", content).executeUpdate();

        }

    }
    public static List<News>all() {
        String given="SELECT *FROM news";
        try(Connection con= DB.sql2o.open()){
            return con.createQuery(given).executeAndFetch(News.class);
        }
    }


    public void delete() {
        String given="DELETE  FROM news WHERE title=:title" ;
        try(Connection con= DB.sql2o.open()){
            con.createQuery(given).addParameter("title",title).executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }

    }
    public static  News findById(int id ) {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM news WHERE  id= :id")
                    .addParameter("id", id) //key/value pair, key must match above
                    .executeAndFetchFirst(News.class); //fetch an individual item
        }
    }


}
