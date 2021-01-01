package com.hhu;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
	    String[] input = {
				"78919,138,129,120,112,105,99.4,93.7,90.1,88.7,87.3,85.9,84.5,83,80.8,78.1,77.8,74.1,71.7," +
						"69.8,68.6,67.3,64.6,60.7,59.4,58.2,56.9,55.7,54.1,52.8,51,49.9,48.8",
				"79916,239,221,204,186,169,166,162,158,153,147,141,137,132,127,125,123,121,119,117,115,114," +
						"112,110,109,107,106,105,103,101,98.5,95.9,93.2,92.6,92,91.4",
				"79813,92.1,81.6,77.4,74.8,73.8,68.7,65.3,63.4,59.7,57.5,56.6,55.3,53.9,52.6,51.8,50,47.4,46.1"
		};

		recessionHistory history = new recessionHistory();
	    for( String floodString : input ){
			floodRecession process = floodRecession.readFromString(floodString, ",");
			history.append(process);
		}
	    history.setRecDischarge(100.0);

	    //输出平移后的退水曲线
		for (int i =0; i < history.getAmount(); i++){
			if (history.get(i).isLegal()){
				System.out.println(history.get(i).toTranslatedString());
			}
		}
		//输出历史场次的平均退水曲线
	    System.out.println(history.toAvgRecessionString());

		//计算平均退水曲线的退水系数
	    floodRecession averageRecession =  floodRecession.readFromString(
	    		history.toAvgRecDSVString(","),",");
	    System.out.println("历史退水系数为： " + averageRecession.getRecessionCoefficient());

    }
}
