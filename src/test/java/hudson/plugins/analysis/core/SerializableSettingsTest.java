package hudson.plugins.analysis.core;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

/**
 * Tests the class {@link SerializableSettings}.
 *
 * @author Ulli Hafner
 */
public class SerializableSettingsTest {
    /**
     * Simple test to see that all values are stored.
     */
    @Test
    public void testValues() {
        Settings original = mock(Settings.class);
        when(original.getConfigurations()).thenReturn(new AnalysisConfiguration[1]);
        SerializableSettings copy;

        copy = new SerializableSettings(original);
        assertFalse("Wrong value for quiet: ", copy.getQuietMode());
        assertFalse("Wrong value for fail: ", copy.getFailOnCorrupt());
        assertArrayEquals("Wrong value for configuration: ", new AnalysisConfiguration[1], copy.getConfigurations());

        when(original.getFailOnCorrupt()).thenReturn(true);
        when(original.getQuietMode()).thenReturn(true);

        copy = new SerializableSettings(original);
        assertTrue("Wrong value for quiet: ", copy.getQuietMode());
        assertTrue("Wrong value for fail: ", copy.getFailOnCorrupt());
    }
}

