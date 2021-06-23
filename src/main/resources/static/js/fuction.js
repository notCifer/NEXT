const S1 = document.querySelector("#SENHA1");
const S2 = document.querySelector("#SENHA2");
const error = document.querySelector(".erro");
const btn = document.querySelector(".btn-cadastro")
const showBtn = document.querySelector(".mostrar")
var delay = 1000;

function active() {
    if (S1.value.length >= 1) {
        S2.removeAttribute("disabled", "");
        btn.classList.add("active");
    } else {
        S2.setAttribute("disabled", "");
        btn.classList.remove("active");
    }
}

function botao() {
    if (S1.value != S2.value) {
        error.style.display = "block";
        error.classList.remove("matched");
        error.textContent = "Confirme a senha";
        return false;
    } else {
        error.style.display = "block";
        error.classList.add("matched");
        error.textContent = "Senha confirmada";
        return true;
    }
}

function active_2() {
    if (S2.value != "") {
        showBtn.style.display = "block";
        showBtn.onclick = function() {
            if ((S1.type == "password") && (S2.type == "password")) {
                S1.type = "text";
                S2.type = "text";
                this.textContent = "Esconder";
                this.classList.add("active");
            } else {
                S1.type = "password";
                S2.type = "password";
                this.textContent = "Mostrar";
                this.classList.remove("active");
            }
        }
    } else {
        showBtn.style.display = "none";
    }
}

const rmCheck = document.getElementById("rememberMe"),
    emailInput = document.getElementById("username"),
    passwordInput = document.getElementById("password");

if (localStorage.checkbox && localStorage.checkbox !== "") {
    rmCheck.setAttribute("checked", "checked");
    emailInput.value = localStorage.username;
    passwordInput.value = localStorage.password;
} else {
    rmCheck.removeAttribute("checked");
    emailInput.value = "";
}


function lsRememberMe() {
    if (rmCheck.checked && emailInput.value !== "") {
        localStorage.username = emailInput.value;
        localStorage.password = passwordInput.value
        localStorage.checkbox = rmCheck.value;
    } else {
        localStorage.username = "";
        localStorage.checkbox = "";
    }
}

function isEmpty() {
    var x = document.forms["formsaldo"]["valor"].value;
    if (x == "") {
        swal({
            text: "Campo não pode estar vazio!",
            icon: "error",
            buttons: false,
            timer: 2000,
        }).then((will) => {
            if (will) {
                $(".onoffswitch-checkbox").prop('checked', false);
            } else {
                $("#all_petugas").click();
            }
        });
        return false;
    } else {
        swal({
            text: "Saldo atualizado!",
            icon: "success",
            button: false
        });
    }
}

function logout() {
    swal({
            title: "Tem certeza?",
            icon: "warning",
            buttons: ["Voltar", "Sair"],
            dangerMode: true,
        })
        .then((willDelete) => {
            if (willDelete) {
                swal("Usuario deslogado!", {
                    icon: "success",
                    button: false
                });
                var delayInMilliseconds = 1000;
                setTimeout(function() { location.href = "/logout" }, delayInMilliseconds);
            }
            return false;
        });
}