package Classes;

public class ControleUsuario {

    private InteractDAO interact  = new InteractDAO();

    //Metodos de controle da classe usuario
    public boolean cadastrarUsuario(Usuario novo){
        Usuario alvo = null;
        alvo = interact.buscarUsuario(novo.getCpf(), novo.getEmail());
        if( alvo == null)
            return interact.createUsuario(novo);
        return false;
    }

    public boolean editarUsuario(Usuario edit, String cpf, String email){
       Usuario alvo = null;
       alvo = interact.buscarUsuario(cpf, email);

       if(alvo == edit)
           return false;
       if(alvo.getCpf() == cpf && alvo.getEmail() == email)
           return interact.updateUsuario(edit);

       return false;
    }

    public boolean removerUsuario(String cpf, String email){
        Usuario alvo = null;
        alvo = interact.buscarUsuario(cpf, email);

        if (alvo != null)
            interact.deleteUsuario(alvo);

        return false;
    }

}