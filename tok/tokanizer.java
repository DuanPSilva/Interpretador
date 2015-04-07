import java.util.StringTokenizer;

public class tokanizer {
	public tokanizer()
	{

	}

public void tests ()
{
	String txt;
	txt = "A casa, esta, na praia.";
	StringTokenizer tokens = new StringTokenizer(txt,",");
	while(tokens.hasMoreTokens())
	{
		System.out.println(tokens.nextToken());
	}
}

}











