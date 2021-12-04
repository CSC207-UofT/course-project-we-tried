package Entities;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ContainerfacotryTest {

    @Test
    public void get_container_freezer() throws IOException {
        Containerfacotry cf = new Containerfacotry();
        assert(cf.get_container("freezer") instanceof Freezer);
        assert(cf.get_container("FREEZER") instanceof Freezer);
        assert(cf.get_container("freeZer") instanceof Freezer);
    }

    @Test
    public void get_container_refrigerator() throws IOException {
        Containerfacotry cf = new Containerfacotry();
        assert(cf.get_container("refrigerator") instanceof Refrigerator);
        assert(cf.get_container("refriGerAtor") instanceof Refrigerator);
        assert(cf.get_container("REFRIGERATOR") instanceof Refrigerator);
    }

    @Test
    public void get_container_locker() throws IOException {
        Containerfacotry cf = new Containerfacotry();
        assert(cf.get_container("LOCKER") instanceof Locker);
        assert(cf.get_container("locker") instanceof Locker);
        assert(cf.get_container("LocKer") instanceof Locker);
    }

    @Test
    public void get_container_null() throws IOException {
        Containerfacotry cf = new Containerfacotry();
        assertNull(cf.get_container("freezers"));
    }

}