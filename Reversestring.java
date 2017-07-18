package exercise;

public class Reversestring

{

	static void reverseEverything(String s)
	{
		String[] words = s.split(" ");

		String reverseString = "";

		for (int i = 0; i < words.length; i++)
		{
			String word = words[i];

			String reverseWord = "";

			for (int k = word.length() - 1; k >= 0; k--)
			{
				reverseWord = reverseWord + word.charAt(k);
			}

			reverseString =  reverseWord + " "+reverseString;
		}

		System.out.println(s);

		System.out.println(reverseString);

		System.out.println("-------------------------");
	}

	public static void main(String[] args)
	{
		reverseEverything("hope you are doing well");

	}

}


