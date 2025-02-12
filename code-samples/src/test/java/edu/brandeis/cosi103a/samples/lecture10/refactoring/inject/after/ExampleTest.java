package edu.brandeis.cosi103a.samples.lecture10.refactoring.inject.after;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

public class ExampleTest {

    @Test
    public void testPrintTempStatsHot() {
        Emitter emitter = mock(Emitter.class);

        Example.printTempStats(100, emitter);

        verify(emitter).emit("It's really hot!");
    }

    @Test
    public void testPrintTempStatsCold() {
        Emitter emitter = mock(Emitter.class);

        Example.printTempStats(30, emitter);

        verify(emitter).emit("It's really cold!");
    }

    @Test
    public void testPrintTempStatsModerate() {
        Emitter emitter = mock(Emitter.class);

        Example.printTempStats(60, emitter);

        verify(emitter).emit("It's moderate!");
    }
}