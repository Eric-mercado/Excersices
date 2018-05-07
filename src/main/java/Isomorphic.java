import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.*;
import java.util.stream.Stream;

public class Isomorphic {

    public static void main(String args[]) throws InvalidArgumentException {

        String rigthWay   = "anita lava la tina";
        String ispmorphic = "smoys ñsbs ñs yoms";

        System.out.println(areIsomorphic(rigthWay, ispmorphic));
    }

    static boolean areIsomorphic(String base, String second) throws InvalidArgumentException {

        validate(base,second);

        boolean isSomorphic = true;
        Map<Character, Character> mapChar = new HashMap<>();

        while(isSomorphic = true){
            for(int i = 0; i < base.length() ; i++) {

                Character basechar = base.charAt(i);
                Character secondChar = second.charAt(i);

                if (!mapChar.containsKey(basechar)) {
                    mapChar.put(basechar, secondChar);
                } else {
                    Character compare = mapChar.get(basechar);

                    isSomorphic = compare.equals(secondChar);
                    break;
                }
            }
            return isSomorphic;

        }

        return isSomorphic;
    }

    static void validate(String base, String second) throws InvalidArgumentException {

        if(base.isEmpty() || second.isEmpty()){
            throw new InvalidArgumentException(new String[]{"Arguments didit match "} );
        }

        if(base.length() != second.length() ){
            throw new InvalidArgumentException(new String[]{"Arguments didit match "} );
        }
    }
}
