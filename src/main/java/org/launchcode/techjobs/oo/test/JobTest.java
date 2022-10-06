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
    public void testSettingJobId() {
        Job firstJob = new Job();
        Job secondJob = new Job();
        assertNotEquals(firstJob.getId(), secondJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob.getName() instanceof String);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", testJob.getName());
        assertEquals("ACME", testJob.getEmployer().getValue());
        assertEquals("Desert", testJob.getLocation().getValue());
        assertEquals("Quality control", testJob.getPositionType().getValue());
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job firstJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job secondJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(firstJob.equals(secondJob));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job firstJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals('\n', firstJob.toString().charAt(0));
        assertEquals('\n', firstJob.toString().charAt(firstJob.toString().length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job firstJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\nID: "+ firstJob.getId() +
                "\nName: "+ firstJob.getName() +
                "\nEmployer: "+ firstJob.getEmployer().toString() +
                "\nLocation: "+ firstJob.getLocation().toString() +
                "\nPosition Type: "+ firstJob.getPositionType().toString() +
                "\nCore Competency: "+ firstJob.getCoreCompetency().toString() + "\n", firstJob.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job firstJob = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType(""), new CoreCompetency(""));
        assertEquals("\nID: " + firstJob.getId() +
                "\nName: Product Tester" +
                "\nEmployer: ACME" +
                "\nLocation: Desert" +
                "\nPosition Type: Data not available" +
                "\nCore Competency: Data not available\n", firstJob.toString());
    }

}
