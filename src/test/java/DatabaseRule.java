import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DatabaseRule extends ExternalResource {
    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/news", "wecode", "12307");  //Those with linux or windows use  astring for username and an intenger for id
    }

//    @Override
//    protected void after() {
//        try(Connection con = DB.sql2o.open()) {
//            String deleteAnimalsQuery = "DELETE FROM animals *;";
//            String deleteSightingsQuery="DELETE FROM sightings *;";
//            con.createQuery(deleteSightingsQuery).executeUpdate();
//            con.createQuery(deleteAnimalsQuery).executeUpdate();
//        }
//}
}