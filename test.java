@Test
void testScheduleOneTimeEvent() {
    OneTimeEvent event = new OneTimeEvent(description, location, startTime, endTime);
    
    // Schedule the event
    event.scheduleEvent(meetingCalendar);
    
    // Check if the event was added to the calendar
    assertTrue(meetingCalendar.containsEvent(event), "One-time event should be scheduled successfully.");
}

@Test
void testScheduleConflictingOneTimeEvent() {
    OneTimeEvent event1 = new OneTimeEvent(description, location, startTime, endTime);
    OneTimeEvent event2 = new OneTimeEvent("Conflicting Meeting", "Conference Room", startTime, endTime);
    
    // Schedule the first event
    event1.scheduleEvent(meetingCalendar);
    
    // Try to schedule a conflicting event
    event2.scheduleEvent(meetingCalendar);
    
    // Check that the second event wasn't scheduled
    assertFalse(meetingCalendar.containsEvent(event2), "Conflicting one-time event should not be scheduled.");
}

@Test
void testSchedulePriorityEvent() {
    OneTimeEvent event1 = new OneTimeEvent(description, location, startTime, endTime);
    PriorityEvent priorityEvent = new PriorityEvent("Urgent Meeting", "Conference Room", startTime, endTime);
    
    // Schedule the normal event first
    event1.scheduleEvent(meetingCalendar);
    
    // Schedule the priority event
    priorityEvent.scheduleEvent(meetingCalendar);
    
    // Check that the priority event replaced the previous event
    assertFalse(meetingCalendar.containsEvent(event1), "The original event should be displaced by the priority event.");
    assertTrue(meetingCalendar.containsEvent(priorityEvent), "The priority event should be scheduled successfully.");
}

@Test
void testScheduleWeeklyEvent() {
    GregorianCalendar repeat = new GregorianCalendar(2024, 9, 22, 10, 0);
    WeeklyEvent weeklyEvent = new WeeklyEvent(description, location, startTime, endTime, repeat);
    
    // Schedule the weekly event
    weeklyEvent.scheduleEvent(meetingCalendar);
    
    // Check that the weekly event was added to the calendar
    assertTrue(meetingCalendar.containsEvent(weeklyEvent), "Weekly event should be scheduled successfully.");
}

@Test
void testScheduleMultiDayPerWeekEvent() {
    int[] days = {GregorianCalendar.MONDAY, GregorianCalendar.WEDNESDAY};
    GregorianCalendar repeat = new GregorianCalendar(2024, 9, 16, 10, 0);
    MultiDayPerWeekEvent multiDayEvent = new MultiDayPerWeekEvent(description, location, startTime, endTime, repeat, days);
    
    // Schedule the multi-day event
    multiDayEvent.scheduleEvent(meetingCalendar);
    
    // Check that the multi-day event was added to the calendar
    assertTrue(meetingCalendar.containsEvent(multiDayEvent), "Multi-day event should be scheduled successfully.");
}


Assessment report [-]
OneTimeEvent should not displace existing meetings

OUTPUT


Thanks for using JUnit! Support its development at https://junit.org/sponsoring


WARNING: Delegated to the 'execute' command.
         This behaviour has been deprecated and will be removed in a future release.
         Please use the 'execute' command directly.

PriorityEvent should displace existing meetings

OUTPUT


Thanks for using JUnit! Support its development at https://junit.org/sponsoring


WARNING: Delegated to the 'execute' command.
         This behaviour has been deprecated and will be removed in a future release.
         Please use the 'execute' command directly.

WeeklyEvent should not displace existing meetings

OUTPUT


Thanks for using JUnit! Support its development at https://junit.org/sponsoring


WARNING: Delegated to the 'execute' command.
         This behaviour has been deprecated and will be removed in a future release.
         Please use the 'execute' command directly.

MultiDayPerWeekEvent should not displace existing meetings

OUTPUT


Thanks for using JUnit! Support its development at https://junit.org/sponsoring


WARNING: Delegated to the 'execute' command.
         This behaviour has been deprecated and will be removed in a future release.
         Please use the 'execute' command directly.

Must check that constructors initialize variables correctly

OUTPUT


Thanks for using JUnit! Support its development at https://junit.org/sponsoring


WARNING: Delegated to the 'execute' command.
         This behaviour has been deprecated and will be removed in a future release.
         Please use the 'execute' command directly.

Must check that constructors initialize variables correctly

OUTPUT


Thanks for using JUnit! Support its development at https://junit.org/sponsoring


WARNING: Delegated to the 'execute' command.
         This behaviour has been deprecated and will be removed in a future release.
         Please use the 'execute' command directly.

Must check all meetings generated in repeated events

OUTPUT


Thanks for using JUnit! Support its development at https://junit.org/sponsoring


WARNING: Delegated to the 'execute' command.
         This behaviour has been deprecated and will be removed in a future release.
         Please use the 'execute' command directly.

Must make sure that repeated events stop when scheduled

OUTPUT


Thanks for using JUnit! Support its development at https://junit.org/sponsoring


WARNING: Delegated to the 'execute' command.
         This behaviour has been deprecated and will be removed in a future release.
         Please use the 'execute' command directly.

Must be sure that multi-day events are not scheduling every day

OUTPUT


Thanks for using JUnit! Support its development at https://junit.org/sponsoring


WARNING: Delegated to the 'execute' command.
         This behaviour has been deprecated and will be removed in a future release.
         Please use the 'execute' command directly.



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.GregorianCalendar;
import calendar.MeetingCalendar;

class CalendarEventTest
{
	private GregorianCalendar startTime;
    private GregorianCalendar endTime;
    private String description;
    private String location;
    private MeetingCalendar meetingCalendar;
    
	@BeforeEach
	void setUp() throws Exception
	{
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


}

