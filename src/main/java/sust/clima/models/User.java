package sust.clima.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  Long id;

  @Column(nullable = false, unique = true)
  String username;

  @Column(nullable = false)
  String name;

  @Column(nullable = false)
  String password;

  @Column(updatable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  Date created;

  @Column()
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  Date updated;

  // vamos a configurar para que al crear un usuario, se guarde la marca temporal
  // de forma automática
  @PrePersist
  protected void onCreate() {
    this.created = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updated = new Date();
  }

}
