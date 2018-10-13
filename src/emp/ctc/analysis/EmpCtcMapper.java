package emp.ctc.analysis;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class EmpCtcMapper extends Mapper<LongWritable,Text,Text,Text>
{
	public void map(LongWritable key,Text value,Context context) throws IOException,InterruptedException
	{
		String [] tokens = value.toString().split("\t");
		String dept = tokens[4].toString();
	
			context.write(new Text(dept),value);
		
	}
}
