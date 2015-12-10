package turkey.client.net;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.Semaphore;

public class FileThread extends Thread{
	
	public static final Semaphore SEMAPHORE = new Semaphore(1);
	private String commitId;
	private String server;
	private int port;
	private String path;
	private boolean isFinish;
	
	public FileThread(String commitId, String server, int port, String path) {
		this.commitId = commitId;
		this.server = server;
		this.port = port;
		this.path = path;
		this.isFinish = false;
	}
	
	public boolean isFinished(){
		return isFinish;
	}
	
	private void sendFile(){
		Socket socket = null;
		DataOutputStream outputStream = null;
		FileInputStream inputStream = null;
		try {
			socket = new Socket(server, port);
			File file = new File(path);
			outputStream = new DataOutputStream(socket.getOutputStream());
			//先写commitId
			outputStream.writeUTF(commitId);
			outputStream.flush();
			//再写文件名称
			outputStream.writeUTF(file.getName());
			outputStream.flush();
			//开始写文件的内容
			inputStream = new FileInputStream(file);
			int len = -1;
			byte[] buffer = new byte[8096];
			while(true){
				len = inputStream.read(buffer);
				if(len < 0){
					break;
				}
				else{
					outputStream.write(buffer, 0, len);
				}
			}
			System.out.println("Client send finish..."+file.getName());
			isFinish = true;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				inputStream.close();
				outputStream.flush();
				outputStream.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void run() {
		try {
			SEMAPHORE.acquire();
			sendFile();
			SEMAPHORE.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
