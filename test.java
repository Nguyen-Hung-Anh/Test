import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.GregorianCalendar;
import calendar.MeetingCalendar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	void testCalendarEvent()
	{
		fail("Not yet implemented");
	}

	@Test
	void testScheduleEvent()
	{
		fail("Not yet implemented");
	}
}

public class CalendarEventTest {

    private GregorianCalendar startTime;
    private GregorianCalendar endTime;
    private String description;
    private String location;
    private MeetingCalendar meetingCalendar;

    @BeforeEach
    public void setUp() {
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
    public void testScheduleEventForOneTimeEvent() {
        OneTimeEvent event = new OneTimeEvent(description, location, startTime, endTime);
        event.scheduleEvent(meetingCalendar);
        
        // Assuming MeetingCalendar has a method to check scheduled events
        assertTrue(meetingCalendar.isEventScheduled(event));
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

    // Additional tests can be created for other classes like MultiDayPerWeekEvent, WeeklyEvent, etc.
}
