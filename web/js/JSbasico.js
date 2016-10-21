function AccessGranted(){
    var valorMail = document.getElementById("labelMail").value;
    var valorPass = document.getElementById("labelPass").value;
    var retorno = true;
    
    if(valorMail === null || valorMail.length === 0 || /^\s+$/.test(valorMail)){
        retorno = false;
        alert("[ERROR] El mail no puede estar vacio");
	
    }
    else if(valorPass === null || valorPass.length === 0 || /^\s+$/.test(valorPass)){
        retorno = false;
        alert("[ERROR] La contraseña no puede estar vacia");
    }
    return retorno;
}
