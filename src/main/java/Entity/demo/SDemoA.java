package Entity.demo;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: shushkov
 * Date: 27.01.15
 * Time: 12:38
 * To change this template use File | Settings | File Templates.
 */
public class SDemoA {
    private int[] intArr;
    private Map<String, SDemoB> map;

    public SDemoA() {
    }

    public void setIntArr(int[] intArr) {
        this.intArr = intArr;
    }

    public void setMap(Map<String, SDemoB> map) {
        this.map = map;
    }
}
