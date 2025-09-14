package br.cogna.SpringBootHibernate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cor;

    @JsonIgnoreProperties("carros")
    @ManyToOne
    @JoinColumn(name = "dono_id")
    private Dono dono;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }
    public Dono getDono() { return dono; }
    public void setDono(Dono dono) { this.dono = dono; }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cor='" + cor + '\'' +
                ", dono=" + (dono != null ? dono.getNome() : "null") +
                '}';
    }
}
