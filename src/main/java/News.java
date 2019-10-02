import org.sql2o.Connection;

public class News {
   private String title;
   private String content;
   private int newsId;

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

    public int getId(int i) {
        return newsId;
    }


    public void save() {
        String given="INSERT INTO news (title,content)VALUES(:title,:content)";
        try(Connection con= DB.sql2o.open()){
            con.createQuery(given).addParameter("title", title)
                    .addParameter("content", content).executeUpdate()
                    .getKey();
        }

    }
    public static News all() {
        String given="SELECT *FROM news";
        try(Connection con= DB.sql2o.open()){
            return con.createQuery(given).executeAndFetchFirst(News.class);
        }
    }


    public void delete() {
        String given="DELETE  FROM news WHERE title=:title";
        try(Connection con= DB.sql2o.open()){
            con.createQuery(given).addParameter("title",this.title).executeUpdate();
            String joinSql="DELETE FROM news_departments WHERE title=:title";
            con.createQuery(joinSql).addParameter("title",this.title).executeUpdate();
        }
    }


}
