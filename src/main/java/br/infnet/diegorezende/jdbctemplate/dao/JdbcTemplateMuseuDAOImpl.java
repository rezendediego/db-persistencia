package br.infnet.diegorezende.jdbctemplate.dao;

import br.infnet.diegorezende.jdbctemplate.model.Museu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;
@Component
@Scope("prototype")
public class JdbcTemplateMuseuDAOImpl implements MuseuDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Museu> findAll() {
        String sql = "SELECT * FROM museu_dbtemplate.MUSEUS_JDBC_TEMPLATE";
        RowMapper<Museu> mapper = (rs, rowNum) -> {
            Museu museu =  new Museu();
            museu.setId(rs.getLong(1));
            museu.setNome(rs.getString(2));
            museu.setPais(rs.getString(3));
            return museu;
        };
        return jdbcTemplate.query(sql,mapper);
    }

    @Override
    public Museu findById(Long id) {
        String sql = "SELECT ID, NOME, PAIS FROM museu_dbtemplate.MUSEUS_JDBC_TEMPLATE WHERE ID= ?";
        return jdbcTemplate.query(sql, new Object[]{id}, new RowMapper<Museu>() {
            @Override
            public Museu mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Museu(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("pais") // corrigi a coluna para "pais" em vez de "cidade"
                );
            }
        }).stream().findFirst().orElse(null);
    }


    @Override
    public Long save(Museu museu) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO museu_dbtemplate.MUSEUS_JDBC_TEMPLATE (NOME, PAIS) VALUES (?, ?)";

        jdbcTemplate.update(connection -> {
            PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, museu.getNome());
            pst.setString(2, museu.getPais());
            return pst;
        }, keyHolder);
        museu.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        return museu.getId();
    }

    @Override
    public void update(Museu museu) {
        String sql = "UPDATE museu_dbtemplate.MUSEUS_JDBC_TEMPLATE SET NOME = ?, PAIS = ? WHERE ID = ?";
        jdbcTemplate.update(sql, museu.getNome(), museu.getPais(), museu.getId());
    }

    @Override
    public void deleteById(Museu museu) {
        String sql = "DELETE FROM museu_dbtemplate.MUSEUS_JDBC_TEMPLATE WHERE ID = ?";
        jdbcTemplate.update(sql, museu.getId());
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
        String sql ="SELECT ID FROM museu_dbtemplate.MUSEUS_JDBC_TEMPLATE";
        return jdbcTemplate.query(sql, (rs, rowNum) -> rs.getLong("id"));
    }


}
