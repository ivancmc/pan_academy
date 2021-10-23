import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WhileRegex {

	public static void main(String[] args) {
		
		String example = "2021.10.20";
		Pattern pattern = Pattern.compile("(\\d{4})[.](\\d{2})[.](\\d{2})");
		Matcher mat = pattern.matcher(example);
		
		while (mat.find()) {
			System.out.println(mat.group().replaceAll("(\\d{4})[.](\\d{2})[.](\\d{2})", "$3/$2/$1"));
		}
		
		Pattern pt = Pattern.compile("\\d+");
		Matcher mt = pt.matcher("hello1234goodboy5678");
		while (mt.find()) {
			System.out.println(mt.group());
		}

		String text = "John speak  and John writes about that,"
				+ " and John think 2021.10.10 about everything.";
		String nominho = "(John)";
		
		Pattern pat = Pattern.compile(nominho);
		Matcher ma = pat.matcher(text);
		
		while (ma.find()) {
			System.out.println("found " + ma.group());
		}
	
		String regex = "\\b(\\d{2})(\\d{5})(\\d{4})\\b";
	    String replacementText = "($1) $2-$3";
	    String source = "11992887722, 1234567, and 1234567890";

	    
	    String formattedSource = source.replaceAll(regex, replacementText);
	    System.out.println(formattedSource);
	    
	    Pattern tel = Pattern.compile("\\b(\\d{2})[.](\\d{5})(\\d{4})\\b");
	    Matcher mTel = tel.matcher("11.992887722 1199288772 ");
	    while (mTel.find()) {
		      System.out.println(mTel.group());
	    }
	    
	    System.out.println("-------------");
	    
	    Pattern p = Pattern.compile("(\\d{4})[.](\\d{2})[.](\\d{2})");
	    Matcher m = p.matcher("luiza 2021.01.10jjjj 2021.01.10");

	    while (m.find()) {
		      System.out.println(m.group().replace(".", "/"));
	    }

	}

}
