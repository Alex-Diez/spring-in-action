package org.tacos.constructor.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import org.tacos.constructor.model.Taco;
import org.tacos.constructor.ports.TacoRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class JdbcTacoRepository implements TacoRepository {
  private final JdbcOperations jdbc;

  @Autowired
  public JdbcTacoRepository(JdbcOperations jdbc) {
    this.jdbc = jdbc;
  }

  @Override
  public Optional<Taco> find(String id) {
    final List<Taco> query = jdbc.query(
        "select ID, NAME, CREATED_AT from TACO where ID = ?",
        this::rowMapper,
        id
    );
    if (query.isEmpty()) return Optional.empty();
    else return Optional.of(query.get(0));
  }

  private Taco rowMapper(ResultSet rs, int rowNum) throws SQLException {
    return new Taco(
        rs.getString("id"),
        rs.getString("name"),
        Set.of(),
        rs.getTimestamp("created_at").toLocalDateTime()
    );
  }

  @Override
  public void save(Taco taco) {
    jdbc.update(
        "insert into TACO (ID, NAME, CREATED_AT) values (?, ?, ?)",
        taco.id(),
        taco.name(),
        Timestamp.valueOf(taco.createdAt())
    );
  }
}
