public class HashTableCustomTest {

    static HashTableCustom<String> map = new HashTableCustom<String>();

    static void testPut(){        
        map.put("Abanico");
        map.put("Boiler");
        map.put("Burro");
        map.put("Barrio");
        map.put("Carro");
        map.put("Dedo");
        map.put("Epson");
        map.put("Foco");
        map.put("Gato");
        map.put("Hielo");
        map.put("Iguana");
        map.put("Jeringa");
        assert map.size() == 10: "Size does not match";
    }

    static void testGet(){
        String value = map.get("Abanico");
        assert value.equals("Abanico"): "Expected Abanico";
        value = map.get("Boiler");
        assert value.equals("Boiler"): "Expected Boiler";
        value = map.get("Gato");
        assert value.equals("Boiler"): "Expected Boiler";
    }

    public static void main(String ... args){
        testPut();
        testGet();

    }

}