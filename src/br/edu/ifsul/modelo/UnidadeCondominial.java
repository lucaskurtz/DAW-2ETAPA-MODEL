
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "unidade_condominial")
public class UnidadeCondominial implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_u_condominial", sequenceName = "seq_u_condominial_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_u_condominial", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O número não pode ser nulo")
    @NotBlank(message = "O número não pode ser em branco")
    @Length(max = 10, message = "O número não pode ter mais de {max} caracteres")
    @Column(name = "numero", length = 10, nullable = false) 
    private String numero;
    @NotNull(message = "A descrição não pode ser nula")
    @NotBlank(message = "A descrição não pode ser em branco")
    @Column(name = "descricao", columnDefinition = "text") 
    private String descricao;
    @NotNull(message = "A area deve ser informada")
    @Column(name = "area", nullable = false, columnDefinition = ("decimal(10,2)"))
    private Double area;
    @NotNull(message = "O numero do quarto deve ser informado")
    @Column(name = "numeroQuarto", nullable = false, columnDefinition = ("integer"))
    private Integer numeroQuarto;
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_unidade_pessoa")
    private Pessoa pessoa;
    @NotNull(message = "O condominio deve ser informado")
    @ManyToOne
    @JoinColumn(name = "condominio", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_unidadeCondominial_condominio")
    private Condominio condominio;
    
    public UnidadeCondominial() {
    }

    

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

  
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getArea() {
        return area;
    }


    public void setArea(Double area) {
        this.area = area;
    }

 

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

  
    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UnidadeCondominial other = (UnidadeCondominial) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

 
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

   
    public Condominio getCondominio() {
        return condominio;
    }

 
    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }
    
}
