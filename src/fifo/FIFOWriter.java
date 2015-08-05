/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fifo;

import com.lts.ipc.IPCException;
import com.lts.ipc.fifo.FIFO;
import com.lts.ipc.fifo.FIFOOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dude
 */
public class FIFOWriter{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, IPCException {
        // TODO code application logic here
        FIFO f1 = new FIFO("myPipe1");
        f1.create();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter How many integers you want to reader");
        String str=br.readLine();
        int N=Integer.parseInt(str);
        
        f1.openWriter();
        FIFOOutputStream fio = new FIFOOutputStream(f1);
        fio.write(N);
        for (int i =1; i <= N; i++) {
            System.out.printf("Writing %d to Pipe\n",i);
            fio.write(i);
            fio.flush();
        }
        fio.close();

    }
}
