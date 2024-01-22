package mycollection.mymap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class CustomHashMapTest {
    CustomHashMap<Integer, String> map = new CustomHashMap<>();

    @Before
    public void setUp() throws Exception {

        for (int i = 0; i < 3000; i++) {
            map.put(i, "i = " + i);
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void size() {
        Assert.assertEquals(map.size(),3000);
    }

    @Test
    public void isEmpty(){
        Assert.assertFalse(map.isEmpty());
    }

    @Test
    public void get(){
        Assert.assertEquals("i = 1000", map.get(1000));
        Assert.assertNull(map.get(4000));
    }

    @Test
    public void remove(){
        map.remove(500);
        Assert.assertNull(map.get(500));

    }

    @Test
    public void containsKey(){
        Assert.assertTrue(map.containsKey(300));
    }

    @Test
    public void containsValue(){
        Assert.assertTrue(map.containsValue("i = 700"));
    }

    @Test
    public void keySet(){
        Set<Integer> mapKeys = map.keySet();
        Assert.assertEquals(3000,mapKeys.size());
    }

    @Test
    public void values(){
        Collection<String> mapValues = map.values();
        Assert.assertEquals(3000, mapValues.size());
    }

    @Test
    public void clear(){
        map.clear();
        Assert.assertTrue(map.isEmpty());
    }
}
