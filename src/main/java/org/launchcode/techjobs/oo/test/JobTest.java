package org.launchcode.techjobs.oo.test;

import org.junit.Before;
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

    Job testJobFull;

    @Before
    public void createTestJobClass() {
        testJobFull = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId() {
        Job jobOne = new Job();
        Job jobTwo = new Job();
        assertNotEquals(jobOne, jobTwo);
    }

    @Test
    public void testJobConstructorSetsAllFields() {

        testJobFull = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertTrue(testJobFull.getName() instanceof String);
        assertEquals("Product tester", testJobFull.getName());

        assertTrue(testJobFull.getEmployer() instanceof Employer);
        assertEquals("ACME", testJobFull.getEmployer().getValue());

        assertTrue(testJobFull.getLocation() instanceof Location);
        assertEquals("Desert", testJobFull.getLocation().getValue());

        assertTrue(testJobFull.getPositionType() instanceof PositionType);
        assertEquals("Quality control", testJobFull.getPositionType().getValue());

        assertTrue(testJobFull.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", testJobFull.getCoreCompetency().getValue());

    }

    @Test
    public void testJobsForEquality() {
        Job equalTestJobOne = new Job();
        Job equalTestJobTwo = new Job();

        assertFalse(equalTestJobOne.equals(equalTestJobTwo));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        testJobFull = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String testString = testJobFull.toString();
        assertEquals('\n', testString.charAt(0));
        assertEquals('\n', testString.charAt(testString.length() - 1));

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {

        testJobFull = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals("\n" +
                "ID: " + testJobFull.getId() + '\n' +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence" +
                "\n", testJobFull.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job emptyJob = new Job();
        emptyJob.setName("Bingo player");
        assertEquals("\n" +
                        "ID: " + emptyJob.getId() + '\n' +
                        "Name: Bingo player\n" +
                        "Employer: Data not available\n" +
                        "Location: Data not available\n" +
                        "Position Type: Data not available\n" +
                        "Core Competency: Data not available" +
                        "\n", emptyJob.toString());
    }

    @Test
    public void testFullyEmptyJob() {
        Job fullyEmptyJob = new Job();
        assertEquals("OOPS! This job does not seem to exist.", fullyEmptyJob.toString());
    }

}
