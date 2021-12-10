package blueOrigin;

import org.junit.Assert;
import org.junit.Test;

public class SpaceshipTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Spaceship

    @Test
    public void countProperly() {
        Spaceship spaceship = new Spaceship("Moon", 2);
        spaceship.add(new Astronaut("Ben", 50));
        int expected = 1;

        Assert.assertEquals(expected, spaceship.getCount());
    }

    @Test
    public void removeAstronautByName() {
        Spaceship spaceship = new Spaceship("Moon", 2);
        spaceship.add(new Astronaut("Ben", 50));
        spaceship.add(new Astronaut("Dan", 70));
        Assert.assertEquals(2, spaceship.getCount());
        Assert.assertTrue(spaceship.remove("Dan"));
        Assert.assertEquals(1, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenCapacityIsFull() {
        Spaceship spaceship = new Spaceship("Moon", 1);
        spaceship.add(new Astronaut("Ben", 50));
        spaceship.add(new Astronaut("Dan", 70));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenAstronautExist() {
        Spaceship spaceship = new Spaceship("Moon", 2);
        spaceship.add(new Astronaut("Ben", 50));
        spaceship.add(new Astronaut("Ben", 70));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenCapacityIsLessThanZero() {
        new Spaceship("Moon", -1);
    }

    @Test(expected = NullPointerException.class)
    public void throwExceptionWhenSetNameIsEmpty() {
        Spaceship spaceship = new Spaceship("    ", 1);
    }

    @Test
    public void getNameProperly() {
        Spaceship spaceship = new Spaceship("Moon", 1);
        String name = spaceship.getName();

        Assert.assertEquals("Moon", name);
    }

}
