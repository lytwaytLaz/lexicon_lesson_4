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

class TheImplementor_1 implements TheInterface {
    @Override
    public void TheMethod() {
        System.out.println("The method from TheImplementor_1");
    }
}

class TheImplementor_2 implements TheInterface {
    @Override
    public void TheMethod() {
        System.out.println("The method from TheImplementor_2");
    }
}

class TheConstructor {
    public TheInterface iFace;
    TheConstructor(TheInterface iFace) {
        this.iFace = iFace;
    }


}

public class MainInterface{
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("usage: java TheConstructor <classname> <methodname>");
            System.exit(1);
        }

        try {
            Class nameClass =   System.class.forName(args[0]);
            Class[] myClasses = nameClass.getInterfaces();

            System.out.println(myClasses); //Uppgiften egentligen klar här eller?
//            Method [] nameMethods_imp1;
//
//            String methodArrayName = new String("nameMethods");
//            public Method MethodArrays {
//                int i = 0;
//                if (i == myClasses.length - 1) return;
//                else {
//                    methodArrayName = methodArrayName + "_" + (i + 1);
//                    Method[] nameMethods??? = myClasses[i].getDeclaredMethods();
//            }
//            }
//            TheConstructor whatever = new TheConstructor();
//            Method method = doIt.getClass().getMethod(args[1]);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}