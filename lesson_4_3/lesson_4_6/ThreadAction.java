package lesson_4_3.lesson_4_6;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-06-08
 */

class ThreadAction
{
    public static void main(String[] args)
    {

        Runnable runner = new Runnable()
        {
            @Override
            public void run()

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
            }
        };
        Thread threadA = new Thread(runner);
        threadA.setName("Stefan");
        Thread threadB = new Thread(runner);
        threadB.setName("Jonas");
        threadA.start();
        threadB.start();
    }

}
