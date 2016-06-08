package lesson_4_3.lesson_4_6;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-06-08
 */
public class ThreadActionLambdaVersion
{
    public static void main(String[] args)
    {
        Runnable runner = () ->
        {
            String name = Thread.currentThread().getName();
            int count = 0;
            String asterisk = new String("*");
            while (true)
            {
                System.out.println(name + ": " + count++ + " " + asterisk);
                asterisk += "*";
                if (count >= 20) break;
            }
        };
        Thread threadA = new Thread(runner);
        threadA.setName("Johan");
        Thread threadB = new Thread(runner);
        threadB.setName("Ashfaq");
        threadA.start();
        threadB.start();
    }
}
