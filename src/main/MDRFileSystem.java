package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class MDRFileSystem {
	public static void yaz(String l1, String l2) {
		try {

			File file = new File("cfg//logintoken.cfg");

			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(l1);
			bw.newLine();
			bw.write(l2);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String gettags(int tagno) throws IOException {
		FileInputStream fstream = new FileInputStream("cfg//tags.cfg");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String cikistag = "null tag read error";
		String tag1 = br.readLine();
		String tag2 = br.readLine();
		String tag3 = br.readLine();
		String tag4 = br.readLine();
		String tag5 = br.readLine();
		String tag6 = br.readLine();
		String tag7 = br.readLine();
		String tag8 = br.readLine();
		String tag9 = br.readLine();
		br.close();
		if (tagno == 1)
			cikistag = tag1;
		if (tagno == 2)
			cikistag = tag2;
		if (tagno == 3)
			cikistag = tag3;
		if (tagno == 4)
			cikistag = tag4;
		if (tagno == 5)
			cikistag = tag5;
		if (tagno == 6)
			cikistag = tag6;
		if (tagno == 7)
			cikistag = tag7;
		if (tagno == 8)
			cikistag = tag8;
		if (tagno == 9)
			cikistag = tag9;
		return cikistag;

	}

	public static String gettwit() throws IOException {
		FileInputStream fstream = new FileInputStream("cfg//twit.cfg");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		strLine = br.readLine();
		br.close();
		return strLine;
	}

	public static String oku1() throws IOException {
		FileInputStream fstream = new FileInputStream("cfg//logintoken.cfg");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		strLine = br.readLine();
		br.close();
		return strLine;
	}

	public static String oku2() throws IOException {
		FileInputStream fstream = new FileInputStream("cfg//logintoken.cfg");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		@SuppressWarnings("unused")
		String strLine;
		String strLine2;
		strLine = br.readLine();
		strLine2 = br.readLine();
		br.close();
		return strLine2;
	}
}
