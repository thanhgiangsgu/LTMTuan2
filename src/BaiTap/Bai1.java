package BaiTap;
import java.util.Scanner;
import java.math.BigInteger;

public class Bai1 {
	
	public static BigInteger tinhPhepTinh(String phepTinh) {
		if (phepTinh.contains("+")) {
			String[] arr = phepTinh.split("\\+");
			BigInteger soA = new BigInteger(arr[0]);
            BigInteger soB = new BigInteger(arr[1]);
            return soA.add(soB);
		} else 
		if (phepTinh.contains("-")) {
			String[] arr = phepTinh.split("-");
			BigInteger soA = new BigInteger(arr[0]);
			BigInteger soB = new BigInteger(arr[1]);
			return soA.subtract(soB);
		} else
		if (phepTinh.contains("*")) {
			String[] arr = phepTinh.split(("\\*"));
			BigInteger soA = new BigInteger(arr[0]);
			BigInteger soB = new BigInteger(arr[1]);
			return soA.multiply(soB);
		} else 
		if (phepTinh.contains("/")) {
			String[] arr = phepTinh.split(("/"));
			BigInteger soA = new BigInteger(arr[0]);
			BigInteger soB = new BigInteger(arr[1]);
			if (soB.equals(BigInteger.ZERO)) {
                throw new ArithmeticException("Phép chia cho 0 không hợp lệ.");
            }
			return soA.divide(soB);
		} else {
            throw new IllegalArgumentException("Phép tính không hợp lệ.");
        }
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập phép tính vào ( không có khoảng trắng ) : ");
		String phepTinh = scanner.nextLine();
		scanner.close();
		
		try {
			BigInteger ketQua = tinhPhepTinh(phepTinh);
			System.out.println("Kết quả: " + ketQua);
		} catch (NumberFormatException e) {
            System.out.println("Lỗi: Định dạng phép tính không hợp lệ.");
        } catch (ArithmeticException e) {
            System.out.println("Lỗi: Phép chia cho 0 không hợp lệ.");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: Phép tính không hợp lệ.");
        }
		}
	}
