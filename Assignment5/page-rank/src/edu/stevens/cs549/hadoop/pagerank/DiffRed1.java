package edu.stevens.cs549.hadoop.pagerank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.io.*;

public class DiffRed1 extends Reducer<Text, Text, Text, Text> {

	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
		double[] ranks = new double[2];
		/* 
		 * TODO: The list of values should contain two ranks.  Compute and output their difference.
		 */
		String node = key.toString();
		List<String> inputList = textToList(values);
		double absoluteDifference = 0.0;

		if (inputList.size() == 1) {
			absoluteDifference = Double.parseDouble(inputList.get(0));
		} else if (inputList.size() == 2) {
			double rank1 = Double.parseDouble(inputList.get(0));
			double rank2 = Double.parseDouble(inputList.get(1));
			absoluteDifference = Math.abs(rank1 - rank2);
		} else {
			throw new IOException("Incorrect data format");
		}

		context.write(key, new Text(Double.toString(absoluteDifference)));
	}

	private List<String> textToList(Iterable<Text> values) {
		List<String> list = new ArrayList<String>();
		for (Text item : values) {
			list.add(item.toString());
		}

		return list;
	}
}
