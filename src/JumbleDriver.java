import javax.swing.JOptionPane;

public class JumbleDriver 
{
	public static final int NUM_ALLOWED_GUESSES = 3;
	public static void main(String[] args)
	{
		System.out.println("Jumble Driver");
		
		/*JumbleClass j = new JumbleClass("cat");
		System.out.println("Original:" + j.getOriginalWord());
		System.out.println("Jumbled:" + j.getJumbledWord());

		if(j.guess("dog") != false)
		{
			System.out.println("Error in guess");
		}
		if(j.guess("cat") != true)
		{
			System.out.println("Error in guess");
		}*/
		
		
		String word = JOptionPane.showInputDialog("Enter in a word to jumble:");
		JumbleClass jumble = new JumbleClass(word);
		
		String hint = JOptionPane.showInputDialog("Enter in a hint:");
		if(hint.isEmpty() == false)
		{
			jumble.setHint(hint);
		}
		
		while(jumble.getWasGuessedCorrectly() == false && jumble.getNumGuessesSoFar() < NUM_ALLOWED_GUESSES)
		{
			//makeAGuess(jumble);
			String option = JOptionPane.showInputDialog("1. Make a guess\n 2. View hint\n 3. Change a letter\n");
			if(option.equals("1"))
			{
				makeAGuess(jumble);
			}
			else if(option.equals("2"))
			{
				JOptionPane.showMessageDialog(null, "Hint: " + jumble.getHint());
			}
			else if(option.equals("3"))
			{
				jumble.updateWithAdditionalLetter();
				makeAGuess(jumble);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid option,retry");

			}
		}
	}
	public static void makeAGuess(JumbleClass jumble)
	{
		String guess = JOptionPane.showInputDialog("Unjumble this word " +jumble.getJumbledWord());
		if(jumble.guess(guess))
		{
			JOptionPane.showMessageDialog(null, "The guess was correct!!");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "The guess was NOT correct!!");

		}
	}

}
