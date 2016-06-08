package lesson_4_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-06-08
 */
public class ThreadDelayedActionLambdaAndURL
{
    public static void main(String[] args)
    {


        Runnable runner1 = () ->
        {
            String name = Thread.currentThread().getName();
            int stopValue = 20;
            StringBuilder asterisk = new StringBuilder("*");
            for (int i = 0; i < stopValue; i++)
            {
                System.out.println(name + ": " + asterisk);
                asterisk.append("*");
                    try
                    {
                        Thread.sleep(1000);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
            }
        };

        Runnable runner2 = () ->
        {
//            String name2 = Thread.currentThread().getName();
            try {
                final URL url = new URL("https://drive.google.com/file/d/0BxOmtD69bddob1RqSnhnNERNNDA/view?usp=sharing");
                final URLConnection conn = url.openConnection();
                final BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                final String pageText = reader.lines().collect(Collectors.joining("\n"));
                Files.write(Paths.get("/tmp/test.html"), pageText.getBytes());
                reader.close();
            }
            catch (IOException e) {
                System.err.println(e.getMessage());
            }

        };
        Thread thA = new Thread(runner1);
        thA.setName("Thread-1");
        Thread thB = new Thread(runner2);
        thB.setName("Thread-2");
        thA.start();
        thB.start();


    }
}
