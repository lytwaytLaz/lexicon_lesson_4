package lesson_4_2;

import java.lang.reflect.Method;
/**
 * @author László Hágó
 * @version 1.0
 * @since 2016-06-07
 */
interface TheInterface {
    void TheMethod();
}

class TheImp_1 implements TheInterface {
    @Override
    public void TheMethod() {
        System.out.println("Da metoad fromm TheImp_1");
    }
}

class TheImp_2 implements TheInterface {
    @Override
    public void TheMethod() {
        System.out.println("Da metoad fromm TheImp_2");
    }
}

class TheConstructor {
    public TheInterface iFace;
    TheConstructor(TheInterface iFace) {
        this.iFace = iFace;
    }

    public void run() {
        iFace.TheMethod();
    }
}

public class MainInterface{
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("usage: java TheConstructor <classname>");
            System.exit(1);
        }
        try {
            TheInterface t = (TheInterface) Class.forName(args[0]).newInstance();
            TheConstructor c = new TheConstructor(t);
            c.run();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}