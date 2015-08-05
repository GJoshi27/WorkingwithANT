/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifo;

import com.lts.ipc.IPCException;
import com.lts.ipc.fifo.FIFO;
import com.lts.ipc.fifo.FIFOInputStream;
import java.io.IOException;

/**
 *
 * @author dude
 */
public class FIFOReader {

	public static void main(String[] args) throws IOException, IPCException {
		// TODO code application logic here
		FIFO f1 = new FIFO("myPipe1");
		f1.openReader();
                FIFOInputStream fis=new FIFOInputStream(f1);
                int data=fis.read();
                int N=data;
                System.out.printf("Reader is going %d Integers \n",N);
                for(int i=1;i<=N;i++)
                {
                data=fis.read();
                System.out.println("Data read from Pipe: "+data);
                
                }
                
        }
        
}
