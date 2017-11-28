import java.util.Comparator;

public class MemberComparator implements Comparator<Member>
{
	
	@Override
	public int compare(Member o1, Member o2)
	{
		// //
		// // First compare surname
		// if (o1.getSurname() != o2.getSurname())
		// {
		// return o1.getSurname().compareTo(o2.getSurname());
		// }
		//
		// //
		// // Second compare first name
		// else if (o1.getFirstName() != o2.getFirstName())
		// {
		// return o1.getFirstName().compareTo(o2.getFirstName());
		// }
		//
		// //
		// // Last compare second name
		// else if (o1.getSecondName() == null)
		// {
		// if (o2.getSecondName() == null)
		// {
		// return 0; // same
		// }
		// else
		// {
		// return 1; // o1 > o2 means o1 will be shown later than o2
		// }
		// }
		// else if (o2.getSecondName() == null)
		// {
		// return -1;
		// }
		// else
		// {
		// return o1.getSecondName().compareTo(o2.getSecondName());
		// }
		
				
		int result = o1.getSurname().compareTo(o2.getSurname());
		
		if (result == 0) // means surname is the same
		{
			result = o1.getFirstName().compareTo(o2.getFirstName());
		}
		
		if (result == 0) // means surname and first name is the same
		{
			
			if (o1.getSecondName() == null && o2.getSecondName() == null)
			{
				result = 0;
			}
			else if (o1.getSecondName() == null || o2.getSecondName() == null)
			{
				result = o1.getSecondName() == null ? 1 : -1;
			}
			else
			{
				result = o1.getSecondName().compareTo(o2.getSecondName());
			}
		}
		
		return result;
		
		
		
		// int result = o1.getSurname().compareTo(o2.getSurname());
		//
		// if(result != 0) // means surname is not equal
		// {
		// return result;
		// }
		//
		// result = o2.getFirstName().compareTo(o2.getFirstName());
		//
		// if(result != 0) // means same surname but different first name
		// {
		// return result;
		// }
		//
		// if(o1.getSecondName() == null && o2.getSecondName() == null) // means same
		// surname and first name, but both dont have second name
		// {
		// return 0;
		// }
		//
		// if(o1.getSecondName() == null || o2.getSecondName() == null)
		// {
		// result = o1.getSecondName() == null? 1:-1;
		// return result;
		// }
		//
		// result = o1.getSecondName().compareTo(o2.getSecondName());
		//
		// return result;
		
	}
	
}
