import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader; 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.util.Queue;
import java.util.LinkedList;

class Main {
  
  /////////////////////////////////////////////////////////
  // Inicio das classes que pegamos do trabalho prático 1
  // Não utilizamos o código do trabalho 1 por motivos de que:
  // Nossa nota ter sido baixa, ou seja, o código ter erros.

  static String nomeArquivo = "grafo.txt"; // arquivo texto que contém o grafo
 
     // carrega o grafo do arquivo para a matriz
    static int carregaGrafo(int[][] G, String[] nomes) throws IOException
    {     
        File arq = new File(nomeArquivo);
        BufferedReader bufLeitura;

        
        int numVertices, numArestas, i;
        String aresta;
        String[] tokens;

        if (!arq.exists()) // arquivo não existe
        {
            System.out.println("Arquivo com o grafo inexistente.");
            return(0);
        }            
        else // arquivo existe
        { 
            bufLeitura = new BufferedReader(new FileReader(nomeArquivo));

            numVertices = Integer.parseInt(bufLeitura.readLine());            
            for (i = 0; i < numVertices; i++)
                nomes[i] = bufLeitura.readLine();

            numArestas = Integer.parseInt(bufLeitura.readLine());
            for (i = 0; i < numArestas; i++)
            {
                aresta = bufLeitura.readLine();

                tokens = aresta.split(" ");

                G[Integer.parseInt(tokens[0])-1][Integer.parseInt(tokens[1])-1] = Integer.parseInt(tokens[2]);
                G[Integer.parseInt(tokens[1])-1][Integer.parseInt(tokens[0])-1] = Integer.parseInt(tokens[2]);
            }

            bufLeitura.close();
            return(numVertices);
        }
    }
    //Fim das classes que pegamos do trabalho prático 1
    ///////////////////////////////////////////////////////

    //Execução da busca em largura
    static int[] buscaLargura(int[][] Grafo)
  {
    int vertInicial = 0; 
    int[] auxVertices = new int[5];
    int[] verticesVisitados = new int[5];    
    int cont = 2, contAux = 1;

    Queue<Integer> fila = new LinkedList<>();
    auxVertices[0] = vertInicial;
    verticesVisitados[vertInicial] = 1;    
    fila.add(vertInicial);

    while (!fila.isEmpty())
    {
      for (int i = 0; i < verticesVisitados.length; i++)
      {
        if (Grafo[fila.element()][i] != 0)
        {
          if (verticesVisitados[i] == 0)
          {
            verticesVisitados[i] = cont;
            auxVertices[contAux] = i;
            contAux++;
            cont++;
            fila.add(i);
          }
        }
      }
      fila.remove();
    }

    return auxVertices;
  }

  // Mostrar o resultado da busca em largura
  static void mostraResultadoBusca(int[] auxVertices, string[] nomeVertice)
  {
    //percorrer todos 
    for (int i = 0; i < auxVertices.length; i++)
    {
      System.out.printf("%s", i + 1);
      System.out.printf("%d\n", nomeVertice[auxVertices[i]]);
    }
  }

  public static void main(String[] args) 
  {
    // Pegamos do trabalho prático 1 e atualizamos para o valor do grafo atual
    int[][] G = new int[5][5]; // matriz de adjacências que armazena o grafo
    String[] nomeVertices = new String[5];//Onde guarda os nomes das cidades

    int[] auxVertices = buscaLargura(G); //Executando a Busca
   
    mostraResultadoBusca(auxVertices, nomeVertices); //Mostrando resultado
  }

    private static void mostraResultadoBusca(int[] auxVertices, String[] nomeVertices) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}