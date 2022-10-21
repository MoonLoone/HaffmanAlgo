package transfer_system_elements;

import huffman_algorithm_elements.Huffman;

public class DataSource {
    String text;
    public DataSource(String textForEncode){
        text = textForEncode;
        System.out.println("Source text is: \n"+text+ "\n");
        CoderChanel.encodeText(text);
    }
}
