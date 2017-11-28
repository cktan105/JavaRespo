import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class ClubApplication
{
	
	//public Date getDate(String date) throws ParseException
	//{
		// TimeZone timeZone = TimeZone.getDefault(); // get default time zone
		// timeZone = TimeZone.getTimeZone("GMT+0800"); // specific time zone
		
		// Calendar calender = Calendar.getInstance(timeZone);
		// calender.getTime();
		
		//Date parsedDate = sdf.parse(date);
		
		//return parsedDate;
	//}
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("d-MMM-yyyy H:mm");
	
	static Date getDate(String date)
	{
		Date d = null;
		
		try
		{
			d = sdf.parse(date);
		}
		catch (ParseException e)
		{
			//e.printStackTrace();
			System.out.println("Invalid format. Please enter d-MMM-yyyy H:mm");
		}
		
		return d;
	}
	
	public static void main(String args[])
	{
		
		Club club = new Club();
		
		
		Member member1, member2, member3, member4, member5, member6;
		
		member1 = club.addMember("Einstein", "Albert", null);
		member2 = club.addMember("Picasso", "Pablo", "Ruiz");
		member3 = club.addMember("Webber", "Andrew", "Lloyd");
		member4 = club.addMember("Baggio", "Roberto", null);
		member5 = club.addMember("Raffles", "Stamford", "Blizzard");
		member6 = club.addMember("Raffles", "Stamford", null);
		
		System.out.println("Current Members:");
		club.showMembers();
		
		System.out.println("Deleting " + member3);
		int id = member3.getMemberNumber();
		club.removeMember(id);
		
		System.out.println("Current members:");
		club.showMembers();
		
		
		Facility f1 = club.addFacility("Canteen", "Food supplier");
		Facility f2 = club.addFacility("Toilet", null);
		Facility f3 = club.addFacility("Swimming pool", "International standard");
					
		club.removeFacility("Toilet");		
		club.show();
		
//		try
//		{
//			club.addBooking(4, "Canteen", getDate("01-dec-2017 08:00"), getDate("01-dec-2017 12:00"));
//			club.addBooking(1,"Canteen", getDate("28-Nov-2017 15:00"), getDate("30-nov-2017 15:00"));
//			
//			club.showBookings("Canteen", getDate("01-Jan-2017 00:00"), getDate("31-dec-2017 23:59"));
//		}
//		catch (BadBookingException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
		
		
	
		
	}
	
	
	
}
