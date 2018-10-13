package emp.ctc.analysis;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class EmpCtcPartitioner extends Partitioner<Text, Text>
{
	@Override
	public int getPartition(Text key, Text value, int numofreducetasks) 
	{
		int partitionNum = 0;
		String [] tokens = value.toString().split("\\t");
		String gender = tokens[3];
		if(numofreducetasks!=0)
		{
			if(gender.equals("female"))
			{
				partitionNum = 0;
			}
			else
			{
				partitionNum = 1;
			}
		}
		return partitionNum;
	}
}
