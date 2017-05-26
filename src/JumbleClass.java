import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class JumbleClass
{
	private String originalWord;
	private String jumbledWord;
	private String hint;
	private int numGuessesSoFar;
	private boolean wasGuessedCorrectly;
	
	
	public JumbleClass(String wordToJumble)
	{
		setOriginalWord(wordToJumble);
		setJumbledWord(jumbleString(wordToJumble));
		setNumGuessesSoFar(0);
		setHint("There is not a hint yet");
	}
	
	public void updateWithAdditionalLetter()
	{
		if(getJumbledWord().equals(getOriginalWord())==false)
		{
			Random randomNumberGenerator = new Random();
			
			Set <Integer> positionsOfCorrectLetters = new HashSet <Integer> ();
			List <Integer> positionsOfIncorrectLetters = new ArrayList <Integer> ();
			
			for(int i = 0; i < getOriginalWord().length(); i++)
			{
				if(getOriginalWord().charAt(i)==getJumbledWord().charAt(i))
				{
					positionsOfCorrectLetters.add(i);
				}
				else
				{
					positionsOfIncorrectLetters.add(i);
				}
			}
			int posOfIncorrect = positionsOfIncorrectLetters.get(randomNumberGenerator.nextInt(positionsOfIncorrectLetters.size()));
			
			for(int i = 0; i < getOriginalWord().length(); i++)
			{
				if(getOriginalWord().charAt(i)==getJumbledWord().charAt(posOfIncorrect) && positionsOfCorrectLetters.contains(i) == false)
				{
					char[] letter = getJumbledWord().toCharArray();
					char temp = letter[i];
					letter[i] = letter[posOfIncorrect];
					letter[posOfIncorrect] = temp;
					
					setJumbledWord(new String(letter));
					
					break;
				}
			
			}
		}
		
	}
	
	public boolean guess(String guessedWord)
	{
		boolean retVal = false;
		setNumGuessesSoFar(getNumGuessesSoFar() + 1);
		
		if(guessedWord.equals(getOriginalWord()))
		{
			retVal = true;
			setWasGuessedCorrectly(true);
		}
		
		return retVal;
	}
	private String jumbleString(String word)
	{
		Random  randomNumberGenerator = new Random();
		
		char[] letter = word.toCharArray();
		for(int i = 0; i < letter.length; i++)
		{
			int randPos = randomNumberGenerator.nextInt(letter.length);
			char temp = letter[i];
			letter[i] = letter[randPos];
			letter[randPos] = temp;
			
		}
		return new String(letter);
	}
	public void setOriginalWord(String word)
	{
		originalWord = word;
	}
	public String getOriginalWord()
	{
		return originalWord;
	}
	
	public void setJumbledWord(String word)
	{
		jumbledWord = word;
	}
	public String getJumbledWord()
	{
		return jumbledWord;
	}
	public void setNumGuessesSoFar(int guessNum)
	{
		numGuessesSoFar = guessNum;
	}
	public int getNumGuessesSoFar()
	{
		return numGuessesSoFar;
	}
	
	public void setWasGuessedCorrectly(boolean correct)
	{
		wasGuessedCorrectly = correct;
	}
	public boolean getWasGuessedCorrectly()
	{
		return wasGuessedCorrectly;
	}
	
	
	public void setHint(String phrase)
	{
		if(getOriginalWord().contains(phrase) == false)
		{
			hint = phrase;

		}
	}

	public String getHint()
	{
		return hint;
	}
}
