package Core;

public class ParametroSingleton {
    private static ParametroSingleton parametroSingleton;

    public  static ParametroSingleton getParametroSingleton() {

        if (parametroSingleton==null) {

            parametroSingleton=new ParametroSingleton();
        }
        return parametroSingleton;
    }

    //public static final
}
