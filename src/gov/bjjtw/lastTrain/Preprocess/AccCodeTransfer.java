package gov.bjjtw.lastTrain.Preprocess;

import java.util.HashMap;

public class AccCodeTransfer {

	public void AccCodeTransfer(String inputFile_transferLinks,String input_Station_name,String inputFile_Adjecent_TransStation) {  
		Operation[] operation= new Operation[3];
		operation[0]=new Operation(inputFile_transferLinks,380,21);
		operation[1]=new Operation(input_Station_name,380,21);
		operation[2]=new Operation(inputFile_Adjecent_TransStation,380,21);
		
		operation[0].readCsv();
		operation[1].readCsv();
		operation[2].readCsv();

		for(int i=0;i<operation[2].table_data.length;i++){
			for(int j=1;j<operation[2].table_data[i].length;j++){
				for(int k=0;k<operation[0].table_data.length;k++){
					if(operation[2].table_data[i][j]==null) {
						break;
					}
					if(operation[2].table_data[i][j].equals(operation[0].table_data[k][3])){
						operation[2].table_data[i][j]=operation[0].table_data[k][2]+","+operation[0].table_data[k][4];
								
					}			
				}
				for(int k=0;k<operation[0].table_data.length;k++){
					if(operation[2].table_data[i][j]==null) {
						break;
					}
					if(operation[2].table_data[i][j].equals(operation[0].table_data[k][5])){
						operation[2].table_data[i][j]=operation[0].table_data[k][2]+","+operation[0].table_data[k][6];
					}			
				}
			}
		}

		//��8����ת����80����13����ת����130
		for(int i=0;i<operation[2].table_data.length;i++){
			for(int j=1;j<operation[2].table_data[i].length;j++){
				if(operation[2].table_data[i][j]==null){
					break;
				}
				String[] temp=operation[2].table_data[i][j].split(",");
				if((temp[0]==null)||(temp[1]==null)){
					break;
				}
				for(int k=0;k<operation[1].table_data.length;k++){
					HashMap<String,String> map=new HashMap<String,String>();
					map.put("��ɽ��", "L091");
					map.put("��ͨ��", "L011");
					map.put("������", "L021");
					map.put("��ׯ��", "L051");
					map.put("��ƽ��", "L131");
					map.put("�෿��", "L092");
					map.put("������", "L101");
					map.put("1����", "L010");
					map.put("2����", "L020");
					map.put("4����", "L040");
					map.put("5����", "L050");
					map.put("6����", "L060");
					map.put("7����", "L070");
					map.put("8����", "L080");
					map.put("9����", "L090");
					map.put("10����", "L100");
					map.put("13����", "L130");
					map.put("14����", "L140");
					map.put("15����", "L150");
					map.put("16����", "L160");

					String ab=(String) map.get(temp[1]);
					if(ab==null){
						break;
					}
					if(temp[0].equals(operation[1].table_data[k][1])&&ab.equals(operation[1].table_data[k][2])){
						operation[2].table_data[i][j]=operation[1].table_data[k][4];
					}
				}
			}
		}

		for(int i=0;i<operation[2].table_data.length;i++){
			for(int j=0;j<operation[2].table_data[i].length;j++){
				if(operation[2].table_data[i][j]==null){
					break;
				}
				System.out.print(operation[2].table_data[i][j]+"\t");
			}
			System.out.println();
		}
	}

}




