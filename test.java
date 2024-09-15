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

