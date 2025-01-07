package edu.brandeis.cosi103a.samples.lecture5.v3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.mockito.Mockito.*;

class DependencyInjectionAppTest {

    @Test
    void testUserInput() {
        String input = "John\n25\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        UserInput userInput = new UserInput();
        assertEquals("John", userInput.getName());
        assertEquals(25, userInput.getAge());
    }

    @Test
    void testConsoleOutputService() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ConsoleOutputService outputService = new ConsoleOutputService();
        outputService.displayMessage("Test message");

        assertEquals("Test message\n", outContent.toString());
    }

    @Test
    void testAgeToGreetingsProcessor() {
        AgeProcessor processor = new AgeToGreetingsProcessor();
        String messageMinor = processor.generateMessage("Alice", 17);
        String messageAdult = processor.generateMessage("Bob", 18);

        assertEquals("Hello, Alice. You are a minor.", messageMinor);
        assertEquals("Hello, Bob. You are an adult.", messageAdult);
    }

    @Test
    void testDependencyInjectionApp() {
        InputService inputService = mock(InputService.class);
        when(inputService.getName()).thenReturn("John");
        when(inputService.getAge()).thenReturn(25);

        AgeProcessor processor = new AgeToGreetingsProcessor();
        OutputService outputService = mock(OutputService.class);
        doNothing().when(outputService).displayMessage(anyString());

        DependencyInjectionApp app = new DependencyInjectionApp(inputService, processor, outputService);
        app.run();

        verify(outputService, times(1)).displayMessage("Hello, John. You are an adult.");
    }
}
