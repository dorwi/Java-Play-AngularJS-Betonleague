package populators;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dori on 24.10.15.
 */
public class CSVReader {
    public static List<JsonNode> read(String fileName) throws Exception {
        List<JsonNode> list = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        String csvSplit = ",";

        br = new BufferedReader(new FileReader(fileName));

        /*The first line is the name of the coloumns*/
        line = br.readLine();
        String[] coloumns = line.split(csvSplit);

        while ((line = br.readLine())!= null){
            String[] values = line.split(csvSplit);
            if (values.length>coloumns.length){
                throw new Exception("In the line:\n" + line + "\nmore values than coloumns");
            }
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode obj = new ObjectNode(JsonNodeFactory.instance);
            for (int i=0;i<values.length;++i){
                obj.put(coloumns[i],values[i]);
            }
            list.add(obj);
        }
        return list;
    }
}
