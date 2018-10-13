package emp.ctc.analysis;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class EmpCtcReducer extends Reducer<Text, Text,NullWritable, Text>
{
	public void reduce(Text key,Iterable<Text> values,Context context) throws IOException,InterruptedException
	{
		int maxCtc = Integer.MIN_VALUE;
		int ctc = 0;
		String val = "";
		for(Text value:values)
		{
			String [] tokens = value.toString().split("\\t");
			//if(tokens.length==6)
				//{
				ctc = Integer.parseInt(tokens[5]);
				if(ctc>maxCtc)
				{
					
					val = value.toString();
					maxCtc = ctc;
				
				}
			//}
		}
		context.write(NullWritable.get(),new Text(val));

	}
}