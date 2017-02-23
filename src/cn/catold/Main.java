package cn.catold;

import cn.catold.util.BaseSolution;

public class Main {
    public static String ALGH_NAME = "p001_050.a041";
//    public static String ALGH_NAME = "p501_550.a526";

    public static void main(String[] args) {
        try {
            BaseSolution solution = (BaseSolution) Class.forName("cn.catold." + ALGH_NAME + ".Solution").newInstance();

            solution.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
