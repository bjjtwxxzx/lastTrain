package Preprocess;

import java.util.Stack;

public class MainClass_Process {

	public static void main(String[] args) throws Exception { 
		String inputFile_transferLinks="D:\\ĩ�೵\\URTNet_TransferLinks_time.csv";
		String adjecent_TransStation="D:\\ĩ�೵\\Adjecent_TransStation.csv";
		String input_Station_name="D:\\ĩ�೵\\station.csv";
		String outputFile_Adjecent_TransStation_ID="D:\\ĩ�೵\\Adjecent_TransStation_ID.csv";
		
		String input_URTNetStation="D:\\ĩ�೵\\URTNet_Station.csv";
		String output_URTNetStation="D:\\ĩ�೵\\NonTrans_Adj_Trans.csv";
		String filename="D:\\ĩ�೵\\available\\TimeTables.csv";
		
//		TransStation transStation=new TransStation();
//		transStation.Adjecent_Station(inputFile_transferLinks, adjecent_TransStation,outputFile_Adjecent_TransStation_ID);//����ÿ������վ���ڽӻ��˵���վ���Ҵ洢��Adjecent_TransStation.csv��
//		
// �Ѿ��������հ汣����Adjecent_TransStation.csv,�������
//		AccCodeTransfer accCodeTransfer=new AccCodeTransfer();
//		accCodeTransfer.AccCodeTransfer(inputFile_transferLinks,input_Station_name,adjecent_TransStation);
		
		DivideTimeTable timeTables=new DivideTimeTable();
		//�Ѿ���������ƽ�պ�˫�ݱ�����timetables�У��������
		timeTables.ReadTimeTable(filename);

	    }
	


}
