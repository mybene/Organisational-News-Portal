package models;

//import java.sql.Connection;
import org.sql2o.Connection;

import java.util.Objects;

public class News {
   public String title;
   public String content;
   public int newsId;

    public News(String title, String content, int newsId) {
        this.title = title;
        this.content = content;
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getNewsId() {
        return newsId;
    }


    public Object save() {
        String given="INSERT INTO news (title,content)VALUES(:title,:content)";
        try(Connection con=BD.sql20.open()){
            return con.createQuery(given).addParameter("title",title)
              .addParameter("content",content).executeUpdate()
               .getKey();
        }

    }
    public static News all() {
        String given="SELECT *FROM news";
        try(Connection con=DB.sql20.open()){
            return con.createQuery(given).executeAndFetchFirst(News.class);
        }
    }


    public void delete() {
        String given="DELETE  FROM news WHERE title=:title";
        try(Connection con=DB.sql20.open()){
            con.createQuery(given).addParameter("title",this.title).executeUpdate();
            String joinSql="DELETE FROM news_departments WHERE title=:title";
            con.createQuery(joinSql).addParameter("title",this.title).executeUpdate();
        }
    }


}
