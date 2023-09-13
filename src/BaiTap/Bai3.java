package BaiTap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Bai3 {
	public static void main(String[] args) {
		Map<String, String> englishToVietNamese = new HashMap<>();
		Map<String, String> vietnameseToEnglish = new HashMap<>();
		
		try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\thanh\\LTM\\BaiTapTuan2\\src\\BaiTap\\dictionary.txt"))){
			 String line;
			 while ((line = reader.readLine()) != null) {
			 String[] arr =  line.split(";");
			 if (arr.length == 2) {
				 String englishWord = arr[0].trim();
				 String vietnameseWord = arr[1].trim();
				 englishToVietNamese.put(englishWord, vietnameseWord);
				 vietnameseToEnglish.put(vietnameseWord, englishWord);
			 }
			}
		} catch (IOException e) {
			System.err.println("Lỗi khi đọc từ điển ");
			return;
		}
		
		 Scanner scanner = new Scanner(System.in);
		 
		 while(true) {
			 System.out.print("Nhập từ ( để thoát, nhập 'exit'): ");
			 String input = scanner.nextLine().trim();
			 
			 if (input.equalsIgnoreCase("exit")) {
				 break;
			 }
			 
			 String translation = null;
			 
			 if (englishToVietNamese.containsKey(input)) {
				 translation = englishToVietNamese.get(input);
			 } else if (vietnameseToEnglish.containsKey(input)) {
				 translation = vietnameseToEnglish.get(input);
			 }
			 
			 if (translation != null ) {
				 System.out.println("Dịch: " + translation);
			 } else {
				 System.out.println("Không tìm thấy từ trong từ điển : ");
			 }
		 }
		 scanner.close();
	}
}
