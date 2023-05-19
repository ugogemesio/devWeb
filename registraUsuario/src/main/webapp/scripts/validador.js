/* global frmContato */

function validar() {
    let nome = frmContato.nome.value;
    let endereco = frmContato.endereco.value;
    let cpf = frmContato.cpf.value;
    let senha = frmContato.senha.value;

    if (nome === "") {
        alert("Preencha o campo nome")
        frmContato.nome.focus()

    }
    if (endereco === "") {
        alert("Preencha o campo endereco")
        frmContato.endereco.focus()

    }
    if (cpf === "") {
        alert("Preencha o campo cpf")
        frmContato.cpf.focus()

    }
document.forms["frmContato"].submit();
}





