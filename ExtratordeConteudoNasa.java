import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratordeConteudoNasa implements ExtratordeConteudo{
    
    public List<Conteudo> extraiConteudos(String json) {
        //extrair os dados
        var parser = new JsonParser();
        List<Map<String, String>> listadeAtributos = parser.parse(json);
        System.out.println(listadeAtributos.size());

        return listadeAtributos.stream()
            .map(atributos -> new Conteudo(atributos.get("title"),atributos.get("url")));
            .toList();
        


    }
}
