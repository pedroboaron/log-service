package com.pedro.logservice.model;

import javax.persistence.*;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Usuario user;

    @ManyToOne
    @JoinColumn(name = "id_cartao_usuario")
    private CartaoUsuario cartaoUsuario;

    @ManyToOne
    @JoinColumn(name = "id_requisicao")
    private Pagamento pagamento;

    @Column(name = "acao", nullable = false)
     private String acao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public CartaoUsuario getCartaoUsuario() {
        return cartaoUsuario;
    }

    public void setCartaoUsuario(CartaoUsuario cartaoUsuario) {
        this.cartaoUsuario = cartaoUsuario;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }


}
