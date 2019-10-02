import org.sql2o.Connection;

public class Departments {
    public static int id;
    public static String dname;
    public static String  Slogon;
    public static int members;

    public Departments(int id, String dname, String slogon, int members) {
        this.id = id;
        this.dname = dname;
        Slogon = slogon;
        this.members = members;
    }

    public int getId() {
        return id;
    }

    public String getDname() {
        return dname;
    }

    public String getSlogon() {
        return Slogon;
    }

    public int getMembers() {
        return members;
    }

    public static void save() {
        String given="INSERT INTO departments ( id,slogon,members,dname)VALUES(:id,:slogon,:members,:dname)";
        try(Connection con= DB.sql2o.open()){
            con.createQuery(given).addParameter("id", id)
                    .addParameter("slogon", Slogon).addParameter("members", members)
                    .addParameter("dname", dname).executeUpdate()
                    .getKey();
        }

    }
    public static News all() {
        String given="SELECT *FROM departments";
        try(Connection con= DB.sql2o.open()){
            return con.createQuery(given).executeAndFetchFirst(News.class);
        }
    }

    public Connection addUser(Departments departments){
        String sql="INSERT INTO departments_users (dept_Id int,badgeId int)VALUES(:dept_Id int,:badgeId int)";
        try(Connection con= DB.sql2o.open()){
            return con.createQuery(sql).addParameter("dept_Id",this.getId())
                    .addParameter("badgeId ",this.getId()).executeUpdate();

        }
    }


    public void delete() {
        String given="DELETE  FROM departments WHERE id=:id";
        try(Connection con= DB.sql2o.open()){
            con.createQuery(given).addParameter("id",this.id).executeUpdate();
            String joinSql="DELETE FROM users_departments WHERE dept_Id=:dept_Id";
            con.createQuery(joinSql).addParameter("dept_Id",this.getId()).executeUpdate();
        }
    }
}
