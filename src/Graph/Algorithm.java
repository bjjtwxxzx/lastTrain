package Graph;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public interface Algorithm {
	/**
	 * ִ���㷨
	 */
	void perform(Graph g, String sourceVertex,String date,String time,String end_vertex);
	/**
	 * �õ�·��
	 */
	Map<String, String> getPath();
}

