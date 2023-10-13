package com.generation.blogpessoal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Table(name = "tb_usuarios")
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O atríbuto nome é obrigatório")
    private String nome;

    @NotNull(message = "O atributo usuario é obrigatório")
    @Email(message = "O atributo usuario deve ser uma email valido")
    private String usuario;

    @NotBlank(message = "O atributo senha é obrigatório")
    @Size(min = 8, message = "O atributo senha deve ter no minimo 8 caracteres")
    private String senha;

    @Size(max = 5000, message = "O atributo foto não pode ser maior que 5000 caracteres")
    private String foto;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("usuario")
    private List<Postagens> postagens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Postagens> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<Postagens> postagens) {
        this.postagens = postagens;
    }
}

