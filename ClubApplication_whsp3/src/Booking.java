import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking
{
	private SimpleDateFormat sdf = new SimpleDateFormat("d-MMM-yyyy H:mm");
	
	//
	// Private attributes
	private Member member;
	private Facility facility;
	private Date startDate;
	private Date endDate;
	
	
	//
	// Getter
	public Member getMember()
	{
		return member;
	}
	
	
	public Facility getFacility()
	{
		return facility;
	}
	
	
	public Date getStartDate()
	{
		
		return startDate;
	}
	
	
	public Date getEndDate()
	{
		return endDate;
	}
	
	
	//
	// Constructor
	public Booking(Member m, Facility f, Date start, Date end) throws BadBookingException
	{
		if (m == null)
		{
			throw new BadBookingException("Invalid member");
		}
		
		if (f == null)
		{
			throw new BadBookingException("Invalid facility");
		}
		
		if (start == null || end == null)
		{
			throw new BadBookingException("Invalid date");
		}
		
		if (start.after(end))
		{
			throw new BadBookingException("Start date cannot later then end date");
		}
		
		this.member = m;
		this.facility = f;
		this.startDate = start;
		this.endDate = end;
	}
	
	
	//
	// Method
	public boolean overlaps(Booking anotherBooking)
	{
		if (this.getFacility().getName() == anotherBooking.getFacility().getName())
		{
			if (this.getStartDate().before(anotherBooking.getStartDate())) // if b1 is earlier than b2
			{
				// compare b1 end date with b2 start date
				if (this.getEndDate().after(anotherBooking.getStartDate()))
				{
					return true;
				}
			}
			else
			{
				// if b1 is later than b2, compare b1 start date with b2 end date
				if (this.getStartDate().before(anotherBooking.getEndDate()))
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	//
	// Override toString()
	@Override
	public String toString()
	{
		String msg = String.format("Booking of %s made by %s (from %s to %s)", facility.toString(), member.toString(),
		                           sdf.format(getStartDate()), sdf.format(getEndDate()));
		
		return msg;
	}
	
	
	public void show()
	{
		System.out.println(this.toString());
	}
	
	// public Booking(Member m, Facility f, String startDate, String endDate) throws
	// BadBookingException
	// {
	// try
	// {
	// Date start = getDate(startDate);
	// Date end = getDate(endDate);
	//
	// if (m == null)
	// {
	// throw new BadBookingException("Invalid member");
	// }
	//
	// if (f == null)
	// {
	// throw new BadBookingException("Invalid facility");
	// }
	//
	// if (start.after(end))
	// {
	// throw new BadBookingException("Start date cannot later then end date");
	// }
	//
	// this.member = m;
	// this.facility = f;
	// this.startDate = getDate(startDate);
	// this.endDate = getDate(endDate);
	//
	// }
	// catch (ParseException e)
	// {
	// // without either a start date or an end date will be caught here
	// throw new BadBookingException("Invalid date (Please enter d-MMM-yyyy H:mm)");
	// }
	// }
}
