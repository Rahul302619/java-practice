package collection;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public class CustomClassAsMapKey {

    public static void main(String[] args) {
        MapKey mapKey1 = new MapKey(1);
        MapKey mapKey2 = new MapKey(2);
        MapKey mapKey3 = new MapKey(3);

        HashMap<MapKey, String> map = new HashMap<>();
        map.put(mapKey1, "Rahul");
        map.put(mapKey2, "Rohan");
        map.put(mapKey3, "Roshan");

        System.out.println(map);
        System.out.println(map.get(mapKey1));
        System.out.println(map.get(mapKey2));
        System.out.println(map.get(mapKey3));
        System.out.println(map.get(new MapKey(3)));
    }
}

class MapKey {
    private int id;

    public MapKey(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + "";
    }

    @Override
    public boolean equals(Object obj) {
        /*
        * Even if we return always false from equal method if hashcode is same in this case always 1
        * means Hashmap determine the bucket after that first it will perform the reference equality if equal it
        * will return the value if not, call the equal() method which we implemented and try to find if still
        * not able to find return null
        * */
        return false;
        /*MapKey mapKey = (MapKey) obj;
        return Objects.equals(mapKey.id, this.id);*/
    }

    @Override
    public int hashCode() {
        return 1;
        /*
        * This will always return null for get operation even if we implemented equal method properly
        * because it always return different hascode(means the diff bucket number)
        * */
//        return new Random().nextInt();
    }
}
