import java.sql.Date;

public class Pessoa {

    private static int count = 1;
    private int numeroPessoa;
    private String nome;
    private String cpf;
    private String email;
    private Date accountCreationDate;

    

    public Pessoa() {
        
    }



    public Pessoa(String nome, String cpf, String email) {
        this.numeroPessoa = Pessoa.count;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.accountCreationDate = new Date(System.currentTimeMillis());
        count += 1;
    }




    public static int getCount() {
        return count;
    }




    public static void setCount(int count) {
        Pessoa.count = count;
    }




    public String getNome() {
        return nome;
    }




    public void setNome(String nome) {
        this.nome = nome;
    }




    public String getCpf() {
        return cpf;
    }




    public void setCpf(String cpf) {
        this.cpf = cpf;
    }




    public String getEmail() {
        return email;
    }




    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", email=" + email + "]";
    }
    

    
}
