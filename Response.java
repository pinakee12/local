package testexample;

import java.util.ArrayList;
import java.util.List;

public class Response {
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List getNums() {
		return nums;
	}

	public void setNums(List nums) {
		this.nums = nums;
	}

	String id;
	
	List nums = new ArrayList<Integer>();

	@Override
	public String toString() {
		return "Response [id=" + id + ", nums=" + nums + "]";
	}
	
	

}
