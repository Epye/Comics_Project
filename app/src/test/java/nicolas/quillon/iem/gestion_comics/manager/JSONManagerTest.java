package nicolas.quillon.iem.gestion_comics.manager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;


import nicolas.quillon.iem.gestion_comics.Modele.manager.JSONManager;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.when;


/**
 * Created by paulg on 14/12/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class JSONManagerTest {

    @Mock
    JSONManager mockJsonManager;

    @Before
    public void before () {
        mockJsonManager = Mockito.mock(JSONManager.class);

        doCallRealMethod()
                .when(mockJsonManager)
                .getAll();
    }

    @Test
    public void getAllIsCorrect() {
        assertNotNull(mockJsonManager.getAll());
    }

}
