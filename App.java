import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD.json";
        
        var http = new ClienteHttp();
        String json = http.buscaDados(url);
        
        
        //diretorio
        var diretorio = new File("figurinhas/");
        diretorio.mkdir();
        
        //exibir e manipular os dados
        ExtratordeConteudo extrator = new ExtratordeConteudoNasa();
        List<Conteudo> conteudos=extrator.extraiConteudos(json);
        var gerador = new Geradordefigurinhas();
        
        for (int index = 0; index < 5; index++) {
            Conteudo conteudo = conteudos.get(index);
            

            InputStream inputStream = new URL(conteudo.url()).openStream();
            String nomeArquivo = "figurinhas/" + conteudo.titulo() + ".png";

            gerador.criar(inputStream, nomeArquivo);
            System.out.println(conteudo.titulo());
        }

    }
    
}
