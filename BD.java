import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BD {
    static final String banco = "jdbc:mysql://localhost:3306/mysql";
    Connection conexao = null;
    Statement consulta = null;
    ResultSet resultados = null;
    PreparedStatement minhaConsulta=null;
    public void inserir(int idProduto, String NomeProduto, float Preco){
        try {
            conexao = DriverManager.getConnection(banco,"root","kmdslkgnlek");
            consulta = conexao.createStatement();
            resultados = consulta.executeQuery("Select * from loja");
            minhaConsulta = conexao.prepareStatement("insert into loja(idProduto,NomeProduto,Preco) values (?,?,?)");
            minhaConsulta.setInt(1,idProduto);
            minhaConsulta.setString(2,NomeProduto);
            minhaConsulta.setFloat(3,Preco);
            minhaConsulta.executeUpdate();
            //resultados = minhaConsulta.executeQuery();
            ResultSetMetaData colunas = resultados.getMetaData();
            int numeroColunas = colunas.getColumnCount();
            for (int i=1; i <= numeroColunas; i++ )
            System.out.println(colunas.getColumnName(i));
            while (resultados.next()){
                for (int i=1; i <= numeroColunas; i++ )
                System.out.println("dados " + resultados.getObject(i));
                System.out.println();
            }
        }
        catch (SQLException erro){
            erro.printStackTrace();
        }
        finally {
            try {
                resultados.close();
                minhaConsulta.close();
                conexao.close();
            }
            catch (Exception erronovo) {
                erronovo.printStackTrace();
            }
        }
    }
}
