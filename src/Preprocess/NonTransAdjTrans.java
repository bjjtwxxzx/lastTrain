package Preprocess;

import java.io.*;


//import org.apache.poi.util.SystemOutLogger;

public class NonTransAdjTrans {
	
	public static void main(String args[])throws IOException{
		//��ȡ����һ���ǻ���վ��Ӧ���������վ���뼰����վ��Ӧ��������·����վ����
		//�����������NonTrans_Adj_Trans.csv
		NonTransAdjTrans adjoin=new NonTransAdjTrans();
		adjoin.NonTransAdjTrans1();
	}
	
	public void NonTransAdjTrans1() throws IOException {
		// TODO Auto-generated method stub
		String output_NonTransstationAdjStation="D:\\ĩ�೵\\available\\NonTrans_Adj_Trans.csv";
		String output_TransStationAdjStation="D:\\ĩ�೵\\available\\Trans_Adj_Trans.csv";
		Operation1 op=new Operation1("D:\\ĩ�೵\\URTNet_Station.csv");
		op.readCsv();
		Operation2 op2=new Operation2("D:\\ĩ�೵\\URTNet_TransferLinks_time.csv");
		op2.readCsv();
		int row_length=op.a.length;
		int column_length=6;
		String str1="",str2="";
		int row2_length=op2.a.length;
		
		for(int i=1;i<row2_length;i++)
		{
			if(op2.a[i][1]!=null&&op2.a[i][1].equals("TRUE"))//true��ʶ�ɻ�����··��
			{
				str1+=op2.a[i][3]+","+op2.a[i][5]+","+op2.a[i][7]+"\n";//�һ���վ�Ļ���վ��,1��ʶ����վ
			}			
		}
			
		for(int i=0;i<row_length;i++){
			if(op.a[i][3]!=null&&op.a[i][3].equals("�м�վ")){
				int j=i;
				while(op.a[j][2]!=null&&op.a[j][2].equals(op.a[i][2])){//�Ƚ���·���Ƿ���ͬ�������ͬ���Ϳ��ǲ��ǻ���վ��
					if(op.a[j][3].equals("����վ")){
						op.a[i][4]=op.a[j][0];
						break;
					}
					if(j>-1){
						j--;
					}
					if(j==-1){
						break;
					}
				}
				j=i;
				while(op.a[j][2]!=null&&op.a[j][2].equals(op.a[i][2])){
					if(op.a[j][3]!=null&&op.a[j][3].equals("����վ")){
						op.a[i][5]=op.a[j][0];
						break;
					}
					j++;		
				}
			}
			else if(op.a[i][3]!=null&&op.a[i][3].equals("ʼ���յ�վ"))
			{
				int j=i;
				while(op.a[j][2]!=null&&op.a[j][2].equals(op.a[i][2])){//�Ƚ���·���Ƿ���ͬ�������ͬ���Ϳ��ǲ��ǻ���վ��
					if(op.a[j][3].equals("����վ")){
						op.a[i][4]=op.a[j][0];
						break;
					}
					if(j>-1){
						j--;
					}
					if(j==-1){
						break;
					}
				}
				j=i;
				while(op.a[j][2]!=null&&op.a[j][2].equals(op.a[i][2])){
					if(op.a[j][3]!=null&&op.a[j][3].equals("����վ")){
						op.a[i][5]=op.a[j][0];
						break;
					}
					j++;		
				}
				
			}
			else{
				op.a[i][4]="����վ";
			}		
		}
		
		try {
			BufferedWriter bw=new BufferedWriter(new FileWriter(new File(output_NonTransstationAdjStation)));
			BufferedWriter bw1=new BufferedWriter(new FileWriter(new File(output_TransStationAdjStation)));
			for(int i=0;i<row_length;i++){
				if(op.a[i][3]!=null&&!op.a[i][3].equals("����վ"))
				{
					for(int j=0;j<column_length;j++){
					if(op.a[i][j]!=null&&op.a[i][j].contains("S"))
						{
						str2+=op.a[i][j]+",";
							System.out.print(op.a[i][j]+",");
							}		
				}
					str2+="\n";
					System.out.println();	
			}		
		}
			bw.write(str2);
			bw1.write(str1);
			bw.close();
			bw1.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

class Operation1{
	private String filepath;
	public String[][] a=null;
	public Operation1(String filepath){
		this.filepath=filepath;
	}
	public void readCsv() throws IOException{
		try{
			BufferedReader br=new BufferedReader(new FileReader(new File(filepath)));
			a=new String[380][6];
			String[] temp=null;
			String str=null;
			int i=0;
			br.readLine();
			while((str=br.readLine())!=null){
				temp=str.split(",");
				int j=0;
				while(j<4){
					a[i][j]=temp[j];
					j++;
				}
				i++;
			}
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}

class Operation2{
	private String filepath;
	public String[][] a=null;
	public Operation2(String filepath){
		this.filepath=filepath;
	}
	public void readCsv() throws IOException{
		try{
			BufferedReader br=new BufferedReader(new FileReader(new File(filepath)));
			a=new String[129][8];
			String[] temp=null;
			String str=null;
			int i=0;
			br.readLine();
			while((str=br.readLine())!=null){
				temp=str.split(",");
				int j=0;
				while(j<8){
					a[i][j]=temp[j];
					j++;
				}
				i++;
			}
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
