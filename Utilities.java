/**
 * Created by Luke Pollen of pollenanalytics.com on 05/07/2017.
 */

package pollenStats;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Utilities {

    public static void theKeyNames(Map<String, Double> theMap){
        List<String> keyNames = new ArrayList<String>(theMap.keySet());
        for(int i = 0; i < keyNames.size(); i++){
            System.out.println(keyNames.get(i));
        }
    }

}

