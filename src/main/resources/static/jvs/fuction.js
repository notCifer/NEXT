const S1 = document.querySelector("#SENHA1");
const S2 = document.querySelector("#SENHA2");
const error = document.querySelector(".erro");
const btn = document.querySelector(".btn-cadastro")
const showBtn = document.querySelector(".mostrar")
var delay = 1000;

function active() {
    if (S1.value.length >= 6) {
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
        error.textContent = "Boa! Senha confirmada";
        return true;
    }
}
function active_2() {
    if (S2.value != "") {
        showBtn.style.display = "block";
        showBtn.onclick = function () {
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