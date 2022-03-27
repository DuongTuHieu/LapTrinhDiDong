import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient {
	public static void main(String[] args) {
		try {
			//Tạo 1 kết nối Socket đến Server time.nist.gov
			Socket soc = new Socket("localhost", 8888);
			System.out.print("Connect!");
			//Lấy luông nhập
			InputStream in = soc.getInputStream();
			InputStreamReader inReader = new InputStreamReader(in);
			BufferedReader buffR = new BufferedReader(inReader);
			
			OutputStream osToClient = soc.getOutputStream();
			OutputStreamWriter write2client = new OutputStreamWriter(osToClient);
			BufferedWriter buffW = new BufferedWriter(write2client);
			//Đọc trả lời và in ra
			Scanner bp = new Scanner(System.in);
			System.out.println(buffR.readLine());
			Double Gui = bp.nextDouble();
			buffW.write(Gui+"\n");
			buffW.flush();
			
		} catch (IOException e) {

			System.out.print("NoConnect....");
			e.printStackTrace();
		}

	}
}
