import org.sql2o.Connection;

import java.util.List;

public class User {
   public String name;
   public String position;
   public String dept;
   public int badgeId;

    public User(String name, String position, String dept, int badgeId) {
        this.name = name;
        this.position = position;
        this.dept = dept;
        this.badgeId = badgeId;
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

    public int getBadgeId() {
        return badgeId;
    }


    public Object save() {
        String given="INSERT INTO users( name, position, dept, badgeId)VALUES(:name, :position,: dept, :badgeId)";
        try(org.sql2o.Connection con= DB.sql2o.open()){
            return con.createQuery(given).addParameter("name",name).addParameter("position",position)
                    .addParameter("dept",dept).addParameter("badgeId",badgeId).executeUpdate()
                    .getKey();
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
            con.createQuery(given).addParameter("badgeId",this.badgeId).executeUpdate();
            String joinSql="DELETE FROM news_departments WHERE id=:id";
            con.createQuery(joinSql).addParameter("id",this.getBadgeId()).executeUpdate();
        }
    }

    public void delete() {
        String given="DELETE  FROM news WHERE badgeId=:badgeId";
        try(Connection con= DB.sql2o.open()){
            con.createQuery(given).addParameter("badgeId",this.badgeId).executeUpdate();
            String joinSql="DELETE FROM news_departments WHERE id=:id";
            con.createQuery(joinSql).addParameter("id",this.getBadgeId()).executeUpdate();
        }
    }
}
