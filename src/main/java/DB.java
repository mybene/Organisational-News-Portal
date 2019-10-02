import org.sql2o.*;

import java.awt.*;


public class DB {
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/media", "wecode", "12307");

}