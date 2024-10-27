package zaikokanri2;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {


	@SuppressWarnings({"resource"})
	public static void main(String[] args) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("メニューを選択してください");
			System.out.println("1：在庫登録");
			System.out.println("2：在庫数呼び出し");
			System.out.println("3：ファイル書き込み");
			System.out.println("終了する場合はCtr + cを押してください");
			try {int i= sc.nextInt(); 
			
			if (i == 1) {
				HashMap<String, String> map1 = touroku(map);
					map = map1;
				}
			else if (i== 2) {
					yobidashi(map);
				}
			else if (i==3) {
					kakikomi(map);
			}
			
			else System.out.println("メニュー選択は半角数字1または2または3で選択してください\r\n");
				}
			catch (java.util.InputMismatchException i){System.out.println("不正な文字が入力されました。\r\n"
					+ "メニュー選択は半角数字1または2または3で入力してください\r\n"+"プログラムを再起動してください");
					break;
			}
		}
	}
	@SuppressWarnings({ "resource" })
	public static HashMap<String, String> touroku(HashMap<String, String> map) {
		
		System.out.println("商品名を入力してください");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println("数量を入力してください");
		String str1= sc.nextLine();
		map.put(s, str1);
		return map;}

	@SuppressWarnings({"resource"})
	public static void yobidashi(HashMap<String, String> map) {
		System.out.println("呼び出したい商品名を入力してください");
		Scanner sc = new Scanner(System.in);
		String str1= sc.nextLine();
		String s= map.get(str1);
		if (s==null) {
				System.out.println("この商品は登録されていません\r\n");
				}
		else System.out.println("商品の数は"+s+ "個\r\n");
	
	}
	public static void kakikomi(HashMap<String, String> map){
		File file = new File("C:\\Users\\brave\\Desktop\\出力\\text.txt");
		FileWriter s =null;
		try{
		s = new FileWriter(file,true);
		for (String key: map.keySet()) {
			String Value=map.get(key);
		s.write(key);
		s.write(':');
		s.write(Value);
		s.write(' ');}
		}catch(IOException e) {System.out.println("エラーです");}
		finally{
			if (s !=null) {
				try {s.close();
			}catch(IOException e) {}
				finally {}
			}
		}
	}
}


