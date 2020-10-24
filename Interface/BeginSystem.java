package Interface;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;

public class BeginSystem {
	public static void main(String args[]) {
		/*try {
			FileReader in=new FileReader("D:\\À¶²©ÎÄ\\RecruitSystem\\src\\source\\activity.txt");
			Scanner theReader=new Scanner(in);
			while(theReader.hasNext()) {
			String m=theReader.next();
			System.out.println(m);
			}
			theReader.close();
			}catch(IOException e) {
				e.printStackTrace();
			}*/
		Timer time=new Timer();
		MyTask task=new MyTask();
		time.schedule(task, 0, 3000);
	}
}
