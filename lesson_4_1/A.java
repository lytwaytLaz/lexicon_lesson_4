package lesson_4_1;

import java.lang.reflect.Method;

/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-06-07
 */
class A {
    public void b(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        if(args.length != 3) {
            System.err.println("usage: java A <classname> <methodname> <string>");
            System.exit(1);
        }

        try {
            // forName används ofta, de andra metoderna inte lika mycket
            A a = (A) Class.forName(args[0]).newInstance(); // obs ange även paketnamnet annars hittar den inte (args[0])

            // ett sätt att få utskrift
//            a.b(args[2]);

            //alternativt sätt, helt dynamiskt
            Method method = a.getClass().getMethod(args[1], String.class);
            method.invoke(a, args[2]); //om static method behövs ej a då ska det vara null
//            Class  a = Class.forName(args[0]).n;ewInstance();
//            a.b();
        }catch(Exception e) {
            e.printStackTrace();
        }







    }

}
