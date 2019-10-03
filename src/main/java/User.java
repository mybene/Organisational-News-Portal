import org.sql2o.Connection;

import java.util.List;

public class User {
   public String name;
   public String position;
   public String dept;
   public String badgeid;
   public int id;

    public User(String name, String position, String dept, String badgeid) {
        this.name = name;
        this.position = position;
        this.dept = dept;
        this.badgeid = badgeid;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getDept() {
        return dept;
    }

    public String getBadgeid() {
        return badgeid;
    }

    public int getId() {
        return id;
    }




    public  void  save() {
        String given="INSERT INTO users(name, position,dept, badgeid) VALUES (:name, :position,:dept,:badgeid)";
        try(Connection con= DB.sql2o.open()) {
            con.createQuery(given)
                    .addParameter("name", name)
                    .addParameter("position", position)
                    .addParameter("dept", dept)
                    .addParameter("badgeid", badgeid)
                    .executeUpdate();
        }


    }

    public static List<User> all() {
        String given="SELECT *FROM users";
        try(Connection con= DB.sql2o.open()){
            return con.createQuery(given).executeAndFetch(User.class);
        }
    }

    public void    deleteById(int badgeId) {
        String given="DELETE  FROM news WHERE badgeId=:badgeId";
        try(Connection con= DB.sql2o.open()){
            con.createQuery(given).addParameter("badgeId",this.badgeid).executeUpdate();
            String joinSql="DELETE FROM news_departments WHERE id=:id";
            con.createQuery(joinSql).addParameter("id",this.badgeid).executeUpdate();
        }
    }

    public void delete() {
        String given="DELETE  FROM news WHERE badgeId=:badgeId";
        try(Connection con= DB.sql2o.open()){
            con.createQuery(given).addParameter("badgeId",this.badgeid).executeUpdate();
            String joinSql="DELETE FROM news_departments WHERE id=:id";
            con.createQuery(joinSql).addParameter("badgeid",this.badgeid).executeUpdate();
        }
    }
}
