package model;
/**
 * {"status":1,"info":"success","data":{"id":1588,"name":"都市奇门医圣","cid":4931455,"cname":"第1810章 失恋","pid":4931454,"nid":4931456,"content":" \f\t\n","hasContent":1}}
 * @author tony
 *
 */
public class chaps {
	int status;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	String info;
	Data data;
	public class Data {
		int id;
		String name;
		int cid;
		String cname;
		int pid;
		int nid;
		String content;
		int hasContent;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getCid() {
			return cid;
		}
		public void setCid(int cid) {
			this.cid = cid;
		}
		public String getCname() {
			return cname;
		}
		public void setCname(String cname) {
			this.cname = cname;
		}
		public int getPid() {
			return pid;
		}
		public void setPid(int pid) {
			this.pid = pid;
		}
		public int getNid() {
			return nid;
		}
		public void setNid(int nid) {
			this.nid = nid;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public int getHasContent() {
			return hasContent;
		}
		public void setHasContent(int hasContent) {
			this.hasContent = hasContent;
		}
	}
}
