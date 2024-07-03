package edu.stevens.cs549.hadoop.pagerank;

import java.io.*;

import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.io.*;

public class JoinReducer extends Reducer<TextPair, Text, Text, Text> {

	public void reduce(TextPair key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
		/* 
		 * TextPair ensures that we have values with tag "0" first, followed by tag "1"
		 * So we know that first value is the name and second value is the rank
		 */
		String k = key.toString(); // Converts the key to a String
		
		// TODO values should have the vertex name and the page rank (in that order).
		// Emit (vertex name, pagerank) or (vertex id, vertex name, pagerank)
		// Ignore if the values do not include both vertex name and page rank
		String vertexName = null;
		double pageRank = 0.0;
		for (Text value : values) {
			String[] parts = value.toString().split("\t");

			if (parts.length == 2) {
				vertexName = parts[0];
				pageRank = Double.parseDouble(parts[1]);
				break;
			}
		}
		if (vertexName != null) {
			context.write(new Text(vertexName), new Text(String.valueOf(pageRank)));
		}

	}
}
