import java.util.*;

public class BookingRegister
{
	
	//
	// Private Booking Table
	private HashMap<Facility, ArrayList<Booking>> bookingTable;
	
	
	//
	// Constructor
	public BookingRegister()
	{
		this.bookingTable = new HashMap<Facility, ArrayList<Booking>>();
	}
	
	
	//
	// Methods
	public void addBooking(Member m, Facility f, Date startDate, Date endDate) throws BadBookingException
	{
		Booking newBooking = new Booking(m, f, startDate, endDate);
		
		ArrayList<Booking> bookingList = bookingTable.get(f);
		
		if (bookingTable.containsKey(f) == false && bookingList == null) // first booking for this facility
		{
			bookingList = new ArrayList<Booking>(); // create new ArrayList
			bookingList.add(newBooking);
			
			bookingTable.put(f, bookingList); // put into HashMap
		}
		else
		{
			// make sure new booking does not overlap with existing bookings
			for (Booking existingBooking : bookingList)
			{
				if (newBooking.overlaps(existingBooking))
				{
					throw new BadBookingException("New booking overlaps with existing booking");
				}				
			}
			
			bookingList.add(newBooking); // only add into list after loop through all the existing bookings
		}
	}
	
	
	public ArrayList<Booking> getBookings(Facility f, Date start, Date end)
	{
		ArrayList<Booking> resultList = new ArrayList<Booking>();
		
		Date temp = new Date();		
		if(start.after(end)) // if start is later then end, switch this two
		{
			temp = start;
			start = end;
			end = temp;
		}
		
		
		for(Booking b : bookingTable.get(f)) // get the booking list of this facility
		{
			if(b.getStartDate().after(start) && b.getEndDate().before(end)) // if within the range
			{
				resultList.add(b); // add booking to the result list
			}
		}
		
		return resultList;
	}
	
	
	/**
	 * @param b booking to remove
	 * @return true if remove successfully
	 */
	public boolean removeBooking(Booking b)
	{
		Facility f = b.getFacility();
		ArrayList<Booking> bookingList = bookingTable.get(f);
		
		return bookingList.remove(b);
	}
	
	

}
