package edu.brandeis.cosi103a.samples.lecture10.refactoring.inject.before;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleTest {

    @Test
    public void testPrintTempStatsHot() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Example.printTempStats(100);

        String expectedOutput = "Temperature is: 37.77777777777778C\nIt's really hot!\n";
        assertEquals(expectedOutput, outContent.toString());

        System.setOut(System.out);
    }

    @Test
    public void testPrintTempStatsCold() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Example.printTempStats(30);

        String expectedOutput = "Temperature is: -1.1111111111111112C\nIt's really cold!\n";
        assertEquals(expectedOutput, outContent.toString());

        System.setOut(System.out);
    }

    @Test
    public void testPrintTempStatsModerate() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Example.printTempStats(60);

        String expectedOutput = "Temperature is: 15.555555555555555C\nIt's moderate!\n";
        assertEquals(expectedOutput, outContent.toString());

        System.setOut(System.out);
    }
}
