import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.GregorianCalendar;
import calendar.MeetingCalendar;

class CalendarEventTest
{
    private GregorianCalendar startTime;
    private GregorianCalendar endTime;
    private GregorianCalendar repeat;
    private String description;
    private String location;
    private MeetingCalendar meetingCalendar;
    private int[] days;
    
    @BeforeEach
    void setUp() throws Exception
    {
        description = "Team Meeting";
        location = "Conference Room";
        startTime = new GregorianCalendar(2024, 9, 15, 10, 0);
        endTime = new GregorianCalendar(2024, 9, 15, 11, 0);
        repeat = new GregorianCalendar(2024, 9, 22, 10, 0); // example repeat time
        meetingCalendar = new MeetingCalendar();
        days = new int[] {GregorianCalendar.MONDAY, GregorianCalendar.WEDNESDAY};
    }

    // Test for OneTimeEvent constructor
    @Test
    void testOneTimeEventConstructor()
    {
        OneTimeEvent event = new OneTimeEvent(description, location, startTime, endTime);
        assertEquals(description, event.getDescription(), "Description should match the initialized value.");
        assertEquals(location, event.getLocation(), "Location should match the initialized value.");
        assertEquals(startTime, event.getStartTime(), "Start time should match the initialized value.");
        assertEquals(endTime, event.getEndTime(), "End time should match the initialized value.");
    }

    // Test for MultiDayPerWeekEvent constructor
    @Test
    void testMultiDayPerWeekEventConstructor()
    {
        MultiDayPerWeekEvent event = new MultiDayPerWeekEvent(description, location, startTime, endTime, repeat, days);
        assertEquals(description, event.getDescription(), "Description should match the initialized value.");
        assertEquals(location, event.getLocation(), "Location should match the initialized value.");
        assertEquals(startTime, event.getStartTime(), "Start time should match the initialized value.");
        assertEquals(endTime, event.getEndTime(), "End time should match the initialized value.");
    }

    // Test for PriorityEvent constructor
    @Test
    void testPriorityEventConstructor()
    {
        PriorityEvent event = new PriorityEvent(description, location, startTime, endTime);
        assertEquals(description, event.getDescription(), "Description should match the initialized value.");
        assertEquals(location, event.getLocation(), "Location should match the initialized value.");
        assertEquals(startTime, event.getStartTime(), "Start time should match the initialized value.");
        assertEquals(endTime, event.getEndTime(), "End time should match the initialized value.");
    }

    // Test for WeeklyEvent constructor
    @Test
    void testWeeklyEventConstructor()
    {
        WeeklyEvent event = new WeeklyEvent(description, location, startTime, endTime, repeat);
        assertEquals(description, event.getDescription(), "Description should match the initialized value.");
        assertEquals(location, event.getLocation(), "Location should match the initialized value.");
        assertEquals(startTime, event.getStartTime(), "Start time should match the initialized value.");
        assertEquals(endTime, event.getEndTime(), "End time should match the initialized value.");
    }

    // Test for scheduling a OneTimeEvent
    @Test
    void testScheduleOneTimeEvent()
    {
        OneTimeEvent event = new OneTimeEvent(description, location, startTime, endTime);
        event.scheduleEvent(meetingCalendar);
        // Assuming MeetingCalendar has a method contains() to verify event scheduling
        assertTrue(meetingCalendar.contains(event), "The event should be scheduled in the meeting calendar.");
    }

    // Test for scheduling a MultiDayPerWeekEvent
    @Test
    void testScheduleMultiDayPerWeekEvent()
    {
        MultiDayPerWeekEvent event = new MultiDayPerWeekEvent(description, location, startTime, endTime, repeat, days);
        event.scheduleEvent(meetingCalendar);
        // Assuming MeetingCalendar has a method contains() to verify event scheduling
        assertTrue(meetingCalendar.contains(event), "The multi-day event should be scheduled in the meeting calendar.");
    }

    // Test for scheduling a PriorityEvent
    @Test
    void testSchedulePriorityEvent()
    {
        PriorityEvent event = new PriorityEvent(description, location, startTime, endTime);
        event.scheduleEvent(meetingCalendar);
        // Assuming MeetingCalendar has a method contains() to verify event scheduling
        assertTrue(meetingCalendar.contains(event), "The priority event should be scheduled in the meeting calendar.");
    }

    // Test for scheduling a WeeklyEvent
    @Test
    void testScheduleWeeklyEvent()
    {
        WeeklyEvent event = new WeeklyEvent(description, location, startTime, endTime, repeat);
        event.scheduleEvent(meetingCalendar);
        // Assuming MeetingCalendar has a method contains() to verify event scheduling
        assertTrue(meetingCalendar.contains(event), "The weekly event should be scheduled in the meeting calendar.");
    }

    // Test for overlapping events
    @Test
    void testOverlappingEvents()
    {
        OneTimeEvent event1 = new OneTimeEvent(description, location, startTime, endTime);
        OneTimeEvent event2 = new OneTimeEvent("Other Meeting", "Different Room", startTime, endTime);
        
        event1.scheduleEvent(meetingCalendar);
        event2.scheduleEvent(meetingCalendar);
        
        // Assuming MeetingCalendar handles overlap
        assertTrue(meetingCalendar.contains(event1), "The first event should be scheduled.");
        assertFalse(meetingCalendar.contains(event2), "The second event should not be scheduled due to overlap.");
    }

    // Test for null description in OneTimeEvent
    @Test
    void testNullDescription()
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new OneTimeEvent(null, location, startTime, endTime);
        });
        assertEquals("Description cannot be null", exception.getMessage());
    }

    // Additional edge cases can be tested similarly...
}
