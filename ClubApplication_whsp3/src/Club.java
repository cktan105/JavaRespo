import java.text.SimpleDateFormat;
import java.util.*;

public class Club
{
	
	private int numMembers = 0;
	private ArrayList<Member> members = new ArrayList<Member>();
	private HashMap<String, Facility> facilities = new HashMap<String, Facility>();
	private BookingRegister bookingRegister = new BookingRegister();
	private SimpleDateFormat sdf = new SimpleDateFormat("d-MMM-yyyy H:mm");
	
	
	public Member addMember(String surname, String firstName, String secondName)
	{
		int memberNumber = numMembers + 1;
		Member m = new Member(surname, firstName, secondName, memberNumber); // memberNumber start at 1
		members.add(m);
		
		numMembers++;
		
		return m;
	}
	
	// public Member getMember(String memberNumber)
	// {
	// try
	// {
	// int number = Integer.valueOf(memberNumber);
	
	// for (Member m : members)
	// {
	// if (m.getMemberNumber() == number)
	// {
	// return m;
	// }
	// }
	// }
	// catch (Exception NumberFormatException) // to handle exception from valueOf
	// {
	// return null;
	// }
	
	// return null;
	// }
	
	
	public Member getMember(int memberNumber)
	{
		for (Member m : members)
		{
			if (m.getMemberNumber() == memberNumber)
			{
				return m;
			}
		}
		
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public ArrayList<Member> getMembers()
	{
		return ((ArrayList<Member>) members.clone());
		
		// .clone() is shallow copy
		// it will be two different lists pointing to the same reference object
		// i.e. modify the underlying object will be reflected in two lists
		// however, remove object from one list will not affect another
	}
	
	
	public void removeMember(int memberNumber)
	{
		for (int i = 0; i < members.size(); i++)
		{
			Member m = members.get(i);
			
			if (m.getMemberNumber() == memberNumber)
			{
				
				members.remove(i);
				System.out.println(m.toString() + " is removed.");
				return;
			}
		}
		
		System.out.println("No such member number");
	}
	
	
	public void showMembers()
	{
		for (Member m : members)
		{
			System.out.println(m.toString());
		}
	}
	
	
	public Facility addFacility(String name, String description)
	{
		Facility f = new Facility(name, description);
		
		facilities.put(name, f);
		
		return f;
	}
	
	
	public Facility getFacility(String name)
	{
		return facilities.get(name);
	}
	
	
	public Facility[] getFacilities()
	{
		Facility[] array = new Facility[facilities.size()];
		
		return facilities.values().toArray(array);
	}
	
	
	public void removeFacility(String name)
	{
		if (facilities.containsKey(name))
		{
			Facility f = facilities.remove(name);
			System.out.println(f.toString() + " is removed.");
		}
		else
		{
			System.out.println("No such facility");
		}
	}
	
	
	public void showFacilities()
	{
		for (Facility f : facilities.values())
		{
			f.show();
		}
	}
	
	
	public void show()
	{
		
		showFacilities();
		System.out.println("");
		
		// Collections.sort(members);
		// Collections.reverse(members);
		
		Collections.sort(members, new MemberComparator());
		showMembers();
	}
	
	
	public void addBooking(int memberNumber, String facilityName, Date startDate,
	                       Date endDate) throws BadBookingException
	{
		Member m = this.getMember(memberNumber);
		Facility f = this.getFacility(facilityName);
		
		bookingRegister.addBooking(m, f, startDate, endDate);
	}
	
	
	public void removeBooking(Booking b)
	{
		if (bookingRegister.removeBooking(b))
		{
			System.out.printf("%s is removed %n", b.toString());
		}
	}
	
	
	public ArrayList<Booking> getBookings(String facilityName, Date start, Date end)
	{
		Facility f = this.getFacility(facilityName);
		
		if (f == null)
		{
			System.out.printf("Facility name: %s doesn't exits %n", facilityName);
			return null;
		}
		else
		{
			return bookingRegister.getBookings(f, start, end);
		}
		
	}
	
	
	public void showBookings(String facilityName, Date start, Date end)
	{
		ArrayList<Booking> bookingList = getBookings(facilityName, start, end);
		
		if (bookingList != null)
		{
			System.out.printf("%s's booking (from %s to %s): %n", facilityName, sdf.format(start), sdf.format(end));
			
			for (Booking b : bookingList)
			{
				b.show();
			}
		}
		else
		{
			System.out.printf("No booking of %s in this range %n", facilityName);
		}
	}
	
	// private Member members[] = new Member[0];
	// private static final int ARRAY_SIZE_INCREMENT = 1;
	
	// public Member addMember(String surname, String firstName, String secondName)
	// {
	// ensureArraySize();
	// numMembers++;
	// Member m = new Member(surname, firstName, secondName, numMembers);
	// members[numMembers - 1] = m;
	// return m;
	// }
	
	// public void removeMember(int memberNumber)
	// {
	// if ((memberNumber < 1) || (memberNumber > numMembers))
	// {
	// return;
	// }
	// members[memberNumber - 1] = null;
	// }
	
	// public void showMembers()
	// {
	// for (int i = 0; i < numMembers; i++)
	// {
	// Member m = members[i];
	// if (m != null)
	// {
	// m.show();
	// }
	// }
	// // for(Member current: this.members) {
	// // current.show();
	// // }
	// }
	
	// public void ensureArraySize()
	// {
	// if (numMembers >= members.length)
	// {
	// Member newMembers[];
	// int newSize = numMembers + ARRAY_SIZE_INCREMENT;
	// newMembers = new Member[newSize];
	// for (int i = 0; i < numMembers; i++)
	// {
	// newMembers[i] = members[i];
	// }
	// members = newMembers;
	// }
	// }
}
