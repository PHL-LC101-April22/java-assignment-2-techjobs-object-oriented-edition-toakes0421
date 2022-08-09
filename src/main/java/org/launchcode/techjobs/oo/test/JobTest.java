package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobID() {
        Job jobOne = new Job();
        Job jobTwo = new Job();
        assertNotEquals(jobOne, jobTwo);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJobFull = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertTrue(testJobFull.getName() instanceof String);
        assertEquals(testJobFull.getName(), "Product tester");

        assertTrue(testJobFull.getEmployer() instanceof Employer);
        assertEquals(testJobFull.getEmployer().getValue(), "ACME");

        assertTrue(testJobFull.getLocation() instanceof Location);
        assertEquals(testJobFull.getLocation().getValue(), "Desert");

        assertTrue(testJobFull.getPositionType() instanceof PositionType);
        assertEquals(testJobFull.getPositionType().getValue(), "Quality control");

        assertTrue(testJobFull.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(testJobFull.getCoreCompetency().getValue(), "Persistence");

    }

    @Test
    public void testJobsForEquality() {
        Job equalTestJobOne = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job equalTestJobTwo = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertFalse(equalTestJobOne.equals(equalTestJobTwo));
    }

}
