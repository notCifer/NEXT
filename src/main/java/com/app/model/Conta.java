package com.app.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity
@Table(name = "conta")
public class Conta {
    
    public Conta() {
    }
   

    public Conta(String uSUARIO, @NotEmpty String sENHA, @NotEmpty String eMAIL, boolean eNABLED) {
        USUARIO = uSUARIO;
        SENHA = sENHA;
        EMAIL = eMAIL;
        ENABLED = eNABLED;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @Column(name = "user" ,unique = true, nullable = false)
    private String USUARIO;

    @NotEmpty
    @Column(name = "senha" ,nullable = false)
    private String SENHA;

    @NotEmpty
    @Column(name = "email" ,unique = true, nullable = false)
    private String EMAIL;

    @Column(name = "enable")
    private boolean ENABLED;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "regra_id"))
    private Collection<Regras> REGRAS;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "Conta_Pessoa",joinColumns = @JoinColumn(name = "conta_id", referencedColumnName = "ID"),
                inverseJoinColumns = @JoinColumn(name = "pessoa_id", referencedColumnName = "ID", unique = true))
    private Pessoa PESSOA;

    public Long getID() {
        return ID;
    }

    public void setID(Long Id) {
        this.ID = Id;
    }

    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String usuario) {
        this.USUARIO = usuario;
    }

    public String getSENHA() {
        return SENHA;
    }

    public void setSENHA(String Senha) {
        BCryptPasswordEncoder PE = new BCryptPasswordEncoder();
        this.SENHA = PE.encode(Senha);
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String Email) {
        this.EMAIL = Email;
    }

    public Collection<Regras> getREGRAS() {
        return REGRAS;
    }

    public void setREGRAS(Collection<Regras> REGRAS) {
        this.REGRAS = REGRAS;
    }


    public boolean isENABLED() {
        return ENABLED;
    }

    public void setENABLED(boolean ENABLED) {
        this.ENABLED = ENABLED;
    }


    public Pessoa getPESSOA() {
        return PESSOA;
    }

    public void setPESSOA(Pessoa PESSOA) {
        this.PESSOA = PESSOA;
    }

}