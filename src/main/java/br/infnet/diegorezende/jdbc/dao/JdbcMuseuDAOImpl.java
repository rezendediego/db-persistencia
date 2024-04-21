package br.infnet.diegorezende.jdbc.dao;

import br.infnet.diegorezende.jdbc.datasource.DataSourceManager;
import br.infnet.diegorezende.jdbc.model.Museu;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcMuseuDAOImpl implements MuseuDAO {
    public JdbcMuseuDAOImpl(){
    }

    @Override
    public List<Museu> findAll() {
        List<Museu> museus = new ArrayList<>();
        try(
                Connection conn = DataSourceManager.getConnection();
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM museus_db.MUSEUS")
        ){
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                museus.add(new Museu(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3)));
            }
            rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

        return museus;
    }


    @Override
    public Museu findById(Long id) {
        Museu museu = null;
        try(
                Connection conn = DataSourceManager.getConnection();
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM museus_db.MUSEUS WHERE ID=?")
        ){
            pst.setLong(1,id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                museu = new Museu(id,rs.getString(2),rs.getString(3));
            }
            rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

        return museu;
    }



    @Override
    public Long save(Museu museu) {
        Long idMuseuPersistido = 0L;
        try(
                Connection conn = DataSourceManager.getConnection();
                PreparedStatement pst = conn.prepareStatement("INSERT INTO museus_db.MUSEUS(NOME, PAIS) VALUES(?,?)",Statement.RETURN_GENERATED_KEYS)
        ){
            pst.setString(1, museu.getNome());
            pst.setString(2, museu.getPais());
            int linhaAdicionadaTabela = pst.executeUpdate();
            if(linhaAdicionadaTabela!=1)throw new SQLException("Nenhuma linha foi adicionada a tabela");
            try(ResultSet idGerado = pst.getGeneratedKeys()){
                if(idGerado.next()){
                    idMuseuPersistido = idGerado.getLong(1);
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return idMuseuPersistido;
    }

    @Override
    public void update(Museu museu) {
        try(
                Connection conn = DataSourceManager.getConnection();
                PreparedStatement pst = conn.prepareStatement("UPDATE museus_db.MUSEUS SET NOME=?, PAIS=? WHERE ID=?")
        ){
            pst.setString(1, museu.getNome());
            pst.setString(2, museu.getPais());
            pst.setLong(3,museu.getId());
            int resultado = pst.executeUpdate();
            if(resultado!=0){
                System.out.println("Museu foi atualizado: "+ findById(museu.getId()));
            }else{
                throw new SQLException("Nenhuma linha foi adicionada a tabela");}
        }catch(SQLException e){
            e.printStackTrace();
            }
    }

    @Override
    public void deleteById(Museu museu) {
        try (
                Connection conn = DataSourceManager.getConnection();
                PreparedStatement pst = conn.prepareStatement("DELETE FROM museus_db.MUSEUS WHERE ID=?")
        ) {
            pst.setLong(1, museu.getId());
            int linhaApagada = pst.executeUpdate();
            if (linhaApagada != 1) throw new SQLException("Nenhuma linha foi apagada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAll() {
        List<Long> todosIds = getIds();
        for(Long id: todosIds){
            deleteById(findById(id));
        }
    }

    @Override
    public List<Long> getIds() {
        List<Long> ids = new ArrayList<>();
        try(
                Connection conn = DataSourceManager.getConnection();
                PreparedStatement pst = conn.prepareStatement("SELECT ID FROM museus_db.MUSEUS")
                ){
                    ResultSet rs = pst.executeQuery();
                    while (rs.next()){
                        ids.add(rs.getLong(1));
                    }
                    rs.close();
        }catch(SQLException e){e.printStackTrace();}
        return ids;
    }

}
