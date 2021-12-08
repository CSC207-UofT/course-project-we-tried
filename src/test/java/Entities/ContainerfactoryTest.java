package Entities;

import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.*;
public class ContainerfactoryTest {

    @Test
    public void get_container_freezer() throws IOException {
        ContainerFactory cf = new ContainerFactory();
        assert(cf.getContainer("freezer") instanceof Freezer);
        assert(cf.getContainer("FREEZER") instanceof Freezer);
        assert(cf.getContainer("freeZer") instanceof Freezer);
    }

    @Test
    public void get_container_refrigerator() throws IOException {
        ContainerFactory cf = new ContainerFactory();
        assert(cf.getContainer("refrigerator") instanceof Refrigerator);
        assert(cf.getContainer("refriGerAtor") instanceof Refrigerator);
        assert(cf.getContainer("REFRIGERATOR") instanceof Refrigerator);
    }

    @Test
    public void get_container_locker() throws IOException {
        ContainerFactory cf = new ContainerFactory();
        assert(cf.getContainer("LOCKER") instanceof Locker);
        assert(cf.getContainer("locker") instanceof Locker);
        assert(cf.getContainer("LocKer") instanceof Locker);
    }

    @Test
    public void get_container_null() throws IOException {
        ContainerFactory cf = new ContainerFactory();
        assertNull(cf.getContainer("freezers"));
    }

}