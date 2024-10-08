CalendarEventTest.java:3: error: class, interface, enum, or record expected
package calendar;
^
CalendarEventTest.java:4: error: class, interface, enum, or record expected
import static org.junit.jupiter.api.Assertions.*;
^
CalendarEventTest.java:5: error: class, interface, enum, or record expected
import org.junit.jupiter.api.BeforeEach;
^
CalendarEventTest.java:6: error: class, interface, enum, or record expected
import org.junit.jupiter.api.Test;
^
CalendarEventTest.java:7: error: class, interface, enum, or record expected
import java.util.GregorianCalendar;
^
CalendarEventTest.java:8: error: class, interface, enum, or record expected
import calendar.MeetingCalendar;
^
CalendarEventTest.java:9: error: class, interface, enum, or record expected
import calendar.WeeklyEvent;
^
CalendarEventTest.java:10: error: class, interface, enum, or record expected
import calendar.MultiDayPerWeekEvent;
^
CalendarEventTest.java:11: error: class, interface, enum, or record expected
import calendar.PriorityEvent;

package calendar;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.GregorianCalendar;
import calendar.MeetingCalendar;
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
        event.scheduleEvent(meetingCalendar);

        // Check if the event was added to the calendar
        Meeting addedMeeting = meetingCalendar.findMeeting(startTime);

        assertEquals(description, addedMeeting.getDescription());
        assertEquals(location, addedMeeting.getLocation());
        assertEquals(startTime, addedMeeting.getStartTime());
        assertEquals(endTime, addedMeeting.getEndTime());
        assertTrue(meetingCalendar.doesMeetingConflict(addedMeeting), "Added meeting has conflict.");
    }

    @Test
    void testScheduleConflictingOneTimeEvent() {
        OneTimeEvent event1 = new OneTimeEvent(description, location, startTime, endTime);
        OneTimeEvent event2 = new OneTimeEvent("Conflicting Meeting", "Conference Room", startTime, endTime);
        
        // Schedule the first event
        event1.scheduleEvent(meetingCalendar);
        
        // Try to schedule a conflicting event
        boolean added = event2.scheduleEvent(meetingCalendar);
        
        // Check that the second event wasn't scheduled if it conflicted
        assertFalse(added, "Conflicting one-time event should not be scheduled.");
    }
    @Test
    void testScheduleWeeklyEvent() {
        WeeklyEvent event = new WeeklyEvent(description, location, startTime, endTime, startTime);
        
        // Schedule the event
        event.scheduleEvent(meetingCalendar);
        
        // Check if the event was added to the calendar
        Meeting addedMeeting = meetingCalendar.findMeeting(startTime);
        
        assertEquals(description, addedMeeting.getDescription());
        assertEquals(location, addedMeeting.getLocation());
        assertEquals(startTime, addedMeeting.getStartTime());
        assertEquals(endTime, addedMeeting.getEndTime());
        assertTrue(meetingCalendar.doesMeetingConflict(addedMeeting), "Added weekly event has conflict.");
    }
    
    @Test
    void testScheduleConflictingWeeklyEvent() {
        WeeklyEvent event1 = new WeeklyEvent(description, location, startTime, endTime, startTime);
        WeeklyEvent event2 = new WeeklyEvent("Conflicting Meeting", "Conference Room", startTime, endTime, startTime);
        
        // Schedule the first event
        event1.scheduleEvent(meetingCalendar);
        
        // Try to schedule a conflicting event
        boolean added = event2.scheduleEvent(meetingCalendar);
        
        // Check that the second event wasn't scheduled if it conflicted
        assertFalse(added, "Conflicting weekly event should not be scheduled.");
    }
    
    @Test
    void testScheduleMultiDayPerWeekEvent() {
        int[] days = {GregorianCalendar.MONDAY, GregorianCalendar.WEDNESDAY};
        MultiDayPerWeekEvent event = new MultiDayPerWeekEvent(description, location, startTime, endTime, startTime, days);
        
        // Schedule the event
        event.scheduleEvent(meetingCalendar);
        
        // Check if the event was added to the calendar
        Meeting addedMeeting = meetingCalendar.findMeeting(startTime);
        
        assertEquals(description, addedMeeting.getDescription());
        assertEquals(location, addedMeeting.getLocation());
        assertEquals(startTime, addedMeeting.getStartTime());
        assertEquals(endTime, addedMeeting.getEndTime());
        assertTrue(meetingCalendar.doesMeetingConflict(addedMeeting), "Added multi-day per week event has conflict.");
    }
    
    @Test
    void testScheduleConflictingMultiDayPerWeekEvent() {
        int[] days = {GregorianCalendar.MONDAY, GregorianCalendar.WEDNESDAY};
        MultiDayPerWeekEvent event1 = new MultiDayPerWeekEvent(description, location, startTime, endTime, startTime, days);
        MultiDayPerWeekEvent event2 = new MultiDayPerWeekEvent("Conflicting Meeting", "Conference Room", startTime, endTime, startTime, days);
        
        // Schedule the first event
        event1.scheduleEvent(meetingCalendar);
        
        // Try to schedule a conflicting event
        boolean added = event2.scheduleEvent(meetingCalendar);
        
        // Check that the second event wasn't scheduled if it conflicted
        assertFalse(added, "Conflicting multi-day per week event should not be scheduled.");
    }
    
    @Test
    void testSchedulePriorityEvent() {
        PriorityEvent event = new PriorityEvent(description, location, startTime, endTime);
        
        // Schedule the event
        event.scheduleEvent(meetingCalendar);
        
        // Check if the event was added to the calendar
        Meeting addedMeeting = meetingCalendar.findMeeting(startTime);
        
        assertEquals(description, addedMeeting.getDescription());
        assertEquals(location, addedMeeting.getLocation());
        assertEquals(startTime, addedMeeting.getStartTime());
        assertEquals(endTime, addedMeeting.getEndTime());
        assertTrue(meetingCalendar.doesMeetingConflict(addedMeeting), "Added priority event has conflict.");
    }
    
    @Test
    void testScheduleConflictingPriorityEvent() {
        PriorityEvent event1 = new PriorityEvent(description, location, startTime, endTime);
        PriorityEvent event2 = new PriorityEvent("Conflicting Meeting", "Conference Room", startTime, endTime);
        
        // Schedule the first event
        event1.scheduleEvent(meetingCalendar);
        
        // Try to schedule a conflicting event
        boolean added = event2.scheduleEvent(meetingCalendar);
        
        // Check that the second event wasn't scheduled if it conflicted
        assertFalse(added, "Conflicting priority event should not be scheduled.");
    }
