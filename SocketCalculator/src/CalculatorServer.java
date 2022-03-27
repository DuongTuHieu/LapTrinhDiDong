import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {
	
	public static void main(String[] args) {
		try {
			//mở cổng và bắt đầu nghe
			ServerSocket socketserver = new ServerSocket(8888);
			System.out.print("I'm listening on port number 8888");
			//luôn luôn lắng nghe
			while(true) {
				Socket socketclient = socketserver.accept();
				
				InputStream in = socketclient.getInputStream();
				InputStreamReader inReader = new InputStreamReader(in);
				BufferedReader buffR = new BufferedReader(inReader);
//				DataInputStream input = new DataInputStream(socketclient.getInputStream());
				
				OutputStream osToClient = socketclient.getOutputStream();
				OutputStreamWriter write2client = new OutputStreamWriter(osToClient);
				BufferedWriter buffW = new BufferedWriter(write2client);
				
				buffW.write("Mời nhập a:");
				buffW.flush();
				String chuoiNhan=buffR.readLine();
				String chuoiGui=chuoiNhan;
				
				buffW.write(chuoiGui+"\n");
				buffW.flush();
				
				socketclient.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
