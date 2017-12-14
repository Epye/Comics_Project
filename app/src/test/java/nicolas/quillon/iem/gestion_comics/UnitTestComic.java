package nicolas.quillon.iem.gestion_comics;

import org.junit.Before;
import org.junit.Test;

import nicolas.quillon.iem.gestion_comics.Modele.manager.JSONManager;
import nicolas.quillon.iem.gestion_comics.Modele.pojo.Comic;
import nicolas.quillon.iem.gestion_comics.Modele.pojo.Creator;

import static org.junit.Assert.*;

public class UnitTestComic {
    Comic comic;

    @Before
    public void init(){
        comic = new Comic(64966, "Despicable Deadpool (2017) #288", 288, "DEADPOOL KILLS CABLE Parts 1 and 2. Deadpool’s going back to his vile beginnings as a mercenary and wanted killer. No more being a hero. No more X-Men. No more Avengers. And if he wants to break bad again, what’s more despicable than killing your best friend? Cable better get ready because his old friend Wade has him in the crosshairs. PLUS: Includes 3 bonus MARVEL PRIMER PAGES! Story by Robbie Thompson and a TBA artist!", "AUG170836", "2017-10-25T00:00:00-0400", (float)3.99, 32, "http://i.annihil.us/u/prod/marvel/i/mg/f/03/59e7b08528560.jpg", new Creator[3]);
    }

    @Test
    public void testGetTitle(){
        assertEquals("Despicable Deadpool (2017) #288", comic.getTitle());
    }

    @Test
    public void testGetId(){
        assertEquals(64966, comic.getId());
    }

    @Test
    public void testGetDescription(){
        assertEquals("DEADPOOL KILLS CABLE Parts 1 and 2. Deadpool’s going back to his vile beginnings as a mercenary and wanted killer. No more being a hero. No more X-Men. No more Avengers. And if he wants to break bad again, what’s more despicable than killing your best friend? Cable better get ready because his old friend Wade has him in the crosshairs. PLUS: Includes 3 bonus MARVEL PRIMER PAGES! Story by Robbie Thompson and a TBA artist!", comic.getDescription());
    }

    @Test
    public void testGetDate(){
        assertEquals("mercredi 25/10/2017", comic.getDate());
    }

    @Test
    public void testGetPageCount(){
        assertEquals(32, comic.getPageCount());
    }
}