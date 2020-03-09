package fastmetro;
import org.json.JSONObject;

@SuppressWarnings("deprecation")

public class Lecture {
	
	public void test() {
		JSONObject obj = new JSONObject();
	    obj.put("name", "foo");
	    obj.put("num", new Integer(100));
	    obj.put("balance", new Double(1000.21));
	    obj.put("is_vip", new Boolean(true));
	    
	    System.out.print(obj);
	}
}

