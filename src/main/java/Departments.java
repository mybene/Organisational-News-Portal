import org.sql2o.Connection;

import java.util.List;

public class Departments {
    public  String deptid;
    public  String dname;
    public  String  slogon;
    public  String members;
    private  int id;

    public Departments( String deptid,String dname, String slogon, String members) {
        this.deptid = deptid;
        this.dname = dname;
        this.slogon = slogon;
        this.members = members;
    }

    public int getId() {
        return id;
    }

    public String getDeptid() {
        return deptid;
    }


    public String getDname() {
        return dname;
    }

    public String getSlogon() {
        return slogon;
    }

    public String getMembers() {
        return members;
    }

    public  void save() {
        String given="INSERT INTO departments (dname, slogon,members, deptid) VALUES (:dname, :slogon, :members, :deptid)";
        try(Connection con= DB.sql2o.open()){
            con.createQuery(given)
                     .addParameter("dname", dname)
                    .addParameter("slogon", slogon)
                    .addParameter("members", members)
                    .addParameter("deptid", deptid)
                    .executeUpdate();
        }

    }

    public  static List<Departments> all() {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM departments") //raw sql
                    .executeAndFetch(Departments.class); //fetch a list
        }
    }

    public Connection addUser(Departments departments){
        String sql="INSERT INTO departments_users (deptid ,badgeid )VALUES(:deptid,:badgeid )";
        try(Connection con= DB.sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("deptid", deptid)
                    .addParameter("badgeid ",this.getId()).executeUpdate();

        }
    }


    public void delete() {
        String given="DELETE  FROM departments WHERE id=:id";
        try(Connection con= DB.sql2o.open()){
            con.createQuery(given).addParameter("deptid",this.deptid).executeUpdate();
            String joinSql="DELETE FROM users_departments WHERE deptid=:deptid";
            con.createQuery(joinSql).addParameter("dept_Id",this.getId()).executeUpdate();
        }
    }
}
