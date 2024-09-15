import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.GregorianCalendar;
import calendar.MeetingCalendar;
import calendar.OneTimeEvent;
import calendar.WeeklyEvent;
import calendar.MultiDayPerWeekEvent;
import calendar.PriorityEvent;

class CalendarEventTest {
    private GregorianCalendar startTime;
    private GregorianCalendar endTime;
    private String description;
    private String location;
    private MeetingCalendar meetingCalendar;

    @BeforeEach
    void setUp() throws Exception {
        description = "Team Meeting";
        location = "Conference Room";
        startTime = new GregorianCalendar(2024, 9, 15, 10, 0);
        endTime = new GregorianCalendar(2024, 9, 15, 11, 0);
        meetingCalendar = new MeetingCalendar();
    }

    @Test
    public void testOneTimeEventCreation() {
        OneTimeEvent event = new OneTimeEvent(description, location, startTime, endTime);
        
        assertEquals(description, event.getDescription());
        assertEquals(location, event.getLocation());
        assertEquals(startTime, event.getStartTime());
        assertEquals(endTime, event.getEndTime());
    }

    @Test
    public void testWeeklyEventCreation() {
        GregorianCalendar repeat = new GregorianCalendar(2024, 9, 22, 10, 0);
        WeeklyEvent event = new WeeklyEvent(description, location, startTime, endTime, repeat);
        
        assertEquals(description, event.getDescription());
        assertEquals(location, event.getLocation());
        assertEquals(startTime, event.getStartTime());
        assertEquals(endTime, event.getEndTime());
    }

    @Test
    public void testMultiDayPerWeekEventCreation() {
        int[] days = {GregorianCalendar.MONDAY, GregorianCalendar.WEDNESDAY};
        GregorianCalendar repeat = new GregorianCalendar(2024, 9, 16, 10, 0);
        MultiDayPerWeekEvent event = new MultiDayPerWeekEvent(description, location, startTime, endTime, repeat, days);
        
        assertEquals(description, event.getDescription());
        assertEquals(location, event.getLocation());
        assertEquals(startTime, event.getStartTime());
        assertEquals(endTime, event.getEndTime());
    }

    @Test
    public void testPriorityEventCreation() {
        PriorityEvent event = new PriorityEvent(description, location, startTime, endTime);
        
        assertEquals(description, event.getDescription());
        assertEquals(location, event.getLocation());
        assertEquals(startTime, event.getStartTime());
        assertEquals(endTime, event.getEndTime());
    }

    @Test
    void testScheduleOneTimeEvent() {
        OneTimeEvent event = new OneTimeEvent(description, location, startTime, endTime);
        
        // Schedule the event
        boolean added = meetingCalendar.addMeeting(event);
        
        // Check if the event was added to the calendar
        assertTrue(added, "One-time event should be scheduled successfully.");
    }

    @Test
    void testScheduleConflictingOneTimeEvent() {
        OneTimeEvent event1 = new OneTimeEvent(description, location, startTime, endTime);
        OneTimeEvent event2 = new OneTimeEvent("Conflicting Meeting", "Conference Room", startTime, endTime);
        
        // Schedule the first event
        meetingCalendar.addMeeting(event1);
        
        // Try to schedule a conflicting event
        boolean added = meetingCalendar.addMeeting(event2);
        
        // Check that the second event wasn't scheduled if it conflicted
        assertFalse(added, "Conflicting one-time event should not be scheduled.");
    }

    @Test
    void testScheduleWeeklyEvent() {
        WeeklyEvent event = new WeeklyEvent(description, location, startTime, endTime, startTime);
        
        // Schedule the event
        boolean added = meetingCalendar.addMeeting(event);
        
        // Check if the event was added to the calendar
        assertTrue(added, "Weekly event should be scheduled successfully.");
    }

    @Test
    void testScheduleConflictingWeeklyEvent() {
        WeeklyEvent event1 = new WeeklyEvent(description, location, startTime, endTime, startTime);
        WeeklyEvent event2 = new WeeklyEvent("Conflicting Meeting", "Conference Room", startTime, endTime, startTime);
        
        // Schedule the first event
        meetingCalendar.addMeeting(event1);
        
        // Try to schedule a conflicting event
        boolean added = meetingCalendar.addMeeting(event2);
        
        // Check that the second event wasn't scheduled if it conflicted
        assertFalse(added, "Conflicting weekly event should not be scheduled.");
    }

    @Test
    void testScheduleMultiDayPerWeekEvent() {
        int[] days = {GregorianCalendar.MONDAY, GregorianCalendar.WEDNESDAY};
        MultiDayPerWeekEvent event = new MultiDayPerWeekEvent(description, location, startTime, endTime, startTime, days);
        
        // Schedule the event
        boolean added = meetingCalendar.addMeeting(event);
        
        // Check if the event was added to the calendar
        assertTrue(added, "Multi-day per week event should be scheduled successfully.");
    }

    @Test
    void testScheduleConflictingMultiDayPerWeekEvent() {
        int[] days = {GregorianCalendar.MONDAY, GregorianCalendar.WEDNESDAY};
        MultiDayPerWeekEvent event1 = new MultiDayPerWeekEvent(description, location, startTime, endTime, startTime, days);
        MultiDayPerWeekEvent event2 = new MultiDayPerWeekEvent("Conflicting Meeting", "Conference Room", startTime, endTime, startTime, days);
        
        // Schedule the first event
        meetingCalendar.addMeeting(event1);
        
        // Try to schedule a conflicting event
        boolean added = meetingCalendar.addMeeting(event2);
        
        // Check that the second event wasn't scheduled if it conflicted
        assertFalse(added, "Conflicting multi-day per week event should not be scheduled.");
    }

    @Test
    void testSchedulePriorityEvent() {
        PriorityEvent event = new PriorityEvent(description, location, startTime, endTime);
        
        // Schedule the event
        boolean added = meetingCalendar.addMeeting(event);
        
        // Check if the event was added to the calendar
        assertTrue(added, "Priority event should be scheduled successfully.");
    }

    @Test
    void testScheduleConflictingPriorityEvent() {
        PriorityEvent event1 = new PriorityEvent(description, location, startTime, endTime);
        PriorityEvent event2 = new PriorityEvent("Conflicting Meeting", "Conference Room", startTime, endTime);
        
        // Schedule the first event
        meetingCalendar.addMeeting(event1);
        
        // Try to schedule a conflicting event
        boolean added = meetingCalendar.addMeeting(event2);
        
        // Check that the second event wasn't scheduled if it conflicted
        assertFalse(added, "Conflicting priority event should not be scheduled.");
    }
}
