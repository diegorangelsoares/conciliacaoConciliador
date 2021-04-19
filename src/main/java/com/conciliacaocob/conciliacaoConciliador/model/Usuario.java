package com.conciliacaocob.conciliacaoConciliador.model;

import javax.persistence.*;

/**
 * Classe do objeto Usuario
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
@Entity
@Table(name="T_USUARIO")
public class Usuario {

    private static final long serialVersionUID = 1L;

    public static final String USUARIO_SENHA_PERSONALIZADA = "senhaUsuarioSistema";
    public static final String LOGIN_SISTEMA = "sistema";
    public static final String USUARIO_ESPECIAL_LOGIN = "usuarioEspecial.login";
    public static final String USUARIO_ESPECIAL_SENHA = "usuarioEspecial.senha";

    public static final String TIPO_USUARIO_RETAGUARDA = "R";
    public static final String TIPO_USUARIO_CONVENIO = "C";
    public static final String TIPO_USUARIO_CONTABIL = "T";
    public static final String TIPO_USUARIO_ADMINISTRADORA = "A";
    public static final String TIPO_USUARIO_ATENDIMENTO = "E";
    public static final String TIPO_USUARIO_SAC = "S";
    public static final String TIPO_USUARIO_NEUS = "N";

    //Constantes para usuario Administradora, esse usuario não possui grupo
    //apenas o tipo e suas permissoes são dadas pelo tipo
    public static final String TIPO_USUARIO_ADMINISTRADORA_PADRAO = "P";
    public static final String TIPO_USUARIO_ADMINISTRADORA_CAIXA = "C";
    private static final String PERMISSAOADMINISTRADOR = "permissaoAdministrador";
    private static final String PERMISSAOCAIXA = "permissaoCaixa";

    /**
     * Código identificador do usuário do sistema. Este usuário é usado para
     * realizar operações que somente ele tem permissão de executar.
     */
    public static final int USUARIO_SISTEMA = 1;
    public static final int USUARIO_SUPERVISOR = -1;
    public static final int USUARIO_LOJA_CONVENIO = -2;
    public static final int USUARIO_LOJA_ADMINISTRADORA = -3;
    public static final int USUARIO_MEGASTORE = -4;
    public static final int USUARIO_CLIENTE = -5;
    public static final int USUARIO_ESCRITORIO_COBRANCA_EXTERNO = -6;
    public static final int USUARIO_SEMPREODONTO = -7;

    public static final int PADRAO_0 = 0;
    public static final int PADRAO_1 = 1;
    public static final int PADRAO_2 = 2;

    public static final String MONITORIA = "u";

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    /** Nome do usuário */
    private String nome;

    /** Login do usuário */
    private String login;

    /** Senha do usuário */
    private String senha;

    /** CPF do usuário */
    private String cpf;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
