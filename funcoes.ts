var campo_id = document.querySelector("input[name='id']");
var campo_nome = document.querySelector("input[name='nome']");
var campo_safra = document.querySelector("input[name='safra']");
var campo_preco = document.querySelector("input[name='preco']");
var corpo_tabela = document.querySelector('tbody');


async function pesquisar() {


    const nome = this.campo_nome.value;

    if (nome != '') {

        try {

            const response = await fetch(`http://localhost:8080/AdegaResWeb/vinho/nome/${nome}`);

            const data = await response.json();



            carregavinho(data);



        } catch (error) {

            console.error(error)
            // alert(`Vinho ${nome} não existe`)

        }


    } else {
        alert('Digite um nome ')
    }




}

async function getAllVinhos() {

    try {

        const response = await fetch('http://localhost:8080/AdegaResWeb/vinhos');

        const data = await response.json();

        this.carregaTabela(data);

    } catch (error) {

        console.error(error);

    }
}

function carregavinho(vinho) {


    const saida = `id: ${vinho.id} nome: ${vinho.nome} safra: ${vinho.safra} preço: ${vinho.preco}`

    alert(saida)

}

function carregaTabela(vinhos) {

    for (const vinho of vinhos) {


        var linha = document.createElement("tr");
        var id = document.createElement("td");
        var nome = document.createElement("td");
        var safra = document.createElement("td");
        var preco = document.createElement("td");

        id.className = "borda"
        nome.className = "borda"
        safra.className = "borda"
        preco.className = "borda"


        var txt_id = document.createTextNode(vinho.id);
        var txt_nome = document.createTextNode(vinho.nome);
        var txt_safra = document.createTextNode(vinho.safra);
        var txt_preco = document.createTextNode(vinho.preco);


        id.appendChild(txt_id);
        nome.appendChild(txt_nome);
        safra.appendChild(txt_safra);
        preco.appendChild(txt_preco);




        linha.appendChild(id);
        linha.appendChild(nome);
        linha.appendChild(safra);
        linha.appendChild(preco);

        corpo_tabela.appendChild(linha);

    }

}

async function addVinho() {

    const nome = this.campo_nome.value;
    const safra = this.campo_safra.value;
    const preco = this.campo_preco.value;

    if (nome != '' && safra != '' && preco != '') {



        let xhr = new XMLHttpRequest();
        let url = "http://localhost:8080/AdegaResWeb/vinho/";


        xhr.open("POST", url, true);


        xhr.setRequestHeader("Content-Type", "application/json");



        var data = JSON.stringify({ "nome": nome, "safra": safra, "preco": preco });


        xhr.send(data);

        getAllVinhos();
        
    } else {
        alert("Digite todos os campos")
    }

}

getAllVinhos();
