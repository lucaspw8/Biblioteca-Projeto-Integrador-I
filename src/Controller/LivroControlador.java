/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.Livro;
import DAO.LivroDao;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
/**
 *
 * @author Lucas
 */
public class LivroControlador {
    
    private Livro livro = new Livro();
    
   
    
    private List<Livro> livros;

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
    
    /**Função responsavel pelo cadastro de livros
     * @exception HibernateException
     */
    public void CadastrarLivros(){
       LivroDao dao = new LivroDao();
       dao.CadastrarLivro(livro);
         
    }
    
    public void listaLivro(){
      LivroDao dao = new LivroDao();
      livros = dao.Listarlivro(livro);
    }
    
    public void atualizarTabela(JTable tabela) {
        
        
            listaLivro();

            List<Livro> LivrosEncontrados = getLivros();

            DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
            
            modelo.setNumRows(0);

            for (int x = 0; x < LivrosEncontrados.size(); x++) {
                modelo.insertRow(
                        x,new String[]{
                            String.valueOf(LivrosEncontrados.get(x).getId()),
                            LivrosEncontrados.get(x).getTitulo(),
                            LivrosEncontrados.get(x).getAutor(),
                            LivrosEncontrados.get(x).getEdicao(),
                            LivrosEncontrados.get(x).getEditora(),
                            LivrosEncontrados.get(x).getAno(),
                            LivrosEncontrados.get(x).getDisponivel(),
                            Integer.toString(LivrosEncontrados.get(x).getQuantidade())
                            
                        });
            }

            tabela.setModel(modelo);
        }
    /**
     * Edita os dados dos livros cadastrados
    */
    public void EditarLivro(){
        LivroDao dao = new LivroDao();
        dao.atualizar(livro);
    }
    
     public void ExcluirLivro(){
        LivroDao dao = new LivroDao();
        dao.Excluir(livro);
    }
   
}
