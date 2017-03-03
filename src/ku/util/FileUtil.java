package ku.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;

public class FileUtil {
	InputStream in;
	OutputStream out;

	public FileUtil(InputStream in, OutputStream out) {
		this.in = in;
		this.out = out;
	}

	static void copy(InputStream in, OutputStream out) {
		try {
			int count;
			while ((count = in.read()) >= 0) {
				out.write(count);
			}
			in.close();
			out.close();
		} catch (IOException ex) {
			throw new RuntimeException();
		}
	}

	static void copy(InputStream in, OutputStream out, int blocksize) {
		try {
			byte[] buffer = new byte[blocksize];
			int count;
			while ((count = in.read(buffer)) >= 0) {
				out.write(buffer, 0, count);
			}
			in.close();
			out.close();
		} catch (IOException ex) {
			throw new RuntimeException();
		}
	}

	static void bcopy(InputStream in, OutputStream out) {
		try {
			Reader streamReader = new InputStreamReader(in);
			BufferedReader buffRead = new BufferedReader(streamReader);
			PrintWriter printer = new PrintWriter(out);
			String textline;
			while ((textline = buffRead.readLine()) != null) {
				printer.write(textline);
			}
			in.close();
			out.close();
		} catch (IOException ex) {
			throw new RuntimeException();
		}
	}
}
