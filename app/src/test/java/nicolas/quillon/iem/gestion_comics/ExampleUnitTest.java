package nicolas.quillon.iem.gestion_comics;

import org.junit.Before;
import org.junit.Test;

import nicolas.quillon.iem.gestion_comics.Modele.manager.JSONManager;

import static org.junit.Assert.*;

public class ExampleUnitTest {
    JSONManager jsonManager;

    @Before
    public void init(){
        jsonManager = new JSONManager("/data/sample-ok.json");
    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
}