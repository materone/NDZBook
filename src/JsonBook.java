import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import com.alibaba.fastjson.JSON;

import model.chaps;

public class JsonBook {
//	public static final String DBURL = "jdbc:sqlite:/Users/tony/dev/temp/books/book/com.kanshushenqi.ebook.app/databases/JW_BOOK_3.db";
//	public static final String BOOKPATH = "/Users/tony/dev/temp/books/book/books/";
	public static final String DBURL = "jdbc:sqlite:/Users/tony/Documents/MuMu共享文件夹/JW_BOOK_3.db";
	public static final String BOOKPATH = "/Users/tony/Documents/MuMu共享文件夹/";
	public JsonBook() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		byte buff[] = new byte[4096];
		String vol = "";
		try {
//			bos = new BufferedOutputStream(new FileOutputStream(new File(BOOKPATH + "1588.txt")));
			bos = new BufferedOutputStream(new FileOutputStream(new File(BOOKPATH + "89230-T.txt")));
			bos.write("# TTXYZ\r\n".getBytes());
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(DBURL);
			Statement s = conn.createStatement();
//			ResultSet rs = s.executeQuery("select * from chapterbean where hascontent<>0 limit 1890,1394");
			ResultSet rs = s.executeQuery("SELECT * FROM cachebean c WHERE c.data NOTNULL and c.url LIKE '%/book/89230/%' limit 1922,99");
			ResultSetMetaData meta = null;
			if(rs != null){
				meta = rs.getMetaData();
				int cols = meta.getColumnCount();
				for (int i = 1; i <= cols; i++) {
					System.out.println(meta.getColumnName(i));
				}
			}
			while (rs.next()){
				//id integer primary key autoincrement,changesourceurl text, url text, name text, nid text, 
				//novelid text, oid text, pid text, rollname text, position integer, hascontent integer
				String data = rs.getString("data");
				String url = rs.getString("url");
				chaps chaps =  JSON.parseObject(data,chaps.class);
				if(chaps != null){
					System.out.println(chaps.getData().getCname() + " \tfile:" + chaps.getData().getCid());
					bos.write("## ".getBytes());
					bos.write(chaps.getData().getCname().getBytes());
					bos.write("\r\n".getBytes());
					bos.write(chaps.getData().getContent().getBytes());
				}
			}
			rs.close();
			s.close();
			conn.close();
			bos.close();
//			bis.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
