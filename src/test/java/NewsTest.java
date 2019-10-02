import News;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public  class NewsTest {
    News news;

    @Before
    public void initial() {
      News news = new News("PM launches 2nd Eisten for Africa summit",  "bfosma bbrfgrtgrg");
    }

    @Test
    public void News_instiateCorrectly() {
        assertEquals(true, news instanceof News);
    }

    @Test
    public void getTitle_theTitleisGivenCorrectly_string() {
        assertEquals("PM launched 2nd Eistern for Africa summit", news.getTitle());
    }



    @Test
    public void contentisFilledCorrectly_string() {
        assertEquals("bfdssd", news.getContent());
    }

    @Test
    public void equals_returnTrueIfPropertiesAreSame_true() {
        News news1 = new News("PM launches 2nd Eisten for Africa summit",  "bfosma bbrfgrtgrg");
        assertEquals(news1, news.equals(news1));

    }

    @Test
    public void saveTheNewsInDatabase() {
        news.save();
        assertEquals(true,News.all().equals(news));
    }


    @Test
    public void deletesNews() {
        news.save();
        news.delete();
        assertEquals(0, news);
    }
}
