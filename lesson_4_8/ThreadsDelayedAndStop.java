package lesson_4_8;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-06-08
 */
public class ThreadsDelayedAndStop
{
    public static void main(String[] args)
    {
        Runnable runner1 = () ->
        {
            String name = Thread.currentThread().getName();
            int count = 0;
            String asterisk = new String("*");
            while (true)
            {
                System.out.println(name + ": " + count++ + " " + asterisk);
                asterisk += "*";
                if (count >= 20) break;
                try
                {
                    Thread.sleep(1000);
                }catch (InterruptedException e1)
                {
                    e1.printStackTrace();
                }
            }
        };

        Runnable runner2 = () ->
        {
            String name = Thread.currentThread().getName();
            String asterisk = new String("*");
            for (int i = 0; i < 20; i++)
            {
                System.out.println(name + ": " + i + " " + asterisk);
                asterisk += "*";
                try
                {
                    Thread.sleep(500);
                }catch (InterruptedException e2)
                {
                    e2.printStackTrace();
                }
            }

        };
        Thread threadA = new Thread(runner1);
        threadA.setName("Thread-001");
        Thread threadB = new Thread(runner2);
        threadB.setName("Thread-007");
        threadA.start();
        threadB.start();
    }
}