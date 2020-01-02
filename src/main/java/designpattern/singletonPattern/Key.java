package designpattern.singletonPattern;

/**
 * @author lijie7
 * @date 2018/2/28
 * @Description
 * @modified By
 */
public class Key {
    private String name;
    private String type;
    private int num;
    private static Key keyInstance = new Key("达尔优","机械键盘",87);

    public Key(String name, String type, int num) {
        this.name = name;
        this.type = type;
        this.num = num;
    }
    private Key() {
    }
    public static Key getOneKey(){
        return keyInstance;
    }
}
