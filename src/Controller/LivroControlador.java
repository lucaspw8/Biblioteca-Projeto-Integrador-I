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
    
    
    public void CadastrarLivros(){
        
         
         LivroDao dao = new LivroDao();
         dao.CadastrarLivro(livro);
         
    }
   
}
