package BaiTap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Scanner; 

public class Bai2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập chuỗi: ");
		String input = scanner.nextLine();
		scanner.close();
		
		String[]  words =  input.split("\\s+");
		Set<String> uniqueWords = new LinkedHashSet<>();
		
		for (String word : words) {
			if (!containsIgnoreCase(uniqueWords, word)) {
                uniqueWords.add(word);
            }
		}
		
		StringBuilder result = new StringBuilder();
		for (String word : uniqueWords) {
			result.append(word).append(" ");
		}
		
		if (result.length() > 0) {
			result.deleteCharAt(result.length() - 1);
		}
		
		System.out.println("Kết quả : " + result.toString());
	}
	
	public static boolean containsIgnoreCase(Set<String> set, String word) {
		for (String s : set) {
			if (s.equalsIgnoreCase(word)) {
				return true;
			}
		}
		return false;
	}
	
}
