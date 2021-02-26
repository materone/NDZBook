import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.xml.bind.DatatypeConverterInterface;

public class FileTest {
	
	void genfile(){
		try {
			FileOutputStream fos = new FileOutputStream(new File("C:/Dev/a.log"));
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			DataOutputStream dos = new DataOutputStream(bos);
			dos.write(0xF0);
			dos.write(0xF1);
			dos.write(0xF2);
			dos.writeInt(0xF3F4F5F6);
			dos.writeShort(0xABCD);
			//dos.write(-1);
			dos.close();
			bos.close();
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		FileTest ft = new FileTest();
		ft.genfile();
		System.out.println("TH");
		try {
			FileInputStream fis = new FileInputStream(new File("C:/Dev/a.log"));
			BufferedInputStream bis = new BufferedInputStream(fis);
			int x;
			int pos = 0;
			while (true) {
				x = fis.read();
				System.out.printf("%X\n", x);
				pos++;
				if (x == -1) {
					System.out.println("END of file:"+pos);
					bis.close();
					fis.close();
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
