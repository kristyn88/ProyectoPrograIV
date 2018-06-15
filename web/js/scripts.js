
var nCategoria = 1;
var nSubcategoria = 1;
var nivel = 1;

function init() {
    cargarCategorias();
    cargarSubCategorias(nCategoria);
    console.log("Inicializando....");
}

function cargarCategorias() {
    loadJSON(actualizarCategorias, "ServicioCategorias");
}

function cargarSubCategorias(categoria) {
loadJSON(actualizarSubCategorias, "ServicioSubCategorias?categoria="+String(categoria));
}

function actualizarCategorias(textJSON) {
    var datos = JSON.parse(textJSON);
    var refMenu = document.getElementById("categoria");
    if (refMenu) {
        refMenu.options.length = 0;
        for (var i = 0; i < datos.caracteristicas.length; i++) {
            var opt = document.createElement("OPTION");
            opt.setAttribute("value", datos.caracteristicas[i].valor);
            if (i === 0) {
                opt.setAttribute("selected", "selected");
            }
            opt.appendChild(document.createTextNode(datos.caracteristicas[i].texto));
            refMenu.appendChild(opt);
        }
    }
}

function actualizarSubCategorias(textJSON) {
    var datos = JSON.parse(textJSON);
    var refMenu = document.getElementById("subcategoria");
    if (refMenu) {
        refMenu.options.length = 0;
        for (var i = 0; i < datos.subcategoria.length; i++) {
            var opt = document.createElement("OPTION");
            opt.setAttribute("value", datos.subcategoria[i].valor);
            if (i === 0) {
                opt.setAttribute("selected", "selected");
            }
            opt.appendChild(document.createTextNode(datos.subcategoria[i].texto));
            refMenu.add(opt);
        }
    }
}

function cargarOpciones(textoJSON) {
    datos = JSON.parse(textoJSON);//Datos no es un array, es un objeto con un array

    var refMenu = document.getElementById("categorias");
    var refMenu2 = document.getElementById("subCategorias");


    while (refMenu.length > 0) {
        refMenu.remove(refMenu.length - 1);
    }
    if (refMenu) {
        for (var i = 0; i < datos.opciones.length; i++) {
            var nuevaOpcion = document.createElement("OPTION");
            nuevaOpcion.setAttribute("value", datos.opciones[i].valor);
            nuevaOpcion.appendChild(document.createTextNode(datos.opciones[i].texto));
            refMenu.appendChild(nuevaOpcion);
        }
    }

    while (refMenu2.length > 0) {
        refMenu2.remove(refMenu2.length - 1);
    }
    if (refMenu2) {
        for (var i = 0; i < datos.opciones2.length; i++) {
            var nuevaOpcion = document.createElement("OPTION");
            nuevaOpcion.setAttribute("value", datos.opciones2[i].valor);
            nuevaOpcion.appendChild(document.createTextNode(datos.opciones2[i].texto));
            refMenu.appendChild(nuevaOpcion);
        }
    }

    var nombre = document.getElementById("error");
    if (nombre) {
        nombre.innerHTML = datos.nombre.texto;
    }

}