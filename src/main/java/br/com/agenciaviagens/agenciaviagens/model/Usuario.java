package br.com.agenciaviagens.agenciaviagens.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="tb_usuario")
public class Usuario extends AbstractEntity{

    @Column(unique = true)
    @NotEmpty(message = "O login não pode ser vazio")
    private String login;
    @Column
    @NotEmpty(message = "A senha não pode ser vazia")
    private String senha;
    @Column
    private boolean admin;

    public Usuario() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }


    public static final class UsuarioBuilder {
        private Long id;
        private @NotEmpty(message = "O login não pode ser vazio") String login;
        private @NotEmpty(message = "A senha não pode ser vazia") String senha;
        private boolean admin;

        private UsuarioBuilder() {
        }

        public static UsuarioBuilder newBuilder() {
            return new UsuarioBuilder();
        }

        public UsuarioBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UsuarioBuilder login(String login) {
            this.login = login;
            return this;
        }

        public UsuarioBuilder senha(String senha) {
            this.senha = senha;
            return this;
        }

        public UsuarioBuilder admin(boolean admin) {
            this.admin = admin;
            return this;
        }

        public Usuario build() {
            Usuario usuario = new Usuario();
            usuario.setId(id);
            usuario.setLogin(login);
            usuario.setSenha(senha);
            usuario.setAdmin(admin);
            return usuario;
        }
    }
}
